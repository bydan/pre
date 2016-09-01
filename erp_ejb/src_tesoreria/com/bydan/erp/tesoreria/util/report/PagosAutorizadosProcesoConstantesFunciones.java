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


import com.bydan.erp.tesoreria.util.report.PagosAutorizadosProcesoConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.PagosAutorizadosProcesoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.PagosAutorizadosProcesoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PagosAutorizadosProcesoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PagosAutorizadosProceso";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PagosAutorizadosProceso"+PagosAutorizadosProcesoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PagosAutorizadosProcesoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PagosAutorizadosProcesoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"_"+PagosAutorizadosProcesoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PagosAutorizadosProcesoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"_"+PagosAutorizadosProcesoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"_"+PagosAutorizadosProcesoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PagosAutorizadosProcesoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"_"+PagosAutorizadosProcesoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutorizadosProcesoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagosAutorizadosProcesoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutorizadosProcesoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutorizadosProcesoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagosAutorizadosProcesoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutorizadosProcesoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PagosAutorizadosProcesoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PagosAutorizadosProcesoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PagosAutorizadosProcesoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PagosAutorizadosProcesoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pagos Autorizados Procesos";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pagos Autorizados Proceso";
	public static final String SCLASSWEBTITULO_LOWER="Pagos Autorizados Proceso";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PagosAutorizadosProceso";
	public static final String OBJECTNAME="pagosautorizadosproceso";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="pagos_autorizados_proceso";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pagosautorizadosproceso from "+PagosAutorizadosProcesoConstantesFunciones.SPERSISTENCENAME+" pagosautorizadosproceso";
	public static String QUERYSELECTNATIVE="select "+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".id,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".version_row,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".id_empresa,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".id_sucursal,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".id_ejercicio,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".nombre_tipo_documento,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".codigo,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".beneficiario,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".fecha,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".fecha_emision,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".codigo_tipo_movimiento_modulo,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".numero_mayor,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".valor,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".codigo_cuenta_banco,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".numero_cheque,"+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME+".beneficiario_detalle_cheque_girado from "+PagosAutorizadosProcesoConstantesFunciones.SCHEMA+"."+PagosAutorizadosProcesoConstantesFunciones.TABLENAME;//+" as "+PagosAutorizadosProcesoConstantesFunciones.TABLENAME;
	
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
    public static final String NOMBRETIPODOCUMENTO= "nombre_tipo_documento";
    public static final String CODIGO= "codigo";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String FECHA= "fecha";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String CODIGOTIPOMOVIMIENTOMODULO= "codigo_tipo_movimiento_modulo";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String VALOR= "valor";
    public static final String CODIGOCUENTABANCO= "codigo_cuenta_banco";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String BENEFICIARIODETALLECHEQUEGIRADO= "beneficiario_detalle_cheque_girado";
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
    	public static final String LABEL_NOMBRETIPODOCUMENTO= "Nombre Tipo Documento";
		public static final String LABEL_NOMBRETIPODOCUMENTO_LOWER= "Nombre Tipo Documento";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_CODIGOTIPOMOVIMIENTOMODULO= "Codigo Tipo Movimiento Modulo";
		public static final String LABEL_CODIGOTIPOMOVIMIENTOMODULO_LOWER= "Codigo Tipo Movimiento Modulo";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_CODIGOCUENTABANCO= "Codigo Cuenta Banco";
		public static final String LABEL_CODIGOCUENTABANCO_LOWER= "Codigo Cuenta Banco";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_BENEFICIARIODETALLECHEQUEGIRADO= "Beneficiario Detalle Cheque Girado";
		public static final String LABEL_BENEFICIARIODETALLECHEQUEGIRADO_LOWER= "Beneficiario Detalle Cheque Girado";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_TIPO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXCODIGO_TIPO_MOVIMIENTO_MODULO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO_MODULO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_CUENTA_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO_DETALLE_CHEQUE_GIRADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO_DETALLE_CHEQUE_GIRADO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPagosAutorizadosProcesoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_NOMBRETIPODOCUMENTO;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGO)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.FECHA)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTOMODULO;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.VALOR)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOCUENTABANCO;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO)) {sLabelColumna=PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIODETALLECHEQUEGIRADO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPagosAutorizadosProcesoDescripcion(PagosAutorizadosProceso pagosautorizadosproceso) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pagosautorizadosproceso !=null/* && pagosautorizadosproceso.getId()!=0*/) {
			sDescripcion=pagosautorizadosproceso.getcodigo();//pagosautorizadosprocesopagosautorizadosproceso.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPagosAutorizadosProcesoDescripcionDetallado(PagosAutorizadosProceso pagosautorizadosproceso) {
		String sDescripcion="";
			
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.ID+"=";
		sDescripcion+=pagosautorizadosproceso.getId().toString()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pagosautorizadosproceso.getVersionRow().toString()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pagosautorizadosproceso.getid_empresa().toString()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pagosautorizadosproceso.getid_sucursal().toString()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=pagosautorizadosproceso.getid_ejercicio().toString()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO+"=";
		sDescripcion+=pagosautorizadosproceso.getnombre_tipo_documento()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.CODIGO+"=";
		sDescripcion+=pagosautorizadosproceso.getcodigo()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=pagosautorizadosproceso.getbeneficiario()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.FECHA+"=";
		sDescripcion+=pagosautorizadosproceso.getfecha().toString()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pagosautorizadosproceso.getfecha_emision().toString()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO+"=";
		sDescripcion+=pagosautorizadosproceso.getcodigo_tipo_movimiento_modulo()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=pagosautorizadosproceso.getnumero_mayor()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.VALOR+"=";
		sDescripcion+=pagosautorizadosproceso.getvalor().toString()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO+"=";
		sDescripcion+=pagosautorizadosproceso.getcodigo_cuenta_banco()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=pagosautorizadosproceso.getnumero_cheque()+",";
		sDescripcion+=PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO+"=";
		sDescripcion+=pagosautorizadosproceso.getbeneficiario_detalle_cheque_girado()+",";
			
		return sDescripcion;
	}
	
	public static void setPagosAutorizadosProcesoDescripcion(PagosAutorizadosProceso pagosautorizadosproceso,String sValor) throws Exception {			
		if(pagosautorizadosproceso !=null) {
			pagosautorizadosproceso.setcodigo(sValor);;//pagosautorizadosprocesopagosautorizadosproceso.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaPagosAutorizadosProceso")) {
			sNombreIndice="Tipo=  Por Ejercicio";
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

	public static String getDetalleIndiceBusquedaPagosAutorizadosProceso(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosPagosAutorizadosProceso(PagosAutorizadosProceso pagosautorizadosproceso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pagosautorizadosproceso.setnombre_tipo_documento(pagosautorizadosproceso.getnombre_tipo_documento().trim());
		pagosautorizadosproceso.setcodigo(pagosautorizadosproceso.getcodigo().trim());
		pagosautorizadosproceso.setbeneficiario(pagosautorizadosproceso.getbeneficiario().trim());
		pagosautorizadosproceso.setcodigo_tipo_movimiento_modulo(pagosautorizadosproceso.getcodigo_tipo_movimiento_modulo().trim());
		pagosautorizadosproceso.setnumero_mayor(pagosautorizadosproceso.getnumero_mayor().trim());
		pagosautorizadosproceso.setcodigo_cuenta_banco(pagosautorizadosproceso.getcodigo_cuenta_banco().trim());
		pagosautorizadosproceso.setnumero_cheque(pagosautorizadosproceso.getnumero_cheque().trim());
		pagosautorizadosproceso.setbeneficiario_detalle_cheque_girado(pagosautorizadosproceso.getbeneficiario_detalle_cheque_girado().trim());
	}
	
	public static void quitarEspaciosPagosAutorizadosProcesos(List<PagosAutorizadosProceso> pagosautorizadosprocesos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PagosAutorizadosProceso pagosautorizadosproceso: pagosautorizadosprocesos) {
			pagosautorizadosproceso.setnombre_tipo_documento(pagosautorizadosproceso.getnombre_tipo_documento().trim());
			pagosautorizadosproceso.setcodigo(pagosautorizadosproceso.getcodigo().trim());
			pagosautorizadosproceso.setbeneficiario(pagosautorizadosproceso.getbeneficiario().trim());
			pagosautorizadosproceso.setcodigo_tipo_movimiento_modulo(pagosautorizadosproceso.getcodigo_tipo_movimiento_modulo().trim());
			pagosautorizadosproceso.setnumero_mayor(pagosautorizadosproceso.getnumero_mayor().trim());
			pagosautorizadosproceso.setcodigo_cuenta_banco(pagosautorizadosproceso.getcodigo_cuenta_banco().trim());
			pagosautorizadosproceso.setnumero_cheque(pagosautorizadosproceso.getnumero_cheque().trim());
			pagosautorizadosproceso.setbeneficiario_detalle_cheque_girado(pagosautorizadosproceso.getbeneficiario_detalle_cheque_girado().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagosAutorizadosProceso(PagosAutorizadosProceso pagosautorizadosproceso,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pagosautorizadosproceso.getConCambioAuxiliar()) {
			pagosautorizadosproceso.setIsDeleted(pagosautorizadosproceso.getIsDeletedAuxiliar());	
			pagosautorizadosproceso.setIsNew(pagosautorizadosproceso.getIsNewAuxiliar());	
			pagosautorizadosproceso.setIsChanged(pagosautorizadosproceso.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pagosautorizadosproceso.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pagosautorizadosproceso.setIsDeletedAuxiliar(false);	
			pagosautorizadosproceso.setIsNewAuxiliar(false);	
			pagosautorizadosproceso.setIsChangedAuxiliar(false);
			
			pagosautorizadosproceso.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagosAutorizadosProcesos(List<PagosAutorizadosProceso> pagosautorizadosprocesos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PagosAutorizadosProceso pagosautorizadosproceso : pagosautorizadosprocesos) {
			if(conAsignarBase && pagosautorizadosproceso.getConCambioAuxiliar()) {
				pagosautorizadosproceso.setIsDeleted(pagosautorizadosproceso.getIsDeletedAuxiliar());	
				pagosautorizadosproceso.setIsNew(pagosautorizadosproceso.getIsNewAuxiliar());	
				pagosautorizadosproceso.setIsChanged(pagosautorizadosproceso.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pagosautorizadosproceso.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pagosautorizadosproceso.setIsDeletedAuxiliar(false);	
				pagosautorizadosproceso.setIsNewAuxiliar(false);	
				pagosautorizadosproceso.setIsChangedAuxiliar(false);
				
				pagosautorizadosproceso.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPagosAutorizadosProceso(PagosAutorizadosProceso pagosautorizadosproceso,Boolean conEnteros) throws Exception  {
		pagosautorizadosproceso.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPagosAutorizadosProcesos(List<PagosAutorizadosProceso> pagosautorizadosprocesos,Boolean conEnteros) throws Exception  {
		
		for(PagosAutorizadosProceso pagosautorizadosproceso: pagosautorizadosprocesos) {
			pagosautorizadosproceso.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPagosAutorizadosProceso(List<PagosAutorizadosProceso> pagosautorizadosprocesos,PagosAutorizadosProceso pagosautorizadosprocesoAux) throws Exception  {
		PagosAutorizadosProcesoConstantesFunciones.InicializarValoresPagosAutorizadosProceso(pagosautorizadosprocesoAux,true);
		
		for(PagosAutorizadosProceso pagosautorizadosproceso: pagosautorizadosprocesos) {
			if(pagosautorizadosproceso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pagosautorizadosprocesoAux.setvalor(pagosautorizadosprocesoAux.getvalor()+pagosautorizadosproceso.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosAutorizadosProceso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PagosAutorizadosProcesoConstantesFunciones.getArrayColumnasGlobalesPagosAutorizadosProceso(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosAutorizadosProceso(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagosAutorizadosProcesoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagosAutorizadosProcesoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagosAutorizadosProcesoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagosAutorizadosProcesoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagosAutorizadosProcesoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagosAutorizadosProcesoConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPagosAutorizadosProceso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PagosAutorizadosProceso> pagosautorizadosprocesos,PagosAutorizadosProceso pagosautorizadosproceso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PagosAutorizadosProceso pagosautorizadosprocesoAux: pagosautorizadosprocesos) {
			if(pagosautorizadosprocesoAux!=null && pagosautorizadosproceso!=null) {
				if((pagosautorizadosprocesoAux.getId()==null && pagosautorizadosproceso.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pagosautorizadosprocesoAux.getId()!=null && pagosautorizadosproceso.getId()!=null){
					if(pagosautorizadosprocesoAux.getId().equals(pagosautorizadosproceso.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPagosAutorizadosProceso(List<PagosAutorizadosProceso> pagosautorizadosprocesos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(PagosAutorizadosProceso pagosautorizadosproceso: pagosautorizadosprocesos) {			
			if(pagosautorizadosproceso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=pagosautorizadosproceso.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPagosAutorizadosProceso() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_ID, PagosAutorizadosProcesoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_VERSIONROW, PagosAutorizadosProcesoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_NOMBRETIPODOCUMENTO, PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGO, PagosAutorizadosProcesoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIO, PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHA, PagosAutorizadosProcesoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHAEMISION, PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTOMODULO, PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROMAYOR, PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_VALOR, PagosAutorizadosProcesoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOCUENTABANCO, PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROCHEQUE, PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIODETALLECHEQUEGIRADO, PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPagosAutorizadosProceso() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutorizadosProceso() throws Exception  {
		return PagosAutorizadosProcesoConstantesFunciones.getTiposSeleccionarPagosAutorizadosProceso(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutorizadosProceso(Boolean conFk) throws Exception  {
		return PagosAutorizadosProcesoConstantesFunciones.getTiposSeleccionarPagosAutorizadosProceso(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutorizadosProceso(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_NOMBRETIPODOCUMENTO);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_NOMBRETIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTOMODULO);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTOMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOCUENTABANCO);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIODETALLECHEQUEGIRADO);
			reporte.setsDescripcion(PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIODETALLECHEQUEGIRADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPagosAutorizadosProceso(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPagosAutorizadosProceso(PagosAutorizadosProceso pagosautorizadosprocesoAux) throws Exception {
		
			pagosautorizadosprocesoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagosautorizadosprocesoAux.getEmpresa()));
			pagosautorizadosprocesoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pagosautorizadosprocesoAux.getSucursal()));
			pagosautorizadosprocesoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pagosautorizadosprocesoAux.getEjercicio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPagosAutorizadosProceso(List<PagosAutorizadosProceso> pagosautorizadosprocesosTemp) throws Exception {
		for(PagosAutorizadosProceso pagosautorizadosprocesoAux:pagosautorizadosprocesosTemp) {
			
			pagosautorizadosprocesoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagosautorizadosprocesoAux.getEmpresa()));
			pagosautorizadosprocesoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pagosautorizadosprocesoAux.getSucursal()));
			pagosautorizadosprocesoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pagosautorizadosprocesoAux.getEjercicio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPagosAutorizadosProceso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPagosAutorizadosProceso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagosAutorizadosProceso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagosAutorizadosProcesoConstantesFunciones.getClassesRelationshipsOfPagosAutorizadosProceso(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagosAutorizadosProceso(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagosAutorizadosProceso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagosAutorizadosProcesoConstantesFunciones.getClassesRelationshipsFromStringsOfPagosAutorizadosProceso(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagosAutorizadosProceso(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PagosAutorizadosProceso pagosautorizadosproceso,List<PagosAutorizadosProceso> pagosautorizadosprocesos,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PagosAutorizadosProceso pagosautorizadosproceso,List<PagosAutorizadosProceso> pagosautorizadosprocesos) throws Exception {
		try	{			
			for(PagosAutorizadosProceso pagosautorizadosprocesoLocal:pagosautorizadosprocesos) {
				if(pagosautorizadosprocesoLocal.getId().equals(pagosautorizadosproceso.getId())) {
					pagosautorizadosprocesoLocal.setIsSelected(pagosautorizadosproceso.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPagosAutorizadosProceso(List<PagosAutorizadosProceso> pagosautorizadosprocesosAux) throws Exception {
		//this.pagosautorizadosprocesosAux=pagosautorizadosprocesosAux;
		
		for(PagosAutorizadosProceso pagosautorizadosprocesoAux:pagosautorizadosprocesosAux) {
			if(pagosautorizadosprocesoAux.getIsChanged()) {
				pagosautorizadosprocesoAux.setIsChanged(false);
			}		
			
			if(pagosautorizadosprocesoAux.getIsNew()) {
				pagosautorizadosprocesoAux.setIsNew(false);
			}	
			
			if(pagosautorizadosprocesoAux.getIsDeleted()) {
				pagosautorizadosprocesoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPagosAutorizadosProceso(PagosAutorizadosProceso pagosautorizadosprocesoAux) throws Exception {
		//this.pagosautorizadosprocesoAux=pagosautorizadosprocesoAux;
		
			if(pagosautorizadosprocesoAux.getIsChanged()) {
				pagosautorizadosprocesoAux.setIsChanged(false);
			}		
			
			if(pagosautorizadosprocesoAux.getIsNew()) {
				pagosautorizadosprocesoAux.setIsNew(false);
			}	
			
			if(pagosautorizadosprocesoAux.getIsDeleted()) {
				pagosautorizadosprocesoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PagosAutorizadosProceso pagosautorizadosprocesoAsignar,PagosAutorizadosProceso pagosautorizadosproceso) throws Exception {
		pagosautorizadosprocesoAsignar.setId(pagosautorizadosproceso.getId());	
		pagosautorizadosprocesoAsignar.setVersionRow(pagosautorizadosproceso.getVersionRow());	
		pagosautorizadosprocesoAsignar.setnombre_tipo_documento(pagosautorizadosproceso.getnombre_tipo_documento());	
		pagosautorizadosprocesoAsignar.setcodigo(pagosautorizadosproceso.getcodigo());	
		pagosautorizadosprocesoAsignar.setbeneficiario(pagosautorizadosproceso.getbeneficiario());	
		pagosautorizadosprocesoAsignar.setfecha(pagosautorizadosproceso.getfecha());	
		pagosautorizadosprocesoAsignar.setfecha_emision(pagosautorizadosproceso.getfecha_emision());	
		pagosautorizadosprocesoAsignar.setcodigo_tipo_movimiento_modulo(pagosautorizadosproceso.getcodigo_tipo_movimiento_modulo());	
		pagosautorizadosprocesoAsignar.setnumero_mayor(pagosautorizadosproceso.getnumero_mayor());	
		pagosautorizadosprocesoAsignar.setvalor(pagosautorizadosproceso.getvalor());	
		pagosautorizadosprocesoAsignar.setcodigo_cuenta_banco(pagosautorizadosproceso.getcodigo_cuenta_banco());	
		pagosautorizadosprocesoAsignar.setnumero_cheque(pagosautorizadosproceso.getnumero_cheque());	
		pagosautorizadosprocesoAsignar.setbeneficiario_detalle_cheque_girado(pagosautorizadosproceso.getbeneficiario_detalle_cheque_girado());	
	}
	
	public static void inicializarPagosAutorizadosProceso(PagosAutorizadosProceso pagosautorizadosproceso) throws Exception {
		try {
				pagosautorizadosproceso.setId(0L);	
					
				pagosautorizadosproceso.setnombre_tipo_documento("");	
				pagosautorizadosproceso.setcodigo("");	
				pagosautorizadosproceso.setbeneficiario("");	
				pagosautorizadosproceso.setfecha(new Date());	
				pagosautorizadosproceso.setfecha_emision(new Date());	
				pagosautorizadosproceso.setcodigo_tipo_movimiento_modulo("");	
				pagosautorizadosproceso.setnumero_mayor("");	
				pagosautorizadosproceso.setvalor(0.0);	
				pagosautorizadosproceso.setcodigo_cuenta_banco("");	
				pagosautorizadosproceso.setnumero_cheque("");	
				pagosautorizadosproceso.setbeneficiario_detalle_cheque_girado("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPagosAutorizadosProceso(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_NOMBRETIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTOMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_CODIGOCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosProcesoConstantesFunciones.LABEL_BENEFICIARIODETALLECHEQUEGIRADO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPagosAutorizadosProceso(String sTipo,Row row,Workbook workbook,PagosAutorizadosProceso pagosautorizadosproceso,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getnombre_tipo_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getcodigo_tipo_movimiento_modulo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getcodigo_cuenta_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizadosproceso.getbeneficiario_detalle_cheque_girado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPagosAutorizadosProceso="";
	
	public String getsFinalQueryPagosAutorizadosProceso() {
		return this.sFinalQueryPagosAutorizadosProceso;
	}
	
	public void setsFinalQueryPagosAutorizadosProceso(String sFinalQueryPagosAutorizadosProceso) {
		this.sFinalQueryPagosAutorizadosProceso= sFinalQueryPagosAutorizadosProceso;
	}
	
	public Border resaltarSeleccionarPagosAutorizadosProceso=null;
	
	public Border setResaltarSeleccionarPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPagosAutorizadosProceso= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPagosAutorizadosProceso() {
		return this.resaltarSeleccionarPagosAutorizadosProceso;
	}
	
	public void setResaltarSeleccionarPagosAutorizadosProceso(Border borderResaltarSeleccionarPagosAutorizadosProceso) {
		this.resaltarSeleccionarPagosAutorizadosProceso= borderResaltarSeleccionarPagosAutorizadosProceso;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPagosAutorizadosProceso=null;
	public Boolean mostraridPagosAutorizadosProceso=true;
	public Boolean activaridPagosAutorizadosProceso=true;

	public Border resaltarid_empresaPagosAutorizadosProceso=null;
	public Boolean mostrarid_empresaPagosAutorizadosProceso=true;
	public Boolean activarid_empresaPagosAutorizadosProceso=true;
	public Boolean cargarid_empresaPagosAutorizadosProceso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPagosAutorizadosProceso=false;//ConEventDepend=true

	public Border resaltarid_sucursalPagosAutorizadosProceso=null;
	public Boolean mostrarid_sucursalPagosAutorizadosProceso=true;
	public Boolean activarid_sucursalPagosAutorizadosProceso=true;
	public Boolean cargarid_sucursalPagosAutorizadosProceso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPagosAutorizadosProceso=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPagosAutorizadosProceso=null;
	public Boolean mostrarid_ejercicioPagosAutorizadosProceso=true;
	public Boolean activarid_ejercicioPagosAutorizadosProceso=true;
	public Boolean cargarid_ejercicioPagosAutorizadosProceso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPagosAutorizadosProceso=false;//ConEventDepend=true

	public Border resaltarnombre_tipo_documentoPagosAutorizadosProceso=null;
	public Boolean mostrarnombre_tipo_documentoPagosAutorizadosProceso=true;
	public Boolean activarnombre_tipo_documentoPagosAutorizadosProceso=true;

	public Border resaltarcodigoPagosAutorizadosProceso=null;
	public Boolean mostrarcodigoPagosAutorizadosProceso=true;
	public Boolean activarcodigoPagosAutorizadosProceso=true;

	public Border resaltarbeneficiarioPagosAutorizadosProceso=null;
	public Boolean mostrarbeneficiarioPagosAutorizadosProceso=true;
	public Boolean activarbeneficiarioPagosAutorizadosProceso=true;

	public Border resaltarfechaPagosAutorizadosProceso=null;
	public Boolean mostrarfechaPagosAutorizadosProceso=true;
	public Boolean activarfechaPagosAutorizadosProceso=true;

	public Border resaltarfecha_emisionPagosAutorizadosProceso=null;
	public Boolean mostrarfecha_emisionPagosAutorizadosProceso=true;
	public Boolean activarfecha_emisionPagosAutorizadosProceso=true;

	public Border resaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso=null;
	public Boolean mostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso=true;
	public Boolean activarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso=true;

	public Border resaltarnumero_mayorPagosAutorizadosProceso=null;
	public Boolean mostrarnumero_mayorPagosAutorizadosProceso=true;
	public Boolean activarnumero_mayorPagosAutorizadosProceso=true;

	public Border resaltarvalorPagosAutorizadosProceso=null;
	public Boolean mostrarvalorPagosAutorizadosProceso=true;
	public Boolean activarvalorPagosAutorizadosProceso=true;

	public Border resaltarcodigo_cuenta_bancoPagosAutorizadosProceso=null;
	public Boolean mostrarcodigo_cuenta_bancoPagosAutorizadosProceso=true;
	public Boolean activarcodigo_cuenta_bancoPagosAutorizadosProceso=true;

	public Border resaltarnumero_chequePagosAutorizadosProceso=null;
	public Boolean mostrarnumero_chequePagosAutorizadosProceso=true;
	public Boolean activarnumero_chequePagosAutorizadosProceso=true;

	public Border resaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso=null;
	public Boolean mostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso=true;
	public Boolean activarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso=true;

	
	

	public Border setResaltaridPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltaridPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPagosAutorizadosProceso() {
		return this.resaltaridPagosAutorizadosProceso;
	}

	public void setResaltaridPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltaridPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostraridPagosAutorizadosProceso() {
		return this.mostraridPagosAutorizadosProceso;
	}

	public void setMostraridPagosAutorizadosProceso(Boolean mostraridPagosAutorizadosProceso) {
		this.mostraridPagosAutorizadosProceso= mostraridPagosAutorizadosProceso;
	}

	public Boolean getActivaridPagosAutorizadosProceso() {
		return this.activaridPagosAutorizadosProceso;
	}

	public void setActivaridPagosAutorizadosProceso(Boolean activaridPagosAutorizadosProceso) {
		this.activaridPagosAutorizadosProceso= activaridPagosAutorizadosProceso;
	}

	public Border setResaltarid_empresaPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarid_empresaPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPagosAutorizadosProceso() {
		return this.resaltarid_empresaPagosAutorizadosProceso;
	}

	public void setResaltarid_empresaPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarid_empresaPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarid_empresaPagosAutorizadosProceso() {
		return this.mostrarid_empresaPagosAutorizadosProceso;
	}

	public void setMostrarid_empresaPagosAutorizadosProceso(Boolean mostrarid_empresaPagosAutorizadosProceso) {
		this.mostrarid_empresaPagosAutorizadosProceso= mostrarid_empresaPagosAutorizadosProceso;
	}

	public Boolean getActivarid_empresaPagosAutorizadosProceso() {
		return this.activarid_empresaPagosAutorizadosProceso;
	}

	public void setActivarid_empresaPagosAutorizadosProceso(Boolean activarid_empresaPagosAutorizadosProceso) {
		this.activarid_empresaPagosAutorizadosProceso= activarid_empresaPagosAutorizadosProceso;
	}

	public Boolean getCargarid_empresaPagosAutorizadosProceso() {
		return this.cargarid_empresaPagosAutorizadosProceso;
	}

	public void setCargarid_empresaPagosAutorizadosProceso(Boolean cargarid_empresaPagosAutorizadosProceso) {
		this.cargarid_empresaPagosAutorizadosProceso= cargarid_empresaPagosAutorizadosProceso;
	}

	public Border setResaltarid_sucursalPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPagosAutorizadosProceso() {
		return this.resaltarid_sucursalPagosAutorizadosProceso;
	}

	public void setResaltarid_sucursalPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarid_sucursalPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPagosAutorizadosProceso() {
		return this.mostrarid_sucursalPagosAutorizadosProceso;
	}

	public void setMostrarid_sucursalPagosAutorizadosProceso(Boolean mostrarid_sucursalPagosAutorizadosProceso) {
		this.mostrarid_sucursalPagosAutorizadosProceso= mostrarid_sucursalPagosAutorizadosProceso;
	}

	public Boolean getActivarid_sucursalPagosAutorizadosProceso() {
		return this.activarid_sucursalPagosAutorizadosProceso;
	}

	public void setActivarid_sucursalPagosAutorizadosProceso(Boolean activarid_sucursalPagosAutorizadosProceso) {
		this.activarid_sucursalPagosAutorizadosProceso= activarid_sucursalPagosAutorizadosProceso;
	}

	public Boolean getCargarid_sucursalPagosAutorizadosProceso() {
		return this.cargarid_sucursalPagosAutorizadosProceso;
	}

	public void setCargarid_sucursalPagosAutorizadosProceso(Boolean cargarid_sucursalPagosAutorizadosProceso) {
		this.cargarid_sucursalPagosAutorizadosProceso= cargarid_sucursalPagosAutorizadosProceso;
	}

	public Border setResaltarid_ejercicioPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPagosAutorizadosProceso() {
		return this.resaltarid_ejercicioPagosAutorizadosProceso;
	}

	public void setResaltarid_ejercicioPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarid_ejercicioPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPagosAutorizadosProceso() {
		return this.mostrarid_ejercicioPagosAutorizadosProceso;
	}

	public void setMostrarid_ejercicioPagosAutorizadosProceso(Boolean mostrarid_ejercicioPagosAutorizadosProceso) {
		this.mostrarid_ejercicioPagosAutorizadosProceso= mostrarid_ejercicioPagosAutorizadosProceso;
	}

	public Boolean getActivarid_ejercicioPagosAutorizadosProceso() {
		return this.activarid_ejercicioPagosAutorizadosProceso;
	}

	public void setActivarid_ejercicioPagosAutorizadosProceso(Boolean activarid_ejercicioPagosAutorizadosProceso) {
		this.activarid_ejercicioPagosAutorizadosProceso= activarid_ejercicioPagosAutorizadosProceso;
	}

	public Boolean getCargarid_ejercicioPagosAutorizadosProceso() {
		return this.cargarid_ejercicioPagosAutorizadosProceso;
	}

	public void setCargarid_ejercicioPagosAutorizadosProceso(Boolean cargarid_ejercicioPagosAutorizadosProceso) {
		this.cargarid_ejercicioPagosAutorizadosProceso= cargarid_ejercicioPagosAutorizadosProceso;
	}

	public Border setResaltarnombre_tipo_documentoPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_documentoPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_documentoPagosAutorizadosProceso() {
		return this.resaltarnombre_tipo_documentoPagosAutorizadosProceso;
	}

	public void setResaltarnombre_tipo_documentoPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarnombre_tipo_documentoPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_documentoPagosAutorizadosProceso() {
		return this.mostrarnombre_tipo_documentoPagosAutorizadosProceso;
	}

	public void setMostrarnombre_tipo_documentoPagosAutorizadosProceso(Boolean mostrarnombre_tipo_documentoPagosAutorizadosProceso) {
		this.mostrarnombre_tipo_documentoPagosAutorizadosProceso= mostrarnombre_tipo_documentoPagosAutorizadosProceso;
	}

	public Boolean getActivarnombre_tipo_documentoPagosAutorizadosProceso() {
		return this.activarnombre_tipo_documentoPagosAutorizadosProceso;
	}

	public void setActivarnombre_tipo_documentoPagosAutorizadosProceso(Boolean activarnombre_tipo_documentoPagosAutorizadosProceso) {
		this.activarnombre_tipo_documentoPagosAutorizadosProceso= activarnombre_tipo_documentoPagosAutorizadosProceso;
	}

	public Border setResaltarcodigoPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarcodigoPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPagosAutorizadosProceso() {
		return this.resaltarcodigoPagosAutorizadosProceso;
	}

	public void setResaltarcodigoPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarcodigoPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarcodigoPagosAutorizadosProceso() {
		return this.mostrarcodigoPagosAutorizadosProceso;
	}

	public void setMostrarcodigoPagosAutorizadosProceso(Boolean mostrarcodigoPagosAutorizadosProceso) {
		this.mostrarcodigoPagosAutorizadosProceso= mostrarcodigoPagosAutorizadosProceso;
	}

	public Boolean getActivarcodigoPagosAutorizadosProceso() {
		return this.activarcodigoPagosAutorizadosProceso;
	}

	public void setActivarcodigoPagosAutorizadosProceso(Boolean activarcodigoPagosAutorizadosProceso) {
		this.activarcodigoPagosAutorizadosProceso= activarcodigoPagosAutorizadosProceso;
	}

	public Border setResaltarbeneficiarioPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioPagosAutorizadosProceso() {
		return this.resaltarbeneficiarioPagosAutorizadosProceso;
	}

	public void setResaltarbeneficiarioPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarbeneficiarioPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioPagosAutorizadosProceso() {
		return this.mostrarbeneficiarioPagosAutorizadosProceso;
	}

	public void setMostrarbeneficiarioPagosAutorizadosProceso(Boolean mostrarbeneficiarioPagosAutorizadosProceso) {
		this.mostrarbeneficiarioPagosAutorizadosProceso= mostrarbeneficiarioPagosAutorizadosProceso;
	}

	public Boolean getActivarbeneficiarioPagosAutorizadosProceso() {
		return this.activarbeneficiarioPagosAutorizadosProceso;
	}

	public void setActivarbeneficiarioPagosAutorizadosProceso(Boolean activarbeneficiarioPagosAutorizadosProceso) {
		this.activarbeneficiarioPagosAutorizadosProceso= activarbeneficiarioPagosAutorizadosProceso;
	}

	public Border setResaltarfechaPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarfechaPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPagosAutorizadosProceso() {
		return this.resaltarfechaPagosAutorizadosProceso;
	}

	public void setResaltarfechaPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarfechaPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarfechaPagosAutorizadosProceso() {
		return this.mostrarfechaPagosAutorizadosProceso;
	}

	public void setMostrarfechaPagosAutorizadosProceso(Boolean mostrarfechaPagosAutorizadosProceso) {
		this.mostrarfechaPagosAutorizadosProceso= mostrarfechaPagosAutorizadosProceso;
	}

	public Boolean getActivarfechaPagosAutorizadosProceso() {
		return this.activarfechaPagosAutorizadosProceso;
	}

	public void setActivarfechaPagosAutorizadosProceso(Boolean activarfechaPagosAutorizadosProceso) {
		this.activarfechaPagosAutorizadosProceso= activarfechaPagosAutorizadosProceso;
	}

	public Border setResaltarfecha_emisionPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPagosAutorizadosProceso() {
		return this.resaltarfecha_emisionPagosAutorizadosProceso;
	}

	public void setResaltarfecha_emisionPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarfecha_emisionPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPagosAutorizadosProceso() {
		return this.mostrarfecha_emisionPagosAutorizadosProceso;
	}

	public void setMostrarfecha_emisionPagosAutorizadosProceso(Boolean mostrarfecha_emisionPagosAutorizadosProceso) {
		this.mostrarfecha_emisionPagosAutorizadosProceso= mostrarfecha_emisionPagosAutorizadosProceso;
	}

	public Boolean getActivarfecha_emisionPagosAutorizadosProceso() {
		return this.activarfecha_emisionPagosAutorizadosProceso;
	}

	public void setActivarfecha_emisionPagosAutorizadosProceso(Boolean activarfecha_emisionPagosAutorizadosProceso) {
		this.activarfecha_emisionPagosAutorizadosProceso= activarfecha_emisionPagosAutorizadosProceso;
	}

	public Border setResaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso() {
		return this.resaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso;
	}

	public void setResaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso() {
		return this.mostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso;
	}

	public void setMostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(Boolean mostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso) {
		this.mostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso= mostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso;
	}

	public Boolean getActivarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso() {
		return this.activarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso;
	}

	public void setActivarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(Boolean activarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso) {
		this.activarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso= activarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso;
	}

	public Border setResaltarnumero_mayorPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorPagosAutorizadosProceso() {
		return this.resaltarnumero_mayorPagosAutorizadosProceso;
	}

	public void setResaltarnumero_mayorPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarnumero_mayorPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorPagosAutorizadosProceso() {
		return this.mostrarnumero_mayorPagosAutorizadosProceso;
	}

	public void setMostrarnumero_mayorPagosAutorizadosProceso(Boolean mostrarnumero_mayorPagosAutorizadosProceso) {
		this.mostrarnumero_mayorPagosAutorizadosProceso= mostrarnumero_mayorPagosAutorizadosProceso;
	}

	public Boolean getActivarnumero_mayorPagosAutorizadosProceso() {
		return this.activarnumero_mayorPagosAutorizadosProceso;
	}

	public void setActivarnumero_mayorPagosAutorizadosProceso(Boolean activarnumero_mayorPagosAutorizadosProceso) {
		this.activarnumero_mayorPagosAutorizadosProceso= activarnumero_mayorPagosAutorizadosProceso;
	}

	public Border setResaltarvalorPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarvalorPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorPagosAutorizadosProceso() {
		return this.resaltarvalorPagosAutorizadosProceso;
	}

	public void setResaltarvalorPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarvalorPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarvalorPagosAutorizadosProceso() {
		return this.mostrarvalorPagosAutorizadosProceso;
	}

	public void setMostrarvalorPagosAutorizadosProceso(Boolean mostrarvalorPagosAutorizadosProceso) {
		this.mostrarvalorPagosAutorizadosProceso= mostrarvalorPagosAutorizadosProceso;
	}

	public Boolean getActivarvalorPagosAutorizadosProceso() {
		return this.activarvalorPagosAutorizadosProceso;
	}

	public void setActivarvalorPagosAutorizadosProceso(Boolean activarvalorPagosAutorizadosProceso) {
		this.activarvalorPagosAutorizadosProceso= activarvalorPagosAutorizadosProceso;
	}

	public Border setResaltarcodigo_cuenta_bancoPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_bancoPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_bancoPagosAutorizadosProceso() {
		return this.resaltarcodigo_cuenta_bancoPagosAutorizadosProceso;
	}

	public void setResaltarcodigo_cuenta_bancoPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarcodigo_cuenta_bancoPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_bancoPagosAutorizadosProceso() {
		return this.mostrarcodigo_cuenta_bancoPagosAutorizadosProceso;
	}

	public void setMostrarcodigo_cuenta_bancoPagosAutorizadosProceso(Boolean mostrarcodigo_cuenta_bancoPagosAutorizadosProceso) {
		this.mostrarcodigo_cuenta_bancoPagosAutorizadosProceso= mostrarcodigo_cuenta_bancoPagosAutorizadosProceso;
	}

	public Boolean getActivarcodigo_cuenta_bancoPagosAutorizadosProceso() {
		return this.activarcodigo_cuenta_bancoPagosAutorizadosProceso;
	}

	public void setActivarcodigo_cuenta_bancoPagosAutorizadosProceso(Boolean activarcodigo_cuenta_bancoPagosAutorizadosProceso) {
		this.activarcodigo_cuenta_bancoPagosAutorizadosProceso= activarcodigo_cuenta_bancoPagosAutorizadosProceso;
	}

	public Border setResaltarnumero_chequePagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarnumero_chequePagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequePagosAutorizadosProceso() {
		return this.resaltarnumero_chequePagosAutorizadosProceso;
	}

	public void setResaltarnumero_chequePagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarnumero_chequePagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarnumero_chequePagosAutorizadosProceso() {
		return this.mostrarnumero_chequePagosAutorizadosProceso;
	}

	public void setMostrarnumero_chequePagosAutorizadosProceso(Boolean mostrarnumero_chequePagosAutorizadosProceso) {
		this.mostrarnumero_chequePagosAutorizadosProceso= mostrarnumero_chequePagosAutorizadosProceso;
	}

	public Boolean getActivarnumero_chequePagosAutorizadosProceso() {
		return this.activarnumero_chequePagosAutorizadosProceso;
	}

	public void setActivarnumero_chequePagosAutorizadosProceso(Boolean activarnumero_chequePagosAutorizadosProceso) {
		this.activarnumero_chequePagosAutorizadosProceso= activarnumero_chequePagosAutorizadosProceso;
	}

	public Border setResaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosprocesoBeanSwingJInternalFrame.jTtoolBarPagosAutorizadosProceso.setBorder(borderResaltar);
		
		this.resaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso() {
		return this.resaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso;
	}

	public void setResaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso= borderResaltar;
	}

	public Boolean getMostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso() {
		return this.mostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso;
	}

	public void setMostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(Boolean mostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso) {
		this.mostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso= mostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso;
	}

	public Boolean getActivarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso() {
		return this.activarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso;
	}

	public void setActivarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(Boolean activarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso) {
		this.activarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso= activarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso;
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
		
		
		this.setMostraridPagosAutorizadosProceso(esInicial);
		this.setMostrarid_empresaPagosAutorizadosProceso(esInicial);
		this.setMostrarid_sucursalPagosAutorizadosProceso(esInicial);
		this.setMostrarid_ejercicioPagosAutorizadosProceso(esInicial);
		this.setMostrarnombre_tipo_documentoPagosAutorizadosProceso(esInicial);
		this.setMostrarcodigoPagosAutorizadosProceso(esInicial);
		this.setMostrarbeneficiarioPagosAutorizadosProceso(esInicial);
		this.setMostrarfechaPagosAutorizadosProceso(esInicial);
		this.setMostrarfecha_emisionPagosAutorizadosProceso(esInicial);
		this.setMostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(esInicial);
		this.setMostrarnumero_mayorPagosAutorizadosProceso(esInicial);
		this.setMostrarvalorPagosAutorizadosProceso(esInicial);
		this.setMostrarcodigo_cuenta_bancoPagosAutorizadosProceso(esInicial);
		this.setMostrarnumero_chequePagosAutorizadosProceso(esInicial);
		this.setMostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.ID)) {
				this.setMostraridPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO)) {
				this.setMostrarnombre_tipo_documentoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.FECHA)) {
				this.setMostrarfechaPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO)) {
				this.setMostrarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.VALOR)) {
				this.setMostrarvalorPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO)) {
				this.setMostrarcodigo_cuenta_bancoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequePagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO)) {
				this.setMostrarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(esAsigna);
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
		
		
		this.setActivaridPagosAutorizadosProceso(esInicial);
		this.setActivarid_empresaPagosAutorizadosProceso(esInicial);
		this.setActivarid_sucursalPagosAutorizadosProceso(esInicial);
		this.setActivarid_ejercicioPagosAutorizadosProceso(esInicial);
		this.setActivarnombre_tipo_documentoPagosAutorizadosProceso(esInicial);
		this.setActivarcodigoPagosAutorizadosProceso(esInicial);
		this.setActivarbeneficiarioPagosAutorizadosProceso(esInicial);
		this.setActivarfechaPagosAutorizadosProceso(esInicial);
		this.setActivarfecha_emisionPagosAutorizadosProceso(esInicial);
		this.setActivarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(esInicial);
		this.setActivarnumero_mayorPagosAutorizadosProceso(esInicial);
		this.setActivarvalorPagosAutorizadosProceso(esInicial);
		this.setActivarcodigo_cuenta_bancoPagosAutorizadosProceso(esInicial);
		this.setActivarnumero_chequePagosAutorizadosProceso(esInicial);
		this.setActivarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.ID)) {
				this.setActivaridPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO)) {
				this.setActivarnombre_tipo_documentoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.FECHA)) {
				this.setActivarfechaPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO)) {
				this.setActivarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.VALOR)) {
				this.setActivarvalorPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO)) {
				this.setActivarcodigo_cuenta_bancoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequePagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO)) {
				this.setActivarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPagosAutorizadosProceso(esInicial);
		this.setResaltarid_empresaPagosAutorizadosProceso(esInicial);
		this.setResaltarid_sucursalPagosAutorizadosProceso(esInicial);
		this.setResaltarid_ejercicioPagosAutorizadosProceso(esInicial);
		this.setResaltarnombre_tipo_documentoPagosAutorizadosProceso(esInicial);
		this.setResaltarcodigoPagosAutorizadosProceso(esInicial);
		this.setResaltarbeneficiarioPagosAutorizadosProceso(esInicial);
		this.setResaltarfechaPagosAutorizadosProceso(esInicial);
		this.setResaltarfecha_emisionPagosAutorizadosProceso(esInicial);
		this.setResaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(esInicial);
		this.setResaltarnumero_mayorPagosAutorizadosProceso(esInicial);
		this.setResaltarvalorPagosAutorizadosProceso(esInicial);
		this.setResaltarcodigo_cuenta_bancoPagosAutorizadosProceso(esInicial);
		this.setResaltarnumero_chequePagosAutorizadosProceso(esInicial);
		this.setResaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.ID)) {
				this.setResaltaridPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NOMBRETIPODOCUMENTO)) {
				this.setResaltarnombre_tipo_documentoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.FECHA)) {
				this.setResaltarfechaPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGOTIPOMOVIMIENTOMODULO)) {
				this.setResaltarcodigo_tipo_movimiento_moduloPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.VALOR)) {
				this.setResaltarvalorPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.CODIGOCUENTABANCO)) {
				this.setResaltarcodigo_cuenta_bancoPagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequePagosAutorizadosProceso(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosProcesoConstantesFunciones.BENEFICIARIODETALLECHEQUEGIRADO)) {
				this.setResaltarbeneficiario_detalle_cheque_giradoPagosAutorizadosProceso(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso=true;

	public Boolean getMostrarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso() {
		return this.mostrarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso;
	}

	public void setMostrarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso=true;

	public Boolean getActivarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso() {
		return this.activarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso;
	}

	public void setActivarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso(Boolean habilitarResaltar) {
		this.activarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso=null;

	public Border getResaltarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso() {
		return this.resaltarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso;
	}

	public void setResaltarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso(Border borderResaltar) {
		this.resaltarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso= borderResaltar;
	}

	public void setResaltarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosProcesoBeanSwingJInternalFrame pagosautorizadosprocesoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPagosAutorizadosProcesoPagosAutorizadosProceso= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}