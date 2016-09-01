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
package com.bydan.erp.cartera.util.report;

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

import com.bydan.erp.cartera.resources.general.AuxiliarGeneral;

import com.bydan.erp.cartera.util.report.ProcesoRecapConstantesFunciones;
import com.bydan.erp.cartera.util.report.ProcesoRecapParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.ProcesoRecapParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoRecapConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoRecap";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoRecap"+ProcesoRecapConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoRecapHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoRecapHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoRecapConstantesFunciones.SCHEMA+"_"+ProcesoRecapConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoRecapHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoRecapConstantesFunciones.SCHEMA+"_"+ProcesoRecapConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoRecapConstantesFunciones.SCHEMA+"_"+ProcesoRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoRecapHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoRecapConstantesFunciones.SCHEMA+"_"+ProcesoRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoRecapConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoRecapHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoRecapConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoRecapHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoRecapConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoRecapConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoRecapConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoRecapConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoRecapConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Recapes";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Recap";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Recap";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoRecap";
	public static final String OBJECTNAME="procesorecap";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="proceso_recap";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesorecap from "+ProcesoRecapConstantesFunciones.SPERSISTENCENAME+" procesorecap";
	public static String QUERYSELECTNATIVE="select "+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".id,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".version_row,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".id_ejercicio,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".fecha_emision_desde,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".numero_pre_impreso,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".nombre_transaccion,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".fecha_emision,"+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME+".monto_mone_local from "+ProcesoRecapConstantesFunciones.SCHEMA+"."+ProcesoRecapConstantesFunciones.TABLENAME;//+" as "+ProcesoRecapConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String NOMBRETRANSACCION= "nombre_transaccion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String MONTOMONELOCAL= "monto_mone_local";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_NOMBRETRANSACCION= "Nombre Transaccion";
		public static final String LABEL_NOMBRETRANSACCION_LOWER= "Nombre Transaccion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_MONTOMONELOCAL= "Monto Mone Local";
		public static final String LABEL_MONTOMONELOCAL_LOWER= "Monto Mone Local";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getProcesoRecapLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.IDEJERCICIO)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.NOMBRETRANSACCION)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_NOMBRETRANSACCION;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.FECHAEMISION)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ProcesoRecapConstantesFunciones.MONTOMONELOCAL)) {sLabelColumna=ProcesoRecapConstantesFunciones.LABEL_MONTOMONELOCAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoRecapDescripcion(ProcesoRecap procesorecap) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesorecap !=null/* && procesorecap.getId()!=0*/) {
			if(procesorecap.getId()!=null) {
				sDescripcion=procesorecap.getId().toString();
			}//procesorecapprocesorecap.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoRecapDescripcionDetallado(ProcesoRecap procesorecap) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoRecapConstantesFunciones.ID+"=";
		sDescripcion+=procesorecap.getId().toString()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesorecap.getVersionRow().toString()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesorecap.getid_empresa().toString()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesorecap.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=procesorecap.getid_ejercicio().toString()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=procesorecap.getfecha_emision_desde().toString()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=procesorecap.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=procesorecap.getnombre_completo_cliente()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=procesorecap.getnumero_pre_impreso()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.NOMBRETRANSACCION+"=";
		sDescripcion+=procesorecap.getnombre_transaccion()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=procesorecap.getfecha_emision().toString()+",";
		sDescripcion+=ProcesoRecapConstantesFunciones.MONTOMONELOCAL+"=";
		sDescripcion+=procesorecap.getmonto_mone_local().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoRecapDescripcion(ProcesoRecap procesorecap,String sValor) throws Exception {			
		if(procesorecap !=null) {
			//procesorecapprocesorecap.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoRecap")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
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

	public static String getDetalleIndiceBusquedaProcesoRecap(Long id_ejercicio,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoRecap(ProcesoRecap procesorecap,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesorecap.setnombre_completo_cliente(procesorecap.getnombre_completo_cliente().trim());
		procesorecap.setnumero_pre_impreso(procesorecap.getnumero_pre_impreso().trim());
		procesorecap.setnombre_transaccion(procesorecap.getnombre_transaccion().trim());
	}
	
	public static void quitarEspaciosProcesoRecaps(List<ProcesoRecap> procesorecaps,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoRecap procesorecap: procesorecaps) {
			procesorecap.setnombre_completo_cliente(procesorecap.getnombre_completo_cliente().trim());
			procesorecap.setnumero_pre_impreso(procesorecap.getnumero_pre_impreso().trim());
			procesorecap.setnombre_transaccion(procesorecap.getnombre_transaccion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoRecap(ProcesoRecap procesorecap,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesorecap.getConCambioAuxiliar()) {
			procesorecap.setIsDeleted(procesorecap.getIsDeletedAuxiliar());	
			procesorecap.setIsNew(procesorecap.getIsNewAuxiliar());	
			procesorecap.setIsChanged(procesorecap.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesorecap.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesorecap.setIsDeletedAuxiliar(false);	
			procesorecap.setIsNewAuxiliar(false);	
			procesorecap.setIsChangedAuxiliar(false);
			
			procesorecap.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoRecaps(List<ProcesoRecap> procesorecaps,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoRecap procesorecap : procesorecaps) {
			if(conAsignarBase && procesorecap.getConCambioAuxiliar()) {
				procesorecap.setIsDeleted(procesorecap.getIsDeletedAuxiliar());	
				procesorecap.setIsNew(procesorecap.getIsNewAuxiliar());	
				procesorecap.setIsChanged(procesorecap.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesorecap.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesorecap.setIsDeletedAuxiliar(false);	
				procesorecap.setIsNewAuxiliar(false);	
				procesorecap.setIsChangedAuxiliar(false);
				
				procesorecap.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoRecap(ProcesoRecap procesorecap,Boolean conEnteros) throws Exception  {
		procesorecap.setmonto_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoRecaps(List<ProcesoRecap> procesorecaps,Boolean conEnteros) throws Exception  {
		
		for(ProcesoRecap procesorecap: procesorecaps) {
			procesorecap.setmonto_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoRecap(List<ProcesoRecap> procesorecaps,ProcesoRecap procesorecapAux) throws Exception  {
		ProcesoRecapConstantesFunciones.InicializarValoresProcesoRecap(procesorecapAux,true);
		
		for(ProcesoRecap procesorecap: procesorecaps) {
			if(procesorecap.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesorecapAux.setmonto_mone_local(procesorecapAux.getmonto_mone_local()+procesorecap.getmonto_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoRecap(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoRecapConstantesFunciones.getArrayColumnasGlobalesProcesoRecap(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoRecap(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoRecapConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoRecapConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoRecapConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoRecapConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoRecapConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoRecapConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoRecap(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoRecap> procesorecaps,ProcesoRecap procesorecap,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoRecap procesorecapAux: procesorecaps) {
			if(procesorecapAux!=null && procesorecap!=null) {
				if((procesorecapAux.getId()==null && procesorecap.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesorecapAux.getId()!=null && procesorecap.getId()!=null){
					if(procesorecapAux.getId().equals(procesorecap.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoRecap(List<ProcesoRecap> procesorecaps) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double monto_mone_localTotal=0.0;
	
		for(ProcesoRecap procesorecap: procesorecaps) {			
			if(procesorecap.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			monto_mone_localTotal+=procesorecap.getmonto_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoRecapConstantesFunciones.MONTOMONELOCAL);
		datoGeneral.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_MONTOMONELOCAL);
		datoGeneral.setdValorDouble(monto_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoRecap() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoRecap() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoRecap() throws Exception  {
		return ProcesoRecapConstantesFunciones.getTiposSeleccionarProcesoRecap(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoRecap(Boolean conFk) throws Exception  {
		return ProcesoRecapConstantesFunciones.getTiposSeleccionarProcesoRecap(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoRecap(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_NOMBRETRANSACCION);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_NOMBRETRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoRecapConstantesFunciones.LABEL_MONTOMONELOCAL);
			reporte.setsDescripcion(ProcesoRecapConstantesFunciones.LABEL_MONTOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoRecap(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoRecap(ProcesoRecap procesorecapAux) throws Exception {
		
			procesorecapAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesorecapAux.getEmpresa()));
			procesorecapAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesorecapAux.getSucursal()));
			procesorecapAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesorecapAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoRecap(List<ProcesoRecap> procesorecapsTemp) throws Exception {
		for(ProcesoRecap procesorecapAux:procesorecapsTemp) {
			
			procesorecapAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesorecapAux.getEmpresa()));
			procesorecapAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesorecapAux.getSucursal()));
			procesorecapAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(procesorecapAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoRecapConstantesFunciones.getClassesRelationshipsOfProcesoRecap(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoRecapConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoRecap(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoRecap(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoRecap procesorecap,List<ProcesoRecap> procesorecaps,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoRecap procesorecap,List<ProcesoRecap> procesorecaps) throws Exception {
		try	{			
			for(ProcesoRecap procesorecapLocal:procesorecaps) {
				if(procesorecapLocal.getId().equals(procesorecap.getId())) {
					procesorecapLocal.setIsSelected(procesorecap.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoRecap(List<ProcesoRecap> procesorecapsAux) throws Exception {
		//this.procesorecapsAux=procesorecapsAux;
		
		for(ProcesoRecap procesorecapAux:procesorecapsAux) {
			if(procesorecapAux.getIsChanged()) {
				procesorecapAux.setIsChanged(false);
			}		
			
			if(procesorecapAux.getIsNew()) {
				procesorecapAux.setIsNew(false);
			}	
			
			if(procesorecapAux.getIsDeleted()) {
				procesorecapAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoRecap(ProcesoRecap procesorecapAux) throws Exception {
		//this.procesorecapAux=procesorecapAux;
		
			if(procesorecapAux.getIsChanged()) {
				procesorecapAux.setIsChanged(false);
			}		
			
			if(procesorecapAux.getIsNew()) {
				procesorecapAux.setIsNew(false);
			}	
			
			if(procesorecapAux.getIsDeleted()) {
				procesorecapAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoRecap procesorecapAsignar,ProcesoRecap procesorecap) throws Exception {
		procesorecapAsignar.setId(procesorecap.getId());	
		procesorecapAsignar.setVersionRow(procesorecap.getVersionRow());	
		procesorecapAsignar.setnombre_completo_cliente(procesorecap.getnombre_completo_cliente());	
		procesorecapAsignar.setnumero_pre_impreso(procesorecap.getnumero_pre_impreso());	
		procesorecapAsignar.setnombre_transaccion(procesorecap.getnombre_transaccion());	
		procesorecapAsignar.setfecha_emision(procesorecap.getfecha_emision());	
		procesorecapAsignar.setmonto_mone_local(procesorecap.getmonto_mone_local());	
	}
	
	public static void inicializarProcesoRecap(ProcesoRecap procesorecap) throws Exception {
		try {
				procesorecap.setId(0L);	
					
				procesorecap.setnombre_completo_cliente("");	
				procesorecap.setnumero_pre_impreso("");	
				procesorecap.setnombre_transaccion("");	
				procesorecap.setfecha_emision(new Date());	
				procesorecap.setmonto_mone_local(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoRecap(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_NOMBRETRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoRecapConstantesFunciones.LABEL_MONTOMONELOCAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoRecap(String sTipo,Row row,Workbook workbook,ProcesoRecap procesorecap,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getnombre_transaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesorecap.getmonto_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoRecap="";
	
	public String getsFinalQueryProcesoRecap() {
		return this.sFinalQueryProcesoRecap;
	}
	
	public void setsFinalQueryProcesoRecap(String sFinalQueryProcesoRecap) {
		this.sFinalQueryProcesoRecap= sFinalQueryProcesoRecap;
	}
	
	public Border resaltarSeleccionarProcesoRecap=null;
	
	public Border setResaltarSeleccionarProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoRecap= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoRecap() {
		return this.resaltarSeleccionarProcesoRecap;
	}
	
	public void setResaltarSeleccionarProcesoRecap(Border borderResaltarSeleccionarProcesoRecap) {
		this.resaltarSeleccionarProcesoRecap= borderResaltarSeleccionarProcesoRecap;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoRecap=null;
	public Boolean mostraridProcesoRecap=true;
	public Boolean activaridProcesoRecap=true;

	public Border resaltarid_empresaProcesoRecap=null;
	public Boolean mostrarid_empresaProcesoRecap=true;
	public Boolean activarid_empresaProcesoRecap=true;
	public Boolean cargarid_empresaProcesoRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoRecap=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoRecap=null;
	public Boolean mostrarid_sucursalProcesoRecap=true;
	public Boolean activarid_sucursalProcesoRecap=true;
	public Boolean cargarid_sucursalProcesoRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoRecap=false;//ConEventDepend=true

	public Border resaltarid_ejercicioProcesoRecap=null;
	public Boolean mostrarid_ejercicioProcesoRecap=true;
	public Boolean activarid_ejercicioProcesoRecap=true;
	public Boolean cargarid_ejercicioProcesoRecap=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioProcesoRecap=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeProcesoRecap=null;
	public Boolean mostrarfecha_emision_desdeProcesoRecap=true;
	public Boolean activarfecha_emision_desdeProcesoRecap=true;

	public Border resaltarfecha_emision_hastaProcesoRecap=null;
	public Boolean mostrarfecha_emision_hastaProcesoRecap=true;
	public Boolean activarfecha_emision_hastaProcesoRecap=true;

	public Border resaltarnombre_completo_clienteProcesoRecap=null;
	public Boolean mostrarnombre_completo_clienteProcesoRecap=true;
	public Boolean activarnombre_completo_clienteProcesoRecap=true;

	public Border resaltarnumero_pre_impresoProcesoRecap=null;
	public Boolean mostrarnumero_pre_impresoProcesoRecap=true;
	public Boolean activarnumero_pre_impresoProcesoRecap=true;

	public Border resaltarnombre_transaccionProcesoRecap=null;
	public Boolean mostrarnombre_transaccionProcesoRecap=true;
	public Boolean activarnombre_transaccionProcesoRecap=true;

	public Border resaltarfecha_emisionProcesoRecap=null;
	public Boolean mostrarfecha_emisionProcesoRecap=true;
	public Boolean activarfecha_emisionProcesoRecap=true;

	public Border resaltarmonto_mone_localProcesoRecap=null;
	public Boolean mostrarmonto_mone_localProcesoRecap=true;
	public Boolean activarmonto_mone_localProcesoRecap=true;

	
	

	public Border setResaltaridProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltaridProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoRecap() {
		return this.resaltaridProcesoRecap;
	}

	public void setResaltaridProcesoRecap(Border borderResaltar) {
		this.resaltaridProcesoRecap= borderResaltar;
	}

	public Boolean getMostraridProcesoRecap() {
		return this.mostraridProcesoRecap;
	}

	public void setMostraridProcesoRecap(Boolean mostraridProcesoRecap) {
		this.mostraridProcesoRecap= mostraridProcesoRecap;
	}

	public Boolean getActivaridProcesoRecap() {
		return this.activaridProcesoRecap;
	}

	public void setActivaridProcesoRecap(Boolean activaridProcesoRecap) {
		this.activaridProcesoRecap= activaridProcesoRecap;
	}

	public Border setResaltarid_empresaProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoRecap() {
		return this.resaltarid_empresaProcesoRecap;
	}

	public void setResaltarid_empresaProcesoRecap(Border borderResaltar) {
		this.resaltarid_empresaProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoRecap() {
		return this.mostrarid_empresaProcesoRecap;
	}

	public void setMostrarid_empresaProcesoRecap(Boolean mostrarid_empresaProcesoRecap) {
		this.mostrarid_empresaProcesoRecap= mostrarid_empresaProcesoRecap;
	}

	public Boolean getActivarid_empresaProcesoRecap() {
		return this.activarid_empresaProcesoRecap;
	}

	public void setActivarid_empresaProcesoRecap(Boolean activarid_empresaProcesoRecap) {
		this.activarid_empresaProcesoRecap= activarid_empresaProcesoRecap;
	}

	public Boolean getCargarid_empresaProcesoRecap() {
		return this.cargarid_empresaProcesoRecap;
	}

	public void setCargarid_empresaProcesoRecap(Boolean cargarid_empresaProcesoRecap) {
		this.cargarid_empresaProcesoRecap= cargarid_empresaProcesoRecap;
	}

	public Border setResaltarid_sucursalProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoRecap() {
		return this.resaltarid_sucursalProcesoRecap;
	}

	public void setResaltarid_sucursalProcesoRecap(Border borderResaltar) {
		this.resaltarid_sucursalProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoRecap() {
		return this.mostrarid_sucursalProcesoRecap;
	}

	public void setMostrarid_sucursalProcesoRecap(Boolean mostrarid_sucursalProcesoRecap) {
		this.mostrarid_sucursalProcesoRecap= mostrarid_sucursalProcesoRecap;
	}

	public Boolean getActivarid_sucursalProcesoRecap() {
		return this.activarid_sucursalProcesoRecap;
	}

	public void setActivarid_sucursalProcesoRecap(Boolean activarid_sucursalProcesoRecap) {
		this.activarid_sucursalProcesoRecap= activarid_sucursalProcesoRecap;
	}

	public Boolean getCargarid_sucursalProcesoRecap() {
		return this.cargarid_sucursalProcesoRecap;
	}

	public void setCargarid_sucursalProcesoRecap(Boolean cargarid_sucursalProcesoRecap) {
		this.cargarid_sucursalProcesoRecap= cargarid_sucursalProcesoRecap;
	}

	public Border setResaltarid_ejercicioProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioProcesoRecap() {
		return this.resaltarid_ejercicioProcesoRecap;
	}

	public void setResaltarid_ejercicioProcesoRecap(Border borderResaltar) {
		this.resaltarid_ejercicioProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioProcesoRecap() {
		return this.mostrarid_ejercicioProcesoRecap;
	}

	public void setMostrarid_ejercicioProcesoRecap(Boolean mostrarid_ejercicioProcesoRecap) {
		this.mostrarid_ejercicioProcesoRecap= mostrarid_ejercicioProcesoRecap;
	}

	public Boolean getActivarid_ejercicioProcesoRecap() {
		return this.activarid_ejercicioProcesoRecap;
	}

	public void setActivarid_ejercicioProcesoRecap(Boolean activarid_ejercicioProcesoRecap) {
		this.activarid_ejercicioProcesoRecap= activarid_ejercicioProcesoRecap;
	}

	public Boolean getCargarid_ejercicioProcesoRecap() {
		return this.cargarid_ejercicioProcesoRecap;
	}

	public void setCargarid_ejercicioProcesoRecap(Boolean cargarid_ejercicioProcesoRecap) {
		this.cargarid_ejercicioProcesoRecap= cargarid_ejercicioProcesoRecap;
	}

	public Border setResaltarfecha_emision_desdeProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeProcesoRecap() {
		return this.resaltarfecha_emision_desdeProcesoRecap;
	}

	public void setResaltarfecha_emision_desdeProcesoRecap(Border borderResaltar) {
		this.resaltarfecha_emision_desdeProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeProcesoRecap() {
		return this.mostrarfecha_emision_desdeProcesoRecap;
	}

	public void setMostrarfecha_emision_desdeProcesoRecap(Boolean mostrarfecha_emision_desdeProcesoRecap) {
		this.mostrarfecha_emision_desdeProcesoRecap= mostrarfecha_emision_desdeProcesoRecap;
	}

	public Boolean getActivarfecha_emision_desdeProcesoRecap() {
		return this.activarfecha_emision_desdeProcesoRecap;
	}

	public void setActivarfecha_emision_desdeProcesoRecap(Boolean activarfecha_emision_desdeProcesoRecap) {
		this.activarfecha_emision_desdeProcesoRecap= activarfecha_emision_desdeProcesoRecap;
	}

	public Border setResaltarfecha_emision_hastaProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaProcesoRecap() {
		return this.resaltarfecha_emision_hastaProcesoRecap;
	}

	public void setResaltarfecha_emision_hastaProcesoRecap(Border borderResaltar) {
		this.resaltarfecha_emision_hastaProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaProcesoRecap() {
		return this.mostrarfecha_emision_hastaProcesoRecap;
	}

	public void setMostrarfecha_emision_hastaProcesoRecap(Boolean mostrarfecha_emision_hastaProcesoRecap) {
		this.mostrarfecha_emision_hastaProcesoRecap= mostrarfecha_emision_hastaProcesoRecap;
	}

	public Boolean getActivarfecha_emision_hastaProcesoRecap() {
		return this.activarfecha_emision_hastaProcesoRecap;
	}

	public void setActivarfecha_emision_hastaProcesoRecap(Boolean activarfecha_emision_hastaProcesoRecap) {
		this.activarfecha_emision_hastaProcesoRecap= activarfecha_emision_hastaProcesoRecap;
	}

	public Border setResaltarnombre_completo_clienteProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteProcesoRecap() {
		return this.resaltarnombre_completo_clienteProcesoRecap;
	}

	public void setResaltarnombre_completo_clienteProcesoRecap(Border borderResaltar) {
		this.resaltarnombre_completo_clienteProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteProcesoRecap() {
		return this.mostrarnombre_completo_clienteProcesoRecap;
	}

	public void setMostrarnombre_completo_clienteProcesoRecap(Boolean mostrarnombre_completo_clienteProcesoRecap) {
		this.mostrarnombre_completo_clienteProcesoRecap= mostrarnombre_completo_clienteProcesoRecap;
	}

	public Boolean getActivarnombre_completo_clienteProcesoRecap() {
		return this.activarnombre_completo_clienteProcesoRecap;
	}

	public void setActivarnombre_completo_clienteProcesoRecap(Boolean activarnombre_completo_clienteProcesoRecap) {
		this.activarnombre_completo_clienteProcesoRecap= activarnombre_completo_clienteProcesoRecap;
	}

	public Border setResaltarnumero_pre_impresoProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoProcesoRecap() {
		return this.resaltarnumero_pre_impresoProcesoRecap;
	}

	public void setResaltarnumero_pre_impresoProcesoRecap(Border borderResaltar) {
		this.resaltarnumero_pre_impresoProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoProcesoRecap() {
		return this.mostrarnumero_pre_impresoProcesoRecap;
	}

	public void setMostrarnumero_pre_impresoProcesoRecap(Boolean mostrarnumero_pre_impresoProcesoRecap) {
		this.mostrarnumero_pre_impresoProcesoRecap= mostrarnumero_pre_impresoProcesoRecap;
	}

	public Boolean getActivarnumero_pre_impresoProcesoRecap() {
		return this.activarnumero_pre_impresoProcesoRecap;
	}

	public void setActivarnumero_pre_impresoProcesoRecap(Boolean activarnumero_pre_impresoProcesoRecap) {
		this.activarnumero_pre_impresoProcesoRecap= activarnumero_pre_impresoProcesoRecap;
	}

	public Border setResaltarnombre_transaccionProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarnombre_transaccionProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_transaccionProcesoRecap() {
		return this.resaltarnombre_transaccionProcesoRecap;
	}

	public void setResaltarnombre_transaccionProcesoRecap(Border borderResaltar) {
		this.resaltarnombre_transaccionProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarnombre_transaccionProcesoRecap() {
		return this.mostrarnombre_transaccionProcesoRecap;
	}

	public void setMostrarnombre_transaccionProcesoRecap(Boolean mostrarnombre_transaccionProcesoRecap) {
		this.mostrarnombre_transaccionProcesoRecap= mostrarnombre_transaccionProcesoRecap;
	}

	public Boolean getActivarnombre_transaccionProcesoRecap() {
		return this.activarnombre_transaccionProcesoRecap;
	}

	public void setActivarnombre_transaccionProcesoRecap(Boolean activarnombre_transaccionProcesoRecap) {
		this.activarnombre_transaccionProcesoRecap= activarnombre_transaccionProcesoRecap;
	}

	public Border setResaltarfecha_emisionProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionProcesoRecap() {
		return this.resaltarfecha_emisionProcesoRecap;
	}

	public void setResaltarfecha_emisionProcesoRecap(Border borderResaltar) {
		this.resaltarfecha_emisionProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionProcesoRecap() {
		return this.mostrarfecha_emisionProcesoRecap;
	}

	public void setMostrarfecha_emisionProcesoRecap(Boolean mostrarfecha_emisionProcesoRecap) {
		this.mostrarfecha_emisionProcesoRecap= mostrarfecha_emisionProcesoRecap;
	}

	public Boolean getActivarfecha_emisionProcesoRecap() {
		return this.activarfecha_emisionProcesoRecap;
	}

	public void setActivarfecha_emisionProcesoRecap(Boolean activarfecha_emisionProcesoRecap) {
		this.activarfecha_emisionProcesoRecap= activarfecha_emisionProcesoRecap;
	}

	public Border setResaltarmonto_mone_localProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesorecapBeanSwingJInternalFrame.jTtoolBarProcesoRecap.setBorder(borderResaltar);
		
		this.resaltarmonto_mone_localProcesoRecap= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_mone_localProcesoRecap() {
		return this.resaltarmonto_mone_localProcesoRecap;
	}

	public void setResaltarmonto_mone_localProcesoRecap(Border borderResaltar) {
		this.resaltarmonto_mone_localProcesoRecap= borderResaltar;
	}

	public Boolean getMostrarmonto_mone_localProcesoRecap() {
		return this.mostrarmonto_mone_localProcesoRecap;
	}

	public void setMostrarmonto_mone_localProcesoRecap(Boolean mostrarmonto_mone_localProcesoRecap) {
		this.mostrarmonto_mone_localProcesoRecap= mostrarmonto_mone_localProcesoRecap;
	}

	public Boolean getActivarmonto_mone_localProcesoRecap() {
		return this.activarmonto_mone_localProcesoRecap;
	}

	public void setActivarmonto_mone_localProcesoRecap(Boolean activarmonto_mone_localProcesoRecap) {
		this.activarmonto_mone_localProcesoRecap= activarmonto_mone_localProcesoRecap;
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
		
		
		this.setMostraridProcesoRecap(esInicial);
		this.setMostrarid_empresaProcesoRecap(esInicial);
		this.setMostrarid_sucursalProcesoRecap(esInicial);
		this.setMostrarid_ejercicioProcesoRecap(esInicial);
		this.setMostrarfecha_emision_desdeProcesoRecap(esInicial);
		this.setMostrarfecha_emision_hastaProcesoRecap(esInicial);
		this.setMostrarnombre_completo_clienteProcesoRecap(esInicial);
		this.setMostrarnumero_pre_impresoProcesoRecap(esInicial);
		this.setMostrarnombre_transaccionProcesoRecap(esInicial);
		this.setMostrarfecha_emisionProcesoRecap(esInicial);
		this.setMostrarmonto_mone_localProcesoRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.ID)) {
				this.setMostraridProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NOMBRETRANSACCION)) {
				this.setMostrarnombre_transaccionProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.MONTOMONELOCAL)) {
				this.setMostrarmonto_mone_localProcesoRecap(esAsigna);
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
		
		
		this.setActivaridProcesoRecap(esInicial);
		this.setActivarid_empresaProcesoRecap(esInicial);
		this.setActivarid_sucursalProcesoRecap(esInicial);
		this.setActivarid_ejercicioProcesoRecap(esInicial);
		this.setActivarfecha_emision_desdeProcesoRecap(esInicial);
		this.setActivarfecha_emision_hastaProcesoRecap(esInicial);
		this.setActivarnombre_completo_clienteProcesoRecap(esInicial);
		this.setActivarnumero_pre_impresoProcesoRecap(esInicial);
		this.setActivarnombre_transaccionProcesoRecap(esInicial);
		this.setActivarfecha_emisionProcesoRecap(esInicial);
		this.setActivarmonto_mone_localProcesoRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.ID)) {
				this.setActivaridProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NOMBRETRANSACCION)) {
				this.setActivarnombre_transaccionProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.MONTOMONELOCAL)) {
				this.setActivarmonto_mone_localProcesoRecap(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoRecap(esInicial);
		this.setResaltarid_empresaProcesoRecap(esInicial);
		this.setResaltarid_sucursalProcesoRecap(esInicial);
		this.setResaltarid_ejercicioProcesoRecap(esInicial);
		this.setResaltarfecha_emision_desdeProcesoRecap(esInicial);
		this.setResaltarfecha_emision_hastaProcesoRecap(esInicial);
		this.setResaltarnombre_completo_clienteProcesoRecap(esInicial);
		this.setResaltarnumero_pre_impresoProcesoRecap(esInicial);
		this.setResaltarnombre_transaccionProcesoRecap(esInicial);
		this.setResaltarfecha_emisionProcesoRecap(esInicial);
		this.setResaltarmonto_mone_localProcesoRecap(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.ID)) {
				this.setResaltaridProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.NOMBRETRANSACCION)) {
				this.setResaltarnombre_transaccionProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionProcesoRecap(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoRecapConstantesFunciones.MONTOMONELOCAL)) {
				this.setResaltarmonto_mone_localProcesoRecap(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoRecapProcesoRecap=true;

	public Boolean getMostrarBusquedaProcesoRecapProcesoRecap() {
		return this.mostrarBusquedaProcesoRecapProcesoRecap;
	}

	public void setMostrarBusquedaProcesoRecapProcesoRecap(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoRecapProcesoRecap= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoRecapProcesoRecap=true;

	public Boolean getActivarBusquedaProcesoRecapProcesoRecap() {
		return this.activarBusquedaProcesoRecapProcesoRecap;
	}

	public void setActivarBusquedaProcesoRecapProcesoRecap(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoRecapProcesoRecap= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoRecapProcesoRecap=null;

	public Border getResaltarBusquedaProcesoRecapProcesoRecap() {
		return this.resaltarBusquedaProcesoRecapProcesoRecap;
	}

	public void setResaltarBusquedaProcesoRecapProcesoRecap(Border borderResaltar) {
		this.resaltarBusquedaProcesoRecapProcesoRecap= borderResaltar;
	}

	public void setResaltarBusquedaProcesoRecapProcesoRecap(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoRecapBeanSwingJInternalFrame procesorecapBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoRecapProcesoRecap= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}