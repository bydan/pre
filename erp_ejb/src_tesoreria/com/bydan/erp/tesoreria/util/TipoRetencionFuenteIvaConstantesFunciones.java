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


import com.bydan.erp.tesoreria.util.TipoRetencionFuenteIvaConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoRetencionFuenteIvaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoRetencionFuenteIvaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



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
final public class TipoRetencionFuenteIvaConstantesFunciones extends TipoRetencionFuenteIvaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRetencionFuenteIva";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRetencionFuenteIva"+TipoRetencionFuenteIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRetencionFuenteIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRetencionFuenteIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"_"+TipoRetencionFuenteIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRetencionFuenteIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"_"+TipoRetencionFuenteIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"_"+TipoRetencionFuenteIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRetencionFuenteIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"_"+TipoRetencionFuenteIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionFuenteIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRetencionFuenteIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionFuenteIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionFuenteIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRetencionFuenteIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRetencionFuenteIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRetencionFuenteIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRetencionFuenteIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRetencionFuenteIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRetencionFuenteIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Retencion Fuente Ivas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Retencion Fuente Iva";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Retencion Fuente Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRetencionFuenteIva";
	public static final String OBJECTNAME="tiporetencionfuenteiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_retencion_fuente_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporetencionfuenteiva from "+TipoRetencionFuenteIvaConstantesFunciones.SPERSISTENCENAME+" tiporetencionfuenteiva";
	public static String QUERYSELECTNATIVE="select "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".version_row,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id_pais,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".codigo,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".nombre,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".porcentaje,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".monto_minimo,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_retencion_iva,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_debito,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_con_iva_factura,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_con_sub_total_factura,"+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME+".es_con_secuencial from "+TipoRetencionFuenteIvaConstantesFunciones.SCHEMA+"."+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME;//+" as "+TipoRetencionFuenteIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRetencionFuenteIvaConstantesFuncionesAdditional tiporetencionfuenteivaConstantesFuncionesAdditional=null;
	
	public TipoRetencionFuenteIvaConstantesFuncionesAdditional getTipoRetencionFuenteIvaConstantesFuncionesAdditional() {
		return this.tiporetencionfuenteivaConstantesFuncionesAdditional;
	}
	
	public void setTipoRetencionFuenteIvaConstantesFuncionesAdditional(TipoRetencionFuenteIvaConstantesFuncionesAdditional tiporetencionfuenteivaConstantesFuncionesAdditional) {
		try {
			this.tiporetencionfuenteivaConstantesFuncionesAdditional=tiporetencionfuenteivaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
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
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
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
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getTipoRetencionFuenteIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.IDPAIS)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.CODIGO)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_MONTOMINIMO;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESRETENCIONIVA;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESDEBITO;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONIVAFACTURA;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA;}
		if(sNombreColumna.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL)) {sLabelColumna=TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSECUENCIAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getes_retencion_ivaDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencionfuenteiva.getes_retencion_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_retencion_ivaHtmlDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencionfuenteiva.getId(),tiporetencionfuenteiva.getes_retencion_iva());

		return sDescripcion;
	}	
		
	public static String getes_debitoDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencionfuenteiva.getes_debito()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_debitoHtmlDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencionfuenteiva.getId(),tiporetencionfuenteiva.getes_debito());

		return sDescripcion;
	}	
		
	public static String getes_con_iva_facturaDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencionfuenteiva.getes_con_iva_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_con_iva_facturaHtmlDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencionfuenteiva.getId(),tiporetencionfuenteiva.getes_con_iva_factura());

		return sDescripcion;
	}	
		
	public static String getes_con_sub_total_facturaDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencionfuenteiva.getes_con_sub_total_factura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_con_sub_total_facturaHtmlDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencionfuenteiva.getId(),tiporetencionfuenteiva.getes_con_sub_total_factura());

		return sDescripcion;
	}	
		
	public static String getes_con_secuencialDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiporetencionfuenteiva.getes_con_secuencial()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_con_secuencialHtmlDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiporetencionfuenteiva.getId(),tiporetencionfuenteiva.getes_con_secuencial());

		return sDescripcion;
	}	
	
	public static String getTipoRetencionFuenteIvaDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporetencionfuenteiva !=null/* && tiporetencionfuenteiva.getId()!=0*/) {
			sDescripcion=tiporetencionfuenteiva.getcodigo()+"-"+tiporetencionfuenteiva.getnombre();//tiporetencionfuenteivatiporetencionfuenteiva.getcodigo().trim()+"-"+tiporetencionfuenteiva.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRetencionFuenteIvaDescripcionDetallado(TipoRetencionFuenteIva tiporetencionfuenteiva) {
		String sDescripcion="";
			
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.ID+"=";
		sDescripcion+=tiporetencionfuenteiva.getId().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporetencionfuenteiva.getVersionRow().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tiporetencionfuenteiva.getid_pais().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporetencionfuenteiva.getcodigo()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporetencionfuenteiva.getnombre()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=tiporetencionfuenteiva.getporcentaje().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO+"=";
		sDescripcion+=tiporetencionfuenteiva.getmonto_minimo().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=tiporetencionfuenteiva.getid_cuenta_contable().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=tiporetencionfuenteiva.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA+"=";
		sDescripcion+=tiporetencionfuenteiva.getes_retencion_iva().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO+"=";
		sDescripcion+=tiporetencionfuenteiva.getes_debito().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA+"=";
		sDescripcion+=tiporetencionfuenteiva.getes_con_iva_factura().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA+"=";
		sDescripcion+=tiporetencionfuenteiva.getes_con_sub_total_factura().toString()+",";
		sDescripcion+=TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL+"=";
		sDescripcion+=tiporetencionfuenteiva.getes_con_secuencial().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRetencionFuenteIvaDescripcion(TipoRetencionFuenteIva tiporetencionfuenteiva,String sValor) throws Exception {			
		if(tiporetencionfuenteiva !=null) {
			tiporetencionfuenteiva.setcodigo(sValor);
tiporetencionfuenteiva.setnombre(sValor);;//tiporetencionfuenteivatiporetencionfuenteiva.getcodigo().trim()+"-"+tiporetencionfuenteiva.getnombre().trim();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoRetencionFuenteIva(TipoRetencionFuenteIva tiporetencionfuenteiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporetencionfuenteiva.setcodigo(tiporetencionfuenteiva.getcodigo().trim());
		tiporetencionfuenteiva.setnombre(tiporetencionfuenteiva.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRetencionFuenteIvas(List<TipoRetencionFuenteIva> tiporetencionfuenteivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRetencionFuenteIva tiporetencionfuenteiva: tiporetencionfuenteivas) {
			tiporetencionfuenteiva.setcodigo(tiporetencionfuenteiva.getcodigo().trim());
			tiporetencionfuenteiva.setnombre(tiporetencionfuenteiva.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRetencionFuenteIva(TipoRetencionFuenteIva tiporetencionfuenteiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporetencionfuenteiva.getConCambioAuxiliar()) {
			tiporetencionfuenteiva.setIsDeleted(tiporetencionfuenteiva.getIsDeletedAuxiliar());	
			tiporetencionfuenteiva.setIsNew(tiporetencionfuenteiva.getIsNewAuxiliar());	
			tiporetencionfuenteiva.setIsChanged(tiporetencionfuenteiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporetencionfuenteiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporetencionfuenteiva.setIsDeletedAuxiliar(false);	
			tiporetencionfuenteiva.setIsNewAuxiliar(false);	
			tiporetencionfuenteiva.setIsChangedAuxiliar(false);
			
			tiporetencionfuenteiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRetencionFuenteIvas(List<TipoRetencionFuenteIva> tiporetencionfuenteivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRetencionFuenteIva tiporetencionfuenteiva : tiporetencionfuenteivas) {
			if(conAsignarBase && tiporetencionfuenteiva.getConCambioAuxiliar()) {
				tiporetencionfuenteiva.setIsDeleted(tiporetencionfuenteiva.getIsDeletedAuxiliar());	
				tiporetencionfuenteiva.setIsNew(tiporetencionfuenteiva.getIsNewAuxiliar());	
				tiporetencionfuenteiva.setIsChanged(tiporetencionfuenteiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporetencionfuenteiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporetencionfuenteiva.setIsDeletedAuxiliar(false);	
				tiporetencionfuenteiva.setIsNewAuxiliar(false);	
				tiporetencionfuenteiva.setIsChangedAuxiliar(false);
				
				tiporetencionfuenteiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRetencionFuenteIva(TipoRetencionFuenteIva tiporetencionfuenteiva,Boolean conEnteros) throws Exception  {
		tiporetencionfuenteiva.setporcentaje(0.0);
		tiporetencionfuenteiva.setmonto_minimo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRetencionFuenteIvas(List<TipoRetencionFuenteIva> tiporetencionfuenteivas,Boolean conEnteros) throws Exception  {
		
		for(TipoRetencionFuenteIva tiporetencionfuenteiva: tiporetencionfuenteivas) {
			tiporetencionfuenteiva.setporcentaje(0.0);
			tiporetencionfuenteiva.setmonto_minimo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRetencionFuenteIva(List<TipoRetencionFuenteIva> tiporetencionfuenteivas,TipoRetencionFuenteIva tiporetencionfuenteivaAux) throws Exception  {
		TipoRetencionFuenteIvaConstantesFunciones.InicializarValoresTipoRetencionFuenteIva(tiporetencionfuenteivaAux,true);
		
		for(TipoRetencionFuenteIva tiporetencionfuenteiva: tiporetencionfuenteivas) {
			if(tiporetencionfuenteiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tiporetencionfuenteivaAux.setporcentaje(tiporetencionfuenteivaAux.getporcentaje()+tiporetencionfuenteiva.getporcentaje());			
			tiporetencionfuenteivaAux.setmonto_minimo(tiporetencionfuenteivaAux.getmonto_minimo()+tiporetencionfuenteiva.getmonto_minimo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRetencionFuenteIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRetencionFuenteIvaConstantesFunciones.getArrayColumnasGlobalesTipoRetencionFuenteIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRetencionFuenteIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRetencionFuenteIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRetencionFuenteIva> tiporetencionfuenteivas,TipoRetencionFuenteIva tiporetencionfuenteiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRetencionFuenteIva tiporetencionfuenteivaAux: tiporetencionfuenteivas) {
			if(tiporetencionfuenteivaAux!=null && tiporetencionfuenteiva!=null) {
				if((tiporetencionfuenteivaAux.getId()==null && tiporetencionfuenteiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporetencionfuenteivaAux.getId()!=null && tiporetencionfuenteiva.getId()!=null){
					if(tiporetencionfuenteivaAux.getId().equals(tiporetencionfuenteiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRetencionFuenteIva(List<TipoRetencionFuenteIva> tiporetencionfuenteivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double monto_minimoTotal=0.0;
	
		for(TipoRetencionFuenteIva tiporetencionfuenteiva: tiporetencionfuenteivas) {			
			if(tiporetencionfuenteiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=tiporetencionfuenteiva.getporcentaje();
			monto_minimoTotal+=tiporetencionfuenteiva.getmonto_minimo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO);
		datoGeneral.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_MONTOMINIMO);
		datoGeneral.setdValorDouble(monto_minimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRetencionFuenteIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_ID, TipoRetencionFuenteIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_VERSIONROW, TipoRetencionFuenteIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDPAIS, TipoRetencionFuenteIvaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_CODIGO, TipoRetencionFuenteIvaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_NOMBRE, TipoRetencionFuenteIvaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_PORCENTAJE, TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_MONTOMINIMO, TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLE, TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESRETENCIONIVA, TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESDEBITO, TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONIVAFACTURA, TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA, TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSECUENCIAL, TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRetencionFuenteIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencionFuenteIva() throws Exception  {
		return TipoRetencionFuenteIvaConstantesFunciones.getTiposSeleccionarTipoRetencionFuenteIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencionFuenteIva(Boolean conFk) throws Exception  {
		return TipoRetencionFuenteIvaConstantesFunciones.getTiposSeleccionarTipoRetencionFuenteIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRetencionFuenteIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_MONTOMINIMO);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_MONTOMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESRETENCIONIVA);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESRETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESDEBITO);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONIVAFACTURA);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONIVAFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSECUENCIAL);
			reporte.setsDescripcion(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRetencionFuenteIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(TipoRetencionFuenteIva tiporetencionfuenteivaAux) throws Exception {
		
			tiporetencionfuenteivaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tiporetencionfuenteivaAux.getPais()));
			tiporetencionfuenteivaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tiporetencionfuenteivaAux.getCuentaContable()));
			tiporetencionfuenteivaAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tiporetencionfuenteivaAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRetencionFuenteIva(List<TipoRetencionFuenteIva> tiporetencionfuenteivasTemp) throws Exception {
		for(TipoRetencionFuenteIva tiporetencionfuenteivaAux:tiporetencionfuenteivasTemp) {
			
			tiporetencionfuenteivaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tiporetencionfuenteivaAux.getPais()));
			tiporetencionfuenteivaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tiporetencionfuenteivaAux.getCuentaContable()));
			tiporetencionfuenteivaAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tiporetencionfuenteivaAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRetencionFuenteIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRetencionFuenteIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRetencionFuenteIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRetencionFuenteIvaConstantesFunciones.getClassesRelationshipsOfTipoRetencionFuenteIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRetencionFuenteIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRetencionFuenteIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRetencionFuenteIvaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRetencionFuenteIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRetencionFuenteIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoRetencionFuenteIva tiporetencionfuenteiva,List<TipoRetencionFuenteIva> tiporetencionfuenteivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRetencionFuenteIva tiporetencionfuenteivaEncontrado=null;
			
			for(TipoRetencionFuenteIva tiporetencionfuenteivaLocal:tiporetencionfuenteivas) {
				if(tiporetencionfuenteivaLocal.getId().equals(tiporetencionfuenteiva.getId())) {
					tiporetencionfuenteivaEncontrado=tiporetencionfuenteivaLocal;
					
					tiporetencionfuenteivaLocal.setIsChanged(tiporetencionfuenteiva.getIsChanged());
					tiporetencionfuenteivaLocal.setIsNew(tiporetencionfuenteiva.getIsNew());
					tiporetencionfuenteivaLocal.setIsDeleted(tiporetencionfuenteiva.getIsDeleted());
					
					tiporetencionfuenteivaLocal.setGeneralEntityOriginal(tiporetencionfuenteiva.getGeneralEntityOriginal());
					
					tiporetencionfuenteivaLocal.setId(tiporetencionfuenteiva.getId());	
					tiporetencionfuenteivaLocal.setVersionRow(tiporetencionfuenteiva.getVersionRow());	
					tiporetencionfuenteivaLocal.setid_pais(tiporetencionfuenteiva.getid_pais());	
					tiporetencionfuenteivaLocal.setcodigo(tiporetencionfuenteiva.getcodigo());	
					tiporetencionfuenteivaLocal.setnombre(tiporetencionfuenteiva.getnombre());	
					tiporetencionfuenteivaLocal.setporcentaje(tiporetencionfuenteiva.getporcentaje());	
					tiporetencionfuenteivaLocal.setmonto_minimo(tiporetencionfuenteiva.getmonto_minimo());	
					tiporetencionfuenteivaLocal.setid_cuenta_contable(tiporetencionfuenteiva.getid_cuenta_contable());	
					tiporetencionfuenteivaLocal.setid_cuenta_contable_credito(tiporetencionfuenteiva.getid_cuenta_contable_credito());	
					tiporetencionfuenteivaLocal.setes_retencion_iva(tiporetencionfuenteiva.getes_retencion_iva());	
					tiporetencionfuenteivaLocal.setes_debito(tiporetencionfuenteiva.getes_debito());	
					tiporetencionfuenteivaLocal.setes_con_iva_factura(tiporetencionfuenteiva.getes_con_iva_factura());	
					tiporetencionfuenteivaLocal.setes_con_sub_total_factura(tiporetencionfuenteiva.getes_con_sub_total_factura());	
					tiporetencionfuenteivaLocal.setes_con_secuencial(tiporetencionfuenteiva.getes_con_secuencial());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiporetencionfuenteiva.getIsDeleted()) {
				if(!existe) {
					tiporetencionfuenteivas.add(tiporetencionfuenteiva);
				}
			} else {
				if(tiporetencionfuenteivaEncontrado!=null && permiteQuitar)  {
					tiporetencionfuenteivas.remove(tiporetencionfuenteivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRetencionFuenteIva tiporetencionfuenteiva,List<TipoRetencionFuenteIva> tiporetencionfuenteivas) throws Exception {
		try	{			
			for(TipoRetencionFuenteIva tiporetencionfuenteivaLocal:tiporetencionfuenteivas) {
				if(tiporetencionfuenteivaLocal.getId().equals(tiporetencionfuenteiva.getId())) {
					tiporetencionfuenteivaLocal.setIsSelected(tiporetencionfuenteiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRetencionFuenteIva(List<TipoRetencionFuenteIva> tiporetencionfuenteivasAux) throws Exception {
		//this.tiporetencionfuenteivasAux=tiporetencionfuenteivasAux;
		
		for(TipoRetencionFuenteIva tiporetencionfuenteivaAux:tiporetencionfuenteivasAux) {
			if(tiporetencionfuenteivaAux.getIsChanged()) {
				tiporetencionfuenteivaAux.setIsChanged(false);
			}		
			
			if(tiporetencionfuenteivaAux.getIsNew()) {
				tiporetencionfuenteivaAux.setIsNew(false);
			}	
			
			if(tiporetencionfuenteivaAux.getIsDeleted()) {
				tiporetencionfuenteivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRetencionFuenteIva(TipoRetencionFuenteIva tiporetencionfuenteivaAux) throws Exception {
		//this.tiporetencionfuenteivaAux=tiporetencionfuenteivaAux;
		
			if(tiporetencionfuenteivaAux.getIsChanged()) {
				tiporetencionfuenteivaAux.setIsChanged(false);
			}		
			
			if(tiporetencionfuenteivaAux.getIsNew()) {
				tiporetencionfuenteivaAux.setIsNew(false);
			}	
			
			if(tiporetencionfuenteivaAux.getIsDeleted()) {
				tiporetencionfuenteivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRetencionFuenteIva tiporetencionfuenteivaAsignar,TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		tiporetencionfuenteivaAsignar.setId(tiporetencionfuenteiva.getId());	
		tiporetencionfuenteivaAsignar.setVersionRow(tiporetencionfuenteiva.getVersionRow());	
		tiporetencionfuenteivaAsignar.setid_pais(tiporetencionfuenteiva.getid_pais());
		tiporetencionfuenteivaAsignar.setpais_descripcion(tiporetencionfuenteiva.getpais_descripcion());	
		tiporetencionfuenteivaAsignar.setcodigo(tiporetencionfuenteiva.getcodigo());	
		tiporetencionfuenteivaAsignar.setnombre(tiporetencionfuenteiva.getnombre());	
		tiporetencionfuenteivaAsignar.setporcentaje(tiporetencionfuenteiva.getporcentaje());	
		tiporetencionfuenteivaAsignar.setmonto_minimo(tiporetencionfuenteiva.getmonto_minimo());	
		tiporetencionfuenteivaAsignar.setid_cuenta_contable(tiporetencionfuenteiva.getid_cuenta_contable());
		tiporetencionfuenteivaAsignar.setcuentacontable_descripcion(tiporetencionfuenteiva.getcuentacontable_descripcion());	
		tiporetencionfuenteivaAsignar.setid_cuenta_contable_credito(tiporetencionfuenteiva.getid_cuenta_contable_credito());
		tiporetencionfuenteivaAsignar.setcuentacontablecredito_descripcion(tiporetencionfuenteiva.getcuentacontablecredito_descripcion());	
		tiporetencionfuenteivaAsignar.setes_retencion_iva(tiporetencionfuenteiva.getes_retencion_iva());	
		tiporetencionfuenteivaAsignar.setes_debito(tiporetencionfuenteiva.getes_debito());	
		tiporetencionfuenteivaAsignar.setes_con_iva_factura(tiporetencionfuenteiva.getes_con_iva_factura());	
		tiporetencionfuenteivaAsignar.setes_con_sub_total_factura(tiporetencionfuenteiva.getes_con_sub_total_factura());	
		tiporetencionfuenteivaAsignar.setes_con_secuencial(tiporetencionfuenteiva.getes_con_secuencial());	
	}
	
	public static void inicializarTipoRetencionFuenteIva(TipoRetencionFuenteIva tiporetencionfuenteiva) throws Exception {
		try {
				tiporetencionfuenteiva.setId(0L);	
					
				tiporetencionfuenteiva.setid_pais(-1L);	
				tiporetencionfuenteiva.setcodigo("");	
				tiporetencionfuenteiva.setnombre("");	
				tiporetencionfuenteiva.setporcentaje(0.0);	
				tiporetencionfuenteiva.setmonto_minimo(0.0);	
				tiporetencionfuenteiva.setid_cuenta_contable(null);	
				tiporetencionfuenteiva.setid_cuenta_contable_credito(null);	
				tiporetencionfuenteiva.setes_retencion_iva(false);	
				tiporetencionfuenteiva.setes_debito(false);	
				tiporetencionfuenteiva.setes_con_iva_factura(false);	
				tiporetencionfuenteiva.setes_con_sub_total_factura(false);	
				tiporetencionfuenteiva.setes_con_secuencial(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRetencionFuenteIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_MONTOMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESRETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONIVAFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSUBTOTALFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRetencionFuenteIvaConstantesFunciones.LABEL_ESCONSECUENCIAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRetencionFuenteIva(String sTipo,Row row,Workbook workbook,TipoRetencionFuenteIva tiporetencionfuenteiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencionfuenteiva.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencionfuenteiva.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencionfuenteiva.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencionfuenteiva.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencionfuenteiva.getmonto_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencionfuenteiva.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporetencionfuenteiva.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencionfuenteiva.getes_retencion_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencionfuenteiva.getes_debito()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencionfuenteiva.getes_con_iva_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencionfuenteiva.getes_con_sub_total_factura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiporetencionfuenteiva.getes_con_secuencial()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRetencionFuenteIva=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRetencionFuenteIva() {
		return this.sFinalQueryTipoRetencionFuenteIva;
	}
	
	public void setsFinalQueryTipoRetencionFuenteIva(String sFinalQueryTipoRetencionFuenteIva) {
		this.sFinalQueryTipoRetencionFuenteIva= sFinalQueryTipoRetencionFuenteIva;
	}
	
	public Border resaltarSeleccionarTipoRetencionFuenteIva=null;
	
	public Border setResaltarSeleccionarTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRetencionFuenteIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRetencionFuenteIva() {
		return this.resaltarSeleccionarTipoRetencionFuenteIva;
	}
	
	public void setResaltarSeleccionarTipoRetencionFuenteIva(Border borderResaltarSeleccionarTipoRetencionFuenteIva) {
		this.resaltarSeleccionarTipoRetencionFuenteIva= borderResaltarSeleccionarTipoRetencionFuenteIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRetencionFuenteIva=null;
	public Boolean mostraridTipoRetencionFuenteIva=true;
	public Boolean activaridTipoRetencionFuenteIva=true;

	public Border resaltarid_paisTipoRetencionFuenteIva=null;
	public Boolean mostrarid_paisTipoRetencionFuenteIva=true;
	public Boolean activarid_paisTipoRetencionFuenteIva=true;
	public Boolean cargarid_paisTipoRetencionFuenteIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoRetencionFuenteIva=false;//ConEventDepend=true

	public Border resaltarcodigoTipoRetencionFuenteIva=null;
	public Boolean mostrarcodigoTipoRetencionFuenteIva=true;
	public Boolean activarcodigoTipoRetencionFuenteIva=true;

	public Border resaltarnombreTipoRetencionFuenteIva=null;
	public Boolean mostrarnombreTipoRetencionFuenteIva=true;
	public Boolean activarnombreTipoRetencionFuenteIva=true;

	public Border resaltarporcentajeTipoRetencionFuenteIva=null;
	public Boolean mostrarporcentajeTipoRetencionFuenteIva=true;
	public Boolean activarporcentajeTipoRetencionFuenteIva=true;

	public Border resaltarmonto_minimoTipoRetencionFuenteIva=null;
	public Boolean mostrarmonto_minimoTipoRetencionFuenteIva=true;
	public Boolean activarmonto_minimoTipoRetencionFuenteIva=true;

	public Border resaltarid_cuenta_contableTipoRetencionFuenteIva=null;
	public Boolean mostrarid_cuenta_contableTipoRetencionFuenteIva=true;
	public Boolean activarid_cuenta_contableTipoRetencionFuenteIva=true;
	public Boolean cargarid_cuenta_contableTipoRetencionFuenteIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableTipoRetencionFuenteIva=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoTipoRetencionFuenteIva=null;
	public Boolean mostrarid_cuenta_contable_creditoTipoRetencionFuenteIva=true;
	public Boolean activarid_cuenta_contable_creditoTipoRetencionFuenteIva=true;
	public Boolean cargarid_cuenta_contable_creditoTipoRetencionFuenteIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoTipoRetencionFuenteIva=false;//ConEventDepend=true

	public Border resaltares_retencion_ivaTipoRetencionFuenteIva=null;
	public Boolean mostrares_retencion_ivaTipoRetencionFuenteIva=true;
	public Boolean activares_retencion_ivaTipoRetencionFuenteIva=true;

	public Border resaltares_debitoTipoRetencionFuenteIva=null;
	public Boolean mostrares_debitoTipoRetencionFuenteIva=true;
	public Boolean activares_debitoTipoRetencionFuenteIva=true;

	public Border resaltares_con_iva_facturaTipoRetencionFuenteIva=null;
	public Boolean mostrares_con_iva_facturaTipoRetencionFuenteIva=true;
	public Boolean activares_con_iva_facturaTipoRetencionFuenteIva=true;

	public Border resaltares_con_sub_total_facturaTipoRetencionFuenteIva=null;
	public Boolean mostrares_con_sub_total_facturaTipoRetencionFuenteIva=true;
	public Boolean activares_con_sub_total_facturaTipoRetencionFuenteIva=true;

	public Border resaltares_con_secuencialTipoRetencionFuenteIva=null;
	public Boolean mostrares_con_secuencialTipoRetencionFuenteIva=true;
	public Boolean activares_con_secuencialTipoRetencionFuenteIva=true;

	
	

	public Border setResaltaridTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltaridTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRetencionFuenteIva() {
		return this.resaltaridTipoRetencionFuenteIva;
	}

	public void setResaltaridTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltaridTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostraridTipoRetencionFuenteIva() {
		return this.mostraridTipoRetencionFuenteIva;
	}

	public void setMostraridTipoRetencionFuenteIva(Boolean mostraridTipoRetencionFuenteIva) {
		this.mostraridTipoRetencionFuenteIva= mostraridTipoRetencionFuenteIva;
	}

	public Boolean getActivaridTipoRetencionFuenteIva() {
		return this.activaridTipoRetencionFuenteIva;
	}

	public void setActivaridTipoRetencionFuenteIva(Boolean activaridTipoRetencionFuenteIva) {
		this.activaridTipoRetencionFuenteIva= activaridTipoRetencionFuenteIva;
	}

	public Border setResaltarid_paisTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoRetencionFuenteIva() {
		return this.resaltarid_paisTipoRetencionFuenteIva;
	}

	public void setResaltarid_paisTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarid_paisTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoRetencionFuenteIva() {
		return this.mostrarid_paisTipoRetencionFuenteIva;
	}

	public void setMostrarid_paisTipoRetencionFuenteIva(Boolean mostrarid_paisTipoRetencionFuenteIva) {
		this.mostrarid_paisTipoRetencionFuenteIva= mostrarid_paisTipoRetencionFuenteIva;
	}

	public Boolean getActivarid_paisTipoRetencionFuenteIva() {
		return this.activarid_paisTipoRetencionFuenteIva;
	}

	public void setActivarid_paisTipoRetencionFuenteIva(Boolean activarid_paisTipoRetencionFuenteIva) {
		this.activarid_paisTipoRetencionFuenteIva= activarid_paisTipoRetencionFuenteIva;
	}

	public Boolean getCargarid_paisTipoRetencionFuenteIva() {
		return this.cargarid_paisTipoRetencionFuenteIva;
	}

	public void setCargarid_paisTipoRetencionFuenteIva(Boolean cargarid_paisTipoRetencionFuenteIva) {
		this.cargarid_paisTipoRetencionFuenteIva= cargarid_paisTipoRetencionFuenteIva;
	}

	public Border setResaltarcodigoTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRetencionFuenteIva() {
		return this.resaltarcodigoTipoRetencionFuenteIva;
	}

	public void setResaltarcodigoTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarcodigoTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRetencionFuenteIva() {
		return this.mostrarcodigoTipoRetencionFuenteIva;
	}

	public void setMostrarcodigoTipoRetencionFuenteIva(Boolean mostrarcodigoTipoRetencionFuenteIva) {
		this.mostrarcodigoTipoRetencionFuenteIva= mostrarcodigoTipoRetencionFuenteIva;
	}

	public Boolean getActivarcodigoTipoRetencionFuenteIva() {
		return this.activarcodigoTipoRetencionFuenteIva;
	}

	public void setActivarcodigoTipoRetencionFuenteIva(Boolean activarcodigoTipoRetencionFuenteIva) {
		this.activarcodigoTipoRetencionFuenteIva= activarcodigoTipoRetencionFuenteIva;
	}

	public Border setResaltarnombreTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRetencionFuenteIva() {
		return this.resaltarnombreTipoRetencionFuenteIva;
	}

	public void setResaltarnombreTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarnombreTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRetencionFuenteIva() {
		return this.mostrarnombreTipoRetencionFuenteIva;
	}

	public void setMostrarnombreTipoRetencionFuenteIva(Boolean mostrarnombreTipoRetencionFuenteIva) {
		this.mostrarnombreTipoRetencionFuenteIva= mostrarnombreTipoRetencionFuenteIva;
	}

	public Boolean getActivarnombreTipoRetencionFuenteIva() {
		return this.activarnombreTipoRetencionFuenteIva;
	}

	public void setActivarnombreTipoRetencionFuenteIva(Boolean activarnombreTipoRetencionFuenteIva) {
		this.activarnombreTipoRetencionFuenteIva= activarnombreTipoRetencionFuenteIva;
	}

	public Border setResaltarporcentajeTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltarporcentajeTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeTipoRetencionFuenteIva() {
		return this.resaltarporcentajeTipoRetencionFuenteIva;
	}

	public void setResaltarporcentajeTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarporcentajeTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrarporcentajeTipoRetencionFuenteIva() {
		return this.mostrarporcentajeTipoRetencionFuenteIva;
	}

	public void setMostrarporcentajeTipoRetencionFuenteIva(Boolean mostrarporcentajeTipoRetencionFuenteIva) {
		this.mostrarporcentajeTipoRetencionFuenteIva= mostrarporcentajeTipoRetencionFuenteIva;
	}

	public Boolean getActivarporcentajeTipoRetencionFuenteIva() {
		return this.activarporcentajeTipoRetencionFuenteIva;
	}

	public void setActivarporcentajeTipoRetencionFuenteIva(Boolean activarporcentajeTipoRetencionFuenteIva) {
		this.activarporcentajeTipoRetencionFuenteIva= activarporcentajeTipoRetencionFuenteIva;
	}

	public Border setResaltarmonto_minimoTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltarmonto_minimoTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_minimoTipoRetencionFuenteIva() {
		return this.resaltarmonto_minimoTipoRetencionFuenteIva;
	}

	public void setResaltarmonto_minimoTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarmonto_minimoTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrarmonto_minimoTipoRetencionFuenteIva() {
		return this.mostrarmonto_minimoTipoRetencionFuenteIva;
	}

	public void setMostrarmonto_minimoTipoRetencionFuenteIva(Boolean mostrarmonto_minimoTipoRetencionFuenteIva) {
		this.mostrarmonto_minimoTipoRetencionFuenteIva= mostrarmonto_minimoTipoRetencionFuenteIva;
	}

	public Boolean getActivarmonto_minimoTipoRetencionFuenteIva() {
		return this.activarmonto_minimoTipoRetencionFuenteIva;
	}

	public void setActivarmonto_minimoTipoRetencionFuenteIva(Boolean activarmonto_minimoTipoRetencionFuenteIva) {
		this.activarmonto_minimoTipoRetencionFuenteIva= activarmonto_minimoTipoRetencionFuenteIva;
	}

	public Border setResaltarid_cuenta_contableTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableTipoRetencionFuenteIva() {
		return this.resaltarid_cuenta_contableTipoRetencionFuenteIva;
	}

	public void setResaltarid_cuenta_contableTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarid_cuenta_contableTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableTipoRetencionFuenteIva() {
		return this.mostrarid_cuenta_contableTipoRetencionFuenteIva;
	}

	public void setMostrarid_cuenta_contableTipoRetencionFuenteIva(Boolean mostrarid_cuenta_contableTipoRetencionFuenteIva) {
		this.mostrarid_cuenta_contableTipoRetencionFuenteIva= mostrarid_cuenta_contableTipoRetencionFuenteIva;
	}

	public Boolean getActivarid_cuenta_contableTipoRetencionFuenteIva() {
		return this.activarid_cuenta_contableTipoRetencionFuenteIva;
	}

	public void setActivarid_cuenta_contableTipoRetencionFuenteIva(Boolean activarid_cuenta_contableTipoRetencionFuenteIva) {
		this.activarid_cuenta_contableTipoRetencionFuenteIva= activarid_cuenta_contableTipoRetencionFuenteIva;
	}

	public Boolean getCargarid_cuenta_contableTipoRetencionFuenteIva() {
		return this.cargarid_cuenta_contableTipoRetencionFuenteIva;
	}

	public void setCargarid_cuenta_contableTipoRetencionFuenteIva(Boolean cargarid_cuenta_contableTipoRetencionFuenteIva) {
		this.cargarid_cuenta_contableTipoRetencionFuenteIva= cargarid_cuenta_contableTipoRetencionFuenteIva;
	}

	public Border setResaltarid_cuenta_contable_creditoTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoTipoRetencionFuenteIva() {
		return this.resaltarid_cuenta_contable_creditoTipoRetencionFuenteIva;
	}

	public void setResaltarid_cuenta_contable_creditoTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoTipoRetencionFuenteIva() {
		return this.mostrarid_cuenta_contable_creditoTipoRetencionFuenteIva;
	}

	public void setMostrarid_cuenta_contable_creditoTipoRetencionFuenteIva(Boolean mostrarid_cuenta_contable_creditoTipoRetencionFuenteIva) {
		this.mostrarid_cuenta_contable_creditoTipoRetencionFuenteIva= mostrarid_cuenta_contable_creditoTipoRetencionFuenteIva;
	}

	public Boolean getActivarid_cuenta_contable_creditoTipoRetencionFuenteIva() {
		return this.activarid_cuenta_contable_creditoTipoRetencionFuenteIva;
	}

	public void setActivarid_cuenta_contable_creditoTipoRetencionFuenteIva(Boolean activarid_cuenta_contable_creditoTipoRetencionFuenteIva) {
		this.activarid_cuenta_contable_creditoTipoRetencionFuenteIva= activarid_cuenta_contable_creditoTipoRetencionFuenteIva;
	}

	public Boolean getCargarid_cuenta_contable_creditoTipoRetencionFuenteIva() {
		return this.cargarid_cuenta_contable_creditoTipoRetencionFuenteIva;
	}

	public void setCargarid_cuenta_contable_creditoTipoRetencionFuenteIva(Boolean cargarid_cuenta_contable_creditoTipoRetencionFuenteIva) {
		this.cargarid_cuenta_contable_creditoTipoRetencionFuenteIva= cargarid_cuenta_contable_creditoTipoRetencionFuenteIva;
	}

	public Border setResaltares_retencion_ivaTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltares_retencion_ivaTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_retencion_ivaTipoRetencionFuenteIva() {
		return this.resaltares_retencion_ivaTipoRetencionFuenteIva;
	}

	public void setResaltares_retencion_ivaTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltares_retencion_ivaTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrares_retencion_ivaTipoRetencionFuenteIva() {
		return this.mostrares_retencion_ivaTipoRetencionFuenteIva;
	}

	public void setMostrares_retencion_ivaTipoRetencionFuenteIva(Boolean mostrares_retencion_ivaTipoRetencionFuenteIva) {
		this.mostrares_retencion_ivaTipoRetencionFuenteIva= mostrares_retencion_ivaTipoRetencionFuenteIva;
	}

	public Boolean getActivares_retencion_ivaTipoRetencionFuenteIva() {
		return this.activares_retencion_ivaTipoRetencionFuenteIva;
	}

	public void setActivares_retencion_ivaTipoRetencionFuenteIva(Boolean activares_retencion_ivaTipoRetencionFuenteIva) {
		this.activares_retencion_ivaTipoRetencionFuenteIva= activares_retencion_ivaTipoRetencionFuenteIva;
	}

	public Border setResaltares_debitoTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltares_debitoTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_debitoTipoRetencionFuenteIva() {
		return this.resaltares_debitoTipoRetencionFuenteIva;
	}

	public void setResaltares_debitoTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltares_debitoTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrares_debitoTipoRetencionFuenteIva() {
		return this.mostrares_debitoTipoRetencionFuenteIva;
	}

	public void setMostrares_debitoTipoRetencionFuenteIva(Boolean mostrares_debitoTipoRetencionFuenteIva) {
		this.mostrares_debitoTipoRetencionFuenteIva= mostrares_debitoTipoRetencionFuenteIva;
	}

	public Boolean getActivares_debitoTipoRetencionFuenteIva() {
		return this.activares_debitoTipoRetencionFuenteIva;
	}

	public void setActivares_debitoTipoRetencionFuenteIva(Boolean activares_debitoTipoRetencionFuenteIva) {
		this.activares_debitoTipoRetencionFuenteIva= activares_debitoTipoRetencionFuenteIva;
	}

	public Border setResaltares_con_iva_facturaTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltares_con_iva_facturaTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_con_iva_facturaTipoRetencionFuenteIva() {
		return this.resaltares_con_iva_facturaTipoRetencionFuenteIva;
	}

	public void setResaltares_con_iva_facturaTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltares_con_iva_facturaTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrares_con_iva_facturaTipoRetencionFuenteIva() {
		return this.mostrares_con_iva_facturaTipoRetencionFuenteIva;
	}

	public void setMostrares_con_iva_facturaTipoRetencionFuenteIva(Boolean mostrares_con_iva_facturaTipoRetencionFuenteIva) {
		this.mostrares_con_iva_facturaTipoRetencionFuenteIva= mostrares_con_iva_facturaTipoRetencionFuenteIva;
	}

	public Boolean getActivares_con_iva_facturaTipoRetencionFuenteIva() {
		return this.activares_con_iva_facturaTipoRetencionFuenteIva;
	}

	public void setActivares_con_iva_facturaTipoRetencionFuenteIva(Boolean activares_con_iva_facturaTipoRetencionFuenteIva) {
		this.activares_con_iva_facturaTipoRetencionFuenteIva= activares_con_iva_facturaTipoRetencionFuenteIva;
	}

	public Border setResaltares_con_sub_total_facturaTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltares_con_sub_total_facturaTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_con_sub_total_facturaTipoRetencionFuenteIva() {
		return this.resaltares_con_sub_total_facturaTipoRetencionFuenteIva;
	}

	public void setResaltares_con_sub_total_facturaTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltares_con_sub_total_facturaTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrares_con_sub_total_facturaTipoRetencionFuenteIva() {
		return this.mostrares_con_sub_total_facturaTipoRetencionFuenteIva;
	}

	public void setMostrares_con_sub_total_facturaTipoRetencionFuenteIva(Boolean mostrares_con_sub_total_facturaTipoRetencionFuenteIva) {
		this.mostrares_con_sub_total_facturaTipoRetencionFuenteIva= mostrares_con_sub_total_facturaTipoRetencionFuenteIva;
	}

	public Boolean getActivares_con_sub_total_facturaTipoRetencionFuenteIva() {
		return this.activares_con_sub_total_facturaTipoRetencionFuenteIva;
	}

	public void setActivares_con_sub_total_facturaTipoRetencionFuenteIva(Boolean activares_con_sub_total_facturaTipoRetencionFuenteIva) {
		this.activares_con_sub_total_facturaTipoRetencionFuenteIva= activares_con_sub_total_facturaTipoRetencionFuenteIva;
	}

	public Border setResaltares_con_secuencialTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporetencionfuenteivaBeanSwingJInternalFrame.jTtoolBarTipoRetencionFuenteIva.setBorder(borderResaltar);
		
		this.resaltares_con_secuencialTipoRetencionFuenteIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_con_secuencialTipoRetencionFuenteIva() {
		return this.resaltares_con_secuencialTipoRetencionFuenteIva;
	}

	public void setResaltares_con_secuencialTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltares_con_secuencialTipoRetencionFuenteIva= borderResaltar;
	}

	public Boolean getMostrares_con_secuencialTipoRetencionFuenteIva() {
		return this.mostrares_con_secuencialTipoRetencionFuenteIva;
	}

	public void setMostrares_con_secuencialTipoRetencionFuenteIva(Boolean mostrares_con_secuencialTipoRetencionFuenteIva) {
		this.mostrares_con_secuencialTipoRetencionFuenteIva= mostrares_con_secuencialTipoRetencionFuenteIva;
	}

	public Boolean getActivares_con_secuencialTipoRetencionFuenteIva() {
		return this.activares_con_secuencialTipoRetencionFuenteIva;
	}

	public void setActivares_con_secuencialTipoRetencionFuenteIva(Boolean activares_con_secuencialTipoRetencionFuenteIva) {
		this.activares_con_secuencialTipoRetencionFuenteIva= activares_con_secuencialTipoRetencionFuenteIva;
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
		
		
		this.setMostraridTipoRetencionFuenteIva(esInicial);
		this.setMostrarid_paisTipoRetencionFuenteIva(esInicial);
		this.setMostrarcodigoTipoRetencionFuenteIva(esInicial);
		this.setMostrarnombreTipoRetencionFuenteIva(esInicial);
		this.setMostrarporcentajeTipoRetencionFuenteIva(esInicial);
		this.setMostrarmonto_minimoTipoRetencionFuenteIva(esInicial);
		this.setMostrarid_cuenta_contableTipoRetencionFuenteIva(esInicial);
		this.setMostrarid_cuenta_contable_creditoTipoRetencionFuenteIva(esInicial);
		this.setMostrares_retencion_ivaTipoRetencionFuenteIva(esInicial);
		this.setMostrares_debitoTipoRetencionFuenteIva(esInicial);
		this.setMostrares_con_iva_facturaTipoRetencionFuenteIva(esInicial);
		this.setMostrares_con_sub_total_facturaTipoRetencionFuenteIva(esInicial);
		this.setMostrares_con_secuencialTipoRetencionFuenteIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ID)) {
				this.setMostraridTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO)) {
				this.setMostrarmonto_minimoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA)) {
				this.setMostrares_retencion_ivaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO)) {
				this.setMostrares_debitoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA)) {
				this.setMostrares_con_iva_facturaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA)) {
				this.setMostrares_con_sub_total_facturaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL)) {
				this.setMostrares_con_secuencialTipoRetencionFuenteIva(esAsigna);
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
		
		
		this.setActivaridTipoRetencionFuenteIva(esInicial);
		this.setActivarid_paisTipoRetencionFuenteIva(esInicial);
		this.setActivarcodigoTipoRetencionFuenteIva(esInicial);
		this.setActivarnombreTipoRetencionFuenteIva(esInicial);
		this.setActivarporcentajeTipoRetencionFuenteIva(esInicial);
		this.setActivarmonto_minimoTipoRetencionFuenteIva(esInicial);
		this.setActivarid_cuenta_contableTipoRetencionFuenteIva(esInicial);
		this.setActivarid_cuenta_contable_creditoTipoRetencionFuenteIva(esInicial);
		this.setActivares_retencion_ivaTipoRetencionFuenteIva(esInicial);
		this.setActivares_debitoTipoRetencionFuenteIva(esInicial);
		this.setActivares_con_iva_facturaTipoRetencionFuenteIva(esInicial);
		this.setActivares_con_sub_total_facturaTipoRetencionFuenteIva(esInicial);
		this.setActivares_con_secuencialTipoRetencionFuenteIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ID)) {
				this.setActivaridTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO)) {
				this.setActivarmonto_minimoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA)) {
				this.setActivares_retencion_ivaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO)) {
				this.setActivares_debitoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA)) {
				this.setActivares_con_iva_facturaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA)) {
				this.setActivares_con_sub_total_facturaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL)) {
				this.setActivares_con_secuencialTipoRetencionFuenteIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRetencionFuenteIva(esInicial);
		this.setResaltarid_paisTipoRetencionFuenteIva(esInicial);
		this.setResaltarcodigoTipoRetencionFuenteIva(esInicial);
		this.setResaltarnombreTipoRetencionFuenteIva(esInicial);
		this.setResaltarporcentajeTipoRetencionFuenteIva(esInicial);
		this.setResaltarmonto_minimoTipoRetencionFuenteIva(esInicial);
		this.setResaltarid_cuenta_contableTipoRetencionFuenteIva(esInicial);
		this.setResaltarid_cuenta_contable_creditoTipoRetencionFuenteIva(esInicial);
		this.setResaltares_retencion_ivaTipoRetencionFuenteIva(esInicial);
		this.setResaltares_debitoTipoRetencionFuenteIva(esInicial);
		this.setResaltares_con_iva_facturaTipoRetencionFuenteIva(esInicial);
		this.setResaltares_con_sub_total_facturaTipoRetencionFuenteIva(esInicial);
		this.setResaltares_con_secuencialTipoRetencionFuenteIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ID)) {
				this.setResaltaridTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.MONTOMINIMO)) {
				this.setResaltarmonto_minimoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESRETENCIONIVA)) {
				this.setResaltares_retencion_ivaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESDEBITO)) {
				this.setResaltares_debitoTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONIVAFACTURA)) {
				this.setResaltares_con_iva_facturaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONSUBTOTALFACTURA)) {
				this.setResaltares_con_sub_total_facturaTipoRetencionFuenteIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRetencionFuenteIvaConstantesFunciones.ESCONSECUENCIAL)) {
				this.setResaltares_con_secuencialTipoRetencionFuenteIva(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoTipoRetencionFuenteIva=true;

	public Boolean getMostrarBusquedaPorCodigoTipoRetencionFuenteIva() {
		return this.mostrarBusquedaPorCodigoTipoRetencionFuenteIva;
	}

	public void setMostrarBusquedaPorCodigoTipoRetencionFuenteIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoTipoRetencionFuenteIva= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoRetencionFuenteIva=true;

	public Boolean getMostrarBusquedaPorNombreTipoRetencionFuenteIva() {
		return this.mostrarBusquedaPorNombreTipoRetencionFuenteIva;
	}

	public void setMostrarBusquedaPorNombreTipoRetencionFuenteIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoRetencionFuenteIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisTipoRetencionFuenteIva=true;

	public Boolean getMostrarFK_IdPaisTipoRetencionFuenteIva() {
		return this.mostrarFK_IdPaisTipoRetencionFuenteIva;
	}

	public void setMostrarFK_IdPaisTipoRetencionFuenteIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoRetencionFuenteIva= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoTipoRetencionFuenteIva=true;

	public Boolean getActivarBusquedaPorCodigoTipoRetencionFuenteIva() {
		return this.activarBusquedaPorCodigoTipoRetencionFuenteIva;
	}

	public void setActivarBusquedaPorCodigoTipoRetencionFuenteIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoTipoRetencionFuenteIva= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoRetencionFuenteIva=true;

	public Boolean getActivarBusquedaPorNombreTipoRetencionFuenteIva() {
		return this.activarBusquedaPorNombreTipoRetencionFuenteIva;
	}

	public void setActivarBusquedaPorNombreTipoRetencionFuenteIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoRetencionFuenteIva= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisTipoRetencionFuenteIva=true;

	public Boolean getActivarFK_IdPaisTipoRetencionFuenteIva() {
		return this.activarFK_IdPaisTipoRetencionFuenteIva;
	}

	public void setActivarFK_IdPaisTipoRetencionFuenteIva(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoRetencionFuenteIva= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoTipoRetencionFuenteIva=null;

	public Border getResaltarBusquedaPorCodigoTipoRetencionFuenteIva() {
		return this.resaltarBusquedaPorCodigoTipoRetencionFuenteIva;
	}

	public void setResaltarBusquedaPorCodigoTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoTipoRetencionFuenteIva= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoTipoRetencionFuenteIva= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoRetencionFuenteIva=null;

	public Border getResaltarBusquedaPorNombreTipoRetencionFuenteIva() {
		return this.resaltarBusquedaPorNombreTipoRetencionFuenteIva;
	}

	public void setResaltarBusquedaPorNombreTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoRetencionFuenteIva= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoRetencionFuenteIva= borderResaltar;
	}

	public Border resaltarFK_IdPaisTipoRetencionFuenteIva=null;

	public Border getResaltarFK_IdPaisTipoRetencionFuenteIva() {
		return this.resaltarFK_IdPaisTipoRetencionFuenteIva;
	}

	public void setResaltarFK_IdPaisTipoRetencionFuenteIva(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoRetencionFuenteIva= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoRetencionFuenteIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRetencionFuenteIvaBeanSwingJInternalFrame tiporetencionfuenteivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoRetencionFuenteIva= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}