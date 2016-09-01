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
package com.bydan.erp.sris.util.report;

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


import com.bydan.erp.sris.util.report.TransaccionesLocalesNotasCreditosConstantesFunciones;
import com.bydan.erp.sris.util.report.TransaccionesLocalesNotasCreditosParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.TransaccionesLocalesNotasCreditosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransaccionesLocalesNotasCreditosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TransaccionesLocalesNotasCreditos";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TransaccionesLocalesNotasCreditos"+TransaccionesLocalesNotasCreditosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransaccionesLocalesNotasCreditosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransaccionesLocalesNotasCreditosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"_"+TransaccionesLocalesNotasCreditosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionesLocalesNotasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"_"+TransaccionesLocalesNotasCreditosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"_"+TransaccionesLocalesNotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionesLocalesNotasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"_"+TransaccionesLocalesNotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionesLocalesNotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionesLocalesNotasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionesLocalesNotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionesLocalesNotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionesLocalesNotasCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionesLocalesNotasCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransaccionesLocalesNotasCreditosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransaccionesLocalesNotasCreditosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransaccionesLocalesNotasCreditosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransaccionesLocalesNotasCreditosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transacciones Locales Notas Creditoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Transacciones Locales Notas Creditos";
	public static final String SCLASSWEBTITULO_LOWER="Transacciones Locales Notas Creditos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TransaccionesLocalesNotasCreditos";
	public static final String OBJECTNAME="transaccioneslocalesnotascreditos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="transacciones_locales_notas_creditos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transaccioneslocalesnotascreditos from "+TransaccionesLocalesNotasCreditosConstantesFunciones.SPERSISTENCENAME+" transaccioneslocalesnotascreditos";
	public static String QUERYSELECTNATIVE="select "+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".id,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".version_row,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".id_empresa,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".id_ejercicio,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".fecha_desde,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".fecha_hasta,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".total_iva,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".total_sin_iva,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".iva,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".total,"+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME+".ruc_cliente from "+TransaccionesLocalesNotasCreditosConstantesFunciones.SCHEMA+"."+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME;//+" as "+TransaccionesLocalesNotasCreditosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String TOTALIVA= "total_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String IVA= "iva";
    public static final String TOTAL= "total";
    public static final String RUCCLIENTE= "ruc_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_RUCCLIENTE= "Ruc Cliente";
		public static final String LABEL_RUCCLIENTE_LOWER= "Ruc Cliente";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXRUC_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTransaccionesLocalesNotasCreditosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.FECHADESDE)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.FECHAHASTA)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALIVA)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALSINIVA)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IVA)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTAL)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.RUCCLIENTE)) {sLabelColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_RUCCLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTransaccionesLocalesNotasCreditosDescripcion(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transaccioneslocalesnotascreditos !=null/* && transaccioneslocalesnotascreditos.getId()!=0*/) {
			sDescripcion=transaccioneslocalesnotascreditos.getfecha_desde().toString();//transaccioneslocalesnotascreditostransaccioneslocalesnotascreditos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransaccionesLocalesNotasCreditosDescripcionDetallado(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos) {
		String sDescripcion="";
			
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.ID+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getId().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getVersionRow().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getid_empresa().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getid_ejercicio().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getfecha_desde().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getfecha_hasta().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getnombre_completo_cliente()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.gettotal_iva().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.gettotal_sin_iva().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.IVA+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getiva().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.TOTAL+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.gettotal().toString()+",";
		sDescripcion+=TransaccionesLocalesNotasCreditosConstantesFunciones.RUCCLIENTE+"=";
		sDescripcion+=transaccioneslocalesnotascreditos.getruc_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setTransaccionesLocalesNotasCreditosDescripcion(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos,String sValor) throws Exception {			
		if(transaccioneslocalesnotascreditos !=null) {
			//transaccioneslocalesnotascreditostransaccioneslocalesnotascreditos.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
		} else if(sNombreIndice.equals("BusquedaTransaccionesLocalesNotasCreditos")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaTransaccionesLocalesNotasCreditos(Long id_ejercicio,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosTransaccionesLocalesNotasCreditos(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transaccioneslocalesnotascreditos.setnombre_completo_cliente(transaccioneslocalesnotascreditos.getnombre_completo_cliente().trim());
		transaccioneslocalesnotascreditos.setruc_cliente(transaccioneslocalesnotascreditos.getruc_cliente().trim());
	}
	
	public static void quitarEspaciosTransaccionesLocalesNotasCreditoss(List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos: transaccioneslocalesnotascreditoss) {
			transaccioneslocalesnotascreditos.setnombre_completo_cliente(transaccioneslocalesnotascreditos.getnombre_completo_cliente().trim());
			transaccioneslocalesnotascreditos.setruc_cliente(transaccioneslocalesnotascreditos.getruc_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionesLocalesNotasCreditos(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transaccioneslocalesnotascreditos.getConCambioAuxiliar()) {
			transaccioneslocalesnotascreditos.setIsDeleted(transaccioneslocalesnotascreditos.getIsDeletedAuxiliar());	
			transaccioneslocalesnotascreditos.setIsNew(transaccioneslocalesnotascreditos.getIsNewAuxiliar());	
			transaccioneslocalesnotascreditos.setIsChanged(transaccioneslocalesnotascreditos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transaccioneslocalesnotascreditos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transaccioneslocalesnotascreditos.setIsDeletedAuxiliar(false);	
			transaccioneslocalesnotascreditos.setIsNewAuxiliar(false);	
			transaccioneslocalesnotascreditos.setIsChangedAuxiliar(false);
			
			transaccioneslocalesnotascreditos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionesLocalesNotasCreditoss(List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos : transaccioneslocalesnotascreditoss) {
			if(conAsignarBase && transaccioneslocalesnotascreditos.getConCambioAuxiliar()) {
				transaccioneslocalesnotascreditos.setIsDeleted(transaccioneslocalesnotascreditos.getIsDeletedAuxiliar());	
				transaccioneslocalesnotascreditos.setIsNew(transaccioneslocalesnotascreditos.getIsNewAuxiliar());	
				transaccioneslocalesnotascreditos.setIsChanged(transaccioneslocalesnotascreditos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transaccioneslocalesnotascreditos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transaccioneslocalesnotascreditos.setIsDeletedAuxiliar(false);	
				transaccioneslocalesnotascreditos.setIsNewAuxiliar(false);	
				transaccioneslocalesnotascreditos.setIsChangedAuxiliar(false);
				
				transaccioneslocalesnotascreditos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransaccionesLocalesNotasCreditos(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos,Boolean conEnteros) throws Exception  {
		transaccioneslocalesnotascreditos.settotal_iva(0.0);
		transaccioneslocalesnotascreditos.settotal_sin_iva(0.0);
		transaccioneslocalesnotascreditos.setiva(0.0);
		transaccioneslocalesnotascreditos.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransaccionesLocalesNotasCreditoss(List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditoss,Boolean conEnteros) throws Exception  {
		
		for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos: transaccioneslocalesnotascreditoss) {
			transaccioneslocalesnotascreditos.settotal_iva(0.0);
			transaccioneslocalesnotascreditos.settotal_sin_iva(0.0);
			transaccioneslocalesnotascreditos.setiva(0.0);
			transaccioneslocalesnotascreditos.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransaccionesLocalesNotasCreditos(List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditoss,TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditosAux) throws Exception  {
		TransaccionesLocalesNotasCreditosConstantesFunciones.InicializarValoresTransaccionesLocalesNotasCreditos(transaccioneslocalesnotascreditosAux,true);
		
		for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos: transaccioneslocalesnotascreditoss) {
			if(transaccioneslocalesnotascreditos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			transaccioneslocalesnotascreditosAux.settotal_iva(transaccioneslocalesnotascreditosAux.gettotal_iva()+transaccioneslocalesnotascreditos.gettotal_iva());			
			transaccioneslocalesnotascreditosAux.settotal_sin_iva(transaccioneslocalesnotascreditosAux.gettotal_sin_iva()+transaccioneslocalesnotascreditos.gettotal_sin_iva());			
			transaccioneslocalesnotascreditosAux.setiva(transaccioneslocalesnotascreditosAux.getiva()+transaccioneslocalesnotascreditos.getiva());			
			transaccioneslocalesnotascreditosAux.settotal(transaccioneslocalesnotascreditosAux.gettotal()+transaccioneslocalesnotascreditos.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionesLocalesNotasCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransaccionesLocalesNotasCreditosConstantesFunciones.getArrayColumnasGlobalesTransaccionesLocalesNotasCreditos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionesLocalesNotasCreditos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransaccionesLocalesNotasCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditoss,TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditosAux: transaccioneslocalesnotascreditoss) {
			if(transaccioneslocalesnotascreditosAux!=null && transaccioneslocalesnotascreditos!=null) {
				if((transaccioneslocalesnotascreditosAux.getId()==null && transaccioneslocalesnotascreditos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transaccioneslocalesnotascreditosAux.getId()!=null && transaccioneslocalesnotascreditos.getId()!=null){
					if(transaccioneslocalesnotascreditosAux.getId().equals(transaccioneslocalesnotascreditos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransaccionesLocalesNotasCreditos(List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double ivaTotal=0.0;
		Double totalTotal=0.0;
	
		for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos: transaccioneslocalesnotascreditoss) {			
			if(transaccioneslocalesnotascreditos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=transaccioneslocalesnotascreditos.gettotal_iva();
			total_sin_ivaTotal+=transaccioneslocalesnotascreditos.gettotal_sin_iva();
			ivaTotal+=transaccioneslocalesnotascreditos.getiva();
			totalTotal+=transaccioneslocalesnotascreditos.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransaccionesLocalesNotasCreditos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_ID, TransaccionesLocalesNotasCreditosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_VERSIONROW, TransaccionesLocalesNotasCreditosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, TransaccionesLocalesNotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALIVA, TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALSINIVA, TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IVA, TransaccionesLocalesNotasCreditosConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTAL, TransaccionesLocalesNotasCreditosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_RUCCLIENTE, TransaccionesLocalesNotasCreditosConstantesFunciones.RUCCLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransaccionesLocalesNotasCreditos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesNotasCreditosConstantesFunciones.RUCCLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionesLocalesNotasCreditos() throws Exception  {
		return TransaccionesLocalesNotasCreditosConstantesFunciones.getTiposSeleccionarTransaccionesLocalesNotasCreditos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionesLocalesNotasCreditos(Boolean conFk) throws Exception  {
		return TransaccionesLocalesNotasCreditosConstantesFunciones.getTiposSeleccionarTransaccionesLocalesNotasCreditos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionesLocalesNotasCreditos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_RUCCLIENTE);
			reporte.setsDescripcion(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_RUCCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransaccionesLocalesNotasCreditos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionesLocalesNotasCreditos(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditosAux) throws Exception {
		
			transaccioneslocalesnotascreditosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccioneslocalesnotascreditosAux.getEmpresa()));
			transaccioneslocalesnotascreditosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(transaccioneslocalesnotascreditosAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionesLocalesNotasCreditos(List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditossTemp) throws Exception {
		for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditosAux:transaccioneslocalesnotascreditossTemp) {
			
			transaccioneslocalesnotascreditosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccioneslocalesnotascreditosAux.getEmpresa()));
			transaccioneslocalesnotascreditosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(transaccioneslocalesnotascreditosAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionesLocalesNotasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ejercicio.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransaccionesLocalesNotasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionesLocalesNotasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionesLocalesNotasCreditosConstantesFunciones.getClassesRelationshipsOfTransaccionesLocalesNotasCreditos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionesLocalesNotasCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionesLocalesNotasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionesLocalesNotasCreditosConstantesFunciones.getClassesRelationshipsFromStringsOfTransaccionesLocalesNotasCreditos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionesLocalesNotasCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos,List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos,List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditoss) throws Exception {
		try	{			
			for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditosLocal:transaccioneslocalesnotascreditoss) {
				if(transaccioneslocalesnotascreditosLocal.getId().equals(transaccioneslocalesnotascreditos.getId())) {
					transaccioneslocalesnotascreditosLocal.setIsSelected(transaccioneslocalesnotascreditos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransaccionesLocalesNotasCreditos(List<TransaccionesLocalesNotasCreditos> transaccioneslocalesnotascreditossAux) throws Exception {
		//this.transaccioneslocalesnotascreditossAux=transaccioneslocalesnotascreditossAux;
		
		for(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditosAux:transaccioneslocalesnotascreditossAux) {
			if(transaccioneslocalesnotascreditosAux.getIsChanged()) {
				transaccioneslocalesnotascreditosAux.setIsChanged(false);
			}		
			
			if(transaccioneslocalesnotascreditosAux.getIsNew()) {
				transaccioneslocalesnotascreditosAux.setIsNew(false);
			}	
			
			if(transaccioneslocalesnotascreditosAux.getIsDeleted()) {
				transaccioneslocalesnotascreditosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransaccionesLocalesNotasCreditos(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditosAux) throws Exception {
		//this.transaccioneslocalesnotascreditosAux=transaccioneslocalesnotascreditosAux;
		
			if(transaccioneslocalesnotascreditosAux.getIsChanged()) {
				transaccioneslocalesnotascreditosAux.setIsChanged(false);
			}		
			
			if(transaccioneslocalesnotascreditosAux.getIsNew()) {
				transaccioneslocalesnotascreditosAux.setIsNew(false);
			}	
			
			if(transaccioneslocalesnotascreditosAux.getIsDeleted()) {
				transaccioneslocalesnotascreditosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditosAsignar,TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos) throws Exception {
		transaccioneslocalesnotascreditosAsignar.setId(transaccioneslocalesnotascreditos.getId());	
		transaccioneslocalesnotascreditosAsignar.setVersionRow(transaccioneslocalesnotascreditos.getVersionRow());	
		transaccioneslocalesnotascreditosAsignar.setnombre_completo_cliente(transaccioneslocalesnotascreditos.getnombre_completo_cliente());	
		transaccioneslocalesnotascreditosAsignar.settotal_iva(transaccioneslocalesnotascreditos.gettotal_iva());	
		transaccioneslocalesnotascreditosAsignar.settotal_sin_iva(transaccioneslocalesnotascreditos.gettotal_sin_iva());	
		transaccioneslocalesnotascreditosAsignar.setiva(transaccioneslocalesnotascreditos.getiva());	
		transaccioneslocalesnotascreditosAsignar.settotal(transaccioneslocalesnotascreditos.gettotal());	
		transaccioneslocalesnotascreditosAsignar.setruc_cliente(transaccioneslocalesnotascreditos.getruc_cliente());	
	}
	
	public static void inicializarTransaccionesLocalesNotasCreditos(TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos) throws Exception {
		try {
				transaccioneslocalesnotascreditos.setId(0L);	
					
				transaccioneslocalesnotascreditos.setnombre_completo_cliente("");	
				transaccioneslocalesnotascreditos.settotal_iva(0.0);	
				transaccioneslocalesnotascreditos.settotal_sin_iva(0.0);	
				transaccioneslocalesnotascreditos.setiva(0.0);	
				transaccioneslocalesnotascreditos.settotal(0.0);	
				transaccioneslocalesnotascreditos.setruc_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransaccionesLocalesNotasCreditos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesNotasCreditosConstantesFunciones.LABEL_RUCCLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransaccionesLocalesNotasCreditos(String sTipo,Row row,Workbook workbook,TransaccionesLocalesNotasCreditos transaccioneslocalesnotascreditos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesnotascreditos.getruc_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransaccionesLocalesNotasCreditos="";
	
	public String getsFinalQueryTransaccionesLocalesNotasCreditos() {
		return this.sFinalQueryTransaccionesLocalesNotasCreditos;
	}
	
	public void setsFinalQueryTransaccionesLocalesNotasCreditos(String sFinalQueryTransaccionesLocalesNotasCreditos) {
		this.sFinalQueryTransaccionesLocalesNotasCreditos= sFinalQueryTransaccionesLocalesNotasCreditos;
	}
	
	public Border resaltarSeleccionarTransaccionesLocalesNotasCreditos=null;
	
	public Border setResaltarSeleccionarTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransaccionesLocalesNotasCreditos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransaccionesLocalesNotasCreditos() {
		return this.resaltarSeleccionarTransaccionesLocalesNotasCreditos;
	}
	
	public void setResaltarSeleccionarTransaccionesLocalesNotasCreditos(Border borderResaltarSeleccionarTransaccionesLocalesNotasCreditos) {
		this.resaltarSeleccionarTransaccionesLocalesNotasCreditos= borderResaltarSeleccionarTransaccionesLocalesNotasCreditos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransaccionesLocalesNotasCreditos=null;
	public Boolean mostraridTransaccionesLocalesNotasCreditos=true;
	public Boolean activaridTransaccionesLocalesNotasCreditos=true;

	public Border resaltarid_empresaTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrarid_empresaTransaccionesLocalesNotasCreditos=true;
	public Boolean activarid_empresaTransaccionesLocalesNotasCreditos=true;
	public Boolean cargarid_empresaTransaccionesLocalesNotasCreditos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransaccionesLocalesNotasCreditos=false;//ConEventDepend=true

	public Border resaltarid_ejercicioTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrarid_ejercicioTransaccionesLocalesNotasCreditos=true;
	public Boolean activarid_ejercicioTransaccionesLocalesNotasCreditos=true;
	public Boolean cargarid_ejercicioTransaccionesLocalesNotasCreditos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioTransaccionesLocalesNotasCreditos=false;//ConEventDepend=true

	public Border resaltarfecha_desdeTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrarfecha_desdeTransaccionesLocalesNotasCreditos=true;
	public Boolean activarfecha_desdeTransaccionesLocalesNotasCreditos=true;

	public Border resaltarfecha_hastaTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrarfecha_hastaTransaccionesLocalesNotasCreditos=true;
	public Boolean activarfecha_hastaTransaccionesLocalesNotasCreditos=true;

	public Border resaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos=true;
	public Boolean activarnombre_completo_clienteTransaccionesLocalesNotasCreditos=true;

	public Border resaltartotal_ivaTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrartotal_ivaTransaccionesLocalesNotasCreditos=true;
	public Boolean activartotal_ivaTransaccionesLocalesNotasCreditos=true;

	public Border resaltartotal_sin_ivaTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrartotal_sin_ivaTransaccionesLocalesNotasCreditos=true;
	public Boolean activartotal_sin_ivaTransaccionesLocalesNotasCreditos=true;

	public Border resaltarivaTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrarivaTransaccionesLocalesNotasCreditos=true;
	public Boolean activarivaTransaccionesLocalesNotasCreditos=true;

	public Border resaltartotalTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrartotalTransaccionesLocalesNotasCreditos=true;
	public Boolean activartotalTransaccionesLocalesNotasCreditos=true;

	public Border resaltarruc_clienteTransaccionesLocalesNotasCreditos=null;
	public Boolean mostrarruc_clienteTransaccionesLocalesNotasCreditos=true;
	public Boolean activarruc_clienteTransaccionesLocalesNotasCreditos=true;

	
	

	public Border setResaltaridTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltaridTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransaccionesLocalesNotasCreditos() {
		return this.resaltaridTransaccionesLocalesNotasCreditos;
	}

	public void setResaltaridTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltaridTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostraridTransaccionesLocalesNotasCreditos() {
		return this.mostraridTransaccionesLocalesNotasCreditos;
	}

	public void setMostraridTransaccionesLocalesNotasCreditos(Boolean mostraridTransaccionesLocalesNotasCreditos) {
		this.mostraridTransaccionesLocalesNotasCreditos= mostraridTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivaridTransaccionesLocalesNotasCreditos() {
		return this.activaridTransaccionesLocalesNotasCreditos;
	}

	public void setActivaridTransaccionesLocalesNotasCreditos(Boolean activaridTransaccionesLocalesNotasCreditos) {
		this.activaridTransaccionesLocalesNotasCreditos= activaridTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltarid_empresaTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransaccionesLocalesNotasCreditos() {
		return this.resaltarid_empresaTransaccionesLocalesNotasCreditos;
	}

	public void setResaltarid_empresaTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltarid_empresaTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransaccionesLocalesNotasCreditos() {
		return this.mostrarid_empresaTransaccionesLocalesNotasCreditos;
	}

	public void setMostrarid_empresaTransaccionesLocalesNotasCreditos(Boolean mostrarid_empresaTransaccionesLocalesNotasCreditos) {
		this.mostrarid_empresaTransaccionesLocalesNotasCreditos= mostrarid_empresaTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivarid_empresaTransaccionesLocalesNotasCreditos() {
		return this.activarid_empresaTransaccionesLocalesNotasCreditos;
	}

	public void setActivarid_empresaTransaccionesLocalesNotasCreditos(Boolean activarid_empresaTransaccionesLocalesNotasCreditos) {
		this.activarid_empresaTransaccionesLocalesNotasCreditos= activarid_empresaTransaccionesLocalesNotasCreditos;
	}

	public Boolean getCargarid_empresaTransaccionesLocalesNotasCreditos() {
		return this.cargarid_empresaTransaccionesLocalesNotasCreditos;
	}

	public void setCargarid_empresaTransaccionesLocalesNotasCreditos(Boolean cargarid_empresaTransaccionesLocalesNotasCreditos) {
		this.cargarid_empresaTransaccionesLocalesNotasCreditos= cargarid_empresaTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltarid_ejercicioTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioTransaccionesLocalesNotasCreditos() {
		return this.resaltarid_ejercicioTransaccionesLocalesNotasCreditos;
	}

	public void setResaltarid_ejercicioTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltarid_ejercicioTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioTransaccionesLocalesNotasCreditos() {
		return this.mostrarid_ejercicioTransaccionesLocalesNotasCreditos;
	}

	public void setMostrarid_ejercicioTransaccionesLocalesNotasCreditos(Boolean mostrarid_ejercicioTransaccionesLocalesNotasCreditos) {
		this.mostrarid_ejercicioTransaccionesLocalesNotasCreditos= mostrarid_ejercicioTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivarid_ejercicioTransaccionesLocalesNotasCreditos() {
		return this.activarid_ejercicioTransaccionesLocalesNotasCreditos;
	}

	public void setActivarid_ejercicioTransaccionesLocalesNotasCreditos(Boolean activarid_ejercicioTransaccionesLocalesNotasCreditos) {
		this.activarid_ejercicioTransaccionesLocalesNotasCreditos= activarid_ejercicioTransaccionesLocalesNotasCreditos;
	}

	public Boolean getCargarid_ejercicioTransaccionesLocalesNotasCreditos() {
		return this.cargarid_ejercicioTransaccionesLocalesNotasCreditos;
	}

	public void setCargarid_ejercicioTransaccionesLocalesNotasCreditos(Boolean cargarid_ejercicioTransaccionesLocalesNotasCreditos) {
		this.cargarid_ejercicioTransaccionesLocalesNotasCreditos= cargarid_ejercicioTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltarfecha_desdeTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeTransaccionesLocalesNotasCreditos() {
		return this.resaltarfecha_desdeTransaccionesLocalesNotasCreditos;
	}

	public void setResaltarfecha_desdeTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltarfecha_desdeTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeTransaccionesLocalesNotasCreditos() {
		return this.mostrarfecha_desdeTransaccionesLocalesNotasCreditos;
	}

	public void setMostrarfecha_desdeTransaccionesLocalesNotasCreditos(Boolean mostrarfecha_desdeTransaccionesLocalesNotasCreditos) {
		this.mostrarfecha_desdeTransaccionesLocalesNotasCreditos= mostrarfecha_desdeTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivarfecha_desdeTransaccionesLocalesNotasCreditos() {
		return this.activarfecha_desdeTransaccionesLocalesNotasCreditos;
	}

	public void setActivarfecha_desdeTransaccionesLocalesNotasCreditos(Boolean activarfecha_desdeTransaccionesLocalesNotasCreditos) {
		this.activarfecha_desdeTransaccionesLocalesNotasCreditos= activarfecha_desdeTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltarfecha_hastaTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaTransaccionesLocalesNotasCreditos() {
		return this.resaltarfecha_hastaTransaccionesLocalesNotasCreditos;
	}

	public void setResaltarfecha_hastaTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltarfecha_hastaTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaTransaccionesLocalesNotasCreditos() {
		return this.mostrarfecha_hastaTransaccionesLocalesNotasCreditos;
	}

	public void setMostrarfecha_hastaTransaccionesLocalesNotasCreditos(Boolean mostrarfecha_hastaTransaccionesLocalesNotasCreditos) {
		this.mostrarfecha_hastaTransaccionesLocalesNotasCreditos= mostrarfecha_hastaTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivarfecha_hastaTransaccionesLocalesNotasCreditos() {
		return this.activarfecha_hastaTransaccionesLocalesNotasCreditos;
	}

	public void setActivarfecha_hastaTransaccionesLocalesNotasCreditos(Boolean activarfecha_hastaTransaccionesLocalesNotasCreditos) {
		this.activarfecha_hastaTransaccionesLocalesNotasCreditos= activarfecha_hastaTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos() {
		return this.resaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos;
	}

	public void setResaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos() {
		return this.mostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos;
	}

	public void setMostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos(Boolean mostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos) {
		this.mostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos= mostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivarnombre_completo_clienteTransaccionesLocalesNotasCreditos() {
		return this.activarnombre_completo_clienteTransaccionesLocalesNotasCreditos;
	}

	public void setActivarnombre_completo_clienteTransaccionesLocalesNotasCreditos(Boolean activarnombre_completo_clienteTransaccionesLocalesNotasCreditos) {
		this.activarnombre_completo_clienteTransaccionesLocalesNotasCreditos= activarnombre_completo_clienteTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltartotal_ivaTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltartotal_ivaTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaTransaccionesLocalesNotasCreditos() {
		return this.resaltartotal_ivaTransaccionesLocalesNotasCreditos;
	}

	public void setResaltartotal_ivaTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltartotal_ivaTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrartotal_ivaTransaccionesLocalesNotasCreditos() {
		return this.mostrartotal_ivaTransaccionesLocalesNotasCreditos;
	}

	public void setMostrartotal_ivaTransaccionesLocalesNotasCreditos(Boolean mostrartotal_ivaTransaccionesLocalesNotasCreditos) {
		this.mostrartotal_ivaTransaccionesLocalesNotasCreditos= mostrartotal_ivaTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivartotal_ivaTransaccionesLocalesNotasCreditos() {
		return this.activartotal_ivaTransaccionesLocalesNotasCreditos;
	}

	public void setActivartotal_ivaTransaccionesLocalesNotasCreditos(Boolean activartotal_ivaTransaccionesLocalesNotasCreditos) {
		this.activartotal_ivaTransaccionesLocalesNotasCreditos= activartotal_ivaTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltartotal_sin_ivaTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaTransaccionesLocalesNotasCreditos() {
		return this.resaltartotal_sin_ivaTransaccionesLocalesNotasCreditos;
	}

	public void setResaltartotal_sin_ivaTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltartotal_sin_ivaTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaTransaccionesLocalesNotasCreditos() {
		return this.mostrartotal_sin_ivaTransaccionesLocalesNotasCreditos;
	}

	public void setMostrartotal_sin_ivaTransaccionesLocalesNotasCreditos(Boolean mostrartotal_sin_ivaTransaccionesLocalesNotasCreditos) {
		this.mostrartotal_sin_ivaTransaccionesLocalesNotasCreditos= mostrartotal_sin_ivaTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivartotal_sin_ivaTransaccionesLocalesNotasCreditos() {
		return this.activartotal_sin_ivaTransaccionesLocalesNotasCreditos;
	}

	public void setActivartotal_sin_ivaTransaccionesLocalesNotasCreditos(Boolean activartotal_sin_ivaTransaccionesLocalesNotasCreditos) {
		this.activartotal_sin_ivaTransaccionesLocalesNotasCreditos= activartotal_sin_ivaTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltarivaTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarivaTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaTransaccionesLocalesNotasCreditos() {
		return this.resaltarivaTransaccionesLocalesNotasCreditos;
	}

	public void setResaltarivaTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltarivaTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarivaTransaccionesLocalesNotasCreditos() {
		return this.mostrarivaTransaccionesLocalesNotasCreditos;
	}

	public void setMostrarivaTransaccionesLocalesNotasCreditos(Boolean mostrarivaTransaccionesLocalesNotasCreditos) {
		this.mostrarivaTransaccionesLocalesNotasCreditos= mostrarivaTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivarivaTransaccionesLocalesNotasCreditos() {
		return this.activarivaTransaccionesLocalesNotasCreditos;
	}

	public void setActivarivaTransaccionesLocalesNotasCreditos(Boolean activarivaTransaccionesLocalesNotasCreditos) {
		this.activarivaTransaccionesLocalesNotasCreditos= activarivaTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltartotalTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltartotalTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalTransaccionesLocalesNotasCreditos() {
		return this.resaltartotalTransaccionesLocalesNotasCreditos;
	}

	public void setResaltartotalTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltartotalTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrartotalTransaccionesLocalesNotasCreditos() {
		return this.mostrartotalTransaccionesLocalesNotasCreditos;
	}

	public void setMostrartotalTransaccionesLocalesNotasCreditos(Boolean mostrartotalTransaccionesLocalesNotasCreditos) {
		this.mostrartotalTransaccionesLocalesNotasCreditos= mostrartotalTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivartotalTransaccionesLocalesNotasCreditos() {
		return this.activartotalTransaccionesLocalesNotasCreditos;
	}

	public void setActivartotalTransaccionesLocalesNotasCreditos(Boolean activartotalTransaccionesLocalesNotasCreditos) {
		this.activartotalTransaccionesLocalesNotasCreditos= activartotalTransaccionesLocalesNotasCreditos;
	}

	public Border setResaltarruc_clienteTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesnotascreditosBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesNotasCreditos.setBorder(borderResaltar);
		
		this.resaltarruc_clienteTransaccionesLocalesNotasCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_clienteTransaccionesLocalesNotasCreditos() {
		return this.resaltarruc_clienteTransaccionesLocalesNotasCreditos;
	}

	public void setResaltarruc_clienteTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltarruc_clienteTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public Boolean getMostrarruc_clienteTransaccionesLocalesNotasCreditos() {
		return this.mostrarruc_clienteTransaccionesLocalesNotasCreditos;
	}

	public void setMostrarruc_clienteTransaccionesLocalesNotasCreditos(Boolean mostrarruc_clienteTransaccionesLocalesNotasCreditos) {
		this.mostrarruc_clienteTransaccionesLocalesNotasCreditos= mostrarruc_clienteTransaccionesLocalesNotasCreditos;
	}

	public Boolean getActivarruc_clienteTransaccionesLocalesNotasCreditos() {
		return this.activarruc_clienteTransaccionesLocalesNotasCreditos;
	}

	public void setActivarruc_clienteTransaccionesLocalesNotasCreditos(Boolean activarruc_clienteTransaccionesLocalesNotasCreditos) {
		this.activarruc_clienteTransaccionesLocalesNotasCreditos= activarruc_clienteTransaccionesLocalesNotasCreditos;
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
		
		
		this.setMostraridTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrarid_empresaTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrarid_ejercicioTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrarfecha_desdeTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrarfecha_hastaTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrartotal_ivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrartotal_sin_ivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrarivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrartotalTransaccionesLocalesNotasCreditos(esInicial);
		this.setMostrarruc_clienteTransaccionesLocalesNotasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.ID)) {
				this.setMostraridTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IVA)) {
				this.setMostrarivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTAL)) {
				this.setMostrartotalTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.RUCCLIENTE)) {
				this.setMostrarruc_clienteTransaccionesLocalesNotasCreditos(esAsigna);
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
		
		
		this.setActivaridTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivarid_empresaTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivarid_ejercicioTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivarfecha_desdeTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivarfecha_hastaTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivarnombre_completo_clienteTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivartotal_ivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivartotal_sin_ivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivarivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivartotalTransaccionesLocalesNotasCreditos(esInicial);
		this.setActivarruc_clienteTransaccionesLocalesNotasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.ID)) {
				this.setActivaridTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IVA)) {
				this.setActivarivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTAL)) {
				this.setActivartotalTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.RUCCLIENTE)) {
				this.setActivarruc_clienteTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltarid_empresaTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltarid_ejercicioTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltarfecha_desdeTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltarfecha_hastaTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltartotal_ivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltartotal_sin_ivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltarivaTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltartotalTransaccionesLocalesNotasCreditos(esInicial);
		this.setResaltarruc_clienteTransaccionesLocalesNotasCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.ID)) {
				this.setResaltaridTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.IVA)) {
				this.setResaltarivaTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.TOTAL)) {
				this.setResaltartotalTransaccionesLocalesNotasCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesNotasCreditosConstantesFunciones.RUCCLIENTE)) {
				this.setResaltarruc_clienteTransaccionesLocalesNotasCreditos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos=true;

	public Boolean getMostrarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos() {
		return this.mostrarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos;
	}

	public void setMostrarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos=true;

	public Boolean getActivarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos() {
		return this.activarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos;
	}

	public void setActivarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos(Boolean habilitarResaltar) {
		this.activarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos=null;

	public Border getResaltarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos() {
		return this.resaltarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos;
	}

	public void setResaltarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos(Border borderResaltar) {
		this.resaltarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos= borderResaltar;
	}

	public void setResaltarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesNotasCreditosBeanSwingJInternalFrame transaccioneslocalesnotascreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaTransaccionesLocalesNotasCreditosTransaccionesLocalesNotasCreditos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}