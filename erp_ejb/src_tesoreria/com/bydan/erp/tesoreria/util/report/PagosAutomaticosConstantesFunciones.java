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


import com.bydan.erp.tesoreria.util.report.PagosAutomaticosConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.PagosAutomaticosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.PagosAutomaticosParameterGeneral;

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
final public class PagosAutomaticosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="PagosAutomaticos";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PagosAutomaticos"+PagosAutomaticosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PagosAutomaticosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PagosAutomaticosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PagosAutomaticosConstantesFunciones.SCHEMA+"_"+PagosAutomaticosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PagosAutomaticosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PagosAutomaticosConstantesFunciones.SCHEMA+"_"+PagosAutomaticosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PagosAutomaticosConstantesFunciones.SCHEMA+"_"+PagosAutomaticosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PagosAutomaticosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PagosAutomaticosConstantesFunciones.SCHEMA+"_"+PagosAutomaticosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutomaticosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagosAutomaticosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutomaticosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutomaticosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagosAutomaticosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagosAutomaticosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PagosAutomaticosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PagosAutomaticosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PagosAutomaticosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PagosAutomaticosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pagos Automaticoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Pagos Automaticos";
	public static final String SCLASSWEBTITULO_LOWER="Pagos Automaticos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PagosAutomaticos";
	public static final String OBJECTNAME="pagosautomaticos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="pagos_automaticos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pagosautomaticos from "+PagosAutomaticosConstantesFunciones.SPERSISTENCENAME+" pagosautomaticos";
	public static String QUERYSELECTNATIVE="select "+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".id,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".version_row,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".id_empresa,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".fecha_corte,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".nombre_cliente,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".numero_factura,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".fecha_emision,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".fecha_vencimiento,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".nombre_banco,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".valor_por_pagar,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".valor_cancelado,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".numero_cuenta,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".esta_autorizado,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".descripcion,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".fecha_corte_dato,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".estado,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".codigo_cuenta_con_cliente,"+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME+".codigo_cuenta_con_banco from "+PagosAutomaticosConstantesFunciones.SCHEMA+"."+PagosAutomaticosConstantesFunciones.TABLENAME;//+" as "+PagosAutomaticosConstantesFunciones.TABLENAME;
	
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
	
	public static String getPagosAutomaticosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.IDEMPRESA)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.FECHACORTE0)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE0;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.FECHAEMISION)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.NOMBREBANCO)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_NOMBREBANCO;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.VALORPORPAGAR)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_VALORPORPAGAR;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.VALORCANCELADO)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_VALORCANCELADO;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.ESTAAUTORIZADO)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_ESTAAUTORIZADO;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.DESCRIPCION)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.FECHACORTE)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.ESTADO)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_ESTADO;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.CODIGOCUENTACONCLIENTE)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE;}
		if(sNombreColumna.equals(PagosAutomaticosConstantesFunciones.CODIGOCUENTACONBANCO)) {sLabelColumna=PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_autorizadoDescripcion(PagosAutomaticos pagosautomaticos) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!pagosautomaticos.getesta_autorizado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_autorizadoHtmlDescripcion(PagosAutomaticos pagosautomaticos) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(pagosautomaticos.getId(),pagosautomaticos.getesta_autorizado());

		return sDescripcion;
	}	
			
			
			
			
			
	
	public static String getPagosAutomaticosDescripcion(PagosAutomaticos pagosautomaticos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pagosautomaticos !=null/* && pagosautomaticos.getId()!=0*/) {
			sDescripcion=pagosautomaticos.getnombre_cliente();//pagosautomaticospagosautomaticos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPagosAutomaticosDescripcionDetallado(PagosAutomaticos pagosautomaticos) {
		String sDescripcion="";
			
		sDescripcion+=PagosAutomaticosConstantesFunciones.ID+"=";
		sDescripcion+=pagosautomaticos.getId().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pagosautomaticos.getVersionRow().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pagosautomaticos.getid_empresa().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.FECHACORTE0+"=";
		sDescripcion+=pagosautomaticos.getfecha_corte().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=pagosautomaticos.getnombre_cliente()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=pagosautomaticos.getnumero_factura()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pagosautomaticos.getfecha_emision().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=pagosautomaticos.getfecha_vencimiento().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.NOMBREBANCO+"=";
		sDescripcion+=pagosautomaticos.getnombre_banco()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.VALORPORPAGAR+"=";
		sDescripcion+=pagosautomaticos.getvalor_por_pagar().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.VALORCANCELADO+"=";
		sDescripcion+=pagosautomaticos.getvalor_cancelado().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=pagosautomaticos.getnumero_cuenta()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.ESTAAUTORIZADO+"=";
		sDescripcion+=pagosautomaticos.getesta_autorizado().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pagosautomaticos.getdescripcion()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.FECHACORTE+"=";
		sDescripcion+=pagosautomaticos.getfecha_corte_dato().toString()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.ESTADO+"=";
		sDescripcion+=pagosautomaticos.getestado()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.CODIGOCUENTACONCLIENTE+"=";
		sDescripcion+=pagosautomaticos.getcodigo_cuenta_con_cliente()+",";
		sDescripcion+=PagosAutomaticosConstantesFunciones.CODIGOCUENTACONBANCO+"=";
		sDescripcion+=pagosautomaticos.getcodigo_cuenta_con_banco()+",";
			
		return sDescripcion;
	}
	
	public static void setPagosAutomaticosDescripcion(PagosAutomaticos pagosautomaticos,String sValor) throws Exception {			
		if(pagosautomaticos !=null) {
			pagosautomaticos.setnombre_cliente(sValor);//pagosautomaticospagosautomaticos.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaPagosAutomaticos")) {
			sNombreIndice="Tipo=  Por Fecha Corte Base";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPagosAutomaticos(Date fecha_corte) {
		String sDetalleIndice=" Parametros->";
		if(fecha_corte!=null) {sDetalleIndice+=" Fecha Corte Base="+fecha_corte.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPagosAutomaticos(PagosAutomaticos pagosautomaticos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pagosautomaticos.setnombre_cliente(pagosautomaticos.getnombre_cliente().trim());
		pagosautomaticos.setnumero_factura(pagosautomaticos.getnumero_factura().trim());
		pagosautomaticos.setnombre_banco(pagosautomaticos.getnombre_banco().trim());
		pagosautomaticos.setnumero_cuenta(pagosautomaticos.getnumero_cuenta().trim());
		pagosautomaticos.setdescripcion(pagosautomaticos.getdescripcion().trim());
		pagosautomaticos.setestado(pagosautomaticos.getestado().trim());
		pagosautomaticos.setcodigo_cuenta_con_cliente(pagosautomaticos.getcodigo_cuenta_con_cliente().trim());
		pagosautomaticos.setcodigo_cuenta_con_banco(pagosautomaticos.getcodigo_cuenta_con_banco().trim());
	}
	
	public static void quitarEspaciosPagosAutomaticoss(List<PagosAutomaticos> pagosautomaticoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PagosAutomaticos pagosautomaticos: pagosautomaticoss) {
			pagosautomaticos.setnombre_cliente(pagosautomaticos.getnombre_cliente().trim());
			pagosautomaticos.setnumero_factura(pagosautomaticos.getnumero_factura().trim());
			pagosautomaticos.setnombre_banco(pagosautomaticos.getnombre_banco().trim());
			pagosautomaticos.setnumero_cuenta(pagosautomaticos.getnumero_cuenta().trim());
			pagosautomaticos.setdescripcion(pagosautomaticos.getdescripcion().trim());
			pagosautomaticos.setestado(pagosautomaticos.getestado().trim());
			pagosautomaticos.setcodigo_cuenta_con_cliente(pagosautomaticos.getcodigo_cuenta_con_cliente().trim());
			pagosautomaticos.setcodigo_cuenta_con_banco(pagosautomaticos.getcodigo_cuenta_con_banco().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagosAutomaticos(PagosAutomaticos pagosautomaticos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pagosautomaticos.getConCambioAuxiliar()) {
			pagosautomaticos.setIsDeleted(pagosautomaticos.getIsDeletedAuxiliar());	
			pagosautomaticos.setIsNew(pagosautomaticos.getIsNewAuxiliar());	
			pagosautomaticos.setIsChanged(pagosautomaticos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pagosautomaticos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pagosautomaticos.setIsDeletedAuxiliar(false);	
			pagosautomaticos.setIsNewAuxiliar(false);	
			pagosautomaticos.setIsChangedAuxiliar(false);
			
			pagosautomaticos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagosAutomaticoss(List<PagosAutomaticos> pagosautomaticoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PagosAutomaticos pagosautomaticos : pagosautomaticoss) {
			if(conAsignarBase && pagosautomaticos.getConCambioAuxiliar()) {
				pagosautomaticos.setIsDeleted(pagosautomaticos.getIsDeletedAuxiliar());	
				pagosautomaticos.setIsNew(pagosautomaticos.getIsNewAuxiliar());	
				pagosautomaticos.setIsChanged(pagosautomaticos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pagosautomaticos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pagosautomaticos.setIsDeletedAuxiliar(false);	
				pagosautomaticos.setIsNewAuxiliar(false);	
				pagosautomaticos.setIsChangedAuxiliar(false);
				
				pagosautomaticos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPagosAutomaticos(PagosAutomaticos pagosautomaticos,Boolean conEnteros) throws Exception  {
		pagosautomaticos.setvalor_por_pagar(0.0);
		pagosautomaticos.setvalor_cancelado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPagosAutomaticoss(List<PagosAutomaticos> pagosautomaticoss,Boolean conEnteros) throws Exception  {
		
		for(PagosAutomaticos pagosautomaticos: pagosautomaticoss) {
			pagosautomaticos.setvalor_por_pagar(0.0);
			pagosautomaticos.setvalor_cancelado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPagosAutomaticos(List<PagosAutomaticos> pagosautomaticoss,PagosAutomaticos pagosautomaticosAux) throws Exception  {
		PagosAutomaticosConstantesFunciones.InicializarValoresPagosAutomaticos(pagosautomaticosAux,true);
		
		for(PagosAutomaticos pagosautomaticos: pagosautomaticoss) {
			if(pagosautomaticos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pagosautomaticosAux.setvalor_por_pagar(pagosautomaticosAux.getvalor_por_pagar()+pagosautomaticos.getvalor_por_pagar());			
			pagosautomaticosAux.setvalor_cancelado(pagosautomaticosAux.getvalor_cancelado()+pagosautomaticos.getvalor_cancelado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosAutomaticos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PagosAutomaticosConstantesFunciones.getArrayColumnasGlobalesPagosAutomaticos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPagosAutomaticos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagosAutomaticosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagosAutomaticosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPagosAutomaticos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PagosAutomaticos> pagosautomaticoss,PagosAutomaticos pagosautomaticos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PagosAutomaticos pagosautomaticosAux: pagosautomaticoss) {
			if(pagosautomaticosAux!=null && pagosautomaticos!=null) {
				if((pagosautomaticosAux.getId()==null && pagosautomaticos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pagosautomaticosAux.getId()!=null && pagosautomaticos.getId()!=null){
					if(pagosautomaticosAux.getId().equals(pagosautomaticos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPagosAutomaticos(List<PagosAutomaticos> pagosautomaticoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_por_pagarTotal=0.0;
		Double valor_canceladoTotal=0.0;
	
		for(PagosAutomaticos pagosautomaticos: pagosautomaticoss) {			
			if(pagosautomaticos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_por_pagarTotal+=pagosautomaticos.getvalor_por_pagar();
			valor_canceladoTotal+=pagosautomaticos.getvalor_cancelado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutomaticosConstantesFunciones.VALORPORPAGAR);
		datoGeneral.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_VALORPORPAGAR);
		datoGeneral.setdValorDouble(valor_por_pagarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagosAutomaticosConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_VALORCANCELADO);
		datoGeneral.setdValorDouble(valor_canceladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPagosAutomaticos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_ID, PagosAutomaticosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_VERSIONROW, PagosAutomaticosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_NOMBRECLIENTE, PagosAutomaticosConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_NUMEROFACTURA, PagosAutomaticosConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_FECHAEMISION, PagosAutomaticosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_FECHAVENCIMIENTO, PagosAutomaticosConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_NOMBREBANCO, PagosAutomaticosConstantesFunciones.NOMBREBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_VALORPORPAGAR, PagosAutomaticosConstantesFunciones.VALORPORPAGAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_VALORCANCELADO, PagosAutomaticosConstantesFunciones.VALORCANCELADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_NUMEROCUENTA, PagosAutomaticosConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_ESTAAUTORIZADO, PagosAutomaticosConstantesFunciones.ESTAAUTORIZADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_DESCRIPCION, PagosAutomaticosConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE, PagosAutomaticosConstantesFunciones.FECHACORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_ESTADO, PagosAutomaticosConstantesFunciones.ESTADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE, PagosAutomaticosConstantesFunciones.CODIGOCUENTACONCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO, PagosAutomaticosConstantesFunciones.CODIGOCUENTACONBANCO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPagosAutomaticos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.NOMBREBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.VALORPORPAGAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.VALORCANCELADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.ESTAAUTORIZADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.FECHACORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.ESTADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.CODIGOCUENTACONCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagosAutomaticosConstantesFunciones.CODIGOCUENTACONBANCO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutomaticos() throws Exception  {
		return PagosAutomaticosConstantesFunciones.getTiposSeleccionarPagosAutomaticos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutomaticos(Boolean conFk) throws Exception  {
		return PagosAutomaticosConstantesFunciones.getTiposSeleccionarPagosAutomaticos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagosAutomaticos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE0);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_NOMBREBANCO);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_NOMBREBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_VALORPORPAGAR);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_VALORPORPAGAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_VALORCANCELADO);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_VALORCANCELADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_ESTAAUTORIZADO);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_ESTAAUTORIZADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_ESTADO);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_ESTADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO);
			reporte.setsDescripcion(PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPagosAutomaticos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPagosAutomaticos(PagosAutomaticos pagosautomaticosAux) throws Exception {
		
			pagosautomaticosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagosautomaticosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPagosAutomaticos(List<PagosAutomaticos> pagosautomaticossTemp) throws Exception {
		for(PagosAutomaticos pagosautomaticosAux:pagosautomaticossTemp) {
			
			pagosautomaticosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagosautomaticosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPagosAutomaticos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPagosAutomaticos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagosAutomaticos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagosAutomaticosConstantesFunciones.getClassesRelationshipsOfPagosAutomaticos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagosAutomaticos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagosAutomaticos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagosAutomaticosConstantesFunciones.getClassesRelationshipsFromStringsOfPagosAutomaticos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagosAutomaticos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PagosAutomaticos pagosautomaticos,List<PagosAutomaticos> pagosautomaticoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(PagosAutomaticos pagosautomaticos,List<PagosAutomaticos> pagosautomaticoss) throws Exception {
		try	{			
			for(PagosAutomaticos pagosautomaticosLocal:pagosautomaticoss) {
				if(pagosautomaticosLocal.getId().equals(pagosautomaticos.getId())) {
					pagosautomaticosLocal.setIsSelected(pagosautomaticos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPagosAutomaticos(List<PagosAutomaticos> pagosautomaticossAux) throws Exception {
		//this.pagosautomaticossAux=pagosautomaticossAux;
		
		for(PagosAutomaticos pagosautomaticosAux:pagosautomaticossAux) {
			if(pagosautomaticosAux.getIsChanged()) {
				pagosautomaticosAux.setIsChanged(false);
			}		
			
			if(pagosautomaticosAux.getIsNew()) {
				pagosautomaticosAux.setIsNew(false);
			}	
			
			if(pagosautomaticosAux.getIsDeleted()) {
				pagosautomaticosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPagosAutomaticos(PagosAutomaticos pagosautomaticosAux) throws Exception {
		//this.pagosautomaticosAux=pagosautomaticosAux;
		
			if(pagosautomaticosAux.getIsChanged()) {
				pagosautomaticosAux.setIsChanged(false);
			}		
			
			if(pagosautomaticosAux.getIsNew()) {
				pagosautomaticosAux.setIsNew(false);
			}	
			
			if(pagosautomaticosAux.getIsDeleted()) {
				pagosautomaticosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PagosAutomaticos pagosautomaticosAsignar,PagosAutomaticos pagosautomaticos) throws Exception {
		pagosautomaticosAsignar.setId(pagosautomaticos.getId());	
		pagosautomaticosAsignar.setVersionRow(pagosautomaticos.getVersionRow());	
		pagosautomaticosAsignar.setnombre_cliente(pagosautomaticos.getnombre_cliente());	
		pagosautomaticosAsignar.setnumero_factura(pagosautomaticos.getnumero_factura());	
		pagosautomaticosAsignar.setfecha_emision(pagosautomaticos.getfecha_emision());	
		pagosautomaticosAsignar.setfecha_vencimiento(pagosautomaticos.getfecha_vencimiento());	
		pagosautomaticosAsignar.setnombre_banco(pagosautomaticos.getnombre_banco());	
		pagosautomaticosAsignar.setvalor_por_pagar(pagosautomaticos.getvalor_por_pagar());	
		pagosautomaticosAsignar.setvalor_cancelado(pagosautomaticos.getvalor_cancelado());	
		pagosautomaticosAsignar.setnumero_cuenta(pagosautomaticos.getnumero_cuenta());	
		pagosautomaticosAsignar.setesta_autorizado(pagosautomaticos.getesta_autorizado());	
		pagosautomaticosAsignar.setdescripcion(pagosautomaticos.getdescripcion());	
		pagosautomaticosAsignar.setfecha_corte_dato(pagosautomaticos.getfecha_corte_dato());	
		pagosautomaticosAsignar.setestado(pagosautomaticos.getestado());	
		pagosautomaticosAsignar.setcodigo_cuenta_con_cliente(pagosautomaticos.getcodigo_cuenta_con_cliente());	
		pagosautomaticosAsignar.setcodigo_cuenta_con_banco(pagosautomaticos.getcodigo_cuenta_con_banco());	
	}
	
	public static void inicializarPagosAutomaticos(PagosAutomaticos pagosautomaticos) throws Exception {
		try {
				pagosautomaticos.setId(0L);	
					
				pagosautomaticos.setnombre_cliente("");	
				pagosautomaticos.setnumero_factura("");	
				pagosautomaticos.setfecha_emision(new Date());	
				pagosautomaticos.setfecha_vencimiento(new Date());	
				pagosautomaticos.setnombre_banco("");	
				pagosautomaticos.setvalor_por_pagar(0.0);	
				pagosautomaticos.setvalor_cancelado(0.0);	
				pagosautomaticos.setnumero_cuenta("");	
				pagosautomaticos.setesta_autorizado(false);	
				pagosautomaticos.setdescripcion("");	
				pagosautomaticos.setfecha_corte_dato(new Date());	
				pagosautomaticos.setestado("");	
				pagosautomaticos.setcodigo_cuenta_con_cliente("");	
				pagosautomaticos.setcodigo_cuenta_con_banco("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPagosAutomaticos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_NOMBREBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_VALORPORPAGAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_VALORCANCELADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_ESTAAUTORIZADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_FECHACORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_ESTADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagosAutomaticosConstantesFunciones.LABEL_CODIGOCUENTACONBANCO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPagosAutomaticos(String sTipo,Row row,Workbook workbook,PagosAutomaticos pagosautomaticos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getfecha_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getnombre_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getvalor_por_pagar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getvalor_cancelado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(pagosautomaticos.getesta_autorizado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getfecha_corte_dato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getestado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getcodigo_cuenta_con_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagosautomaticos.getcodigo_cuenta_con_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPagosAutomaticos="";
	
	public String getsFinalQueryPagosAutomaticos() {
		return this.sFinalQueryPagosAutomaticos;
	}
	
	public void setsFinalQueryPagosAutomaticos(String sFinalQueryPagosAutomaticos) {
		this.sFinalQueryPagosAutomaticos= sFinalQueryPagosAutomaticos;
	}
	
	public Border resaltarSeleccionarPagosAutomaticos=null;
	
	public Border setResaltarSeleccionarPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPagosAutomaticos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPagosAutomaticos() {
		return this.resaltarSeleccionarPagosAutomaticos;
	}
	
	public void setResaltarSeleccionarPagosAutomaticos(Border borderResaltarSeleccionarPagosAutomaticos) {
		this.resaltarSeleccionarPagosAutomaticos= borderResaltarSeleccionarPagosAutomaticos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPagosAutomaticos=null;
	public Boolean mostraridPagosAutomaticos=true;
	public Boolean activaridPagosAutomaticos=true;

	public Border resaltarid_empresaPagosAutomaticos=null;
	public Boolean mostrarid_empresaPagosAutomaticos=true;
	public Boolean activarid_empresaPagosAutomaticos=true;
	public Boolean cargarid_empresaPagosAutomaticos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPagosAutomaticos=false;//ConEventDepend=true

	public Border resaltarfecha_cortePagosAutomaticos=null;
	public Boolean mostrarfecha_cortePagosAutomaticos=true;
	public Boolean activarfecha_cortePagosAutomaticos=true;

	public Border resaltarnombre_clientePagosAutomaticos=null;
	public Boolean mostrarnombre_clientePagosAutomaticos=true;
	public Boolean activarnombre_clientePagosAutomaticos=true;

	public Border resaltarnumero_facturaPagosAutomaticos=null;
	public Boolean mostrarnumero_facturaPagosAutomaticos=true;
	public Boolean activarnumero_facturaPagosAutomaticos=true;

	public Border resaltarfecha_emisionPagosAutomaticos=null;
	public Boolean mostrarfecha_emisionPagosAutomaticos=true;
	public Boolean activarfecha_emisionPagosAutomaticos=true;

	public Border resaltarfecha_vencimientoPagosAutomaticos=null;
	public Boolean mostrarfecha_vencimientoPagosAutomaticos=true;
	public Boolean activarfecha_vencimientoPagosAutomaticos=true;

	public Border resaltarnombre_bancoPagosAutomaticos=null;
	public Boolean mostrarnombre_bancoPagosAutomaticos=true;
	public Boolean activarnombre_bancoPagosAutomaticos=true;

	public Border resaltarvalor_por_pagarPagosAutomaticos=null;
	public Boolean mostrarvalor_por_pagarPagosAutomaticos=true;
	public Boolean activarvalor_por_pagarPagosAutomaticos=true;

	public Border resaltarvalor_canceladoPagosAutomaticos=null;
	public Boolean mostrarvalor_canceladoPagosAutomaticos=true;
	public Boolean activarvalor_canceladoPagosAutomaticos=true;

	public Border resaltarnumero_cuentaPagosAutomaticos=null;
	public Boolean mostrarnumero_cuentaPagosAutomaticos=true;
	public Boolean activarnumero_cuentaPagosAutomaticos=true;

	public Border resaltaresta_autorizadoPagosAutomaticos=null;
	public Boolean mostraresta_autorizadoPagosAutomaticos=true;
	public Boolean activaresta_autorizadoPagosAutomaticos=true;

	public Border resaltardescripcionPagosAutomaticos=null;
	public Boolean mostrardescripcionPagosAutomaticos=true;
	public Boolean activardescripcionPagosAutomaticos=true;

	public Border resaltarfecha_corte_datoPagosAutomaticos=null;
	public Boolean mostrarfecha_corte_datoPagosAutomaticos=true;
	public Boolean activarfecha_corte_datoPagosAutomaticos=true;

	public Border resaltarestadoPagosAutomaticos=null;
	public Boolean mostrarestadoPagosAutomaticos=true;
	public Boolean activarestadoPagosAutomaticos=true;

	public Border resaltarcodigo_cuenta_con_clientePagosAutomaticos=null;
	public Boolean mostrarcodigo_cuenta_con_clientePagosAutomaticos=true;
	public Boolean activarcodigo_cuenta_con_clientePagosAutomaticos=true;

	public Border resaltarcodigo_cuenta_con_bancoPagosAutomaticos=null;
	public Boolean mostrarcodigo_cuenta_con_bancoPagosAutomaticos=true;
	public Boolean activarcodigo_cuenta_con_bancoPagosAutomaticos=true;

	
	

	public Border setResaltaridPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltaridPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPagosAutomaticos() {
		return this.resaltaridPagosAutomaticos;
	}

	public void setResaltaridPagosAutomaticos(Border borderResaltar) {
		this.resaltaridPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostraridPagosAutomaticos() {
		return this.mostraridPagosAutomaticos;
	}

	public void setMostraridPagosAutomaticos(Boolean mostraridPagosAutomaticos) {
		this.mostraridPagosAutomaticos= mostraridPagosAutomaticos;
	}

	public Boolean getActivaridPagosAutomaticos() {
		return this.activaridPagosAutomaticos;
	}

	public void setActivaridPagosAutomaticos(Boolean activaridPagosAutomaticos) {
		this.activaridPagosAutomaticos= activaridPagosAutomaticos;
	}

	public Border setResaltarid_empresaPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarid_empresaPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPagosAutomaticos() {
		return this.resaltarid_empresaPagosAutomaticos;
	}

	public void setResaltarid_empresaPagosAutomaticos(Border borderResaltar) {
		this.resaltarid_empresaPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarid_empresaPagosAutomaticos() {
		return this.mostrarid_empresaPagosAutomaticos;
	}

	public void setMostrarid_empresaPagosAutomaticos(Boolean mostrarid_empresaPagosAutomaticos) {
		this.mostrarid_empresaPagosAutomaticos= mostrarid_empresaPagosAutomaticos;
	}

	public Boolean getActivarid_empresaPagosAutomaticos() {
		return this.activarid_empresaPagosAutomaticos;
	}

	public void setActivarid_empresaPagosAutomaticos(Boolean activarid_empresaPagosAutomaticos) {
		this.activarid_empresaPagosAutomaticos= activarid_empresaPagosAutomaticos;
	}

	public Boolean getCargarid_empresaPagosAutomaticos() {
		return this.cargarid_empresaPagosAutomaticos;
	}

	public void setCargarid_empresaPagosAutomaticos(Boolean cargarid_empresaPagosAutomaticos) {
		this.cargarid_empresaPagosAutomaticos= cargarid_empresaPagosAutomaticos;
	}

	public Border setResaltarfecha_cortePagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarfecha_cortePagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_cortePagosAutomaticos() {
		return this.resaltarfecha_cortePagosAutomaticos;
	}

	public void setResaltarfecha_cortePagosAutomaticos(Border borderResaltar) {
		this.resaltarfecha_cortePagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarfecha_cortePagosAutomaticos() {
		return this.mostrarfecha_cortePagosAutomaticos;
	}

	public void setMostrarfecha_cortePagosAutomaticos(Boolean mostrarfecha_cortePagosAutomaticos) {
		this.mostrarfecha_cortePagosAutomaticos= mostrarfecha_cortePagosAutomaticos;
	}

	public Boolean getActivarfecha_cortePagosAutomaticos() {
		return this.activarfecha_cortePagosAutomaticos;
	}

	public void setActivarfecha_cortePagosAutomaticos(Boolean activarfecha_cortePagosAutomaticos) {
		this.activarfecha_cortePagosAutomaticos= activarfecha_cortePagosAutomaticos;
	}

	public Border setResaltarnombre_clientePagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarnombre_clientePagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clientePagosAutomaticos() {
		return this.resaltarnombre_clientePagosAutomaticos;
	}

	public void setResaltarnombre_clientePagosAutomaticos(Border borderResaltar) {
		this.resaltarnombre_clientePagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarnombre_clientePagosAutomaticos() {
		return this.mostrarnombre_clientePagosAutomaticos;
	}

	public void setMostrarnombre_clientePagosAutomaticos(Boolean mostrarnombre_clientePagosAutomaticos) {
		this.mostrarnombre_clientePagosAutomaticos= mostrarnombre_clientePagosAutomaticos;
	}

	public Boolean getActivarnombre_clientePagosAutomaticos() {
		return this.activarnombre_clientePagosAutomaticos;
	}

	public void setActivarnombre_clientePagosAutomaticos(Boolean activarnombre_clientePagosAutomaticos) {
		this.activarnombre_clientePagosAutomaticos= activarnombre_clientePagosAutomaticos;
	}

	public Border setResaltarnumero_facturaPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaPagosAutomaticos() {
		return this.resaltarnumero_facturaPagosAutomaticos;
	}

	public void setResaltarnumero_facturaPagosAutomaticos(Border borderResaltar) {
		this.resaltarnumero_facturaPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaPagosAutomaticos() {
		return this.mostrarnumero_facturaPagosAutomaticos;
	}

	public void setMostrarnumero_facturaPagosAutomaticos(Boolean mostrarnumero_facturaPagosAutomaticos) {
		this.mostrarnumero_facturaPagosAutomaticos= mostrarnumero_facturaPagosAutomaticos;
	}

	public Boolean getActivarnumero_facturaPagosAutomaticos() {
		return this.activarnumero_facturaPagosAutomaticos;
	}

	public void setActivarnumero_facturaPagosAutomaticos(Boolean activarnumero_facturaPagosAutomaticos) {
		this.activarnumero_facturaPagosAutomaticos= activarnumero_facturaPagosAutomaticos;
	}

	public Border setResaltarfecha_emisionPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPagosAutomaticos() {
		return this.resaltarfecha_emisionPagosAutomaticos;
	}

	public void setResaltarfecha_emisionPagosAutomaticos(Border borderResaltar) {
		this.resaltarfecha_emisionPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPagosAutomaticos() {
		return this.mostrarfecha_emisionPagosAutomaticos;
	}

	public void setMostrarfecha_emisionPagosAutomaticos(Boolean mostrarfecha_emisionPagosAutomaticos) {
		this.mostrarfecha_emisionPagosAutomaticos= mostrarfecha_emisionPagosAutomaticos;
	}

	public Boolean getActivarfecha_emisionPagosAutomaticos() {
		return this.activarfecha_emisionPagosAutomaticos;
	}

	public void setActivarfecha_emisionPagosAutomaticos(Boolean activarfecha_emisionPagosAutomaticos) {
		this.activarfecha_emisionPagosAutomaticos= activarfecha_emisionPagosAutomaticos;
	}

	public Border setResaltarfecha_vencimientoPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoPagosAutomaticos() {
		return this.resaltarfecha_vencimientoPagosAutomaticos;
	}

	public void setResaltarfecha_vencimientoPagosAutomaticos(Border borderResaltar) {
		this.resaltarfecha_vencimientoPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoPagosAutomaticos() {
		return this.mostrarfecha_vencimientoPagosAutomaticos;
	}

	public void setMostrarfecha_vencimientoPagosAutomaticos(Boolean mostrarfecha_vencimientoPagosAutomaticos) {
		this.mostrarfecha_vencimientoPagosAutomaticos= mostrarfecha_vencimientoPagosAutomaticos;
	}

	public Boolean getActivarfecha_vencimientoPagosAutomaticos() {
		return this.activarfecha_vencimientoPagosAutomaticos;
	}

	public void setActivarfecha_vencimientoPagosAutomaticos(Boolean activarfecha_vencimientoPagosAutomaticos) {
		this.activarfecha_vencimientoPagosAutomaticos= activarfecha_vencimientoPagosAutomaticos;
	}

	public Border setResaltarnombre_bancoPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarnombre_bancoPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bancoPagosAutomaticos() {
		return this.resaltarnombre_bancoPagosAutomaticos;
	}

	public void setResaltarnombre_bancoPagosAutomaticos(Border borderResaltar) {
		this.resaltarnombre_bancoPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarnombre_bancoPagosAutomaticos() {
		return this.mostrarnombre_bancoPagosAutomaticos;
	}

	public void setMostrarnombre_bancoPagosAutomaticos(Boolean mostrarnombre_bancoPagosAutomaticos) {
		this.mostrarnombre_bancoPagosAutomaticos= mostrarnombre_bancoPagosAutomaticos;
	}

	public Boolean getActivarnombre_bancoPagosAutomaticos() {
		return this.activarnombre_bancoPagosAutomaticos;
	}

	public void setActivarnombre_bancoPagosAutomaticos(Boolean activarnombre_bancoPagosAutomaticos) {
		this.activarnombre_bancoPagosAutomaticos= activarnombre_bancoPagosAutomaticos;
	}

	public Border setResaltarvalor_por_pagarPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarvalor_por_pagarPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_por_pagarPagosAutomaticos() {
		return this.resaltarvalor_por_pagarPagosAutomaticos;
	}

	public void setResaltarvalor_por_pagarPagosAutomaticos(Border borderResaltar) {
		this.resaltarvalor_por_pagarPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarvalor_por_pagarPagosAutomaticos() {
		return this.mostrarvalor_por_pagarPagosAutomaticos;
	}

	public void setMostrarvalor_por_pagarPagosAutomaticos(Boolean mostrarvalor_por_pagarPagosAutomaticos) {
		this.mostrarvalor_por_pagarPagosAutomaticos= mostrarvalor_por_pagarPagosAutomaticos;
	}

	public Boolean getActivarvalor_por_pagarPagosAutomaticos() {
		return this.activarvalor_por_pagarPagosAutomaticos;
	}

	public void setActivarvalor_por_pagarPagosAutomaticos(Boolean activarvalor_por_pagarPagosAutomaticos) {
		this.activarvalor_por_pagarPagosAutomaticos= activarvalor_por_pagarPagosAutomaticos;
	}

	public Border setResaltarvalor_canceladoPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarvalor_canceladoPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_canceladoPagosAutomaticos() {
		return this.resaltarvalor_canceladoPagosAutomaticos;
	}

	public void setResaltarvalor_canceladoPagosAutomaticos(Border borderResaltar) {
		this.resaltarvalor_canceladoPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarvalor_canceladoPagosAutomaticos() {
		return this.mostrarvalor_canceladoPagosAutomaticos;
	}

	public void setMostrarvalor_canceladoPagosAutomaticos(Boolean mostrarvalor_canceladoPagosAutomaticos) {
		this.mostrarvalor_canceladoPagosAutomaticos= mostrarvalor_canceladoPagosAutomaticos;
	}

	public Boolean getActivarvalor_canceladoPagosAutomaticos() {
		return this.activarvalor_canceladoPagosAutomaticos;
	}

	public void setActivarvalor_canceladoPagosAutomaticos(Boolean activarvalor_canceladoPagosAutomaticos) {
		this.activarvalor_canceladoPagosAutomaticos= activarvalor_canceladoPagosAutomaticos;
	}

	public Border setResaltarnumero_cuentaPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaPagosAutomaticos() {
		return this.resaltarnumero_cuentaPagosAutomaticos;
	}

	public void setResaltarnumero_cuentaPagosAutomaticos(Border borderResaltar) {
		this.resaltarnumero_cuentaPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaPagosAutomaticos() {
		return this.mostrarnumero_cuentaPagosAutomaticos;
	}

	public void setMostrarnumero_cuentaPagosAutomaticos(Boolean mostrarnumero_cuentaPagosAutomaticos) {
		this.mostrarnumero_cuentaPagosAutomaticos= mostrarnumero_cuentaPagosAutomaticos;
	}

	public Boolean getActivarnumero_cuentaPagosAutomaticos() {
		return this.activarnumero_cuentaPagosAutomaticos;
	}

	public void setActivarnumero_cuentaPagosAutomaticos(Boolean activarnumero_cuentaPagosAutomaticos) {
		this.activarnumero_cuentaPagosAutomaticos= activarnumero_cuentaPagosAutomaticos;
	}

	public Border setResaltaresta_autorizadoPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltaresta_autorizadoPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_autorizadoPagosAutomaticos() {
		return this.resaltaresta_autorizadoPagosAutomaticos;
	}

	public void setResaltaresta_autorizadoPagosAutomaticos(Border borderResaltar) {
		this.resaltaresta_autorizadoPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostraresta_autorizadoPagosAutomaticos() {
		return this.mostraresta_autorizadoPagosAutomaticos;
	}

	public void setMostraresta_autorizadoPagosAutomaticos(Boolean mostraresta_autorizadoPagosAutomaticos) {
		this.mostraresta_autorizadoPagosAutomaticos= mostraresta_autorizadoPagosAutomaticos;
	}

	public Boolean getActivaresta_autorizadoPagosAutomaticos() {
		return this.activaresta_autorizadoPagosAutomaticos;
	}

	public void setActivaresta_autorizadoPagosAutomaticos(Boolean activaresta_autorizadoPagosAutomaticos) {
		this.activaresta_autorizadoPagosAutomaticos= activaresta_autorizadoPagosAutomaticos;
	}

	public Border setResaltardescripcionPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltardescripcionPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPagosAutomaticos() {
		return this.resaltardescripcionPagosAutomaticos;
	}

	public void setResaltardescripcionPagosAutomaticos(Border borderResaltar) {
		this.resaltardescripcionPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrardescripcionPagosAutomaticos() {
		return this.mostrardescripcionPagosAutomaticos;
	}

	public void setMostrardescripcionPagosAutomaticos(Boolean mostrardescripcionPagosAutomaticos) {
		this.mostrardescripcionPagosAutomaticos= mostrardescripcionPagosAutomaticos;
	}

	public Boolean getActivardescripcionPagosAutomaticos() {
		return this.activardescripcionPagosAutomaticos;
	}

	public void setActivardescripcionPagosAutomaticos(Boolean activardescripcionPagosAutomaticos) {
		this.activardescripcionPagosAutomaticos= activardescripcionPagosAutomaticos;
	}

	public Border setResaltarfecha_corte_datoPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarfecha_corte_datoPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_corte_datoPagosAutomaticos() {
		return this.resaltarfecha_corte_datoPagosAutomaticos;
	}

	public void setResaltarfecha_corte_datoPagosAutomaticos(Border borderResaltar) {
		this.resaltarfecha_corte_datoPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarfecha_corte_datoPagosAutomaticos() {
		return this.mostrarfecha_corte_datoPagosAutomaticos;
	}

	public void setMostrarfecha_corte_datoPagosAutomaticos(Boolean mostrarfecha_corte_datoPagosAutomaticos) {
		this.mostrarfecha_corte_datoPagosAutomaticos= mostrarfecha_corte_datoPagosAutomaticos;
	}

	public Boolean getActivarfecha_corte_datoPagosAutomaticos() {
		return this.activarfecha_corte_datoPagosAutomaticos;
	}

	public void setActivarfecha_corte_datoPagosAutomaticos(Boolean activarfecha_corte_datoPagosAutomaticos) {
		this.activarfecha_corte_datoPagosAutomaticos= activarfecha_corte_datoPagosAutomaticos;
	}

	public Border setResaltarestadoPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarestadoPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarestadoPagosAutomaticos() {
		return this.resaltarestadoPagosAutomaticos;
	}

	public void setResaltarestadoPagosAutomaticos(Border borderResaltar) {
		this.resaltarestadoPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarestadoPagosAutomaticos() {
		return this.mostrarestadoPagosAutomaticos;
	}

	public void setMostrarestadoPagosAutomaticos(Boolean mostrarestadoPagosAutomaticos) {
		this.mostrarestadoPagosAutomaticos= mostrarestadoPagosAutomaticos;
	}

	public Boolean getActivarestadoPagosAutomaticos() {
		return this.activarestadoPagosAutomaticos;
	}

	public void setActivarestadoPagosAutomaticos(Boolean activarestadoPagosAutomaticos) {
		this.activarestadoPagosAutomaticos= activarestadoPagosAutomaticos;
	}

	public Border setResaltarcodigo_cuenta_con_clientePagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_con_clientePagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_con_clientePagosAutomaticos() {
		return this.resaltarcodigo_cuenta_con_clientePagosAutomaticos;
	}

	public void setResaltarcodigo_cuenta_con_clientePagosAutomaticos(Border borderResaltar) {
		this.resaltarcodigo_cuenta_con_clientePagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_con_clientePagosAutomaticos() {
		return this.mostrarcodigo_cuenta_con_clientePagosAutomaticos;
	}

	public void setMostrarcodigo_cuenta_con_clientePagosAutomaticos(Boolean mostrarcodigo_cuenta_con_clientePagosAutomaticos) {
		this.mostrarcodigo_cuenta_con_clientePagosAutomaticos= mostrarcodigo_cuenta_con_clientePagosAutomaticos;
	}

	public Boolean getActivarcodigo_cuenta_con_clientePagosAutomaticos() {
		return this.activarcodigo_cuenta_con_clientePagosAutomaticos;
	}

	public void setActivarcodigo_cuenta_con_clientePagosAutomaticos(Boolean activarcodigo_cuenta_con_clientePagosAutomaticos) {
		this.activarcodigo_cuenta_con_clientePagosAutomaticos= activarcodigo_cuenta_con_clientePagosAutomaticos;
	}

	public Border setResaltarcodigo_cuenta_con_bancoPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagosautomaticosBeanSwingJInternalFrame.jTtoolBarPagosAutomaticos.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_con_bancoPagosAutomaticos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_con_bancoPagosAutomaticos() {
		return this.resaltarcodigo_cuenta_con_bancoPagosAutomaticos;
	}

	public void setResaltarcodigo_cuenta_con_bancoPagosAutomaticos(Border borderResaltar) {
		this.resaltarcodigo_cuenta_con_bancoPagosAutomaticos= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_con_bancoPagosAutomaticos() {
		return this.mostrarcodigo_cuenta_con_bancoPagosAutomaticos;
	}

	public void setMostrarcodigo_cuenta_con_bancoPagosAutomaticos(Boolean mostrarcodigo_cuenta_con_bancoPagosAutomaticos) {
		this.mostrarcodigo_cuenta_con_bancoPagosAutomaticos= mostrarcodigo_cuenta_con_bancoPagosAutomaticos;
	}

	public Boolean getActivarcodigo_cuenta_con_bancoPagosAutomaticos() {
		return this.activarcodigo_cuenta_con_bancoPagosAutomaticos;
	}

	public void setActivarcodigo_cuenta_con_bancoPagosAutomaticos(Boolean activarcodigo_cuenta_con_bancoPagosAutomaticos) {
		this.activarcodigo_cuenta_con_bancoPagosAutomaticos= activarcodigo_cuenta_con_bancoPagosAutomaticos;
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
		
		
		this.setMostraridPagosAutomaticos(esInicial);
		this.setMostrarid_empresaPagosAutomaticos(esInicial);
		this.setMostrarfecha_cortePagosAutomaticos(esInicial);
		this.setMostrarnombre_clientePagosAutomaticos(esInicial);
		this.setMostrarnumero_facturaPagosAutomaticos(esInicial);
		this.setMostrarfecha_emisionPagosAutomaticos(esInicial);
		this.setMostrarfecha_vencimientoPagosAutomaticos(esInicial);
		this.setMostrarnombre_bancoPagosAutomaticos(esInicial);
		this.setMostrarvalor_por_pagarPagosAutomaticos(esInicial);
		this.setMostrarvalor_canceladoPagosAutomaticos(esInicial);
		this.setMostrarnumero_cuentaPagosAutomaticos(esInicial);
		this.setMostraresta_autorizadoPagosAutomaticos(esInicial);
		this.setMostrardescripcionPagosAutomaticos(esInicial);
		this.setMostrarfecha_corte_datoPagosAutomaticos(esInicial);
		this.setMostrarestadoPagosAutomaticos(esInicial);
		this.setMostrarcodigo_cuenta_con_clientePagosAutomaticos(esInicial);
		this.setMostrarcodigo_cuenta_con_bancoPagosAutomaticos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ID)) {
				this.setMostraridPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHACORTE0)) {
				this.setMostrarfecha_cortePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clientePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NOMBREBANCO)) {
				this.setMostrarnombre_bancoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.VALORPORPAGAR)) {
				this.setMostrarvalor_por_pagarPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.VALORCANCELADO)) {
				this.setMostrarvalor_canceladoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ESTAAUTORIZADO)) {
				this.setMostraresta_autorizadoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHACORTE)) {
				this.setMostrarfecha_corte_datoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ESTADO)) {
				this.setMostrarestadoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.CODIGOCUENTACONCLIENTE)) {
				this.setMostrarcodigo_cuenta_con_clientePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.CODIGOCUENTACONBANCO)) {
				this.setMostrarcodigo_cuenta_con_bancoPagosAutomaticos(esAsigna);
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
		
		
		this.setActivaridPagosAutomaticos(esInicial);
		this.setActivarid_empresaPagosAutomaticos(esInicial);
		this.setActivarfecha_cortePagosAutomaticos(esInicial);
		this.setActivarnombre_clientePagosAutomaticos(esInicial);
		this.setActivarnumero_facturaPagosAutomaticos(esInicial);
		this.setActivarfecha_emisionPagosAutomaticos(esInicial);
		this.setActivarfecha_vencimientoPagosAutomaticos(esInicial);
		this.setActivarnombre_bancoPagosAutomaticos(esInicial);
		this.setActivarvalor_por_pagarPagosAutomaticos(esInicial);
		this.setActivarvalor_canceladoPagosAutomaticos(esInicial);
		this.setActivarnumero_cuentaPagosAutomaticos(esInicial);
		this.setActivaresta_autorizadoPagosAutomaticos(esInicial);
		this.setActivardescripcionPagosAutomaticos(esInicial);
		this.setActivarfecha_corte_datoPagosAutomaticos(esInicial);
		this.setActivarestadoPagosAutomaticos(esInicial);
		this.setActivarcodigo_cuenta_con_clientePagosAutomaticos(esInicial);
		this.setActivarcodigo_cuenta_con_bancoPagosAutomaticos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ID)) {
				this.setActivaridPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHACORTE0)) {
				this.setActivarfecha_cortePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clientePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NOMBREBANCO)) {
				this.setActivarnombre_bancoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.VALORPORPAGAR)) {
				this.setActivarvalor_por_pagarPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.VALORCANCELADO)) {
				this.setActivarvalor_canceladoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ESTAAUTORIZADO)) {
				this.setActivaresta_autorizadoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHACORTE)) {
				this.setActivarfecha_corte_datoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ESTADO)) {
				this.setActivarestadoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.CODIGOCUENTACONCLIENTE)) {
				this.setActivarcodigo_cuenta_con_clientePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.CODIGOCUENTACONBANCO)) {
				this.setActivarcodigo_cuenta_con_bancoPagosAutomaticos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPagosAutomaticos(esInicial);
		this.setResaltarid_empresaPagosAutomaticos(esInicial);
		this.setResaltarfecha_cortePagosAutomaticos(esInicial);
		this.setResaltarnombre_clientePagosAutomaticos(esInicial);
		this.setResaltarnumero_facturaPagosAutomaticos(esInicial);
		this.setResaltarfecha_emisionPagosAutomaticos(esInicial);
		this.setResaltarfecha_vencimientoPagosAutomaticos(esInicial);
		this.setResaltarnombre_bancoPagosAutomaticos(esInicial);
		this.setResaltarvalor_por_pagarPagosAutomaticos(esInicial);
		this.setResaltarvalor_canceladoPagosAutomaticos(esInicial);
		this.setResaltarnumero_cuentaPagosAutomaticos(esInicial);
		this.setResaltaresta_autorizadoPagosAutomaticos(esInicial);
		this.setResaltardescripcionPagosAutomaticos(esInicial);
		this.setResaltarfecha_corte_datoPagosAutomaticos(esInicial);
		this.setResaltarestadoPagosAutomaticos(esInicial);
		this.setResaltarcodigo_cuenta_con_clientePagosAutomaticos(esInicial);
		this.setResaltarcodigo_cuenta_con_bancoPagosAutomaticos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ID)) {
				this.setResaltaridPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHACORTE0)) {
				this.setResaltarfecha_cortePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clientePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NOMBREBANCO)) {
				this.setResaltarnombre_bancoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.VALORPORPAGAR)) {
				this.setResaltarvalor_por_pagarPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.VALORCANCELADO)) {
				this.setResaltarvalor_canceladoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ESTAAUTORIZADO)) {
				this.setResaltaresta_autorizadoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.FECHACORTE)) {
				this.setResaltarfecha_corte_datoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.ESTADO)) {
				this.setResaltarestadoPagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.CODIGOCUENTACONCLIENTE)) {
				this.setResaltarcodigo_cuenta_con_clientePagosAutomaticos(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagosAutomaticosConstantesFunciones.CODIGOCUENTACONBANCO)) {
				this.setResaltarcodigo_cuenta_con_bancoPagosAutomaticos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPagosAutomaticosPagosAutomaticos=true;

	public Boolean getMostrarBusquedaPagosAutomaticosPagosAutomaticos() {
		return this.mostrarBusquedaPagosAutomaticosPagosAutomaticos;
	}

	public void setMostrarBusquedaPagosAutomaticosPagosAutomaticos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPagosAutomaticosPagosAutomaticos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPagosAutomaticosPagosAutomaticos=true;

	public Boolean getActivarBusquedaPagosAutomaticosPagosAutomaticos() {
		return this.activarBusquedaPagosAutomaticosPagosAutomaticos;
	}

	public void setActivarBusquedaPagosAutomaticosPagosAutomaticos(Boolean habilitarResaltar) {
		this.activarBusquedaPagosAutomaticosPagosAutomaticos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPagosAutomaticosPagosAutomaticos=null;

	public Border getResaltarBusquedaPagosAutomaticosPagosAutomaticos() {
		return this.resaltarBusquedaPagosAutomaticosPagosAutomaticos;
	}

	public void setResaltarBusquedaPagosAutomaticosPagosAutomaticos(Border borderResaltar) {
		this.resaltarBusquedaPagosAutomaticosPagosAutomaticos= borderResaltar;
	}

	public void setResaltarBusquedaPagosAutomaticosPagosAutomaticos(ParametroGeneralUsuario parametroGeneralUsuario/*PagosAutomaticosBeanSwingJInternalFrame pagosautomaticosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPagosAutomaticosPagosAutomaticos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}