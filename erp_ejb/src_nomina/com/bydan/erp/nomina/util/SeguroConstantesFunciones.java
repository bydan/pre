/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.nomina.util.SeguroConstantesFunciones;
import com.bydan.erp.nomina.util.SeguroParameterReturnGeneral;
//import com.bydan.erp.nomina.util.SeguroParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SeguroConstantesFunciones extends SeguroConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="Seguro";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Seguro"+SeguroConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SeguroHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SeguroHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SeguroConstantesFunciones.SCHEMA+"_"+SeguroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SeguroHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SeguroConstantesFunciones.SCHEMA+"_"+SeguroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SeguroConstantesFunciones.SCHEMA+"_"+SeguroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SeguroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SeguroConstantesFunciones.SCHEMA+"_"+SeguroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SeguroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SeguroHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SeguroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SeguroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SeguroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SeguroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SeguroConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SeguroConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SeguroConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SeguroConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Seguros";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Seguro";
	public static final String SCLASSWEBTITULO_LOWER="Seguro";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Seguro";
	public static final String OBJECTNAME="seguro";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="seguro";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select seguro from "+SeguroConstantesFunciones.SPERSISTENCENAME+" seguro";
	public static String QUERYSELECTNATIVE="select "+SeguroConstantesFunciones.SCHEMA+"."+SeguroConstantesFunciones.TABLENAME+".id,"+SeguroConstantesFunciones.SCHEMA+"."+SeguroConstantesFunciones.TABLENAME+".version_row,"+SeguroConstantesFunciones.SCHEMA+"."+SeguroConstantesFunciones.TABLENAME+".id_empleado,"+SeguroConstantesFunciones.SCHEMA+"."+SeguroConstantesFunciones.TABLENAME+".nombre from "+SeguroConstantesFunciones.SCHEMA+"."+SeguroConstantesFunciones.TABLENAME;//+" as "+SeguroConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SeguroConstantesFuncionesAdditional seguroConstantesFuncionesAdditional=null;
	
	public SeguroConstantesFuncionesAdditional getSeguroConstantesFuncionesAdditional() {
		return this.seguroConstantesFuncionesAdditional;
	}
	
	public void setSeguroConstantesFuncionesAdditional(SeguroConstantesFuncionesAdditional seguroConstantesFuncionesAdditional) {
		try {
			this.seguroConstantesFuncionesAdditional=seguroConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPLEADO= "id_empleado";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSeguroLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SeguroConstantesFunciones.IDEMPLEADO)) {sLabelColumna=SeguroConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(SeguroConstantesFunciones.NOMBRE)) {sLabelColumna=SeguroConstantesFunciones.LABEL_NOMBRE;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
	
	public static String getSeguroDescripcion(Seguro seguro) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(seguro !=null/* && seguro.getId()!=0*/) {
			sDescripcion=seguro.getnombre();//seguroseguro.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSeguroDescripcionDetallado(Seguro seguro) {
		String sDescripcion="";
			
		sDescripcion+=SeguroConstantesFunciones.ID+"=";
		sDescripcion+=seguro.getId().toString()+",";
		sDescripcion+=SeguroConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=seguro.getVersionRow().toString()+",";
		sDescripcion+=SeguroConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=seguro.getid_empleado().toString()+",";
		sDescripcion+=SeguroConstantesFunciones.NOMBRE+"=";
		sDescripcion+=seguro.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setSeguroDescripcion(Seguro seguro,String sValor) throws Exception {			
		if(seguro !=null) {
			seguro.setnombre(sValor);;//seguroseguro.getnombre().trim();
		}		
	}
	
		

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSeguro(Seguro seguro,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		seguro.setnombre(seguro.getnombre().trim());
	}
	
	public static void quitarEspaciosSeguros(List<Seguro> seguros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Seguro seguro: seguros) {
			seguro.setnombre(seguro.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSeguro(Seguro seguro,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && seguro.getConCambioAuxiliar()) {
			seguro.setIsDeleted(seguro.getIsDeletedAuxiliar());	
			seguro.setIsNew(seguro.getIsNewAuxiliar());	
			seguro.setIsChanged(seguro.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			seguro.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			seguro.setIsDeletedAuxiliar(false);	
			seguro.setIsNewAuxiliar(false);	
			seguro.setIsChangedAuxiliar(false);
			
			seguro.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSeguros(List<Seguro> seguros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Seguro seguro : seguros) {
			if(conAsignarBase && seguro.getConCambioAuxiliar()) {
				seguro.setIsDeleted(seguro.getIsDeletedAuxiliar());	
				seguro.setIsNew(seguro.getIsNewAuxiliar());	
				seguro.setIsChanged(seguro.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				seguro.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				seguro.setIsDeletedAuxiliar(false);	
				seguro.setIsNewAuxiliar(false);	
				seguro.setIsChangedAuxiliar(false);
				
				seguro.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSeguro(Seguro seguro,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSeguros(List<Seguro> seguros,Boolean conEnteros) throws Exception  {
		
		for(Seguro seguro: seguros) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSeguro(List<Seguro> seguros,Seguro seguroAux) throws Exception  {
		SeguroConstantesFunciones.InicializarValoresSeguro(seguroAux,true);
		
		for(Seguro seguro: seguros) {
			if(seguro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSeguro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SeguroConstantesFunciones.getArrayColumnasGlobalesSeguro(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSeguro(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSeguro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Seguro> seguros,Seguro seguro,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Seguro seguroAux: seguros) {
			if(seguroAux!=null && seguro!=null) {
				if((seguroAux.getId()==null && seguro.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(seguroAux.getId()!=null && seguro.getId()!=null){
					if(seguroAux.getId().equals(seguro.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSeguro(List<Seguro> seguros) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Seguro seguro: seguros) {			
			if(seguro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSeguro() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SeguroConstantesFunciones.LABEL_ID, SeguroConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SeguroConstantesFunciones.LABEL_VERSIONROW, SeguroConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SeguroConstantesFunciones.LABEL_IDEMPLEADO, SeguroConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SeguroConstantesFunciones.LABEL_NOMBRE, SeguroConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSeguro() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SeguroConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SeguroConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SeguroConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SeguroConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSeguro() throws Exception  {
		return SeguroConstantesFunciones.getTiposSeleccionarSeguro(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSeguro(Boolean conFk) throws Exception  {
		return SeguroConstantesFunciones.getTiposSeleccionarSeguro(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSeguro(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SeguroConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(SeguroConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SeguroConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SeguroConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSeguro(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSeguro(Seguro seguroAux) throws Exception {
		
			seguroAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(seguroAux.getEmpleado()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSeguro(List<Seguro> segurosTemp) throws Exception {
		for(Seguro seguroAux:segurosTemp) {
			
			seguroAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(seguroAux.getEmpleado()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSeguro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSeguro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSeguro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SeguroConstantesFunciones.getClassesRelationshipsOfSeguro(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSeguro(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSeguro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SeguroConstantesFunciones.getClassesRelationshipsFromStringsOfSeguro(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSeguro(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Seguro seguro,List<Seguro> seguros,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Seguro seguroEncontrado=null;
			
			for(Seguro seguroLocal:seguros) {
				if(seguroLocal.getId().equals(seguro.getId())) {
					seguroEncontrado=seguroLocal;
					
					seguroLocal.setIsChanged(seguro.getIsChanged());
					seguroLocal.setIsNew(seguro.getIsNew());
					seguroLocal.setIsDeleted(seguro.getIsDeleted());
					
					seguroLocal.setGeneralEntityOriginal(seguro.getGeneralEntityOriginal());
					
					seguroLocal.setId(seguro.getId());	
					seguroLocal.setVersionRow(seguro.getVersionRow());	
					seguroLocal.setid_empleado(seguro.getid_empleado());	
					seguroLocal.setnombre(seguro.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!seguro.getIsDeleted()) {
				if(!existe) {
					seguros.add(seguro);
				}
			} else {
				if(seguroEncontrado!=null && permiteQuitar)  {
					seguros.remove(seguroEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Seguro seguro,List<Seguro> seguros) throws Exception {
		try	{			
			for(Seguro seguroLocal:seguros) {
				if(seguroLocal.getId().equals(seguro.getId())) {
					seguroLocal.setIsSelected(seguro.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSeguro(List<Seguro> segurosAux) throws Exception {
		//this.segurosAux=segurosAux;
		
		for(Seguro seguroAux:segurosAux) {
			if(seguroAux.getIsChanged()) {
				seguroAux.setIsChanged(false);
			}		
			
			if(seguroAux.getIsNew()) {
				seguroAux.setIsNew(false);
			}	
			
			if(seguroAux.getIsDeleted()) {
				seguroAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSeguro(Seguro seguroAux) throws Exception {
		//this.seguroAux=seguroAux;
		
			if(seguroAux.getIsChanged()) {
				seguroAux.setIsChanged(false);
			}		
			
			if(seguroAux.getIsNew()) {
				seguroAux.setIsNew(false);
			}	
			
			if(seguroAux.getIsDeleted()) {
				seguroAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Seguro seguroAsignar,Seguro seguro) throws Exception {
		seguroAsignar.setId(seguro.getId());	
		seguroAsignar.setVersionRow(seguro.getVersionRow());	
		seguroAsignar.setid_empleado(seguro.getid_empleado());
		seguroAsignar.setempleado_descripcion(seguro.getempleado_descripcion());	
		seguroAsignar.setnombre(seguro.getnombre());	
	}
	
	public static void inicializarSeguro(Seguro seguro) throws Exception {
		try {
				seguro.setId(0L);	
					
				seguro.setid_empleado(-1L);	
				seguro.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSeguro(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SeguroConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SeguroConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSeguro(String sTipo,Row row,Workbook workbook,Seguro seguro,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(seguro.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(seguro.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySeguro=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySeguro() {
		return this.sFinalQuerySeguro;
	}
	
	public void setsFinalQuerySeguro(String sFinalQuerySeguro) {
		this.sFinalQuerySeguro= sFinalQuerySeguro;
	}
	
	public Border resaltarSeleccionarSeguro=null;
	
	public Border setResaltarSeleccionarSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*SeguroBeanSwingJInternalFrame seguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//seguroBeanSwingJInternalFrame.jTtoolBarSeguro.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSeguro= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSeguro() {
		return this.resaltarSeleccionarSeguro;
	}
	
	public void setResaltarSeleccionarSeguro(Border borderResaltarSeleccionarSeguro) {
		this.resaltarSeleccionarSeguro= borderResaltarSeleccionarSeguro;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSeguro=null;
	public Boolean mostraridSeguro=true;
	public Boolean activaridSeguro=true;

	public Border resaltarid_empleadoSeguro=null;
	public Boolean mostrarid_empleadoSeguro=true;
	public Boolean activarid_empleadoSeguro=true;
	public Boolean cargarid_empleadoSeguro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoSeguro=false;//ConEventDepend=true

	public Border resaltarnombreSeguro=null;
	public Boolean mostrarnombreSeguro=true;
	public Boolean activarnombreSeguro=true;

	
	

	public Border setResaltaridSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*SeguroBeanSwingJInternalFrame seguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//seguroBeanSwingJInternalFrame.jTtoolBarSeguro.setBorder(borderResaltar);
		
		this.resaltaridSeguro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSeguro() {
		return this.resaltaridSeguro;
	}

	public void setResaltaridSeguro(Border borderResaltar) {
		this.resaltaridSeguro= borderResaltar;
	}

	public Boolean getMostraridSeguro() {
		return this.mostraridSeguro;
	}

	public void setMostraridSeguro(Boolean mostraridSeguro) {
		this.mostraridSeguro= mostraridSeguro;
	}

	public Boolean getActivaridSeguro() {
		return this.activaridSeguro;
	}

	public void setActivaridSeguro(Boolean activaridSeguro) {
		this.activaridSeguro= activaridSeguro;
	}

	public Border setResaltarid_empleadoSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*SeguroBeanSwingJInternalFrame seguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//seguroBeanSwingJInternalFrame.jTtoolBarSeguro.setBorder(borderResaltar);
		
		this.resaltarid_empleadoSeguro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoSeguro() {
		return this.resaltarid_empleadoSeguro;
	}

	public void setResaltarid_empleadoSeguro(Border borderResaltar) {
		this.resaltarid_empleadoSeguro= borderResaltar;
	}

	public Boolean getMostrarid_empleadoSeguro() {
		return this.mostrarid_empleadoSeguro;
	}

	public void setMostrarid_empleadoSeguro(Boolean mostrarid_empleadoSeguro) {
		this.mostrarid_empleadoSeguro= mostrarid_empleadoSeguro;
	}

	public Boolean getActivarid_empleadoSeguro() {
		return this.activarid_empleadoSeguro;
	}

	public void setActivarid_empleadoSeguro(Boolean activarid_empleadoSeguro) {
		this.activarid_empleadoSeguro= activarid_empleadoSeguro;
	}

	public Boolean getCargarid_empleadoSeguro() {
		return this.cargarid_empleadoSeguro;
	}

	public void setCargarid_empleadoSeguro(Boolean cargarid_empleadoSeguro) {
		this.cargarid_empleadoSeguro= cargarid_empleadoSeguro;
	}

	public Border setResaltarnombreSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*SeguroBeanSwingJInternalFrame seguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//seguroBeanSwingJInternalFrame.jTtoolBarSeguro.setBorder(borderResaltar);
		
		this.resaltarnombreSeguro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSeguro() {
		return this.resaltarnombreSeguro;
	}

	public void setResaltarnombreSeguro(Border borderResaltar) {
		this.resaltarnombreSeguro= borderResaltar;
	}

	public Boolean getMostrarnombreSeguro() {
		return this.mostrarnombreSeguro;
	}

	public void setMostrarnombreSeguro(Boolean mostrarnombreSeguro) {
		this.mostrarnombreSeguro= mostrarnombreSeguro;
	}

	public Boolean getActivarnombreSeguro() {
		return this.activarnombreSeguro;
	}

	public void setActivarnombreSeguro(Boolean activarnombreSeguro) {
		this.activarnombreSeguro= activarnombreSeguro;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridSeguro(esInicial);
		this.setMostrarid_empleadoSeguro(esInicial);
		this.setMostrarnombreSeguro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SeguroConstantesFunciones.ID)) {
				this.setMostraridSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguroConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguroConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSeguro(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridSeguro(esInicial);
		this.setActivarid_empleadoSeguro(esInicial);
		this.setActivarnombreSeguro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SeguroConstantesFunciones.ID)) {
				this.setActivaridSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguroConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguroConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSeguro(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SeguroBeanSwingJInternalFrame seguroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSeguro(esInicial);
		this.setResaltarid_empleadoSeguro(esInicial);
		this.setResaltarnombreSeguro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SeguroConstantesFunciones.ID)) {
				this.setResaltaridSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguroConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(SeguroConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSeguro(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SeguroBeanSwingJInternalFrame seguroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpleadoSeguro=true;

	public Boolean getMostrarFK_IdEmpleadoSeguro() {
		return this.mostrarFK_IdEmpleadoSeguro;
	}

	public void setMostrarFK_IdEmpleadoSeguro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoSeguro= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoSeguro=true;

	public Boolean getActivarFK_IdEmpleadoSeguro() {
		return this.activarFK_IdEmpleadoSeguro;
	}

	public void setActivarFK_IdEmpleadoSeguro(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoSeguro= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoSeguro=null;

	public Border getResaltarFK_IdEmpleadoSeguro() {
		return this.resaltarFK_IdEmpleadoSeguro;
	}

	public void setResaltarFK_IdEmpleadoSeguro(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoSeguro= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*SeguroBeanSwingJInternalFrame seguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoSeguro= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}