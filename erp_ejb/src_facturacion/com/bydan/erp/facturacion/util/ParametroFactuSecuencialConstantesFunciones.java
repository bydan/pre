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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.ParametroFactuSecuencialConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroFactuSecuencialParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroFactuSecuencialParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroFactuSecuencialConstantesFunciones extends ParametroFactuSecuencialConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroFactuSecuencial";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroFactuSecuencial"+ParametroFactuSecuencialConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroFactuSecuencialHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroFactuSecuencialHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroFactuSecuencialConstantesFunciones.SCHEMA+"_"+ParametroFactuSecuencialConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuSecuencialHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroFactuSecuencialConstantesFunciones.SCHEMA+"_"+ParametroFactuSecuencialConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroFactuSecuencialConstantesFunciones.SCHEMA+"_"+ParametroFactuSecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroFactuSecuencialHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroFactuSecuencialConstantesFunciones.SCHEMA+"_"+ParametroFactuSecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuSecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuSecuencialHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuSecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuSecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroFactuSecuencialHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroFactuSecuencialConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroFactuSecuencialConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroFactuSecuencialConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroFactuSecuencialConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroFactuSecuencialConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Secuencial s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Secuencial ";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Factu Secuencial";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroFactuSecuencial";
	public static final String OBJECTNAME="parametrofactusecuencial";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="parametro_factu_secuencial";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrofactusecuencial from "+ParametroFactuSecuencialConstantesFunciones.SPERSISTENCENAME+" parametrofactusecuencial";
	public static String QUERYSELECTNATIVE="select "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".version_row,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_empresa,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_tipo_documento_general,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".secuencial,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_digitos,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_items,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_descuento,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_adiicionales,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_digito_inicio,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_digito_fin,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".numero_dias_plazo,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".con_detalle,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".con_lector,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_bodega,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_tipo_param_factu_plazo,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_formato,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".con_transferencia,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_bodega_transferencia,"+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME+".id_transaccion_transferencia from "+ParametroFactuSecuencialConstantesFunciones.SCHEMA+"."+ParametroFactuSecuencialConstantesFunciones.TABLENAME;//+" as "+ParametroFactuSecuencialConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroFactuSecuencialConstantesFuncionesAdditional parametrofactusecuencialConstantesFuncionesAdditional=null;
	
	public ParametroFactuSecuencialConstantesFuncionesAdditional getParametroFactuSecuencialConstantesFuncionesAdditional() {
		return this.parametrofactusecuencialConstantesFuncionesAdditional;
	}
	
	public void setParametroFactuSecuencialConstantesFuncionesAdditional(ParametroFactuSecuencialConstantesFuncionesAdditional parametrofactusecuencialConstantesFuncionesAdditional) {
		try {
			this.parametrofactusecuencialConstantesFuncionesAdditional=parametrofactusecuencialConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPODOCUMENTOGENERAL= "id_tipo_documento_general";
    public static final String SECUENCIAL= "secuencial";
    public static final String NUMERODIGITOS= "numero_digitos";
    public static final String NUMEROITEMS= "numero_items";
    public static final String NUMERODESCUENTO= "numero_descuento";
    public static final String NUMEROADIICIONALES= "numero_adiicionales";
    public static final String NUMERODIGITOINICIO= "numero_digito_inicio";
    public static final String NUMERODIGITOFIN= "numero_digito_fin";
    public static final String NUMERODIASPLAZO= "numero_dias_plazo";
    public static final String CONDETALLE= "con_detalle";
    public static final String CONLECTOR= "con_lector";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDTIPOPARAMFACTUPLAZO= "id_tipo_param_factu_plazo";
    public static final String IDFORMATO= "id_formato";
    public static final String CONTRANSFERENCIA= "con_transferencia";
    public static final String IDBODEGATRANSFERENCIA= "id_bodega_transferencia";
    public static final String IDTRANSACCIONTRANSFERENCIA= "id_transaccion_transferencia";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPODOCUMENTOGENERAL= "T. Documento General";
		public static final String LABEL_IDTIPODOCUMENTOGENERAL_LOWER= "Tipo Documento General";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_NUMERODIGITOS= "No Digitos";
		public static final String LABEL_NUMERODIGITOS_LOWER= "Numero Digitos";
    	public static final String LABEL_NUMEROITEMS= "No Items";
		public static final String LABEL_NUMEROITEMS_LOWER= "Numero Items";
    	public static final String LABEL_NUMERODESCUENTO= "No Descuento";
		public static final String LABEL_NUMERODESCUENTO_LOWER= "Numero Descuento";
    	public static final String LABEL_NUMEROADIICIONALES= "No Adiicionales";
		public static final String LABEL_NUMEROADIICIONALES_LOWER= "Numero Adiicionales";
    	public static final String LABEL_NUMERODIGITOINICIO= "No Digito Inicio";
		public static final String LABEL_NUMERODIGITOINICIO_LOWER= "Numero Digito Inicio";
    	public static final String LABEL_NUMERODIGITOFIN= "No Digito Fin";
		public static final String LABEL_NUMERODIGITOFIN_LOWER= "Numero Digito Fin";
    	public static final String LABEL_NUMERODIASPLAZO= "No Dias Plazo";
		public static final String LABEL_NUMERODIASPLAZO_LOWER= "Numero Dias Plazo";
    	public static final String LABEL_CONDETALLE= "Detalle";
		public static final String LABEL_CONDETALLE_LOWER= "Con Detalle";
    	public static final String LABEL_CONLECTOR= "Lector";
		public static final String LABEL_CONLECTOR_LOWER= "Con Lector";
    	public static final String LABEL_IDBODEGA= "Bodega Defecto";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDTIPOPARAMFACTUPLAZO= "T. Parametro Plazo";
		public static final String LABEL_IDTIPOPARAMFACTUPLAZO_LOWER= "Tipo Param Factu Plazo";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_CONTRANSFERENCIA= "Transferencia";
		public static final String LABEL_CONTRANSFERENCIA_LOWER= "Con Transferencia";
    	public static final String LABEL_IDBODEGATRANSFERENCIA= "Bodega Transferencia";
		public static final String LABEL_IDBODEGATRANSFERENCIA_LOWER= "Bodega Transferencia";
    	public static final String LABEL_IDTRANSACCIONTRANSFERENCIA= "Transaccion Transferencia";
		public static final String LABEL_IDTRANSACCIONTRANSFERENCIA_LOWER= "Transaccion Transferencia";
	
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroFactuSecuencialLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.SECUENCIAL)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOS;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROITEMS;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODESCUENTO;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROADIICIONALES;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOINICIO;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOFIN;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIASPLAZO;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.CONDETALLE)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_CONDETALLE;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.CONLECTOR)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_CONLECTOR;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.IDBODEGA)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPOPARAMFACTUPLAZO;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.IDFORMATO)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_CONTRANSFERENCIA;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGATRANSFERENCIA;}
		if(sNombreColumna.equals(ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA)) {sLabelColumna=ParametroFactuSecuencialConstantesFunciones.LABEL_IDTRANSACCIONTRANSFERENCIA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_detalleDescripcion(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactusecuencial.getcon_detalle()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_detalleHtmlDescripcion(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactusecuencial.getId(),parametrofactusecuencial.getcon_detalle());

		return sDescripcion;
	}	
		
	public static String getcon_lectorDescripcion(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactusecuencial.getcon_lector()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_lectorHtmlDescripcion(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactusecuencial.getId(),parametrofactusecuencial.getcon_lector());

		return sDescripcion;
	}	
			
			
			
		
	public static String getcon_transferenciaDescripcion(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametrofactusecuencial.getcon_transferencia()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_transferenciaHtmlDescripcion(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametrofactusecuencial.getId(),parametrofactusecuencial.getcon_transferencia());

		return sDescripcion;
	}	
			
			
	
	public static String getParametroFactuSecuencialDescripcion(ParametroFactuSecuencial parametrofactusecuencial) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrofactusecuencial !=null/* && parametrofactusecuencial.getId()!=0*/) {
			if(parametrofactusecuencial.getId()!=null) {
				sDescripcion=parametrofactusecuencial.getId().toString();
			}//parametrofactusecuencialparametrofactusecuencial.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroFactuSecuencialDescripcionDetallado(ParametroFactuSecuencial parametrofactusecuencial) {
		String sDescripcion="";
			
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.ID+"=";
		sDescripcion+=parametrofactusecuencial.getId().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrofactusecuencial.getVersionRow().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrofactusecuencial.getid_empresa().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrofactusecuencial.getid_sucursal().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL+"=";
		sDescripcion+=parametrofactusecuencial.getid_tipo_documento_general().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=parametrofactusecuencial.getsecuencial()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS+"=";
		sDescripcion+=parametrofactusecuencial.getnumero_digitos().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS+"=";
		sDescripcion+=parametrofactusecuencial.getnumero_items().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO+"=";
		sDescripcion+=parametrofactusecuencial.getnumero_descuento().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES+"=";
		sDescripcion+=parametrofactusecuencial.getnumero_adiicionales().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO+"=";
		sDescripcion+=parametrofactusecuencial.getnumero_digito_inicio().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN+"=";
		sDescripcion+=parametrofactusecuencial.getnumero_digito_fin().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO+"=";
		sDescripcion+=parametrofactusecuencial.getnumero_dias_plazo().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.CONDETALLE+"=";
		sDescripcion+=parametrofactusecuencial.getcon_detalle().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.CONLECTOR+"=";
		sDescripcion+=parametrofactusecuencial.getcon_lector().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=parametrofactusecuencial.getid_bodega().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO+"=";
		sDescripcion+=parametrofactusecuencial.getid_tipo_param_factu_plazo().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=parametrofactusecuencial.getid_formato().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA+"=";
		sDescripcion+=parametrofactusecuencial.getcon_transferencia().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA+"=";
		sDescripcion+=parametrofactusecuencial.getid_bodega_transferencia().toString()+",";
		sDescripcion+=ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA+"=";
		sDescripcion+=parametrofactusecuencial.getid_transaccion_transferencia().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroFactuSecuencialDescripcion(ParametroFactuSecuencial parametrofactusecuencial,String sValor) throws Exception {			
		if(parametrofactusecuencial !=null) {
			//parametrofactusecuencialparametrofactusecuencial.getId().toString();
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

	public static String getTipoDocumentoGeneralDescripcion(TipoDocumentoGeneral tipodocumentogeneral) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumentogeneral!=null/*&&tipodocumentogeneral.getId()>0*/) {
			sDescripcion=TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(tipodocumentogeneral);
		}

		return sDescripcion;
	}

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getTipoParamFactuPlazoDescripcion(TipoParamFactuPlazo tipoparamfactuplazo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoparamfactuplazo!=null/*&&tipoparamfactuplazo.getId()>0*/) {
			sDescripcion=TipoParamFactuPlazoConstantesFunciones.getTipoParamFactuPlazoDescripcion(tipoparamfactuplazo);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getBodegaTransferenciaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getTransaccionTransferenciaDescripcion(Transaccion transaccion) {
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
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega Defecto";
		} else if(sNombreIndice.equals("FK_IdBodegaTransferencia")) {
			sNombreIndice="Tipo=  Por Bodega Transferencia";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumentoGeneral")) {
			sNombreIndice="Tipo=  Por T. Documento General";
		} else if(sNombreIndice.equals("FK_IdTipoParamFactuPlazo")) {
			sNombreIndice="Tipo=  Por T. Parametro Plazo";
		} else if(sNombreIndice.equals("FK_IdTransaccionTransferencia")) {
			sNombreIndice="Tipo=  Por Transaccion Transferencia";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega Defecto="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodegaTransferencia(Long id_bodega_transferencia) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega_transferencia!=null) {sDetalleIndice+=" Codigo Unico De Bodega Transferencia="+id_bodega_transferencia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumentoGeneral(Long id_tipo_documento_general) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento_general!=null) {sDetalleIndice+=" Codigo Unico De T. Documento General="+id_tipo_documento_general.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoParamFactuPlazo(Long id_tipo_param_factu_plazo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_param_factu_plazo!=null) {sDetalleIndice+=" Codigo Unico De T. Parametro Plazo="+id_tipo_param_factu_plazo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionTransferencia(Long id_transaccion_transferencia) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_transferencia!=null) {sDetalleIndice+=" Codigo Unico De Transaccion Transferencia="+id_transaccion_transferencia.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroFactuSecuencial(ParametroFactuSecuencial parametrofactusecuencial,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		parametrofactusecuencial.setsecuencial(parametrofactusecuencial.getsecuencial().trim());
	}
	
	public static void quitarEspaciosParametroFactuSecuencials(List<ParametroFactuSecuencial> parametrofactusecuencials,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroFactuSecuencial parametrofactusecuencial: parametrofactusecuencials) {
			parametrofactusecuencial.setsecuencial(parametrofactusecuencial.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactuSecuencial(ParametroFactuSecuencial parametrofactusecuencial,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrofactusecuencial.getConCambioAuxiliar()) {
			parametrofactusecuencial.setIsDeleted(parametrofactusecuencial.getIsDeletedAuxiliar());	
			parametrofactusecuencial.setIsNew(parametrofactusecuencial.getIsNewAuxiliar());	
			parametrofactusecuencial.setIsChanged(parametrofactusecuencial.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrofactusecuencial.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrofactusecuencial.setIsDeletedAuxiliar(false);	
			parametrofactusecuencial.setIsNewAuxiliar(false);	
			parametrofactusecuencial.setIsChangedAuxiliar(false);
			
			parametrofactusecuencial.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroFactuSecuencials(List<ParametroFactuSecuencial> parametrofactusecuencials,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroFactuSecuencial parametrofactusecuencial : parametrofactusecuencials) {
			if(conAsignarBase && parametrofactusecuencial.getConCambioAuxiliar()) {
				parametrofactusecuencial.setIsDeleted(parametrofactusecuencial.getIsDeletedAuxiliar());	
				parametrofactusecuencial.setIsNew(parametrofactusecuencial.getIsNewAuxiliar());	
				parametrofactusecuencial.setIsChanged(parametrofactusecuencial.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrofactusecuencial.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrofactusecuencial.setIsDeletedAuxiliar(false);	
				parametrofactusecuencial.setIsNewAuxiliar(false);	
				parametrofactusecuencial.setIsChangedAuxiliar(false);
				
				parametrofactusecuencial.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroFactuSecuencial(ParametroFactuSecuencial parametrofactusecuencial,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametrofactusecuencial.setnumero_digitos(0);
			parametrofactusecuencial.setnumero_items(0);
			parametrofactusecuencial.setnumero_descuento(0);
			parametrofactusecuencial.setnumero_adiicionales(0);
			parametrofactusecuencial.setnumero_digito_inicio(0);
			parametrofactusecuencial.setnumero_digito_fin(0);
			parametrofactusecuencial.setnumero_dias_plazo(0);
		}
	}		
	
	public static void InicializarValoresParametroFactuSecuencials(List<ParametroFactuSecuencial> parametrofactusecuencials,Boolean conEnteros) throws Exception  {
		
		for(ParametroFactuSecuencial parametrofactusecuencial: parametrofactusecuencials) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametrofactusecuencial.setnumero_digitos(0);
				parametrofactusecuencial.setnumero_items(0);
				parametrofactusecuencial.setnumero_descuento(0);
				parametrofactusecuencial.setnumero_adiicionales(0);
				parametrofactusecuencial.setnumero_digito_inicio(0);
				parametrofactusecuencial.setnumero_digito_fin(0);
				parametrofactusecuencial.setnumero_dias_plazo(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroFactuSecuencial(List<ParametroFactuSecuencial> parametrofactusecuencials,ParametroFactuSecuencial parametrofactusecuencialAux) throws Exception  {
		ParametroFactuSecuencialConstantesFunciones.InicializarValoresParametroFactuSecuencial(parametrofactusecuencialAux,true);
		
		for(ParametroFactuSecuencial parametrofactusecuencial: parametrofactusecuencials) {
			if(parametrofactusecuencial.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrofactusecuencialAux.setnumero_digitos(parametrofactusecuencialAux.getnumero_digitos()+parametrofactusecuencial.getnumero_digitos());			
			parametrofactusecuencialAux.setnumero_items(parametrofactusecuencialAux.getnumero_items()+parametrofactusecuencial.getnumero_items());			
			parametrofactusecuencialAux.setnumero_descuento(parametrofactusecuencialAux.getnumero_descuento()+parametrofactusecuencial.getnumero_descuento());			
			parametrofactusecuencialAux.setnumero_adiicionales(parametrofactusecuencialAux.getnumero_adiicionales()+parametrofactusecuencial.getnumero_adiicionales());			
			parametrofactusecuencialAux.setnumero_digito_inicio(parametrofactusecuencialAux.getnumero_digito_inicio()+parametrofactusecuencial.getnumero_digito_inicio());			
			parametrofactusecuencialAux.setnumero_digito_fin(parametrofactusecuencialAux.getnumero_digito_fin()+parametrofactusecuencial.getnumero_digito_fin());			
			parametrofactusecuencialAux.setnumero_dias_plazo(parametrofactusecuencialAux.getnumero_dias_plazo()+parametrofactusecuencial.getnumero_dias_plazo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactuSecuencial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroFactuSecuencialConstantesFunciones.getArrayColumnasGlobalesParametroFactuSecuencial(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroFactuSecuencial(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuSecuencialConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuSecuencialConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroFactuSecuencial(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroFactuSecuencial> parametrofactusecuencials,ParametroFactuSecuencial parametrofactusecuencial,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroFactuSecuencial parametrofactusecuencialAux: parametrofactusecuencials) {
			if(parametrofactusecuencialAux!=null && parametrofactusecuencial!=null) {
				if((parametrofactusecuencialAux.getId()==null && parametrofactusecuencial.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrofactusecuencialAux.getId()!=null && parametrofactusecuencial.getId()!=null){
					if(parametrofactusecuencialAux.getId().equals(parametrofactusecuencial.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroFactuSecuencial(List<ParametroFactuSecuencial> parametrofactusecuencials) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroFactuSecuencial parametrofactusecuencial: parametrofactusecuencials) {			
			if(parametrofactusecuencial.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroFactuSecuencial() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_ID, ParametroFactuSecuencialConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_VERSIONROW, ParametroFactuSecuencialConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_IDEMPRESA, ParametroFactuSecuencialConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_IDSUCURSAL, ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL, ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_SECUENCIAL, ParametroFactuSecuencialConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOS, ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROITEMS, ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODESCUENTO, ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROADIICIONALES, ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOINICIO, ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOFIN, ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIASPLAZO, ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_CONDETALLE, ParametroFactuSecuencialConstantesFunciones.CONDETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_CONLECTOR, ParametroFactuSecuencialConstantesFunciones.CONLECTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGA, ParametroFactuSecuencialConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPOPARAMFACTUPLAZO, ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_IDFORMATO, ParametroFactuSecuencialConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_CONTRANSFERENCIA, ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGATRANSFERENCIA, ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroFactuSecuencialConstantesFunciones.LABEL_IDTRANSACCIONTRANSFERENCIA, ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroFactuSecuencial() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.CONDETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.CONLECTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuSecuencial() throws Exception  {
		return ParametroFactuSecuencialConstantesFunciones.getTiposSeleccionarParametroFactuSecuencial(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuSecuencial(Boolean conFk) throws Exception  {
		return ParametroFactuSecuencialConstantesFunciones.getTiposSeleccionarParametroFactuSecuencial(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroFactuSecuencial(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOS);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROITEMS);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROITEMS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODESCUENTO);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROADIICIONALES);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROADIICIONALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOINICIO);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOFIN);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIASPLAZO);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIASPLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_CONDETALLE);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_CONDETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_CONLECTOR);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_CONLECTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPOPARAMFACTUPLAZO);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPOPARAMFACTUPLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_CONTRANSFERENCIA);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_CONTRANSFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGATRANSFERENCIA);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGATRANSFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTRANSACCIONTRANSFERENCIA);
			reporte.setsDescripcion(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTRANSACCIONTRANSFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroFactuSecuencial(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactuSecuencial(ParametroFactuSecuencial parametrofactusecuencialAux) throws Exception {
		
			parametrofactusecuencialAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactusecuencialAux.getEmpresa()));
			parametrofactusecuencialAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactusecuencialAux.getSucursal()));
			parametrofactusecuencialAux.settipodocumentogeneral_descripcion(TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(parametrofactusecuencialAux.getTipoDocumentoGeneral()));
			parametrofactusecuencialAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactusecuencialAux.getBodega()));
			parametrofactusecuencialAux.settipoparamfactuplazo_descripcion(TipoParamFactuPlazoConstantesFunciones.getTipoParamFactuPlazoDescripcion(parametrofactusecuencialAux.getTipoParamFactuPlazo()));
			parametrofactusecuencialAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactusecuencialAux.getFormato()));
			parametrofactusecuencialAux.setbodegatransferencia_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactusecuencialAux.getBodegaTransferencia()));
			parametrofactusecuencialAux.settransacciontransferencia_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactusecuencialAux.getTransaccionTransferencia()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroFactuSecuencial(List<ParametroFactuSecuencial> parametrofactusecuencialsTemp) throws Exception {
		for(ParametroFactuSecuencial parametrofactusecuencialAux:parametrofactusecuencialsTemp) {
			
			parametrofactusecuencialAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrofactusecuencialAux.getEmpresa()));
			parametrofactusecuencialAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrofactusecuencialAux.getSucursal()));
			parametrofactusecuencialAux.settipodocumentogeneral_descripcion(TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralDescripcion(parametrofactusecuencialAux.getTipoDocumentoGeneral()));
			parametrofactusecuencialAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactusecuencialAux.getBodega()));
			parametrofactusecuencialAux.settipoparamfactuplazo_descripcion(TipoParamFactuPlazoConstantesFunciones.getTipoParamFactuPlazoDescripcion(parametrofactusecuencialAux.getTipoParamFactuPlazo()));
			parametrofactusecuencialAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(parametrofactusecuencialAux.getFormato()));
			parametrofactusecuencialAux.setbodegatransferencia_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(parametrofactusecuencialAux.getBodegaTransferencia()));
			parametrofactusecuencialAux.settransacciontransferencia_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(parametrofactusecuencialAux.getTransaccionTransferencia()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFactuSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoDocumentoGeneral.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(TipoParamFactuPlazo.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Bodega.class));
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
					if(clas.clas.equals(TipoDocumentoGeneral.class)) {
						classes.add(new Classe(TipoDocumentoGeneral.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoParamFactuPlazo.class)) {
						classes.add(new Classe(TipoParamFactuPlazo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroFactuSecuencial(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoDocumentoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumentoGeneral.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(TipoParamFactuPlazo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParamFactuPlazo.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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

					if(TipoDocumentoGeneral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumentoGeneral.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(TipoParamFactuPlazo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoParamFactuPlazo.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuSecuencialConstantesFunciones.getClassesRelationshipsOfParametroFactuSecuencial(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFactuSecuencial(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactuSecuencial(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroFactuSecuencialConstantesFunciones.getClassesRelationshipsFromStringsOfParametroFactuSecuencial(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroFactuSecuencial(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroFactuSecuencial parametrofactusecuencial,List<ParametroFactuSecuencial> parametrofactusecuencials,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroFactuSecuencial parametrofactusecuencialEncontrado=null;
			
			for(ParametroFactuSecuencial parametrofactusecuencialLocal:parametrofactusecuencials) {
				if(parametrofactusecuencialLocal.getId().equals(parametrofactusecuencial.getId())) {
					parametrofactusecuencialEncontrado=parametrofactusecuencialLocal;
					
					parametrofactusecuencialLocal.setIsChanged(parametrofactusecuencial.getIsChanged());
					parametrofactusecuencialLocal.setIsNew(parametrofactusecuencial.getIsNew());
					parametrofactusecuencialLocal.setIsDeleted(parametrofactusecuencial.getIsDeleted());
					
					parametrofactusecuencialLocal.setGeneralEntityOriginal(parametrofactusecuencial.getGeneralEntityOriginal());
					
					parametrofactusecuencialLocal.setId(parametrofactusecuencial.getId());	
					parametrofactusecuencialLocal.setVersionRow(parametrofactusecuencial.getVersionRow());	
					parametrofactusecuencialLocal.setid_empresa(parametrofactusecuencial.getid_empresa());	
					parametrofactusecuencialLocal.setid_sucursal(parametrofactusecuencial.getid_sucursal());	
					parametrofactusecuencialLocal.setid_tipo_documento_general(parametrofactusecuencial.getid_tipo_documento_general());	
					parametrofactusecuencialLocal.setsecuencial(parametrofactusecuencial.getsecuencial());	
					parametrofactusecuencialLocal.setnumero_digitos(parametrofactusecuencial.getnumero_digitos());	
					parametrofactusecuencialLocal.setnumero_items(parametrofactusecuencial.getnumero_items());	
					parametrofactusecuencialLocal.setnumero_descuento(parametrofactusecuencial.getnumero_descuento());	
					parametrofactusecuencialLocal.setnumero_adiicionales(parametrofactusecuencial.getnumero_adiicionales());	
					parametrofactusecuencialLocal.setnumero_digito_inicio(parametrofactusecuencial.getnumero_digito_inicio());	
					parametrofactusecuencialLocal.setnumero_digito_fin(parametrofactusecuencial.getnumero_digito_fin());	
					parametrofactusecuencialLocal.setnumero_dias_plazo(parametrofactusecuencial.getnumero_dias_plazo());	
					parametrofactusecuencialLocal.setcon_detalle(parametrofactusecuencial.getcon_detalle());	
					parametrofactusecuencialLocal.setcon_lector(parametrofactusecuencial.getcon_lector());	
					parametrofactusecuencialLocal.setid_bodega(parametrofactusecuencial.getid_bodega());	
					parametrofactusecuencialLocal.setid_tipo_param_factu_plazo(parametrofactusecuencial.getid_tipo_param_factu_plazo());	
					parametrofactusecuencialLocal.setid_formato(parametrofactusecuencial.getid_formato());	
					parametrofactusecuencialLocal.setcon_transferencia(parametrofactusecuencial.getcon_transferencia());	
					parametrofactusecuencialLocal.setid_bodega_transferencia(parametrofactusecuencial.getid_bodega_transferencia());	
					parametrofactusecuencialLocal.setid_transaccion_transferencia(parametrofactusecuencial.getid_transaccion_transferencia());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrofactusecuencial.getIsDeleted()) {
				if(!existe) {
					parametrofactusecuencials.add(parametrofactusecuencial);
				}
			} else {
				if(parametrofactusecuencialEncontrado!=null && permiteQuitar)  {
					parametrofactusecuencials.remove(parametrofactusecuencialEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroFactuSecuencial parametrofactusecuencial,List<ParametroFactuSecuencial> parametrofactusecuencials) throws Exception {
		try	{			
			for(ParametroFactuSecuencial parametrofactusecuencialLocal:parametrofactusecuencials) {
				if(parametrofactusecuencialLocal.getId().equals(parametrofactusecuencial.getId())) {
					parametrofactusecuencialLocal.setIsSelected(parametrofactusecuencial.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroFactuSecuencial(List<ParametroFactuSecuencial> parametrofactusecuencialsAux) throws Exception {
		//this.parametrofactusecuencialsAux=parametrofactusecuencialsAux;
		
		for(ParametroFactuSecuencial parametrofactusecuencialAux:parametrofactusecuencialsAux) {
			if(parametrofactusecuencialAux.getIsChanged()) {
				parametrofactusecuencialAux.setIsChanged(false);
			}		
			
			if(parametrofactusecuencialAux.getIsNew()) {
				parametrofactusecuencialAux.setIsNew(false);
			}	
			
			if(parametrofactusecuencialAux.getIsDeleted()) {
				parametrofactusecuencialAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroFactuSecuencial(ParametroFactuSecuencial parametrofactusecuencialAux) throws Exception {
		//this.parametrofactusecuencialAux=parametrofactusecuencialAux;
		
			if(parametrofactusecuencialAux.getIsChanged()) {
				parametrofactusecuencialAux.setIsChanged(false);
			}		
			
			if(parametrofactusecuencialAux.getIsNew()) {
				parametrofactusecuencialAux.setIsNew(false);
			}	
			
			if(parametrofactusecuencialAux.getIsDeleted()) {
				parametrofactusecuencialAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroFactuSecuencial parametrofactusecuencialAsignar,ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		parametrofactusecuencialAsignar.setId(parametrofactusecuencial.getId());	
		parametrofactusecuencialAsignar.setVersionRow(parametrofactusecuencial.getVersionRow());	
		parametrofactusecuencialAsignar.setid_empresa(parametrofactusecuencial.getid_empresa());
		parametrofactusecuencialAsignar.setempresa_descripcion(parametrofactusecuencial.getempresa_descripcion());	
		parametrofactusecuencialAsignar.setid_sucursal(parametrofactusecuencial.getid_sucursal());
		parametrofactusecuencialAsignar.setsucursal_descripcion(parametrofactusecuencial.getsucursal_descripcion());	
		parametrofactusecuencialAsignar.setid_tipo_documento_general(parametrofactusecuencial.getid_tipo_documento_general());
		parametrofactusecuencialAsignar.settipodocumentogeneral_descripcion(parametrofactusecuencial.gettipodocumentogeneral_descripcion());	
		parametrofactusecuencialAsignar.setsecuencial(parametrofactusecuencial.getsecuencial());	
		parametrofactusecuencialAsignar.setnumero_digitos(parametrofactusecuencial.getnumero_digitos());	
		parametrofactusecuencialAsignar.setnumero_items(parametrofactusecuencial.getnumero_items());	
		parametrofactusecuencialAsignar.setnumero_descuento(parametrofactusecuencial.getnumero_descuento());	
		parametrofactusecuencialAsignar.setnumero_adiicionales(parametrofactusecuencial.getnumero_adiicionales());	
		parametrofactusecuencialAsignar.setnumero_digito_inicio(parametrofactusecuencial.getnumero_digito_inicio());	
		parametrofactusecuencialAsignar.setnumero_digito_fin(parametrofactusecuencial.getnumero_digito_fin());	
		parametrofactusecuencialAsignar.setnumero_dias_plazo(parametrofactusecuencial.getnumero_dias_plazo());	
		parametrofactusecuencialAsignar.setcon_detalle(parametrofactusecuencial.getcon_detalle());	
		parametrofactusecuencialAsignar.setcon_lector(parametrofactusecuencial.getcon_lector());	
		parametrofactusecuencialAsignar.setid_bodega(parametrofactusecuencial.getid_bodega());
		parametrofactusecuencialAsignar.setbodega_descripcion(parametrofactusecuencial.getbodega_descripcion());	
		parametrofactusecuencialAsignar.setid_tipo_param_factu_plazo(parametrofactusecuencial.getid_tipo_param_factu_plazo());
		parametrofactusecuencialAsignar.settipoparamfactuplazo_descripcion(parametrofactusecuencial.gettipoparamfactuplazo_descripcion());	
		parametrofactusecuencialAsignar.setid_formato(parametrofactusecuencial.getid_formato());
		parametrofactusecuencialAsignar.setformato_descripcion(parametrofactusecuencial.getformato_descripcion());	
		parametrofactusecuencialAsignar.setcon_transferencia(parametrofactusecuencial.getcon_transferencia());	
		parametrofactusecuencialAsignar.setid_bodega_transferencia(parametrofactusecuencial.getid_bodega_transferencia());
		parametrofactusecuencialAsignar.setbodegatransferencia_descripcion(parametrofactusecuencial.getbodegatransferencia_descripcion());	
		parametrofactusecuencialAsignar.setid_transaccion_transferencia(parametrofactusecuencial.getid_transaccion_transferencia());
		parametrofactusecuencialAsignar.settransacciontransferencia_descripcion(parametrofactusecuencial.gettransacciontransferencia_descripcion());	
	}
	
	public static void inicializarParametroFactuSecuencial(ParametroFactuSecuencial parametrofactusecuencial) throws Exception {
		try {
				parametrofactusecuencial.setId(0L);	
					
				parametrofactusecuencial.setid_empresa(-1L);	
				parametrofactusecuencial.setid_sucursal(-1L);	
				parametrofactusecuencial.setid_tipo_documento_general(-1L);	
				parametrofactusecuencial.setsecuencial("");	
				parametrofactusecuencial.setnumero_digitos(0);	
				parametrofactusecuencial.setnumero_items(0);	
				parametrofactusecuencial.setnumero_descuento(0);	
				parametrofactusecuencial.setnumero_adiicionales(0);	
				parametrofactusecuencial.setnumero_digito_inicio(0);	
				parametrofactusecuencial.setnumero_digito_fin(0);	
				parametrofactusecuencial.setnumero_dias_plazo(0);	
				parametrofactusecuencial.setcon_detalle(false);	
				parametrofactusecuencial.setcon_lector(false);	
				parametrofactusecuencial.setid_bodega(-1L);	
				parametrofactusecuencial.setid_tipo_param_factu_plazo(-1L);	
				parametrofactusecuencial.setid_formato(-1L);	
				parametrofactusecuencial.setcon_transferencia(false);	
				parametrofactusecuencial.setid_bodega_transferencia(-1L);	
				parametrofactusecuencial.setid_transaccion_transferencia(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroFactuSecuencial(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPODOCUMENTOGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROITEMS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMEROADIICIONALES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIGITOFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_NUMERODIASPLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_CONDETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_CONLECTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTIPOPARAMFACTUPLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_CONTRANSFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_IDBODEGATRANSFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroFactuSecuencialConstantesFunciones.LABEL_IDTRANSACCIONTRANSFERENCIA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroFactuSecuencial(String sTipo,Row row,Workbook workbook,ParametroFactuSecuencial parametrofactusecuencial,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.gettipodocumentogeneral_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getnumero_digitos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getnumero_items());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getnumero_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getnumero_adiicionales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getnumero_digito_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getnumero_digito_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getnumero_dias_plazo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactusecuencial.getcon_detalle()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactusecuencial.getcon_lector()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.gettipoparamfactuplazo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametrofactusecuencial.getcon_transferencia()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.getbodegatransferencia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrofactusecuencial.gettransacciontransferencia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroFactuSecuencial=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroFactuSecuencial() {
		return this.sFinalQueryParametroFactuSecuencial;
	}
	
	public void setsFinalQueryParametroFactuSecuencial(String sFinalQueryParametroFactuSecuencial) {
		this.sFinalQueryParametroFactuSecuencial= sFinalQueryParametroFactuSecuencial;
	}
	
	public Border resaltarSeleccionarParametroFactuSecuencial=null;
	
	public Border setResaltarSeleccionarParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroFactuSecuencial= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroFactuSecuencial() {
		return this.resaltarSeleccionarParametroFactuSecuencial;
	}
	
	public void setResaltarSeleccionarParametroFactuSecuencial(Border borderResaltarSeleccionarParametroFactuSecuencial) {
		this.resaltarSeleccionarParametroFactuSecuencial= borderResaltarSeleccionarParametroFactuSecuencial;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroFactuSecuencial=null;
	public Boolean mostraridParametroFactuSecuencial=true;
	public Boolean activaridParametroFactuSecuencial=true;

	public Border resaltarid_empresaParametroFactuSecuencial=null;
	public Boolean mostrarid_empresaParametroFactuSecuencial=true;
	public Boolean activarid_empresaParametroFactuSecuencial=true;
	public Boolean cargarid_empresaParametroFactuSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroFactuSecuencial=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroFactuSecuencial=null;
	public Boolean mostrarid_sucursalParametroFactuSecuencial=true;
	public Boolean activarid_sucursalParametroFactuSecuencial=true;
	public Boolean cargarid_sucursalParametroFactuSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroFactuSecuencial=false;//ConEventDepend=true

	public Border resaltarid_tipo_documento_generalParametroFactuSecuencial=null;
	public Boolean mostrarid_tipo_documento_generalParametroFactuSecuencial=true;
	public Boolean activarid_tipo_documento_generalParametroFactuSecuencial=true;
	public Boolean cargarid_tipo_documento_generalParametroFactuSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documento_generalParametroFactuSecuencial=false;//ConEventDepend=true

	public Border resaltarsecuencialParametroFactuSecuencial=null;
	public Boolean mostrarsecuencialParametroFactuSecuencial=true;
	public Boolean activarsecuencialParametroFactuSecuencial=true;

	public Border resaltarnumero_digitosParametroFactuSecuencial=null;
	public Boolean mostrarnumero_digitosParametroFactuSecuencial=true;
	public Boolean activarnumero_digitosParametroFactuSecuencial=true;

	public Border resaltarnumero_itemsParametroFactuSecuencial=null;
	public Boolean mostrarnumero_itemsParametroFactuSecuencial=true;
	public Boolean activarnumero_itemsParametroFactuSecuencial=true;

	public Border resaltarnumero_descuentoParametroFactuSecuencial=null;
	public Boolean mostrarnumero_descuentoParametroFactuSecuencial=true;
	public Boolean activarnumero_descuentoParametroFactuSecuencial=true;

	public Border resaltarnumero_adiicionalesParametroFactuSecuencial=null;
	public Boolean mostrarnumero_adiicionalesParametroFactuSecuencial=true;
	public Boolean activarnumero_adiicionalesParametroFactuSecuencial=true;

	public Border resaltarnumero_digito_inicioParametroFactuSecuencial=null;
	public Boolean mostrarnumero_digito_inicioParametroFactuSecuencial=true;
	public Boolean activarnumero_digito_inicioParametroFactuSecuencial=true;

	public Border resaltarnumero_digito_finParametroFactuSecuencial=null;
	public Boolean mostrarnumero_digito_finParametroFactuSecuencial=true;
	public Boolean activarnumero_digito_finParametroFactuSecuencial=true;

	public Border resaltarnumero_dias_plazoParametroFactuSecuencial=null;
	public Boolean mostrarnumero_dias_plazoParametroFactuSecuencial=true;
	public Boolean activarnumero_dias_plazoParametroFactuSecuencial=true;

	public Border resaltarcon_detalleParametroFactuSecuencial=null;
	public Boolean mostrarcon_detalleParametroFactuSecuencial=true;
	public Boolean activarcon_detalleParametroFactuSecuencial=true;

	public Border resaltarcon_lectorParametroFactuSecuencial=null;
	public Boolean mostrarcon_lectorParametroFactuSecuencial=true;
	public Boolean activarcon_lectorParametroFactuSecuencial=true;

	public Border resaltarid_bodegaParametroFactuSecuencial=null;
	public Boolean mostrarid_bodegaParametroFactuSecuencial=true;
	public Boolean activarid_bodegaParametroFactuSecuencial=true;
	public Boolean cargarid_bodegaParametroFactuSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaParametroFactuSecuencial=false;//ConEventDepend=true

	public Border resaltarid_tipo_param_factu_plazoParametroFactuSecuencial=null;
	public Boolean mostrarid_tipo_param_factu_plazoParametroFactuSecuencial=true;
	public Boolean activarid_tipo_param_factu_plazoParametroFactuSecuencial=true;
	public Boolean cargarid_tipo_param_factu_plazoParametroFactuSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_param_factu_plazoParametroFactuSecuencial=false;//ConEventDepend=true

	public Border resaltarid_formatoParametroFactuSecuencial=null;
	public Boolean mostrarid_formatoParametroFactuSecuencial=true;
	public Boolean activarid_formatoParametroFactuSecuencial=true;
	public Boolean cargarid_formatoParametroFactuSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoParametroFactuSecuencial=false;//ConEventDepend=true

	public Border resaltarcon_transferenciaParametroFactuSecuencial=null;
	public Boolean mostrarcon_transferenciaParametroFactuSecuencial=true;
	public Boolean activarcon_transferenciaParametroFactuSecuencial=true;

	public Border resaltarid_bodega_transferenciaParametroFactuSecuencial=null;
	public Boolean mostrarid_bodega_transferenciaParametroFactuSecuencial=true;
	public Boolean activarid_bodega_transferenciaParametroFactuSecuencial=true;
	public Boolean cargarid_bodega_transferenciaParametroFactuSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodega_transferenciaParametroFactuSecuencial=false;//ConEventDepend=true

	public Border resaltarid_transaccion_transferenciaParametroFactuSecuencial=null;
	public Boolean mostrarid_transaccion_transferenciaParametroFactuSecuencial=true;
	public Boolean activarid_transaccion_transferenciaParametroFactuSecuencial=true;
	public Boolean cargarid_transaccion_transferenciaParametroFactuSecuencial=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_transferenciaParametroFactuSecuencial=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltaridParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroFactuSecuencial() {
		return this.resaltaridParametroFactuSecuencial;
	}

	public void setResaltaridParametroFactuSecuencial(Border borderResaltar) {
		this.resaltaridParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostraridParametroFactuSecuencial() {
		return this.mostraridParametroFactuSecuencial;
	}

	public void setMostraridParametroFactuSecuencial(Boolean mostraridParametroFactuSecuencial) {
		this.mostraridParametroFactuSecuencial= mostraridParametroFactuSecuencial;
	}

	public Boolean getActivaridParametroFactuSecuencial() {
		return this.activaridParametroFactuSecuencial;
	}

	public void setActivaridParametroFactuSecuencial(Boolean activaridParametroFactuSecuencial) {
		this.activaridParametroFactuSecuencial= activaridParametroFactuSecuencial;
	}

	public Border setResaltarid_empresaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroFactuSecuencial() {
		return this.resaltarid_empresaParametroFactuSecuencial;
	}

	public void setResaltarid_empresaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarid_empresaParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroFactuSecuencial() {
		return this.mostrarid_empresaParametroFactuSecuencial;
	}

	public void setMostrarid_empresaParametroFactuSecuencial(Boolean mostrarid_empresaParametroFactuSecuencial) {
		this.mostrarid_empresaParametroFactuSecuencial= mostrarid_empresaParametroFactuSecuencial;
	}

	public Boolean getActivarid_empresaParametroFactuSecuencial() {
		return this.activarid_empresaParametroFactuSecuencial;
	}

	public void setActivarid_empresaParametroFactuSecuencial(Boolean activarid_empresaParametroFactuSecuencial) {
		this.activarid_empresaParametroFactuSecuencial= activarid_empresaParametroFactuSecuencial;
	}

	public Boolean getCargarid_empresaParametroFactuSecuencial() {
		return this.cargarid_empresaParametroFactuSecuencial;
	}

	public void setCargarid_empresaParametroFactuSecuencial(Boolean cargarid_empresaParametroFactuSecuencial) {
		this.cargarid_empresaParametroFactuSecuencial= cargarid_empresaParametroFactuSecuencial;
	}

	public Border setResaltarid_sucursalParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroFactuSecuencial() {
		return this.resaltarid_sucursalParametroFactuSecuencial;
	}

	public void setResaltarid_sucursalParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarid_sucursalParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroFactuSecuencial() {
		return this.mostrarid_sucursalParametroFactuSecuencial;
	}

	public void setMostrarid_sucursalParametroFactuSecuencial(Boolean mostrarid_sucursalParametroFactuSecuencial) {
		this.mostrarid_sucursalParametroFactuSecuencial= mostrarid_sucursalParametroFactuSecuencial;
	}

	public Boolean getActivarid_sucursalParametroFactuSecuencial() {
		return this.activarid_sucursalParametroFactuSecuencial;
	}

	public void setActivarid_sucursalParametroFactuSecuencial(Boolean activarid_sucursalParametroFactuSecuencial) {
		this.activarid_sucursalParametroFactuSecuencial= activarid_sucursalParametroFactuSecuencial;
	}

	public Boolean getCargarid_sucursalParametroFactuSecuencial() {
		return this.cargarid_sucursalParametroFactuSecuencial;
	}

	public void setCargarid_sucursalParametroFactuSecuencial(Boolean cargarid_sucursalParametroFactuSecuencial) {
		this.cargarid_sucursalParametroFactuSecuencial= cargarid_sucursalParametroFactuSecuencial;
	}

	public Border setResaltarid_tipo_documento_generalParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documento_generalParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documento_generalParametroFactuSecuencial() {
		return this.resaltarid_tipo_documento_generalParametroFactuSecuencial;
	}

	public void setResaltarid_tipo_documento_generalParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarid_tipo_documento_generalParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documento_generalParametroFactuSecuencial() {
		return this.mostrarid_tipo_documento_generalParametroFactuSecuencial;
	}

	public void setMostrarid_tipo_documento_generalParametroFactuSecuencial(Boolean mostrarid_tipo_documento_generalParametroFactuSecuencial) {
		this.mostrarid_tipo_documento_generalParametroFactuSecuencial= mostrarid_tipo_documento_generalParametroFactuSecuencial;
	}

	public Boolean getActivarid_tipo_documento_generalParametroFactuSecuencial() {
		return this.activarid_tipo_documento_generalParametroFactuSecuencial;
	}

	public void setActivarid_tipo_documento_generalParametroFactuSecuencial(Boolean activarid_tipo_documento_generalParametroFactuSecuencial) {
		this.activarid_tipo_documento_generalParametroFactuSecuencial= activarid_tipo_documento_generalParametroFactuSecuencial;
	}

	public Boolean getCargarid_tipo_documento_generalParametroFactuSecuencial() {
		return this.cargarid_tipo_documento_generalParametroFactuSecuencial;
	}

	public void setCargarid_tipo_documento_generalParametroFactuSecuencial(Boolean cargarid_tipo_documento_generalParametroFactuSecuencial) {
		this.cargarid_tipo_documento_generalParametroFactuSecuencial= cargarid_tipo_documento_generalParametroFactuSecuencial;
	}

	public Border setResaltarsecuencialParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarsecuencialParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialParametroFactuSecuencial() {
		return this.resaltarsecuencialParametroFactuSecuencial;
	}

	public void setResaltarsecuencialParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarsecuencialParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarsecuencialParametroFactuSecuencial() {
		return this.mostrarsecuencialParametroFactuSecuencial;
	}

	public void setMostrarsecuencialParametroFactuSecuencial(Boolean mostrarsecuencialParametroFactuSecuencial) {
		this.mostrarsecuencialParametroFactuSecuencial= mostrarsecuencialParametroFactuSecuencial;
	}

	public Boolean getActivarsecuencialParametroFactuSecuencial() {
		return this.activarsecuencialParametroFactuSecuencial;
	}

	public void setActivarsecuencialParametroFactuSecuencial(Boolean activarsecuencialParametroFactuSecuencial) {
		this.activarsecuencialParametroFactuSecuencial= activarsecuencialParametroFactuSecuencial;
	}

	public Border setResaltarnumero_digitosParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_digitosParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_digitosParametroFactuSecuencial() {
		return this.resaltarnumero_digitosParametroFactuSecuencial;
	}

	public void setResaltarnumero_digitosParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarnumero_digitosParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_digitosParametroFactuSecuencial() {
		return this.mostrarnumero_digitosParametroFactuSecuencial;
	}

	public void setMostrarnumero_digitosParametroFactuSecuencial(Boolean mostrarnumero_digitosParametroFactuSecuencial) {
		this.mostrarnumero_digitosParametroFactuSecuencial= mostrarnumero_digitosParametroFactuSecuencial;
	}

	public Boolean getActivarnumero_digitosParametroFactuSecuencial() {
		return this.activarnumero_digitosParametroFactuSecuencial;
	}

	public void setActivarnumero_digitosParametroFactuSecuencial(Boolean activarnumero_digitosParametroFactuSecuencial) {
		this.activarnumero_digitosParametroFactuSecuencial= activarnumero_digitosParametroFactuSecuencial;
	}

	public Border setResaltarnumero_itemsParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_itemsParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_itemsParametroFactuSecuencial() {
		return this.resaltarnumero_itemsParametroFactuSecuencial;
	}

	public void setResaltarnumero_itemsParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarnumero_itemsParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_itemsParametroFactuSecuencial() {
		return this.mostrarnumero_itemsParametroFactuSecuencial;
	}

	public void setMostrarnumero_itemsParametroFactuSecuencial(Boolean mostrarnumero_itemsParametroFactuSecuencial) {
		this.mostrarnumero_itemsParametroFactuSecuencial= mostrarnumero_itemsParametroFactuSecuencial;
	}

	public Boolean getActivarnumero_itemsParametroFactuSecuencial() {
		return this.activarnumero_itemsParametroFactuSecuencial;
	}

	public void setActivarnumero_itemsParametroFactuSecuencial(Boolean activarnumero_itemsParametroFactuSecuencial) {
		this.activarnumero_itemsParametroFactuSecuencial= activarnumero_itemsParametroFactuSecuencial;
	}

	public Border setResaltarnumero_descuentoParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_descuentoParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_descuentoParametroFactuSecuencial() {
		return this.resaltarnumero_descuentoParametroFactuSecuencial;
	}

	public void setResaltarnumero_descuentoParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarnumero_descuentoParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_descuentoParametroFactuSecuencial() {
		return this.mostrarnumero_descuentoParametroFactuSecuencial;
	}

	public void setMostrarnumero_descuentoParametroFactuSecuencial(Boolean mostrarnumero_descuentoParametroFactuSecuencial) {
		this.mostrarnumero_descuentoParametroFactuSecuencial= mostrarnumero_descuentoParametroFactuSecuencial;
	}

	public Boolean getActivarnumero_descuentoParametroFactuSecuencial() {
		return this.activarnumero_descuentoParametroFactuSecuencial;
	}

	public void setActivarnumero_descuentoParametroFactuSecuencial(Boolean activarnumero_descuentoParametroFactuSecuencial) {
		this.activarnumero_descuentoParametroFactuSecuencial= activarnumero_descuentoParametroFactuSecuencial;
	}

	public Border setResaltarnumero_adiicionalesParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_adiicionalesParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_adiicionalesParametroFactuSecuencial() {
		return this.resaltarnumero_adiicionalesParametroFactuSecuencial;
	}

	public void setResaltarnumero_adiicionalesParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarnumero_adiicionalesParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_adiicionalesParametroFactuSecuencial() {
		return this.mostrarnumero_adiicionalesParametroFactuSecuencial;
	}

	public void setMostrarnumero_adiicionalesParametroFactuSecuencial(Boolean mostrarnumero_adiicionalesParametroFactuSecuencial) {
		this.mostrarnumero_adiicionalesParametroFactuSecuencial= mostrarnumero_adiicionalesParametroFactuSecuencial;
	}

	public Boolean getActivarnumero_adiicionalesParametroFactuSecuencial() {
		return this.activarnumero_adiicionalesParametroFactuSecuencial;
	}

	public void setActivarnumero_adiicionalesParametroFactuSecuencial(Boolean activarnumero_adiicionalesParametroFactuSecuencial) {
		this.activarnumero_adiicionalesParametroFactuSecuencial= activarnumero_adiicionalesParametroFactuSecuencial;
	}

	public Border setResaltarnumero_digito_inicioParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_digito_inicioParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_digito_inicioParametroFactuSecuencial() {
		return this.resaltarnumero_digito_inicioParametroFactuSecuencial;
	}

	public void setResaltarnumero_digito_inicioParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarnumero_digito_inicioParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_digito_inicioParametroFactuSecuencial() {
		return this.mostrarnumero_digito_inicioParametroFactuSecuencial;
	}

	public void setMostrarnumero_digito_inicioParametroFactuSecuencial(Boolean mostrarnumero_digito_inicioParametroFactuSecuencial) {
		this.mostrarnumero_digito_inicioParametroFactuSecuencial= mostrarnumero_digito_inicioParametroFactuSecuencial;
	}

	public Boolean getActivarnumero_digito_inicioParametroFactuSecuencial() {
		return this.activarnumero_digito_inicioParametroFactuSecuencial;
	}

	public void setActivarnumero_digito_inicioParametroFactuSecuencial(Boolean activarnumero_digito_inicioParametroFactuSecuencial) {
		this.activarnumero_digito_inicioParametroFactuSecuencial= activarnumero_digito_inicioParametroFactuSecuencial;
	}

	public Border setResaltarnumero_digito_finParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_digito_finParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_digito_finParametroFactuSecuencial() {
		return this.resaltarnumero_digito_finParametroFactuSecuencial;
	}

	public void setResaltarnumero_digito_finParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarnumero_digito_finParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_digito_finParametroFactuSecuencial() {
		return this.mostrarnumero_digito_finParametroFactuSecuencial;
	}

	public void setMostrarnumero_digito_finParametroFactuSecuencial(Boolean mostrarnumero_digito_finParametroFactuSecuencial) {
		this.mostrarnumero_digito_finParametroFactuSecuencial= mostrarnumero_digito_finParametroFactuSecuencial;
	}

	public Boolean getActivarnumero_digito_finParametroFactuSecuencial() {
		return this.activarnumero_digito_finParametroFactuSecuencial;
	}

	public void setActivarnumero_digito_finParametroFactuSecuencial(Boolean activarnumero_digito_finParametroFactuSecuencial) {
		this.activarnumero_digito_finParametroFactuSecuencial= activarnumero_digito_finParametroFactuSecuencial;
	}

	public Border setResaltarnumero_dias_plazoParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarnumero_dias_plazoParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_dias_plazoParametroFactuSecuencial() {
		return this.resaltarnumero_dias_plazoParametroFactuSecuencial;
	}

	public void setResaltarnumero_dias_plazoParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarnumero_dias_plazoParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarnumero_dias_plazoParametroFactuSecuencial() {
		return this.mostrarnumero_dias_plazoParametroFactuSecuencial;
	}

	public void setMostrarnumero_dias_plazoParametroFactuSecuencial(Boolean mostrarnumero_dias_plazoParametroFactuSecuencial) {
		this.mostrarnumero_dias_plazoParametroFactuSecuencial= mostrarnumero_dias_plazoParametroFactuSecuencial;
	}

	public Boolean getActivarnumero_dias_plazoParametroFactuSecuencial() {
		return this.activarnumero_dias_plazoParametroFactuSecuencial;
	}

	public void setActivarnumero_dias_plazoParametroFactuSecuencial(Boolean activarnumero_dias_plazoParametroFactuSecuencial) {
		this.activarnumero_dias_plazoParametroFactuSecuencial= activarnumero_dias_plazoParametroFactuSecuencial;
	}

	public Border setResaltarcon_detalleParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarcon_detalleParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_detalleParametroFactuSecuencial() {
		return this.resaltarcon_detalleParametroFactuSecuencial;
	}

	public void setResaltarcon_detalleParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarcon_detalleParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarcon_detalleParametroFactuSecuencial() {
		return this.mostrarcon_detalleParametroFactuSecuencial;
	}

	public void setMostrarcon_detalleParametroFactuSecuencial(Boolean mostrarcon_detalleParametroFactuSecuencial) {
		this.mostrarcon_detalleParametroFactuSecuencial= mostrarcon_detalleParametroFactuSecuencial;
	}

	public Boolean getActivarcon_detalleParametroFactuSecuencial() {
		return this.activarcon_detalleParametroFactuSecuencial;
	}

	public void setActivarcon_detalleParametroFactuSecuencial(Boolean activarcon_detalleParametroFactuSecuencial) {
		this.activarcon_detalleParametroFactuSecuencial= activarcon_detalleParametroFactuSecuencial;
	}

	public Border setResaltarcon_lectorParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarcon_lectorParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_lectorParametroFactuSecuencial() {
		return this.resaltarcon_lectorParametroFactuSecuencial;
	}

	public void setResaltarcon_lectorParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarcon_lectorParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarcon_lectorParametroFactuSecuencial() {
		return this.mostrarcon_lectorParametroFactuSecuencial;
	}

	public void setMostrarcon_lectorParametroFactuSecuencial(Boolean mostrarcon_lectorParametroFactuSecuencial) {
		this.mostrarcon_lectorParametroFactuSecuencial= mostrarcon_lectorParametroFactuSecuencial;
	}

	public Boolean getActivarcon_lectorParametroFactuSecuencial() {
		return this.activarcon_lectorParametroFactuSecuencial;
	}

	public void setActivarcon_lectorParametroFactuSecuencial(Boolean activarcon_lectorParametroFactuSecuencial) {
		this.activarcon_lectorParametroFactuSecuencial= activarcon_lectorParametroFactuSecuencial;
	}

	public Border setResaltarid_bodegaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_bodegaParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaParametroFactuSecuencial() {
		return this.resaltarid_bodegaParametroFactuSecuencial;
	}

	public void setResaltarid_bodegaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarid_bodegaParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_bodegaParametroFactuSecuencial() {
		return this.mostrarid_bodegaParametroFactuSecuencial;
	}

	public void setMostrarid_bodegaParametroFactuSecuencial(Boolean mostrarid_bodegaParametroFactuSecuencial) {
		this.mostrarid_bodegaParametroFactuSecuencial= mostrarid_bodegaParametroFactuSecuencial;
	}

	public Boolean getActivarid_bodegaParametroFactuSecuencial() {
		return this.activarid_bodegaParametroFactuSecuencial;
	}

	public void setActivarid_bodegaParametroFactuSecuencial(Boolean activarid_bodegaParametroFactuSecuencial) {
		this.activarid_bodegaParametroFactuSecuencial= activarid_bodegaParametroFactuSecuencial;
	}

	public Boolean getCargarid_bodegaParametroFactuSecuencial() {
		return this.cargarid_bodegaParametroFactuSecuencial;
	}

	public void setCargarid_bodegaParametroFactuSecuencial(Boolean cargarid_bodegaParametroFactuSecuencial) {
		this.cargarid_bodegaParametroFactuSecuencial= cargarid_bodegaParametroFactuSecuencial;
	}

	public Border setResaltarid_tipo_param_factu_plazoParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_tipo_param_factu_plazoParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_param_factu_plazoParametroFactuSecuencial() {
		return this.resaltarid_tipo_param_factu_plazoParametroFactuSecuencial;
	}

	public void setResaltarid_tipo_param_factu_plazoParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarid_tipo_param_factu_plazoParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_tipo_param_factu_plazoParametroFactuSecuencial() {
		return this.mostrarid_tipo_param_factu_plazoParametroFactuSecuencial;
	}

	public void setMostrarid_tipo_param_factu_plazoParametroFactuSecuencial(Boolean mostrarid_tipo_param_factu_plazoParametroFactuSecuencial) {
		this.mostrarid_tipo_param_factu_plazoParametroFactuSecuencial= mostrarid_tipo_param_factu_plazoParametroFactuSecuencial;
	}

	public Boolean getActivarid_tipo_param_factu_plazoParametroFactuSecuencial() {
		return this.activarid_tipo_param_factu_plazoParametroFactuSecuencial;
	}

	public void setActivarid_tipo_param_factu_plazoParametroFactuSecuencial(Boolean activarid_tipo_param_factu_plazoParametroFactuSecuencial) {
		this.activarid_tipo_param_factu_plazoParametroFactuSecuencial= activarid_tipo_param_factu_plazoParametroFactuSecuencial;
	}

	public Boolean getCargarid_tipo_param_factu_plazoParametroFactuSecuencial() {
		return this.cargarid_tipo_param_factu_plazoParametroFactuSecuencial;
	}

	public void setCargarid_tipo_param_factu_plazoParametroFactuSecuencial(Boolean cargarid_tipo_param_factu_plazoParametroFactuSecuencial) {
		this.cargarid_tipo_param_factu_plazoParametroFactuSecuencial= cargarid_tipo_param_factu_plazoParametroFactuSecuencial;
	}

	public Border setResaltarid_formatoParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_formatoParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoParametroFactuSecuencial() {
		return this.resaltarid_formatoParametroFactuSecuencial;
	}

	public void setResaltarid_formatoParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarid_formatoParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_formatoParametroFactuSecuencial() {
		return this.mostrarid_formatoParametroFactuSecuencial;
	}

	public void setMostrarid_formatoParametroFactuSecuencial(Boolean mostrarid_formatoParametroFactuSecuencial) {
		this.mostrarid_formatoParametroFactuSecuencial= mostrarid_formatoParametroFactuSecuencial;
	}

	public Boolean getActivarid_formatoParametroFactuSecuencial() {
		return this.activarid_formatoParametroFactuSecuencial;
	}

	public void setActivarid_formatoParametroFactuSecuencial(Boolean activarid_formatoParametroFactuSecuencial) {
		this.activarid_formatoParametroFactuSecuencial= activarid_formatoParametroFactuSecuencial;
	}

	public Boolean getCargarid_formatoParametroFactuSecuencial() {
		return this.cargarid_formatoParametroFactuSecuencial;
	}

	public void setCargarid_formatoParametroFactuSecuencial(Boolean cargarid_formatoParametroFactuSecuencial) {
		this.cargarid_formatoParametroFactuSecuencial= cargarid_formatoParametroFactuSecuencial;
	}

	public Border setResaltarcon_transferenciaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarcon_transferenciaParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_transferenciaParametroFactuSecuencial() {
		return this.resaltarcon_transferenciaParametroFactuSecuencial;
	}

	public void setResaltarcon_transferenciaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarcon_transferenciaParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarcon_transferenciaParametroFactuSecuencial() {
		return this.mostrarcon_transferenciaParametroFactuSecuencial;
	}

	public void setMostrarcon_transferenciaParametroFactuSecuencial(Boolean mostrarcon_transferenciaParametroFactuSecuencial) {
		this.mostrarcon_transferenciaParametroFactuSecuencial= mostrarcon_transferenciaParametroFactuSecuencial;
	}

	public Boolean getActivarcon_transferenciaParametroFactuSecuencial() {
		return this.activarcon_transferenciaParametroFactuSecuencial;
	}

	public void setActivarcon_transferenciaParametroFactuSecuencial(Boolean activarcon_transferenciaParametroFactuSecuencial) {
		this.activarcon_transferenciaParametroFactuSecuencial= activarcon_transferenciaParametroFactuSecuencial;
	}

	public Border setResaltarid_bodega_transferenciaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_bodega_transferenciaParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodega_transferenciaParametroFactuSecuencial() {
		return this.resaltarid_bodega_transferenciaParametroFactuSecuencial;
	}

	public void setResaltarid_bodega_transferenciaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarid_bodega_transferenciaParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_bodega_transferenciaParametroFactuSecuencial() {
		return this.mostrarid_bodega_transferenciaParametroFactuSecuencial;
	}

	public void setMostrarid_bodega_transferenciaParametroFactuSecuencial(Boolean mostrarid_bodega_transferenciaParametroFactuSecuencial) {
		this.mostrarid_bodega_transferenciaParametroFactuSecuencial= mostrarid_bodega_transferenciaParametroFactuSecuencial;
	}

	public Boolean getActivarid_bodega_transferenciaParametroFactuSecuencial() {
		return this.activarid_bodega_transferenciaParametroFactuSecuencial;
	}

	public void setActivarid_bodega_transferenciaParametroFactuSecuencial(Boolean activarid_bodega_transferenciaParametroFactuSecuencial) {
		this.activarid_bodega_transferenciaParametroFactuSecuencial= activarid_bodega_transferenciaParametroFactuSecuencial;
	}

	public Boolean getCargarid_bodega_transferenciaParametroFactuSecuencial() {
		return this.cargarid_bodega_transferenciaParametroFactuSecuencial;
	}

	public void setCargarid_bodega_transferenciaParametroFactuSecuencial(Boolean cargarid_bodega_transferenciaParametroFactuSecuencial) {
		this.cargarid_bodega_transferenciaParametroFactuSecuencial= cargarid_bodega_transferenciaParametroFactuSecuencial;
	}

	public Border setResaltarid_transaccion_transferenciaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrofactusecuencialBeanSwingJInternalFrame.jTtoolBarParametroFactuSecuencial.setBorder(borderResaltar);
		
		this.resaltarid_transaccion_transferenciaParametroFactuSecuencial= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_transferenciaParametroFactuSecuencial() {
		return this.resaltarid_transaccion_transferenciaParametroFactuSecuencial;
	}

	public void setResaltarid_transaccion_transferenciaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarid_transaccion_transferenciaParametroFactuSecuencial= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_transferenciaParametroFactuSecuencial() {
		return this.mostrarid_transaccion_transferenciaParametroFactuSecuencial;
	}

	public void setMostrarid_transaccion_transferenciaParametroFactuSecuencial(Boolean mostrarid_transaccion_transferenciaParametroFactuSecuencial) {
		this.mostrarid_transaccion_transferenciaParametroFactuSecuencial= mostrarid_transaccion_transferenciaParametroFactuSecuencial;
	}

	public Boolean getActivarid_transaccion_transferenciaParametroFactuSecuencial() {
		return this.activarid_transaccion_transferenciaParametroFactuSecuencial;
	}

	public void setActivarid_transaccion_transferenciaParametroFactuSecuencial(Boolean activarid_transaccion_transferenciaParametroFactuSecuencial) {
		this.activarid_transaccion_transferenciaParametroFactuSecuencial= activarid_transaccion_transferenciaParametroFactuSecuencial;
	}

	public Boolean getCargarid_transaccion_transferenciaParametroFactuSecuencial() {
		return this.cargarid_transaccion_transferenciaParametroFactuSecuencial;
	}

	public void setCargarid_transaccion_transferenciaParametroFactuSecuencial(Boolean cargarid_transaccion_transferenciaParametroFactuSecuencial) {
		this.cargarid_transaccion_transferenciaParametroFactuSecuencial= cargarid_transaccion_transferenciaParametroFactuSecuencial;
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
		
		
		this.setMostraridParametroFactuSecuencial(esInicial);
		this.setMostrarid_empresaParametroFactuSecuencial(esInicial);
		this.setMostrarid_sucursalParametroFactuSecuencial(esInicial);
		this.setMostrarid_tipo_documento_generalParametroFactuSecuencial(esInicial);
		this.setMostrarsecuencialParametroFactuSecuencial(esInicial);
		this.setMostrarnumero_digitosParametroFactuSecuencial(esInicial);
		this.setMostrarnumero_itemsParametroFactuSecuencial(esInicial);
		this.setMostrarnumero_descuentoParametroFactuSecuencial(esInicial);
		this.setMostrarnumero_adiicionalesParametroFactuSecuencial(esInicial);
		this.setMostrarnumero_digito_inicioParametroFactuSecuencial(esInicial);
		this.setMostrarnumero_digito_finParametroFactuSecuencial(esInicial);
		this.setMostrarnumero_dias_plazoParametroFactuSecuencial(esInicial);
		this.setMostrarcon_detalleParametroFactuSecuencial(esInicial);
		this.setMostrarcon_lectorParametroFactuSecuencial(esInicial);
		this.setMostrarid_bodegaParametroFactuSecuencial(esInicial);
		this.setMostrarid_tipo_param_factu_plazoParametroFactuSecuencial(esInicial);
		this.setMostrarid_formatoParametroFactuSecuencial(esInicial);
		this.setMostrarcon_transferenciaParametroFactuSecuencial(esInicial);
		this.setMostrarid_bodega_transferenciaParametroFactuSecuencial(esInicial);
		this.setMostrarid_transaccion_transferenciaParametroFactuSecuencial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.ID)) {
				this.setMostraridParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setMostrarid_tipo_documento_generalParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS)) {
				this.setMostrarnumero_digitosParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS)) {
				this.setMostrarnumero_itemsParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO)) {
				this.setMostrarnumero_descuentoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES)) {
				this.setMostrarnumero_adiicionalesParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO)) {
				this.setMostrarnumero_digito_inicioParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN)) {
				this.setMostrarnumero_digito_finParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO)) {
				this.setMostrarnumero_dias_plazoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONDETALLE)) {
				this.setMostrarcon_detalleParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONLECTOR)) {
				this.setMostrarcon_lectorParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO)) {
				this.setMostrarid_tipo_param_factu_plazoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA)) {
				this.setMostrarcon_transferenciaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA)) {
				this.setMostrarid_bodega_transferenciaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA)) {
				this.setMostrarid_transaccion_transferenciaParametroFactuSecuencial(esAsigna);
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
		
		
		this.setActivaridParametroFactuSecuencial(esInicial);
		this.setActivarid_empresaParametroFactuSecuencial(esInicial);
		this.setActivarid_sucursalParametroFactuSecuencial(esInicial);
		this.setActivarid_tipo_documento_generalParametroFactuSecuencial(esInicial);
		this.setActivarsecuencialParametroFactuSecuencial(esInicial);
		this.setActivarnumero_digitosParametroFactuSecuencial(esInicial);
		this.setActivarnumero_itemsParametroFactuSecuencial(esInicial);
		this.setActivarnumero_descuentoParametroFactuSecuencial(esInicial);
		this.setActivarnumero_adiicionalesParametroFactuSecuencial(esInicial);
		this.setActivarnumero_digito_inicioParametroFactuSecuencial(esInicial);
		this.setActivarnumero_digito_finParametroFactuSecuencial(esInicial);
		this.setActivarnumero_dias_plazoParametroFactuSecuencial(esInicial);
		this.setActivarcon_detalleParametroFactuSecuencial(esInicial);
		this.setActivarcon_lectorParametroFactuSecuencial(esInicial);
		this.setActivarid_bodegaParametroFactuSecuencial(esInicial);
		this.setActivarid_tipo_param_factu_plazoParametroFactuSecuencial(esInicial);
		this.setActivarid_formatoParametroFactuSecuencial(esInicial);
		this.setActivarcon_transferenciaParametroFactuSecuencial(esInicial);
		this.setActivarid_bodega_transferenciaParametroFactuSecuencial(esInicial);
		this.setActivarid_transaccion_transferenciaParametroFactuSecuencial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.ID)) {
				this.setActivaridParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setActivarid_tipo_documento_generalParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS)) {
				this.setActivarnumero_digitosParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS)) {
				this.setActivarnumero_itemsParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO)) {
				this.setActivarnumero_descuentoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES)) {
				this.setActivarnumero_adiicionalesParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO)) {
				this.setActivarnumero_digito_inicioParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN)) {
				this.setActivarnumero_digito_finParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO)) {
				this.setActivarnumero_dias_plazoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONDETALLE)) {
				this.setActivarcon_detalleParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONLECTOR)) {
				this.setActivarcon_lectorParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO)) {
				this.setActivarid_tipo_param_factu_plazoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA)) {
				this.setActivarcon_transferenciaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA)) {
				this.setActivarid_bodega_transferenciaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA)) {
				this.setActivarid_transaccion_transferenciaParametroFactuSecuencial(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroFactuSecuencial(esInicial);
		this.setResaltarid_empresaParametroFactuSecuencial(esInicial);
		this.setResaltarid_sucursalParametroFactuSecuencial(esInicial);
		this.setResaltarid_tipo_documento_generalParametroFactuSecuencial(esInicial);
		this.setResaltarsecuencialParametroFactuSecuencial(esInicial);
		this.setResaltarnumero_digitosParametroFactuSecuencial(esInicial);
		this.setResaltarnumero_itemsParametroFactuSecuencial(esInicial);
		this.setResaltarnumero_descuentoParametroFactuSecuencial(esInicial);
		this.setResaltarnumero_adiicionalesParametroFactuSecuencial(esInicial);
		this.setResaltarnumero_digito_inicioParametroFactuSecuencial(esInicial);
		this.setResaltarnumero_digito_finParametroFactuSecuencial(esInicial);
		this.setResaltarnumero_dias_plazoParametroFactuSecuencial(esInicial);
		this.setResaltarcon_detalleParametroFactuSecuencial(esInicial);
		this.setResaltarcon_lectorParametroFactuSecuencial(esInicial);
		this.setResaltarid_bodegaParametroFactuSecuencial(esInicial);
		this.setResaltarid_tipo_param_factu_plazoParametroFactuSecuencial(esInicial);
		this.setResaltarid_formatoParametroFactuSecuencial(esInicial);
		this.setResaltarcon_transferenciaParametroFactuSecuencial(esInicial);
		this.setResaltarid_bodega_transferenciaParametroFactuSecuencial(esInicial);
		this.setResaltarid_transaccion_transferenciaParametroFactuSecuencial(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.ID)) {
				this.setResaltaridParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTIPODOCUMENTOGENERAL)) {
				this.setResaltarid_tipo_documento_generalParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOS)) {
				this.setResaltarnumero_digitosParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMEROITEMS)) {
				this.setResaltarnumero_itemsParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODESCUENTO)) {
				this.setResaltarnumero_descuentoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMEROADIICIONALES)) {
				this.setResaltarnumero_adiicionalesParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOINICIO)) {
				this.setResaltarnumero_digito_inicioParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIGITOFIN)) {
				this.setResaltarnumero_digito_finParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.NUMERODIASPLAZO)) {
				this.setResaltarnumero_dias_plazoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONDETALLE)) {
				this.setResaltarcon_detalleParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONLECTOR)) {
				this.setResaltarcon_lectorParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTIPOPARAMFACTUPLAZO)) {
				this.setResaltarid_tipo_param_factu_plazoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.CONTRANSFERENCIA)) {
				this.setResaltarcon_transferenciaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDBODEGATRANSFERENCIA)) {
				this.setResaltarid_bodega_transferenciaParametroFactuSecuencial(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroFactuSecuencialConstantesFunciones.IDTRANSACCIONTRANSFERENCIA)) {
				this.setResaltarid_transaccion_transferenciaParametroFactuSecuencial(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBodegaParametroFactuSecuencial=true;

	public Boolean getMostrarFK_IdBodegaParametroFactuSecuencial() {
		return this.mostrarFK_IdBodegaParametroFactuSecuencial;
	}

	public void setMostrarFK_IdBodegaParametroFactuSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaParametroFactuSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaTransferenciaParametroFactuSecuencial=true;

	public Boolean getMostrarFK_IdBodegaTransferenciaParametroFactuSecuencial() {
		return this.mostrarFK_IdBodegaTransferenciaParametroFactuSecuencial;
	}

	public void setMostrarFK_IdBodegaTransferenciaParametroFactuSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaTransferenciaParametroFactuSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroFactuSecuencial=true;

	public Boolean getMostrarFK_IdEmpresaParametroFactuSecuencial() {
		return this.mostrarFK_IdEmpresaParametroFactuSecuencial;
	}

	public void setMostrarFK_IdEmpresaParametroFactuSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroFactuSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoParametroFactuSecuencial=true;

	public Boolean getMostrarFK_IdFormatoParametroFactuSecuencial() {
		return this.mostrarFK_IdFormatoParametroFactuSecuencial;
	}

	public void setMostrarFK_IdFormatoParametroFactuSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoParametroFactuSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroFactuSecuencial=true;

	public Boolean getMostrarFK_IdSucursalParametroFactuSecuencial() {
		return this.mostrarFK_IdSucursalParametroFactuSecuencial;
	}

	public void setMostrarFK_IdSucursalParametroFactuSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroFactuSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoGeneralParametroFactuSecuencial=true;

	public Boolean getMostrarFK_IdTipoDocumentoGeneralParametroFactuSecuencial() {
		return this.mostrarFK_IdTipoDocumentoGeneralParametroFactuSecuencial;
	}

	public void setMostrarFK_IdTipoDocumentoGeneralParametroFactuSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoGeneralParametroFactuSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoParamFactuPlazoParametroFactuSecuencial=true;

	public Boolean getMostrarFK_IdTipoParamFactuPlazoParametroFactuSecuencial() {
		return this.mostrarFK_IdTipoParamFactuPlazoParametroFactuSecuencial;
	}

	public void setMostrarFK_IdTipoParamFactuPlazoParametroFactuSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoParamFactuPlazoParametroFactuSecuencial= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionTransferenciaParametroFactuSecuencial=true;

	public Boolean getMostrarFK_IdTransaccionTransferenciaParametroFactuSecuencial() {
		return this.mostrarFK_IdTransaccionTransferenciaParametroFactuSecuencial;
	}

	public void setMostrarFK_IdTransaccionTransferenciaParametroFactuSecuencial(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionTransferenciaParametroFactuSecuencial= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBodegaParametroFactuSecuencial=true;

	public Boolean getActivarFK_IdBodegaParametroFactuSecuencial() {
		return this.activarFK_IdBodegaParametroFactuSecuencial;
	}

	public void setActivarFK_IdBodegaParametroFactuSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaParametroFactuSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaTransferenciaParametroFactuSecuencial=true;

	public Boolean getActivarFK_IdBodegaTransferenciaParametroFactuSecuencial() {
		return this.activarFK_IdBodegaTransferenciaParametroFactuSecuencial;
	}

	public void setActivarFK_IdBodegaTransferenciaParametroFactuSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaTransferenciaParametroFactuSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroFactuSecuencial=true;

	public Boolean getActivarFK_IdEmpresaParametroFactuSecuencial() {
		return this.activarFK_IdEmpresaParametroFactuSecuencial;
	}

	public void setActivarFK_IdEmpresaParametroFactuSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroFactuSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoParametroFactuSecuencial=true;

	public Boolean getActivarFK_IdFormatoParametroFactuSecuencial() {
		return this.activarFK_IdFormatoParametroFactuSecuencial;
	}

	public void setActivarFK_IdFormatoParametroFactuSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoParametroFactuSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroFactuSecuencial=true;

	public Boolean getActivarFK_IdSucursalParametroFactuSecuencial() {
		return this.activarFK_IdSucursalParametroFactuSecuencial;
	}

	public void setActivarFK_IdSucursalParametroFactuSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroFactuSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoGeneralParametroFactuSecuencial=true;

	public Boolean getActivarFK_IdTipoDocumentoGeneralParametroFactuSecuencial() {
		return this.activarFK_IdTipoDocumentoGeneralParametroFactuSecuencial;
	}

	public void setActivarFK_IdTipoDocumentoGeneralParametroFactuSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoGeneralParametroFactuSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoParamFactuPlazoParametroFactuSecuencial=true;

	public Boolean getActivarFK_IdTipoParamFactuPlazoParametroFactuSecuencial() {
		return this.activarFK_IdTipoParamFactuPlazoParametroFactuSecuencial;
	}

	public void setActivarFK_IdTipoParamFactuPlazoParametroFactuSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdTipoParamFactuPlazoParametroFactuSecuencial= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionTransferenciaParametroFactuSecuencial=true;

	public Boolean getActivarFK_IdTransaccionTransferenciaParametroFactuSecuencial() {
		return this.activarFK_IdTransaccionTransferenciaParametroFactuSecuencial;
	}

	public void setActivarFK_IdTransaccionTransferenciaParametroFactuSecuencial(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionTransferenciaParametroFactuSecuencial= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBodegaParametroFactuSecuencial=null;

	public Border getResaltarFK_IdBodegaParametroFactuSecuencial() {
		return this.resaltarFK_IdBodegaParametroFactuSecuencial;
	}

	public void setResaltarFK_IdBodegaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarFK_IdBodegaParametroFactuSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdBodegaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaParametroFactuSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdBodegaTransferenciaParametroFactuSecuencial=null;

	public Border getResaltarFK_IdBodegaTransferenciaParametroFactuSecuencial() {
		return this.resaltarFK_IdBodegaTransferenciaParametroFactuSecuencial;
	}

	public void setResaltarFK_IdBodegaTransferenciaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarFK_IdBodegaTransferenciaParametroFactuSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdBodegaTransferenciaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaTransferenciaParametroFactuSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroFactuSecuencial=null;

	public Border getResaltarFK_IdEmpresaParametroFactuSecuencial() {
		return this.resaltarFK_IdEmpresaParametroFactuSecuencial;
	}

	public void setResaltarFK_IdEmpresaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroFactuSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroFactuSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdFormatoParametroFactuSecuencial=null;

	public Border getResaltarFK_IdFormatoParametroFactuSecuencial() {
		return this.resaltarFK_IdFormatoParametroFactuSecuencial;
	}

	public void setResaltarFK_IdFormatoParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarFK_IdFormatoParametroFactuSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdFormatoParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoParametroFactuSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroFactuSecuencial=null;

	public Border getResaltarFK_IdSucursalParametroFactuSecuencial() {
		return this.resaltarFK_IdSucursalParametroFactuSecuencial;
	}

	public void setResaltarFK_IdSucursalParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroFactuSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroFactuSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoGeneralParametroFactuSecuencial=null;

	public Border getResaltarFK_IdTipoDocumentoGeneralParametroFactuSecuencial() {
		return this.resaltarFK_IdTipoDocumentoGeneralParametroFactuSecuencial;
	}

	public void setResaltarFK_IdTipoDocumentoGeneralParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoGeneralParametroFactuSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoGeneralParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoGeneralParametroFactuSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdTipoParamFactuPlazoParametroFactuSecuencial=null;

	public Border getResaltarFK_IdTipoParamFactuPlazoParametroFactuSecuencial() {
		return this.resaltarFK_IdTipoParamFactuPlazoParametroFactuSecuencial;
	}

	public void setResaltarFK_IdTipoParamFactuPlazoParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarFK_IdTipoParamFactuPlazoParametroFactuSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdTipoParamFactuPlazoParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoParamFactuPlazoParametroFactuSecuencial= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionTransferenciaParametroFactuSecuencial=null;

	public Border getResaltarFK_IdTransaccionTransferenciaParametroFactuSecuencial() {
		return this.resaltarFK_IdTransaccionTransferenciaParametroFactuSecuencial;
	}

	public void setResaltarFK_IdTransaccionTransferenciaParametroFactuSecuencial(Border borderResaltar) {
		this.resaltarFK_IdTransaccionTransferenciaParametroFactuSecuencial= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionTransferenciaParametroFactuSecuencial(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroFactuSecuencialBeanSwingJInternalFrame parametrofactusecuencialBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionTransferenciaParametroFactuSecuencial= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}