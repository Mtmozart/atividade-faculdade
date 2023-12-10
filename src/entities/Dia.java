package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import entities.staus.StatusLeitura;

public class Dia {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private StatusLeitura status;

	public Dia() {
	}

	public Dia(Date dia, StatusLeitura status) {
		this.moment = dia;
		this.status = status;

	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public StatusLeitura getStatus() {
		return status;
	}

	public void setStatus(StatusLeitura status) {
		this.status = status;
	}

	public static Date adicionarUmDia(Date dia) {
		LocalDate localDate = dia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		// Adicione um dia
		LocalDate dataAmanha = localDate.plusDays(1);

		// Converta de volta para Date
		Date novoDia = Date.from(dataAmanha.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return novoDia;
	}

	@Override
	public String toString() {

		return sdf.format(moment) + " " + getStatus();
	}

}
