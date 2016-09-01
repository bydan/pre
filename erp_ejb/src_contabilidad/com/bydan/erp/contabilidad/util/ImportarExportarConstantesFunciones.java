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


import com.bydan.erp.contabilidad.util.ImportarExportarConstantesFunciones;
import com.bydan.erp.contabilidad.util.ImportarExportarParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ImportarExportarParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ImportarExportarConstantesFunciones extends ImportarExportarConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ImportarExportar";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ImportarExportar"+ImportarExportarConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ImportarExportarHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ImportarExportarHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ImportarExportarConstantesFunciones.SCHEMA+"_"+ImportarExportarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ImportarExportarHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ImportarExportarConstantesFunciones.SCHEMA+"_"+ImportarExportarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ImportarExportarConstantesFunciones.SCHEMA+"_"+ImportarExportarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ImportarExportarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ImportarExportarConstantesFunciones.SCHEMA+"_"+ImportarExportarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImportarExportarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ImportarExportarHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImportarExportarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImportarExportarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ImportarExportarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImportarExportarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ImportarExportarConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ImportarExportarConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ImportarExportarConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ImportarExportarConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Importar Exportars";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Importar Exportar";
	public static final String SCLASSWEBTITULO_LOWER="Importar Exportar";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ImportarExportar";
	public static final String OBJECTNAME="importarexportar";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="importar_exportar";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select importarexportar from "+ImportarExportarConstantesFunciones.SPERSISTENCENAME+" importarexportar";
	public static String QUERYSELECTNATIVE="select "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".version_row,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_modulo,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_asiento_contable,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".ruc,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_periodo_import_export,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_transaccion_conta,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".fecha,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_importacion,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".documento_transporte,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_referencia_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_tributario,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".codigo_fiscal,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_cliente,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".es_juridico,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".base0,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".monto_total_cif,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".monto_iva,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_iva,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".monto_ice,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_ice,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".base_general,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_banco,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".id_tipo_comprobante_banco,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".con_convenio,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".con_devolucion,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".fecha_emision,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_serie_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_autorizacion_comprobante,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".numero_secuencial_fuente,"+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME+".valor_fob from "+ImportarExportarConstantesFunciones.SCHEMA+"."+ImportarExportarConstantesFunciones.TABLENAME;//+" as "+ImportarExportarConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ImportarExportarConstantesFuncionesAdditional importarexportarConstantesFuncionesAdditional=null;
	
	public ImportarExportarConstantesFuncionesAdditional getImportarExportarConstantesFuncionesAdditional() {
		return this.importarexportarConstantesFuncionesAdditional;
	}
	
	public void setImportarExportarConstantesFuncionesAdditional(ImportarExportarConstantesFuncionesAdditional importarexportarConstantesFuncionesAdditional) {
		try {
			this.importarexportarConstantesFuncionesAdditional=importarexportarConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDMODULO= "id_modulo";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String RUCINFORMANTE= "ruc";
    public static final String IDPERIODOIMPORTEXPORT= "id_periodo_import_export";
    public static final String IDTRANSACCIONCONTA= "id_transaccion_conta";
    public static final String FECHA= "fecha";
    public static final String IDTIPOIMPORTACION= "id_tipo_importacion";
    public static final String IDTIPOCOMPROBANTE= "id_tipo_comprobante";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String DOCUMENTOTRANSPORTE= "documento_transporte";
    public static final String NUMEROREFERENCIACOMPROBANTE= "numero_referencia_comprobante";
    public static final String IDTIPOTRIBUTARIO= "id_tipo_tributario";
    public static final String CODIGOFISCAL= "codigo_fiscal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String ESJURIDICO= "es_juridico";
    public static final String BASE0= "base0";
    public static final String MONTOTOTALCIF= "monto_total_cif";
    public static final String MONTOIVA= "monto_iva";
    public static final String IDTIPOIVA= "id_tipo_iva";
    public static final String MONTOICE= "monto_ice";
    public static final String IDTIPOICE= "id_tipo_ice";
    public static final String BASEGENERAL= "base_general";
    public static final String IDTIPOBANCO= "id_tipo_banco";
    public static final String IDTIPOCOMPROBANTEBANCO= "id_tipo_comprobante_banco";
    public static final String CONCONVENIO= "con_convenio";
    public static final String CONDEVOLUCION= "con_devolucion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMEROSERIECOMPROBANTE= "numero_serie_comprobante";
    public static final String NUMEROAUTORIZACIONCOMPROBANTE= "numero_autorizacion_comprobante";
    public static final String NUMEROSECUENCIALFUENTE= "numero_secuencial_fuente";
    public static final String VALORFOB= "valor_fob";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento C.";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_RUCINFORMANTE= "Ruc Informa";
		public static final String LABEL_RUCINFORMANTE_LOWER= "Ruc Informante";
    	public static final String LABEL_IDPERIODOIMPORTEXPORT= "Periodo";
		public static final String LABEL_IDPERIODOIMPORTEXPORT_LOWER= "Periodo Import Export";
    	public static final String LABEL_IDTRANSACCIONCONTA= "Transaccion";
		public static final String LABEL_IDTRANSACCIONCONTA_LOWER= "Transaccion Conta";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDTIPOIMPORTACION= "Tipo Importacion";
		public static final String LABEL_IDTIPOIMPORTACION_LOWER= "Tipo Importacion";
    	public static final String LABEL_IDTIPOCOMPROBANTE= "Tipo Comprobante";
		public static final String LABEL_IDTIPOCOMPROBANTE_LOWER= "Tipo Comprobante";
    	public static final String LABEL_NUMEROCOMPROBANTE= "No Comp. PreImp";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_DOCUMENTOTRANSPORTE= "Doc. Transporte";
		public static final String LABEL_DOCUMENTOTRANSPORTE_LOWER= "Documento Transporte";
    	public static final String LABEL_NUMEROREFERENCIACOMPROBANTE= "No Ref. Comp.";
		public static final String LABEL_NUMEROREFERENCIACOMPROBANTE_LOWER= "Numero Referencia Comprobante";
    	public static final String LABEL_IDTIPOTRIBUTARIO= "Sustento Tribut.";
		public static final String LABEL_IDTIPOTRIBUTARIO_LOWER= "Tipo Tributario";
    	public static final String LABEL_CODIGOFISCAL= "Identif. Fiscal Prov.";
		public static final String LABEL_CODIGOFISCAL_LOWER= "Codigo Fiscal";
    	public static final String LABEL_IDCLIENTE= "Proveedor";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_ESJURIDICO= "Es Juridico";
		public static final String LABEL_ESJURIDICO_LOWER= "Es Juridico";
    	public static final String LABEL_BASE0= "Base 0%";
		public static final String LABEL_BASE0_LOWER= "Base0";
    	public static final String LABEL_MONTOTOTALCIF= "Monto Total Cif";
		public static final String LABEL_MONTOTOTALCIF_LOWER= "Monto Total Cif";
    	public static final String LABEL_MONTOIVA= "Monto Iva";
		public static final String LABEL_MONTOIVA_LOWER= "Monto Iva";
    	public static final String LABEL_IDTIPOIVA= "% Iva";
		public static final String LABEL_IDTIPOIVA_LOWER= "Tipo Iva";
    	public static final String LABEL_MONTOICE= "Monto Ice";
		public static final String LABEL_MONTOICE_LOWER= "Monto Ice";
    	public static final String LABEL_IDTIPOICE= "Codigo Ice";
		public static final String LABEL_IDTIPOICE_LOWER= "Tipo Ice";
    	public static final String LABEL_BASEGENERAL= "Base Gr.";
		public static final String LABEL_BASEGENERAL_LOWER= "Base General";
    	public static final String LABEL_IDTIPOBANCO= "Banco";
		public static final String LABEL_IDTIPOBANCO_LOWER= "Tipo Banco";
    	public static final String LABEL_IDTIPOCOMPROBANTEBANCO= "T. Comprob";
		public static final String LABEL_IDTIPOCOMPROBANTEBANCO_LOWER= "Tipo Comprobante Banco";
    	public static final String LABEL_CONCONVENIO= "Convenio Int.";
		public static final String LABEL_CONCONVENIO_LOWER= "Con Convenio";
    	public static final String LABEL_CONDEVOLUCION= "Devolucion";
		public static final String LABEL_CONDEVOLUCION_LOWER= "Con Devolucion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMEROSERIECOMPROBANTE= "No Serie Comp.";
		public static final String LABEL_NUMEROSERIECOMPROBANTE_LOWER= "Numero Serie Comprobante";
    	public static final String LABEL_NUMEROAUTORIZACIONCOMPROBANTE= "No Aut. Comp.";
		public static final String LABEL_NUMEROAUTORIZACIONCOMPROBANTE_LOWER= "Numero Autorizacion Comprobante";
    	public static final String LABEL_NUMEROSECUENCIALFUENTE= "No. Sec. Comp.Fue/Dui/Das";
		public static final String LABEL_NUMEROSECUENCIALFUENTE_LOWER= "Numero Secuencial Fuente";
    	public static final String LABEL_VALORFOB= "Valor FOB";
		public static final String LABEL_VALORFOB_LOWER= "Valor Fob";
	
		
		
		
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDOCUMENTO_TRANSPORTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDOCUMENTO_TRANSPORTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_REFERENCIA_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_REFERENCIA_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_FISCAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_FISCAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SERIE_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_SECUENCIAL_FUENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL_FUENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getImportarExportarLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDMODULO)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.RUCINFORMANTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_RUCINFORMANTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDPERIODOIMPORTEXPORT;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDTRANSACCIONCONTA;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.FECHA)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDTIPOIMPORTACION)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDTIPOIMPORTACION;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_DOCUMENTOTRANSPORTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_NUMEROREFERENCIACOMPROBANTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDTIPOTRIBUTARIO;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.CODIGOFISCAL)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_CODIGOFISCAL;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDCLIENTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.ESJURIDICO)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_ESJURIDICO;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.BASE0)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_BASE0;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.MONTOTOTALCIF)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_MONTOTOTALCIF;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.MONTOIVA)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_MONTOIVA;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDTIPOIVA)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDTIPOIVA;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.MONTOICE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_MONTOICE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDTIPOICE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDTIPOICE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.BASEGENERAL)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_BASEGENERAL;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDTIPOBANCO)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDTIPOBANCO;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTEBANCO;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.CONCONVENIO)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_CONCONVENIO;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.CONDEVOLUCION)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_CONDEVOLUCION;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.FECHAEMISION)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_NUMEROSERIECOMPROBANTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_NUMEROAUTORIZACIONCOMPROBANTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_NUMEROSECUENCIALFUENTE;}
		if(sNombreColumna.equals(ImportarExportarConstantesFunciones.VALORFOB)) {sLabelColumna=ImportarExportarConstantesFunciones.LABEL_VALORFOB;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_juridicoDescripcion(ImportarExportar importarexportar) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!importarexportar.getes_juridico()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_juridicoHtmlDescripcion(ImportarExportar importarexportar) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(importarexportar.getId(),importarexportar.getes_juridico());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
		
	public static String getcon_convenioDescripcion(ImportarExportar importarexportar) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!importarexportar.getcon_convenio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_convenioHtmlDescripcion(ImportarExportar importarexportar) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(importarexportar.getId(),importarexportar.getcon_convenio());

		return sDescripcion;
	}	
		
	public static String getcon_devolucionDescripcion(ImportarExportar importarexportar) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!importarexportar.getcon_devolucion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_devolucionHtmlDescripcion(ImportarExportar importarexportar) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(importarexportar.getId(),importarexportar.getcon_devolucion());

		return sDescripcion;
	}	
			
			
			
			
			
	
	public static String getImportarExportarDescripcion(ImportarExportar importarexportar) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(importarexportar !=null/* && importarexportar.getId()!=0*/) {
			sDescripcion=importarexportar.getruc();//importarexportarimportarexportar.getruc().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getImportarExportarDescripcionDetallado(ImportarExportar importarexportar) {
		String sDescripcion="";
			
		sDescripcion+=ImportarExportarConstantesFunciones.ID+"=";
		sDescripcion+=importarexportar.getId().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=importarexportar.getVersionRow().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDMODULO+"=";
		sDescripcion+=importarexportar.getid_modulo().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=importarexportar.getid_asiento_contable().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.RUCINFORMANTE+"=";
		sDescripcion+=importarexportar.getruc()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT+"=";
		sDescripcion+=importarexportar.getid_periodo_import_export().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA+"=";
		sDescripcion+=importarexportar.getid_transaccion_conta().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.FECHA+"=";
		sDescripcion+=importarexportar.getfecha().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDTIPOIMPORTACION+"=";
		sDescripcion+=importarexportar.getid_tipo_importacion().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE+"=";
		sDescripcion+=importarexportar.getid_tipo_comprobante().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=importarexportar.getnumero_comprobante()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE+"=";
		sDescripcion+=importarexportar.getdocumento_transporte()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE+"=";
		sDescripcion+=importarexportar.getnumero_referencia_comprobante()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO+"=";
		sDescripcion+=importarexportar.getid_tipo_tributario().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.CODIGOFISCAL+"=";
		sDescripcion+=importarexportar.getcodigo_fiscal()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=importarexportar.getid_cliente().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.ESJURIDICO+"=";
		sDescripcion+=importarexportar.getes_juridico().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.BASE0+"=";
		sDescripcion+=importarexportar.getbase0().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.MONTOTOTALCIF+"=";
		sDescripcion+=importarexportar.getmonto_total_cif().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.MONTOIVA+"=";
		sDescripcion+=importarexportar.getmonto_iva().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDTIPOIVA+"=";
		sDescripcion+=importarexportar.getid_tipo_iva().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.MONTOICE+"=";
		sDescripcion+=importarexportar.getmonto_ice().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDTIPOICE+"=";
		sDescripcion+=importarexportar.getid_tipo_ice().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.BASEGENERAL+"=";
		sDescripcion+=importarexportar.getbase_general().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDTIPOBANCO+"=";
		sDescripcion+=importarexportar.getid_tipo_banco().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO+"=";
		sDescripcion+=importarexportar.getid_tipo_comprobante_banco().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.CONCONVENIO+"=";
		sDescripcion+=importarexportar.getcon_convenio().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.CONDEVOLUCION+"=";
		sDescripcion+=importarexportar.getcon_devolucion().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=importarexportar.getfecha_emision().toString()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE+"=";
		sDescripcion+=importarexportar.getnumero_serie_comprobante()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE+"=";
		sDescripcion+=importarexportar.getnumero_autorizacion_comprobante()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE+"=";
		sDescripcion+=importarexportar.getnumero_secuencial_fuente()+",";
		sDescripcion+=ImportarExportarConstantesFunciones.VALORFOB+"=";
		sDescripcion+=importarexportar.getvalor_fob().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setImportarExportarDescripcion(ImportarExportar importarexportar,String sValor) throws Exception {			
		if(importarexportar !=null) {
			importarexportar.setruc(sValor);;//importarexportarimportarexportar.getruc().trim();
		}		
	}
	
		

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getPeriodoImportExportDescripcion(PeriodoImportExport periodoimportexport) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodoimportexport!=null/*&&periodoimportexport.getId()>0*/) {
			sDescripcion=PeriodoImportExportConstantesFunciones.getPeriodoImportExportDescripcion(periodoimportexport);
		}

		return sDescripcion;
	}

	public static String getTransaccionContaDescripcion(TransaccionConta transaccionconta) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccionconta!=null/*&&transaccionconta.getId()>0*/) {
			sDescripcion=TransaccionContaConstantesFunciones.getTransaccionContaDescripcion(transaccionconta);
		}

		return sDescripcion;
	}

	public static String getTipoImportacionDescripcion(TipoImportacion tipoimportacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoimportacion!=null/*&&tipoimportacion.getId()>0*/) {
			sDescripcion=TipoImportacionConstantesFunciones.getTipoImportacionDescripcion(tipoimportacion);
		}

		return sDescripcion;
	}

	public static String getTipoComprobanteDescripcion(TipoComprobante tipocomprobante) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocomprobante!=null/*&&tipocomprobante.getId()>0*/) {
			sDescripcion=TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(tipocomprobante);
		}

		return sDescripcion;
	}

	public static String getTipoTributarioDescripcion(TipoTributario tipotributario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotributario!=null/*&&tipotributario.getId()>0*/) {
			sDescripcion=TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(tipotributario);
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

	public static String getTipoIvaDescripcion(TipoIva tipoiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoiva!=null/*&&tipoiva.getId()>0*/) {
			sDescripcion=TipoIvaConstantesFunciones.getTipoIvaDescripcion(tipoiva);
		}

		return sDescripcion;
	}

	public static String getTipoIceDescripcion(TipoIce tipoice) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoice!=null/*&&tipoice.getId()>0*/) {
			sDescripcion=TipoIceConstantesFunciones.getTipoIceDescripcion(tipoice);
		}

		return sDescripcion;
	}

	public static String getTipoBancoDescripcion(TipoBanco tipobanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipobanco!=null/*&&tipobanco.getId()>0*/) {
			sDescripcion=TipoBancoConstantesFunciones.getTipoBancoDescripcion(tipobanco);
		}

		return sDescripcion;
	}

	public static String getTipoComprobanteBancoDescripcion(TipoComprobante tipocomprobante) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocomprobante!=null/*&&tipocomprobante.getId()>0*/) {
			sDescripcion=TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(tipocomprobante);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNumeroComprobante")) {
			sNombreIndice="Tipo=  Por No Comp. PreImp";
		} else if(sNombreIndice.equals("BusquedaPorRucInformante")) {
			sNombreIndice="Tipo=  Por Ruc Informa";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento C.";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Proveedor";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdPeriodoImportExport")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdTipoBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdTipoComprobante")) {
			sNombreIndice="Tipo=  Por Tipo Comprobante";
		} else if(sNombreIndice.equals("FK_IdTipoComprobanteBanco")) {
			sNombreIndice="Tipo=  Por T. Comprob";
		} else if(sNombreIndice.equals("FK_IdTipoIce")) {
			sNombreIndice="Tipo=  Por Codigo Ice";
		} else if(sNombreIndice.equals("FK_IdTipoImportacion")) {
			sNombreIndice="Tipo=  Por Tipo Importacion";
		} else if(sNombreIndice.equals("FK_IdTipoIva")) {
			sNombreIndice="Tipo=  Por % Iva";
		} else if(sNombreIndice.equals("FK_IdTipoTributario")) {
			sNombreIndice="Tipo=  Por Sustento Tribut.";
		} else if(sNombreIndice.equals("FK_IdTransaccionConta")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNumeroComprobante(String numero_comprobante) {
		String sDetalleIndice=" Parametros->";
		if(numero_comprobante!=null) {sDetalleIndice+=" No Comp. PreImp="+numero_comprobante;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorRucInformante(String ruc) {
		String sDetalleIndice=" Parametros->";
		if(ruc!=null) {sDetalleIndice+=" Ruc Informa="+ruc;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento C.="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Proveedor="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodoImportExport(Long id_periodo_import_export) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo_import_export!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo_import_export.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoBanco(Long id_tipo_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_tipo_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoComprobante(Long id_tipo_comprobante) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_comprobante!=null) {sDetalleIndice+=" Codigo Unico De Tipo Comprobante="+id_tipo_comprobante.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoComprobanteBanco(Long id_tipo_comprobante_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_comprobante_banco!=null) {sDetalleIndice+=" Codigo Unico De T. Comprob="+id_tipo_comprobante_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIce(Long id_tipo_ice) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_ice!=null) {sDetalleIndice+=" Codigo Unico De Codigo Ice="+id_tipo_ice.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoImportacion(Long id_tipo_importacion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_importacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Importacion="+id_tipo_importacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIva(Long id_tipo_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_iva!=null) {sDetalleIndice+=" Codigo Unico De % Iva="+id_tipo_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTributario(Long id_tipo_tributario) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_tributario!=null) {sDetalleIndice+=" Codigo Unico De Sustento Tribut.="+id_tipo_tributario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionConta(Long id_transaccion_conta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_conta!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion_conta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosImportarExportar(ImportarExportar importarexportar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		importarexportar.setruc(importarexportar.getruc().trim());
		importarexportar.setnumero_comprobante(importarexportar.getnumero_comprobante().trim());
		importarexportar.setdocumento_transporte(importarexportar.getdocumento_transporte().trim());
		importarexportar.setnumero_referencia_comprobante(importarexportar.getnumero_referencia_comprobante().trim());
		importarexportar.setcodigo_fiscal(importarexportar.getcodigo_fiscal().trim());
		importarexportar.setnumero_serie_comprobante(importarexportar.getnumero_serie_comprobante().trim());
		importarexportar.setnumero_autorizacion_comprobante(importarexportar.getnumero_autorizacion_comprobante().trim());
		importarexportar.setnumero_secuencial_fuente(importarexportar.getnumero_secuencial_fuente().trim());
	}
	
	public static void quitarEspaciosImportarExportars(List<ImportarExportar> importarexportars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ImportarExportar importarexportar: importarexportars) {
			importarexportar.setruc(importarexportar.getruc().trim());
			importarexportar.setnumero_comprobante(importarexportar.getnumero_comprobante().trim());
			importarexportar.setdocumento_transporte(importarexportar.getdocumento_transporte().trim());
			importarexportar.setnumero_referencia_comprobante(importarexportar.getnumero_referencia_comprobante().trim());
			importarexportar.setcodigo_fiscal(importarexportar.getcodigo_fiscal().trim());
			importarexportar.setnumero_serie_comprobante(importarexportar.getnumero_serie_comprobante().trim());
			importarexportar.setnumero_autorizacion_comprobante(importarexportar.getnumero_autorizacion_comprobante().trim());
			importarexportar.setnumero_secuencial_fuente(importarexportar.getnumero_secuencial_fuente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresImportarExportar(ImportarExportar importarexportar,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && importarexportar.getConCambioAuxiliar()) {
			importarexportar.setIsDeleted(importarexportar.getIsDeletedAuxiliar());	
			importarexportar.setIsNew(importarexportar.getIsNewAuxiliar());	
			importarexportar.setIsChanged(importarexportar.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			importarexportar.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			importarexportar.setIsDeletedAuxiliar(false);	
			importarexportar.setIsNewAuxiliar(false);	
			importarexportar.setIsChangedAuxiliar(false);
			
			importarexportar.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresImportarExportars(List<ImportarExportar> importarexportars,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ImportarExportar importarexportar : importarexportars) {
			if(conAsignarBase && importarexportar.getConCambioAuxiliar()) {
				importarexportar.setIsDeleted(importarexportar.getIsDeletedAuxiliar());	
				importarexportar.setIsNew(importarexportar.getIsNewAuxiliar());	
				importarexportar.setIsChanged(importarexportar.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				importarexportar.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				importarexportar.setIsDeletedAuxiliar(false);	
				importarexportar.setIsNewAuxiliar(false);	
				importarexportar.setIsChangedAuxiliar(false);
				
				importarexportar.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresImportarExportar(ImportarExportar importarexportar,Boolean conEnteros) throws Exception  {
		importarexportar.setbase0(0.0);
		importarexportar.setmonto_total_cif(0.0);
		importarexportar.setmonto_iva(0.0);
		importarexportar.setmonto_ice(0.0);
		importarexportar.setbase_general(0.0);
		importarexportar.setvalor_fob(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresImportarExportars(List<ImportarExportar> importarexportars,Boolean conEnteros) throws Exception  {
		
		for(ImportarExportar importarexportar: importarexportars) {
			importarexportar.setbase0(0.0);
			importarexportar.setmonto_total_cif(0.0);
			importarexportar.setmonto_iva(0.0);
			importarexportar.setmonto_ice(0.0);
			importarexportar.setbase_general(0.0);
			importarexportar.setvalor_fob(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaImportarExportar(List<ImportarExportar> importarexportars,ImportarExportar importarexportarAux) throws Exception  {
		ImportarExportarConstantesFunciones.InicializarValoresImportarExportar(importarexportarAux,true);
		
		for(ImportarExportar importarexportar: importarexportars) {
			if(importarexportar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			importarexportarAux.setbase0(importarexportarAux.getbase0()+importarexportar.getbase0());			
			importarexportarAux.setmonto_total_cif(importarexportarAux.getmonto_total_cif()+importarexportar.getmonto_total_cif());			
			importarexportarAux.setmonto_iva(importarexportarAux.getmonto_iva()+importarexportar.getmonto_iva());			
			importarexportarAux.setmonto_ice(importarexportarAux.getmonto_ice()+importarexportar.getmonto_ice());			
			importarexportarAux.setbase_general(importarexportarAux.getbase_general()+importarexportar.getbase_general());			
			importarexportarAux.setvalor_fob(importarexportarAux.getvalor_fob()+importarexportar.getvalor_fob());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesImportarExportar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ImportarExportarConstantesFunciones.getArrayColumnasGlobalesImportarExportar(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesImportarExportar(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ImportarExportarConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ImportarExportarConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoImportarExportar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ImportarExportar> importarexportars,ImportarExportar importarexportar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ImportarExportar importarexportarAux: importarexportars) {
			if(importarexportarAux!=null && importarexportar!=null) {
				if((importarexportarAux.getId()==null && importarexportar.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(importarexportarAux.getId()!=null && importarexportar.getId()!=null){
					if(importarexportarAux.getId().equals(importarexportar.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaImportarExportar(List<ImportarExportar> importarexportars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double base0Total=0.0;
		Double monto_total_cifTotal=0.0;
		Double monto_ivaTotal=0.0;
		Double monto_iceTotal=0.0;
		Double base_generalTotal=0.0;
		Double valor_fobTotal=0.0;
	
		for(ImportarExportar importarexportar: importarexportars) {			
			if(importarexportar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			base0Total+=importarexportar.getbase0();
			monto_total_cifTotal+=importarexportar.getmonto_total_cif();
			monto_ivaTotal+=importarexportar.getmonto_iva();
			monto_iceTotal+=importarexportar.getmonto_ice();
			base_generalTotal+=importarexportar.getbase_general();
			valor_fobTotal+=importarexportar.getvalor_fob();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImportarExportarConstantesFunciones.BASE0);
		datoGeneral.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_BASE0);
		datoGeneral.setdValorDouble(base0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImportarExportarConstantesFunciones.MONTOTOTALCIF);
		datoGeneral.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_MONTOTOTALCIF);
		datoGeneral.setdValorDouble(monto_total_cifTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImportarExportarConstantesFunciones.MONTOIVA);
		datoGeneral.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_MONTOIVA);
		datoGeneral.setdValorDouble(monto_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImportarExportarConstantesFunciones.MONTOICE);
		datoGeneral.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_MONTOICE);
		datoGeneral.setdValorDouble(monto_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImportarExportarConstantesFunciones.BASEGENERAL);
		datoGeneral.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_BASEGENERAL);
		datoGeneral.setdValorDouble(base_generalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ImportarExportarConstantesFunciones.VALORFOB);
		datoGeneral.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_VALORFOB);
		datoGeneral.setdValorDouble(valor_fobTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaImportarExportar() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_ID, ImportarExportarConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_VERSIONROW, ImportarExportarConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDMODULO, ImportarExportarConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDASIENTOCONTABLE, ImportarExportarConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_RUCINFORMANTE, ImportarExportarConstantesFunciones.RUCINFORMANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDPERIODOIMPORTEXPORT, ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDTRANSACCIONCONTA, ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_FECHA, ImportarExportarConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDTIPOIMPORTACION, ImportarExportarConstantesFunciones.IDTIPOIMPORTACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTE, ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_NUMEROCOMPROBANTE, ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_DOCUMENTOTRANSPORTE, ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_NUMEROREFERENCIACOMPROBANTE, ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDTIPOTRIBUTARIO, ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_CODIGOFISCAL, ImportarExportarConstantesFunciones.CODIGOFISCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDCLIENTE, ImportarExportarConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_ESJURIDICO, ImportarExportarConstantesFunciones.ESJURIDICO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_BASE0, ImportarExportarConstantesFunciones.BASE0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_MONTOTOTALCIF, ImportarExportarConstantesFunciones.MONTOTOTALCIF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_MONTOIVA, ImportarExportarConstantesFunciones.MONTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDTIPOIVA, ImportarExportarConstantesFunciones.IDTIPOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_MONTOICE, ImportarExportarConstantesFunciones.MONTOICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDTIPOICE, ImportarExportarConstantesFunciones.IDTIPOICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_BASEGENERAL, ImportarExportarConstantesFunciones.BASEGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDTIPOBANCO, ImportarExportarConstantesFunciones.IDTIPOBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTEBANCO, ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_CONCONVENIO, ImportarExportarConstantesFunciones.CONCONVENIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_CONDEVOLUCION, ImportarExportarConstantesFunciones.CONDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_FECHAEMISION, ImportarExportarConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_NUMEROSERIECOMPROBANTE, ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_NUMEROAUTORIZACIONCOMPROBANTE, ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_NUMEROSECUENCIALFUENTE, ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImportarExportarConstantesFunciones.LABEL_VALORFOB, ImportarExportarConstantesFunciones.VALORFOB,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasImportarExportar() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.RUCINFORMANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDTIPOIMPORTACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.CODIGOFISCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.ESJURIDICO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.BASE0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.MONTOTOTALCIF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.MONTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDTIPOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.MONTOICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDTIPOICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.BASEGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDTIPOBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.CONCONVENIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.CONDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImportarExportarConstantesFunciones.VALORFOB;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImportarExportar() throws Exception  {
		return ImportarExportarConstantesFunciones.getTiposSeleccionarImportarExportar(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImportarExportar(Boolean conFk) throws Exception  {
		return ImportarExportarConstantesFunciones.getTiposSeleccionarImportarExportar(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImportarExportar(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_RUCINFORMANTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_RUCINFORMANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDPERIODOIMPORTEXPORT);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDPERIODOIMPORTEXPORT);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDTRANSACCIONCONTA);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDTRANSACCIONCONTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDTIPOIMPORTACION);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDTIPOIMPORTACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_DOCUMENTOTRANSPORTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_DOCUMENTOTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_NUMEROREFERENCIACOMPROBANTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_NUMEROREFERENCIACOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_CODIGOFISCAL);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_CODIGOFISCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_ESJURIDICO);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_ESJURIDICO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_BASE0);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_BASE0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_MONTOTOTALCIF);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_MONTOTOTALCIF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_MONTOIVA);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_MONTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDTIPOIVA);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDTIPOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_MONTOICE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_MONTOICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDTIPOICE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDTIPOICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_BASEGENERAL);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_BASEGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDTIPOBANCO);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDTIPOBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTEBANCO);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTEBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_CONCONVENIO);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_CONCONVENIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_CONDEVOLUCION);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_CONDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_NUMEROSERIECOMPROBANTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_NUMEROSERIECOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_NUMEROAUTORIZACIONCOMPROBANTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_NUMEROAUTORIZACIONCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_NUMEROSECUENCIALFUENTE);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_NUMEROSECUENCIALFUENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImportarExportarConstantesFunciones.LABEL_VALORFOB);
			reporte.setsDescripcion(ImportarExportarConstantesFunciones.LABEL_VALORFOB);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesImportarExportar(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesImportarExportar(ImportarExportar importarexportarAux) throws Exception {
		
			importarexportarAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(importarexportarAux.getModulo()));
			importarexportarAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(importarexportarAux.getAsientoContable()));
			importarexportarAux.setperiodoimportexport_descripcion(PeriodoImportExportConstantesFunciones.getPeriodoImportExportDescripcion(importarexportarAux.getPeriodoImportExport()));
			importarexportarAux.settransaccionconta_descripcion(TransaccionContaConstantesFunciones.getTransaccionContaDescripcion(importarexportarAux.getTransaccionConta()));
			importarexportarAux.settipoimportacion_descripcion(TipoImportacionConstantesFunciones.getTipoImportacionDescripcion(importarexportarAux.getTipoImportacion()));
			importarexportarAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(importarexportarAux.getTipoComprobante()));
			importarexportarAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(importarexportarAux.getTipoTributario()));
			importarexportarAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(importarexportarAux.getCliente()));
			importarexportarAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(importarexportarAux.getTipoIva()));
			importarexportarAux.settipoice_descripcion(TipoIceConstantesFunciones.getTipoIceDescripcion(importarexportarAux.getTipoIce()));
			importarexportarAux.settipobanco_descripcion(TipoBancoConstantesFunciones.getTipoBancoDescripcion(importarexportarAux.getTipoBanco()));
			importarexportarAux.settipocomprobantebanco_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(importarexportarAux.getTipoComprobanteBanco()));		
	}
	
	public static void refrescarForeignKeysDescripcionesImportarExportar(List<ImportarExportar> importarexportarsTemp) throws Exception {
		for(ImportarExportar importarexportarAux:importarexportarsTemp) {
			
			importarexportarAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(importarexportarAux.getModulo()));
			importarexportarAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(importarexportarAux.getAsientoContable()));
			importarexportarAux.setperiodoimportexport_descripcion(PeriodoImportExportConstantesFunciones.getPeriodoImportExportDescripcion(importarexportarAux.getPeriodoImportExport()));
			importarexportarAux.settransaccionconta_descripcion(TransaccionContaConstantesFunciones.getTransaccionContaDescripcion(importarexportarAux.getTransaccionConta()));
			importarexportarAux.settipoimportacion_descripcion(TipoImportacionConstantesFunciones.getTipoImportacionDescripcion(importarexportarAux.getTipoImportacion()));
			importarexportarAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(importarexportarAux.getTipoComprobante()));
			importarexportarAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(importarexportarAux.getTipoTributario()));
			importarexportarAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(importarexportarAux.getCliente()));
			importarexportarAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(importarexportarAux.getTipoIva()));
			importarexportarAux.settipoice_descripcion(TipoIceConstantesFunciones.getTipoIceDescripcion(importarexportarAux.getTipoIce()));
			importarexportarAux.settipobanco_descripcion(TipoBancoConstantesFunciones.getTipoBancoDescripcion(importarexportarAux.getTipoBanco()));
			importarexportarAux.settipocomprobantebanco_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(importarexportarAux.getTipoComprobanteBanco()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfImportarExportar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(PeriodoImportExport.class));
				classes.add(new Classe(TransaccionConta.class));
				classes.add(new Classe(TipoImportacion.class));
				classes.add(new Classe(TipoComprobante.class));
				classes.add(new Classe(TipoTributario.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoIva.class));
				classes.add(new Classe(TipoIce.class));
				classes.add(new Classe(TipoBanco.class));
				classes.add(new Classe(TipoComprobante.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(PeriodoImportExport.class)) {
						classes.add(new Classe(PeriodoImportExport.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionConta.class)) {
						classes.add(new Classe(TransaccionConta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoImportacion.class)) {
						classes.add(new Classe(TipoImportacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoComprobante.class)) {
						classes.add(new Classe(TipoComprobante.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTributario.class)) {
						classes.add(new Classe(TipoTributario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIva.class)) {
						classes.add(new Classe(TipoIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoIce.class)) {
						classes.add(new Classe(TipoIce.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoBanco.class)) {
						classes.add(new Classe(TipoBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoComprobante.class)) {
						classes.add(new Classe(TipoComprobante.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfImportarExportar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(PeriodoImportExport.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoImportExport.class)); continue;
					}

					if(TransaccionConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionConta.class)); continue;
					}

					if(TipoImportacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoImportacion.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}

					if(TipoIce.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIce.class)); continue;
					}

					if(TipoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBanco.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(PeriodoImportExport.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PeriodoImportExport.class)); continue;
					}

					if(TransaccionConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionConta.class)); continue;
					}

					if(TipoImportacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoImportacion.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}

					if(TipoIce.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIce.class)); continue;
					}

					if(TipoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBanco.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfImportarExportar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ImportarExportarConstantesFunciones.getClassesRelationshipsOfImportarExportar(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfImportarExportar(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfImportarExportar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ImportarExportarConstantesFunciones.getClassesRelationshipsFromStringsOfImportarExportar(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfImportarExportar(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ImportarExportar importarexportar,List<ImportarExportar> importarexportars,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ImportarExportar importarexportarEncontrado=null;
			
			for(ImportarExportar importarexportarLocal:importarexportars) {
				if(importarexportarLocal.getId().equals(importarexportar.getId())) {
					importarexportarEncontrado=importarexportarLocal;
					
					importarexportarLocal.setIsChanged(importarexportar.getIsChanged());
					importarexportarLocal.setIsNew(importarexportar.getIsNew());
					importarexportarLocal.setIsDeleted(importarexportar.getIsDeleted());
					
					importarexportarLocal.setGeneralEntityOriginal(importarexportar.getGeneralEntityOriginal());
					
					importarexportarLocal.setId(importarexportar.getId());	
					importarexportarLocal.setVersionRow(importarexportar.getVersionRow());	
					importarexportarLocal.setid_modulo(importarexportar.getid_modulo());	
					importarexportarLocal.setid_asiento_contable(importarexportar.getid_asiento_contable());	
					importarexportarLocal.setruc(importarexportar.getruc());	
					importarexportarLocal.setid_periodo_import_export(importarexportar.getid_periodo_import_export());	
					importarexportarLocal.setid_transaccion_conta(importarexportar.getid_transaccion_conta());	
					importarexportarLocal.setfecha(importarexportar.getfecha());	
					importarexportarLocal.setid_tipo_importacion(importarexportar.getid_tipo_importacion());	
					importarexportarLocal.setid_tipo_comprobante(importarexportar.getid_tipo_comprobante());	
					importarexportarLocal.setnumero_comprobante(importarexportar.getnumero_comprobante());	
					importarexportarLocal.setdocumento_transporte(importarexportar.getdocumento_transporte());	
					importarexportarLocal.setnumero_referencia_comprobante(importarexportar.getnumero_referencia_comprobante());	
					importarexportarLocal.setid_tipo_tributario(importarexportar.getid_tipo_tributario());	
					importarexportarLocal.setcodigo_fiscal(importarexportar.getcodigo_fiscal());	
					importarexportarLocal.setid_cliente(importarexportar.getid_cliente());	
					importarexportarLocal.setes_juridico(importarexportar.getes_juridico());	
					importarexportarLocal.setbase0(importarexportar.getbase0());	
					importarexportarLocal.setmonto_total_cif(importarexportar.getmonto_total_cif());	
					importarexportarLocal.setmonto_iva(importarexportar.getmonto_iva());	
					importarexportarLocal.setid_tipo_iva(importarexportar.getid_tipo_iva());	
					importarexportarLocal.setmonto_ice(importarexportar.getmonto_ice());	
					importarexportarLocal.setid_tipo_ice(importarexportar.getid_tipo_ice());	
					importarexportarLocal.setbase_general(importarexportar.getbase_general());	
					importarexportarLocal.setid_tipo_banco(importarexportar.getid_tipo_banco());	
					importarexportarLocal.setid_tipo_comprobante_banco(importarexportar.getid_tipo_comprobante_banco());	
					importarexportarLocal.setcon_convenio(importarexportar.getcon_convenio());	
					importarexportarLocal.setcon_devolucion(importarexportar.getcon_devolucion());	
					importarexportarLocal.setfecha_emision(importarexportar.getfecha_emision());	
					importarexportarLocal.setnumero_serie_comprobante(importarexportar.getnumero_serie_comprobante());	
					importarexportarLocal.setnumero_autorizacion_comprobante(importarexportar.getnumero_autorizacion_comprobante());	
					importarexportarLocal.setnumero_secuencial_fuente(importarexportar.getnumero_secuencial_fuente());	
					importarexportarLocal.setvalor_fob(importarexportar.getvalor_fob());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!importarexportar.getIsDeleted()) {
				if(!existe) {
					importarexportars.add(importarexportar);
				}
			} else {
				if(importarexportarEncontrado!=null && permiteQuitar)  {
					importarexportars.remove(importarexportarEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ImportarExportar importarexportar,List<ImportarExportar> importarexportars) throws Exception {
		try	{			
			for(ImportarExportar importarexportarLocal:importarexportars) {
				if(importarexportarLocal.getId().equals(importarexportar.getId())) {
					importarexportarLocal.setIsSelected(importarexportar.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesImportarExportar(List<ImportarExportar> importarexportarsAux) throws Exception {
		//this.importarexportarsAux=importarexportarsAux;
		
		for(ImportarExportar importarexportarAux:importarexportarsAux) {
			if(importarexportarAux.getIsChanged()) {
				importarexportarAux.setIsChanged(false);
			}		
			
			if(importarexportarAux.getIsNew()) {
				importarexportarAux.setIsNew(false);
			}	
			
			if(importarexportarAux.getIsDeleted()) {
				importarexportarAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesImportarExportar(ImportarExportar importarexportarAux) throws Exception {
		//this.importarexportarAux=importarexportarAux;
		
			if(importarexportarAux.getIsChanged()) {
				importarexportarAux.setIsChanged(false);
			}		
			
			if(importarexportarAux.getIsNew()) {
				importarexportarAux.setIsNew(false);
			}	
			
			if(importarexportarAux.getIsDeleted()) {
				importarexportarAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ImportarExportar importarexportarAsignar,ImportarExportar importarexportar) throws Exception {
		importarexportarAsignar.setId(importarexportar.getId());	
		importarexportarAsignar.setVersionRow(importarexportar.getVersionRow());	
		importarexportarAsignar.setid_modulo(importarexportar.getid_modulo());
		importarexportarAsignar.setmodulo_descripcion(importarexportar.getmodulo_descripcion());	
		importarexportarAsignar.setid_asiento_contable(importarexportar.getid_asiento_contable());
		importarexportarAsignar.setasientocontable_descripcion(importarexportar.getasientocontable_descripcion());	
		importarexportarAsignar.setruc(importarexportar.getruc());	
		importarexportarAsignar.setid_periodo_import_export(importarexportar.getid_periodo_import_export());
		importarexportarAsignar.setperiodoimportexport_descripcion(importarexportar.getperiodoimportexport_descripcion());	
		importarexportarAsignar.setid_transaccion_conta(importarexportar.getid_transaccion_conta());
		importarexportarAsignar.settransaccionconta_descripcion(importarexportar.gettransaccionconta_descripcion());	
		importarexportarAsignar.setfecha(importarexportar.getfecha());	
		importarexportarAsignar.setid_tipo_importacion(importarexportar.getid_tipo_importacion());
		importarexportarAsignar.settipoimportacion_descripcion(importarexportar.gettipoimportacion_descripcion());	
		importarexportarAsignar.setid_tipo_comprobante(importarexportar.getid_tipo_comprobante());
		importarexportarAsignar.settipocomprobante_descripcion(importarexportar.gettipocomprobante_descripcion());	
		importarexportarAsignar.setnumero_comprobante(importarexportar.getnumero_comprobante());	
		importarexportarAsignar.setdocumento_transporte(importarexportar.getdocumento_transporte());	
		importarexportarAsignar.setnumero_referencia_comprobante(importarexportar.getnumero_referencia_comprobante());	
		importarexportarAsignar.setid_tipo_tributario(importarexportar.getid_tipo_tributario());
		importarexportarAsignar.settipotributario_descripcion(importarexportar.gettipotributario_descripcion());	
		importarexportarAsignar.setcodigo_fiscal(importarexportar.getcodigo_fiscal());	
		importarexportarAsignar.setid_cliente(importarexportar.getid_cliente());
		importarexportarAsignar.setcliente_descripcion(importarexportar.getcliente_descripcion());	
		importarexportarAsignar.setes_juridico(importarexportar.getes_juridico());	
		importarexportarAsignar.setbase0(importarexportar.getbase0());	
		importarexportarAsignar.setmonto_total_cif(importarexportar.getmonto_total_cif());	
		importarexportarAsignar.setmonto_iva(importarexportar.getmonto_iva());	
		importarexportarAsignar.setid_tipo_iva(importarexportar.getid_tipo_iva());
		importarexportarAsignar.settipoiva_descripcion(importarexportar.gettipoiva_descripcion());	
		importarexportarAsignar.setmonto_ice(importarexportar.getmonto_ice());	
		importarexportarAsignar.setid_tipo_ice(importarexportar.getid_tipo_ice());
		importarexportarAsignar.settipoice_descripcion(importarexportar.gettipoice_descripcion());	
		importarexportarAsignar.setbase_general(importarexportar.getbase_general());	
		importarexportarAsignar.setid_tipo_banco(importarexportar.getid_tipo_banco());
		importarexportarAsignar.settipobanco_descripcion(importarexportar.gettipobanco_descripcion());	
		importarexportarAsignar.setid_tipo_comprobante_banco(importarexportar.getid_tipo_comprobante_banco());
		importarexportarAsignar.settipocomprobantebanco_descripcion(importarexportar.gettipocomprobantebanco_descripcion());	
		importarexportarAsignar.setcon_convenio(importarexportar.getcon_convenio());	
		importarexportarAsignar.setcon_devolucion(importarexportar.getcon_devolucion());	
		importarexportarAsignar.setfecha_emision(importarexportar.getfecha_emision());	
		importarexportarAsignar.setnumero_serie_comprobante(importarexportar.getnumero_serie_comprobante());	
		importarexportarAsignar.setnumero_autorizacion_comprobante(importarexportar.getnumero_autorizacion_comprobante());	
		importarexportarAsignar.setnumero_secuencial_fuente(importarexportar.getnumero_secuencial_fuente());	
		importarexportarAsignar.setvalor_fob(importarexportar.getvalor_fob());	
	}
	
	public static void inicializarImportarExportar(ImportarExportar importarexportar) throws Exception {
		try {
				importarexportar.setId(0L);	
					
				importarexportar.setid_modulo(-1L);	
				importarexportar.setid_asiento_contable(-1L);	
				importarexportar.setruc("");	
				importarexportar.setid_periodo_import_export(-1L);	
				importarexportar.setid_transaccion_conta(-1L);	
				importarexportar.setfecha(new Date());	
				importarexportar.setid_tipo_importacion(-1L);	
				importarexportar.setid_tipo_comprobante(-1L);	
				importarexportar.setnumero_comprobante("");	
				importarexportar.setdocumento_transporte("");	
				importarexportar.setnumero_referencia_comprobante("");	
				importarexportar.setid_tipo_tributario(-1L);	
				importarexportar.setcodigo_fiscal("");	
				importarexportar.setid_cliente(-1L);	
				importarexportar.setes_juridico(false);	
				importarexportar.setbase0(0.0);	
				importarexportar.setmonto_total_cif(0.0);	
				importarexportar.setmonto_iva(0.0);	
				importarexportar.setid_tipo_iva(-1L);	
				importarexportar.setmonto_ice(0.0);	
				importarexportar.setid_tipo_ice(-1L);	
				importarexportar.setbase_general(0.0);	
				importarexportar.setid_tipo_banco(-1L);	
				importarexportar.setid_tipo_comprobante_banco(-1L);	
				importarexportar.setcon_convenio(false);	
				importarexportar.setcon_devolucion(false);	
				importarexportar.setfecha_emision(new Date());	
				importarexportar.setnumero_serie_comprobante("");	
				importarexportar.setnumero_autorizacion_comprobante("");	
				importarexportar.setnumero_secuencial_fuente("");	
				importarexportar.setvalor_fob(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderImportarExportar(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_RUCINFORMANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDPERIODOIMPORTEXPORT);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDTRANSACCIONCONTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDTIPOIMPORTACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_DOCUMENTOTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_NUMEROREFERENCIACOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_CODIGOFISCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_ESJURIDICO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_BASE0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_MONTOTOTALCIF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_MONTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDTIPOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_MONTOICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDTIPOICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_BASEGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDTIPOBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_IDTIPOCOMPROBANTEBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_CONCONVENIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_CONDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_NUMEROSERIECOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_NUMEROAUTORIZACIONCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_NUMEROSECUENCIALFUENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImportarExportarConstantesFunciones.LABEL_VALORFOB);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataImportarExportar(String sTipo,Row row,Workbook workbook,ImportarExportar importarexportar,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getperiodoimportexport_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.gettransaccionconta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.gettipoimportacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.gettipocomprobante_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getdocumento_transporte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getnumero_referencia_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.gettipotributario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getcodigo_fiscal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(importarexportar.getes_juridico()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getbase0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getmonto_total_cif());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getmonto_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.gettipoiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getmonto_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.gettipoice_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getbase_general());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.gettipobanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.gettipocomprobantebanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(importarexportar.getcon_convenio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(importarexportar.getcon_devolucion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getnumero_serie_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getnumero_autorizacion_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getnumero_secuencial_fuente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(importarexportar.getvalor_fob());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryImportarExportar=Constantes.SFINALQUERY;
	
	public String getsFinalQueryImportarExportar() {
		return this.sFinalQueryImportarExportar;
	}
	
	public void setsFinalQueryImportarExportar(String sFinalQueryImportarExportar) {
		this.sFinalQueryImportarExportar= sFinalQueryImportarExportar;
	}
	
	public Border resaltarSeleccionarImportarExportar=null;
	
	public Border setResaltarSeleccionarImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarImportarExportar= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarImportarExportar() {
		return this.resaltarSeleccionarImportarExportar;
	}
	
	public void setResaltarSeleccionarImportarExportar(Border borderResaltarSeleccionarImportarExportar) {
		this.resaltarSeleccionarImportarExportar= borderResaltarSeleccionarImportarExportar;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridImportarExportar=null;
	public Boolean mostraridImportarExportar=true;
	public Boolean activaridImportarExportar=true;

	public Border resaltarid_moduloImportarExportar=null;
	public Boolean mostrarid_moduloImportarExportar=true;
	public Boolean activarid_moduloImportarExportar=true;
	public Boolean cargarid_moduloImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloImportarExportar=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableImportarExportar=null;
	public Boolean mostrarid_asiento_contableImportarExportar=true;
	public Boolean activarid_asiento_contableImportarExportar=true;
	public Boolean cargarid_asiento_contableImportarExportar=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableImportarExportar=false;//ConEventDepend=true

	public Border resaltarrucImportarExportar=null;
	public Boolean mostrarrucImportarExportar=true;
	public Boolean activarrucImportarExportar=true;

	public Border resaltarid_periodo_import_exportImportarExportar=null;
	public Boolean mostrarid_periodo_import_exportImportarExportar=true;
	public Boolean activarid_periodo_import_exportImportarExportar=true;
	public Boolean cargarid_periodo_import_exportImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodo_import_exportImportarExportar=false;//ConEventDepend=true

	public Border resaltarid_transaccion_contaImportarExportar=null;
	public Boolean mostrarid_transaccion_contaImportarExportar=true;
	public Boolean activarid_transaccion_contaImportarExportar=true;
	public Boolean cargarid_transaccion_contaImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_contaImportarExportar=false;//ConEventDepend=true

	public Border resaltarfechaImportarExportar=null;
	public Boolean mostrarfechaImportarExportar=true;
	public Boolean activarfechaImportarExportar=true;

	public Border resaltarid_tipo_importacionImportarExportar=null;
	public Boolean mostrarid_tipo_importacionImportarExportar=true;
	public Boolean activarid_tipo_importacionImportarExportar=true;
	public Boolean cargarid_tipo_importacionImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_importacionImportarExportar=false;//ConEventDepend=true

	public Border resaltarid_tipo_comprobanteImportarExportar=null;
	public Boolean mostrarid_tipo_comprobanteImportarExportar=true;
	public Boolean activarid_tipo_comprobanteImportarExportar=true;
	public Boolean cargarid_tipo_comprobanteImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_comprobanteImportarExportar=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteImportarExportar=null;
	public Boolean mostrarnumero_comprobanteImportarExportar=true;
	public Boolean activarnumero_comprobanteImportarExportar=true;

	public Border resaltardocumento_transporteImportarExportar=null;
	public Boolean mostrardocumento_transporteImportarExportar=true;
	public Boolean activardocumento_transporteImportarExportar=true;

	public Border resaltarnumero_referencia_comprobanteImportarExportar=null;
	public Boolean mostrarnumero_referencia_comprobanteImportarExportar=true;
	public Boolean activarnumero_referencia_comprobanteImportarExportar=true;

	public Border resaltarid_tipo_tributarioImportarExportar=null;
	public Boolean mostrarid_tipo_tributarioImportarExportar=true;
	public Boolean activarid_tipo_tributarioImportarExportar=true;
	public Boolean cargarid_tipo_tributarioImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_tributarioImportarExportar=false;//ConEventDepend=true

	public Border resaltarcodigo_fiscalImportarExportar=null;
	public Boolean mostrarcodigo_fiscalImportarExportar=true;
	public Boolean activarcodigo_fiscalImportarExportar=true;

	public Border resaltarid_clienteImportarExportar=null;
	public Boolean mostrarid_clienteImportarExportar=true;
	public Boolean activarid_clienteImportarExportar=true;
	public Boolean cargarid_clienteImportarExportar=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteImportarExportar=false;//ConEventDepend=true

	public Border resaltares_juridicoImportarExportar=null;
	public Boolean mostrares_juridicoImportarExportar=true;
	public Boolean activares_juridicoImportarExportar=true;

	public Border resaltarbase0ImportarExportar=null;
	public Boolean mostrarbase0ImportarExportar=true;
	public Boolean activarbase0ImportarExportar=true;

	public Border resaltarmonto_total_cifImportarExportar=null;
	public Boolean mostrarmonto_total_cifImportarExportar=true;
	public Boolean activarmonto_total_cifImportarExportar=true;

	public Border resaltarmonto_ivaImportarExportar=null;
	public Boolean mostrarmonto_ivaImportarExportar=true;
	public Boolean activarmonto_ivaImportarExportar=true;

	public Border resaltarid_tipo_ivaImportarExportar=null;
	public Boolean mostrarid_tipo_ivaImportarExportar=true;
	public Boolean activarid_tipo_ivaImportarExportar=true;
	public Boolean cargarid_tipo_ivaImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ivaImportarExportar=false;//ConEventDepend=true

	public Border resaltarmonto_iceImportarExportar=null;
	public Boolean mostrarmonto_iceImportarExportar=true;
	public Boolean activarmonto_iceImportarExportar=true;

	public Border resaltarid_tipo_iceImportarExportar=null;
	public Boolean mostrarid_tipo_iceImportarExportar=true;
	public Boolean activarid_tipo_iceImportarExportar=true;
	public Boolean cargarid_tipo_iceImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_iceImportarExportar=false;//ConEventDepend=true

	public Border resaltarbase_generalImportarExportar=null;
	public Boolean mostrarbase_generalImportarExportar=true;
	public Boolean activarbase_generalImportarExportar=true;

	public Border resaltarid_tipo_bancoImportarExportar=null;
	public Boolean mostrarid_tipo_bancoImportarExportar=true;
	public Boolean activarid_tipo_bancoImportarExportar=true;
	public Boolean cargarid_tipo_bancoImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_bancoImportarExportar=false;//ConEventDepend=true

	public Border resaltarid_tipo_comprobante_bancoImportarExportar=null;
	public Boolean mostrarid_tipo_comprobante_bancoImportarExportar=true;
	public Boolean activarid_tipo_comprobante_bancoImportarExportar=true;
	public Boolean cargarid_tipo_comprobante_bancoImportarExportar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_comprobante_bancoImportarExportar=false;//ConEventDepend=true

	public Border resaltarcon_convenioImportarExportar=null;
	public Boolean mostrarcon_convenioImportarExportar=true;
	public Boolean activarcon_convenioImportarExportar=true;

	public Border resaltarcon_devolucionImportarExportar=null;
	public Boolean mostrarcon_devolucionImportarExportar=true;
	public Boolean activarcon_devolucionImportarExportar=true;

	public Border resaltarfecha_emisionImportarExportar=null;
	public Boolean mostrarfecha_emisionImportarExportar=true;
	public Boolean activarfecha_emisionImportarExportar=true;

	public Border resaltarnumero_serie_comprobanteImportarExportar=null;
	public Boolean mostrarnumero_serie_comprobanteImportarExportar=true;
	public Boolean activarnumero_serie_comprobanteImportarExportar=true;

	public Border resaltarnumero_autorizacion_comprobanteImportarExportar=null;
	public Boolean mostrarnumero_autorizacion_comprobanteImportarExportar=true;
	public Boolean activarnumero_autorizacion_comprobanteImportarExportar=true;

	public Border resaltarnumero_secuencial_fuenteImportarExportar=null;
	public Boolean mostrarnumero_secuencial_fuenteImportarExportar=true;
	public Boolean activarnumero_secuencial_fuenteImportarExportar=true;

	public Border resaltarvalor_fobImportarExportar=null;
	public Boolean mostrarvalor_fobImportarExportar=true;
	public Boolean activarvalor_fobImportarExportar=true;

	
	

	public Border setResaltaridImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltaridImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridImportarExportar() {
		return this.resaltaridImportarExportar;
	}

	public void setResaltaridImportarExportar(Border borderResaltar) {
		this.resaltaridImportarExportar= borderResaltar;
	}

	public Boolean getMostraridImportarExportar() {
		return this.mostraridImportarExportar;
	}

	public void setMostraridImportarExportar(Boolean mostraridImportarExportar) {
		this.mostraridImportarExportar= mostraridImportarExportar;
	}

	public Boolean getActivaridImportarExportar() {
		return this.activaridImportarExportar;
	}

	public void setActivaridImportarExportar(Boolean activaridImportarExportar) {
		this.activaridImportarExportar= activaridImportarExportar;
	}

	public Border setResaltarid_moduloImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_moduloImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloImportarExportar() {
		return this.resaltarid_moduloImportarExportar;
	}

	public void setResaltarid_moduloImportarExportar(Border borderResaltar) {
		this.resaltarid_moduloImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_moduloImportarExportar() {
		return this.mostrarid_moduloImportarExportar;
	}

	public void setMostrarid_moduloImportarExportar(Boolean mostrarid_moduloImportarExportar) {
		this.mostrarid_moduloImportarExportar= mostrarid_moduloImportarExportar;
	}

	public Boolean getActivarid_moduloImportarExportar() {
		return this.activarid_moduloImportarExportar;
	}

	public void setActivarid_moduloImportarExportar(Boolean activarid_moduloImportarExportar) {
		this.activarid_moduloImportarExportar= activarid_moduloImportarExportar;
	}

	public Boolean getCargarid_moduloImportarExportar() {
		return this.cargarid_moduloImportarExportar;
	}

	public void setCargarid_moduloImportarExportar(Boolean cargarid_moduloImportarExportar) {
		this.cargarid_moduloImportarExportar= cargarid_moduloImportarExportar;
	}

	public Border setResaltarid_asiento_contableImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_asiento_contableImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableImportarExportar() {
		return this.resaltarid_asiento_contableImportarExportar;
	}

	public void setResaltarid_asiento_contableImportarExportar(Border borderResaltar) {
		this.resaltarid_asiento_contableImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableImportarExportar() {
		return this.mostrarid_asiento_contableImportarExportar;
	}

	public void setMostrarid_asiento_contableImportarExportar(Boolean mostrarid_asiento_contableImportarExportar) {
		this.mostrarid_asiento_contableImportarExportar= mostrarid_asiento_contableImportarExportar;
	}

	public Boolean getActivarid_asiento_contableImportarExportar() {
		return this.activarid_asiento_contableImportarExportar;
	}

	public void setActivarid_asiento_contableImportarExportar(Boolean activarid_asiento_contableImportarExportar) {
		this.activarid_asiento_contableImportarExportar= activarid_asiento_contableImportarExportar;
	}

	public Boolean getCargarid_asiento_contableImportarExportar() {
		return this.cargarid_asiento_contableImportarExportar;
	}

	public void setCargarid_asiento_contableImportarExportar(Boolean cargarid_asiento_contableImportarExportar) {
		this.cargarid_asiento_contableImportarExportar= cargarid_asiento_contableImportarExportar;
	}

	public Border setResaltarrucImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarrucImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucImportarExportar() {
		return this.resaltarrucImportarExportar;
	}

	public void setResaltarrucImportarExportar(Border borderResaltar) {
		this.resaltarrucImportarExportar= borderResaltar;
	}

	public Boolean getMostrarrucImportarExportar() {
		return this.mostrarrucImportarExportar;
	}

	public void setMostrarrucImportarExportar(Boolean mostrarrucImportarExportar) {
		this.mostrarrucImportarExportar= mostrarrucImportarExportar;
	}

	public Boolean getActivarrucImportarExportar() {
		return this.activarrucImportarExportar;
	}

	public void setActivarrucImportarExportar(Boolean activarrucImportarExportar) {
		this.activarrucImportarExportar= activarrucImportarExportar;
	}

	public Border setResaltarid_periodo_import_exportImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_periodo_import_exportImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodo_import_exportImportarExportar() {
		return this.resaltarid_periodo_import_exportImportarExportar;
	}

	public void setResaltarid_periodo_import_exportImportarExportar(Border borderResaltar) {
		this.resaltarid_periodo_import_exportImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_periodo_import_exportImportarExportar() {
		return this.mostrarid_periodo_import_exportImportarExportar;
	}

	public void setMostrarid_periodo_import_exportImportarExportar(Boolean mostrarid_periodo_import_exportImportarExportar) {
		this.mostrarid_periodo_import_exportImportarExportar= mostrarid_periodo_import_exportImportarExportar;
	}

	public Boolean getActivarid_periodo_import_exportImportarExportar() {
		return this.activarid_periodo_import_exportImportarExportar;
	}

	public void setActivarid_periodo_import_exportImportarExportar(Boolean activarid_periodo_import_exportImportarExportar) {
		this.activarid_periodo_import_exportImportarExportar= activarid_periodo_import_exportImportarExportar;
	}

	public Boolean getCargarid_periodo_import_exportImportarExportar() {
		return this.cargarid_periodo_import_exportImportarExportar;
	}

	public void setCargarid_periodo_import_exportImportarExportar(Boolean cargarid_periodo_import_exportImportarExportar) {
		this.cargarid_periodo_import_exportImportarExportar= cargarid_periodo_import_exportImportarExportar;
	}

	public Border setResaltarid_transaccion_contaImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_transaccion_contaImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_contaImportarExportar() {
		return this.resaltarid_transaccion_contaImportarExportar;
	}

	public void setResaltarid_transaccion_contaImportarExportar(Border borderResaltar) {
		this.resaltarid_transaccion_contaImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_contaImportarExportar() {
		return this.mostrarid_transaccion_contaImportarExportar;
	}

	public void setMostrarid_transaccion_contaImportarExportar(Boolean mostrarid_transaccion_contaImportarExportar) {
		this.mostrarid_transaccion_contaImportarExportar= mostrarid_transaccion_contaImportarExportar;
	}

	public Boolean getActivarid_transaccion_contaImportarExportar() {
		return this.activarid_transaccion_contaImportarExportar;
	}

	public void setActivarid_transaccion_contaImportarExportar(Boolean activarid_transaccion_contaImportarExportar) {
		this.activarid_transaccion_contaImportarExportar= activarid_transaccion_contaImportarExportar;
	}

	public Boolean getCargarid_transaccion_contaImportarExportar() {
		return this.cargarid_transaccion_contaImportarExportar;
	}

	public void setCargarid_transaccion_contaImportarExportar(Boolean cargarid_transaccion_contaImportarExportar) {
		this.cargarid_transaccion_contaImportarExportar= cargarid_transaccion_contaImportarExportar;
	}

	public Border setResaltarfechaImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarfechaImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaImportarExportar() {
		return this.resaltarfechaImportarExportar;
	}

	public void setResaltarfechaImportarExportar(Border borderResaltar) {
		this.resaltarfechaImportarExportar= borderResaltar;
	}

	public Boolean getMostrarfechaImportarExportar() {
		return this.mostrarfechaImportarExportar;
	}

	public void setMostrarfechaImportarExportar(Boolean mostrarfechaImportarExportar) {
		this.mostrarfechaImportarExportar= mostrarfechaImportarExportar;
	}

	public Boolean getActivarfechaImportarExportar() {
		return this.activarfechaImportarExportar;
	}

	public void setActivarfechaImportarExportar(Boolean activarfechaImportarExportar) {
		this.activarfechaImportarExportar= activarfechaImportarExportar;
	}

	public Border setResaltarid_tipo_importacionImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_importacionImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_importacionImportarExportar() {
		return this.resaltarid_tipo_importacionImportarExportar;
	}

	public void setResaltarid_tipo_importacionImportarExportar(Border borderResaltar) {
		this.resaltarid_tipo_importacionImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_importacionImportarExportar() {
		return this.mostrarid_tipo_importacionImportarExportar;
	}

	public void setMostrarid_tipo_importacionImportarExportar(Boolean mostrarid_tipo_importacionImportarExportar) {
		this.mostrarid_tipo_importacionImportarExportar= mostrarid_tipo_importacionImportarExportar;
	}

	public Boolean getActivarid_tipo_importacionImportarExportar() {
		return this.activarid_tipo_importacionImportarExportar;
	}

	public void setActivarid_tipo_importacionImportarExportar(Boolean activarid_tipo_importacionImportarExportar) {
		this.activarid_tipo_importacionImportarExportar= activarid_tipo_importacionImportarExportar;
	}

	public Boolean getCargarid_tipo_importacionImportarExportar() {
		return this.cargarid_tipo_importacionImportarExportar;
	}

	public void setCargarid_tipo_importacionImportarExportar(Boolean cargarid_tipo_importacionImportarExportar) {
		this.cargarid_tipo_importacionImportarExportar= cargarid_tipo_importacionImportarExportar;
	}

	public Border setResaltarid_tipo_comprobanteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_comprobanteImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_comprobanteImportarExportar() {
		return this.resaltarid_tipo_comprobanteImportarExportar;
	}

	public void setResaltarid_tipo_comprobanteImportarExportar(Border borderResaltar) {
		this.resaltarid_tipo_comprobanteImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_comprobanteImportarExportar() {
		return this.mostrarid_tipo_comprobanteImportarExportar;
	}

	public void setMostrarid_tipo_comprobanteImportarExportar(Boolean mostrarid_tipo_comprobanteImportarExportar) {
		this.mostrarid_tipo_comprobanteImportarExportar= mostrarid_tipo_comprobanteImportarExportar;
	}

	public Boolean getActivarid_tipo_comprobanteImportarExportar() {
		return this.activarid_tipo_comprobanteImportarExportar;
	}

	public void setActivarid_tipo_comprobanteImportarExportar(Boolean activarid_tipo_comprobanteImportarExportar) {
		this.activarid_tipo_comprobanteImportarExportar= activarid_tipo_comprobanteImportarExportar;
	}

	public Boolean getCargarid_tipo_comprobanteImportarExportar() {
		return this.cargarid_tipo_comprobanteImportarExportar;
	}

	public void setCargarid_tipo_comprobanteImportarExportar(Boolean cargarid_tipo_comprobanteImportarExportar) {
		this.cargarid_tipo_comprobanteImportarExportar= cargarid_tipo_comprobanteImportarExportar;
	}

	public Border setResaltarnumero_comprobanteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarnumero_comprobanteImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteImportarExportar() {
		return this.resaltarnumero_comprobanteImportarExportar;
	}

	public void setResaltarnumero_comprobanteImportarExportar(Border borderResaltar) {
		this.resaltarnumero_comprobanteImportarExportar= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteImportarExportar() {
		return this.mostrarnumero_comprobanteImportarExportar;
	}

	public void setMostrarnumero_comprobanteImportarExportar(Boolean mostrarnumero_comprobanteImportarExportar) {
		this.mostrarnumero_comprobanteImportarExportar= mostrarnumero_comprobanteImportarExportar;
	}

	public Boolean getActivarnumero_comprobanteImportarExportar() {
		return this.activarnumero_comprobanteImportarExportar;
	}

	public void setActivarnumero_comprobanteImportarExportar(Boolean activarnumero_comprobanteImportarExportar) {
		this.activarnumero_comprobanteImportarExportar= activarnumero_comprobanteImportarExportar;
	}

	public Border setResaltardocumento_transporteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltardocumento_transporteImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardocumento_transporteImportarExportar() {
		return this.resaltardocumento_transporteImportarExportar;
	}

	public void setResaltardocumento_transporteImportarExportar(Border borderResaltar) {
		this.resaltardocumento_transporteImportarExportar= borderResaltar;
	}

	public Boolean getMostrardocumento_transporteImportarExportar() {
		return this.mostrardocumento_transporteImportarExportar;
	}

	public void setMostrardocumento_transporteImportarExportar(Boolean mostrardocumento_transporteImportarExportar) {
		this.mostrardocumento_transporteImportarExportar= mostrardocumento_transporteImportarExportar;
	}

	public Boolean getActivardocumento_transporteImportarExportar() {
		return this.activardocumento_transporteImportarExportar;
	}

	public void setActivardocumento_transporteImportarExportar(Boolean activardocumento_transporteImportarExportar) {
		this.activardocumento_transporteImportarExportar= activardocumento_transporteImportarExportar;
	}

	public Border setResaltarnumero_referencia_comprobanteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarnumero_referencia_comprobanteImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_referencia_comprobanteImportarExportar() {
		return this.resaltarnumero_referencia_comprobanteImportarExportar;
	}

	public void setResaltarnumero_referencia_comprobanteImportarExportar(Border borderResaltar) {
		this.resaltarnumero_referencia_comprobanteImportarExportar= borderResaltar;
	}

	public Boolean getMostrarnumero_referencia_comprobanteImportarExportar() {
		return this.mostrarnumero_referencia_comprobanteImportarExportar;
	}

	public void setMostrarnumero_referencia_comprobanteImportarExportar(Boolean mostrarnumero_referencia_comprobanteImportarExportar) {
		this.mostrarnumero_referencia_comprobanteImportarExportar= mostrarnumero_referencia_comprobanteImportarExportar;
	}

	public Boolean getActivarnumero_referencia_comprobanteImportarExportar() {
		return this.activarnumero_referencia_comprobanteImportarExportar;
	}

	public void setActivarnumero_referencia_comprobanteImportarExportar(Boolean activarnumero_referencia_comprobanteImportarExportar) {
		this.activarnumero_referencia_comprobanteImportarExportar= activarnumero_referencia_comprobanteImportarExportar;
	}

	public Border setResaltarid_tipo_tributarioImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_tributarioImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_tributarioImportarExportar() {
		return this.resaltarid_tipo_tributarioImportarExportar;
	}

	public void setResaltarid_tipo_tributarioImportarExportar(Border borderResaltar) {
		this.resaltarid_tipo_tributarioImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_tributarioImportarExportar() {
		return this.mostrarid_tipo_tributarioImportarExportar;
	}

	public void setMostrarid_tipo_tributarioImportarExportar(Boolean mostrarid_tipo_tributarioImportarExportar) {
		this.mostrarid_tipo_tributarioImportarExportar= mostrarid_tipo_tributarioImportarExportar;
	}

	public Boolean getActivarid_tipo_tributarioImportarExportar() {
		return this.activarid_tipo_tributarioImportarExportar;
	}

	public void setActivarid_tipo_tributarioImportarExportar(Boolean activarid_tipo_tributarioImportarExportar) {
		this.activarid_tipo_tributarioImportarExportar= activarid_tipo_tributarioImportarExportar;
	}

	public Boolean getCargarid_tipo_tributarioImportarExportar() {
		return this.cargarid_tipo_tributarioImportarExportar;
	}

	public void setCargarid_tipo_tributarioImportarExportar(Boolean cargarid_tipo_tributarioImportarExportar) {
		this.cargarid_tipo_tributarioImportarExportar= cargarid_tipo_tributarioImportarExportar;
	}

	public Border setResaltarcodigo_fiscalImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarcodigo_fiscalImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_fiscalImportarExportar() {
		return this.resaltarcodigo_fiscalImportarExportar;
	}

	public void setResaltarcodigo_fiscalImportarExportar(Border borderResaltar) {
		this.resaltarcodigo_fiscalImportarExportar= borderResaltar;
	}

	public Boolean getMostrarcodigo_fiscalImportarExportar() {
		return this.mostrarcodigo_fiscalImportarExportar;
	}

	public void setMostrarcodigo_fiscalImportarExportar(Boolean mostrarcodigo_fiscalImportarExportar) {
		this.mostrarcodigo_fiscalImportarExportar= mostrarcodigo_fiscalImportarExportar;
	}

	public Boolean getActivarcodigo_fiscalImportarExportar() {
		return this.activarcodigo_fiscalImportarExportar;
	}

	public void setActivarcodigo_fiscalImportarExportar(Boolean activarcodigo_fiscalImportarExportar) {
		this.activarcodigo_fiscalImportarExportar= activarcodigo_fiscalImportarExportar;
	}

	public Border setResaltarid_clienteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_clienteImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteImportarExportar() {
		return this.resaltarid_clienteImportarExportar;
	}

	public void setResaltarid_clienteImportarExportar(Border borderResaltar) {
		this.resaltarid_clienteImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_clienteImportarExportar() {
		return this.mostrarid_clienteImportarExportar;
	}

	public void setMostrarid_clienteImportarExportar(Boolean mostrarid_clienteImportarExportar) {
		this.mostrarid_clienteImportarExportar= mostrarid_clienteImportarExportar;
	}

	public Boolean getActivarid_clienteImportarExportar() {
		return this.activarid_clienteImportarExportar;
	}

	public void setActivarid_clienteImportarExportar(Boolean activarid_clienteImportarExportar) {
		this.activarid_clienteImportarExportar= activarid_clienteImportarExportar;
	}

	public Boolean getCargarid_clienteImportarExportar() {
		return this.cargarid_clienteImportarExportar;
	}

	public void setCargarid_clienteImportarExportar(Boolean cargarid_clienteImportarExportar) {
		this.cargarid_clienteImportarExportar= cargarid_clienteImportarExportar;
	}

	public Border setResaltares_juridicoImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltares_juridicoImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_juridicoImportarExportar() {
		return this.resaltares_juridicoImportarExportar;
	}

	public void setResaltares_juridicoImportarExportar(Border borderResaltar) {
		this.resaltares_juridicoImportarExportar= borderResaltar;
	}

	public Boolean getMostrares_juridicoImportarExportar() {
		return this.mostrares_juridicoImportarExportar;
	}

	public void setMostrares_juridicoImportarExportar(Boolean mostrares_juridicoImportarExportar) {
		this.mostrares_juridicoImportarExportar= mostrares_juridicoImportarExportar;
	}

	public Boolean getActivares_juridicoImportarExportar() {
		return this.activares_juridicoImportarExportar;
	}

	public void setActivares_juridicoImportarExportar(Boolean activares_juridicoImportarExportar) {
		this.activares_juridicoImportarExportar= activares_juridicoImportarExportar;
	}

	public Border setResaltarbase0ImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarbase0ImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase0ImportarExportar() {
		return this.resaltarbase0ImportarExportar;
	}

	public void setResaltarbase0ImportarExportar(Border borderResaltar) {
		this.resaltarbase0ImportarExportar= borderResaltar;
	}

	public Boolean getMostrarbase0ImportarExportar() {
		return this.mostrarbase0ImportarExportar;
	}

	public void setMostrarbase0ImportarExportar(Boolean mostrarbase0ImportarExportar) {
		this.mostrarbase0ImportarExportar= mostrarbase0ImportarExportar;
	}

	public Boolean getActivarbase0ImportarExportar() {
		return this.activarbase0ImportarExportar;
	}

	public void setActivarbase0ImportarExportar(Boolean activarbase0ImportarExportar) {
		this.activarbase0ImportarExportar= activarbase0ImportarExportar;
	}

	public Border setResaltarmonto_total_cifImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarmonto_total_cifImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_total_cifImportarExportar() {
		return this.resaltarmonto_total_cifImportarExportar;
	}

	public void setResaltarmonto_total_cifImportarExportar(Border borderResaltar) {
		this.resaltarmonto_total_cifImportarExportar= borderResaltar;
	}

	public Boolean getMostrarmonto_total_cifImportarExportar() {
		return this.mostrarmonto_total_cifImportarExportar;
	}

	public void setMostrarmonto_total_cifImportarExportar(Boolean mostrarmonto_total_cifImportarExportar) {
		this.mostrarmonto_total_cifImportarExportar= mostrarmonto_total_cifImportarExportar;
	}

	public Boolean getActivarmonto_total_cifImportarExportar() {
		return this.activarmonto_total_cifImportarExportar;
	}

	public void setActivarmonto_total_cifImportarExportar(Boolean activarmonto_total_cifImportarExportar) {
		this.activarmonto_total_cifImportarExportar= activarmonto_total_cifImportarExportar;
	}

	public Border setResaltarmonto_ivaImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarmonto_ivaImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ivaImportarExportar() {
		return this.resaltarmonto_ivaImportarExportar;
	}

	public void setResaltarmonto_ivaImportarExportar(Border borderResaltar) {
		this.resaltarmonto_ivaImportarExportar= borderResaltar;
	}

	public Boolean getMostrarmonto_ivaImportarExportar() {
		return this.mostrarmonto_ivaImportarExportar;
	}

	public void setMostrarmonto_ivaImportarExportar(Boolean mostrarmonto_ivaImportarExportar) {
		this.mostrarmonto_ivaImportarExportar= mostrarmonto_ivaImportarExportar;
	}

	public Boolean getActivarmonto_ivaImportarExportar() {
		return this.activarmonto_ivaImportarExportar;
	}

	public void setActivarmonto_ivaImportarExportar(Boolean activarmonto_ivaImportarExportar) {
		this.activarmonto_ivaImportarExportar= activarmonto_ivaImportarExportar;
	}

	public Border setResaltarid_tipo_ivaImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_ivaImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ivaImportarExportar() {
		return this.resaltarid_tipo_ivaImportarExportar;
	}

	public void setResaltarid_tipo_ivaImportarExportar(Border borderResaltar) {
		this.resaltarid_tipo_ivaImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ivaImportarExportar() {
		return this.mostrarid_tipo_ivaImportarExportar;
	}

	public void setMostrarid_tipo_ivaImportarExportar(Boolean mostrarid_tipo_ivaImportarExportar) {
		this.mostrarid_tipo_ivaImportarExportar= mostrarid_tipo_ivaImportarExportar;
	}

	public Boolean getActivarid_tipo_ivaImportarExportar() {
		return this.activarid_tipo_ivaImportarExportar;
	}

	public void setActivarid_tipo_ivaImportarExportar(Boolean activarid_tipo_ivaImportarExportar) {
		this.activarid_tipo_ivaImportarExportar= activarid_tipo_ivaImportarExportar;
	}

	public Boolean getCargarid_tipo_ivaImportarExportar() {
		return this.cargarid_tipo_ivaImportarExportar;
	}

	public void setCargarid_tipo_ivaImportarExportar(Boolean cargarid_tipo_ivaImportarExportar) {
		this.cargarid_tipo_ivaImportarExportar= cargarid_tipo_ivaImportarExportar;
	}

	public Border setResaltarmonto_iceImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarmonto_iceImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_iceImportarExportar() {
		return this.resaltarmonto_iceImportarExportar;
	}

	public void setResaltarmonto_iceImportarExportar(Border borderResaltar) {
		this.resaltarmonto_iceImportarExportar= borderResaltar;
	}

	public Boolean getMostrarmonto_iceImportarExportar() {
		return this.mostrarmonto_iceImportarExportar;
	}

	public void setMostrarmonto_iceImportarExportar(Boolean mostrarmonto_iceImportarExportar) {
		this.mostrarmonto_iceImportarExportar= mostrarmonto_iceImportarExportar;
	}

	public Boolean getActivarmonto_iceImportarExportar() {
		return this.activarmonto_iceImportarExportar;
	}

	public void setActivarmonto_iceImportarExportar(Boolean activarmonto_iceImportarExportar) {
		this.activarmonto_iceImportarExportar= activarmonto_iceImportarExportar;
	}

	public Border setResaltarid_tipo_iceImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_iceImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_iceImportarExportar() {
		return this.resaltarid_tipo_iceImportarExportar;
	}

	public void setResaltarid_tipo_iceImportarExportar(Border borderResaltar) {
		this.resaltarid_tipo_iceImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_iceImportarExportar() {
		return this.mostrarid_tipo_iceImportarExportar;
	}

	public void setMostrarid_tipo_iceImportarExportar(Boolean mostrarid_tipo_iceImportarExportar) {
		this.mostrarid_tipo_iceImportarExportar= mostrarid_tipo_iceImportarExportar;
	}

	public Boolean getActivarid_tipo_iceImportarExportar() {
		return this.activarid_tipo_iceImportarExportar;
	}

	public void setActivarid_tipo_iceImportarExportar(Boolean activarid_tipo_iceImportarExportar) {
		this.activarid_tipo_iceImportarExportar= activarid_tipo_iceImportarExportar;
	}

	public Boolean getCargarid_tipo_iceImportarExportar() {
		return this.cargarid_tipo_iceImportarExportar;
	}

	public void setCargarid_tipo_iceImportarExportar(Boolean cargarid_tipo_iceImportarExportar) {
		this.cargarid_tipo_iceImportarExportar= cargarid_tipo_iceImportarExportar;
	}

	public Border setResaltarbase_generalImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarbase_generalImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_generalImportarExportar() {
		return this.resaltarbase_generalImportarExportar;
	}

	public void setResaltarbase_generalImportarExportar(Border borderResaltar) {
		this.resaltarbase_generalImportarExportar= borderResaltar;
	}

	public Boolean getMostrarbase_generalImportarExportar() {
		return this.mostrarbase_generalImportarExportar;
	}

	public void setMostrarbase_generalImportarExportar(Boolean mostrarbase_generalImportarExportar) {
		this.mostrarbase_generalImportarExportar= mostrarbase_generalImportarExportar;
	}

	public Boolean getActivarbase_generalImportarExportar() {
		return this.activarbase_generalImportarExportar;
	}

	public void setActivarbase_generalImportarExportar(Boolean activarbase_generalImportarExportar) {
		this.activarbase_generalImportarExportar= activarbase_generalImportarExportar;
	}

	public Border setResaltarid_tipo_bancoImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_bancoImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_bancoImportarExportar() {
		return this.resaltarid_tipo_bancoImportarExportar;
	}

	public void setResaltarid_tipo_bancoImportarExportar(Border borderResaltar) {
		this.resaltarid_tipo_bancoImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_bancoImportarExportar() {
		return this.mostrarid_tipo_bancoImportarExportar;
	}

	public void setMostrarid_tipo_bancoImportarExportar(Boolean mostrarid_tipo_bancoImportarExportar) {
		this.mostrarid_tipo_bancoImportarExportar= mostrarid_tipo_bancoImportarExportar;
	}

	public Boolean getActivarid_tipo_bancoImportarExportar() {
		return this.activarid_tipo_bancoImportarExportar;
	}

	public void setActivarid_tipo_bancoImportarExportar(Boolean activarid_tipo_bancoImportarExportar) {
		this.activarid_tipo_bancoImportarExportar= activarid_tipo_bancoImportarExportar;
	}

	public Boolean getCargarid_tipo_bancoImportarExportar() {
		return this.cargarid_tipo_bancoImportarExportar;
	}

	public void setCargarid_tipo_bancoImportarExportar(Boolean cargarid_tipo_bancoImportarExportar) {
		this.cargarid_tipo_bancoImportarExportar= cargarid_tipo_bancoImportarExportar;
	}

	public Border setResaltarid_tipo_comprobante_bancoImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_comprobante_bancoImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_comprobante_bancoImportarExportar() {
		return this.resaltarid_tipo_comprobante_bancoImportarExportar;
	}

	public void setResaltarid_tipo_comprobante_bancoImportarExportar(Border borderResaltar) {
		this.resaltarid_tipo_comprobante_bancoImportarExportar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_comprobante_bancoImportarExportar() {
		return this.mostrarid_tipo_comprobante_bancoImportarExportar;
	}

	public void setMostrarid_tipo_comprobante_bancoImportarExportar(Boolean mostrarid_tipo_comprobante_bancoImportarExportar) {
		this.mostrarid_tipo_comprobante_bancoImportarExportar= mostrarid_tipo_comprobante_bancoImportarExportar;
	}

	public Boolean getActivarid_tipo_comprobante_bancoImportarExportar() {
		return this.activarid_tipo_comprobante_bancoImportarExportar;
	}

	public void setActivarid_tipo_comprobante_bancoImportarExportar(Boolean activarid_tipo_comprobante_bancoImportarExportar) {
		this.activarid_tipo_comprobante_bancoImportarExportar= activarid_tipo_comprobante_bancoImportarExportar;
	}

	public Boolean getCargarid_tipo_comprobante_bancoImportarExportar() {
		return this.cargarid_tipo_comprobante_bancoImportarExportar;
	}

	public void setCargarid_tipo_comprobante_bancoImportarExportar(Boolean cargarid_tipo_comprobante_bancoImportarExportar) {
		this.cargarid_tipo_comprobante_bancoImportarExportar= cargarid_tipo_comprobante_bancoImportarExportar;
	}

	public Border setResaltarcon_convenioImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarcon_convenioImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_convenioImportarExportar() {
		return this.resaltarcon_convenioImportarExportar;
	}

	public void setResaltarcon_convenioImportarExportar(Border borderResaltar) {
		this.resaltarcon_convenioImportarExportar= borderResaltar;
	}

	public Boolean getMostrarcon_convenioImportarExportar() {
		return this.mostrarcon_convenioImportarExportar;
	}

	public void setMostrarcon_convenioImportarExportar(Boolean mostrarcon_convenioImportarExportar) {
		this.mostrarcon_convenioImportarExportar= mostrarcon_convenioImportarExportar;
	}

	public Boolean getActivarcon_convenioImportarExportar() {
		return this.activarcon_convenioImportarExportar;
	}

	public void setActivarcon_convenioImportarExportar(Boolean activarcon_convenioImportarExportar) {
		this.activarcon_convenioImportarExportar= activarcon_convenioImportarExportar;
	}

	public Border setResaltarcon_devolucionImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarcon_devolucionImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_devolucionImportarExportar() {
		return this.resaltarcon_devolucionImportarExportar;
	}

	public void setResaltarcon_devolucionImportarExportar(Border borderResaltar) {
		this.resaltarcon_devolucionImportarExportar= borderResaltar;
	}

	public Boolean getMostrarcon_devolucionImportarExportar() {
		return this.mostrarcon_devolucionImportarExportar;
	}

	public void setMostrarcon_devolucionImportarExportar(Boolean mostrarcon_devolucionImportarExportar) {
		this.mostrarcon_devolucionImportarExportar= mostrarcon_devolucionImportarExportar;
	}

	public Boolean getActivarcon_devolucionImportarExportar() {
		return this.activarcon_devolucionImportarExportar;
	}

	public void setActivarcon_devolucionImportarExportar(Boolean activarcon_devolucionImportarExportar) {
		this.activarcon_devolucionImportarExportar= activarcon_devolucionImportarExportar;
	}

	public Border setResaltarfecha_emisionImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarfecha_emisionImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionImportarExportar() {
		return this.resaltarfecha_emisionImportarExportar;
	}

	public void setResaltarfecha_emisionImportarExportar(Border borderResaltar) {
		this.resaltarfecha_emisionImportarExportar= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionImportarExportar() {
		return this.mostrarfecha_emisionImportarExportar;
	}

	public void setMostrarfecha_emisionImportarExportar(Boolean mostrarfecha_emisionImportarExportar) {
		this.mostrarfecha_emisionImportarExportar= mostrarfecha_emisionImportarExportar;
	}

	public Boolean getActivarfecha_emisionImportarExportar() {
		return this.activarfecha_emisionImportarExportar;
	}

	public void setActivarfecha_emisionImportarExportar(Boolean activarfecha_emisionImportarExportar) {
		this.activarfecha_emisionImportarExportar= activarfecha_emisionImportarExportar;
	}

	public Border setResaltarnumero_serie_comprobanteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarnumero_serie_comprobanteImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serie_comprobanteImportarExportar() {
		return this.resaltarnumero_serie_comprobanteImportarExportar;
	}

	public void setResaltarnumero_serie_comprobanteImportarExportar(Border borderResaltar) {
		this.resaltarnumero_serie_comprobanteImportarExportar= borderResaltar;
	}

	public Boolean getMostrarnumero_serie_comprobanteImportarExportar() {
		return this.mostrarnumero_serie_comprobanteImportarExportar;
	}

	public void setMostrarnumero_serie_comprobanteImportarExportar(Boolean mostrarnumero_serie_comprobanteImportarExportar) {
		this.mostrarnumero_serie_comprobanteImportarExportar= mostrarnumero_serie_comprobanteImportarExportar;
	}

	public Boolean getActivarnumero_serie_comprobanteImportarExportar() {
		return this.activarnumero_serie_comprobanteImportarExportar;
	}

	public void setActivarnumero_serie_comprobanteImportarExportar(Boolean activarnumero_serie_comprobanteImportarExportar) {
		this.activarnumero_serie_comprobanteImportarExportar= activarnumero_serie_comprobanteImportarExportar;
	}

	public Border setResaltarnumero_autorizacion_comprobanteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarnumero_autorizacion_comprobanteImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacion_comprobanteImportarExportar() {
		return this.resaltarnumero_autorizacion_comprobanteImportarExportar;
	}

	public void setResaltarnumero_autorizacion_comprobanteImportarExportar(Border borderResaltar) {
		this.resaltarnumero_autorizacion_comprobanteImportarExportar= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacion_comprobanteImportarExportar() {
		return this.mostrarnumero_autorizacion_comprobanteImportarExportar;
	}

	public void setMostrarnumero_autorizacion_comprobanteImportarExportar(Boolean mostrarnumero_autorizacion_comprobanteImportarExportar) {
		this.mostrarnumero_autorizacion_comprobanteImportarExportar= mostrarnumero_autorizacion_comprobanteImportarExportar;
	}

	public Boolean getActivarnumero_autorizacion_comprobanteImportarExportar() {
		return this.activarnumero_autorizacion_comprobanteImportarExportar;
	}

	public void setActivarnumero_autorizacion_comprobanteImportarExportar(Boolean activarnumero_autorizacion_comprobanteImportarExportar) {
		this.activarnumero_autorizacion_comprobanteImportarExportar= activarnumero_autorizacion_comprobanteImportarExportar;
	}

	public Border setResaltarnumero_secuencial_fuenteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarnumero_secuencial_fuenteImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencial_fuenteImportarExportar() {
		return this.resaltarnumero_secuencial_fuenteImportarExportar;
	}

	public void setResaltarnumero_secuencial_fuenteImportarExportar(Border borderResaltar) {
		this.resaltarnumero_secuencial_fuenteImportarExportar= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencial_fuenteImportarExportar() {
		return this.mostrarnumero_secuencial_fuenteImportarExportar;
	}

	public void setMostrarnumero_secuencial_fuenteImportarExportar(Boolean mostrarnumero_secuencial_fuenteImportarExportar) {
		this.mostrarnumero_secuencial_fuenteImportarExportar= mostrarnumero_secuencial_fuenteImportarExportar;
	}

	public Boolean getActivarnumero_secuencial_fuenteImportarExportar() {
		return this.activarnumero_secuencial_fuenteImportarExportar;
	}

	public void setActivarnumero_secuencial_fuenteImportarExportar(Boolean activarnumero_secuencial_fuenteImportarExportar) {
		this.activarnumero_secuencial_fuenteImportarExportar= activarnumero_secuencial_fuenteImportarExportar;
	}

	public Border setResaltarvalor_fobImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//importarexportarBeanSwingJInternalFrame.jTtoolBarImportarExportar.setBorder(borderResaltar);
		*/
		this.resaltarvalor_fobImportarExportar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_fobImportarExportar() {
		return this.resaltarvalor_fobImportarExportar;
	}

	public void setResaltarvalor_fobImportarExportar(Border borderResaltar) {
		this.resaltarvalor_fobImportarExportar= borderResaltar;
	}

	public Boolean getMostrarvalor_fobImportarExportar() {
		return this.mostrarvalor_fobImportarExportar;
	}

	public void setMostrarvalor_fobImportarExportar(Boolean mostrarvalor_fobImportarExportar) {
		this.mostrarvalor_fobImportarExportar= mostrarvalor_fobImportarExportar;
	}

	public Boolean getActivarvalor_fobImportarExportar() {
		return this.activarvalor_fobImportarExportar;
	}

	public void setActivarvalor_fobImportarExportar(Boolean activarvalor_fobImportarExportar) {
		this.activarvalor_fobImportarExportar= activarvalor_fobImportarExportar;
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
		
		
		this.setMostraridImportarExportar(esInicial);
		this.setMostrarid_moduloImportarExportar(esInicial);
		this.setMostrarid_asiento_contableImportarExportar(esInicial);
		this.setMostrarrucImportarExportar(esInicial);
		this.setMostrarid_periodo_import_exportImportarExportar(esInicial);
		this.setMostrarid_transaccion_contaImportarExportar(esInicial);
		this.setMostrarfechaImportarExportar(esInicial);
		this.setMostrarid_tipo_importacionImportarExportar(esInicial);
		this.setMostrarid_tipo_comprobanteImportarExportar(esInicial);
		this.setMostrarnumero_comprobanteImportarExportar(esInicial);
		this.setMostrardocumento_transporteImportarExportar(esInicial);
		this.setMostrarnumero_referencia_comprobanteImportarExportar(esInicial);
		this.setMostrarid_tipo_tributarioImportarExportar(esInicial);
		this.setMostrarcodigo_fiscalImportarExportar(esInicial);
		this.setMostrarid_clienteImportarExportar(esInicial);
		this.setMostrares_juridicoImportarExportar(esInicial);
		this.setMostrarbase0ImportarExportar(esInicial);
		this.setMostrarmonto_total_cifImportarExportar(esInicial);
		this.setMostrarmonto_ivaImportarExportar(esInicial);
		this.setMostrarid_tipo_ivaImportarExportar(esInicial);
		this.setMostrarmonto_iceImportarExportar(esInicial);
		this.setMostrarid_tipo_iceImportarExportar(esInicial);
		this.setMostrarbase_generalImportarExportar(esInicial);
		this.setMostrarid_tipo_bancoImportarExportar(esInicial);
		this.setMostrarid_tipo_comprobante_bancoImportarExportar(esInicial);
		this.setMostrarcon_convenioImportarExportar(esInicial);
		this.setMostrarcon_devolucionImportarExportar(esInicial);
		this.setMostrarfecha_emisionImportarExportar(esInicial);
		this.setMostrarnumero_serie_comprobanteImportarExportar(esInicial);
		this.setMostrarnumero_autorizacion_comprobanteImportarExportar(esInicial);
		this.setMostrarnumero_secuencial_fuenteImportarExportar(esInicial);
		this.setMostrarvalor_fobImportarExportar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImportarExportarConstantesFunciones.ID)) {
				this.setMostraridImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.RUCINFORMANTE)) {
				this.setMostrarrucImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT)) {
				this.setMostrarid_periodo_import_exportImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setMostrarid_transaccion_contaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.FECHA)) {
				this.setMostrarfechaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOIMPORTACION)) {
				this.setMostrarid_tipo_importacionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setMostrarid_tipo_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE)) {
				this.setMostrardocumento_transporteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE)) {
				this.setMostrarnumero_referencia_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setMostrarid_tipo_tributarioImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CODIGOFISCAL)) {
				this.setMostrarcodigo_fiscalImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.ESJURIDICO)) {
				this.setMostrares_juridicoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.BASE0)) {
				this.setMostrarbase0ImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOTOTALCIF)) {
				this.setMostrarmonto_total_cifImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOIVA)) {
				this.setMostrarmonto_ivaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOIVA)) {
				this.setMostrarid_tipo_ivaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOICE)) {
				this.setMostrarmonto_iceImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOICE)) {
				this.setMostrarid_tipo_iceImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.BASEGENERAL)) {
				this.setMostrarbase_generalImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOBANCO)) {
				this.setMostrarid_tipo_bancoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO)) {
				this.setMostrarid_tipo_comprobante_bancoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CONCONVENIO)) {
				this.setMostrarcon_convenioImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CONDEVOLUCION)) {
				this.setMostrarcon_devolucionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE)) {
				this.setMostrarnumero_serie_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE)) {
				this.setMostrarnumero_autorizacion_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE)) {
				this.setMostrarnumero_secuencial_fuenteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.VALORFOB)) {
				this.setMostrarvalor_fobImportarExportar(esAsigna);
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
		
		
		this.setActivaridImportarExportar(esInicial);
		this.setActivarid_moduloImportarExportar(esInicial);
		this.setActivarid_asiento_contableImportarExportar(esInicial);
		this.setActivarrucImportarExportar(esInicial);
		this.setActivarid_periodo_import_exportImportarExportar(esInicial);
		this.setActivarid_transaccion_contaImportarExportar(esInicial);
		this.setActivarfechaImportarExportar(esInicial);
		this.setActivarid_tipo_importacionImportarExportar(esInicial);
		this.setActivarid_tipo_comprobanteImportarExportar(esInicial);
		this.setActivarnumero_comprobanteImportarExportar(esInicial);
		this.setActivardocumento_transporteImportarExportar(esInicial);
		this.setActivarnumero_referencia_comprobanteImportarExportar(esInicial);
		this.setActivarid_tipo_tributarioImportarExportar(esInicial);
		this.setActivarcodigo_fiscalImportarExportar(esInicial);
		this.setActivarid_clienteImportarExportar(esInicial);
		this.setActivares_juridicoImportarExportar(esInicial);
		this.setActivarbase0ImportarExportar(esInicial);
		this.setActivarmonto_total_cifImportarExportar(esInicial);
		this.setActivarmonto_ivaImportarExportar(esInicial);
		this.setActivarid_tipo_ivaImportarExportar(esInicial);
		this.setActivarmonto_iceImportarExportar(esInicial);
		this.setActivarid_tipo_iceImportarExportar(esInicial);
		this.setActivarbase_generalImportarExportar(esInicial);
		this.setActivarid_tipo_bancoImportarExportar(esInicial);
		this.setActivarid_tipo_comprobante_bancoImportarExportar(esInicial);
		this.setActivarcon_convenioImportarExportar(esInicial);
		this.setActivarcon_devolucionImportarExportar(esInicial);
		this.setActivarfecha_emisionImportarExportar(esInicial);
		this.setActivarnumero_serie_comprobanteImportarExportar(esInicial);
		this.setActivarnumero_autorizacion_comprobanteImportarExportar(esInicial);
		this.setActivarnumero_secuencial_fuenteImportarExportar(esInicial);
		this.setActivarvalor_fobImportarExportar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImportarExportarConstantesFunciones.ID)) {
				this.setActivaridImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.RUCINFORMANTE)) {
				this.setActivarrucImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT)) {
				this.setActivarid_periodo_import_exportImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setActivarid_transaccion_contaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.FECHA)) {
				this.setActivarfechaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOIMPORTACION)) {
				this.setActivarid_tipo_importacionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setActivarid_tipo_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE)) {
				this.setActivardocumento_transporteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE)) {
				this.setActivarnumero_referencia_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setActivarid_tipo_tributarioImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CODIGOFISCAL)) {
				this.setActivarcodigo_fiscalImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.ESJURIDICO)) {
				this.setActivares_juridicoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.BASE0)) {
				this.setActivarbase0ImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOTOTALCIF)) {
				this.setActivarmonto_total_cifImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOIVA)) {
				this.setActivarmonto_ivaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOIVA)) {
				this.setActivarid_tipo_ivaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOICE)) {
				this.setActivarmonto_iceImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOICE)) {
				this.setActivarid_tipo_iceImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.BASEGENERAL)) {
				this.setActivarbase_generalImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOBANCO)) {
				this.setActivarid_tipo_bancoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO)) {
				this.setActivarid_tipo_comprobante_bancoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CONCONVENIO)) {
				this.setActivarcon_convenioImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CONDEVOLUCION)) {
				this.setActivarcon_devolucionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE)) {
				this.setActivarnumero_serie_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE)) {
				this.setActivarnumero_autorizacion_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE)) {
				this.setActivarnumero_secuencial_fuenteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.VALORFOB)) {
				this.setActivarvalor_fobImportarExportar(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridImportarExportar(esInicial);
		this.setResaltarid_moduloImportarExportar(esInicial);
		this.setResaltarid_asiento_contableImportarExportar(esInicial);
		this.setResaltarrucImportarExportar(esInicial);
		this.setResaltarid_periodo_import_exportImportarExportar(esInicial);
		this.setResaltarid_transaccion_contaImportarExportar(esInicial);
		this.setResaltarfechaImportarExportar(esInicial);
		this.setResaltarid_tipo_importacionImportarExportar(esInicial);
		this.setResaltarid_tipo_comprobanteImportarExportar(esInicial);
		this.setResaltarnumero_comprobanteImportarExportar(esInicial);
		this.setResaltardocumento_transporteImportarExportar(esInicial);
		this.setResaltarnumero_referencia_comprobanteImportarExportar(esInicial);
		this.setResaltarid_tipo_tributarioImportarExportar(esInicial);
		this.setResaltarcodigo_fiscalImportarExportar(esInicial);
		this.setResaltarid_clienteImportarExportar(esInicial);
		this.setResaltares_juridicoImportarExportar(esInicial);
		this.setResaltarbase0ImportarExportar(esInicial);
		this.setResaltarmonto_total_cifImportarExportar(esInicial);
		this.setResaltarmonto_ivaImportarExportar(esInicial);
		this.setResaltarid_tipo_ivaImportarExportar(esInicial);
		this.setResaltarmonto_iceImportarExportar(esInicial);
		this.setResaltarid_tipo_iceImportarExportar(esInicial);
		this.setResaltarbase_generalImportarExportar(esInicial);
		this.setResaltarid_tipo_bancoImportarExportar(esInicial);
		this.setResaltarid_tipo_comprobante_bancoImportarExportar(esInicial);
		this.setResaltarcon_convenioImportarExportar(esInicial);
		this.setResaltarcon_devolucionImportarExportar(esInicial);
		this.setResaltarfecha_emisionImportarExportar(esInicial);
		this.setResaltarnumero_serie_comprobanteImportarExportar(esInicial);
		this.setResaltarnumero_autorizacion_comprobanteImportarExportar(esInicial);
		this.setResaltarnumero_secuencial_fuenteImportarExportar(esInicial);
		this.setResaltarvalor_fobImportarExportar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImportarExportarConstantesFunciones.ID)) {
				this.setResaltaridImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.RUCINFORMANTE)) {
				this.setResaltarrucImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT)) {
				this.setResaltarid_periodo_import_exportImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setResaltarid_transaccion_contaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.FECHA)) {
				this.setResaltarfechaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOIMPORTACION)) {
				this.setResaltarid_tipo_importacionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setResaltarid_tipo_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE)) {
				this.setResaltardocumento_transporteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE)) {
				this.setResaltarnumero_referencia_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setResaltarid_tipo_tributarioImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CODIGOFISCAL)) {
				this.setResaltarcodigo_fiscalImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.ESJURIDICO)) {
				this.setResaltares_juridicoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.BASE0)) {
				this.setResaltarbase0ImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOTOTALCIF)) {
				this.setResaltarmonto_total_cifImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOIVA)) {
				this.setResaltarmonto_ivaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOIVA)) {
				this.setResaltarid_tipo_ivaImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.MONTOICE)) {
				this.setResaltarmonto_iceImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOICE)) {
				this.setResaltarid_tipo_iceImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.BASEGENERAL)) {
				this.setResaltarbase_generalImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOBANCO)) {
				this.setResaltarid_tipo_bancoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO)) {
				this.setResaltarid_tipo_comprobante_bancoImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CONCONVENIO)) {
				this.setResaltarcon_convenioImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.CONDEVOLUCION)) {
				this.setResaltarcon_devolucionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE)) {
				this.setResaltarnumero_serie_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE)) {
				this.setResaltarnumero_autorizacion_comprobanteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE)) {
				this.setResaltarnumero_secuencial_fuenteImportarExportar(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImportarExportarConstantesFunciones.VALORFOB)) {
				this.setResaltarvalor_fobImportarExportar(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNumeroComprobanteImportarExportar=true;

	public Boolean getMostrarBusquedaPorNumeroComprobanteImportarExportar() {
		return this.mostrarBusquedaPorNumeroComprobanteImportarExportar;
	}

	public void setMostrarBusquedaPorNumeroComprobanteImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroComprobanteImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorRucInformanteImportarExportar=true;

	public Boolean getMostrarBusquedaPorRucInformanteImportarExportar() {
		return this.mostrarBusquedaPorRucInformanteImportarExportar;
	}

	public void setMostrarBusquedaPorRucInformanteImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorRucInformanteImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAsientoContableImportarExportar=true;

	public Boolean getMostrarFK_IdAsientoContableImportarExportar() {
		return this.mostrarFK_IdAsientoContableImportarExportar;
	}

	public void setMostrarFK_IdAsientoContableImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteImportarExportar=true;

	public Boolean getMostrarFK_IdClienteImportarExportar() {
		return this.mostrarFK_IdClienteImportarExportar;
	}

	public void setMostrarFK_IdClienteImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloImportarExportar=true;

	public Boolean getMostrarFK_IdModuloImportarExportar() {
		return this.mostrarFK_IdModuloImportarExportar;
	}

	public void setMostrarFK_IdModuloImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoImportExportImportarExportar=true;

	public Boolean getMostrarFK_IdPeriodoImportExportImportarExportar() {
		return this.mostrarFK_IdPeriodoImportExportImportarExportar;
	}

	public void setMostrarFK_IdPeriodoImportExportImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoImportExportImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoBancoImportarExportar=true;

	public Boolean getMostrarFK_IdTipoBancoImportarExportar() {
		return this.mostrarFK_IdTipoBancoImportarExportar;
	}

	public void setMostrarFK_IdTipoBancoImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoBancoImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoComprobanteImportarExportar=true;

	public Boolean getMostrarFK_IdTipoComprobanteImportarExportar() {
		return this.mostrarFK_IdTipoComprobanteImportarExportar;
	}

	public void setMostrarFK_IdTipoComprobanteImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoComprobanteImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoComprobanteBancoImportarExportar=true;

	public Boolean getMostrarFK_IdTipoComprobanteBancoImportarExportar() {
		return this.mostrarFK_IdTipoComprobanteBancoImportarExportar;
	}

	public void setMostrarFK_IdTipoComprobanteBancoImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoComprobanteBancoImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIceImportarExportar=true;

	public Boolean getMostrarFK_IdTipoIceImportarExportar() {
		return this.mostrarFK_IdTipoIceImportarExportar;
	}

	public void setMostrarFK_IdTipoIceImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIceImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoImportacionImportarExportar=true;

	public Boolean getMostrarFK_IdTipoImportacionImportarExportar() {
		return this.mostrarFK_IdTipoImportacionImportarExportar;
	}

	public void setMostrarFK_IdTipoImportacionImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoImportacionImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIvaImportarExportar=true;

	public Boolean getMostrarFK_IdTipoIvaImportarExportar() {
		return this.mostrarFK_IdTipoIvaImportarExportar;
	}

	public void setMostrarFK_IdTipoIvaImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIvaImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTributarioImportarExportar=true;

	public Boolean getMostrarFK_IdTipoTributarioImportarExportar() {
		return this.mostrarFK_IdTipoTributarioImportarExportar;
	}

	public void setMostrarFK_IdTipoTributarioImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTributarioImportarExportar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionContaImportarExportar=true;

	public Boolean getMostrarFK_IdTransaccionContaImportarExportar() {
		return this.mostrarFK_IdTransaccionContaImportarExportar;
	}

	public void setMostrarFK_IdTransaccionContaImportarExportar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionContaImportarExportar= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNumeroComprobanteImportarExportar=true;

	public Boolean getActivarBusquedaPorNumeroComprobanteImportarExportar() {
		return this.activarBusquedaPorNumeroComprobanteImportarExportar;
	}

	public void setActivarBusquedaPorNumeroComprobanteImportarExportar(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroComprobanteImportarExportar= habilitarResaltar;
	}

	public Boolean activarBusquedaPorRucInformanteImportarExportar=true;

	public Boolean getActivarBusquedaPorRucInformanteImportarExportar() {
		return this.activarBusquedaPorRucInformanteImportarExportar;
	}

	public void setActivarBusquedaPorRucInformanteImportarExportar(Boolean habilitarResaltar) {
		this.activarBusquedaPorRucInformanteImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdAsientoContableImportarExportar=true;

	public Boolean getActivarFK_IdAsientoContableImportarExportar() {
		return this.activarFK_IdAsientoContableImportarExportar;
	}

	public void setActivarFK_IdAsientoContableImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteImportarExportar=true;

	public Boolean getActivarFK_IdClienteImportarExportar() {
		return this.activarFK_IdClienteImportarExportar;
	}

	public void setActivarFK_IdClienteImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdClienteImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloImportarExportar=true;

	public Boolean getActivarFK_IdModuloImportarExportar() {
		return this.activarFK_IdModuloImportarExportar;
	}

	public void setActivarFK_IdModuloImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdModuloImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoImportExportImportarExportar=true;

	public Boolean getActivarFK_IdPeriodoImportExportImportarExportar() {
		return this.activarFK_IdPeriodoImportExportImportarExportar;
	}

	public void setActivarFK_IdPeriodoImportExportImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoImportExportImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoBancoImportarExportar=true;

	public Boolean getActivarFK_IdTipoBancoImportarExportar() {
		return this.activarFK_IdTipoBancoImportarExportar;
	}

	public void setActivarFK_IdTipoBancoImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoBancoImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoComprobanteImportarExportar=true;

	public Boolean getActivarFK_IdTipoComprobanteImportarExportar() {
		return this.activarFK_IdTipoComprobanteImportarExportar;
	}

	public void setActivarFK_IdTipoComprobanteImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoComprobanteImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoComprobanteBancoImportarExportar=true;

	public Boolean getActivarFK_IdTipoComprobanteBancoImportarExportar() {
		return this.activarFK_IdTipoComprobanteBancoImportarExportar;
	}

	public void setActivarFK_IdTipoComprobanteBancoImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoComprobanteBancoImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIceImportarExportar=true;

	public Boolean getActivarFK_IdTipoIceImportarExportar() {
		return this.activarFK_IdTipoIceImportarExportar;
	}

	public void setActivarFK_IdTipoIceImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIceImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoImportacionImportarExportar=true;

	public Boolean getActivarFK_IdTipoImportacionImportarExportar() {
		return this.activarFK_IdTipoImportacionImportarExportar;
	}

	public void setActivarFK_IdTipoImportacionImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoImportacionImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIvaImportarExportar=true;

	public Boolean getActivarFK_IdTipoIvaImportarExportar() {
		return this.activarFK_IdTipoIvaImportarExportar;
	}

	public void setActivarFK_IdTipoIvaImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIvaImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTributarioImportarExportar=true;

	public Boolean getActivarFK_IdTipoTributarioImportarExportar() {
		return this.activarFK_IdTipoTributarioImportarExportar;
	}

	public void setActivarFK_IdTipoTributarioImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTributarioImportarExportar= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionContaImportarExportar=true;

	public Boolean getActivarFK_IdTransaccionContaImportarExportar() {
		return this.activarFK_IdTransaccionContaImportarExportar;
	}

	public void setActivarFK_IdTransaccionContaImportarExportar(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionContaImportarExportar= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNumeroComprobanteImportarExportar=null;

	public Border getResaltarBusquedaPorNumeroComprobanteImportarExportar() {
		return this.resaltarBusquedaPorNumeroComprobanteImportarExportar;
	}

	public void setResaltarBusquedaPorNumeroComprobanteImportarExportar(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroComprobanteImportarExportar= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroComprobanteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroComprobanteImportarExportar= borderResaltar;
	}

	public Border resaltarBusquedaPorRucInformanteImportarExportar=null;

	public Border getResaltarBusquedaPorRucInformanteImportarExportar() {
		return this.resaltarBusquedaPorRucInformanteImportarExportar;
	}

	public void setResaltarBusquedaPorRucInformanteImportarExportar(Border borderResaltar) {
		this.resaltarBusquedaPorRucInformanteImportarExportar= borderResaltar;
	}

	public void setResaltarBusquedaPorRucInformanteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorRucInformanteImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdAsientoContableImportarExportar=null;

	public Border getResaltarFK_IdAsientoContableImportarExportar() {
		return this.resaltarFK_IdAsientoContableImportarExportar;
	}

	public void setResaltarFK_IdAsientoContableImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdClienteImportarExportar=null;

	public Border getResaltarFK_IdClienteImportarExportar() {
		return this.resaltarFK_IdClienteImportarExportar;
	}

	public void setResaltarFK_IdClienteImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdClienteImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdClienteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdModuloImportarExportar=null;

	public Border getResaltarFK_IdModuloImportarExportar() {
		return this.resaltarFK_IdModuloImportarExportar;
	}

	public void setResaltarFK_IdModuloImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdModuloImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdModuloImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoImportExportImportarExportar=null;

	public Border getResaltarFK_IdPeriodoImportExportImportarExportar() {
		return this.resaltarFK_IdPeriodoImportExportImportarExportar;
	}

	public void setResaltarFK_IdPeriodoImportExportImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdPeriodoImportExportImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoImportExportImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoImportExportImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdTipoBancoImportarExportar=null;

	public Border getResaltarFK_IdTipoBancoImportarExportar() {
		return this.resaltarFK_IdTipoBancoImportarExportar;
	}

	public void setResaltarFK_IdTipoBancoImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdTipoBancoImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdTipoBancoImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoBancoImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdTipoComprobanteImportarExportar=null;

	public Border getResaltarFK_IdTipoComprobanteImportarExportar() {
		return this.resaltarFK_IdTipoComprobanteImportarExportar;
	}

	public void setResaltarFK_IdTipoComprobanteImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdTipoComprobanteImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdTipoComprobanteImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoComprobanteImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdTipoComprobanteBancoImportarExportar=null;

	public Border getResaltarFK_IdTipoComprobanteBancoImportarExportar() {
		return this.resaltarFK_IdTipoComprobanteBancoImportarExportar;
	}

	public void setResaltarFK_IdTipoComprobanteBancoImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdTipoComprobanteBancoImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdTipoComprobanteBancoImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoComprobanteBancoImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdTipoIceImportarExportar=null;

	public Border getResaltarFK_IdTipoIceImportarExportar() {
		return this.resaltarFK_IdTipoIceImportarExportar;
	}

	public void setResaltarFK_IdTipoIceImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdTipoIceImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdTipoIceImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIceImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdTipoImportacionImportarExportar=null;

	public Border getResaltarFK_IdTipoImportacionImportarExportar() {
		return this.resaltarFK_IdTipoImportacionImportarExportar;
	}

	public void setResaltarFK_IdTipoImportacionImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdTipoImportacionImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdTipoImportacionImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoImportacionImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdTipoIvaImportarExportar=null;

	public Border getResaltarFK_IdTipoIvaImportarExportar() {
		return this.resaltarFK_IdTipoIvaImportarExportar;
	}

	public void setResaltarFK_IdTipoIvaImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdTipoIvaImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdTipoIvaImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIvaImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdTipoTributarioImportarExportar=null;

	public Border getResaltarFK_IdTipoTributarioImportarExportar() {
		return this.resaltarFK_IdTipoTributarioImportarExportar;
	}

	public void setResaltarFK_IdTipoTributarioImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdTipoTributarioImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdTipoTributarioImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTributarioImportarExportar= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionContaImportarExportar=null;

	public Border getResaltarFK_IdTransaccionContaImportarExportar() {
		return this.resaltarFK_IdTransaccionContaImportarExportar;
	}

	public void setResaltarFK_IdTransaccionContaImportarExportar(Border borderResaltar) {
		this.resaltarFK_IdTransaccionContaImportarExportar= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionContaImportarExportar(ParametroGeneralUsuario parametroGeneralUsuario/*ImportarExportarBeanSwingJInternalFrame importarexportarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionContaImportarExportar= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}