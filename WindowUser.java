package ejercicios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.io.*;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowUser {

	private JFrame create;
	private JTextField Fuser;
	private JComboBox<String> Box;
	private JLabel pathA;
	private JLabel pathB;
	private JCheckBox exe;
	private JCheckBox read;
	private JCheckBox write; 

	private JFileChooser choos;
	private String Eco = "/home/Economicos/";
	private String Human = "/home/Humanos/";
	private String Mate = "/home/Materiales/";
	private File arch;
	private File fich;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowUser window = new WindowUser();
					window.create.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public WindowUser() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		create = new JFrame();
		create.setTitle("Crear usuarios");
		create.setBounds(100, 100, 540, 300);
		create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		create.getContentPane().setLayout(null);
		
		JLabel Luser = new JLabel("Usuario:");
		Luser.setBounds(12, 45, 70, 15);
		create.getContentPane().add(Luser);
		
		JLabel Lgroup = new JLabel("Grupo:");
		Lgroup.setBounds(12, 83, 70, 15);
		create.getContentPane().add(Lgroup);
		
		pathA = new JLabel("");
		pathA.setBounds(10, 133, 218, 14);
		create.getContentPane().add(pathA);
		
		pathB = new JLabel("");
		pathB.setBounds(12, 158, 216, 14);
		create.getContentPane().add(pathB);
		
		Box = new JComboBox<String>();
		Box.addItem("");
		Box.addItem("Economicos");
		Box.addItem("Humanos");
		Box.addItem("Materiales");
		Box.setBounds(75, 78, 97, 24);
		create.getContentPane().add(Box);
		
		Fuser = new JTextField();
		Fuser.setBounds(75, 42, 114, 19);
		create.getContentPane().add(Fuser);
		Fuser.setColumns(10);
		
		exe = new JCheckBox("Ejecuci\u00F3n");
		exe.setBounds(240, 83, 97, 23);
		create.getContentPane().add(exe);
		
		read = new JCheckBox("Lectura");
		read.setBounds(240, 120, 97, 23);
		create.getContentPane().add(read);
		
		write = new JCheckBox("Escritura");
		write.setBounds(240, 153, 97, 23);
		create.getContentPane().add(write);
		
		JButton Badd = new JButton("A\u00F1adir");
		Badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		Badd.setBounds(12, 216, 89, 23);
		create.getContentPane().add(Badd);
		
		JButton Bdelete = new JButton("Eliminar");
		Bdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		Bdelete.setBounds(113, 216, 107, 23);
		create.getContentPane().add(Bdelete);
		
		choos = new JFileChooser();
		
		JButton archivo = new JButton("Elegir archivo");
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectFiles();
			}
		});
		archivo.setBounds(201, 41, 162, 23);
		create.getContentPane().add(archivo);
		
		JButton Barchivo = new JButton("Modificar Arch");
		Barchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		Barchivo.setBounds(349, 97, 162, 23);
		create.getContentPane().add(Barchivo);
		
		JButton Directory = new JButton("Elegir directorio");
		Directory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectDirectory();
			}
		});
		Directory.setBounds(366, 41, 162, 23);
		create.getContentPane().add(Directory);
		
		JButton Bdirect = new JButton("Modificar Direct");
		Bdirect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModDir();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		Bdirect.setBounds(343, 133, 172, 23);
		create.getContentPane().add(Bdirect);
		
			}//initialize
		
		public void create(){
			String user = Fuser.getText();
			
			File dir1 = new File(Eco);
			File dir2 = new File(Human);
			File dir3 = new File(Mate);

			String group1 [] = {"groupadd", "Economicos"};
			String group2 [] = {"groupadd","Humanos"};
			String group3 [] = {"groupadd", "Materiales"};
			
			String Cuser1 [] = {"useradd", "-g" ,"Economicos","-s", "/bin/bash/", "-m", "-d", Eco+user, user};
			String Cuser2 [] = {"useradd", "-g" ,"Humanos", "-s", "/bin/bash/" ,"-m", "-d", Human+user, user};
			String Cuser3 [] = {"useradd", "-g" ,"Materiales", "-s", "/bin/bash" ,"-m", "-d",Mate+user,user};
			
			ProcessBuilder Puser = new ProcessBuilder();
			ProcessBuilder Puser2 = new ProcessBuilder();
			ProcessBuilder Puser3 = new ProcessBuilder();

			ProcessBuilder PG = new ProcessBuilder();
			ProcessBuilder PG2 = new ProcessBuilder();
			ProcessBuilder PG3 = new ProcessBuilder();

			PG.command(group1);
			PG2.command(group2);
			PG3.command(group3);

			Puser.command(Cuser1);
			Puser2.command(Cuser2);
			Puser3.command(Cuser3);
			
			PG.directory(new File("/home/"));
			PG2.directory(new File("/home/"));
			PG3.directory(new File("/home/"));

			Puser.directory(dir1);
			Puser2.directory(dir2);
			Puser3.directory(dir3);
	
			String boxselect = (String)Box.getSelectedItem();
			switch (boxselect) {
				case "":
					JOptionPane.showMessageDialog(create, "Tienes que seleccionar una opción");
					break;
				
				case "Economicos":
					if(dir1.exists()==false ) {
						dir1.mkdir();
						try {
							PG.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						try {
							Puser.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						try {
							PG.start();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							Puser.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					break;
				
				case "Humanos":
					if (dir2.exists() == false) {
						dir2.mkdir();
						try {
							PG2.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							Puser2.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						try {
							PG2.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							Puser2.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}//else
					break;
				
				case "Materiales":
					if (dir3.exists() == false) {
						dir3.mkdir();
						try {
							PG3.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							Puser3.start();
						} catch (IOException e) {
							e.printStackTrace();
						}

					} else {
						try {
							PG3.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							Puser3.start();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}// else
					break;
					
				 default:
					 System.out.println("Esta vacio");
					 break;
			}//Switch
			
		}//Create
		
		public void SelectFiles(){
			choos.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int select = choos.showOpenDialog(create);
			if(select == JFileChooser.APPROVE_OPTION) {
				arch = choos.getSelectedFile();
				pathA.setText(arch.getAbsolutePath());
				
				if (arch.canExecute()) {
						exe.setSelected(true);
					} else {
						exe.setSelected(false);
					}//else
				
				if (arch.canRead()) {
						read.setSelected(true);
				} else {
					read.setSelected(false);
				}//else
				
				if (arch.canWrite()) {
					write.setSelected(true);
				} else {
					write.setSelected(false);
				}//else
			}//if
		}

		public void SelectDirectory(){
			choos.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int select = choos.showOpenDialog(create);
			
			if(select == JFileChooser.APPROVE_OPTION) {
				fich = choos.getSelectedFile();
				pathB.setText(fich.getAbsolutePath());
				
				if (fich.canExecute()) {
					exe.setSelected(true);
				} else {
					exe.setSelected(false);
				}//else
			
				if (fich.canRead()) {
					read.setSelected(true);
				} else {
					read.setSelected(false);
				}
			
				if (fich.canWrite()) {
					write.setSelected(true);
				} else {
					write.setSelected(false);
				}//else
				
			}//if
		}//SelectDirectory

		public void ModDir() throws IOException {

			fich = choos.getSelectedFile();
			String fiche = fich.toString();
			int answer = JOptionPane.showConfirmDialog(create, "¿Quieres modificar el propietario?", "Pregunta", JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.OK_OPTION) {
				String user = Fuser.getText();
				String group = (String)Box.getSelectedItem();
				
				String command [] = {"chown", user+":"+group, fiche};
				ProcessBuilder change = new ProcessBuilder();
				change.command(command);
				change.directory(new File ("/home/"));
				
				if (exe.isSelected() == true) {
					String exeplus [] = {"chmod", "+x", fiche};
					ProcessBuilder exeP = new ProcessBuilder();
					exeP.command(exeplus);
					exeP.directory(new File("/home/"));
					
					change.start();
					exeP.start();
				} else {
					String exeminus [] = {"chmod", "-x", fiche};
					ProcessBuilder exeM = new ProcessBuilder();
					exeM.command(exeminus);
					exeM.directory(new File("/home/"));
					
					change.start();
					exeM.start();
				}//else
				
				if (read.isSelected() == true) {
					String readPlus [] = {"chmod", "+r", fiche};
					ProcessBuilder readP = new ProcessBuilder();
					readP.command(readPlus);
					readP.directory(new File("/home/"));
					
					change.start();
					readP.start();
				} else {
					String readMinus [] = {"chmod", "-r", fiche};
					ProcessBuilder readM = new ProcessBuilder();
					readM.command(readMinus);
					readM.directory(new File("/home/"));
					
					change.start();
					readM.start();
				}//else
				
				if (write.isSelected() == true) {
					String writePlus [] = {"chmod", "+w",fiche};
					ProcessBuilder writeP = new ProcessBuilder();
					writeP.command(writePlus);
					writeP.directory(new File("/home/"));
					
					change.start();
					writeP.start();
				} else {
					String writeMinus [] = {"chmod", "-w", fiche};
					ProcessBuilder writeM = new ProcessBuilder();
					writeM.command(writeMinus);
					writeM.directory(new File("/home/"));
					
					change.start();
					writeM.start();
				}//else con usuario
				
			} else {
				if (exe.isSelected() == true) {
					String exeplus [] = {"chmod", "+x", fiche};
					ProcessBuilder exeP = new ProcessBuilder();
					exeP.command(exeplus);
					exeP.directory(new File("/home/"));
					
					exeP.start();
				} else {
					String exeminus [] = {"chmod", "-x", fiche};
					ProcessBuilder exeM = new ProcessBuilder();
					exeM.command(exeminus);
					exeM.directory(new File("/home/"));
					
					exeM.start();
				}//else
				
				if (read.isSelected() == true) {
					String readPlus [] = {"chmod", "+r", fiche};
					ProcessBuilder readP = new ProcessBuilder();
					readP.command(readPlus);
					readP.directory(new File("/home/"));
					
					readP.start();
				} else {
					String readMinus [] = {"chmod", "-r", fiche};
					ProcessBuilder readM = new ProcessBuilder();
					readM.command(readMinus);
					readM.directory(new File("/home/"));
					
					readM.start();
				}//else
				
				if (write.isSelected() == true) {
					String writePlus [] = {"chmod", "+w",fiche};
					ProcessBuilder writeP = new ProcessBuilder();
					writeP.command(writePlus);
					writeP.directory(new File("/home/"));
					
					writeP.start();
				} else {
					String writeMinus [] = {"chmod", "-w", fiche};
					ProcessBuilder writeM = new ProcessBuilder();
					writeM.command(writeMinus);
					writeM.directory(new File("/home/"));
					
					writeM.start();
				}//else sin usuario
			}//else final
		
		}//ModDir
		
		public void ModFile() throws IOException{
			arch = choos.getSelectedFile();
			String archi = arch.toString();
			int answer = JOptionPane.showConfirmDialog(create, "¿Quieres modificar el propietario?", "Pregunta", JOptionPane.YES_NO_OPTION);
			
			if (answer == JOptionPane.OK_OPTION) {
				String user = Fuser.getText();
				String group = (String)Box.getSelectedItem();
				
				String command [] = {"chown", user+":"+group, archi};
				ProcessBuilder change = new ProcessBuilder();
				change.command(command);
				change.directory(new File ("/home/"));
				
				if (exe.isSelected() == true) {
					String exeplus [] = {"chmod", "+x", archi};
					ProcessBuilder exeP = new ProcessBuilder();
					exeP.command(exeplus);
					exeP.directory(new File("/home/"));
					
					change.start();
					exeP.start();
				} else {
					String exeminus [] = {"chmod", "-x", archi};
					ProcessBuilder exeM = new ProcessBuilder();
					exeM.command(exeminus);
					exeM.directory(new File("/home/"));
					
					change.start();
					exeM.start();
				}//else
			
				if (read.isSelected() == true) {
					String readPlus [] = {"chmod", "+r", archi};
					ProcessBuilder readP = new ProcessBuilder();
					readP.command(readPlus);
					readP.directory(new File("/home/"));
					
					change.start();
					readP.start();
				} else {
					String readMinus [] = {"chmod", "-r", archi};
					ProcessBuilder readM = new ProcessBuilder();
					readM.command(readMinus);
					readM.directory(new File("/home/"));
					
					change.start();
					readM.start();
				}//else
				
				if (write.isSelected() == true) {
					String writePlus [] = {"chmod", "+w",archi};
					ProcessBuilder writeP = new ProcessBuilder();
					writeP.command(writePlus);
					writeP.directory(new File("/home/"));
					
					change.start();
					writeP.start();
				} else {
					String writeMinus [] = {"chmod", "-w", archi};
					ProcessBuilder writeM = new ProcessBuilder();
					writeM.command(writeMinus);
					writeM.directory(new File("/home/"));
					
					change.start();
					writeM.start();
				}//else con usuario
			
			} else {
				if (exe.isSelected() == true) {
					String exeplus [] = {"chmod", "+x", archi};
					ProcessBuilder exeP = new ProcessBuilder();
					exeP.command(exeplus);
					exeP.directory(new File("/home/"));
					
					exeP.start();
				} else {
					String exeminus [] = {"chmod", "-x", archi};
					ProcessBuilder exeM = new ProcessBuilder();
					exeM.command(exeminus);
					exeM.directory(new File("/home/"));
					
					exeM.start();
				}//else
				
				if (read.isSelected() == true) {
					String readPlus [] = {"chmod", "+r", archi};
					ProcessBuilder readP = new ProcessBuilder();
					readP.command(readPlus);
					readP.directory(new File("/home/"));
					
					readP.start();
				} else {
					String readMinus [] = {"chmod", "-r", archi};
					ProcessBuilder readM = new ProcessBuilder();
					readM.command(readMinus);
					readM.directory(new File("/home/"));
					
					readM.start();
				}//else
				
				if (write.isSelected() == true) {
					String writePlus [] = {"chmod", "+w",archi};
					ProcessBuilder writeP = new ProcessBuilder();
					writeP.command(writePlus);
					writeP.directory(new File("/home/"));
					
					writeP.start();
				} else {
					String writeMinus [] = {"chmod", "-w", archi};
					ProcessBuilder writeM = new ProcessBuilder();
					writeM.command(writeMinus);
					writeM.directory(new File("/home/"));
					
					writeM.start();
				}//else sin usuario
			
			}//else Final
			
		}//ModFile

		public void delete(){
			String user = Fuser.getText();
			String delete [] = {"userdel", "-r", user};

			ProcessBuilder del = new ProcessBuilder();

			del.command(delete);
			del.directory(new File("/home/"));
			try {
				del.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}//delete
		
	}//class
