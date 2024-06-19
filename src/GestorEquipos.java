import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

public class GestorEquipos {

	private LinkedList<Equipo> equipos = new LinkedList<Equipo>();
	private LinkedList<Partido> partidos = new LinkedList<Partido>();
	private LinkedList<Equipo> ganadores = new LinkedList<Equipo>();
	private LinkedList<Equipo> finalistas = new LinkedList<Equipo>();
	
	public GestorEquipos() {

	}
	
	
	

	public LinkedList<Equipo> getFinalistas() {
		return finalistas;
	}




	public void setFinalistas(LinkedList<Equipo> finalistas) {
		this.finalistas = finalistas;
	}




	public LinkedList<Equipo> getGanadores() {
		return ganadores;
	}




	public void setGanadores(LinkedList<Equipo> ganadores) {
		this.ganadores = ganadores;
	}




	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}
	
	




	public LinkedList<Partido> getPartidos() {
		return partidos;
	}


	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}


	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}
	

	@Override
	public String toString() {
		return "GestorEquipos [equipos=" + equipos + "]";
	}


	public Equipo JugarPartido(Partido partido) {
		if (partido.getEquipo1().getPlantel().size()>= 8 && partido.getEquipo2().getPlantel().size() >= 8) {
			if (partido.getEquipo1().getNombre().equals(partido.getEquipo2().getNombre())) {
				JOptionPane.showMessageDialog(null, "No puede jugar el mismo equipo, elija otro");
			} else {
				JOptionPane.showMessageDialog(null, "El partido comenzara pronto");
				int goles1;
				int goles2;
				int resultado1;
				int resultado2;
		
					goles1 = (int)(Math.random()*5);
					resultado1 = goles1;
					goles2 = (int)(Math.random()*5);
					resultado2 = goles2;
					JOptionPane.showMessageDialog(null, "Se termino el primer tiempo\n Resultado : "+ partido.getEquipo1().getNombre() + " " + goles1 + " : " + goles2 + " " + partido.getEquipo2().getNombre());
					JOptionPane.showMessageDialog(null, "Arranca el segundo tiempo...");
					goles1 = (int)(Math.random()*5);
					resultado1 = resultado1 + goles1;
					goles2 = (int)(Math.random()*5);
					resultado2 = resultado2 + goles2;
					JOptionPane.showMessageDialog(null, "Se termino el segundo tiempo\n Resultado : "+ partido.getEquipo1().getNombre() + " " + resultado1 + " : " + resultado2 + " " + partido.getEquipo2().getNombre());
					//Si empatan van a penales. Gana el primero que llegue a 3 penales.
					if (resultado1==resultado2) {
						JOptionPane.showMessageDialog(null, "Es un empate. Hay penales...");
						int penales1,penales2,tot1,tot2;
						tot1 = 0;
						tot2 = 0;
						do {
							JOptionPane.showMessageDialog(null, partido.getEquipo1().getNombre() + " Patea el penal...");
							penales1=(int)(Math.random()*2);
							if (penales1 == 1) {
								JOptionPane.showMessageDialog(null, "GOOOOOOOOOOOOOOOL!!! de  " +partido.getEquipo1().getNombre());
								tot1=tot1+1;
							} else {
								JOptionPane.showMessageDialog(null, partido.getEquipo1().getNombre() +" Erro el penal :(");
							}
							JOptionPane.showMessageDialog(null, partido.getEquipo2().getNombre() + " Patea el penal...");
							penales2=(int)(Math.random()*2);
							if (penales2 == 1) {
								JOptionPane.showMessageDialog(null, "GOOOOOOOOOOOOOOOL!!! de  " +partido.getEquipo2().getNombre());
								tot2=tot2+1;
							} else {
								JOptionPane.showMessageDialog(null, partido.getEquipo2().getNombre() +" Erro el penal :(");
							}
							JOptionPane.showMessageDialog(null, "Resultado actual: " + partido.getEquipo1().getNombre() + " " + tot1 + " : " + tot2 + " " + partido.getEquipo2().getNombre());
						}while(tot1 < 3 && tot2 < 3);
						//Desempate de penales
						if(tot1==tot2) {
							do {
							JOptionPane.showMessageDialog(null, "Ambos equipos empataron, Vamos a gol gana...");
							penales1=(int)(Math.random()*2);
							if (penales1 == 1) {
								JOptionPane.showMessageDialog(null, "GOOOOOOOOOOOOOOOL!!! de  " +partido.getEquipo1().getNombre());
								tot1=tot1+1;
							} else {
								JOptionPane.showMessageDialog(null, partido.getEquipo1().getNombre() +" Erro el penal :(");
							}
							JOptionPane.showMessageDialog(null, partido.getEquipo2().getNombre() + " Patea el penal...");
							penales2=(int)(Math.random()*2);
							if (penales2 == 1) {
								JOptionPane.showMessageDialog(null, "GOOOOOOOOOOOOOOOL!!! de  " +partido.getEquipo2().getNombre());
								tot2=tot2+1;
							} else {
								JOptionPane.showMessageDialog(null, partido.getEquipo2().getNombre() +" Erro el penal :(");
							}
							JOptionPane.showMessageDialog(null, "Resultado actual: " + partido.getEquipo1().getNombre() + " " + tot1 + " : " + tot2 + " " + partido.getEquipo2().getNombre());
						}while(tot1==tot2);
						}
						resultado1 = resultado1+tot1;
						resultado2 = resultado2+tot2;

					} 
					
					partido.setGoles1(resultado1);
					partido.setGoles2(resultado2);
					partido.setEstado("Terminado");
			}

			
		} else {
			JOptionPane.showMessageDialog(null, "No hay jugadores suficientes");
		}
		JOptionPane.showMessageDialog(null, "El Ganador es: " +partido.DeterminarGanador());
		if (Partido.getCantPartidos()<=4) {
			ganadores.add(partido.DeterminarGanador());
		}
		if (Partido.getCantPartidos()> 4 && Partido.getCantPartidos() <= 6) {
			finalistas.add(partido.DeterminarGanador());
		}
		partido.setCantPartidos(partido.getCantPartidos()+1);
		return null;
	}
	
	public void agregarEquipo() {
		String nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del Equipo");
		String ciudadEquipo = JOptionPane.showInputDialog("Ingrese la ciudad del Equipo"); 
		if(!nombreEquipo.equals("") ) {
			Equipo nuevo = new Equipo(nombreEquipo,ciudadEquipo);
			if (this.getEquipos().isEmpty()) {
				this.getEquipos().add(nuevo);
			} else {
				boolean flag = true;
				for (Equipo equipos : this.getEquipos()) {
					if (equipos.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
						JOptionPane.showMessageDialog(null, "Este nombre ya existe");
						flag = false;
						break;
					}
				}
				if (flag) {
					this.getEquipos().add(nuevo);
				} else {
					JOptionPane.showMessageDialog(null, "No se pudo agregar el equipo, el nombre ya existe");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
		}
		
	}
	
	public void buscarEquipo() {
		if (!this.equipos.isEmpty()) {
			String buscar = JOptionPane.showInputDialog("Ingrese el nombre del Equipo");
			String[] nombreEquipo = new String[this.equipos.size()];
			for (int i = 0; i < this.equipos.size(); i++) {
				nombreEquipo[i] = this.equipos.get(i).getNombre();
			}
			boolean flag = true;
			for (Equipo equipos : this.equipos) {
				if (equipos.getNombre().equalsIgnoreCase(buscar)) {
					JOptionPane.showMessageDialog(null, equipos);
					flag=true;
					break;
				} else {
					flag=false;
				}
			}
			if (!flag) {
				JOptionPane.showMessageDialog(null, "No se encontro ningun Equipo con ese nombre");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "No existe ningun equipo");
		}
	}
	
	public void cantEquipos() {
		if (!this.equipos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "La cantidad de Equipos es: " + this.equipos.size());
		} else {
			JOptionPane.showMessageDialog(null, "No hay ningun Equipo");
		}
	}
	
	public void verEquipos() {
		if (!this.equipos.isEmpty()) {
			JOptionPane.showMessageDialog(null, this.equipos);
		} else {
			JOptionPane.showMessageDialog(null, "No hay equipos para mostrar");
		}
	}
	
	public void eliminarEquipo() {
		while (!this.equipos.isEmpty()) {
			String[] opciones = new String[this.equipos.size()];
	        for (int i = 0; i < this.equipos.size(); i++) {
	            opciones[i] = this.equipos.get(i).getNombre();
	        }
	        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un Equipo para eliminar:",
	                "Eliminar Jugador", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
	        if (seleccion != null) {
	            for (Equipo equipos : this.equipos) {
	                if (equipos.getNombre().equals(seleccion)) {
	                	this.equipos.remove(equipos);
	                    JOptionPane.showMessageDialog(null, "Equipo eliminado: " + equipos.getNombre());
	                    break;
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún Equipo.");
	            break;
	        }
	    }
		if (this.equipos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay Equipos para eliminar");

		}
		
		
    }
	
	public void CrearFixture() {
		LinkedList<Equipo> copiarEquipos = new LinkedList<>(equipos);
		int[] partidos = new int[8];
		Random random = new Random();
		
		for (int i = 0; i < 8; i++) {
			int numero;
			boolean flag;
			do {
				flag = true;
				numero = random.nextInt(8);
				for (int j = 0; j < i; j++) {
					if (numero == partidos[j]) {
						flag = false;
						break;
					}
				}
			} while (!flag);
			
			partidos[i] = numero;
		}
		
		LinkedList<Partido> listaPartidos = new LinkedList<>();
		for (int i = 0; i < partidos.length; i+=2) {
			Partido partido = new Partido(copiarEquipos.get(partidos[i]), copiarEquipos.get(partidos[i+1]));
			listaPartidos.add(partido);
			this.getPartidos().add(partido);
		}
		
		StringBuilder mensaje = new StringBuilder("Partidos generados:\n");
		for (Partido partido : listaPartidos) {
			mensaje.append(partido).append("\n");
		}
		JOptionPane.showMessageDialog(null, mensaje.toString());
	}
}
