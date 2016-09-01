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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoRetencionConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoRetencionParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoRetencionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.importaciones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoRetencionConstantesFunciones extends TipoRetencionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRetencion";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRetencion"+TipoRetencionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRetencionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRetencionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRetencionConstantesFunciones.SCHEMA+"_"+TipoRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRetencionConstantesFunciones.SCHEMA+"_"+TipoRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRetencionConstantesFunciones.SCHEMA+"_"+TipoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRetencionConstantesFunciones.SCHEMA+"_"+TipoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRetencionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRetencionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRetencionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRetencionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Retencion s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Retencion ";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Retencion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRetencion";
	public static final String OBJECTNAME="tiporetencion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_retencion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporetencion from "+TipoRetencionConstantesFunciones.SPERSISTENCENAME+" tiporetencion";
	public static String QUERYSELECTNATIVE="select "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".version_row,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id_empresa,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".nombre,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".codigo,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".porcentaje,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".monto_minimo,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_retencion_iva,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_debito,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_con_iva_factura,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_con_sub_total_factura,"+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME+".es_con_secuencial from "+TipoRetencionConstantesFunciones.SCHEMA+"."+TipoRetencionConstantesFunciones.TABLENAME;//+" as "+TipoRetencionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRetencionConstantesFuncionesAdditional tiporetencionConstantesFuncionesAdditional=null;
	
	public TipoRetencionConstantesFuncionesAdditional getTipoRetencionConstantesFuncionesAdditional() {
		return this.tiporetencionConstantesFuncionesAdditional;
	}
	
	public void setTipoRetencionConstantesFuncionesAdditional(TipoRetencionConstantesFuncionesAdditional tiporetencionConstantesFuncionesAdditional) {
		try {
			this.tiporetencionConstantesFuncionesAdditional=tiporetencionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String CODIGO= "codigo";
    public static final String PORCENTAJE= "porcentaje";
    public static final String MONTOMINIMO= "monto_minimo";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String ESRETENCIONIVA= "es_retencion_iva";
    public static final String ESDEBITO= "es_debito";
    public static final String ESCONIVAFACTURA= "es_con_iva_factura";
    public static final String ESCONSUBTOTALFACTURA= "es_con_sub_total_factura";
    public static final String ESCONSECUENCIAL= "es_con_secuencial";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGO= "Codigo Sri";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_MONTOMINIMO= "Monto Minimo";
		public static final String LABEL_MONTOMINIMO_LOWER= "Monto Minimo";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta Contable Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_ESRETENCIONIVA= "Es Retencion Iva";
		public static final String LABEL_ESRETENCIONIVA_LOWER= "Es Retencion Iva";
    	public static final String LABEL_ESDEBITO= "Es Debito";
		public static final String LABEL_ESDEBITO_LOWER= "Es Debito";
    	public static final String LABEL_ESCONIVAFACTURA= "Con Iva Factura";
		public static final String LABEL_ESCONIVAFACTURA_LOWER= "Es Con Iva Factura";
    	public static final String LABEL_ESCONSUBTOTALFACTURA= "Con Sub Total Factura";
		public static final String LABEL_ESCONSUBTOTALFACTURA_LOWER= "Es Con Sub Total Factura";
    	public static final String LABEL_ESCONSECUENCIAL= "Con Secuencial";
		public static final String LABEL_ESCONSECUENCIAL_LOWER= "Es Con Secuencial";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getTipoRetencionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.CODIGO)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.PORCENTAJE)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.MONTOMINIMO)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_MONTOMINIMO;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.ESRETENCIONIVA)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_ESRETENCIONIVA;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.ESDEBITO)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_ESDEBITO;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.ESCONIVAFACTURA)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_ESCONIVAFACTURA;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA;}
		if(sNombreColumna.equals(TipoRetencionConstantesFunciones.ESCONSECUENCIAL)) {sLabelColumna=TipoRetencionConstantesFunciones.LABEL_ESCONSECUENCIAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getes_retencion_ivaDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencion.getes_retencion_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_retencion_ivaHtmlDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencion.getId(),tiporetencion.getes_retencion_iva());

		return sDescripcion;
	}	
		
	public static String getes_debitoDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencion.getes_debito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_debitoHtmlDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencion.getId(),tiporetencion.getes_debito());

		return sDescripcion;
	}	
		
	public static String getes_con_iva_facturaDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencion.getes_con_iva_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_con_iva_facturaHtmlDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencion.getId(),tiporetencion.getes_con_iva_factura());

		return sDescripcion;
	}	
		
	public static String getes_con_sub_total_facturaDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencion.getes_con_sub_total_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_con_sub_total_facturaHtmlDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencion.getId(),tiporetencion.getes_con_sub_total_factura());

		return sDescripcion;
	}	
		
	public static String getes_con_secuencialDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencion.getes_con_secuencial()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_con_secuencialHtmlDescripcion(TipoRetencion tiporetencion) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencion.getId(),tiporetencion.getes_con_secuencial());

		return sDescripcion;
	}	
	
	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporetencion !=null/* && tiporetencion.getId()!=0*/) {
			sDescripcion=tiporetencion.getnombre();//tiporetenciontiporetencion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRetencionDescripcionDetallado(TipoRetencion tiporetencion) {
		String sDescripcion="";
			
		sDescripcion+=TipoRetencionConstantesFunciones.ID+"=";
		sDescripcion+=tiporetencion.getId().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporetencion.getVersionRow().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiporetencion.getid_empresa().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporetencion.getnombre()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporetencion.getcodigo()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=tiporetencion.getporcentaje().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.MONTOMINIMO+"=";
		sDescripcion+=tiporetencion.getmonto_minimo().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=tiporetencion.getid_cuenta_contable().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=tiporetencion.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.ESRETENCIONIVA+"=";
		sDescripcion+=tiporetencion.getes_retencion_iva().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.ESDEBITO+"=";
		sDescripcion+=tiporetencion.getes_debito().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.ESCONIVAFACTURA+"=";
		sDescripcion+=tiporetencion.getes_con_iva_factura().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA+"=";
		sDescripcion+=tiporetencion.getes_con_sub_total_factura().toString()+",";
		sDescripcion+=TipoRetencionConstantesFunciones.ESCONSECUENCIAL+"=";
		sDescripcion+=tiporetencion.getes_con_secuencial().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRetencionDescripcion(TipoRetencion tiporetencion,String sValor) throws Exception {			
		if(tiporetencion !=null) {
			tiporetencion.setnombre(sValor);;//tiporetenciontiporetencion.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPoNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("BusquedaPorCodigoSri")) {
			sNombreIndice="Tipo=  Por Codigo Sri";
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPoNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorCodigoSri(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo Sri="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoRetencion(TipoRetencion tiporetencion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporetencion.setnombre(tiporetencion.getnombre().trim());
		tiporetencion.setcodigo(tiporetencion.getcodigo().trim());
	}
	
	public static void quitarEspaciosTipoRetencions(List<TipoRetencion> tiporetencions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRetencion tiporetencion: tiporetencions) {
			tiporetencion.setnombre(tiporetencion.getnombre().trim());
			tiporetencion.setcodigo(tiporetencion.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRetencion(TipoRetencion tiporetencion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporetencion.getConCambioAuxiliar()) {
			tiporetencion.setIsDeleted(tiporetencion.getIsDeletedAuxiliar());	
			tiporetencion.setIsNew(tiporetencion.getIsNewAuxiliar());	
			tiporetencion.setIsChanged(tiporetencion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporetencion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporetencion.setIsDeletedAuxiliar(false);	
			tiporetencion.setIsNewAuxiliar(false);	
			tiporetencion.setIsChangedAuxiliar(false);
			
			tiporetencion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRetencions(List<TipoRetencion> tiporetencions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRetencion tiporetencion : tiporetencions) {
			if(conAsignarBase && tiporetencion.getConCambioAuxiliar()) {
				tiporetencion.setIsDeleted(tiporetencion.getIsDeletedAuxiliar());	
				tiporetencion.setIsNew(tiporetencion.getIsNewAuxiliar());	
				tiporetencion.setIsChanged(tiporetencion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporetencion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporetencion.setIsDeletedAuxiliar(false);	
				tiporetencion.setIsNewAuxiliar(false);	
				tiporetencion.setIsChangedAuxiliar(false);
				
				tiporetencion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRetencion(TipoRetencion tiporetencion,Boolean conEnteros) throws Exception  {
		tiporetencion.setporcentaje(0.0);
		tiporetencion.setmonto_minimo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRetencions(List<TipoRetencion> tiporetencions,Boolean conEnteros) throws Exception  {
		
		for(TipoRetencion tiporetencion: tiporetencions) {
			tiporetencion.setporcentaje(0.0);
			tiporetencion.setmonto_minimo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRetencion(List<TipoRetencion> tiporetencions,TipoRetencion tiporetencionAux) throws Exception  {
		TipoRetencionConstantesFunciones.InicializarValoresTipoRetencion(tiporetencionAux,true);
		
		for(TipoRetencion tiporetencion: tiporetencions) {
			if(tiporetencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tiporetencionAux.setporcentaje(tiporetencionAux.getporcentaje()+tiporetencion.getporcentaje());			
			tiporetencionAux.setmonto_minimo(tiporetencionAux.getmonto_minimo()+tiporetencion.getmonto_minimo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRetencionConstantesFunciones.getArrayColumnasGlobalesTipoRetencion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRetencion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoRetencionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoRetencionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRetencion> tiporetencions,TipoRetencion tiporetencion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRetencion tiporetencionAux: tiporetencions) {
			if(tiporetencionAux!=null && tiporetencion!=null) {
				if((tiporetencionAux.getId()==null && tiporetencion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporetencionAux.getId()!=null && tiporetencion.getId()!=null){
					if(tiporetencionAux.getId().equals(tiporetencion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRetencion(List<TipoRetencion> tiporetencions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double monto_minimoTotal=0.0;
	
		for(TipoRetencion tiporetencion: tiporetencions) {			
			if(tiporetencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=tiporetencion.getporcentaje();
			monto_minimoTotal+=tiporetencion.getmonto_minimo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoRetencionConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoRetencionConstantesFunciones.MONTOMINIMO);
		datoGeneral.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_MONTOMINIMO);
		datoGeneral.setdValorDouble(monto_minimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRetencion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_ID, TipoRetencionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_VERSIONROW, TipoRetencionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_IDEMPRESA, TipoRetencionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_NOMBRE, TipoRetencionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_CODIGO, TipoRetencionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_PORCENTAJE, TipoRetencionConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_MONTOMINIMO, TipoRetencionConstantesFunciones.MONTOMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE, TipoRetencionConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_ESRETENCIONIVA, TipoRetencionConstantesFunciones.ESRETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_ESDEBITO, TipoRetencionConstantesFunciones.ESDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_ESCONIVAFACTURA, TipoRetencionConstantesFunciones.ESCONIVAFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA, TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionConstantesFunciones.LABEL_ESCONSECUENCIAL, TipoRetencionConstantesFunciones.ESCONSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRetencion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.MONTOMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.ESRETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.ESDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.ESCONIVAFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionConstantesFunciones.ESCONSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencion() throws Exception  {
		return TipoRetencionConstantesFunciones.getTiposSeleccionarTipoRetencion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencion(Boolean conFk) throws Exception  {
		return TipoRetencionConstantesFunciones.getTiposSeleccionarTipoRetencion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_MONTOMINIMO);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_MONTOMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_ESRETENCIONIVA);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_ESRETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_ESDEBITO);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_ESDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_ESCONIVAFACTURA);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_ESCONIVAFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionConstantesFunciones.LABEL_ESCONSECUENCIAL);
			reporte.setsDescripcion(TipoRetencionConstantesFunciones.LABEL_ESCONSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRetencion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRetencion(TipoRetencion tiporetencionAux) throws Exception {
		
			tiporetencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporetencionAux.getEmpresa()));
			tiporetencionAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tiporetencionAux.getCuentaContable()));
			tiporetencionAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tiporetencionAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRetencion(List<TipoRetencion> tiporetencionsTemp) throws Exception {
		for(TipoRetencion tiporetencionAux:tiporetencionsTemp) {
			
			tiporetencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporetencionAux.getEmpresa()));
			tiporetencionAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tiporetencionAux.getCuentaContable()));
			tiporetencionAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tiporetencionAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRetencionConstantesFunciones.getClassesRelationshipsOfTipoRetencion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRetencionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRetencion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoRetencion tiporetencion,List<TipoRetencion> tiporetencions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRetencion tiporetencionEncontrado=null;
			
			for(TipoRetencion tiporetencionLocal:tiporetencions) {
				if(tiporetencionLocal.getId().equals(tiporetencion.getId())) {
					tiporetencionEncontrado=tiporetencionLocal;
					
					tiporetencionLocal.setIsChanged(tiporetencion.getIsChanged());
					tiporetencionLocal.setIsNew(tiporetencion.getIsNew());
					tiporetencionLocal.setIsDeleted(tiporetencion.getIsDeleted());
					
					tiporetencionLocal.setGeneralEntityOriginal(tiporetencion.getGeneralEntityOriginal());
					
					tiporetencionLocal.setId(tiporetencion.getId());	
					tiporetencionLocal.setVersionRow(tiporetencion.getVersionRow());	
					tiporetencionLocal.setid_empresa(tiporetencion.getid_empresa());	
					tiporetencionLocal.setnombre(tiporetencion.getnombre());	
					tiporetencionLocal.setcodigo(tiporetencion.getcodigo());	
					tiporetencionLocal.setporcentaje(tiporetencion.getporcentaje());	
					tiporetencionLocal.setmonto_minimo(tiporetencion.getmonto_minimo());	
					tiporetencionLocal.setid_cuenta_contable(tiporetencion.getid_cuenta_contable());	
					tiporetencionLocal.setid_cuenta_contable_credito(tiporetencion.getid_cuenta_contable_credito());	
					tiporetencionLocal.setes_retencion_iva(tiporetencion.getes_retencion_iva());	
					tiporetencionLocal.setes_debito(tiporetencion.getes_debito());	
					tiporetencionLocal.setes_con_iva_factura(tiporetencion.getes_con_iva_factura());	
					tiporetencionLocal.setes_con_sub_total_factura(tiporetencion.getes_con_sub_total_factura());	
					tiporetencionLocal.setes_con_secuencial(tiporetencion.getes_con_secuencial());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiporetencion.getIsDeleted()) {
				if(!existe) {
					tiporetencions.add(tiporetencion);
				}
			} else {
				if(tiporetencionEncontrado!=null && permiteQuitar)  {
					tiporetencions.remove(tiporetencionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRetencion tiporetencion,List<TipoRetencion> tiporetencions) throws Exception {
		try	{			
			for(TipoRetencion tiporetencionLocal:tiporetencions) {
				if(tiporetencionLocal.getId().equals(tiporetencion.getId())) {
					tiporetencionLocal.setIsSelected(tiporetencion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRetencion(List<TipoRetencion> tiporetencionsAux) throws Exception {
		//this.tiporetencionsAux=tiporetencionsAux;
		
		for(TipoRetencion tiporetencionAux:tiporetencionsAux) {
			if(tiporetencionAux.getIsChanged()) {
				tiporetencionAux.setIsChanged(false);
			}		
			
			if(tiporetencionAux.getIsNew()) {
				tiporetencionAux.setIsNew(false);
			}	
			
			if(tiporetencionAux.getIsDeleted()) {
				tiporetencionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRetencion(TipoRetencion tiporetencionAux) throws Exception {
		//this.tiporetencionAux=tiporetencionAux;
		
			if(tiporetencionAux.getIsChanged()) {
				tiporetencionAux.setIsChanged(false);
			}		
			
			if(tiporetencionAux.getIsNew()) {
				tiporetencionAux.setIsNew(false);
			}	
			
			if(tiporetencionAux.getIsDeleted()) {
				tiporetencionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRetencion tiporetencionAsignar,TipoRetencion tiporetencion) throws Exception {
		tiporetencionAsignar.setId(tiporetencion.getId());	
		tiporetencionAsignar.setVersionRow(tiporetencion.getVersionRow());	
		tiporetencionAsignar.setid_empresa(tiporetencion.getid_empresa());
		tiporetencionAsignar.setempresa_descripcion(tiporetencion.getempresa_descripcion());	
		tiporetencionAsignar.setnombre(tiporetencion.getnombre());	
		tiporetencionAsignar.setcodigo(tiporetencion.getcodigo());	
		tiporetencionAsignar.setporcentaje(tiporetencion.getporcentaje());	
		tiporetencionAsignar.setmonto_minimo(tiporetencion.getmonto_minimo());	
		tiporetencionAsignar.setid_cuenta_contable(tiporetencion.getid_cuenta_contable());
		tiporetencionAsignar.setcuentacontable_descripcion(tiporetencion.getcuentacontable_descripcion());	
		tiporetencionAsignar.setid_cuenta_contable_credito(tiporetencion.getid_cuenta_contable_credito());
		tiporetencionAsignar.setcuentacontablecredito_descripcion(tiporetencion.getcuentacontablecredito_descripcion());	
		tiporetencionAsignar.setes_retencion_iva(tiporetencion.getes_retencion_iva());	
		tiporetencionAsignar.setes_debito(tiporetencion.getes_debito());	
		tiporetencionAsignar.setes_con_iva_factura(tiporetencion.getes_con_iva_factura());	
		tiporetencionAsignar.setes_con_sub_total_factura(tiporetencion.getes_con_sub_total_factura());	
		tiporetencionAsignar.setes_con_secuencial(tiporetencion.getes_con_secuencial());	
	}
	
	public static void inicializarTipoRetencion(TipoRetencion tiporetencion) throws Exception {
		try {
				tiporetencion.setId(0L);	
					
				tiporetencion.setid_empresa(-1L);	
				tiporetencion.setnombre("");	
				tiporetencion.setcodigo("");	
				tiporetencion.setporcentaje(0.0);	
				tiporetencion.setmonto_minimo(0.0);	
				tiporetencion.setid_cuenta_contable(null);	
				tiporetencion.setid_cuenta_contable_credito(null);	
				tiporetencion.setes_retencion_iva(false);	
				tiporetencion.setes_debito(false);	
				tiporetencion.setes_con_iva_factura(false);	
				tiporetencion.setes_con_sub_total_factura(false);	
				tiporetencion.setes_con_secuencial(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRetencion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_MONTOMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_ESRETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_ESDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_ESCONIVAFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionConstantesFunciones.LABEL_ESCONSECUENCIAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRetencion(String sTipo,Row row,Workbook workbook,TipoRetencion tiporetencion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencion.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencion.getmonto_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencion.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencion.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencion.getes_retencion_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencion.getes_debito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencion.getes_con_iva_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencion.getes_con_sub_total_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencion.getes_con_secuencial()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRetencion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRetencion() {
		return this.sFinalQueryTipoRetencion;
	}
	
	public void setsFinalQueryTipoRetencion(String sFinalQueryTipoRetencion) {
		this.sFinalQueryTipoRetencion= sFinalQueryTipoRetencion;
	}
	
	public Border resaltarSeleccionarTipoRetencion=null;
	
	public Border setResaltarSeleccionarTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRetencion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRetencion() {
		return this.resaltarSeleccionarTipoRetencion;
	}
	
	public void setResaltarSeleccionarTipoRetencion(Border borderResaltarSeleccionarTipoRetencion) {
		this.resaltarSeleccionarTipoRetencion= borderResaltarSeleccionarTipoRetencion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRetencion=null;
	public Boolean mostraridTipoRetencion=true;
	public Boolean activaridTipoRetencion=true;

	public Border resaltarid_empresaTipoRetencion=null;
	public Boolean mostrarid_empresaTipoRetencion=true;
	public Boolean activarid_empresaTipoRetencion=true;
	public Boolean cargarid_empresaTipoRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoRetencion=false;//ConEventDepend=true

	public Border resaltarnombreTipoRetencion=null;
	public Boolean mostrarnombreTipoRetencion=true;
	public Boolean activarnombreTipoRetencion=true;

	public Border resaltarcodigoTipoRetencion=null;
	public Boolean mostrarcodigoTipoRetencion=true;
	public Boolean activarcodigoTipoRetencion=true;

	public Border resaltarporcentajeTipoRetencion=null;
	public Boolean mostrarporcentajeTipoRetencion=true;
	public Boolean activarporcentajeTipoRetencion=true;

	public Border resaltarmonto_minimoTipoRetencion=null;
	public Boolean mostrarmonto_minimoTipoRetencion=true;
	public Boolean activarmonto_minimoTipoRetencion=true;

	public Border resaltarid_cuenta_contableTipoRetencion=null;
	public Boolean mostrarid_cuenta_contableTipoRetencion=true;
	public Boolean activarid_cuenta_contableTipoRetencion=true;
	public Boolean cargarid_cuenta_contableTipoRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableTipoRetencion=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoTipoRetencion=null;
	public Boolean mostrarid_cuenta_contable_creditoTipoRetencion=true;
	public Boolean activarid_cuenta_contable_creditoTipoRetencion=true;
	public Boolean cargarid_cuenta_contable_creditoTipoRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoTipoRetencion=false;//ConEventDepend=true

	public Border resaltares_retencion_ivaTipoRetencion=null;
	public Boolean mostrares_retencion_ivaTipoRetencion=true;
	public Boolean activares_retencion_ivaTipoRetencion=true;

	public Border resaltares_debitoTipoRetencion=null;
	public Boolean mostrares_debitoTipoRetencion=true;
	public Boolean activares_debitoTipoRetencion=true;

	public Border resaltares_con_iva_facturaTipoRetencion=null;
	public Boolean mostrares_con_iva_facturaTipoRetencion=true;
	public Boolean activares_con_iva_facturaTipoRetencion=true;

	public Border resaltares_con_sub_total_facturaTipoRetencion=null;
	public Boolean mostrares_con_sub_total_facturaTipoRetencion=true;
	public Boolean activares_con_sub_total_facturaTipoRetencion=true;

	public Border resaltares_con_secuencialTipoRetencion=null;
	public Boolean mostrares_con_secuencialTipoRetencion=true;
	public Boolean activares_con_secuencialTipoRetencion=true;

	
	

	public Border setResaltaridTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltaridTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRetencion() {
		return this.resaltaridTipoRetencion;
	}

	public void setResaltaridTipoRetencion(Border borderResaltar) {
		this.resaltaridTipoRetencion= borderResaltar;
	}

	public Boolean getMostraridTipoRetencion() {
		return this.mostraridTipoRetencion;
	}

	public void setMostraridTipoRetencion(Boolean mostraridTipoRetencion) {
		this.mostraridTipoRetencion= mostraridTipoRetencion;
	}

	public Boolean getActivaridTipoRetencion() {
		return this.activaridTipoRetencion;
	}

	public void setActivaridTipoRetencion(Boolean activaridTipoRetencion) {
		this.activaridTipoRetencion= activaridTipoRetencion;
	}

	public Border setResaltarid_empresaTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoRetencion() {
		return this.resaltarid_empresaTipoRetencion;
	}

	public void setResaltarid_empresaTipoRetencion(Border borderResaltar) {
		this.resaltarid_empresaTipoRetencion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoRetencion() {
		return this.mostrarid_empresaTipoRetencion;
	}

	public void setMostrarid_empresaTipoRetencion(Boolean mostrarid_empresaTipoRetencion) {
		this.mostrarid_empresaTipoRetencion= mostrarid_empresaTipoRetencion;
	}

	public Boolean getActivarid_empresaTipoRetencion() {
		return this.activarid_empresaTipoRetencion;
	}

	public void setActivarid_empresaTipoRetencion(Boolean activarid_empresaTipoRetencion) {
		this.activarid_empresaTipoRetencion= activarid_empresaTipoRetencion;
	}

	public Boolean getCargarid_empresaTipoRetencion() {
		return this.cargarid_empresaTipoRetencion;
	}

	public void setCargarid_empresaTipoRetencion(Boolean cargarid_empresaTipoRetencion) {
		this.cargarid_empresaTipoRetencion= cargarid_empresaTipoRetencion;
	}

	public Border setResaltarnombreTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRetencion() {
		return this.resaltarnombreTipoRetencion;
	}

	public void setResaltarnombreTipoRetencion(Border borderResaltar) {
		this.resaltarnombreTipoRetencion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRetencion() {
		return this.mostrarnombreTipoRetencion;
	}

	public void setMostrarnombreTipoRetencion(Boolean mostrarnombreTipoRetencion) {
		this.mostrarnombreTipoRetencion= mostrarnombreTipoRetencion;
	}

	public Boolean getActivarnombreTipoRetencion() {
		return this.activarnombreTipoRetencion;
	}

	public void setActivarnombreTipoRetencion(Boolean activarnombreTipoRetencion) {
		this.activarnombreTipoRetencion= activarnombreTipoRetencion;
	}

	public Border setResaltarcodigoTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRetencion() {
		return this.resaltarcodigoTipoRetencion;
	}

	public void setResaltarcodigoTipoRetencion(Border borderResaltar) {
		this.resaltarcodigoTipoRetencion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRetencion() {
		return this.mostrarcodigoTipoRetencion;
	}

	public void setMostrarcodigoTipoRetencion(Boolean mostrarcodigoTipoRetencion) {
		this.mostrarcodigoTipoRetencion= mostrarcodigoTipoRetencion;
	}

	public Boolean getActivarcodigoTipoRetencion() {
		return this.activarcodigoTipoRetencion;
	}

	public void setActivarcodigoTipoRetencion(Boolean activarcodigoTipoRetencion) {
		this.activarcodigoTipoRetencion= activarcodigoTipoRetencion;
	}

	public Border setResaltarporcentajeTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltarporcentajeTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeTipoRetencion() {
		return this.resaltarporcentajeTipoRetencion;
	}

	public void setResaltarporcentajeTipoRetencion(Border borderResaltar) {
		this.resaltarporcentajeTipoRetencion= borderResaltar;
	}

	public Boolean getMostrarporcentajeTipoRetencion() {
		return this.mostrarporcentajeTipoRetencion;
	}

	public void setMostrarporcentajeTipoRetencion(Boolean mostrarporcentajeTipoRetencion) {
		this.mostrarporcentajeTipoRetencion= mostrarporcentajeTipoRetencion;
	}

	public Boolean getActivarporcentajeTipoRetencion() {
		return this.activarporcentajeTipoRetencion;
	}

	public void setActivarporcentajeTipoRetencion(Boolean activarporcentajeTipoRetencion) {
		this.activarporcentajeTipoRetencion= activarporcentajeTipoRetencion;
	}

	public Border setResaltarmonto_minimoTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltarmonto_minimoTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_minimoTipoRetencion() {
		return this.resaltarmonto_minimoTipoRetencion;
	}

	public void setResaltarmonto_minimoTipoRetencion(Border borderResaltar) {
		this.resaltarmonto_minimoTipoRetencion= borderResaltar;
	}

	public Boolean getMostrarmonto_minimoTipoRetencion() {
		return this.mostrarmonto_minimoTipoRetencion;
	}

	public void setMostrarmonto_minimoTipoRetencion(Boolean mostrarmonto_minimoTipoRetencion) {
		this.mostrarmonto_minimoTipoRetencion= mostrarmonto_minimoTipoRetencion;
	}

	public Boolean getActivarmonto_minimoTipoRetencion() {
		return this.activarmonto_minimoTipoRetencion;
	}

	public void setActivarmonto_minimoTipoRetencion(Boolean activarmonto_minimoTipoRetencion) {
		this.activarmonto_minimoTipoRetencion= activarmonto_minimoTipoRetencion;
	}

	public Border setResaltarid_cuenta_contableTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableTipoRetencion() {
		return this.resaltarid_cuenta_contableTipoRetencion;
	}

	public void setResaltarid_cuenta_contableTipoRetencion(Border borderResaltar) {
		this.resaltarid_cuenta_contableTipoRetencion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableTipoRetencion() {
		return this.mostrarid_cuenta_contableTipoRetencion;
	}

	public void setMostrarid_cuenta_contableTipoRetencion(Boolean mostrarid_cuenta_contableTipoRetencion) {
		this.mostrarid_cuenta_contableTipoRetencion= mostrarid_cuenta_contableTipoRetencion;
	}

	public Boolean getActivarid_cuenta_contableTipoRetencion() {
		return this.activarid_cuenta_contableTipoRetencion;
	}

	public void setActivarid_cuenta_contableTipoRetencion(Boolean activarid_cuenta_contableTipoRetencion) {
		this.activarid_cuenta_contableTipoRetencion= activarid_cuenta_contableTipoRetencion;
	}

	public Boolean getCargarid_cuenta_contableTipoRetencion() {
		return this.cargarid_cuenta_contableTipoRetencion;
	}

	public void setCargarid_cuenta_contableTipoRetencion(Boolean cargarid_cuenta_contableTipoRetencion) {
		this.cargarid_cuenta_contableTipoRetencion= cargarid_cuenta_contableTipoRetencion;
	}

	public Border setResaltarid_cuenta_contable_creditoTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoTipoRetencion() {
		return this.resaltarid_cuenta_contable_creditoTipoRetencion;
	}

	public void setResaltarid_cuenta_contable_creditoTipoRetencion(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoTipoRetencion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoTipoRetencion() {
		return this.mostrarid_cuenta_contable_creditoTipoRetencion;
	}

	public void setMostrarid_cuenta_contable_creditoTipoRetencion(Boolean mostrarid_cuenta_contable_creditoTipoRetencion) {
		this.mostrarid_cuenta_contable_creditoTipoRetencion= mostrarid_cuenta_contable_creditoTipoRetencion;
	}

	public Boolean getActivarid_cuenta_contable_creditoTipoRetencion() {
		return this.activarid_cuenta_contable_creditoTipoRetencion;
	}

	public void setActivarid_cuenta_contable_creditoTipoRetencion(Boolean activarid_cuenta_contable_creditoTipoRetencion) {
		this.activarid_cuenta_contable_creditoTipoRetencion= activarid_cuenta_contable_creditoTipoRetencion;
	}

	public Boolean getCargarid_cuenta_contable_creditoTipoRetencion() {
		return this.cargarid_cuenta_contable_creditoTipoRetencion;
	}

	public void setCargarid_cuenta_contable_creditoTipoRetencion(Boolean cargarid_cuenta_contable_creditoTipoRetencion) {
		this.cargarid_cuenta_contable_creditoTipoRetencion= cargarid_cuenta_contable_creditoTipoRetencion;
	}

	public Border setResaltares_retencion_ivaTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltares_retencion_ivaTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_retencion_ivaTipoRetencion() {
		return this.resaltares_retencion_ivaTipoRetencion;
	}

	public void setResaltares_retencion_ivaTipoRetencion(Border borderResaltar) {
		this.resaltares_retencion_ivaTipoRetencion= borderResaltar;
	}

	public Boolean getMostrares_retencion_ivaTipoRetencion() {
		return this.mostrares_retencion_ivaTipoRetencion;
	}

	public void setMostrares_retencion_ivaTipoRetencion(Boolean mostrares_retencion_ivaTipoRetencion) {
		this.mostrares_retencion_ivaTipoRetencion= mostrares_retencion_ivaTipoRetencion;
	}

	public Boolean getActivares_retencion_ivaTipoRetencion() {
		return this.activares_retencion_ivaTipoRetencion;
	}

	public void setActivares_retencion_ivaTipoRetencion(Boolean activares_retencion_ivaTipoRetencion) {
		this.activares_retencion_ivaTipoRetencion= activares_retencion_ivaTipoRetencion;
	}

	public Border setResaltares_debitoTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltares_debitoTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_debitoTipoRetencion() {
		return this.resaltares_debitoTipoRetencion;
	}

	public void setResaltares_debitoTipoRetencion(Border borderResaltar) {
		this.resaltares_debitoTipoRetencion= borderResaltar;
	}

	public Boolean getMostrares_debitoTipoRetencion() {
		return this.mostrares_debitoTipoRetencion;
	}

	public void setMostrares_debitoTipoRetencion(Boolean mostrares_debitoTipoRetencion) {
		this.mostrares_debitoTipoRetencion= mostrares_debitoTipoRetencion;
	}

	public Boolean getActivares_debitoTipoRetencion() {
		return this.activares_debitoTipoRetencion;
	}

	public void setActivares_debitoTipoRetencion(Boolean activares_debitoTipoRetencion) {
		this.activares_debitoTipoRetencion= activares_debitoTipoRetencion;
	}

	public Border setResaltares_con_iva_facturaTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltares_con_iva_facturaTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_con_iva_facturaTipoRetencion() {
		return this.resaltares_con_iva_facturaTipoRetencion;
	}

	public void setResaltares_con_iva_facturaTipoRetencion(Border borderResaltar) {
		this.resaltares_con_iva_facturaTipoRetencion= borderResaltar;
	}

	public Boolean getMostrares_con_iva_facturaTipoRetencion() {
		return this.mostrares_con_iva_facturaTipoRetencion;
	}

	public void setMostrares_con_iva_facturaTipoRetencion(Boolean mostrares_con_iva_facturaTipoRetencion) {
		this.mostrares_con_iva_facturaTipoRetencion= mostrares_con_iva_facturaTipoRetencion;
	}

	public Boolean getActivares_con_iva_facturaTipoRetencion() {
		return this.activares_con_iva_facturaTipoRetencion;
	}

	public void setActivares_con_iva_facturaTipoRetencion(Boolean activares_con_iva_facturaTipoRetencion) {
		this.activares_con_iva_facturaTipoRetencion= activares_con_iva_facturaTipoRetencion;
	}

	public Border setResaltares_con_sub_total_facturaTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltares_con_sub_total_facturaTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_con_sub_total_facturaTipoRetencion() {
		return this.resaltares_con_sub_total_facturaTipoRetencion;
	}

	public void setResaltares_con_sub_total_facturaTipoRetencion(Border borderResaltar) {
		this.resaltares_con_sub_total_facturaTipoRetencion= borderResaltar;
	}

	public Boolean getMostrares_con_sub_total_facturaTipoRetencion() {
		return this.mostrares_con_sub_total_facturaTipoRetencion;
	}

	public void setMostrares_con_sub_total_facturaTipoRetencion(Boolean mostrares_con_sub_total_facturaTipoRetencion) {
		this.mostrares_con_sub_total_facturaTipoRetencion= mostrares_con_sub_total_facturaTipoRetencion;
	}

	public Boolean getActivares_con_sub_total_facturaTipoRetencion() {
		return this.activares_con_sub_total_facturaTipoRetencion;
	}

	public void setActivares_con_sub_total_facturaTipoRetencion(Boolean activares_con_sub_total_facturaTipoRetencion) {
		this.activares_con_sub_total_facturaTipoRetencion= activares_con_sub_total_facturaTipoRetencion;
	}

	public Border setResaltares_con_secuencialTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionBeanSwingJInternalFrame.jTtoolBarTipoRetencion.setBorder(borderResaltar);
		
		this.resaltares_con_secuencialTipoRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_con_secuencialTipoRetencion() {
		return this.resaltares_con_secuencialTipoRetencion;
	}

	public void setResaltares_con_secuencialTipoRetencion(Border borderResaltar) {
		this.resaltares_con_secuencialTipoRetencion= borderResaltar;
	}

	public Boolean getMostrares_con_secuencialTipoRetencion() {
		return this.mostrares_con_secuencialTipoRetencion;
	}

	public void setMostrares_con_secuencialTipoRetencion(Boolean mostrares_con_secuencialTipoRetencion) {
		this.mostrares_con_secuencialTipoRetencion= mostrares_con_secuencialTipoRetencion;
	}

	public Boolean getActivares_con_secuencialTipoRetencion() {
		return this.activares_con_secuencialTipoRetencion;
	}

	public void setActivares_con_secuencialTipoRetencion(Boolean activares_con_secuencialTipoRetencion) {
		this.activares_con_secuencialTipoRetencion= activares_con_secuencialTipoRetencion;
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
		
		
		this.setMostraridTipoRetencion(esInicial);
		this.setMostrarid_empresaTipoRetencion(esInicial);
		this.setMostrarnombreTipoRetencion(esInicial);
		this.setMostrarcodigoTipoRetencion(esInicial);
		this.setMostrarporcentajeTipoRetencion(esInicial);
		this.setMostrarmonto_minimoTipoRetencion(esInicial);
		this.setMostrarid_cuenta_contableTipoRetencion(esInicial);
		this.setMostrarid_cuenta_contable_creditoTipoRetencion(esInicial);
		this.setMostrares_retencion_ivaTipoRetencion(esInicial);
		this.setMostrares_debitoTipoRetencion(esInicial);
		this.setMostrares_con_iva_facturaTipoRetencion(esInicial);
		this.setMostrares_con_sub_total_facturaTipoRetencion(esInicial);
		this.setMostrares_con_secuencialTipoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ID)) {
				this.setMostraridTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setMostrarmonto_minimoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESRETENCIONIVA)) {
				this.setMostrares_retencion_ivaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESDEBITO)) {
				this.setMostrares_debitoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONIVAFACTURA)) {
				this.setMostrares_con_iva_facturaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA)) {
				this.setMostrares_con_sub_total_facturaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONSECUENCIAL)) {
				this.setMostrares_con_secuencialTipoRetencion(esAsigna);
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
		
		
		this.setActivaridTipoRetencion(esInicial);
		this.setActivarid_empresaTipoRetencion(esInicial);
		this.setActivarnombreTipoRetencion(esInicial);
		this.setActivarcodigoTipoRetencion(esInicial);
		this.setActivarporcentajeTipoRetencion(esInicial);
		this.setActivarmonto_minimoTipoRetencion(esInicial);
		this.setActivarid_cuenta_contableTipoRetencion(esInicial);
		this.setActivarid_cuenta_contable_creditoTipoRetencion(esInicial);
		this.setActivares_retencion_ivaTipoRetencion(esInicial);
		this.setActivares_debitoTipoRetencion(esInicial);
		this.setActivares_con_iva_facturaTipoRetencion(esInicial);
		this.setActivares_con_sub_total_facturaTipoRetencion(esInicial);
		this.setActivares_con_secuencialTipoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ID)) {
				this.setActivaridTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setActivarmonto_minimoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESRETENCIONIVA)) {
				this.setActivares_retencion_ivaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESDEBITO)) {
				this.setActivares_debitoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONIVAFACTURA)) {
				this.setActivares_con_iva_facturaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA)) {
				this.setActivares_con_sub_total_facturaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONSECUENCIAL)) {
				this.setActivares_con_secuencialTipoRetencion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRetencion(esInicial);
		this.setResaltarid_empresaTipoRetencion(esInicial);
		this.setResaltarnombreTipoRetencion(esInicial);
		this.setResaltarcodigoTipoRetencion(esInicial);
		this.setResaltarporcentajeTipoRetencion(esInicial);
		this.setResaltarmonto_minimoTipoRetencion(esInicial);
		this.setResaltarid_cuenta_contableTipoRetencion(esInicial);
		this.setResaltarid_cuenta_contable_creditoTipoRetencion(esInicial);
		this.setResaltares_retencion_ivaTipoRetencion(esInicial);
		this.setResaltares_debitoTipoRetencion(esInicial);
		this.setResaltares_con_iva_facturaTipoRetencion(esInicial);
		this.setResaltares_con_sub_total_facturaTipoRetencion(esInicial);
		this.setResaltares_con_secuencialTipoRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ID)) {
				this.setResaltaridTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setResaltarmonto_minimoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESRETENCIONIVA)) {
				this.setResaltares_retencion_ivaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESDEBITO)) {
				this.setResaltares_debitoTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONIVAFACTURA)) {
				this.setResaltares_con_iva_facturaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONSUBTOTALFACTURA)) {
				this.setResaltares_con_sub_total_facturaTipoRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionConstantesFunciones.ESCONSECUENCIAL)) {
				this.setResaltares_con_secuencialTipoRetencion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPoNombreTipoRetencion=true;

	public Boolean getMostrarBusquedaPoNombreTipoRetencion() {
		return this.mostrarBusquedaPoNombreTipoRetencion;
	}

	public void setMostrarBusquedaPoNombreTipoRetencion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPoNombreTipoRetencion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorCodigoSriTipoRetencion=true;

	public Boolean getMostrarBusquedaPorCodigoSriTipoRetencion() {
		return this.mostrarBusquedaPorCodigoSriTipoRetencion;
	}

	public void setMostrarBusquedaPorCodigoSriTipoRetencion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoSriTipoRetencion= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorIdTipoRetencion=true;

	public Boolean getMostrarBusquedaPorIdTipoRetencion() {
		return this.mostrarBusquedaPorIdTipoRetencion;
	}

	public void setMostrarBusquedaPorIdTipoRetencion(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoRetencion=true;

	public Boolean getMostrarFK_IdEmpresaTipoRetencion() {
		return this.mostrarFK_IdEmpresaTipoRetencion;
	}

	public void setMostrarFK_IdEmpresaTipoRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoRetencion= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPoNombreTipoRetencion=true;

	public Boolean getActivarBusquedaPoNombreTipoRetencion() {
		return this.activarBusquedaPoNombreTipoRetencion;
	}

	public void setActivarBusquedaPoNombreTipoRetencion(Boolean habilitarResaltar) {
		this.activarBusquedaPoNombreTipoRetencion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorCodigoSriTipoRetencion=true;

	public Boolean getActivarBusquedaPorCodigoSriTipoRetencion() {
		return this.activarBusquedaPorCodigoSriTipoRetencion;
	}

	public void setActivarBusquedaPorCodigoSriTipoRetencion(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoSriTipoRetencion= habilitarResaltar;
	}

	public Boolean activarBusquedaPorIdTipoRetencion=true;

	public Boolean getActivarBusquedaPorIdTipoRetencion() {
		return this.activarBusquedaPorIdTipoRetencion;
	}

	public void setActivarBusquedaPorIdTipoRetencion(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoRetencion=true;

	public Boolean getActivarFK_IdEmpresaTipoRetencion() {
		return this.activarFK_IdEmpresaTipoRetencion;
	}

	public void setActivarFK_IdEmpresaTipoRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoRetencion= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPoNombreTipoRetencion=null;

	public Border getResaltarBusquedaPoNombreTipoRetencion() {
		return this.resaltarBusquedaPoNombreTipoRetencion;
	}

	public void setResaltarBusquedaPoNombreTipoRetencion(Border borderResaltar) {
		this.resaltarBusquedaPoNombreTipoRetencion= borderResaltar;
	}

	public void setResaltarBusquedaPoNombreTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPoNombreTipoRetencion= borderResaltar;
	}

	public Border resaltarBusquedaPorCodigoSriTipoRetencion=null;

	public Border getResaltarBusquedaPorCodigoSriTipoRetencion() {
		return this.resaltarBusquedaPorCodigoSriTipoRetencion;
	}

	public void setResaltarBusquedaPorCodigoSriTipoRetencion(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoSriTipoRetencion= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoSriTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoSriTipoRetencion= borderResaltar;
	}

	public Border resaltarBusquedaPorIdTipoRetencion=null;

	public Border getResaltarBusquedaPorIdTipoRetencion() {
		return this.resaltarBusquedaPorIdTipoRetencion;
	}

	public void setResaltarBusquedaPorIdTipoRetencion(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoRetencion= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoRetencion=null;

	public Border getResaltarFK_IdEmpresaTipoRetencion() {
		return this.resaltarFK_IdEmpresaTipoRetencion;
	}

	public void setResaltarFK_IdEmpresaTipoRetencion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionBeanSwingJInternalFrame tiporetencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoRetencion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}