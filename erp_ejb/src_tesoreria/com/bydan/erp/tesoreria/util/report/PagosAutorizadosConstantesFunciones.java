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


import com.bydan.erp.tesoreria.util.report.PagosAutorizadosConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.PagosAutorizadosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.PagosAutorizadosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PagosAutorizadosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PagosAutorizados";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PagosAutorizados"+PagosAutorizadosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PagosAutorizadosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PagosAutorizadosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PagosAutorizadosConstantesFunciones.SCHEMA+"_"+PagosAutorizadosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PagosAutorizadosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PagosAutorizadosConstantesFunciones.SCHEMA+"_"+PagosAutorizadosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PagosAutorizadosConstantesFunciones.SCHEMA+"_"+PagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PagosAutorizadosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PagosAutorizadosConstantesFunciones.SCHEMA+"_"+PagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagosAutorizadosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagosAutorizadosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutorizadosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PagosAutorizadosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PagosAutorizadosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PagosAutorizadosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PagosAutorizadosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pagos Autorizadoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Pagos Autorizados";
	public static final String SCLASSWEBTITULO_LOWER="Pagos Autorizados";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PagosAutorizados";
	public static final String OBJECTNAME="pagosautorizados";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="pagos_autorizados";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pagosautorizados from "+PagosAutorizadosConstantesFunciones.SPERSISTENCENAME+" pagosautorizados";
	public static String QUERYSELECTNATIVE="select "+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".id,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".version_row,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".id_empresa,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".fecha_corte,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".nombre_cliente,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".numero_factura,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".fecha_emision,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".fecha_vencimiento,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".nombre_banco,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".valor_por_pagar,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".valor_cancelado,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".numero_cuenta,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".esta_autorizado,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".descripcion,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".fecha_corte_dato,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".estado,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".codigo_cuenta_con_cliente,"+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME+".codigo_cuenta_con_banco from "+PagosAutorizadosConstantesFunciones.SCHEMA+"."+PagosAutorizadosConstantesFunciones.TABLENAME;//+" as "+PagosAutorizadosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHACORTE0= "fecha_corte";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String NOMBREBANCO= "nombre_banco";
    public static final String VALORPORPAGAR= "valor_por_pagar";
    public static final String VALORCANCELADO= "valor_cancelado";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String ESTAAUTORIZADO= "esta_autorizado";
    public static final String DESCRIPCION= "descripcion";
    public static final String FECHACORTE= "fecha_corte_dato";
    public static final String ESTADO= "estado";
    public static final String CODIGOCUENTACONCLIENTE= "codigo_cuenta_con_cliente";
    public static final String CODIGOCUENTACONBANCO= "codigo_cuenta_con_banco";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHACORTE0= "Fecha Corte Base";
		public static final String LABEL_FECHACORTE0_LOWER= "Fecha Corte0";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_NOMBREBANCO= "Nombre Banco";
		public static final String LABEL_NOMBREBANCO_LOWER= "Nombre Banco";
    	public static final String LABEL_VALORPORPAGAR= "Valor Por Pagar";
		public static final String LABEL_VALORPORPAGAR_LOWER= "Valor Por Pagar";
    	public static final String LABEL_VALORCANCELADO= "Valor Cancelado";
		public static final String LABEL_VALORCANCELADO_LOWER= "Valor Cancelado";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_ESTAAUTORIZADO= "Esta Autorizado";
		public static final String LABEL_ESTAAUTORIZADO_LOWER= "Esta Autorizado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_FECHACORTE= "Fecha Corte";
		public static final String LABEL_FECHACORTE_LOWER= "Fecha Corte";
    	public static final String LABEL_ESTADO= "Estado";
		public static final String LABEL_ESTADO_LOWER= "Estado";
    	public static final String LABEL_CODIGOCUENTACONCLIENTE= "Codigo Cuenta Con Cliente";
		public static final String LABEL_CODIGOCUENTACONCLIENTE_LOWER= "Codigo Cuenta Con Cliente";
    	public static final String LABEL_CODIGOCUENTACONBANCO= "Codigo Cuenta Con Banco";
		public static final String LABEL_CODIGOCUENTACONBANCO_LOWER= "Codigo Cuenta Con Banco";
	
		
		
		
		
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXESTADO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXESTADO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CUENTA_CON_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA_CON_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CUENTA_CON_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA_CON_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPagosAutorizadosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.IDEMPRESA)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.FECHACORTE0)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE0;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.FECHAEMISION)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.NOMBREBANCO)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.VALORPORPAGAR)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_VALORPORPAGAR;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.VALORCANCELADO)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_VALORCANCELADO;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_ESTAAUTORIZADO;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.DESCRIPCION)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.FECHACORTE)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.ESTADO)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_ESTADO;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE;}
		if(sNombreColumna.equals(PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO)) {sLabelColumna=PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_autorizadoDescripcion(PagosAutorizados pagosautorizados) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!pagosautorizados.getesta_autorizado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_autorizadoHtmlDescripcion(PagosAutorizados pagosautorizados) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(pagosautorizados.getId(),pagosautorizados.getesta_autorizado());

		return sDescripcion;
	}	
			
			
			
			
			
	
	public static String getPagosAutorizadosDescripcion(PagosAutorizados pagosautorizados) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pagosautorizados !=null/* && pagosautorizados.getId()!=0*/) {
			sDescripcion=pagosautorizados.getnombre_cliente();//pagosautorizadospagosautorizados.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPagosAutorizadosDescripcionDetallado(PagosAutorizados pagosautorizados) {
		String sDescripcion="";
			
		sDescripcion+=PagosAutorizadosConstantesFunciones.ID+"=";
		sDescripcion+=pagosautorizados.getId().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pagosautorizados.getVersionRow().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pagosautorizados.getid_empresa().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.FECHACORTE0+"=";
		sDescripcion+=pagosautorizados.getfecha_corte().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=pagosautorizados.getnombre_cliente()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=pagosautorizados.getnumero_factura()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pagosautorizados.getfecha_emision().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=pagosautorizados.getfecha_vencimiento().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.NOMBREBANCO+"=";
		sDescripcion+=pagosautorizados.getnombre_banco()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.VALORPORPAGAR+"=";
		sDescripcion+=pagosautorizados.getvalor_por_pagar().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.VALORCANCELADO+"=";
		sDescripcion+=pagosautorizados.getvalor_cancelado().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=pagosautorizados.getnumero_cuenta()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO+"=";
		sDescripcion+=pagosautorizados.getesta_autorizado().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pagosautorizados.getdescripcion()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.FECHACORTE+"=";
		sDescripcion+=pagosautorizados.getfecha_corte_dato().toString()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.ESTADO+"=";
		sDescripcion+=pagosautorizados.getestado()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE+"=";
		sDescripcion+=pagosautorizados.getcodigo_cuenta_con_cliente()+",";
		sDescripcion+=PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO+"=";
		sDescripcion+=pagosautorizados.getcodigo_cuenta_con_banco()+",";
			
		return sDescripcion;
	}
	
	public static void setPagosAutorizadosDescripcion(PagosAutorizados pagosautorizados,String sValor) throws Exception {			
		if(pagosautorizados !=null) {
			pagosautorizados.setnombre_cliente(sValor);//pagosautorizadospagosautorizados.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPagosAutorizados")) {
			sNombreIndice="Tipo=  Por Fecha Corte Base";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPagosAutorizados(Date fecha_corte) {
		String sDetalleIndice=" Parametros->";
		if(fecha_corte!=null) {sDetalleIndice+=" Fecha Corte Base="+fecha_corte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPagosAutorizados(PagosAutorizados pagosautorizados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pagosautorizados.setnombre_cliente(pagosautorizados.getnombre_cliente().trim());
		pagosautorizados.setnumero_factura(pagosautorizados.getnumero_factura().trim());
		pagosautorizados.setnombre_banco(pagosautorizados.getnombre_banco().trim());
		pagosautorizados.setnumero_cuenta(pagosautorizados.getnumero_cuenta().trim());
		pagosautorizados.setdescripcion(pagosautorizados.getdescripcion().trim());
		pagosautorizados.setestado(pagosautorizados.getestado().trim());
		pagosautorizados.setcodigo_cuenta_con_cliente(pagosautorizados.getcodigo_cuenta_con_cliente().trim());
		pagosautorizados.setcodigo_cuenta_con_banco(pagosautorizados.getcodigo_cuenta_con_banco().trim());
	}
	
	public static void quitarEspaciosPagosAutorizadoss(List<PagosAutorizados> pagosautorizadoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PagosAutorizados pagosautorizados: pagosautorizadoss) {
			pagosautorizados.setnombre_cliente(pagosautorizados.getnombre_cliente().trim());
			pagosautorizados.setnumero_factura(pagosautorizados.getnumero_factura().trim());
			pagosautorizados.setnombre_banco(pagosautorizados.getnombre_banco().trim());
			pagosautorizados.setnumero_cuenta(pagosautorizados.getnumero_cuenta().trim());
			pagosautorizados.setdescripcion(pagosautorizados.getdescripcion().trim());
			pagosautorizados.setestado(pagosautorizados.getestado().trim());
			pagosautorizados.setcodigo_cuenta_con_cliente(pagosautorizados.getcodigo_cuenta_con_cliente().trim());
			pagosautorizados.setcodigo_cuenta_con_banco(pagosautorizados.getcodigo_cuenta_con_banco().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagosAutorizados(PagosAutorizados pagosautorizados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pagosautorizados.getConCambioAuxiliar()) {
			pagosautorizados.setIsDeleted(pagosautorizados.getIsDeletedAuxiliar());	
			pagosautorizados.setIsNew(pagosautorizados.getIsNewAuxiliar());	
			pagosautorizados.setIsChanged(pagosautorizados.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pagosautorizados.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pagosautorizados.setIsDeletedAuxiliar(false);	
			pagosautorizados.setIsNewAuxiliar(false);	
			pagosautorizados.setIsChangedAuxiliar(false);
			
			pagosautorizados.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagosAutorizadoss(List<PagosAutorizados> pagosautorizadoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PagosAutorizados pagosautorizados : pagosautorizadoss) {
			if(conAsignarBase && pagosautorizados.getConCambioAuxiliar()) {
				pagosautorizados.setIsDeleted(pagosautorizados.getIsDeletedAuxiliar());	
				pagosautorizados.setIsNew(pagosautorizados.getIsNewAuxiliar());	
				pagosautorizados.setIsChanged(pagosautorizados.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pagosautorizados.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pagosautorizados.setIsDeletedAuxiliar(false);	
				pagosautorizados.setIsNewAuxiliar(false);	
				pagosautorizados.setIsChangedAuxiliar(false);
				
				pagosautorizados.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPagosAutorizados(PagosAutorizados pagosautorizados,Boolean conEnteros) throws Exception  {
		pagosautorizados.setvalor_por_pagar(0.0);
		pagosautorizados.setvalor_cancelado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPagosAutorizadoss(List<PagosAutorizados> pagosautorizadoss,Boolean conEnteros) throws Exception  {
		
		for(PagosAutorizados pagosautorizados: pagosautorizadoss) {
			pagosautorizados.setvalor_por_pagar(0.0);
			pagosautorizados.setvalor_cancelado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPagosAutorizados(List<PagosAutorizados> pagosautorizadoss,PagosAutorizados pagosautorizadosAux) throws Exception  {
		PagosAutorizadosConstantesFunciones.InicializarValoresPagosAutorizados(pagosautorizadosAux,true);
		
		for(PagosAutorizados pagosautorizados: pagosautorizadoss) {
			if(pagosautorizados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pagosautorizadosAux.setvalor_por_pagar(pagosautorizadosAux.getvalor_por_pagar()+pagosautorizados.getvalor_por_pagar());			
			pagosautorizadosAux.setvalor_cancelado(pagosautorizadosAux.getvalor_cancelado()+pagosautorizados.getvalor_cancelado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosAutorizados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PagosAutorizadosConstantesFunciones.getArrayColumnasGlobalesPagosAutorizados(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosAutorizados(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagosAutorizadosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagosAutorizadosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPagosAutorizados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PagosAutorizados> pagosautorizadoss,PagosAutorizados pagosautorizados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PagosAutorizados pagosautorizadosAux: pagosautorizadoss) {
			if(pagosautorizadosAux!=null && pagosautorizados!=null) {
				if((pagosautorizadosAux.getId()==null && pagosautorizados.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pagosautorizadosAux.getId()!=null && pagosautorizados.getId()!=null){
					if(pagosautorizadosAux.getId().equals(pagosautorizados.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPagosAutorizados(List<PagosAutorizados> pagosautorizadoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_por_pagarTotal=0.0;
		Double valor_canceladoTotal=0.0;
	
		for(PagosAutorizados pagosautorizados: pagosautorizadoss) {			
			if(pagosautorizados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_por_pagarTotal+=pagosautorizados.getvalor_por_pagar();
			valor_canceladoTotal+=pagosautorizados.getvalor_cancelado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutorizadosConstantesFunciones.VALORPORPAGAR);
		datoGeneral.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_VALORPORPAGAR);
		datoGeneral.setdValorDouble(valor_por_pagarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutorizadosConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_VALORCANCELADO);
		datoGeneral.setdValorDouble(valor_canceladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPagosAutorizados() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_ID, PagosAutorizadosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_VERSIONROW, PagosAutorizadosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE, PagosAutorizadosConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA, PagosAutorizadosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_FECHAEMISION, PagosAutorizadosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_FECHAVENCIMIENTO, PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO, PagosAutorizadosConstantesFunciones.NOMBREBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_VALORPORPAGAR, PagosAutorizadosConstantesFunciones.VALORPORPAGAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_VALORCANCELADO, PagosAutorizadosConstantesFunciones.VALORCANCELADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA, PagosAutorizadosConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_ESTAAUTORIZADO, PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_DESCRIPCION, PagosAutorizadosConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE, PagosAutorizadosConstantesFunciones.FECHACORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_ESTADO, PagosAutorizadosConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE, PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO, PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPagosAutorizados() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.NOMBREBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.VALORPORPAGAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.VALORCANCELADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.FECHACORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutorizados() throws Exception  {
		return PagosAutorizadosConstantesFunciones.getTiposSeleccionarPagosAutorizados(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutorizados(Boolean conFk) throws Exception  {
		return PagosAutorizadosConstantesFunciones.getTiposSeleccionarPagosAutorizados(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutorizados(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE0);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_VALORPORPAGAR);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_VALORPORPAGAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_VALORCANCELADO);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_VALORCANCELADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_ESTAAUTORIZADO);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_ESTAAUTORIZADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO);
			reporte.setsDescripcion(PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPagosAutorizados(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPagosAutorizados(PagosAutorizados pagosautorizadosAux) throws Exception {
		
			pagosautorizadosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagosautorizadosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPagosAutorizados(List<PagosAutorizados> pagosautorizadossTemp) throws Exception {
		for(PagosAutorizados pagosautorizadosAux:pagosautorizadossTemp) {
			
			pagosautorizadosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagosautorizadosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPagosAutorizados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPagosAutorizados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagosAutorizados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagosAutorizadosConstantesFunciones.getClassesRelationshipsOfPagosAutorizados(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagosAutorizados(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagosAutorizados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagosAutorizadosConstantesFunciones.getClassesRelationshipsFromStringsOfPagosAutorizados(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagosAutorizados(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PagosAutorizados pagosautorizados,List<PagosAutorizados> pagosautorizadoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PagosAutorizados pagosautorizados,List<PagosAutorizados> pagosautorizadoss) throws Exception {
		try	{			
			for(PagosAutorizados pagosautorizadosLocal:pagosautorizadoss) {
				if(pagosautorizadosLocal.getId().equals(pagosautorizados.getId())) {
					pagosautorizadosLocal.setIsSelected(pagosautorizados.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPagosAutorizados(List<PagosAutorizados> pagosautorizadossAux) throws Exception {
		//this.pagosautorizadossAux=pagosautorizadossAux;
		
		for(PagosAutorizados pagosautorizadosAux:pagosautorizadossAux) {
			if(pagosautorizadosAux.getIsChanged()) {
				pagosautorizadosAux.setIsChanged(false);
			}		
			
			if(pagosautorizadosAux.getIsNew()) {
				pagosautorizadosAux.setIsNew(false);
			}	
			
			if(pagosautorizadosAux.getIsDeleted()) {
				pagosautorizadosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPagosAutorizados(PagosAutorizados pagosautorizadosAux) throws Exception {
		//this.pagosautorizadosAux=pagosautorizadosAux;
		
			if(pagosautorizadosAux.getIsChanged()) {
				pagosautorizadosAux.setIsChanged(false);
			}		
			
			if(pagosautorizadosAux.getIsNew()) {
				pagosautorizadosAux.setIsNew(false);
			}	
			
			if(pagosautorizadosAux.getIsDeleted()) {
				pagosautorizadosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PagosAutorizados pagosautorizadosAsignar,PagosAutorizados pagosautorizados) throws Exception {
		pagosautorizadosAsignar.setId(pagosautorizados.getId());	
		pagosautorizadosAsignar.setVersionRow(pagosautorizados.getVersionRow());	
		pagosautorizadosAsignar.setnombre_cliente(pagosautorizados.getnombre_cliente());	
		pagosautorizadosAsignar.setnumero_factura(pagosautorizados.getnumero_factura());	
		pagosautorizadosAsignar.setfecha_emision(pagosautorizados.getfecha_emision());	
		pagosautorizadosAsignar.setfecha_vencimiento(pagosautorizados.getfecha_vencimiento());	
		pagosautorizadosAsignar.setnombre_banco(pagosautorizados.getnombre_banco());	
		pagosautorizadosAsignar.setvalor_por_pagar(pagosautorizados.getvalor_por_pagar());	
		pagosautorizadosAsignar.setvalor_cancelado(pagosautorizados.getvalor_cancelado());	
		pagosautorizadosAsignar.setnumero_cuenta(pagosautorizados.getnumero_cuenta());	
		pagosautorizadosAsignar.setesta_autorizado(pagosautorizados.getesta_autorizado());	
		pagosautorizadosAsignar.setdescripcion(pagosautorizados.getdescripcion());	
		pagosautorizadosAsignar.setfecha_corte_dato(pagosautorizados.getfecha_corte_dato());	
		pagosautorizadosAsignar.setestado(pagosautorizados.getestado());	
		pagosautorizadosAsignar.setcodigo_cuenta_con_cliente(pagosautorizados.getcodigo_cuenta_con_cliente());	
		pagosautorizadosAsignar.setcodigo_cuenta_con_banco(pagosautorizados.getcodigo_cuenta_con_banco());	
	}
	
	public static void inicializarPagosAutorizados(PagosAutorizados pagosautorizados) throws Exception {
		try {
				pagosautorizados.setId(0L);	
					
				pagosautorizados.setnombre_cliente("");	
				pagosautorizados.setnumero_factura("");	
				pagosautorizados.setfecha_emision(new Date());	
				pagosautorizados.setfecha_vencimiento(new Date());	
				pagosautorizados.setnombre_banco("");	
				pagosautorizados.setvalor_por_pagar(0.0);	
				pagosautorizados.setvalor_cancelado(0.0);	
				pagosautorizados.setnumero_cuenta("");	
				pagosautorizados.setesta_autorizado(false);	
				pagosautorizados.setdescripcion("");	
				pagosautorizados.setfecha_corte_dato(new Date());	
				pagosautorizados.setestado("");	
				pagosautorizados.setcodigo_cuenta_con_cliente("");	
				pagosautorizados.setcodigo_cuenta_con_banco("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPagosAutorizados(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_NOMBREBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_VALORPORPAGAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_VALORCANCELADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_ESTAAUTORIZADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_FECHACORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutorizadosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPagosAutorizados(String sTipo,Row row,Workbook workbook,PagosAutorizados pagosautorizados,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getfecha_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getnombre_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getvalor_por_pagar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getvalor_cancelado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(pagosautorizados.getesta_autorizado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getfecha_corte_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getestado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getcodigo_cuenta_con_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautorizados.getcodigo_cuenta_con_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPagosAutorizados="";
	
	public String getsFinalQueryPagosAutorizados() {
		return this.sFinalQueryPagosAutorizados;
	}
	
	public void setsFinalQueryPagosAutorizados(String sFinalQueryPagosAutorizados) {
		this.sFinalQueryPagosAutorizados= sFinalQueryPagosAutorizados;
	}
	
	public Border resaltarSeleccionarPagosAutorizados=null;
	
	public Border setResaltarSeleccionarPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPagosAutorizados= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPagosAutorizados() {
		return this.resaltarSeleccionarPagosAutorizados;
	}
	
	public void setResaltarSeleccionarPagosAutorizados(Border borderResaltarSeleccionarPagosAutorizados) {
		this.resaltarSeleccionarPagosAutorizados= borderResaltarSeleccionarPagosAutorizados;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPagosAutorizados=null;
	public Boolean mostraridPagosAutorizados=true;
	public Boolean activaridPagosAutorizados=true;

	public Border resaltarid_empresaPagosAutorizados=null;
	public Boolean mostrarid_empresaPagosAutorizados=true;
	public Boolean activarid_empresaPagosAutorizados=true;
	public Boolean cargarid_empresaPagosAutorizados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPagosAutorizados=false;//ConEventDepend=true

	public Border resaltarfecha_cortePagosAutorizados=null;
	public Boolean mostrarfecha_cortePagosAutorizados=true;
	public Boolean activarfecha_cortePagosAutorizados=true;

	public Border resaltarnombre_clientePagosAutorizados=null;
	public Boolean mostrarnombre_clientePagosAutorizados=true;
	public Boolean activarnombre_clientePagosAutorizados=true;

	public Border resaltarnumero_facturaPagosAutorizados=null;
	public Boolean mostrarnumero_facturaPagosAutorizados=true;
	public Boolean activarnumero_facturaPagosAutorizados=true;

	public Border resaltarfecha_emisionPagosAutorizados=null;
	public Boolean mostrarfecha_emisionPagosAutorizados=true;
	public Boolean activarfecha_emisionPagosAutorizados=true;

	public Border resaltarfecha_vencimientoPagosAutorizados=null;
	public Boolean mostrarfecha_vencimientoPagosAutorizados=true;
	public Boolean activarfecha_vencimientoPagosAutorizados=true;

	public Border resaltarnombre_bancoPagosAutorizados=null;
	public Boolean mostrarnombre_bancoPagosAutorizados=true;
	public Boolean activarnombre_bancoPagosAutorizados=true;

	public Border resaltarvalor_por_pagarPagosAutorizados=null;
	public Boolean mostrarvalor_por_pagarPagosAutorizados=true;
	public Boolean activarvalor_por_pagarPagosAutorizados=true;

	public Border resaltarvalor_canceladoPagosAutorizados=null;
	public Boolean mostrarvalor_canceladoPagosAutorizados=true;
	public Boolean activarvalor_canceladoPagosAutorizados=true;

	public Border resaltarnumero_cuentaPagosAutorizados=null;
	public Boolean mostrarnumero_cuentaPagosAutorizados=true;
	public Boolean activarnumero_cuentaPagosAutorizados=true;

	public Border resaltaresta_autorizadoPagosAutorizados=null;
	public Boolean mostraresta_autorizadoPagosAutorizados=true;
	public Boolean activaresta_autorizadoPagosAutorizados=true;

	public Border resaltardescripcionPagosAutorizados=null;
	public Boolean mostrardescripcionPagosAutorizados=true;
	public Boolean activardescripcionPagosAutorizados=true;

	public Border resaltarfecha_corte_datoPagosAutorizados=null;
	public Boolean mostrarfecha_corte_datoPagosAutorizados=true;
	public Boolean activarfecha_corte_datoPagosAutorizados=true;

	public Border resaltarestadoPagosAutorizados=null;
	public Boolean mostrarestadoPagosAutorizados=true;
	public Boolean activarestadoPagosAutorizados=true;

	public Border resaltarcodigo_cuenta_con_clientePagosAutorizados=null;
	public Boolean mostrarcodigo_cuenta_con_clientePagosAutorizados=true;
	public Boolean activarcodigo_cuenta_con_clientePagosAutorizados=true;

	public Border resaltarcodigo_cuenta_con_bancoPagosAutorizados=null;
	public Boolean mostrarcodigo_cuenta_con_bancoPagosAutorizados=true;
	public Boolean activarcodigo_cuenta_con_bancoPagosAutorizados=true;

	
	

	public Border setResaltaridPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltaridPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPagosAutorizados() {
		return this.resaltaridPagosAutorizados;
	}

	public void setResaltaridPagosAutorizados(Border borderResaltar) {
		this.resaltaridPagosAutorizados= borderResaltar;
	}

	public Boolean getMostraridPagosAutorizados() {
		return this.mostraridPagosAutorizados;
	}

	public void setMostraridPagosAutorizados(Boolean mostraridPagosAutorizados) {
		this.mostraridPagosAutorizados= mostraridPagosAutorizados;
	}

	public Boolean getActivaridPagosAutorizados() {
		return this.activaridPagosAutorizados;
	}

	public void setActivaridPagosAutorizados(Boolean activaridPagosAutorizados) {
		this.activaridPagosAutorizados= activaridPagosAutorizados;
	}

	public Border setResaltarid_empresaPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarid_empresaPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPagosAutorizados() {
		return this.resaltarid_empresaPagosAutorizados;
	}

	public void setResaltarid_empresaPagosAutorizados(Border borderResaltar) {
		this.resaltarid_empresaPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarid_empresaPagosAutorizados() {
		return this.mostrarid_empresaPagosAutorizados;
	}

	public void setMostrarid_empresaPagosAutorizados(Boolean mostrarid_empresaPagosAutorizados) {
		this.mostrarid_empresaPagosAutorizados= mostrarid_empresaPagosAutorizados;
	}

	public Boolean getActivarid_empresaPagosAutorizados() {
		return this.activarid_empresaPagosAutorizados;
	}

	public void setActivarid_empresaPagosAutorizados(Boolean activarid_empresaPagosAutorizados) {
		this.activarid_empresaPagosAutorizados= activarid_empresaPagosAutorizados;
	}

	public Boolean getCargarid_empresaPagosAutorizados() {
		return this.cargarid_empresaPagosAutorizados;
	}

	public void setCargarid_empresaPagosAutorizados(Boolean cargarid_empresaPagosAutorizados) {
		this.cargarid_empresaPagosAutorizados= cargarid_empresaPagosAutorizados;
	}

	public Border setResaltarfecha_cortePagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarfecha_cortePagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_cortePagosAutorizados() {
		return this.resaltarfecha_cortePagosAutorizados;
	}

	public void setResaltarfecha_cortePagosAutorizados(Border borderResaltar) {
		this.resaltarfecha_cortePagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarfecha_cortePagosAutorizados() {
		return this.mostrarfecha_cortePagosAutorizados;
	}

	public void setMostrarfecha_cortePagosAutorizados(Boolean mostrarfecha_cortePagosAutorizados) {
		this.mostrarfecha_cortePagosAutorizados= mostrarfecha_cortePagosAutorizados;
	}

	public Boolean getActivarfecha_cortePagosAutorizados() {
		return this.activarfecha_cortePagosAutorizados;
	}

	public void setActivarfecha_cortePagosAutorizados(Boolean activarfecha_cortePagosAutorizados) {
		this.activarfecha_cortePagosAutorizados= activarfecha_cortePagosAutorizados;
	}

	public Border setResaltarnombre_clientePagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnombre_clientePagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clientePagosAutorizados() {
		return this.resaltarnombre_clientePagosAutorizados;
	}

	public void setResaltarnombre_clientePagosAutorizados(Border borderResaltar) {
		this.resaltarnombre_clientePagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnombre_clientePagosAutorizados() {
		return this.mostrarnombre_clientePagosAutorizados;
	}

	public void setMostrarnombre_clientePagosAutorizados(Boolean mostrarnombre_clientePagosAutorizados) {
		this.mostrarnombre_clientePagosAutorizados= mostrarnombre_clientePagosAutorizados;
	}

	public Boolean getActivarnombre_clientePagosAutorizados() {
		return this.activarnombre_clientePagosAutorizados;
	}

	public void setActivarnombre_clientePagosAutorizados(Boolean activarnombre_clientePagosAutorizados) {
		this.activarnombre_clientePagosAutorizados= activarnombre_clientePagosAutorizados;
	}

	public Border setResaltarnumero_facturaPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaPagosAutorizados() {
		return this.resaltarnumero_facturaPagosAutorizados;
	}

	public void setResaltarnumero_facturaPagosAutorizados(Border borderResaltar) {
		this.resaltarnumero_facturaPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaPagosAutorizados() {
		return this.mostrarnumero_facturaPagosAutorizados;
	}

	public void setMostrarnumero_facturaPagosAutorizados(Boolean mostrarnumero_facturaPagosAutorizados) {
		this.mostrarnumero_facturaPagosAutorizados= mostrarnumero_facturaPagosAutorizados;
	}

	public Boolean getActivarnumero_facturaPagosAutorizados() {
		return this.activarnumero_facturaPagosAutorizados;
	}

	public void setActivarnumero_facturaPagosAutorizados(Boolean activarnumero_facturaPagosAutorizados) {
		this.activarnumero_facturaPagosAutorizados= activarnumero_facturaPagosAutorizados;
	}

	public Border setResaltarfecha_emisionPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPagosAutorizados() {
		return this.resaltarfecha_emisionPagosAutorizados;
	}

	public void setResaltarfecha_emisionPagosAutorizados(Border borderResaltar) {
		this.resaltarfecha_emisionPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPagosAutorizados() {
		return this.mostrarfecha_emisionPagosAutorizados;
	}

	public void setMostrarfecha_emisionPagosAutorizados(Boolean mostrarfecha_emisionPagosAutorizados) {
		this.mostrarfecha_emisionPagosAutorizados= mostrarfecha_emisionPagosAutorizados;
	}

	public Boolean getActivarfecha_emisionPagosAutorizados() {
		return this.activarfecha_emisionPagosAutorizados;
	}

	public void setActivarfecha_emisionPagosAutorizados(Boolean activarfecha_emisionPagosAutorizados) {
		this.activarfecha_emisionPagosAutorizados= activarfecha_emisionPagosAutorizados;
	}

	public Border setResaltarfecha_vencimientoPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoPagosAutorizados() {
		return this.resaltarfecha_vencimientoPagosAutorizados;
	}

	public void setResaltarfecha_vencimientoPagosAutorizados(Border borderResaltar) {
		this.resaltarfecha_vencimientoPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoPagosAutorizados() {
		return this.mostrarfecha_vencimientoPagosAutorizados;
	}

	public void setMostrarfecha_vencimientoPagosAutorizados(Boolean mostrarfecha_vencimientoPagosAutorizados) {
		this.mostrarfecha_vencimientoPagosAutorizados= mostrarfecha_vencimientoPagosAutorizados;
	}

	public Boolean getActivarfecha_vencimientoPagosAutorizados() {
		return this.activarfecha_vencimientoPagosAutorizados;
	}

	public void setActivarfecha_vencimientoPagosAutorizados(Boolean activarfecha_vencimientoPagosAutorizados) {
		this.activarfecha_vencimientoPagosAutorizados= activarfecha_vencimientoPagosAutorizados;
	}

	public Border setResaltarnombre_bancoPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnombre_bancoPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bancoPagosAutorizados() {
		return this.resaltarnombre_bancoPagosAutorizados;
	}

	public void setResaltarnombre_bancoPagosAutorizados(Border borderResaltar) {
		this.resaltarnombre_bancoPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnombre_bancoPagosAutorizados() {
		return this.mostrarnombre_bancoPagosAutorizados;
	}

	public void setMostrarnombre_bancoPagosAutorizados(Boolean mostrarnombre_bancoPagosAutorizados) {
		this.mostrarnombre_bancoPagosAutorizados= mostrarnombre_bancoPagosAutorizados;
	}

	public Boolean getActivarnombre_bancoPagosAutorizados() {
		return this.activarnombre_bancoPagosAutorizados;
	}

	public void setActivarnombre_bancoPagosAutorizados(Boolean activarnombre_bancoPagosAutorizados) {
		this.activarnombre_bancoPagosAutorizados= activarnombre_bancoPagosAutorizados;
	}

	public Border setResaltarvalor_por_pagarPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarvalor_por_pagarPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_por_pagarPagosAutorizados() {
		return this.resaltarvalor_por_pagarPagosAutorizados;
	}

	public void setResaltarvalor_por_pagarPagosAutorizados(Border borderResaltar) {
		this.resaltarvalor_por_pagarPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarvalor_por_pagarPagosAutorizados() {
		return this.mostrarvalor_por_pagarPagosAutorizados;
	}

	public void setMostrarvalor_por_pagarPagosAutorizados(Boolean mostrarvalor_por_pagarPagosAutorizados) {
		this.mostrarvalor_por_pagarPagosAutorizados= mostrarvalor_por_pagarPagosAutorizados;
	}

	public Boolean getActivarvalor_por_pagarPagosAutorizados() {
		return this.activarvalor_por_pagarPagosAutorizados;
	}

	public void setActivarvalor_por_pagarPagosAutorizados(Boolean activarvalor_por_pagarPagosAutorizados) {
		this.activarvalor_por_pagarPagosAutorizados= activarvalor_por_pagarPagosAutorizados;
	}

	public Border setResaltarvalor_canceladoPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarvalor_canceladoPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_canceladoPagosAutorizados() {
		return this.resaltarvalor_canceladoPagosAutorizados;
	}

	public void setResaltarvalor_canceladoPagosAutorizados(Border borderResaltar) {
		this.resaltarvalor_canceladoPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarvalor_canceladoPagosAutorizados() {
		return this.mostrarvalor_canceladoPagosAutorizados;
	}

	public void setMostrarvalor_canceladoPagosAutorizados(Boolean mostrarvalor_canceladoPagosAutorizados) {
		this.mostrarvalor_canceladoPagosAutorizados= mostrarvalor_canceladoPagosAutorizados;
	}

	public Boolean getActivarvalor_canceladoPagosAutorizados() {
		return this.activarvalor_canceladoPagosAutorizados;
	}

	public void setActivarvalor_canceladoPagosAutorizados(Boolean activarvalor_canceladoPagosAutorizados) {
		this.activarvalor_canceladoPagosAutorizados= activarvalor_canceladoPagosAutorizados;
	}

	public Border setResaltarnumero_cuentaPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaPagosAutorizados() {
		return this.resaltarnumero_cuentaPagosAutorizados;
	}

	public void setResaltarnumero_cuentaPagosAutorizados(Border borderResaltar) {
		this.resaltarnumero_cuentaPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaPagosAutorizados() {
		return this.mostrarnumero_cuentaPagosAutorizados;
	}

	public void setMostrarnumero_cuentaPagosAutorizados(Boolean mostrarnumero_cuentaPagosAutorizados) {
		this.mostrarnumero_cuentaPagosAutorizados= mostrarnumero_cuentaPagosAutorizados;
	}

	public Boolean getActivarnumero_cuentaPagosAutorizados() {
		return this.activarnumero_cuentaPagosAutorizados;
	}

	public void setActivarnumero_cuentaPagosAutorizados(Boolean activarnumero_cuentaPagosAutorizados) {
		this.activarnumero_cuentaPagosAutorizados= activarnumero_cuentaPagosAutorizados;
	}

	public Border setResaltaresta_autorizadoPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltaresta_autorizadoPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_autorizadoPagosAutorizados() {
		return this.resaltaresta_autorizadoPagosAutorizados;
	}

	public void setResaltaresta_autorizadoPagosAutorizados(Border borderResaltar) {
		this.resaltaresta_autorizadoPagosAutorizados= borderResaltar;
	}

	public Boolean getMostraresta_autorizadoPagosAutorizados() {
		return this.mostraresta_autorizadoPagosAutorizados;
	}

	public void setMostraresta_autorizadoPagosAutorizados(Boolean mostraresta_autorizadoPagosAutorizados) {
		this.mostraresta_autorizadoPagosAutorizados= mostraresta_autorizadoPagosAutorizados;
	}

	public Boolean getActivaresta_autorizadoPagosAutorizados() {
		return this.activaresta_autorizadoPagosAutorizados;
	}

	public void setActivaresta_autorizadoPagosAutorizados(Boolean activaresta_autorizadoPagosAutorizados) {
		this.activaresta_autorizadoPagosAutorizados= activaresta_autorizadoPagosAutorizados;
	}

	public Border setResaltardescripcionPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltardescripcionPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPagosAutorizados() {
		return this.resaltardescripcionPagosAutorizados;
	}

	public void setResaltardescripcionPagosAutorizados(Border borderResaltar) {
		this.resaltardescripcionPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrardescripcionPagosAutorizados() {
		return this.mostrardescripcionPagosAutorizados;
	}

	public void setMostrardescripcionPagosAutorizados(Boolean mostrardescripcionPagosAutorizados) {
		this.mostrardescripcionPagosAutorizados= mostrardescripcionPagosAutorizados;
	}

	public Boolean getActivardescripcionPagosAutorizados() {
		return this.activardescripcionPagosAutorizados;
	}

	public void setActivardescripcionPagosAutorizados(Boolean activardescripcionPagosAutorizados) {
		this.activardescripcionPagosAutorizados= activardescripcionPagosAutorizados;
	}

	public Border setResaltarfecha_corte_datoPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarfecha_corte_datoPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_corte_datoPagosAutorizados() {
		return this.resaltarfecha_corte_datoPagosAutorizados;
	}

	public void setResaltarfecha_corte_datoPagosAutorizados(Border borderResaltar) {
		this.resaltarfecha_corte_datoPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarfecha_corte_datoPagosAutorizados() {
		return this.mostrarfecha_corte_datoPagosAutorizados;
	}

	public void setMostrarfecha_corte_datoPagosAutorizados(Boolean mostrarfecha_corte_datoPagosAutorizados) {
		this.mostrarfecha_corte_datoPagosAutorizados= mostrarfecha_corte_datoPagosAutorizados;
	}

	public Boolean getActivarfecha_corte_datoPagosAutorizados() {
		return this.activarfecha_corte_datoPagosAutorizados;
	}

	public void setActivarfecha_corte_datoPagosAutorizados(Boolean activarfecha_corte_datoPagosAutorizados) {
		this.activarfecha_corte_datoPagosAutorizados= activarfecha_corte_datoPagosAutorizados;
	}

	public Border setResaltarestadoPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarestadoPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoPagosAutorizados() {
		return this.resaltarestadoPagosAutorizados;
	}

	public void setResaltarestadoPagosAutorizados(Border borderResaltar) {
		this.resaltarestadoPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarestadoPagosAutorizados() {
		return this.mostrarestadoPagosAutorizados;
	}

	public void setMostrarestadoPagosAutorizados(Boolean mostrarestadoPagosAutorizados) {
		this.mostrarestadoPagosAutorizados= mostrarestadoPagosAutorizados;
	}

	public Boolean getActivarestadoPagosAutorizados() {
		return this.activarestadoPagosAutorizados;
	}

	public void setActivarestadoPagosAutorizados(Boolean activarestadoPagosAutorizados) {
		this.activarestadoPagosAutorizados= activarestadoPagosAutorizados;
	}

	public Border setResaltarcodigo_cuenta_con_clientePagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_con_clientePagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_con_clientePagosAutorizados() {
		return this.resaltarcodigo_cuenta_con_clientePagosAutorizados;
	}

	public void setResaltarcodigo_cuenta_con_clientePagosAutorizados(Border borderResaltar) {
		this.resaltarcodigo_cuenta_con_clientePagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_con_clientePagosAutorizados() {
		return this.mostrarcodigo_cuenta_con_clientePagosAutorizados;
	}

	public void setMostrarcodigo_cuenta_con_clientePagosAutorizados(Boolean mostrarcodigo_cuenta_con_clientePagosAutorizados) {
		this.mostrarcodigo_cuenta_con_clientePagosAutorizados= mostrarcodigo_cuenta_con_clientePagosAutorizados;
	}

	public Boolean getActivarcodigo_cuenta_con_clientePagosAutorizados() {
		return this.activarcodigo_cuenta_con_clientePagosAutorizados;
	}

	public void setActivarcodigo_cuenta_con_clientePagosAutorizados(Boolean activarcodigo_cuenta_con_clientePagosAutorizados) {
		this.activarcodigo_cuenta_con_clientePagosAutorizados= activarcodigo_cuenta_con_clientePagosAutorizados;
	}

	public Border setResaltarcodigo_cuenta_con_bancoPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautorizadosBeanSwingJInternalFrame.jTtoolBarPagosAutorizados.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_con_bancoPagosAutorizados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_con_bancoPagosAutorizados() {
		return this.resaltarcodigo_cuenta_con_bancoPagosAutorizados;
	}

	public void setResaltarcodigo_cuenta_con_bancoPagosAutorizados(Border borderResaltar) {
		this.resaltarcodigo_cuenta_con_bancoPagosAutorizados= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_con_bancoPagosAutorizados() {
		return this.mostrarcodigo_cuenta_con_bancoPagosAutorizados;
	}

	public void setMostrarcodigo_cuenta_con_bancoPagosAutorizados(Boolean mostrarcodigo_cuenta_con_bancoPagosAutorizados) {
		this.mostrarcodigo_cuenta_con_bancoPagosAutorizados= mostrarcodigo_cuenta_con_bancoPagosAutorizados;
	}

	public Boolean getActivarcodigo_cuenta_con_bancoPagosAutorizados() {
		return this.activarcodigo_cuenta_con_bancoPagosAutorizados;
	}

	public void setActivarcodigo_cuenta_con_bancoPagosAutorizados(Boolean activarcodigo_cuenta_con_bancoPagosAutorizados) {
		this.activarcodigo_cuenta_con_bancoPagosAutorizados= activarcodigo_cuenta_con_bancoPagosAutorizados;
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
		
		
		this.setMostraridPagosAutorizados(esInicial);
		this.setMostrarid_empresaPagosAutorizados(esInicial);
		this.setMostrarfecha_cortePagosAutorizados(esInicial);
		this.setMostrarnombre_clientePagosAutorizados(esInicial);
		this.setMostrarnumero_facturaPagosAutorizados(esInicial);
		this.setMostrarfecha_emisionPagosAutorizados(esInicial);
		this.setMostrarfecha_vencimientoPagosAutorizados(esInicial);
		this.setMostrarnombre_bancoPagosAutorizados(esInicial);
		this.setMostrarvalor_por_pagarPagosAutorizados(esInicial);
		this.setMostrarvalor_canceladoPagosAutorizados(esInicial);
		this.setMostrarnumero_cuentaPagosAutorizados(esInicial);
		this.setMostraresta_autorizadoPagosAutorizados(esInicial);
		this.setMostrardescripcionPagosAutorizados(esInicial);
		this.setMostrarfecha_corte_datoPagosAutorizados(esInicial);
		this.setMostrarestadoPagosAutorizados(esInicial);
		this.setMostrarcodigo_cuenta_con_clientePagosAutorizados(esInicial);
		this.setMostrarcodigo_cuenta_con_bancoPagosAutorizados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ID)) {
				this.setMostraridPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHACORTE0)) {
				this.setMostrarfecha_cortePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clientePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NOMBREBANCO)) {
				this.setMostrarnombre_bancoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.VALORPORPAGAR)) {
				this.setMostrarvalor_por_pagarPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.VALORCANCELADO)) {
				this.setMostrarvalor_canceladoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO)) {
				this.setMostraresta_autorizadoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHACORTE)) {
				this.setMostrarfecha_corte_datoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ESTADO)) {
				this.setMostrarestadoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE)) {
				this.setMostrarcodigo_cuenta_con_clientePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO)) {
				this.setMostrarcodigo_cuenta_con_bancoPagosAutorizados(esAsigna);
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
		
		
		this.setActivaridPagosAutorizados(esInicial);
		this.setActivarid_empresaPagosAutorizados(esInicial);
		this.setActivarfecha_cortePagosAutorizados(esInicial);
		this.setActivarnombre_clientePagosAutorizados(esInicial);
		this.setActivarnumero_facturaPagosAutorizados(esInicial);
		this.setActivarfecha_emisionPagosAutorizados(esInicial);
		this.setActivarfecha_vencimientoPagosAutorizados(esInicial);
		this.setActivarnombre_bancoPagosAutorizados(esInicial);
		this.setActivarvalor_por_pagarPagosAutorizados(esInicial);
		this.setActivarvalor_canceladoPagosAutorizados(esInicial);
		this.setActivarnumero_cuentaPagosAutorizados(esInicial);
		this.setActivaresta_autorizadoPagosAutorizados(esInicial);
		this.setActivardescripcionPagosAutorizados(esInicial);
		this.setActivarfecha_corte_datoPagosAutorizados(esInicial);
		this.setActivarestadoPagosAutorizados(esInicial);
		this.setActivarcodigo_cuenta_con_clientePagosAutorizados(esInicial);
		this.setActivarcodigo_cuenta_con_bancoPagosAutorizados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ID)) {
				this.setActivaridPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHACORTE0)) {
				this.setActivarfecha_cortePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clientePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NOMBREBANCO)) {
				this.setActivarnombre_bancoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.VALORPORPAGAR)) {
				this.setActivarvalor_por_pagarPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.VALORCANCELADO)) {
				this.setActivarvalor_canceladoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO)) {
				this.setActivaresta_autorizadoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHACORTE)) {
				this.setActivarfecha_corte_datoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ESTADO)) {
				this.setActivarestadoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE)) {
				this.setActivarcodigo_cuenta_con_clientePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO)) {
				this.setActivarcodigo_cuenta_con_bancoPagosAutorizados(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPagosAutorizados(esInicial);
		this.setResaltarid_empresaPagosAutorizados(esInicial);
		this.setResaltarfecha_cortePagosAutorizados(esInicial);
		this.setResaltarnombre_clientePagosAutorizados(esInicial);
		this.setResaltarnumero_facturaPagosAutorizados(esInicial);
		this.setResaltarfecha_emisionPagosAutorizados(esInicial);
		this.setResaltarfecha_vencimientoPagosAutorizados(esInicial);
		this.setResaltarnombre_bancoPagosAutorizados(esInicial);
		this.setResaltarvalor_por_pagarPagosAutorizados(esInicial);
		this.setResaltarvalor_canceladoPagosAutorizados(esInicial);
		this.setResaltarnumero_cuentaPagosAutorizados(esInicial);
		this.setResaltaresta_autorizadoPagosAutorizados(esInicial);
		this.setResaltardescripcionPagosAutorizados(esInicial);
		this.setResaltarfecha_corte_datoPagosAutorizados(esInicial);
		this.setResaltarestadoPagosAutorizados(esInicial);
		this.setResaltarcodigo_cuenta_con_clientePagosAutorizados(esInicial);
		this.setResaltarcodigo_cuenta_con_bancoPagosAutorizados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ID)) {
				this.setResaltaridPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHACORTE0)) {
				this.setResaltarfecha_cortePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clientePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NOMBREBANCO)) {
				this.setResaltarnombre_bancoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.VALORPORPAGAR)) {
				this.setResaltarvalor_por_pagarPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.VALORCANCELADO)) {
				this.setResaltarvalor_canceladoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ESTAAUTORIZADO)) {
				this.setResaltaresta_autorizadoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.FECHACORTE)) {
				this.setResaltarfecha_corte_datoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.ESTADO)) {
				this.setResaltarestadoPagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.CODIGOCUENTACONCLIENTE)) {
				this.setResaltarcodigo_cuenta_con_clientePagosAutorizados(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutorizadosConstantesFunciones.CODIGOCUENTACONBANCO)) {
				this.setResaltarcodigo_cuenta_con_bancoPagosAutorizados(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPagosAutorizadosPagosAutorizados=true;

	public Boolean getMostrarBusquedaPagosAutorizadosPagosAutorizados() {
		return this.mostrarBusquedaPagosAutorizadosPagosAutorizados;
	}

	public void setMostrarBusquedaPagosAutorizadosPagosAutorizados(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPagosAutorizadosPagosAutorizados= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPagosAutorizadosPagosAutorizados=true;

	public Boolean getActivarBusquedaPagosAutorizadosPagosAutorizados() {
		return this.activarBusquedaPagosAutorizadosPagosAutorizados;
	}

	public void setActivarBusquedaPagosAutorizadosPagosAutorizados(Boolean habilitarResaltar) {
		this.activarBusquedaPagosAutorizadosPagosAutorizados= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPagosAutorizadosPagosAutorizados=null;

	public Border getResaltarBusquedaPagosAutorizadosPagosAutorizados() {
		return this.resaltarBusquedaPagosAutorizadosPagosAutorizados;
	}

	public void setResaltarBusquedaPagosAutorizadosPagosAutorizados(Border borderResaltar) {
		this.resaltarBusquedaPagosAutorizadosPagosAutorizados= borderResaltar;
	}

	public void setResaltarBusquedaPagosAutorizadosPagosAutorizados(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutorizadosBeanSwingJInternalFrame pagosautorizadosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPagosAutorizadosPagosAutorizados= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}