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


import com.bydan.erp.tesoreria.util.PagoAutoConstantesFunciones;
import com.bydan.erp.tesoreria.util.PagoAutoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.PagoAutoParameterGeneral;

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
final public class PagoAutoConstantesFunciones extends PagoAutoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PagoAuto";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PagoAuto"+PagoAutoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PagoAutoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PagoAutoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PagoAutoConstantesFunciones.SCHEMA+"_"+PagoAutoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PagoAutoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PagoAutoConstantesFunciones.SCHEMA+"_"+PagoAutoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PagoAutoConstantesFunciones.SCHEMA+"_"+PagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PagoAutoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PagoAutoConstantesFunciones.SCHEMA+"_"+PagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagoAutoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PagoAutoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PagoAutoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PagoAutoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PagoAutoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PagoAutoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PagoAutoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Pago Autos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Pago Auto";
	public static final String SCLASSWEBTITULO_LOWER="Pago Auto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PagoAuto";
	public static final String OBJECTNAME="pagoauto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="pago_auto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select pagoauto from "+PagoAutoConstantesFunciones.SPERSISTENCENAME+" pagoauto";
	public static String QUERYSELECTNATIVE="select "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".version_row,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_empresa,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_sucursal,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_ejercicio,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_cliente,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_asiento_contable,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_centro_costo,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_centro_actividad,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_factura,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_detalle_prove,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_cuenta_banco,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_transaccion,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".id_estado_pago_auto,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".numero_factura,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".fecha_emision,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".fecha_corte,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".valor_por_pagar,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".valor_cancelado,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".esta_autorizado,"+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME+".descripcion from "+PagoAutoConstantesFunciones.SCHEMA+"."+PagoAutoConstantesFunciones.TABLENAME;//+" as "+PagoAutoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PagoAutoConstantesFuncionesAdditional pagoautoConstantesFuncionesAdditional=null;
	
	public PagoAutoConstantesFuncionesAdditional getPagoAutoConstantesFuncionesAdditional() {
		return this.pagoautoConstantesFuncionesAdditional;
	}
	
	public void setPagoAutoConstantesFuncionesAdditional(PagoAutoConstantesFuncionesAdditional pagoautoConstantesFuncionesAdditional) {
		try {
			this.pagoautoConstantesFuncionesAdditional=pagoautoConstantesFuncionesAdditional;
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
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDCENTROACTIVIDAD= "id_centro_actividad";
    public static final String IDFACTURA= "id_factura";
    public static final String IDDETALLEPROVE= "id_detalle_prove";
    public static final String IDCUENTABANCO= "id_cuenta_banco";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDESTADOPAGOAUTO= "id_estado_pago_auto";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String FECHACORTE= "fecha_corte";
    public static final String VALORPORPAGAR= "valor_por_pagar";
    public static final String VALORCANCELADO= "valor_cancelado";
    public static final String ESTAAUTORIZADO= "esta_autorizado";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDCENTROACTIVIDAD= "Centro Activad";
		public static final String LABEL_IDCENTROACTIVIDAD_LOWER= "Centro Actividad";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDDETALLEPROVE= "Detalle Prove";
		public static final String LABEL_IDDETALLEPROVE_LOWER= "Detalle Prove";
    	public static final String LABEL_IDCUENTABANCO= "Cuenta Banco";
		public static final String LABEL_IDCUENTABANCO_LOWER= "Cuenta Banco";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDESTADOPAGOAUTO= "Estado Pago Auto";
		public static final String LABEL_IDESTADOPAGOAUTO_LOWER= "Estado Pago Auto";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_FECHACORTE= "Fecha Corte";
		public static final String LABEL_FECHACORTE_LOWER= "Fecha Corte";
    	public static final String LABEL_VALORPORPAGAR= "Valor Por Pagar";
		public static final String LABEL_VALORPORPAGAR_LOWER= "Valor Por Pagar";
    	public static final String LABEL_VALORCANCELADO= "Valor Cancelado";
		public static final String LABEL_VALORCANCELADO_LOWER= "Valor Cancelado";
    	public static final String LABEL_ESTAAUTORIZADO= "Esta Autorizado";
		public static final String LABEL_ESTAAUTORIZADO_LOWER= "Esta Autorizado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPagoAutoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDCLIENTE)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDCENTROACTIVIDAD)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDCENTROACTIVIDAD;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDFACTURA)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDDETALLEPROVE)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDDETALLEPROVE;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDCUENTABANCO)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDCUENTABANCO;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDTRANSACCION)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.IDESTADOPAGOAUTO)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_IDESTADOPAGOAUTO;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.FECHAEMISION)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.FECHACORTE)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_FECHACORTE;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.VALORPORPAGAR)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_VALORPORPAGAR;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.VALORCANCELADO)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_VALORCANCELADO;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.ESTAAUTORIZADO)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_ESTAAUTORIZADO;}
		if(sNombreColumna.equals(PagoAutoConstantesFunciones.DESCRIPCION)) {sLabelColumna=PagoAutoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getesta_autorizadoDescripcion(PagoAuto pagoauto) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!pagoauto.getesta_autorizado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_autorizadoHtmlDescripcion(PagoAuto pagoauto) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(pagoauto.getId(),pagoauto.getesta_autorizado());

		return sDescripcion;
	}	
			
	
	public static String getPagoAutoDescripcion(PagoAuto pagoauto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(pagoauto !=null/* && pagoauto.getId()!=0*/) {
			if(pagoauto.getId()!=null) {
				sDescripcion=pagoauto.getId().toString();
			}//pagoautopagoauto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPagoAutoDescripcionDetallado(PagoAuto pagoauto) {
		String sDescripcion="";
			
		sDescripcion+=PagoAutoConstantesFunciones.ID+"=";
		sDescripcion+=pagoauto.getId().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=pagoauto.getVersionRow().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=pagoauto.getid_empresa().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=pagoauto.getid_sucursal().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=pagoauto.getid_ejercicio().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=pagoauto.getid_cliente().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=pagoauto.getid_asiento_contable().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=pagoauto.getid_centro_costo().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDCENTROACTIVIDAD+"=";
		sDescripcion+=pagoauto.getid_centro_actividad().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=pagoauto.getid_factura().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDDETALLEPROVE+"=";
		sDescripcion+=pagoauto.getid_detalle_prove().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDCUENTABANCO+"=";
		sDescripcion+=pagoauto.getid_cuenta_banco().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=pagoauto.getid_transaccion().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.IDESTADOPAGOAUTO+"=";
		sDescripcion+=pagoauto.getid_estado_pago_auto().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=pagoauto.getnumero_factura()+",";
		sDescripcion+=PagoAutoConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=pagoauto.getfecha_emision().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=pagoauto.getfecha_vencimiento().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.FECHACORTE+"=";
		sDescripcion+=pagoauto.getfecha_corte().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.VALORPORPAGAR+"=";
		sDescripcion+=pagoauto.getvalor_por_pagar().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.VALORCANCELADO+"=";
		sDescripcion+=pagoauto.getvalor_cancelado().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.ESTAAUTORIZADO+"=";
		sDescripcion+=pagoauto.getesta_autorizado().toString()+",";
		sDescripcion+=PagoAutoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=pagoauto.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setPagoAutoDescripcion(PagoAuto pagoauto,String sValor) throws Exception {			
		if(pagoauto !=null) {
			//pagoautopagoauto.getId().toString();
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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

	public static String getCuentaBancoDescripcion(CuentaBanco cuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentabanco!=null/*&&cuentabanco.getId()>0*/) {
			sDescripcion=CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(cuentabanco);
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

	public static String getEstadoPagoAutoDescripcion(EstadoPagoAuto estadopagoauto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopagoauto!=null/*&&estadopagoauto.getId()>0*/) {
			sDescripcion=EstadoPagoAutoConstantesFunciones.getEstadoPagoAutoDescripcion(estadopagoauto);
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
		} else if(sNombreIndice.equals("FK_IdEstadoPagoAuto")) {
			sNombreIndice="Tipo=  Por Estado Pago Auto";
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

	public static String getDetalleIndiceFK_IdEstadoPagoAuto(Long id_estado_pago_auto) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_pago_auto!=null) {sDetalleIndice+=" Codigo Unico De Estado Pago Auto="+id_estado_pago_auto.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosPagoAuto(PagoAuto pagoauto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		pagoauto.setnumero_factura(pagoauto.getnumero_factura().trim());
		pagoauto.setdescripcion(pagoauto.getdescripcion().trim());
	}
	
	public static void quitarEspaciosPagoAutos(List<PagoAuto> pagoautos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PagoAuto pagoauto: pagoautos) {
			pagoauto.setnumero_factura(pagoauto.getnumero_factura().trim());
			pagoauto.setdescripcion(pagoauto.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagoAuto(PagoAuto pagoauto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && pagoauto.getConCambioAuxiliar()) {
			pagoauto.setIsDeleted(pagoauto.getIsDeletedAuxiliar());	
			pagoauto.setIsNew(pagoauto.getIsNewAuxiliar());	
			pagoauto.setIsChanged(pagoauto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			pagoauto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			pagoauto.setIsDeletedAuxiliar(false);	
			pagoauto.setIsNewAuxiliar(false);	
			pagoauto.setIsChangedAuxiliar(false);
			
			pagoauto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPagoAutos(List<PagoAuto> pagoautos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PagoAuto pagoauto : pagoautos) {
			if(conAsignarBase && pagoauto.getConCambioAuxiliar()) {
				pagoauto.setIsDeleted(pagoauto.getIsDeletedAuxiliar());	
				pagoauto.setIsNew(pagoauto.getIsNewAuxiliar());	
				pagoauto.setIsChanged(pagoauto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				pagoauto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				pagoauto.setIsDeletedAuxiliar(false);	
				pagoauto.setIsNewAuxiliar(false);	
				pagoauto.setIsChangedAuxiliar(false);
				
				pagoauto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPagoAuto(PagoAuto pagoauto,Boolean conEnteros) throws Exception  {
		pagoauto.setvalor_por_pagar(0.0);
		pagoauto.setvalor_cancelado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPagoAutos(List<PagoAuto> pagoautos,Boolean conEnteros) throws Exception  {
		
		for(PagoAuto pagoauto: pagoautos) {
			pagoauto.setvalor_por_pagar(0.0);
			pagoauto.setvalor_cancelado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPagoAuto(List<PagoAuto> pagoautos,PagoAuto pagoautoAux) throws Exception  {
		PagoAutoConstantesFunciones.InicializarValoresPagoAuto(pagoautoAux,true);
		
		for(PagoAuto pagoauto: pagoautos) {
			if(pagoauto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			pagoautoAux.setvalor_por_pagar(pagoautoAux.getvalor_por_pagar()+pagoauto.getvalor_por_pagar());			
			pagoautoAux.setvalor_cancelado(pagoautoAux.getvalor_cancelado()+pagoauto.getvalor_cancelado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPagoAuto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PagoAutoConstantesFunciones.getArrayColumnasGlobalesPagoAuto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPagoAuto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagoAutoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagoAutoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagoAutoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagoAutoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PagoAutoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PagoAutoConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPagoAuto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PagoAuto> pagoautos,PagoAuto pagoauto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PagoAuto pagoautoAux: pagoautos) {
			if(pagoautoAux!=null && pagoauto!=null) {
				if((pagoautoAux.getId()==null && pagoauto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(pagoautoAux.getId()!=null && pagoauto.getId()!=null){
					if(pagoautoAux.getId().equals(pagoauto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPagoAuto(List<PagoAuto> pagoautos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_por_pagarTotal=0.0;
		Double valor_canceladoTotal=0.0;
	
		for(PagoAuto pagoauto: pagoautos) {			
			if(pagoauto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_por_pagarTotal+=pagoauto.getvalor_por_pagar();
			valor_canceladoTotal+=pagoauto.getvalor_cancelado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagoAutoConstantesFunciones.VALORPORPAGAR);
		datoGeneral.setsDescripcion(PagoAutoConstantesFunciones.LABEL_VALORPORPAGAR);
		datoGeneral.setdValorDouble(valor_por_pagarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PagoAutoConstantesFunciones.VALORCANCELADO);
		datoGeneral.setsDescripcion(PagoAutoConstantesFunciones.LABEL_VALORCANCELADO);
		datoGeneral.setdValorDouble(valor_canceladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPagoAuto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_ID, PagoAutoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_VERSIONROW, PagoAutoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDEMPRESA, PagoAutoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDSUCURSAL, PagoAutoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDEJERCICIO, PagoAutoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDCLIENTE, PagoAutoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDASIENTOCONTABLE, PagoAutoConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDCENTROCOSTO, PagoAutoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDCENTROACTIVIDAD, PagoAutoConstantesFunciones.IDCENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDFACTURA, PagoAutoConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDDETALLEPROVE, PagoAutoConstantesFunciones.IDDETALLEPROVE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDCUENTABANCO, PagoAutoConstantesFunciones.IDCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDTRANSACCION, PagoAutoConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_IDESTADOPAGOAUTO, PagoAutoConstantesFunciones.IDESTADOPAGOAUTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_NUMEROFACTURA, PagoAutoConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_FECHAEMISION, PagoAutoConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_FECHAVENCIMIENTO, PagoAutoConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_FECHACORTE, PagoAutoConstantesFunciones.FECHACORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_VALORPORPAGAR, PagoAutoConstantesFunciones.VALORPORPAGAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_VALORCANCELADO, PagoAutoConstantesFunciones.VALORCANCELADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_ESTAAUTORIZADO, PagoAutoConstantesFunciones.ESTAAUTORIZADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PagoAutoConstantesFunciones.LABEL_DESCRIPCION, PagoAutoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPagoAuto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDCENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDDETALLEPROVE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.IDESTADOPAGOAUTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.FECHACORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.VALORPORPAGAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.VALORCANCELADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.ESTAAUTORIZADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PagoAutoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagoAuto() throws Exception  {
		return PagoAutoConstantesFunciones.getTiposSeleccionarPagoAuto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagoAuto(Boolean conFk) throws Exception  {
		return PagoAutoConstantesFunciones.getTiposSeleccionarPagoAuto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPagoAuto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDDETALLEPROVE);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDDETALLEPROVE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDCUENTABANCO);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_IDESTADOPAGOAUTO);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_IDESTADOPAGOAUTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_FECHACORTE);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_FECHACORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_VALORPORPAGAR);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_VALORPORPAGAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_VALORCANCELADO);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_VALORCANCELADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_ESTAAUTORIZADO);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_ESTAAUTORIZADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PagoAutoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(PagoAutoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPagoAuto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPagoAuto(PagoAuto pagoautoAux) throws Exception {
		
			pagoautoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagoautoAux.getEmpresa()));
			pagoautoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pagoautoAux.getSucursal()));
			pagoautoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pagoautoAux.getEjercicio()));
			pagoautoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pagoautoAux.getCliente()));
			pagoautoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(pagoautoAux.getAsientoContable()));
			pagoautoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(pagoautoAux.getCentroCosto()));
			pagoautoAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(pagoautoAux.getCentroActividad()));
			pagoautoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(pagoautoAux.getFactura()));
			pagoautoAux.setdetalleprove_descripcion(DetalleProveConstantesFunciones.getDetalleProveDescripcion(pagoautoAux.getDetalleProve()));
			pagoautoAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(pagoautoAux.getCuentaBanco()));
			pagoautoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(pagoautoAux.getTransaccion()));
			pagoautoAux.setestadopagoauto_descripcion(EstadoPagoAutoConstantesFunciones.getEstadoPagoAutoDescripcion(pagoautoAux.getEstadoPagoAuto()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPagoAuto(List<PagoAuto> pagoautosTemp) throws Exception {
		for(PagoAuto pagoautoAux:pagoautosTemp) {
			
			pagoautoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(pagoautoAux.getEmpresa()));
			pagoautoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(pagoautoAux.getSucursal()));
			pagoautoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(pagoautoAux.getEjercicio()));
			pagoautoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(pagoautoAux.getCliente()));
			pagoautoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(pagoautoAux.getAsientoContable()));
			pagoautoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(pagoautoAux.getCentroCosto()));
			pagoautoAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(pagoautoAux.getCentroActividad()));
			pagoautoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(pagoautoAux.getFactura()));
			pagoautoAux.setdetalleprove_descripcion(DetalleProveConstantesFunciones.getDetalleProveDescripcion(pagoautoAux.getDetalleProve()));
			pagoautoAux.setcuentabanco_descripcion(CuentaBancoConstantesFunciones.getCuentaBancoDescripcion(pagoautoAux.getCuentaBanco()));
			pagoautoAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(pagoautoAux.getTransaccion()));
			pagoautoAux.setestadopagoauto_descripcion(EstadoPagoAutoConstantesFunciones.getEstadoPagoAutoDescripcion(pagoautoAux.getEstadoPagoAuto()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(CentroActividad.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(DetalleProve.class));
				classes.add(new Classe(CuentaBanco.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(EstadoPagoAuto.class));
				
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
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleProve.class)) {
						classes.add(new Classe(DetalleProve.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaBanco.class)) {
						classes.add(new Classe(CuentaBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPagoAuto.class)) {
						classes.add(new Classe(EstadoPagoAuto.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPagoAuto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(DetalleProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProve.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(EstadoPagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPagoAuto.class)); continue;
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(DetalleProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProve.class)); continue;
					}

					if(CuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaBanco.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(EstadoPagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPagoAuto.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagoAutoConstantesFunciones.getClassesRelationshipsOfPagoAuto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPagoAuto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagoAuto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PagoAutoConstantesFunciones.getClassesRelationshipsFromStringsOfPagoAuto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPagoAuto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PagoAuto pagoauto,List<PagoAuto> pagoautos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PagoAuto pagoautoEncontrado=null;
			
			for(PagoAuto pagoautoLocal:pagoautos) {
				if(pagoautoLocal.getId().equals(pagoauto.getId())) {
					pagoautoEncontrado=pagoautoLocal;
					
					pagoautoLocal.setIsChanged(pagoauto.getIsChanged());
					pagoautoLocal.setIsNew(pagoauto.getIsNew());
					pagoautoLocal.setIsDeleted(pagoauto.getIsDeleted());
					
					pagoautoLocal.setGeneralEntityOriginal(pagoauto.getGeneralEntityOriginal());
					
					pagoautoLocal.setId(pagoauto.getId());	
					pagoautoLocal.setVersionRow(pagoauto.getVersionRow());	
					pagoautoLocal.setid_empresa(pagoauto.getid_empresa());	
					pagoautoLocal.setid_sucursal(pagoauto.getid_sucursal());	
					pagoautoLocal.setid_ejercicio(pagoauto.getid_ejercicio());	
					pagoautoLocal.setid_cliente(pagoauto.getid_cliente());	
					pagoautoLocal.setid_asiento_contable(pagoauto.getid_asiento_contable());	
					pagoautoLocal.setid_centro_costo(pagoauto.getid_centro_costo());	
					pagoautoLocal.setid_centro_actividad(pagoauto.getid_centro_actividad());	
					pagoautoLocal.setid_factura(pagoauto.getid_factura());	
					pagoautoLocal.setid_detalle_prove(pagoauto.getid_detalle_prove());	
					pagoautoLocal.setid_cuenta_banco(pagoauto.getid_cuenta_banco());	
					pagoautoLocal.setid_transaccion(pagoauto.getid_transaccion());	
					pagoautoLocal.setid_estado_pago_auto(pagoauto.getid_estado_pago_auto());	
					pagoautoLocal.setnumero_factura(pagoauto.getnumero_factura());	
					pagoautoLocal.setfecha_emision(pagoauto.getfecha_emision());	
					pagoautoLocal.setfecha_vencimiento(pagoauto.getfecha_vencimiento());	
					pagoautoLocal.setfecha_corte(pagoauto.getfecha_corte());	
					pagoautoLocal.setvalor_por_pagar(pagoauto.getvalor_por_pagar());	
					pagoautoLocal.setvalor_cancelado(pagoauto.getvalor_cancelado());	
					pagoautoLocal.setesta_autorizado(pagoauto.getesta_autorizado());	
					pagoautoLocal.setdescripcion(pagoauto.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!pagoauto.getIsDeleted()) {
				if(!existe) {
					pagoautos.add(pagoauto);
				}
			} else {
				if(pagoautoEncontrado!=null && permiteQuitar)  {
					pagoautos.remove(pagoautoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PagoAuto pagoauto,List<PagoAuto> pagoautos) throws Exception {
		try	{			
			for(PagoAuto pagoautoLocal:pagoautos) {
				if(pagoautoLocal.getId().equals(pagoauto.getId())) {
					pagoautoLocal.setIsSelected(pagoauto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPagoAuto(List<PagoAuto> pagoautosAux) throws Exception {
		//this.pagoautosAux=pagoautosAux;
		
		for(PagoAuto pagoautoAux:pagoautosAux) {
			if(pagoautoAux.getIsChanged()) {
				pagoautoAux.setIsChanged(false);
			}		
			
			if(pagoautoAux.getIsNew()) {
				pagoautoAux.setIsNew(false);
			}	
			
			if(pagoautoAux.getIsDeleted()) {
				pagoautoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPagoAuto(PagoAuto pagoautoAux) throws Exception {
		//this.pagoautoAux=pagoautoAux;
		
			if(pagoautoAux.getIsChanged()) {
				pagoautoAux.setIsChanged(false);
			}		
			
			if(pagoautoAux.getIsNew()) {
				pagoautoAux.setIsNew(false);
			}	
			
			if(pagoautoAux.getIsDeleted()) {
				pagoautoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PagoAuto pagoautoAsignar,PagoAuto pagoauto) throws Exception {
		pagoautoAsignar.setId(pagoauto.getId());	
		pagoautoAsignar.setVersionRow(pagoauto.getVersionRow());	
		pagoautoAsignar.setid_empresa(pagoauto.getid_empresa());
		pagoautoAsignar.setempresa_descripcion(pagoauto.getempresa_descripcion());	
		pagoautoAsignar.setid_sucursal(pagoauto.getid_sucursal());
		pagoautoAsignar.setsucursal_descripcion(pagoauto.getsucursal_descripcion());	
		pagoautoAsignar.setid_ejercicio(pagoauto.getid_ejercicio());
		pagoautoAsignar.setejercicio_descripcion(pagoauto.getejercicio_descripcion());	
		pagoautoAsignar.setid_cliente(pagoauto.getid_cliente());
		pagoautoAsignar.setcliente_descripcion(pagoauto.getcliente_descripcion());	
		pagoautoAsignar.setid_asiento_contable(pagoauto.getid_asiento_contable());
		pagoautoAsignar.setasientocontable_descripcion(pagoauto.getasientocontable_descripcion());	
		pagoautoAsignar.setid_centro_costo(pagoauto.getid_centro_costo());
		pagoautoAsignar.setcentrocosto_descripcion(pagoauto.getcentrocosto_descripcion());	
		pagoautoAsignar.setid_centro_actividad(pagoauto.getid_centro_actividad());
		pagoautoAsignar.setcentroactividad_descripcion(pagoauto.getcentroactividad_descripcion());	
		pagoautoAsignar.setid_factura(pagoauto.getid_factura());
		pagoautoAsignar.setfactura_descripcion(pagoauto.getfactura_descripcion());	
		pagoautoAsignar.setid_detalle_prove(pagoauto.getid_detalle_prove());
		pagoautoAsignar.setdetalleprove_descripcion(pagoauto.getdetalleprove_descripcion());	
		pagoautoAsignar.setid_cuenta_banco(pagoauto.getid_cuenta_banco());
		pagoautoAsignar.setcuentabanco_descripcion(pagoauto.getcuentabanco_descripcion());	
		pagoautoAsignar.setid_transaccion(pagoauto.getid_transaccion());
		pagoautoAsignar.settransaccion_descripcion(pagoauto.gettransaccion_descripcion());	
		pagoautoAsignar.setid_estado_pago_auto(pagoauto.getid_estado_pago_auto());
		pagoautoAsignar.setestadopagoauto_descripcion(pagoauto.getestadopagoauto_descripcion());	
		pagoautoAsignar.setnumero_factura(pagoauto.getnumero_factura());	
		pagoautoAsignar.setfecha_emision(pagoauto.getfecha_emision());	
		pagoautoAsignar.setfecha_vencimiento(pagoauto.getfecha_vencimiento());	
		pagoautoAsignar.setfecha_corte(pagoauto.getfecha_corte());	
		pagoautoAsignar.setvalor_por_pagar(pagoauto.getvalor_por_pagar());	
		pagoautoAsignar.setvalor_cancelado(pagoauto.getvalor_cancelado());	
		pagoautoAsignar.setesta_autorizado(pagoauto.getesta_autorizado());	
		pagoautoAsignar.setdescripcion(pagoauto.getdescripcion());	
	}
	
	public static void inicializarPagoAuto(PagoAuto pagoauto) throws Exception {
		try {
				pagoauto.setId(0L);	
					
				pagoauto.setid_empresa(-1L);	
				pagoauto.setid_sucursal(-1L);	
				pagoauto.setid_ejercicio(-1L);	
				pagoauto.setid_cliente(-1L);	
				pagoauto.setid_asiento_contable(-1L);	
				pagoauto.setid_centro_costo(null);	
				pagoauto.setid_centro_actividad(null);	
				pagoauto.setid_factura(-1L);	
				pagoauto.setid_detalle_prove(-1L);	
				pagoauto.setid_cuenta_banco(-1L);	
				pagoauto.setid_transaccion(-1L);	
				pagoauto.setid_estado_pago_auto(-1L);	
				pagoauto.setnumero_factura("");	
				pagoauto.setfecha_emision(new Date());	
				pagoauto.setfecha_vencimiento(new Date());	
				pagoauto.setfecha_corte(new Date());	
				pagoauto.setvalor_por_pagar(0.0);	
				pagoauto.setvalor_cancelado(0.0);	
				pagoauto.setesta_autorizado(false);	
				pagoauto.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPagoAuto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDDETALLEPROVE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_IDESTADOPAGOAUTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_FECHACORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_VALORPORPAGAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_VALORCANCELADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_ESTAAUTORIZADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PagoAutoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPagoAuto(String sTipo,Row row,Workbook workbook,PagoAuto pagoauto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getcentroactividad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getdetalleprove_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getcuentabanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getestadopagoauto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getfecha_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getvalor_por_pagar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getvalor_cancelado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(pagoauto.getesta_autorizado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(pagoauto.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPagoAuto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPagoAuto() {
		return this.sFinalQueryPagoAuto;
	}
	
	public void setsFinalQueryPagoAuto(String sFinalQueryPagoAuto) {
		this.sFinalQueryPagoAuto= sFinalQueryPagoAuto;
	}
	
	public Border resaltarSeleccionarPagoAuto=null;
	
	public Border setResaltarSeleccionarPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPagoAuto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPagoAuto() {
		return this.resaltarSeleccionarPagoAuto;
	}
	
	public void setResaltarSeleccionarPagoAuto(Border borderResaltarSeleccionarPagoAuto) {
		this.resaltarSeleccionarPagoAuto= borderResaltarSeleccionarPagoAuto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPagoAuto=null;
	public Boolean mostraridPagoAuto=true;
	public Boolean activaridPagoAuto=true;

	public Border resaltarid_empresaPagoAuto=null;
	public Boolean mostrarid_empresaPagoAuto=true;
	public Boolean activarid_empresaPagoAuto=true;
	public Boolean cargarid_empresaPagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPagoAuto=false;//ConEventDepend=true

	public Border resaltarid_sucursalPagoAuto=null;
	public Boolean mostrarid_sucursalPagoAuto=true;
	public Boolean activarid_sucursalPagoAuto=true;
	public Boolean cargarid_sucursalPagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPagoAuto=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPagoAuto=null;
	public Boolean mostrarid_ejercicioPagoAuto=true;
	public Boolean activarid_ejercicioPagoAuto=true;
	public Boolean cargarid_ejercicioPagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPagoAuto=false;//ConEventDepend=true

	public Border resaltarid_clientePagoAuto=null;
	public Boolean mostrarid_clientePagoAuto=true;
	public Boolean activarid_clientePagoAuto=true;
	public Boolean cargarid_clientePagoAuto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePagoAuto=false;//ConEventDepend=true

	public Border resaltarid_asiento_contablePagoAuto=null;
	public Boolean mostrarid_asiento_contablePagoAuto=true;
	public Boolean activarid_asiento_contablePagoAuto=true;
	public Boolean cargarid_asiento_contablePagoAuto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contablePagoAuto=false;//ConEventDepend=true

	public Border resaltarid_centro_costoPagoAuto=null;
	public Boolean mostrarid_centro_costoPagoAuto=true;
	public Boolean activarid_centro_costoPagoAuto=true;
	public Boolean cargarid_centro_costoPagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoPagoAuto=false;//ConEventDepend=true

	public Border resaltarid_centro_actividadPagoAuto=null;
	public Boolean mostrarid_centro_actividadPagoAuto=true;
	public Boolean activarid_centro_actividadPagoAuto=true;
	public Boolean cargarid_centro_actividadPagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_actividadPagoAuto=false;//ConEventDepend=true

	public Border resaltarid_facturaPagoAuto=null;
	public Boolean mostrarid_facturaPagoAuto=true;
	public Boolean activarid_facturaPagoAuto=true;
	public Boolean cargarid_facturaPagoAuto=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaPagoAuto=false;//ConEventDepend=true

	public Border resaltarid_detalle_provePagoAuto=null;
	public Boolean mostrarid_detalle_provePagoAuto=true;
	public Boolean activarid_detalle_provePagoAuto=true;
	public Boolean cargarid_detalle_provePagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_provePagoAuto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_bancoPagoAuto=null;
	public Boolean mostrarid_cuenta_bancoPagoAuto=true;
	public Boolean activarid_cuenta_bancoPagoAuto=true;
	public Boolean cargarid_cuenta_bancoPagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_bancoPagoAuto=false;//ConEventDepend=true

	public Border resaltarid_transaccionPagoAuto=null;
	public Boolean mostrarid_transaccionPagoAuto=true;
	public Boolean activarid_transaccionPagoAuto=true;
	public Boolean cargarid_transaccionPagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionPagoAuto=false;//ConEventDepend=true

	public Border resaltarid_estado_pago_autoPagoAuto=null;
	public Boolean mostrarid_estado_pago_autoPagoAuto=true;
	public Boolean activarid_estado_pago_autoPagoAuto=true;
	public Boolean cargarid_estado_pago_autoPagoAuto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_pago_autoPagoAuto=false;//ConEventDepend=true

	public Border resaltarnumero_facturaPagoAuto=null;
	public Boolean mostrarnumero_facturaPagoAuto=true;
	public Boolean activarnumero_facturaPagoAuto=true;

	public Border resaltarfecha_emisionPagoAuto=null;
	public Boolean mostrarfecha_emisionPagoAuto=true;
	public Boolean activarfecha_emisionPagoAuto=false;

	public Border resaltarfecha_vencimientoPagoAuto=null;
	public Boolean mostrarfecha_vencimientoPagoAuto=true;
	public Boolean activarfecha_vencimientoPagoAuto=false;

	public Border resaltarfecha_cortePagoAuto=null;
	public Boolean mostrarfecha_cortePagoAuto=true;
	public Boolean activarfecha_cortePagoAuto=false;

	public Border resaltarvalor_por_pagarPagoAuto=null;
	public Boolean mostrarvalor_por_pagarPagoAuto=true;
	public Boolean activarvalor_por_pagarPagoAuto=true;

	public Border resaltarvalor_canceladoPagoAuto=null;
	public Boolean mostrarvalor_canceladoPagoAuto=true;
	public Boolean activarvalor_canceladoPagoAuto=true;

	public Border resaltaresta_autorizadoPagoAuto=null;
	public Boolean mostraresta_autorizadoPagoAuto=true;
	public Boolean activaresta_autorizadoPagoAuto=true;

	public Border resaltardescripcionPagoAuto=null;
	public Boolean mostrardescripcionPagoAuto=true;
	public Boolean activardescripcionPagoAuto=true;

	
	

	public Border setResaltaridPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltaridPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPagoAuto() {
		return this.resaltaridPagoAuto;
	}

	public void setResaltaridPagoAuto(Border borderResaltar) {
		this.resaltaridPagoAuto= borderResaltar;
	}

	public Boolean getMostraridPagoAuto() {
		return this.mostraridPagoAuto;
	}

	public void setMostraridPagoAuto(Boolean mostraridPagoAuto) {
		this.mostraridPagoAuto= mostraridPagoAuto;
	}

	public Boolean getActivaridPagoAuto() {
		return this.activaridPagoAuto;
	}

	public void setActivaridPagoAuto(Boolean activaridPagoAuto) {
		this.activaridPagoAuto= activaridPagoAuto;
	}

	public Border setResaltarid_empresaPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_empresaPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPagoAuto() {
		return this.resaltarid_empresaPagoAuto;
	}

	public void setResaltarid_empresaPagoAuto(Border borderResaltar) {
		this.resaltarid_empresaPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_empresaPagoAuto() {
		return this.mostrarid_empresaPagoAuto;
	}

	public void setMostrarid_empresaPagoAuto(Boolean mostrarid_empresaPagoAuto) {
		this.mostrarid_empresaPagoAuto= mostrarid_empresaPagoAuto;
	}

	public Boolean getActivarid_empresaPagoAuto() {
		return this.activarid_empresaPagoAuto;
	}

	public void setActivarid_empresaPagoAuto(Boolean activarid_empresaPagoAuto) {
		this.activarid_empresaPagoAuto= activarid_empresaPagoAuto;
	}

	public Boolean getCargarid_empresaPagoAuto() {
		return this.cargarid_empresaPagoAuto;
	}

	public void setCargarid_empresaPagoAuto(Boolean cargarid_empresaPagoAuto) {
		this.cargarid_empresaPagoAuto= cargarid_empresaPagoAuto;
	}

	public Border setResaltarid_sucursalPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPagoAuto() {
		return this.resaltarid_sucursalPagoAuto;
	}

	public void setResaltarid_sucursalPagoAuto(Border borderResaltar) {
		this.resaltarid_sucursalPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPagoAuto() {
		return this.mostrarid_sucursalPagoAuto;
	}

	public void setMostrarid_sucursalPagoAuto(Boolean mostrarid_sucursalPagoAuto) {
		this.mostrarid_sucursalPagoAuto= mostrarid_sucursalPagoAuto;
	}

	public Boolean getActivarid_sucursalPagoAuto() {
		return this.activarid_sucursalPagoAuto;
	}

	public void setActivarid_sucursalPagoAuto(Boolean activarid_sucursalPagoAuto) {
		this.activarid_sucursalPagoAuto= activarid_sucursalPagoAuto;
	}

	public Boolean getCargarid_sucursalPagoAuto() {
		return this.cargarid_sucursalPagoAuto;
	}

	public void setCargarid_sucursalPagoAuto(Boolean cargarid_sucursalPagoAuto) {
		this.cargarid_sucursalPagoAuto= cargarid_sucursalPagoAuto;
	}

	public Border setResaltarid_ejercicioPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPagoAuto() {
		return this.resaltarid_ejercicioPagoAuto;
	}

	public void setResaltarid_ejercicioPagoAuto(Border borderResaltar) {
		this.resaltarid_ejercicioPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPagoAuto() {
		return this.mostrarid_ejercicioPagoAuto;
	}

	public void setMostrarid_ejercicioPagoAuto(Boolean mostrarid_ejercicioPagoAuto) {
		this.mostrarid_ejercicioPagoAuto= mostrarid_ejercicioPagoAuto;
	}

	public Boolean getActivarid_ejercicioPagoAuto() {
		return this.activarid_ejercicioPagoAuto;
	}

	public void setActivarid_ejercicioPagoAuto(Boolean activarid_ejercicioPagoAuto) {
		this.activarid_ejercicioPagoAuto= activarid_ejercicioPagoAuto;
	}

	public Boolean getCargarid_ejercicioPagoAuto() {
		return this.cargarid_ejercicioPagoAuto;
	}

	public void setCargarid_ejercicioPagoAuto(Boolean cargarid_ejercicioPagoAuto) {
		this.cargarid_ejercicioPagoAuto= cargarid_ejercicioPagoAuto;
	}

	public Border setResaltarid_clientePagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_clientePagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePagoAuto() {
		return this.resaltarid_clientePagoAuto;
	}

	public void setResaltarid_clientePagoAuto(Border borderResaltar) {
		this.resaltarid_clientePagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_clientePagoAuto() {
		return this.mostrarid_clientePagoAuto;
	}

	public void setMostrarid_clientePagoAuto(Boolean mostrarid_clientePagoAuto) {
		this.mostrarid_clientePagoAuto= mostrarid_clientePagoAuto;
	}

	public Boolean getActivarid_clientePagoAuto() {
		return this.activarid_clientePagoAuto;
	}

	public void setActivarid_clientePagoAuto(Boolean activarid_clientePagoAuto) {
		this.activarid_clientePagoAuto= activarid_clientePagoAuto;
	}

	public Boolean getCargarid_clientePagoAuto() {
		return this.cargarid_clientePagoAuto;
	}

	public void setCargarid_clientePagoAuto(Boolean cargarid_clientePagoAuto) {
		this.cargarid_clientePagoAuto= cargarid_clientePagoAuto;
	}

	public Border setResaltarid_asiento_contablePagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contablePagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contablePagoAuto() {
		return this.resaltarid_asiento_contablePagoAuto;
	}

	public void setResaltarid_asiento_contablePagoAuto(Border borderResaltar) {
		this.resaltarid_asiento_contablePagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contablePagoAuto() {
		return this.mostrarid_asiento_contablePagoAuto;
	}

	public void setMostrarid_asiento_contablePagoAuto(Boolean mostrarid_asiento_contablePagoAuto) {
		this.mostrarid_asiento_contablePagoAuto= mostrarid_asiento_contablePagoAuto;
	}

	public Boolean getActivarid_asiento_contablePagoAuto() {
		return this.activarid_asiento_contablePagoAuto;
	}

	public void setActivarid_asiento_contablePagoAuto(Boolean activarid_asiento_contablePagoAuto) {
		this.activarid_asiento_contablePagoAuto= activarid_asiento_contablePagoAuto;
	}

	public Boolean getCargarid_asiento_contablePagoAuto() {
		return this.cargarid_asiento_contablePagoAuto;
	}

	public void setCargarid_asiento_contablePagoAuto(Boolean cargarid_asiento_contablePagoAuto) {
		this.cargarid_asiento_contablePagoAuto= cargarid_asiento_contablePagoAuto;
	}

	public Border setResaltarid_centro_costoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoPagoAuto() {
		return this.resaltarid_centro_costoPagoAuto;
	}

	public void setResaltarid_centro_costoPagoAuto(Border borderResaltar) {
		this.resaltarid_centro_costoPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoPagoAuto() {
		return this.mostrarid_centro_costoPagoAuto;
	}

	public void setMostrarid_centro_costoPagoAuto(Boolean mostrarid_centro_costoPagoAuto) {
		this.mostrarid_centro_costoPagoAuto= mostrarid_centro_costoPagoAuto;
	}

	public Boolean getActivarid_centro_costoPagoAuto() {
		return this.activarid_centro_costoPagoAuto;
	}

	public void setActivarid_centro_costoPagoAuto(Boolean activarid_centro_costoPagoAuto) {
		this.activarid_centro_costoPagoAuto= activarid_centro_costoPagoAuto;
	}

	public Boolean getCargarid_centro_costoPagoAuto() {
		return this.cargarid_centro_costoPagoAuto;
	}

	public void setCargarid_centro_costoPagoAuto(Boolean cargarid_centro_costoPagoAuto) {
		this.cargarid_centro_costoPagoAuto= cargarid_centro_costoPagoAuto;
	}

	public Border setResaltarid_centro_actividadPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_centro_actividadPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_actividadPagoAuto() {
		return this.resaltarid_centro_actividadPagoAuto;
	}

	public void setResaltarid_centro_actividadPagoAuto(Border borderResaltar) {
		this.resaltarid_centro_actividadPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_centro_actividadPagoAuto() {
		return this.mostrarid_centro_actividadPagoAuto;
	}

	public void setMostrarid_centro_actividadPagoAuto(Boolean mostrarid_centro_actividadPagoAuto) {
		this.mostrarid_centro_actividadPagoAuto= mostrarid_centro_actividadPagoAuto;
	}

	public Boolean getActivarid_centro_actividadPagoAuto() {
		return this.activarid_centro_actividadPagoAuto;
	}

	public void setActivarid_centro_actividadPagoAuto(Boolean activarid_centro_actividadPagoAuto) {
		this.activarid_centro_actividadPagoAuto= activarid_centro_actividadPagoAuto;
	}

	public Boolean getCargarid_centro_actividadPagoAuto() {
		return this.cargarid_centro_actividadPagoAuto;
	}

	public void setCargarid_centro_actividadPagoAuto(Boolean cargarid_centro_actividadPagoAuto) {
		this.cargarid_centro_actividadPagoAuto= cargarid_centro_actividadPagoAuto;
	}

	public Border setResaltarid_facturaPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_facturaPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaPagoAuto() {
		return this.resaltarid_facturaPagoAuto;
	}

	public void setResaltarid_facturaPagoAuto(Border borderResaltar) {
		this.resaltarid_facturaPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_facturaPagoAuto() {
		return this.mostrarid_facturaPagoAuto;
	}

	public void setMostrarid_facturaPagoAuto(Boolean mostrarid_facturaPagoAuto) {
		this.mostrarid_facturaPagoAuto= mostrarid_facturaPagoAuto;
	}

	public Boolean getActivarid_facturaPagoAuto() {
		return this.activarid_facturaPagoAuto;
	}

	public void setActivarid_facturaPagoAuto(Boolean activarid_facturaPagoAuto) {
		this.activarid_facturaPagoAuto= activarid_facturaPagoAuto;
	}

	public Boolean getCargarid_facturaPagoAuto() {
		return this.cargarid_facturaPagoAuto;
	}

	public void setCargarid_facturaPagoAuto(Boolean cargarid_facturaPagoAuto) {
		this.cargarid_facturaPagoAuto= cargarid_facturaPagoAuto;
	}

	public Border setResaltarid_detalle_provePagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_detalle_provePagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_provePagoAuto() {
		return this.resaltarid_detalle_provePagoAuto;
	}

	public void setResaltarid_detalle_provePagoAuto(Border borderResaltar) {
		this.resaltarid_detalle_provePagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_detalle_provePagoAuto() {
		return this.mostrarid_detalle_provePagoAuto;
	}

	public void setMostrarid_detalle_provePagoAuto(Boolean mostrarid_detalle_provePagoAuto) {
		this.mostrarid_detalle_provePagoAuto= mostrarid_detalle_provePagoAuto;
	}

	public Boolean getActivarid_detalle_provePagoAuto() {
		return this.activarid_detalle_provePagoAuto;
	}

	public void setActivarid_detalle_provePagoAuto(Boolean activarid_detalle_provePagoAuto) {
		this.activarid_detalle_provePagoAuto= activarid_detalle_provePagoAuto;
	}

	public Boolean getCargarid_detalle_provePagoAuto() {
		return this.cargarid_detalle_provePagoAuto;
	}

	public void setCargarid_detalle_provePagoAuto(Boolean cargarid_detalle_provePagoAuto) {
		this.cargarid_detalle_provePagoAuto= cargarid_detalle_provePagoAuto;
	}

	public Border setResaltarid_cuenta_bancoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_bancoPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_bancoPagoAuto() {
		return this.resaltarid_cuenta_bancoPagoAuto;
	}

	public void setResaltarid_cuenta_bancoPagoAuto(Border borderResaltar) {
		this.resaltarid_cuenta_bancoPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_bancoPagoAuto() {
		return this.mostrarid_cuenta_bancoPagoAuto;
	}

	public void setMostrarid_cuenta_bancoPagoAuto(Boolean mostrarid_cuenta_bancoPagoAuto) {
		this.mostrarid_cuenta_bancoPagoAuto= mostrarid_cuenta_bancoPagoAuto;
	}

	public Boolean getActivarid_cuenta_bancoPagoAuto() {
		return this.activarid_cuenta_bancoPagoAuto;
	}

	public void setActivarid_cuenta_bancoPagoAuto(Boolean activarid_cuenta_bancoPagoAuto) {
		this.activarid_cuenta_bancoPagoAuto= activarid_cuenta_bancoPagoAuto;
	}

	public Boolean getCargarid_cuenta_bancoPagoAuto() {
		return this.cargarid_cuenta_bancoPagoAuto;
	}

	public void setCargarid_cuenta_bancoPagoAuto(Boolean cargarid_cuenta_bancoPagoAuto) {
		this.cargarid_cuenta_bancoPagoAuto= cargarid_cuenta_bancoPagoAuto;
	}

	public Border setResaltarid_transaccionPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_transaccionPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionPagoAuto() {
		return this.resaltarid_transaccionPagoAuto;
	}

	public void setResaltarid_transaccionPagoAuto(Border borderResaltar) {
		this.resaltarid_transaccionPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_transaccionPagoAuto() {
		return this.mostrarid_transaccionPagoAuto;
	}

	public void setMostrarid_transaccionPagoAuto(Boolean mostrarid_transaccionPagoAuto) {
		this.mostrarid_transaccionPagoAuto= mostrarid_transaccionPagoAuto;
	}

	public Boolean getActivarid_transaccionPagoAuto() {
		return this.activarid_transaccionPagoAuto;
	}

	public void setActivarid_transaccionPagoAuto(Boolean activarid_transaccionPagoAuto) {
		this.activarid_transaccionPagoAuto= activarid_transaccionPagoAuto;
	}

	public Boolean getCargarid_transaccionPagoAuto() {
		return this.cargarid_transaccionPagoAuto;
	}

	public void setCargarid_transaccionPagoAuto(Boolean cargarid_transaccionPagoAuto) {
		this.cargarid_transaccionPagoAuto= cargarid_transaccionPagoAuto;
	}

	public Border setResaltarid_estado_pago_autoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarid_estado_pago_autoPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_pago_autoPagoAuto() {
		return this.resaltarid_estado_pago_autoPagoAuto;
	}

	public void setResaltarid_estado_pago_autoPagoAuto(Border borderResaltar) {
		this.resaltarid_estado_pago_autoPagoAuto= borderResaltar;
	}

	public Boolean getMostrarid_estado_pago_autoPagoAuto() {
		return this.mostrarid_estado_pago_autoPagoAuto;
	}

	public void setMostrarid_estado_pago_autoPagoAuto(Boolean mostrarid_estado_pago_autoPagoAuto) {
		this.mostrarid_estado_pago_autoPagoAuto= mostrarid_estado_pago_autoPagoAuto;
	}

	public Boolean getActivarid_estado_pago_autoPagoAuto() {
		return this.activarid_estado_pago_autoPagoAuto;
	}

	public void setActivarid_estado_pago_autoPagoAuto(Boolean activarid_estado_pago_autoPagoAuto) {
		this.activarid_estado_pago_autoPagoAuto= activarid_estado_pago_autoPagoAuto;
	}

	public Boolean getCargarid_estado_pago_autoPagoAuto() {
		return this.cargarid_estado_pago_autoPagoAuto;
	}

	public void setCargarid_estado_pago_autoPagoAuto(Boolean cargarid_estado_pago_autoPagoAuto) {
		this.cargarid_estado_pago_autoPagoAuto= cargarid_estado_pago_autoPagoAuto;
	}

	public Border setResaltarnumero_facturaPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaPagoAuto() {
		return this.resaltarnumero_facturaPagoAuto;
	}

	public void setResaltarnumero_facturaPagoAuto(Border borderResaltar) {
		this.resaltarnumero_facturaPagoAuto= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaPagoAuto() {
		return this.mostrarnumero_facturaPagoAuto;
	}

	public void setMostrarnumero_facturaPagoAuto(Boolean mostrarnumero_facturaPagoAuto) {
		this.mostrarnumero_facturaPagoAuto= mostrarnumero_facturaPagoAuto;
	}

	public Boolean getActivarnumero_facturaPagoAuto() {
		return this.activarnumero_facturaPagoAuto;
	}

	public void setActivarnumero_facturaPagoAuto(Boolean activarnumero_facturaPagoAuto) {
		this.activarnumero_facturaPagoAuto= activarnumero_facturaPagoAuto;
	}

	public Border setResaltarfecha_emisionPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionPagoAuto() {
		return this.resaltarfecha_emisionPagoAuto;
	}

	public void setResaltarfecha_emisionPagoAuto(Border borderResaltar) {
		this.resaltarfecha_emisionPagoAuto= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionPagoAuto() {
		return this.mostrarfecha_emisionPagoAuto;
	}

	public void setMostrarfecha_emisionPagoAuto(Boolean mostrarfecha_emisionPagoAuto) {
		this.mostrarfecha_emisionPagoAuto= mostrarfecha_emisionPagoAuto;
	}

	public Boolean getActivarfecha_emisionPagoAuto() {
		return this.activarfecha_emisionPagoAuto;
	}

	public void setActivarfecha_emisionPagoAuto(Boolean activarfecha_emisionPagoAuto) {
		this.activarfecha_emisionPagoAuto= activarfecha_emisionPagoAuto;
	}

	public Border setResaltarfecha_vencimientoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoPagoAuto() {
		return this.resaltarfecha_vencimientoPagoAuto;
	}

	public void setResaltarfecha_vencimientoPagoAuto(Border borderResaltar) {
		this.resaltarfecha_vencimientoPagoAuto= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoPagoAuto() {
		return this.mostrarfecha_vencimientoPagoAuto;
	}

	public void setMostrarfecha_vencimientoPagoAuto(Boolean mostrarfecha_vencimientoPagoAuto) {
		this.mostrarfecha_vencimientoPagoAuto= mostrarfecha_vencimientoPagoAuto;
	}

	public Boolean getActivarfecha_vencimientoPagoAuto() {
		return this.activarfecha_vencimientoPagoAuto;
	}

	public void setActivarfecha_vencimientoPagoAuto(Boolean activarfecha_vencimientoPagoAuto) {
		this.activarfecha_vencimientoPagoAuto= activarfecha_vencimientoPagoAuto;
	}

	public Border setResaltarfecha_cortePagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarfecha_cortePagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_cortePagoAuto() {
		return this.resaltarfecha_cortePagoAuto;
	}

	public void setResaltarfecha_cortePagoAuto(Border borderResaltar) {
		this.resaltarfecha_cortePagoAuto= borderResaltar;
	}

	public Boolean getMostrarfecha_cortePagoAuto() {
		return this.mostrarfecha_cortePagoAuto;
	}

	public void setMostrarfecha_cortePagoAuto(Boolean mostrarfecha_cortePagoAuto) {
		this.mostrarfecha_cortePagoAuto= mostrarfecha_cortePagoAuto;
	}

	public Boolean getActivarfecha_cortePagoAuto() {
		return this.activarfecha_cortePagoAuto;
	}

	public void setActivarfecha_cortePagoAuto(Boolean activarfecha_cortePagoAuto) {
		this.activarfecha_cortePagoAuto= activarfecha_cortePagoAuto;
	}

	public Border setResaltarvalor_por_pagarPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarvalor_por_pagarPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_por_pagarPagoAuto() {
		return this.resaltarvalor_por_pagarPagoAuto;
	}

	public void setResaltarvalor_por_pagarPagoAuto(Border borderResaltar) {
		this.resaltarvalor_por_pagarPagoAuto= borderResaltar;
	}

	public Boolean getMostrarvalor_por_pagarPagoAuto() {
		return this.mostrarvalor_por_pagarPagoAuto;
	}

	public void setMostrarvalor_por_pagarPagoAuto(Boolean mostrarvalor_por_pagarPagoAuto) {
		this.mostrarvalor_por_pagarPagoAuto= mostrarvalor_por_pagarPagoAuto;
	}

	public Boolean getActivarvalor_por_pagarPagoAuto() {
		return this.activarvalor_por_pagarPagoAuto;
	}

	public void setActivarvalor_por_pagarPagoAuto(Boolean activarvalor_por_pagarPagoAuto) {
		this.activarvalor_por_pagarPagoAuto= activarvalor_por_pagarPagoAuto;
	}

	public Border setResaltarvalor_canceladoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltarvalor_canceladoPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_canceladoPagoAuto() {
		return this.resaltarvalor_canceladoPagoAuto;
	}

	public void setResaltarvalor_canceladoPagoAuto(Border borderResaltar) {
		this.resaltarvalor_canceladoPagoAuto= borderResaltar;
	}

	public Boolean getMostrarvalor_canceladoPagoAuto() {
		return this.mostrarvalor_canceladoPagoAuto;
	}

	public void setMostrarvalor_canceladoPagoAuto(Boolean mostrarvalor_canceladoPagoAuto) {
		this.mostrarvalor_canceladoPagoAuto= mostrarvalor_canceladoPagoAuto;
	}

	public Boolean getActivarvalor_canceladoPagoAuto() {
		return this.activarvalor_canceladoPagoAuto;
	}

	public void setActivarvalor_canceladoPagoAuto(Boolean activarvalor_canceladoPagoAuto) {
		this.activarvalor_canceladoPagoAuto= activarvalor_canceladoPagoAuto;
	}

	public Border setResaltaresta_autorizadoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltaresta_autorizadoPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_autorizadoPagoAuto() {
		return this.resaltaresta_autorizadoPagoAuto;
	}

	public void setResaltaresta_autorizadoPagoAuto(Border borderResaltar) {
		this.resaltaresta_autorizadoPagoAuto= borderResaltar;
	}

	public Boolean getMostraresta_autorizadoPagoAuto() {
		return this.mostraresta_autorizadoPagoAuto;
	}

	public void setMostraresta_autorizadoPagoAuto(Boolean mostraresta_autorizadoPagoAuto) {
		this.mostraresta_autorizadoPagoAuto= mostraresta_autorizadoPagoAuto;
	}

	public Boolean getActivaresta_autorizadoPagoAuto() {
		return this.activaresta_autorizadoPagoAuto;
	}

	public void setActivaresta_autorizadoPagoAuto(Boolean activaresta_autorizadoPagoAuto) {
		this.activaresta_autorizadoPagoAuto= activaresta_autorizadoPagoAuto;
	}

	public Border setResaltardescripcionPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//pagoautoBeanSwingJInternalFrame.jTtoolBarPagoAuto.setBorder(borderResaltar);
		
		this.resaltardescripcionPagoAuto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionPagoAuto() {
		return this.resaltardescripcionPagoAuto;
	}

	public void setResaltardescripcionPagoAuto(Border borderResaltar) {
		this.resaltardescripcionPagoAuto= borderResaltar;
	}

	public Boolean getMostrardescripcionPagoAuto() {
		return this.mostrardescripcionPagoAuto;
	}

	public void setMostrardescripcionPagoAuto(Boolean mostrardescripcionPagoAuto) {
		this.mostrardescripcionPagoAuto= mostrardescripcionPagoAuto;
	}

	public Boolean getActivardescripcionPagoAuto() {
		return this.activardescripcionPagoAuto;
	}

	public void setActivardescripcionPagoAuto(Boolean activardescripcionPagoAuto) {
		this.activardescripcionPagoAuto= activardescripcionPagoAuto;
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
		
		
		this.setMostraridPagoAuto(esInicial);
		this.setMostrarid_empresaPagoAuto(esInicial);
		this.setMostrarid_sucursalPagoAuto(esInicial);
		this.setMostrarid_ejercicioPagoAuto(esInicial);
		this.setMostrarid_clientePagoAuto(esInicial);
		this.setMostrarid_asiento_contablePagoAuto(esInicial);
		this.setMostrarid_centro_costoPagoAuto(esInicial);
		this.setMostrarid_centro_actividadPagoAuto(esInicial);
		this.setMostrarid_facturaPagoAuto(esInicial);
		this.setMostrarid_detalle_provePagoAuto(esInicial);
		this.setMostrarid_cuenta_bancoPagoAuto(esInicial);
		this.setMostrarid_transaccionPagoAuto(esInicial);
		this.setMostrarid_estado_pago_autoPagoAuto(esInicial);
		this.setMostrarnumero_facturaPagoAuto(esInicial);
		this.setMostrarfecha_emisionPagoAuto(esInicial);
		this.setMostrarfecha_vencimientoPagoAuto(esInicial);
		this.setMostrarfecha_cortePagoAuto(esInicial);
		this.setMostrarvalor_por_pagarPagoAuto(esInicial);
		this.setMostrarvalor_canceladoPagoAuto(esInicial);
		this.setMostraresta_autorizadoPagoAuto(esInicial);
		this.setMostrardescripcionPagoAuto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagoAutoConstantesFunciones.ID)) {
				this.setMostraridPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clientePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contablePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setMostrarid_centro_actividadPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDDETALLEPROVE)) {
				this.setMostrarid_detalle_provePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCUENTABANCO)) {
				this.setMostrarid_cuenta_bancoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDESTADOPAGOAUTO)) {
				this.setMostrarid_estado_pago_autoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHACORTE)) {
				this.setMostrarfecha_cortePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.VALORPORPAGAR)) {
				this.setMostrarvalor_por_pagarPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.VALORCANCELADO)) {
				this.setMostrarvalor_canceladoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.ESTAAUTORIZADO)) {
				this.setMostraresta_autorizadoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionPagoAuto(esAsigna);
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
		
		
		this.setActivaridPagoAuto(esInicial);
		this.setActivarid_empresaPagoAuto(esInicial);
		this.setActivarid_sucursalPagoAuto(esInicial);
		this.setActivarid_ejercicioPagoAuto(esInicial);
		this.setActivarid_clientePagoAuto(esInicial);
		this.setActivarid_asiento_contablePagoAuto(esInicial);
		this.setActivarid_centro_costoPagoAuto(esInicial);
		this.setActivarid_centro_actividadPagoAuto(esInicial);
		this.setActivarid_facturaPagoAuto(esInicial);
		this.setActivarid_detalle_provePagoAuto(esInicial);
		this.setActivarid_cuenta_bancoPagoAuto(esInicial);
		this.setActivarid_transaccionPagoAuto(esInicial);
		this.setActivarid_estado_pago_autoPagoAuto(esInicial);
		this.setActivarnumero_facturaPagoAuto(esInicial);
		this.setActivarfecha_emisionPagoAuto(esInicial);
		this.setActivarfecha_vencimientoPagoAuto(esInicial);
		this.setActivarfecha_cortePagoAuto(esInicial);
		this.setActivarvalor_por_pagarPagoAuto(esInicial);
		this.setActivarvalor_canceladoPagoAuto(esInicial);
		this.setActivaresta_autorizadoPagoAuto(esInicial);
		this.setActivardescripcionPagoAuto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagoAutoConstantesFunciones.ID)) {
				this.setActivaridPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clientePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contablePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setActivarid_centro_actividadPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDDETALLEPROVE)) {
				this.setActivarid_detalle_provePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCUENTABANCO)) {
				this.setActivarid_cuenta_bancoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDESTADOPAGOAUTO)) {
				this.setActivarid_estado_pago_autoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHACORTE)) {
				this.setActivarfecha_cortePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.VALORPORPAGAR)) {
				this.setActivarvalor_por_pagarPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.VALORCANCELADO)) {
				this.setActivarvalor_canceladoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.ESTAAUTORIZADO)) {
				this.setActivaresta_autorizadoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionPagoAuto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPagoAuto(esInicial);
		this.setResaltarid_empresaPagoAuto(esInicial);
		this.setResaltarid_sucursalPagoAuto(esInicial);
		this.setResaltarid_ejercicioPagoAuto(esInicial);
		this.setResaltarid_clientePagoAuto(esInicial);
		this.setResaltarid_asiento_contablePagoAuto(esInicial);
		this.setResaltarid_centro_costoPagoAuto(esInicial);
		this.setResaltarid_centro_actividadPagoAuto(esInicial);
		this.setResaltarid_facturaPagoAuto(esInicial);
		this.setResaltarid_detalle_provePagoAuto(esInicial);
		this.setResaltarid_cuenta_bancoPagoAuto(esInicial);
		this.setResaltarid_transaccionPagoAuto(esInicial);
		this.setResaltarid_estado_pago_autoPagoAuto(esInicial);
		this.setResaltarnumero_facturaPagoAuto(esInicial);
		this.setResaltarfecha_emisionPagoAuto(esInicial);
		this.setResaltarfecha_vencimientoPagoAuto(esInicial);
		this.setResaltarfecha_cortePagoAuto(esInicial);
		this.setResaltarvalor_por_pagarPagoAuto(esInicial);
		this.setResaltarvalor_canceladoPagoAuto(esInicial);
		this.setResaltaresta_autorizadoPagoAuto(esInicial);
		this.setResaltardescripcionPagoAuto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PagoAutoConstantesFunciones.ID)) {
				this.setResaltaridPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clientePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contablePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setResaltarid_centro_actividadPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDDETALLEPROVE)) {
				this.setResaltarid_detalle_provePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDCUENTABANCO)) {
				this.setResaltarid_cuenta_bancoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.IDESTADOPAGOAUTO)) {
				this.setResaltarid_estado_pago_autoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.FECHACORTE)) {
				this.setResaltarfecha_cortePagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.VALORPORPAGAR)) {
				this.setResaltarvalor_por_pagarPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.VALORCANCELADO)) {
				this.setResaltarvalor_canceladoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.ESTAAUTORIZADO)) {
				this.setResaltaresta_autorizadoPagoAuto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PagoAutoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionPagoAuto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContablePagoAuto=true;

	public Boolean getMostrarFK_IdAsientoContablePagoAuto() {
		return this.mostrarFK_IdAsientoContablePagoAuto;
	}

	public void setMostrarFK_IdAsientoContablePagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContablePagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroActividadPagoAuto=true;

	public Boolean getMostrarFK_IdCentroActividadPagoAuto() {
		return this.mostrarFK_IdCentroActividadPagoAuto;
	}

	public void setMostrarFK_IdCentroActividadPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroActividadPagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoPagoAuto=true;

	public Boolean getMostrarFK_IdCentroCostoPagoAuto() {
		return this.mostrarFK_IdCentroCostoPagoAuto;
	}

	public void setMostrarFK_IdCentroCostoPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoPagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClientePagoAuto=true;

	public Boolean getMostrarFK_IdClientePagoAuto() {
		return this.mostrarFK_IdClientePagoAuto;
	}

	public void setMostrarFK_IdClientePagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaBancoPagoAuto=true;

	public Boolean getMostrarFK_IdCuentaBancoPagoAuto() {
		return this.mostrarFK_IdCuentaBancoPagoAuto;
	}

	public void setMostrarFK_IdCuentaBancoPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaBancoPagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleProvePagoAuto=true;

	public Boolean getMostrarFK_IdDetalleProvePagoAuto() {
		return this.mostrarFK_IdDetalleProvePagoAuto;
	}

	public void setMostrarFK_IdDetalleProvePagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleProvePagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioPagoAuto=true;

	public Boolean getMostrarFK_IdEjercicioPagoAuto() {
		return this.mostrarFK_IdEjercicioPagoAuto;
	}

	public void setMostrarFK_IdEjercicioPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPagoAuto=true;

	public Boolean getMostrarFK_IdEmpresaPagoAuto() {
		return this.mostrarFK_IdEmpresaPagoAuto;
	}

	public void setMostrarFK_IdEmpresaPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPagoAutoPagoAuto=true;

	public Boolean getMostrarFK_IdEstadoPagoAutoPagoAuto() {
		return this.mostrarFK_IdEstadoPagoAutoPagoAuto;
	}

	public void setMostrarFK_IdEstadoPagoAutoPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPagoAutoPagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaPagoAuto=true;

	public Boolean getMostrarFK_IdFacturaPagoAuto() {
		return this.mostrarFK_IdFacturaPagoAuto;
	}

	public void setMostrarFK_IdFacturaPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaPagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPagoAuto=true;

	public Boolean getMostrarFK_IdSucursalPagoAuto() {
		return this.mostrarFK_IdSucursalPagoAuto;
	}

	public void setMostrarFK_IdSucursalPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPagoAuto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionPagoAuto=true;

	public Boolean getMostrarFK_IdTransaccionPagoAuto() {
		return this.mostrarFK_IdTransaccionPagoAuto;
	}

	public void setMostrarFK_IdTransaccionPagoAuto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionPagoAuto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContablePagoAuto=true;

	public Boolean getActivarFK_IdAsientoContablePagoAuto() {
		return this.activarFK_IdAsientoContablePagoAuto;
	}

	public void setActivarFK_IdAsientoContablePagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContablePagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroActividadPagoAuto=true;

	public Boolean getActivarFK_IdCentroActividadPagoAuto() {
		return this.activarFK_IdCentroActividadPagoAuto;
	}

	public void setActivarFK_IdCentroActividadPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdCentroActividadPagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoPagoAuto=true;

	public Boolean getActivarFK_IdCentroCostoPagoAuto() {
		return this.activarFK_IdCentroCostoPagoAuto;
	}

	public void setActivarFK_IdCentroCostoPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoPagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdClientePagoAuto=true;

	public Boolean getActivarFK_IdClientePagoAuto() {
		return this.activarFK_IdClientePagoAuto;
	}

	public void setActivarFK_IdClientePagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdClientePagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaBancoPagoAuto=true;

	public Boolean getActivarFK_IdCuentaBancoPagoAuto() {
		return this.activarFK_IdCuentaBancoPagoAuto;
	}

	public void setActivarFK_IdCuentaBancoPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaBancoPagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleProvePagoAuto=true;

	public Boolean getActivarFK_IdDetalleProvePagoAuto() {
		return this.activarFK_IdDetalleProvePagoAuto;
	}

	public void setActivarFK_IdDetalleProvePagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleProvePagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioPagoAuto=true;

	public Boolean getActivarFK_IdEjercicioPagoAuto() {
		return this.activarFK_IdEjercicioPagoAuto;
	}

	public void setActivarFK_IdEjercicioPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPagoAuto=true;

	public Boolean getActivarFK_IdEmpresaPagoAuto() {
		return this.activarFK_IdEmpresaPagoAuto;
	}

	public void setActivarFK_IdEmpresaPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPagoAutoPagoAuto=true;

	public Boolean getActivarFK_IdEstadoPagoAutoPagoAuto() {
		return this.activarFK_IdEstadoPagoAutoPagoAuto;
	}

	public void setActivarFK_IdEstadoPagoAutoPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPagoAutoPagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaPagoAuto=true;

	public Boolean getActivarFK_IdFacturaPagoAuto() {
		return this.activarFK_IdFacturaPagoAuto;
	}

	public void setActivarFK_IdFacturaPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaPagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPagoAuto=true;

	public Boolean getActivarFK_IdSucursalPagoAuto() {
		return this.activarFK_IdSucursalPagoAuto;
	}

	public void setActivarFK_IdSucursalPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPagoAuto= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionPagoAuto=true;

	public Boolean getActivarFK_IdTransaccionPagoAuto() {
		return this.activarFK_IdTransaccionPagoAuto;
	}

	public void setActivarFK_IdTransaccionPagoAuto(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionPagoAuto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContablePagoAuto=null;

	public Border getResaltarFK_IdAsientoContablePagoAuto() {
		return this.resaltarFK_IdAsientoContablePagoAuto;
	}

	public void setResaltarFK_IdAsientoContablePagoAuto(Border borderResaltar) {
		this.resaltarFK_IdAsientoContablePagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContablePagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContablePagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdCentroActividadPagoAuto=null;

	public Border getResaltarFK_IdCentroActividadPagoAuto() {
		return this.resaltarFK_IdCentroActividadPagoAuto;
	}

	public void setResaltarFK_IdCentroActividadPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdCentroActividadPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdCentroActividadPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroActividadPagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoPagoAuto=null;

	public Border getResaltarFK_IdCentroCostoPagoAuto() {
		return this.resaltarFK_IdCentroCostoPagoAuto;
	}

	public void setResaltarFK_IdCentroCostoPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoPagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdClientePagoAuto=null;

	public Border getResaltarFK_IdClientePagoAuto() {
		return this.resaltarFK_IdClientePagoAuto;
	}

	public void setResaltarFK_IdClientePagoAuto(Border borderResaltar) {
		this.resaltarFK_IdClientePagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdClientePagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaBancoPagoAuto=null;

	public Border getResaltarFK_IdCuentaBancoPagoAuto() {
		return this.resaltarFK_IdCuentaBancoPagoAuto;
	}

	public void setResaltarFK_IdCuentaBancoPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdCuentaBancoPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaBancoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaBancoPagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdDetalleProvePagoAuto=null;

	public Border getResaltarFK_IdDetalleProvePagoAuto() {
		return this.resaltarFK_IdDetalleProvePagoAuto;
	}

	public void setResaltarFK_IdDetalleProvePagoAuto(Border borderResaltar) {
		this.resaltarFK_IdDetalleProvePagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdDetalleProvePagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleProvePagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioPagoAuto=null;

	public Border getResaltarFK_IdEjercicioPagoAuto() {
		return this.resaltarFK_IdEjercicioPagoAuto;
	}

	public void setResaltarFK_IdEjercicioPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPagoAuto=null;

	public Border getResaltarFK_IdEmpresaPagoAuto() {
		return this.resaltarFK_IdEmpresaPagoAuto;
	}

	public void setResaltarFK_IdEmpresaPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPagoAutoPagoAuto=null;

	public Border getResaltarFK_IdEstadoPagoAutoPagoAuto() {
		return this.resaltarFK_IdEstadoPagoAutoPagoAuto;
	}

	public void setResaltarFK_IdEstadoPagoAutoPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdEstadoPagoAutoPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPagoAutoPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPagoAutoPagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdFacturaPagoAuto=null;

	public Border getResaltarFK_IdFacturaPagoAuto() {
		return this.resaltarFK_IdFacturaPagoAuto;
	}

	public void setResaltarFK_IdFacturaPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdFacturaPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdFacturaPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaPagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPagoAuto=null;

	public Border getResaltarFK_IdSucursalPagoAuto() {
		return this.resaltarFK_IdSucursalPagoAuto;
	}

	public void setResaltarFK_IdSucursalPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdSucursalPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPagoAuto= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionPagoAuto=null;

	public Border getResaltarFK_IdTransaccionPagoAuto() {
		return this.resaltarFK_IdTransaccionPagoAuto;
	}

	public void setResaltarFK_IdTransaccionPagoAuto(Border borderResaltar) {
		this.resaltarFK_IdTransaccionPagoAuto= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionPagoAuto(ParametroGeneralUsuario parametroGeneralUsuario/*PagoAutoBeanSwingJInternalFrame pagoautoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionPagoAuto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}