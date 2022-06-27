
public class Mensaje {

	private String texto;
	private String emisor;
	private String receptor;
	private String fecha;
	
	public Mensaje(String emisor, String receptor, String texto, String fecha) {

        this.emisor = emisor;
        this.receptor = receptor;
        this.texto = texto;
        this.fecha = fecha;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
