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


import com.bydan.erp.sris.util.report.FacturacionesPorDiariosConstantesFunciones;
import com.bydan.erp.sris.util.report.FacturacionesPorDiariosParameterReturnGeneral;
//import com.bydan.erp.sris.util.report.FacturacionesPorDiariosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.sris.business.dataaccess.*;
//import com.bydan.erp.sris.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturacionesPorDiariosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="FacturacionesPorDiarios";
	public static final String SPATHOPCION="Sris";	
	public static final String SPATHMODULO="sris/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturacionesPorDiarios"+FacturacionesPorDiariosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturacionesPorDiariosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturacionesPorDiariosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturacionesPorDiariosConstantesFunciones.SCHEMA+"_"+FacturacionesPorDiariosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturacionesPorDiariosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturacionesPorDiariosConstantesFunciones.SCHEMA+"_"+FacturacionesPorDiariosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturacionesPorDiariosConstantesFunciones.SCHEMA+"_"+FacturacionesPorDiariosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturacionesPorDiariosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturacionesPorDiariosConstantesFunciones.SCHEMA+"_"+FacturacionesPorDiariosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturacionesPorDiariosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturacionesPorDiariosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturacionesPorDiariosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturacionesPorDiariosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturacionesPorDiariosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturacionesPorDiariosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturacionesPorDiariosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturacionesPorDiariosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturacionesPorDiariosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturacionesPorDiariosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Facturaciones Por Diarioses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Facturaciones Por Diarios";
	public static final String SCLASSWEBTITULO_LOWER="Facturaciones Por Diarios";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturacionesPorDiarios";
	public static final String OBJECTNAME="facturacionespordiarios";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SRIS;	
	public static final String TABLENAME="facturaciones_por_diarios";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturacionespordiarios from "+FacturacionesPorDiariosConstantesFunciones.SPERSISTENCENAME+" facturacionespordiarios";
	public static String QUERYSELECTNATIVE="select "+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".id,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".version_row,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".id_empresa,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".id_transaccion,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".fecha_emision,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".nombre_sucursal,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".codigo_asiento_contable,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".fecha_vence,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".fecha_emision_detalle_cliente,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".monto_mone_local,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".numero_factura,"+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME+".ruc_cliente from "+FacturacionesPorDiariosConstantesFunciones.SCHEMA+"."+FacturacionesPorDiariosConstantesFunciones.TABLENAME;//+" as "+FacturacionesPorDiariosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String CODIGOASIENTOCONTABLE= "codigo_asiento_contable";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String FECHAEMISIONDETALLECLIENTE= "fecha_emision_detalle_cliente";
    public static final String MONTOMONELOCAL= "monto_mone_local";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String RUCCLIENTE= "ruc_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_CODIGOASIENTOCONTABLE= "Codigo Asiento Contable";
		public static final String LABEL_CODIGOASIENTOCONTABLE_LOWER= "Codigo Asiento Contable";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_FECHAEMISIONDETALLECLIENTE= "Fecha Emision Detalle Cliente";
		public static final String LABEL_FECHAEMISIONDETALLECLIENTE_LOWER= "Fecha Emision Detalle Cliente";
    	public static final String LABEL_MONTOMONELOCAL= "Monto Mone Local";
		public static final String LABEL_MONTOMONELOCAL_LOWER= "Monto Mone Local";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_RUCCLIENTE= "Ruc Cliente";
		public static final String LABEL_RUCCLIENTE_LOWER= "Ruc Cliente";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_ASIENTO_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ASIENTO_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getFacturacionesPorDiariosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.IDTRANSACCION)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISION)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.FECHAVENCE)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDETALLECLIENTE;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_MONTOMONELOCAL;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE)) {sLabelColumna=FacturacionesPorDiariosConstantesFunciones.LABEL_RUCCLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturacionesPorDiariosDescripcion(FacturacionesPorDiarios facturacionespordiarios) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturacionespordiarios !=null/* && facturacionespordiarios.getId()!=0*/) {
			sDescripcion=facturacionespordiarios.getfecha_emision_desde().toString();//facturacionespordiariosfacturacionespordiarios.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturacionesPorDiariosDescripcionDetallado(FacturacionesPorDiarios facturacionespordiarios) {
		String sDescripcion="";
			
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.ID+"=";
		sDescripcion+=facturacionespordiarios.getId().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturacionespordiarios.getVersionRow().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturacionespordiarios.getid_empresa().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=facturacionespordiarios.getid_transaccion().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=facturacionespordiarios.getfecha_emision_desde().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=facturacionespordiarios.getfecha_emision_hasta().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=facturacionespordiarios.getfecha_emision().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=facturacionespordiarios.getnombre_sucursal()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=facturacionespordiarios.getnombre_completo_cliente()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=facturacionespordiarios.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE+"=";
		sDescripcion+=facturacionespordiarios.getcodigo_asiento_contable()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=facturacionespordiarios.getfecha_vence().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE+"=";
		sDescripcion+=facturacionespordiarios.getfecha_emision_detalle_cliente().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL+"=";
		sDescripcion+=facturacionespordiarios.getmonto_mone_local().toString()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=facturacionespordiarios.getnumero_factura()+",";
		sDescripcion+=FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE+"=";
		sDescripcion+=facturacionespordiarios.getruc_cliente()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturacionesPorDiariosDescripcion(FacturacionesPorDiarios facturacionespordiarios,String sValor) throws Exception {			
		if(facturacionespordiarios !=null) {
			//facturacionespordiariosfacturacionespordiarios.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaFacturacionesPorDiarios")) {
			sNombreIndice="Tipo=  Por Transaccion Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaFacturacionesPorDiarios(Long id_transaccion,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturacionesPorDiarios(FacturacionesPorDiarios facturacionespordiarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturacionespordiarios.setnombre_sucursal(facturacionespordiarios.getnombre_sucursal().trim());
		facturacionespordiarios.setnombre_completo_cliente(facturacionespordiarios.getnombre_completo_cliente().trim());
		facturacionespordiarios.setcodigo_asiento_contable(facturacionespordiarios.getcodigo_asiento_contable().trim());
		facturacionespordiarios.setnumero_factura(facturacionespordiarios.getnumero_factura().trim());
		facturacionespordiarios.setruc_cliente(facturacionespordiarios.getruc_cliente().trim());
	}
	
	public static void quitarEspaciosFacturacionesPorDiarioss(List<FacturacionesPorDiarios> facturacionespordiarioss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturacionesPorDiarios facturacionespordiarios: facturacionespordiarioss) {
			facturacionespordiarios.setnombre_sucursal(facturacionespordiarios.getnombre_sucursal().trim());
			facturacionespordiarios.setnombre_completo_cliente(facturacionespordiarios.getnombre_completo_cliente().trim());
			facturacionespordiarios.setcodigo_asiento_contable(facturacionespordiarios.getcodigo_asiento_contable().trim());
			facturacionespordiarios.setnumero_factura(facturacionespordiarios.getnumero_factura().trim());
			facturacionespordiarios.setruc_cliente(facturacionespordiarios.getruc_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturacionesPorDiarios(FacturacionesPorDiarios facturacionespordiarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturacionespordiarios.getConCambioAuxiliar()) {
			facturacionespordiarios.setIsDeleted(facturacionespordiarios.getIsDeletedAuxiliar());	
			facturacionespordiarios.setIsNew(facturacionespordiarios.getIsNewAuxiliar());	
			facturacionespordiarios.setIsChanged(facturacionespordiarios.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturacionespordiarios.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturacionespordiarios.setIsDeletedAuxiliar(false);	
			facturacionespordiarios.setIsNewAuxiliar(false);	
			facturacionespordiarios.setIsChangedAuxiliar(false);
			
			facturacionespordiarios.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturacionesPorDiarioss(List<FacturacionesPorDiarios> facturacionespordiarioss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturacionesPorDiarios facturacionespordiarios : facturacionespordiarioss) {
			if(conAsignarBase && facturacionespordiarios.getConCambioAuxiliar()) {
				facturacionespordiarios.setIsDeleted(facturacionespordiarios.getIsDeletedAuxiliar());	
				facturacionespordiarios.setIsNew(facturacionespordiarios.getIsNewAuxiliar());	
				facturacionespordiarios.setIsChanged(facturacionespordiarios.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturacionespordiarios.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturacionespordiarios.setIsDeletedAuxiliar(false);	
				facturacionespordiarios.setIsNewAuxiliar(false);	
				facturacionespordiarios.setIsChangedAuxiliar(false);
				
				facturacionespordiarios.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturacionesPorDiarios(FacturacionesPorDiarios facturacionespordiarios,Boolean conEnteros) throws Exception  {
		facturacionespordiarios.setmonto_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturacionesPorDiarioss(List<FacturacionesPorDiarios> facturacionespordiarioss,Boolean conEnteros) throws Exception  {
		
		for(FacturacionesPorDiarios facturacionespordiarios: facturacionespordiarioss) {
			facturacionespordiarios.setmonto_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturacionesPorDiarios(List<FacturacionesPorDiarios> facturacionespordiarioss,FacturacionesPorDiarios facturacionespordiariosAux) throws Exception  {
		FacturacionesPorDiariosConstantesFunciones.InicializarValoresFacturacionesPorDiarios(facturacionespordiariosAux,true);
		
		for(FacturacionesPorDiarios facturacionespordiarios: facturacionespordiarioss) {
			if(facturacionespordiarios.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturacionespordiariosAux.setmonto_mone_local(facturacionespordiariosAux.getmonto_mone_local()+facturacionespordiarios.getmonto_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturacionesPorDiarios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturacionesPorDiariosConstantesFunciones.getArrayColumnasGlobalesFacturacionesPorDiarios(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturacionesPorDiarios(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturacionesPorDiariosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturacionesPorDiariosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturacionesPorDiarios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturacionesPorDiarios> facturacionespordiarioss,FacturacionesPorDiarios facturacionespordiarios,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturacionesPorDiarios facturacionespordiariosAux: facturacionespordiarioss) {
			if(facturacionespordiariosAux!=null && facturacionespordiarios!=null) {
				if((facturacionespordiariosAux.getId()==null && facturacionespordiarios.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturacionespordiariosAux.getId()!=null && facturacionespordiarios.getId()!=null){
					if(facturacionespordiariosAux.getId().equals(facturacionespordiarios.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturacionesPorDiarios(List<FacturacionesPorDiarios> facturacionespordiarioss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double monto_mone_localTotal=0.0;
	
		for(FacturacionesPorDiarios facturacionespordiarios: facturacionespordiarioss) {			
			if(facturacionespordiarios.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			monto_mone_localTotal+=facturacionespordiarios.getmonto_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL);
		datoGeneral.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_MONTOMONELOCAL);
		datoGeneral.setdValorDouble(monto_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturacionesPorDiarios() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_ID, FacturacionesPorDiariosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_VERSIONROW, FacturacionesPorDiariosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISION, FacturacionesPorDiariosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRESUCURSAL, FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE, FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAVENCE, FacturacionesPorDiariosConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDETALLECLIENTE, FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_MONTOMONELOCAL, FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_NUMEROFACTURA, FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturacionesPorDiariosConstantesFunciones.LABEL_RUCCLIENTE, FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturacionesPorDiarios() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturacionesPorDiarios() throws Exception  {
		return FacturacionesPorDiariosConstantesFunciones.getTiposSeleccionarFacturacionesPorDiarios(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturacionesPorDiarios(Boolean conFk) throws Exception  {
		return FacturacionesPorDiariosConstantesFunciones.getTiposSeleccionarFacturacionesPorDiarios(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturacionesPorDiarios(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDETALLECLIENTE);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDETALLECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_MONTOMONELOCAL);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_MONTOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturacionesPorDiariosConstantesFunciones.LABEL_RUCCLIENTE);
			reporte.setsDescripcion(FacturacionesPorDiariosConstantesFunciones.LABEL_RUCCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturacionesPorDiarios(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturacionesPorDiarios(FacturacionesPorDiarios facturacionespordiariosAux) throws Exception {
		
			facturacionespordiariosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturacionespordiariosAux.getEmpresa()));
			facturacionespordiariosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(facturacionespordiariosAux.getTransaccion()));
			facturacionespordiariosAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(facturacionespordiariosAux.getTipoTransaccionModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturacionesPorDiarios(List<FacturacionesPorDiarios> facturacionespordiariossTemp) throws Exception {
		for(FacturacionesPorDiarios facturacionespordiariosAux:facturacionespordiariossTemp) {
			
			facturacionespordiariosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturacionespordiariosAux.getEmpresa()));
			facturacionespordiariosAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(facturacionespordiariosAux.getTransaccion()));
			facturacionespordiariosAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(facturacionespordiariosAux.getTipoTransaccionModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturacionesPorDiarios(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturacionesPorDiarios(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturacionesPorDiarios(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturacionesPorDiariosConstantesFunciones.getClassesRelationshipsOfFacturacionesPorDiarios(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturacionesPorDiarios(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturacionesPorDiarios(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturacionesPorDiariosConstantesFunciones.getClassesRelationshipsFromStringsOfFacturacionesPorDiarios(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturacionesPorDiarios(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FacturacionesPorDiarios facturacionespordiarios,List<FacturacionesPorDiarios> facturacionespordiarioss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(FacturacionesPorDiarios facturacionespordiarios,List<FacturacionesPorDiarios> facturacionespordiarioss) throws Exception {
		try	{			
			for(FacturacionesPorDiarios facturacionespordiariosLocal:facturacionespordiarioss) {
				if(facturacionespordiariosLocal.getId().equals(facturacionespordiarios.getId())) {
					facturacionespordiariosLocal.setIsSelected(facturacionespordiarios.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturacionesPorDiarios(List<FacturacionesPorDiarios> facturacionespordiariossAux) throws Exception {
		//this.facturacionespordiariossAux=facturacionespordiariossAux;
		
		for(FacturacionesPorDiarios facturacionespordiariosAux:facturacionespordiariossAux) {
			if(facturacionespordiariosAux.getIsChanged()) {
				facturacionespordiariosAux.setIsChanged(false);
			}		
			
			if(facturacionespordiariosAux.getIsNew()) {
				facturacionespordiariosAux.setIsNew(false);
			}	
			
			if(facturacionespordiariosAux.getIsDeleted()) {
				facturacionespordiariosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturacionesPorDiarios(FacturacionesPorDiarios facturacionespordiariosAux) throws Exception {
		//this.facturacionespordiariosAux=facturacionespordiariosAux;
		
			if(facturacionespordiariosAux.getIsChanged()) {
				facturacionespordiariosAux.setIsChanged(false);
			}		
			
			if(facturacionespordiariosAux.getIsNew()) {
				facturacionespordiariosAux.setIsNew(false);
			}	
			
			if(facturacionespordiariosAux.getIsDeleted()) {
				facturacionespordiariosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturacionesPorDiarios facturacionespordiariosAsignar,FacturacionesPorDiarios facturacionespordiarios) throws Exception {
		facturacionespordiariosAsignar.setId(facturacionespordiarios.getId());	
		facturacionespordiariosAsignar.setVersionRow(facturacionespordiarios.getVersionRow());	
		facturacionespordiariosAsignar.setfecha_emision(facturacionespordiarios.getfecha_emision());	
		facturacionespordiariosAsignar.setnombre_sucursal(facturacionespordiarios.getnombre_sucursal());	
		facturacionespordiariosAsignar.setnombre_completo_cliente(facturacionespordiarios.getnombre_completo_cliente());	
		facturacionespordiariosAsignar.setid_tipo_transaccion_modulo(facturacionespordiarios.getid_tipo_transaccion_modulo());
		facturacionespordiariosAsignar.settipotransaccionmodulo_descripcion(facturacionespordiarios.gettipotransaccionmodulo_descripcion());	
		facturacionespordiariosAsignar.setcodigo_asiento_contable(facturacionespordiarios.getcodigo_asiento_contable());	
		facturacionespordiariosAsignar.setfecha_vence(facturacionespordiarios.getfecha_vence());	
		facturacionespordiariosAsignar.setfecha_emision_detalle_cliente(facturacionespordiarios.getfecha_emision_detalle_cliente());	
		facturacionespordiariosAsignar.setmonto_mone_local(facturacionespordiarios.getmonto_mone_local());	
		facturacionespordiariosAsignar.setnumero_factura(facturacionespordiarios.getnumero_factura());	
		facturacionespordiariosAsignar.setruc_cliente(facturacionespordiarios.getruc_cliente());	
	}
	
	public static void inicializarFacturacionesPorDiarios(FacturacionesPorDiarios facturacionespordiarios) throws Exception {
		try {
				facturacionespordiarios.setId(0L);	
					
				facturacionespordiarios.setfecha_emision(new Date());	
				facturacionespordiarios.setnombre_sucursal("");	
				facturacionespordiarios.setnombre_completo_cliente("");	
				facturacionespordiarios.setid_tipo_transaccion_modulo(-1L);	
				facturacionespordiarios.setcodigo_asiento_contable("");	
				facturacionespordiarios.setfecha_vence(new Date());	
				facturacionespordiarios.setfecha_emision_detalle_cliente(new Date());	
				facturacionespordiarios.setmonto_mone_local(0.0);	
				facturacionespordiarios.setnumero_factura("");	
				facturacionespordiarios.setruc_cliente("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturacionesPorDiarios(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_CODIGOASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_FECHAEMISIONDETALLECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_MONTOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturacionesPorDiariosConstantesFunciones.LABEL_RUCCLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturacionesPorDiarios(String sTipo,Row row,Workbook workbook,FacturacionesPorDiarios facturacionespordiarios,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getcodigo_asiento_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getfecha_emision_detalle_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getmonto_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturacionespordiarios.getruc_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturacionesPorDiarios="";
	
	public String getsFinalQueryFacturacionesPorDiarios() {
		return this.sFinalQueryFacturacionesPorDiarios;
	}
	
	public void setsFinalQueryFacturacionesPorDiarios(String sFinalQueryFacturacionesPorDiarios) {
		this.sFinalQueryFacturacionesPorDiarios= sFinalQueryFacturacionesPorDiarios;
	}
	
	public Border resaltarSeleccionarFacturacionesPorDiarios=null;
	
	public Border setResaltarSeleccionarFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturacionesPorDiarios= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturacionesPorDiarios() {
		return this.resaltarSeleccionarFacturacionesPorDiarios;
	}
	
	public void setResaltarSeleccionarFacturacionesPorDiarios(Border borderResaltarSeleccionarFacturacionesPorDiarios) {
		this.resaltarSeleccionarFacturacionesPorDiarios= borderResaltarSeleccionarFacturacionesPorDiarios;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturacionesPorDiarios=null;
	public Boolean mostraridFacturacionesPorDiarios=true;
	public Boolean activaridFacturacionesPorDiarios=true;

	public Border resaltarid_empresaFacturacionesPorDiarios=null;
	public Boolean mostrarid_empresaFacturacionesPorDiarios=true;
	public Boolean activarid_empresaFacturacionesPorDiarios=true;
	public Boolean cargarid_empresaFacturacionesPorDiarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturacionesPorDiarios=false;//ConEventDepend=true

	public Border resaltarid_transaccionFacturacionesPorDiarios=null;
	public Boolean mostrarid_transaccionFacturacionesPorDiarios=true;
	public Boolean activarid_transaccionFacturacionesPorDiarios=true;
	public Boolean cargarid_transaccionFacturacionesPorDiarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionFacturacionesPorDiarios=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeFacturacionesPorDiarios=null;
	public Boolean mostrarfecha_emision_desdeFacturacionesPorDiarios=true;
	public Boolean activarfecha_emision_desdeFacturacionesPorDiarios=true;

	public Border resaltarfecha_emision_hastaFacturacionesPorDiarios=null;
	public Boolean mostrarfecha_emision_hastaFacturacionesPorDiarios=true;
	public Boolean activarfecha_emision_hastaFacturacionesPorDiarios=true;

	public Border resaltarfecha_emisionFacturacionesPorDiarios=null;
	public Boolean mostrarfecha_emisionFacturacionesPorDiarios=true;
	public Boolean activarfecha_emisionFacturacionesPorDiarios=true;

	public Border resaltarnombre_sucursalFacturacionesPorDiarios=null;
	public Boolean mostrarnombre_sucursalFacturacionesPorDiarios=true;
	public Boolean activarnombre_sucursalFacturacionesPorDiarios=true;

	public Border resaltarnombre_completo_clienteFacturacionesPorDiarios=null;
	public Boolean mostrarnombre_completo_clienteFacturacionesPorDiarios=true;
	public Boolean activarnombre_completo_clienteFacturacionesPorDiarios=true;

	public Border resaltarid_tipo_transaccion_moduloFacturacionesPorDiarios=null;
	public Boolean mostrarid_tipo_transaccion_moduloFacturacionesPorDiarios=true;
	public Boolean activarid_tipo_transaccion_moduloFacturacionesPorDiarios=true;
	public Boolean cargarid_tipo_transaccion_moduloFacturacionesPorDiarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloFacturacionesPorDiarios=false;//ConEventDepend=true

	public Border resaltarcodigo_asiento_contableFacturacionesPorDiarios=null;
	public Boolean mostrarcodigo_asiento_contableFacturacionesPorDiarios=true;
	public Boolean activarcodigo_asiento_contableFacturacionesPorDiarios=true;

	public Border resaltarfecha_venceFacturacionesPorDiarios=null;
	public Boolean mostrarfecha_venceFacturacionesPorDiarios=true;
	public Boolean activarfecha_venceFacturacionesPorDiarios=true;

	public Border resaltarfecha_emision_detalle_clienteFacturacionesPorDiarios=null;
	public Boolean mostrarfecha_emision_detalle_clienteFacturacionesPorDiarios=true;
	public Boolean activarfecha_emision_detalle_clienteFacturacionesPorDiarios=true;

	public Border resaltarmonto_mone_localFacturacionesPorDiarios=null;
	public Boolean mostrarmonto_mone_localFacturacionesPorDiarios=true;
	public Boolean activarmonto_mone_localFacturacionesPorDiarios=true;

	public Border resaltarnumero_facturaFacturacionesPorDiarios=null;
	public Boolean mostrarnumero_facturaFacturacionesPorDiarios=true;
	public Boolean activarnumero_facturaFacturacionesPorDiarios=true;

	public Border resaltarruc_clienteFacturacionesPorDiarios=null;
	public Boolean mostrarruc_clienteFacturacionesPorDiarios=true;
	public Boolean activarruc_clienteFacturacionesPorDiarios=true;

	
	

	public Border setResaltaridFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltaridFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturacionesPorDiarios() {
		return this.resaltaridFacturacionesPorDiarios;
	}

	public void setResaltaridFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltaridFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostraridFacturacionesPorDiarios() {
		return this.mostraridFacturacionesPorDiarios;
	}

	public void setMostraridFacturacionesPorDiarios(Boolean mostraridFacturacionesPorDiarios) {
		this.mostraridFacturacionesPorDiarios= mostraridFacturacionesPorDiarios;
	}

	public Boolean getActivaridFacturacionesPorDiarios() {
		return this.activaridFacturacionesPorDiarios;
	}

	public void setActivaridFacturacionesPorDiarios(Boolean activaridFacturacionesPorDiarios) {
		this.activaridFacturacionesPorDiarios= activaridFacturacionesPorDiarios;
	}

	public Border setResaltarid_empresaFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturacionesPorDiarios() {
		return this.resaltarid_empresaFacturacionesPorDiarios;
	}

	public void setResaltarid_empresaFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarid_empresaFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturacionesPorDiarios() {
		return this.mostrarid_empresaFacturacionesPorDiarios;
	}

	public void setMostrarid_empresaFacturacionesPorDiarios(Boolean mostrarid_empresaFacturacionesPorDiarios) {
		this.mostrarid_empresaFacturacionesPorDiarios= mostrarid_empresaFacturacionesPorDiarios;
	}

	public Boolean getActivarid_empresaFacturacionesPorDiarios() {
		return this.activarid_empresaFacturacionesPorDiarios;
	}

	public void setActivarid_empresaFacturacionesPorDiarios(Boolean activarid_empresaFacturacionesPorDiarios) {
		this.activarid_empresaFacturacionesPorDiarios= activarid_empresaFacturacionesPorDiarios;
	}

	public Boolean getCargarid_empresaFacturacionesPorDiarios() {
		return this.cargarid_empresaFacturacionesPorDiarios;
	}

	public void setCargarid_empresaFacturacionesPorDiarios(Boolean cargarid_empresaFacturacionesPorDiarios) {
		this.cargarid_empresaFacturacionesPorDiarios= cargarid_empresaFacturacionesPorDiarios;
	}

	public Border setResaltarid_transaccionFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarid_transaccionFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionFacturacionesPorDiarios() {
		return this.resaltarid_transaccionFacturacionesPorDiarios;
	}

	public void setResaltarid_transaccionFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarid_transaccionFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarid_transaccionFacturacionesPorDiarios() {
		return this.mostrarid_transaccionFacturacionesPorDiarios;
	}

	public void setMostrarid_transaccionFacturacionesPorDiarios(Boolean mostrarid_transaccionFacturacionesPorDiarios) {
		this.mostrarid_transaccionFacturacionesPorDiarios= mostrarid_transaccionFacturacionesPorDiarios;
	}

	public Boolean getActivarid_transaccionFacturacionesPorDiarios() {
		return this.activarid_transaccionFacturacionesPorDiarios;
	}

	public void setActivarid_transaccionFacturacionesPorDiarios(Boolean activarid_transaccionFacturacionesPorDiarios) {
		this.activarid_transaccionFacturacionesPorDiarios= activarid_transaccionFacturacionesPorDiarios;
	}

	public Boolean getCargarid_transaccionFacturacionesPorDiarios() {
		return this.cargarid_transaccionFacturacionesPorDiarios;
	}

	public void setCargarid_transaccionFacturacionesPorDiarios(Boolean cargarid_transaccionFacturacionesPorDiarios) {
		this.cargarid_transaccionFacturacionesPorDiarios= cargarid_transaccionFacturacionesPorDiarios;
	}

	public Border setResaltarfecha_emision_desdeFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeFacturacionesPorDiarios() {
		return this.resaltarfecha_emision_desdeFacturacionesPorDiarios;
	}

	public void setResaltarfecha_emision_desdeFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarfecha_emision_desdeFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeFacturacionesPorDiarios() {
		return this.mostrarfecha_emision_desdeFacturacionesPorDiarios;
	}

	public void setMostrarfecha_emision_desdeFacturacionesPorDiarios(Boolean mostrarfecha_emision_desdeFacturacionesPorDiarios) {
		this.mostrarfecha_emision_desdeFacturacionesPorDiarios= mostrarfecha_emision_desdeFacturacionesPorDiarios;
	}

	public Boolean getActivarfecha_emision_desdeFacturacionesPorDiarios() {
		return this.activarfecha_emision_desdeFacturacionesPorDiarios;
	}

	public void setActivarfecha_emision_desdeFacturacionesPorDiarios(Boolean activarfecha_emision_desdeFacturacionesPorDiarios) {
		this.activarfecha_emision_desdeFacturacionesPorDiarios= activarfecha_emision_desdeFacturacionesPorDiarios;
	}

	public Border setResaltarfecha_emision_hastaFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaFacturacionesPorDiarios() {
		return this.resaltarfecha_emision_hastaFacturacionesPorDiarios;
	}

	public void setResaltarfecha_emision_hastaFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarfecha_emision_hastaFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaFacturacionesPorDiarios() {
		return this.mostrarfecha_emision_hastaFacturacionesPorDiarios;
	}

	public void setMostrarfecha_emision_hastaFacturacionesPorDiarios(Boolean mostrarfecha_emision_hastaFacturacionesPorDiarios) {
		this.mostrarfecha_emision_hastaFacturacionesPorDiarios= mostrarfecha_emision_hastaFacturacionesPorDiarios;
	}

	public Boolean getActivarfecha_emision_hastaFacturacionesPorDiarios() {
		return this.activarfecha_emision_hastaFacturacionesPorDiarios;
	}

	public void setActivarfecha_emision_hastaFacturacionesPorDiarios(Boolean activarfecha_emision_hastaFacturacionesPorDiarios) {
		this.activarfecha_emision_hastaFacturacionesPorDiarios= activarfecha_emision_hastaFacturacionesPorDiarios;
	}

	public Border setResaltarfecha_emisionFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionFacturacionesPorDiarios() {
		return this.resaltarfecha_emisionFacturacionesPorDiarios;
	}

	public void setResaltarfecha_emisionFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarfecha_emisionFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionFacturacionesPorDiarios() {
		return this.mostrarfecha_emisionFacturacionesPorDiarios;
	}

	public void setMostrarfecha_emisionFacturacionesPorDiarios(Boolean mostrarfecha_emisionFacturacionesPorDiarios) {
		this.mostrarfecha_emisionFacturacionesPorDiarios= mostrarfecha_emisionFacturacionesPorDiarios;
	}

	public Boolean getActivarfecha_emisionFacturacionesPorDiarios() {
		return this.activarfecha_emisionFacturacionesPorDiarios;
	}

	public void setActivarfecha_emisionFacturacionesPorDiarios(Boolean activarfecha_emisionFacturacionesPorDiarios) {
		this.activarfecha_emisionFacturacionesPorDiarios= activarfecha_emisionFacturacionesPorDiarios;
	}

	public Border setResaltarnombre_sucursalFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalFacturacionesPorDiarios() {
		return this.resaltarnombre_sucursalFacturacionesPorDiarios;
	}

	public void setResaltarnombre_sucursalFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarnombre_sucursalFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalFacturacionesPorDiarios() {
		return this.mostrarnombre_sucursalFacturacionesPorDiarios;
	}

	public void setMostrarnombre_sucursalFacturacionesPorDiarios(Boolean mostrarnombre_sucursalFacturacionesPorDiarios) {
		this.mostrarnombre_sucursalFacturacionesPorDiarios= mostrarnombre_sucursalFacturacionesPorDiarios;
	}

	public Boolean getActivarnombre_sucursalFacturacionesPorDiarios() {
		return this.activarnombre_sucursalFacturacionesPorDiarios;
	}

	public void setActivarnombre_sucursalFacturacionesPorDiarios(Boolean activarnombre_sucursalFacturacionesPorDiarios) {
		this.activarnombre_sucursalFacturacionesPorDiarios= activarnombre_sucursalFacturacionesPorDiarios;
	}

	public Border setResaltarnombre_completo_clienteFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteFacturacionesPorDiarios() {
		return this.resaltarnombre_completo_clienteFacturacionesPorDiarios;
	}

	public void setResaltarnombre_completo_clienteFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarnombre_completo_clienteFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteFacturacionesPorDiarios() {
		return this.mostrarnombre_completo_clienteFacturacionesPorDiarios;
	}

	public void setMostrarnombre_completo_clienteFacturacionesPorDiarios(Boolean mostrarnombre_completo_clienteFacturacionesPorDiarios) {
		this.mostrarnombre_completo_clienteFacturacionesPorDiarios= mostrarnombre_completo_clienteFacturacionesPorDiarios;
	}

	public Boolean getActivarnombre_completo_clienteFacturacionesPorDiarios() {
		return this.activarnombre_completo_clienteFacturacionesPorDiarios;
	}

	public void setActivarnombre_completo_clienteFacturacionesPorDiarios(Boolean activarnombre_completo_clienteFacturacionesPorDiarios) {
		this.activarnombre_completo_clienteFacturacionesPorDiarios= activarnombre_completo_clienteFacturacionesPorDiarios;
	}

	public Border setResaltarid_tipo_transaccion_moduloFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloFacturacionesPorDiarios() {
		return this.resaltarid_tipo_transaccion_moduloFacturacionesPorDiarios;
	}

	public void setResaltarid_tipo_transaccion_moduloFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloFacturacionesPorDiarios() {
		return this.mostrarid_tipo_transaccion_moduloFacturacionesPorDiarios;
	}

	public void setMostrarid_tipo_transaccion_moduloFacturacionesPorDiarios(Boolean mostrarid_tipo_transaccion_moduloFacturacionesPorDiarios) {
		this.mostrarid_tipo_transaccion_moduloFacturacionesPorDiarios= mostrarid_tipo_transaccion_moduloFacturacionesPorDiarios;
	}

	public Boolean getActivarid_tipo_transaccion_moduloFacturacionesPorDiarios() {
		return this.activarid_tipo_transaccion_moduloFacturacionesPorDiarios;
	}

	public void setActivarid_tipo_transaccion_moduloFacturacionesPorDiarios(Boolean activarid_tipo_transaccion_moduloFacturacionesPorDiarios) {
		this.activarid_tipo_transaccion_moduloFacturacionesPorDiarios= activarid_tipo_transaccion_moduloFacturacionesPorDiarios;
	}

	public Boolean getCargarid_tipo_transaccion_moduloFacturacionesPorDiarios() {
		return this.cargarid_tipo_transaccion_moduloFacturacionesPorDiarios;
	}

	public void setCargarid_tipo_transaccion_moduloFacturacionesPorDiarios(Boolean cargarid_tipo_transaccion_moduloFacturacionesPorDiarios) {
		this.cargarid_tipo_transaccion_moduloFacturacionesPorDiarios= cargarid_tipo_transaccion_moduloFacturacionesPorDiarios;
	}

	public Border setResaltarcodigo_asiento_contableFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarcodigo_asiento_contableFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_asiento_contableFacturacionesPorDiarios() {
		return this.resaltarcodigo_asiento_contableFacturacionesPorDiarios;
	}

	public void setResaltarcodigo_asiento_contableFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarcodigo_asiento_contableFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarcodigo_asiento_contableFacturacionesPorDiarios() {
		return this.mostrarcodigo_asiento_contableFacturacionesPorDiarios;
	}

	public void setMostrarcodigo_asiento_contableFacturacionesPorDiarios(Boolean mostrarcodigo_asiento_contableFacturacionesPorDiarios) {
		this.mostrarcodigo_asiento_contableFacturacionesPorDiarios= mostrarcodigo_asiento_contableFacturacionesPorDiarios;
	}

	public Boolean getActivarcodigo_asiento_contableFacturacionesPorDiarios() {
		return this.activarcodigo_asiento_contableFacturacionesPorDiarios;
	}

	public void setActivarcodigo_asiento_contableFacturacionesPorDiarios(Boolean activarcodigo_asiento_contableFacturacionesPorDiarios) {
		this.activarcodigo_asiento_contableFacturacionesPorDiarios= activarcodigo_asiento_contableFacturacionesPorDiarios;
	}

	public Border setResaltarfecha_venceFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarfecha_venceFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceFacturacionesPorDiarios() {
		return this.resaltarfecha_venceFacturacionesPorDiarios;
	}

	public void setResaltarfecha_venceFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarfecha_venceFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarfecha_venceFacturacionesPorDiarios() {
		return this.mostrarfecha_venceFacturacionesPorDiarios;
	}

	public void setMostrarfecha_venceFacturacionesPorDiarios(Boolean mostrarfecha_venceFacturacionesPorDiarios) {
		this.mostrarfecha_venceFacturacionesPorDiarios= mostrarfecha_venceFacturacionesPorDiarios;
	}

	public Boolean getActivarfecha_venceFacturacionesPorDiarios() {
		return this.activarfecha_venceFacturacionesPorDiarios;
	}

	public void setActivarfecha_venceFacturacionesPorDiarios(Boolean activarfecha_venceFacturacionesPorDiarios) {
		this.activarfecha_venceFacturacionesPorDiarios= activarfecha_venceFacturacionesPorDiarios;
	}

	public Border setResaltarfecha_emision_detalle_clienteFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_detalle_clienteFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_detalle_clienteFacturacionesPorDiarios() {
		return this.resaltarfecha_emision_detalle_clienteFacturacionesPorDiarios;
	}

	public void setResaltarfecha_emision_detalle_clienteFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarfecha_emision_detalle_clienteFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_detalle_clienteFacturacionesPorDiarios() {
		return this.mostrarfecha_emision_detalle_clienteFacturacionesPorDiarios;
	}

	public void setMostrarfecha_emision_detalle_clienteFacturacionesPorDiarios(Boolean mostrarfecha_emision_detalle_clienteFacturacionesPorDiarios) {
		this.mostrarfecha_emision_detalle_clienteFacturacionesPorDiarios= mostrarfecha_emision_detalle_clienteFacturacionesPorDiarios;
	}

	public Boolean getActivarfecha_emision_detalle_clienteFacturacionesPorDiarios() {
		return this.activarfecha_emision_detalle_clienteFacturacionesPorDiarios;
	}

	public void setActivarfecha_emision_detalle_clienteFacturacionesPorDiarios(Boolean activarfecha_emision_detalle_clienteFacturacionesPorDiarios) {
		this.activarfecha_emision_detalle_clienteFacturacionesPorDiarios= activarfecha_emision_detalle_clienteFacturacionesPorDiarios;
	}

	public Border setResaltarmonto_mone_localFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarmonto_mone_localFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_mone_localFacturacionesPorDiarios() {
		return this.resaltarmonto_mone_localFacturacionesPorDiarios;
	}

	public void setResaltarmonto_mone_localFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarmonto_mone_localFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarmonto_mone_localFacturacionesPorDiarios() {
		return this.mostrarmonto_mone_localFacturacionesPorDiarios;
	}

	public void setMostrarmonto_mone_localFacturacionesPorDiarios(Boolean mostrarmonto_mone_localFacturacionesPorDiarios) {
		this.mostrarmonto_mone_localFacturacionesPorDiarios= mostrarmonto_mone_localFacturacionesPorDiarios;
	}

	public Boolean getActivarmonto_mone_localFacturacionesPorDiarios() {
		return this.activarmonto_mone_localFacturacionesPorDiarios;
	}

	public void setActivarmonto_mone_localFacturacionesPorDiarios(Boolean activarmonto_mone_localFacturacionesPorDiarios) {
		this.activarmonto_mone_localFacturacionesPorDiarios= activarmonto_mone_localFacturacionesPorDiarios;
	}

	public Border setResaltarnumero_facturaFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaFacturacionesPorDiarios() {
		return this.resaltarnumero_facturaFacturacionesPorDiarios;
	}

	public void setResaltarnumero_facturaFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarnumero_facturaFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaFacturacionesPorDiarios() {
		return this.mostrarnumero_facturaFacturacionesPorDiarios;
	}

	public void setMostrarnumero_facturaFacturacionesPorDiarios(Boolean mostrarnumero_facturaFacturacionesPorDiarios) {
		this.mostrarnumero_facturaFacturacionesPorDiarios= mostrarnumero_facturaFacturacionesPorDiarios;
	}

	public Boolean getActivarnumero_facturaFacturacionesPorDiarios() {
		return this.activarnumero_facturaFacturacionesPorDiarios;
	}

	public void setActivarnumero_facturaFacturacionesPorDiarios(Boolean activarnumero_facturaFacturacionesPorDiarios) {
		this.activarnumero_facturaFacturacionesPorDiarios= activarnumero_facturaFacturacionesPorDiarios;
	}

	public Border setResaltarruc_clienteFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturacionespordiariosBeanSwingJInternalFrame.jTtoolBarFacturacionesPorDiarios.setBorder(borderResaltar);
		
		this.resaltarruc_clienteFacturacionesPorDiarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarruc_clienteFacturacionesPorDiarios() {
		return this.resaltarruc_clienteFacturacionesPorDiarios;
	}

	public void setResaltarruc_clienteFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarruc_clienteFacturacionesPorDiarios= borderResaltar;
	}

	public Boolean getMostrarruc_clienteFacturacionesPorDiarios() {
		return this.mostrarruc_clienteFacturacionesPorDiarios;
	}

	public void setMostrarruc_clienteFacturacionesPorDiarios(Boolean mostrarruc_clienteFacturacionesPorDiarios) {
		this.mostrarruc_clienteFacturacionesPorDiarios= mostrarruc_clienteFacturacionesPorDiarios;
	}

	public Boolean getActivarruc_clienteFacturacionesPorDiarios() {
		return this.activarruc_clienteFacturacionesPorDiarios;
	}

	public void setActivarruc_clienteFacturacionesPorDiarios(Boolean activarruc_clienteFacturacionesPorDiarios) {
		this.activarruc_clienteFacturacionesPorDiarios= activarruc_clienteFacturacionesPorDiarios;
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
		
		
		this.setMostraridFacturacionesPorDiarios(esInicial);
		this.setMostrarid_empresaFacturacionesPorDiarios(esInicial);
		this.setMostrarid_transaccionFacturacionesPorDiarios(esInicial);
		this.setMostrarfecha_emision_desdeFacturacionesPorDiarios(esInicial);
		this.setMostrarfecha_emision_hastaFacturacionesPorDiarios(esInicial);
		this.setMostrarfecha_emisionFacturacionesPorDiarios(esInicial);
		this.setMostrarnombre_sucursalFacturacionesPorDiarios(esInicial);
		this.setMostrarnombre_completo_clienteFacturacionesPorDiarios(esInicial);
		this.setMostrarid_tipo_transaccion_moduloFacturacionesPorDiarios(esInicial);
		this.setMostrarcodigo_asiento_contableFacturacionesPorDiarios(esInicial);
		this.setMostrarfecha_venceFacturacionesPorDiarios(esInicial);
		this.setMostrarfecha_emision_detalle_clienteFacturacionesPorDiarios(esInicial);
		this.setMostrarmonto_mone_localFacturacionesPorDiarios(esInicial);
		this.setMostrarnumero_facturaFacturacionesPorDiarios(esInicial);
		this.setMostrarruc_clienteFacturacionesPorDiarios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.ID)) {
				this.setMostraridFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setMostrarcodigo_asiento_contableFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE)) {
				this.setMostrarfecha_emision_detalle_clienteFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL)) {
				this.setMostrarmonto_mone_localFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE)) {
				this.setMostrarruc_clienteFacturacionesPorDiarios(esAsigna);
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
		
		
		this.setActivaridFacturacionesPorDiarios(esInicial);
		this.setActivarid_empresaFacturacionesPorDiarios(esInicial);
		this.setActivarid_transaccionFacturacionesPorDiarios(esInicial);
		this.setActivarfecha_emision_desdeFacturacionesPorDiarios(esInicial);
		this.setActivarfecha_emision_hastaFacturacionesPorDiarios(esInicial);
		this.setActivarfecha_emisionFacturacionesPorDiarios(esInicial);
		this.setActivarnombre_sucursalFacturacionesPorDiarios(esInicial);
		this.setActivarnombre_completo_clienteFacturacionesPorDiarios(esInicial);
		this.setActivarid_tipo_transaccion_moduloFacturacionesPorDiarios(esInicial);
		this.setActivarcodigo_asiento_contableFacturacionesPorDiarios(esInicial);
		this.setActivarfecha_venceFacturacionesPorDiarios(esInicial);
		this.setActivarfecha_emision_detalle_clienteFacturacionesPorDiarios(esInicial);
		this.setActivarmonto_mone_localFacturacionesPorDiarios(esInicial);
		this.setActivarnumero_facturaFacturacionesPorDiarios(esInicial);
		this.setActivarruc_clienteFacturacionesPorDiarios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.ID)) {
				this.setActivaridFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setActivarcodigo_asiento_contableFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE)) {
				this.setActivarfecha_emision_detalle_clienteFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL)) {
				this.setActivarmonto_mone_localFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE)) {
				this.setActivarruc_clienteFacturacionesPorDiarios(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturacionesPorDiarios(esInicial);
		this.setResaltarid_empresaFacturacionesPorDiarios(esInicial);
		this.setResaltarid_transaccionFacturacionesPorDiarios(esInicial);
		this.setResaltarfecha_emision_desdeFacturacionesPorDiarios(esInicial);
		this.setResaltarfecha_emision_hastaFacturacionesPorDiarios(esInicial);
		this.setResaltarfecha_emisionFacturacionesPorDiarios(esInicial);
		this.setResaltarnombre_sucursalFacturacionesPorDiarios(esInicial);
		this.setResaltarnombre_completo_clienteFacturacionesPorDiarios(esInicial);
		this.setResaltarid_tipo_transaccion_moduloFacturacionesPorDiarios(esInicial);
		this.setResaltarcodigo_asiento_contableFacturacionesPorDiarios(esInicial);
		this.setResaltarfecha_venceFacturacionesPorDiarios(esInicial);
		this.setResaltarfecha_emision_detalle_clienteFacturacionesPorDiarios(esInicial);
		this.setResaltarmonto_mone_localFacturacionesPorDiarios(esInicial);
		this.setResaltarnumero_facturaFacturacionesPorDiarios(esInicial);
		this.setResaltarruc_clienteFacturacionesPorDiarios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.ID)) {
				this.setResaltaridFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.CODIGOASIENTOCONTABLE)) {
				this.setResaltarcodigo_asiento_contableFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.FECHAEMISIONDETALLECLIENTE)) {
				this.setResaltarfecha_emision_detalle_clienteFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.MONTOMONELOCAL)) {
				this.setResaltarmonto_mone_localFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaFacturacionesPorDiarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturacionesPorDiariosConstantesFunciones.RUCCLIENTE)) {
				this.setResaltarruc_clienteFacturacionesPorDiarios(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios=true;

	public Boolean getMostrarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios() {
		return this.mostrarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios;
	}

	public void setMostrarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios(Boolean visibilidadResaltar) {
		this.mostrarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios=true;

	public Boolean getActivarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios() {
		return this.activarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios;
	}

	public void setActivarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios(Boolean habilitarResaltar) {
		this.activarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios=null;

	public Border getResaltarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios() {
		return this.resaltarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios;
	}

	public void setResaltarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios(Border borderResaltar) {
		this.resaltarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios= borderResaltar;
	}

	public void setResaltarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios(ParametroGeneralUsuario parametroGeneralUsuario/*FacturacionesPorDiariosBeanSwingJInternalFrame facturacionespordiariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaFacturacionesPorDiariosFacturacionesPorDiarios= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}