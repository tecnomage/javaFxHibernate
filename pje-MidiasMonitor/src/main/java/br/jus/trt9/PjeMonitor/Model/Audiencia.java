package br.jus.trt9.PjeMonitor.Model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Audiencia {

	private final StringProperty processo;
	private final ObjectProperty<LocalDate> data;
	private final StringProperty assinado;

	public Audiencia(String processo, LocalDate date, String assinado) {

		this.processo = new SimpleStringProperty(processo);
		this.data = new SimpleObjectProperty<LocalDate>(date);
		this.assinado = new SimpleStringProperty(assinado);

	}

	public String getProcesso() {
		return processo.get();
	}

	public void setProcesso(String processo) {
		this.processo.set(processo);
	}

	public StringProperty processoProperty() {
		return processo;
	}

	public LocalDate getData() {
		return data.get();
	}

	public void setData(LocalDate data) {
		this.data.set(data);
	}

	public ObjectProperty<LocalDate> dataProperty() {
		return data;
	}

	public String getAssinado() {
		return assinado.get();
	}

	public void setAssinado(String assinado) {
		this.assinado.set(assinado);
	}

	public StringProperty assinadoProperty() {
		return assinado;
	}

}
