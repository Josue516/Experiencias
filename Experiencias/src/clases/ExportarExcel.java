package clases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExportarExcel {
    
    private Workbook workbook;
    private Sheet sheet;
    private List<OperacionData> operaciones;
    
    // Clase interna para almacenar datos de operación
    private static class OperacionData {
        String operacion;
        String ruta;
        int unidades;
        double gasolinaPorUnidad;
        double gasolinaTotal;
        
        public OperacionData(String operacion, String ruta, int unidades, 
                           double gasolinaPorUnidad, double gasolinaTotal) {
            this.operacion = operacion;
            this.ruta = ruta;
            this.unidades = unidades;
            this.gasolinaPorUnidad = gasolinaPorUnidad;
            this.gasolinaTotal = gasolinaTotal;
        }
    }
    
    public ExportarExcel() {
        this.operaciones = new ArrayList<>();
    }
    
    // Método principal para exportar
    public void exportarDatos() {
        try {
            // Leer datos del archivo
            leerDatosDelArchivo();
            
            // Crear el workbook y sheet
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Reporte de Operaciones");
            
            // Crear estilos
            Map<String, CellStyle> estilos = crearEstilos();
            
            // Generar el reporte
            generarReporte(estilos);
            
            // Guardar archivo
            guardarArchivo();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al exportar: " + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Leer datos del archivo txt
    private void leerDatosDelArchivo() throws IOException {
        String rutaArchivo = "datos/OperacionesProgramadas.txt";
        File archivo = new File(rutaArchivo);
        
        if (!archivo.exists()) {
            throw new FileNotFoundException("No se encontró el archivo: " + rutaArchivo);
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                
                // Dividir la línea por comas o el separador que uses
                String[] datos = linea.split(",");
                
                if (datos.length >= 5) {
                    String operacion = datos[0].trim();
                    String ruta = datos[1].trim();
                    int unidades = Integer.parseInt(datos[2].trim());
                    double gasolinaPorUnidad = Double.parseDouble(datos[3].trim());
                    double gasolinaTotal = Double.parseDouble(datos[4].trim());
                    
                    operaciones.add(new OperacionData(operacion, ruta, unidades, 
                                                    gasolinaPorUnidad, gasolinaTotal));
                }
            }
        }
    }
    
    // Crear estilos para el Excel
    private Map<String, CellStyle> crearEstilos() {
        Map<String, CellStyle> estilos = new HashMap<>();
        
        // Estilo para encabezados
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setBorderTop(BorderStyle.THICK);
        headerStyle.setBorderBottom(BorderStyle.THICK);
        headerStyle.setBorderLeft(BorderStyle.THICK);
        headerStyle.setBorderRight(BorderStyle.THICK);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estilos.put("header", headerStyle);
        
        // Estilo para operaciones (fondo amarillo)
        CellStyle operacionStyle = workbook.createCellStyle();
        Font operacionFont = workbook.createFont();
        operacionFont.setBold(true);
        operacionStyle.setFont(operacionFont);
        operacionStyle.setAlignment(HorizontalAlignment.CENTER);
        operacionStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        operacionStyle.setBorderTop(BorderStyle.THIN);
        operacionStyle.setBorderBottom(BorderStyle.THIN);
        operacionStyle.setBorderLeft(BorderStyle.THICK);
        operacionStyle.setBorderRight(BorderStyle.THICK);
        operacionStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        operacionStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estilos.put("operacion", operacionStyle);
        
        // Estilo para datos normales
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);
        estilos.put("data", dataStyle);
        
        // Estilo para totales
        CellStyle totalStyle = workbook.createCellStyle();
        Font totalFont = workbook.createFont();
        totalFont.setBold(true);
        totalStyle.setFont(totalFont);
        totalStyle.setAlignment(HorizontalAlignment.CENTER);
        totalStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        totalStyle.setBorderTop(BorderStyle.THICK);
        totalStyle.setBorderBottom(BorderStyle.THICK);
        totalStyle.setBorderLeft(BorderStyle.THICK);
        totalStyle.setBorderRight(BorderStyle.THICK);
        totalStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        totalStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estilos.put("total", totalStyle);
        
        return estilos;
    }
    
    // Generar el reporte completo
    private void generarReporte(Map<String, CellStyle> estilos) {
        int filaActual = 0;
        
        // Crear encabezados
        filaActual = crearEncabezados(estilos, filaActual);
        
        // Agrupar operaciones
        Map<String, List<OperacionData>> operacionesAgrupadas = agruparOperaciones();
        
        // Crear filas de datos
        filaActual = crearFilasDatos(estilos, filaActual, operacionesAgrupadas);
        
        // Crear fila de totales
        filaActual = crearFilaTotales(estilos, filaActual);
        
        // Crear fila de fecha
        crearFilaFecha(estilos, filaActual);
        
        // Ajustar ancho de columnas
        ajustarAnchoColumnas();
    }
    
    // Crear encabezados
    private int crearEncabezados(Map<String, CellStyle> estilos, int filaActual) {
        Row headerRow = sheet.createRow(filaActual);
        String[] headers = {"OPERACIÓN", "UNIDADES", "RUTA", "GALONES/UNIDAD", "GALONES", "TOTAL GALONES"};
        
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(estilos.get("header"));
        }
        
        return filaActual + 1;
    }
    
    // Agrupar operaciones por nombre
    private Map<String, List<OperacionData>> agruparOperaciones() {
        Map<String, List<OperacionData>> agrupadas = new LinkedHashMap<>();
        
        for (OperacionData op : operaciones) {
            agrupadas.computeIfAbsent(op.operacion, k -> new ArrayList<>()).add(op);
        }
        
        return agrupadas;
    }
    
    // Crear filas de datos
    private int crearFilasDatos(Map<String, CellStyle> estilos, int filaActual, 
                               Map<String, List<OperacionData>> operacionesAgrupadas) {
        
        for (Map.Entry<String, List<OperacionData>> entry : operacionesAgrupadas.entrySet()) {
            String nombreOperacion = entry.getKey();
            List<OperacionData> datosOperacion = entry.getValue();
            
            // Calcular total de galones para esta operación
            double totalGalonesOperacion = datosOperacion.stream()
                    .mapToDouble(op -> op.gasolinaTotal)
                    .sum();
            
            // Crear fila para el nombre de la operación (primera fila del grupo)
            Row primeraFila = sheet.createRow(filaActual);
            
            // Combinar celdas para el nombre de la operación
            if (datosOperacion.size() > 1) {
                sheet.addMergedRegion(new CellRangeAddress(filaActual, 
                        filaActual + datosOperacion.size() - 1, 0, 0));
                sheet.addMergedRegion(new CellRangeAddress(filaActual, 
                        filaActual + datosOperacion.size() - 1, 5, 5));
            }
            
            // Llenar primera fila
            Cell cellOperacion = primeraFila.createCell(0);
            cellOperacion.setCellValue(nombreOperacion);
            cellOperacion.setCellStyle(estilos.get("operacion"));
            
            OperacionData primerDato = datosOperacion.get(0);
            primeraFila.createCell(1).setCellValue(primerDato.unidades);
            primeraFila.createCell(2).setCellValue(primerDato.ruta);
            primeraFila.createCell(3).setCellValue(primerDato.gasolinaPorUnidad);
            primeraFila.createCell(4).setCellValue(primerDato.gasolinaTotal);
            
            Cell cellTotalGalones = primeraFila.createCell(5);
            cellTotalGalones.setCellValue(String.format("%.0f GL", totalGalonesOperacion));
            cellTotalGalones.setCellStyle(estilos.get("operacion"));
            
            // Aplicar estilos a las celdas de datos
            for (int i = 1; i <= 4; i++) {
                primeraFila.getCell(i).setCellStyle(estilos.get("data"));
            }
            
            filaActual++;
            
            // Crear filas adicionales para esta operación
            for (int i = 1; i < datosOperacion.size(); i++) {
                Row fila = sheet.createRow(filaActual);
                OperacionData dato = datosOperacion.get(i);
                
                // La celda de operación y total galones están combinadas, no se llenan
                fila.createCell(1).setCellValue(dato.unidades);
                fila.createCell(2).setCellValue(dato.ruta);
                fila.createCell(3).setCellValue(dato.gasolinaPorUnidad);
                fila.createCell(4).setCellValue(dato.gasolinaTotal);
                
                // Aplicar estilos
                for (int j = 1; j <= 4; j++) {
                    fila.getCell(j).setCellStyle(estilos.get("data"));
                }
                
                filaActual++;
            }
        }
        
        return filaActual;
    }
    
    // Crear fila de totales
    private int crearFilaTotales(Map<String, CellStyle> estilos, int filaActual) {
        Row totalRow = sheet.createRow(filaActual);
        
        // Calcular totales
        int totalUnidades = operaciones.stream().mapToInt(op -> op.unidades).sum();
        double totalGalones = operaciones.stream().mapToDouble(op -> op.gasolinaTotal).sum();
        
        totalRow.createCell(0).setCellValue("TOTAL UNIDADES");
        totalRow.createCell(1).setCellValue(totalUnidades);
        totalRow.createCell(2).setCellValue("");
        totalRow.createCell(3).setCellValue("");
        totalRow.createCell(4).setCellValue("");
        totalRow.createCell(5).setCellValue(String.format("%.0f GL", totalGalones));
        
        // Aplicar estilos
        for (int i = 0; i <= 5; i++) {
            totalRow.getCell(i).setCellStyle(estilos.get("total"));
        }
        
        return filaActual + 1;
    }
    
    // Crear fila de fecha
    private void crearFilaFecha(Map<String, CellStyle> estilos, int filaActual) {
        Row fechaRow = sheet.createRow(filaActual + 1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdf.format(new Date());
        
        Cell cellFecha = fechaRow.createCell(0);
        cellFecha.setCellValue("FECHA DEL REPORTE: " + fechaActual);
        cellFecha.setCellStyle(estilos.get("total"));
        
        // Combinar celdas para la fecha
        sheet.addMergedRegion(new CellRangeAddress(filaActual + 1, filaActual + 1, 0, 5));
    }
    
    // Ajustar ancho de columnas
    private void ajustarAnchoColumnas() {
        for (int i = 0; i <= 5; i++) {
            sheet.autoSizeColumn(i);
            // Ajustar un poco más el ancho
            int width = sheet.getColumnWidth(i);
            sheet.setColumnWidth(i, width + 1000);
        }
    }
    
    // Guardar archivo
    private void guardarArchivo() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte Excel");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos Excel (*.xlsx)", "xlsx"));
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaHoy = sdf.format(new Date());
        fileChooser.setSelectedFile(new File("Reporte_Operaciones_" + fechaHoy + ".xlsx"));
        
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            
            // Asegurar extensión .xlsx
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx";
            }
            
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        }
        
    }
    
    // Método público para usar desde otras clases
    public static void exportar() {
        ExportarExcel exporter = new ExportarExcel();
        exporter.exportarDatos();
        JOptionPane.showMessageDialog(null, "Archivo Excel exportado exitosamente!", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}