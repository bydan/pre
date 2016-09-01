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
package com.bydan.erp.puntoventa.util.report;

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

import com.bydan.erp.puntoventa.resources.general.AuxiliarGeneral;

import com.bydan.erp.puntoventa.util.report.ProcesoCierreCajaConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.ProcesoCierreCajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ProcesoCierreCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoCierreCajaConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="ProcesoCierreCaja";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoCierreCaja"+ProcesoCierreCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoCierreCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoCierreCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoCierreCajaConstantesFunciones.SCHEMA+"_"+ProcesoCierreCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoCierreCajaConstantesFunciones.SCHEMA+"_"+ProcesoCierreCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoCierreCajaConstantesFunciones.SCHEMA+"_"+ProcesoCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoCierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoCierreCajaConstantesFunciones.SCHEMA+"_"+ProcesoCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoCierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoCierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoCierreCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoCierreCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoCierreCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoCierreCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Cierre Cajas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Proceso Cierre Caja";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Cierre Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoCierreCaja";
	public static final String OBJECTNAME="procesocierrecaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="proceso_cierre_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesocierrecaja from "+ProcesoCierreCajaConstantesFunciones.SPERSISTENCENAME+" procesocierrecaja";
	public static String QUERYSELECTNATIVE="select "+ProcesoCierreCajaConstantesFunciones.SCHEMA+"."+ProcesoCierreCajaConstantesFunciones.TABLENAME+".id,"+ProcesoCierreCajaConstantesFunciones.SCHEMA+"."+ProcesoCierreCajaConstantesFunciones.TABLENAME+".version_row,"+ProcesoCierreCajaConstantesFunciones.SCHEMA+"."+ProcesoCierreCajaConstantesFunciones.TABLENAME+".id_usuario,"+ProcesoCierreCajaConstantesFunciones.SCHEMA+"."+ProcesoCierreCajaConstantesFunciones.TABLENAME+".id_caja,"+ProcesoCierreCajaConstantesFunciones.SCHEMA+"."+ProcesoCierreCajaConstantesFunciones.TABLENAME+".fecha from "+ProcesoCierreCajaConstantesFunciones.SCHEMA+"."+ProcesoCierreCajaConstantesFunciones.TABLENAME;//+" as "+ProcesoCierreCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDCAJA= "id_caja";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
	
	public static String getProcesoCierreCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoCierreCajaConstantesFunciones.IDUSUARIO)) {sLabelColumna=ProcesoCierreCajaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(ProcesoCierreCajaConstantesFunciones.IDCAJA)) {sLabelColumna=ProcesoCierreCajaConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(ProcesoCierreCajaConstantesFunciones.FECHA)) {sLabelColumna=ProcesoCierreCajaConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getProcesoCierreCajaDescripcion(ProcesoCierreCaja procesocierrecaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesocierrecaja !=null/* && procesocierrecaja.getId()!=0*/) {
			sDescripcion=procesocierrecaja.getfecha().toString();//procesocierrecajaprocesocierrecaja.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoCierreCajaDescripcionDetallado(ProcesoCierreCaja procesocierrecaja) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoCierreCajaConstantesFunciones.ID+"=";
		sDescripcion+=procesocierrecaja.getId().toString()+",";
		sDescripcion+=ProcesoCierreCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesocierrecaja.getVersionRow().toString()+",";
		sDescripcion+=ProcesoCierreCajaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=procesocierrecaja.getid_usuario().toString()+",";
		sDescripcion+=ProcesoCierreCajaConstantesFunciones.IDCAJA+"=";
		sDescripcion+=procesocierrecaja.getid_caja().toString()+",";
		sDescripcion+=ProcesoCierreCajaConstantesFunciones.FECHA+"=";
		sDescripcion+=procesocierrecaja.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoCierreCajaDescripcion(ProcesoCierreCaja procesocierrecaja,String sValor) throws Exception {			
		if(procesocierrecaja !=null) {
			//procesocierrecajaprocesocierrecaja.getId().toString();
		}		
	}
	
		

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoCierreCaja")) {
			sNombreIndice="Tipo=  Por Usuario Por Caja Por Fecha";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaProcesoCierreCaja(Long id_usuario,Long id_caja,Date fecha) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();}
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();}
		if(fecha!=null) {sDetalleIndice+=" Fecha="+fecha.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosProcesoCierreCaja(ProcesoCierreCaja procesocierrecaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosProcesoCierreCajas(List<ProcesoCierreCaja> procesocierrecajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoCierreCaja procesocierrecaja: procesocierrecajas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierreCaja(ProcesoCierreCaja procesocierrecaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesocierrecaja.getConCambioAuxiliar()) {
			procesocierrecaja.setIsDeleted(procesocierrecaja.getIsDeletedAuxiliar());	
			procesocierrecaja.setIsNew(procesocierrecaja.getIsNewAuxiliar());	
			procesocierrecaja.setIsChanged(procesocierrecaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesocierrecaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesocierrecaja.setIsDeletedAuxiliar(false);	
			procesocierrecaja.setIsNewAuxiliar(false);	
			procesocierrecaja.setIsChangedAuxiliar(false);
			
			procesocierrecaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoCierreCajas(List<ProcesoCierreCaja> procesocierrecajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoCierreCaja procesocierrecaja : procesocierrecajas) {
			if(conAsignarBase && procesocierrecaja.getConCambioAuxiliar()) {
				procesocierrecaja.setIsDeleted(procesocierrecaja.getIsDeletedAuxiliar());	
				procesocierrecaja.setIsNew(procesocierrecaja.getIsNewAuxiliar());	
				procesocierrecaja.setIsChanged(procesocierrecaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesocierrecaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesocierrecaja.setIsDeletedAuxiliar(false);	
				procesocierrecaja.setIsNewAuxiliar(false);	
				procesocierrecaja.setIsChangedAuxiliar(false);
				
				procesocierrecaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoCierreCaja(ProcesoCierreCaja procesocierrecaja,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoCierreCajas(List<ProcesoCierreCaja> procesocierrecajas,Boolean conEnteros) throws Exception  {
		
		for(ProcesoCierreCaja procesocierrecaja: procesocierrecajas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoCierreCaja(List<ProcesoCierreCaja> procesocierrecajas,ProcesoCierreCaja procesocierrecajaAux) throws Exception  {
		ProcesoCierreCajaConstantesFunciones.InicializarValoresProcesoCierreCaja(procesocierrecajaAux,true);
		
		for(ProcesoCierreCaja procesocierrecaja: procesocierrecajas) {
			if(procesocierrecaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoCierreCajaConstantesFunciones.getArrayColumnasGlobalesProcesoCierreCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoCierreCajaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoCierreCajaConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoCierreCaja> procesocierrecajas,ProcesoCierreCaja procesocierrecaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoCierreCaja procesocierrecajaAux: procesocierrecajas) {
			if(procesocierrecajaAux!=null && procesocierrecaja!=null) {
				if((procesocierrecajaAux.getId()==null && procesocierrecaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesocierrecajaAux.getId()!=null && procesocierrecaja.getId()!=null){
					if(procesocierrecajaAux.getId().equals(procesocierrecaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoCierreCaja(List<ProcesoCierreCaja> procesocierrecajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ProcesoCierreCaja procesocierrecaja: procesocierrecajas) {			
			if(procesocierrecaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoCierreCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoCierreCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreCaja() throws Exception  {
		return ProcesoCierreCajaConstantesFunciones.getTiposSeleccionarProcesoCierreCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreCaja(Boolean conFk) throws Exception  {
		return ProcesoCierreCajaConstantesFunciones.getTiposSeleccionarProcesoCierreCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoCierreCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreCajaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(ProcesoCierreCajaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreCajaConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(ProcesoCierreCajaConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoCierreCajaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ProcesoCierreCajaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoCierreCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierreCaja(ProcesoCierreCaja procesocierrecajaAux) throws Exception {
		
			procesocierrecajaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(procesocierrecajaAux.getUsuario()));
			procesocierrecajaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(procesocierrecajaAux.getCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoCierreCaja(List<ProcesoCierreCaja> procesocierrecajasTemp) throws Exception {
		for(ProcesoCierreCaja procesocierrecajaAux:procesocierrecajasTemp) {
			
			procesocierrecajaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(procesocierrecajaAux.getUsuario()));
			procesocierrecajaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(procesocierrecajaAux.getCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Caja.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierreCajaConstantesFunciones.getClassesRelationshipsOfProcesoCierreCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoCierreCajaConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoCierreCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoCierreCaja procesocierrecaja,List<ProcesoCierreCaja> procesocierrecajas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoCierreCaja procesocierrecaja,List<ProcesoCierreCaja> procesocierrecajas) throws Exception {
		try	{			
			for(ProcesoCierreCaja procesocierrecajaLocal:procesocierrecajas) {
				if(procesocierrecajaLocal.getId().equals(procesocierrecaja.getId())) {
					procesocierrecajaLocal.setIsSelected(procesocierrecaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoCierreCaja(List<ProcesoCierreCaja> procesocierrecajasAux) throws Exception {
		//this.procesocierrecajasAux=procesocierrecajasAux;
		
		for(ProcesoCierreCaja procesocierrecajaAux:procesocierrecajasAux) {
			if(procesocierrecajaAux.getIsChanged()) {
				procesocierrecajaAux.setIsChanged(false);
			}		
			
			if(procesocierrecajaAux.getIsNew()) {
				procesocierrecajaAux.setIsNew(false);
			}	
			
			if(procesocierrecajaAux.getIsDeleted()) {
				procesocierrecajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoCierreCaja(ProcesoCierreCaja procesocierrecajaAux) throws Exception {
		//this.procesocierrecajaAux=procesocierrecajaAux;
		
			if(procesocierrecajaAux.getIsChanged()) {
				procesocierrecajaAux.setIsChanged(false);
			}		
			
			if(procesocierrecajaAux.getIsNew()) {
				procesocierrecajaAux.setIsNew(false);
			}	
			
			if(procesocierrecajaAux.getIsDeleted()) {
				procesocierrecajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoCierreCaja procesocierrecajaAsignar,ProcesoCierreCaja procesocierrecaja) throws Exception {
		procesocierrecajaAsignar.setId(procesocierrecaja.getId());	
		procesocierrecajaAsignar.setVersionRow(procesocierrecaja.getVersionRow());	
		procesocierrecajaAsignar.setid_usuario(procesocierrecaja.getid_usuario());
		procesocierrecajaAsignar.setusuario_descripcion(procesocierrecaja.getusuario_descripcion());	
		procesocierrecajaAsignar.setid_caja(procesocierrecaja.getid_caja());
		procesocierrecajaAsignar.setcaja_descripcion(procesocierrecaja.getcaja_descripcion());	
		procesocierrecajaAsignar.setfecha(procesocierrecaja.getfecha());	
	}
	
	public static void inicializarProcesoCierreCaja(ProcesoCierreCaja procesocierrecaja) throws Exception {
		try {
				procesocierrecaja.setId(0L);	
					
				procesocierrecaja.setid_usuario(-1L);	
				procesocierrecaja.setid_caja(-1L);	
				procesocierrecaja.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoCierreCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreCajaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreCajaConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoCierreCajaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoCierreCaja(String sTipo,Row row,Workbook workbook,ProcesoCierreCaja procesocierrecaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierrecaja.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierrecaja.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesocierrecaja.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoCierreCaja="";
	
	public String getsFinalQueryProcesoCierreCaja() {
		return this.sFinalQueryProcesoCierreCaja;
	}
	
	public void setsFinalQueryProcesoCierreCaja(String sFinalQueryProcesoCierreCaja) {
		this.sFinalQueryProcesoCierreCaja= sFinalQueryProcesoCierreCaja;
	}
	
	public Border resaltarSeleccionarProcesoCierreCaja=null;
	
	public Border setResaltarSeleccionarProcesoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreCajaBeanSwingJInternalFrame procesocierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesocierrecajaBeanSwingJInternalFrame.jTtoolBarProcesoCierreCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoCierreCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoCierreCaja() {
		return this.resaltarSeleccionarProcesoCierreCaja;
	}
	
	public void setResaltarSeleccionarProcesoCierreCaja(Border borderResaltarSeleccionarProcesoCierreCaja) {
		this.resaltarSeleccionarProcesoCierreCaja= borderResaltarSeleccionarProcesoCierreCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoCierreCaja=null;
	public Boolean mostraridProcesoCierreCaja=true;
	public Boolean activaridProcesoCierreCaja=true;

	public Border resaltarid_usuarioProcesoCierreCaja=null;
	public Boolean mostrarid_usuarioProcesoCierreCaja=true;
	public Boolean activarid_usuarioProcesoCierreCaja=true;
	public Boolean cargarid_usuarioProcesoCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioProcesoCierreCaja=false;//ConEventDepend=true

	public Border resaltarid_cajaProcesoCierreCaja=null;
	public Boolean mostrarid_cajaProcesoCierreCaja=true;
	public Boolean activarid_cajaProcesoCierreCaja=true;
	public Boolean cargarid_cajaProcesoCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaProcesoCierreCaja=false;//ConEventDepend=true

	public Border resaltarfechaProcesoCierreCaja=null;
	public Boolean mostrarfechaProcesoCierreCaja=true;
	public Boolean activarfechaProcesoCierreCaja=true;

	
	

	public Border setResaltaridProcesoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreCajaBeanSwingJInternalFrame procesocierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierrecajaBeanSwingJInternalFrame.jTtoolBarProcesoCierreCaja.setBorder(borderResaltar);
		
		this.resaltaridProcesoCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoCierreCaja() {
		return this.resaltaridProcesoCierreCaja;
	}

	public void setResaltaridProcesoCierreCaja(Border borderResaltar) {
		this.resaltaridProcesoCierreCaja= borderResaltar;
	}

	public Boolean getMostraridProcesoCierreCaja() {
		return this.mostraridProcesoCierreCaja;
	}

	public void setMostraridProcesoCierreCaja(Boolean mostraridProcesoCierreCaja) {
		this.mostraridProcesoCierreCaja= mostraridProcesoCierreCaja;
	}

	public Boolean getActivaridProcesoCierreCaja() {
		return this.activaridProcesoCierreCaja;
	}

	public void setActivaridProcesoCierreCaja(Boolean activaridProcesoCierreCaja) {
		this.activaridProcesoCierreCaja= activaridProcesoCierreCaja;
	}

	public Border setResaltarid_usuarioProcesoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreCajaBeanSwingJInternalFrame procesocierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierrecajaBeanSwingJInternalFrame.jTtoolBarProcesoCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_usuarioProcesoCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioProcesoCierreCaja() {
		return this.resaltarid_usuarioProcesoCierreCaja;
	}

	public void setResaltarid_usuarioProcesoCierreCaja(Border borderResaltar) {
		this.resaltarid_usuarioProcesoCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_usuarioProcesoCierreCaja() {
		return this.mostrarid_usuarioProcesoCierreCaja;
	}

	public void setMostrarid_usuarioProcesoCierreCaja(Boolean mostrarid_usuarioProcesoCierreCaja) {
		this.mostrarid_usuarioProcesoCierreCaja= mostrarid_usuarioProcesoCierreCaja;
	}

	public Boolean getActivarid_usuarioProcesoCierreCaja() {
		return this.activarid_usuarioProcesoCierreCaja;
	}

	public void setActivarid_usuarioProcesoCierreCaja(Boolean activarid_usuarioProcesoCierreCaja) {
		this.activarid_usuarioProcesoCierreCaja= activarid_usuarioProcesoCierreCaja;
	}

	public Boolean getCargarid_usuarioProcesoCierreCaja() {
		return this.cargarid_usuarioProcesoCierreCaja;
	}

	public void setCargarid_usuarioProcesoCierreCaja(Boolean cargarid_usuarioProcesoCierreCaja) {
		this.cargarid_usuarioProcesoCierreCaja= cargarid_usuarioProcesoCierreCaja;
	}

	public Border setResaltarid_cajaProcesoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreCajaBeanSwingJInternalFrame procesocierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierrecajaBeanSwingJInternalFrame.jTtoolBarProcesoCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_cajaProcesoCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaProcesoCierreCaja() {
		return this.resaltarid_cajaProcesoCierreCaja;
	}

	public void setResaltarid_cajaProcesoCierreCaja(Border borderResaltar) {
		this.resaltarid_cajaProcesoCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_cajaProcesoCierreCaja() {
		return this.mostrarid_cajaProcesoCierreCaja;
	}

	public void setMostrarid_cajaProcesoCierreCaja(Boolean mostrarid_cajaProcesoCierreCaja) {
		this.mostrarid_cajaProcesoCierreCaja= mostrarid_cajaProcesoCierreCaja;
	}

	public Boolean getActivarid_cajaProcesoCierreCaja() {
		return this.activarid_cajaProcesoCierreCaja;
	}

	public void setActivarid_cajaProcesoCierreCaja(Boolean activarid_cajaProcesoCierreCaja) {
		this.activarid_cajaProcesoCierreCaja= activarid_cajaProcesoCierreCaja;
	}

	public Boolean getCargarid_cajaProcesoCierreCaja() {
		return this.cargarid_cajaProcesoCierreCaja;
	}

	public void setCargarid_cajaProcesoCierreCaja(Boolean cargarid_cajaProcesoCierreCaja) {
		this.cargarid_cajaProcesoCierreCaja= cargarid_cajaProcesoCierreCaja;
	}

	public Border setResaltarfechaProcesoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreCajaBeanSwingJInternalFrame procesocierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesocierrecajaBeanSwingJInternalFrame.jTtoolBarProcesoCierreCaja.setBorder(borderResaltar);
		
		this.resaltarfechaProcesoCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaProcesoCierreCaja() {
		return this.resaltarfechaProcesoCierreCaja;
	}

	public void setResaltarfechaProcesoCierreCaja(Border borderResaltar) {
		this.resaltarfechaProcesoCierreCaja= borderResaltar;
	}

	public Boolean getMostrarfechaProcesoCierreCaja() {
		return this.mostrarfechaProcesoCierreCaja;
	}

	public void setMostrarfechaProcesoCierreCaja(Boolean mostrarfechaProcesoCierreCaja) {
		this.mostrarfechaProcesoCierreCaja= mostrarfechaProcesoCierreCaja;
	}

	public Boolean getActivarfechaProcesoCierreCaja() {
		return this.activarfechaProcesoCierreCaja;
	}

	public void setActivarfechaProcesoCierreCaja(Boolean activarfechaProcesoCierreCaja) {
		this.activarfechaProcesoCierreCaja= activarfechaProcesoCierreCaja;
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
		
		
		this.setMostraridProcesoCierreCaja(esInicial);
		this.setMostrarid_usuarioProcesoCierreCaja(esInicial);
		this.setMostrarid_cajaProcesoCierreCaja(esInicial);
		this.setMostrarfechaProcesoCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.ID)) {
				this.setMostraridProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.FECHA)) {
				this.setMostrarfechaProcesoCierreCaja(esAsigna);
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
		
		
		this.setActivaridProcesoCierreCaja(esInicial);
		this.setActivarid_usuarioProcesoCierreCaja(esInicial);
		this.setActivarid_cajaProcesoCierreCaja(esInicial);
		this.setActivarfechaProcesoCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.ID)) {
				this.setActivaridProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.FECHA)) {
				this.setActivarfechaProcesoCierreCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierreCajaBeanSwingJInternalFrame procesocierrecajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoCierreCaja(esInicial);
		this.setResaltarid_usuarioProcesoCierreCaja(esInicial);
		this.setResaltarid_cajaProcesoCierreCaja(esInicial);
		this.setResaltarfechaProcesoCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.ID)) {
				this.setResaltaridProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaProcesoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoCierreCajaConstantesFunciones.FECHA)) {
				this.setResaltarfechaProcesoCierreCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoCierreCajaBeanSwingJInternalFrame procesocierrecajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoCierreCajaProcesoCierreCaja=true;

	public Boolean getMostrarBusquedaProcesoCierreCajaProcesoCierreCaja() {
		return this.mostrarBusquedaProcesoCierreCajaProcesoCierreCaja;
	}

	public void setMostrarBusquedaProcesoCierreCajaProcesoCierreCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoCierreCajaProcesoCierreCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoCierreCajaProcesoCierreCaja=true;

	public Boolean getActivarBusquedaProcesoCierreCajaProcesoCierreCaja() {
		return this.activarBusquedaProcesoCierreCajaProcesoCierreCaja;
	}

	public void setActivarBusquedaProcesoCierreCajaProcesoCierreCaja(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoCierreCajaProcesoCierreCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoCierreCajaProcesoCierreCaja=null;

	public Border getResaltarBusquedaProcesoCierreCajaProcesoCierreCaja() {
		return this.resaltarBusquedaProcesoCierreCajaProcesoCierreCaja;
	}

	public void setResaltarBusquedaProcesoCierreCajaProcesoCierreCaja(Border borderResaltar) {
		this.resaltarBusquedaProcesoCierreCajaProcesoCierreCaja= borderResaltar;
	}

	public void setResaltarBusquedaProcesoCierreCajaProcesoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoCierreCajaBeanSwingJInternalFrame procesocierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoCierreCajaProcesoCierreCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}