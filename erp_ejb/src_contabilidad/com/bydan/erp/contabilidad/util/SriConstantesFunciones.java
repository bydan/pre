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


import com.bydan.erp.contabilidad.util.SriConstantesFunciones;
import com.bydan.erp.contabilidad.util.SriParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.SriParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SriConstantesFunciones extends SriConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Sri";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Sri"+SriConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SriHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SriHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SriConstantesFunciones.SCHEMA+"_"+SriConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SriHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SriConstantesFunciones.SCHEMA+"_"+SriConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SriConstantesFunciones.SCHEMA+"_"+SriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SriHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SriConstantesFunciones.SCHEMA+"_"+SriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SriHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SriConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SriConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SriConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SriConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SriConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sris";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Sri";
	public static final String SCLASSWEBTITULO_LOWER="Sri";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Sri";
	public static final String OBJECTNAME="sri";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="sri";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sri from "+SriConstantesFunciones.SPERSISTENCENAME+" sri";
	public static String QUERYSELECTNATIVE="select "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".version_row,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_asiento_contable,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_transaccion_conta,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".ruc,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_cliente,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".razon_social,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".tipo_comprobante,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".es_rise,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".numero_serie,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".numero_autorizacion,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".numero_secuencial,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".fecha_emision,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".fecha_registro_contable,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".fecha_caducidad,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".tipo_tributario,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".bienes_tar12,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".bienes_tar0,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_tipo_iva,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".servicios_tar12,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".servicios_tar0,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".monto_iva,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".base_impo_tar12,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".base_impo_tar0,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".monto_ice,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".monto_iva_bien,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".monto_iva_servicio,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_bien,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_servicio,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".retencion_iva_bien,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".retencion_iva_servicio,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".con_devolucion,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_tipo_movimiento from "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME;//+" as "+SriConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SriConstantesFuncionesAdditional sriConstantesFuncionesAdditional=null;
	
	public SriConstantesFuncionesAdditional getSriConstantesFuncionesAdditional() {
		return this.sriConstantesFuncionesAdditional;
	}
	
	public void setSriConstantesFuncionesAdditional(SriConstantesFuncionesAdditional sriConstantesFuncionesAdditional) {
		try {
			this.sriConstantesFuncionesAdditional=sriConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDTRANSACCIONCONTA= "id_transaccion_conta";
    public static final String RUC= "ruc";
    public static final String IDCLIENTE= "id_cliente";
    public static final String RAZONSOCIAL= "razon_social";
    public static final String IDTIPOCOMPROBANTE= "tipo_comprobante";
    public static final String ESRISE= "es_rise";
    public static final String NUMEROSERIE= "numero_serie";
    public static final String NUMEROAUTORIZACION= "numero_autorizacion";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAREGISTROCONTABLE= "fecha_registro_contable";
    public static final String FECHACADUCIDAD= "fecha_caducidad";
    public static final String IDTIPOTRIBUTARIO= "tipo_tributario";
    public static final String BIENESTAR12= "bienes_tar12";
    public static final String BIENESTAR0= "bienes_tar0";
    public static final String IDTIPOIVA= "id_tipo_iva";
    public static final String SERVICIOSTAR12= "servicios_tar12";
    public static final String SERVICIOSTAR0= "servicios_tar0";
    public static final String MONTOIVA= "monto_iva";
    public static final String BASEIMPOTAR12= "base_impo_tar12";
    public static final String BASEIMPOTAR0= "base_impo_tar0";
    public static final String MONTOICE= "monto_ice";
    public static final String MONTOIVABIEN= "monto_iva_bien";
    public static final String MONTOIVASERVICIO= "monto_iva_servicio";
    public static final String IDTIPORETENCIONIVABIEN= "id_tipo_retencion_iva_bien";
    public static final String IDTIPORETENCIONIVASERVICIO= "id_tipo_retencion_iva_servicio";
    public static final String RETENCIONIVABIEN= "retencion_iva_bien";
    public static final String RETENCIONIVASERVICIO= "retencion_iva_servicio";
    public static final String CONDEVOLUCION= "con_devolucion";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento C.";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDTRANSACCIONCONTA= "Transaccion";
		public static final String LABEL_IDTRANSACCIONCONTA_LOWER= "Transaccion Conta";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_RAZONSOCIAL= "Razon Social";
		public static final String LABEL_RAZONSOCIAL_LOWER= "Razon Social";
    	public static final String LABEL_IDTIPOCOMPROBANTE= "Tipo Comp.";
		public static final String LABEL_IDTIPOCOMPROBANTE_LOWER= "Tipo Comprobante";
    	public static final String LABEL_ESRISE= "Es Rise";
		public static final String LABEL_ESRISE_LOWER= "Es Rise";
    	public static final String LABEL_NUMEROSERIE= "No Serie";
		public static final String LABEL_NUMEROSERIE_LOWER= "Numero Serie";
    	public static final String LABEL_NUMEROAUTORIZACION= "No Autorizacion";
		public static final String LABEL_NUMEROAUTORIZACION_LOWER= "Numero Autorizacion";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial C";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_FECHAEMISION= "F. Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAREGISTROCONTABLE= "F. Reg. Contable";
		public static final String LABEL_FECHAREGISTROCONTABLE_LOWER= "Fecha Registro Contable";
    	public static final String LABEL_FECHACADUCIDAD= "F. Caducidad";
		public static final String LABEL_FECHACADUCIDAD_LOWER= "Fecha Caducidad";
    	public static final String LABEL_IDTIPOTRIBUTARIO= "Codigo Tribut";
		public static final String LABEL_IDTIPOTRIBUTARIO_LOWER= "Tipo Tributario";
    	public static final String LABEL_BIENESTAR12= "Bienes Tar.12";
		public static final String LABEL_BIENESTAR12_LOWER= "Bienes Tar12";
    	public static final String LABEL_BIENESTAR0= "Bienes Tar.0";
		public static final String LABEL_BIENESTAR0_LOWER= "Bienes Tar0";
    	public static final String LABEL_IDTIPOIVA= "P Iva";
		public static final String LABEL_IDTIPOIVA_LOWER= "Tipo Iva";
    	public static final String LABEL_SERVICIOSTAR12= "Servicios Tar.12";
		public static final String LABEL_SERVICIOSTAR12_LOWER= "Servicios Tar12";
    	public static final String LABEL_SERVICIOSTAR0= "Servicios Tar.0";
		public static final String LABEL_SERVICIOSTAR0_LOWER= "Servicios Tar0";
    	public static final String LABEL_MONTOIVA= "Monto Iva";
		public static final String LABEL_MONTOIVA_LOWER= "Monto Iva";
    	public static final String LABEL_BASEIMPOTAR12= "B. Imp. Tar.12";
		public static final String LABEL_BASEIMPOTAR12_LOWER= "Base Impo Tar12";
    	public static final String LABEL_BASEIMPOTAR0= "B. Imp. Tar 0";
		public static final String LABEL_BASEIMPOTAR0_LOWER= "Base Impo Tar0";
    	public static final String LABEL_MONTOICE= "Monto Ice";
		public static final String LABEL_MONTOICE_LOWER= "Monto Ice";
    	public static final String LABEL_MONTOIVABIEN= "Monto Iva Bien";
		public static final String LABEL_MONTOIVABIEN_LOWER= "Monto Iva Bien";
    	public static final String LABEL_MONTOIVASERVICIO= "Monto Iva Serv";
		public static final String LABEL_MONTOIVASERVICIO_LOWER= "Monto Iva Servicio";
    	public static final String LABEL_IDTIPORETENCIONIVABIEN= "P Ret. Iva Bien";
		public static final String LABEL_IDTIPORETENCIONIVABIEN_LOWER= "Tipo Retencion Iva Bien";
    	public static final String LABEL_IDTIPORETENCIONIVASERVICIO= "P. Ret. Iva Serv";
		public static final String LABEL_IDTIPORETENCIONIVASERVICIO_LOWER= "Tipo Retencion Iva Servicio";
    	public static final String LABEL_RETENCIONIVABIEN= "M.Ret Iva Bien";
		public static final String LABEL_RETENCIONIVABIEN_LOWER= "Retencion Iva Bien";
    	public static final String LABEL_RETENCIONIVASERVICIO= "M.Ret Iva Serv";
		public static final String LABEL_RETENCIONIVASERVICIO_LOWER= "Retencion Iva Servicio";
    	public static final String LABEL_CONDEVOLUCION= "Con Devolucion";
		public static final String LABEL_CONDEVOLUCION_LOWER= "Con Devolucion";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
	
		
		
		
		
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXRAZON_SOCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRAZON_SOCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_SERIE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SERIE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_AUTORIZACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getSriLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SriConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=SriConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(SriConstantesFunciones.IDTRANSACCIONCONTA)) {sLabelColumna=SriConstantesFunciones.LABEL_IDTRANSACCIONCONTA;}
		if(sNombreColumna.equals(SriConstantesFunciones.RUC)) {sLabelColumna=SriConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(SriConstantesFunciones.IDCLIENTE)) {sLabelColumna=SriConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(SriConstantesFunciones.RAZONSOCIAL)) {sLabelColumna=SriConstantesFunciones.LABEL_RAZONSOCIAL;}
		if(sNombreColumna.equals(SriConstantesFunciones.IDTIPOCOMPROBANTE)) {sLabelColumna=SriConstantesFunciones.LABEL_IDTIPOCOMPROBANTE;}
		if(sNombreColumna.equals(SriConstantesFunciones.ESRISE)) {sLabelColumna=SriConstantesFunciones.LABEL_ESRISE;}
		if(sNombreColumna.equals(SriConstantesFunciones.NUMEROSERIE)) {sLabelColumna=SriConstantesFunciones.LABEL_NUMEROSERIE;}
		if(sNombreColumna.equals(SriConstantesFunciones.NUMEROAUTORIZACION)) {sLabelColumna=SriConstantesFunciones.LABEL_NUMEROAUTORIZACION;}
		if(sNombreColumna.equals(SriConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=SriConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(SriConstantesFunciones.FECHAEMISION)) {sLabelColumna=SriConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(SriConstantesFunciones.FECHAREGISTROCONTABLE)) {sLabelColumna=SriConstantesFunciones.LABEL_FECHAREGISTROCONTABLE;}
		if(sNombreColumna.equals(SriConstantesFunciones.FECHACADUCIDAD)) {sLabelColumna=SriConstantesFunciones.LABEL_FECHACADUCIDAD;}
		if(sNombreColumna.equals(SriConstantesFunciones.IDTIPOTRIBUTARIO)) {sLabelColumna=SriConstantesFunciones.LABEL_IDTIPOTRIBUTARIO;}
		if(sNombreColumna.equals(SriConstantesFunciones.BIENESTAR12)) {sLabelColumna=SriConstantesFunciones.LABEL_BIENESTAR12;}
		if(sNombreColumna.equals(SriConstantesFunciones.BIENESTAR0)) {sLabelColumna=SriConstantesFunciones.LABEL_BIENESTAR0;}
		if(sNombreColumna.equals(SriConstantesFunciones.IDTIPOIVA)) {sLabelColumna=SriConstantesFunciones.LABEL_IDTIPOIVA;}
		if(sNombreColumna.equals(SriConstantesFunciones.SERVICIOSTAR12)) {sLabelColumna=SriConstantesFunciones.LABEL_SERVICIOSTAR12;}
		if(sNombreColumna.equals(SriConstantesFunciones.SERVICIOSTAR0)) {sLabelColumna=SriConstantesFunciones.LABEL_SERVICIOSTAR0;}
		if(sNombreColumna.equals(SriConstantesFunciones.MONTOIVA)) {sLabelColumna=SriConstantesFunciones.LABEL_MONTOIVA;}
		if(sNombreColumna.equals(SriConstantesFunciones.BASEIMPOTAR12)) {sLabelColumna=SriConstantesFunciones.LABEL_BASEIMPOTAR12;}
		if(sNombreColumna.equals(SriConstantesFunciones.BASEIMPOTAR0)) {sLabelColumna=SriConstantesFunciones.LABEL_BASEIMPOTAR0;}
		if(sNombreColumna.equals(SriConstantesFunciones.MONTOICE)) {sLabelColumna=SriConstantesFunciones.LABEL_MONTOICE;}
		if(sNombreColumna.equals(SriConstantesFunciones.MONTOIVABIEN)) {sLabelColumna=SriConstantesFunciones.LABEL_MONTOIVABIEN;}
		if(sNombreColumna.equals(SriConstantesFunciones.MONTOIVASERVICIO)) {sLabelColumna=SriConstantesFunciones.LABEL_MONTOIVASERVICIO;}
		if(sNombreColumna.equals(SriConstantesFunciones.IDTIPORETENCIONIVABIEN)) {sLabelColumna=SriConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN;}
		if(sNombreColumna.equals(SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO)) {sLabelColumna=SriConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO;}
		if(sNombreColumna.equals(SriConstantesFunciones.RETENCIONIVABIEN)) {sLabelColumna=SriConstantesFunciones.LABEL_RETENCIONIVABIEN;}
		if(sNombreColumna.equals(SriConstantesFunciones.RETENCIONIVASERVICIO)) {sLabelColumna=SriConstantesFunciones.LABEL_RETENCIONIVASERVICIO;}
		if(sNombreColumna.equals(SriConstantesFunciones.CONDEVOLUCION)) {sLabelColumna=SriConstantesFunciones.LABEL_CONDEVOLUCION;}
		if(sNombreColumna.equals(SriConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=SriConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
		
	public static String getes_riseDescripcion(Sri sri) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!sri.getes_rise()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_riseHtmlDescripcion(Sri sri) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(sri.getId(),sri.getes_rise());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_devolucionDescripcion(Sri sri) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!sri.getcon_devolucion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_devolucionHtmlDescripcion(Sri sri) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(sri.getId(),sri.getcon_devolucion());

		return sDescripcion;
	}	
			
	
	public static String getSriDescripcion(Sri sri) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sri !=null/* && sri.getId()!=0*/) {
			sDescripcion=sri.getruc();//srisri.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getSriDescripcionDetallado(Sri sri) {
		String sDescripcion="";
			
		sDescripcion+=SriConstantesFunciones.ID+"=";
		sDescripcion+=sri.getId().toString()+",";
		sDescripcion+=SriConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sri.getVersionRow().toString()+",";
		sDescripcion+=SriConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=sri.getid_asiento_contable().toString()+",";
		sDescripcion+=SriConstantesFunciones.IDTRANSACCIONCONTA+"=";
		sDescripcion+=sri.getid_transaccion_conta().toString()+",";
		sDescripcion+=SriConstantesFunciones.RUC+"=";
		sDescripcion+=sri.getruc()+",";
		sDescripcion+=SriConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=sri.getid_cliente().toString()+",";
		sDescripcion+=SriConstantesFunciones.RAZONSOCIAL+"=";
		sDescripcion+=sri.getrazon_social()+",";
		sDescripcion+=SriConstantesFunciones.IDTIPOCOMPROBANTE+"=";
		sDescripcion+=sri.gettipo_comprobante().toString()+",";
		sDescripcion+=SriConstantesFunciones.ESRISE+"=";
		sDescripcion+=sri.getes_rise().toString()+",";
		sDescripcion+=SriConstantesFunciones.NUMEROSERIE+"=";
		sDescripcion+=sri.getnumero_serie()+",";
		sDescripcion+=SriConstantesFunciones.NUMEROAUTORIZACION+"=";
		sDescripcion+=sri.getnumero_autorizacion()+",";
		sDescripcion+=SriConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=sri.getnumero_secuencial()+",";
		sDescripcion+=SriConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=sri.getfecha_emision().toString()+",";
		sDescripcion+=SriConstantesFunciones.FECHAREGISTROCONTABLE+"=";
		sDescripcion+=sri.getfecha_registro_contable().toString()+",";
		sDescripcion+=SriConstantesFunciones.FECHACADUCIDAD+"=";
		sDescripcion+=sri.getfecha_caducidad().toString()+",";
		sDescripcion+=SriConstantesFunciones.IDTIPOTRIBUTARIO+"=";
		sDescripcion+=sri.gettipo_tributario().toString()+",";
		sDescripcion+=SriConstantesFunciones.BIENESTAR12+"=";
		sDescripcion+=sri.getbienes_tar12().toString()+",";
		sDescripcion+=SriConstantesFunciones.BIENESTAR0+"=";
		sDescripcion+=sri.getbienes_tar0().toString()+",";
		sDescripcion+=SriConstantesFunciones.IDTIPOIVA+"=";
		sDescripcion+=sri.getid_tipo_iva().toString()+",";
		sDescripcion+=SriConstantesFunciones.SERVICIOSTAR12+"=";
		sDescripcion+=sri.getservicios_tar12().toString()+",";
		sDescripcion+=SriConstantesFunciones.SERVICIOSTAR0+"=";
		sDescripcion+=sri.getservicios_tar0().toString()+",";
		sDescripcion+=SriConstantesFunciones.MONTOIVA+"=";
		sDescripcion+=sri.getmonto_iva().toString()+",";
		sDescripcion+=SriConstantesFunciones.BASEIMPOTAR12+"=";
		sDescripcion+=sri.getbase_impo_tar12().toString()+",";
		sDescripcion+=SriConstantesFunciones.BASEIMPOTAR0+"=";
		sDescripcion+=sri.getbase_impo_tar0().toString()+",";
		sDescripcion+=SriConstantesFunciones.MONTOICE+"=";
		sDescripcion+=sri.getmonto_ice().toString()+",";
		sDescripcion+=SriConstantesFunciones.MONTOIVABIEN+"=";
		sDescripcion+=sri.getmonto_iva_bien().toString()+",";
		sDescripcion+=SriConstantesFunciones.MONTOIVASERVICIO+"=";
		sDescripcion+=sri.getmonto_iva_servicio().toString()+",";
		sDescripcion+=SriConstantesFunciones.IDTIPORETENCIONIVABIEN+"=";
		sDescripcion+=sri.getid_tipo_retencion_iva_bien().toString()+",";
		sDescripcion+=SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO+"=";
		sDescripcion+=sri.getid_tipo_retencion_iva_servicio().toString()+",";
		sDescripcion+=SriConstantesFunciones.RETENCIONIVABIEN+"=";
		sDescripcion+=sri.getretencion_iva_bien().toString()+",";
		sDescripcion+=SriConstantesFunciones.RETENCIONIVASERVICIO+"=";
		sDescripcion+=sri.getretencion_iva_servicio().toString()+",";
		sDescripcion+=SriConstantesFunciones.CONDEVOLUCION+"=";
		sDescripcion+=sri.getcon_devolucion().toString()+",";
		sDescripcion+=SriConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=sri.getid_tipo_movimiento().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setSriDescripcion(Sri sri,String sValor) throws Exception {			
		if(sri !=null) {
			sri.setruc(sValor);//srisri.getId().toString();
		}		
	}
	
		

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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

	public static String getTipoIvaDescripcion(TipoIva tipoiva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoiva!=null/*&&tipoiva.getId()>0*/) {
			sDescripcion=TipoIvaConstantesFunciones.getTipoIvaDescripcion(tipoiva);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIvaBienDescripcion(TipoRetencionIva tiporetencioniva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencioniva!=null/*&&tiporetencioniva.getId()>0*/) {
			sDescripcion=TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(tiporetencioniva);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIvaServicioDescripcion(TipoRetencionIva tiporetencioniva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencioniva!=null/*&&tiporetencioniva.getId()>0*/) {
			sDescripcion=TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(tiporetencioniva);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento C.";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdTipoComprobante")) {
			sNombreIndice="Tipo=  Por Tipo Comp.";
		} else if(sNombreIndice.equals("FK_IdTipoIva")) {
			sNombreIndice="Tipo=  Por P Iva";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIvaBien")) {
			sNombreIndice="Tipo=  Por P Ret. Iva Bien";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIvaServicio")) {
			sNombreIndice="Tipo=  Por P. Ret. Iva Serv";
		} else if(sNombreIndice.equals("FK_IdTipoTributario")) {
			sNombreIndice="Tipo=  Por Codigo Tribut";
		} else if(sNombreIndice.equals("FK_IdTransaccionConta")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento C.="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoComprobante(Long tipo_comprobante) {
		String sDetalleIndice=" Parametros->";
		if(tipo_comprobante!=null) {sDetalleIndice+=" Codigo Unico De Tipo Comp.="+tipo_comprobante.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoIva(Long id_tipo_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_iva!=null) {sDetalleIndice+=" Codigo Unico De P Iva="+id_tipo_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIvaBien(Long id_tipo_retencion_iva_bien) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva_bien!=null) {sDetalleIndice+=" Codigo Unico De P Ret. Iva Bien="+id_tipo_retencion_iva_bien.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIvaServicio(Long id_tipo_retencion_iva_servicio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva_servicio!=null) {sDetalleIndice+=" Codigo Unico De P. Ret. Iva Serv="+id_tipo_retencion_iva_servicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTributario(Long tipo_tributario) {
		String sDetalleIndice=" Parametros->";
		if(tipo_tributario!=null) {sDetalleIndice+=" Codigo Unico De Codigo Tribut="+tipo_tributario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionConta(Long id_transaccion_conta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion_conta!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion_conta.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSri(Sri sri,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sri.setruc(sri.getruc().trim());
		sri.setrazon_social(sri.getrazon_social().trim());
		sri.setnumero_serie(sri.getnumero_serie().trim());
		sri.setnumero_autorizacion(sri.getnumero_autorizacion().trim());
		sri.setnumero_secuencial(sri.getnumero_secuencial().trim());
	}
	
	public static void quitarEspaciosSris(List<Sri> sris,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Sri sri: sris) {
			sri.setruc(sri.getruc().trim());
			sri.setrazon_social(sri.getrazon_social().trim());
			sri.setnumero_serie(sri.getnumero_serie().trim());
			sri.setnumero_autorizacion(sri.getnumero_autorizacion().trim());
			sri.setnumero_secuencial(sri.getnumero_secuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSri(Sri sri,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sri.getConCambioAuxiliar()) {
			sri.setIsDeleted(sri.getIsDeletedAuxiliar());	
			sri.setIsNew(sri.getIsNewAuxiliar());	
			sri.setIsChanged(sri.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sri.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sri.setIsDeletedAuxiliar(false);	
			sri.setIsNewAuxiliar(false);	
			sri.setIsChangedAuxiliar(false);
			
			sri.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSris(List<Sri> sris,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Sri sri : sris) {
			if(conAsignarBase && sri.getConCambioAuxiliar()) {
				sri.setIsDeleted(sri.getIsDeletedAuxiliar());	
				sri.setIsNew(sri.getIsNewAuxiliar());	
				sri.setIsChanged(sri.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sri.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sri.setIsDeletedAuxiliar(false);	
				sri.setIsNewAuxiliar(false);	
				sri.setIsChangedAuxiliar(false);
				
				sri.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSri(Sri sri,Boolean conEnteros) throws Exception  {
		sri.setbienes_tar12(0.0);
		sri.setbienes_tar0(0.0);
		sri.setservicios_tar12(0.0);
		sri.setservicios_tar0(0.0);
		sri.setmonto_iva(0.0);
		sri.setbase_impo_tar12(0.0);
		sri.setbase_impo_tar0(0.0);
		sri.setmonto_ice(0.0);
		sri.setmonto_iva_bien(0.0);
		sri.setmonto_iva_servicio(0.0);
		sri.setretencion_iva_bien(0.0);
		sri.setretencion_iva_servicio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSris(List<Sri> sris,Boolean conEnteros) throws Exception  {
		
		for(Sri sri: sris) {
			sri.setbienes_tar12(0.0);
			sri.setbienes_tar0(0.0);
			sri.setservicios_tar12(0.0);
			sri.setservicios_tar0(0.0);
			sri.setmonto_iva(0.0);
			sri.setbase_impo_tar12(0.0);
			sri.setbase_impo_tar0(0.0);
			sri.setmonto_ice(0.0);
			sri.setmonto_iva_bien(0.0);
			sri.setmonto_iva_servicio(0.0);
			sri.setretencion_iva_bien(0.0);
			sri.setretencion_iva_servicio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSri(List<Sri> sris,Sri sriAux) throws Exception  {
		SriConstantesFunciones.InicializarValoresSri(sriAux,true);
		
		for(Sri sri: sris) {
			if(sri.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			sriAux.setbienes_tar12(sriAux.getbienes_tar12()+sri.getbienes_tar12());			
			sriAux.setbienes_tar0(sriAux.getbienes_tar0()+sri.getbienes_tar0());			
			sriAux.setservicios_tar12(sriAux.getservicios_tar12()+sri.getservicios_tar12());			
			sriAux.setservicios_tar0(sriAux.getservicios_tar0()+sri.getservicios_tar0());			
			sriAux.setmonto_iva(sriAux.getmonto_iva()+sri.getmonto_iva());			
			sriAux.setbase_impo_tar12(sriAux.getbase_impo_tar12()+sri.getbase_impo_tar12());			
			sriAux.setbase_impo_tar0(sriAux.getbase_impo_tar0()+sri.getbase_impo_tar0());			
			sriAux.setmonto_ice(sriAux.getmonto_ice()+sri.getmonto_ice());			
			sriAux.setmonto_iva_bien(sriAux.getmonto_iva_bien()+sri.getmonto_iva_bien());			
			sriAux.setmonto_iva_servicio(sriAux.getmonto_iva_servicio()+sri.getmonto_iva_servicio());			
			sriAux.setretencion_iva_bien(sriAux.getretencion_iva_bien()+sri.getretencion_iva_bien());			
			sriAux.setretencion_iva_servicio(sriAux.getretencion_iva_servicio()+sri.getretencion_iva_servicio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSri(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SriConstantesFunciones.getArrayColumnasGlobalesSri(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSri(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSri(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Sri> sris,Sri sri,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Sri sriAux: sris) {
			if(sriAux!=null && sri!=null) {
				if((sriAux.getId()==null && sri.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(sriAux.getId()!=null && sri.getId()!=null){
					if(sriAux.getId().equals(sri.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSri(List<Sri> sris) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double bienes_tar12Total=0.0;
		Double bienes_tar0Total=0.0;
		Double servicios_tar12Total=0.0;
		Double servicios_tar0Total=0.0;
		Double monto_ivaTotal=0.0;
		Double base_impo_tar12Total=0.0;
		Double base_impo_tar0Total=0.0;
		Double monto_iceTotal=0.0;
		Double monto_iva_bienTotal=0.0;
		Double monto_iva_servicioTotal=0.0;
		Double retencion_iva_bienTotal=0.0;
		Double retencion_iva_servicioTotal=0.0;
	
		for(Sri sri: sris) {			
			if(sri.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bienes_tar12Total+=sri.getbienes_tar12();
			bienes_tar0Total+=sri.getbienes_tar0();
			servicios_tar12Total+=sri.getservicios_tar12();
			servicios_tar0Total+=sri.getservicios_tar0();
			monto_ivaTotal+=sri.getmonto_iva();
			base_impo_tar12Total+=sri.getbase_impo_tar12();
			base_impo_tar0Total+=sri.getbase_impo_tar0();
			monto_iceTotal+=sri.getmonto_ice();
			monto_iva_bienTotal+=sri.getmonto_iva_bien();
			monto_iva_servicioTotal+=sri.getmonto_iva_servicio();
			retencion_iva_bienTotal+=sri.getretencion_iva_bien();
			retencion_iva_servicioTotal+=sri.getretencion_iva_servicio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.BIENESTAR12);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_BIENESTAR12);
		datoGeneral.setdValorDouble(bienes_tar12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.BIENESTAR0);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_BIENESTAR0);
		datoGeneral.setdValorDouble(bienes_tar0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.SERVICIOSTAR12);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_SERVICIOSTAR12);
		datoGeneral.setdValorDouble(servicios_tar12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.SERVICIOSTAR0);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_SERVICIOSTAR0);
		datoGeneral.setdValorDouble(servicios_tar0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.MONTOIVA);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_MONTOIVA);
		datoGeneral.setdValorDouble(monto_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.BASEIMPOTAR12);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_BASEIMPOTAR12);
		datoGeneral.setdValorDouble(base_impo_tar12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.BASEIMPOTAR0);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_BASEIMPOTAR0);
		datoGeneral.setdValorDouble(base_impo_tar0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.MONTOICE);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_MONTOICE);
		datoGeneral.setdValorDouble(monto_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.MONTOIVABIEN);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_MONTOIVABIEN);
		datoGeneral.setdValorDouble(monto_iva_bienTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.MONTOIVASERVICIO);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_MONTOIVASERVICIO);
		datoGeneral.setdValorDouble(monto_iva_servicioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.RETENCIONIVABIEN);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_RETENCIONIVABIEN);
		datoGeneral.setdValorDouble(retencion_iva_bienTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(SriConstantesFunciones.RETENCIONIVASERVICIO);
		datoGeneral.setsDescripcion(SriConstantesFunciones.LABEL_RETENCIONIVASERVICIO);
		datoGeneral.setdValorDouble(retencion_iva_servicioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSri() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_ID, SriConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_VERSIONROW, SriConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDASIENTOCONTABLE, SriConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDTRANSACCIONCONTA, SriConstantesFunciones.IDTRANSACCIONCONTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_RUC, SriConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDCLIENTE, SriConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_RAZONSOCIAL, SriConstantesFunciones.RAZONSOCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDTIPOCOMPROBANTE, SriConstantesFunciones.IDTIPOCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_ESRISE, SriConstantesFunciones.ESRISE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_NUMEROSERIE, SriConstantesFunciones.NUMEROSERIE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_NUMEROAUTORIZACION, SriConstantesFunciones.NUMEROAUTORIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_NUMEROSECUENCIAL, SriConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_FECHAEMISION, SriConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_FECHAREGISTROCONTABLE, SriConstantesFunciones.FECHAREGISTROCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_FECHACADUCIDAD, SriConstantesFunciones.FECHACADUCIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDTIPOTRIBUTARIO, SriConstantesFunciones.IDTIPOTRIBUTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_BIENESTAR12, SriConstantesFunciones.BIENESTAR12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_BIENESTAR0, SriConstantesFunciones.BIENESTAR0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDTIPOIVA, SriConstantesFunciones.IDTIPOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_SERVICIOSTAR12, SriConstantesFunciones.SERVICIOSTAR12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_SERVICIOSTAR0, SriConstantesFunciones.SERVICIOSTAR0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_MONTOIVA, SriConstantesFunciones.MONTOIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_BASEIMPOTAR12, SriConstantesFunciones.BASEIMPOTAR12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_BASEIMPOTAR0, SriConstantesFunciones.BASEIMPOTAR0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_MONTOICE, SriConstantesFunciones.MONTOICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_MONTOIVABIEN, SriConstantesFunciones.MONTOIVABIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_MONTOIVASERVICIO, SriConstantesFunciones.MONTOIVASERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN, SriConstantesFunciones.IDTIPORETENCIONIVABIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO, SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_RETENCIONIVABIEN, SriConstantesFunciones.RETENCIONIVABIEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_RETENCIONIVASERVICIO, SriConstantesFunciones.RETENCIONIVASERVICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_CONDEVOLUCION, SriConstantesFunciones.CONDEVOLUCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SriConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, SriConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSri() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDTRANSACCIONCONTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.RAZONSOCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDTIPOCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.ESRISE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.NUMEROSERIE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.NUMEROAUTORIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.FECHAREGISTROCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.FECHACADUCIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDTIPOTRIBUTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.BIENESTAR12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.BIENESTAR0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDTIPOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.SERVICIOSTAR12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.SERVICIOSTAR0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.MONTOIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.BASEIMPOTAR12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.BASEIMPOTAR0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.MONTOICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.MONTOIVABIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.MONTOIVASERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDTIPORETENCIONIVABIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.RETENCIONIVABIEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.RETENCIONIVASERVICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.CONDEVOLUCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SriConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSri() throws Exception  {
		return SriConstantesFunciones.getTiposSeleccionarSri(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSri(Boolean conFk) throws Exception  {
		return SriConstantesFunciones.getTiposSeleccionarSri(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSri(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDTRANSACCIONCONTA);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDTRANSACCIONCONTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_RAZONSOCIAL);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_RAZONSOCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_ESRISE);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_ESRISE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_NUMEROSERIE);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_NUMEROSERIE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_NUMEROAUTORIZACION);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_NUMEROAUTORIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_FECHACADUCIDAD);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_FECHACADUCIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_BIENESTAR12);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_BIENESTAR12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_BIENESTAR0);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_BIENESTAR0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDTIPOIVA);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDTIPOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_SERVICIOSTAR12);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_SERVICIOSTAR12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_SERVICIOSTAR0);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_SERVICIOSTAR0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_MONTOIVA);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_MONTOIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_BASEIMPOTAR12);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_BASEIMPOTAR12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_BASEIMPOTAR0);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_BASEIMPOTAR0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_MONTOICE);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_MONTOICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_MONTOIVABIEN);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_MONTOIVABIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_MONTOIVASERVICIO);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_MONTOIVASERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_RETENCIONIVABIEN);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_RETENCIONIVABIEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_RETENCIONIVASERVICIO);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_RETENCIONIVASERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_CONDEVOLUCION);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_CONDEVOLUCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SriConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(SriConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSri(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSri(Sri sriAux) throws Exception {
		
			sriAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(sriAux.getAsientoContable()));
			sriAux.settransaccionconta_descripcion(TransaccionContaConstantesFunciones.getTransaccionContaDescripcion(sriAux.getTransaccionConta()));
			sriAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(sriAux.getCliente()));
			sriAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(sriAux.getTipoComprobante()));
			sriAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(sriAux.getTipoTributario()));
			sriAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(sriAux.getTipoIva()));
			sriAux.settiporetencionivabien_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(sriAux.getTipoRetencionIvaBien()));
			sriAux.settiporetencionivaservicio_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(sriAux.getTipoRetencionIvaServicio()));
			sriAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(sriAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSri(List<Sri> srisTemp) throws Exception {
		for(Sri sriAux:srisTemp) {
			
			sriAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(sriAux.getAsientoContable()));
			sriAux.settransaccionconta_descripcion(TransaccionContaConstantesFunciones.getTransaccionContaDescripcion(sriAux.getTransaccionConta()));
			sriAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(sriAux.getCliente()));
			sriAux.settipocomprobante_descripcion(TipoComprobanteConstantesFunciones.getTipoComprobanteDescripcion(sriAux.getTipoComprobante()));
			sriAux.settipotributario_descripcion(TipoTributarioConstantesFunciones.getTipoTributarioDescripcion(sriAux.getTipoTributario()));
			sriAux.settipoiva_descripcion(TipoIvaConstantesFunciones.getTipoIvaDescripcion(sriAux.getTipoIva()));
			sriAux.settiporetencionivabien_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(sriAux.getTipoRetencionIvaBien()));
			sriAux.settiporetencionivaservicio_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(sriAux.getTipoRetencionIvaServicio()));
			sriAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(sriAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(TransaccionConta.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoComprobante.class));
				classes.add(new Classe(TipoTributario.class));
				classes.add(new Classe(TipoIva.class));
				classes.add(new Classe(TipoRetencionIva.class));
				classes.add(new Classe(TipoRetencionIva.class));
				classes.add(new Classe(TipoMovimiento.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TransaccionConta.class)) {
						classes.add(new Classe(TransaccionConta.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
					if(clas.clas.equals(TipoIva.class)) {
						classes.add(new Classe(TipoIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencionIva.class)) {
						classes.add(new Classe(TipoRetencionIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencionIva.class)) {
						classes.add(new Classe(TipoRetencionIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TransaccionConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionConta.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TransaccionConta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TransaccionConta.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoComprobante.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoComprobante.class)); continue;
					}

					if(TipoTributario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTributario.class)); continue;
					}

					if(TipoIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoIva.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriConstantesFunciones.getClassesRelationshipsOfSri(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSri(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SriConstantesFunciones.getClassesRelationshipsFromStringsOfSri(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSri(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(Sri sri,List<Sri> sris,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Sri sriEncontrado=null;
			
			for(Sri sriLocal:sris) {
				if(sriLocal.getId().equals(sri.getId())) {
					sriEncontrado=sriLocal;
					
					sriLocal.setIsChanged(sri.getIsChanged());
					sriLocal.setIsNew(sri.getIsNew());
					sriLocal.setIsDeleted(sri.getIsDeleted());
					
					sriLocal.setGeneralEntityOriginal(sri.getGeneralEntityOriginal());
					
					sriLocal.setId(sri.getId());	
					sriLocal.setVersionRow(sri.getVersionRow());	
					sriLocal.setid_asiento_contable(sri.getid_asiento_contable());	
					sriLocal.setid_transaccion_conta(sri.getid_transaccion_conta());	
					sriLocal.setruc(sri.getruc());	
					sriLocal.setid_cliente(sri.getid_cliente());	
					sriLocal.setrazon_social(sri.getrazon_social());	
					sriLocal.settipo_comprobante(sri.gettipo_comprobante());	
					sriLocal.setes_rise(sri.getes_rise());	
					sriLocal.setnumero_serie(sri.getnumero_serie());	
					sriLocal.setnumero_autorizacion(sri.getnumero_autorizacion());	
					sriLocal.setnumero_secuencial(sri.getnumero_secuencial());	
					sriLocal.setfecha_emision(sri.getfecha_emision());	
					sriLocal.setfecha_registro_contable(sri.getfecha_registro_contable());	
					sriLocal.setfecha_caducidad(sri.getfecha_caducidad());	
					sriLocal.settipo_tributario(sri.gettipo_tributario());	
					sriLocal.setbienes_tar12(sri.getbienes_tar12());	
					sriLocal.setbienes_tar0(sri.getbienes_tar0());	
					sriLocal.setid_tipo_iva(sri.getid_tipo_iva());	
					sriLocal.setservicios_tar12(sri.getservicios_tar12());	
					sriLocal.setservicios_tar0(sri.getservicios_tar0());	
					sriLocal.setmonto_iva(sri.getmonto_iva());	
					sriLocal.setbase_impo_tar12(sri.getbase_impo_tar12());	
					sriLocal.setbase_impo_tar0(sri.getbase_impo_tar0());	
					sriLocal.setmonto_ice(sri.getmonto_ice());	
					sriLocal.setmonto_iva_bien(sri.getmonto_iva_bien());	
					sriLocal.setmonto_iva_servicio(sri.getmonto_iva_servicio());	
					sriLocal.setid_tipo_retencion_iva_bien(sri.getid_tipo_retencion_iva_bien());	
					sriLocal.setid_tipo_retencion_iva_servicio(sri.getid_tipo_retencion_iva_servicio());	
					sriLocal.setretencion_iva_bien(sri.getretencion_iva_bien());	
					sriLocal.setretencion_iva_servicio(sri.getretencion_iva_servicio());	
					sriLocal.setcon_devolucion(sri.getcon_devolucion());	
					sriLocal.setid_tipo_movimiento(sri.getid_tipo_movimiento());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!sri.getIsDeleted()) {
				if(!existe) {
					sris.add(sri);
				}
			} else {
				if(sriEncontrado!=null && permiteQuitar)  {
					sris.remove(sriEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Sri sri,List<Sri> sris) throws Exception {
		try	{			
			for(Sri sriLocal:sris) {
				if(sriLocal.getId().equals(sri.getId())) {
					sriLocal.setIsSelected(sri.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSri(List<Sri> srisAux) throws Exception {
		//this.srisAux=srisAux;
		
		for(Sri sriAux:srisAux) {
			if(sriAux.getIsChanged()) {
				sriAux.setIsChanged(false);
			}		
			
			if(sriAux.getIsNew()) {
				sriAux.setIsNew(false);
			}	
			
			if(sriAux.getIsDeleted()) {
				sriAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSri(Sri sriAux) throws Exception {
		//this.sriAux=sriAux;
		
			if(sriAux.getIsChanged()) {
				sriAux.setIsChanged(false);
			}		
			
			if(sriAux.getIsNew()) {
				sriAux.setIsNew(false);
			}	
			
			if(sriAux.getIsDeleted()) {
				sriAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Sri sriAsignar,Sri sri) throws Exception {
		sriAsignar.setId(sri.getId());	
		sriAsignar.setVersionRow(sri.getVersionRow());	
		sriAsignar.setid_asiento_contable(sri.getid_asiento_contable());
		sriAsignar.setasientocontable_descripcion(sri.getasientocontable_descripcion());	
		sriAsignar.setid_transaccion_conta(sri.getid_transaccion_conta());
		sriAsignar.settransaccionconta_descripcion(sri.gettransaccionconta_descripcion());	
		sriAsignar.setruc(sri.getruc());	
		sriAsignar.setid_cliente(sri.getid_cliente());
		sriAsignar.setcliente_descripcion(sri.getcliente_descripcion());	
		sriAsignar.setrazon_social(sri.getrazon_social());	
		sriAsignar.settipo_comprobante(sri.gettipo_comprobante());
		sriAsignar.settipocomprobante_descripcion(sri.gettipocomprobante_descripcion());	
		sriAsignar.setes_rise(sri.getes_rise());	
		sriAsignar.setnumero_serie(sri.getnumero_serie());	
		sriAsignar.setnumero_autorizacion(sri.getnumero_autorizacion());	
		sriAsignar.setnumero_secuencial(sri.getnumero_secuencial());	
		sriAsignar.setfecha_emision(sri.getfecha_emision());	
		sriAsignar.setfecha_registro_contable(sri.getfecha_registro_contable());	
		sriAsignar.setfecha_caducidad(sri.getfecha_caducidad());	
		sriAsignar.settipo_tributario(sri.gettipo_tributario());
		sriAsignar.settipotributario_descripcion(sri.gettipotributario_descripcion());	
		sriAsignar.setbienes_tar12(sri.getbienes_tar12());	
		sriAsignar.setbienes_tar0(sri.getbienes_tar0());	
		sriAsignar.setid_tipo_iva(sri.getid_tipo_iva());
		sriAsignar.settipoiva_descripcion(sri.gettipoiva_descripcion());	
		sriAsignar.setservicios_tar12(sri.getservicios_tar12());	
		sriAsignar.setservicios_tar0(sri.getservicios_tar0());	
		sriAsignar.setmonto_iva(sri.getmonto_iva());	
		sriAsignar.setbase_impo_tar12(sri.getbase_impo_tar12());	
		sriAsignar.setbase_impo_tar0(sri.getbase_impo_tar0());	
		sriAsignar.setmonto_ice(sri.getmonto_ice());	
		sriAsignar.setmonto_iva_bien(sri.getmonto_iva_bien());	
		sriAsignar.setmonto_iva_servicio(sri.getmonto_iva_servicio());	
		sriAsignar.setid_tipo_retencion_iva_bien(sri.getid_tipo_retencion_iva_bien());
		sriAsignar.settiporetencionivabien_descripcion(sri.gettiporetencionivabien_descripcion());	
		sriAsignar.setid_tipo_retencion_iva_servicio(sri.getid_tipo_retencion_iva_servicio());
		sriAsignar.settiporetencionivaservicio_descripcion(sri.gettiporetencionivaservicio_descripcion());	
		sriAsignar.setretencion_iva_bien(sri.getretencion_iva_bien());	
		sriAsignar.setretencion_iva_servicio(sri.getretencion_iva_servicio());	
		sriAsignar.setcon_devolucion(sri.getcon_devolucion());	
		sriAsignar.setid_tipo_movimiento(sri.getid_tipo_movimiento());
		sriAsignar.settipomovimiento_descripcion(sri.gettipomovimiento_descripcion());	
	}
	
	public static void inicializarSri(Sri sri) throws Exception {
		try {
				sri.setId(0L);	
					
				sri.setid_asiento_contable(-1L);	
				sri.setid_transaccion_conta(-1L);	
				sri.setruc("");	
				sri.setid_cliente(-1L);	
				sri.setrazon_social("");	
				sri.settipo_comprobante(-1L);	
				sri.setes_rise(false);	
				sri.setnumero_serie("");	
				sri.setnumero_autorizacion("");	
				sri.setnumero_secuencial("");	
				sri.setfecha_emision(new Date());	
				sri.setfecha_registro_contable(new Date());	
				sri.setfecha_caducidad(new Date());	
				sri.settipo_tributario(-1L);	
				sri.setbienes_tar12(0.0);	
				sri.setbienes_tar0(0.0);	
				sri.setid_tipo_iva(-1L);	
				sri.setservicios_tar12(0.0);	
				sri.setservicios_tar0(0.0);	
				sri.setmonto_iva(0.0);	
				sri.setbase_impo_tar12(0.0);	
				sri.setbase_impo_tar0(0.0);	
				sri.setmonto_ice(0.0);	
				sri.setmonto_iva_bien(0.0);	
				sri.setmonto_iva_servicio(0.0);	
				sri.setid_tipo_retencion_iva_bien(-1L);	
				sri.setid_tipo_retencion_iva_servicio(-1L);	
				sri.setretencion_iva_bien(0.0);	
				sri.setretencion_iva_servicio(0.0);	
				sri.setcon_devolucion(false);	
				sri.setid_tipo_movimiento(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSri(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDTRANSACCIONCONTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_RAZONSOCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDTIPOCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_ESRISE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_NUMEROSERIE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_NUMEROAUTORIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_FECHAREGISTROCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_FECHACADUCIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDTIPOTRIBUTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_BIENESTAR12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_BIENESTAR0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDTIPOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_SERVICIOSTAR12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_SERVICIOSTAR0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_MONTOIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_BASEIMPOTAR12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_BASEIMPOTAR0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_MONTOICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_MONTOIVABIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_MONTOIVASERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDTIPORETENCIONIVABIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDTIPORETENCIONIVASERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_RETENCIONIVABIEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_RETENCIONIVASERVICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_CONDEVOLUCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SriConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSri(String sTipo,Row row,Workbook workbook,Sri sri,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.gettransaccionconta_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getrazon_social());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.gettipocomprobante_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(sri.getes_rise()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getnumero_serie());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getnumero_autorizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getfecha_registro_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getfecha_caducidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.gettipotributario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getbienes_tar12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getbienes_tar0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.gettipoiva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getservicios_tar12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getservicios_tar0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getmonto_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getbase_impo_tar12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getbase_impo_tar0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getmonto_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getmonto_iva_bien());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getmonto_iva_servicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.gettiporetencionivabien_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.gettiporetencionivaservicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getretencion_iva_bien());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.getretencion_iva_servicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(sri.getcon_devolucion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sri.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySri=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySri() {
		return this.sFinalQuerySri;
	}
	
	public void setsFinalQuerySri(String sFinalQuerySri) {
		this.sFinalQuerySri= sFinalQuerySri;
	}
	
	public Border resaltarSeleccionarSri=null;
	
	public Border setResaltarSeleccionarSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarSri= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSri() {
		return this.resaltarSeleccionarSri;
	}
	
	public void setResaltarSeleccionarSri(Border borderResaltarSeleccionarSri) {
		this.resaltarSeleccionarSri= borderResaltarSeleccionarSri;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSri=null;
	public Boolean mostraridSri=true;
	public Boolean activaridSri=true;

	public Border resaltarid_asiento_contableSri=null;
	public Boolean mostrarid_asiento_contableSri=true;
	public Boolean activarid_asiento_contableSri=true;
	public Boolean cargarid_asiento_contableSri=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableSri=false;//ConEventDepend=true

	public Border resaltarid_transaccion_contaSri=null;
	public Boolean mostrarid_transaccion_contaSri=true;
	public Boolean activarid_transaccion_contaSri=true;
	public Boolean cargarid_transaccion_contaSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion_contaSri=false;//ConEventDepend=true

	public Border resaltarrucSri=null;
	public Boolean mostrarrucSri=true;
	public Boolean activarrucSri=true;

	public Border resaltarid_clienteSri=null;
	public Boolean mostrarid_clienteSri=true;
	public Boolean activarid_clienteSri=true;
	public Boolean cargarid_clienteSri=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteSri=false;//ConEventDepend=true

	public Border resaltarrazon_socialSri=null;
	public Boolean mostrarrazon_socialSri=true;
	public Boolean activarrazon_socialSri=true;

	public Border resaltartipo_comprobanteSri=null;
	public Boolean mostrartipo_comprobanteSri=true;
	public Boolean activartipo_comprobanteSri=true;
	public Boolean cargartipo_comprobanteSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependtipo_comprobanteSri=false;//ConEventDepend=true

	public Border resaltares_riseSri=null;
	public Boolean mostrares_riseSri=true;
	public Boolean activares_riseSri=true;

	public Border resaltarnumero_serieSri=null;
	public Boolean mostrarnumero_serieSri=true;
	public Boolean activarnumero_serieSri=true;

	public Border resaltarnumero_autorizacionSri=null;
	public Boolean mostrarnumero_autorizacionSri=true;
	public Boolean activarnumero_autorizacionSri=true;

	public Border resaltarnumero_secuencialSri=null;
	public Boolean mostrarnumero_secuencialSri=true;
	public Boolean activarnumero_secuencialSri=true;

	public Border resaltarfecha_emisionSri=null;
	public Boolean mostrarfecha_emisionSri=true;
	public Boolean activarfecha_emisionSri=true;

	public Border resaltarfecha_registro_contableSri=null;
	public Boolean mostrarfecha_registro_contableSri=true;
	public Boolean activarfecha_registro_contableSri=true;

	public Border resaltarfecha_caducidadSri=null;
	public Boolean mostrarfecha_caducidadSri=true;
	public Boolean activarfecha_caducidadSri=true;

	public Border resaltartipo_tributarioSri=null;
	public Boolean mostrartipo_tributarioSri=true;
	public Boolean activartipo_tributarioSri=true;
	public Boolean cargartipo_tributarioSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependtipo_tributarioSri=false;//ConEventDepend=true

	public Border resaltarbienes_tar12Sri=null;
	public Boolean mostrarbienes_tar12Sri=true;
	public Boolean activarbienes_tar12Sri=true;

	public Border resaltarbienes_tar0Sri=null;
	public Boolean mostrarbienes_tar0Sri=true;
	public Boolean activarbienes_tar0Sri=true;

	public Border resaltarid_tipo_ivaSri=null;
	public Boolean mostrarid_tipo_ivaSri=true;
	public Boolean activarid_tipo_ivaSri=true;
	public Boolean cargarid_tipo_ivaSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_ivaSri=false;//ConEventDepend=true

	public Border resaltarservicios_tar12Sri=null;
	public Boolean mostrarservicios_tar12Sri=true;
	public Boolean activarservicios_tar12Sri=true;

	public Border resaltarservicios_tar0Sri=null;
	public Boolean mostrarservicios_tar0Sri=true;
	public Boolean activarservicios_tar0Sri=true;

	public Border resaltarmonto_ivaSri=null;
	public Boolean mostrarmonto_ivaSri=true;
	public Boolean activarmonto_ivaSri=true;

	public Border resaltarbase_impo_tar12Sri=null;
	public Boolean mostrarbase_impo_tar12Sri=true;
	public Boolean activarbase_impo_tar12Sri=true;

	public Border resaltarbase_impo_tar0Sri=null;
	public Boolean mostrarbase_impo_tar0Sri=true;
	public Boolean activarbase_impo_tar0Sri=true;

	public Border resaltarmonto_iceSri=null;
	public Boolean mostrarmonto_iceSri=true;
	public Boolean activarmonto_iceSri=true;

	public Border resaltarmonto_iva_bienSri=null;
	public Boolean mostrarmonto_iva_bienSri=true;
	public Boolean activarmonto_iva_bienSri=true;

	public Border resaltarmonto_iva_servicioSri=null;
	public Boolean mostrarmonto_iva_servicioSri=true;
	public Boolean activarmonto_iva_servicioSri=true;

	public Border resaltarid_tipo_retencion_iva_bienSri=null;
	public Boolean mostrarid_tipo_retencion_iva_bienSri=true;
	public Boolean activarid_tipo_retencion_iva_bienSri=true;
	public Boolean cargarid_tipo_retencion_iva_bienSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva_bienSri=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_iva_servicioSri=null;
	public Boolean mostrarid_tipo_retencion_iva_servicioSri=true;
	public Boolean activarid_tipo_retencion_iva_servicioSri=true;
	public Boolean cargarid_tipo_retencion_iva_servicioSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_iva_servicioSri=false;//ConEventDepend=true

	public Border resaltarretencion_iva_bienSri=null;
	public Boolean mostrarretencion_iva_bienSri=true;
	public Boolean activarretencion_iva_bienSri=true;

	public Border resaltarretencion_iva_servicioSri=null;
	public Boolean mostrarretencion_iva_servicioSri=true;
	public Boolean activarretencion_iva_servicioSri=true;

	public Border resaltarcon_devolucionSri=null;
	public Boolean mostrarcon_devolucionSri=true;
	public Boolean activarcon_devolucionSri=true;

	public Border resaltarid_tipo_movimientoSri=null;
	public Boolean mostrarid_tipo_movimientoSri=true;
	public Boolean activarid_tipo_movimientoSri=false;
	public Boolean cargarid_tipo_movimientoSri=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoSri=false;//ConEventDepend=true

	
	

	public Border setResaltaridSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltaridSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSri() {
		return this.resaltaridSri;
	}

	public void setResaltaridSri(Border borderResaltar) {
		this.resaltaridSri= borderResaltar;
	}

	public Boolean getMostraridSri() {
		return this.mostraridSri;
	}

	public void setMostraridSri(Boolean mostraridSri) {
		this.mostraridSri= mostraridSri;
	}

	public Boolean getActivaridSri() {
		return this.activaridSri;
	}

	public void setActivaridSri(Boolean activaridSri) {
		this.activaridSri= activaridSri;
	}

	public Border setResaltarid_asiento_contableSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarid_asiento_contableSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableSri() {
		return this.resaltarid_asiento_contableSri;
	}

	public void setResaltarid_asiento_contableSri(Border borderResaltar) {
		this.resaltarid_asiento_contableSri= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableSri() {
		return this.mostrarid_asiento_contableSri;
	}

	public void setMostrarid_asiento_contableSri(Boolean mostrarid_asiento_contableSri) {
		this.mostrarid_asiento_contableSri= mostrarid_asiento_contableSri;
	}

	public Boolean getActivarid_asiento_contableSri() {
		return this.activarid_asiento_contableSri;
	}

	public void setActivarid_asiento_contableSri(Boolean activarid_asiento_contableSri) {
		this.activarid_asiento_contableSri= activarid_asiento_contableSri;
	}

	public Boolean getCargarid_asiento_contableSri() {
		return this.cargarid_asiento_contableSri;
	}

	public void setCargarid_asiento_contableSri(Boolean cargarid_asiento_contableSri) {
		this.cargarid_asiento_contableSri= cargarid_asiento_contableSri;
	}

	public Border setResaltarid_transaccion_contaSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarid_transaccion_contaSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion_contaSri() {
		return this.resaltarid_transaccion_contaSri;
	}

	public void setResaltarid_transaccion_contaSri(Border borderResaltar) {
		this.resaltarid_transaccion_contaSri= borderResaltar;
	}

	public Boolean getMostrarid_transaccion_contaSri() {
		return this.mostrarid_transaccion_contaSri;
	}

	public void setMostrarid_transaccion_contaSri(Boolean mostrarid_transaccion_contaSri) {
		this.mostrarid_transaccion_contaSri= mostrarid_transaccion_contaSri;
	}

	public Boolean getActivarid_transaccion_contaSri() {
		return this.activarid_transaccion_contaSri;
	}

	public void setActivarid_transaccion_contaSri(Boolean activarid_transaccion_contaSri) {
		this.activarid_transaccion_contaSri= activarid_transaccion_contaSri;
	}

	public Boolean getCargarid_transaccion_contaSri() {
		return this.cargarid_transaccion_contaSri;
	}

	public void setCargarid_transaccion_contaSri(Boolean cargarid_transaccion_contaSri) {
		this.cargarid_transaccion_contaSri= cargarid_transaccion_contaSri;
	}

	public Border setResaltarrucSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarrucSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucSri() {
		return this.resaltarrucSri;
	}

	public void setResaltarrucSri(Border borderResaltar) {
		this.resaltarrucSri= borderResaltar;
	}

	public Boolean getMostrarrucSri() {
		return this.mostrarrucSri;
	}

	public void setMostrarrucSri(Boolean mostrarrucSri) {
		this.mostrarrucSri= mostrarrucSri;
	}

	public Boolean getActivarrucSri() {
		return this.activarrucSri;
	}

	public void setActivarrucSri(Boolean activarrucSri) {
		this.activarrucSri= activarrucSri;
	}

	public Border setResaltarid_clienteSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarid_clienteSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteSri() {
		return this.resaltarid_clienteSri;
	}

	public void setResaltarid_clienteSri(Border borderResaltar) {
		this.resaltarid_clienteSri= borderResaltar;
	}

	public Boolean getMostrarid_clienteSri() {
		return this.mostrarid_clienteSri;
	}

	public void setMostrarid_clienteSri(Boolean mostrarid_clienteSri) {
		this.mostrarid_clienteSri= mostrarid_clienteSri;
	}

	public Boolean getActivarid_clienteSri() {
		return this.activarid_clienteSri;
	}

	public void setActivarid_clienteSri(Boolean activarid_clienteSri) {
		this.activarid_clienteSri= activarid_clienteSri;
	}

	public Boolean getCargarid_clienteSri() {
		return this.cargarid_clienteSri;
	}

	public void setCargarid_clienteSri(Boolean cargarid_clienteSri) {
		this.cargarid_clienteSri= cargarid_clienteSri;
	}

	public Border setResaltarrazon_socialSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarrazon_socialSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrazon_socialSri() {
		return this.resaltarrazon_socialSri;
	}

	public void setResaltarrazon_socialSri(Border borderResaltar) {
		this.resaltarrazon_socialSri= borderResaltar;
	}

	public Boolean getMostrarrazon_socialSri() {
		return this.mostrarrazon_socialSri;
	}

	public void setMostrarrazon_socialSri(Boolean mostrarrazon_socialSri) {
		this.mostrarrazon_socialSri= mostrarrazon_socialSri;
	}

	public Boolean getActivarrazon_socialSri() {
		return this.activarrazon_socialSri;
	}

	public void setActivarrazon_socialSri(Boolean activarrazon_socialSri) {
		this.activarrazon_socialSri= activarrazon_socialSri;
	}

	public Border setResaltartipo_comprobanteSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltartipo_comprobanteSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_comprobanteSri() {
		return this.resaltartipo_comprobanteSri;
	}

	public void setResaltartipo_comprobanteSri(Border borderResaltar) {
		this.resaltartipo_comprobanteSri= borderResaltar;
	}

	public Boolean getMostrartipo_comprobanteSri() {
		return this.mostrartipo_comprobanteSri;
	}

	public void setMostrartipo_comprobanteSri(Boolean mostrartipo_comprobanteSri) {
		this.mostrartipo_comprobanteSri= mostrartipo_comprobanteSri;
	}

	public Boolean getActivartipo_comprobanteSri() {
		return this.activartipo_comprobanteSri;
	}

	public void setActivartipo_comprobanteSri(Boolean activartipo_comprobanteSri) {
		this.activartipo_comprobanteSri= activartipo_comprobanteSri;
	}

	public Boolean getCargartipo_comprobanteSri() {
		return this.cargartipo_comprobanteSri;
	}

	public void setCargartipo_comprobanteSri(Boolean cargartipo_comprobanteSri) {
		this.cargartipo_comprobanteSri= cargartipo_comprobanteSri;
	}

	public Border setResaltares_riseSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltares_riseSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_riseSri() {
		return this.resaltares_riseSri;
	}

	public void setResaltares_riseSri(Border borderResaltar) {
		this.resaltares_riseSri= borderResaltar;
	}

	public Boolean getMostrares_riseSri() {
		return this.mostrares_riseSri;
	}

	public void setMostrares_riseSri(Boolean mostrares_riseSri) {
		this.mostrares_riseSri= mostrares_riseSri;
	}

	public Boolean getActivares_riseSri() {
		return this.activares_riseSri;
	}

	public void setActivares_riseSri(Boolean activares_riseSri) {
		this.activares_riseSri= activares_riseSri;
	}

	public Border setResaltarnumero_serieSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarnumero_serieSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_serieSri() {
		return this.resaltarnumero_serieSri;
	}

	public void setResaltarnumero_serieSri(Border borderResaltar) {
		this.resaltarnumero_serieSri= borderResaltar;
	}

	public Boolean getMostrarnumero_serieSri() {
		return this.mostrarnumero_serieSri;
	}

	public void setMostrarnumero_serieSri(Boolean mostrarnumero_serieSri) {
		this.mostrarnumero_serieSri= mostrarnumero_serieSri;
	}

	public Boolean getActivarnumero_serieSri() {
		return this.activarnumero_serieSri;
	}

	public void setActivarnumero_serieSri(Boolean activarnumero_serieSri) {
		this.activarnumero_serieSri= activarnumero_serieSri;
	}

	public Border setResaltarnumero_autorizacionSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarnumero_autorizacionSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_autorizacionSri() {
		return this.resaltarnumero_autorizacionSri;
	}

	public void setResaltarnumero_autorizacionSri(Border borderResaltar) {
		this.resaltarnumero_autorizacionSri= borderResaltar;
	}

	public Boolean getMostrarnumero_autorizacionSri() {
		return this.mostrarnumero_autorizacionSri;
	}

	public void setMostrarnumero_autorizacionSri(Boolean mostrarnumero_autorizacionSri) {
		this.mostrarnumero_autorizacionSri= mostrarnumero_autorizacionSri;
	}

	public Boolean getActivarnumero_autorizacionSri() {
		return this.activarnumero_autorizacionSri;
	}

	public void setActivarnumero_autorizacionSri(Boolean activarnumero_autorizacionSri) {
		this.activarnumero_autorizacionSri= activarnumero_autorizacionSri;
	}

	public Border setResaltarnumero_secuencialSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarnumero_secuencialSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialSri() {
		return this.resaltarnumero_secuencialSri;
	}

	public void setResaltarnumero_secuencialSri(Border borderResaltar) {
		this.resaltarnumero_secuencialSri= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialSri() {
		return this.mostrarnumero_secuencialSri;
	}

	public void setMostrarnumero_secuencialSri(Boolean mostrarnumero_secuencialSri) {
		this.mostrarnumero_secuencialSri= mostrarnumero_secuencialSri;
	}

	public Boolean getActivarnumero_secuencialSri() {
		return this.activarnumero_secuencialSri;
	}

	public void setActivarnumero_secuencialSri(Boolean activarnumero_secuencialSri) {
		this.activarnumero_secuencialSri= activarnumero_secuencialSri;
	}

	public Border setResaltarfecha_emisionSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarfecha_emisionSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionSri() {
		return this.resaltarfecha_emisionSri;
	}

	public void setResaltarfecha_emisionSri(Border borderResaltar) {
		this.resaltarfecha_emisionSri= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionSri() {
		return this.mostrarfecha_emisionSri;
	}

	public void setMostrarfecha_emisionSri(Boolean mostrarfecha_emisionSri) {
		this.mostrarfecha_emisionSri= mostrarfecha_emisionSri;
	}

	public Boolean getActivarfecha_emisionSri() {
		return this.activarfecha_emisionSri;
	}

	public void setActivarfecha_emisionSri(Boolean activarfecha_emisionSri) {
		this.activarfecha_emisionSri= activarfecha_emisionSri;
	}

	public Border setResaltarfecha_registro_contableSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarfecha_registro_contableSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_registro_contableSri() {
		return this.resaltarfecha_registro_contableSri;
	}

	public void setResaltarfecha_registro_contableSri(Border borderResaltar) {
		this.resaltarfecha_registro_contableSri= borderResaltar;
	}

	public Boolean getMostrarfecha_registro_contableSri() {
		return this.mostrarfecha_registro_contableSri;
	}

	public void setMostrarfecha_registro_contableSri(Boolean mostrarfecha_registro_contableSri) {
		this.mostrarfecha_registro_contableSri= mostrarfecha_registro_contableSri;
	}

	public Boolean getActivarfecha_registro_contableSri() {
		return this.activarfecha_registro_contableSri;
	}

	public void setActivarfecha_registro_contableSri(Boolean activarfecha_registro_contableSri) {
		this.activarfecha_registro_contableSri= activarfecha_registro_contableSri;
	}

	public Border setResaltarfecha_caducidadSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarfecha_caducidadSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_caducidadSri() {
		return this.resaltarfecha_caducidadSri;
	}

	public void setResaltarfecha_caducidadSri(Border borderResaltar) {
		this.resaltarfecha_caducidadSri= borderResaltar;
	}

	public Boolean getMostrarfecha_caducidadSri() {
		return this.mostrarfecha_caducidadSri;
	}

	public void setMostrarfecha_caducidadSri(Boolean mostrarfecha_caducidadSri) {
		this.mostrarfecha_caducidadSri= mostrarfecha_caducidadSri;
	}

	public Boolean getActivarfecha_caducidadSri() {
		return this.activarfecha_caducidadSri;
	}

	public void setActivarfecha_caducidadSri(Boolean activarfecha_caducidadSri) {
		this.activarfecha_caducidadSri= activarfecha_caducidadSri;
	}

	public Border setResaltartipo_tributarioSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltartipo_tributarioSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_tributarioSri() {
		return this.resaltartipo_tributarioSri;
	}

	public void setResaltartipo_tributarioSri(Border borderResaltar) {
		this.resaltartipo_tributarioSri= borderResaltar;
	}

	public Boolean getMostrartipo_tributarioSri() {
		return this.mostrartipo_tributarioSri;
	}

	public void setMostrartipo_tributarioSri(Boolean mostrartipo_tributarioSri) {
		this.mostrartipo_tributarioSri= mostrartipo_tributarioSri;
	}

	public Boolean getActivartipo_tributarioSri() {
		return this.activartipo_tributarioSri;
	}

	public void setActivartipo_tributarioSri(Boolean activartipo_tributarioSri) {
		this.activartipo_tributarioSri= activartipo_tributarioSri;
	}

	public Boolean getCargartipo_tributarioSri() {
		return this.cargartipo_tributarioSri;
	}

	public void setCargartipo_tributarioSri(Boolean cargartipo_tributarioSri) {
		this.cargartipo_tributarioSri= cargartipo_tributarioSri;
	}

	public Border setResaltarbienes_tar12Sri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarbienes_tar12Sri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_tar12Sri() {
		return this.resaltarbienes_tar12Sri;
	}

	public void setResaltarbienes_tar12Sri(Border borderResaltar) {
		this.resaltarbienes_tar12Sri= borderResaltar;
	}

	public Boolean getMostrarbienes_tar12Sri() {
		return this.mostrarbienes_tar12Sri;
	}

	public void setMostrarbienes_tar12Sri(Boolean mostrarbienes_tar12Sri) {
		this.mostrarbienes_tar12Sri= mostrarbienes_tar12Sri;
	}

	public Boolean getActivarbienes_tar12Sri() {
		return this.activarbienes_tar12Sri;
	}

	public void setActivarbienes_tar12Sri(Boolean activarbienes_tar12Sri) {
		this.activarbienes_tar12Sri= activarbienes_tar12Sri;
	}

	public Border setResaltarbienes_tar0Sri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarbienes_tar0Sri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_tar0Sri() {
		return this.resaltarbienes_tar0Sri;
	}

	public void setResaltarbienes_tar0Sri(Border borderResaltar) {
		this.resaltarbienes_tar0Sri= borderResaltar;
	}

	public Boolean getMostrarbienes_tar0Sri() {
		return this.mostrarbienes_tar0Sri;
	}

	public void setMostrarbienes_tar0Sri(Boolean mostrarbienes_tar0Sri) {
		this.mostrarbienes_tar0Sri= mostrarbienes_tar0Sri;
	}

	public Boolean getActivarbienes_tar0Sri() {
		return this.activarbienes_tar0Sri;
	}

	public void setActivarbienes_tar0Sri(Boolean activarbienes_tar0Sri) {
		this.activarbienes_tar0Sri= activarbienes_tar0Sri;
	}

	public Border setResaltarid_tipo_ivaSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_ivaSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_ivaSri() {
		return this.resaltarid_tipo_ivaSri;
	}

	public void setResaltarid_tipo_ivaSri(Border borderResaltar) {
		this.resaltarid_tipo_ivaSri= borderResaltar;
	}

	public Boolean getMostrarid_tipo_ivaSri() {
		return this.mostrarid_tipo_ivaSri;
	}

	public void setMostrarid_tipo_ivaSri(Boolean mostrarid_tipo_ivaSri) {
		this.mostrarid_tipo_ivaSri= mostrarid_tipo_ivaSri;
	}

	public Boolean getActivarid_tipo_ivaSri() {
		return this.activarid_tipo_ivaSri;
	}

	public void setActivarid_tipo_ivaSri(Boolean activarid_tipo_ivaSri) {
		this.activarid_tipo_ivaSri= activarid_tipo_ivaSri;
	}

	public Boolean getCargarid_tipo_ivaSri() {
		return this.cargarid_tipo_ivaSri;
	}

	public void setCargarid_tipo_ivaSri(Boolean cargarid_tipo_ivaSri) {
		this.cargarid_tipo_ivaSri= cargarid_tipo_ivaSri;
	}

	public Border setResaltarservicios_tar12Sri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarservicios_tar12Sri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicios_tar12Sri() {
		return this.resaltarservicios_tar12Sri;
	}

	public void setResaltarservicios_tar12Sri(Border borderResaltar) {
		this.resaltarservicios_tar12Sri= borderResaltar;
	}

	public Boolean getMostrarservicios_tar12Sri() {
		return this.mostrarservicios_tar12Sri;
	}

	public void setMostrarservicios_tar12Sri(Boolean mostrarservicios_tar12Sri) {
		this.mostrarservicios_tar12Sri= mostrarservicios_tar12Sri;
	}

	public Boolean getActivarservicios_tar12Sri() {
		return this.activarservicios_tar12Sri;
	}

	public void setActivarservicios_tar12Sri(Boolean activarservicios_tar12Sri) {
		this.activarservicios_tar12Sri= activarservicios_tar12Sri;
	}

	public Border setResaltarservicios_tar0Sri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarservicios_tar0Sri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarservicios_tar0Sri() {
		return this.resaltarservicios_tar0Sri;
	}

	public void setResaltarservicios_tar0Sri(Border borderResaltar) {
		this.resaltarservicios_tar0Sri= borderResaltar;
	}

	public Boolean getMostrarservicios_tar0Sri() {
		return this.mostrarservicios_tar0Sri;
	}

	public void setMostrarservicios_tar0Sri(Boolean mostrarservicios_tar0Sri) {
		this.mostrarservicios_tar0Sri= mostrarservicios_tar0Sri;
	}

	public Boolean getActivarservicios_tar0Sri() {
		return this.activarservicios_tar0Sri;
	}

	public void setActivarservicios_tar0Sri(Boolean activarservicios_tar0Sri) {
		this.activarservicios_tar0Sri= activarservicios_tar0Sri;
	}

	public Border setResaltarmonto_ivaSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarmonto_ivaSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_ivaSri() {
		return this.resaltarmonto_ivaSri;
	}

	public void setResaltarmonto_ivaSri(Border borderResaltar) {
		this.resaltarmonto_ivaSri= borderResaltar;
	}

	public Boolean getMostrarmonto_ivaSri() {
		return this.mostrarmonto_ivaSri;
	}

	public void setMostrarmonto_ivaSri(Boolean mostrarmonto_ivaSri) {
		this.mostrarmonto_ivaSri= mostrarmonto_ivaSri;
	}

	public Boolean getActivarmonto_ivaSri() {
		return this.activarmonto_ivaSri;
	}

	public void setActivarmonto_ivaSri(Boolean activarmonto_ivaSri) {
		this.activarmonto_ivaSri= activarmonto_ivaSri;
	}

	public Border setResaltarbase_impo_tar12Sri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarbase_impo_tar12Sri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_impo_tar12Sri() {
		return this.resaltarbase_impo_tar12Sri;
	}

	public void setResaltarbase_impo_tar12Sri(Border borderResaltar) {
		this.resaltarbase_impo_tar12Sri= borderResaltar;
	}

	public Boolean getMostrarbase_impo_tar12Sri() {
		return this.mostrarbase_impo_tar12Sri;
	}

	public void setMostrarbase_impo_tar12Sri(Boolean mostrarbase_impo_tar12Sri) {
		this.mostrarbase_impo_tar12Sri= mostrarbase_impo_tar12Sri;
	}

	public Boolean getActivarbase_impo_tar12Sri() {
		return this.activarbase_impo_tar12Sri;
	}

	public void setActivarbase_impo_tar12Sri(Boolean activarbase_impo_tar12Sri) {
		this.activarbase_impo_tar12Sri= activarbase_impo_tar12Sri;
	}

	public Border setResaltarbase_impo_tar0Sri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarbase_impo_tar0Sri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_impo_tar0Sri() {
		return this.resaltarbase_impo_tar0Sri;
	}

	public void setResaltarbase_impo_tar0Sri(Border borderResaltar) {
		this.resaltarbase_impo_tar0Sri= borderResaltar;
	}

	public Boolean getMostrarbase_impo_tar0Sri() {
		return this.mostrarbase_impo_tar0Sri;
	}

	public void setMostrarbase_impo_tar0Sri(Boolean mostrarbase_impo_tar0Sri) {
		this.mostrarbase_impo_tar0Sri= mostrarbase_impo_tar0Sri;
	}

	public Boolean getActivarbase_impo_tar0Sri() {
		return this.activarbase_impo_tar0Sri;
	}

	public void setActivarbase_impo_tar0Sri(Boolean activarbase_impo_tar0Sri) {
		this.activarbase_impo_tar0Sri= activarbase_impo_tar0Sri;
	}

	public Border setResaltarmonto_iceSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarmonto_iceSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_iceSri() {
		return this.resaltarmonto_iceSri;
	}

	public void setResaltarmonto_iceSri(Border borderResaltar) {
		this.resaltarmonto_iceSri= borderResaltar;
	}

	public Boolean getMostrarmonto_iceSri() {
		return this.mostrarmonto_iceSri;
	}

	public void setMostrarmonto_iceSri(Boolean mostrarmonto_iceSri) {
		this.mostrarmonto_iceSri= mostrarmonto_iceSri;
	}

	public Boolean getActivarmonto_iceSri() {
		return this.activarmonto_iceSri;
	}

	public void setActivarmonto_iceSri(Boolean activarmonto_iceSri) {
		this.activarmonto_iceSri= activarmonto_iceSri;
	}

	public Border setResaltarmonto_iva_bienSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarmonto_iva_bienSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_iva_bienSri() {
		return this.resaltarmonto_iva_bienSri;
	}

	public void setResaltarmonto_iva_bienSri(Border borderResaltar) {
		this.resaltarmonto_iva_bienSri= borderResaltar;
	}

	public Boolean getMostrarmonto_iva_bienSri() {
		return this.mostrarmonto_iva_bienSri;
	}

	public void setMostrarmonto_iva_bienSri(Boolean mostrarmonto_iva_bienSri) {
		this.mostrarmonto_iva_bienSri= mostrarmonto_iva_bienSri;
	}

	public Boolean getActivarmonto_iva_bienSri() {
		return this.activarmonto_iva_bienSri;
	}

	public void setActivarmonto_iva_bienSri(Boolean activarmonto_iva_bienSri) {
		this.activarmonto_iva_bienSri= activarmonto_iva_bienSri;
	}

	public Border setResaltarmonto_iva_servicioSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarmonto_iva_servicioSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_iva_servicioSri() {
		return this.resaltarmonto_iva_servicioSri;
	}

	public void setResaltarmonto_iva_servicioSri(Border borderResaltar) {
		this.resaltarmonto_iva_servicioSri= borderResaltar;
	}

	public Boolean getMostrarmonto_iva_servicioSri() {
		return this.mostrarmonto_iva_servicioSri;
	}

	public void setMostrarmonto_iva_servicioSri(Boolean mostrarmonto_iva_servicioSri) {
		this.mostrarmonto_iva_servicioSri= mostrarmonto_iva_servicioSri;
	}

	public Boolean getActivarmonto_iva_servicioSri() {
		return this.activarmonto_iva_servicioSri;
	}

	public void setActivarmonto_iva_servicioSri(Boolean activarmonto_iva_servicioSri) {
		this.activarmonto_iva_servicioSri= activarmonto_iva_servicioSri;
	}

	public Border setResaltarid_tipo_retencion_iva_bienSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_retencion_iva_bienSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva_bienSri() {
		return this.resaltarid_tipo_retencion_iva_bienSri;
	}

	public void setResaltarid_tipo_retencion_iva_bienSri(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva_bienSri= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva_bienSri() {
		return this.mostrarid_tipo_retencion_iva_bienSri;
	}

	public void setMostrarid_tipo_retencion_iva_bienSri(Boolean mostrarid_tipo_retencion_iva_bienSri) {
		this.mostrarid_tipo_retencion_iva_bienSri= mostrarid_tipo_retencion_iva_bienSri;
	}

	public Boolean getActivarid_tipo_retencion_iva_bienSri() {
		return this.activarid_tipo_retencion_iva_bienSri;
	}

	public void setActivarid_tipo_retencion_iva_bienSri(Boolean activarid_tipo_retencion_iva_bienSri) {
		this.activarid_tipo_retencion_iva_bienSri= activarid_tipo_retencion_iva_bienSri;
	}

	public Boolean getCargarid_tipo_retencion_iva_bienSri() {
		return this.cargarid_tipo_retencion_iva_bienSri;
	}

	public void setCargarid_tipo_retencion_iva_bienSri(Boolean cargarid_tipo_retencion_iva_bienSri) {
		this.cargarid_tipo_retencion_iva_bienSri= cargarid_tipo_retencion_iva_bienSri;
	}

	public Border setResaltarid_tipo_retencion_iva_servicioSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_retencion_iva_servicioSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_iva_servicioSri() {
		return this.resaltarid_tipo_retencion_iva_servicioSri;
	}

	public void setResaltarid_tipo_retencion_iva_servicioSri(Border borderResaltar) {
		this.resaltarid_tipo_retencion_iva_servicioSri= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_iva_servicioSri() {
		return this.mostrarid_tipo_retencion_iva_servicioSri;
	}

	public void setMostrarid_tipo_retencion_iva_servicioSri(Boolean mostrarid_tipo_retencion_iva_servicioSri) {
		this.mostrarid_tipo_retencion_iva_servicioSri= mostrarid_tipo_retencion_iva_servicioSri;
	}

	public Boolean getActivarid_tipo_retencion_iva_servicioSri() {
		return this.activarid_tipo_retencion_iva_servicioSri;
	}

	public void setActivarid_tipo_retencion_iva_servicioSri(Boolean activarid_tipo_retencion_iva_servicioSri) {
		this.activarid_tipo_retencion_iva_servicioSri= activarid_tipo_retencion_iva_servicioSri;
	}

	public Boolean getCargarid_tipo_retencion_iva_servicioSri() {
		return this.cargarid_tipo_retencion_iva_servicioSri;
	}

	public void setCargarid_tipo_retencion_iva_servicioSri(Boolean cargarid_tipo_retencion_iva_servicioSri) {
		this.cargarid_tipo_retencion_iva_servicioSri= cargarid_tipo_retencion_iva_servicioSri;
	}

	public Border setResaltarretencion_iva_bienSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarretencion_iva_bienSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencion_iva_bienSri() {
		return this.resaltarretencion_iva_bienSri;
	}

	public void setResaltarretencion_iva_bienSri(Border borderResaltar) {
		this.resaltarretencion_iva_bienSri= borderResaltar;
	}

	public Boolean getMostrarretencion_iva_bienSri() {
		return this.mostrarretencion_iva_bienSri;
	}

	public void setMostrarretencion_iva_bienSri(Boolean mostrarretencion_iva_bienSri) {
		this.mostrarretencion_iva_bienSri= mostrarretencion_iva_bienSri;
	}

	public Boolean getActivarretencion_iva_bienSri() {
		return this.activarretencion_iva_bienSri;
	}

	public void setActivarretencion_iva_bienSri(Boolean activarretencion_iva_bienSri) {
		this.activarretencion_iva_bienSri= activarretencion_iva_bienSri;
	}

	public Border setResaltarretencion_iva_servicioSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarretencion_iva_servicioSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencion_iva_servicioSri() {
		return this.resaltarretencion_iva_servicioSri;
	}

	public void setResaltarretencion_iva_servicioSri(Border borderResaltar) {
		this.resaltarretencion_iva_servicioSri= borderResaltar;
	}

	public Boolean getMostrarretencion_iva_servicioSri() {
		return this.mostrarretencion_iva_servicioSri;
	}

	public void setMostrarretencion_iva_servicioSri(Boolean mostrarretencion_iva_servicioSri) {
		this.mostrarretencion_iva_servicioSri= mostrarretencion_iva_servicioSri;
	}

	public Boolean getActivarretencion_iva_servicioSri() {
		return this.activarretencion_iva_servicioSri;
	}

	public void setActivarretencion_iva_servicioSri(Boolean activarretencion_iva_servicioSri) {
		this.activarretencion_iva_servicioSri= activarretencion_iva_servicioSri;
	}

	public Border setResaltarcon_devolucionSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarcon_devolucionSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_devolucionSri() {
		return this.resaltarcon_devolucionSri;
	}

	public void setResaltarcon_devolucionSri(Border borderResaltar) {
		this.resaltarcon_devolucionSri= borderResaltar;
	}

	public Boolean getMostrarcon_devolucionSri() {
		return this.mostrarcon_devolucionSri;
	}

	public void setMostrarcon_devolucionSri(Boolean mostrarcon_devolucionSri) {
		this.mostrarcon_devolucionSri= mostrarcon_devolucionSri;
	}

	public Boolean getActivarcon_devolucionSri() {
		return this.activarcon_devolucionSri;
	}

	public void setActivarcon_devolucionSri(Boolean activarcon_devolucionSri) {
		this.activarcon_devolucionSri= activarcon_devolucionSri;
	}

	public Border setResaltarid_tipo_movimientoSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//sriBeanSwingJInternalFrame.jTtoolBarSri.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_movimientoSri= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoSri() {
		return this.resaltarid_tipo_movimientoSri;
	}

	public void setResaltarid_tipo_movimientoSri(Border borderResaltar) {
		this.resaltarid_tipo_movimientoSri= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoSri() {
		return this.mostrarid_tipo_movimientoSri;
	}

	public void setMostrarid_tipo_movimientoSri(Boolean mostrarid_tipo_movimientoSri) {
		this.mostrarid_tipo_movimientoSri= mostrarid_tipo_movimientoSri;
	}

	public Boolean getActivarid_tipo_movimientoSri() {
		return this.activarid_tipo_movimientoSri;
	}

	public void setActivarid_tipo_movimientoSri(Boolean activarid_tipo_movimientoSri) {
		this.activarid_tipo_movimientoSri= activarid_tipo_movimientoSri;
	}

	public Boolean getCargarid_tipo_movimientoSri() {
		return this.cargarid_tipo_movimientoSri;
	}

	public void setCargarid_tipo_movimientoSri(Boolean cargarid_tipo_movimientoSri) {
		this.cargarid_tipo_movimientoSri= cargarid_tipo_movimientoSri;
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
		
		
		this.setMostraridSri(esInicial);
		this.setMostrarid_asiento_contableSri(esInicial);
		this.setMostrarid_transaccion_contaSri(esInicial);
		this.setMostrarrucSri(esInicial);
		this.setMostrarid_clienteSri(esInicial);
		this.setMostrarrazon_socialSri(esInicial);
		this.setMostrartipo_comprobanteSri(esInicial);
		this.setMostrares_riseSri(esInicial);
		this.setMostrarnumero_serieSri(esInicial);
		this.setMostrarnumero_autorizacionSri(esInicial);
		this.setMostrarnumero_secuencialSri(esInicial);
		this.setMostrarfecha_emisionSri(esInicial);
		this.setMostrarfecha_registro_contableSri(esInicial);
		this.setMostrarfecha_caducidadSri(esInicial);
		this.setMostrartipo_tributarioSri(esInicial);
		this.setMostrarbienes_tar12Sri(esInicial);
		this.setMostrarbienes_tar0Sri(esInicial);
		this.setMostrarid_tipo_ivaSri(esInicial);
		this.setMostrarservicios_tar12Sri(esInicial);
		this.setMostrarservicios_tar0Sri(esInicial);
		this.setMostrarmonto_ivaSri(esInicial);
		this.setMostrarbase_impo_tar12Sri(esInicial);
		this.setMostrarbase_impo_tar0Sri(esInicial);
		this.setMostrarmonto_iceSri(esInicial);
		this.setMostrarmonto_iva_bienSri(esInicial);
		this.setMostrarmonto_iva_servicioSri(esInicial);
		this.setMostrarid_tipo_retencion_iva_bienSri(esInicial);
		this.setMostrarid_tipo_retencion_iva_servicioSri(esInicial);
		this.setMostrarretencion_iva_bienSri(esInicial);
		this.setMostrarretencion_iva_servicioSri(esInicial);
		this.setMostrarcon_devolucionSri(esInicial);
		this.setMostrarid_tipo_movimientoSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriConstantesFunciones.ID)) {
				this.setMostraridSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setMostrarid_transaccion_contaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RUC)) {
				this.setMostrarrucSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RAZONSOCIAL)) {
				this.setMostrarrazon_socialSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setMostrartipo_comprobanteSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.ESRISE)) {
				this.setMostrares_riseSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROSERIE)) {
				this.setMostrarnumero_serieSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setMostrarnumero_autorizacionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setMostrarfecha_registro_contableSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHACADUCIDAD)) {
				this.setMostrarfecha_caducidadSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setMostrartipo_tributarioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BIENESTAR12)) {
				this.setMostrarbienes_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BIENESTAR0)) {
				this.setMostrarbienes_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOIVA)) {
				this.setMostrarid_tipo_ivaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.SERVICIOSTAR12)) {
				this.setMostrarservicios_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.SERVICIOSTAR0)) {
				this.setMostrarservicios_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVA)) {
				this.setMostrarmonto_ivaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BASEIMPOTAR12)) {
				this.setMostrarbase_impo_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BASEIMPOTAR0)) {
				this.setMostrarbase_impo_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOICE)) {
				this.setMostrarmonto_iceSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVABIEN)) {
				this.setMostrarmonto_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVASERVICIO)) {
				this.setMostrarmonto_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPORETENCIONIVABIEN)) {
				this.setMostrarid_tipo_retencion_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO)) {
				this.setMostrarid_tipo_retencion_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RETENCIONIVABIEN)) {
				this.setMostrarretencion_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RETENCIONIVASERVICIO)) {
				this.setMostrarretencion_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.CONDEVOLUCION)) {
				this.setMostrarcon_devolucionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoSri(esAsigna);
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
		
		
		this.setActivaridSri(esInicial);
		this.setActivarid_asiento_contableSri(esInicial);
		this.setActivarid_transaccion_contaSri(esInicial);
		this.setActivarrucSri(esInicial);
		this.setActivarid_clienteSri(esInicial);
		this.setActivarrazon_socialSri(esInicial);
		this.setActivartipo_comprobanteSri(esInicial);
		this.setActivares_riseSri(esInicial);
		this.setActivarnumero_serieSri(esInicial);
		this.setActivarnumero_autorizacionSri(esInicial);
		this.setActivarnumero_secuencialSri(esInicial);
		this.setActivarfecha_emisionSri(esInicial);
		this.setActivarfecha_registro_contableSri(esInicial);
		this.setActivarfecha_caducidadSri(esInicial);
		this.setActivartipo_tributarioSri(esInicial);
		this.setActivarbienes_tar12Sri(esInicial);
		this.setActivarbienes_tar0Sri(esInicial);
		this.setActivarid_tipo_ivaSri(esInicial);
		this.setActivarservicios_tar12Sri(esInicial);
		this.setActivarservicios_tar0Sri(esInicial);
		this.setActivarmonto_ivaSri(esInicial);
		this.setActivarbase_impo_tar12Sri(esInicial);
		this.setActivarbase_impo_tar0Sri(esInicial);
		this.setActivarmonto_iceSri(esInicial);
		this.setActivarmonto_iva_bienSri(esInicial);
		this.setActivarmonto_iva_servicioSri(esInicial);
		this.setActivarid_tipo_retencion_iva_bienSri(esInicial);
		this.setActivarid_tipo_retencion_iva_servicioSri(esInicial);
		this.setActivarretencion_iva_bienSri(esInicial);
		this.setActivarretencion_iva_servicioSri(esInicial);
		this.setActivarcon_devolucionSri(esInicial);
		this.setActivarid_tipo_movimientoSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriConstantesFunciones.ID)) {
				this.setActivaridSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setActivarid_transaccion_contaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RUC)) {
				this.setActivarrucSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RAZONSOCIAL)) {
				this.setActivarrazon_socialSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setActivartipo_comprobanteSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.ESRISE)) {
				this.setActivares_riseSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROSERIE)) {
				this.setActivarnumero_serieSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setActivarnumero_autorizacionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setActivarfecha_registro_contableSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHACADUCIDAD)) {
				this.setActivarfecha_caducidadSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setActivartipo_tributarioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BIENESTAR12)) {
				this.setActivarbienes_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BIENESTAR0)) {
				this.setActivarbienes_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOIVA)) {
				this.setActivarid_tipo_ivaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.SERVICIOSTAR12)) {
				this.setActivarservicios_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.SERVICIOSTAR0)) {
				this.setActivarservicios_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVA)) {
				this.setActivarmonto_ivaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BASEIMPOTAR12)) {
				this.setActivarbase_impo_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BASEIMPOTAR0)) {
				this.setActivarbase_impo_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOICE)) {
				this.setActivarmonto_iceSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVABIEN)) {
				this.setActivarmonto_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVASERVICIO)) {
				this.setActivarmonto_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPORETENCIONIVABIEN)) {
				this.setActivarid_tipo_retencion_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO)) {
				this.setActivarid_tipo_retencion_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RETENCIONIVABIEN)) {
				this.setActivarretencion_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RETENCIONIVASERVICIO)) {
				this.setActivarretencion_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.CONDEVOLUCION)) {
				this.setActivarcon_devolucionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoSri(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSri(esInicial);
		this.setResaltarid_asiento_contableSri(esInicial);
		this.setResaltarid_transaccion_contaSri(esInicial);
		this.setResaltarrucSri(esInicial);
		this.setResaltarid_clienteSri(esInicial);
		this.setResaltarrazon_socialSri(esInicial);
		this.setResaltartipo_comprobanteSri(esInicial);
		this.setResaltares_riseSri(esInicial);
		this.setResaltarnumero_serieSri(esInicial);
		this.setResaltarnumero_autorizacionSri(esInicial);
		this.setResaltarnumero_secuencialSri(esInicial);
		this.setResaltarfecha_emisionSri(esInicial);
		this.setResaltarfecha_registro_contableSri(esInicial);
		this.setResaltarfecha_caducidadSri(esInicial);
		this.setResaltartipo_tributarioSri(esInicial);
		this.setResaltarbienes_tar12Sri(esInicial);
		this.setResaltarbienes_tar0Sri(esInicial);
		this.setResaltarid_tipo_ivaSri(esInicial);
		this.setResaltarservicios_tar12Sri(esInicial);
		this.setResaltarservicios_tar0Sri(esInicial);
		this.setResaltarmonto_ivaSri(esInicial);
		this.setResaltarbase_impo_tar12Sri(esInicial);
		this.setResaltarbase_impo_tar0Sri(esInicial);
		this.setResaltarmonto_iceSri(esInicial);
		this.setResaltarmonto_iva_bienSri(esInicial);
		this.setResaltarmonto_iva_servicioSri(esInicial);
		this.setResaltarid_tipo_retencion_iva_bienSri(esInicial);
		this.setResaltarid_tipo_retencion_iva_servicioSri(esInicial);
		this.setResaltarretencion_iva_bienSri(esInicial);
		this.setResaltarretencion_iva_servicioSri(esInicial);
		this.setResaltarcon_devolucionSri(esInicial);
		this.setResaltarid_tipo_movimientoSri(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SriConstantesFunciones.ID)) {
				this.setResaltaridSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTRANSACCIONCONTA)) {
				this.setResaltarid_transaccion_contaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RUC)) {
				this.setResaltarrucSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RAZONSOCIAL)) {
				this.setResaltarrazon_socialSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOCOMPROBANTE)) {
				this.setResaltartipo_comprobanteSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.ESRISE)) {
				this.setResaltares_riseSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROSERIE)) {
				this.setResaltarnumero_serieSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROAUTORIZACION)) {
				this.setResaltarnumero_autorizacionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHAREGISTROCONTABLE)) {
				this.setResaltarfecha_registro_contableSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.FECHACADUCIDAD)) {
				this.setResaltarfecha_caducidadSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOTRIBUTARIO)) {
				this.setResaltartipo_tributarioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BIENESTAR12)) {
				this.setResaltarbienes_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BIENESTAR0)) {
				this.setResaltarbienes_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOIVA)) {
				this.setResaltarid_tipo_ivaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.SERVICIOSTAR12)) {
				this.setResaltarservicios_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.SERVICIOSTAR0)) {
				this.setResaltarservicios_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVA)) {
				this.setResaltarmonto_ivaSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BASEIMPOTAR12)) {
				this.setResaltarbase_impo_tar12Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.BASEIMPOTAR0)) {
				this.setResaltarbase_impo_tar0Sri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOICE)) {
				this.setResaltarmonto_iceSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVABIEN)) {
				this.setResaltarmonto_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.MONTOIVASERVICIO)) {
				this.setResaltarmonto_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPORETENCIONIVABIEN)) {
				this.setResaltarid_tipo_retencion_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO)) {
				this.setResaltarid_tipo_retencion_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RETENCIONIVABIEN)) {
				this.setResaltarretencion_iva_bienSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.RETENCIONIVASERVICIO)) {
				this.setResaltarretencion_iva_servicioSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.CONDEVOLUCION)) {
				this.setResaltarcon_devolucionSri(esAsigna);
				continue;
			}

			if(campo.clase.equals(SriConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoSri(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableSri=true;

	public Boolean getMostrarFK_IdAsientoContableSri() {
		return this.mostrarFK_IdAsientoContableSri;
	}

	public void setMostrarFK_IdAsientoContableSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteSri=true;

	public Boolean getMostrarFK_IdClienteSri() {
		return this.mostrarFK_IdClienteSri;
	}

	public void setMostrarFK_IdClienteSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoComprobanteSri=true;

	public Boolean getMostrarFK_IdTipoComprobanteSri() {
		return this.mostrarFK_IdTipoComprobanteSri;
	}

	public void setMostrarFK_IdTipoComprobanteSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoComprobanteSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoIvaSri=true;

	public Boolean getMostrarFK_IdTipoIvaSri() {
		return this.mostrarFK_IdTipoIvaSri;
	}

	public void setMostrarFK_IdTipoIvaSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoIvaSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoSri=true;

	public Boolean getMostrarFK_IdTipoMovimientoSri() {
		return this.mostrarFK_IdTipoMovimientoSri;
	}

	public void setMostrarFK_IdTipoMovimientoSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIvaBienSri=true;

	public Boolean getMostrarFK_IdTipoRetencionIvaBienSri() {
		return this.mostrarFK_IdTipoRetencionIvaBienSri;
	}

	public void setMostrarFK_IdTipoRetencionIvaBienSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIvaBienSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIvaServicioSri=true;

	public Boolean getMostrarFK_IdTipoRetencionIvaServicioSri() {
		return this.mostrarFK_IdTipoRetencionIvaServicioSri;
	}

	public void setMostrarFK_IdTipoRetencionIvaServicioSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIvaServicioSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTributarioSri=true;

	public Boolean getMostrarFK_IdTipoTributarioSri() {
		return this.mostrarFK_IdTipoTributarioSri;
	}

	public void setMostrarFK_IdTipoTributarioSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTributarioSri= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionContaSri=true;

	public Boolean getMostrarFK_IdTransaccionContaSri() {
		return this.mostrarFK_IdTransaccionContaSri;
	}

	public void setMostrarFK_IdTransaccionContaSri(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionContaSri= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableSri=true;

	public Boolean getActivarFK_IdAsientoContableSri() {
		return this.activarFK_IdAsientoContableSri;
	}

	public void setActivarFK_IdAsientoContableSri(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableSri= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteSri=true;

	public Boolean getActivarFK_IdClienteSri() {
		return this.activarFK_IdClienteSri;
	}

	public void setActivarFK_IdClienteSri(Boolean habilitarResaltar) {
		this.activarFK_IdClienteSri= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoComprobanteSri=true;

	public Boolean getActivarFK_IdTipoComprobanteSri() {
		return this.activarFK_IdTipoComprobanteSri;
	}

	public void setActivarFK_IdTipoComprobanteSri(Boolean habilitarResaltar) {
		this.activarFK_IdTipoComprobanteSri= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoIvaSri=true;

	public Boolean getActivarFK_IdTipoIvaSri() {
		return this.activarFK_IdTipoIvaSri;
	}

	public void setActivarFK_IdTipoIvaSri(Boolean habilitarResaltar) {
		this.activarFK_IdTipoIvaSri= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoSri=true;

	public Boolean getActivarFK_IdTipoMovimientoSri() {
		return this.activarFK_IdTipoMovimientoSri;
	}

	public void setActivarFK_IdTipoMovimientoSri(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoSri= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIvaBienSri=true;

	public Boolean getActivarFK_IdTipoRetencionIvaBienSri() {
		return this.activarFK_IdTipoRetencionIvaBienSri;
	}

	public void setActivarFK_IdTipoRetencionIvaBienSri(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIvaBienSri= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIvaServicioSri=true;

	public Boolean getActivarFK_IdTipoRetencionIvaServicioSri() {
		return this.activarFK_IdTipoRetencionIvaServicioSri;
	}

	public void setActivarFK_IdTipoRetencionIvaServicioSri(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIvaServicioSri= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTributarioSri=true;

	public Boolean getActivarFK_IdTipoTributarioSri() {
		return this.activarFK_IdTipoTributarioSri;
	}

	public void setActivarFK_IdTipoTributarioSri(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTributarioSri= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionContaSri=true;

	public Boolean getActivarFK_IdTransaccionContaSri() {
		return this.activarFK_IdTransaccionContaSri;
	}

	public void setActivarFK_IdTransaccionContaSri(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionContaSri= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableSri=null;

	public Border getResaltarFK_IdAsientoContableSri() {
		return this.resaltarFK_IdAsientoContableSri;
	}

	public void setResaltarFK_IdAsientoContableSri(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableSri= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableSri= borderResaltar;
	}

	public Border resaltarFK_IdClienteSri=null;

	public Border getResaltarFK_IdClienteSri() {
		return this.resaltarFK_IdClienteSri;
	}

	public void setResaltarFK_IdClienteSri(Border borderResaltar) {
		this.resaltarFK_IdClienteSri= borderResaltar;
	}

	public void setResaltarFK_IdClienteSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteSri= borderResaltar;
	}

	public Border resaltarFK_IdTipoComprobanteSri=null;

	public Border getResaltarFK_IdTipoComprobanteSri() {
		return this.resaltarFK_IdTipoComprobanteSri;
	}

	public void setResaltarFK_IdTipoComprobanteSri(Border borderResaltar) {
		this.resaltarFK_IdTipoComprobanteSri= borderResaltar;
	}

	public void setResaltarFK_IdTipoComprobanteSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoComprobanteSri= borderResaltar;
	}

	public Border resaltarFK_IdTipoIvaSri=null;

	public Border getResaltarFK_IdTipoIvaSri() {
		return this.resaltarFK_IdTipoIvaSri;
	}

	public void setResaltarFK_IdTipoIvaSri(Border borderResaltar) {
		this.resaltarFK_IdTipoIvaSri= borderResaltar;
	}

	public void setResaltarFK_IdTipoIvaSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoIvaSri= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoSri=null;

	public Border getResaltarFK_IdTipoMovimientoSri() {
		return this.resaltarFK_IdTipoMovimientoSri;
	}

	public void setResaltarFK_IdTipoMovimientoSri(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoSri= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoSri= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIvaBienSri=null;

	public Border getResaltarFK_IdTipoRetencionIvaBienSri() {
		return this.resaltarFK_IdTipoRetencionIvaBienSri;
	}

	public void setResaltarFK_IdTipoRetencionIvaBienSri(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIvaBienSri= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIvaBienSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIvaBienSri= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIvaServicioSri=null;

	public Border getResaltarFK_IdTipoRetencionIvaServicioSri() {
		return this.resaltarFK_IdTipoRetencionIvaServicioSri;
	}

	public void setResaltarFK_IdTipoRetencionIvaServicioSri(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIvaServicioSri= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIvaServicioSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIvaServicioSri= borderResaltar;
	}

	public Border resaltarFK_IdTipoTributarioSri=null;

	public Border getResaltarFK_IdTipoTributarioSri() {
		return this.resaltarFK_IdTipoTributarioSri;
	}

	public void setResaltarFK_IdTipoTributarioSri(Border borderResaltar) {
		this.resaltarFK_IdTipoTributarioSri= borderResaltar;
	}

	public void setResaltarFK_IdTipoTributarioSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTributarioSri= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionContaSri=null;

	public Border getResaltarFK_IdTransaccionContaSri() {
		return this.resaltarFK_IdTransaccionContaSri;
	}

	public void setResaltarFK_IdTransaccionContaSri(Border borderResaltar) {
		this.resaltarFK_IdTransaccionContaSri= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionContaSri(ParametroGeneralUsuario parametroGeneralUsuario/*SriBeanSwingJInternalFrame sriBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionContaSri= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}