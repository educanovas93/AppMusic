package tds.um.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Interprete")
public class Interprete implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nombre")
	private String nombre;

	public Interprete() {

	}

	public Interprete(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public List<String> getSubInterpretes() {
		LinkedList<String> aux = new LinkedList<>();
		for (String sub : this.nombre.split("&")) {
			aux.add(sub);
		}
		return aux;	
	}

	@Override
	public String toString() {
		return "Interprete [nombre=" + nombre + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Interprete other = (Interprete) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
