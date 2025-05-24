package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Model.SolicitudPrestamo;

public class ApacheProyect {
	public static final String RUTA_DESCARGAS = System.getProperty("user.home") + File.separator + "Downloads";
	public static void createExcelFormat(String filename) {
		File archivoDestino = new File(RUTA_DESCARGAS + File.separator + filename);
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet hoja = workbook.createSheet("Solicitudes");
			Row encabezado = hoja.createRow(0);
			encabezado.createCell(0).setCellValue("FechaSolicitud");
			encabezado.createCell(1).setCellValue("FechaInicio");
			encabezado.createCell(2).setCellValue("FechaFinPrevista");
			encabezado.createCell(3).setCellValue("FechaDevolucion");
			encabezado.createCell(4).setCellValue("Estado");
			//Autofit column widths
			hoja.autoSizeColumn(0);
			hoja.autoSizeColumn(1);
			hoja.autoSizeColumn(2);
			hoja.autoSizeColumn(3);
			hoja.autoSizeColumn(4);
			try (FileOutputStream fos = new FileOutputStream(archivoDestino)) {
				workbook.write(fos);
				System.out.println("✅ Plantilla creada correctamente en: " + archivoDestino.getAbsolutePath());
			}
		} catch (IOException e) {
			System.err.println("❌ Error al crear plantilla: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static ArrayList<SolicitudPrestamo> fetchExcel(File archivoOrigen) {
		ArrayList<SolicitudPrestamo> solicitudes = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(archivoOrigen); Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet hoja = workbook.getSheetAt(0);
			for (Row fila : hoja) {
				if (fila.getRowNum() == 0) continue; //Skip header
				Cell cellFechaSolicitud = fila.getCell(0);
				Cell cellFechaInicio = fila.getCell(1);
				Cell cellFechaFinPrevista = fila.getCell(2);
				Cell cellFechaDevolucion = fila.getCell(3);
				Cell cellEstado = fila.getCell(4);
				if (cellFechaSolicitud == null || cellFechaInicio == null || cellFechaFinPrevista == null || cellFechaDevolucion == null || cellEstado == null) continue;
				String FechaSolicitud = cellFechaSolicitud.getStringCellValue();
				String FechaInicio = cellFechaInicio.getStringCellValue();
				String FechaFinPrevista = cellFechaFinPrevista.getStringCellValue();
				String FechaDevolucion = cellFechaDevolucion.getStringCellValue();
				boolean Estado = (boolean) cellEstado.getBooleanCellValue();
				solicitudes.add(new SolicitudPrestamo( FechaSolicitud, FechaInicio, FechaFinPrevista, FechaDevolucion, Estado));
			}
		} catch (IOException e) {
			System.err.println("Error al leer archivo Excel: " + e.getMessage());e.printStackTrace();
		}
		return solicitudes;
	}
}
