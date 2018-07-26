package tds.um.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Cancion")
public class Cancion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "interprete")
	private Interprete interprete;

	@Column(name = "estiloMusical")
	private String estiloMusical;
	
	@Column(name = "rutaFichero")
	private String rutaFichero;
	
	@Column(name = "numeroReproduciones")
	private int numReproduciones;

	public Cancion() {

	}

	public Cancion(String titulo, String rutaFichero, String estiloMusical, Interprete interprete) {
		this.titulo = titulo;
		this.rutaFichero = rutaFichero;
		this.estiloMusical = estiloMusical;
		this.interprete = interprete;
		this.numReproduciones = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int codigo) {
		this.id = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getRutaFichero() {
		return rutaFichero;
	}

	public void setRutaFichero(String rutaFichero) {
		this.rutaFichero = rutaFichero;
	}

	public int getNumReproduciones() {
		return numReproduciones;
	}

	public void addNumReproducciones(int cantidad) {
		this.numReproduciones += cantidad;
	}

	public void addNumReproducciones() {
		this.numReproduciones++;
	}

	public String getEstiloMusical() {
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical) {
		this.estiloMusical = estiloMusical;
	}

	public Interprete getInterprete() {
		return interprete;
	}

	public void setInterprete(Interprete interprete) {
		this.interprete = interprete;
	}

	@Override
	public String toString() {
		return "Cancion [id=" + id + ", titulo=" + titulo + ", interprete=" + interprete + ", estiloMusical="
				+ estiloMusical + ", rutaFichero=" + rutaFichero + ", numReproduciones=" + numReproduciones + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estiloMusical == null) ? 0 : estiloMusical.hashCode());
		result = prime * result + ((interprete == null) ? 0 : interprete.hashCode());
		result = prime * result + ((rutaFichero == null) ? 0 : rutaFichero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (estiloMusical == null) {
			if (other.estiloMusical != null)
				return false;
		} else if (!estiloMusical.equals(other.estiloMusical))
			return false;
		if (interprete == null) {
			if (other.interprete != null)
				return false;
		} else if (!interprete.equals(other.interprete))
			return false;
		if (rutaFichero == null) {
			if (other.rutaFichero != null)
				return false;
		} else if (!rutaFichero.equals(other.rutaFichero))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
}
