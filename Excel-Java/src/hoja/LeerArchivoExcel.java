package hoja;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import excelJava.Usuario;

public class LeerArchivoExcel {

	private String nArchivo;
	private FileInputStream file;
	private boolean estado;
	private ArrayList<Usuario> lista;

	public LeerArchivoExcel() {
		
		this("Book1.xlsx");
	}

	public LeerArchivoExcel(String nombre) {

		this.nArchivo = nombre;
		File myfile = new File(this.nArchivo);

		if (myfile.exists()) {
			estado = true;
		lista = new ArrayList<Usuario>();
		
		try {
			file = new FileInputStream(myfile);

		} catch (Exception e) {
			System.out.println("Error al leer el fichero");
			e.getMessage();
			estado = false;
		}
		
	} else
		System.out.println("El fichero no existe");
}
		public ArrayList<Usuario> leerExcel() {
			ArrayList<Usuario> list = new ArrayList<Usuario>();
		try {	
		XSSFWorkbook worbook = new XSSFWorkbook(file);
		XSSFSheet sheet = worbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		Row row;
		
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell;
			String[] datos = new String[4];
			int i = 0;
			
			while (cellIterator.hasNext()) {
				cell = cellIterator.next();
				datos[i++]= "cell.getStringCellValue()" + " | ";
			}
			list.add(new Usuario(datos[0],datos[1],datos[2],datos[3]));
		} return list;
		} catch (Exception e) {
			System.out.println("El archivo no se pudo leer correctamente");
			e.getMessage();
			return null;
		}
	}
		
	public boolean estado() {
			return this.estado;
		}

	public boolean close() {
		try {
			file.close();
			return true;
			
		}catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
}
