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


import com.bydan.erp.facturacion.util.DetaFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.DetaFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetaFormaPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
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
final public class DetaFormaPagoConstantesFunciones extends DetaFormaPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetaFormaPago";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetaFormaPago"+DetaFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetaFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetaFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetaFormaPagoConstantesFunciones.SCHEMA+"_"+DetaFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetaFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetaFormaPagoConstantesFunciones.SCHEMA+"_"+DetaFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetaFormaPagoConstantesFunciones.SCHEMA+"_"+DetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetaFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetaFormaPagoConstantesFunciones.SCHEMA+"_"+DetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetaFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetaFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetaFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetaFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetaFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetaFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetaFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Deta Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Deta Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Deta Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetaFormaPago";
	public static final String OBJECTNAME="detaformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="deta_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detaformapago from "+DetaFormaPagoConstantesFunciones.SPERSISTENCENAME+" detaformapago";
	public static String QUERYSELECTNATIVE="select "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".version_row,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_periodo,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_factura,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_tipo_deta_forma_pago,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_deta_forma_pago_factu,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_tipo_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".valor,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".fecha_inicial,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".fecha_final,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".porcentaje,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".porcentaje_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".base_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".valor_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".numero_retencion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".numero_dias,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".numero_cuota,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".descripcion,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_anio,"+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME+".id_mes from "+DetaFormaPagoConstantesFunciones.SCHEMA+"."+DetaFormaPagoConstantesFunciones.TABLENAME;//+" as "+DetaFormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetaFormaPagoConstantesFuncionesAdditional detaformapagoConstantesFuncionesAdditional=null;
	
	public DetaFormaPagoConstantesFuncionesAdditional getDetaFormaPagoConstantesFuncionesAdditional() {
		return this.detaformapagoConstantesFuncionesAdditional;
	}
	
	public void setDetaFormaPagoConstantesFuncionesAdditional(DetaFormaPagoConstantesFuncionesAdditional detaformapagoConstantesFuncionesAdditional) {
		try {
			this.detaformapagoConstantesFuncionesAdditional=detaformapagoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDFACTURA= "id_factura";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String IDTIPODETAFORMAPAGO= "id_tipo_deta_forma_pago";
    public static final String IDDETAFORMAPAGOFACTU= "id_deta_forma_pago_factu";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String VALOR= "valor";
    public static final String FECHAINICIAL= "fecha_inicial";
    public static final String FECHAFINAL= "fecha_final";
    public static final String PORCENTAJE= "porcentaje";
    public static final String RETENCION= "retencion";
    public static final String PORCENTAJERETENCION= "porcentaje_retencion";
    public static final String BASERETENCION= "base_retencion";
    public static final String VALORRETENCION= "valor_retencion";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String NUMERODIAS= "numero_dias";
    public static final String NUMEROCUOTA= "numero_cuota";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_IDTIPODETAFORMAPAGO= "Tipo Deta Forma Pago";
		public static final String LABEL_IDTIPODETAFORMAPAGO_LOWER= "Tipo Deta Forma Pago";
    	public static final String LABEL_IDDETAFORMAPAGOFACTU= "Deta Forma Pago Factu";
		public static final String LABEL_IDDETAFORMAPAGOFACTU_LOWER= "Deta Forma Pago Factu";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_FECHAINICIAL= "Fecha Inicial";
		public static final String LABEL_FECHAINICIAL_LOWER= "Fecha Inicial";
    	public static final String LABEL_FECHAFINAL= "Fecha Final";
		public static final String LABEL_FECHAFINAL_LOWER= "Fecha Final";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_PORCENTAJERETENCION= "Porcentaje Retencion";
		public static final String LABEL_PORCENTAJERETENCION_LOWER= "Porcentaje Retencion";
    	public static final String LABEL_BASERETENCION= "Base";
		public static final String LABEL_BASERETENCION_LOWER= "Base Retencion";
    	public static final String LABEL_VALORRETENCION= "Valor Retencion";
		public static final String LABEL_VALORRETENCION_LOWER= "Valor Retencion";
    	public static final String LABEL_NUMERORETENCION= "Numero Retencion";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_NUMERODIAS= "Numero Dias";
		public static final String LABEL_NUMERODIAS_LOWER= "Numero Dias";
    	public static final String LABEL_NUMEROCUOTA= "Numero Cuota";
		public static final String LABEL_NUMEROCUOTA_LOWER= "Numero Cuota";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getDetaFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDPERIODO)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDFACTURA)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDTIPODETAFORMAPAGO;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGOFACTU;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.VALOR)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.FECHAINICIAL)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_FECHAINICIAL;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.FECHAFINAL)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_FECHAFINAL;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.PORCENTAJE)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.RETENCION)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.BASERETENCION)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_BASERETENCION;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.VALORRETENCION)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_VALORRETENCION;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.NUMERORETENCION)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.NUMERODIAS)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_NUMERODIAS;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.NUMEROCUOTA)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_NUMEROCUOTA;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDANIO)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetaFormaPagoConstantesFunciones.IDMES)) {sLabelColumna=DetaFormaPagoConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetaFormaPagoDescripcion(DetaFormaPago detaformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detaformapago !=null/* && detaformapago.getId()!=0*/) {
			if(detaformapago.getId()!=null) {
				sDescripcion=detaformapago.getId().toString();
			}//detaformapagodetaformapago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetaFormaPagoDescripcionDetallado(DetaFormaPago detaformapago) {
		String sDescripcion="";
			
		sDescripcion+=DetaFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=detaformapago.getId().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detaformapago.getVersionRow().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detaformapago.getid_empresa().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detaformapago.getid_sucursal().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detaformapago.getid_ejercicio().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detaformapago.getid_periodo().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=detaformapago.getid_factura().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=detaformapago.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO+"=";
		sDescripcion+=detaformapago.getid_tipo_deta_forma_pago().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU+"=";
		sDescripcion+=detaformapago.getid_deta_forma_pago_factu().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=detaformapago.getid_cuenta_contable().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=detaformapago.getid_tipo_retencion().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.VALOR+"=";
		sDescripcion+=detaformapago.getvalor().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.FECHAINICIAL+"=";
		sDescripcion+=detaformapago.getfecha_inicial().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.FECHAFINAL+"=";
		sDescripcion+=detaformapago.getfecha_final().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=detaformapago.getporcentaje().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.RETENCION+"=";
		sDescripcion+=detaformapago.getretencion().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION+"=";
		sDescripcion+=detaformapago.getporcentaje_retencion().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.BASERETENCION+"=";
		sDescripcion+=detaformapago.getbase_retencion().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.VALORRETENCION+"=";
		sDescripcion+=detaformapago.getvalor_retencion().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=detaformapago.getnumero_retencion()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.NUMERODIAS+"=";
		sDescripcion+=detaformapago.getnumero_dias().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.NUMEROCUOTA+"=";
		sDescripcion+=detaformapago.getnumero_cuota().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detaformapago.getdescripcion()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDANIO+"=";
		sDescripcion+=detaformapago.getid_anio().toString()+",";
		sDescripcion+=DetaFormaPagoConstantesFunciones.IDMES+"=";
		sDescripcion+=detaformapago.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetaFormaPagoDescripcion(DetaFormaPago detaformapago,String sValor) throws Exception {			
		if(detaformapago !=null) {
			//detaformapagodetaformapago.getId().toString();
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

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
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

	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformapago!=null/*&&tipoformapago.getId()>0*/) {
			sDescripcion=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(tipoformapago);
		}

		return sDescripcion;
	}

	public static String getTipoDetaFormaPagoDescripcion(TipoDetaFormaPago tipodetaformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodetaformapago!=null/*&&tipodetaformapago.getId()>0*/) {
			sDescripcion=TipoDetaFormaPagoConstantesFunciones.getTipoDetaFormaPagoDescripcion(tipodetaformapago);
		}

		return sDescripcion;
	}

	public static String getDetaFormaPagoFactuDescripcion(DetaFormaPagoFactu detaformapagofactu) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detaformapagofactu!=null/*&&detaformapagofactu.getId()>0*/) {
			sDescripcion=DetaFormaPagoFactuConstantesFunciones.getDetaFormaPagoFactuDescripcion(detaformapagofactu);
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

	public static String getTipoRetencionDescripcion(TipoRetencion tiporetencion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencion!=null/*&&tiporetencion.getId()>0*/) {
			sDescripcion=TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tiporetencion);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdDetaFormaPagoFactu")) {
			sNombreIndice="Tipo=  Por Deta Forma Pago Factu";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDetaFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Deta Forma Pago";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetaFormaPagoFactu(Long id_deta_forma_pago_factu) {
		String sDetalleIndice=" Parametros->";
		if(id_deta_forma_pago_factu!=null) {sDetalleIndice+=" Codigo Unico De Deta Forma Pago Factu="+id_deta_forma_pago_factu.toString();} 

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

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDetaFormaPago(Long id_tipo_deta_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_deta_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Deta Forma Pago="+id_tipo_deta_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetaFormaPago(DetaFormaPago detaformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detaformapago.setnumero_retencion(detaformapago.getnumero_retencion().trim());
		detaformapago.setdescripcion(detaformapago.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetaFormaPagos(List<DetaFormaPago> detaformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetaFormaPago detaformapago: detaformapagos) {
			detaformapago.setnumero_retencion(detaformapago.getnumero_retencion().trim());
			detaformapago.setdescripcion(detaformapago.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetaFormaPago(DetaFormaPago detaformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detaformapago.getConCambioAuxiliar()) {
			detaformapago.setIsDeleted(detaformapago.getIsDeletedAuxiliar());	
			detaformapago.setIsNew(detaformapago.getIsNewAuxiliar());	
			detaformapago.setIsChanged(detaformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detaformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detaformapago.setIsDeletedAuxiliar(false);	
			detaformapago.setIsNewAuxiliar(false);	
			detaformapago.setIsChangedAuxiliar(false);
			
			detaformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetaFormaPagos(List<DetaFormaPago> detaformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetaFormaPago detaformapago : detaformapagos) {
			if(conAsignarBase && detaformapago.getConCambioAuxiliar()) {
				detaformapago.setIsDeleted(detaformapago.getIsDeletedAuxiliar());	
				detaformapago.setIsNew(detaformapago.getIsNewAuxiliar());	
				detaformapago.setIsChanged(detaformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detaformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detaformapago.setIsDeletedAuxiliar(false);	
				detaformapago.setIsNewAuxiliar(false);	
				detaformapago.setIsChangedAuxiliar(false);
				
				detaformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetaFormaPago(DetaFormaPago detaformapago,Boolean conEnteros) throws Exception  {
		detaformapago.setvalor(0.0);
		detaformapago.setporcentaje(0.0);
		detaformapago.setretencion(0.0);
		detaformapago.setporcentaje_retencion(0.0);
		detaformapago.setbase_retencion(0.0);
		detaformapago.setvalor_retencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detaformapago.setnumero_dias(0);
			detaformapago.setnumero_cuota(0);
		}
	}		
	
	public static void InicializarValoresDetaFormaPagos(List<DetaFormaPago> detaformapagos,Boolean conEnteros) throws Exception  {
		
		for(DetaFormaPago detaformapago: detaformapagos) {
			detaformapago.setvalor(0.0);
			detaformapago.setporcentaje(0.0);
			detaformapago.setretencion(0.0);
			detaformapago.setporcentaje_retencion(0.0);
			detaformapago.setbase_retencion(0.0);
			detaformapago.setvalor_retencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detaformapago.setnumero_dias(0);
				detaformapago.setnumero_cuota(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetaFormaPago(List<DetaFormaPago> detaformapagos,DetaFormaPago detaformapagoAux) throws Exception  {
		DetaFormaPagoConstantesFunciones.InicializarValoresDetaFormaPago(detaformapagoAux,true);
		
		for(DetaFormaPago detaformapago: detaformapagos) {
			if(detaformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detaformapagoAux.setvalor(detaformapagoAux.getvalor()+detaformapago.getvalor());			
			detaformapagoAux.setporcentaje(detaformapagoAux.getporcentaje()+detaformapago.getporcentaje());			
			detaformapagoAux.setretencion(detaformapagoAux.getretencion()+detaformapago.getretencion());			
			detaformapagoAux.setporcentaje_retencion(detaformapagoAux.getporcentaje_retencion()+detaformapago.getporcentaje_retencion());			
			detaformapagoAux.setbase_retencion(detaformapagoAux.getbase_retencion()+detaformapago.getbase_retencion());			
			detaformapagoAux.setvalor_retencion(detaformapagoAux.getvalor_retencion()+detaformapago.getvalor_retencion());			
			detaformapagoAux.setnumero_dias(detaformapagoAux.getnumero_dias()+detaformapago.getnumero_dias());			
			detaformapagoAux.setnumero_cuota(detaformapagoAux.getnumero_cuota()+detaformapago.getnumero_cuota());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetaFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetaFormaPagoConstantesFunciones.getArrayColumnasGlobalesDetaFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetaFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaFormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaFormaPagoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaFormaPagoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaFormaPagoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaFormaPagoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaFormaPagoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetaFormaPagoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetaFormaPagoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetaFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetaFormaPago> detaformapagos,DetaFormaPago detaformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetaFormaPago detaformapagoAux: detaformapagos) {
			if(detaformapagoAux!=null && detaformapago!=null) {
				if((detaformapagoAux.getId()==null && detaformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detaformapagoAux.getId()!=null && detaformapago.getId()!=null){
					if(detaformapagoAux.getId().equals(detaformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetaFormaPago(List<DetaFormaPago> detaformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double porcentajeTotal=0.0;
		Double retencionTotal=0.0;
		Double porcentaje_retencionTotal=0.0;
		Double base_retencionTotal=0.0;
		Double valor_retencionTotal=0.0;
	
		for(DetaFormaPago detaformapago: detaformapagos) {			
			if(detaformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detaformapago.getvalor();
			porcentajeTotal+=detaformapago.getporcentaje();
			retencionTotal+=detaformapago.getretencion();
			porcentaje_retencionTotal+=detaformapago.getporcentaje_retencion();
			base_retencionTotal+=detaformapago.getbase_retencion();
			valor_retencionTotal+=detaformapago.getvalor_retencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaFormaPagoConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaFormaPagoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaFormaPagoConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION);
		datoGeneral.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION);
		datoGeneral.setdValorDouble(porcentaje_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaFormaPagoConstantesFunciones.BASERETENCION);
		datoGeneral.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_BASERETENCION);
		datoGeneral.setdValorDouble(base_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetaFormaPagoConstantesFunciones.VALORRETENCION);
		datoGeneral.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_VALORRETENCION);
		datoGeneral.setdValorDouble(valor_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetaFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_ID, DetaFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_VERSIONROW, DetaFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA, DetaFormaPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDSUCURSAL, DetaFormaPagoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDEJERCICIO, DetaFormaPagoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDPERIODO, DetaFormaPagoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDFACTURA, DetaFormaPagoConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO, DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDTIPODETAFORMAPAGO, DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGOFACTU, DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE, DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDTIPORETENCION, DetaFormaPagoConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_VALOR, DetaFormaPagoConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_FECHAINICIAL, DetaFormaPagoConstantesFunciones.FECHAINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_FECHAFINAL, DetaFormaPagoConstantesFunciones.FECHAFINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJE, DetaFormaPagoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_RETENCION, DetaFormaPagoConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION, DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_BASERETENCION, DetaFormaPagoConstantesFunciones.BASERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_VALORRETENCION, DetaFormaPagoConstantesFunciones.VALORRETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_NUMERORETENCION, DetaFormaPagoConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_NUMERODIAS, DetaFormaPagoConstantesFunciones.NUMERODIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_NUMEROCUOTA, DetaFormaPagoConstantesFunciones.NUMEROCUOTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_DESCRIPCION, DetaFormaPagoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDANIO, DetaFormaPagoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetaFormaPagoConstantesFunciones.LABEL_IDMES, DetaFormaPagoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetaFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.FECHAINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.FECHAFINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.BASERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.VALORRETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.NUMERODIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.NUMEROCUOTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetaFormaPagoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaFormaPago() throws Exception  {
		return DetaFormaPagoConstantesFunciones.getTiposSeleccionarDetaFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaFormaPago(Boolean conFk) throws Exception  {
		return DetaFormaPagoConstantesFunciones.getTiposSeleccionarDetaFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetaFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDTIPODETAFORMAPAGO);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDTIPODETAFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGOFACTU);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGOFACTU);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_FECHAINICIAL);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_FECHAINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_FECHAFINAL);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_FECHAFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_BASERETENCION);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_BASERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_VALORRETENCION);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_VALORRETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_NUMERODIAS);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_NUMERODIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_NUMEROCUOTA);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_NUMEROCUOTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetaFormaPagoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetaFormaPagoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetaFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetaFormaPago(DetaFormaPago detaformapagoAux) throws Exception {
		
			detaformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detaformapagoAux.getEmpresa()));
			detaformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detaformapagoAux.getSucursal()));
			detaformapagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detaformapagoAux.getEjercicio()));
			detaformapagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detaformapagoAux.getPeriodo()));
			detaformapagoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detaformapagoAux.getFactura()));
			detaformapagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(detaformapagoAux.getTipoFormaPago()));
			detaformapagoAux.settipodetaformapago_descripcion(TipoDetaFormaPagoConstantesFunciones.getTipoDetaFormaPagoDescripcion(detaformapagoAux.getTipoDetaFormaPago()));
			detaformapagoAux.setdetaformapagofactu_descripcion(DetaFormaPagoFactuConstantesFunciones.getDetaFormaPagoFactuDescripcion(detaformapagoAux.getDetaFormaPagoFactu()));
			detaformapagoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detaformapagoAux.getCuentaContable()));
			detaformapagoAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(detaformapagoAux.getTipoRetencion()));
			detaformapagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detaformapagoAux.getAnio()));
			detaformapagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detaformapagoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetaFormaPago(List<DetaFormaPago> detaformapagosTemp) throws Exception {
		for(DetaFormaPago detaformapagoAux:detaformapagosTemp) {
			
			detaformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detaformapagoAux.getEmpresa()));
			detaformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detaformapagoAux.getSucursal()));
			detaformapagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detaformapagoAux.getEjercicio()));
			detaformapagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detaformapagoAux.getPeriodo()));
			detaformapagoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detaformapagoAux.getFactura()));
			detaformapagoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(detaformapagoAux.getTipoFormaPago()));
			detaformapagoAux.settipodetaformapago_descripcion(TipoDetaFormaPagoConstantesFunciones.getTipoDetaFormaPagoDescripcion(detaformapagoAux.getTipoDetaFormaPago()));
			detaformapagoAux.setdetaformapagofactu_descripcion(DetaFormaPagoFactuConstantesFunciones.getDetaFormaPagoFactuDescripcion(detaformapagoAux.getDetaFormaPagoFactu()));
			detaformapagoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detaformapagoAux.getCuentaContable()));
			detaformapagoAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(detaformapagoAux.getTipoRetencion()));
			detaformapagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detaformapagoAux.getAnio()));
			detaformapagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detaformapagoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetaFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(TipoFormaPago.class));
				classes.add(new Classe(TipoDetaFormaPago.class));
				classes.add(new Classe(DetaFormaPagoFactu.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDetaFormaPago.class)) {
						classes.add(new Classe(TipoDetaFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaFormaPagoFactu.class)) {
						classes.add(new Classe(DetaFormaPagoFactu.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetaFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(TipoDetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDetaFormaPago.class)); continue;
					}

					if(DetaFormaPagoFactu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPagoFactu.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(TipoDetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDetaFormaPago.class)); continue;
					}

					if(DetaFormaPagoFactu.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPagoFactu.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetaFormaPagoConstantesFunciones.getClassesRelationshipsOfDetaFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(BancoFormaPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(BancoFormaPago.class)) {
						classes.add(new Classe(BancoFormaPago.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetaFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetaFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfDetaFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetaFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(BancoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BancoFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(BancoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(BancoFormaPago.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(DetaFormaPago detaformapago,List<DetaFormaPago> detaformapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetaFormaPago detaformapagoEncontrado=null;
			
			for(DetaFormaPago detaformapagoLocal:detaformapagos) {
				if(detaformapagoLocal.getId().equals(detaformapago.getId())) {
					detaformapagoEncontrado=detaformapagoLocal;
					
					detaformapagoLocal.setIsChanged(detaformapago.getIsChanged());
					detaformapagoLocal.setIsNew(detaformapago.getIsNew());
					detaformapagoLocal.setIsDeleted(detaformapago.getIsDeleted());
					
					detaformapagoLocal.setGeneralEntityOriginal(detaformapago.getGeneralEntityOriginal());
					
					detaformapagoLocal.setId(detaformapago.getId());	
					detaformapagoLocal.setVersionRow(detaformapago.getVersionRow());	
					detaformapagoLocal.setid_empresa(detaformapago.getid_empresa());	
					detaformapagoLocal.setid_sucursal(detaformapago.getid_sucursal());	
					detaformapagoLocal.setid_ejercicio(detaformapago.getid_ejercicio());	
					detaformapagoLocal.setid_periodo(detaformapago.getid_periodo());	
					detaformapagoLocal.setid_factura(detaformapago.getid_factura());	
					detaformapagoLocal.setid_tipo_forma_pago(detaformapago.getid_tipo_forma_pago());	
					detaformapagoLocal.setid_tipo_deta_forma_pago(detaformapago.getid_tipo_deta_forma_pago());	
					detaformapagoLocal.setid_deta_forma_pago_factu(detaformapago.getid_deta_forma_pago_factu());	
					detaformapagoLocal.setid_cuenta_contable(detaformapago.getid_cuenta_contable());	
					detaformapagoLocal.setid_tipo_retencion(detaformapago.getid_tipo_retencion());	
					detaformapagoLocal.setvalor(detaformapago.getvalor());	
					detaformapagoLocal.setfecha_inicial(detaformapago.getfecha_inicial());	
					detaformapagoLocal.setfecha_final(detaformapago.getfecha_final());	
					detaformapagoLocal.setporcentaje(detaformapago.getporcentaje());	
					detaformapagoLocal.setretencion(detaformapago.getretencion());	
					detaformapagoLocal.setporcentaje_retencion(detaformapago.getporcentaje_retencion());	
					detaformapagoLocal.setbase_retencion(detaformapago.getbase_retencion());	
					detaformapagoLocal.setvalor_retencion(detaformapago.getvalor_retencion());	
					detaformapagoLocal.setnumero_retencion(detaformapago.getnumero_retencion());	
					detaformapagoLocal.setnumero_dias(detaformapago.getnumero_dias());	
					detaformapagoLocal.setnumero_cuota(detaformapago.getnumero_cuota());	
					detaformapagoLocal.setdescripcion(detaformapago.getdescripcion());	
					detaformapagoLocal.setid_anio(detaformapago.getid_anio());	
					detaformapagoLocal.setid_mes(detaformapago.getid_mes());	
					
					
					detaformapagoLocal.setBancoFormaPagos(detaformapago.getBancoFormaPagos());
					
					existe=true;
					break;
				}
			}
			
			if(!detaformapago.getIsDeleted()) {
				if(!existe) {
					detaformapagos.add(detaformapago);
				}
			} else {
				if(detaformapagoEncontrado!=null && permiteQuitar)  {
					detaformapagos.remove(detaformapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetaFormaPago detaformapago,List<DetaFormaPago> detaformapagos) throws Exception {
		try	{			
			for(DetaFormaPago detaformapagoLocal:detaformapagos) {
				if(detaformapagoLocal.getId().equals(detaformapago.getId())) {
					detaformapagoLocal.setIsSelected(detaformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetaFormaPago(List<DetaFormaPago> detaformapagosAux) throws Exception {
		//this.detaformapagosAux=detaformapagosAux;
		
		for(DetaFormaPago detaformapagoAux:detaformapagosAux) {
			if(detaformapagoAux.getIsChanged()) {
				detaformapagoAux.setIsChanged(false);
			}		
			
			if(detaformapagoAux.getIsNew()) {
				detaformapagoAux.setIsNew(false);
			}	
			
			if(detaformapagoAux.getIsDeleted()) {
				detaformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetaFormaPago(DetaFormaPago detaformapagoAux) throws Exception {
		//this.detaformapagoAux=detaformapagoAux;
		
			if(detaformapagoAux.getIsChanged()) {
				detaformapagoAux.setIsChanged(false);
			}		
			
			if(detaformapagoAux.getIsNew()) {
				detaformapagoAux.setIsNew(false);
			}	
			
			if(detaformapagoAux.getIsDeleted()) {
				detaformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetaFormaPago detaformapagoAsignar,DetaFormaPago detaformapago) throws Exception {
		detaformapagoAsignar.setId(detaformapago.getId());	
		detaformapagoAsignar.setVersionRow(detaformapago.getVersionRow());	
		detaformapagoAsignar.setid_empresa(detaformapago.getid_empresa());
		detaformapagoAsignar.setempresa_descripcion(detaformapago.getempresa_descripcion());	
		detaformapagoAsignar.setid_sucursal(detaformapago.getid_sucursal());
		detaformapagoAsignar.setsucursal_descripcion(detaformapago.getsucursal_descripcion());	
		detaformapagoAsignar.setid_ejercicio(detaformapago.getid_ejercicio());
		detaformapagoAsignar.setejercicio_descripcion(detaformapago.getejercicio_descripcion());	
		detaformapagoAsignar.setid_periodo(detaformapago.getid_periodo());
		detaformapagoAsignar.setperiodo_descripcion(detaformapago.getperiodo_descripcion());	
		detaformapagoAsignar.setid_factura(detaformapago.getid_factura());
		detaformapagoAsignar.setfactura_descripcion(detaformapago.getfactura_descripcion());	
		detaformapagoAsignar.setid_tipo_forma_pago(detaformapago.getid_tipo_forma_pago());
		detaformapagoAsignar.settipoformapago_descripcion(detaformapago.gettipoformapago_descripcion());	
		detaformapagoAsignar.setid_tipo_deta_forma_pago(detaformapago.getid_tipo_deta_forma_pago());
		detaformapagoAsignar.settipodetaformapago_descripcion(detaformapago.gettipodetaformapago_descripcion());	
		detaformapagoAsignar.setid_deta_forma_pago_factu(detaformapago.getid_deta_forma_pago_factu());
		detaformapagoAsignar.setdetaformapagofactu_descripcion(detaformapago.getdetaformapagofactu_descripcion());	
		detaformapagoAsignar.setid_cuenta_contable(detaformapago.getid_cuenta_contable());
		detaformapagoAsignar.setcuentacontable_descripcion(detaformapago.getcuentacontable_descripcion());	
		detaformapagoAsignar.setid_tipo_retencion(detaformapago.getid_tipo_retencion());
		detaformapagoAsignar.settiporetencion_descripcion(detaformapago.gettiporetencion_descripcion());	
		detaformapagoAsignar.setvalor(detaformapago.getvalor());	
		detaformapagoAsignar.setfecha_inicial(detaformapago.getfecha_inicial());	
		detaformapagoAsignar.setfecha_final(detaformapago.getfecha_final());	
		detaformapagoAsignar.setporcentaje(detaformapago.getporcentaje());	
		detaformapagoAsignar.setretencion(detaformapago.getretencion());	
		detaformapagoAsignar.setporcentaje_retencion(detaformapago.getporcentaje_retencion());	
		detaformapagoAsignar.setbase_retencion(detaformapago.getbase_retencion());	
		detaformapagoAsignar.setvalor_retencion(detaformapago.getvalor_retencion());	
		detaformapagoAsignar.setnumero_retencion(detaformapago.getnumero_retencion());	
		detaformapagoAsignar.setnumero_dias(detaformapago.getnumero_dias());	
		detaformapagoAsignar.setnumero_cuota(detaformapago.getnumero_cuota());	
		detaformapagoAsignar.setdescripcion(detaformapago.getdescripcion());	
		detaformapagoAsignar.setid_anio(detaformapago.getid_anio());
		detaformapagoAsignar.setanio_descripcion(detaformapago.getanio_descripcion());	
		detaformapagoAsignar.setid_mes(detaformapago.getid_mes());
		detaformapagoAsignar.setmes_descripcion(detaformapago.getmes_descripcion());	
	}
	
	public static void inicializarDetaFormaPago(DetaFormaPago detaformapago) throws Exception {
		try {
				detaformapago.setId(0L);	
					
				detaformapago.setid_empresa(-1L);	
				detaformapago.setid_sucursal(-1L);	
				detaformapago.setid_ejercicio(-1L);	
				detaformapago.setid_periodo(-1L);	
				detaformapago.setid_factura(-1L);	
				detaformapago.setid_tipo_forma_pago(-1L);	
				detaformapago.setid_tipo_deta_forma_pago(-1L);	
				detaformapago.setid_deta_forma_pago_factu(-1L);	
				detaformapago.setid_cuenta_contable(null);	
				detaformapago.setid_tipo_retencion(-1L);	
				detaformapago.setvalor(0.0);	
				detaformapago.setfecha_inicial(new Date());	
				detaformapago.setfecha_final(new Date());	
				detaformapago.setporcentaje(0.0);	
				detaformapago.setretencion(0.0);	
				detaformapago.setporcentaje_retencion(0.0);	
				detaformapago.setbase_retencion(0.0);	
				detaformapago.setvalor_retencion(0.0);	
				detaformapago.setnumero_retencion("");	
				detaformapago.setnumero_dias(0);	
				detaformapago.setnumero_cuota(0);	
				detaformapago.setdescripcion("");	
				detaformapago.setid_anio(null);	
				detaformapago.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetaFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDTIPODETAFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGOFACTU);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_FECHAINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_FECHAFINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_PORCENTAJERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_BASERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_VALORRETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_NUMERODIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_NUMEROCUOTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetaFormaPagoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetaFormaPago(String sTipo,Row row,Workbook workbook,DetaFormaPago detaformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.gettipodetaformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getdetaformapagofactu_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getfecha_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getfecha_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getporcentaje_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getbase_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getvalor_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getnumero_dias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getnumero_cuota());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detaformapago.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetaFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetaFormaPago() {
		return this.sFinalQueryDetaFormaPago;
	}
	
	public void setsFinalQueryDetaFormaPago(String sFinalQueryDetaFormaPago) {
		this.sFinalQueryDetaFormaPago= sFinalQueryDetaFormaPago;
	}
	
	public Border resaltarSeleccionarDetaFormaPago=null;
	
	public Border setResaltarSeleccionarDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetaFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetaFormaPago() {
		return this.resaltarSeleccionarDetaFormaPago;
	}
	
	public void setResaltarSeleccionarDetaFormaPago(Border borderResaltarSeleccionarDetaFormaPago) {
		this.resaltarSeleccionarDetaFormaPago= borderResaltarSeleccionarDetaFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetaFormaPago=null;
	public Boolean mostraridDetaFormaPago=true;
	public Boolean activaridDetaFormaPago=true;

	public Border resaltarid_empresaDetaFormaPago=null;
	public Boolean mostrarid_empresaDetaFormaPago=true;
	public Boolean activarid_empresaDetaFormaPago=true;
	public Boolean cargarid_empresaDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetaFormaPago=null;
	public Boolean mostrarid_sucursalDetaFormaPago=true;
	public Boolean activarid_sucursalDetaFormaPago=true;
	public Boolean cargarid_sucursalDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetaFormaPago=null;
	public Boolean mostrarid_ejercicioDetaFormaPago=true;
	public Boolean activarid_ejercicioDetaFormaPago=true;
	public Boolean cargarid_ejercicioDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_periodoDetaFormaPago=null;
	public Boolean mostrarid_periodoDetaFormaPago=true;
	public Boolean activarid_periodoDetaFormaPago=true;
	public Boolean cargarid_periodoDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_facturaDetaFormaPago=null;
	public Boolean mostrarid_facturaDetaFormaPago=true;
	public Boolean activarid_facturaDetaFormaPago=true;
	public Boolean cargarid_facturaDetaFormaPago=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoDetaFormaPago=null;
	public Boolean mostrarid_tipo_forma_pagoDetaFormaPago=true;
	public Boolean activarid_tipo_forma_pagoDetaFormaPago=true;
	public Boolean cargarid_tipo_forma_pagoDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_deta_forma_pagoDetaFormaPago=null;
	public Boolean mostrarid_tipo_deta_forma_pagoDetaFormaPago=true;
	public Boolean activarid_tipo_deta_forma_pagoDetaFormaPago=true;
	public Boolean cargarid_tipo_deta_forma_pagoDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_deta_forma_pagoDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_deta_forma_pago_factuDetaFormaPago=null;
	public Boolean mostrarid_deta_forma_pago_factuDetaFormaPago=true;
	public Boolean activarid_deta_forma_pago_factuDetaFormaPago=true;
	public Boolean cargarid_deta_forma_pago_factuDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_deta_forma_pago_factuDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableDetaFormaPago=null;
	public Boolean mostrarid_cuenta_contableDetaFormaPago=true;
	public Boolean activarid_cuenta_contableDetaFormaPago=true;
	public Boolean cargarid_cuenta_contableDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencionDetaFormaPago=null;
	public Boolean mostrarid_tipo_retencionDetaFormaPago=true;
	public Boolean activarid_tipo_retencionDetaFormaPago=true;
	public Boolean cargarid_tipo_retencionDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarvalorDetaFormaPago=null;
	public Boolean mostrarvalorDetaFormaPago=true;
	public Boolean activarvalorDetaFormaPago=true;

	public Border resaltarfecha_inicialDetaFormaPago=null;
	public Boolean mostrarfecha_inicialDetaFormaPago=true;
	public Boolean activarfecha_inicialDetaFormaPago=false;

	public Border resaltarfecha_finalDetaFormaPago=null;
	public Boolean mostrarfecha_finalDetaFormaPago=true;
	public Boolean activarfecha_finalDetaFormaPago=false;

	public Border resaltarporcentajeDetaFormaPago=null;
	public Boolean mostrarporcentajeDetaFormaPago=true;
	public Boolean activarporcentajeDetaFormaPago=true;

	public Border resaltarretencionDetaFormaPago=null;
	public Boolean mostrarretencionDetaFormaPago=true;
	public Boolean activarretencionDetaFormaPago=true;

	public Border resaltarporcentaje_retencionDetaFormaPago=null;
	public Boolean mostrarporcentaje_retencionDetaFormaPago=true;
	public Boolean activarporcentaje_retencionDetaFormaPago=true;

	public Border resaltarbase_retencionDetaFormaPago=null;
	public Boolean mostrarbase_retencionDetaFormaPago=true;
	public Boolean activarbase_retencionDetaFormaPago=true;

	public Border resaltarvalor_retencionDetaFormaPago=null;
	public Boolean mostrarvalor_retencionDetaFormaPago=true;
	public Boolean activarvalor_retencionDetaFormaPago=true;

	public Border resaltarnumero_retencionDetaFormaPago=null;
	public Boolean mostrarnumero_retencionDetaFormaPago=true;
	public Boolean activarnumero_retencionDetaFormaPago=true;

	public Border resaltarnumero_diasDetaFormaPago=null;
	public Boolean mostrarnumero_diasDetaFormaPago=true;
	public Boolean activarnumero_diasDetaFormaPago=true;

	public Border resaltarnumero_cuotaDetaFormaPago=null;
	public Boolean mostrarnumero_cuotaDetaFormaPago=true;
	public Boolean activarnumero_cuotaDetaFormaPago=true;

	public Border resaltardescripcionDetaFormaPago=null;
	public Boolean mostrardescripcionDetaFormaPago=true;
	public Boolean activardescripcionDetaFormaPago=true;

	public Border resaltarid_anioDetaFormaPago=null;
	public Boolean mostrarid_anioDetaFormaPago=true;
	public Boolean activarid_anioDetaFormaPago=false;
	public Boolean cargarid_anioDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetaFormaPago=false;//ConEventDepend=true

	public Border resaltarid_mesDetaFormaPago=null;
	public Boolean mostrarid_mesDetaFormaPago=true;
	public Boolean activarid_mesDetaFormaPago=false;
	public Boolean cargarid_mesDetaFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetaFormaPago=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltaridDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetaFormaPago() {
		return this.resaltaridDetaFormaPago;
	}

	public void setResaltaridDetaFormaPago(Border borderResaltar) {
		this.resaltaridDetaFormaPago= borderResaltar;
	}

	public Boolean getMostraridDetaFormaPago() {
		return this.mostraridDetaFormaPago;
	}

	public void setMostraridDetaFormaPago(Boolean mostraridDetaFormaPago) {
		this.mostraridDetaFormaPago= mostraridDetaFormaPago;
	}

	public Boolean getActivaridDetaFormaPago() {
		return this.activaridDetaFormaPago;
	}

	public void setActivaridDetaFormaPago(Boolean activaridDetaFormaPago) {
		this.activaridDetaFormaPago= activaridDetaFormaPago;
	}

	public Border setResaltarid_empresaDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetaFormaPago() {
		return this.resaltarid_empresaDetaFormaPago;
	}

	public void setResaltarid_empresaDetaFormaPago(Border borderResaltar) {
		this.resaltarid_empresaDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetaFormaPago() {
		return this.mostrarid_empresaDetaFormaPago;
	}

	public void setMostrarid_empresaDetaFormaPago(Boolean mostrarid_empresaDetaFormaPago) {
		this.mostrarid_empresaDetaFormaPago= mostrarid_empresaDetaFormaPago;
	}

	public Boolean getActivarid_empresaDetaFormaPago() {
		return this.activarid_empresaDetaFormaPago;
	}

	public void setActivarid_empresaDetaFormaPago(Boolean activarid_empresaDetaFormaPago) {
		this.activarid_empresaDetaFormaPago= activarid_empresaDetaFormaPago;
	}

	public Boolean getCargarid_empresaDetaFormaPago() {
		return this.cargarid_empresaDetaFormaPago;
	}

	public void setCargarid_empresaDetaFormaPago(Boolean cargarid_empresaDetaFormaPago) {
		this.cargarid_empresaDetaFormaPago= cargarid_empresaDetaFormaPago;
	}

	public Border setResaltarid_sucursalDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetaFormaPago() {
		return this.resaltarid_sucursalDetaFormaPago;
	}

	public void setResaltarid_sucursalDetaFormaPago(Border borderResaltar) {
		this.resaltarid_sucursalDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetaFormaPago() {
		return this.mostrarid_sucursalDetaFormaPago;
	}

	public void setMostrarid_sucursalDetaFormaPago(Boolean mostrarid_sucursalDetaFormaPago) {
		this.mostrarid_sucursalDetaFormaPago= mostrarid_sucursalDetaFormaPago;
	}

	public Boolean getActivarid_sucursalDetaFormaPago() {
		return this.activarid_sucursalDetaFormaPago;
	}

	public void setActivarid_sucursalDetaFormaPago(Boolean activarid_sucursalDetaFormaPago) {
		this.activarid_sucursalDetaFormaPago= activarid_sucursalDetaFormaPago;
	}

	public Boolean getCargarid_sucursalDetaFormaPago() {
		return this.cargarid_sucursalDetaFormaPago;
	}

	public void setCargarid_sucursalDetaFormaPago(Boolean cargarid_sucursalDetaFormaPago) {
		this.cargarid_sucursalDetaFormaPago= cargarid_sucursalDetaFormaPago;
	}

	public Border setResaltarid_ejercicioDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetaFormaPago() {
		return this.resaltarid_ejercicioDetaFormaPago;
	}

	public void setResaltarid_ejercicioDetaFormaPago(Border borderResaltar) {
		this.resaltarid_ejercicioDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetaFormaPago() {
		return this.mostrarid_ejercicioDetaFormaPago;
	}

	public void setMostrarid_ejercicioDetaFormaPago(Boolean mostrarid_ejercicioDetaFormaPago) {
		this.mostrarid_ejercicioDetaFormaPago= mostrarid_ejercicioDetaFormaPago;
	}

	public Boolean getActivarid_ejercicioDetaFormaPago() {
		return this.activarid_ejercicioDetaFormaPago;
	}

	public void setActivarid_ejercicioDetaFormaPago(Boolean activarid_ejercicioDetaFormaPago) {
		this.activarid_ejercicioDetaFormaPago= activarid_ejercicioDetaFormaPago;
	}

	public Boolean getCargarid_ejercicioDetaFormaPago() {
		return this.cargarid_ejercicioDetaFormaPago;
	}

	public void setCargarid_ejercicioDetaFormaPago(Boolean cargarid_ejercicioDetaFormaPago) {
		this.cargarid_ejercicioDetaFormaPago= cargarid_ejercicioDetaFormaPago;
	}

	public Border setResaltarid_periodoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetaFormaPago() {
		return this.resaltarid_periodoDetaFormaPago;
	}

	public void setResaltarid_periodoDetaFormaPago(Border borderResaltar) {
		this.resaltarid_periodoDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetaFormaPago() {
		return this.mostrarid_periodoDetaFormaPago;
	}

	public void setMostrarid_periodoDetaFormaPago(Boolean mostrarid_periodoDetaFormaPago) {
		this.mostrarid_periodoDetaFormaPago= mostrarid_periodoDetaFormaPago;
	}

	public Boolean getActivarid_periodoDetaFormaPago() {
		return this.activarid_periodoDetaFormaPago;
	}

	public void setActivarid_periodoDetaFormaPago(Boolean activarid_periodoDetaFormaPago) {
		this.activarid_periodoDetaFormaPago= activarid_periodoDetaFormaPago;
	}

	public Boolean getCargarid_periodoDetaFormaPago() {
		return this.cargarid_periodoDetaFormaPago;
	}

	public void setCargarid_periodoDetaFormaPago(Boolean cargarid_periodoDetaFormaPago) {
		this.cargarid_periodoDetaFormaPago= cargarid_periodoDetaFormaPago;
	}

	public Border setResaltarid_facturaDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_facturaDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaDetaFormaPago() {
		return this.resaltarid_facturaDetaFormaPago;
	}

	public void setResaltarid_facturaDetaFormaPago(Border borderResaltar) {
		this.resaltarid_facturaDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_facturaDetaFormaPago() {
		return this.mostrarid_facturaDetaFormaPago;
	}

	public void setMostrarid_facturaDetaFormaPago(Boolean mostrarid_facturaDetaFormaPago) {
		this.mostrarid_facturaDetaFormaPago= mostrarid_facturaDetaFormaPago;
	}

	public Boolean getActivarid_facturaDetaFormaPago() {
		return this.activarid_facturaDetaFormaPago;
	}

	public void setActivarid_facturaDetaFormaPago(Boolean activarid_facturaDetaFormaPago) {
		this.activarid_facturaDetaFormaPago= activarid_facturaDetaFormaPago;
	}

	public Boolean getCargarid_facturaDetaFormaPago() {
		return this.cargarid_facturaDetaFormaPago;
	}

	public void setCargarid_facturaDetaFormaPago(Boolean cargarid_facturaDetaFormaPago) {
		this.cargarid_facturaDetaFormaPago= cargarid_facturaDetaFormaPago;
	}

	public Border setResaltarid_tipo_forma_pagoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoDetaFormaPago() {
		return this.resaltarid_tipo_forma_pagoDetaFormaPago;
	}

	public void setResaltarid_tipo_forma_pagoDetaFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoDetaFormaPago() {
		return this.mostrarid_tipo_forma_pagoDetaFormaPago;
	}

	public void setMostrarid_tipo_forma_pagoDetaFormaPago(Boolean mostrarid_tipo_forma_pagoDetaFormaPago) {
		this.mostrarid_tipo_forma_pagoDetaFormaPago= mostrarid_tipo_forma_pagoDetaFormaPago;
	}

	public Boolean getActivarid_tipo_forma_pagoDetaFormaPago() {
		return this.activarid_tipo_forma_pagoDetaFormaPago;
	}

	public void setActivarid_tipo_forma_pagoDetaFormaPago(Boolean activarid_tipo_forma_pagoDetaFormaPago) {
		this.activarid_tipo_forma_pagoDetaFormaPago= activarid_tipo_forma_pagoDetaFormaPago;
	}

	public Boolean getCargarid_tipo_forma_pagoDetaFormaPago() {
		return this.cargarid_tipo_forma_pagoDetaFormaPago;
	}

	public void setCargarid_tipo_forma_pagoDetaFormaPago(Boolean cargarid_tipo_forma_pagoDetaFormaPago) {
		this.cargarid_tipo_forma_pagoDetaFormaPago= cargarid_tipo_forma_pagoDetaFormaPago;
	}

	public Border setResaltarid_tipo_deta_forma_pagoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_deta_forma_pagoDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_deta_forma_pagoDetaFormaPago() {
		return this.resaltarid_tipo_deta_forma_pagoDetaFormaPago;
	}

	public void setResaltarid_tipo_deta_forma_pagoDetaFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_deta_forma_pagoDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_deta_forma_pagoDetaFormaPago() {
		return this.mostrarid_tipo_deta_forma_pagoDetaFormaPago;
	}

	public void setMostrarid_tipo_deta_forma_pagoDetaFormaPago(Boolean mostrarid_tipo_deta_forma_pagoDetaFormaPago) {
		this.mostrarid_tipo_deta_forma_pagoDetaFormaPago= mostrarid_tipo_deta_forma_pagoDetaFormaPago;
	}

	public Boolean getActivarid_tipo_deta_forma_pagoDetaFormaPago() {
		return this.activarid_tipo_deta_forma_pagoDetaFormaPago;
	}

	public void setActivarid_tipo_deta_forma_pagoDetaFormaPago(Boolean activarid_tipo_deta_forma_pagoDetaFormaPago) {
		this.activarid_tipo_deta_forma_pagoDetaFormaPago= activarid_tipo_deta_forma_pagoDetaFormaPago;
	}

	public Boolean getCargarid_tipo_deta_forma_pagoDetaFormaPago() {
		return this.cargarid_tipo_deta_forma_pagoDetaFormaPago;
	}

	public void setCargarid_tipo_deta_forma_pagoDetaFormaPago(Boolean cargarid_tipo_deta_forma_pagoDetaFormaPago) {
		this.cargarid_tipo_deta_forma_pagoDetaFormaPago= cargarid_tipo_deta_forma_pagoDetaFormaPago;
	}

	public Border setResaltarid_deta_forma_pago_factuDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_deta_forma_pago_factuDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_deta_forma_pago_factuDetaFormaPago() {
		return this.resaltarid_deta_forma_pago_factuDetaFormaPago;
	}

	public void setResaltarid_deta_forma_pago_factuDetaFormaPago(Border borderResaltar) {
		this.resaltarid_deta_forma_pago_factuDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_deta_forma_pago_factuDetaFormaPago() {
		return this.mostrarid_deta_forma_pago_factuDetaFormaPago;
	}

	public void setMostrarid_deta_forma_pago_factuDetaFormaPago(Boolean mostrarid_deta_forma_pago_factuDetaFormaPago) {
		this.mostrarid_deta_forma_pago_factuDetaFormaPago= mostrarid_deta_forma_pago_factuDetaFormaPago;
	}

	public Boolean getActivarid_deta_forma_pago_factuDetaFormaPago() {
		return this.activarid_deta_forma_pago_factuDetaFormaPago;
	}

	public void setActivarid_deta_forma_pago_factuDetaFormaPago(Boolean activarid_deta_forma_pago_factuDetaFormaPago) {
		this.activarid_deta_forma_pago_factuDetaFormaPago= activarid_deta_forma_pago_factuDetaFormaPago;
	}

	public Boolean getCargarid_deta_forma_pago_factuDetaFormaPago() {
		return this.cargarid_deta_forma_pago_factuDetaFormaPago;
	}

	public void setCargarid_deta_forma_pago_factuDetaFormaPago(Boolean cargarid_deta_forma_pago_factuDetaFormaPago) {
		this.cargarid_deta_forma_pago_factuDetaFormaPago= cargarid_deta_forma_pago_factuDetaFormaPago;
	}

	public Border setResaltarid_cuenta_contableDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableDetaFormaPago() {
		return this.resaltarid_cuenta_contableDetaFormaPago;
	}

	public void setResaltarid_cuenta_contableDetaFormaPago(Border borderResaltar) {
		this.resaltarid_cuenta_contableDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableDetaFormaPago() {
		return this.mostrarid_cuenta_contableDetaFormaPago;
	}

	public void setMostrarid_cuenta_contableDetaFormaPago(Boolean mostrarid_cuenta_contableDetaFormaPago) {
		this.mostrarid_cuenta_contableDetaFormaPago= mostrarid_cuenta_contableDetaFormaPago;
	}

	public Boolean getActivarid_cuenta_contableDetaFormaPago() {
		return this.activarid_cuenta_contableDetaFormaPago;
	}

	public void setActivarid_cuenta_contableDetaFormaPago(Boolean activarid_cuenta_contableDetaFormaPago) {
		this.activarid_cuenta_contableDetaFormaPago= activarid_cuenta_contableDetaFormaPago;
	}

	public Boolean getCargarid_cuenta_contableDetaFormaPago() {
		return this.cargarid_cuenta_contableDetaFormaPago;
	}

	public void setCargarid_cuenta_contableDetaFormaPago(Boolean cargarid_cuenta_contableDetaFormaPago) {
		this.cargarid_cuenta_contableDetaFormaPago= cargarid_cuenta_contableDetaFormaPago;
	}

	public Border setResaltarid_tipo_retencionDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionDetaFormaPago() {
		return this.resaltarid_tipo_retencionDetaFormaPago;
	}

	public void setResaltarid_tipo_retencionDetaFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_retencionDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionDetaFormaPago() {
		return this.mostrarid_tipo_retencionDetaFormaPago;
	}

	public void setMostrarid_tipo_retencionDetaFormaPago(Boolean mostrarid_tipo_retencionDetaFormaPago) {
		this.mostrarid_tipo_retencionDetaFormaPago= mostrarid_tipo_retencionDetaFormaPago;
	}

	public Boolean getActivarid_tipo_retencionDetaFormaPago() {
		return this.activarid_tipo_retencionDetaFormaPago;
	}

	public void setActivarid_tipo_retencionDetaFormaPago(Boolean activarid_tipo_retencionDetaFormaPago) {
		this.activarid_tipo_retencionDetaFormaPago= activarid_tipo_retencionDetaFormaPago;
	}

	public Boolean getCargarid_tipo_retencionDetaFormaPago() {
		return this.cargarid_tipo_retencionDetaFormaPago;
	}

	public void setCargarid_tipo_retencionDetaFormaPago(Boolean cargarid_tipo_retencionDetaFormaPago) {
		this.cargarid_tipo_retencionDetaFormaPago= cargarid_tipo_retencionDetaFormaPago;
	}

	public Border setResaltarvalorDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarvalorDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetaFormaPago() {
		return this.resaltarvalorDetaFormaPago;
	}

	public void setResaltarvalorDetaFormaPago(Border borderResaltar) {
		this.resaltarvalorDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarvalorDetaFormaPago() {
		return this.mostrarvalorDetaFormaPago;
	}

	public void setMostrarvalorDetaFormaPago(Boolean mostrarvalorDetaFormaPago) {
		this.mostrarvalorDetaFormaPago= mostrarvalorDetaFormaPago;
	}

	public Boolean getActivarvalorDetaFormaPago() {
		return this.activarvalorDetaFormaPago;
	}

	public void setActivarvalorDetaFormaPago(Boolean activarvalorDetaFormaPago) {
		this.activarvalorDetaFormaPago= activarvalorDetaFormaPago;
	}

	public Border setResaltarfecha_inicialDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarfecha_inicialDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicialDetaFormaPago() {
		return this.resaltarfecha_inicialDetaFormaPago;
	}

	public void setResaltarfecha_inicialDetaFormaPago(Border borderResaltar) {
		this.resaltarfecha_inicialDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarfecha_inicialDetaFormaPago() {
		return this.mostrarfecha_inicialDetaFormaPago;
	}

	public void setMostrarfecha_inicialDetaFormaPago(Boolean mostrarfecha_inicialDetaFormaPago) {
		this.mostrarfecha_inicialDetaFormaPago= mostrarfecha_inicialDetaFormaPago;
	}

	public Boolean getActivarfecha_inicialDetaFormaPago() {
		return this.activarfecha_inicialDetaFormaPago;
	}

	public void setActivarfecha_inicialDetaFormaPago(Boolean activarfecha_inicialDetaFormaPago) {
		this.activarfecha_inicialDetaFormaPago= activarfecha_inicialDetaFormaPago;
	}

	public Border setResaltarfecha_finalDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarfecha_finalDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finalDetaFormaPago() {
		return this.resaltarfecha_finalDetaFormaPago;
	}

	public void setResaltarfecha_finalDetaFormaPago(Border borderResaltar) {
		this.resaltarfecha_finalDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarfecha_finalDetaFormaPago() {
		return this.mostrarfecha_finalDetaFormaPago;
	}

	public void setMostrarfecha_finalDetaFormaPago(Boolean mostrarfecha_finalDetaFormaPago) {
		this.mostrarfecha_finalDetaFormaPago= mostrarfecha_finalDetaFormaPago;
	}

	public Boolean getActivarfecha_finalDetaFormaPago() {
		return this.activarfecha_finalDetaFormaPago;
	}

	public void setActivarfecha_finalDetaFormaPago(Boolean activarfecha_finalDetaFormaPago) {
		this.activarfecha_finalDetaFormaPago= activarfecha_finalDetaFormaPago;
	}

	public Border setResaltarporcentajeDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarporcentajeDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeDetaFormaPago() {
		return this.resaltarporcentajeDetaFormaPago;
	}

	public void setResaltarporcentajeDetaFormaPago(Border borderResaltar) {
		this.resaltarporcentajeDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarporcentajeDetaFormaPago() {
		return this.mostrarporcentajeDetaFormaPago;
	}

	public void setMostrarporcentajeDetaFormaPago(Boolean mostrarporcentajeDetaFormaPago) {
		this.mostrarporcentajeDetaFormaPago= mostrarporcentajeDetaFormaPago;
	}

	public Boolean getActivarporcentajeDetaFormaPago() {
		return this.activarporcentajeDetaFormaPago;
	}

	public void setActivarporcentajeDetaFormaPago(Boolean activarporcentajeDetaFormaPago) {
		this.activarporcentajeDetaFormaPago= activarporcentajeDetaFormaPago;
	}

	public Border setResaltarretencionDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarretencionDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionDetaFormaPago() {
		return this.resaltarretencionDetaFormaPago;
	}

	public void setResaltarretencionDetaFormaPago(Border borderResaltar) {
		this.resaltarretencionDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarretencionDetaFormaPago() {
		return this.mostrarretencionDetaFormaPago;
	}

	public void setMostrarretencionDetaFormaPago(Boolean mostrarretencionDetaFormaPago) {
		this.mostrarretencionDetaFormaPago= mostrarretencionDetaFormaPago;
	}

	public Boolean getActivarretencionDetaFormaPago() {
		return this.activarretencionDetaFormaPago;
	}

	public void setActivarretencionDetaFormaPago(Boolean activarretencionDetaFormaPago) {
		this.activarretencionDetaFormaPago= activarretencionDetaFormaPago;
	}

	public Border setResaltarporcentaje_retencionDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarporcentaje_retencionDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_retencionDetaFormaPago() {
		return this.resaltarporcentaje_retencionDetaFormaPago;
	}

	public void setResaltarporcentaje_retencionDetaFormaPago(Border borderResaltar) {
		this.resaltarporcentaje_retencionDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarporcentaje_retencionDetaFormaPago() {
		return this.mostrarporcentaje_retencionDetaFormaPago;
	}

	public void setMostrarporcentaje_retencionDetaFormaPago(Boolean mostrarporcentaje_retencionDetaFormaPago) {
		this.mostrarporcentaje_retencionDetaFormaPago= mostrarporcentaje_retencionDetaFormaPago;
	}

	public Boolean getActivarporcentaje_retencionDetaFormaPago() {
		return this.activarporcentaje_retencionDetaFormaPago;
	}

	public void setActivarporcentaje_retencionDetaFormaPago(Boolean activarporcentaje_retencionDetaFormaPago) {
		this.activarporcentaje_retencionDetaFormaPago= activarporcentaje_retencionDetaFormaPago;
	}

	public Border setResaltarbase_retencionDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarbase_retencionDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbase_retencionDetaFormaPago() {
		return this.resaltarbase_retencionDetaFormaPago;
	}

	public void setResaltarbase_retencionDetaFormaPago(Border borderResaltar) {
		this.resaltarbase_retencionDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarbase_retencionDetaFormaPago() {
		return this.mostrarbase_retencionDetaFormaPago;
	}

	public void setMostrarbase_retencionDetaFormaPago(Boolean mostrarbase_retencionDetaFormaPago) {
		this.mostrarbase_retencionDetaFormaPago= mostrarbase_retencionDetaFormaPago;
	}

	public Boolean getActivarbase_retencionDetaFormaPago() {
		return this.activarbase_retencionDetaFormaPago;
	}

	public void setActivarbase_retencionDetaFormaPago(Boolean activarbase_retencionDetaFormaPago) {
		this.activarbase_retencionDetaFormaPago= activarbase_retencionDetaFormaPago;
	}

	public Border setResaltarvalor_retencionDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarvalor_retencionDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_retencionDetaFormaPago() {
		return this.resaltarvalor_retencionDetaFormaPago;
	}

	public void setResaltarvalor_retencionDetaFormaPago(Border borderResaltar) {
		this.resaltarvalor_retencionDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarvalor_retencionDetaFormaPago() {
		return this.mostrarvalor_retencionDetaFormaPago;
	}

	public void setMostrarvalor_retencionDetaFormaPago(Boolean mostrarvalor_retencionDetaFormaPago) {
		this.mostrarvalor_retencionDetaFormaPago= mostrarvalor_retencionDetaFormaPago;
	}

	public Boolean getActivarvalor_retencionDetaFormaPago() {
		return this.activarvalor_retencionDetaFormaPago;
	}

	public void setActivarvalor_retencionDetaFormaPago(Boolean activarvalor_retencionDetaFormaPago) {
		this.activarvalor_retencionDetaFormaPago= activarvalor_retencionDetaFormaPago;
	}

	public Border setResaltarnumero_retencionDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionDetaFormaPago() {
		return this.resaltarnumero_retencionDetaFormaPago;
	}

	public void setResaltarnumero_retencionDetaFormaPago(Border borderResaltar) {
		this.resaltarnumero_retencionDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionDetaFormaPago() {
		return this.mostrarnumero_retencionDetaFormaPago;
	}

	public void setMostrarnumero_retencionDetaFormaPago(Boolean mostrarnumero_retencionDetaFormaPago) {
		this.mostrarnumero_retencionDetaFormaPago= mostrarnumero_retencionDetaFormaPago;
	}

	public Boolean getActivarnumero_retencionDetaFormaPago() {
		return this.activarnumero_retencionDetaFormaPago;
	}

	public void setActivarnumero_retencionDetaFormaPago(Boolean activarnumero_retencionDetaFormaPago) {
		this.activarnumero_retencionDetaFormaPago= activarnumero_retencionDetaFormaPago;
	}

	public Border setResaltarnumero_diasDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_diasDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_diasDetaFormaPago() {
		return this.resaltarnumero_diasDetaFormaPago;
	}

	public void setResaltarnumero_diasDetaFormaPago(Border borderResaltar) {
		this.resaltarnumero_diasDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_diasDetaFormaPago() {
		return this.mostrarnumero_diasDetaFormaPago;
	}

	public void setMostrarnumero_diasDetaFormaPago(Boolean mostrarnumero_diasDetaFormaPago) {
		this.mostrarnumero_diasDetaFormaPago= mostrarnumero_diasDetaFormaPago;
	}

	public Boolean getActivarnumero_diasDetaFormaPago() {
		return this.activarnumero_diasDetaFormaPago;
	}

	public void setActivarnumero_diasDetaFormaPago(Boolean activarnumero_diasDetaFormaPago) {
		this.activarnumero_diasDetaFormaPago= activarnumero_diasDetaFormaPago;
	}

	public Border setResaltarnumero_cuotaDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_cuotaDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuotaDetaFormaPago() {
		return this.resaltarnumero_cuotaDetaFormaPago;
	}

	public void setResaltarnumero_cuotaDetaFormaPago(Border borderResaltar) {
		this.resaltarnumero_cuotaDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_cuotaDetaFormaPago() {
		return this.mostrarnumero_cuotaDetaFormaPago;
	}

	public void setMostrarnumero_cuotaDetaFormaPago(Boolean mostrarnumero_cuotaDetaFormaPago) {
		this.mostrarnumero_cuotaDetaFormaPago= mostrarnumero_cuotaDetaFormaPago;
	}

	public Boolean getActivarnumero_cuotaDetaFormaPago() {
		return this.activarnumero_cuotaDetaFormaPago;
	}

	public void setActivarnumero_cuotaDetaFormaPago(Boolean activarnumero_cuotaDetaFormaPago) {
		this.activarnumero_cuotaDetaFormaPago= activarnumero_cuotaDetaFormaPago;
	}

	public Border setResaltardescripcionDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltardescripcionDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetaFormaPago() {
		return this.resaltardescripcionDetaFormaPago;
	}

	public void setResaltardescripcionDetaFormaPago(Border borderResaltar) {
		this.resaltardescripcionDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrardescripcionDetaFormaPago() {
		return this.mostrardescripcionDetaFormaPago;
	}

	public void setMostrardescripcionDetaFormaPago(Boolean mostrardescripcionDetaFormaPago) {
		this.mostrardescripcionDetaFormaPago= mostrardescripcionDetaFormaPago;
	}

	public Boolean getActivardescripcionDetaFormaPago() {
		return this.activardescripcionDetaFormaPago;
	}

	public void setActivardescripcionDetaFormaPago(Boolean activardescripcionDetaFormaPago) {
		this.activardescripcionDetaFormaPago= activardescripcionDetaFormaPago;
	}

	public Border setResaltarid_anioDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_anioDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetaFormaPago() {
		return this.resaltarid_anioDetaFormaPago;
	}

	public void setResaltarid_anioDetaFormaPago(Border borderResaltar) {
		this.resaltarid_anioDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_anioDetaFormaPago() {
		return this.mostrarid_anioDetaFormaPago;
	}

	public void setMostrarid_anioDetaFormaPago(Boolean mostrarid_anioDetaFormaPago) {
		this.mostrarid_anioDetaFormaPago= mostrarid_anioDetaFormaPago;
	}

	public Boolean getActivarid_anioDetaFormaPago() {
		return this.activarid_anioDetaFormaPago;
	}

	public void setActivarid_anioDetaFormaPago(Boolean activarid_anioDetaFormaPago) {
		this.activarid_anioDetaFormaPago= activarid_anioDetaFormaPago;
	}

	public Boolean getCargarid_anioDetaFormaPago() {
		return this.cargarid_anioDetaFormaPago;
	}

	public void setCargarid_anioDetaFormaPago(Boolean cargarid_anioDetaFormaPago) {
		this.cargarid_anioDetaFormaPago= cargarid_anioDetaFormaPago;
	}

	public Border setResaltarid_mesDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_mesDetaFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetaFormaPago() {
		return this.resaltarid_mesDetaFormaPago;
	}

	public void setResaltarid_mesDetaFormaPago(Border borderResaltar) {
		this.resaltarid_mesDetaFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_mesDetaFormaPago() {
		return this.mostrarid_mesDetaFormaPago;
	}

	public void setMostrarid_mesDetaFormaPago(Boolean mostrarid_mesDetaFormaPago) {
		this.mostrarid_mesDetaFormaPago= mostrarid_mesDetaFormaPago;
	}

	public Boolean getActivarid_mesDetaFormaPago() {
		return this.activarid_mesDetaFormaPago;
	}

	public void setActivarid_mesDetaFormaPago(Boolean activarid_mesDetaFormaPago) {
		this.activarid_mesDetaFormaPago= activarid_mesDetaFormaPago;
	}

	public Boolean getCargarid_mesDetaFormaPago() {
		return this.cargarid_mesDetaFormaPago;
	}

	public void setCargarid_mesDetaFormaPago(Boolean cargarid_mesDetaFormaPago) {
		this.cargarid_mesDetaFormaPago= cargarid_mesDetaFormaPago;
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
		
		
		this.setMostraridDetaFormaPago(esInicial);
		this.setMostrarid_empresaDetaFormaPago(esInicial);
		this.setMostrarid_sucursalDetaFormaPago(esInicial);
		this.setMostrarid_ejercicioDetaFormaPago(esInicial);
		this.setMostrarid_periodoDetaFormaPago(esInicial);
		this.setMostrarid_facturaDetaFormaPago(esInicial);
		this.setMostrarid_tipo_forma_pagoDetaFormaPago(esInicial);
		this.setMostrarid_tipo_deta_forma_pagoDetaFormaPago(esInicial);
		this.setMostrarid_deta_forma_pago_factuDetaFormaPago(esInicial);
		this.setMostrarid_cuenta_contableDetaFormaPago(esInicial);
		this.setMostrarid_tipo_retencionDetaFormaPago(esInicial);
		this.setMostrarvalorDetaFormaPago(esInicial);
		this.setMostrarfecha_inicialDetaFormaPago(esInicial);
		this.setMostrarfecha_finalDetaFormaPago(esInicial);
		this.setMostrarporcentajeDetaFormaPago(esInicial);
		this.setMostrarretencionDetaFormaPago(esInicial);
		this.setMostrarporcentaje_retencionDetaFormaPago(esInicial);
		this.setMostrarbase_retencionDetaFormaPago(esInicial);
		this.setMostrarvalor_retencionDetaFormaPago(esInicial);
		this.setMostrarnumero_retencionDetaFormaPago(esInicial);
		this.setMostrarnumero_diasDetaFormaPago(esInicial);
		this.setMostrarnumero_cuotaDetaFormaPago(esInicial);
		this.setMostrardescripcionDetaFormaPago(esInicial);
		this.setMostrarid_anioDetaFormaPago(esInicial);
		this.setMostrarid_mesDetaFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.ID)) {
				this.setMostraridDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO)) {
				this.setMostrarid_tipo_deta_forma_pagoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU)) {
				this.setMostrarid_deta_forma_pago_factuDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.FECHAINICIAL)) {
				this.setMostrarfecha_inicialDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.FECHAFINAL)) {
				this.setMostrarfecha_finalDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.RETENCION)) {
				this.setMostrarretencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setMostrarporcentaje_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.BASERETENCION)) {
				this.setMostrarbase_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.VALORRETENCION)) {
				this.setMostrarvalor_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setMostrarnumero_diasDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMEROCUOTA)) {
				this.setMostrarnumero_cuotaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetaFormaPago(esAsigna);
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
		
		
		this.setActivaridDetaFormaPago(esInicial);
		this.setActivarid_empresaDetaFormaPago(esInicial);
		this.setActivarid_sucursalDetaFormaPago(esInicial);
		this.setActivarid_ejercicioDetaFormaPago(esInicial);
		this.setActivarid_periodoDetaFormaPago(esInicial);
		this.setActivarid_facturaDetaFormaPago(esInicial);
		this.setActivarid_tipo_forma_pagoDetaFormaPago(esInicial);
		this.setActivarid_tipo_deta_forma_pagoDetaFormaPago(esInicial);
		this.setActivarid_deta_forma_pago_factuDetaFormaPago(esInicial);
		this.setActivarid_cuenta_contableDetaFormaPago(esInicial);
		this.setActivarid_tipo_retencionDetaFormaPago(esInicial);
		this.setActivarvalorDetaFormaPago(esInicial);
		this.setActivarfecha_inicialDetaFormaPago(esInicial);
		this.setActivarfecha_finalDetaFormaPago(esInicial);
		this.setActivarporcentajeDetaFormaPago(esInicial);
		this.setActivarretencionDetaFormaPago(esInicial);
		this.setActivarporcentaje_retencionDetaFormaPago(esInicial);
		this.setActivarbase_retencionDetaFormaPago(esInicial);
		this.setActivarvalor_retencionDetaFormaPago(esInicial);
		this.setActivarnumero_retencionDetaFormaPago(esInicial);
		this.setActivarnumero_diasDetaFormaPago(esInicial);
		this.setActivarnumero_cuotaDetaFormaPago(esInicial);
		this.setActivardescripcionDetaFormaPago(esInicial);
		this.setActivarid_anioDetaFormaPago(esInicial);
		this.setActivarid_mesDetaFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.ID)) {
				this.setActivaridDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO)) {
				this.setActivarid_tipo_deta_forma_pagoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU)) {
				this.setActivarid_deta_forma_pago_factuDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.VALOR)) {
				this.setActivarvalorDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.FECHAINICIAL)) {
				this.setActivarfecha_inicialDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.FECHAFINAL)) {
				this.setActivarfecha_finalDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.RETENCION)) {
				this.setActivarretencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setActivarporcentaje_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.BASERETENCION)) {
				this.setActivarbase_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.VALORRETENCION)) {
				this.setActivarvalor_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setActivarnumero_diasDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMEROCUOTA)) {
				this.setActivarnumero_cuotaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetaFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetaFormaPago(esInicial);
		this.setResaltarid_empresaDetaFormaPago(esInicial);
		this.setResaltarid_sucursalDetaFormaPago(esInicial);
		this.setResaltarid_ejercicioDetaFormaPago(esInicial);
		this.setResaltarid_periodoDetaFormaPago(esInicial);
		this.setResaltarid_facturaDetaFormaPago(esInicial);
		this.setResaltarid_tipo_forma_pagoDetaFormaPago(esInicial);
		this.setResaltarid_tipo_deta_forma_pagoDetaFormaPago(esInicial);
		this.setResaltarid_deta_forma_pago_factuDetaFormaPago(esInicial);
		this.setResaltarid_cuenta_contableDetaFormaPago(esInicial);
		this.setResaltarid_tipo_retencionDetaFormaPago(esInicial);
		this.setResaltarvalorDetaFormaPago(esInicial);
		this.setResaltarfecha_inicialDetaFormaPago(esInicial);
		this.setResaltarfecha_finalDetaFormaPago(esInicial);
		this.setResaltarporcentajeDetaFormaPago(esInicial);
		this.setResaltarretencionDetaFormaPago(esInicial);
		this.setResaltarporcentaje_retencionDetaFormaPago(esInicial);
		this.setResaltarbase_retencionDetaFormaPago(esInicial);
		this.setResaltarvalor_retencionDetaFormaPago(esInicial);
		this.setResaltarnumero_retencionDetaFormaPago(esInicial);
		this.setResaltarnumero_diasDetaFormaPago(esInicial);
		this.setResaltarnumero_cuotaDetaFormaPago(esInicial);
		this.setResaltardescripcionDetaFormaPago(esInicial);
		this.setResaltarid_anioDetaFormaPago(esInicial);
		this.setResaltarid_mesDetaFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO)) {
				this.setResaltarid_tipo_deta_forma_pagoDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU)) {
				this.setResaltarid_deta_forma_pago_factuDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.FECHAINICIAL)) {
				this.setResaltarfecha_inicialDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.FECHAFINAL)) {
				this.setResaltarfecha_finalDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.RETENCION)) {
				this.setResaltarretencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setResaltarporcentaje_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.BASERETENCION)) {
				this.setResaltarbase_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.VALORRETENCION)) {
				this.setResaltarvalor_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMERODIAS)) {
				this.setResaltarnumero_diasDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.NUMEROCUOTA)) {
				this.setResaltarnumero_cuotaDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetaFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetaFormaPagoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetaFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBancoFormaPagoDetaFormaPago=null;

	public Border getResaltarBancoFormaPagoDetaFormaPago() {
		return this.resaltarBancoFormaPagoDetaFormaPago;
	}

	public void setResaltarBancoFormaPagoDetaFormaPago(Border borderResaltarBancoFormaPago) {
		if(borderResaltarBancoFormaPago!=null) {
			this.resaltarBancoFormaPagoDetaFormaPago= borderResaltarBancoFormaPago;
		}
	}

	public Border setResaltarBancoFormaPagoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltarBancoFormaPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detaformapagoBeanSwingJInternalFrame.jTtoolBarDetaFormaPago.setBorder(borderResaltarBancoFormaPago);
			
		this.resaltarBancoFormaPagoDetaFormaPago= borderResaltarBancoFormaPago;

		 return borderResaltarBancoFormaPago;
	}



	public Boolean mostrarBancoFormaPagoDetaFormaPago=true;

	public Boolean getMostrarBancoFormaPagoDetaFormaPago() {
		return this.mostrarBancoFormaPagoDetaFormaPago;
	}

	public void setMostrarBancoFormaPagoDetaFormaPago(Boolean visibilidadResaltarBancoFormaPago) {
		this.mostrarBancoFormaPagoDetaFormaPago= visibilidadResaltarBancoFormaPago;
	}



	public Boolean activarBancoFormaPagoDetaFormaPago=true;

	public Boolean gethabilitarResaltarBancoFormaPagoDetaFormaPago() {
		return this.activarBancoFormaPagoDetaFormaPago;
	}

	public void setActivarBancoFormaPagoDetaFormaPago(Boolean habilitarResaltarBancoFormaPago) {
		this.activarBancoFormaPagoDetaFormaPago= habilitarResaltarBancoFormaPago;
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

		this.setMostrarBancoFormaPagoDetaFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoFormaPago.class)) {
				this.setMostrarBancoFormaPagoDetaFormaPago(esAsigna);
				continue;
			}
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

		this.setActivarBancoFormaPagoDetaFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoFormaPago.class)) {
				this.setActivarBancoFormaPagoDetaFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBancoFormaPagoDetaFormaPago(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(BancoFormaPago.class)) {
				this.setResaltarBancoFormaPagoDetaFormaPago(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCuentaContableDetaFormaPago=true;

	public Boolean getMostrarFK_IdCuentaContableDetaFormaPago() {
		return this.mostrarFK_IdCuentaContableDetaFormaPago;
	}

	public void setMostrarFK_IdCuentaContableDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetaFormaPagoFactuDetaFormaPago=true;

	public Boolean getMostrarFK_IdDetaFormaPagoFactuDetaFormaPago() {
		return this.mostrarFK_IdDetaFormaPagoFactuDetaFormaPago;
	}

	public void setMostrarFK_IdDetaFormaPagoFactuDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetaFormaPagoFactuDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetaFormaPago=true;

	public Boolean getMostrarFK_IdEjercicioDetaFormaPago() {
		return this.mostrarFK_IdEjercicioDetaFormaPago;
	}

	public void setMostrarFK_IdEjercicioDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetaFormaPago=true;

	public Boolean getMostrarFK_IdEmpresaDetaFormaPago() {
		return this.mostrarFK_IdEmpresaDetaFormaPago;
	}

	public void setMostrarFK_IdEmpresaDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaDetaFormaPago=true;

	public Boolean getMostrarFK_IdFacturaDetaFormaPago() {
		return this.mostrarFK_IdFacturaDetaFormaPago;
	}

	public void setMostrarFK_IdFacturaDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetaFormaPago=true;

	public Boolean getMostrarFK_IdPeriodoDetaFormaPago() {
		return this.mostrarFK_IdPeriodoDetaFormaPago;
	}

	public void setMostrarFK_IdPeriodoDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetaFormaPago=true;

	public Boolean getMostrarFK_IdSucursalDetaFormaPago() {
		return this.mostrarFK_IdSucursalDetaFormaPago;
	}

	public void setMostrarFK_IdSucursalDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDetaFormaPagoDetaFormaPago=true;

	public Boolean getMostrarFK_IdTipoDetaFormaPagoDetaFormaPago() {
		return this.mostrarFK_IdTipoDetaFormaPagoDetaFormaPago;
	}

	public void setMostrarFK_IdTipoDetaFormaPagoDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDetaFormaPagoDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoDetaFormaPago=true;

	public Boolean getMostrarFK_IdTipoFormaPagoDetaFormaPago() {
		return this.mostrarFK_IdTipoFormaPagoDetaFormaPago;
	}

	public void setMostrarFK_IdTipoFormaPagoDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoDetaFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionDetaFormaPago=true;

	public Boolean getMostrarFK_IdTipoRetencionDetaFormaPago() {
		return this.mostrarFK_IdTipoRetencionDetaFormaPago;
	}

	public void setMostrarFK_IdTipoRetencionDetaFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionDetaFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableDetaFormaPago=true;

	public Boolean getActivarFK_IdCuentaContableDetaFormaPago() {
		return this.activarFK_IdCuentaContableDetaFormaPago;
	}

	public void setActivarFK_IdCuentaContableDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdDetaFormaPagoFactuDetaFormaPago=true;

	public Boolean getActivarFK_IdDetaFormaPagoFactuDetaFormaPago() {
		return this.activarFK_IdDetaFormaPagoFactuDetaFormaPago;
	}

	public void setActivarFK_IdDetaFormaPagoFactuDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdDetaFormaPagoFactuDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetaFormaPago=true;

	public Boolean getActivarFK_IdEjercicioDetaFormaPago() {
		return this.activarFK_IdEjercicioDetaFormaPago;
	}

	public void setActivarFK_IdEjercicioDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetaFormaPago=true;

	public Boolean getActivarFK_IdEmpresaDetaFormaPago() {
		return this.activarFK_IdEmpresaDetaFormaPago;
	}

	public void setActivarFK_IdEmpresaDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaDetaFormaPago=true;

	public Boolean getActivarFK_IdFacturaDetaFormaPago() {
		return this.activarFK_IdFacturaDetaFormaPago;
	}

	public void setActivarFK_IdFacturaDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetaFormaPago=true;

	public Boolean getActivarFK_IdPeriodoDetaFormaPago() {
		return this.activarFK_IdPeriodoDetaFormaPago;
	}

	public void setActivarFK_IdPeriodoDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetaFormaPago=true;

	public Boolean getActivarFK_IdSucursalDetaFormaPago() {
		return this.activarFK_IdSucursalDetaFormaPago;
	}

	public void setActivarFK_IdSucursalDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDetaFormaPagoDetaFormaPago=true;

	public Boolean getActivarFK_IdTipoDetaFormaPagoDetaFormaPago() {
		return this.activarFK_IdTipoDetaFormaPagoDetaFormaPago;
	}

	public void setActivarFK_IdTipoDetaFormaPagoDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDetaFormaPagoDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoDetaFormaPago=true;

	public Boolean getActivarFK_IdTipoFormaPagoDetaFormaPago() {
		return this.activarFK_IdTipoFormaPagoDetaFormaPago;
	}

	public void setActivarFK_IdTipoFormaPagoDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoDetaFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionDetaFormaPago=true;

	public Boolean getActivarFK_IdTipoRetencionDetaFormaPago() {
		return this.activarFK_IdTipoRetencionDetaFormaPago;
	}

	public void setActivarFK_IdTipoRetencionDetaFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionDetaFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableDetaFormaPago=null;

	public Border getResaltarFK_IdCuentaContableDetaFormaPago() {
		return this.resaltarFK_IdCuentaContableDetaFormaPago;
	}

	public void setResaltarFK_IdCuentaContableDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdDetaFormaPagoFactuDetaFormaPago=null;

	public Border getResaltarFK_IdDetaFormaPagoFactuDetaFormaPago() {
		return this.resaltarFK_IdDetaFormaPagoFactuDetaFormaPago;
	}

	public void setResaltarFK_IdDetaFormaPagoFactuDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdDetaFormaPagoFactuDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdDetaFormaPagoFactuDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetaFormaPagoFactuDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetaFormaPago=null;

	public Border getResaltarFK_IdEjercicioDetaFormaPago() {
		return this.resaltarFK_IdEjercicioDetaFormaPago;
	}

	public void setResaltarFK_IdEjercicioDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetaFormaPago=null;

	public Border getResaltarFK_IdEmpresaDetaFormaPago() {
		return this.resaltarFK_IdEmpresaDetaFormaPago;
	}

	public void setResaltarFK_IdEmpresaDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdFacturaDetaFormaPago=null;

	public Border getResaltarFK_IdFacturaDetaFormaPago() {
		return this.resaltarFK_IdFacturaDetaFormaPago;
	}

	public void setResaltarFK_IdFacturaDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdFacturaDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdFacturaDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetaFormaPago=null;

	public Border getResaltarFK_IdPeriodoDetaFormaPago() {
		return this.resaltarFK_IdPeriodoDetaFormaPago;
	}

	public void setResaltarFK_IdPeriodoDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetaFormaPago=null;

	public Border getResaltarFK_IdSucursalDetaFormaPago() {
		return this.resaltarFK_IdSucursalDetaFormaPago;
	}

	public void setResaltarFK_IdSucursalDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoDetaFormaPagoDetaFormaPago=null;

	public Border getResaltarFK_IdTipoDetaFormaPagoDetaFormaPago() {
		return this.resaltarFK_IdTipoDetaFormaPagoDetaFormaPago;
	}

	public void setResaltarFK_IdTipoDetaFormaPagoDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoDetaFormaPagoDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoDetaFormaPagoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDetaFormaPagoDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoDetaFormaPago=null;

	public Border getResaltarFK_IdTipoFormaPagoDetaFormaPago() {
		return this.resaltarFK_IdTipoFormaPagoDetaFormaPago;
	}

	public void setResaltarFK_IdTipoFormaPagoDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoDetaFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionDetaFormaPago=null;

	public Border getResaltarFK_IdTipoRetencionDetaFormaPago() {
		return this.resaltarFK_IdTipoRetencionDetaFormaPago;
	}

	public void setResaltarFK_IdTipoRetencionDetaFormaPago(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionDetaFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionDetaFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*DetaFormaPagoBeanSwingJInternalFrame detaformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionDetaFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}