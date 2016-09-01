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
package com.bydan.erp.tesoreria.util.report;

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

import com.bydan.erp.tesoreria.resources.general.AuxiliarGeneral;

import com.bydan.erp.tesoreria.util.report.ProcesoSolicitudesAutorizacionesConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.ProcesoSolicitudesAutorizacionesParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.ProcesoSolicitudesAutorizacionesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProcesoSolicitudesAutorizacionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ProcesoSolicitudesAutorizaciones";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ProcesoSolicitudesAutorizaciones"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProcesoSolicitudesAutorizacionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProcesoSolicitudesAutorizacionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"_"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoSolicitudesAutorizacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"_"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"_"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProcesoSolicitudesAutorizacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"_"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoSolicitudesAutorizacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoSolicitudesAutorizacionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoSolicitudesAutorizacionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoSolicitudesAutorizacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProcesoSolicitudesAutorizacionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProcesoSolicitudesAutorizacionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProcesoSolicitudesAutorizacionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProcesoSolicitudesAutorizacionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProcesoSolicitudesAutorizacionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProcesoSolicitudesAutorizacionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Proceso Solicitudes Autorizacioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Proceso Solicitudes Autorizaciones";
	public static final String SCLASSWEBTITULO_LOWER="Proceso Solicitudes Autorizaciones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ProcesoSolicitudesAutorizaciones";
	public static final String OBJECTNAME="procesosolicitudesautorizaciones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="proceso_solicitudes_autorizaciones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select procesosolicitudesautorizaciones from "+ProcesoSolicitudesAutorizacionesConstantesFunciones.SPERSISTENCENAME+" procesosolicitudesautorizaciones";
	public static String QUERYSELECTNATIVE="select "+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".id,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".version_row,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".id_empresa,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".id_sucursal,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".id_cliente,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".fecha_vencimiento_hasta,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".nombre_moneda,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".numero_pre_impreso_factura,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".fecha_emision,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".fecha_pago,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".fecha_vencimiento,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".debito_mone_local,"+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME+".debito_mone_extra from "+ProcesoSolicitudesAutorizacionesConstantesFunciones.SCHEMA+"."+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME;//+" as "+ProcesoSolicitudesAutorizacionesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String FECHAVENCIMIENTOHASTA= "fecha_vencimiento_hasta";
    public static final String NOMBREMONEDA= "nombre_moneda";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NUMEROPREIMPRESOFACTURA= "numero_pre_impreso_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAPAGO= "fecha_pago";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String DEBITOMONEEXTRA= "debito_mone_extra";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_FECHAVENCIMIENTOHASTA= "Fecha Vencimiento Hasta";
		public static final String LABEL_FECHAVENCIMIENTOHASTA_LOWER= "Fecha Vencimiento Hasta";
    	public static final String LABEL_NOMBREMONEDA= "Nombre Moneda";
		public static final String LABEL_NOMBREMONEDA_LOWER= "Nombre Moneda";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NUMEROPREIMPRESOFACTURA= "Numero Pre Impreso Factura";
		public static final String LABEL_NUMEROPREIMPRESOFACTURA_LOWER= "Numero Pre Impreso Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAPAGO= "Fecha Pago";
		public static final String LABEL_FECHAPAGO_LOWER= "Fecha Pago";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_DEBITOMONEEXTRA= "Debito Mone Extra";
		public static final String LABEL_DEBITOMONEEXTRA_LOWER= "Debito Mone Extra";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_MONEDA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MONEDA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getProcesoSolicitudesAutorizacionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDEMPRESA)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDCLIENTE)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTOHASTA)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBREMONEDA)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NOMBREMONEDA;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAEMISION)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAPAGO)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAPAGO;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONEEXTRA)) {sLabelColumna=ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONEEXTRA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getProcesoSolicitudesAutorizacionesDescripcion(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(procesosolicitudesautorizaciones !=null/* && procesosolicitudesautorizaciones.getId()!=0*/) {
			if(procesosolicitudesautorizaciones.getId()!=null) {
				sDescripcion=procesosolicitudesautorizaciones.getId().toString();
			}//procesosolicitudesautorizacionesprocesosolicitudesautorizaciones.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getProcesoSolicitudesAutorizacionesDescripcionDetallado(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones) {
		String sDescripcion="";
			
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.ID+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getId().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getVersionRow().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getid_empresa().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getid_sucursal().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getid_cliente().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTOHASTA+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getfecha_vencimiento_hasta().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBREMONEDA+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getnombre_moneda()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getnombre_completo_cliente()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.NUMEROPREIMPRESOFACTURA+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getnumero_pre_impreso_factura()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getfecha_emision().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAPAGO+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getfecha_pago().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getfecha_vencimiento().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getdebito_mone_local().toString()+",";
		sDescripcion+=ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONEEXTRA+"=";
		sDescripcion+=procesosolicitudesautorizaciones.getdebito_mone_extra().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setProcesoSolicitudesAutorizacionesDescripcion(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,String sValor) throws Exception {			
		if(procesosolicitudesautorizaciones !=null) {
			//procesosolicitudesautorizacionesprocesosolicitudesautorizaciones.getId().toString();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaProcesoSolicitudesAutorizaciones")) {
			sNombreIndice="Tipo=  Por Cliente Por Fecha Vencimiento Hasta";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
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

	public static String getDetalleIndiceBusquedaProcesoSolicitudesAutorizaciones(Long id_cliente,Date fecha_vencimiento_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();}
		if(fecha_vencimiento_hasta!=null) {sDetalleIndice+=" Fecha Vencimiento Hasta="+fecha_vencimiento_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProcesoSolicitudesAutorizaciones(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		procesosolicitudesautorizaciones.setnombre_moneda(procesosolicitudesautorizaciones.getnombre_moneda().trim());
		procesosolicitudesautorizaciones.setnombre_completo_cliente(procesosolicitudesautorizaciones.getnombre_completo_cliente().trim());
		procesosolicitudesautorizaciones.setnumero_pre_impreso_factura(procesosolicitudesautorizaciones.getnumero_pre_impreso_factura().trim());
	}
	
	public static void quitarEspaciosProcesoSolicitudesAutorizacioness(List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones: procesosolicitudesautorizacioness) {
			procesosolicitudesautorizaciones.setnombre_moneda(procesosolicitudesautorizaciones.getnombre_moneda().trim());
			procesosolicitudesautorizaciones.setnombre_completo_cliente(procesosolicitudesautorizaciones.getnombre_completo_cliente().trim());
			procesosolicitudesautorizaciones.setnumero_pre_impreso_factura(procesosolicitudesautorizaciones.getnumero_pre_impreso_factura().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoSolicitudesAutorizaciones(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && procesosolicitudesautorizaciones.getConCambioAuxiliar()) {
			procesosolicitudesautorizaciones.setIsDeleted(procesosolicitudesautorizaciones.getIsDeletedAuxiliar());	
			procesosolicitudesautorizaciones.setIsNew(procesosolicitudesautorizaciones.getIsNewAuxiliar());	
			procesosolicitudesautorizaciones.setIsChanged(procesosolicitudesautorizaciones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			procesosolicitudesautorizaciones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			procesosolicitudesautorizaciones.setIsDeletedAuxiliar(false);	
			procesosolicitudesautorizaciones.setIsNewAuxiliar(false);	
			procesosolicitudesautorizaciones.setIsChangedAuxiliar(false);
			
			procesosolicitudesautorizaciones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProcesoSolicitudesAutorizacioness(List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones : procesosolicitudesautorizacioness) {
			if(conAsignarBase && procesosolicitudesautorizaciones.getConCambioAuxiliar()) {
				procesosolicitudesautorizaciones.setIsDeleted(procesosolicitudesautorizaciones.getIsDeletedAuxiliar());	
				procesosolicitudesautorizaciones.setIsNew(procesosolicitudesautorizaciones.getIsNewAuxiliar());	
				procesosolicitudesautorizaciones.setIsChanged(procesosolicitudesautorizaciones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				procesosolicitudesautorizaciones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				procesosolicitudesautorizaciones.setIsDeletedAuxiliar(false);	
				procesosolicitudesautorizaciones.setIsNewAuxiliar(false);	
				procesosolicitudesautorizaciones.setIsChangedAuxiliar(false);
				
				procesosolicitudesautorizaciones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProcesoSolicitudesAutorizaciones(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,Boolean conEnteros) throws Exception  {
		procesosolicitudesautorizaciones.setdebito_mone_local(0.0);
		procesosolicitudesautorizaciones.setdebito_mone_extra(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProcesoSolicitudesAutorizacioness(List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,Boolean conEnteros) throws Exception  {
		
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones: procesosolicitudesautorizacioness) {
			procesosolicitudesautorizaciones.setdebito_mone_local(0.0);
			procesosolicitudesautorizaciones.setdebito_mone_extra(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProcesoSolicitudesAutorizaciones(List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesAux) throws Exception  {
		ProcesoSolicitudesAutorizacionesConstantesFunciones.InicializarValoresProcesoSolicitudesAutorizaciones(procesosolicitudesautorizacionesAux,true);
		
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones: procesosolicitudesautorizacioness) {
			if(procesosolicitudesautorizaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			procesosolicitudesautorizacionesAux.setdebito_mone_local(procesosolicitudesautorizacionesAux.getdebito_mone_local()+procesosolicitudesautorizaciones.getdebito_mone_local());			
			procesosolicitudesautorizacionesAux.setdebito_mone_extra(procesosolicitudesautorizacionesAux.getdebito_mone_extra()+procesosolicitudesautorizaciones.getdebito_mone_extra());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoSolicitudesAutorizaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProcesoSolicitudesAutorizacionesConstantesFunciones.getArrayColumnasGlobalesProcesoSolicitudesAutorizaciones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProcesoSolicitudesAutorizaciones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProcesoSolicitudesAutorizaciones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesAux: procesosolicitudesautorizacioness) {
			if(procesosolicitudesautorizacionesAux!=null && procesosolicitudesautorizaciones!=null) {
				if((procesosolicitudesautorizacionesAux.getId()==null && procesosolicitudesautorizaciones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(procesosolicitudesautorizacionesAux.getId()!=null && procesosolicitudesautorizaciones.getId()!=null){
					if(procesosolicitudesautorizacionesAux.getId().equals(procesosolicitudesautorizaciones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProcesoSolicitudesAutorizaciones(List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double debito_mone_extraTotal=0.0;
	
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones: procesosolicitudesautorizacioness) {			
			if(procesosolicitudesautorizaciones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=procesosolicitudesautorizaciones.getdebito_mone_local();
			debito_mone_extraTotal+=procesosolicitudesautorizaciones.getdebito_mone_extra();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONEEXTRA);
		datoGeneral.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		datoGeneral.setdValorDouble(debito_mone_extraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProcesoSolicitudesAutorizaciones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProcesoSolicitudesAutorizaciones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoSolicitudesAutorizaciones() throws Exception  {
		return ProcesoSolicitudesAutorizacionesConstantesFunciones.getTiposSeleccionarProcesoSolicitudesAutorizaciones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoSolicitudesAutorizaciones(Boolean conFk) throws Exception  {
		return ProcesoSolicitudesAutorizacionesConstantesFunciones.getTiposSeleccionarProcesoSolicitudesAutorizaciones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProcesoSolicitudesAutorizaciones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NOMBREMONEDA);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NOMBREMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAPAGO);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONEEXTRA);
			reporte.setsDescripcion(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONEEXTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProcesoSolicitudesAutorizaciones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoSolicitudesAutorizaciones(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesAux) throws Exception {
		
			procesosolicitudesautorizacionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesosolicitudesautorizacionesAux.getEmpresa()));
			procesosolicitudesautorizacionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesosolicitudesautorizacionesAux.getSucursal()));
			procesosolicitudesautorizacionesAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(procesosolicitudesautorizacionesAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProcesoSolicitudesAutorizaciones(List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacionessTemp) throws Exception {
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesAux:procesosolicitudesautorizacionessTemp) {
			
			procesosolicitudesautorizacionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(procesosolicitudesautorizacionesAux.getEmpresa()));
			procesosolicitudesautorizacionesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(procesosolicitudesautorizacionesAux.getSucursal()));
			procesosolicitudesautorizacionesAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(procesosolicitudesautorizacionesAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProcesoSolicitudesAutorizaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProcesoSolicitudesAutorizaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoSolicitudesAutorizaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoSolicitudesAutorizacionesConstantesFunciones.getClassesRelationshipsOfProcesoSolicitudesAutorizaciones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProcesoSolicitudesAutorizaciones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoSolicitudesAutorizaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProcesoSolicitudesAutorizacionesConstantesFunciones.getClassesRelationshipsFromStringsOfProcesoSolicitudesAutorizaciones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProcesoSolicitudesAutorizaciones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacioness) throws Exception {
		try	{			
			for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesLocal:procesosolicitudesautorizacioness) {
				if(procesosolicitudesautorizacionesLocal.getId().equals(procesosolicitudesautorizaciones.getId())) {
					procesosolicitudesautorizacionesLocal.setIsSelected(procesosolicitudesautorizaciones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProcesoSolicitudesAutorizaciones(List<ProcesoSolicitudesAutorizaciones> procesosolicitudesautorizacionessAux) throws Exception {
		//this.procesosolicitudesautorizacionessAux=procesosolicitudesautorizacionessAux;
		
		for(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesAux:procesosolicitudesautorizacionessAux) {
			if(procesosolicitudesautorizacionesAux.getIsChanged()) {
				procesosolicitudesautorizacionesAux.setIsChanged(false);
			}		
			
			if(procesosolicitudesautorizacionesAux.getIsNew()) {
				procesosolicitudesautorizacionesAux.setIsNew(false);
			}	
			
			if(procesosolicitudesautorizacionesAux.getIsDeleted()) {
				procesosolicitudesautorizacionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProcesoSolicitudesAutorizaciones(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesAux) throws Exception {
		//this.procesosolicitudesautorizacionesAux=procesosolicitudesautorizacionesAux;
		
			if(procesosolicitudesautorizacionesAux.getIsChanged()) {
				procesosolicitudesautorizacionesAux.setIsChanged(false);
			}		
			
			if(procesosolicitudesautorizacionesAux.getIsNew()) {
				procesosolicitudesautorizacionesAux.setIsNew(false);
			}	
			
			if(procesosolicitudesautorizacionesAux.getIsDeleted()) {
				procesosolicitudesautorizacionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizacionesAsignar,ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones) throws Exception {
		procesosolicitudesautorizacionesAsignar.setId(procesosolicitudesautorizaciones.getId());	
		procesosolicitudesautorizacionesAsignar.setVersionRow(procesosolicitudesautorizaciones.getVersionRow());	
		procesosolicitudesautorizacionesAsignar.setnombre_moneda(procesosolicitudesautorizaciones.getnombre_moneda());	
		procesosolicitudesautorizacionesAsignar.setnombre_completo_cliente(procesosolicitudesautorizaciones.getnombre_completo_cliente());	
		procesosolicitudesautorizacionesAsignar.setnumero_pre_impreso_factura(procesosolicitudesautorizaciones.getnumero_pre_impreso_factura());	
		procesosolicitudesautorizacionesAsignar.setfecha_emision(procesosolicitudesautorizaciones.getfecha_emision());	
		procesosolicitudesautorizacionesAsignar.setfecha_pago(procesosolicitudesautorizaciones.getfecha_pago());	
		procesosolicitudesautorizacionesAsignar.setfecha_vencimiento(procesosolicitudesautorizaciones.getfecha_vencimiento());	
		procesosolicitudesautorizacionesAsignar.setdebito_mone_local(procesosolicitudesautorizaciones.getdebito_mone_local());	
		procesosolicitudesautorizacionesAsignar.setdebito_mone_extra(procesosolicitudesautorizaciones.getdebito_mone_extra());	
	}
	
	public static void inicializarProcesoSolicitudesAutorizaciones(ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones) throws Exception {
		try {
				procesosolicitudesautorizaciones.setId(0L);	
					
				procesosolicitudesautorizaciones.setnombre_moneda("");	
				procesosolicitudesautorizaciones.setnombre_completo_cliente("");	
				procesosolicitudesautorizaciones.setnumero_pre_impreso_factura("");	
				procesosolicitudesautorizaciones.setfecha_emision(new Date());	
				procesosolicitudesautorizaciones.setfecha_pago(new Date());	
				procesosolicitudesautorizaciones.setfecha_vencimiento(new Date());	
				procesosolicitudesautorizaciones.setdebito_mone_local(0.0);	
				procesosolicitudesautorizaciones.setdebito_mone_extra(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProcesoSolicitudesAutorizaciones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAVENCIMIENTOHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NOMBREMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProcesoSolicitudesAutorizacionesConstantesFunciones.LABEL_DEBITOMONEEXTRA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProcesoSolicitudesAutorizaciones(String sTipo,Row row,Workbook workbook,ProcesoSolicitudesAutorizaciones procesosolicitudesautorizaciones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getfecha_vencimiento_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getnombre_moneda());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getnumero_pre_impreso_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getfecha_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(procesosolicitudesautorizaciones.getdebito_mone_extra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProcesoSolicitudesAutorizaciones="";
	
	public String getsFinalQueryProcesoSolicitudesAutorizaciones() {
		return this.sFinalQueryProcesoSolicitudesAutorizaciones;
	}
	
	public void setsFinalQueryProcesoSolicitudesAutorizaciones(String sFinalQueryProcesoSolicitudesAutorizaciones) {
		this.sFinalQueryProcesoSolicitudesAutorizaciones= sFinalQueryProcesoSolicitudesAutorizaciones;
	}
	
	public Border resaltarSeleccionarProcesoSolicitudesAutorizaciones=null;
	
	public Border setResaltarSeleccionarProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProcesoSolicitudesAutorizaciones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProcesoSolicitudesAutorizaciones() {
		return this.resaltarSeleccionarProcesoSolicitudesAutorizaciones;
	}
	
	public void setResaltarSeleccionarProcesoSolicitudesAutorizaciones(Border borderResaltarSeleccionarProcesoSolicitudesAutorizaciones) {
		this.resaltarSeleccionarProcesoSolicitudesAutorizaciones= borderResaltarSeleccionarProcesoSolicitudesAutorizaciones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProcesoSolicitudesAutorizaciones=null;
	public Boolean mostraridProcesoSolicitudesAutorizaciones=true;
	public Boolean activaridProcesoSolicitudesAutorizaciones=true;

	public Border resaltarid_empresaProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarid_empresaProcesoSolicitudesAutorizaciones=true;
	public Boolean activarid_empresaProcesoSolicitudesAutorizaciones=true;
	public Boolean cargarid_empresaProcesoSolicitudesAutorizaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaProcesoSolicitudesAutorizaciones=false;//ConEventDepend=true

	public Border resaltarid_sucursalProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarid_sucursalProcesoSolicitudesAutorizaciones=true;
	public Boolean activarid_sucursalProcesoSolicitudesAutorizaciones=true;
	public Boolean cargarid_sucursalProcesoSolicitudesAutorizaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalProcesoSolicitudesAutorizaciones=false;//ConEventDepend=true

	public Border resaltarid_clienteProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarid_clienteProcesoSolicitudesAutorizaciones=true;
	public Boolean activarid_clienteProcesoSolicitudesAutorizaciones=true;
	public Boolean cargarid_clienteProcesoSolicitudesAutorizaciones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteProcesoSolicitudesAutorizaciones=false;//ConEventDepend=true

	public Border resaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones=true;
	public Boolean activarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones=true;

	public Border resaltarnombre_monedaProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarnombre_monedaProcesoSolicitudesAutorizaciones=true;
	public Boolean activarnombre_monedaProcesoSolicitudesAutorizaciones=true;

	public Border resaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones=true;
	public Boolean activarnombre_completo_clienteProcesoSolicitudesAutorizaciones=true;

	public Border resaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones=true;
	public Boolean activarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones=true;

	public Border resaltarfecha_emisionProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarfecha_emisionProcesoSolicitudesAutorizaciones=true;
	public Boolean activarfecha_emisionProcesoSolicitudesAutorizaciones=true;

	public Border resaltarfecha_pagoProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarfecha_pagoProcesoSolicitudesAutorizaciones=true;
	public Boolean activarfecha_pagoProcesoSolicitudesAutorizaciones=true;

	public Border resaltarfecha_vencimientoProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrarfecha_vencimientoProcesoSolicitudesAutorizaciones=true;
	public Boolean activarfecha_vencimientoProcesoSolicitudesAutorizaciones=true;

	public Border resaltardebito_mone_localProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrardebito_mone_localProcesoSolicitudesAutorizaciones=true;
	public Boolean activardebito_mone_localProcesoSolicitudesAutorizaciones=true;

	public Border resaltardebito_mone_extraProcesoSolicitudesAutorizaciones=null;
	public Boolean mostrardebito_mone_extraProcesoSolicitudesAutorizaciones=true;
	public Boolean activardebito_mone_extraProcesoSolicitudesAutorizaciones=true;

	
	

	public Border setResaltaridProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltaridProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProcesoSolicitudesAutorizaciones() {
		return this.resaltaridProcesoSolicitudesAutorizaciones;
	}

	public void setResaltaridProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltaridProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostraridProcesoSolicitudesAutorizaciones() {
		return this.mostraridProcesoSolicitudesAutorizaciones;
	}

	public void setMostraridProcesoSolicitudesAutorizaciones(Boolean mostraridProcesoSolicitudesAutorizaciones) {
		this.mostraridProcesoSolicitudesAutorizaciones= mostraridProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivaridProcesoSolicitudesAutorizaciones() {
		return this.activaridProcesoSolicitudesAutorizaciones;
	}

	public void setActivaridProcesoSolicitudesAutorizaciones(Boolean activaridProcesoSolicitudesAutorizaciones) {
		this.activaridProcesoSolicitudesAutorizaciones= activaridProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarid_empresaProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarid_empresaProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaProcesoSolicitudesAutorizaciones() {
		return this.resaltarid_empresaProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarid_empresaProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarid_empresaProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarid_empresaProcesoSolicitudesAutorizaciones() {
		return this.mostrarid_empresaProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarid_empresaProcesoSolicitudesAutorizaciones(Boolean mostrarid_empresaProcesoSolicitudesAutorizaciones) {
		this.mostrarid_empresaProcesoSolicitudesAutorizaciones= mostrarid_empresaProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarid_empresaProcesoSolicitudesAutorizaciones() {
		return this.activarid_empresaProcesoSolicitudesAutorizaciones;
	}

	public void setActivarid_empresaProcesoSolicitudesAutorizaciones(Boolean activarid_empresaProcesoSolicitudesAutorizaciones) {
		this.activarid_empresaProcesoSolicitudesAutorizaciones= activarid_empresaProcesoSolicitudesAutorizaciones;
	}

	public Boolean getCargarid_empresaProcesoSolicitudesAutorizaciones() {
		return this.cargarid_empresaProcesoSolicitudesAutorizaciones;
	}

	public void setCargarid_empresaProcesoSolicitudesAutorizaciones(Boolean cargarid_empresaProcesoSolicitudesAutorizaciones) {
		this.cargarid_empresaProcesoSolicitudesAutorizaciones= cargarid_empresaProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarid_sucursalProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarid_sucursalProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalProcesoSolicitudesAutorizaciones() {
		return this.resaltarid_sucursalProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarid_sucursalProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarid_sucursalProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarid_sucursalProcesoSolicitudesAutorizaciones() {
		return this.mostrarid_sucursalProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarid_sucursalProcesoSolicitudesAutorizaciones(Boolean mostrarid_sucursalProcesoSolicitudesAutorizaciones) {
		this.mostrarid_sucursalProcesoSolicitudesAutorizaciones= mostrarid_sucursalProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarid_sucursalProcesoSolicitudesAutorizaciones() {
		return this.activarid_sucursalProcesoSolicitudesAutorizaciones;
	}

	public void setActivarid_sucursalProcesoSolicitudesAutorizaciones(Boolean activarid_sucursalProcesoSolicitudesAutorizaciones) {
		this.activarid_sucursalProcesoSolicitudesAutorizaciones= activarid_sucursalProcesoSolicitudesAutorizaciones;
	}

	public Boolean getCargarid_sucursalProcesoSolicitudesAutorizaciones() {
		return this.cargarid_sucursalProcesoSolicitudesAutorizaciones;
	}

	public void setCargarid_sucursalProcesoSolicitudesAutorizaciones(Boolean cargarid_sucursalProcesoSolicitudesAutorizaciones) {
		this.cargarid_sucursalProcesoSolicitudesAutorizaciones= cargarid_sucursalProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarid_clienteProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarid_clienteProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteProcesoSolicitudesAutorizaciones() {
		return this.resaltarid_clienteProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarid_clienteProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarid_clienteProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarid_clienteProcesoSolicitudesAutorizaciones() {
		return this.mostrarid_clienteProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarid_clienteProcesoSolicitudesAutorizaciones(Boolean mostrarid_clienteProcesoSolicitudesAutorizaciones) {
		this.mostrarid_clienteProcesoSolicitudesAutorizaciones= mostrarid_clienteProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarid_clienteProcesoSolicitudesAutorizaciones() {
		return this.activarid_clienteProcesoSolicitudesAutorizaciones;
	}

	public void setActivarid_clienteProcesoSolicitudesAutorizaciones(Boolean activarid_clienteProcesoSolicitudesAutorizaciones) {
		this.activarid_clienteProcesoSolicitudesAutorizaciones= activarid_clienteProcesoSolicitudesAutorizaciones;
	}

	public Boolean getCargarid_clienteProcesoSolicitudesAutorizaciones() {
		return this.cargarid_clienteProcesoSolicitudesAutorizaciones;
	}

	public void setCargarid_clienteProcesoSolicitudesAutorizaciones(Boolean cargarid_clienteProcesoSolicitudesAutorizaciones) {
		this.cargarid_clienteProcesoSolicitudesAutorizaciones= cargarid_clienteProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones() {
		return this.resaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones() {
		return this.mostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(Boolean mostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones) {
		this.mostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones= mostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones() {
		return this.activarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones;
	}

	public void setActivarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(Boolean activarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones) {
		this.activarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones= activarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarnombre_monedaProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarnombre_monedaProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_monedaProcesoSolicitudesAutorizaciones() {
		return this.resaltarnombre_monedaProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarnombre_monedaProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarnombre_monedaProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarnombre_monedaProcesoSolicitudesAutorizaciones() {
		return this.mostrarnombre_monedaProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarnombre_monedaProcesoSolicitudesAutorizaciones(Boolean mostrarnombre_monedaProcesoSolicitudesAutorizaciones) {
		this.mostrarnombre_monedaProcesoSolicitudesAutorizaciones= mostrarnombre_monedaProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarnombre_monedaProcesoSolicitudesAutorizaciones() {
		return this.activarnombre_monedaProcesoSolicitudesAutorizaciones;
	}

	public void setActivarnombre_monedaProcesoSolicitudesAutorizaciones(Boolean activarnombre_monedaProcesoSolicitudesAutorizaciones) {
		this.activarnombre_monedaProcesoSolicitudesAutorizaciones= activarnombre_monedaProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones() {
		return this.resaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones() {
		return this.mostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones(Boolean mostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones) {
		this.mostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones= mostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarnombre_completo_clienteProcesoSolicitudesAutorizaciones() {
		return this.activarnombre_completo_clienteProcesoSolicitudesAutorizaciones;
	}

	public void setActivarnombre_completo_clienteProcesoSolicitudesAutorizaciones(Boolean activarnombre_completo_clienteProcesoSolicitudesAutorizaciones) {
		this.activarnombre_completo_clienteProcesoSolicitudesAutorizaciones= activarnombre_completo_clienteProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones() {
		return this.resaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones() {
		return this.mostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(Boolean mostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones) {
		this.mostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones= mostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones() {
		return this.activarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones;
	}

	public void setActivarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(Boolean activarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones) {
		this.activarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones= activarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarfecha_emisionProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionProcesoSolicitudesAutorizaciones() {
		return this.resaltarfecha_emisionProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarfecha_emisionProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarfecha_emisionProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionProcesoSolicitudesAutorizaciones() {
		return this.mostrarfecha_emisionProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarfecha_emisionProcesoSolicitudesAutorizaciones(Boolean mostrarfecha_emisionProcesoSolicitudesAutorizaciones) {
		this.mostrarfecha_emisionProcesoSolicitudesAutorizaciones= mostrarfecha_emisionProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarfecha_emisionProcesoSolicitudesAutorizaciones() {
		return this.activarfecha_emisionProcesoSolicitudesAutorizaciones;
	}

	public void setActivarfecha_emisionProcesoSolicitudesAutorizaciones(Boolean activarfecha_emisionProcesoSolicitudesAutorizaciones) {
		this.activarfecha_emisionProcesoSolicitudesAutorizaciones= activarfecha_emisionProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarfecha_pagoProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarfecha_pagoProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_pagoProcesoSolicitudesAutorizaciones() {
		return this.resaltarfecha_pagoProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarfecha_pagoProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarfecha_pagoProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarfecha_pagoProcesoSolicitudesAutorizaciones() {
		return this.mostrarfecha_pagoProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarfecha_pagoProcesoSolicitudesAutorizaciones(Boolean mostrarfecha_pagoProcesoSolicitudesAutorizaciones) {
		this.mostrarfecha_pagoProcesoSolicitudesAutorizaciones= mostrarfecha_pagoProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarfecha_pagoProcesoSolicitudesAutorizaciones() {
		return this.activarfecha_pagoProcesoSolicitudesAutorizaciones;
	}

	public void setActivarfecha_pagoProcesoSolicitudesAutorizaciones(Boolean activarfecha_pagoProcesoSolicitudesAutorizaciones) {
		this.activarfecha_pagoProcesoSolicitudesAutorizaciones= activarfecha_pagoProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltarfecha_vencimientoProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoProcesoSolicitudesAutorizaciones() {
		return this.resaltarfecha_vencimientoProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarfecha_vencimientoProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarfecha_vencimientoProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoProcesoSolicitudesAutorizaciones() {
		return this.mostrarfecha_vencimientoProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarfecha_vencimientoProcesoSolicitudesAutorizaciones(Boolean mostrarfecha_vencimientoProcesoSolicitudesAutorizaciones) {
		this.mostrarfecha_vencimientoProcesoSolicitudesAutorizaciones= mostrarfecha_vencimientoProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivarfecha_vencimientoProcesoSolicitudesAutorizaciones() {
		return this.activarfecha_vencimientoProcesoSolicitudesAutorizaciones;
	}

	public void setActivarfecha_vencimientoProcesoSolicitudesAutorizaciones(Boolean activarfecha_vencimientoProcesoSolicitudesAutorizaciones) {
		this.activarfecha_vencimientoProcesoSolicitudesAutorizaciones= activarfecha_vencimientoProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltardebito_mone_localProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localProcesoSolicitudesAutorizaciones() {
		return this.resaltardebito_mone_localProcesoSolicitudesAutorizaciones;
	}

	public void setResaltardebito_mone_localProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltardebito_mone_localProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localProcesoSolicitudesAutorizaciones() {
		return this.mostrardebito_mone_localProcesoSolicitudesAutorizaciones;
	}

	public void setMostrardebito_mone_localProcesoSolicitudesAutorizaciones(Boolean mostrardebito_mone_localProcesoSolicitudesAutorizaciones) {
		this.mostrardebito_mone_localProcesoSolicitudesAutorizaciones= mostrardebito_mone_localProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivardebito_mone_localProcesoSolicitudesAutorizaciones() {
		return this.activardebito_mone_localProcesoSolicitudesAutorizaciones;
	}

	public void setActivardebito_mone_localProcesoSolicitudesAutorizaciones(Boolean activardebito_mone_localProcesoSolicitudesAutorizaciones) {
		this.activardebito_mone_localProcesoSolicitudesAutorizaciones= activardebito_mone_localProcesoSolicitudesAutorizaciones;
	}

	public Border setResaltardebito_mone_extraProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//procesosolicitudesautorizacionesBeanSwingJInternalFrame.jTtoolBarProcesoSolicitudesAutorizaciones.setBorder(borderResaltar);
		
		this.resaltardebito_mone_extraProcesoSolicitudesAutorizaciones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_extraProcesoSolicitudesAutorizaciones() {
		return this.resaltardebito_mone_extraProcesoSolicitudesAutorizaciones;
	}

	public void setResaltardebito_mone_extraProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltardebito_mone_extraProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public Boolean getMostrardebito_mone_extraProcesoSolicitudesAutorizaciones() {
		return this.mostrardebito_mone_extraProcesoSolicitudesAutorizaciones;
	}

	public void setMostrardebito_mone_extraProcesoSolicitudesAutorizaciones(Boolean mostrardebito_mone_extraProcesoSolicitudesAutorizaciones) {
		this.mostrardebito_mone_extraProcesoSolicitudesAutorizaciones= mostrardebito_mone_extraProcesoSolicitudesAutorizaciones;
	}

	public Boolean getActivardebito_mone_extraProcesoSolicitudesAutorizaciones() {
		return this.activardebito_mone_extraProcesoSolicitudesAutorizaciones;
	}

	public void setActivardebito_mone_extraProcesoSolicitudesAutorizaciones(Boolean activardebito_mone_extraProcesoSolicitudesAutorizaciones) {
		this.activardebito_mone_extraProcesoSolicitudesAutorizaciones= activardebito_mone_extraProcesoSolicitudesAutorizaciones;
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
		
		
		this.setMostraridProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarid_empresaProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarid_sucursalProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarid_clienteProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarnombre_monedaProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarfecha_emisionProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarfecha_pagoProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrarfecha_vencimientoProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrardebito_mone_localProcesoSolicitudesAutorizaciones(esInicial);
		this.setMostrardebito_mone_extraProcesoSolicitudesAutorizaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.ID)) {
				this.setMostraridProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setMostrarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBREMONEDA)) {
				this.setMostrarnombre_monedaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setMostrarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAPAGO)) {
				this.setMostrarfecha_pagoProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setMostrardebito_mone_extraProcesoSolicitudesAutorizaciones(esAsigna);
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
		
		
		this.setActivaridProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarid_empresaProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarid_sucursalProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarid_clienteProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarnombre_monedaProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarnombre_completo_clienteProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarfecha_emisionProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarfecha_pagoProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivarfecha_vencimientoProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivardebito_mone_localProcesoSolicitudesAutorizaciones(esInicial);
		this.setActivardebito_mone_extraProcesoSolicitudesAutorizaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.ID)) {
				this.setActivaridProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setActivarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBREMONEDA)) {
				this.setActivarnombre_monedaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setActivarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAPAGO)) {
				this.setActivarfecha_pagoProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setActivardebito_mone_extraProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarid_empresaProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarid_sucursalProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarid_clienteProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarnombre_monedaProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarfecha_emisionProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarfecha_pagoProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltarfecha_vencimientoProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltardebito_mone_localProcesoSolicitudesAutorizaciones(esInicial);
		this.setResaltardebito_mone_extraProcesoSolicitudesAutorizaciones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.ID)) {
				this.setResaltaridProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTOHASTA)) {
				this.setResaltarfecha_vencimiento_hastaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBREMONEDA)) {
				this.setResaltarnombre_monedaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setResaltarnumero_pre_impreso_facturaProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAPAGO)) {
				this.setResaltarfecha_pagoProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localProcesoSolicitudesAutorizaciones(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProcesoSolicitudesAutorizacionesConstantesFunciones.DEBITOMONEEXTRA)) {
				this.setResaltardebito_mone_extraProcesoSolicitudesAutorizaciones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones=true;

	public Boolean getMostrarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones() {
		return this.mostrarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones;
	}

	public void setMostrarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones=true;

	public Boolean getActivarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones() {
		return this.activarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones;
	}

	public void setActivarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones(Boolean habilitarResaltar) {
		this.activarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones=null;

	public Border getResaltarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones() {
		return this.resaltarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones;
	}

	public void setResaltarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones(Border borderResaltar) {
		this.resaltarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones= borderResaltar;
	}

	public void setResaltarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones(ParametroGeneralUsuario parametroGeneralUsuario/*ProcesoSolicitudesAutorizacionesBeanSwingJInternalFrame procesosolicitudesautorizacionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaProcesoSolicitudesAutorizacionesProcesoSolicitudesAutorizaciones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}