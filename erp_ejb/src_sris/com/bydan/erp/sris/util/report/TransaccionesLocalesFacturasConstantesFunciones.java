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


import com.bydan.erp.sris.util.report.TransaccionesLocalesFacturasConstantesFunciones;
import com.bydan.erp.sris.util.report.TransaccionesLocalesFacturasParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.TransaccionesLocalesFacturasParameterGeneral;

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
final public class TransaccionesLocalesFacturasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TransaccionesLocalesFacturas";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TransaccionesLocalesFacturas"+TransaccionesLocalesFacturasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransaccionesLocalesFacturasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransaccionesLocalesFacturasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"_"+TransaccionesLocalesFacturasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionesLocalesFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"_"+TransaccionesLocalesFacturasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"_"+TransaccionesLocalesFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionesLocalesFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"_"+TransaccionesLocalesFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionesLocalesFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionesLocalesFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionesLocalesFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionesLocalesFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionesLocalesFacturasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionesLocalesFacturasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransaccionesLocalesFacturasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransaccionesLocalesFacturasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransaccionesLocalesFacturasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransaccionesLocalesFacturasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transacciones Locales Facturases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Transacciones Locales Facturas";
	public static final String SCLASSWEBTITULO_LOWER="Transacciones Locales Facturas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TransaccionesLocalesFacturas";
	public static final String OBJECTNAME="transaccioneslocalesfacturas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="transacciones_locales_facturas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transaccioneslocalesfacturas from "+TransaccionesLocalesFacturasConstantesFunciones.SPERSISTENCENAME+" transaccioneslocalesfacturas";
	public static String QUERYSELECTNATIVE="select "+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".id,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".version_row,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".id_empresa,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".id_ejercicio,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".fecha_desde,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".fecha_hasta,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".total_iva,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".total_sin_iva,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".total_descuento,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".total,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".iva,"+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME+".ruc_cliente from "+TransaccionesLocalesFacturasConstantesFunciones.SCHEMA+"."+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME;//+" as "+TransaccionesLocalesFacturasConstantesFunciones.TABLENAME;
	
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
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String TOTAL= "total";
    public static final String IVA= "iva";
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
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Descuento";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_RUCCLIENTE= "Ruc Cliente";
		public static final String LABEL_RUCCLIENTE_LOWER= "Ruc Cliente";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXRUC_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTransaccionesLocalesFacturasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEJERCICIO)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.FECHADESDE)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.FECHAHASTA)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTAL)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.IVA)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE)) {sLabelColumna=TransaccionesLocalesFacturasConstantesFunciones.LABEL_RUCCLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTransaccionesLocalesFacturasDescripcion(TransaccionesLocalesFacturas transaccioneslocalesfacturas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transaccioneslocalesfacturas !=null/* && transaccioneslocalesfacturas.getId()!=0*/) {
			sDescripcion=transaccioneslocalesfacturas.getfecha_desde().toString();//transaccioneslocalesfacturastransaccioneslocalesfacturas.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransaccionesLocalesFacturasDescripcionDetallado(TransaccionesLocalesFacturas transaccioneslocalesfacturas) {
		String sDescripcion="";
			
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.ID+"=";
		sDescripcion+=transaccioneslocalesfacturas.getId().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transaccioneslocalesfacturas.getVersionRow().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transaccioneslocalesfacturas.getid_empresa().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=transaccioneslocalesfacturas.getid_ejercicio().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=transaccioneslocalesfacturas.getfecha_desde().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=transaccioneslocalesfacturas.getfecha_hasta().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=transaccioneslocalesfacturas.getnombre_completo_cliente()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=transaccioneslocalesfacturas.gettotal_iva().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=transaccioneslocalesfacturas.gettotal_sin_iva().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=transaccioneslocalesfacturas.gettotal_descuento().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.TOTAL+"=";
		sDescripcion+=transaccioneslocalesfacturas.gettotal().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.IVA+"=";
		sDescripcion+=transaccioneslocalesfacturas.getiva().toString()+",";
		sDescripcion+=TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE+"=";
		sDescripcion+=transaccioneslocalesfacturas.getruc_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setTransaccionesLocalesFacturasDescripcion(TransaccionesLocalesFacturas transaccioneslocalesfacturas,String sValor) throws Exception {			
		if(transaccioneslocalesfacturas !=null) {
			//transaccioneslocalesfacturastransaccioneslocalesfacturas.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaTransaccionesLocalesFacturas")) {
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

	public static String getDetalleIndiceBusquedaTransaccionesLocalesFacturas(Long id_ejercicio,Date fecha_desde,Date fecha_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosTransaccionesLocalesFacturas(TransaccionesLocalesFacturas transaccioneslocalesfacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transaccioneslocalesfacturas.setnombre_completo_cliente(transaccioneslocalesfacturas.getnombre_completo_cliente().trim());
		transaccioneslocalesfacturas.setruc_cliente(transaccioneslocalesfacturas.getruc_cliente().trim());
	}
	
	public static void quitarEspaciosTransaccionesLocalesFacturass(List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturas: transaccioneslocalesfacturass) {
			transaccioneslocalesfacturas.setnombre_completo_cliente(transaccioneslocalesfacturas.getnombre_completo_cliente().trim());
			transaccioneslocalesfacturas.setruc_cliente(transaccioneslocalesfacturas.getruc_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionesLocalesFacturas(TransaccionesLocalesFacturas transaccioneslocalesfacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transaccioneslocalesfacturas.getConCambioAuxiliar()) {
			transaccioneslocalesfacturas.setIsDeleted(transaccioneslocalesfacturas.getIsDeletedAuxiliar());	
			transaccioneslocalesfacturas.setIsNew(transaccioneslocalesfacturas.getIsNewAuxiliar());	
			transaccioneslocalesfacturas.setIsChanged(transaccioneslocalesfacturas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transaccioneslocalesfacturas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transaccioneslocalesfacturas.setIsDeletedAuxiliar(false);	
			transaccioneslocalesfacturas.setIsNewAuxiliar(false);	
			transaccioneslocalesfacturas.setIsChangedAuxiliar(false);
			
			transaccioneslocalesfacturas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionesLocalesFacturass(List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturas : transaccioneslocalesfacturass) {
			if(conAsignarBase && transaccioneslocalesfacturas.getConCambioAuxiliar()) {
				transaccioneslocalesfacturas.setIsDeleted(transaccioneslocalesfacturas.getIsDeletedAuxiliar());	
				transaccioneslocalesfacturas.setIsNew(transaccioneslocalesfacturas.getIsNewAuxiliar());	
				transaccioneslocalesfacturas.setIsChanged(transaccioneslocalesfacturas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transaccioneslocalesfacturas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transaccioneslocalesfacturas.setIsDeletedAuxiliar(false);	
				transaccioneslocalesfacturas.setIsNewAuxiliar(false);	
				transaccioneslocalesfacturas.setIsChangedAuxiliar(false);
				
				transaccioneslocalesfacturas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransaccionesLocalesFacturas(TransaccionesLocalesFacturas transaccioneslocalesfacturas,Boolean conEnteros) throws Exception  {
		transaccioneslocalesfacturas.settotal_iva(0.0);
		transaccioneslocalesfacturas.settotal_sin_iva(0.0);
		transaccioneslocalesfacturas.settotal_descuento(0.0);
		transaccioneslocalesfacturas.settotal(0.0);
		transaccioneslocalesfacturas.setiva(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransaccionesLocalesFacturass(List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass,Boolean conEnteros) throws Exception  {
		
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturas: transaccioneslocalesfacturass) {
			transaccioneslocalesfacturas.settotal_iva(0.0);
			transaccioneslocalesfacturas.settotal_sin_iva(0.0);
			transaccioneslocalesfacturas.settotal_descuento(0.0);
			transaccioneslocalesfacturas.settotal(0.0);
			transaccioneslocalesfacturas.setiva(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransaccionesLocalesFacturas(List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass,TransaccionesLocalesFacturas transaccioneslocalesfacturasAux) throws Exception  {
		TransaccionesLocalesFacturasConstantesFunciones.InicializarValoresTransaccionesLocalesFacturas(transaccioneslocalesfacturasAux,true);
		
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturas: transaccioneslocalesfacturass) {
			if(transaccioneslocalesfacturas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			transaccioneslocalesfacturasAux.settotal_iva(transaccioneslocalesfacturasAux.gettotal_iva()+transaccioneslocalesfacturas.gettotal_iva());			
			transaccioneslocalesfacturasAux.settotal_sin_iva(transaccioneslocalesfacturasAux.gettotal_sin_iva()+transaccioneslocalesfacturas.gettotal_sin_iva());			
			transaccioneslocalesfacturasAux.settotal_descuento(transaccioneslocalesfacturasAux.gettotal_descuento()+transaccioneslocalesfacturas.gettotal_descuento());			
			transaccioneslocalesfacturasAux.settotal(transaccioneslocalesfacturasAux.gettotal()+transaccioneslocalesfacturas.gettotal());			
			transaccioneslocalesfacturasAux.setiva(transaccioneslocalesfacturasAux.getiva()+transaccioneslocalesfacturas.getiva());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionesLocalesFacturas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransaccionesLocalesFacturasConstantesFunciones.getArrayColumnasGlobalesTransaccionesLocalesFacturas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionesLocalesFacturas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionesLocalesFacturasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionesLocalesFacturasConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransaccionesLocalesFacturas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass,TransaccionesLocalesFacturas transaccioneslocalesfacturas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturasAux: transaccioneslocalesfacturass) {
			if(transaccioneslocalesfacturasAux!=null && transaccioneslocalesfacturas!=null) {
				if((transaccioneslocalesfacturasAux.getId()==null && transaccioneslocalesfacturas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transaccioneslocalesfacturasAux.getId()!=null && transaccioneslocalesfacturas.getId()!=null){
					if(transaccioneslocalesfacturasAux.getId().equals(transaccioneslocalesfacturas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransaccionesLocalesFacturas(List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double totalTotal=0.0;
		Double ivaTotal=0.0;
	
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturas: transaccioneslocalesfacturass) {			
			if(transaccioneslocalesfacturas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=transaccioneslocalesfacturas.gettotal_iva();
			total_sin_ivaTotal+=transaccioneslocalesfacturas.gettotal_sin_iva();
			total_descuentoTotal+=transaccioneslocalesfacturas.gettotal_descuento();
			totalTotal+=transaccioneslocalesfacturas.gettotal();
			ivaTotal+=transaccioneslocalesfacturas.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransaccionesLocalesFacturas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_ID, TransaccionesLocalesFacturasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_VERSIONROW, TransaccionesLocalesFacturasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALIVA, TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALSINIVA, TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALDESCUENTO, TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTAL, TransaccionesLocalesFacturasConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_IVA, TransaccionesLocalesFacturasConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionesLocalesFacturasConstantesFunciones.LABEL_RUCCLIENTE, TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransaccionesLocalesFacturas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionesLocalesFacturas() throws Exception  {
		return TransaccionesLocalesFacturasConstantesFunciones.getTiposSeleccionarTransaccionesLocalesFacturas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionesLocalesFacturas(Boolean conFk) throws Exception  {
		return TransaccionesLocalesFacturasConstantesFunciones.getTiposSeleccionarTransaccionesLocalesFacturas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionesLocalesFacturas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionesLocalesFacturasConstantesFunciones.LABEL_RUCCLIENTE);
			reporte.setsDescripcion(TransaccionesLocalesFacturasConstantesFunciones.LABEL_RUCCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransaccionesLocalesFacturas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionesLocalesFacturas(TransaccionesLocalesFacturas transaccioneslocalesfacturasAux) throws Exception {
		
			transaccioneslocalesfacturasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccioneslocalesfacturasAux.getEmpresa()));
			transaccioneslocalesfacturasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(transaccioneslocalesfacturasAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionesLocalesFacturas(List<TransaccionesLocalesFacturas> transaccioneslocalesfacturassTemp) throws Exception {
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturasAux:transaccioneslocalesfacturassTemp) {
			
			transaccioneslocalesfacturasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccioneslocalesfacturasAux.getEmpresa()));
			transaccioneslocalesfacturasAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(transaccioneslocalesfacturasAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionesLocalesFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransaccionesLocalesFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionesLocalesFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionesLocalesFacturasConstantesFunciones.getClassesRelationshipsOfTransaccionesLocalesFacturas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionesLocalesFacturas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionesLocalesFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionesLocalesFacturasConstantesFunciones.getClassesRelationshipsFromStringsOfTransaccionesLocalesFacturas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionesLocalesFacturas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TransaccionesLocalesFacturas transaccioneslocalesfacturas,List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(TransaccionesLocalesFacturas transaccioneslocalesfacturas,List<TransaccionesLocalesFacturas> transaccioneslocalesfacturass) throws Exception {
		try	{			
			for(TransaccionesLocalesFacturas transaccioneslocalesfacturasLocal:transaccioneslocalesfacturass) {
				if(transaccioneslocalesfacturasLocal.getId().equals(transaccioneslocalesfacturas.getId())) {
					transaccioneslocalesfacturasLocal.setIsSelected(transaccioneslocalesfacturas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransaccionesLocalesFacturas(List<TransaccionesLocalesFacturas> transaccioneslocalesfacturassAux) throws Exception {
		//this.transaccioneslocalesfacturassAux=transaccioneslocalesfacturassAux;
		
		for(TransaccionesLocalesFacturas transaccioneslocalesfacturasAux:transaccioneslocalesfacturassAux) {
			if(transaccioneslocalesfacturasAux.getIsChanged()) {
				transaccioneslocalesfacturasAux.setIsChanged(false);
			}		
			
			if(transaccioneslocalesfacturasAux.getIsNew()) {
				transaccioneslocalesfacturasAux.setIsNew(false);
			}	
			
			if(transaccioneslocalesfacturasAux.getIsDeleted()) {
				transaccioneslocalesfacturasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransaccionesLocalesFacturas(TransaccionesLocalesFacturas transaccioneslocalesfacturasAux) throws Exception {
		//this.transaccioneslocalesfacturasAux=transaccioneslocalesfacturasAux;
		
			if(transaccioneslocalesfacturasAux.getIsChanged()) {
				transaccioneslocalesfacturasAux.setIsChanged(false);
			}		
			
			if(transaccioneslocalesfacturasAux.getIsNew()) {
				transaccioneslocalesfacturasAux.setIsNew(false);
			}	
			
			if(transaccioneslocalesfacturasAux.getIsDeleted()) {
				transaccioneslocalesfacturasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TransaccionesLocalesFacturas transaccioneslocalesfacturasAsignar,TransaccionesLocalesFacturas transaccioneslocalesfacturas) throws Exception {
		transaccioneslocalesfacturasAsignar.setId(transaccioneslocalesfacturas.getId());	
		transaccioneslocalesfacturasAsignar.setVersionRow(transaccioneslocalesfacturas.getVersionRow());	
		transaccioneslocalesfacturasAsignar.setnombre_completo_cliente(transaccioneslocalesfacturas.getnombre_completo_cliente());	
		transaccioneslocalesfacturasAsignar.settotal_iva(transaccioneslocalesfacturas.gettotal_iva());	
		transaccioneslocalesfacturasAsignar.settotal_sin_iva(transaccioneslocalesfacturas.gettotal_sin_iva());	
		transaccioneslocalesfacturasAsignar.settotal_descuento(transaccioneslocalesfacturas.gettotal_descuento());	
		transaccioneslocalesfacturasAsignar.settotal(transaccioneslocalesfacturas.gettotal());	
		transaccioneslocalesfacturasAsignar.setiva(transaccioneslocalesfacturas.getiva());	
		transaccioneslocalesfacturasAsignar.setruc_cliente(transaccioneslocalesfacturas.getruc_cliente());	
	}
	
	public static void inicializarTransaccionesLocalesFacturas(TransaccionesLocalesFacturas transaccioneslocalesfacturas) throws Exception {
		try {
				transaccioneslocalesfacturas.setId(0L);	
					
				transaccioneslocalesfacturas.setnombre_completo_cliente("");	
				transaccioneslocalesfacturas.settotal_iva(0.0);	
				transaccioneslocalesfacturas.settotal_sin_iva(0.0);	
				transaccioneslocalesfacturas.settotal_descuento(0.0);	
				transaccioneslocalesfacturas.settotal(0.0);	
				transaccioneslocalesfacturas.setiva(0.0);	
				transaccioneslocalesfacturas.setruc_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransaccionesLocalesFacturas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionesLocalesFacturasConstantesFunciones.LABEL_RUCCLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransaccionesLocalesFacturas(String sTipo,Row row,Workbook workbook,TransaccionesLocalesFacturas transaccioneslocalesfacturas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioneslocalesfacturas.getruc_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransaccionesLocalesFacturas="";
	
	public String getsFinalQueryTransaccionesLocalesFacturas() {
		return this.sFinalQueryTransaccionesLocalesFacturas;
	}
	
	public void setsFinalQueryTransaccionesLocalesFacturas(String sFinalQueryTransaccionesLocalesFacturas) {
		this.sFinalQueryTransaccionesLocalesFacturas= sFinalQueryTransaccionesLocalesFacturas;
	}
	
	public Border resaltarSeleccionarTransaccionesLocalesFacturas=null;
	
	public Border setResaltarSeleccionarTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransaccionesLocalesFacturas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransaccionesLocalesFacturas() {
		return this.resaltarSeleccionarTransaccionesLocalesFacturas;
	}
	
	public void setResaltarSeleccionarTransaccionesLocalesFacturas(Border borderResaltarSeleccionarTransaccionesLocalesFacturas) {
		this.resaltarSeleccionarTransaccionesLocalesFacturas= borderResaltarSeleccionarTransaccionesLocalesFacturas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransaccionesLocalesFacturas=null;
	public Boolean mostraridTransaccionesLocalesFacturas=true;
	public Boolean activaridTransaccionesLocalesFacturas=true;

	public Border resaltarid_empresaTransaccionesLocalesFacturas=null;
	public Boolean mostrarid_empresaTransaccionesLocalesFacturas=true;
	public Boolean activarid_empresaTransaccionesLocalesFacturas=true;
	public Boolean cargarid_empresaTransaccionesLocalesFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransaccionesLocalesFacturas=false;//ConEventDepend=true

	public Border resaltarid_ejercicioTransaccionesLocalesFacturas=null;
	public Boolean mostrarid_ejercicioTransaccionesLocalesFacturas=true;
	public Boolean activarid_ejercicioTransaccionesLocalesFacturas=true;
	public Boolean cargarid_ejercicioTransaccionesLocalesFacturas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioTransaccionesLocalesFacturas=false;//ConEventDepend=true

	public Border resaltarfecha_desdeTransaccionesLocalesFacturas=null;
	public Boolean mostrarfecha_desdeTransaccionesLocalesFacturas=true;
	public Boolean activarfecha_desdeTransaccionesLocalesFacturas=true;

	public Border resaltarfecha_hastaTransaccionesLocalesFacturas=null;
	public Boolean mostrarfecha_hastaTransaccionesLocalesFacturas=true;
	public Boolean activarfecha_hastaTransaccionesLocalesFacturas=true;

	public Border resaltarnombre_completo_clienteTransaccionesLocalesFacturas=null;
	public Boolean mostrarnombre_completo_clienteTransaccionesLocalesFacturas=true;
	public Boolean activarnombre_completo_clienteTransaccionesLocalesFacturas=true;

	public Border resaltartotal_ivaTransaccionesLocalesFacturas=null;
	public Boolean mostrartotal_ivaTransaccionesLocalesFacturas=true;
	public Boolean activartotal_ivaTransaccionesLocalesFacturas=true;

	public Border resaltartotal_sin_ivaTransaccionesLocalesFacturas=null;
	public Boolean mostrartotal_sin_ivaTransaccionesLocalesFacturas=true;
	public Boolean activartotal_sin_ivaTransaccionesLocalesFacturas=true;

	public Border resaltartotal_descuentoTransaccionesLocalesFacturas=null;
	public Boolean mostrartotal_descuentoTransaccionesLocalesFacturas=true;
	public Boolean activartotal_descuentoTransaccionesLocalesFacturas=true;

	public Border resaltartotalTransaccionesLocalesFacturas=null;
	public Boolean mostrartotalTransaccionesLocalesFacturas=true;
	public Boolean activartotalTransaccionesLocalesFacturas=true;

	public Border resaltarivaTransaccionesLocalesFacturas=null;
	public Boolean mostrarivaTransaccionesLocalesFacturas=true;
	public Boolean activarivaTransaccionesLocalesFacturas=true;

	public Border resaltarruc_clienteTransaccionesLocalesFacturas=null;
	public Boolean mostrarruc_clienteTransaccionesLocalesFacturas=true;
	public Boolean activarruc_clienteTransaccionesLocalesFacturas=true;

	
	

	public Border setResaltaridTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltaridTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransaccionesLocalesFacturas() {
		return this.resaltaridTransaccionesLocalesFacturas;
	}

	public void setResaltaridTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltaridTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostraridTransaccionesLocalesFacturas() {
		return this.mostraridTransaccionesLocalesFacturas;
	}

	public void setMostraridTransaccionesLocalesFacturas(Boolean mostraridTransaccionesLocalesFacturas) {
		this.mostraridTransaccionesLocalesFacturas= mostraridTransaccionesLocalesFacturas;
	}

	public Boolean getActivaridTransaccionesLocalesFacturas() {
		return this.activaridTransaccionesLocalesFacturas;
	}

	public void setActivaridTransaccionesLocalesFacturas(Boolean activaridTransaccionesLocalesFacturas) {
		this.activaridTransaccionesLocalesFacturas= activaridTransaccionesLocalesFacturas;
	}

	public Border setResaltarid_empresaTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransaccionesLocalesFacturas() {
		return this.resaltarid_empresaTransaccionesLocalesFacturas;
	}

	public void setResaltarid_empresaTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltarid_empresaTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransaccionesLocalesFacturas() {
		return this.mostrarid_empresaTransaccionesLocalesFacturas;
	}

	public void setMostrarid_empresaTransaccionesLocalesFacturas(Boolean mostrarid_empresaTransaccionesLocalesFacturas) {
		this.mostrarid_empresaTransaccionesLocalesFacturas= mostrarid_empresaTransaccionesLocalesFacturas;
	}

	public Boolean getActivarid_empresaTransaccionesLocalesFacturas() {
		return this.activarid_empresaTransaccionesLocalesFacturas;
	}

	public void setActivarid_empresaTransaccionesLocalesFacturas(Boolean activarid_empresaTransaccionesLocalesFacturas) {
		this.activarid_empresaTransaccionesLocalesFacturas= activarid_empresaTransaccionesLocalesFacturas;
	}

	public Boolean getCargarid_empresaTransaccionesLocalesFacturas() {
		return this.cargarid_empresaTransaccionesLocalesFacturas;
	}

	public void setCargarid_empresaTransaccionesLocalesFacturas(Boolean cargarid_empresaTransaccionesLocalesFacturas) {
		this.cargarid_empresaTransaccionesLocalesFacturas= cargarid_empresaTransaccionesLocalesFacturas;
	}

	public Border setResaltarid_ejercicioTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioTransaccionesLocalesFacturas() {
		return this.resaltarid_ejercicioTransaccionesLocalesFacturas;
	}

	public void setResaltarid_ejercicioTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltarid_ejercicioTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioTransaccionesLocalesFacturas() {
		return this.mostrarid_ejercicioTransaccionesLocalesFacturas;
	}

	public void setMostrarid_ejercicioTransaccionesLocalesFacturas(Boolean mostrarid_ejercicioTransaccionesLocalesFacturas) {
		this.mostrarid_ejercicioTransaccionesLocalesFacturas= mostrarid_ejercicioTransaccionesLocalesFacturas;
	}

	public Boolean getActivarid_ejercicioTransaccionesLocalesFacturas() {
		return this.activarid_ejercicioTransaccionesLocalesFacturas;
	}

	public void setActivarid_ejercicioTransaccionesLocalesFacturas(Boolean activarid_ejercicioTransaccionesLocalesFacturas) {
		this.activarid_ejercicioTransaccionesLocalesFacturas= activarid_ejercicioTransaccionesLocalesFacturas;
	}

	public Boolean getCargarid_ejercicioTransaccionesLocalesFacturas() {
		return this.cargarid_ejercicioTransaccionesLocalesFacturas;
	}

	public void setCargarid_ejercicioTransaccionesLocalesFacturas(Boolean cargarid_ejercicioTransaccionesLocalesFacturas) {
		this.cargarid_ejercicioTransaccionesLocalesFacturas= cargarid_ejercicioTransaccionesLocalesFacturas;
	}

	public Border setResaltarfecha_desdeTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeTransaccionesLocalesFacturas() {
		return this.resaltarfecha_desdeTransaccionesLocalesFacturas;
	}

	public void setResaltarfecha_desdeTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltarfecha_desdeTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeTransaccionesLocalesFacturas() {
		return this.mostrarfecha_desdeTransaccionesLocalesFacturas;
	}

	public void setMostrarfecha_desdeTransaccionesLocalesFacturas(Boolean mostrarfecha_desdeTransaccionesLocalesFacturas) {
		this.mostrarfecha_desdeTransaccionesLocalesFacturas= mostrarfecha_desdeTransaccionesLocalesFacturas;
	}

	public Boolean getActivarfecha_desdeTransaccionesLocalesFacturas() {
		return this.activarfecha_desdeTransaccionesLocalesFacturas;
	}

	public void setActivarfecha_desdeTransaccionesLocalesFacturas(Boolean activarfecha_desdeTransaccionesLocalesFacturas) {
		this.activarfecha_desdeTransaccionesLocalesFacturas= activarfecha_desdeTransaccionesLocalesFacturas;
	}

	public Border setResaltarfecha_hastaTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaTransaccionesLocalesFacturas() {
		return this.resaltarfecha_hastaTransaccionesLocalesFacturas;
	}

	public void setResaltarfecha_hastaTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltarfecha_hastaTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaTransaccionesLocalesFacturas() {
		return this.mostrarfecha_hastaTransaccionesLocalesFacturas;
	}

	public void setMostrarfecha_hastaTransaccionesLocalesFacturas(Boolean mostrarfecha_hastaTransaccionesLocalesFacturas) {
		this.mostrarfecha_hastaTransaccionesLocalesFacturas= mostrarfecha_hastaTransaccionesLocalesFacturas;
	}

	public Boolean getActivarfecha_hastaTransaccionesLocalesFacturas() {
		return this.activarfecha_hastaTransaccionesLocalesFacturas;
	}

	public void setActivarfecha_hastaTransaccionesLocalesFacturas(Boolean activarfecha_hastaTransaccionesLocalesFacturas) {
		this.activarfecha_hastaTransaccionesLocalesFacturas= activarfecha_hastaTransaccionesLocalesFacturas;
	}

	public Border setResaltarnombre_completo_clienteTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteTransaccionesLocalesFacturas() {
		return this.resaltarnombre_completo_clienteTransaccionesLocalesFacturas;
	}

	public void setResaltarnombre_completo_clienteTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltarnombre_completo_clienteTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteTransaccionesLocalesFacturas() {
		return this.mostrarnombre_completo_clienteTransaccionesLocalesFacturas;
	}

	public void setMostrarnombre_completo_clienteTransaccionesLocalesFacturas(Boolean mostrarnombre_completo_clienteTransaccionesLocalesFacturas) {
		this.mostrarnombre_completo_clienteTransaccionesLocalesFacturas= mostrarnombre_completo_clienteTransaccionesLocalesFacturas;
	}

	public Boolean getActivarnombre_completo_clienteTransaccionesLocalesFacturas() {
		return this.activarnombre_completo_clienteTransaccionesLocalesFacturas;
	}

	public void setActivarnombre_completo_clienteTransaccionesLocalesFacturas(Boolean activarnombre_completo_clienteTransaccionesLocalesFacturas) {
		this.activarnombre_completo_clienteTransaccionesLocalesFacturas= activarnombre_completo_clienteTransaccionesLocalesFacturas;
	}

	public Border setResaltartotal_ivaTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltartotal_ivaTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaTransaccionesLocalesFacturas() {
		return this.resaltartotal_ivaTransaccionesLocalesFacturas;
	}

	public void setResaltartotal_ivaTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltartotal_ivaTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrartotal_ivaTransaccionesLocalesFacturas() {
		return this.mostrartotal_ivaTransaccionesLocalesFacturas;
	}

	public void setMostrartotal_ivaTransaccionesLocalesFacturas(Boolean mostrartotal_ivaTransaccionesLocalesFacturas) {
		this.mostrartotal_ivaTransaccionesLocalesFacturas= mostrartotal_ivaTransaccionesLocalesFacturas;
	}

	public Boolean getActivartotal_ivaTransaccionesLocalesFacturas() {
		return this.activartotal_ivaTransaccionesLocalesFacturas;
	}

	public void setActivartotal_ivaTransaccionesLocalesFacturas(Boolean activartotal_ivaTransaccionesLocalesFacturas) {
		this.activartotal_ivaTransaccionesLocalesFacturas= activartotal_ivaTransaccionesLocalesFacturas;
	}

	public Border setResaltartotal_sin_ivaTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaTransaccionesLocalesFacturas() {
		return this.resaltartotal_sin_ivaTransaccionesLocalesFacturas;
	}

	public void setResaltartotal_sin_ivaTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltartotal_sin_ivaTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaTransaccionesLocalesFacturas() {
		return this.mostrartotal_sin_ivaTransaccionesLocalesFacturas;
	}

	public void setMostrartotal_sin_ivaTransaccionesLocalesFacturas(Boolean mostrartotal_sin_ivaTransaccionesLocalesFacturas) {
		this.mostrartotal_sin_ivaTransaccionesLocalesFacturas= mostrartotal_sin_ivaTransaccionesLocalesFacturas;
	}

	public Boolean getActivartotal_sin_ivaTransaccionesLocalesFacturas() {
		return this.activartotal_sin_ivaTransaccionesLocalesFacturas;
	}

	public void setActivartotal_sin_ivaTransaccionesLocalesFacturas(Boolean activartotal_sin_ivaTransaccionesLocalesFacturas) {
		this.activartotal_sin_ivaTransaccionesLocalesFacturas= activartotal_sin_ivaTransaccionesLocalesFacturas;
	}

	public Border setResaltartotal_descuentoTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoTransaccionesLocalesFacturas() {
		return this.resaltartotal_descuentoTransaccionesLocalesFacturas;
	}

	public void setResaltartotal_descuentoTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltartotal_descuentoTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoTransaccionesLocalesFacturas() {
		return this.mostrartotal_descuentoTransaccionesLocalesFacturas;
	}

	public void setMostrartotal_descuentoTransaccionesLocalesFacturas(Boolean mostrartotal_descuentoTransaccionesLocalesFacturas) {
		this.mostrartotal_descuentoTransaccionesLocalesFacturas= mostrartotal_descuentoTransaccionesLocalesFacturas;
	}

	public Boolean getActivartotal_descuentoTransaccionesLocalesFacturas() {
		return this.activartotal_descuentoTransaccionesLocalesFacturas;
	}

	public void setActivartotal_descuentoTransaccionesLocalesFacturas(Boolean activartotal_descuentoTransaccionesLocalesFacturas) {
		this.activartotal_descuentoTransaccionesLocalesFacturas= activartotal_descuentoTransaccionesLocalesFacturas;
	}

	public Border setResaltartotalTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltartotalTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalTransaccionesLocalesFacturas() {
		return this.resaltartotalTransaccionesLocalesFacturas;
	}

	public void setResaltartotalTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltartotalTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrartotalTransaccionesLocalesFacturas() {
		return this.mostrartotalTransaccionesLocalesFacturas;
	}

	public void setMostrartotalTransaccionesLocalesFacturas(Boolean mostrartotalTransaccionesLocalesFacturas) {
		this.mostrartotalTransaccionesLocalesFacturas= mostrartotalTransaccionesLocalesFacturas;
	}

	public Boolean getActivartotalTransaccionesLocalesFacturas() {
		return this.activartotalTransaccionesLocalesFacturas;
	}

	public void setActivartotalTransaccionesLocalesFacturas(Boolean activartotalTransaccionesLocalesFacturas) {
		this.activartotalTransaccionesLocalesFacturas= activartotalTransaccionesLocalesFacturas;
	}

	public Border setResaltarivaTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltarivaTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaTransaccionesLocalesFacturas() {
		return this.resaltarivaTransaccionesLocalesFacturas;
	}

	public void setResaltarivaTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltarivaTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrarivaTransaccionesLocalesFacturas() {
		return this.mostrarivaTransaccionesLocalesFacturas;
	}

	public void setMostrarivaTransaccionesLocalesFacturas(Boolean mostrarivaTransaccionesLocalesFacturas) {
		this.mostrarivaTransaccionesLocalesFacturas= mostrarivaTransaccionesLocalesFacturas;
	}

	public Boolean getActivarivaTransaccionesLocalesFacturas() {
		return this.activarivaTransaccionesLocalesFacturas;
	}

	public void setActivarivaTransaccionesLocalesFacturas(Boolean activarivaTransaccionesLocalesFacturas) {
		this.activarivaTransaccionesLocalesFacturas= activarivaTransaccionesLocalesFacturas;
	}

	public Border setResaltarruc_clienteTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccioneslocalesfacturasBeanSwingJInternalFrame.jTtoolBarTransaccionesLocalesFacturas.setBorder(borderResaltar);
		
		this.resaltarruc_clienteTransaccionesLocalesFacturas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_clienteTransaccionesLocalesFacturas() {
		return this.resaltarruc_clienteTransaccionesLocalesFacturas;
	}

	public void setResaltarruc_clienteTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltarruc_clienteTransaccionesLocalesFacturas= borderResaltar;
	}

	public Boolean getMostrarruc_clienteTransaccionesLocalesFacturas() {
		return this.mostrarruc_clienteTransaccionesLocalesFacturas;
	}

	public void setMostrarruc_clienteTransaccionesLocalesFacturas(Boolean mostrarruc_clienteTransaccionesLocalesFacturas) {
		this.mostrarruc_clienteTransaccionesLocalesFacturas= mostrarruc_clienteTransaccionesLocalesFacturas;
	}

	public Boolean getActivarruc_clienteTransaccionesLocalesFacturas() {
		return this.activarruc_clienteTransaccionesLocalesFacturas;
	}

	public void setActivarruc_clienteTransaccionesLocalesFacturas(Boolean activarruc_clienteTransaccionesLocalesFacturas) {
		this.activarruc_clienteTransaccionesLocalesFacturas= activarruc_clienteTransaccionesLocalesFacturas;
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
		
		
		this.setMostraridTransaccionesLocalesFacturas(esInicial);
		this.setMostrarid_empresaTransaccionesLocalesFacturas(esInicial);
		this.setMostrarid_ejercicioTransaccionesLocalesFacturas(esInicial);
		this.setMostrarfecha_desdeTransaccionesLocalesFacturas(esInicial);
		this.setMostrarfecha_hastaTransaccionesLocalesFacturas(esInicial);
		this.setMostrarnombre_completo_clienteTransaccionesLocalesFacturas(esInicial);
		this.setMostrartotal_ivaTransaccionesLocalesFacturas(esInicial);
		this.setMostrartotal_sin_ivaTransaccionesLocalesFacturas(esInicial);
		this.setMostrartotal_descuentoTransaccionesLocalesFacturas(esInicial);
		this.setMostrartotalTransaccionesLocalesFacturas(esInicial);
		this.setMostrarivaTransaccionesLocalesFacturas(esInicial);
		this.setMostrarruc_clienteTransaccionesLocalesFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.ID)) {
				this.setMostraridTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTAL)) {
				this.setMostrartotalTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IVA)) {
				this.setMostrarivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE)) {
				this.setMostrarruc_clienteTransaccionesLocalesFacturas(esAsigna);
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
		
		
		this.setActivaridTransaccionesLocalesFacturas(esInicial);
		this.setActivarid_empresaTransaccionesLocalesFacturas(esInicial);
		this.setActivarid_ejercicioTransaccionesLocalesFacturas(esInicial);
		this.setActivarfecha_desdeTransaccionesLocalesFacturas(esInicial);
		this.setActivarfecha_hastaTransaccionesLocalesFacturas(esInicial);
		this.setActivarnombre_completo_clienteTransaccionesLocalesFacturas(esInicial);
		this.setActivartotal_ivaTransaccionesLocalesFacturas(esInicial);
		this.setActivartotal_sin_ivaTransaccionesLocalesFacturas(esInicial);
		this.setActivartotal_descuentoTransaccionesLocalesFacturas(esInicial);
		this.setActivartotalTransaccionesLocalesFacturas(esInicial);
		this.setActivarivaTransaccionesLocalesFacturas(esInicial);
		this.setActivarruc_clienteTransaccionesLocalesFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.ID)) {
				this.setActivaridTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTAL)) {
				this.setActivartotalTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IVA)) {
				this.setActivarivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE)) {
				this.setActivarruc_clienteTransaccionesLocalesFacturas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransaccionesLocalesFacturas(esInicial);
		this.setResaltarid_empresaTransaccionesLocalesFacturas(esInicial);
		this.setResaltarid_ejercicioTransaccionesLocalesFacturas(esInicial);
		this.setResaltarfecha_desdeTransaccionesLocalesFacturas(esInicial);
		this.setResaltarfecha_hastaTransaccionesLocalesFacturas(esInicial);
		this.setResaltarnombre_completo_clienteTransaccionesLocalesFacturas(esInicial);
		this.setResaltartotal_ivaTransaccionesLocalesFacturas(esInicial);
		this.setResaltartotal_sin_ivaTransaccionesLocalesFacturas(esInicial);
		this.setResaltartotal_descuentoTransaccionesLocalesFacturas(esInicial);
		this.setResaltartotalTransaccionesLocalesFacturas(esInicial);
		this.setResaltarivaTransaccionesLocalesFacturas(esInicial);
		this.setResaltarruc_clienteTransaccionesLocalesFacturas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.ID)) {
				this.setResaltaridTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.TOTAL)) {
				this.setResaltartotalTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.IVA)) {
				this.setResaltarivaTransaccionesLocalesFacturas(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionesLocalesFacturasConstantesFunciones.RUCCLIENTE)) {
				this.setResaltarruc_clienteTransaccionesLocalesFacturas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas=true;

	public Boolean getMostrarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas() {
		return this.mostrarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas;
	}

	public void setMostrarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas=true;

	public Boolean getActivarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas() {
		return this.activarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas;
	}

	public void setActivarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas(Boolean habilitarResaltar) {
		this.activarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas=null;

	public Border getResaltarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas() {
		return this.resaltarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas;
	}

	public void setResaltarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas(Border borderResaltar) {
		this.resaltarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas= borderResaltar;
	}

	public void setResaltarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionesLocalesFacturasBeanSwingJInternalFrame transaccioneslocalesfacturasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaTransaccionesLocalesFacturasTransaccionesLocalesFacturas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}