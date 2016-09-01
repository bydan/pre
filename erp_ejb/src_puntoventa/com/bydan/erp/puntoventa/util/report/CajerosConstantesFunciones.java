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


import com.bydan.erp.puntoventa.util.report.CajerosConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.CajerosParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.CajerosParameterGeneral;

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
final public class CajerosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="Cajeros";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Cajeros"+CajerosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajerosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajerosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajerosConstantesFunciones.SCHEMA+"_"+CajerosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajerosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajerosConstantesFunciones.SCHEMA+"_"+CajerosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajerosConstantesFunciones.SCHEMA+"_"+CajerosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajerosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajerosConstantesFunciones.SCHEMA+"_"+CajerosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajerosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajerosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajerosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajerosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajerosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajerosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajerosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajerosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajerosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajerosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cajeroses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cajeros";
	public static final String SCLASSWEBTITULO_LOWER="Cajeros";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Cajeros";
	public static final String OBJECTNAME="cajeros";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="cajeros";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajeros from "+CajerosConstantesFunciones.SPERSISTENCENAME+" cajeros";
	public static String QUERYSELECTNATIVE="select "+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".id,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".version_row,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".id_empresa,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".id_sucursal,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".id_caja,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".fecha_inicio,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".fecha_fin,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".nombre_caja,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".fecha,"+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME+".total from "+CajerosConstantesFunciones.SCHEMA+"."+CajerosConstantesFunciones.TABLENAME;//+" as "+CajerosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCAJA= "id_caja";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String NOMBRECAJA= "nombre_caja";
    public static final String FECHA= "fecha";
    public static final String TOTAL= "total";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_NOMBRECAJA= "Nombre Caja";
		public static final String LABEL_NOMBRECAJA_LOWER= "Nombre Caja";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CAJA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CAJA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getCajerosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajerosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajerosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajerosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CajerosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CajerosConstantesFunciones.IDCAJA)) {sLabelColumna=CajerosConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(CajerosConstantesFunciones.FECHAINICIO)) {sLabelColumna=CajerosConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(CajerosConstantesFunciones.FECHAFIN)) {sLabelColumna=CajerosConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(CajerosConstantesFunciones.NOMBRECAJA)) {sLabelColumna=CajerosConstantesFunciones.LABEL_NOMBRECAJA;}
		if(sNombreColumna.equals(CajerosConstantesFunciones.FECHA)) {sLabelColumna=CajerosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(CajerosConstantesFunciones.TOTAL)) {sLabelColumna=CajerosConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getCajerosDescripcion(Cajeros cajeros) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajeros !=null/* && cajeros.getId()!=0*/) {
			if(cajeros.getId()!=null) {
				sDescripcion=cajeros.getId().toString();
			}//cajeroscajeros.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCajerosDescripcionDetallado(Cajeros cajeros) {
		String sDescripcion="";
			
		sDescripcion+=CajerosConstantesFunciones.ID+"=";
		sDescripcion+=cajeros.getId().toString()+",";
		sDescripcion+=CajerosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajeros.getVersionRow().toString()+",";
		sDescripcion+=CajerosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajeros.getid_empresa().toString()+",";
		sDescripcion+=CajerosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cajeros.getid_sucursal().toString()+",";
		sDescripcion+=CajerosConstantesFunciones.IDCAJA+"=";
		sDescripcion+=cajeros.getid_caja().toString()+",";
		sDescripcion+=CajerosConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=cajeros.getfecha_inicio().toString()+",";
		sDescripcion+=CajerosConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=cajeros.getfecha_fin().toString()+",";
		sDescripcion+=CajerosConstantesFunciones.NOMBRECAJA+"=";
		sDescripcion+=cajeros.getnombre_caja()+",";
		sDescripcion+=CajerosConstantesFunciones.FECHA+"=";
		sDescripcion+=cajeros.getfecha().toString()+",";
		sDescripcion+=CajerosConstantesFunciones.TOTAL+"=";
		sDescripcion+=cajeros.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajerosDescripcion(Cajeros cajeros,String sValor) throws Exception {			
		if(cajeros !=null) {
			//cajeroscajeros.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
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
		} else if(sNombreIndice.equals("BusquedaCajeros")) {
			sNombreIndice="Tipo=  Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCajeros(Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCajeros(Cajeros cajeros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajeros.setnombre_caja(cajeros.getnombre_caja().trim());
	}
	
	public static void quitarEspaciosCajeross(List<Cajeros> cajeross,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Cajeros cajeros: cajeross) {
			cajeros.setnombre_caja(cajeros.getnombre_caja().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajeros(Cajeros cajeros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajeros.getConCambioAuxiliar()) {
			cajeros.setIsDeleted(cajeros.getIsDeletedAuxiliar());	
			cajeros.setIsNew(cajeros.getIsNewAuxiliar());	
			cajeros.setIsChanged(cajeros.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajeros.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajeros.setIsDeletedAuxiliar(false);	
			cajeros.setIsNewAuxiliar(false);	
			cajeros.setIsChangedAuxiliar(false);
			
			cajeros.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajeross(List<Cajeros> cajeross,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Cajeros cajeros : cajeross) {
			if(conAsignarBase && cajeros.getConCambioAuxiliar()) {
				cajeros.setIsDeleted(cajeros.getIsDeletedAuxiliar());	
				cajeros.setIsNew(cajeros.getIsNewAuxiliar());	
				cajeros.setIsChanged(cajeros.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajeros.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajeros.setIsDeletedAuxiliar(false);	
				cajeros.setIsNewAuxiliar(false);	
				cajeros.setIsChangedAuxiliar(false);
				
				cajeros.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajeros(Cajeros cajeros,Boolean conEnteros) throws Exception  {
		cajeros.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajeross(List<Cajeros> cajeross,Boolean conEnteros) throws Exception  {
		
		for(Cajeros cajeros: cajeross) {
			cajeros.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajeros(List<Cajeros> cajeross,Cajeros cajerosAux) throws Exception  {
		CajerosConstantesFunciones.InicializarValoresCajeros(cajerosAux,true);
		
		for(Cajeros cajeros: cajeross) {
			if(cajeros.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cajerosAux.settotal(cajerosAux.gettotal()+cajeros.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajeros(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajerosConstantesFunciones.getArrayColumnasGlobalesCajeros(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajeros(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajerosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajerosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajerosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajerosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajeros(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Cajeros> cajeross,Cajeros cajeros,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Cajeros cajerosAux: cajeross) {
			if(cajerosAux!=null && cajeros!=null) {
				if((cajerosAux.getId()==null && cajeros.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajerosAux.getId()!=null && cajeros.getId()!=null){
					if(cajerosAux.getId().equals(cajeros.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajeros(List<Cajeros> cajeross) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(Cajeros cajeros: cajeross) {			
			if(cajeros.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=cajeros.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CajerosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(CajerosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajeros() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajerosConstantesFunciones.LABEL_ID, CajerosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajerosConstantesFunciones.LABEL_VERSIONROW, CajerosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajerosConstantesFunciones.LABEL_IDCAJA, CajerosConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajerosConstantesFunciones.LABEL_NOMBRECAJA, CajerosConstantesFunciones.NOMBRECAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajerosConstantesFunciones.LABEL_FECHA, CajerosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajerosConstantesFunciones.LABEL_TOTAL, CajerosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajeros() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajerosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajerosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajerosConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajerosConstantesFunciones.NOMBRECAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajerosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajerosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajeros() throws Exception  {
		return CajerosConstantesFunciones.getTiposSeleccionarCajeros(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajeros(Boolean conFk) throws Exception  {
		return CajerosConstantesFunciones.getTiposSeleccionarCajeros(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajeros(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajerosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajerosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajerosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CajerosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajerosConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(CajerosConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajerosConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(CajerosConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajerosConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(CajerosConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajerosConstantesFunciones.LABEL_NOMBRECAJA);
			reporte.setsDescripcion(CajerosConstantesFunciones.LABEL_NOMBRECAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajerosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CajerosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajerosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(CajerosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajeros(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajeros(Cajeros cajerosAux) throws Exception {
		
			cajerosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajerosAux.getEmpresa()));
			cajerosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajerosAux.getSucursal()));
			cajerosAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajerosAux.getCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajeros(List<Cajeros> cajerossTemp) throws Exception {
		for(Cajeros cajerosAux:cajerossTemp) {
			
			cajerosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajerosAux.getEmpresa()));
			cajerosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajerosAux.getSucursal()));
			cajerosAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajerosAux.getCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajeros(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Caja.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajeros(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajeros(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajerosConstantesFunciones.getClassesRelationshipsOfCajeros(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajeros(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajeros(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajerosConstantesFunciones.getClassesRelationshipsFromStringsOfCajeros(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajeros(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Cajeros cajeros,List<Cajeros> cajeross,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(Cajeros cajeros,List<Cajeros> cajeross) throws Exception {
		try	{			
			for(Cajeros cajerosLocal:cajeross) {
				if(cajerosLocal.getId().equals(cajeros.getId())) {
					cajerosLocal.setIsSelected(cajeros.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajeros(List<Cajeros> cajerossAux) throws Exception {
		//this.cajerossAux=cajerossAux;
		
		for(Cajeros cajerosAux:cajerossAux) {
			if(cajerosAux.getIsChanged()) {
				cajerosAux.setIsChanged(false);
			}		
			
			if(cajerosAux.getIsNew()) {
				cajerosAux.setIsNew(false);
			}	
			
			if(cajerosAux.getIsDeleted()) {
				cajerosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajeros(Cajeros cajerosAux) throws Exception {
		//this.cajerosAux=cajerosAux;
		
			if(cajerosAux.getIsChanged()) {
				cajerosAux.setIsChanged(false);
			}		
			
			if(cajerosAux.getIsNew()) {
				cajerosAux.setIsNew(false);
			}	
			
			if(cajerosAux.getIsDeleted()) {
				cajerosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Cajeros cajerosAsignar,Cajeros cajeros) throws Exception {
		cajerosAsignar.setId(cajeros.getId());	
		cajerosAsignar.setVersionRow(cajeros.getVersionRow());	
		cajerosAsignar.setid_caja(cajeros.getid_caja());
		cajerosAsignar.setcaja_descripcion(cajeros.getcaja_descripcion());	
		cajerosAsignar.setnombre_caja(cajeros.getnombre_caja());	
		cajerosAsignar.setfecha(cajeros.getfecha());	
		cajerosAsignar.settotal(cajeros.gettotal());	
	}
	
	public static void inicializarCajeros(Cajeros cajeros) throws Exception {
		try {
				cajeros.setId(0L);	
					
				cajeros.setid_caja(-1L);	
				cajeros.setnombre_caja("");	
				cajeros.setfecha(new Date());	
				cajeros.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajeros(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajerosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajerosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajerosConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajerosConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajerosConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajerosConstantesFunciones.LABEL_NOMBRECAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajerosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajerosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajeros(String sTipo,Row row,Workbook workbook,Cajeros cajeros,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeros.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeros.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeros.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeros.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeros.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeros.getnombre_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeros.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajeros.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajeros="";
	
	public String getsFinalQueryCajeros() {
		return this.sFinalQueryCajeros;
	}
	
	public void setsFinalQueryCajeros(String sFinalQueryCajeros) {
		this.sFinalQueryCajeros= sFinalQueryCajeros;
	}
	
	public Border resaltarSeleccionarCajeros=null;
	
	public Border setResaltarSeleccionarCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajeros= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajeros() {
		return this.resaltarSeleccionarCajeros;
	}
	
	public void setResaltarSeleccionarCajeros(Border borderResaltarSeleccionarCajeros) {
		this.resaltarSeleccionarCajeros= borderResaltarSeleccionarCajeros;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajeros=null;
	public Boolean mostraridCajeros=true;
	public Boolean activaridCajeros=true;

	public Border resaltarid_empresaCajeros=null;
	public Boolean mostrarid_empresaCajeros=true;
	public Boolean activarid_empresaCajeros=true;
	public Boolean cargarid_empresaCajeros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajeros=false;//ConEventDepend=true

	public Border resaltarid_sucursalCajeros=null;
	public Boolean mostrarid_sucursalCajeros=true;
	public Boolean activarid_sucursalCajeros=true;
	public Boolean cargarid_sucursalCajeros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCajeros=false;//ConEventDepend=true

	public Border resaltarid_cajaCajeros=null;
	public Boolean mostrarid_cajaCajeros=true;
	public Boolean activarid_cajaCajeros=false;
	public Boolean cargarid_cajaCajeros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaCajeros=false;//ConEventDepend=true

	public Border resaltarfecha_inicioCajeros=null;
	public Boolean mostrarfecha_inicioCajeros=true;
	public Boolean activarfecha_inicioCajeros=true;

	public Border resaltarfecha_finCajeros=null;
	public Boolean mostrarfecha_finCajeros=true;
	public Boolean activarfecha_finCajeros=true;

	public Border resaltarnombre_cajaCajeros=null;
	public Boolean mostrarnombre_cajaCajeros=true;
	public Boolean activarnombre_cajaCajeros=true;

	public Border resaltarfechaCajeros=null;
	public Boolean mostrarfechaCajeros=true;
	public Boolean activarfechaCajeros=true;

	public Border resaltartotalCajeros=null;
	public Boolean mostrartotalCajeros=true;
	public Boolean activartotalCajeros=true;

	
	

	public Border setResaltaridCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltaridCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajeros() {
		return this.resaltaridCajeros;
	}

	public void setResaltaridCajeros(Border borderResaltar) {
		this.resaltaridCajeros= borderResaltar;
	}

	public Boolean getMostraridCajeros() {
		return this.mostraridCajeros;
	}

	public void setMostraridCajeros(Boolean mostraridCajeros) {
		this.mostraridCajeros= mostraridCajeros;
	}

	public Boolean getActivaridCajeros() {
		return this.activaridCajeros;
	}

	public void setActivaridCajeros(Boolean activaridCajeros) {
		this.activaridCajeros= activaridCajeros;
	}

	public Border setResaltarid_empresaCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajeros() {
		return this.resaltarid_empresaCajeros;
	}

	public void setResaltarid_empresaCajeros(Border borderResaltar) {
		this.resaltarid_empresaCajeros= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajeros() {
		return this.mostrarid_empresaCajeros;
	}

	public void setMostrarid_empresaCajeros(Boolean mostrarid_empresaCajeros) {
		this.mostrarid_empresaCajeros= mostrarid_empresaCajeros;
	}

	public Boolean getActivarid_empresaCajeros() {
		return this.activarid_empresaCajeros;
	}

	public void setActivarid_empresaCajeros(Boolean activarid_empresaCajeros) {
		this.activarid_empresaCajeros= activarid_empresaCajeros;
	}

	public Boolean getCargarid_empresaCajeros() {
		return this.cargarid_empresaCajeros;
	}

	public void setCargarid_empresaCajeros(Boolean cargarid_empresaCajeros) {
		this.cargarid_empresaCajeros= cargarid_empresaCajeros;
	}

	public Border setResaltarid_sucursalCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCajeros() {
		return this.resaltarid_sucursalCajeros;
	}

	public void setResaltarid_sucursalCajeros(Border borderResaltar) {
		this.resaltarid_sucursalCajeros= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCajeros() {
		return this.mostrarid_sucursalCajeros;
	}

	public void setMostrarid_sucursalCajeros(Boolean mostrarid_sucursalCajeros) {
		this.mostrarid_sucursalCajeros= mostrarid_sucursalCajeros;
	}

	public Boolean getActivarid_sucursalCajeros() {
		return this.activarid_sucursalCajeros;
	}

	public void setActivarid_sucursalCajeros(Boolean activarid_sucursalCajeros) {
		this.activarid_sucursalCajeros= activarid_sucursalCajeros;
	}

	public Boolean getCargarid_sucursalCajeros() {
		return this.cargarid_sucursalCajeros;
	}

	public void setCargarid_sucursalCajeros(Boolean cargarid_sucursalCajeros) {
		this.cargarid_sucursalCajeros= cargarid_sucursalCajeros;
	}

	public Border setResaltarid_cajaCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltarid_cajaCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaCajeros() {
		return this.resaltarid_cajaCajeros;
	}

	public void setResaltarid_cajaCajeros(Border borderResaltar) {
		this.resaltarid_cajaCajeros= borderResaltar;
	}

	public Boolean getMostrarid_cajaCajeros() {
		return this.mostrarid_cajaCajeros;
	}

	public void setMostrarid_cajaCajeros(Boolean mostrarid_cajaCajeros) {
		this.mostrarid_cajaCajeros= mostrarid_cajaCajeros;
	}

	public Boolean getActivarid_cajaCajeros() {
		return this.activarid_cajaCajeros;
	}

	public void setActivarid_cajaCajeros(Boolean activarid_cajaCajeros) {
		this.activarid_cajaCajeros= activarid_cajaCajeros;
	}

	public Boolean getCargarid_cajaCajeros() {
		return this.cargarid_cajaCajeros;
	}

	public void setCargarid_cajaCajeros(Boolean cargarid_cajaCajeros) {
		this.cargarid_cajaCajeros= cargarid_cajaCajeros;
	}

	public Border setResaltarfecha_inicioCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioCajeros() {
		return this.resaltarfecha_inicioCajeros;
	}

	public void setResaltarfecha_inicioCajeros(Border borderResaltar) {
		this.resaltarfecha_inicioCajeros= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioCajeros() {
		return this.mostrarfecha_inicioCajeros;
	}

	public void setMostrarfecha_inicioCajeros(Boolean mostrarfecha_inicioCajeros) {
		this.mostrarfecha_inicioCajeros= mostrarfecha_inicioCajeros;
	}

	public Boolean getActivarfecha_inicioCajeros() {
		return this.activarfecha_inicioCajeros;
	}

	public void setActivarfecha_inicioCajeros(Boolean activarfecha_inicioCajeros) {
		this.activarfecha_inicioCajeros= activarfecha_inicioCajeros;
	}

	public Border setResaltarfecha_finCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltarfecha_finCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finCajeros() {
		return this.resaltarfecha_finCajeros;
	}

	public void setResaltarfecha_finCajeros(Border borderResaltar) {
		this.resaltarfecha_finCajeros= borderResaltar;
	}

	public Boolean getMostrarfecha_finCajeros() {
		return this.mostrarfecha_finCajeros;
	}

	public void setMostrarfecha_finCajeros(Boolean mostrarfecha_finCajeros) {
		this.mostrarfecha_finCajeros= mostrarfecha_finCajeros;
	}

	public Boolean getActivarfecha_finCajeros() {
		return this.activarfecha_finCajeros;
	}

	public void setActivarfecha_finCajeros(Boolean activarfecha_finCajeros) {
		this.activarfecha_finCajeros= activarfecha_finCajeros;
	}

	public Border setResaltarnombre_cajaCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltarnombre_cajaCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cajaCajeros() {
		return this.resaltarnombre_cajaCajeros;
	}

	public void setResaltarnombre_cajaCajeros(Border borderResaltar) {
		this.resaltarnombre_cajaCajeros= borderResaltar;
	}

	public Boolean getMostrarnombre_cajaCajeros() {
		return this.mostrarnombre_cajaCajeros;
	}

	public void setMostrarnombre_cajaCajeros(Boolean mostrarnombre_cajaCajeros) {
		this.mostrarnombre_cajaCajeros= mostrarnombre_cajaCajeros;
	}

	public Boolean getActivarnombre_cajaCajeros() {
		return this.activarnombre_cajaCajeros;
	}

	public void setActivarnombre_cajaCajeros(Boolean activarnombre_cajaCajeros) {
		this.activarnombre_cajaCajeros= activarnombre_cajaCajeros;
	}

	public Border setResaltarfechaCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltarfechaCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCajeros() {
		return this.resaltarfechaCajeros;
	}

	public void setResaltarfechaCajeros(Border borderResaltar) {
		this.resaltarfechaCajeros= borderResaltar;
	}

	public Boolean getMostrarfechaCajeros() {
		return this.mostrarfechaCajeros;
	}

	public void setMostrarfechaCajeros(Boolean mostrarfechaCajeros) {
		this.mostrarfechaCajeros= mostrarfechaCajeros;
	}

	public Boolean getActivarfechaCajeros() {
		return this.activarfechaCajeros;
	}

	public void setActivarfechaCajeros(Boolean activarfechaCajeros) {
		this.activarfechaCajeros= activarfechaCajeros;
	}

	public Border setResaltartotalCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajerosBeanSwingJInternalFrame.jTtoolBarCajeros.setBorder(borderResaltar);
		
		this.resaltartotalCajeros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalCajeros() {
		return this.resaltartotalCajeros;
	}

	public void setResaltartotalCajeros(Border borderResaltar) {
		this.resaltartotalCajeros= borderResaltar;
	}

	public Boolean getMostrartotalCajeros() {
		return this.mostrartotalCajeros;
	}

	public void setMostrartotalCajeros(Boolean mostrartotalCajeros) {
		this.mostrartotalCajeros= mostrartotalCajeros;
	}

	public Boolean getActivartotalCajeros() {
		return this.activartotalCajeros;
	}

	public void setActivartotalCajeros(Boolean activartotalCajeros) {
		this.activartotalCajeros= activartotalCajeros;
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
		
		
		this.setMostraridCajeros(esInicial);
		this.setMostrarid_empresaCajeros(esInicial);
		this.setMostrarid_sucursalCajeros(esInicial);
		this.setMostrarid_cajaCajeros(esInicial);
		this.setMostrarfecha_inicioCajeros(esInicial);
		this.setMostrarfecha_finCajeros(esInicial);
		this.setMostrarnombre_cajaCajeros(esInicial);
		this.setMostrarfechaCajeros(esInicial);
		this.setMostrartotalCajeros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajerosConstantesFunciones.ID)) {
				this.setMostraridCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.NOMBRECAJA)) {
				this.setMostrarnombre_cajaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHA)) {
				this.setMostrarfechaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.TOTAL)) {
				this.setMostrartotalCajeros(esAsigna);
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
		
		
		this.setActivaridCajeros(esInicial);
		this.setActivarid_empresaCajeros(esInicial);
		this.setActivarid_sucursalCajeros(esInicial);
		this.setActivarid_cajaCajeros(esInicial);
		this.setActivarfecha_inicioCajeros(esInicial);
		this.setActivarfecha_finCajeros(esInicial);
		this.setActivarnombre_cajaCajeros(esInicial);
		this.setActivarfechaCajeros(esInicial);
		this.setActivartotalCajeros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajerosConstantesFunciones.ID)) {
				this.setActivaridCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.NOMBRECAJA)) {
				this.setActivarnombre_cajaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHA)) {
				this.setActivarfechaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.TOTAL)) {
				this.setActivartotalCajeros(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajeros(esInicial);
		this.setResaltarid_empresaCajeros(esInicial);
		this.setResaltarid_sucursalCajeros(esInicial);
		this.setResaltarid_cajaCajeros(esInicial);
		this.setResaltarfecha_inicioCajeros(esInicial);
		this.setResaltarfecha_finCajeros(esInicial);
		this.setResaltarnombre_cajaCajeros(esInicial);
		this.setResaltarfechaCajeros(esInicial);
		this.setResaltartotalCajeros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajerosConstantesFunciones.ID)) {
				this.setResaltaridCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.NOMBRECAJA)) {
				this.setResaltarnombre_cajaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.FECHA)) {
				this.setResaltarfechaCajeros(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajerosConstantesFunciones.TOTAL)) {
				this.setResaltartotalCajeros(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCajerosCajeros=true;

	public Boolean getMostrarBusquedaCajerosCajeros() {
		return this.mostrarBusquedaCajerosCajeros;
	}

	public void setMostrarBusquedaCajerosCajeros(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCajerosCajeros= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCajerosCajeros=true;

	public Boolean getActivarBusquedaCajerosCajeros() {
		return this.activarBusquedaCajerosCajeros;
	}

	public void setActivarBusquedaCajerosCajeros(Boolean habilitarResaltar) {
		this.activarBusquedaCajerosCajeros= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCajerosCajeros=null;

	public Border getResaltarBusquedaCajerosCajeros() {
		return this.resaltarBusquedaCajerosCajeros;
	}

	public void setResaltarBusquedaCajerosCajeros(Border borderResaltar) {
		this.resaltarBusquedaCajerosCajeros= borderResaltar;
	}

	public void setResaltarBusquedaCajerosCajeros(ParametroGeneralUsuario parametroGeneralUsuario/*CajerosBeanSwingJInternalFrame cajerosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCajerosCajeros= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}