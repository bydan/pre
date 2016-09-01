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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.AutoriPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.AutoriPagoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.AutoriPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AutoriPagoConstantesFunciones extends AutoriPagoConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="AutoriPago";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AutoriPago"+AutoriPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AutoriPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AutoriPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AutoriPagoConstantesFunciones.SCHEMA+"_"+AutoriPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AutoriPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AutoriPagoConstantesFunciones.SCHEMA+"_"+AutoriPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AutoriPagoConstantesFunciones.SCHEMA+"_"+AutoriPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AutoriPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AutoriPagoConstantesFunciones.SCHEMA+"_"+AutoriPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AutoriPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AutoriPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AutoriPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AutoriPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AutoriPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AutoriPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Autori Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Autori Pago";
	public static final String SCLASSWEBTITULO_LOWER="Autori Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AutoriPago";
	public static final String OBJECTNAME="autoripago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="autori_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select autoripago from "+AutoriPagoConstantesFunciones.SPERSISTENCENAME+" autoripago";
	public static String QUERYSELECTNATIVE="select "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".version_row,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_empresa,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_sucursal,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_cliente,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_factura,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_asiento_contable,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_centro_costo,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_centro_actividad,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_banco,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_cuenta_banco,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_detalle_prove,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".id_transaccion,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".fecha_emision,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".valor_pago,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".valor_cancelado,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".numero_factura,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".detalle_factura,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".fecha_corte,"+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME+".descripcion from "+AutoriPagoConstantesFunciones.SCHEMA+"."+AutoriPagoConstantesFunciones.TABLENAME;//+" as "+AutoriPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AutoriPagoConstantesFuncionesAdditional autoripagoConstantesFuncionesAdditional=null;
	
	public AutoriPagoConstantesFuncionesAdditional getAutoriPagoConstantesFuncionesAdditional() {
		return this.autoripagoConstantesFuncionesAdditional;
	}
	
	public void setAutoriPagoConstantesFuncionesAdditional(AutoriPagoConstantesFuncionesAdditional autoripagoConstantesFuncionesAdditional) {
		try {
			this.autoripagoConstantesFuncionesAdditional=autoripagoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFACTURA= "id_factura";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCENTROACTIVIDAD= "id_centro_actividad";
    public static final String IDBANCO= "id_banco";
    public static final String IDCUENTABANCO= "id_cuenta_banco";
    public static final String IDDETALLEPROVE= "id_detalle_prove";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String VALORPAGO= "valor_pago";
    public static final String VALORCANCELADO= "valor_cancelado";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String DETALLEFACTURA= "detalle_factura";
    public static final String FECHACORTE= "fecha_corte";
    public static final String DESCRIPCION= "descripcion";
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
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCENTROACTIVIDAD= "Centro Activad";
		public static final String LABEL_IDCENTROACTIVIDAD_LOWER= "Centro Actividad";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDCUENTABANCO= "Cuenta Banco";
		public static final String LABEL_IDCUENTABANCO_LOWER= "Cuenta Banco";
    	public static final String LABEL_IDDETALLEPROVE= "Detalle Prove";
		public static final String LABEL_IDDETALLEPROVE_LOWER= "Detalle Prove";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_VALORPAGO= "Valor Pago";
		public static final String LABEL_VALORPAGO_LOWER= "Valor Pago";
    	public static final String LABEL_VALORCANCELADO= "Valor Cancelado";
		public static final String LABEL_VALORCANCELADO_LOWER= "Valor Cancelado";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_DETALLEFACTURA= "Detalle Factura";
		public static final String LABEL_DETALLEFACTURA_LOWER= "Detalle Factura";
    	public static final String LABEL_FECHACORTE= "Fecha Corte";
		public static final String LABEL_FECHACORTE_LOWER= "Fecha Corte";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDETALLE_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getAutoriPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDCLIENTE)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDFACTURA)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDCENTROACTIVIDAD;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDBANCO)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDCUENTABANCO)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDCUENTABANCO;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDDETALLEPROVE)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDDETALLEPROVE;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.IDTRANSACCION)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.FECHAEMISION)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.VALORPAGO)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_VALORPAGO;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.VALORCANCELADO)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_VALORCANCELADO;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.DETALLEFACTURA)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_DETALLEFACTURA;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.FECHACORTE)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_FECHACORTE;}
		if(sNombreColumna.equals(AutoriPagoConstantesFunciones.DESCRIPCION)) {sLabelColumna=AutoriPagoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAutoriPagoDescripcion(AutoriPago autoripago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(autoripago !=null/* && autoripago.getId()!=0*/) {
			if(autoripago.getId()!=null) {
				sDescripcion=autoripago.getId().toString();
			}//autoripagoautoripago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAutoriPagoDescripcionDetallado(AutoriPago autoripago) {
		String sDescripcion="";
			
		sDescripcion+=AutoriPagoConstantesFunciones.ID+"=";
		sDescripcion+=autoripago.getId().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=autoripago.getVersionRow().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=autoripago.getid_empresa().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=autoripago.getid_sucursal().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=autoripago.getid_ejercicio().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=autoripago.getid_cliente().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=autoripago.getid_factura().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=autoripago.getid_asiento_contable().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=autoripago.getid_centro_costo().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD+"=";
		sDescripcion+=autoripago.getid_centro_actividad().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDBANCO+"=";
		sDescripcion+=autoripago.getid_banco().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDCUENTABANCO+"=";
		sDescripcion+=autoripago.getid_cuenta_banco().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDDETALLEPROVE+"=";
		sDescripcion+=autoripago.getid_detalle_prove().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=autoripago.getid_transaccion().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=autoripago.getfecha_emision().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=autoripago.getfecha_vencimiento().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.VALORPAGO+"=";
		sDescripcion+=autoripago.getvalor_pago().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.VALORCANCELADO+"=";
		sDescripcion+=autoripago.getvalor_cancelado().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=autoripago.getnumero_factura()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.DETALLEFACTURA+"=";
		sDescripcion+=autoripago.getdetalle_factura()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.FECHACORTE+"=";
		sDescripcion+=autoripago.getfecha_corte().toString()+",";
		sDescripcion+=AutoriPagoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=autoripago.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setAutoriPagoDescripcion(AutoriPago autoripago,String sValor) throws Exception {			
		if(autoripago !=null) {
			//autoripagoautoripago.getId().toString();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getCentroActividadDescripcion(CentroActividad centroactividad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centroactividad!=null/*&&centroactividad.getId()>0*/) {
			sDescripcion=CentroActividadConstantesFunciones.getCentroActividadDescripcion(centroactividad);
		}

		return sDescripcion;
	}

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getCuentaBancoDescripcion(CuentaBanco cuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentabanco!=null/*&&cuentabanco.getId()>0*/) {
			sDescripcion=CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(cuentabanco);
		}

		return sDescripcion;
	}

	public static String getDetalleProveDescripcion(DetalleProve detalleprove) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleprove!=null/*&&detalleprove.getId()>0*/) {
			sDescripcion=DetalleProveConstantesFunciones.getDetalleProveDescripcion(detalleprove);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdCentroActividad")) {
			sNombreIndice="Tipo=  Por Centro Activad";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdCuentaBanco")) {
			sNombreIndice="Tipo=  Por Cuenta Banco";
		} else if(sNombreIndice.equals("FK_IdDetalleProve")) {
			sNombreIndice="Tipo=  Por Detalle Prove";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroActividad(Long id_centro_actividad) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_actividad!=null) {sDetalleIndice+=" Codigo Unico De Centro Activad="+id_centro_actividad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaBanco(Long id_cuenta_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_banco!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Banco="+id_cuenta_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleProve(Long id_detalle_prove) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_prove!=null) {sDetalleIndice+=" Codigo Unico De Detalle Prove="+id_detalle_prove.toString();} 

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

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAutoriPago(AutoriPago autoripago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		autoripago.setnumero_factura(autoripago.getnumero_factura().trim());
		autoripago.setdetalle_factura(autoripago.getdetalle_factura().trim());
		autoripago.setdescripcion(autoripago.getdescripcion().trim());
	}
	
	public static void quitarEspaciosAutoriPagos(List<AutoriPago> autoripagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AutoriPago autoripago: autoripagos) {
			autoripago.setnumero_factura(autoripago.getnumero_factura().trim());
			autoripago.setdetalle_factura(autoripago.getdetalle_factura().trim());
			autoripago.setdescripcion(autoripago.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriPago(AutoriPago autoripago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && autoripago.getConCambioAuxiliar()) {
			autoripago.setIsDeleted(autoripago.getIsDeletedAuxiliar());	
			autoripago.setIsNew(autoripago.getIsNewAuxiliar());	
			autoripago.setIsChanged(autoripago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			autoripago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			autoripago.setIsDeletedAuxiliar(false);	
			autoripago.setIsNewAuxiliar(false);	
			autoripago.setIsChangedAuxiliar(false);
			
			autoripago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAutoriPagos(List<AutoriPago> autoripagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AutoriPago autoripago : autoripagos) {
			if(conAsignarBase && autoripago.getConCambioAuxiliar()) {
				autoripago.setIsDeleted(autoripago.getIsDeletedAuxiliar());	
				autoripago.setIsNew(autoripago.getIsNewAuxiliar());	
				autoripago.setIsChanged(autoripago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				autoripago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				autoripago.setIsDeletedAuxiliar(false);	
				autoripago.setIsNewAuxiliar(false);	
				autoripago.setIsChangedAuxiliar(false);
				
				autoripago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAutoriPago(AutoriPago autoripago,Boolean conEnteros) throws Exception  {
		autoripago.setvalor_pago(0.0);
		autoripago.setvalor_cancelado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAutoriPagos(List<AutoriPago> autoripagos,Boolean conEnteros) throws Exception  {
		
		for(AutoriPago autoripago: autoripagos) {
			autoripago.setvalor_pago(0.0);
			autoripago.setvalor_cancelado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAutoriPago(List<AutoriPago> autoripagos,AutoriPago autoripagoAux) throws Exception  {
		AutoriPagoConstantesFunciones.InicializarValoresAutoriPago(autoripagoAux,true);
		
		for(AutoriPago autoripago: autoripagos) {
			if(autoripago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			autoripagoAux.setvalor_pago(autoripagoAux.getvalor_pago()+autoripago.getvalor_pago());			
			autoripagoAux.setvalor_cancelado(autoripagoAux.getvalor_cancelado()+autoripago.getvalor_cancelado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AutoriPagoConstantesFunciones.getArrayColumnasGlobalesAutoriPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAutoriPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AutoriPagoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AutoriPagoConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAutoriPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AutoriPago> autoripagos,AutoriPago autoripago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AutoriPago autoripagoAux: autoripagos) {
			if(autoripagoAux!=null && autoripago!=null) {
				if((autoripagoAux.getId()==null && autoripago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(autoripagoAux.getId()!=null && autoripago.getId()!=null){
					if(autoripagoAux.getId().equals(autoripago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAutoriPago(List<AutoriPago> autoripagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_pagoTotal=0.0;
		Double valor_canceladoTotal=0.0;
	
		for(AutoriPago autoripago: autoripagos) {			
			if(autoripago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_pagoTotal+=autoripago.getvalor_pago();
			valor_canceladoTotal+=autoripago.getvalor_cancelado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AutoriPagoConstantesFunciones.VALORPAGO);
		datoGeneral.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_VALORPAGO);
		datoGeneral.setdValorDouble(valor_pagoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AutoriPagoConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_VALORCANCELADO);
		datoGeneral.setdValorDouble(valor_canceladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAutoriPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_ID, AutoriPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_VERSIONROW, AutoriPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDEMPRESA, AutoriPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDSUCURSAL, AutoriPagoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDEJERCICIO, AutoriPagoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDCLIENTE, AutoriPagoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDFACTURA, AutoriPagoConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDASIENTOCONTABLE, AutoriPagoConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDCENTROCOSTO, AutoriPagoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDCENTROACTIVIDAD, AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDBANCO, AutoriPagoConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDCUENTABANCO, AutoriPagoConstantesFunciones.IDCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDDETALLEPROVE, AutoriPagoConstantesFunciones.IDDETALLEPROVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_IDTRANSACCION, AutoriPagoConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_FECHAEMISION, AutoriPagoConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_FECHAVENCIMIENTO, AutoriPagoConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_VALORPAGO, AutoriPagoConstantesFunciones.VALORPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_VALORCANCELADO, AutoriPagoConstantesFunciones.VALORCANCELADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_NUMEROFACTURA, AutoriPagoConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_DETALLEFACTURA, AutoriPagoConstantesFunciones.DETALLEFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_FECHACORTE, AutoriPagoConstantesFunciones.FECHACORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AutoriPagoConstantesFunciones.LABEL_DESCRIPCION, AutoriPagoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAutoriPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDDETALLEPROVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.VALORPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.VALORCANCELADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.DETALLEFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.FECHACORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AutoriPagoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriPago() throws Exception  {
		return AutoriPagoConstantesFunciones.getTiposSeleccionarAutoriPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriPago(Boolean conFk) throws Exception  {
		return AutoriPagoConstantesFunciones.getTiposSeleccionarAutoriPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAutoriPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDCUENTABANCO);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDDETALLEPROVE);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDDETALLEPROVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_VALORPAGO);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_VALORPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_VALORCANCELADO);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_VALORCANCELADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_DETALLEFACTURA);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_DETALLEFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_FECHACORTE);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_FECHACORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AutoriPagoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(AutoriPagoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAutoriPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriPago(AutoriPago autoripagoAux) throws Exception {
		
			autoripagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autoripagoAux.getEmpresa()));
			autoripagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autoripagoAux.getSucursal()));
			autoripagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(autoripagoAux.getEjercicio()));
			autoripagoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(autoripagoAux.getCliente()));
			autoripagoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(autoripagoAux.getFactura()));
			autoripagoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(autoripagoAux.getAsientoContable()));
			autoripagoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(autoripagoAux.getCentroCosto()));
			autoripagoAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(autoripagoAux.getCentroActividad()));
			autoripagoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(autoripagoAux.getBanco()));
			autoripagoAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(autoripagoAux.getCuentaBanco()));
			autoripagoAux.setdetalleprove_descripcion(DetalleProveConstantesFunciones.getDetalleProveDescripcion(autoripagoAux.getDetalleProve()));
			autoripagoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(autoripagoAux.getTransaccion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAutoriPago(List<AutoriPago> autoripagosTemp) throws Exception {
		for(AutoriPago autoripagoAux:autoripagosTemp) {
			
			autoripagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(autoripagoAux.getEmpresa()));
			autoripagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(autoripagoAux.getSucursal()));
			autoripagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(autoripagoAux.getEjercicio()));
			autoripagoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(autoripagoAux.getCliente()));
			autoripagoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(autoripagoAux.getFactura()));
			autoripagoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(autoripagoAux.getAsientoContable()));
			autoripagoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(autoripagoAux.getCentroCosto()));
			autoripagoAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(autoripagoAux.getCentroActividad()));
			autoripagoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(autoripagoAux.getBanco()));
			autoripagoAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(autoripagoAux.getCuentaBanco()));
			autoripagoAux.setdetalleprove_descripcion(DetalleProveConstantesFunciones.getDetalleProveDescripcion(autoripagoAux.getDetalleProve()));
			autoripagoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(autoripagoAux.getTransaccion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CentroActividad.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(CuentaBanco.class));
				classes.add(new Classe(DetalleProve.class));
				classes.add(new Classe(Transaccion.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroActividad.class)) {
						classes.add(new Classe(CentroActividad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBanco.class)) {
						classes.add(new Classe(CuentaBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleProve.class)) {
						classes.add(new Classe(DetalleProve.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAutoriPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}

					if(DetalleProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProve.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}

					if(DetalleProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProve.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriPagoConstantesFunciones.getClassesRelationshipsOfAutoriPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AutoriPagoConstantesFunciones.getClassesRelationshipsFromStringsOfAutoriPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAutoriPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AutoriPago autoripago,List<AutoriPago> autoripagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AutoriPago autoripagoEncontrado=null;
			
			for(AutoriPago autoripagoLocal:autoripagos) {
				if(autoripagoLocal.getId().equals(autoripago.getId())) {
					autoripagoEncontrado=autoripagoLocal;
					
					autoripagoLocal.setIsChanged(autoripago.getIsChanged());
					autoripagoLocal.setIsNew(autoripago.getIsNew());
					autoripagoLocal.setIsDeleted(autoripago.getIsDeleted());
					
					autoripagoLocal.setGeneralEntityOriginal(autoripago.getGeneralEntityOriginal());
					
					autoripagoLocal.setId(autoripago.getId());	
					autoripagoLocal.setVersionRow(autoripago.getVersionRow());	
					autoripagoLocal.setid_empresa(autoripago.getid_empresa());	
					autoripagoLocal.setid_sucursal(autoripago.getid_sucursal());	
					autoripagoLocal.setid_ejercicio(autoripago.getid_ejercicio());	
					autoripagoLocal.setid_cliente(autoripago.getid_cliente());	
					autoripagoLocal.setid_factura(autoripago.getid_factura());	
					autoripagoLocal.setid_asiento_contable(autoripago.getid_asiento_contable());	
					autoripagoLocal.setid_centro_costo(autoripago.getid_centro_costo());	
					autoripagoLocal.setid_centro_actividad(autoripago.getid_centro_actividad());	
					autoripagoLocal.setid_banco(autoripago.getid_banco());	
					autoripagoLocal.setid_cuenta_banco(autoripago.getid_cuenta_banco());	
					autoripagoLocal.setid_detalle_prove(autoripago.getid_detalle_prove());	
					autoripagoLocal.setid_transaccion(autoripago.getid_transaccion());	
					autoripagoLocal.setfecha_emision(autoripago.getfecha_emision());	
					autoripagoLocal.setfecha_vencimiento(autoripago.getfecha_vencimiento());	
					autoripagoLocal.setvalor_pago(autoripago.getvalor_pago());	
					autoripagoLocal.setvalor_cancelado(autoripago.getvalor_cancelado());	
					autoripagoLocal.setnumero_factura(autoripago.getnumero_factura());	
					autoripagoLocal.setdetalle_factura(autoripago.getdetalle_factura());	
					autoripagoLocal.setfecha_corte(autoripago.getfecha_corte());	
					autoripagoLocal.setdescripcion(autoripago.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!autoripago.getIsDeleted()) {
				if(!existe) {
					autoripagos.add(autoripago);
				}
			} else {
				if(autoripagoEncontrado!=null && permiteQuitar)  {
					autoripagos.remove(autoripagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AutoriPago autoripago,List<AutoriPago> autoripagos) throws Exception {
		try	{			
			for(AutoriPago autoripagoLocal:autoripagos) {
				if(autoripagoLocal.getId().equals(autoripago.getId())) {
					autoripagoLocal.setIsSelected(autoripago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAutoriPago(List<AutoriPago> autoripagosAux) throws Exception {
		//this.autoripagosAux=autoripagosAux;
		
		for(AutoriPago autoripagoAux:autoripagosAux) {
			if(autoripagoAux.getIsChanged()) {
				autoripagoAux.setIsChanged(false);
			}		
			
			if(autoripagoAux.getIsNew()) {
				autoripagoAux.setIsNew(false);
			}	
			
			if(autoripagoAux.getIsDeleted()) {
				autoripagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAutoriPago(AutoriPago autoripagoAux) throws Exception {
		//this.autoripagoAux=autoripagoAux;
		
			if(autoripagoAux.getIsChanged()) {
				autoripagoAux.setIsChanged(false);
			}		
			
			if(autoripagoAux.getIsNew()) {
				autoripagoAux.setIsNew(false);
			}	
			
			if(autoripagoAux.getIsDeleted()) {
				autoripagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AutoriPago autoripagoAsignar,AutoriPago autoripago) throws Exception {
		autoripagoAsignar.setId(autoripago.getId());	
		autoripagoAsignar.setVersionRow(autoripago.getVersionRow());	
		autoripagoAsignar.setid_empresa(autoripago.getid_empresa());
		autoripagoAsignar.setempresa_descripcion(autoripago.getempresa_descripcion());	
		autoripagoAsignar.setid_sucursal(autoripago.getid_sucursal());
		autoripagoAsignar.setsucursal_descripcion(autoripago.getsucursal_descripcion());	
		autoripagoAsignar.setid_ejercicio(autoripago.getid_ejercicio());
		autoripagoAsignar.setejercicio_descripcion(autoripago.getejercicio_descripcion());	
		autoripagoAsignar.setid_cliente(autoripago.getid_cliente());
		autoripagoAsignar.setcliente_descripcion(autoripago.getcliente_descripcion());	
		autoripagoAsignar.setid_factura(autoripago.getid_factura());
		autoripagoAsignar.setfactura_descripcion(autoripago.getfactura_descripcion());	
		autoripagoAsignar.setid_asiento_contable(autoripago.getid_asiento_contable());
		autoripagoAsignar.setasientocontable_descripcion(autoripago.getasientocontable_descripcion());	
		autoripagoAsignar.setid_centro_costo(autoripago.getid_centro_costo());
		autoripagoAsignar.setcentrocosto_descripcion(autoripago.getcentrocosto_descripcion());	
		autoripagoAsignar.setid_centro_actividad(autoripago.getid_centro_actividad());
		autoripagoAsignar.setcentroactividad_descripcion(autoripago.getcentroactividad_descripcion());	
		autoripagoAsignar.setid_banco(autoripago.getid_banco());
		autoripagoAsignar.setbanco_descripcion(autoripago.getbanco_descripcion());	
		autoripagoAsignar.setid_cuenta_banco(autoripago.getid_cuenta_banco());
		autoripagoAsignar.setcuentabanco_descripcion(autoripago.getcuentabanco_descripcion());	
		autoripagoAsignar.setid_detalle_prove(autoripago.getid_detalle_prove());
		autoripagoAsignar.setdetalleprove_descripcion(autoripago.getdetalleprove_descripcion());	
		autoripagoAsignar.setid_transaccion(autoripago.getid_transaccion());
		autoripagoAsignar.settransaccion_descripcion(autoripago.gettransaccion_descripcion());	
		autoripagoAsignar.setfecha_emision(autoripago.getfecha_emision());	
		autoripagoAsignar.setfecha_vencimiento(autoripago.getfecha_vencimiento());	
		autoripagoAsignar.setvalor_pago(autoripago.getvalor_pago());	
		autoripagoAsignar.setvalor_cancelado(autoripago.getvalor_cancelado());	
		autoripagoAsignar.setnumero_factura(autoripago.getnumero_factura());	
		autoripagoAsignar.setdetalle_factura(autoripago.getdetalle_factura());	
		autoripagoAsignar.setfecha_corte(autoripago.getfecha_corte());	
		autoripagoAsignar.setdescripcion(autoripago.getdescripcion());	
	}
	
	public static void inicializarAutoriPago(AutoriPago autoripago) throws Exception {
		try {
				autoripago.setId(0L);	
					
				autoripago.setid_empresa(-1L);	
				autoripago.setid_sucursal(-1L);	
				autoripago.setid_ejercicio(-1L);	
				autoripago.setid_cliente(-1L);	
				autoripago.setid_factura(-1L);	
				autoripago.setid_asiento_contable(-1L);	
				autoripago.setid_centro_costo(null);	
				autoripago.setid_centro_actividad(null);	
				autoripago.setid_banco(-1L);	
				autoripago.setid_cuenta_banco(-1L);	
				autoripago.setid_detalle_prove(-1L);	
				autoripago.setid_transaccion(-1L);	
				autoripago.setfecha_emision(new Date());	
				autoripago.setfecha_vencimiento(new Date());	
				autoripago.setvalor_pago(0.0);	
				autoripago.setvalor_cancelado(0.0);	
				autoripago.setnumero_factura("");	
				autoripago.setdetalle_factura("");	
				autoripago.setfecha_corte(new Date());	
				autoripago.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAutoriPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDDETALLEPROVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_VALORPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_VALORCANCELADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_DETALLEFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_FECHACORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AutoriPagoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAutoriPago(String sTipo,Row row,Workbook workbook,AutoriPago autoripago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getcentroactividad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getcuentabanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getdetalleprove_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getvalor_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getvalor_cancelado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getdetalle_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getfecha_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(autoripago.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAutoriPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAutoriPago() {
		return this.sFinalQueryAutoriPago;
	}
	
	public void setsFinalQueryAutoriPago(String sFinalQueryAutoriPago) {
		this.sFinalQueryAutoriPago= sFinalQueryAutoriPago;
	}
	
	public Border resaltarSeleccionarAutoriPago=null;
	
	public Border setResaltarSeleccionarAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAutoriPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAutoriPago() {
		return this.resaltarSeleccionarAutoriPago;
	}
	
	public void setResaltarSeleccionarAutoriPago(Border borderResaltarSeleccionarAutoriPago) {
		this.resaltarSeleccionarAutoriPago= borderResaltarSeleccionarAutoriPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAutoriPago=null;
	public Boolean mostraridAutoriPago=true;
	public Boolean activaridAutoriPago=true;

	public Border resaltarid_empresaAutoriPago=null;
	public Boolean mostrarid_empresaAutoriPago=true;
	public Boolean activarid_empresaAutoriPago=true;
	public Boolean cargarid_empresaAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_sucursalAutoriPago=null;
	public Boolean mostrarid_sucursalAutoriPago=true;
	public Boolean activarid_sucursalAutoriPago=true;
	public Boolean cargarid_sucursalAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_ejercicioAutoriPago=null;
	public Boolean mostrarid_ejercicioAutoriPago=true;
	public Boolean activarid_ejercicioAutoriPago=true;
	public Boolean cargarid_ejercicioAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_clienteAutoriPago=null;
	public Boolean mostrarid_clienteAutoriPago=true;
	public Boolean activarid_clienteAutoriPago=true;
	public Boolean cargarid_clienteAutoriPago=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_facturaAutoriPago=null;
	public Boolean mostrarid_facturaAutoriPago=true;
	public Boolean activarid_facturaAutoriPago=true;
	public Boolean cargarid_facturaAutoriPago=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableAutoriPago=null;
	public Boolean mostrarid_asiento_contableAutoriPago=true;
	public Boolean activarid_asiento_contableAutoriPago=true;
	public Boolean cargarid_asiento_contableAutoriPago=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_centro_costoAutoriPago=null;
	public Boolean mostrarid_centro_costoAutoriPago=true;
	public Boolean activarid_centro_costoAutoriPago=true;
	public Boolean cargarid_centro_costoAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_centro_actividadAutoriPago=null;
	public Boolean mostrarid_centro_actividadAutoriPago=true;
	public Boolean activarid_centro_actividadAutoriPago=true;
	public Boolean cargarid_centro_actividadAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_actividadAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_bancoAutoriPago=null;
	public Boolean mostrarid_bancoAutoriPago=true;
	public Boolean activarid_bancoAutoriPago=true;
	public Boolean cargarid_bancoAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_cuenta_bancoAutoriPago=null;
	public Boolean mostrarid_cuenta_bancoAutoriPago=true;
	public Boolean activarid_cuenta_bancoAutoriPago=true;
	public Boolean cargarid_cuenta_bancoAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_bancoAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_detalle_proveAutoriPago=null;
	public Boolean mostrarid_detalle_proveAutoriPago=true;
	public Boolean activarid_detalle_proveAutoriPago=true;
	public Boolean cargarid_detalle_proveAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_proveAutoriPago=false;//ConEventDepend=true

	public Border resaltarid_transaccionAutoriPago=null;
	public Boolean mostrarid_transaccionAutoriPago=true;
	public Boolean activarid_transaccionAutoriPago=true;
	public Boolean cargarid_transaccionAutoriPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionAutoriPago=false;//ConEventDepend=true

	public Border resaltarfecha_emisionAutoriPago=null;
	public Boolean mostrarfecha_emisionAutoriPago=true;
	public Boolean activarfecha_emisionAutoriPago=false;

	public Border resaltarfecha_vencimientoAutoriPago=null;
	public Boolean mostrarfecha_vencimientoAutoriPago=true;
	public Boolean activarfecha_vencimientoAutoriPago=false;

	public Border resaltarvalor_pagoAutoriPago=null;
	public Boolean mostrarvalor_pagoAutoriPago=true;
	public Boolean activarvalor_pagoAutoriPago=true;

	public Border resaltarvalor_canceladoAutoriPago=null;
	public Boolean mostrarvalor_canceladoAutoriPago=true;
	public Boolean activarvalor_canceladoAutoriPago=true;

	public Border resaltarnumero_facturaAutoriPago=null;
	public Boolean mostrarnumero_facturaAutoriPago=true;
	public Boolean activarnumero_facturaAutoriPago=true;

	public Border resaltardetalle_facturaAutoriPago=null;
	public Boolean mostrardetalle_facturaAutoriPago=true;
	public Boolean activardetalle_facturaAutoriPago=true;

	public Border resaltarfecha_corteAutoriPago=null;
	public Boolean mostrarfecha_corteAutoriPago=true;
	public Boolean activarfecha_corteAutoriPago=false;

	public Border resaltardescripcionAutoriPago=null;
	public Boolean mostrardescripcionAutoriPago=true;
	public Boolean activardescripcionAutoriPago=true;

	
	

	public Border setResaltaridAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltaridAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAutoriPago() {
		return this.resaltaridAutoriPago;
	}

	public void setResaltaridAutoriPago(Border borderResaltar) {
		this.resaltaridAutoriPago= borderResaltar;
	}

	public Boolean getMostraridAutoriPago() {
		return this.mostraridAutoriPago;
	}

	public void setMostraridAutoriPago(Boolean mostraridAutoriPago) {
		this.mostraridAutoriPago= mostraridAutoriPago;
	}

	public Boolean getActivaridAutoriPago() {
		return this.activaridAutoriPago;
	}

	public void setActivaridAutoriPago(Boolean activaridAutoriPago) {
		this.activaridAutoriPago= activaridAutoriPago;
	}

	public Border setResaltarid_empresaAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAutoriPago() {
		return this.resaltarid_empresaAutoriPago;
	}

	public void setResaltarid_empresaAutoriPago(Border borderResaltar) {
		this.resaltarid_empresaAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaAutoriPago() {
		return this.mostrarid_empresaAutoriPago;
	}

	public void setMostrarid_empresaAutoriPago(Boolean mostrarid_empresaAutoriPago) {
		this.mostrarid_empresaAutoriPago= mostrarid_empresaAutoriPago;
	}

	public Boolean getActivarid_empresaAutoriPago() {
		return this.activarid_empresaAutoriPago;
	}

	public void setActivarid_empresaAutoriPago(Boolean activarid_empresaAutoriPago) {
		this.activarid_empresaAutoriPago= activarid_empresaAutoriPago;
	}

	public Boolean getCargarid_empresaAutoriPago() {
		return this.cargarid_empresaAutoriPago;
	}

	public void setCargarid_empresaAutoriPago(Boolean cargarid_empresaAutoriPago) {
		this.cargarid_empresaAutoriPago= cargarid_empresaAutoriPago;
	}

	public Border setResaltarid_sucursalAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAutoriPago() {
		return this.resaltarid_sucursalAutoriPago;
	}

	public void setResaltarid_sucursalAutoriPago(Border borderResaltar) {
		this.resaltarid_sucursalAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAutoriPago() {
		return this.mostrarid_sucursalAutoriPago;
	}

	public void setMostrarid_sucursalAutoriPago(Boolean mostrarid_sucursalAutoriPago) {
		this.mostrarid_sucursalAutoriPago= mostrarid_sucursalAutoriPago;
	}

	public Boolean getActivarid_sucursalAutoriPago() {
		return this.activarid_sucursalAutoriPago;
	}

	public void setActivarid_sucursalAutoriPago(Boolean activarid_sucursalAutoriPago) {
		this.activarid_sucursalAutoriPago= activarid_sucursalAutoriPago;
	}

	public Boolean getCargarid_sucursalAutoriPago() {
		return this.cargarid_sucursalAutoriPago;
	}

	public void setCargarid_sucursalAutoriPago(Boolean cargarid_sucursalAutoriPago) {
		this.cargarid_sucursalAutoriPago= cargarid_sucursalAutoriPago;
	}

	public Border setResaltarid_ejercicioAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioAutoriPago() {
		return this.resaltarid_ejercicioAutoriPago;
	}

	public void setResaltarid_ejercicioAutoriPago(Border borderResaltar) {
		this.resaltarid_ejercicioAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioAutoriPago() {
		return this.mostrarid_ejercicioAutoriPago;
	}

	public void setMostrarid_ejercicioAutoriPago(Boolean mostrarid_ejercicioAutoriPago) {
		this.mostrarid_ejercicioAutoriPago= mostrarid_ejercicioAutoriPago;
	}

	public Boolean getActivarid_ejercicioAutoriPago() {
		return this.activarid_ejercicioAutoriPago;
	}

	public void setActivarid_ejercicioAutoriPago(Boolean activarid_ejercicioAutoriPago) {
		this.activarid_ejercicioAutoriPago= activarid_ejercicioAutoriPago;
	}

	public Boolean getCargarid_ejercicioAutoriPago() {
		return this.cargarid_ejercicioAutoriPago;
	}

	public void setCargarid_ejercicioAutoriPago(Boolean cargarid_ejercicioAutoriPago) {
		this.cargarid_ejercicioAutoriPago= cargarid_ejercicioAutoriPago;
	}

	public Border setResaltarid_clienteAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_clienteAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteAutoriPago() {
		return this.resaltarid_clienteAutoriPago;
	}

	public void setResaltarid_clienteAutoriPago(Border borderResaltar) {
		this.resaltarid_clienteAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_clienteAutoriPago() {
		return this.mostrarid_clienteAutoriPago;
	}

	public void setMostrarid_clienteAutoriPago(Boolean mostrarid_clienteAutoriPago) {
		this.mostrarid_clienteAutoriPago= mostrarid_clienteAutoriPago;
	}

	public Boolean getActivarid_clienteAutoriPago() {
		return this.activarid_clienteAutoriPago;
	}

	public void setActivarid_clienteAutoriPago(Boolean activarid_clienteAutoriPago) {
		this.activarid_clienteAutoriPago= activarid_clienteAutoriPago;
	}

	public Boolean getCargarid_clienteAutoriPago() {
		return this.cargarid_clienteAutoriPago;
	}

	public void setCargarid_clienteAutoriPago(Boolean cargarid_clienteAutoriPago) {
		this.cargarid_clienteAutoriPago= cargarid_clienteAutoriPago;
	}

	public Border setResaltarid_facturaAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_facturaAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaAutoriPago() {
		return this.resaltarid_facturaAutoriPago;
	}

	public void setResaltarid_facturaAutoriPago(Border borderResaltar) {
		this.resaltarid_facturaAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_facturaAutoriPago() {
		return this.mostrarid_facturaAutoriPago;
	}

	public void setMostrarid_facturaAutoriPago(Boolean mostrarid_facturaAutoriPago) {
		this.mostrarid_facturaAutoriPago= mostrarid_facturaAutoriPago;
	}

	public Boolean getActivarid_facturaAutoriPago() {
		return this.activarid_facturaAutoriPago;
	}

	public void setActivarid_facturaAutoriPago(Boolean activarid_facturaAutoriPago) {
		this.activarid_facturaAutoriPago= activarid_facturaAutoriPago;
	}

	public Boolean getCargarid_facturaAutoriPago() {
		return this.cargarid_facturaAutoriPago;
	}

	public void setCargarid_facturaAutoriPago(Boolean cargarid_facturaAutoriPago) {
		this.cargarid_facturaAutoriPago= cargarid_facturaAutoriPago;
	}

	public Border setResaltarid_asiento_contableAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableAutoriPago() {
		return this.resaltarid_asiento_contableAutoriPago;
	}

	public void setResaltarid_asiento_contableAutoriPago(Border borderResaltar) {
		this.resaltarid_asiento_contableAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableAutoriPago() {
		return this.mostrarid_asiento_contableAutoriPago;
	}

	public void setMostrarid_asiento_contableAutoriPago(Boolean mostrarid_asiento_contableAutoriPago) {
		this.mostrarid_asiento_contableAutoriPago= mostrarid_asiento_contableAutoriPago;
	}

	public Boolean getActivarid_asiento_contableAutoriPago() {
		return this.activarid_asiento_contableAutoriPago;
	}

	public void setActivarid_asiento_contableAutoriPago(Boolean activarid_asiento_contableAutoriPago) {
		this.activarid_asiento_contableAutoriPago= activarid_asiento_contableAutoriPago;
	}

	public Boolean getCargarid_asiento_contableAutoriPago() {
		return this.cargarid_asiento_contableAutoriPago;
	}

	public void setCargarid_asiento_contableAutoriPago(Boolean cargarid_asiento_contableAutoriPago) {
		this.cargarid_asiento_contableAutoriPago= cargarid_asiento_contableAutoriPago;
	}

	public Border setResaltarid_centro_costoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoAutoriPago() {
		return this.resaltarid_centro_costoAutoriPago;
	}

	public void setResaltarid_centro_costoAutoriPago(Border borderResaltar) {
		this.resaltarid_centro_costoAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoAutoriPago() {
		return this.mostrarid_centro_costoAutoriPago;
	}

	public void setMostrarid_centro_costoAutoriPago(Boolean mostrarid_centro_costoAutoriPago) {
		this.mostrarid_centro_costoAutoriPago= mostrarid_centro_costoAutoriPago;
	}

	public Boolean getActivarid_centro_costoAutoriPago() {
		return this.activarid_centro_costoAutoriPago;
	}

	public void setActivarid_centro_costoAutoriPago(Boolean activarid_centro_costoAutoriPago) {
		this.activarid_centro_costoAutoriPago= activarid_centro_costoAutoriPago;
	}

	public Boolean getCargarid_centro_costoAutoriPago() {
		return this.cargarid_centro_costoAutoriPago;
	}

	public void setCargarid_centro_costoAutoriPago(Boolean cargarid_centro_costoAutoriPago) {
		this.cargarid_centro_costoAutoriPago= cargarid_centro_costoAutoriPago;
	}

	public Border setResaltarid_centro_actividadAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_centro_actividadAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_actividadAutoriPago() {
		return this.resaltarid_centro_actividadAutoriPago;
	}

	public void setResaltarid_centro_actividadAutoriPago(Border borderResaltar) {
		this.resaltarid_centro_actividadAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_centro_actividadAutoriPago() {
		return this.mostrarid_centro_actividadAutoriPago;
	}

	public void setMostrarid_centro_actividadAutoriPago(Boolean mostrarid_centro_actividadAutoriPago) {
		this.mostrarid_centro_actividadAutoriPago= mostrarid_centro_actividadAutoriPago;
	}

	public Boolean getActivarid_centro_actividadAutoriPago() {
		return this.activarid_centro_actividadAutoriPago;
	}

	public void setActivarid_centro_actividadAutoriPago(Boolean activarid_centro_actividadAutoriPago) {
		this.activarid_centro_actividadAutoriPago= activarid_centro_actividadAutoriPago;
	}

	public Boolean getCargarid_centro_actividadAutoriPago() {
		return this.cargarid_centro_actividadAutoriPago;
	}

	public void setCargarid_centro_actividadAutoriPago(Boolean cargarid_centro_actividadAutoriPago) {
		this.cargarid_centro_actividadAutoriPago= cargarid_centro_actividadAutoriPago;
	}

	public Border setResaltarid_bancoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_bancoAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoAutoriPago() {
		return this.resaltarid_bancoAutoriPago;
	}

	public void setResaltarid_bancoAutoriPago(Border borderResaltar) {
		this.resaltarid_bancoAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_bancoAutoriPago() {
		return this.mostrarid_bancoAutoriPago;
	}

	public void setMostrarid_bancoAutoriPago(Boolean mostrarid_bancoAutoriPago) {
		this.mostrarid_bancoAutoriPago= mostrarid_bancoAutoriPago;
	}

	public Boolean getActivarid_bancoAutoriPago() {
		return this.activarid_bancoAutoriPago;
	}

	public void setActivarid_bancoAutoriPago(Boolean activarid_bancoAutoriPago) {
		this.activarid_bancoAutoriPago= activarid_bancoAutoriPago;
	}

	public Boolean getCargarid_bancoAutoriPago() {
		return this.cargarid_bancoAutoriPago;
	}

	public void setCargarid_bancoAutoriPago(Boolean cargarid_bancoAutoriPago) {
		this.cargarid_bancoAutoriPago= cargarid_bancoAutoriPago;
	}

	public Border setResaltarid_cuenta_bancoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_bancoAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_bancoAutoriPago() {
		return this.resaltarid_cuenta_bancoAutoriPago;
	}

	public void setResaltarid_cuenta_bancoAutoriPago(Border borderResaltar) {
		this.resaltarid_cuenta_bancoAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_bancoAutoriPago() {
		return this.mostrarid_cuenta_bancoAutoriPago;
	}

	public void setMostrarid_cuenta_bancoAutoriPago(Boolean mostrarid_cuenta_bancoAutoriPago) {
		this.mostrarid_cuenta_bancoAutoriPago= mostrarid_cuenta_bancoAutoriPago;
	}

	public Boolean getActivarid_cuenta_bancoAutoriPago() {
		return this.activarid_cuenta_bancoAutoriPago;
	}

	public void setActivarid_cuenta_bancoAutoriPago(Boolean activarid_cuenta_bancoAutoriPago) {
		this.activarid_cuenta_bancoAutoriPago= activarid_cuenta_bancoAutoriPago;
	}

	public Boolean getCargarid_cuenta_bancoAutoriPago() {
		return this.cargarid_cuenta_bancoAutoriPago;
	}

	public void setCargarid_cuenta_bancoAutoriPago(Boolean cargarid_cuenta_bancoAutoriPago) {
		this.cargarid_cuenta_bancoAutoriPago= cargarid_cuenta_bancoAutoriPago;
	}

	public Border setResaltarid_detalle_proveAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_detalle_proveAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_proveAutoriPago() {
		return this.resaltarid_detalle_proveAutoriPago;
	}

	public void setResaltarid_detalle_proveAutoriPago(Border borderResaltar) {
		this.resaltarid_detalle_proveAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_detalle_proveAutoriPago() {
		return this.mostrarid_detalle_proveAutoriPago;
	}

	public void setMostrarid_detalle_proveAutoriPago(Boolean mostrarid_detalle_proveAutoriPago) {
		this.mostrarid_detalle_proveAutoriPago= mostrarid_detalle_proveAutoriPago;
	}

	public Boolean getActivarid_detalle_proveAutoriPago() {
		return this.activarid_detalle_proveAutoriPago;
	}

	public void setActivarid_detalle_proveAutoriPago(Boolean activarid_detalle_proveAutoriPago) {
		this.activarid_detalle_proveAutoriPago= activarid_detalle_proveAutoriPago;
	}

	public Boolean getCargarid_detalle_proveAutoriPago() {
		return this.cargarid_detalle_proveAutoriPago;
	}

	public void setCargarid_detalle_proveAutoriPago(Boolean cargarid_detalle_proveAutoriPago) {
		this.cargarid_detalle_proveAutoriPago= cargarid_detalle_proveAutoriPago;
	}

	public Border setResaltarid_transaccionAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarid_transaccionAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionAutoriPago() {
		return this.resaltarid_transaccionAutoriPago;
	}

	public void setResaltarid_transaccionAutoriPago(Border borderResaltar) {
		this.resaltarid_transaccionAutoriPago= borderResaltar;
	}

	public Boolean getMostrarid_transaccionAutoriPago() {
		return this.mostrarid_transaccionAutoriPago;
	}

	public void setMostrarid_transaccionAutoriPago(Boolean mostrarid_transaccionAutoriPago) {
		this.mostrarid_transaccionAutoriPago= mostrarid_transaccionAutoriPago;
	}

	public Boolean getActivarid_transaccionAutoriPago() {
		return this.activarid_transaccionAutoriPago;
	}

	public void setActivarid_transaccionAutoriPago(Boolean activarid_transaccionAutoriPago) {
		this.activarid_transaccionAutoriPago= activarid_transaccionAutoriPago;
	}

	public Boolean getCargarid_transaccionAutoriPago() {
		return this.cargarid_transaccionAutoriPago;
	}

	public void setCargarid_transaccionAutoriPago(Boolean cargarid_transaccionAutoriPago) {
		this.cargarid_transaccionAutoriPago= cargarid_transaccionAutoriPago;
	}

	public Border setResaltarfecha_emisionAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionAutoriPago() {
		return this.resaltarfecha_emisionAutoriPago;
	}

	public void setResaltarfecha_emisionAutoriPago(Border borderResaltar) {
		this.resaltarfecha_emisionAutoriPago= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionAutoriPago() {
		return this.mostrarfecha_emisionAutoriPago;
	}

	public void setMostrarfecha_emisionAutoriPago(Boolean mostrarfecha_emisionAutoriPago) {
		this.mostrarfecha_emisionAutoriPago= mostrarfecha_emisionAutoriPago;
	}

	public Boolean getActivarfecha_emisionAutoriPago() {
		return this.activarfecha_emisionAutoriPago;
	}

	public void setActivarfecha_emisionAutoriPago(Boolean activarfecha_emisionAutoriPago) {
		this.activarfecha_emisionAutoriPago= activarfecha_emisionAutoriPago;
	}

	public Border setResaltarfecha_vencimientoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoAutoriPago() {
		return this.resaltarfecha_vencimientoAutoriPago;
	}

	public void setResaltarfecha_vencimientoAutoriPago(Border borderResaltar) {
		this.resaltarfecha_vencimientoAutoriPago= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoAutoriPago() {
		return this.mostrarfecha_vencimientoAutoriPago;
	}

	public void setMostrarfecha_vencimientoAutoriPago(Boolean mostrarfecha_vencimientoAutoriPago) {
		this.mostrarfecha_vencimientoAutoriPago= mostrarfecha_vencimientoAutoriPago;
	}

	public Boolean getActivarfecha_vencimientoAutoriPago() {
		return this.activarfecha_vencimientoAutoriPago;
	}

	public void setActivarfecha_vencimientoAutoriPago(Boolean activarfecha_vencimientoAutoriPago) {
		this.activarfecha_vencimientoAutoriPago= activarfecha_vencimientoAutoriPago;
	}

	public Border setResaltarvalor_pagoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarvalor_pagoAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_pagoAutoriPago() {
		return this.resaltarvalor_pagoAutoriPago;
	}

	public void setResaltarvalor_pagoAutoriPago(Border borderResaltar) {
		this.resaltarvalor_pagoAutoriPago= borderResaltar;
	}

	public Boolean getMostrarvalor_pagoAutoriPago() {
		return this.mostrarvalor_pagoAutoriPago;
	}

	public void setMostrarvalor_pagoAutoriPago(Boolean mostrarvalor_pagoAutoriPago) {
		this.mostrarvalor_pagoAutoriPago= mostrarvalor_pagoAutoriPago;
	}

	public Boolean getActivarvalor_pagoAutoriPago() {
		return this.activarvalor_pagoAutoriPago;
	}

	public void setActivarvalor_pagoAutoriPago(Boolean activarvalor_pagoAutoriPago) {
		this.activarvalor_pagoAutoriPago= activarvalor_pagoAutoriPago;
	}

	public Border setResaltarvalor_canceladoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarvalor_canceladoAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_canceladoAutoriPago() {
		return this.resaltarvalor_canceladoAutoriPago;
	}

	public void setResaltarvalor_canceladoAutoriPago(Border borderResaltar) {
		this.resaltarvalor_canceladoAutoriPago= borderResaltar;
	}

	public Boolean getMostrarvalor_canceladoAutoriPago() {
		return this.mostrarvalor_canceladoAutoriPago;
	}

	public void setMostrarvalor_canceladoAutoriPago(Boolean mostrarvalor_canceladoAutoriPago) {
		this.mostrarvalor_canceladoAutoriPago= mostrarvalor_canceladoAutoriPago;
	}

	public Boolean getActivarvalor_canceladoAutoriPago() {
		return this.activarvalor_canceladoAutoriPago;
	}

	public void setActivarvalor_canceladoAutoriPago(Boolean activarvalor_canceladoAutoriPago) {
		this.activarvalor_canceladoAutoriPago= activarvalor_canceladoAutoriPago;
	}

	public Border setResaltarnumero_facturaAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaAutoriPago() {
		return this.resaltarnumero_facturaAutoriPago;
	}

	public void setResaltarnumero_facturaAutoriPago(Border borderResaltar) {
		this.resaltarnumero_facturaAutoriPago= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaAutoriPago() {
		return this.mostrarnumero_facturaAutoriPago;
	}

	public void setMostrarnumero_facturaAutoriPago(Boolean mostrarnumero_facturaAutoriPago) {
		this.mostrarnumero_facturaAutoriPago= mostrarnumero_facturaAutoriPago;
	}

	public Boolean getActivarnumero_facturaAutoriPago() {
		return this.activarnumero_facturaAutoriPago;
	}

	public void setActivarnumero_facturaAutoriPago(Boolean activarnumero_facturaAutoriPago) {
		this.activarnumero_facturaAutoriPago= activarnumero_facturaAutoriPago;
	}

	public Border setResaltardetalle_facturaAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltardetalle_facturaAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalle_facturaAutoriPago() {
		return this.resaltardetalle_facturaAutoriPago;
	}

	public void setResaltardetalle_facturaAutoriPago(Border borderResaltar) {
		this.resaltardetalle_facturaAutoriPago= borderResaltar;
	}

	public Boolean getMostrardetalle_facturaAutoriPago() {
		return this.mostrardetalle_facturaAutoriPago;
	}

	public void setMostrardetalle_facturaAutoriPago(Boolean mostrardetalle_facturaAutoriPago) {
		this.mostrardetalle_facturaAutoriPago= mostrardetalle_facturaAutoriPago;
	}

	public Boolean getActivardetalle_facturaAutoriPago() {
		return this.activardetalle_facturaAutoriPago;
	}

	public void setActivardetalle_facturaAutoriPago(Boolean activardetalle_facturaAutoriPago) {
		this.activardetalle_facturaAutoriPago= activardetalle_facturaAutoriPago;
	}

	public Border setResaltarfecha_corteAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltarfecha_corteAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_corteAutoriPago() {
		return this.resaltarfecha_corteAutoriPago;
	}

	public void setResaltarfecha_corteAutoriPago(Border borderResaltar) {
		this.resaltarfecha_corteAutoriPago= borderResaltar;
	}

	public Boolean getMostrarfecha_corteAutoriPago() {
		return this.mostrarfecha_corteAutoriPago;
	}

	public void setMostrarfecha_corteAutoriPago(Boolean mostrarfecha_corteAutoriPago) {
		this.mostrarfecha_corteAutoriPago= mostrarfecha_corteAutoriPago;
	}

	public Boolean getActivarfecha_corteAutoriPago() {
		return this.activarfecha_corteAutoriPago;
	}

	public void setActivarfecha_corteAutoriPago(Boolean activarfecha_corteAutoriPago) {
		this.activarfecha_corteAutoriPago= activarfecha_corteAutoriPago;
	}

	public Border setResaltardescripcionAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//autoripagoBeanSwingJInternalFrame.jTtoolBarAutoriPago.setBorder(borderResaltar);
		
		this.resaltardescripcionAutoriPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionAutoriPago() {
		return this.resaltardescripcionAutoriPago;
	}

	public void setResaltardescripcionAutoriPago(Border borderResaltar) {
		this.resaltardescripcionAutoriPago= borderResaltar;
	}

	public Boolean getMostrardescripcionAutoriPago() {
		return this.mostrardescripcionAutoriPago;
	}

	public void setMostrardescripcionAutoriPago(Boolean mostrardescripcionAutoriPago) {
		this.mostrardescripcionAutoriPago= mostrardescripcionAutoriPago;
	}

	public Boolean getActivardescripcionAutoriPago() {
		return this.activardescripcionAutoriPago;
	}

	public void setActivardescripcionAutoriPago(Boolean activardescripcionAutoriPago) {
		this.activardescripcionAutoriPago= activardescripcionAutoriPago;
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
		
		
		this.setMostraridAutoriPago(esInicial);
		this.setMostrarid_empresaAutoriPago(esInicial);
		this.setMostrarid_sucursalAutoriPago(esInicial);
		this.setMostrarid_ejercicioAutoriPago(esInicial);
		this.setMostrarid_clienteAutoriPago(esInicial);
		this.setMostrarid_facturaAutoriPago(esInicial);
		this.setMostrarid_asiento_contableAutoriPago(esInicial);
		this.setMostrarid_centro_costoAutoriPago(esInicial);
		this.setMostrarid_centro_actividadAutoriPago(esInicial);
		this.setMostrarid_bancoAutoriPago(esInicial);
		this.setMostrarid_cuenta_bancoAutoriPago(esInicial);
		this.setMostrarid_detalle_proveAutoriPago(esInicial);
		this.setMostrarid_transaccionAutoriPago(esInicial);
		this.setMostrarfecha_emisionAutoriPago(esInicial);
		this.setMostrarfecha_vencimientoAutoriPago(esInicial);
		this.setMostrarvalor_pagoAutoriPago(esInicial);
		this.setMostrarvalor_canceladoAutoriPago(esInicial);
		this.setMostrarnumero_facturaAutoriPago(esInicial);
		this.setMostrardetalle_facturaAutoriPago(esInicial);
		this.setMostrarfecha_corteAutoriPago(esInicial);
		this.setMostrardescripcionAutoriPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriPagoConstantesFunciones.ID)) {
				this.setMostraridAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setMostrarid_centro_actividadAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCUENTABANCO)) {
				this.setMostrarid_cuenta_bancoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDDETALLEPROVE)) {
				this.setMostrarid_detalle_proveAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.VALORPAGO)) {
				this.setMostrarvalor_pagoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.VALORCANCELADO)) {
				this.setMostrarvalor_canceladoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.DETALLEFACTURA)) {
				this.setMostrardetalle_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHACORTE)) {
				this.setMostrarfecha_corteAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionAutoriPago(esAsigna);
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
		
		
		this.setActivaridAutoriPago(esInicial);
		this.setActivarid_empresaAutoriPago(esInicial);
		this.setActivarid_sucursalAutoriPago(esInicial);
		this.setActivarid_ejercicioAutoriPago(esInicial);
		this.setActivarid_clienteAutoriPago(esInicial);
		this.setActivarid_facturaAutoriPago(esInicial);
		this.setActivarid_asiento_contableAutoriPago(esInicial);
		this.setActivarid_centro_costoAutoriPago(esInicial);
		this.setActivarid_centro_actividadAutoriPago(esInicial);
		this.setActivarid_bancoAutoriPago(esInicial);
		this.setActivarid_cuenta_bancoAutoriPago(esInicial);
		this.setActivarid_detalle_proveAutoriPago(esInicial);
		this.setActivarid_transaccionAutoriPago(esInicial);
		this.setActivarfecha_emisionAutoriPago(esInicial);
		this.setActivarfecha_vencimientoAutoriPago(esInicial);
		this.setActivarvalor_pagoAutoriPago(esInicial);
		this.setActivarvalor_canceladoAutoriPago(esInicial);
		this.setActivarnumero_facturaAutoriPago(esInicial);
		this.setActivardetalle_facturaAutoriPago(esInicial);
		this.setActivarfecha_corteAutoriPago(esInicial);
		this.setActivardescripcionAutoriPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriPagoConstantesFunciones.ID)) {
				this.setActivaridAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setActivarid_centro_actividadAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCUENTABANCO)) {
				this.setActivarid_cuenta_bancoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDDETALLEPROVE)) {
				this.setActivarid_detalle_proveAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.VALORPAGO)) {
				this.setActivarvalor_pagoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.VALORCANCELADO)) {
				this.setActivarvalor_canceladoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.DETALLEFACTURA)) {
				this.setActivardetalle_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHACORTE)) {
				this.setActivarfecha_corteAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionAutoriPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAutoriPago(esInicial);
		this.setResaltarid_empresaAutoriPago(esInicial);
		this.setResaltarid_sucursalAutoriPago(esInicial);
		this.setResaltarid_ejercicioAutoriPago(esInicial);
		this.setResaltarid_clienteAutoriPago(esInicial);
		this.setResaltarid_facturaAutoriPago(esInicial);
		this.setResaltarid_asiento_contableAutoriPago(esInicial);
		this.setResaltarid_centro_costoAutoriPago(esInicial);
		this.setResaltarid_centro_actividadAutoriPago(esInicial);
		this.setResaltarid_bancoAutoriPago(esInicial);
		this.setResaltarid_cuenta_bancoAutoriPago(esInicial);
		this.setResaltarid_detalle_proveAutoriPago(esInicial);
		this.setResaltarid_transaccionAutoriPago(esInicial);
		this.setResaltarfecha_emisionAutoriPago(esInicial);
		this.setResaltarfecha_vencimientoAutoriPago(esInicial);
		this.setResaltarvalor_pagoAutoriPago(esInicial);
		this.setResaltarvalor_canceladoAutoriPago(esInicial);
		this.setResaltarnumero_facturaAutoriPago(esInicial);
		this.setResaltardetalle_facturaAutoriPago(esInicial);
		this.setResaltarfecha_corteAutoriPago(esInicial);
		this.setResaltardescripcionAutoriPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AutoriPagoConstantesFunciones.ID)) {
				this.setResaltaridAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setResaltarid_centro_actividadAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDCUENTABANCO)) {
				this.setResaltarid_cuenta_bancoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDDETALLEPROVE)) {
				this.setResaltarid_detalle_proveAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.VALORPAGO)) {
				this.setResaltarvalor_pagoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.VALORCANCELADO)) {
				this.setResaltarvalor_canceladoAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.DETALLEFACTURA)) {
				this.setResaltardetalle_facturaAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.FECHACORTE)) {
				this.setResaltarfecha_corteAutoriPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(AutoriPagoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionAutoriPago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableAutoriPago=true;

	public Boolean getMostrarFK_IdAsientoContableAutoriPago() {
		return this.mostrarFK_IdAsientoContableAutoriPago;
	}

	public void setMostrarFK_IdAsientoContableAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBancoAutoriPago=true;

	public Boolean getMostrarFK_IdBancoAutoriPago() {
		return this.mostrarFK_IdBancoAutoriPago;
	}

	public void setMostrarFK_IdBancoAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroActividadAutoriPago=true;

	public Boolean getMostrarFK_IdCentroActividadAutoriPago() {
		return this.mostrarFK_IdCentroActividadAutoriPago;
	}

	public void setMostrarFK_IdCentroActividadAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroActividadAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoAutoriPago=true;

	public Boolean getMostrarFK_IdCentroCostoAutoriPago() {
		return this.mostrarFK_IdCentroCostoAutoriPago;
	}

	public void setMostrarFK_IdCentroCostoAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteAutoriPago=true;

	public Boolean getMostrarFK_IdClienteAutoriPago() {
		return this.mostrarFK_IdClienteAutoriPago;
	}

	public void setMostrarFK_IdClienteAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaBancoAutoriPago=true;

	public Boolean getMostrarFK_IdCuentaBancoAutoriPago() {
		return this.mostrarFK_IdCuentaBancoAutoriPago;
	}

	public void setMostrarFK_IdCuentaBancoAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaBancoAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleProveAutoriPago=true;

	public Boolean getMostrarFK_IdDetalleProveAutoriPago() {
		return this.mostrarFK_IdDetalleProveAutoriPago;
	}

	public void setMostrarFK_IdDetalleProveAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleProveAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioAutoriPago=true;

	public Boolean getMostrarFK_IdEjercicioAutoriPago() {
		return this.mostrarFK_IdEjercicioAutoriPago;
	}

	public void setMostrarFK_IdEjercicioAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAutoriPago=true;

	public Boolean getMostrarFK_IdEmpresaAutoriPago() {
		return this.mostrarFK_IdEmpresaAutoriPago;
	}

	public void setMostrarFK_IdEmpresaAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaAutoriPago=true;

	public Boolean getMostrarFK_IdFacturaAutoriPago() {
		return this.mostrarFK_IdFacturaAutoriPago;
	}

	public void setMostrarFK_IdFacturaAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalAutoriPago=true;

	public Boolean getMostrarFK_IdSucursalAutoriPago() {
		return this.mostrarFK_IdSucursalAutoriPago;
	}

	public void setMostrarFK_IdSucursalAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalAutoriPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionAutoriPago=true;

	public Boolean getMostrarFK_IdTransaccionAutoriPago() {
		return this.mostrarFK_IdTransaccionAutoriPago;
	}

	public void setMostrarFK_IdTransaccionAutoriPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionAutoriPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableAutoriPago=true;

	public Boolean getActivarFK_IdAsientoContableAutoriPago() {
		return this.activarFK_IdAsientoContableAutoriPago;
	}

	public void setActivarFK_IdAsientoContableAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdBancoAutoriPago=true;

	public Boolean getActivarFK_IdBancoAutoriPago() {
		return this.activarFK_IdBancoAutoriPago;
	}

	public void setActivarFK_IdBancoAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdBancoAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroActividadAutoriPago=true;

	public Boolean getActivarFK_IdCentroActividadAutoriPago() {
		return this.activarFK_IdCentroActividadAutoriPago;
	}

	public void setActivarFK_IdCentroActividadAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdCentroActividadAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoAutoriPago=true;

	public Boolean getActivarFK_IdCentroCostoAutoriPago() {
		return this.activarFK_IdCentroCostoAutoriPago;
	}

	public void setActivarFK_IdCentroCostoAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteAutoriPago=true;

	public Boolean getActivarFK_IdClienteAutoriPago() {
		return this.activarFK_IdClienteAutoriPago;
	}

	public void setActivarFK_IdClienteAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdClienteAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaBancoAutoriPago=true;

	public Boolean getActivarFK_IdCuentaBancoAutoriPago() {
		return this.activarFK_IdCuentaBancoAutoriPago;
	}

	public void setActivarFK_IdCuentaBancoAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaBancoAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleProveAutoriPago=true;

	public Boolean getActivarFK_IdDetalleProveAutoriPago() {
		return this.activarFK_IdDetalleProveAutoriPago;
	}

	public void setActivarFK_IdDetalleProveAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleProveAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioAutoriPago=true;

	public Boolean getActivarFK_IdEjercicioAutoriPago() {
		return this.activarFK_IdEjercicioAutoriPago;
	}

	public void setActivarFK_IdEjercicioAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAutoriPago=true;

	public Boolean getActivarFK_IdEmpresaAutoriPago() {
		return this.activarFK_IdEmpresaAutoriPago;
	}

	public void setActivarFK_IdEmpresaAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaAutoriPago=true;

	public Boolean getActivarFK_IdFacturaAutoriPago() {
		return this.activarFK_IdFacturaAutoriPago;
	}

	public void setActivarFK_IdFacturaAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalAutoriPago=true;

	public Boolean getActivarFK_IdSucursalAutoriPago() {
		return this.activarFK_IdSucursalAutoriPago;
	}

	public void setActivarFK_IdSucursalAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalAutoriPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionAutoriPago=true;

	public Boolean getActivarFK_IdTransaccionAutoriPago() {
		return this.activarFK_IdTransaccionAutoriPago;
	}

	public void setActivarFK_IdTransaccionAutoriPago(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionAutoriPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableAutoriPago=null;

	public Border getResaltarFK_IdAsientoContableAutoriPago() {
		return this.resaltarFK_IdAsientoContableAutoriPago;
	}

	public void setResaltarFK_IdAsientoContableAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdBancoAutoriPago=null;

	public Border getResaltarFK_IdBancoAutoriPago() {
		return this.resaltarFK_IdBancoAutoriPago;
	}

	public void setResaltarFK_IdBancoAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdBancoAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdBancoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdCentroActividadAutoriPago=null;

	public Border getResaltarFK_IdCentroActividadAutoriPago() {
		return this.resaltarFK_IdCentroActividadAutoriPago;
	}

	public void setResaltarFK_IdCentroActividadAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdCentroActividadAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdCentroActividadAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroActividadAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoAutoriPago=null;

	public Border getResaltarFK_IdCentroCostoAutoriPago() {
		return this.resaltarFK_IdCentroCostoAutoriPago;
	}

	public void setResaltarFK_IdCentroCostoAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdClienteAutoriPago=null;

	public Border getResaltarFK_IdClienteAutoriPago() {
		return this.resaltarFK_IdClienteAutoriPago;
	}

	public void setResaltarFK_IdClienteAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdClienteAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdClienteAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdCuentaBancoAutoriPago=null;

	public Border getResaltarFK_IdCuentaBancoAutoriPago() {
		return this.resaltarFK_IdCuentaBancoAutoriPago;
	}

	public void setResaltarFK_IdCuentaBancoAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdCuentaBancoAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdCuentaBancoAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaBancoAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdDetalleProveAutoriPago=null;

	public Border getResaltarFK_IdDetalleProveAutoriPago() {
		return this.resaltarFK_IdDetalleProveAutoriPago;
	}

	public void setResaltarFK_IdDetalleProveAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdDetalleProveAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdDetalleProveAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleProveAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioAutoriPago=null;

	public Border getResaltarFK_IdEjercicioAutoriPago() {
		return this.resaltarFK_IdEjercicioAutoriPago;
	}

	public void setResaltarFK_IdEjercicioAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdEjercicioAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAutoriPago=null;

	public Border getResaltarFK_IdEmpresaAutoriPago() {
		return this.resaltarFK_IdEmpresaAutoriPago;
	}

	public void setResaltarFK_IdEmpresaAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdFacturaAutoriPago=null;

	public Border getResaltarFK_IdFacturaAutoriPago() {
		return this.resaltarFK_IdFacturaAutoriPago;
	}

	public void setResaltarFK_IdFacturaAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdFacturaAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdFacturaAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdSucursalAutoriPago=null;

	public Border getResaltarFK_IdSucursalAutoriPago() {
		return this.resaltarFK_IdSucursalAutoriPago;
	}

	public void setResaltarFK_IdSucursalAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdSucursalAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdSucursalAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalAutoriPago= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionAutoriPago=null;

	public Border getResaltarFK_IdTransaccionAutoriPago() {
		return this.resaltarFK_IdTransaccionAutoriPago;
	}

	public void setResaltarFK_IdTransaccionAutoriPago(Border borderResaltar) {
		this.resaltarFK_IdTransaccionAutoriPago= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionAutoriPago(ParametroGeneralUsuario parametroGeneralUsuario/*AutoriPagoBeanSwingJInternalFrame autoripagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionAutoriPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}