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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.BalanceGeneralClienteConstantesFunciones;
import com.bydan.erp.cartera.util.BalanceGeneralClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.BalanceGeneralClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BalanceGeneralClienteConstantesFunciones extends BalanceGeneralClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="BalanceGeneralCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BalanceGeneralCliente"+BalanceGeneralClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BalanceGeneralClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BalanceGeneralClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BalanceGeneralClienteConstantesFunciones.SCHEMA+"_"+BalanceGeneralClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BalanceGeneralClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BalanceGeneralClienteConstantesFunciones.SCHEMA+"_"+BalanceGeneralClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BalanceGeneralClienteConstantesFunciones.SCHEMA+"_"+BalanceGeneralClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BalanceGeneralClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BalanceGeneralClienteConstantesFunciones.SCHEMA+"_"+BalanceGeneralClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BalanceGeneralClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BalanceGeneralClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BalanceGeneralClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BalanceGeneralClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BalanceGeneralClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BalanceGeneralClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BalanceGeneralClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BalanceGeneralClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BalanceGeneralClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BalanceGeneralClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Balance General Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Balance General Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Balance General Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BalanceGeneralCliente";
	public static final String OBJECTNAME="balancegeneralcliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="balance_general_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select balancegeneralcliente from "+BalanceGeneralClienteConstantesFunciones.SPERSISTENCENAME+" balancegeneralcliente";
	public static String QUERYSELECTNATIVE="select "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".id,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".version_row,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".id_empresa,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".id_cliente,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".caja_bancos_disponible,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".cuentas_por_cobrar_clientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".inventario,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otros_activos_corrientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_activos_corrientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".bienes_inmuebles,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".bienes_muebles,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otros_activos_no_corrientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_activos_no_corrientes,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".ventas_mensuales,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".costo_ventas_mensuales,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".utilidad_bruta,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".gastos_operativos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".sueldos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".servicios,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".arriendos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".impuestos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".utilidad_operativa,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".gastos_familiares,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".excedente_antes_dividendos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".dividendos_bancos_otros,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".exedente_neto_mensual,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".deudas_bancarias,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".cuentas_por_pagar,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".anticipos_recibos,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otras_cuentas_por_pagar,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otras_deudas_familiares,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_pasivo_corriente,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".deudas_bancarias_largo_plazo,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".otros_pasivos_largo_plazo,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_pasivo_no_corriente,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".total_pasivo,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".patrimonio,"+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME+".descripcion from "+BalanceGeneralClienteConstantesFunciones.SCHEMA+"."+BalanceGeneralClienteConstantesFunciones.TABLENAME;//+" as "+BalanceGeneralClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BalanceGeneralClienteConstantesFuncionesAdditional balancegeneralclienteConstantesFuncionesAdditional=null;
	
	public BalanceGeneralClienteConstantesFuncionesAdditional getBalanceGeneralClienteConstantesFuncionesAdditional() {
		return this.balancegeneralclienteConstantesFuncionesAdditional;
	}
	
	public void setBalanceGeneralClienteConstantesFuncionesAdditional(BalanceGeneralClienteConstantesFuncionesAdditional balancegeneralclienteConstantesFuncionesAdditional) {
		try {
			this.balancegeneralclienteConstantesFuncionesAdditional=balancegeneralclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCLIENTE= "id_cliente";
    public static final String CAJABANCOSDISPONIBLE= "caja_bancos_disponible";
    public static final String CUENTASPORCOBRARCLIENTES= "cuentas_por_cobrar_clientes";
    public static final String INVENTARIO= "inventario";
    public static final String OTROSACTIVOSCORRIENTES= "otros_activos_corrientes";
    public static final String TOTALACTIVOSCORRIENTES= "total_activos_corrientes";
    public static final String BIENESINMUEBLES= "bienes_inmuebles";
    public static final String BIENESMUEBLES= "bienes_muebles";
    public static final String OTROSACTIVOSNOCORRIENTES= "otros_activos_no_corrientes";
    public static final String TOTALACTIVOSNOCORRIENTES= "total_activos_no_corrientes";
    public static final String VENTASMENSUALES= "ventas_mensuales";
    public static final String COSTOVENTASMENSUALES= "costo_ventas_mensuales";
    public static final String UTILIDADBRUTA= "utilidad_bruta";
    public static final String GASTOSOPERATIVOS= "gastos_operativos";
    public static final String SUELDOS= "sueldos";
    public static final String SERVICIOS= "servicios";
    public static final String ARRIENDOS= "arriendos";
    public static final String IMPUESTOS= "impuestos";
    public static final String UTILIDADOPERATIVA= "utilidad_operativa";
    public static final String GASTOSFAMILIARES= "gastos_familiares";
    public static final String EXCEDENTEANTESDIVIDENDOS= "excedente_antes_dividendos";
    public static final String DIVIDENDOSBANCOSOTROS= "dividendos_bancos_otros";
    public static final String EXEDENTENETOMENSUAL= "exedente_neto_mensual";
    public static final String DEUDASBANCARIAS= "deudas_bancarias";
    public static final String CUENTASPORPAGAR= "cuentas_por_pagar";
    public static final String ANTICIPOSRECIBOS= "anticipos_recibos";
    public static final String OTRASCUENTASPORPAGAR= "otras_cuentas_por_pagar";
    public static final String OTRASDEUDASFAMILIARES= "otras_deudas_familiares";
    public static final String TOTALPASIVOCORRIENTE= "total_pasivo_corriente";
    public static final String DEUDASBANCARIASLARGOPLAZO= "deudas_bancarias_largo_plazo";
    public static final String OTROSPASIVOSLARGOPLAZO= "otros_pasivos_largo_plazo";
    public static final String TOTALPASIVONOCORRIENTE= "total_pasivo_no_corriente";
    public static final String TOTALPASIVO= "total_pasivo";
    public static final String PATRIMONIO= "patrimonio";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_CAJABANCOSDISPONIBLE= "Caja Bancos Disponible";
		public static final String LABEL_CAJABANCOSDISPONIBLE_LOWER= "Caja Bancos Disponible";
    	public static final String LABEL_CUENTASPORCOBRARCLIENTES= "Cuentas Por Cobrar Clientes";
		public static final String LABEL_CUENTASPORCOBRARCLIENTES_LOWER= "Cuentas Por Cobrar Clientes";
    	public static final String LABEL_INVENTARIO= "Inventario";
		public static final String LABEL_INVENTARIO_LOWER= "Inventario";
    	public static final String LABEL_OTROSACTIVOSCORRIENTES= "Otros Activos Corrientes";
		public static final String LABEL_OTROSACTIVOSCORRIENTES_LOWER= "Otros Activos Corrientes";
    	public static final String LABEL_TOTALACTIVOSCORRIENTES= "Total Activos Corrientes";
		public static final String LABEL_TOTALACTIVOSCORRIENTES_LOWER= "Total Activos Corrientes";
    	public static final String LABEL_BIENESINMUEBLES= "Bienes Inmuebles";
		public static final String LABEL_BIENESINMUEBLES_LOWER= "Bienes Inmuebles";
    	public static final String LABEL_BIENESMUEBLES= "Bienes Muebles";
		public static final String LABEL_BIENESMUEBLES_LOWER= "Bienes Muebles";
    	public static final String LABEL_OTROSACTIVOSNOCORRIENTES= "Otros Activos No Corrientes";
		public static final String LABEL_OTROSACTIVOSNOCORRIENTES_LOWER= "Otros Activos No Corrientes";
    	public static final String LABEL_TOTALACTIVOSNOCORRIENTES= "Total Activos No Corrientes";
		public static final String LABEL_TOTALACTIVOSNOCORRIENTES_LOWER= "Total Activos No Corrientes";
    	public static final String LABEL_VENTASMENSUALES= "Ventas Mensuales";
		public static final String LABEL_VENTASMENSUALES_LOWER= "Ventas Mensuales";
    	public static final String LABEL_COSTOVENTASMENSUALES= "Costo Ventas Mensuales";
		public static final String LABEL_COSTOVENTASMENSUALES_LOWER= "Costo Ventas Mensuales";
    	public static final String LABEL_UTILIDADBRUTA= "Utilidad Bruta";
		public static final String LABEL_UTILIDADBRUTA_LOWER= "Utilidad Bruta";
    	public static final String LABEL_GASTOSOPERATIVOS= "Gastos Operativos";
		public static final String LABEL_GASTOSOPERATIVOS_LOWER= "Gastos Operativos";
    	public static final String LABEL_SUELDOS= "Sueldos";
		public static final String LABEL_SUELDOS_LOWER= "Sueldos";
    	public static final String LABEL_SERVICIOS= "Servicios";
		public static final String LABEL_SERVICIOS_LOWER= "Servicios";
    	public static final String LABEL_ARRIENDOS= "Arriendos";
		public static final String LABEL_ARRIENDOS_LOWER= "Arriendos";
    	public static final String LABEL_IMPUESTOS= "Impuestos";
		public static final String LABEL_IMPUESTOS_LOWER= "Impuestos";
    	public static final String LABEL_UTILIDADOPERATIVA= "Utilidad Operativa";
		public static final String LABEL_UTILIDADOPERATIVA_LOWER= "Utilidad Operativa";
    	public static final String LABEL_GASTOSFAMILIARES= "Gastos Familiares";
		public static final String LABEL_GASTOSFAMILIARES_LOWER= "Gastos Familiares";
    	public static final String LABEL_EXCEDENTEANTESDIVIDENDOS= "Excedente Antes Dividendos";
		public static final String LABEL_EXCEDENTEANTESDIVIDENDOS_LOWER= "Excedente Antes Dividendos";
    	public static final String LABEL_DIVIDENDOSBANCOSOTROS= "Dividendos Bancos Otros";
		public static final String LABEL_DIVIDENDOSBANCOSOTROS_LOWER= "Dividendos Bancos Otros";
    	public static final String LABEL_EXEDENTENETOMENSUAL= "Exedente Neto Mensual";
		public static final String LABEL_EXEDENTENETOMENSUAL_LOWER= "Exedente Neto Mensual";
    	public static final String LABEL_DEUDASBANCARIAS= "Deudas Bancarias";
		public static final String LABEL_DEUDASBANCARIAS_LOWER= "Deudas Bancarias";
    	public static final String LABEL_CUENTASPORPAGAR= "Cuentas Por Pagar";
		public static final String LABEL_CUENTASPORPAGAR_LOWER= "Cuentas Por Pagar";
    	public static final String LABEL_ANTICIPOSRECIBOS= "Anticipos Recibos";
		public static final String LABEL_ANTICIPOSRECIBOS_LOWER= "Anticipos Recibos";
    	public static final String LABEL_OTRASCUENTASPORPAGAR= "Otras Cuentas Por Pagar";
		public static final String LABEL_OTRASCUENTASPORPAGAR_LOWER= "Otras Cuentas Por Pagar";
    	public static final String LABEL_OTRASDEUDASFAMILIARES= "Otras Deudas Familiares";
		public static final String LABEL_OTRASDEUDASFAMILIARES_LOWER= "Otras Deudas Familiares";
    	public static final String LABEL_TOTALPASIVOCORRIENTE= "Total Pasivo Corriente";
		public static final String LABEL_TOTALPASIVOCORRIENTE_LOWER= "Total Pasivo Corriente";
    	public static final String LABEL_DEUDASBANCARIASLARGOPLAZO= "Deudas Bancarias Largo Plazo";
		public static final String LABEL_DEUDASBANCARIASLARGOPLAZO_LOWER= "Deudas Bancarias Largo Plazo";
    	public static final String LABEL_OTROSPASIVOSLARGOPLAZO= "Otros Pasivos Largo Plazo";
		public static final String LABEL_OTROSPASIVOSLARGOPLAZO_LOWER= "Otros Pasivos Largo Plazo";
    	public static final String LABEL_TOTALPASIVONOCORRIENTE= "Total Pasivo No Corriente";
		public static final String LABEL_TOTALPASIVONOCORRIENTE_LOWER= "Total Pasivo No Corriente";
    	public static final String LABEL_TOTALPASIVO= "Total Pasivo";
		public static final String LABEL_TOTALPASIVO_LOWER= "Total Pasivo";
    	public static final String LABEL_PATRIMONIO= "Patrimonio";
		public static final String LABEL_PATRIMONIO_LOWER= "Patrimonio";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getBalanceGeneralClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.IDCLIENTE)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_CAJABANCOSDISPONIBLE;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORCOBRARCLIENTES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.INVENTARIO)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_INVENTARIO;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSCORRIENTES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSCORRIENTES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_BIENESINMUEBLES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_BIENESMUEBLES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSNOCORRIENTES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSNOCORRIENTES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_VENTASMENSUALES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_COSTOVENTASMENSUALES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADBRUTA;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSOPERATIVOS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.SUELDOS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_SUELDOS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.SERVICIOS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_SERVICIOS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.ARRIENDOS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_ARRIENDOS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.IMPUESTOS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_IMPUESTOS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADOPERATIVA;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSFAMILIARES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_EXCEDENTEANTESDIVIDENDOS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_DIVIDENDOSBANCOSOTROS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_EXEDENTENETOMENSUAL;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIAS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORPAGAR;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_ANTICIPOSRECIBOS;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_OTRASCUENTASPORPAGAR;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_OTRASDEUDASFAMILIARES;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVOCORRIENTE;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIASLARGOPLAZO;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_OTROSPASIVOSLARGOPLAZO;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVONOCORRIENTE;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVO)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVO;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.PATRIMONIO)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_PATRIMONIO;}
		if(sNombreColumna.equals(BalanceGeneralClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=BalanceGeneralClienteConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getBalanceGeneralClienteDescripcion(BalanceGeneralCliente balancegeneralcliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(balancegeneralcliente !=null/* && balancegeneralcliente.getId()!=0*/) {
			if(balancegeneralcliente.getId()!=null) {
				sDescripcion=balancegeneralcliente.getId().toString();
			}//balancegeneralclientebalancegeneralcliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBalanceGeneralClienteDescripcionDetallado(BalanceGeneralCliente balancegeneralcliente) {
		String sDescripcion="";
			
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.ID+"=";
		sDescripcion+=balancegeneralcliente.getId().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=balancegeneralcliente.getVersionRow().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=balancegeneralcliente.getid_empresa().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=balancegeneralcliente.getid_cliente().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE+"=";
		sDescripcion+=balancegeneralcliente.getcaja_bancos_disponible().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES+"=";
		sDescripcion+=balancegeneralcliente.getcuentas_por_cobrar_clientes().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.INVENTARIO+"=";
		sDescripcion+=balancegeneralcliente.getinventario().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES+"=";
		sDescripcion+=balancegeneralcliente.getotros_activos_corrientes().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES+"=";
		sDescripcion+=balancegeneralcliente.gettotal_activos_corrientes().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES+"=";
		sDescripcion+=balancegeneralcliente.getbienes_inmuebles().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES+"=";
		sDescripcion+=balancegeneralcliente.getbienes_muebles().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES+"=";
		sDescripcion+=balancegeneralcliente.getotros_activos_no_corrientes().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES+"=";
		sDescripcion+=balancegeneralcliente.gettotal_activos_no_corrientes().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES+"=";
		sDescripcion+=balancegeneralcliente.getventas_mensuales().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES+"=";
		sDescripcion+=balancegeneralcliente.getcosto_ventas_mensuales().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA+"=";
		sDescripcion+=balancegeneralcliente.getutilidad_bruta().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS+"=";
		sDescripcion+=balancegeneralcliente.getgastos_operativos().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.SUELDOS+"=";
		sDescripcion+=balancegeneralcliente.getsueldos().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.SERVICIOS+"=";
		sDescripcion+=balancegeneralcliente.getservicios().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.ARRIENDOS+"=";
		sDescripcion+=balancegeneralcliente.getarriendos().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.IMPUESTOS+"=";
		sDescripcion+=balancegeneralcliente.getimpuestos().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA+"=";
		sDescripcion+=balancegeneralcliente.getutilidad_operativa().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES+"=";
		sDescripcion+=balancegeneralcliente.getgastos_familiares().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS+"=";
		sDescripcion+=balancegeneralcliente.getexcedente_antes_dividendos().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS+"=";
		sDescripcion+=balancegeneralcliente.getdividendos_bancos_otros().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL+"=";
		sDescripcion+=balancegeneralcliente.getexedente_neto_mensual().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS+"=";
		sDescripcion+=balancegeneralcliente.getdeudas_bancarias().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR+"=";
		sDescripcion+=balancegeneralcliente.getcuentas_por_pagar().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS+"=";
		sDescripcion+=balancegeneralcliente.getanticipos_recibos().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR+"=";
		sDescripcion+=balancegeneralcliente.getotras_cuentas_por_pagar().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES+"=";
		sDescripcion+=balancegeneralcliente.getotras_deudas_familiares().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE+"=";
		sDescripcion+=balancegeneralcliente.gettotal_pasivo_corriente().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO+"=";
		sDescripcion+=balancegeneralcliente.getdeudas_bancarias_largo_plazo().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO+"=";
		sDescripcion+=balancegeneralcliente.getotros_pasivos_largo_plazo().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE+"=";
		sDescripcion+=balancegeneralcliente.gettotal_pasivo_no_corriente().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.TOTALPASIVO+"=";
		sDescripcion+=balancegeneralcliente.gettotal_pasivo().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.PATRIMONIO+"=";
		sDescripcion+=balancegeneralcliente.getpatrimonio().toString()+",";
		sDescripcion+=BalanceGeneralClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=balancegeneralcliente.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setBalanceGeneralClienteDescripcion(BalanceGeneralCliente balancegeneralcliente,String sValor) throws Exception {			
		if(balancegeneralcliente !=null) {
			//balancegeneralclientebalancegeneralcliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBalanceGeneralCliente(BalanceGeneralCliente balancegeneralcliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		balancegeneralcliente.setdescripcion(balancegeneralcliente.getdescripcion().trim());
	}
	
	public static void quitarEspaciosBalanceGeneralClientes(List<BalanceGeneralCliente> balancegeneralclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BalanceGeneralCliente balancegeneralcliente: balancegeneralclientes) {
			balancegeneralcliente.setdescripcion(balancegeneralcliente.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBalanceGeneralCliente(BalanceGeneralCliente balancegeneralcliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && balancegeneralcliente.getConCambioAuxiliar()) {
			balancegeneralcliente.setIsDeleted(balancegeneralcliente.getIsDeletedAuxiliar());	
			balancegeneralcliente.setIsNew(balancegeneralcliente.getIsNewAuxiliar());	
			balancegeneralcliente.setIsChanged(balancegeneralcliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			balancegeneralcliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			balancegeneralcliente.setIsDeletedAuxiliar(false);	
			balancegeneralcliente.setIsNewAuxiliar(false);	
			balancegeneralcliente.setIsChangedAuxiliar(false);
			
			balancegeneralcliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBalanceGeneralClientes(List<BalanceGeneralCliente> balancegeneralclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BalanceGeneralCliente balancegeneralcliente : balancegeneralclientes) {
			if(conAsignarBase && balancegeneralcliente.getConCambioAuxiliar()) {
				balancegeneralcliente.setIsDeleted(balancegeneralcliente.getIsDeletedAuxiliar());	
				balancegeneralcliente.setIsNew(balancegeneralcliente.getIsNewAuxiliar());	
				balancegeneralcliente.setIsChanged(balancegeneralcliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				balancegeneralcliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				balancegeneralcliente.setIsDeletedAuxiliar(false);	
				balancegeneralcliente.setIsNewAuxiliar(false);	
				balancegeneralcliente.setIsChangedAuxiliar(false);
				
				balancegeneralcliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBalanceGeneralCliente(BalanceGeneralCliente balancegeneralcliente,Boolean conEnteros) throws Exception  {
		balancegeneralcliente.setcaja_bancos_disponible(0.0);
		balancegeneralcliente.setcuentas_por_cobrar_clientes(0.0);
		balancegeneralcliente.setinventario(0.0);
		balancegeneralcliente.setotros_activos_corrientes(0.0);
		balancegeneralcliente.settotal_activos_corrientes(0.0);
		balancegeneralcliente.setbienes_inmuebles(0.0);
		balancegeneralcliente.setbienes_muebles(0.0);
		balancegeneralcliente.setotros_activos_no_corrientes(0.0);
		balancegeneralcliente.settotal_activos_no_corrientes(0.0);
		balancegeneralcliente.setventas_mensuales(0.0);
		balancegeneralcliente.setcosto_ventas_mensuales(0.0);
		balancegeneralcliente.setutilidad_bruta(0.0);
		balancegeneralcliente.setgastos_operativos(0.0);
		balancegeneralcliente.setsueldos(0.0);
		balancegeneralcliente.setservicios(0.0);
		balancegeneralcliente.setarriendos(0.0);
		balancegeneralcliente.setimpuestos(0.0);
		balancegeneralcliente.setutilidad_operativa(0.0);
		balancegeneralcliente.setgastos_familiares(0.0);
		balancegeneralcliente.setexcedente_antes_dividendos(0.0);
		balancegeneralcliente.setdividendos_bancos_otros(0.0);
		balancegeneralcliente.setexedente_neto_mensual(0.0);
		balancegeneralcliente.setdeudas_bancarias(0.0);
		balancegeneralcliente.setcuentas_por_pagar(0.0);
		balancegeneralcliente.setanticipos_recibos(0.0);
		balancegeneralcliente.setotras_cuentas_por_pagar(0.0);
		balancegeneralcliente.setotras_deudas_familiares(0.0);
		balancegeneralcliente.settotal_pasivo_corriente(0.0);
		balancegeneralcliente.setdeudas_bancarias_largo_plazo(0.0);
		balancegeneralcliente.setotros_pasivos_largo_plazo(0.0);
		balancegeneralcliente.settotal_pasivo_no_corriente(0.0);
		balancegeneralcliente.settotal_pasivo(0.0);
		balancegeneralcliente.setpatrimonio(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBalanceGeneralClientes(List<BalanceGeneralCliente> balancegeneralclientes,Boolean conEnteros) throws Exception  {
		
		for(BalanceGeneralCliente balancegeneralcliente: balancegeneralclientes) {
			balancegeneralcliente.setcaja_bancos_disponible(0.0);
			balancegeneralcliente.setcuentas_por_cobrar_clientes(0.0);
			balancegeneralcliente.setinventario(0.0);
			balancegeneralcliente.setotros_activos_corrientes(0.0);
			balancegeneralcliente.settotal_activos_corrientes(0.0);
			balancegeneralcliente.setbienes_inmuebles(0.0);
			balancegeneralcliente.setbienes_muebles(0.0);
			balancegeneralcliente.setotros_activos_no_corrientes(0.0);
			balancegeneralcliente.settotal_activos_no_corrientes(0.0);
			balancegeneralcliente.setventas_mensuales(0.0);
			balancegeneralcliente.setcosto_ventas_mensuales(0.0);
			balancegeneralcliente.setutilidad_bruta(0.0);
			balancegeneralcliente.setgastos_operativos(0.0);
			balancegeneralcliente.setsueldos(0.0);
			balancegeneralcliente.setservicios(0.0);
			balancegeneralcliente.setarriendos(0.0);
			balancegeneralcliente.setimpuestos(0.0);
			balancegeneralcliente.setutilidad_operativa(0.0);
			balancegeneralcliente.setgastos_familiares(0.0);
			balancegeneralcliente.setexcedente_antes_dividendos(0.0);
			balancegeneralcliente.setdividendos_bancos_otros(0.0);
			balancegeneralcliente.setexedente_neto_mensual(0.0);
			balancegeneralcliente.setdeudas_bancarias(0.0);
			balancegeneralcliente.setcuentas_por_pagar(0.0);
			balancegeneralcliente.setanticipos_recibos(0.0);
			balancegeneralcliente.setotras_cuentas_por_pagar(0.0);
			balancegeneralcliente.setotras_deudas_familiares(0.0);
			balancegeneralcliente.settotal_pasivo_corriente(0.0);
			balancegeneralcliente.setdeudas_bancarias_largo_plazo(0.0);
			balancegeneralcliente.setotros_pasivos_largo_plazo(0.0);
			balancegeneralcliente.settotal_pasivo_no_corriente(0.0);
			balancegeneralcliente.settotal_pasivo(0.0);
			balancegeneralcliente.setpatrimonio(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBalanceGeneralCliente(List<BalanceGeneralCliente> balancegeneralclientes,BalanceGeneralCliente balancegeneralclienteAux) throws Exception  {
		BalanceGeneralClienteConstantesFunciones.InicializarValoresBalanceGeneralCliente(balancegeneralclienteAux,true);
		
		for(BalanceGeneralCliente balancegeneralcliente: balancegeneralclientes) {
			if(balancegeneralcliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			balancegeneralclienteAux.setcaja_bancos_disponible(balancegeneralclienteAux.getcaja_bancos_disponible()+balancegeneralcliente.getcaja_bancos_disponible());			
			balancegeneralclienteAux.setcuentas_por_cobrar_clientes(balancegeneralclienteAux.getcuentas_por_cobrar_clientes()+balancegeneralcliente.getcuentas_por_cobrar_clientes());			
			balancegeneralclienteAux.setinventario(balancegeneralclienteAux.getinventario()+balancegeneralcliente.getinventario());			
			balancegeneralclienteAux.setotros_activos_corrientes(balancegeneralclienteAux.getotros_activos_corrientes()+balancegeneralcliente.getotros_activos_corrientes());			
			balancegeneralclienteAux.settotal_activos_corrientes(balancegeneralclienteAux.gettotal_activos_corrientes()+balancegeneralcliente.gettotal_activos_corrientes());			
			balancegeneralclienteAux.setbienes_inmuebles(balancegeneralclienteAux.getbienes_inmuebles()+balancegeneralcliente.getbienes_inmuebles());			
			balancegeneralclienteAux.setbienes_muebles(balancegeneralclienteAux.getbienes_muebles()+balancegeneralcliente.getbienes_muebles());			
			balancegeneralclienteAux.setotros_activos_no_corrientes(balancegeneralclienteAux.getotros_activos_no_corrientes()+balancegeneralcliente.getotros_activos_no_corrientes());			
			balancegeneralclienteAux.settotal_activos_no_corrientes(balancegeneralclienteAux.gettotal_activos_no_corrientes()+balancegeneralcliente.gettotal_activos_no_corrientes());			
			balancegeneralclienteAux.setventas_mensuales(balancegeneralclienteAux.getventas_mensuales()+balancegeneralcliente.getventas_mensuales());			
			balancegeneralclienteAux.setcosto_ventas_mensuales(balancegeneralclienteAux.getcosto_ventas_mensuales()+balancegeneralcliente.getcosto_ventas_mensuales());			
			balancegeneralclienteAux.setutilidad_bruta(balancegeneralclienteAux.getutilidad_bruta()+balancegeneralcliente.getutilidad_bruta());			
			balancegeneralclienteAux.setgastos_operativos(balancegeneralclienteAux.getgastos_operativos()+balancegeneralcliente.getgastos_operativos());			
			balancegeneralclienteAux.setsueldos(balancegeneralclienteAux.getsueldos()+balancegeneralcliente.getsueldos());			
			balancegeneralclienteAux.setservicios(balancegeneralclienteAux.getservicios()+balancegeneralcliente.getservicios());			
			balancegeneralclienteAux.setarriendos(balancegeneralclienteAux.getarriendos()+balancegeneralcliente.getarriendos());			
			balancegeneralclienteAux.setimpuestos(balancegeneralclienteAux.getimpuestos()+balancegeneralcliente.getimpuestos());			
			balancegeneralclienteAux.setutilidad_operativa(balancegeneralclienteAux.getutilidad_operativa()+balancegeneralcliente.getutilidad_operativa());			
			balancegeneralclienteAux.setgastos_familiares(balancegeneralclienteAux.getgastos_familiares()+balancegeneralcliente.getgastos_familiares());			
			balancegeneralclienteAux.setexcedente_antes_dividendos(balancegeneralclienteAux.getexcedente_antes_dividendos()+balancegeneralcliente.getexcedente_antes_dividendos());			
			balancegeneralclienteAux.setdividendos_bancos_otros(balancegeneralclienteAux.getdividendos_bancos_otros()+balancegeneralcliente.getdividendos_bancos_otros());			
			balancegeneralclienteAux.setexedente_neto_mensual(balancegeneralclienteAux.getexedente_neto_mensual()+balancegeneralcliente.getexedente_neto_mensual());			
			balancegeneralclienteAux.setdeudas_bancarias(balancegeneralclienteAux.getdeudas_bancarias()+balancegeneralcliente.getdeudas_bancarias());			
			balancegeneralclienteAux.setcuentas_por_pagar(balancegeneralclienteAux.getcuentas_por_pagar()+balancegeneralcliente.getcuentas_por_pagar());			
			balancegeneralclienteAux.setanticipos_recibos(balancegeneralclienteAux.getanticipos_recibos()+balancegeneralcliente.getanticipos_recibos());			
			balancegeneralclienteAux.setotras_cuentas_por_pagar(balancegeneralclienteAux.getotras_cuentas_por_pagar()+balancegeneralcliente.getotras_cuentas_por_pagar());			
			balancegeneralclienteAux.setotras_deudas_familiares(balancegeneralclienteAux.getotras_deudas_familiares()+balancegeneralcliente.getotras_deudas_familiares());			
			balancegeneralclienteAux.settotal_pasivo_corriente(balancegeneralclienteAux.gettotal_pasivo_corriente()+balancegeneralcliente.gettotal_pasivo_corriente());			
			balancegeneralclienteAux.setdeudas_bancarias_largo_plazo(balancegeneralclienteAux.getdeudas_bancarias_largo_plazo()+balancegeneralcliente.getdeudas_bancarias_largo_plazo());			
			balancegeneralclienteAux.setotros_pasivos_largo_plazo(balancegeneralclienteAux.getotros_pasivos_largo_plazo()+balancegeneralcliente.getotros_pasivos_largo_plazo());			
			balancegeneralclienteAux.settotal_pasivo_no_corriente(balancegeneralclienteAux.gettotal_pasivo_no_corriente()+balancegeneralcliente.gettotal_pasivo_no_corriente());			
			balancegeneralclienteAux.settotal_pasivo(balancegeneralclienteAux.gettotal_pasivo()+balancegeneralcliente.gettotal_pasivo());			
			balancegeneralclienteAux.setpatrimonio(balancegeneralclienteAux.getpatrimonio()+balancegeneralcliente.getpatrimonio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBalanceGeneralCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BalanceGeneralClienteConstantesFunciones.getArrayColumnasGlobalesBalanceGeneralCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBalanceGeneralCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BalanceGeneralClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BalanceGeneralClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBalanceGeneralCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BalanceGeneralCliente> balancegeneralclientes,BalanceGeneralCliente balancegeneralcliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BalanceGeneralCliente balancegeneralclienteAux: balancegeneralclientes) {
			if(balancegeneralclienteAux!=null && balancegeneralcliente!=null) {
				if((balancegeneralclienteAux.getId()==null && balancegeneralcliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(balancegeneralclienteAux.getId()!=null && balancegeneralcliente.getId()!=null){
					if(balancegeneralclienteAux.getId().equals(balancegeneralcliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBalanceGeneralCliente(List<BalanceGeneralCliente> balancegeneralclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double caja_bancos_disponibleTotal=0.0;
		Double cuentas_por_cobrar_clientesTotal=0.0;
		Double inventarioTotal=0.0;
		Double otros_activos_corrientesTotal=0.0;
		Double total_activos_corrientesTotal=0.0;
		Double bienes_inmueblesTotal=0.0;
		Double bienes_mueblesTotal=0.0;
		Double otros_activos_no_corrientesTotal=0.0;
		Double total_activos_no_corrientesTotal=0.0;
		Double ventas_mensualesTotal=0.0;
		Double costo_ventas_mensualesTotal=0.0;
		Double utilidad_brutaTotal=0.0;
		Double gastos_operativosTotal=0.0;
		Double sueldosTotal=0.0;
		Double serviciosTotal=0.0;
		Double arriendosTotal=0.0;
		Double impuestosTotal=0.0;
		Double utilidad_operativaTotal=0.0;
		Double gastos_familiaresTotal=0.0;
		Double excedente_antes_dividendosTotal=0.0;
		Double dividendos_bancos_otrosTotal=0.0;
		Double exedente_neto_mensualTotal=0.0;
		Double deudas_bancariasTotal=0.0;
		Double cuentas_por_pagarTotal=0.0;
		Double anticipos_recibosTotal=0.0;
		Double otras_cuentas_por_pagarTotal=0.0;
		Double otras_deudas_familiaresTotal=0.0;
		Double total_pasivo_corrienteTotal=0.0;
		Double deudas_bancarias_largo_plazoTotal=0.0;
		Double otros_pasivos_largo_plazoTotal=0.0;
		Double total_pasivo_no_corrienteTotal=0.0;
		Double total_pasivoTotal=0.0;
		Double patrimonioTotal=0.0;
	
		for(BalanceGeneralCliente balancegeneralcliente: balancegeneralclientes) {			
			if(balancegeneralcliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			caja_bancos_disponibleTotal+=balancegeneralcliente.getcaja_bancos_disponible();
			cuentas_por_cobrar_clientesTotal+=balancegeneralcliente.getcuentas_por_cobrar_clientes();
			inventarioTotal+=balancegeneralcliente.getinventario();
			otros_activos_corrientesTotal+=balancegeneralcliente.getotros_activos_corrientes();
			total_activos_corrientesTotal+=balancegeneralcliente.gettotal_activos_corrientes();
			bienes_inmueblesTotal+=balancegeneralcliente.getbienes_inmuebles();
			bienes_mueblesTotal+=balancegeneralcliente.getbienes_muebles();
			otros_activos_no_corrientesTotal+=balancegeneralcliente.getotros_activos_no_corrientes();
			total_activos_no_corrientesTotal+=balancegeneralcliente.gettotal_activos_no_corrientes();
			ventas_mensualesTotal+=balancegeneralcliente.getventas_mensuales();
			costo_ventas_mensualesTotal+=balancegeneralcliente.getcosto_ventas_mensuales();
			utilidad_brutaTotal+=balancegeneralcliente.getutilidad_bruta();
			gastos_operativosTotal+=balancegeneralcliente.getgastos_operativos();
			sueldosTotal+=balancegeneralcliente.getsueldos();
			serviciosTotal+=balancegeneralcliente.getservicios();
			arriendosTotal+=balancegeneralcliente.getarriendos();
			impuestosTotal+=balancegeneralcliente.getimpuestos();
			utilidad_operativaTotal+=balancegeneralcliente.getutilidad_operativa();
			gastos_familiaresTotal+=balancegeneralcliente.getgastos_familiares();
			excedente_antes_dividendosTotal+=balancegeneralcliente.getexcedente_antes_dividendos();
			dividendos_bancos_otrosTotal+=balancegeneralcliente.getdividendos_bancos_otros();
			exedente_neto_mensualTotal+=balancegeneralcliente.getexedente_neto_mensual();
			deudas_bancariasTotal+=balancegeneralcliente.getdeudas_bancarias();
			cuentas_por_pagarTotal+=balancegeneralcliente.getcuentas_por_pagar();
			anticipos_recibosTotal+=balancegeneralcliente.getanticipos_recibos();
			otras_cuentas_por_pagarTotal+=balancegeneralcliente.getotras_cuentas_por_pagar();
			otras_deudas_familiaresTotal+=balancegeneralcliente.getotras_deudas_familiares();
			total_pasivo_corrienteTotal+=balancegeneralcliente.gettotal_pasivo_corriente();
			deudas_bancarias_largo_plazoTotal+=balancegeneralcliente.getdeudas_bancarias_largo_plazo();
			otros_pasivos_largo_plazoTotal+=balancegeneralcliente.getotros_pasivos_largo_plazo();
			total_pasivo_no_corrienteTotal+=balancegeneralcliente.gettotal_pasivo_no_corriente();
			total_pasivoTotal+=balancegeneralcliente.gettotal_pasivo();
			patrimonioTotal+=balancegeneralcliente.getpatrimonio();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_CAJABANCOSDISPONIBLE);
		datoGeneral.setdValorDouble(caja_bancos_disponibleTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORCOBRARCLIENTES);
		datoGeneral.setdValorDouble(cuentas_por_cobrar_clientesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.INVENTARIO);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_INVENTARIO);
		datoGeneral.setdValorDouble(inventarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSCORRIENTES);
		datoGeneral.setdValorDouble(otros_activos_corrientesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSCORRIENTES);
		datoGeneral.setdValorDouble(total_activos_corrientesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_BIENESINMUEBLES);
		datoGeneral.setdValorDouble(bienes_inmueblesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_BIENESMUEBLES);
		datoGeneral.setdValorDouble(bienes_mueblesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSNOCORRIENTES);
		datoGeneral.setdValorDouble(otros_activos_no_corrientesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSNOCORRIENTES);
		datoGeneral.setdValorDouble(total_activos_no_corrientesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_VENTASMENSUALES);
		datoGeneral.setdValorDouble(ventas_mensualesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_COSTOVENTASMENSUALES);
		datoGeneral.setdValorDouble(costo_ventas_mensualesTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADBRUTA);
		datoGeneral.setdValorDouble(utilidad_brutaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSOPERATIVOS);
		datoGeneral.setdValorDouble(gastos_operativosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.SUELDOS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_SUELDOS);
		datoGeneral.setdValorDouble(sueldosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.SERVICIOS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_SERVICIOS);
		datoGeneral.setdValorDouble(serviciosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.ARRIENDOS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_ARRIENDOS);
		datoGeneral.setdValorDouble(arriendosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.IMPUESTOS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_IMPUESTOS);
		datoGeneral.setdValorDouble(impuestosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADOPERATIVA);
		datoGeneral.setdValorDouble(utilidad_operativaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSFAMILIARES);
		datoGeneral.setdValorDouble(gastos_familiaresTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_EXCEDENTEANTESDIVIDENDOS);
		datoGeneral.setdValorDouble(excedente_antes_dividendosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_DIVIDENDOSBANCOSOTROS);
		datoGeneral.setdValorDouble(dividendos_bancos_otrosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_EXEDENTENETOMENSUAL);
		datoGeneral.setdValorDouble(exedente_neto_mensualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIAS);
		datoGeneral.setdValorDouble(deudas_bancariasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORPAGAR);
		datoGeneral.setdValorDouble(cuentas_por_pagarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_ANTICIPOSRECIBOS);
		datoGeneral.setdValorDouble(anticipos_recibosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTRASCUENTASPORPAGAR);
		datoGeneral.setdValorDouble(otras_cuentas_por_pagarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTRASDEUDASFAMILIARES);
		datoGeneral.setdValorDouble(otras_deudas_familiaresTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVOCORRIENTE);
		datoGeneral.setdValorDouble(total_pasivo_corrienteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIASLARGOPLAZO);
		datoGeneral.setdValorDouble(deudas_bancarias_largo_plazoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSPASIVOSLARGOPLAZO);
		datoGeneral.setdValorDouble(otros_pasivos_largo_plazoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVONOCORRIENTE);
		datoGeneral.setdValorDouble(total_pasivo_no_corrienteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.TOTALPASIVO);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVO);
		datoGeneral.setdValorDouble(total_pasivoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BalanceGeneralClienteConstantesFunciones.PATRIMONIO);
		datoGeneral.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_PATRIMONIO);
		datoGeneral.setdValorDouble(patrimonioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBalanceGeneralCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_ID, BalanceGeneralClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_VERSIONROW, BalanceGeneralClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_IDEMPRESA, BalanceGeneralClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_IDCLIENTE, BalanceGeneralClienteConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_CAJABANCOSDISPONIBLE, BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORCOBRARCLIENTES, BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_INVENTARIO, BalanceGeneralClienteConstantesFunciones.INVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSCORRIENTES, BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSCORRIENTES, BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_BIENESINMUEBLES, BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_BIENESMUEBLES, BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSNOCORRIENTES, BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSNOCORRIENTES, BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_VENTASMENSUALES, BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_COSTOVENTASMENSUALES, BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADBRUTA, BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSOPERATIVOS, BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_SUELDOS, BalanceGeneralClienteConstantesFunciones.SUELDOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_SERVICIOS, BalanceGeneralClienteConstantesFunciones.SERVICIOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_ARRIENDOS, BalanceGeneralClienteConstantesFunciones.ARRIENDOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_IMPUESTOS, BalanceGeneralClienteConstantesFunciones.IMPUESTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADOPERATIVA, BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSFAMILIARES, BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_EXCEDENTEANTESDIVIDENDOS, BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_DIVIDENDOSBANCOSOTROS, BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_EXEDENTENETOMENSUAL, BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIAS, BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORPAGAR, BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_ANTICIPOSRECIBOS, BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_OTRASCUENTASPORPAGAR, BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_OTRASDEUDASFAMILIARES, BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVOCORRIENTE, BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIASLARGOPLAZO, BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_OTROSPASIVOSLARGOPLAZO, BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVONOCORRIENTE, BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVO, BalanceGeneralClienteConstantesFunciones.TOTALPASIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_PATRIMONIO, BalanceGeneralClienteConstantesFunciones.PATRIMONIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BalanceGeneralClienteConstantesFunciones.LABEL_DESCRIPCION, BalanceGeneralClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBalanceGeneralCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.INVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.SUELDOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.SERVICIOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.ARRIENDOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.IMPUESTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.TOTALPASIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.PATRIMONIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BalanceGeneralClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBalanceGeneralCliente() throws Exception  {
		return BalanceGeneralClienteConstantesFunciones.getTiposSeleccionarBalanceGeneralCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBalanceGeneralCliente(Boolean conFk) throws Exception  {
		return BalanceGeneralClienteConstantesFunciones.getTiposSeleccionarBalanceGeneralCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBalanceGeneralCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_CAJABANCOSDISPONIBLE);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_CAJABANCOSDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORCOBRARCLIENTES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORCOBRARCLIENTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_INVENTARIO);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_INVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSCORRIENTES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSCORRIENTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSCORRIENTES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSCORRIENTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_BIENESINMUEBLES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_BIENESINMUEBLES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_BIENESMUEBLES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_BIENESMUEBLES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSNOCORRIENTES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSNOCORRIENTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSNOCORRIENTES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSNOCORRIENTES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_VENTASMENSUALES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_VENTASMENSUALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_COSTOVENTASMENSUALES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_COSTOVENTASMENSUALES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADBRUTA);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADBRUTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSOPERATIVOS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSOPERATIVOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_SUELDOS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_SUELDOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_SERVICIOS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_SERVICIOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_ARRIENDOS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_ARRIENDOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_IMPUESTOS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_IMPUESTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADOPERATIVA);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADOPERATIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSFAMILIARES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSFAMILIARES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_EXCEDENTEANTESDIVIDENDOS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_EXCEDENTEANTESDIVIDENDOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_DIVIDENDOSBANCOSOTROS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_DIVIDENDOSBANCOSOTROS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_EXEDENTENETOMENSUAL);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_EXEDENTENETOMENSUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIAS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORPAGAR);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORPAGAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_ANTICIPOSRECIBOS);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_ANTICIPOSRECIBOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_OTRASCUENTASPORPAGAR);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTRASCUENTASPORPAGAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_OTRASDEUDASFAMILIARES);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTRASDEUDASFAMILIARES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVOCORRIENTE);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVOCORRIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIASLARGOPLAZO);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIASLARGOPLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSPASIVOSLARGOPLAZO);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSPASIVOSLARGOPLAZO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVONOCORRIENTE);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVONOCORRIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVO);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_PATRIMONIO);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_PATRIMONIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BalanceGeneralClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(BalanceGeneralClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBalanceGeneralCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBalanceGeneralCliente(BalanceGeneralCliente balancegeneralclienteAux) throws Exception {
		
			balancegeneralclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(balancegeneralclienteAux.getEmpresa()));
			balancegeneralclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(balancegeneralclienteAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBalanceGeneralCliente(List<BalanceGeneralCliente> balancegeneralclientesTemp) throws Exception {
		for(BalanceGeneralCliente balancegeneralclienteAux:balancegeneralclientesTemp) {
			
			balancegeneralclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(balancegeneralclienteAux.getEmpresa()));
			balancegeneralclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(balancegeneralclienteAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBalanceGeneralCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBalanceGeneralCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBalanceGeneralCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BalanceGeneralClienteConstantesFunciones.getClassesRelationshipsOfBalanceGeneralCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBalanceGeneralCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBalanceGeneralCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BalanceGeneralClienteConstantesFunciones.getClassesRelationshipsFromStringsOfBalanceGeneralCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBalanceGeneralCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(BalanceGeneralCliente balancegeneralcliente,List<BalanceGeneralCliente> balancegeneralclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			BalanceGeneralCliente balancegeneralclienteEncontrado=null;
			
			for(BalanceGeneralCliente balancegeneralclienteLocal:balancegeneralclientes) {
				if(balancegeneralclienteLocal.getId().equals(balancegeneralcliente.getId())) {
					balancegeneralclienteEncontrado=balancegeneralclienteLocal;
					
					balancegeneralclienteLocal.setIsChanged(balancegeneralcliente.getIsChanged());
					balancegeneralclienteLocal.setIsNew(balancegeneralcliente.getIsNew());
					balancegeneralclienteLocal.setIsDeleted(balancegeneralcliente.getIsDeleted());
					
					balancegeneralclienteLocal.setGeneralEntityOriginal(balancegeneralcliente.getGeneralEntityOriginal());
					
					balancegeneralclienteLocal.setId(balancegeneralcliente.getId());	
					balancegeneralclienteLocal.setVersionRow(balancegeneralcliente.getVersionRow());	
					balancegeneralclienteLocal.setid_empresa(balancegeneralcliente.getid_empresa());	
					balancegeneralclienteLocal.setid_cliente(balancegeneralcliente.getid_cliente());	
					balancegeneralclienteLocal.setcaja_bancos_disponible(balancegeneralcliente.getcaja_bancos_disponible());	
					balancegeneralclienteLocal.setcuentas_por_cobrar_clientes(balancegeneralcliente.getcuentas_por_cobrar_clientes());	
					balancegeneralclienteLocal.setinventario(balancegeneralcliente.getinventario());	
					balancegeneralclienteLocal.setotros_activos_corrientes(balancegeneralcliente.getotros_activos_corrientes());	
					balancegeneralclienteLocal.settotal_activos_corrientes(balancegeneralcliente.gettotal_activos_corrientes());	
					balancegeneralclienteLocal.setbienes_inmuebles(balancegeneralcliente.getbienes_inmuebles());	
					balancegeneralclienteLocal.setbienes_muebles(balancegeneralcliente.getbienes_muebles());	
					balancegeneralclienteLocal.setotros_activos_no_corrientes(balancegeneralcliente.getotros_activos_no_corrientes());	
					balancegeneralclienteLocal.settotal_activos_no_corrientes(balancegeneralcliente.gettotal_activos_no_corrientes());	
					balancegeneralclienteLocal.setventas_mensuales(balancegeneralcliente.getventas_mensuales());	
					balancegeneralclienteLocal.setcosto_ventas_mensuales(balancegeneralcliente.getcosto_ventas_mensuales());	
					balancegeneralclienteLocal.setutilidad_bruta(balancegeneralcliente.getutilidad_bruta());	
					balancegeneralclienteLocal.setgastos_operativos(balancegeneralcliente.getgastos_operativos());	
					balancegeneralclienteLocal.setsueldos(balancegeneralcliente.getsueldos());	
					balancegeneralclienteLocal.setservicios(balancegeneralcliente.getservicios());	
					balancegeneralclienteLocal.setarriendos(balancegeneralcliente.getarriendos());	
					balancegeneralclienteLocal.setimpuestos(balancegeneralcliente.getimpuestos());	
					balancegeneralclienteLocal.setutilidad_operativa(balancegeneralcliente.getutilidad_operativa());	
					balancegeneralclienteLocal.setgastos_familiares(balancegeneralcliente.getgastos_familiares());	
					balancegeneralclienteLocal.setexcedente_antes_dividendos(balancegeneralcliente.getexcedente_antes_dividendos());	
					balancegeneralclienteLocal.setdividendos_bancos_otros(balancegeneralcliente.getdividendos_bancos_otros());	
					balancegeneralclienteLocal.setexedente_neto_mensual(balancegeneralcliente.getexedente_neto_mensual());	
					balancegeneralclienteLocal.setdeudas_bancarias(balancegeneralcliente.getdeudas_bancarias());	
					balancegeneralclienteLocal.setcuentas_por_pagar(balancegeneralcliente.getcuentas_por_pagar());	
					balancegeneralclienteLocal.setanticipos_recibos(balancegeneralcliente.getanticipos_recibos());	
					balancegeneralclienteLocal.setotras_cuentas_por_pagar(balancegeneralcliente.getotras_cuentas_por_pagar());	
					balancegeneralclienteLocal.setotras_deudas_familiares(balancegeneralcliente.getotras_deudas_familiares());	
					balancegeneralclienteLocal.settotal_pasivo_corriente(balancegeneralcliente.gettotal_pasivo_corriente());	
					balancegeneralclienteLocal.setdeudas_bancarias_largo_plazo(balancegeneralcliente.getdeudas_bancarias_largo_plazo());	
					balancegeneralclienteLocal.setotros_pasivos_largo_plazo(balancegeneralcliente.getotros_pasivos_largo_plazo());	
					balancegeneralclienteLocal.settotal_pasivo_no_corriente(balancegeneralcliente.gettotal_pasivo_no_corriente());	
					balancegeneralclienteLocal.settotal_pasivo(balancegeneralcliente.gettotal_pasivo());	
					balancegeneralclienteLocal.setpatrimonio(balancegeneralcliente.getpatrimonio());	
					balancegeneralclienteLocal.setdescripcion(balancegeneralcliente.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!balancegeneralcliente.getIsDeleted()) {
				if(!existe) {
					balancegeneralclientes.add(balancegeneralcliente);
				}
			} else {
				if(balancegeneralclienteEncontrado!=null && permiteQuitar)  {
					balancegeneralclientes.remove(balancegeneralclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(BalanceGeneralCliente balancegeneralcliente,List<BalanceGeneralCliente> balancegeneralclientes) throws Exception {
		try	{			
			for(BalanceGeneralCliente balancegeneralclienteLocal:balancegeneralclientes) {
				if(balancegeneralclienteLocal.getId().equals(balancegeneralcliente.getId())) {
					balancegeneralclienteLocal.setIsSelected(balancegeneralcliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBalanceGeneralCliente(List<BalanceGeneralCliente> balancegeneralclientesAux) throws Exception {
		//this.balancegeneralclientesAux=balancegeneralclientesAux;
		
		for(BalanceGeneralCliente balancegeneralclienteAux:balancegeneralclientesAux) {
			if(balancegeneralclienteAux.getIsChanged()) {
				balancegeneralclienteAux.setIsChanged(false);
			}		
			
			if(balancegeneralclienteAux.getIsNew()) {
				balancegeneralclienteAux.setIsNew(false);
			}	
			
			if(balancegeneralclienteAux.getIsDeleted()) {
				balancegeneralclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBalanceGeneralCliente(BalanceGeneralCliente balancegeneralclienteAux) throws Exception {
		//this.balancegeneralclienteAux=balancegeneralclienteAux;
		
			if(balancegeneralclienteAux.getIsChanged()) {
				balancegeneralclienteAux.setIsChanged(false);
			}		
			
			if(balancegeneralclienteAux.getIsNew()) {
				balancegeneralclienteAux.setIsNew(false);
			}	
			
			if(balancegeneralclienteAux.getIsDeleted()) {
				balancegeneralclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BalanceGeneralCliente balancegeneralclienteAsignar,BalanceGeneralCliente balancegeneralcliente) throws Exception {
		balancegeneralclienteAsignar.setId(balancegeneralcliente.getId());	
		balancegeneralclienteAsignar.setVersionRow(balancegeneralcliente.getVersionRow());	
		balancegeneralclienteAsignar.setid_empresa(balancegeneralcliente.getid_empresa());
		balancegeneralclienteAsignar.setempresa_descripcion(balancegeneralcliente.getempresa_descripcion());	
		balancegeneralclienteAsignar.setid_cliente(balancegeneralcliente.getid_cliente());
		balancegeneralclienteAsignar.setcliente_descripcion(balancegeneralcliente.getcliente_descripcion());	
		balancegeneralclienteAsignar.setcaja_bancos_disponible(balancegeneralcliente.getcaja_bancos_disponible());	
		balancegeneralclienteAsignar.setcuentas_por_cobrar_clientes(balancegeneralcliente.getcuentas_por_cobrar_clientes());	
		balancegeneralclienteAsignar.setinventario(balancegeneralcliente.getinventario());	
		balancegeneralclienteAsignar.setotros_activos_corrientes(balancegeneralcliente.getotros_activos_corrientes());	
		balancegeneralclienteAsignar.settotal_activos_corrientes(balancegeneralcliente.gettotal_activos_corrientes());	
		balancegeneralclienteAsignar.setbienes_inmuebles(balancegeneralcliente.getbienes_inmuebles());	
		balancegeneralclienteAsignar.setbienes_muebles(balancegeneralcliente.getbienes_muebles());	
		balancegeneralclienteAsignar.setotros_activos_no_corrientes(balancegeneralcliente.getotros_activos_no_corrientes());	
		balancegeneralclienteAsignar.settotal_activos_no_corrientes(balancegeneralcliente.gettotal_activos_no_corrientes());	
		balancegeneralclienteAsignar.setventas_mensuales(balancegeneralcliente.getventas_mensuales());	
		balancegeneralclienteAsignar.setcosto_ventas_mensuales(balancegeneralcliente.getcosto_ventas_mensuales());	
		balancegeneralclienteAsignar.setutilidad_bruta(balancegeneralcliente.getutilidad_bruta());	
		balancegeneralclienteAsignar.setgastos_operativos(balancegeneralcliente.getgastos_operativos());	
		balancegeneralclienteAsignar.setsueldos(balancegeneralcliente.getsueldos());	
		balancegeneralclienteAsignar.setservicios(balancegeneralcliente.getservicios());	
		balancegeneralclienteAsignar.setarriendos(balancegeneralcliente.getarriendos());	
		balancegeneralclienteAsignar.setimpuestos(balancegeneralcliente.getimpuestos());	
		balancegeneralclienteAsignar.setutilidad_operativa(balancegeneralcliente.getutilidad_operativa());	
		balancegeneralclienteAsignar.setgastos_familiares(balancegeneralcliente.getgastos_familiares());	
		balancegeneralclienteAsignar.setexcedente_antes_dividendos(balancegeneralcliente.getexcedente_antes_dividendos());	
		balancegeneralclienteAsignar.setdividendos_bancos_otros(balancegeneralcliente.getdividendos_bancos_otros());	
		balancegeneralclienteAsignar.setexedente_neto_mensual(balancegeneralcliente.getexedente_neto_mensual());	
		balancegeneralclienteAsignar.setdeudas_bancarias(balancegeneralcliente.getdeudas_bancarias());	
		balancegeneralclienteAsignar.setcuentas_por_pagar(balancegeneralcliente.getcuentas_por_pagar());	
		balancegeneralclienteAsignar.setanticipos_recibos(balancegeneralcliente.getanticipos_recibos());	
		balancegeneralclienteAsignar.setotras_cuentas_por_pagar(balancegeneralcliente.getotras_cuentas_por_pagar());	
		balancegeneralclienteAsignar.setotras_deudas_familiares(balancegeneralcliente.getotras_deudas_familiares());	
		balancegeneralclienteAsignar.settotal_pasivo_corriente(balancegeneralcliente.gettotal_pasivo_corriente());	
		balancegeneralclienteAsignar.setdeudas_bancarias_largo_plazo(balancegeneralcliente.getdeudas_bancarias_largo_plazo());	
		balancegeneralclienteAsignar.setotros_pasivos_largo_plazo(balancegeneralcliente.getotros_pasivos_largo_plazo());	
		balancegeneralclienteAsignar.settotal_pasivo_no_corriente(balancegeneralcliente.gettotal_pasivo_no_corriente());	
		balancegeneralclienteAsignar.settotal_pasivo(balancegeneralcliente.gettotal_pasivo());	
		balancegeneralclienteAsignar.setpatrimonio(balancegeneralcliente.getpatrimonio());	
		balancegeneralclienteAsignar.setdescripcion(balancegeneralcliente.getdescripcion());	
	}
	
	public static void inicializarBalanceGeneralCliente(BalanceGeneralCliente balancegeneralcliente) throws Exception {
		try {
				balancegeneralcliente.setId(0L);	
					
				balancegeneralcliente.setid_empresa(-1L);	
				balancegeneralcliente.setid_cliente(-1L);	
				balancegeneralcliente.setcaja_bancos_disponible(0.0);	
				balancegeneralcliente.setcuentas_por_cobrar_clientes(0.0);	
				balancegeneralcliente.setinventario(0.0);	
				balancegeneralcliente.setotros_activos_corrientes(0.0);	
				balancegeneralcliente.settotal_activos_corrientes(0.0);	
				balancegeneralcliente.setbienes_inmuebles(0.0);	
				balancegeneralcliente.setbienes_muebles(0.0);	
				balancegeneralcliente.setotros_activos_no_corrientes(0.0);	
				balancegeneralcliente.settotal_activos_no_corrientes(0.0);	
				balancegeneralcliente.setventas_mensuales(0.0);	
				balancegeneralcliente.setcosto_ventas_mensuales(0.0);	
				balancegeneralcliente.setutilidad_bruta(0.0);	
				balancegeneralcliente.setgastos_operativos(0.0);	
				balancegeneralcliente.setsueldos(0.0);	
				balancegeneralcliente.setservicios(0.0);	
				balancegeneralcliente.setarriendos(0.0);	
				balancegeneralcliente.setimpuestos(0.0);	
				balancegeneralcliente.setutilidad_operativa(0.0);	
				balancegeneralcliente.setgastos_familiares(0.0);	
				balancegeneralcliente.setexcedente_antes_dividendos(0.0);	
				balancegeneralcliente.setdividendos_bancos_otros(0.0);	
				balancegeneralcliente.setexedente_neto_mensual(0.0);	
				balancegeneralcliente.setdeudas_bancarias(0.0);	
				balancegeneralcliente.setcuentas_por_pagar(0.0);	
				balancegeneralcliente.setanticipos_recibos(0.0);	
				balancegeneralcliente.setotras_cuentas_por_pagar(0.0);	
				balancegeneralcliente.setotras_deudas_familiares(0.0);	
				balancegeneralcliente.settotal_pasivo_corriente(0.0);	
				balancegeneralcliente.setdeudas_bancarias_largo_plazo(0.0);	
				balancegeneralcliente.setotros_pasivos_largo_plazo(0.0);	
				balancegeneralcliente.settotal_pasivo_no_corriente(0.0);	
				balancegeneralcliente.settotal_pasivo(0.0);	
				balancegeneralcliente.setpatrimonio(0.0);	
				balancegeneralcliente.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBalanceGeneralCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_CAJABANCOSDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORCOBRARCLIENTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_INVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSCORRIENTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSCORRIENTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_BIENESINMUEBLES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_BIENESMUEBLES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSACTIVOSNOCORRIENTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALACTIVOSNOCORRIENTES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_VENTASMENSUALES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_COSTOVENTASMENSUALES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADBRUTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSOPERATIVOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_SUELDOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_SERVICIOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_ARRIENDOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_IMPUESTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_UTILIDADOPERATIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_GASTOSFAMILIARES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_EXCEDENTEANTESDIVIDENDOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_DIVIDENDOSBANCOSOTROS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_EXEDENTENETOMENSUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_CUENTASPORPAGAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_ANTICIPOSRECIBOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_OTRASCUENTASPORPAGAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_OTRASDEUDASFAMILIARES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVOCORRIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_DEUDASBANCARIASLARGOPLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_OTROSPASIVOSLARGOPLAZO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVONOCORRIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_TOTALPASIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_PATRIMONIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BalanceGeneralClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBalanceGeneralCliente(String sTipo,Row row,Workbook workbook,BalanceGeneralCliente balancegeneralcliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getcaja_bancos_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getcuentas_por_cobrar_clientes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getinventario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getotros_activos_corrientes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.gettotal_activos_corrientes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getbienes_inmuebles());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getbienes_muebles());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getotros_activos_no_corrientes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.gettotal_activos_no_corrientes());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getventas_mensuales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getcosto_ventas_mensuales());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getutilidad_bruta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getgastos_operativos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getsueldos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getservicios());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getarriendos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getimpuestos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getutilidad_operativa());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getgastos_familiares());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getexcedente_antes_dividendos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getdividendos_bancos_otros());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getexedente_neto_mensual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getdeudas_bancarias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getcuentas_por_pagar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getanticipos_recibos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getotras_cuentas_por_pagar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getotras_deudas_familiares());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.gettotal_pasivo_corriente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getdeudas_bancarias_largo_plazo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getotros_pasivos_largo_plazo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.gettotal_pasivo_no_corriente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.gettotal_pasivo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getpatrimonio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(balancegeneralcliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBalanceGeneralCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBalanceGeneralCliente() {
		return this.sFinalQueryBalanceGeneralCliente;
	}
	
	public void setsFinalQueryBalanceGeneralCliente(String sFinalQueryBalanceGeneralCliente) {
		this.sFinalQueryBalanceGeneralCliente= sFinalQueryBalanceGeneralCliente;
	}
	
	public Border resaltarSeleccionarBalanceGeneralCliente=null;
	
	public Border setResaltarSeleccionarBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBalanceGeneralCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBalanceGeneralCliente() {
		return this.resaltarSeleccionarBalanceGeneralCliente;
	}
	
	public void setResaltarSeleccionarBalanceGeneralCliente(Border borderResaltarSeleccionarBalanceGeneralCliente) {
		this.resaltarSeleccionarBalanceGeneralCliente= borderResaltarSeleccionarBalanceGeneralCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBalanceGeneralCliente=null;
	public Boolean mostraridBalanceGeneralCliente=true;
	public Boolean activaridBalanceGeneralCliente=true;

	public Border resaltarid_empresaBalanceGeneralCliente=null;
	public Boolean mostrarid_empresaBalanceGeneralCliente=true;
	public Boolean activarid_empresaBalanceGeneralCliente=true;
	public Boolean cargarid_empresaBalanceGeneralCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBalanceGeneralCliente=false;//ConEventDepend=true

	public Border resaltarid_clienteBalanceGeneralCliente=null;
	public Boolean mostrarid_clienteBalanceGeneralCliente=true;
	public Boolean activarid_clienteBalanceGeneralCliente=true;
	public Boolean cargarid_clienteBalanceGeneralCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteBalanceGeneralCliente=false;//ConEventDepend=true

	public Border resaltarcaja_bancos_disponibleBalanceGeneralCliente=null;
	public Boolean mostrarcaja_bancos_disponibleBalanceGeneralCliente=true;
	public Boolean activarcaja_bancos_disponibleBalanceGeneralCliente=true;

	public Border resaltarcuentas_por_cobrar_clientesBalanceGeneralCliente=null;
	public Boolean mostrarcuentas_por_cobrar_clientesBalanceGeneralCliente=true;
	public Boolean activarcuentas_por_cobrar_clientesBalanceGeneralCliente=true;

	public Border resaltarinventarioBalanceGeneralCliente=null;
	public Boolean mostrarinventarioBalanceGeneralCliente=true;
	public Boolean activarinventarioBalanceGeneralCliente=true;

	public Border resaltarotros_activos_corrientesBalanceGeneralCliente=null;
	public Boolean mostrarotros_activos_corrientesBalanceGeneralCliente=true;
	public Boolean activarotros_activos_corrientesBalanceGeneralCliente=true;

	public Border resaltartotal_activos_corrientesBalanceGeneralCliente=null;
	public Boolean mostrartotal_activos_corrientesBalanceGeneralCliente=true;
	public Boolean activartotal_activos_corrientesBalanceGeneralCliente=true;

	public Border resaltarbienes_inmueblesBalanceGeneralCliente=null;
	public Boolean mostrarbienes_inmueblesBalanceGeneralCliente=true;
	public Boolean activarbienes_inmueblesBalanceGeneralCliente=true;

	public Border resaltarbienes_mueblesBalanceGeneralCliente=null;
	public Boolean mostrarbienes_mueblesBalanceGeneralCliente=true;
	public Boolean activarbienes_mueblesBalanceGeneralCliente=true;

	public Border resaltarotros_activos_no_corrientesBalanceGeneralCliente=null;
	public Boolean mostrarotros_activos_no_corrientesBalanceGeneralCliente=true;
	public Boolean activarotros_activos_no_corrientesBalanceGeneralCliente=true;

	public Border resaltartotal_activos_no_corrientesBalanceGeneralCliente=null;
	public Boolean mostrartotal_activos_no_corrientesBalanceGeneralCliente=true;
	public Boolean activartotal_activos_no_corrientesBalanceGeneralCliente=true;

	public Border resaltarventas_mensualesBalanceGeneralCliente=null;
	public Boolean mostrarventas_mensualesBalanceGeneralCliente=true;
	public Boolean activarventas_mensualesBalanceGeneralCliente=true;

	public Border resaltarcosto_ventas_mensualesBalanceGeneralCliente=null;
	public Boolean mostrarcosto_ventas_mensualesBalanceGeneralCliente=true;
	public Boolean activarcosto_ventas_mensualesBalanceGeneralCliente=true;

	public Border resaltarutilidad_brutaBalanceGeneralCliente=null;
	public Boolean mostrarutilidad_brutaBalanceGeneralCliente=true;
	public Boolean activarutilidad_brutaBalanceGeneralCliente=true;

	public Border resaltargastos_operativosBalanceGeneralCliente=null;
	public Boolean mostrargastos_operativosBalanceGeneralCliente=true;
	public Boolean activargastos_operativosBalanceGeneralCliente=true;

	public Border resaltarsueldosBalanceGeneralCliente=null;
	public Boolean mostrarsueldosBalanceGeneralCliente=true;
	public Boolean activarsueldosBalanceGeneralCliente=true;

	public Border resaltarserviciosBalanceGeneralCliente=null;
	public Boolean mostrarserviciosBalanceGeneralCliente=true;
	public Boolean activarserviciosBalanceGeneralCliente=true;

	public Border resaltararriendosBalanceGeneralCliente=null;
	public Boolean mostrararriendosBalanceGeneralCliente=true;
	public Boolean activararriendosBalanceGeneralCliente=true;

	public Border resaltarimpuestosBalanceGeneralCliente=null;
	public Boolean mostrarimpuestosBalanceGeneralCliente=true;
	public Boolean activarimpuestosBalanceGeneralCliente=true;

	public Border resaltarutilidad_operativaBalanceGeneralCliente=null;
	public Boolean mostrarutilidad_operativaBalanceGeneralCliente=true;
	public Boolean activarutilidad_operativaBalanceGeneralCliente=true;

	public Border resaltargastos_familiaresBalanceGeneralCliente=null;
	public Boolean mostrargastos_familiaresBalanceGeneralCliente=true;
	public Boolean activargastos_familiaresBalanceGeneralCliente=true;

	public Border resaltarexcedente_antes_dividendosBalanceGeneralCliente=null;
	public Boolean mostrarexcedente_antes_dividendosBalanceGeneralCliente=true;
	public Boolean activarexcedente_antes_dividendosBalanceGeneralCliente=true;

	public Border resaltardividendos_bancos_otrosBalanceGeneralCliente=null;
	public Boolean mostrardividendos_bancos_otrosBalanceGeneralCliente=true;
	public Boolean activardividendos_bancos_otrosBalanceGeneralCliente=true;

	public Border resaltarexedente_neto_mensualBalanceGeneralCliente=null;
	public Boolean mostrarexedente_neto_mensualBalanceGeneralCliente=true;
	public Boolean activarexedente_neto_mensualBalanceGeneralCliente=true;

	public Border resaltardeudas_bancariasBalanceGeneralCliente=null;
	public Boolean mostrardeudas_bancariasBalanceGeneralCliente=true;
	public Boolean activardeudas_bancariasBalanceGeneralCliente=true;

	public Border resaltarcuentas_por_pagarBalanceGeneralCliente=null;
	public Boolean mostrarcuentas_por_pagarBalanceGeneralCliente=true;
	public Boolean activarcuentas_por_pagarBalanceGeneralCliente=true;

	public Border resaltaranticipos_recibosBalanceGeneralCliente=null;
	public Boolean mostraranticipos_recibosBalanceGeneralCliente=true;
	public Boolean activaranticipos_recibosBalanceGeneralCliente=true;

	public Border resaltarotras_cuentas_por_pagarBalanceGeneralCliente=null;
	public Boolean mostrarotras_cuentas_por_pagarBalanceGeneralCliente=true;
	public Boolean activarotras_cuentas_por_pagarBalanceGeneralCliente=true;

	public Border resaltarotras_deudas_familiaresBalanceGeneralCliente=null;
	public Boolean mostrarotras_deudas_familiaresBalanceGeneralCliente=true;
	public Boolean activarotras_deudas_familiaresBalanceGeneralCliente=true;

	public Border resaltartotal_pasivo_corrienteBalanceGeneralCliente=null;
	public Boolean mostrartotal_pasivo_corrienteBalanceGeneralCliente=true;
	public Boolean activartotal_pasivo_corrienteBalanceGeneralCliente=true;

	public Border resaltardeudas_bancarias_largo_plazoBalanceGeneralCliente=null;
	public Boolean mostrardeudas_bancarias_largo_plazoBalanceGeneralCliente=true;
	public Boolean activardeudas_bancarias_largo_plazoBalanceGeneralCliente=true;

	public Border resaltarotros_pasivos_largo_plazoBalanceGeneralCliente=null;
	public Boolean mostrarotros_pasivos_largo_plazoBalanceGeneralCliente=true;
	public Boolean activarotros_pasivos_largo_plazoBalanceGeneralCliente=true;

	public Border resaltartotal_pasivo_no_corrienteBalanceGeneralCliente=null;
	public Boolean mostrartotal_pasivo_no_corrienteBalanceGeneralCliente=true;
	public Boolean activartotal_pasivo_no_corrienteBalanceGeneralCliente=true;

	public Border resaltartotal_pasivoBalanceGeneralCliente=null;
	public Boolean mostrartotal_pasivoBalanceGeneralCliente=true;
	public Boolean activartotal_pasivoBalanceGeneralCliente=true;

	public Border resaltarpatrimonioBalanceGeneralCliente=null;
	public Boolean mostrarpatrimonioBalanceGeneralCliente=true;
	public Boolean activarpatrimonioBalanceGeneralCliente=true;

	public Border resaltardescripcionBalanceGeneralCliente=null;
	public Boolean mostrardescripcionBalanceGeneralCliente=true;
	public Boolean activardescripcionBalanceGeneralCliente=true;

	
	

	public Border setResaltaridBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltaridBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBalanceGeneralCliente() {
		return this.resaltaridBalanceGeneralCliente;
	}

	public void setResaltaridBalanceGeneralCliente(Border borderResaltar) {
		this.resaltaridBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostraridBalanceGeneralCliente() {
		return this.mostraridBalanceGeneralCliente;
	}

	public void setMostraridBalanceGeneralCliente(Boolean mostraridBalanceGeneralCliente) {
		this.mostraridBalanceGeneralCliente= mostraridBalanceGeneralCliente;
	}

	public Boolean getActivaridBalanceGeneralCliente() {
		return this.activaridBalanceGeneralCliente;
	}

	public void setActivaridBalanceGeneralCliente(Boolean activaridBalanceGeneralCliente) {
		this.activaridBalanceGeneralCliente= activaridBalanceGeneralCliente;
	}

	public Border setResaltarid_empresaBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBalanceGeneralCliente() {
		return this.resaltarid_empresaBalanceGeneralCliente;
	}

	public void setResaltarid_empresaBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarid_empresaBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaBalanceGeneralCliente() {
		return this.mostrarid_empresaBalanceGeneralCliente;
	}

	public void setMostrarid_empresaBalanceGeneralCliente(Boolean mostrarid_empresaBalanceGeneralCliente) {
		this.mostrarid_empresaBalanceGeneralCliente= mostrarid_empresaBalanceGeneralCliente;
	}

	public Boolean getActivarid_empresaBalanceGeneralCliente() {
		return this.activarid_empresaBalanceGeneralCliente;
	}

	public void setActivarid_empresaBalanceGeneralCliente(Boolean activarid_empresaBalanceGeneralCliente) {
		this.activarid_empresaBalanceGeneralCliente= activarid_empresaBalanceGeneralCliente;
	}

	public Boolean getCargarid_empresaBalanceGeneralCliente() {
		return this.cargarid_empresaBalanceGeneralCliente;
	}

	public void setCargarid_empresaBalanceGeneralCliente(Boolean cargarid_empresaBalanceGeneralCliente) {
		this.cargarid_empresaBalanceGeneralCliente= cargarid_empresaBalanceGeneralCliente;
	}

	public Border setResaltarid_clienteBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarid_clienteBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteBalanceGeneralCliente() {
		return this.resaltarid_clienteBalanceGeneralCliente;
	}

	public void setResaltarid_clienteBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarid_clienteBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarid_clienteBalanceGeneralCliente() {
		return this.mostrarid_clienteBalanceGeneralCliente;
	}

	public void setMostrarid_clienteBalanceGeneralCliente(Boolean mostrarid_clienteBalanceGeneralCliente) {
		this.mostrarid_clienteBalanceGeneralCliente= mostrarid_clienteBalanceGeneralCliente;
	}

	public Boolean getActivarid_clienteBalanceGeneralCliente() {
		return this.activarid_clienteBalanceGeneralCliente;
	}

	public void setActivarid_clienteBalanceGeneralCliente(Boolean activarid_clienteBalanceGeneralCliente) {
		this.activarid_clienteBalanceGeneralCliente= activarid_clienteBalanceGeneralCliente;
	}

	public Boolean getCargarid_clienteBalanceGeneralCliente() {
		return this.cargarid_clienteBalanceGeneralCliente;
	}

	public void setCargarid_clienteBalanceGeneralCliente(Boolean cargarid_clienteBalanceGeneralCliente) {
		this.cargarid_clienteBalanceGeneralCliente= cargarid_clienteBalanceGeneralCliente;
	}

	public Border setResaltarcaja_bancos_disponibleBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarcaja_bancos_disponibleBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcaja_bancos_disponibleBalanceGeneralCliente() {
		return this.resaltarcaja_bancos_disponibleBalanceGeneralCliente;
	}

	public void setResaltarcaja_bancos_disponibleBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarcaja_bancos_disponibleBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarcaja_bancos_disponibleBalanceGeneralCliente() {
		return this.mostrarcaja_bancos_disponibleBalanceGeneralCliente;
	}

	public void setMostrarcaja_bancos_disponibleBalanceGeneralCliente(Boolean mostrarcaja_bancos_disponibleBalanceGeneralCliente) {
		this.mostrarcaja_bancos_disponibleBalanceGeneralCliente= mostrarcaja_bancos_disponibleBalanceGeneralCliente;
	}

	public Boolean getActivarcaja_bancos_disponibleBalanceGeneralCliente() {
		return this.activarcaja_bancos_disponibleBalanceGeneralCliente;
	}

	public void setActivarcaja_bancos_disponibleBalanceGeneralCliente(Boolean activarcaja_bancos_disponibleBalanceGeneralCliente) {
		this.activarcaja_bancos_disponibleBalanceGeneralCliente= activarcaja_bancos_disponibleBalanceGeneralCliente;
	}

	public Border setResaltarcuentas_por_cobrar_clientesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarcuentas_por_cobrar_clientesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcuentas_por_cobrar_clientesBalanceGeneralCliente() {
		return this.resaltarcuentas_por_cobrar_clientesBalanceGeneralCliente;
	}

	public void setResaltarcuentas_por_cobrar_clientesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarcuentas_por_cobrar_clientesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarcuentas_por_cobrar_clientesBalanceGeneralCliente() {
		return this.mostrarcuentas_por_cobrar_clientesBalanceGeneralCliente;
	}

	public void setMostrarcuentas_por_cobrar_clientesBalanceGeneralCliente(Boolean mostrarcuentas_por_cobrar_clientesBalanceGeneralCliente) {
		this.mostrarcuentas_por_cobrar_clientesBalanceGeneralCliente= mostrarcuentas_por_cobrar_clientesBalanceGeneralCliente;
	}

	public Boolean getActivarcuentas_por_cobrar_clientesBalanceGeneralCliente() {
		return this.activarcuentas_por_cobrar_clientesBalanceGeneralCliente;
	}

	public void setActivarcuentas_por_cobrar_clientesBalanceGeneralCliente(Boolean activarcuentas_por_cobrar_clientesBalanceGeneralCliente) {
		this.activarcuentas_por_cobrar_clientesBalanceGeneralCliente= activarcuentas_por_cobrar_clientesBalanceGeneralCliente;
	}

	public Border setResaltarinventarioBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarinventarioBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarinventarioBalanceGeneralCliente() {
		return this.resaltarinventarioBalanceGeneralCliente;
	}

	public void setResaltarinventarioBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarinventarioBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarinventarioBalanceGeneralCliente() {
		return this.mostrarinventarioBalanceGeneralCliente;
	}

	public void setMostrarinventarioBalanceGeneralCliente(Boolean mostrarinventarioBalanceGeneralCliente) {
		this.mostrarinventarioBalanceGeneralCliente= mostrarinventarioBalanceGeneralCliente;
	}

	public Boolean getActivarinventarioBalanceGeneralCliente() {
		return this.activarinventarioBalanceGeneralCliente;
	}

	public void setActivarinventarioBalanceGeneralCliente(Boolean activarinventarioBalanceGeneralCliente) {
		this.activarinventarioBalanceGeneralCliente= activarinventarioBalanceGeneralCliente;
	}

	public Border setResaltarotros_activos_corrientesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarotros_activos_corrientesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotros_activos_corrientesBalanceGeneralCliente() {
		return this.resaltarotros_activos_corrientesBalanceGeneralCliente;
	}

	public void setResaltarotros_activos_corrientesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarotros_activos_corrientesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarotros_activos_corrientesBalanceGeneralCliente() {
		return this.mostrarotros_activos_corrientesBalanceGeneralCliente;
	}

	public void setMostrarotros_activos_corrientesBalanceGeneralCliente(Boolean mostrarotros_activos_corrientesBalanceGeneralCliente) {
		this.mostrarotros_activos_corrientesBalanceGeneralCliente= mostrarotros_activos_corrientesBalanceGeneralCliente;
	}

	public Boolean getActivarotros_activos_corrientesBalanceGeneralCliente() {
		return this.activarotros_activos_corrientesBalanceGeneralCliente;
	}

	public void setActivarotros_activos_corrientesBalanceGeneralCliente(Boolean activarotros_activos_corrientesBalanceGeneralCliente) {
		this.activarotros_activos_corrientesBalanceGeneralCliente= activarotros_activos_corrientesBalanceGeneralCliente;
	}

	public Border setResaltartotal_activos_corrientesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltartotal_activos_corrientesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_activos_corrientesBalanceGeneralCliente() {
		return this.resaltartotal_activos_corrientesBalanceGeneralCliente;
	}

	public void setResaltartotal_activos_corrientesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltartotal_activos_corrientesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrartotal_activos_corrientesBalanceGeneralCliente() {
		return this.mostrartotal_activos_corrientesBalanceGeneralCliente;
	}

	public void setMostrartotal_activos_corrientesBalanceGeneralCliente(Boolean mostrartotal_activos_corrientesBalanceGeneralCliente) {
		this.mostrartotal_activos_corrientesBalanceGeneralCliente= mostrartotal_activos_corrientesBalanceGeneralCliente;
	}

	public Boolean getActivartotal_activos_corrientesBalanceGeneralCliente() {
		return this.activartotal_activos_corrientesBalanceGeneralCliente;
	}

	public void setActivartotal_activos_corrientesBalanceGeneralCliente(Boolean activartotal_activos_corrientesBalanceGeneralCliente) {
		this.activartotal_activos_corrientesBalanceGeneralCliente= activartotal_activos_corrientesBalanceGeneralCliente;
	}

	public Border setResaltarbienes_inmueblesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarbienes_inmueblesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_inmueblesBalanceGeneralCliente() {
		return this.resaltarbienes_inmueblesBalanceGeneralCliente;
	}

	public void setResaltarbienes_inmueblesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarbienes_inmueblesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarbienes_inmueblesBalanceGeneralCliente() {
		return this.mostrarbienes_inmueblesBalanceGeneralCliente;
	}

	public void setMostrarbienes_inmueblesBalanceGeneralCliente(Boolean mostrarbienes_inmueblesBalanceGeneralCliente) {
		this.mostrarbienes_inmueblesBalanceGeneralCliente= mostrarbienes_inmueblesBalanceGeneralCliente;
	}

	public Boolean getActivarbienes_inmueblesBalanceGeneralCliente() {
		return this.activarbienes_inmueblesBalanceGeneralCliente;
	}

	public void setActivarbienes_inmueblesBalanceGeneralCliente(Boolean activarbienes_inmueblesBalanceGeneralCliente) {
		this.activarbienes_inmueblesBalanceGeneralCliente= activarbienes_inmueblesBalanceGeneralCliente;
	}

	public Border setResaltarbienes_mueblesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarbienes_mueblesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbienes_mueblesBalanceGeneralCliente() {
		return this.resaltarbienes_mueblesBalanceGeneralCliente;
	}

	public void setResaltarbienes_mueblesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarbienes_mueblesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarbienes_mueblesBalanceGeneralCliente() {
		return this.mostrarbienes_mueblesBalanceGeneralCliente;
	}

	public void setMostrarbienes_mueblesBalanceGeneralCliente(Boolean mostrarbienes_mueblesBalanceGeneralCliente) {
		this.mostrarbienes_mueblesBalanceGeneralCliente= mostrarbienes_mueblesBalanceGeneralCliente;
	}

	public Boolean getActivarbienes_mueblesBalanceGeneralCliente() {
		return this.activarbienes_mueblesBalanceGeneralCliente;
	}

	public void setActivarbienes_mueblesBalanceGeneralCliente(Boolean activarbienes_mueblesBalanceGeneralCliente) {
		this.activarbienes_mueblesBalanceGeneralCliente= activarbienes_mueblesBalanceGeneralCliente;
	}

	public Border setResaltarotros_activos_no_corrientesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarotros_activos_no_corrientesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotros_activos_no_corrientesBalanceGeneralCliente() {
		return this.resaltarotros_activos_no_corrientesBalanceGeneralCliente;
	}

	public void setResaltarotros_activos_no_corrientesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarotros_activos_no_corrientesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarotros_activos_no_corrientesBalanceGeneralCliente() {
		return this.mostrarotros_activos_no_corrientesBalanceGeneralCliente;
	}

	public void setMostrarotros_activos_no_corrientesBalanceGeneralCliente(Boolean mostrarotros_activos_no_corrientesBalanceGeneralCliente) {
		this.mostrarotros_activos_no_corrientesBalanceGeneralCliente= mostrarotros_activos_no_corrientesBalanceGeneralCliente;
	}

	public Boolean getActivarotros_activos_no_corrientesBalanceGeneralCliente() {
		return this.activarotros_activos_no_corrientesBalanceGeneralCliente;
	}

	public void setActivarotros_activos_no_corrientesBalanceGeneralCliente(Boolean activarotros_activos_no_corrientesBalanceGeneralCliente) {
		this.activarotros_activos_no_corrientesBalanceGeneralCliente= activarotros_activos_no_corrientesBalanceGeneralCliente;
	}

	public Border setResaltartotal_activos_no_corrientesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltartotal_activos_no_corrientesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_activos_no_corrientesBalanceGeneralCliente() {
		return this.resaltartotal_activos_no_corrientesBalanceGeneralCliente;
	}

	public void setResaltartotal_activos_no_corrientesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltartotal_activos_no_corrientesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrartotal_activos_no_corrientesBalanceGeneralCliente() {
		return this.mostrartotal_activos_no_corrientesBalanceGeneralCliente;
	}

	public void setMostrartotal_activos_no_corrientesBalanceGeneralCliente(Boolean mostrartotal_activos_no_corrientesBalanceGeneralCliente) {
		this.mostrartotal_activos_no_corrientesBalanceGeneralCliente= mostrartotal_activos_no_corrientesBalanceGeneralCliente;
	}

	public Boolean getActivartotal_activos_no_corrientesBalanceGeneralCliente() {
		return this.activartotal_activos_no_corrientesBalanceGeneralCliente;
	}

	public void setActivartotal_activos_no_corrientesBalanceGeneralCliente(Boolean activartotal_activos_no_corrientesBalanceGeneralCliente) {
		this.activartotal_activos_no_corrientesBalanceGeneralCliente= activartotal_activos_no_corrientesBalanceGeneralCliente;
	}

	public Border setResaltarventas_mensualesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarventas_mensualesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarventas_mensualesBalanceGeneralCliente() {
		return this.resaltarventas_mensualesBalanceGeneralCliente;
	}

	public void setResaltarventas_mensualesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarventas_mensualesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarventas_mensualesBalanceGeneralCliente() {
		return this.mostrarventas_mensualesBalanceGeneralCliente;
	}

	public void setMostrarventas_mensualesBalanceGeneralCliente(Boolean mostrarventas_mensualesBalanceGeneralCliente) {
		this.mostrarventas_mensualesBalanceGeneralCliente= mostrarventas_mensualesBalanceGeneralCliente;
	}

	public Boolean getActivarventas_mensualesBalanceGeneralCliente() {
		return this.activarventas_mensualesBalanceGeneralCliente;
	}

	public void setActivarventas_mensualesBalanceGeneralCliente(Boolean activarventas_mensualesBalanceGeneralCliente) {
		this.activarventas_mensualesBalanceGeneralCliente= activarventas_mensualesBalanceGeneralCliente;
	}

	public Border setResaltarcosto_ventas_mensualesBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarcosto_ventas_mensualesBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_ventas_mensualesBalanceGeneralCliente() {
		return this.resaltarcosto_ventas_mensualesBalanceGeneralCliente;
	}

	public void setResaltarcosto_ventas_mensualesBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarcosto_ventas_mensualesBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarcosto_ventas_mensualesBalanceGeneralCliente() {
		return this.mostrarcosto_ventas_mensualesBalanceGeneralCliente;
	}

	public void setMostrarcosto_ventas_mensualesBalanceGeneralCliente(Boolean mostrarcosto_ventas_mensualesBalanceGeneralCliente) {
		this.mostrarcosto_ventas_mensualesBalanceGeneralCliente= mostrarcosto_ventas_mensualesBalanceGeneralCliente;
	}

	public Boolean getActivarcosto_ventas_mensualesBalanceGeneralCliente() {
		return this.activarcosto_ventas_mensualesBalanceGeneralCliente;
	}

	public void setActivarcosto_ventas_mensualesBalanceGeneralCliente(Boolean activarcosto_ventas_mensualesBalanceGeneralCliente) {
		this.activarcosto_ventas_mensualesBalanceGeneralCliente= activarcosto_ventas_mensualesBalanceGeneralCliente;
	}

	public Border setResaltarutilidad_brutaBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarutilidad_brutaBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidad_brutaBalanceGeneralCliente() {
		return this.resaltarutilidad_brutaBalanceGeneralCliente;
	}

	public void setResaltarutilidad_brutaBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarutilidad_brutaBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarutilidad_brutaBalanceGeneralCliente() {
		return this.mostrarutilidad_brutaBalanceGeneralCliente;
	}

	public void setMostrarutilidad_brutaBalanceGeneralCliente(Boolean mostrarutilidad_brutaBalanceGeneralCliente) {
		this.mostrarutilidad_brutaBalanceGeneralCliente= mostrarutilidad_brutaBalanceGeneralCliente;
	}

	public Boolean getActivarutilidad_brutaBalanceGeneralCliente() {
		return this.activarutilidad_brutaBalanceGeneralCliente;
	}

	public void setActivarutilidad_brutaBalanceGeneralCliente(Boolean activarutilidad_brutaBalanceGeneralCliente) {
		this.activarutilidad_brutaBalanceGeneralCliente= activarutilidad_brutaBalanceGeneralCliente;
	}

	public Border setResaltargastos_operativosBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltargastos_operativosBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargastos_operativosBalanceGeneralCliente() {
		return this.resaltargastos_operativosBalanceGeneralCliente;
	}

	public void setResaltargastos_operativosBalanceGeneralCliente(Border borderResaltar) {
		this.resaltargastos_operativosBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrargastos_operativosBalanceGeneralCliente() {
		return this.mostrargastos_operativosBalanceGeneralCliente;
	}

	public void setMostrargastos_operativosBalanceGeneralCliente(Boolean mostrargastos_operativosBalanceGeneralCliente) {
		this.mostrargastos_operativosBalanceGeneralCliente= mostrargastos_operativosBalanceGeneralCliente;
	}

	public Boolean getActivargastos_operativosBalanceGeneralCliente() {
		return this.activargastos_operativosBalanceGeneralCliente;
	}

	public void setActivargastos_operativosBalanceGeneralCliente(Boolean activargastos_operativosBalanceGeneralCliente) {
		this.activargastos_operativosBalanceGeneralCliente= activargastos_operativosBalanceGeneralCliente;
	}

	public Border setResaltarsueldosBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarsueldosBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsueldosBalanceGeneralCliente() {
		return this.resaltarsueldosBalanceGeneralCliente;
	}

	public void setResaltarsueldosBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarsueldosBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarsueldosBalanceGeneralCliente() {
		return this.mostrarsueldosBalanceGeneralCliente;
	}

	public void setMostrarsueldosBalanceGeneralCliente(Boolean mostrarsueldosBalanceGeneralCliente) {
		this.mostrarsueldosBalanceGeneralCliente= mostrarsueldosBalanceGeneralCliente;
	}

	public Boolean getActivarsueldosBalanceGeneralCliente() {
		return this.activarsueldosBalanceGeneralCliente;
	}

	public void setActivarsueldosBalanceGeneralCliente(Boolean activarsueldosBalanceGeneralCliente) {
		this.activarsueldosBalanceGeneralCliente= activarsueldosBalanceGeneralCliente;
	}

	public Border setResaltarserviciosBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarserviciosBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarserviciosBalanceGeneralCliente() {
		return this.resaltarserviciosBalanceGeneralCliente;
	}

	public void setResaltarserviciosBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarserviciosBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarserviciosBalanceGeneralCliente() {
		return this.mostrarserviciosBalanceGeneralCliente;
	}

	public void setMostrarserviciosBalanceGeneralCliente(Boolean mostrarserviciosBalanceGeneralCliente) {
		this.mostrarserviciosBalanceGeneralCliente= mostrarserviciosBalanceGeneralCliente;
	}

	public Boolean getActivarserviciosBalanceGeneralCliente() {
		return this.activarserviciosBalanceGeneralCliente;
	}

	public void setActivarserviciosBalanceGeneralCliente(Boolean activarserviciosBalanceGeneralCliente) {
		this.activarserviciosBalanceGeneralCliente= activarserviciosBalanceGeneralCliente;
	}

	public Border setResaltararriendosBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltararriendosBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltararriendosBalanceGeneralCliente() {
		return this.resaltararriendosBalanceGeneralCliente;
	}

	public void setResaltararriendosBalanceGeneralCliente(Border borderResaltar) {
		this.resaltararriendosBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrararriendosBalanceGeneralCliente() {
		return this.mostrararriendosBalanceGeneralCliente;
	}

	public void setMostrararriendosBalanceGeneralCliente(Boolean mostrararriendosBalanceGeneralCliente) {
		this.mostrararriendosBalanceGeneralCliente= mostrararriendosBalanceGeneralCliente;
	}

	public Boolean getActivararriendosBalanceGeneralCliente() {
		return this.activararriendosBalanceGeneralCliente;
	}

	public void setActivararriendosBalanceGeneralCliente(Boolean activararriendosBalanceGeneralCliente) {
		this.activararriendosBalanceGeneralCliente= activararriendosBalanceGeneralCliente;
	}

	public Border setResaltarimpuestosBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarimpuestosBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestosBalanceGeneralCliente() {
		return this.resaltarimpuestosBalanceGeneralCliente;
	}

	public void setResaltarimpuestosBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarimpuestosBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarimpuestosBalanceGeneralCliente() {
		return this.mostrarimpuestosBalanceGeneralCliente;
	}

	public void setMostrarimpuestosBalanceGeneralCliente(Boolean mostrarimpuestosBalanceGeneralCliente) {
		this.mostrarimpuestosBalanceGeneralCliente= mostrarimpuestosBalanceGeneralCliente;
	}

	public Boolean getActivarimpuestosBalanceGeneralCliente() {
		return this.activarimpuestosBalanceGeneralCliente;
	}

	public void setActivarimpuestosBalanceGeneralCliente(Boolean activarimpuestosBalanceGeneralCliente) {
		this.activarimpuestosBalanceGeneralCliente= activarimpuestosBalanceGeneralCliente;
	}

	public Border setResaltarutilidad_operativaBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarutilidad_operativaBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarutilidad_operativaBalanceGeneralCliente() {
		return this.resaltarutilidad_operativaBalanceGeneralCliente;
	}

	public void setResaltarutilidad_operativaBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarutilidad_operativaBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarutilidad_operativaBalanceGeneralCliente() {
		return this.mostrarutilidad_operativaBalanceGeneralCliente;
	}

	public void setMostrarutilidad_operativaBalanceGeneralCliente(Boolean mostrarutilidad_operativaBalanceGeneralCliente) {
		this.mostrarutilidad_operativaBalanceGeneralCliente= mostrarutilidad_operativaBalanceGeneralCliente;
	}

	public Boolean getActivarutilidad_operativaBalanceGeneralCliente() {
		return this.activarutilidad_operativaBalanceGeneralCliente;
	}

	public void setActivarutilidad_operativaBalanceGeneralCliente(Boolean activarutilidad_operativaBalanceGeneralCliente) {
		this.activarutilidad_operativaBalanceGeneralCliente= activarutilidad_operativaBalanceGeneralCliente;
	}

	public Border setResaltargastos_familiaresBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltargastos_familiaresBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltargastos_familiaresBalanceGeneralCliente() {
		return this.resaltargastos_familiaresBalanceGeneralCliente;
	}

	public void setResaltargastos_familiaresBalanceGeneralCliente(Border borderResaltar) {
		this.resaltargastos_familiaresBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrargastos_familiaresBalanceGeneralCliente() {
		return this.mostrargastos_familiaresBalanceGeneralCliente;
	}

	public void setMostrargastos_familiaresBalanceGeneralCliente(Boolean mostrargastos_familiaresBalanceGeneralCliente) {
		this.mostrargastos_familiaresBalanceGeneralCliente= mostrargastos_familiaresBalanceGeneralCliente;
	}

	public Boolean getActivargastos_familiaresBalanceGeneralCliente() {
		return this.activargastos_familiaresBalanceGeneralCliente;
	}

	public void setActivargastos_familiaresBalanceGeneralCliente(Boolean activargastos_familiaresBalanceGeneralCliente) {
		this.activargastos_familiaresBalanceGeneralCliente= activargastos_familiaresBalanceGeneralCliente;
	}

	public Border setResaltarexcedente_antes_dividendosBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarexcedente_antes_dividendosBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarexcedente_antes_dividendosBalanceGeneralCliente() {
		return this.resaltarexcedente_antes_dividendosBalanceGeneralCliente;
	}

	public void setResaltarexcedente_antes_dividendosBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarexcedente_antes_dividendosBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarexcedente_antes_dividendosBalanceGeneralCliente() {
		return this.mostrarexcedente_antes_dividendosBalanceGeneralCliente;
	}

	public void setMostrarexcedente_antes_dividendosBalanceGeneralCliente(Boolean mostrarexcedente_antes_dividendosBalanceGeneralCliente) {
		this.mostrarexcedente_antes_dividendosBalanceGeneralCliente= mostrarexcedente_antes_dividendosBalanceGeneralCliente;
	}

	public Boolean getActivarexcedente_antes_dividendosBalanceGeneralCliente() {
		return this.activarexcedente_antes_dividendosBalanceGeneralCliente;
	}

	public void setActivarexcedente_antes_dividendosBalanceGeneralCliente(Boolean activarexcedente_antes_dividendosBalanceGeneralCliente) {
		this.activarexcedente_antes_dividendosBalanceGeneralCliente= activarexcedente_antes_dividendosBalanceGeneralCliente;
	}

	public Border setResaltardividendos_bancos_otrosBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltardividendos_bancos_otrosBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardividendos_bancos_otrosBalanceGeneralCliente() {
		return this.resaltardividendos_bancos_otrosBalanceGeneralCliente;
	}

	public void setResaltardividendos_bancos_otrosBalanceGeneralCliente(Border borderResaltar) {
		this.resaltardividendos_bancos_otrosBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrardividendos_bancos_otrosBalanceGeneralCliente() {
		return this.mostrardividendos_bancos_otrosBalanceGeneralCliente;
	}

	public void setMostrardividendos_bancos_otrosBalanceGeneralCliente(Boolean mostrardividendos_bancos_otrosBalanceGeneralCliente) {
		this.mostrardividendos_bancos_otrosBalanceGeneralCliente= mostrardividendos_bancos_otrosBalanceGeneralCliente;
	}

	public Boolean getActivardividendos_bancos_otrosBalanceGeneralCliente() {
		return this.activardividendos_bancos_otrosBalanceGeneralCliente;
	}

	public void setActivardividendos_bancos_otrosBalanceGeneralCliente(Boolean activardividendos_bancos_otrosBalanceGeneralCliente) {
		this.activardividendos_bancos_otrosBalanceGeneralCliente= activardividendos_bancos_otrosBalanceGeneralCliente;
	}

	public Border setResaltarexedente_neto_mensualBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarexedente_neto_mensualBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarexedente_neto_mensualBalanceGeneralCliente() {
		return this.resaltarexedente_neto_mensualBalanceGeneralCliente;
	}

	public void setResaltarexedente_neto_mensualBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarexedente_neto_mensualBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarexedente_neto_mensualBalanceGeneralCliente() {
		return this.mostrarexedente_neto_mensualBalanceGeneralCliente;
	}

	public void setMostrarexedente_neto_mensualBalanceGeneralCliente(Boolean mostrarexedente_neto_mensualBalanceGeneralCliente) {
		this.mostrarexedente_neto_mensualBalanceGeneralCliente= mostrarexedente_neto_mensualBalanceGeneralCliente;
	}

	public Boolean getActivarexedente_neto_mensualBalanceGeneralCliente() {
		return this.activarexedente_neto_mensualBalanceGeneralCliente;
	}

	public void setActivarexedente_neto_mensualBalanceGeneralCliente(Boolean activarexedente_neto_mensualBalanceGeneralCliente) {
		this.activarexedente_neto_mensualBalanceGeneralCliente= activarexedente_neto_mensualBalanceGeneralCliente;
	}

	public Border setResaltardeudas_bancariasBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltardeudas_bancariasBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardeudas_bancariasBalanceGeneralCliente() {
		return this.resaltardeudas_bancariasBalanceGeneralCliente;
	}

	public void setResaltardeudas_bancariasBalanceGeneralCliente(Border borderResaltar) {
		this.resaltardeudas_bancariasBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrardeudas_bancariasBalanceGeneralCliente() {
		return this.mostrardeudas_bancariasBalanceGeneralCliente;
	}

	public void setMostrardeudas_bancariasBalanceGeneralCliente(Boolean mostrardeudas_bancariasBalanceGeneralCliente) {
		this.mostrardeudas_bancariasBalanceGeneralCliente= mostrardeudas_bancariasBalanceGeneralCliente;
	}

	public Boolean getActivardeudas_bancariasBalanceGeneralCliente() {
		return this.activardeudas_bancariasBalanceGeneralCliente;
	}

	public void setActivardeudas_bancariasBalanceGeneralCliente(Boolean activardeudas_bancariasBalanceGeneralCliente) {
		this.activardeudas_bancariasBalanceGeneralCliente= activardeudas_bancariasBalanceGeneralCliente;
	}

	public Border setResaltarcuentas_por_pagarBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarcuentas_por_pagarBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcuentas_por_pagarBalanceGeneralCliente() {
		return this.resaltarcuentas_por_pagarBalanceGeneralCliente;
	}

	public void setResaltarcuentas_por_pagarBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarcuentas_por_pagarBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarcuentas_por_pagarBalanceGeneralCliente() {
		return this.mostrarcuentas_por_pagarBalanceGeneralCliente;
	}

	public void setMostrarcuentas_por_pagarBalanceGeneralCliente(Boolean mostrarcuentas_por_pagarBalanceGeneralCliente) {
		this.mostrarcuentas_por_pagarBalanceGeneralCliente= mostrarcuentas_por_pagarBalanceGeneralCliente;
	}

	public Boolean getActivarcuentas_por_pagarBalanceGeneralCliente() {
		return this.activarcuentas_por_pagarBalanceGeneralCliente;
	}

	public void setActivarcuentas_por_pagarBalanceGeneralCliente(Boolean activarcuentas_por_pagarBalanceGeneralCliente) {
		this.activarcuentas_por_pagarBalanceGeneralCliente= activarcuentas_por_pagarBalanceGeneralCliente;
	}

	public Border setResaltaranticipos_recibosBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltaranticipos_recibosBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaranticipos_recibosBalanceGeneralCliente() {
		return this.resaltaranticipos_recibosBalanceGeneralCliente;
	}

	public void setResaltaranticipos_recibosBalanceGeneralCliente(Border borderResaltar) {
		this.resaltaranticipos_recibosBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostraranticipos_recibosBalanceGeneralCliente() {
		return this.mostraranticipos_recibosBalanceGeneralCliente;
	}

	public void setMostraranticipos_recibosBalanceGeneralCliente(Boolean mostraranticipos_recibosBalanceGeneralCliente) {
		this.mostraranticipos_recibosBalanceGeneralCliente= mostraranticipos_recibosBalanceGeneralCliente;
	}

	public Boolean getActivaranticipos_recibosBalanceGeneralCliente() {
		return this.activaranticipos_recibosBalanceGeneralCliente;
	}

	public void setActivaranticipos_recibosBalanceGeneralCliente(Boolean activaranticipos_recibosBalanceGeneralCliente) {
		this.activaranticipos_recibosBalanceGeneralCliente= activaranticipos_recibosBalanceGeneralCliente;
	}

	public Border setResaltarotras_cuentas_por_pagarBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarotras_cuentas_por_pagarBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotras_cuentas_por_pagarBalanceGeneralCliente() {
		return this.resaltarotras_cuentas_por_pagarBalanceGeneralCliente;
	}

	public void setResaltarotras_cuentas_por_pagarBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarotras_cuentas_por_pagarBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarotras_cuentas_por_pagarBalanceGeneralCliente() {
		return this.mostrarotras_cuentas_por_pagarBalanceGeneralCliente;
	}

	public void setMostrarotras_cuentas_por_pagarBalanceGeneralCliente(Boolean mostrarotras_cuentas_por_pagarBalanceGeneralCliente) {
		this.mostrarotras_cuentas_por_pagarBalanceGeneralCliente= mostrarotras_cuentas_por_pagarBalanceGeneralCliente;
	}

	public Boolean getActivarotras_cuentas_por_pagarBalanceGeneralCliente() {
		return this.activarotras_cuentas_por_pagarBalanceGeneralCliente;
	}

	public void setActivarotras_cuentas_por_pagarBalanceGeneralCliente(Boolean activarotras_cuentas_por_pagarBalanceGeneralCliente) {
		this.activarotras_cuentas_por_pagarBalanceGeneralCliente= activarotras_cuentas_por_pagarBalanceGeneralCliente;
	}

	public Border setResaltarotras_deudas_familiaresBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarotras_deudas_familiaresBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotras_deudas_familiaresBalanceGeneralCliente() {
		return this.resaltarotras_deudas_familiaresBalanceGeneralCliente;
	}

	public void setResaltarotras_deudas_familiaresBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarotras_deudas_familiaresBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarotras_deudas_familiaresBalanceGeneralCliente() {
		return this.mostrarotras_deudas_familiaresBalanceGeneralCliente;
	}

	public void setMostrarotras_deudas_familiaresBalanceGeneralCliente(Boolean mostrarotras_deudas_familiaresBalanceGeneralCliente) {
		this.mostrarotras_deudas_familiaresBalanceGeneralCliente= mostrarotras_deudas_familiaresBalanceGeneralCliente;
	}

	public Boolean getActivarotras_deudas_familiaresBalanceGeneralCliente() {
		return this.activarotras_deudas_familiaresBalanceGeneralCliente;
	}

	public void setActivarotras_deudas_familiaresBalanceGeneralCliente(Boolean activarotras_deudas_familiaresBalanceGeneralCliente) {
		this.activarotras_deudas_familiaresBalanceGeneralCliente= activarotras_deudas_familiaresBalanceGeneralCliente;
	}

	public Border setResaltartotal_pasivo_corrienteBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltartotal_pasivo_corrienteBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_pasivo_corrienteBalanceGeneralCliente() {
		return this.resaltartotal_pasivo_corrienteBalanceGeneralCliente;
	}

	public void setResaltartotal_pasivo_corrienteBalanceGeneralCliente(Border borderResaltar) {
		this.resaltartotal_pasivo_corrienteBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrartotal_pasivo_corrienteBalanceGeneralCliente() {
		return this.mostrartotal_pasivo_corrienteBalanceGeneralCliente;
	}

	public void setMostrartotal_pasivo_corrienteBalanceGeneralCliente(Boolean mostrartotal_pasivo_corrienteBalanceGeneralCliente) {
		this.mostrartotal_pasivo_corrienteBalanceGeneralCliente= mostrartotal_pasivo_corrienteBalanceGeneralCliente;
	}

	public Boolean getActivartotal_pasivo_corrienteBalanceGeneralCliente() {
		return this.activartotal_pasivo_corrienteBalanceGeneralCliente;
	}

	public void setActivartotal_pasivo_corrienteBalanceGeneralCliente(Boolean activartotal_pasivo_corrienteBalanceGeneralCliente) {
		this.activartotal_pasivo_corrienteBalanceGeneralCliente= activartotal_pasivo_corrienteBalanceGeneralCliente;
	}

	public Border setResaltardeudas_bancarias_largo_plazoBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltardeudas_bancarias_largo_plazoBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardeudas_bancarias_largo_plazoBalanceGeneralCliente() {
		return this.resaltardeudas_bancarias_largo_plazoBalanceGeneralCliente;
	}

	public void setResaltardeudas_bancarias_largo_plazoBalanceGeneralCliente(Border borderResaltar) {
		this.resaltardeudas_bancarias_largo_plazoBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrardeudas_bancarias_largo_plazoBalanceGeneralCliente() {
		return this.mostrardeudas_bancarias_largo_plazoBalanceGeneralCliente;
	}

	public void setMostrardeudas_bancarias_largo_plazoBalanceGeneralCliente(Boolean mostrardeudas_bancarias_largo_plazoBalanceGeneralCliente) {
		this.mostrardeudas_bancarias_largo_plazoBalanceGeneralCliente= mostrardeudas_bancarias_largo_plazoBalanceGeneralCliente;
	}

	public Boolean getActivardeudas_bancarias_largo_plazoBalanceGeneralCliente() {
		return this.activardeudas_bancarias_largo_plazoBalanceGeneralCliente;
	}

	public void setActivardeudas_bancarias_largo_plazoBalanceGeneralCliente(Boolean activardeudas_bancarias_largo_plazoBalanceGeneralCliente) {
		this.activardeudas_bancarias_largo_plazoBalanceGeneralCliente= activardeudas_bancarias_largo_plazoBalanceGeneralCliente;
	}

	public Border setResaltarotros_pasivos_largo_plazoBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarotros_pasivos_largo_plazoBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotros_pasivos_largo_plazoBalanceGeneralCliente() {
		return this.resaltarotros_pasivos_largo_plazoBalanceGeneralCliente;
	}

	public void setResaltarotros_pasivos_largo_plazoBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarotros_pasivos_largo_plazoBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarotros_pasivos_largo_plazoBalanceGeneralCliente() {
		return this.mostrarotros_pasivos_largo_plazoBalanceGeneralCliente;
	}

	public void setMostrarotros_pasivos_largo_plazoBalanceGeneralCliente(Boolean mostrarotros_pasivos_largo_plazoBalanceGeneralCliente) {
		this.mostrarotros_pasivos_largo_plazoBalanceGeneralCliente= mostrarotros_pasivos_largo_plazoBalanceGeneralCliente;
	}

	public Boolean getActivarotros_pasivos_largo_plazoBalanceGeneralCliente() {
		return this.activarotros_pasivos_largo_plazoBalanceGeneralCliente;
	}

	public void setActivarotros_pasivos_largo_plazoBalanceGeneralCliente(Boolean activarotros_pasivos_largo_plazoBalanceGeneralCliente) {
		this.activarotros_pasivos_largo_plazoBalanceGeneralCliente= activarotros_pasivos_largo_plazoBalanceGeneralCliente;
	}

	public Border setResaltartotal_pasivo_no_corrienteBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltartotal_pasivo_no_corrienteBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_pasivo_no_corrienteBalanceGeneralCliente() {
		return this.resaltartotal_pasivo_no_corrienteBalanceGeneralCliente;
	}

	public void setResaltartotal_pasivo_no_corrienteBalanceGeneralCliente(Border borderResaltar) {
		this.resaltartotal_pasivo_no_corrienteBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrartotal_pasivo_no_corrienteBalanceGeneralCliente() {
		return this.mostrartotal_pasivo_no_corrienteBalanceGeneralCliente;
	}

	public void setMostrartotal_pasivo_no_corrienteBalanceGeneralCliente(Boolean mostrartotal_pasivo_no_corrienteBalanceGeneralCliente) {
		this.mostrartotal_pasivo_no_corrienteBalanceGeneralCliente= mostrartotal_pasivo_no_corrienteBalanceGeneralCliente;
	}

	public Boolean getActivartotal_pasivo_no_corrienteBalanceGeneralCliente() {
		return this.activartotal_pasivo_no_corrienteBalanceGeneralCliente;
	}

	public void setActivartotal_pasivo_no_corrienteBalanceGeneralCliente(Boolean activartotal_pasivo_no_corrienteBalanceGeneralCliente) {
		this.activartotal_pasivo_no_corrienteBalanceGeneralCliente= activartotal_pasivo_no_corrienteBalanceGeneralCliente;
	}

	public Border setResaltartotal_pasivoBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltartotal_pasivoBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_pasivoBalanceGeneralCliente() {
		return this.resaltartotal_pasivoBalanceGeneralCliente;
	}

	public void setResaltartotal_pasivoBalanceGeneralCliente(Border borderResaltar) {
		this.resaltartotal_pasivoBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrartotal_pasivoBalanceGeneralCliente() {
		return this.mostrartotal_pasivoBalanceGeneralCliente;
	}

	public void setMostrartotal_pasivoBalanceGeneralCliente(Boolean mostrartotal_pasivoBalanceGeneralCliente) {
		this.mostrartotal_pasivoBalanceGeneralCliente= mostrartotal_pasivoBalanceGeneralCliente;
	}

	public Boolean getActivartotal_pasivoBalanceGeneralCliente() {
		return this.activartotal_pasivoBalanceGeneralCliente;
	}

	public void setActivartotal_pasivoBalanceGeneralCliente(Boolean activartotal_pasivoBalanceGeneralCliente) {
		this.activartotal_pasivoBalanceGeneralCliente= activartotal_pasivoBalanceGeneralCliente;
	}

	public Border setResaltarpatrimonioBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltarpatrimonioBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpatrimonioBalanceGeneralCliente() {
		return this.resaltarpatrimonioBalanceGeneralCliente;
	}

	public void setResaltarpatrimonioBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarpatrimonioBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrarpatrimonioBalanceGeneralCliente() {
		return this.mostrarpatrimonioBalanceGeneralCliente;
	}

	public void setMostrarpatrimonioBalanceGeneralCliente(Boolean mostrarpatrimonioBalanceGeneralCliente) {
		this.mostrarpatrimonioBalanceGeneralCliente= mostrarpatrimonioBalanceGeneralCliente;
	}

	public Boolean getActivarpatrimonioBalanceGeneralCliente() {
		return this.activarpatrimonioBalanceGeneralCliente;
	}

	public void setActivarpatrimonioBalanceGeneralCliente(Boolean activarpatrimonioBalanceGeneralCliente) {
		this.activarpatrimonioBalanceGeneralCliente= activarpatrimonioBalanceGeneralCliente;
	}

	public Border setResaltardescripcionBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//balancegeneralclienteBeanSwingJInternalFrame.jTtoolBarBalanceGeneralCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionBalanceGeneralCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionBalanceGeneralCliente() {
		return this.resaltardescripcionBalanceGeneralCliente;
	}

	public void setResaltardescripcionBalanceGeneralCliente(Border borderResaltar) {
		this.resaltardescripcionBalanceGeneralCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionBalanceGeneralCliente() {
		return this.mostrardescripcionBalanceGeneralCliente;
	}

	public void setMostrardescripcionBalanceGeneralCliente(Boolean mostrardescripcionBalanceGeneralCliente) {
		this.mostrardescripcionBalanceGeneralCliente= mostrardescripcionBalanceGeneralCliente;
	}

	public Boolean getActivardescripcionBalanceGeneralCliente() {
		return this.activardescripcionBalanceGeneralCliente;
	}

	public void setActivardescripcionBalanceGeneralCliente(Boolean activardescripcionBalanceGeneralCliente) {
		this.activardescripcionBalanceGeneralCliente= activardescripcionBalanceGeneralCliente;
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
		
		
		this.setMostraridBalanceGeneralCliente(esInicial);
		this.setMostrarid_empresaBalanceGeneralCliente(esInicial);
		this.setMostrarid_clienteBalanceGeneralCliente(esInicial);
		this.setMostrarcaja_bancos_disponibleBalanceGeneralCliente(esInicial);
		this.setMostrarcuentas_por_cobrar_clientesBalanceGeneralCliente(esInicial);
		this.setMostrarinventarioBalanceGeneralCliente(esInicial);
		this.setMostrarotros_activos_corrientesBalanceGeneralCliente(esInicial);
		this.setMostrartotal_activos_corrientesBalanceGeneralCliente(esInicial);
		this.setMostrarbienes_inmueblesBalanceGeneralCliente(esInicial);
		this.setMostrarbienes_mueblesBalanceGeneralCliente(esInicial);
		this.setMostrarotros_activos_no_corrientesBalanceGeneralCliente(esInicial);
		this.setMostrartotal_activos_no_corrientesBalanceGeneralCliente(esInicial);
		this.setMostrarventas_mensualesBalanceGeneralCliente(esInicial);
		this.setMostrarcosto_ventas_mensualesBalanceGeneralCliente(esInicial);
		this.setMostrarutilidad_brutaBalanceGeneralCliente(esInicial);
		this.setMostrargastos_operativosBalanceGeneralCliente(esInicial);
		this.setMostrarsueldosBalanceGeneralCliente(esInicial);
		this.setMostrarserviciosBalanceGeneralCliente(esInicial);
		this.setMostrararriendosBalanceGeneralCliente(esInicial);
		this.setMostrarimpuestosBalanceGeneralCliente(esInicial);
		this.setMostrarutilidad_operativaBalanceGeneralCliente(esInicial);
		this.setMostrargastos_familiaresBalanceGeneralCliente(esInicial);
		this.setMostrarexcedente_antes_dividendosBalanceGeneralCliente(esInicial);
		this.setMostrardividendos_bancos_otrosBalanceGeneralCliente(esInicial);
		this.setMostrarexedente_neto_mensualBalanceGeneralCliente(esInicial);
		this.setMostrardeudas_bancariasBalanceGeneralCliente(esInicial);
		this.setMostrarcuentas_por_pagarBalanceGeneralCliente(esInicial);
		this.setMostraranticipos_recibosBalanceGeneralCliente(esInicial);
		this.setMostrarotras_cuentas_por_pagarBalanceGeneralCliente(esInicial);
		this.setMostrarotras_deudas_familiaresBalanceGeneralCliente(esInicial);
		this.setMostrartotal_pasivo_corrienteBalanceGeneralCliente(esInicial);
		this.setMostrardeudas_bancarias_largo_plazoBalanceGeneralCliente(esInicial);
		this.setMostrarotros_pasivos_largo_plazoBalanceGeneralCliente(esInicial);
		this.setMostrartotal_pasivo_no_corrienteBalanceGeneralCliente(esInicial);
		this.setMostrartotal_pasivoBalanceGeneralCliente(esInicial);
		this.setMostrarpatrimonioBalanceGeneralCliente(esInicial);
		this.setMostrardescripcionBalanceGeneralCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ID)) {
				this.setMostraridBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE)) {
				this.setMostrarcaja_bancos_disponibleBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES)) {
				this.setMostrarcuentas_por_cobrar_clientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.INVENTARIO)) {
				this.setMostrarinventarioBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES)) {
				this.setMostrarotros_activos_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES)) {
				this.setMostrartotal_activos_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES)) {
				this.setMostrarbienes_inmueblesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES)) {
				this.setMostrarbienes_mueblesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES)) {
				this.setMostrarotros_activos_no_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES)) {
				this.setMostrartotal_activos_no_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES)) {
				this.setMostrarventas_mensualesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES)) {
				this.setMostrarcosto_ventas_mensualesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA)) {
				this.setMostrarutilidad_brutaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS)) {
				this.setMostrargastos_operativosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.SUELDOS)) {
				this.setMostrarsueldosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.SERVICIOS)) {
				this.setMostrarserviciosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ARRIENDOS)) {
				this.setMostrararriendosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IMPUESTOS)) {
				this.setMostrarimpuestosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA)) {
				this.setMostrarutilidad_operativaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES)) {
				this.setMostrargastos_familiaresBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS)) {
				this.setMostrarexcedente_antes_dividendosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS)) {
				this.setMostrardividendos_bancos_otrosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL)) {
				this.setMostrarexedente_neto_mensualBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS)) {
				this.setMostrardeudas_bancariasBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR)) {
				this.setMostrarcuentas_por_pagarBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS)) {
				this.setMostraranticipos_recibosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR)) {
				this.setMostrarotras_cuentas_por_pagarBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES)) {
				this.setMostrarotras_deudas_familiaresBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE)) {
				this.setMostrartotal_pasivo_corrienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO)) {
				this.setMostrardeudas_bancarias_largo_plazoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO)) {
				this.setMostrarotros_pasivos_largo_plazoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE)) {
				this.setMostrartotal_pasivo_no_corrienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVO)) {
				this.setMostrartotal_pasivoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.PATRIMONIO)) {
				this.setMostrarpatrimonioBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionBalanceGeneralCliente(esAsigna);
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
		
		
		this.setActivaridBalanceGeneralCliente(esInicial);
		this.setActivarid_empresaBalanceGeneralCliente(esInicial);
		this.setActivarid_clienteBalanceGeneralCliente(esInicial);
		this.setActivarcaja_bancos_disponibleBalanceGeneralCliente(esInicial);
		this.setActivarcuentas_por_cobrar_clientesBalanceGeneralCliente(esInicial);
		this.setActivarinventarioBalanceGeneralCliente(esInicial);
		this.setActivarotros_activos_corrientesBalanceGeneralCliente(esInicial);
		this.setActivartotal_activos_corrientesBalanceGeneralCliente(esInicial);
		this.setActivarbienes_inmueblesBalanceGeneralCliente(esInicial);
		this.setActivarbienes_mueblesBalanceGeneralCliente(esInicial);
		this.setActivarotros_activos_no_corrientesBalanceGeneralCliente(esInicial);
		this.setActivartotal_activos_no_corrientesBalanceGeneralCliente(esInicial);
		this.setActivarventas_mensualesBalanceGeneralCliente(esInicial);
		this.setActivarcosto_ventas_mensualesBalanceGeneralCliente(esInicial);
		this.setActivarutilidad_brutaBalanceGeneralCliente(esInicial);
		this.setActivargastos_operativosBalanceGeneralCliente(esInicial);
		this.setActivarsueldosBalanceGeneralCliente(esInicial);
		this.setActivarserviciosBalanceGeneralCliente(esInicial);
		this.setActivararriendosBalanceGeneralCliente(esInicial);
		this.setActivarimpuestosBalanceGeneralCliente(esInicial);
		this.setActivarutilidad_operativaBalanceGeneralCliente(esInicial);
		this.setActivargastos_familiaresBalanceGeneralCliente(esInicial);
		this.setActivarexcedente_antes_dividendosBalanceGeneralCliente(esInicial);
		this.setActivardividendos_bancos_otrosBalanceGeneralCliente(esInicial);
		this.setActivarexedente_neto_mensualBalanceGeneralCliente(esInicial);
		this.setActivardeudas_bancariasBalanceGeneralCliente(esInicial);
		this.setActivarcuentas_por_pagarBalanceGeneralCliente(esInicial);
		this.setActivaranticipos_recibosBalanceGeneralCliente(esInicial);
		this.setActivarotras_cuentas_por_pagarBalanceGeneralCliente(esInicial);
		this.setActivarotras_deudas_familiaresBalanceGeneralCliente(esInicial);
		this.setActivartotal_pasivo_corrienteBalanceGeneralCliente(esInicial);
		this.setActivardeudas_bancarias_largo_plazoBalanceGeneralCliente(esInicial);
		this.setActivarotros_pasivos_largo_plazoBalanceGeneralCliente(esInicial);
		this.setActivartotal_pasivo_no_corrienteBalanceGeneralCliente(esInicial);
		this.setActivartotal_pasivoBalanceGeneralCliente(esInicial);
		this.setActivarpatrimonioBalanceGeneralCliente(esInicial);
		this.setActivardescripcionBalanceGeneralCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ID)) {
				this.setActivaridBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE)) {
				this.setActivarcaja_bancos_disponibleBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES)) {
				this.setActivarcuentas_por_cobrar_clientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.INVENTARIO)) {
				this.setActivarinventarioBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES)) {
				this.setActivarotros_activos_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES)) {
				this.setActivartotal_activos_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES)) {
				this.setActivarbienes_inmueblesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES)) {
				this.setActivarbienes_mueblesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES)) {
				this.setActivarotros_activos_no_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES)) {
				this.setActivartotal_activos_no_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES)) {
				this.setActivarventas_mensualesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES)) {
				this.setActivarcosto_ventas_mensualesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA)) {
				this.setActivarutilidad_brutaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS)) {
				this.setActivargastos_operativosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.SUELDOS)) {
				this.setActivarsueldosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.SERVICIOS)) {
				this.setActivarserviciosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ARRIENDOS)) {
				this.setActivararriendosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IMPUESTOS)) {
				this.setActivarimpuestosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA)) {
				this.setActivarutilidad_operativaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES)) {
				this.setActivargastos_familiaresBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS)) {
				this.setActivarexcedente_antes_dividendosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS)) {
				this.setActivardividendos_bancos_otrosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL)) {
				this.setActivarexedente_neto_mensualBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS)) {
				this.setActivardeudas_bancariasBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR)) {
				this.setActivarcuentas_por_pagarBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS)) {
				this.setActivaranticipos_recibosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR)) {
				this.setActivarotras_cuentas_por_pagarBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES)) {
				this.setActivarotras_deudas_familiaresBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE)) {
				this.setActivartotal_pasivo_corrienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO)) {
				this.setActivardeudas_bancarias_largo_plazoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO)) {
				this.setActivarotros_pasivos_largo_plazoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE)) {
				this.setActivartotal_pasivo_no_corrienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVO)) {
				this.setActivartotal_pasivoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.PATRIMONIO)) {
				this.setActivarpatrimonioBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionBalanceGeneralCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBalanceGeneralCliente(esInicial);
		this.setResaltarid_empresaBalanceGeneralCliente(esInicial);
		this.setResaltarid_clienteBalanceGeneralCliente(esInicial);
		this.setResaltarcaja_bancos_disponibleBalanceGeneralCliente(esInicial);
		this.setResaltarcuentas_por_cobrar_clientesBalanceGeneralCliente(esInicial);
		this.setResaltarinventarioBalanceGeneralCliente(esInicial);
		this.setResaltarotros_activos_corrientesBalanceGeneralCliente(esInicial);
		this.setResaltartotal_activos_corrientesBalanceGeneralCliente(esInicial);
		this.setResaltarbienes_inmueblesBalanceGeneralCliente(esInicial);
		this.setResaltarbienes_mueblesBalanceGeneralCliente(esInicial);
		this.setResaltarotros_activos_no_corrientesBalanceGeneralCliente(esInicial);
		this.setResaltartotal_activos_no_corrientesBalanceGeneralCliente(esInicial);
		this.setResaltarventas_mensualesBalanceGeneralCliente(esInicial);
		this.setResaltarcosto_ventas_mensualesBalanceGeneralCliente(esInicial);
		this.setResaltarutilidad_brutaBalanceGeneralCliente(esInicial);
		this.setResaltargastos_operativosBalanceGeneralCliente(esInicial);
		this.setResaltarsueldosBalanceGeneralCliente(esInicial);
		this.setResaltarserviciosBalanceGeneralCliente(esInicial);
		this.setResaltararriendosBalanceGeneralCliente(esInicial);
		this.setResaltarimpuestosBalanceGeneralCliente(esInicial);
		this.setResaltarutilidad_operativaBalanceGeneralCliente(esInicial);
		this.setResaltargastos_familiaresBalanceGeneralCliente(esInicial);
		this.setResaltarexcedente_antes_dividendosBalanceGeneralCliente(esInicial);
		this.setResaltardividendos_bancos_otrosBalanceGeneralCliente(esInicial);
		this.setResaltarexedente_neto_mensualBalanceGeneralCliente(esInicial);
		this.setResaltardeudas_bancariasBalanceGeneralCliente(esInicial);
		this.setResaltarcuentas_por_pagarBalanceGeneralCliente(esInicial);
		this.setResaltaranticipos_recibosBalanceGeneralCliente(esInicial);
		this.setResaltarotras_cuentas_por_pagarBalanceGeneralCliente(esInicial);
		this.setResaltarotras_deudas_familiaresBalanceGeneralCliente(esInicial);
		this.setResaltartotal_pasivo_corrienteBalanceGeneralCliente(esInicial);
		this.setResaltardeudas_bancarias_largo_plazoBalanceGeneralCliente(esInicial);
		this.setResaltarotros_pasivos_largo_plazoBalanceGeneralCliente(esInicial);
		this.setResaltartotal_pasivo_no_corrienteBalanceGeneralCliente(esInicial);
		this.setResaltartotal_pasivoBalanceGeneralCliente(esInicial);
		this.setResaltarpatrimonioBalanceGeneralCliente(esInicial);
		this.setResaltardescripcionBalanceGeneralCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ID)) {
				this.setResaltaridBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE)) {
				this.setResaltarcaja_bancos_disponibleBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES)) {
				this.setResaltarcuentas_por_cobrar_clientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.INVENTARIO)) {
				this.setResaltarinventarioBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES)) {
				this.setResaltarotros_activos_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES)) {
				this.setResaltartotal_activos_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES)) {
				this.setResaltarbienes_inmueblesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES)) {
				this.setResaltarbienes_mueblesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES)) {
				this.setResaltarotros_activos_no_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES)) {
				this.setResaltartotal_activos_no_corrientesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES)) {
				this.setResaltarventas_mensualesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES)) {
				this.setResaltarcosto_ventas_mensualesBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA)) {
				this.setResaltarutilidad_brutaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS)) {
				this.setResaltargastos_operativosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.SUELDOS)) {
				this.setResaltarsueldosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.SERVICIOS)) {
				this.setResaltarserviciosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ARRIENDOS)) {
				this.setResaltararriendosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.IMPUESTOS)) {
				this.setResaltarimpuestosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA)) {
				this.setResaltarutilidad_operativaBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES)) {
				this.setResaltargastos_familiaresBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS)) {
				this.setResaltarexcedente_antes_dividendosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS)) {
				this.setResaltardividendos_bancos_otrosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL)) {
				this.setResaltarexedente_neto_mensualBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS)) {
				this.setResaltardeudas_bancariasBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR)) {
				this.setResaltarcuentas_por_pagarBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS)) {
				this.setResaltaranticipos_recibosBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR)) {
				this.setResaltarotras_cuentas_por_pagarBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES)) {
				this.setResaltarotras_deudas_familiaresBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE)) {
				this.setResaltartotal_pasivo_corrienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO)) {
				this.setResaltardeudas_bancarias_largo_plazoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO)) {
				this.setResaltarotros_pasivos_largo_plazoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE)) {
				this.setResaltartotal_pasivo_no_corrienteBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.TOTALPASIVO)) {
				this.setResaltartotal_pasivoBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.PATRIMONIO)) {
				this.setResaltarpatrimonioBalanceGeneralCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(BalanceGeneralClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionBalanceGeneralCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdClienteBalanceGeneralCliente=true;

	public Boolean getMostrarFK_IdClienteBalanceGeneralCliente() {
		return this.mostrarFK_IdClienteBalanceGeneralCliente;
	}

	public void setMostrarFK_IdClienteBalanceGeneralCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteBalanceGeneralCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaBalanceGeneralCliente=true;

	public Boolean getMostrarFK_IdEmpresaBalanceGeneralCliente() {
		return this.mostrarFK_IdEmpresaBalanceGeneralCliente;
	}

	public void setMostrarFK_IdEmpresaBalanceGeneralCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBalanceGeneralCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteBalanceGeneralCliente=true;

	public Boolean getActivarFK_IdClienteBalanceGeneralCliente() {
		return this.activarFK_IdClienteBalanceGeneralCliente;
	}

	public void setActivarFK_IdClienteBalanceGeneralCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClienteBalanceGeneralCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaBalanceGeneralCliente=true;

	public Boolean getActivarFK_IdEmpresaBalanceGeneralCliente() {
		return this.activarFK_IdEmpresaBalanceGeneralCliente;
	}

	public void setActivarFK_IdEmpresaBalanceGeneralCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBalanceGeneralCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteBalanceGeneralCliente=null;

	public Border getResaltarFK_IdClienteBalanceGeneralCliente() {
		return this.resaltarFK_IdClienteBalanceGeneralCliente;
	}

	public void setResaltarFK_IdClienteBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarFK_IdClienteBalanceGeneralCliente= borderResaltar;
	}

	public void setResaltarFK_IdClienteBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteBalanceGeneralCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaBalanceGeneralCliente=null;

	public Border getResaltarFK_IdEmpresaBalanceGeneralCliente() {
		return this.resaltarFK_IdEmpresaBalanceGeneralCliente;
	}

	public void setResaltarFK_IdEmpresaBalanceGeneralCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBalanceGeneralCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBalanceGeneralCliente(ParametroGeneralUsuario parametroGeneralUsuario/*BalanceGeneralClienteBeanSwingJInternalFrame balancegeneralclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBalanceGeneralCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}