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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.TarjetaCreditoConstantesFunciones;
import com.bydan.erp.puntoventa.util.TarjetaCreditoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TarjetaCreditoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TarjetaCreditoConstantesFunciones extends TarjetaCreditoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TarjetaCredito";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TarjetaCredito"+TarjetaCreditoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TarjetaCreditoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TarjetaCreditoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TarjetaCreditoConstantesFunciones.SCHEMA+"_"+TarjetaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TarjetaCreditoConstantesFunciones.SCHEMA+"_"+TarjetaCreditoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TarjetaCreditoConstantesFunciones.SCHEMA+"_"+TarjetaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TarjetaCreditoConstantesFunciones.SCHEMA+"_"+TarjetaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TarjetaCreditoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TarjetaCreditoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TarjetaCreditoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TarjetaCreditoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tarjeta Creditos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tarjeta Credito";
	public static final String SCLASSWEBTITULO_LOWER="Tarjeta Credito";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TarjetaCredito";
	public static final String OBJECTNAME="tarjetacredito";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tarjeta_credito";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tarjetacredito from "+TarjetaCreditoConstantesFunciones.SPERSISTENCENAME+" tarjetacredito";
	public static String QUERYSELECTNATIVE="select "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".version_row,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_empresa,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_sucursal,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_banco,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".codigo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".nombre,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".nombre_corto,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".digito_valido,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".digito_tarjeta,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".comision,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".interes,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".monto_minimo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".porcentaje_retencion,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".comision_retencion,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".es_retencion_redondeo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".es_pago_banco_redondeo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".es_comision_redondeo,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_tipo_retencion,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_tipo_retencion_iva,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_cuenta_contable_comision,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_formula_pago_banco,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_cuenta_contable_diferencia,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_formula_retencion,"+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME+".id_formula_comision from "+TarjetaCreditoConstantesFunciones.SCHEMA+"."+TarjetaCreditoConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TarjetaCreditoConstantesFuncionesAdditional tarjetacreditoConstantesFuncionesAdditional=null;
	
	public TarjetaCreditoConstantesFuncionesAdditional getTarjetaCreditoConstantesFuncionesAdditional() {
		return this.tarjetacreditoConstantesFuncionesAdditional;
	}
	
	public void setTarjetaCreditoConstantesFuncionesAdditional(TarjetaCreditoConstantesFuncionesAdditional tarjetacreditoConstantesFuncionesAdditional) {
		try {
			this.tarjetacreditoConstantesFuncionesAdditional=tarjetacreditoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBANCO= "id_banco";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBRECORTO= "nombre_corto";
    public static final String DIGITOVALIDO= "digito_valido";
    public static final String DIGITOTARJETA= "digito_tarjeta";
    public static final String COMISION= "comision";
    public static final String INTERES= "interes";
    public static final String MONTOMINIMO= "monto_minimo";
    public static final String PORCENTAJERETENCION= "porcentaje_retencion";
    public static final String COMISIONRETENCION= "comision_retencion";
    public static final String ESRETENCIONREDONDEO= "es_retencion_redondeo";
    public static final String ESPAGOBANCOREDONDEO= "es_pago_banco_redondeo";
    public static final String ESCOMISIONREDONDEO= "es_comision_redondeo";
    public static final String IDTIPORETENCION= "id_tipo_retencion";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDTIPORETENCIONIVA= "id_tipo_retencion_iva";
    public static final String IDCUENTACONTABLECOMISION= "id_cuenta_contable_comision";
    public static final String IDFORMULAPAGOBANCO= "id_formula_pago_banco";
    public static final String IDCUENTACONTABLEDIFERENCIA= "id_cuenta_contable_diferencia";
    public static final String IDFORMULARETENCION= "id_formula_retencion";
    public static final String IDFORMULACOMISION= "id_formula_comision";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBRECORTO= "Nombre Corto";
		public static final String LABEL_NOMBRECORTO_LOWER= "Nombre Corto";
    	public static final String LABEL_DIGITOVALIDO= "Digito Valido";
		public static final String LABEL_DIGITOVALIDO_LOWER= "Digito Valido";
    	public static final String LABEL_DIGITOTARJETA= "Digito Tarjeta";
		public static final String LABEL_DIGITOTARJETA_LOWER= "Digito Tarjeta";
    	public static final String LABEL_COMISION= "Comision";
		public static final String LABEL_COMISION_LOWER= "Comision";
    	public static final String LABEL_INTERES= "Interes";
		public static final String LABEL_INTERES_LOWER= "Interes";
    	public static final String LABEL_MONTOMINIMO= "Monto Minimo";
		public static final String LABEL_MONTOMINIMO_LOWER= "Monto Minimo";
    	public static final String LABEL_PORCENTAJERETENCION= "% Retencion";
		public static final String LABEL_PORCENTAJERETENCION_LOWER= "Porcentaje Retencion";
    	public static final String LABEL_COMISIONRETENCION= "Comision Retencion";
		public static final String LABEL_COMISIONRETENCION_LOWER= "Comision Retencion";
    	public static final String LABEL_ESRETENCIONREDONDEO= "Retencion Redondeo";
		public static final String LABEL_ESRETENCIONREDONDEO_LOWER= "Es Retencion Redondeo";
    	public static final String LABEL_ESPAGOBANCOREDONDEO= "Pago Banco Redondeo";
		public static final String LABEL_ESPAGOBANCOREDONDEO_LOWER= "Es Pago Banco Redondeo";
    	public static final String LABEL_ESCOMISIONREDONDEO= "Comision Redondeo";
		public static final String LABEL_ESCOMISIONREDONDEO_LOWER= "Es Comision Redondeo";
    	public static final String LABEL_IDTIPORETENCION= "Tipo Retencion";
		public static final String LABEL_IDTIPORETENCION_LOWER= "Tipo Retencion";
    	public static final String LABEL_IDCUENTACONTABLE= "Cta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDTIPORETENCIONIVA= "Tipo Retencion Iva";
		public static final String LABEL_IDTIPORETENCIONIVA_LOWER= "Tipo Retencion Iva";
    	public static final String LABEL_IDCUENTACONTABLECOMISION= "Cta Contable Comision";
		public static final String LABEL_IDCUENTACONTABLECOMISION_LOWER= "Cuenta Contable Comision";
    	public static final String LABEL_IDFORMULAPAGOBANCO= "Formula Pago Banco";
		public static final String LABEL_IDFORMULAPAGOBANCO_LOWER= "Formula Pago Banco";
    	public static final String LABEL_IDCUENTACONTABLEDIFERENCIA= "Cta Contable Diferencia";
		public static final String LABEL_IDCUENTACONTABLEDIFERENCIA_LOWER= "Cuenta Contable Diferencia";
    	public static final String LABEL_IDFORMULARETENCION= "Formula Retencion";
		public static final String LABEL_IDFORMULARETENCION_LOWER= "Formula Retencion";
    	public static final String LABEL_IDFORMULACOMISION= "Formula Comision";
		public static final String LABEL_IDFORMULACOMISION_LOWER= "Formula Comision";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CORTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CORTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getTarjetaCreditoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDBANCO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.CODIGO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.NOMBRE)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.NOMBRECORTO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_NOMBRECORTO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.DIGITOVALIDO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_DIGITOVALIDO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.DIGITOTARJETA)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_DIGITOTARJETA;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.COMISION)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_COMISION;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.INTERES)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_INTERES;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.MONTOMINIMO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_MONTOMINIMO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_PORCENTAJERETENCION;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.COMISIONRETENCION)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_COMISIONRETENCION;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_ESRETENCIONREDONDEO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_ESPAGOBANCOREDONDEO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_ESCOMISIONREDONDEO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDTIPORETENCION)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCION;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCIONIVA;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLECOMISION;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDFORMULAPAGOBANCO;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLEDIFERENCIA;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDFORMULARETENCION)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDFORMULARETENCION;}
		if(sNombreColumna.equals(TarjetaCreditoConstantesFunciones.IDFORMULACOMISION)) {sLabelColumna=TarjetaCreditoConstantesFunciones.LABEL_IDFORMULACOMISION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_retencion_redondeoDescripcion(TarjetaCredito tarjetacredito) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tarjetacredito.getes_retencion_redondeo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_retencion_redondeoHtmlDescripcion(TarjetaCredito tarjetacredito) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tarjetacredito.getId(),tarjetacredito.getes_retencion_redondeo());

		return sDescripcion;
	}	
		
	public static String getes_pago_banco_redondeoDescripcion(TarjetaCredito tarjetacredito) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tarjetacredito.getes_pago_banco_redondeo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_pago_banco_redondeoHtmlDescripcion(TarjetaCredito tarjetacredito) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tarjetacredito.getId(),tarjetacredito.getes_pago_banco_redondeo());

		return sDescripcion;
	}	
		
	public static String getes_comision_redondeoDescripcion(TarjetaCredito tarjetacredito) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tarjetacredito.getes_comision_redondeo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_comision_redondeoHtmlDescripcion(TarjetaCredito tarjetacredito) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tarjetacredito.getId(),tarjetacredito.getes_comision_redondeo());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
	
	public static String getTarjetaCreditoDescripcion(TarjetaCredito tarjetacredito) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tarjetacredito !=null/* && tarjetacredito.getId()!=0*/) {
			sDescripcion=tarjetacredito.getcodigo();//tarjetacreditotarjetacredito.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTarjetaCreditoDescripcionDetallado(TarjetaCredito tarjetacredito) {
		String sDescripcion="";
			
		sDescripcion+=TarjetaCreditoConstantesFunciones.ID+"=";
		sDescripcion+=tarjetacredito.getId().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tarjetacredito.getVersionRow().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tarjetacredito.getid_empresa().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tarjetacredito.getid_sucursal().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDBANCO+"=";
		sDescripcion+=tarjetacredito.getid_banco().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tarjetacredito.getcodigo()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tarjetacredito.getnombre()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.NOMBRECORTO+"=";
		sDescripcion+=tarjetacredito.getnombre_corto()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.DIGITOVALIDO+"=";
		sDescripcion+=tarjetacredito.getdigito_valido().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.DIGITOTARJETA+"=";
		sDescripcion+=tarjetacredito.getdigito_tarjeta().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.COMISION+"=";
		sDescripcion+=tarjetacredito.getcomision().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.INTERES+"=";
		sDescripcion+=tarjetacredito.getinteres().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.MONTOMINIMO+"=";
		sDescripcion+=tarjetacredito.getmonto_minimo().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION+"=";
		sDescripcion+=tarjetacredito.getporcentaje_retencion().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.COMISIONRETENCION+"=";
		sDescripcion+=tarjetacredito.getcomision_retencion().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO+"=";
		sDescripcion+=tarjetacredito.getes_retencion_redondeo().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO+"=";
		sDescripcion+=tarjetacredito.getes_pago_banco_redondeo().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO+"=";
		sDescripcion+=tarjetacredito.getes_comision_redondeo().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDTIPORETENCION+"=";
		sDescripcion+=tarjetacredito.getid_tipo_retencion().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=tarjetacredito.getid_cuenta_contable().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA+"=";
		sDescripcion+=tarjetacredito.getid_tipo_retencion_iva().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION+"=";
		sDescripcion+=tarjetacredito.getid_cuenta_contable_comision().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO+"=";
		sDescripcion+=tarjetacredito.getid_formula_pago_banco().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA+"=";
		sDescripcion+=tarjetacredito.getid_cuenta_contable_diferencia().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDFORMULARETENCION+"=";
		sDescripcion+=tarjetacredito.getid_formula_retencion().toString()+",";
		sDescripcion+=TarjetaCreditoConstantesFunciones.IDFORMULACOMISION+"=";
		sDescripcion+=tarjetacredito.getid_formula_comision().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTarjetaCreditoDescripcion(TarjetaCredito tarjetacredito,String sValor) throws Exception {			
		if(tarjetacredito !=null) {
			tarjetacredito.setcodigo(sValor);;//tarjetacreditotarjetacredito.getcodigo().trim();
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

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getTipoRetencionIvaDescripcion(TipoRetencionIva tiporetencioniva) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiporetencioniva!=null/*&&tiporetencioniva.getId()>0*/) {
			sDescripcion=TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(tiporetencioniva);
		}

		return sDescripcion;
	}

	public static String getCuentaContableComisionDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getFormulaPagoBancoDescripcion(Formula formula) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formula!=null/*&&formula.getId()>0*/) {
			sDescripcion=FormulaConstantesFunciones.getFormulaDescripcion(formula);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDiferenciaDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getFormulaRetencionDescripcion(Formula formula) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formula!=null/*&&formula.getId()>0*/) {
			sDescripcion=FormulaConstantesFunciones.getFormulaDescripcion(formula);
		}

		return sDescripcion;
	}

	public static String getFormulaComisionDescripcion(Formula formula) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formula!=null/*&&formula.getId()>0*/) {
			sDescripcion=FormulaConstantesFunciones.getFormulaDescripcion(formula);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cta Contable";
		} else if(sNombreIndice.equals("FK_IdCuentaContableComision")) {
			sNombreIndice="Tipo=  Por Cta Contable Comision";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDiferencia")) {
			sNombreIndice="Tipo=  Por Cta Contable Diferencia";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormulaComision")) {
			sNombreIndice="Tipo=  Por Formula Comision";
		} else if(sNombreIndice.equals("FK_IdFormulaPagoBanco")) {
			sNombreIndice="Tipo=  Por Formula Pago Banco";
		} else if(sNombreIndice.equals("FK_IdFormulaRetencion")) {
			sNombreIndice="Tipo=  Por Formula Retencion";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoRetencion")) {
			sNombreIndice="Tipo=  Por Tipo Retencion";
		} else if(sNombreIndice.equals("FK_IdTipoRetencionIva")) {
			sNombreIndice="Tipo=  Por Tipo Retencion Iva";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableComision(Long id_cuenta_contable_comision) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_comision!=null) {sDetalleIndice+=" Codigo Unico De Cta Contable Comision="+id_cuenta_contable_comision.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDiferencia(Long id_cuenta_contable_diferencia) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_diferencia!=null) {sDetalleIndice+=" Codigo Unico De Cta Contable Diferencia="+id_cuenta_contable_diferencia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormulaComision(Long id_formula_comision) {
		String sDetalleIndice=" Parametros->";
		if(id_formula_comision!=null) {sDetalleIndice+=" Codigo Unico De Formula Comision="+id_formula_comision.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormulaPagoBanco(Long id_formula_pago_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_formula_pago_banco!=null) {sDetalleIndice+=" Codigo Unico De Formula Pago Banco="+id_formula_pago_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormulaRetencion(Long id_formula_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_formula_retencion!=null) {sDetalleIndice+=" Codigo Unico De Formula Retencion="+id_formula_retencion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencion(Long id_tipo_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion="+id_tipo_retencion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoRetencionIva(Long id_tipo_retencion_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_retencion_iva!=null) {sDetalleIndice+=" Codigo Unico De Tipo Retencion Iva="+id_tipo_retencion_iva.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTarjetaCredito(TarjetaCredito tarjetacredito,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tarjetacredito.setcodigo(tarjetacredito.getcodigo().trim());
		tarjetacredito.setnombre(tarjetacredito.getnombre().trim());
		tarjetacredito.setnombre_corto(tarjetacredito.getnombre_corto().trim());
	}
	
	public static void quitarEspaciosTarjetaCreditos(List<TarjetaCredito> tarjetacreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TarjetaCredito tarjetacredito: tarjetacreditos) {
			tarjetacredito.setcodigo(tarjetacredito.getcodigo().trim());
			tarjetacredito.setnombre(tarjetacredito.getnombre().trim());
			tarjetacredito.setnombre_corto(tarjetacredito.getnombre_corto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTarjetaCredito(TarjetaCredito tarjetacredito,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tarjetacredito.getConCambioAuxiliar()) {
			tarjetacredito.setIsDeleted(tarjetacredito.getIsDeletedAuxiliar());	
			tarjetacredito.setIsNew(tarjetacredito.getIsNewAuxiliar());	
			tarjetacredito.setIsChanged(tarjetacredito.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tarjetacredito.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tarjetacredito.setIsDeletedAuxiliar(false);	
			tarjetacredito.setIsNewAuxiliar(false);	
			tarjetacredito.setIsChangedAuxiliar(false);
			
			tarjetacredito.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTarjetaCreditos(List<TarjetaCredito> tarjetacreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TarjetaCredito tarjetacredito : tarjetacreditos) {
			if(conAsignarBase && tarjetacredito.getConCambioAuxiliar()) {
				tarjetacredito.setIsDeleted(tarjetacredito.getIsDeletedAuxiliar());	
				tarjetacredito.setIsNew(tarjetacredito.getIsNewAuxiliar());	
				tarjetacredito.setIsChanged(tarjetacredito.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tarjetacredito.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tarjetacredito.setIsDeletedAuxiliar(false);	
				tarjetacredito.setIsNewAuxiliar(false);	
				tarjetacredito.setIsChangedAuxiliar(false);
				
				tarjetacredito.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTarjetaCredito(TarjetaCredito tarjetacredito,Boolean conEnteros) throws Exception  {
		tarjetacredito.setcomision(0.0);
		tarjetacredito.setinteres(0.0);
		tarjetacredito.setmonto_minimo(0.0);
		tarjetacredito.setporcentaje_retencion(0.0);
		tarjetacredito.setcomision_retencion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			tarjetacredito.setdigito_valido(0);
			tarjetacredito.setdigito_tarjeta(0);
		}
	}		
	
	public static void InicializarValoresTarjetaCreditos(List<TarjetaCredito> tarjetacreditos,Boolean conEnteros) throws Exception  {
		
		for(TarjetaCredito tarjetacredito: tarjetacreditos) {
			tarjetacredito.setcomision(0.0);
			tarjetacredito.setinteres(0.0);
			tarjetacredito.setmonto_minimo(0.0);
			tarjetacredito.setporcentaje_retencion(0.0);
			tarjetacredito.setcomision_retencion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				tarjetacredito.setdigito_valido(0);
				tarjetacredito.setdigito_tarjeta(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaTarjetaCredito(List<TarjetaCredito> tarjetacreditos,TarjetaCredito tarjetacreditoAux) throws Exception  {
		TarjetaCreditoConstantesFunciones.InicializarValoresTarjetaCredito(tarjetacreditoAux,true);
		
		for(TarjetaCredito tarjetacredito: tarjetacreditos) {
			if(tarjetacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tarjetacreditoAux.setdigito_valido(tarjetacreditoAux.getdigito_valido()+tarjetacredito.getdigito_valido());			
			tarjetacreditoAux.setdigito_tarjeta(tarjetacreditoAux.getdigito_tarjeta()+tarjetacredito.getdigito_tarjeta());			
			tarjetacreditoAux.setcomision(tarjetacreditoAux.getcomision()+tarjetacredito.getcomision());			
			tarjetacreditoAux.setinteres(tarjetacreditoAux.getinteres()+tarjetacredito.getinteres());			
			tarjetacreditoAux.setmonto_minimo(tarjetacreditoAux.getmonto_minimo()+tarjetacredito.getmonto_minimo());			
			tarjetacreditoAux.setporcentaje_retencion(tarjetacreditoAux.getporcentaje_retencion()+tarjetacredito.getporcentaje_retencion());			
			tarjetacreditoAux.setcomision_retencion(tarjetacreditoAux.getcomision_retencion()+tarjetacredito.getcomision_retencion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TarjetaCreditoConstantesFunciones.getArrayColumnasGlobalesTarjetaCredito(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetaCredito(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TarjetaCreditoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TarjetaCreditoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TarjetaCreditoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TarjetaCreditoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTarjetaCredito(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TarjetaCredito> tarjetacreditos,TarjetaCredito tarjetacredito,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TarjetaCredito tarjetacreditoAux: tarjetacreditos) {
			if(tarjetacreditoAux!=null && tarjetacredito!=null) {
				if((tarjetacreditoAux.getId()==null && tarjetacredito.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tarjetacreditoAux.getId()!=null && tarjetacredito.getId()!=null){
					if(tarjetacreditoAux.getId().equals(tarjetacredito.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTarjetaCredito(List<TarjetaCredito> tarjetacreditos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double comisionTotal=0.0;
		Double interesTotal=0.0;
		Double monto_minimoTotal=0.0;
		Double porcentaje_retencionTotal=0.0;
		Double comision_retencionTotal=0.0;
	
		for(TarjetaCredito tarjetacredito: tarjetacreditos) {			
			if(tarjetacredito.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comisionTotal+=tarjetacredito.getcomision();
			interesTotal+=tarjetacredito.getinteres();
			monto_minimoTotal+=tarjetacredito.getmonto_minimo();
			porcentaje_retencionTotal+=tarjetacredito.getporcentaje_retencion();
			comision_retencionTotal+=tarjetacredito.getcomision_retencion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.COMISION);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_COMISION);
		datoGeneral.setdValorDouble(comisionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.INTERES);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_INTERES);
		datoGeneral.setdValorDouble(interesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.MONTOMINIMO);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_MONTOMINIMO);
		datoGeneral.setdValorDouble(monto_minimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_PORCENTAJERETENCION);
		datoGeneral.setdValorDouble(porcentaje_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoConstantesFunciones.COMISIONRETENCION);
		datoGeneral.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_COMISIONRETENCION);
		datoGeneral.setdValorDouble(comision_retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTarjetaCredito() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_ID, TarjetaCreditoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_VERSIONROW, TarjetaCreditoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDEMPRESA, TarjetaCreditoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDSUCURSAL, TarjetaCreditoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDBANCO, TarjetaCreditoConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_CODIGO, TarjetaCreditoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_NOMBRE, TarjetaCreditoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_NOMBRECORTO, TarjetaCreditoConstantesFunciones.NOMBRECORTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_DIGITOVALIDO, TarjetaCreditoConstantesFunciones.DIGITOVALIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_DIGITOTARJETA, TarjetaCreditoConstantesFunciones.DIGITOTARJETA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_COMISION, TarjetaCreditoConstantesFunciones.COMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_INTERES, TarjetaCreditoConstantesFunciones.INTERES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_MONTOMINIMO, TarjetaCreditoConstantesFunciones.MONTOMINIMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_PORCENTAJERETENCION, TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_COMISIONRETENCION, TarjetaCreditoConstantesFunciones.COMISIONRETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_ESRETENCIONREDONDEO, TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_ESPAGOBANCOREDONDEO, TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_ESCOMISIONREDONDEO, TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCION, TarjetaCreditoConstantesFunciones.IDTIPORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLE, TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCIONIVA, TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLECOMISION, TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDFORMULAPAGOBANCO, TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLEDIFERENCIA, TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDFORMULARETENCION, TarjetaCreditoConstantesFunciones.IDFORMULARETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoConstantesFunciones.LABEL_IDFORMULACOMISION, TarjetaCreditoConstantesFunciones.IDFORMULACOMISION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTarjetaCredito() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.NOMBRECORTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.DIGITOVALIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.DIGITOTARJETA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.COMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.INTERES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.MONTOMINIMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.COMISIONRETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDTIPORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDFORMULARETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoConstantesFunciones.IDFORMULACOMISION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCredito() throws Exception  {
		return TarjetaCreditoConstantesFunciones.getTiposSeleccionarTarjetaCredito(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCredito(Boolean conFk) throws Exception  {
		return TarjetaCreditoConstantesFunciones.getTiposSeleccionarTarjetaCredito(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCredito(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_NOMBRECORTO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_NOMBRECORTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_DIGITOVALIDO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_DIGITOVALIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_DIGITOTARJETA);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_DIGITOTARJETA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_COMISION);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_COMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_INTERES);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_INTERES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_MONTOMINIMO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_MONTOMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_PORCENTAJERETENCION);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_PORCENTAJERETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_COMISIONRETENCION);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_COMISIONRETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_ESRETENCIONREDONDEO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_ESRETENCIONREDONDEO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_ESPAGOBANCOREDONDEO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_ESPAGOBANCOREDONDEO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_ESCOMISIONREDONDEO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_ESCOMISIONREDONDEO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCION);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLECOMISION);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLECOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULAPAGOBANCO);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULAPAGOBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLEDIFERENCIA);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLEDIFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULARETENCION);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULARETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULACOMISION);
			reporte.setsDescripcion(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULACOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTarjetaCredito(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTarjetaCredito(TarjetaCredito tarjetacreditoAux) throws Exception {
		
			tarjetacreditoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tarjetacreditoAux.getEmpresa()));
			tarjetacreditoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tarjetacreditoAux.getSucursal()));
			tarjetacreditoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(tarjetacreditoAux.getBanco()));
			tarjetacreditoAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tarjetacreditoAux.getTipoRetencion()));
			tarjetacreditoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tarjetacreditoAux.getCuentaContable()));
			tarjetacreditoAux.settiporetencioniva_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(tarjetacreditoAux.getTipoRetencionIva()));
			tarjetacreditoAux.setcuentacontablecomision_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tarjetacreditoAux.getCuentaContableComision()));
			tarjetacreditoAux.setformulapagobanco_descripcion(FormulaConstantesFunciones.getFormulaDescripcion(tarjetacreditoAux.getFormulaPagoBanco()));
			tarjetacreditoAux.setcuentacontablediferencia_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tarjetacreditoAux.getCuentaContableDiferencia()));
			tarjetacreditoAux.setformularetencion_descripcion(FormulaConstantesFunciones.getFormulaDescripcion(tarjetacreditoAux.getFormulaRetencion()));
			tarjetacreditoAux.setformulacomision_descripcion(FormulaConstantesFunciones.getFormulaDescripcion(tarjetacreditoAux.getFormulaComision()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTarjetaCredito(List<TarjetaCredito> tarjetacreditosTemp) throws Exception {
		for(TarjetaCredito tarjetacreditoAux:tarjetacreditosTemp) {
			
			tarjetacreditoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tarjetacreditoAux.getEmpresa()));
			tarjetacreditoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tarjetacreditoAux.getSucursal()));
			tarjetacreditoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(tarjetacreditoAux.getBanco()));
			tarjetacreditoAux.settiporetencion_descripcion(TipoRetencionConstantesFunciones.getTipoRetencionDescripcion(tarjetacreditoAux.getTipoRetencion()));
			tarjetacreditoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tarjetacreditoAux.getCuentaContable()));
			tarjetacreditoAux.settiporetencioniva_descripcion(TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaDescripcion(tarjetacreditoAux.getTipoRetencionIva()));
			tarjetacreditoAux.setcuentacontablecomision_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tarjetacreditoAux.getCuentaContableComision()));
			tarjetacreditoAux.setformulapagobanco_descripcion(FormulaConstantesFunciones.getFormulaDescripcion(tarjetacreditoAux.getFormulaPagoBanco()));
			tarjetacreditoAux.setcuentacontablediferencia_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(tarjetacreditoAux.getCuentaContableDiferencia()));
			tarjetacreditoAux.setformularetencion_descripcion(FormulaConstantesFunciones.getFormulaDescripcion(tarjetacreditoAux.getFormulaRetencion()));
			tarjetacreditoAux.setformulacomision_descripcion(FormulaConstantesFunciones.getFormulaDescripcion(tarjetacreditoAux.getFormulaComision()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTarjetaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(TipoRetencion.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(TipoRetencionIva.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Formula.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Formula.class));
				classes.add(new Classe(Formula.class));
				
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
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencion.class)) {
						classes.add(new Classe(TipoRetencion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoRetencionIva.class)) {
						classes.add(new Classe(TipoRetencionIva.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formula.class)) {
						classes.add(new Classe(Formula.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formula.class)) {
						classes.add(new Classe(Formula.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formula.class)) {
						classes.add(new Classe(Formula.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTarjetaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Formula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formula.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Formula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formula.class)); continue;
					}

					if(Formula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formula.class)); continue;
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

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoRetencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencion.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(TipoRetencionIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoRetencionIva.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Formula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formula.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Formula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formula.class)); continue;
					}

					if(Formula.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formula.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TarjetaCreditoConstantesFunciones.getClassesRelationshipsOfTarjetaCredito(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(TarjetaCreditoConexion.class));
				classes.add(new Classe(TarjetaCreditoDescuento.class));
				classes.add(new Classe(FormaPagoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(TarjetaCreditoConexion.class)) {
						classes.add(new Classe(TarjetaCreditoConexion.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TarjetaCreditoDescuento.class)) {
						classes.add(new Classe(TarjetaCreditoDescuento.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormaPagoPuntoVenta.class)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTarjetaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TarjetaCreditoConstantesFunciones.getClassesRelationshipsFromStringsOfTarjetaCredito(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTarjetaCredito(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(TarjetaCreditoConexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCreditoConexion.class)); continue;
					}

					if(TarjetaCreditoDescuento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCreditoDescuento.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(TarjetaCreditoConexion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCreditoConexion.class)); continue;
					}

					if(TarjetaCreditoDescuento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCreditoDescuento.class)); continue;
					}

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
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
	public static void actualizarLista(TarjetaCredito tarjetacredito,List<TarjetaCredito> tarjetacreditos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TarjetaCredito tarjetacreditoEncontrado=null;
			
			for(TarjetaCredito tarjetacreditoLocal:tarjetacreditos) {
				if(tarjetacreditoLocal.getId().equals(tarjetacredito.getId())) {
					tarjetacreditoEncontrado=tarjetacreditoLocal;
					
					tarjetacreditoLocal.setIsChanged(tarjetacredito.getIsChanged());
					tarjetacreditoLocal.setIsNew(tarjetacredito.getIsNew());
					tarjetacreditoLocal.setIsDeleted(tarjetacredito.getIsDeleted());
					
					tarjetacreditoLocal.setGeneralEntityOriginal(tarjetacredito.getGeneralEntityOriginal());
					
					tarjetacreditoLocal.setId(tarjetacredito.getId());	
					tarjetacreditoLocal.setVersionRow(tarjetacredito.getVersionRow());	
					tarjetacreditoLocal.setid_empresa(tarjetacredito.getid_empresa());	
					tarjetacreditoLocal.setid_sucursal(tarjetacredito.getid_sucursal());	
					tarjetacreditoLocal.setid_banco(tarjetacredito.getid_banco());	
					tarjetacreditoLocal.setcodigo(tarjetacredito.getcodigo());	
					tarjetacreditoLocal.setnombre(tarjetacredito.getnombre());	
					tarjetacreditoLocal.setnombre_corto(tarjetacredito.getnombre_corto());	
					tarjetacreditoLocal.setdigito_valido(tarjetacredito.getdigito_valido());	
					tarjetacreditoLocal.setdigito_tarjeta(tarjetacredito.getdigito_tarjeta());	
					tarjetacreditoLocal.setcomision(tarjetacredito.getcomision());	
					tarjetacreditoLocal.setinteres(tarjetacredito.getinteres());	
					tarjetacreditoLocal.setmonto_minimo(tarjetacredito.getmonto_minimo());	
					tarjetacreditoLocal.setporcentaje_retencion(tarjetacredito.getporcentaje_retencion());	
					tarjetacreditoLocal.setcomision_retencion(tarjetacredito.getcomision_retencion());	
					tarjetacreditoLocal.setes_retencion_redondeo(tarjetacredito.getes_retencion_redondeo());	
					tarjetacreditoLocal.setes_pago_banco_redondeo(tarjetacredito.getes_pago_banco_redondeo());	
					tarjetacreditoLocal.setes_comision_redondeo(tarjetacredito.getes_comision_redondeo());	
					tarjetacreditoLocal.setid_tipo_retencion(tarjetacredito.getid_tipo_retencion());	
					tarjetacreditoLocal.setid_cuenta_contable(tarjetacredito.getid_cuenta_contable());	
					tarjetacreditoLocal.setid_tipo_retencion_iva(tarjetacredito.getid_tipo_retencion_iva());	
					tarjetacreditoLocal.setid_cuenta_contable_comision(tarjetacredito.getid_cuenta_contable_comision());	
					tarjetacreditoLocal.setid_formula_pago_banco(tarjetacredito.getid_formula_pago_banco());	
					tarjetacreditoLocal.setid_cuenta_contable_diferencia(tarjetacredito.getid_cuenta_contable_diferencia());	
					tarjetacreditoLocal.setid_formula_retencion(tarjetacredito.getid_formula_retencion());	
					tarjetacreditoLocal.setid_formula_comision(tarjetacredito.getid_formula_comision());	
					
					
					tarjetacreditoLocal.setTarjetaCreditoConexions(tarjetacredito.getTarjetaCreditoConexions());
					tarjetacreditoLocal.setTarjetaCreditoDescuentos(tarjetacredito.getTarjetaCreditoDescuentos());
					tarjetacreditoLocal.setFormaPagoPuntoVentas(tarjetacredito.getFormaPagoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!tarjetacredito.getIsDeleted()) {
				if(!existe) {
					tarjetacreditos.add(tarjetacredito);
				}
			} else {
				if(tarjetacreditoEncontrado!=null && permiteQuitar)  {
					tarjetacreditos.remove(tarjetacreditoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TarjetaCredito tarjetacredito,List<TarjetaCredito> tarjetacreditos) throws Exception {
		try	{			
			for(TarjetaCredito tarjetacreditoLocal:tarjetacreditos) {
				if(tarjetacreditoLocal.getId().equals(tarjetacredito.getId())) {
					tarjetacreditoLocal.setIsSelected(tarjetacredito.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTarjetaCredito(List<TarjetaCredito> tarjetacreditosAux) throws Exception {
		//this.tarjetacreditosAux=tarjetacreditosAux;
		
		for(TarjetaCredito tarjetacreditoAux:tarjetacreditosAux) {
			if(tarjetacreditoAux.getIsChanged()) {
				tarjetacreditoAux.setIsChanged(false);
			}		
			
			if(tarjetacreditoAux.getIsNew()) {
				tarjetacreditoAux.setIsNew(false);
			}	
			
			if(tarjetacreditoAux.getIsDeleted()) {
				tarjetacreditoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTarjetaCredito(TarjetaCredito tarjetacreditoAux) throws Exception {
		//this.tarjetacreditoAux=tarjetacreditoAux;
		
			if(tarjetacreditoAux.getIsChanged()) {
				tarjetacreditoAux.setIsChanged(false);
			}		
			
			if(tarjetacreditoAux.getIsNew()) {
				tarjetacreditoAux.setIsNew(false);
			}	
			
			if(tarjetacreditoAux.getIsDeleted()) {
				tarjetacreditoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TarjetaCredito tarjetacreditoAsignar,TarjetaCredito tarjetacredito) throws Exception {
		tarjetacreditoAsignar.setId(tarjetacredito.getId());	
		tarjetacreditoAsignar.setVersionRow(tarjetacredito.getVersionRow());	
		tarjetacreditoAsignar.setid_empresa(tarjetacredito.getid_empresa());
		tarjetacreditoAsignar.setempresa_descripcion(tarjetacredito.getempresa_descripcion());	
		tarjetacreditoAsignar.setid_sucursal(tarjetacredito.getid_sucursal());
		tarjetacreditoAsignar.setsucursal_descripcion(tarjetacredito.getsucursal_descripcion());	
		tarjetacreditoAsignar.setid_banco(tarjetacredito.getid_banco());
		tarjetacreditoAsignar.setbanco_descripcion(tarjetacredito.getbanco_descripcion());	
		tarjetacreditoAsignar.setcodigo(tarjetacredito.getcodigo());	
		tarjetacreditoAsignar.setnombre(tarjetacredito.getnombre());	
		tarjetacreditoAsignar.setnombre_corto(tarjetacredito.getnombre_corto());	
		tarjetacreditoAsignar.setdigito_valido(tarjetacredito.getdigito_valido());	
		tarjetacreditoAsignar.setdigito_tarjeta(tarjetacredito.getdigito_tarjeta());	
		tarjetacreditoAsignar.setcomision(tarjetacredito.getcomision());	
		tarjetacreditoAsignar.setinteres(tarjetacredito.getinteres());	
		tarjetacreditoAsignar.setmonto_minimo(tarjetacredito.getmonto_minimo());	
		tarjetacreditoAsignar.setporcentaje_retencion(tarjetacredito.getporcentaje_retencion());	
		tarjetacreditoAsignar.setcomision_retencion(tarjetacredito.getcomision_retencion());	
		tarjetacreditoAsignar.setes_retencion_redondeo(tarjetacredito.getes_retencion_redondeo());	
		tarjetacreditoAsignar.setes_pago_banco_redondeo(tarjetacredito.getes_pago_banco_redondeo());	
		tarjetacreditoAsignar.setes_comision_redondeo(tarjetacredito.getes_comision_redondeo());	
		tarjetacreditoAsignar.setid_tipo_retencion(tarjetacredito.getid_tipo_retencion());
		tarjetacreditoAsignar.settiporetencion_descripcion(tarjetacredito.gettiporetencion_descripcion());	
		tarjetacreditoAsignar.setid_cuenta_contable(tarjetacredito.getid_cuenta_contable());
		tarjetacreditoAsignar.setcuentacontable_descripcion(tarjetacredito.getcuentacontable_descripcion());	
		tarjetacreditoAsignar.setid_tipo_retencion_iva(tarjetacredito.getid_tipo_retencion_iva());
		tarjetacreditoAsignar.settiporetencioniva_descripcion(tarjetacredito.gettiporetencioniva_descripcion());	
		tarjetacreditoAsignar.setid_cuenta_contable_comision(tarjetacredito.getid_cuenta_contable_comision());
		tarjetacreditoAsignar.setcuentacontablecomision_descripcion(tarjetacredito.getcuentacontablecomision_descripcion());	
		tarjetacreditoAsignar.setid_formula_pago_banco(tarjetacredito.getid_formula_pago_banco());
		tarjetacreditoAsignar.setformulapagobanco_descripcion(tarjetacredito.getformulapagobanco_descripcion());	
		tarjetacreditoAsignar.setid_cuenta_contable_diferencia(tarjetacredito.getid_cuenta_contable_diferencia());
		tarjetacreditoAsignar.setcuentacontablediferencia_descripcion(tarjetacredito.getcuentacontablediferencia_descripcion());	
		tarjetacreditoAsignar.setid_formula_retencion(tarjetacredito.getid_formula_retencion());
		tarjetacreditoAsignar.setformularetencion_descripcion(tarjetacredito.getformularetencion_descripcion());	
		tarjetacreditoAsignar.setid_formula_comision(tarjetacredito.getid_formula_comision());
		tarjetacreditoAsignar.setformulacomision_descripcion(tarjetacredito.getformulacomision_descripcion());	
	}
	
	public static void inicializarTarjetaCredito(TarjetaCredito tarjetacredito) throws Exception {
		try {
				tarjetacredito.setId(0L);	
					
				tarjetacredito.setid_empresa(-1L);	
				tarjetacredito.setid_sucursal(-1L);	
				tarjetacredito.setid_banco(-1L);	
				tarjetacredito.setcodigo("");	
				tarjetacredito.setnombre("");	
				tarjetacredito.setnombre_corto("");	
				tarjetacredito.setdigito_valido(0);	
				tarjetacredito.setdigito_tarjeta(0);	
				tarjetacredito.setcomision(0.0);	
				tarjetacredito.setinteres(0.0);	
				tarjetacredito.setmonto_minimo(0.0);	
				tarjetacredito.setporcentaje_retencion(0.0);	
				tarjetacredito.setcomision_retencion(0.0);	
				tarjetacredito.setes_retencion_redondeo(false);	
				tarjetacredito.setes_pago_banco_redondeo(false);	
				tarjetacredito.setes_comision_redondeo(false);	
				tarjetacredito.setid_tipo_retencion(-1L);	
				tarjetacredito.setid_cuenta_contable(-1L);	
				tarjetacredito.setid_tipo_retencion_iva(-1L);	
				tarjetacredito.setid_cuenta_contable_comision(-1L);	
				tarjetacredito.setid_formula_pago_banco(-1L);	
				tarjetacredito.setid_cuenta_contable_diferencia(-1L);	
				tarjetacredito.setid_formula_retencion(-1L);	
				tarjetacredito.setid_formula_comision(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTarjetaCredito(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_NOMBRECORTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_DIGITOVALIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_DIGITOTARJETA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_COMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_INTERES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_MONTOMINIMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_PORCENTAJERETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_COMISIONRETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_ESRETENCIONREDONDEO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_ESPAGOBANCOREDONDEO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_ESCOMISIONREDONDEO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDTIPORETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLECOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULAPAGOBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDCUENTACONTABLEDIFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULARETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoConstantesFunciones.LABEL_IDFORMULACOMISION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTarjetaCredito(String sTipo,Row row,Workbook workbook,TarjetaCredito tarjetacredito,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getnombre_corto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getdigito_valido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getdigito_tarjeta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getcomision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getinteres());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getmonto_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getporcentaje_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getcomision_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tarjetacredito.getes_retencion_redondeo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tarjetacredito.getes_pago_banco_redondeo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tarjetacredito.getes_comision_redondeo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.gettiporetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.gettiporetencioniva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getcuentacontablecomision_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getformulapagobanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getcuentacontablediferencia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getformularetencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacredito.getformulacomision_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTarjetaCredito=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTarjetaCredito() {
		return this.sFinalQueryTarjetaCredito;
	}
	
	public void setsFinalQueryTarjetaCredito(String sFinalQueryTarjetaCredito) {
		this.sFinalQueryTarjetaCredito= sFinalQueryTarjetaCredito;
	}
	
	public Border resaltarSeleccionarTarjetaCredito=null;
	
	public Border setResaltarSeleccionarTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTarjetaCredito= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTarjetaCredito() {
		return this.resaltarSeleccionarTarjetaCredito;
	}
	
	public void setResaltarSeleccionarTarjetaCredito(Border borderResaltarSeleccionarTarjetaCredito) {
		this.resaltarSeleccionarTarjetaCredito= borderResaltarSeleccionarTarjetaCredito;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTarjetaCredito=null;
	public Boolean mostraridTarjetaCredito=true;
	public Boolean activaridTarjetaCredito=true;

	public Border resaltarid_empresaTarjetaCredito=null;
	public Boolean mostrarid_empresaTarjetaCredito=true;
	public Boolean activarid_empresaTarjetaCredito=true;
	public Boolean cargarid_empresaTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_sucursalTarjetaCredito=null;
	public Boolean mostrarid_sucursalTarjetaCredito=true;
	public Boolean activarid_sucursalTarjetaCredito=true;
	public Boolean cargarid_sucursalTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_bancoTarjetaCredito=null;
	public Boolean mostrarid_bancoTarjetaCredito=true;
	public Boolean activarid_bancoTarjetaCredito=true;
	public Boolean cargarid_bancoTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarcodigoTarjetaCredito=null;
	public Boolean mostrarcodigoTarjetaCredito=true;
	public Boolean activarcodigoTarjetaCredito=true;

	public Border resaltarnombreTarjetaCredito=null;
	public Boolean mostrarnombreTarjetaCredito=true;
	public Boolean activarnombreTarjetaCredito=true;

	public Border resaltarnombre_cortoTarjetaCredito=null;
	public Boolean mostrarnombre_cortoTarjetaCredito=true;
	public Boolean activarnombre_cortoTarjetaCredito=true;

	public Border resaltardigito_validoTarjetaCredito=null;
	public Boolean mostrardigito_validoTarjetaCredito=true;
	public Boolean activardigito_validoTarjetaCredito=true;

	public Border resaltardigito_tarjetaTarjetaCredito=null;
	public Boolean mostrardigito_tarjetaTarjetaCredito=true;
	public Boolean activardigito_tarjetaTarjetaCredito=true;

	public Border resaltarcomisionTarjetaCredito=null;
	public Boolean mostrarcomisionTarjetaCredito=true;
	public Boolean activarcomisionTarjetaCredito=true;

	public Border resaltarinteresTarjetaCredito=null;
	public Boolean mostrarinteresTarjetaCredito=true;
	public Boolean activarinteresTarjetaCredito=true;

	public Border resaltarmonto_minimoTarjetaCredito=null;
	public Boolean mostrarmonto_minimoTarjetaCredito=true;
	public Boolean activarmonto_minimoTarjetaCredito=true;

	public Border resaltarporcentaje_retencionTarjetaCredito=null;
	public Boolean mostrarporcentaje_retencionTarjetaCredito=true;
	public Boolean activarporcentaje_retencionTarjetaCredito=true;

	public Border resaltarcomision_retencionTarjetaCredito=null;
	public Boolean mostrarcomision_retencionTarjetaCredito=true;
	public Boolean activarcomision_retencionTarjetaCredito=true;

	public Border resaltares_retencion_redondeoTarjetaCredito=null;
	public Boolean mostrares_retencion_redondeoTarjetaCredito=true;
	public Boolean activares_retencion_redondeoTarjetaCredito=true;

	public Border resaltares_pago_banco_redondeoTarjetaCredito=null;
	public Boolean mostrares_pago_banco_redondeoTarjetaCredito=true;
	public Boolean activares_pago_banco_redondeoTarjetaCredito=true;

	public Border resaltares_comision_redondeoTarjetaCredito=null;
	public Boolean mostrares_comision_redondeoTarjetaCredito=true;
	public Boolean activares_comision_redondeoTarjetaCredito=true;

	public Border resaltarid_tipo_retencionTarjetaCredito=null;
	public Boolean mostrarid_tipo_retencionTarjetaCredito=true;
	public Boolean activarid_tipo_retencionTarjetaCredito=true;
	public Boolean cargarid_tipo_retencionTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencionTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableTarjetaCredito=null;
	public Boolean mostrarid_cuenta_contableTarjetaCredito=true;
	public Boolean activarid_cuenta_contableTarjetaCredito=true;
	public Boolean cargarid_cuenta_contableTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_tipo_retencion_ivaTarjetaCredito=null;
	public Boolean mostrarid_tipo_retencion_ivaTarjetaCredito=true;
	public Boolean activarid_tipo_retencion_ivaTarjetaCredito=true;
	public Boolean cargarid_tipo_retencion_ivaTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_retencion_ivaTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_comisionTarjetaCredito=null;
	public Boolean mostrarid_cuenta_contable_comisionTarjetaCredito=true;
	public Boolean activarid_cuenta_contable_comisionTarjetaCredito=true;
	public Boolean cargarid_cuenta_contable_comisionTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_comisionTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_formula_pago_bancoTarjetaCredito=null;
	public Boolean mostrarid_formula_pago_bancoTarjetaCredito=true;
	public Boolean activarid_formula_pago_bancoTarjetaCredito=true;
	public Boolean cargarid_formula_pago_bancoTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formula_pago_bancoTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_diferenciaTarjetaCredito=null;
	public Boolean mostrarid_cuenta_contable_diferenciaTarjetaCredito=true;
	public Boolean activarid_cuenta_contable_diferenciaTarjetaCredito=true;
	public Boolean cargarid_cuenta_contable_diferenciaTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_diferenciaTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_formula_retencionTarjetaCredito=null;
	public Boolean mostrarid_formula_retencionTarjetaCredito=true;
	public Boolean activarid_formula_retencionTarjetaCredito=true;
	public Boolean cargarid_formula_retencionTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formula_retencionTarjetaCredito=false;//ConEventDepend=true

	public Border resaltarid_formula_comisionTarjetaCredito=null;
	public Boolean mostrarid_formula_comisionTarjetaCredito=true;
	public Boolean activarid_formula_comisionTarjetaCredito=true;
	public Boolean cargarid_formula_comisionTarjetaCredito=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formula_comisionTarjetaCredito=false;//ConEventDepend=true

	
	

	public Border setResaltaridTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltaridTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTarjetaCredito() {
		return this.resaltaridTarjetaCredito;
	}

	public void setResaltaridTarjetaCredito(Border borderResaltar) {
		this.resaltaridTarjetaCredito= borderResaltar;
	}

	public Boolean getMostraridTarjetaCredito() {
		return this.mostraridTarjetaCredito;
	}

	public void setMostraridTarjetaCredito(Boolean mostraridTarjetaCredito) {
		this.mostraridTarjetaCredito= mostraridTarjetaCredito;
	}

	public Boolean getActivaridTarjetaCredito() {
		return this.activaridTarjetaCredito;
	}

	public void setActivaridTarjetaCredito(Boolean activaridTarjetaCredito) {
		this.activaridTarjetaCredito= activaridTarjetaCredito;
	}

	public Border setResaltarid_empresaTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_empresaTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTarjetaCredito() {
		return this.resaltarid_empresaTarjetaCredito;
	}

	public void setResaltarid_empresaTarjetaCredito(Border borderResaltar) {
		this.resaltarid_empresaTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_empresaTarjetaCredito() {
		return this.mostrarid_empresaTarjetaCredito;
	}

	public void setMostrarid_empresaTarjetaCredito(Boolean mostrarid_empresaTarjetaCredito) {
		this.mostrarid_empresaTarjetaCredito= mostrarid_empresaTarjetaCredito;
	}

	public Boolean getActivarid_empresaTarjetaCredito() {
		return this.activarid_empresaTarjetaCredito;
	}

	public void setActivarid_empresaTarjetaCredito(Boolean activarid_empresaTarjetaCredito) {
		this.activarid_empresaTarjetaCredito= activarid_empresaTarjetaCredito;
	}

	public Boolean getCargarid_empresaTarjetaCredito() {
		return this.cargarid_empresaTarjetaCredito;
	}

	public void setCargarid_empresaTarjetaCredito(Boolean cargarid_empresaTarjetaCredito) {
		this.cargarid_empresaTarjetaCredito= cargarid_empresaTarjetaCredito;
	}

	public Border setResaltarid_sucursalTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTarjetaCredito() {
		return this.resaltarid_sucursalTarjetaCredito;
	}

	public void setResaltarid_sucursalTarjetaCredito(Border borderResaltar) {
		this.resaltarid_sucursalTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTarjetaCredito() {
		return this.mostrarid_sucursalTarjetaCredito;
	}

	public void setMostrarid_sucursalTarjetaCredito(Boolean mostrarid_sucursalTarjetaCredito) {
		this.mostrarid_sucursalTarjetaCredito= mostrarid_sucursalTarjetaCredito;
	}

	public Boolean getActivarid_sucursalTarjetaCredito() {
		return this.activarid_sucursalTarjetaCredito;
	}

	public void setActivarid_sucursalTarjetaCredito(Boolean activarid_sucursalTarjetaCredito) {
		this.activarid_sucursalTarjetaCredito= activarid_sucursalTarjetaCredito;
	}

	public Boolean getCargarid_sucursalTarjetaCredito() {
		return this.cargarid_sucursalTarjetaCredito;
	}

	public void setCargarid_sucursalTarjetaCredito(Boolean cargarid_sucursalTarjetaCredito) {
		this.cargarid_sucursalTarjetaCredito= cargarid_sucursalTarjetaCredito;
	}

	public Border setResaltarid_bancoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_bancoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoTarjetaCredito() {
		return this.resaltarid_bancoTarjetaCredito;
	}

	public void setResaltarid_bancoTarjetaCredito(Border borderResaltar) {
		this.resaltarid_bancoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_bancoTarjetaCredito() {
		return this.mostrarid_bancoTarjetaCredito;
	}

	public void setMostrarid_bancoTarjetaCredito(Boolean mostrarid_bancoTarjetaCredito) {
		this.mostrarid_bancoTarjetaCredito= mostrarid_bancoTarjetaCredito;
	}

	public Boolean getActivarid_bancoTarjetaCredito() {
		return this.activarid_bancoTarjetaCredito;
	}

	public void setActivarid_bancoTarjetaCredito(Boolean activarid_bancoTarjetaCredito) {
		this.activarid_bancoTarjetaCredito= activarid_bancoTarjetaCredito;
	}

	public Boolean getCargarid_bancoTarjetaCredito() {
		return this.cargarid_bancoTarjetaCredito;
	}

	public void setCargarid_bancoTarjetaCredito(Boolean cargarid_bancoTarjetaCredito) {
		this.cargarid_bancoTarjetaCredito= cargarid_bancoTarjetaCredito;
	}

	public Border setResaltarcodigoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarcodigoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTarjetaCredito() {
		return this.resaltarcodigoTarjetaCredito;
	}

	public void setResaltarcodigoTarjetaCredito(Border borderResaltar) {
		this.resaltarcodigoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarcodigoTarjetaCredito() {
		return this.mostrarcodigoTarjetaCredito;
	}

	public void setMostrarcodigoTarjetaCredito(Boolean mostrarcodigoTarjetaCredito) {
		this.mostrarcodigoTarjetaCredito= mostrarcodigoTarjetaCredito;
	}

	public Boolean getActivarcodigoTarjetaCredito() {
		return this.activarcodigoTarjetaCredito;
	}

	public void setActivarcodigoTarjetaCredito(Boolean activarcodigoTarjetaCredito) {
		this.activarcodigoTarjetaCredito= activarcodigoTarjetaCredito;
	}

	public Border setResaltarnombreTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarnombreTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTarjetaCredito() {
		return this.resaltarnombreTarjetaCredito;
	}

	public void setResaltarnombreTarjetaCredito(Border borderResaltar) {
		this.resaltarnombreTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarnombreTarjetaCredito() {
		return this.mostrarnombreTarjetaCredito;
	}

	public void setMostrarnombreTarjetaCredito(Boolean mostrarnombreTarjetaCredito) {
		this.mostrarnombreTarjetaCredito= mostrarnombreTarjetaCredito;
	}

	public Boolean getActivarnombreTarjetaCredito() {
		return this.activarnombreTarjetaCredito;
	}

	public void setActivarnombreTarjetaCredito(Boolean activarnombreTarjetaCredito) {
		this.activarnombreTarjetaCredito= activarnombreTarjetaCredito;
	}

	public Border setResaltarnombre_cortoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarnombre_cortoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cortoTarjetaCredito() {
		return this.resaltarnombre_cortoTarjetaCredito;
	}

	public void setResaltarnombre_cortoTarjetaCredito(Border borderResaltar) {
		this.resaltarnombre_cortoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarnombre_cortoTarjetaCredito() {
		return this.mostrarnombre_cortoTarjetaCredito;
	}

	public void setMostrarnombre_cortoTarjetaCredito(Boolean mostrarnombre_cortoTarjetaCredito) {
		this.mostrarnombre_cortoTarjetaCredito= mostrarnombre_cortoTarjetaCredito;
	}

	public Boolean getActivarnombre_cortoTarjetaCredito() {
		return this.activarnombre_cortoTarjetaCredito;
	}

	public void setActivarnombre_cortoTarjetaCredito(Boolean activarnombre_cortoTarjetaCredito) {
		this.activarnombre_cortoTarjetaCredito= activarnombre_cortoTarjetaCredito;
	}

	public Border setResaltardigito_validoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltardigito_validoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardigito_validoTarjetaCredito() {
		return this.resaltardigito_validoTarjetaCredito;
	}

	public void setResaltardigito_validoTarjetaCredito(Border borderResaltar) {
		this.resaltardigito_validoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrardigito_validoTarjetaCredito() {
		return this.mostrardigito_validoTarjetaCredito;
	}

	public void setMostrardigito_validoTarjetaCredito(Boolean mostrardigito_validoTarjetaCredito) {
		this.mostrardigito_validoTarjetaCredito= mostrardigito_validoTarjetaCredito;
	}

	public Boolean getActivardigito_validoTarjetaCredito() {
		return this.activardigito_validoTarjetaCredito;
	}

	public void setActivardigito_validoTarjetaCredito(Boolean activardigito_validoTarjetaCredito) {
		this.activardigito_validoTarjetaCredito= activardigito_validoTarjetaCredito;
	}

	public Border setResaltardigito_tarjetaTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltardigito_tarjetaTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardigito_tarjetaTarjetaCredito() {
		return this.resaltardigito_tarjetaTarjetaCredito;
	}

	public void setResaltardigito_tarjetaTarjetaCredito(Border borderResaltar) {
		this.resaltardigito_tarjetaTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrardigito_tarjetaTarjetaCredito() {
		return this.mostrardigito_tarjetaTarjetaCredito;
	}

	public void setMostrardigito_tarjetaTarjetaCredito(Boolean mostrardigito_tarjetaTarjetaCredito) {
		this.mostrardigito_tarjetaTarjetaCredito= mostrardigito_tarjetaTarjetaCredito;
	}

	public Boolean getActivardigito_tarjetaTarjetaCredito() {
		return this.activardigito_tarjetaTarjetaCredito;
	}

	public void setActivardigito_tarjetaTarjetaCredito(Boolean activardigito_tarjetaTarjetaCredito) {
		this.activardigito_tarjetaTarjetaCredito= activardigito_tarjetaTarjetaCredito;
	}

	public Border setResaltarcomisionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarcomisionTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcomisionTarjetaCredito() {
		return this.resaltarcomisionTarjetaCredito;
	}

	public void setResaltarcomisionTarjetaCredito(Border borderResaltar) {
		this.resaltarcomisionTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarcomisionTarjetaCredito() {
		return this.mostrarcomisionTarjetaCredito;
	}

	public void setMostrarcomisionTarjetaCredito(Boolean mostrarcomisionTarjetaCredito) {
		this.mostrarcomisionTarjetaCredito= mostrarcomisionTarjetaCredito;
	}

	public Boolean getActivarcomisionTarjetaCredito() {
		return this.activarcomisionTarjetaCredito;
	}

	public void setActivarcomisionTarjetaCredito(Boolean activarcomisionTarjetaCredito) {
		this.activarcomisionTarjetaCredito= activarcomisionTarjetaCredito;
	}

	public Border setResaltarinteresTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarinteresTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinteresTarjetaCredito() {
		return this.resaltarinteresTarjetaCredito;
	}

	public void setResaltarinteresTarjetaCredito(Border borderResaltar) {
		this.resaltarinteresTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarinteresTarjetaCredito() {
		return this.mostrarinteresTarjetaCredito;
	}

	public void setMostrarinteresTarjetaCredito(Boolean mostrarinteresTarjetaCredito) {
		this.mostrarinteresTarjetaCredito= mostrarinteresTarjetaCredito;
	}

	public Boolean getActivarinteresTarjetaCredito() {
		return this.activarinteresTarjetaCredito;
	}

	public void setActivarinteresTarjetaCredito(Boolean activarinteresTarjetaCredito) {
		this.activarinteresTarjetaCredito= activarinteresTarjetaCredito;
	}

	public Border setResaltarmonto_minimoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarmonto_minimoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_minimoTarjetaCredito() {
		return this.resaltarmonto_minimoTarjetaCredito;
	}

	public void setResaltarmonto_minimoTarjetaCredito(Border borderResaltar) {
		this.resaltarmonto_minimoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarmonto_minimoTarjetaCredito() {
		return this.mostrarmonto_minimoTarjetaCredito;
	}

	public void setMostrarmonto_minimoTarjetaCredito(Boolean mostrarmonto_minimoTarjetaCredito) {
		this.mostrarmonto_minimoTarjetaCredito= mostrarmonto_minimoTarjetaCredito;
	}

	public Boolean getActivarmonto_minimoTarjetaCredito() {
		return this.activarmonto_minimoTarjetaCredito;
	}

	public void setActivarmonto_minimoTarjetaCredito(Boolean activarmonto_minimoTarjetaCredito) {
		this.activarmonto_minimoTarjetaCredito= activarmonto_minimoTarjetaCredito;
	}

	public Border setResaltarporcentaje_retencionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarporcentaje_retencionTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_retencionTarjetaCredito() {
		return this.resaltarporcentaje_retencionTarjetaCredito;
	}

	public void setResaltarporcentaje_retencionTarjetaCredito(Border borderResaltar) {
		this.resaltarporcentaje_retencionTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarporcentaje_retencionTarjetaCredito() {
		return this.mostrarporcentaje_retencionTarjetaCredito;
	}

	public void setMostrarporcentaje_retencionTarjetaCredito(Boolean mostrarporcentaje_retencionTarjetaCredito) {
		this.mostrarporcentaje_retencionTarjetaCredito= mostrarporcentaje_retencionTarjetaCredito;
	}

	public Boolean getActivarporcentaje_retencionTarjetaCredito() {
		return this.activarporcentaje_retencionTarjetaCredito;
	}

	public void setActivarporcentaje_retencionTarjetaCredito(Boolean activarporcentaje_retencionTarjetaCredito) {
		this.activarporcentaje_retencionTarjetaCredito= activarporcentaje_retencionTarjetaCredito;
	}

	public Border setResaltarcomision_retencionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarcomision_retencionTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcomision_retencionTarjetaCredito() {
		return this.resaltarcomision_retencionTarjetaCredito;
	}

	public void setResaltarcomision_retencionTarjetaCredito(Border borderResaltar) {
		this.resaltarcomision_retencionTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarcomision_retencionTarjetaCredito() {
		return this.mostrarcomision_retencionTarjetaCredito;
	}

	public void setMostrarcomision_retencionTarjetaCredito(Boolean mostrarcomision_retencionTarjetaCredito) {
		this.mostrarcomision_retencionTarjetaCredito= mostrarcomision_retencionTarjetaCredito;
	}

	public Boolean getActivarcomision_retencionTarjetaCredito() {
		return this.activarcomision_retencionTarjetaCredito;
	}

	public void setActivarcomision_retencionTarjetaCredito(Boolean activarcomision_retencionTarjetaCredito) {
		this.activarcomision_retencionTarjetaCredito= activarcomision_retencionTarjetaCredito;
	}

	public Border setResaltares_retencion_redondeoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltares_retencion_redondeoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_retencion_redondeoTarjetaCredito() {
		return this.resaltares_retencion_redondeoTarjetaCredito;
	}

	public void setResaltares_retencion_redondeoTarjetaCredito(Border borderResaltar) {
		this.resaltares_retencion_redondeoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrares_retencion_redondeoTarjetaCredito() {
		return this.mostrares_retencion_redondeoTarjetaCredito;
	}

	public void setMostrares_retencion_redondeoTarjetaCredito(Boolean mostrares_retencion_redondeoTarjetaCredito) {
		this.mostrares_retencion_redondeoTarjetaCredito= mostrares_retencion_redondeoTarjetaCredito;
	}

	public Boolean getActivares_retencion_redondeoTarjetaCredito() {
		return this.activares_retencion_redondeoTarjetaCredito;
	}

	public void setActivares_retencion_redondeoTarjetaCredito(Boolean activares_retencion_redondeoTarjetaCredito) {
		this.activares_retencion_redondeoTarjetaCredito= activares_retencion_redondeoTarjetaCredito;
	}

	public Border setResaltares_pago_banco_redondeoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltares_pago_banco_redondeoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_pago_banco_redondeoTarjetaCredito() {
		return this.resaltares_pago_banco_redondeoTarjetaCredito;
	}

	public void setResaltares_pago_banco_redondeoTarjetaCredito(Border borderResaltar) {
		this.resaltares_pago_banco_redondeoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrares_pago_banco_redondeoTarjetaCredito() {
		return this.mostrares_pago_banco_redondeoTarjetaCredito;
	}

	public void setMostrares_pago_banco_redondeoTarjetaCredito(Boolean mostrares_pago_banco_redondeoTarjetaCredito) {
		this.mostrares_pago_banco_redondeoTarjetaCredito= mostrares_pago_banco_redondeoTarjetaCredito;
	}

	public Boolean getActivares_pago_banco_redondeoTarjetaCredito() {
		return this.activares_pago_banco_redondeoTarjetaCredito;
	}

	public void setActivares_pago_banco_redondeoTarjetaCredito(Boolean activares_pago_banco_redondeoTarjetaCredito) {
		this.activares_pago_banco_redondeoTarjetaCredito= activares_pago_banco_redondeoTarjetaCredito;
	}

	public Border setResaltares_comision_redondeoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltares_comision_redondeoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_comision_redondeoTarjetaCredito() {
		return this.resaltares_comision_redondeoTarjetaCredito;
	}

	public void setResaltares_comision_redondeoTarjetaCredito(Border borderResaltar) {
		this.resaltares_comision_redondeoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrares_comision_redondeoTarjetaCredito() {
		return this.mostrares_comision_redondeoTarjetaCredito;
	}

	public void setMostrares_comision_redondeoTarjetaCredito(Boolean mostrares_comision_redondeoTarjetaCredito) {
		this.mostrares_comision_redondeoTarjetaCredito= mostrares_comision_redondeoTarjetaCredito;
	}

	public Boolean getActivares_comision_redondeoTarjetaCredito() {
		return this.activares_comision_redondeoTarjetaCredito;
	}

	public void setActivares_comision_redondeoTarjetaCredito(Boolean activares_comision_redondeoTarjetaCredito) {
		this.activares_comision_redondeoTarjetaCredito= activares_comision_redondeoTarjetaCredito;
	}

	public Border setResaltarid_tipo_retencionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencionTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencionTarjetaCredito() {
		return this.resaltarid_tipo_retencionTarjetaCredito;
	}

	public void setResaltarid_tipo_retencionTarjetaCredito(Border borderResaltar) {
		this.resaltarid_tipo_retencionTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencionTarjetaCredito() {
		return this.mostrarid_tipo_retencionTarjetaCredito;
	}

	public void setMostrarid_tipo_retencionTarjetaCredito(Boolean mostrarid_tipo_retencionTarjetaCredito) {
		this.mostrarid_tipo_retencionTarjetaCredito= mostrarid_tipo_retencionTarjetaCredito;
	}

	public Boolean getActivarid_tipo_retencionTarjetaCredito() {
		return this.activarid_tipo_retencionTarjetaCredito;
	}

	public void setActivarid_tipo_retencionTarjetaCredito(Boolean activarid_tipo_retencionTarjetaCredito) {
		this.activarid_tipo_retencionTarjetaCredito= activarid_tipo_retencionTarjetaCredito;
	}

	public Boolean getCargarid_tipo_retencionTarjetaCredito() {
		return this.cargarid_tipo_retencionTarjetaCredito;
	}

	public void setCargarid_tipo_retencionTarjetaCredito(Boolean cargarid_tipo_retencionTarjetaCredito) {
		this.cargarid_tipo_retencionTarjetaCredito= cargarid_tipo_retencionTarjetaCredito;
	}

	public Border setResaltarid_cuenta_contableTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableTarjetaCredito() {
		return this.resaltarid_cuenta_contableTarjetaCredito;
	}

	public void setResaltarid_cuenta_contableTarjetaCredito(Border borderResaltar) {
		this.resaltarid_cuenta_contableTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableTarjetaCredito() {
		return this.mostrarid_cuenta_contableTarjetaCredito;
	}

	public void setMostrarid_cuenta_contableTarjetaCredito(Boolean mostrarid_cuenta_contableTarjetaCredito) {
		this.mostrarid_cuenta_contableTarjetaCredito= mostrarid_cuenta_contableTarjetaCredito;
	}

	public Boolean getActivarid_cuenta_contableTarjetaCredito() {
		return this.activarid_cuenta_contableTarjetaCredito;
	}

	public void setActivarid_cuenta_contableTarjetaCredito(Boolean activarid_cuenta_contableTarjetaCredito) {
		this.activarid_cuenta_contableTarjetaCredito= activarid_cuenta_contableTarjetaCredito;
	}

	public Boolean getCargarid_cuenta_contableTarjetaCredito() {
		return this.cargarid_cuenta_contableTarjetaCredito;
	}

	public void setCargarid_cuenta_contableTarjetaCredito(Boolean cargarid_cuenta_contableTarjetaCredito) {
		this.cargarid_cuenta_contableTarjetaCredito= cargarid_cuenta_contableTarjetaCredito;
	}

	public Border setResaltarid_tipo_retencion_ivaTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_tipo_retencion_ivaTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_retencion_ivaTarjetaCredito() {
		return this.resaltarid_tipo_retencion_ivaTarjetaCredito;
	}

	public void setResaltarid_tipo_retencion_ivaTarjetaCredito(Border borderResaltar) {
		this.resaltarid_tipo_retencion_ivaTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_tipo_retencion_ivaTarjetaCredito() {
		return this.mostrarid_tipo_retencion_ivaTarjetaCredito;
	}

	public void setMostrarid_tipo_retencion_ivaTarjetaCredito(Boolean mostrarid_tipo_retencion_ivaTarjetaCredito) {
		this.mostrarid_tipo_retencion_ivaTarjetaCredito= mostrarid_tipo_retencion_ivaTarjetaCredito;
	}

	public Boolean getActivarid_tipo_retencion_ivaTarjetaCredito() {
		return this.activarid_tipo_retencion_ivaTarjetaCredito;
	}

	public void setActivarid_tipo_retencion_ivaTarjetaCredito(Boolean activarid_tipo_retencion_ivaTarjetaCredito) {
		this.activarid_tipo_retencion_ivaTarjetaCredito= activarid_tipo_retencion_ivaTarjetaCredito;
	}

	public Boolean getCargarid_tipo_retencion_ivaTarjetaCredito() {
		return this.cargarid_tipo_retencion_ivaTarjetaCredito;
	}

	public void setCargarid_tipo_retencion_ivaTarjetaCredito(Boolean cargarid_tipo_retencion_ivaTarjetaCredito) {
		this.cargarid_tipo_retencion_ivaTarjetaCredito= cargarid_tipo_retencion_ivaTarjetaCredito;
	}

	public Border setResaltarid_cuenta_contable_comisionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_comisionTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_comisionTarjetaCredito() {
		return this.resaltarid_cuenta_contable_comisionTarjetaCredito;
	}

	public void setResaltarid_cuenta_contable_comisionTarjetaCredito(Border borderResaltar) {
		this.resaltarid_cuenta_contable_comisionTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_comisionTarjetaCredito() {
		return this.mostrarid_cuenta_contable_comisionTarjetaCredito;
	}

	public void setMostrarid_cuenta_contable_comisionTarjetaCredito(Boolean mostrarid_cuenta_contable_comisionTarjetaCredito) {
		this.mostrarid_cuenta_contable_comisionTarjetaCredito= mostrarid_cuenta_contable_comisionTarjetaCredito;
	}

	public Boolean getActivarid_cuenta_contable_comisionTarjetaCredito() {
		return this.activarid_cuenta_contable_comisionTarjetaCredito;
	}

	public void setActivarid_cuenta_contable_comisionTarjetaCredito(Boolean activarid_cuenta_contable_comisionTarjetaCredito) {
		this.activarid_cuenta_contable_comisionTarjetaCredito= activarid_cuenta_contable_comisionTarjetaCredito;
	}

	public Boolean getCargarid_cuenta_contable_comisionTarjetaCredito() {
		return this.cargarid_cuenta_contable_comisionTarjetaCredito;
	}

	public void setCargarid_cuenta_contable_comisionTarjetaCredito(Boolean cargarid_cuenta_contable_comisionTarjetaCredito) {
		this.cargarid_cuenta_contable_comisionTarjetaCredito= cargarid_cuenta_contable_comisionTarjetaCredito;
	}

	public Border setResaltarid_formula_pago_bancoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_formula_pago_bancoTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formula_pago_bancoTarjetaCredito() {
		return this.resaltarid_formula_pago_bancoTarjetaCredito;
	}

	public void setResaltarid_formula_pago_bancoTarjetaCredito(Border borderResaltar) {
		this.resaltarid_formula_pago_bancoTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_formula_pago_bancoTarjetaCredito() {
		return this.mostrarid_formula_pago_bancoTarjetaCredito;
	}

	public void setMostrarid_formula_pago_bancoTarjetaCredito(Boolean mostrarid_formula_pago_bancoTarjetaCredito) {
		this.mostrarid_formula_pago_bancoTarjetaCredito= mostrarid_formula_pago_bancoTarjetaCredito;
	}

	public Boolean getActivarid_formula_pago_bancoTarjetaCredito() {
		return this.activarid_formula_pago_bancoTarjetaCredito;
	}

	public void setActivarid_formula_pago_bancoTarjetaCredito(Boolean activarid_formula_pago_bancoTarjetaCredito) {
		this.activarid_formula_pago_bancoTarjetaCredito= activarid_formula_pago_bancoTarjetaCredito;
	}

	public Boolean getCargarid_formula_pago_bancoTarjetaCredito() {
		return this.cargarid_formula_pago_bancoTarjetaCredito;
	}

	public void setCargarid_formula_pago_bancoTarjetaCredito(Boolean cargarid_formula_pago_bancoTarjetaCredito) {
		this.cargarid_formula_pago_bancoTarjetaCredito= cargarid_formula_pago_bancoTarjetaCredito;
	}

	public Border setResaltarid_cuenta_contable_diferenciaTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_diferenciaTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_diferenciaTarjetaCredito() {
		return this.resaltarid_cuenta_contable_diferenciaTarjetaCredito;
	}

	public void setResaltarid_cuenta_contable_diferenciaTarjetaCredito(Border borderResaltar) {
		this.resaltarid_cuenta_contable_diferenciaTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_diferenciaTarjetaCredito() {
		return this.mostrarid_cuenta_contable_diferenciaTarjetaCredito;
	}

	public void setMostrarid_cuenta_contable_diferenciaTarjetaCredito(Boolean mostrarid_cuenta_contable_diferenciaTarjetaCredito) {
		this.mostrarid_cuenta_contable_diferenciaTarjetaCredito= mostrarid_cuenta_contable_diferenciaTarjetaCredito;
	}

	public Boolean getActivarid_cuenta_contable_diferenciaTarjetaCredito() {
		return this.activarid_cuenta_contable_diferenciaTarjetaCredito;
	}

	public void setActivarid_cuenta_contable_diferenciaTarjetaCredito(Boolean activarid_cuenta_contable_diferenciaTarjetaCredito) {
		this.activarid_cuenta_contable_diferenciaTarjetaCredito= activarid_cuenta_contable_diferenciaTarjetaCredito;
	}

	public Boolean getCargarid_cuenta_contable_diferenciaTarjetaCredito() {
		return this.cargarid_cuenta_contable_diferenciaTarjetaCredito;
	}

	public void setCargarid_cuenta_contable_diferenciaTarjetaCredito(Boolean cargarid_cuenta_contable_diferenciaTarjetaCredito) {
		this.cargarid_cuenta_contable_diferenciaTarjetaCredito= cargarid_cuenta_contable_diferenciaTarjetaCredito;
	}

	public Border setResaltarid_formula_retencionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_formula_retencionTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formula_retencionTarjetaCredito() {
		return this.resaltarid_formula_retencionTarjetaCredito;
	}

	public void setResaltarid_formula_retencionTarjetaCredito(Border borderResaltar) {
		this.resaltarid_formula_retencionTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_formula_retencionTarjetaCredito() {
		return this.mostrarid_formula_retencionTarjetaCredito;
	}

	public void setMostrarid_formula_retencionTarjetaCredito(Boolean mostrarid_formula_retencionTarjetaCredito) {
		this.mostrarid_formula_retencionTarjetaCredito= mostrarid_formula_retencionTarjetaCredito;
	}

	public Boolean getActivarid_formula_retencionTarjetaCredito() {
		return this.activarid_formula_retencionTarjetaCredito;
	}

	public void setActivarid_formula_retencionTarjetaCredito(Boolean activarid_formula_retencionTarjetaCredito) {
		this.activarid_formula_retencionTarjetaCredito= activarid_formula_retencionTarjetaCredito;
	}

	public Boolean getCargarid_formula_retencionTarjetaCredito() {
		return this.cargarid_formula_retencionTarjetaCredito;
	}

	public void setCargarid_formula_retencionTarjetaCredito(Boolean cargarid_formula_retencionTarjetaCredito) {
		this.cargarid_formula_retencionTarjetaCredito= cargarid_formula_retencionTarjetaCredito;
	}

	public Border setResaltarid_formula_comisionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltar);
		
		this.resaltarid_formula_comisionTarjetaCredito= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formula_comisionTarjetaCredito() {
		return this.resaltarid_formula_comisionTarjetaCredito;
	}

	public void setResaltarid_formula_comisionTarjetaCredito(Border borderResaltar) {
		this.resaltarid_formula_comisionTarjetaCredito= borderResaltar;
	}

	public Boolean getMostrarid_formula_comisionTarjetaCredito() {
		return this.mostrarid_formula_comisionTarjetaCredito;
	}

	public void setMostrarid_formula_comisionTarjetaCredito(Boolean mostrarid_formula_comisionTarjetaCredito) {
		this.mostrarid_formula_comisionTarjetaCredito= mostrarid_formula_comisionTarjetaCredito;
	}

	public Boolean getActivarid_formula_comisionTarjetaCredito() {
		return this.activarid_formula_comisionTarjetaCredito;
	}

	public void setActivarid_formula_comisionTarjetaCredito(Boolean activarid_formula_comisionTarjetaCredito) {
		this.activarid_formula_comisionTarjetaCredito= activarid_formula_comisionTarjetaCredito;
	}

	public Boolean getCargarid_formula_comisionTarjetaCredito() {
		return this.cargarid_formula_comisionTarjetaCredito;
	}

	public void setCargarid_formula_comisionTarjetaCredito(Boolean cargarid_formula_comisionTarjetaCredito) {
		this.cargarid_formula_comisionTarjetaCredito= cargarid_formula_comisionTarjetaCredito;
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
		
		
		this.setMostraridTarjetaCredito(esInicial);
		this.setMostrarid_empresaTarjetaCredito(esInicial);
		this.setMostrarid_sucursalTarjetaCredito(esInicial);
		this.setMostrarid_bancoTarjetaCredito(esInicial);
		this.setMostrarcodigoTarjetaCredito(esInicial);
		this.setMostrarnombreTarjetaCredito(esInicial);
		this.setMostrarnombre_cortoTarjetaCredito(esInicial);
		this.setMostrardigito_validoTarjetaCredito(esInicial);
		this.setMostrardigito_tarjetaTarjetaCredito(esInicial);
		this.setMostrarcomisionTarjetaCredito(esInicial);
		this.setMostrarinteresTarjetaCredito(esInicial);
		this.setMostrarmonto_minimoTarjetaCredito(esInicial);
		this.setMostrarporcentaje_retencionTarjetaCredito(esInicial);
		this.setMostrarcomision_retencionTarjetaCredito(esInicial);
		this.setMostrares_retencion_redondeoTarjetaCredito(esInicial);
		this.setMostrares_pago_banco_redondeoTarjetaCredito(esInicial);
		this.setMostrares_comision_redondeoTarjetaCredito(esInicial);
		this.setMostrarid_tipo_retencionTarjetaCredito(esInicial);
		this.setMostrarid_cuenta_contableTarjetaCredito(esInicial);
		this.setMostrarid_tipo_retencion_ivaTarjetaCredito(esInicial);
		this.setMostrarid_cuenta_contable_comisionTarjetaCredito(esInicial);
		this.setMostrarid_formula_pago_bancoTarjetaCredito(esInicial);
		this.setMostrarid_cuenta_contable_diferenciaTarjetaCredito(esInicial);
		this.setMostrarid_formula_retencionTarjetaCredito(esInicial);
		this.setMostrarid_formula_comisionTarjetaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ID)) {
				this.setMostraridTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.NOMBRECORTO)) {
				this.setMostrarnombre_cortoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.DIGITOVALIDO)) {
				this.setMostrardigito_validoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.DIGITOTARJETA)) {
				this.setMostrardigito_tarjetaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.COMISION)) {
				this.setMostrarcomisionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.INTERES)) {
				this.setMostrarinteresTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.MONTOMINIMO)) {
				this.setMostrarmonto_minimoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setMostrarporcentaje_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.COMISIONRETENCION)) {
				this.setMostrarcomision_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO)) {
				this.setMostrares_retencion_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO)) {
				this.setMostrares_pago_banco_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO)) {
				this.setMostrares_comision_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDTIPORETENCION)) {
				this.setMostrarid_tipo_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setMostrarid_tipo_retencion_ivaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION)) {
				this.setMostrarid_cuenta_contable_comisionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO)) {
				this.setMostrarid_formula_pago_bancoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA)) {
				this.setMostrarid_cuenta_contable_diferenciaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULARETENCION)) {
				this.setMostrarid_formula_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULACOMISION)) {
				this.setMostrarid_formula_comisionTarjetaCredito(esAsigna);
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
		
		
		this.setActivaridTarjetaCredito(esInicial);
		this.setActivarid_empresaTarjetaCredito(esInicial);
		this.setActivarid_sucursalTarjetaCredito(esInicial);
		this.setActivarid_bancoTarjetaCredito(esInicial);
		this.setActivarcodigoTarjetaCredito(esInicial);
		this.setActivarnombreTarjetaCredito(esInicial);
		this.setActivarnombre_cortoTarjetaCredito(esInicial);
		this.setActivardigito_validoTarjetaCredito(esInicial);
		this.setActivardigito_tarjetaTarjetaCredito(esInicial);
		this.setActivarcomisionTarjetaCredito(esInicial);
		this.setActivarinteresTarjetaCredito(esInicial);
		this.setActivarmonto_minimoTarjetaCredito(esInicial);
		this.setActivarporcentaje_retencionTarjetaCredito(esInicial);
		this.setActivarcomision_retencionTarjetaCredito(esInicial);
		this.setActivares_retencion_redondeoTarjetaCredito(esInicial);
		this.setActivares_pago_banco_redondeoTarjetaCredito(esInicial);
		this.setActivares_comision_redondeoTarjetaCredito(esInicial);
		this.setActivarid_tipo_retencionTarjetaCredito(esInicial);
		this.setActivarid_cuenta_contableTarjetaCredito(esInicial);
		this.setActivarid_tipo_retencion_ivaTarjetaCredito(esInicial);
		this.setActivarid_cuenta_contable_comisionTarjetaCredito(esInicial);
		this.setActivarid_formula_pago_bancoTarjetaCredito(esInicial);
		this.setActivarid_cuenta_contable_diferenciaTarjetaCredito(esInicial);
		this.setActivarid_formula_retencionTarjetaCredito(esInicial);
		this.setActivarid_formula_comisionTarjetaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ID)) {
				this.setActivaridTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.NOMBRECORTO)) {
				this.setActivarnombre_cortoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.DIGITOVALIDO)) {
				this.setActivardigito_validoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.DIGITOTARJETA)) {
				this.setActivardigito_tarjetaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.COMISION)) {
				this.setActivarcomisionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.INTERES)) {
				this.setActivarinteresTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.MONTOMINIMO)) {
				this.setActivarmonto_minimoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setActivarporcentaje_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.COMISIONRETENCION)) {
				this.setActivarcomision_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO)) {
				this.setActivares_retencion_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO)) {
				this.setActivares_pago_banco_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO)) {
				this.setActivares_comision_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDTIPORETENCION)) {
				this.setActivarid_tipo_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setActivarid_tipo_retencion_ivaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION)) {
				this.setActivarid_cuenta_contable_comisionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO)) {
				this.setActivarid_formula_pago_bancoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA)) {
				this.setActivarid_cuenta_contable_diferenciaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULARETENCION)) {
				this.setActivarid_formula_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULACOMISION)) {
				this.setActivarid_formula_comisionTarjetaCredito(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTarjetaCredito(esInicial);
		this.setResaltarid_empresaTarjetaCredito(esInicial);
		this.setResaltarid_sucursalTarjetaCredito(esInicial);
		this.setResaltarid_bancoTarjetaCredito(esInicial);
		this.setResaltarcodigoTarjetaCredito(esInicial);
		this.setResaltarnombreTarjetaCredito(esInicial);
		this.setResaltarnombre_cortoTarjetaCredito(esInicial);
		this.setResaltardigito_validoTarjetaCredito(esInicial);
		this.setResaltardigito_tarjetaTarjetaCredito(esInicial);
		this.setResaltarcomisionTarjetaCredito(esInicial);
		this.setResaltarinteresTarjetaCredito(esInicial);
		this.setResaltarmonto_minimoTarjetaCredito(esInicial);
		this.setResaltarporcentaje_retencionTarjetaCredito(esInicial);
		this.setResaltarcomision_retencionTarjetaCredito(esInicial);
		this.setResaltares_retencion_redondeoTarjetaCredito(esInicial);
		this.setResaltares_pago_banco_redondeoTarjetaCredito(esInicial);
		this.setResaltares_comision_redondeoTarjetaCredito(esInicial);
		this.setResaltarid_tipo_retencionTarjetaCredito(esInicial);
		this.setResaltarid_cuenta_contableTarjetaCredito(esInicial);
		this.setResaltarid_tipo_retencion_ivaTarjetaCredito(esInicial);
		this.setResaltarid_cuenta_contable_comisionTarjetaCredito(esInicial);
		this.setResaltarid_formula_pago_bancoTarjetaCredito(esInicial);
		this.setResaltarid_cuenta_contable_diferenciaTarjetaCredito(esInicial);
		this.setResaltarid_formula_retencionTarjetaCredito(esInicial);
		this.setResaltarid_formula_comisionTarjetaCredito(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ID)) {
				this.setResaltaridTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.NOMBRECORTO)) {
				this.setResaltarnombre_cortoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.DIGITOVALIDO)) {
				this.setResaltardigito_validoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.DIGITOTARJETA)) {
				this.setResaltardigito_tarjetaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.COMISION)) {
				this.setResaltarcomisionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.INTERES)) {
				this.setResaltarinteresTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.MONTOMINIMO)) {
				this.setResaltarmonto_minimoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.PORCENTAJERETENCION)) {
				this.setResaltarporcentaje_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.COMISIONRETENCION)) {
				this.setResaltarcomision_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESRETENCIONREDONDEO)) {
				this.setResaltares_retencion_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESPAGOBANCOREDONDEO)) {
				this.setResaltares_pago_banco_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.ESCOMISIONREDONDEO)) {
				this.setResaltares_comision_redondeoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDTIPORETENCION)) {
				this.setResaltarid_tipo_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDTIPORETENCIONIVA)) {
				this.setResaltarid_tipo_retencion_ivaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLECOMISION)) {
				this.setResaltarid_cuenta_contable_comisionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULAPAGOBANCO)) {
				this.setResaltarid_formula_pago_bancoTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDCUENTACONTABLEDIFERENCIA)) {
				this.setResaltarid_cuenta_contable_diferenciaTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULARETENCION)) {
				this.setResaltarid_formula_retencionTarjetaCredito(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoConstantesFunciones.IDFORMULACOMISION)) {
				this.setResaltarid_formula_comisionTarjetaCredito(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarTarjetaCreditoConexionTarjetaCredito=null;

	public Border getResaltarTarjetaCreditoConexionTarjetaCredito() {
		return this.resaltarTarjetaCreditoConexionTarjetaCredito;
	}

	public void setResaltarTarjetaCreditoConexionTarjetaCredito(Border borderResaltarTarjetaCreditoConexion) {
		if(borderResaltarTarjetaCreditoConexion!=null) {
			this.resaltarTarjetaCreditoConexionTarjetaCredito= borderResaltarTarjetaCreditoConexion;
		}
	}

	public Border setResaltarTarjetaCreditoConexionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltarTarjetaCreditoConexion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltarTarjetaCreditoConexion);
			
		this.resaltarTarjetaCreditoConexionTarjetaCredito= borderResaltarTarjetaCreditoConexion;

		 return borderResaltarTarjetaCreditoConexion;
	}



	public Boolean mostrarTarjetaCreditoConexionTarjetaCredito=true;

	public Boolean getMostrarTarjetaCreditoConexionTarjetaCredito() {
		return this.mostrarTarjetaCreditoConexionTarjetaCredito;
	}

	public void setMostrarTarjetaCreditoConexionTarjetaCredito(Boolean visibilidadResaltarTarjetaCreditoConexion) {
		this.mostrarTarjetaCreditoConexionTarjetaCredito= visibilidadResaltarTarjetaCreditoConexion;
	}



	public Boolean activarTarjetaCreditoConexionTarjetaCredito=true;

	public Boolean gethabilitarResaltarTarjetaCreditoConexionTarjetaCredito() {
		return this.activarTarjetaCreditoConexionTarjetaCredito;
	}

	public void setActivarTarjetaCreditoConexionTarjetaCredito(Boolean habilitarResaltarTarjetaCreditoConexion) {
		this.activarTarjetaCreditoConexionTarjetaCredito= habilitarResaltarTarjetaCreditoConexion;
	}


	public Border resaltarTarjetaCreditoDescuentoTarjetaCredito=null;

	public Border getResaltarTarjetaCreditoDescuentoTarjetaCredito() {
		return this.resaltarTarjetaCreditoDescuentoTarjetaCredito;
	}

	public void setResaltarTarjetaCreditoDescuentoTarjetaCredito(Border borderResaltarTarjetaCreditoDescuento) {
		if(borderResaltarTarjetaCreditoDescuento!=null) {
			this.resaltarTarjetaCreditoDescuentoTarjetaCredito= borderResaltarTarjetaCreditoDescuento;
		}
	}

	public Border setResaltarTarjetaCreditoDescuentoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltarTarjetaCreditoDescuento=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltarTarjetaCreditoDescuento);
			
		this.resaltarTarjetaCreditoDescuentoTarjetaCredito= borderResaltarTarjetaCreditoDescuento;

		 return borderResaltarTarjetaCreditoDescuento;
	}



	public Boolean mostrarTarjetaCreditoDescuentoTarjetaCredito=true;

	public Boolean getMostrarTarjetaCreditoDescuentoTarjetaCredito() {
		return this.mostrarTarjetaCreditoDescuentoTarjetaCredito;
	}

	public void setMostrarTarjetaCreditoDescuentoTarjetaCredito(Boolean visibilidadResaltarTarjetaCreditoDescuento) {
		this.mostrarTarjetaCreditoDescuentoTarjetaCredito= visibilidadResaltarTarjetaCreditoDescuento;
	}



	public Boolean activarTarjetaCreditoDescuentoTarjetaCredito=true;

	public Boolean gethabilitarResaltarTarjetaCreditoDescuentoTarjetaCredito() {
		return this.activarTarjetaCreditoDescuentoTarjetaCredito;
	}

	public void setActivarTarjetaCreditoDescuentoTarjetaCredito(Boolean habilitarResaltarTarjetaCreditoDescuento) {
		this.activarTarjetaCreditoDescuentoTarjetaCredito= habilitarResaltarTarjetaCreditoDescuento;
	}


	public Border resaltarFormaPagoPuntoVentaTarjetaCredito=null;

	public Border getResaltarFormaPagoPuntoVentaTarjetaCredito() {
		return this.resaltarFormaPagoPuntoVentaTarjetaCredito;
	}

	public void setResaltarFormaPagoPuntoVentaTarjetaCredito(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaTarjetaCredito= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tarjetacreditoBeanSwingJInternalFrame.jTtoolBarTarjetaCredito.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaTarjetaCredito= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaTarjetaCredito=true;

	public Boolean getMostrarFormaPagoPuntoVentaTarjetaCredito() {
		return this.mostrarFormaPagoPuntoVentaTarjetaCredito;
	}

	public void setMostrarFormaPagoPuntoVentaTarjetaCredito(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaTarjetaCredito= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaTarjetaCredito=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaTarjetaCredito() {
		return this.activarFormaPagoPuntoVentaTarjetaCredito;
	}

	public void setActivarFormaPagoPuntoVentaTarjetaCredito(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaTarjetaCredito= habilitarResaltarFormaPagoPuntoVenta;
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

		this.setMostrarTarjetaCreditoConexionTarjetaCredito(esInicial);
		this.setMostrarTarjetaCreditoDescuentoTarjetaCredito(esInicial);
		this.setMostrarFormaPagoPuntoVentaTarjetaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCreditoConexion.class)) {
				this.setMostrarTarjetaCreditoConexionTarjetaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCreditoDescuento.class)) {
				this.setMostrarTarjetaCreditoDescuentoTarjetaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaTarjetaCredito(esAsigna);
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

		this.setActivarTarjetaCreditoConexionTarjetaCredito(esInicial);
		this.setActivarTarjetaCreditoDescuentoTarjetaCredito(esInicial);
		this.setActivarFormaPagoPuntoVentaTarjetaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCreditoConexion.class)) {
				this.setActivarTarjetaCreditoConexionTarjetaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCreditoDescuento.class)) {
				this.setActivarTarjetaCreditoDescuentoTarjetaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaTarjetaCredito(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarTarjetaCreditoConexionTarjetaCredito(esInicial);
		this.setResaltarTarjetaCreditoDescuentoTarjetaCredito(esInicial);
		this.setResaltarFormaPagoPuntoVentaTarjetaCredito(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(TarjetaCreditoConexion.class)) {
				this.setResaltarTarjetaCreditoConexionTarjetaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(TarjetaCreditoDescuento.class)) {
				this.setResaltarTarjetaCreditoDescuentoTarjetaCredito(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaTarjetaCredito(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdBancoTarjetaCredito=true;

	public Boolean getMostrarFK_IdBancoTarjetaCredito() {
		return this.mostrarFK_IdBancoTarjetaCredito;
	}

	public void setMostrarFK_IdBancoTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableTarjetaCredito=true;

	public Boolean getMostrarFK_IdCuentaContableTarjetaCredito() {
		return this.mostrarFK_IdCuentaContableTarjetaCredito;
	}

	public void setMostrarFK_IdCuentaContableTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableComisionTarjetaCredito=true;

	public Boolean getMostrarFK_IdCuentaContableComisionTarjetaCredito() {
		return this.mostrarFK_IdCuentaContableComisionTarjetaCredito;
	}

	public void setMostrarFK_IdCuentaContableComisionTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableComisionTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDiferenciaTarjetaCredito=true;

	public Boolean getMostrarFK_IdCuentaContableDiferenciaTarjetaCredito() {
		return this.mostrarFK_IdCuentaContableDiferenciaTarjetaCredito;
	}

	public void setMostrarFK_IdCuentaContableDiferenciaTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDiferenciaTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTarjetaCredito=true;

	public Boolean getMostrarFK_IdEmpresaTarjetaCredito() {
		return this.mostrarFK_IdEmpresaTarjetaCredito;
	}

	public void setMostrarFK_IdEmpresaTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormulaComisionTarjetaCredito=true;

	public Boolean getMostrarFK_IdFormulaComisionTarjetaCredito() {
		return this.mostrarFK_IdFormulaComisionTarjetaCredito;
	}

	public void setMostrarFK_IdFormulaComisionTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormulaComisionTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormulaPagoBancoTarjetaCredito=true;

	public Boolean getMostrarFK_IdFormulaPagoBancoTarjetaCredito() {
		return this.mostrarFK_IdFormulaPagoBancoTarjetaCredito;
	}

	public void setMostrarFK_IdFormulaPagoBancoTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormulaPagoBancoTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormulaRetencionTarjetaCredito=true;

	public Boolean getMostrarFK_IdFormulaRetencionTarjetaCredito() {
		return this.mostrarFK_IdFormulaRetencionTarjetaCredito;
	}

	public void setMostrarFK_IdFormulaRetencionTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormulaRetencionTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTarjetaCredito=true;

	public Boolean getMostrarFK_IdSucursalTarjetaCredito() {
		return this.mostrarFK_IdSucursalTarjetaCredito;
	}

	public void setMostrarFK_IdSucursalTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionTarjetaCredito=true;

	public Boolean getMostrarFK_IdTipoRetencionTarjetaCredito() {
		return this.mostrarFK_IdTipoRetencionTarjetaCredito;
	}

	public void setMostrarFK_IdTipoRetencionTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionTarjetaCredito= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoRetencionIvaTarjetaCredito=true;

	public Boolean getMostrarFK_IdTipoRetencionIvaTarjetaCredito() {
		return this.mostrarFK_IdTipoRetencionIvaTarjetaCredito;
	}

	public void setMostrarFK_IdTipoRetencionIvaTarjetaCredito(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoRetencionIvaTarjetaCredito= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoTarjetaCredito=true;

	public Boolean getActivarFK_IdBancoTarjetaCredito() {
		return this.activarFK_IdBancoTarjetaCredito;
	}

	public void setActivarFK_IdBancoTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdBancoTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableTarjetaCredito=true;

	public Boolean getActivarFK_IdCuentaContableTarjetaCredito() {
		return this.activarFK_IdCuentaContableTarjetaCredito;
	}

	public void setActivarFK_IdCuentaContableTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableComisionTarjetaCredito=true;

	public Boolean getActivarFK_IdCuentaContableComisionTarjetaCredito() {
		return this.activarFK_IdCuentaContableComisionTarjetaCredito;
	}

	public void setActivarFK_IdCuentaContableComisionTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableComisionTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDiferenciaTarjetaCredito=true;

	public Boolean getActivarFK_IdCuentaContableDiferenciaTarjetaCredito() {
		return this.activarFK_IdCuentaContableDiferenciaTarjetaCredito;
	}

	public void setActivarFK_IdCuentaContableDiferenciaTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDiferenciaTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTarjetaCredito=true;

	public Boolean getActivarFK_IdEmpresaTarjetaCredito() {
		return this.activarFK_IdEmpresaTarjetaCredito;
	}

	public void setActivarFK_IdEmpresaTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdFormulaComisionTarjetaCredito=true;

	public Boolean getActivarFK_IdFormulaComisionTarjetaCredito() {
		return this.activarFK_IdFormulaComisionTarjetaCredito;
	}

	public void setActivarFK_IdFormulaComisionTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdFormulaComisionTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdFormulaPagoBancoTarjetaCredito=true;

	public Boolean getActivarFK_IdFormulaPagoBancoTarjetaCredito() {
		return this.activarFK_IdFormulaPagoBancoTarjetaCredito;
	}

	public void setActivarFK_IdFormulaPagoBancoTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdFormulaPagoBancoTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdFormulaRetencionTarjetaCredito=true;

	public Boolean getActivarFK_IdFormulaRetencionTarjetaCredito() {
		return this.activarFK_IdFormulaRetencionTarjetaCredito;
	}

	public void setActivarFK_IdFormulaRetencionTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdFormulaRetencionTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTarjetaCredito=true;

	public Boolean getActivarFK_IdSucursalTarjetaCredito() {
		return this.activarFK_IdSucursalTarjetaCredito;
	}

	public void setActivarFK_IdSucursalTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionTarjetaCredito=true;

	public Boolean getActivarFK_IdTipoRetencionTarjetaCredito() {
		return this.activarFK_IdTipoRetencionTarjetaCredito;
	}

	public void setActivarFK_IdTipoRetencionTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionTarjetaCredito= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoRetencionIvaTarjetaCredito=true;

	public Boolean getActivarFK_IdTipoRetencionIvaTarjetaCredito() {
		return this.activarFK_IdTipoRetencionIvaTarjetaCredito;
	}

	public void setActivarFK_IdTipoRetencionIvaTarjetaCredito(Boolean habilitarResaltar) {
		this.activarFK_IdTipoRetencionIvaTarjetaCredito= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoTarjetaCredito=null;

	public Border getResaltarFK_IdBancoTarjetaCredito() {
		return this.resaltarFK_IdBancoTarjetaCredito;
	}

	public void setResaltarFK_IdBancoTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdBancoTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdBancoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableTarjetaCredito=null;

	public Border getResaltarFK_IdCuentaContableTarjetaCredito() {
		return this.resaltarFK_IdCuentaContableTarjetaCredito;
	}

	public void setResaltarFK_IdCuentaContableTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableComisionTarjetaCredito=null;

	public Border getResaltarFK_IdCuentaContableComisionTarjetaCredito() {
		return this.resaltarFK_IdCuentaContableComisionTarjetaCredito;
	}

	public void setResaltarFK_IdCuentaContableComisionTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableComisionTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableComisionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableComisionTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDiferenciaTarjetaCredito=null;

	public Border getResaltarFK_IdCuentaContableDiferenciaTarjetaCredito() {
		return this.resaltarFK_IdCuentaContableDiferenciaTarjetaCredito;
	}

	public void setResaltarFK_IdCuentaContableDiferenciaTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDiferenciaTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDiferenciaTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDiferenciaTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTarjetaCredito=null;

	public Border getResaltarFK_IdEmpresaTarjetaCredito() {
		return this.resaltarFK_IdEmpresaTarjetaCredito;
	}

	public void setResaltarFK_IdEmpresaTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdFormulaComisionTarjetaCredito=null;

	public Border getResaltarFK_IdFormulaComisionTarjetaCredito() {
		return this.resaltarFK_IdFormulaComisionTarjetaCredito;
	}

	public void setResaltarFK_IdFormulaComisionTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdFormulaComisionTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdFormulaComisionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormulaComisionTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdFormulaPagoBancoTarjetaCredito=null;

	public Border getResaltarFK_IdFormulaPagoBancoTarjetaCredito() {
		return this.resaltarFK_IdFormulaPagoBancoTarjetaCredito;
	}

	public void setResaltarFK_IdFormulaPagoBancoTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdFormulaPagoBancoTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdFormulaPagoBancoTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormulaPagoBancoTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdFormulaRetencionTarjetaCredito=null;

	public Border getResaltarFK_IdFormulaRetencionTarjetaCredito() {
		return this.resaltarFK_IdFormulaRetencionTarjetaCredito;
	}

	public void setResaltarFK_IdFormulaRetencionTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdFormulaRetencionTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdFormulaRetencionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormulaRetencionTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTarjetaCredito=null;

	public Border getResaltarFK_IdSucursalTarjetaCredito() {
		return this.resaltarFK_IdSucursalTarjetaCredito;
	}

	public void setResaltarFK_IdSucursalTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdSucursalTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionTarjetaCredito=null;

	public Border getResaltarFK_IdTipoRetencionTarjetaCredito() {
		return this.resaltarFK_IdTipoRetencionTarjetaCredito;
	}

	public void setResaltarFK_IdTipoRetencionTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionTarjetaCredito= borderResaltar;
	}

	public Border resaltarFK_IdTipoRetencionIvaTarjetaCredito=null;

	public Border getResaltarFK_IdTipoRetencionIvaTarjetaCredito() {
		return this.resaltarFK_IdTipoRetencionIvaTarjetaCredito;
	}

	public void setResaltarFK_IdTipoRetencionIvaTarjetaCredito(Border borderResaltar) {
		this.resaltarFK_IdTipoRetencionIvaTarjetaCredito= borderResaltar;
	}

	public void setResaltarFK_IdTipoRetencionIvaTarjetaCredito(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoBeanSwingJInternalFrame tarjetacreditoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoRetencionIvaTarjetaCredito= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}