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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.PaqueteConstantesFunciones;
import com.bydan.erp.seguridad.util.PaqueteParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PaqueteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PaqueteConstantesFunciones extends PaqueteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Paquete";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Paquete"+PaqueteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PaqueteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PaqueteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PaqueteConstantesFunciones.SCHEMA+"_"+PaqueteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PaqueteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PaqueteConstantesFunciones.SCHEMA+"_"+PaqueteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PaqueteConstantesFunciones.SCHEMA+"_"+PaqueteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PaqueteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PaqueteConstantesFunciones.SCHEMA+"_"+PaqueteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PaqueteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PaqueteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PaqueteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PaqueteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PaqueteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PaqueteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PaqueteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PaqueteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PaqueteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PaqueteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Paquetes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Paquete";
	public static final String SCLASSWEBTITULO_LOWER="Paquete";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Paquete";
	public static final String OBJECTNAME="paquete";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="paquete";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select paquete from "+PaqueteConstantesFunciones.SPERSISTENCENAME+" paquete";
	public static String QUERYSELECTNATIVE="select "+PaqueteConstantesFunciones.SCHEMA+"."+PaqueteConstantesFunciones.TABLENAME+".id,"+PaqueteConstantesFunciones.SCHEMA+"."+PaqueteConstantesFunciones.TABLENAME+".version_row,"+PaqueteConstantesFunciones.SCHEMA+"."+PaqueteConstantesFunciones.TABLENAME+".id_sistema,"+PaqueteConstantesFunciones.SCHEMA+"."+PaqueteConstantesFunciones.TABLENAME+".nombre,"+PaqueteConstantesFunciones.SCHEMA+"."+PaqueteConstantesFunciones.TABLENAME+".descripcion from "+PaqueteConstantesFunciones.SCHEMA+"."+PaqueteConstantesFunciones.TABLENAME;//+" as "+PaqueteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PaqueteConstantesFuncionesAdditional paqueteConstantesFuncionesAdditional=null;
	
	public PaqueteConstantesFuncionesAdditional getPaqueteConstantesFuncionesAdditional() {
		return this.paqueteConstantesFuncionesAdditional;
	}
	
	public void setPaqueteConstantesFuncionesAdditional(PaqueteConstantesFuncionesAdditional paqueteConstantesFuncionesAdditional) {
		try {
			this.paqueteConstantesFuncionesAdditional=paqueteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDSISTEMA= "id_sistema";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDSISTEMA= "Sistema";
		public static final String LABEL_IDSISTEMA_LOWER= "Sistema";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPaqueteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PaqueteConstantesFunciones.IDSISTEMA)) {sLabelColumna=PaqueteConstantesFunciones.LABEL_IDSISTEMA;}
		if(sNombreColumna.equals(PaqueteConstantesFunciones.NOMBRE)) {sLabelColumna=PaqueteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(PaqueteConstantesFunciones.DESCRIPCION)) {sLabelColumna=PaqueteConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getPaqueteDescripcion(Paquete paquete) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(paquete !=null/* && paquete.getId()!=0*/) {
			sDescripcion=paquete.getnombre();//paquetepaquete.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPaqueteDescripcionDetallado(Paquete paquete) {
		String sDescripcion="";
			
		sDescripcion+=PaqueteConstantesFunciones.ID+"=";
		sDescripcion+=paquete.getId().toString()+",";
		sDescripcion+=PaqueteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=paquete.getVersionRow().toString()+",";
		sDescripcion+=PaqueteConstantesFunciones.IDSISTEMA+"=";
		sDescripcion+=paquete.getid_sistema().toString()+",";
		sDescripcion+=PaqueteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=paquete.getnombre()+",";
		sDescripcion+=PaqueteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=paquete.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPaqueteDescripcion(Paquete paquete,String sValor) throws Exception {			
		if(paquete !=null) {
			paquete.setnombre(sValor);;//paquetepaquete.getnombre().trim();
		}		
	}
	
		

	public static String getSistemaDescripcion(Sistema sistema) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sistema!=null/*&&sistema.getId()>0*/) {
			sDescripcion=SistemaConstantesFunciones.getSistemaDescripcion(sistema);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdSistema")) {
			sNombreIndice="Tipo=  Por Sistema";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdSistema(Long id_sistema) {
		String sDetalleIndice=" Parametros->";
		if(id_sistema!=null) {sDetalleIndice+=" Codigo Unico De Sistema="+id_sistema.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPaquete(Paquete paquete,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		paquete.setnombre(paquete.getnombre().trim());
		paquete.setdescripcion(paquete.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPaquetes(List<Paquete> paquetes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Paquete paquete: paquetes) {
			paquete.setnombre(paquete.getnombre().trim());
			paquete.setdescripcion(paquete.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPaquete(Paquete paquete,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && paquete.getConCambioAuxiliar()) {
			paquete.setIsDeleted(paquete.getIsDeletedAuxiliar());	
			paquete.setIsNew(paquete.getIsNewAuxiliar());	
			paquete.setIsChanged(paquete.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			paquete.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			paquete.setIsDeletedAuxiliar(false);	
			paquete.setIsNewAuxiliar(false);	
			paquete.setIsChangedAuxiliar(false);
			
			paquete.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPaquetes(List<Paquete> paquetes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Paquete paquete : paquetes) {
			if(conAsignarBase && paquete.getConCambioAuxiliar()) {
				paquete.setIsDeleted(paquete.getIsDeletedAuxiliar());	
				paquete.setIsNew(paquete.getIsNewAuxiliar());	
				paquete.setIsChanged(paquete.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				paquete.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				paquete.setIsDeletedAuxiliar(false);	
				paquete.setIsNewAuxiliar(false);	
				paquete.setIsChangedAuxiliar(false);
				
				paquete.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPaquete(Paquete paquete,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPaquetes(List<Paquete> paquetes,Boolean conEnteros) throws Exception  {
		
		for(Paquete paquete: paquetes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPaquete(List<Paquete> paquetes,Paquete paqueteAux) throws Exception  {
		PaqueteConstantesFunciones.InicializarValoresPaquete(paqueteAux,true);
		
		for(Paquete paquete: paquetes) {
			if(paquete.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPaquete(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PaqueteConstantesFunciones.getArrayColumnasGlobalesPaquete(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPaquete(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPaquete(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Paquete> paquetes,Paquete paquete,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Paquete paqueteAux: paquetes) {
			if(paqueteAux!=null && paquete!=null) {
				if((paqueteAux.getId()==null && paquete.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(paqueteAux.getId()!=null && paquete.getId()!=null){
					if(paqueteAux.getId().equals(paquete.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPaquete(List<Paquete> paquetes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Paquete paquete: paquetes) {			
			if(paquete.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPaquete() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PaqueteConstantesFunciones.LABEL_ID, PaqueteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaqueteConstantesFunciones.LABEL_VERSIONROW, PaqueteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaqueteConstantesFunciones.LABEL_IDSISTEMA, PaqueteConstantesFunciones.IDSISTEMA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaqueteConstantesFunciones.LABEL_NOMBRE, PaqueteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PaqueteConstantesFunciones.LABEL_DESCRIPCION, PaqueteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPaquete() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PaqueteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaqueteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaqueteConstantesFunciones.IDSISTEMA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaqueteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PaqueteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPaquete() throws Exception  {
		return PaqueteConstantesFunciones.getTiposSeleccionarPaquete(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPaquete(Boolean conFk) throws Exception  {
		return PaqueteConstantesFunciones.getTiposSeleccionarPaquete(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPaquete(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PaqueteConstantesFunciones.LABEL_IDSISTEMA);
			reporte.setsDescripcion(PaqueteConstantesFunciones.LABEL_IDSISTEMA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PaqueteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PaqueteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PaqueteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PaqueteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPaquete(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPaquete(Paquete paqueteAux) throws Exception {
		
			paqueteAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(paqueteAux.getSistema()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPaquete(List<Paquete> paquetesTemp) throws Exception {
		for(Paquete paqueteAux:paquetesTemp) {
			
			paqueteAux.setsistema_descripcion(SistemaConstantesFunciones.getSistemaDescripcion(paqueteAux.getSistema()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPaquete(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sistema.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sistema.class)) {
						classes.add(new Classe(Sistema.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPaquete(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sistema.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sistema.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPaquete(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PaqueteConstantesFunciones.getClassesRelationshipsOfPaquete(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPaquete(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPaquete(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PaqueteConstantesFunciones.getClassesRelationshipsFromStringsOfPaquete(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPaquete(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Paquete paquete,List<Paquete> paquetes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Paquete paqueteEncontrado=null;
			
			for(Paquete paqueteLocal:paquetes) {
				if(paqueteLocal.getId().equals(paquete.getId())) {
					paqueteEncontrado=paqueteLocal;
					
					paqueteLocal.setIsChanged(paquete.getIsChanged());
					paqueteLocal.setIsNew(paquete.getIsNew());
					paqueteLocal.setIsDeleted(paquete.getIsDeleted());
					
					paqueteLocal.setGeneralEntityOriginal(paquete.getGeneralEntityOriginal());
					
					paqueteLocal.setId(paquete.getId());	
					paqueteLocal.setVersionRow(paquete.getVersionRow());	
					paqueteLocal.setid_sistema(paquete.getid_sistema());	
					paqueteLocal.setnombre(paquete.getnombre());	
					paqueteLocal.setdescripcion(paquete.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!paquete.getIsDeleted()) {
				if(!existe) {
					paquetes.add(paquete);
				}
			} else {
				if(paqueteEncontrado!=null && permiteQuitar)  {
					paquetes.remove(paqueteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Paquete paquete,List<Paquete> paquetes) throws Exception {
		try	{			
			for(Paquete paqueteLocal:paquetes) {
				if(paqueteLocal.getId().equals(paquete.getId())) {
					paqueteLocal.setIsSelected(paquete.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPaquete(List<Paquete> paquetesAux) throws Exception {
		//this.paquetesAux=paquetesAux;
		
		for(Paquete paqueteAux:paquetesAux) {
			if(paqueteAux.getIsChanged()) {
				paqueteAux.setIsChanged(false);
			}		
			
			if(paqueteAux.getIsNew()) {
				paqueteAux.setIsNew(false);
			}	
			
			if(paqueteAux.getIsDeleted()) {
				paqueteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPaquete(Paquete paqueteAux) throws Exception {
		//this.paqueteAux=paqueteAux;
		
			if(paqueteAux.getIsChanged()) {
				paqueteAux.setIsChanged(false);
			}		
			
			if(paqueteAux.getIsNew()) {
				paqueteAux.setIsNew(false);
			}	
			
			if(paqueteAux.getIsDeleted()) {
				paqueteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Paquete paqueteAsignar,Paquete paquete) throws Exception {
		paqueteAsignar.setId(paquete.getId());	
		paqueteAsignar.setVersionRow(paquete.getVersionRow());	
		paqueteAsignar.setid_sistema(paquete.getid_sistema());
		paqueteAsignar.setsistema_descripcion(paquete.getsistema_descripcion());	
		paqueteAsignar.setnombre(paquete.getnombre());	
		paqueteAsignar.setdescripcion(paquete.getdescripcion());	
	}
	
	public static void inicializarPaquete(Paquete paquete) throws Exception {
		try {
				paquete.setId(0L);	
					
				paquete.setid_sistema(-1L);	
				paquete.setnombre("");	
				paquete.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPaquete(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PaqueteConstantesFunciones.LABEL_IDSISTEMA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PaqueteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PaqueteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPaquete(String sTipo,Row row,Workbook workbook,Paquete paquete,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(paquete.getsistema_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(paquete.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(paquete.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPaquete=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPaquete() {
		return this.sFinalQueryPaquete;
	}
	
	public void setsFinalQueryPaquete(String sFinalQueryPaquete) {
		this.sFinalQueryPaquete= sFinalQueryPaquete;
	}
	
	public Border resaltarSeleccionarPaquete=null;
	
	public Border setResaltarSeleccionarPaquete(ParametroGeneralUsuario parametroGeneralUsuario/*PaqueteBeanSwingJInternalFrame paqueteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//paqueteBeanSwingJInternalFrame.jTtoolBarPaquete.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPaquete= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPaquete() {
		return this.resaltarSeleccionarPaquete;
	}
	
	public void setResaltarSeleccionarPaquete(Border borderResaltarSeleccionarPaquete) {
		this.resaltarSeleccionarPaquete= borderResaltarSeleccionarPaquete;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPaquete=null;
	public Boolean mostraridPaquete=true;
	public Boolean activaridPaquete=true;

	public Border resaltarid_sistemaPaquete=null;
	public Boolean mostrarid_sistemaPaquete=true;
	public Boolean activarid_sistemaPaquete=true;
	public Boolean cargarid_sistemaPaquete=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sistemaPaquete=false;//ConEventDepend=true

	public Border resaltarnombrePaquete=null;
	public Boolean mostrarnombrePaquete=true;
	public Boolean activarnombrePaquete=true;

	public Border resaltardescripcionPaquete=null;
	public Boolean mostrardescripcionPaquete=true;
	public Boolean activardescripcionPaquete=true;

	
	

	public Border setResaltaridPaquete(ParametroGeneralUsuario parametroGeneralUsuario/*PaqueteBeanSwingJInternalFrame paqueteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paqueteBeanSwingJInternalFrame.jTtoolBarPaquete.setBorder(borderResaltar);
		
		this.resaltaridPaquete= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPaquete() {
		return this.resaltaridPaquete;
	}

	public void setResaltaridPaquete(Border borderResaltar) {
		this.resaltaridPaquete= borderResaltar;
	}

	public Boolean getMostraridPaquete() {
		return this.mostraridPaquete;
	}

	public void setMostraridPaquete(Boolean mostraridPaquete) {
		this.mostraridPaquete= mostraridPaquete;
	}

	public Boolean getActivaridPaquete() {
		return this.activaridPaquete;
	}

	public void setActivaridPaquete(Boolean activaridPaquete) {
		this.activaridPaquete= activaridPaquete;
	}

	public Border setResaltarid_sistemaPaquete(ParametroGeneralUsuario parametroGeneralUsuario/*PaqueteBeanSwingJInternalFrame paqueteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paqueteBeanSwingJInternalFrame.jTtoolBarPaquete.setBorder(borderResaltar);
		
		this.resaltarid_sistemaPaquete= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sistemaPaquete() {
		return this.resaltarid_sistemaPaquete;
	}

	public void setResaltarid_sistemaPaquete(Border borderResaltar) {
		this.resaltarid_sistemaPaquete= borderResaltar;
	}

	public Boolean getMostrarid_sistemaPaquete() {
		return this.mostrarid_sistemaPaquete;
	}

	public void setMostrarid_sistemaPaquete(Boolean mostrarid_sistemaPaquete) {
		this.mostrarid_sistemaPaquete= mostrarid_sistemaPaquete;
	}

	public Boolean getActivarid_sistemaPaquete() {
		return this.activarid_sistemaPaquete;
	}

	public void setActivarid_sistemaPaquete(Boolean activarid_sistemaPaquete) {
		this.activarid_sistemaPaquete= activarid_sistemaPaquete;
	}

	public Boolean getCargarid_sistemaPaquete() {
		return this.cargarid_sistemaPaquete;
	}

	public void setCargarid_sistemaPaquete(Boolean cargarid_sistemaPaquete) {
		this.cargarid_sistemaPaquete= cargarid_sistemaPaquete;
	}

	public Border setResaltarnombrePaquete(ParametroGeneralUsuario parametroGeneralUsuario/*PaqueteBeanSwingJInternalFrame paqueteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paqueteBeanSwingJInternalFrame.jTtoolBarPaquete.setBorder(borderResaltar);
		
		this.resaltarnombrePaquete= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePaquete() {
		return this.resaltarnombrePaquete;
	}

	public void setResaltarnombrePaquete(Border borderResaltar) {
		this.resaltarnombrePaquete= borderResaltar;
	}

	public Boolean getMostrarnombrePaquete() {
		return this.mostrarnombrePaquete;
	}

	public void setMostrarnombrePaquete(Boolean mostrarnombrePaquete) {
		this.mostrarnombrePaquete= mostrarnombrePaquete;
	}

	public Boolean getActivarnombrePaquete() {
		return this.activarnombrePaquete;
	}

	public void setActivarnombrePaquete(Boolean activarnombrePaquete) {
		this.activarnombrePaquete= activarnombrePaquete;
	}

	public Border setResaltardescripcionPaquete(ParametroGeneralUsuario parametroGeneralUsuario/*PaqueteBeanSwingJInternalFrame paqueteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//paqueteBeanSwingJInternalFrame.jTtoolBarPaquete.setBorder(borderResaltar);
		
		this.resaltardescripcionPaquete= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPaquete() {
		return this.resaltardescripcionPaquete;
	}

	public void setResaltardescripcionPaquete(Border borderResaltar) {
		this.resaltardescripcionPaquete= borderResaltar;
	}

	public Boolean getMostrardescripcionPaquete() {
		return this.mostrardescripcionPaquete;
	}

	public void setMostrardescripcionPaquete(Boolean mostrardescripcionPaquete) {
		this.mostrardescripcionPaquete= mostrardescripcionPaquete;
	}

	public Boolean getActivardescripcionPaquete() {
		return this.activardescripcionPaquete;
	}

	public void setActivardescripcionPaquete(Boolean activardescripcionPaquete) {
		this.activardescripcionPaquete= activardescripcionPaquete;
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
		
		
		this.setMostraridPaquete(esInicial);
		this.setMostrarid_sistemaPaquete(esInicial);
		this.setMostrarnombrePaquete(esInicial);
		this.setMostrardescripcionPaquete(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PaqueteConstantesFunciones.ID)) {
				this.setMostraridPaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.IDSISTEMA)) {
				this.setMostrarid_sistemaPaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPaquete(esAsigna);
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
		
		
		this.setActivaridPaquete(esInicial);
		this.setActivarid_sistemaPaquete(esInicial);
		this.setActivarnombrePaquete(esInicial);
		this.setActivardescripcionPaquete(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PaqueteConstantesFunciones.ID)) {
				this.setActivaridPaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.IDSISTEMA)) {
				this.setActivarid_sistemaPaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPaquete(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PaqueteBeanSwingJInternalFrame paqueteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPaquete(esInicial);
		this.setResaltarid_sistemaPaquete(esInicial);
		this.setResaltarnombrePaquete(esInicial);
		this.setResaltardescripcionPaquete(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PaqueteConstantesFunciones.ID)) {
				this.setResaltaridPaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.IDSISTEMA)) {
				this.setResaltarid_sistemaPaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePaquete(esAsigna);
				continue;
			}

			if(campo.clase.equals(PaqueteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPaquete(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PaqueteBeanSwingJInternalFrame paqueteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdSistemaPaquete=true;

	public Boolean getMostrarFK_IdSistemaPaquete() {
		return this.mostrarFK_IdSistemaPaquete;
	}

	public void setMostrarFK_IdSistemaPaquete(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSistemaPaquete= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdSistemaPaquete=true;

	public Boolean getActivarFK_IdSistemaPaquete() {
		return this.activarFK_IdSistemaPaquete;
	}

	public void setActivarFK_IdSistemaPaquete(Boolean habilitarResaltar) {
		this.activarFK_IdSistemaPaquete= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdSistemaPaquete=null;

	public Border getResaltarFK_IdSistemaPaquete() {
		return this.resaltarFK_IdSistemaPaquete;
	}

	public void setResaltarFK_IdSistemaPaquete(Border borderResaltar) {
		this.resaltarFK_IdSistemaPaquete= borderResaltar;
	}

	public void setResaltarFK_IdSistemaPaquete(ParametroGeneralUsuario parametroGeneralUsuario/*PaqueteBeanSwingJInternalFrame paqueteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSistemaPaquete= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}