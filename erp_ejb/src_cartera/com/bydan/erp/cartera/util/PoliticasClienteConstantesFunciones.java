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


import com.bydan.erp.cartera.util.PoliticasClienteConstantesFunciones;
import com.bydan.erp.cartera.util.PoliticasClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.PoliticasClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PoliticasClienteConstantesFunciones extends PoliticasClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PoliticasCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PoliticasCliente"+PoliticasClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PoliticasClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PoliticasClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PoliticasClienteConstantesFunciones.SCHEMA+"_"+PoliticasClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PoliticasClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PoliticasClienteConstantesFunciones.SCHEMA+"_"+PoliticasClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PoliticasClienteConstantesFunciones.SCHEMA+"_"+PoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PoliticasClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PoliticasClienteConstantesFunciones.SCHEMA+"_"+PoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PoliticasClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PoliticasClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PoliticasClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PoliticasClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PoliticasClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PoliticasClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PoliticasClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Politicas Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Politicas Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Politicas Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PoliticasCliente";
	public static final String OBJECTNAME="politicascliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="politicas_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select politicascliente from "+PoliticasClienteConstantesFunciones.SPERSISTENCENAME+" politicascliente";
	public static String QUERYSELECTNATIVE="select "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".version_row,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_empresa,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".limite_credito,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_inicio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_renovacion,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_fin,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".dias_neto_pago,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".dias_gracia,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".cupo,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".descuento_general,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".descuento_pronto_pago,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_tipo_precio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".con_lista_precio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".con_impuestos,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".activar_monto_facturacion,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".valor_sobregiro,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_venci_sobregiro,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_transporte,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".valor_solicitado,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".valor_aprobado,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_linea_negocio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".fecha_solicitud,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".obsevacion,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".web,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".casilla_postal,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".forma_envio,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_banco,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".numero_cuenta,"+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME+".id_estado_politicas_cliente from "+PoliticasClienteConstantesFunciones.SCHEMA+"."+PoliticasClienteConstantesFunciones.TABLENAME;//+" as "+PoliticasClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PoliticasClienteConstantesFuncionesAdditional politicasclienteConstantesFuncionesAdditional=null;
	
	public PoliticasClienteConstantesFuncionesAdditional getPoliticasClienteConstantesFuncionesAdditional() {
		return this.politicasclienteConstantesFuncionesAdditional;
	}
	
	public void setPoliticasClienteConstantesFuncionesAdditional(PoliticasClienteConstantesFuncionesAdditional politicasclienteConstantesFuncionesAdditional) {
		try {
			this.politicasclienteConstantesFuncionesAdditional=politicasclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String LIMITECREDITO= "limite_credito";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHARENOVACION= "fecha_renovacion";
    public static final String FECHAFIN= "fecha_fin";
    public static final String DIASNETOPAGO= "dias_neto_pago";
    public static final String DIASGRACIA= "dias_gracia";
    public static final String CUPO= "cupo";
    public static final String DESCUENTOGENERAL= "descuento_general";
    public static final String DESCUENTOPRONTOPAGO= "descuento_pronto_pago";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String CONLISTAPRECIO= "con_lista_precio";
    public static final String CONIMPUESTOS= "con_impuestos";
    public static final String ACTIVARMONTOFACTURACION= "activar_monto_facturacion";
    public static final String VALORSOBREGIRO= "valor_sobregiro";
    public static final String FECHAVENCISOBREGIRO= "fecha_venci_sobregiro";
    public static final String IDTRANSPORTE= "id_transporte";
    public static final String VALORSOLICITADO= "valor_solicitado";
    public static final String VALORAPROBADO= "valor_aprobado";
    public static final String IDLINEANEGOCIO= "id_linea_negocio";
    public static final String FECHASOLICITUD= "fecha_solicitud";
    public static final String OBSEVACION= "obsevacion";
    public static final String WEB= "web";
    public static final String CASILLAPOSTAL= "casilla_postal";
    public static final String FORMAENVIO= "forma_envio";
    public static final String IDBANCO= "id_banco";
    public static final String IDTIPOCUENTABANCOGLOBAL= "id_tipo_cuenta_banco_global";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String IDESTADOPOLITICASCLIENTE= "id_estado_politicas_cliente";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_LIMITECREDITO= "Limite Credito";
		public static final String LABEL_LIMITECREDITO_LOWER= "Limite Credito";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHARENOVACION= "Fecha Renovacion";
		public static final String LABEL_FECHARENOVACION_LOWER= "Fecha Renovacion";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_DIASNETOPAGO= "Dias Neto Pago";
		public static final String LABEL_DIASNETOPAGO_LOWER= "Dias Neto Pago";
    	public static final String LABEL_DIASGRACIA= "Dias Gracia";
		public static final String LABEL_DIASGRACIA_LOWER= "Dias Gracia";
    	public static final String LABEL_CUPO= "Cupo";
		public static final String LABEL_CUPO_LOWER= "Cupo";
    	public static final String LABEL_DESCUENTOGENERAL= "Descuento General";
		public static final String LABEL_DESCUENTOGENERAL_LOWER= "Descuento General";
    	public static final String LABEL_DESCUENTOPRONTOPAGO= "Descuento Pronto Pago";
		public static final String LABEL_DESCUENTOPRONTOPAGO_LOWER= "Descuento Pronto Pago";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_CONLISTAPRECIO= "Con Lista Precio";
		public static final String LABEL_CONLISTAPRECIO_LOWER= "Con Lista Precio";
    	public static final String LABEL_CONIMPUESTOS= "Con Impuestos";
		public static final String LABEL_CONIMPUESTOS_LOWER= "Con Impuestos";
    	public static final String LABEL_ACTIVARMONTOFACTURACION= "Activar Monto Facturacion";
		public static final String LABEL_ACTIVARMONTOFACTURACION_LOWER= "Activar Monto Facturacion";
    	public static final String LABEL_VALORSOBREGIRO= "Valor Sobregiro";
		public static final String LABEL_VALORSOBREGIRO_LOWER= "Valor Sobregiro";
    	public static final String LABEL_FECHAVENCISOBREGIRO= "Fecha Venci Sobregiro";
		public static final String LABEL_FECHAVENCISOBREGIRO_LOWER= "Fecha Venci Sobregiro";
    	public static final String LABEL_IDTRANSPORTE= "Transporte";
		public static final String LABEL_IDTRANSPORTE_LOWER= "Transporte";
    	public static final String LABEL_VALORSOLICITADO= "Valor Solicitado";
		public static final String LABEL_VALORSOLICITADO_LOWER= "Valor Solicitado";
    	public static final String LABEL_VALORAPROBADO= "Valor Aprobado";
		public static final String LABEL_VALORAPROBADO_LOWER= "Valor Aprobado";
    	public static final String LABEL_IDLINEANEGOCIO= "Linea Negocio";
		public static final String LABEL_IDLINEANEGOCIO_LOWER= "Linea Negocio";
    	public static final String LABEL_FECHASOLICITUD= "Fecha Solicitud";
		public static final String LABEL_FECHASOLICITUD_LOWER= "Fecha Solicitud";
    	public static final String LABEL_OBSEVACION= "Obsevacion";
		public static final String LABEL_OBSEVACION_LOWER= "Obsevacion";
    	public static final String LABEL_WEB= "Web";
		public static final String LABEL_WEB_LOWER= "Web";
    	public static final String LABEL_CASILLAPOSTAL= "Casilla Postal";
		public static final String LABEL_CASILLAPOSTAL_LOWER= "Casilla Postal";
    	public static final String LABEL_FORMAENVIO= "Forma Envio";
		public static final String LABEL_FORMAENVIO_LOWER= "Forma Envio";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDTIPOCUENTABANCOGLOBAL= "Tipo Cuenta Banco Global";
		public static final String LABEL_IDTIPOCUENTABANCOGLOBAL_LOWER= "Tipo Cuenta Banco Global";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_IDESTADOPOLITICASCLIENTE= "Estado Politicas Cliente";
		public static final String LABEL_IDESTADOPOLITICASCLIENTE_LOWER= "Estado Politicas Cliente";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXOBSEVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSEVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXWEB=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXWEB=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCASILLA_POSTAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCASILLA_POSTAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXFORMA_ENVIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFORMA_ENVIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getPoliticasClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.LIMITECREDITO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_LIMITECREDITO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.FECHAINICIO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.FECHARENOVACION)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_FECHARENOVACION;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.FECHAFIN)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.DIASNETOPAGO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_DIASNETOPAGO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.DIASGRACIA)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_DIASGRACIA;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.CUPO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_CUPO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.DESCUENTOGENERAL)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_DESCUENTOGENERAL;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_DESCUENTOPRONTOPAGO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.CONLISTAPRECIO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_CONLISTAPRECIO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.CONIMPUESTOS)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_CONIMPUESTOS;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_ACTIVARMONTOFACTURACION;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.VALORSOBREGIRO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_VALORSOBREGIRO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_FECHAVENCISOBREGIRO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.IDTRANSPORTE)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_IDTRANSPORTE;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.VALORSOLICITADO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_VALORSOLICITADO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.VALORAPROBADO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_VALORAPROBADO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.IDLINEANEGOCIO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_IDLINEANEGOCIO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.FECHASOLICITUD)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_FECHASOLICITUD;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.OBSEVACION)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_OBSEVACION;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.WEB)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_WEB;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.CASILLAPOSTAL)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_CASILLAPOSTAL;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.FORMAENVIO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_FORMAENVIO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.IDBANCO)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE)) {sLabelColumna=PoliticasClienteConstantesFunciones.LABEL_IDESTADOPOLITICASCLIENTE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_lista_precioDescripcion(PoliticasCliente politicascliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!politicascliente.getcon_lista_precio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_lista_precioHtmlDescripcion(PoliticasCliente politicascliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(politicascliente.getId(),politicascliente.getcon_lista_precio());

		return sDescripcion;
	}	
		
	public static String getcon_impuestosDescripcion(PoliticasCliente politicascliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!politicascliente.getcon_impuestos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_impuestosHtmlDescripcion(PoliticasCliente politicascliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(politicascliente.getId(),politicascliente.getcon_impuestos());

		return sDescripcion;
	}	
		
	public static String getactivar_monto_facturacionDescripcion(PoliticasCliente politicascliente) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!politicascliente.getactivar_monto_facturacion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getactivar_monto_facturacionHtmlDescripcion(PoliticasCliente politicascliente) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(politicascliente.getId(),politicascliente.getactivar_monto_facturacion());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPoliticasClienteDescripcion(PoliticasCliente politicascliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(politicascliente !=null/* && politicascliente.getId()!=0*/) {
			sDescripcion=politicascliente.getfecha_inicio().toString();//politicasclientepoliticascliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPoliticasClienteDescripcionDetallado(PoliticasCliente politicascliente) {
		String sDescripcion="";
			
		sDescripcion+=PoliticasClienteConstantesFunciones.ID+"=";
		sDescripcion+=politicascliente.getId().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=politicascliente.getVersionRow().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=politicascliente.getid_empresa().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.LIMITECREDITO+"=";
		sDescripcion+=politicascliente.getlimite_credito().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=politicascliente.getfecha_inicio().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.FECHARENOVACION+"=";
		sDescripcion+=politicascliente.getfecha_renovacion().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=politicascliente.getfecha_fin().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.DIASNETOPAGO+"=";
		sDescripcion+=politicascliente.getdias_neto_pago().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.DIASGRACIA+"=";
		sDescripcion+=politicascliente.getdias_gracia().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.CUPO+"=";
		sDescripcion+=politicascliente.getcupo().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.DESCUENTOGENERAL+"=";
		sDescripcion+=politicascliente.getdescuento_general().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO+"=";
		sDescripcion+=politicascliente.getdescuento_pronto_pago().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=politicascliente.getid_tipo_precio().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.CONLISTAPRECIO+"=";
		sDescripcion+=politicascliente.getcon_lista_precio().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.CONIMPUESTOS+"=";
		sDescripcion+=politicascliente.getcon_impuestos().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION+"=";
		sDescripcion+=politicascliente.getactivar_monto_facturacion().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.VALORSOBREGIRO+"=";
		sDescripcion+=politicascliente.getvalor_sobregiro().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO+"=";
		sDescripcion+=politicascliente.getfecha_venci_sobregiro().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.IDTRANSPORTE+"=";
		sDescripcion+=politicascliente.getid_transporte().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.VALORSOLICITADO+"=";
		sDescripcion+=politicascliente.getvalor_solicitado().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.VALORAPROBADO+"=";
		sDescripcion+=politicascliente.getvalor_aprobado().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.IDLINEANEGOCIO+"=";
		sDescripcion+=politicascliente.getid_linea_negocio().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.FECHASOLICITUD+"=";
		sDescripcion+=politicascliente.getfecha_solicitud().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.OBSEVACION+"=";
		sDescripcion+=politicascliente.getobsevacion()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.WEB+"=";
		sDescripcion+=politicascliente.getweb()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.CASILLAPOSTAL+"=";
		sDescripcion+=politicascliente.getcasilla_postal()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.FORMAENVIO+"=";
		sDescripcion+=politicascliente.getforma_envio()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.IDBANCO+"=";
		sDescripcion+=politicascliente.getid_banco().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL+"=";
		sDescripcion+=politicascliente.getid_tipo_cuenta_banco_global().toString()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=politicascliente.getnumero_cuenta()+",";
		sDescripcion+=PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE+"=";
		sDescripcion+=politicascliente.getid_estado_politicas_cliente().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setPoliticasClienteDescripcion(PoliticasCliente politicascliente,String sValor) throws Exception {			
		if(politicascliente !=null) {
			//politicasclientepoliticascliente.getId().toString();
		}		
	}
	
		

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
		}

		return sDescripcion;
	}

	public static String getTransporteDescripcion(Transporte transporte) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transporte!=null/*&&transporte.getId()>0*/) {
			sDescripcion=TransporteConstantesFunciones.getTransporteDescripcion(transporte);
		}

		return sDescripcion;
	}

	public static String getLineaNegocioDescripcion(LineaNegocio lineanegocio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(lineanegocio!=null/*&&lineanegocio.getId()>0*/) {
			sDescripcion=LineaNegocioConstantesFunciones.getLineaNegocioDescripcion(lineanegocio);
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

	public static String getTipoCuentaBancoGlobalDescripcion(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuentabancoglobal!=null/*&&tipocuentabancoglobal.getId()>0*/) {
			sDescripcion=TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(tipocuentabancoglobal);
		}

		return sDescripcion;
	}

	public static String getEstadoPoliticasClienteDescripcion(EstadoPoliticasCliente estadopoliticascliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadopoliticascliente!=null/*&&estadopoliticascliente.getId()>0*/) {
			sDescripcion=EstadoPoliticasClienteConstantesFunciones.getEstadoPoliticasClienteDescripcion(estadopoliticascliente);
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
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoPoliticasCliente")) {
			sNombreIndice="Tipo=  Por Estado Politicas Cliente";
		} else if(sNombreIndice.equals("FK_IdLineaNegocio")) {
			sNombreIndice="Tipo=  Por Linea Negocio";
		} else if(sNombreIndice.equals("FK_IdTipoCuentaBancoGlobal")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta Banco Global";
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
		} else if(sNombreIndice.equals("FK_IdTransporte")) {
			sNombreIndice="Tipo=  Por Transporte";
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

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De ="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoPoliticasCliente(Long id_estado_politicas_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_politicas_cliente!=null) {sDetalleIndice+=" Codigo Unico De Estado Politicas Cliente="+id_estado_politicas_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaNegocio(Long id_linea_negocio) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_negocio!=null) {sDetalleIndice+=" Codigo Unico De Linea Negocio="+id_linea_negocio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuentaBancoGlobal(Long id_tipo_cuenta_banco_global) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuenta_banco_global!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta Banco Global="+id_tipo_cuenta_banco_global.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransporte(Long id_transporte) {
		String sDetalleIndice=" Parametros->";
		if(id_transporte!=null) {sDetalleIndice+=" Codigo Unico De Transporte="+id_transporte.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPoliticasCliente(PoliticasCliente politicascliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		politicascliente.setobsevacion(politicascliente.getobsevacion().trim());
		politicascliente.setweb(politicascliente.getweb().trim());
		politicascliente.setcasilla_postal(politicascliente.getcasilla_postal().trim());
		politicascliente.setforma_envio(politicascliente.getforma_envio().trim());
		politicascliente.setnumero_cuenta(politicascliente.getnumero_cuenta().trim());
	}
	
	public static void quitarEspaciosPoliticasClientes(List<PoliticasCliente> politicasclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PoliticasCliente politicascliente: politicasclientes) {
			politicascliente.setobsevacion(politicascliente.getobsevacion().trim());
			politicascliente.setweb(politicascliente.getweb().trim());
			politicascliente.setcasilla_postal(politicascliente.getcasilla_postal().trim());
			politicascliente.setforma_envio(politicascliente.getforma_envio().trim());
			politicascliente.setnumero_cuenta(politicascliente.getnumero_cuenta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPoliticasCliente(PoliticasCliente politicascliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && politicascliente.getConCambioAuxiliar()) {
			politicascliente.setIsDeleted(politicascliente.getIsDeletedAuxiliar());	
			politicascliente.setIsNew(politicascliente.getIsNewAuxiliar());	
			politicascliente.setIsChanged(politicascliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			politicascliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			politicascliente.setIsDeletedAuxiliar(false);	
			politicascliente.setIsNewAuxiliar(false);	
			politicascliente.setIsChangedAuxiliar(false);
			
			politicascliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPoliticasClientes(List<PoliticasCliente> politicasclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PoliticasCliente politicascliente : politicasclientes) {
			if(conAsignarBase && politicascliente.getConCambioAuxiliar()) {
				politicascliente.setIsDeleted(politicascliente.getIsDeletedAuxiliar());	
				politicascliente.setIsNew(politicascliente.getIsNewAuxiliar());	
				politicascliente.setIsChanged(politicascliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				politicascliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				politicascliente.setIsDeletedAuxiliar(false);	
				politicascliente.setIsNewAuxiliar(false);	
				politicascliente.setIsChangedAuxiliar(false);
				
				politicascliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPoliticasCliente(PoliticasCliente politicascliente,Boolean conEnteros) throws Exception  {
		politicascliente.setlimite_credito(0.0);
		politicascliente.setcupo(0.0);
		politicascliente.setdescuento_general(0.0);
		politicascliente.setdescuento_pronto_pago(0.0);
		politicascliente.setvalor_sobregiro(0.0);
		politicascliente.setvalor_solicitado(0.0);
		politicascliente.setvalor_aprobado(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			politicascliente.setdias_neto_pago(0);
			politicascliente.setdias_gracia(0);
		}
	}		
	
	public static void InicializarValoresPoliticasClientes(List<PoliticasCliente> politicasclientes,Boolean conEnteros) throws Exception  {
		
		for(PoliticasCliente politicascliente: politicasclientes) {
			politicascliente.setlimite_credito(0.0);
			politicascliente.setcupo(0.0);
			politicascliente.setdescuento_general(0.0);
			politicascliente.setdescuento_pronto_pago(0.0);
			politicascliente.setvalor_sobregiro(0.0);
			politicascliente.setvalor_solicitado(0.0);
			politicascliente.setvalor_aprobado(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				politicascliente.setdias_neto_pago(0);
				politicascliente.setdias_gracia(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPoliticasCliente(List<PoliticasCliente> politicasclientes,PoliticasCliente politicasclienteAux) throws Exception  {
		PoliticasClienteConstantesFunciones.InicializarValoresPoliticasCliente(politicasclienteAux,true);
		
		for(PoliticasCliente politicascliente: politicasclientes) {
			if(politicascliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			politicasclienteAux.setlimite_credito(politicasclienteAux.getlimite_credito()+politicascliente.getlimite_credito());			
			politicasclienteAux.setdias_neto_pago(politicasclienteAux.getdias_neto_pago()+politicascliente.getdias_neto_pago());			
			politicasclienteAux.setdias_gracia(politicasclienteAux.getdias_gracia()+politicascliente.getdias_gracia());			
			politicasclienteAux.setcupo(politicasclienteAux.getcupo()+politicascliente.getcupo());			
			politicasclienteAux.setdescuento_general(politicasclienteAux.getdescuento_general()+politicascliente.getdescuento_general());			
			politicasclienteAux.setdescuento_pronto_pago(politicasclienteAux.getdescuento_pronto_pago()+politicascliente.getdescuento_pronto_pago());			
			politicasclienteAux.setvalor_sobregiro(politicasclienteAux.getvalor_sobregiro()+politicascliente.getvalor_sobregiro());			
			politicasclienteAux.setvalor_solicitado(politicasclienteAux.getvalor_solicitado()+politicascliente.getvalor_solicitado());			
			politicasclienteAux.setvalor_aprobado(politicasclienteAux.getvalor_aprobado()+politicascliente.getvalor_aprobado());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPoliticasCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PoliticasClienteConstantesFunciones.getArrayColumnasGlobalesPoliticasCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPoliticasCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PoliticasClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PoliticasClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPoliticasCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PoliticasCliente> politicasclientes,PoliticasCliente politicascliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PoliticasCliente politicasclienteAux: politicasclientes) {
			if(politicasclienteAux!=null && politicascliente!=null) {
				if((politicasclienteAux.getId()==null && politicascliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(politicasclienteAux.getId()!=null && politicascliente.getId()!=null){
					if(politicasclienteAux.getId().equals(politicascliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPoliticasCliente(List<PoliticasCliente> politicasclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double limite_creditoTotal=0.0;
		Double cupoTotal=0.0;
		Double descuento_generalTotal=0.0;
		Double descuento_pronto_pagoTotal=0.0;
		Double valor_sobregiroTotal=0.0;
		Double valor_solicitadoTotal=0.0;
		Double valor_aprobadoTotal=0.0;
	
		for(PoliticasCliente politicascliente: politicasclientes) {			
			if(politicascliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			limite_creditoTotal+=politicascliente.getlimite_credito();
			cupoTotal+=politicascliente.getcupo();
			descuento_generalTotal+=politicascliente.getdescuento_general();
			descuento_pronto_pagoTotal+=politicascliente.getdescuento_pronto_pago();
			valor_sobregiroTotal+=politicascliente.getvalor_sobregiro();
			valor_solicitadoTotal+=politicascliente.getvalor_solicitado();
			valor_aprobadoTotal+=politicascliente.getvalor_aprobado();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticasClienteConstantesFunciones.LIMITECREDITO);
		datoGeneral.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_LIMITECREDITO);
		datoGeneral.setdValorDouble(limite_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticasClienteConstantesFunciones.CUPO);
		datoGeneral.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_CUPO);
		datoGeneral.setdValorDouble(cupoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticasClienteConstantesFunciones.DESCUENTOGENERAL);
		datoGeneral.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_DESCUENTOGENERAL);
		datoGeneral.setdValorDouble(descuento_generalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO);
		datoGeneral.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_DESCUENTOPRONTOPAGO);
		datoGeneral.setdValorDouble(descuento_pronto_pagoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticasClienteConstantesFunciones.VALORSOBREGIRO);
		datoGeneral.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_VALORSOBREGIRO);
		datoGeneral.setdValorDouble(valor_sobregiroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticasClienteConstantesFunciones.VALORSOLICITADO);
		datoGeneral.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_VALORSOLICITADO);
		datoGeneral.setdValorDouble(valor_solicitadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(PoliticasClienteConstantesFunciones.VALORAPROBADO);
		datoGeneral.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_VALORAPROBADO);
		datoGeneral.setdValorDouble(valor_aprobadoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPoliticasCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_ID, PoliticasClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_VERSIONROW, PoliticasClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_IDEMPRESA, PoliticasClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_LIMITECREDITO, PoliticasClienteConstantesFunciones.LIMITECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_FECHAINICIO, PoliticasClienteConstantesFunciones.FECHAINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_FECHARENOVACION, PoliticasClienteConstantesFunciones.FECHARENOVACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_FECHAFIN, PoliticasClienteConstantesFunciones.FECHAFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_DIASNETOPAGO, PoliticasClienteConstantesFunciones.DIASNETOPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_DIASGRACIA, PoliticasClienteConstantesFunciones.DIASGRACIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_CUPO, PoliticasClienteConstantesFunciones.CUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_DESCUENTOGENERAL, PoliticasClienteConstantesFunciones.DESCUENTOGENERAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_DESCUENTOPRONTOPAGO, PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_IDTIPOPRECIO, PoliticasClienteConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_CONLISTAPRECIO, PoliticasClienteConstantesFunciones.CONLISTAPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_CONIMPUESTOS, PoliticasClienteConstantesFunciones.CONIMPUESTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_ACTIVARMONTOFACTURACION, PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_VALORSOBREGIRO, PoliticasClienteConstantesFunciones.VALORSOBREGIRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_FECHAVENCISOBREGIRO, PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_IDTRANSPORTE, PoliticasClienteConstantesFunciones.IDTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_VALORSOLICITADO, PoliticasClienteConstantesFunciones.VALORSOLICITADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_VALORAPROBADO, PoliticasClienteConstantesFunciones.VALORAPROBADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_IDLINEANEGOCIO, PoliticasClienteConstantesFunciones.IDLINEANEGOCIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_FECHASOLICITUD, PoliticasClienteConstantesFunciones.FECHASOLICITUD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_OBSEVACION, PoliticasClienteConstantesFunciones.OBSEVACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_WEB, PoliticasClienteConstantesFunciones.WEB,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_CASILLAPOSTAL, PoliticasClienteConstantesFunciones.CASILLAPOSTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_FORMAENVIO, PoliticasClienteConstantesFunciones.FORMAENVIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_IDBANCO, PoliticasClienteConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL, PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_NUMEROCUENTA, PoliticasClienteConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PoliticasClienteConstantesFunciones.LABEL_IDESTADOPOLITICASCLIENTE, PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPoliticasCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.LIMITECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.FECHAINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.FECHARENOVACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.FECHAFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.DIASNETOPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.DIASGRACIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.CUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.DESCUENTOGENERAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.CONLISTAPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.CONIMPUESTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.VALORSOBREGIRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.IDTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.VALORSOLICITADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.VALORAPROBADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.IDLINEANEGOCIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.FECHASOLICITUD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.OBSEVACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.WEB;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.CASILLAPOSTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.FORMAENVIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticasCliente() throws Exception  {
		return PoliticasClienteConstantesFunciones.getTiposSeleccionarPoliticasCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticasCliente(Boolean conFk) throws Exception  {
		return PoliticasClienteConstantesFunciones.getTiposSeleccionarPoliticasCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPoliticasCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_LIMITECREDITO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_LIMITECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_FECHARENOVACION);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_FECHARENOVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_DIASNETOPAGO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_DIASNETOPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_DIASGRACIA);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_DIASGRACIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_CUPO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_CUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_DESCUENTOGENERAL);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_DESCUENTOGENERAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_DESCUENTOPRONTOPAGO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_DESCUENTOPRONTOPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_CONLISTAPRECIO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_CONLISTAPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_CONIMPUESTOS);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_CONIMPUESTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_ACTIVARMONTOFACTURACION);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_ACTIVARMONTOFACTURACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_VALORSOBREGIRO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_VALORSOBREGIRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_FECHAVENCISOBREGIRO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_FECHAVENCISOBREGIRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_IDTRANSPORTE);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_IDTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_VALORSOLICITADO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_VALORSOLICITADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_VALORAPROBADO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_VALORAPROBADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_IDLINEANEGOCIO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_IDLINEANEGOCIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_FECHASOLICITUD);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_FECHASOLICITUD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_OBSEVACION);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_OBSEVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_WEB);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_WEB);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_CASILLAPOSTAL);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_CASILLAPOSTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_FORMAENVIO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_FORMAENVIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PoliticasClienteConstantesFunciones.LABEL_IDESTADOPOLITICASCLIENTE);
			reporte.setsDescripcion(PoliticasClienteConstantesFunciones.LABEL_IDESTADOPOLITICASCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPoliticasCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPoliticasCliente(PoliticasCliente politicasclienteAux) throws Exception {
		
			politicasclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(politicasclienteAux.getCliente()));
			politicasclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(politicasclienteAux.getEmpresa()));
			politicasclienteAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(politicasclienteAux.getTipoPrecio()));
			politicasclienteAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(politicasclienteAux.getTransporte()));
			politicasclienteAux.setlineanegocio_descripcion(LineaNegocioConstantesFunciones.getLineaNegocioDescripcion(politicasclienteAux.getLineaNegocio()));
			politicasclienteAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(politicasclienteAux.getBanco()));
			politicasclienteAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(politicasclienteAux.getTipoCuentaBancoGlobal()));
			politicasclienteAux.setestadopoliticascliente_descripcion(EstadoPoliticasClienteConstantesFunciones.getEstadoPoliticasClienteDescripcion(politicasclienteAux.getEstadoPoliticasCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPoliticasCliente(List<PoliticasCliente> politicasclientesTemp) throws Exception {
		for(PoliticasCliente politicasclienteAux:politicasclientesTemp) {
			
			politicasclienteAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(politicasclienteAux.getCliente()));
			politicasclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(politicasclienteAux.getEmpresa()));
			politicasclienteAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(politicasclienteAux.getTipoPrecio()));
			politicasclienteAux.settransporte_descripcion(TransporteConstantesFunciones.getTransporteDescripcion(politicasclienteAux.getTransporte()));
			politicasclienteAux.setlineanegocio_descripcion(LineaNegocioConstantesFunciones.getLineaNegocioDescripcion(politicasclienteAux.getLineaNegocio()));
			politicasclienteAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(politicasclienteAux.getBanco()));
			politicasclienteAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(politicasclienteAux.getTipoCuentaBancoGlobal()));
			politicasclienteAux.setestadopoliticascliente_descripcion(EstadoPoliticasClienteConstantesFunciones.getEstadoPoliticasClienteDescripcion(politicasclienteAux.getEstadoPoliticasCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoPrecio.class));
				classes.add(new Classe(Transporte.class));
				classes.add(new Classe(LineaNegocio.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(TipoCuentaBancoGlobal.class));
				classes.add(new Classe(EstadoPoliticasCliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transporte.class)) {
						classes.add(new Classe(Transporte.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(LineaNegocio.class)) {
						classes.add(new Classe(LineaNegocio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoPoliticasCliente.class)) {
						classes.add(new Classe(EstadoPoliticasCliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPoliticasCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(LineaNegocio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LineaNegocio.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}

					if(EstadoPoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPoliticasCliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
					}

					if(Transporte.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transporte.class)); continue;
					}

					if(LineaNegocio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(LineaNegocio.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}

					if(EstadoPoliticasCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoPoliticasCliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PoliticasClienteConstantesFunciones.getClassesRelationshipsOfPoliticasCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPoliticasCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PoliticasClienteConstantesFunciones.getClassesRelationshipsFromStringsOfPoliticasCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPoliticasCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(PoliticasCliente politicascliente,List<PoliticasCliente> politicasclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PoliticasCliente politicasclienteEncontrado=null;
			
			for(PoliticasCliente politicasclienteLocal:politicasclientes) {
				if(politicasclienteLocal.getId().equals(politicascliente.getId())) {
					politicasclienteEncontrado=politicasclienteLocal;
					
					politicasclienteLocal.setIsChanged(politicascliente.getIsChanged());
					politicasclienteLocal.setIsNew(politicascliente.getIsNew());
					politicasclienteLocal.setIsDeleted(politicascliente.getIsDeleted());
					
					politicasclienteLocal.setGeneralEntityOriginal(politicascliente.getGeneralEntityOriginal());
					
					politicasclienteLocal.setId(politicascliente.getId());	
					politicasclienteLocal.setVersionRow(politicascliente.getVersionRow());	
					politicasclienteLocal.setid_empresa(politicascliente.getid_empresa());	
					politicasclienteLocal.setlimite_credito(politicascliente.getlimite_credito());	
					politicasclienteLocal.setfecha_inicio(politicascliente.getfecha_inicio());	
					politicasclienteLocal.setfecha_renovacion(politicascliente.getfecha_renovacion());	
					politicasclienteLocal.setfecha_fin(politicascliente.getfecha_fin());	
					politicasclienteLocal.setdias_neto_pago(politicascliente.getdias_neto_pago());	
					politicasclienteLocal.setdias_gracia(politicascliente.getdias_gracia());	
					politicasclienteLocal.setcupo(politicascliente.getcupo());	
					politicasclienteLocal.setdescuento_general(politicascliente.getdescuento_general());	
					politicasclienteLocal.setdescuento_pronto_pago(politicascliente.getdescuento_pronto_pago());	
					politicasclienteLocal.setid_tipo_precio(politicascliente.getid_tipo_precio());	
					politicasclienteLocal.setcon_lista_precio(politicascliente.getcon_lista_precio());	
					politicasclienteLocal.setcon_impuestos(politicascliente.getcon_impuestos());	
					politicasclienteLocal.setactivar_monto_facturacion(politicascliente.getactivar_monto_facturacion());	
					politicasclienteLocal.setvalor_sobregiro(politicascliente.getvalor_sobregiro());	
					politicasclienteLocal.setfecha_venci_sobregiro(politicascliente.getfecha_venci_sobregiro());	
					politicasclienteLocal.setid_transporte(politicascliente.getid_transporte());	
					politicasclienteLocal.setvalor_solicitado(politicascliente.getvalor_solicitado());	
					politicasclienteLocal.setvalor_aprobado(politicascliente.getvalor_aprobado());	
					politicasclienteLocal.setid_linea_negocio(politicascliente.getid_linea_negocio());	
					politicasclienteLocal.setfecha_solicitud(politicascliente.getfecha_solicitud());	
					politicasclienteLocal.setobsevacion(politicascliente.getobsevacion());	
					politicasclienteLocal.setweb(politicascliente.getweb());	
					politicasclienteLocal.setcasilla_postal(politicascliente.getcasilla_postal());	
					politicasclienteLocal.setforma_envio(politicascliente.getforma_envio());	
					politicasclienteLocal.setid_banco(politicascliente.getid_banco());	
					politicasclienteLocal.setid_tipo_cuenta_banco_global(politicascliente.getid_tipo_cuenta_banco_global());	
					politicasclienteLocal.setnumero_cuenta(politicascliente.getnumero_cuenta());	
					politicasclienteLocal.setid_estado_politicas_cliente(politicascliente.getid_estado_politicas_cliente());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!politicascliente.getIsDeleted()) {
				if(!existe) {
					politicasclientes.add(politicascliente);
				}
			} else {
				if(politicasclienteEncontrado!=null && permiteQuitar)  {
					politicasclientes.remove(politicasclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PoliticasCliente politicascliente,List<PoliticasCliente> politicasclientes) throws Exception {
		try	{			
			for(PoliticasCliente politicasclienteLocal:politicasclientes) {
				if(politicasclienteLocal.getId().equals(politicascliente.getId())) {
					politicasclienteLocal.setIsSelected(politicascliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPoliticasCliente(List<PoliticasCliente> politicasclientesAux) throws Exception {
		//this.politicasclientesAux=politicasclientesAux;
		
		for(PoliticasCliente politicasclienteAux:politicasclientesAux) {
			if(politicasclienteAux.getIsChanged()) {
				politicasclienteAux.setIsChanged(false);
			}		
			
			if(politicasclienteAux.getIsNew()) {
				politicasclienteAux.setIsNew(false);
			}	
			
			if(politicasclienteAux.getIsDeleted()) {
				politicasclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPoliticasCliente(PoliticasCliente politicasclienteAux) throws Exception {
		//this.politicasclienteAux=politicasclienteAux;
		
			if(politicasclienteAux.getIsChanged()) {
				politicasclienteAux.setIsChanged(false);
			}		
			
			if(politicasclienteAux.getIsNew()) {
				politicasclienteAux.setIsNew(false);
			}	
			
			if(politicasclienteAux.getIsDeleted()) {
				politicasclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PoliticasCliente politicasclienteAsignar,PoliticasCliente politicascliente) throws Exception {
		politicasclienteAsignar.setId(politicascliente.getId());	
		politicasclienteAsignar.setVersionRow(politicascliente.getVersionRow());	
		politicasclienteAsignar.setid_empresa(politicascliente.getid_empresa());
		politicasclienteAsignar.setempresa_descripcion(politicascliente.getempresa_descripcion());	
		politicasclienteAsignar.setlimite_credito(politicascliente.getlimite_credito());	
		politicasclienteAsignar.setfecha_inicio(politicascliente.getfecha_inicio());	
		politicasclienteAsignar.setfecha_renovacion(politicascliente.getfecha_renovacion());	
		politicasclienteAsignar.setfecha_fin(politicascliente.getfecha_fin());	
		politicasclienteAsignar.setdias_neto_pago(politicascliente.getdias_neto_pago());	
		politicasclienteAsignar.setdias_gracia(politicascliente.getdias_gracia());	
		politicasclienteAsignar.setcupo(politicascliente.getcupo());	
		politicasclienteAsignar.setdescuento_general(politicascliente.getdescuento_general());	
		politicasclienteAsignar.setdescuento_pronto_pago(politicascliente.getdescuento_pronto_pago());	
		politicasclienteAsignar.setid_tipo_precio(politicascliente.getid_tipo_precio());
		politicasclienteAsignar.settipoprecio_descripcion(politicascliente.gettipoprecio_descripcion());	
		politicasclienteAsignar.setcon_lista_precio(politicascliente.getcon_lista_precio());	
		politicasclienteAsignar.setcon_impuestos(politicascliente.getcon_impuestos());	
		politicasclienteAsignar.setactivar_monto_facturacion(politicascliente.getactivar_monto_facturacion());	
		politicasclienteAsignar.setvalor_sobregiro(politicascliente.getvalor_sobregiro());	
		politicasclienteAsignar.setfecha_venci_sobregiro(politicascliente.getfecha_venci_sobregiro());	
		politicasclienteAsignar.setid_transporte(politicascliente.getid_transporte());
		politicasclienteAsignar.settransporte_descripcion(politicascliente.gettransporte_descripcion());	
		politicasclienteAsignar.setvalor_solicitado(politicascliente.getvalor_solicitado());	
		politicasclienteAsignar.setvalor_aprobado(politicascliente.getvalor_aprobado());	
		politicasclienteAsignar.setid_linea_negocio(politicascliente.getid_linea_negocio());
		politicasclienteAsignar.setlineanegocio_descripcion(politicascliente.getlineanegocio_descripcion());	
		politicasclienteAsignar.setfecha_solicitud(politicascliente.getfecha_solicitud());	
		politicasclienteAsignar.setobsevacion(politicascliente.getobsevacion());	
		politicasclienteAsignar.setweb(politicascliente.getweb());	
		politicasclienteAsignar.setcasilla_postal(politicascliente.getcasilla_postal());	
		politicasclienteAsignar.setforma_envio(politicascliente.getforma_envio());	
		politicasclienteAsignar.setid_banco(politicascliente.getid_banco());
		politicasclienteAsignar.setbanco_descripcion(politicascliente.getbanco_descripcion());	
		politicasclienteAsignar.setid_tipo_cuenta_banco_global(politicascliente.getid_tipo_cuenta_banco_global());
		politicasclienteAsignar.settipocuentabancoglobal_descripcion(politicascliente.gettipocuentabancoglobal_descripcion());	
		politicasclienteAsignar.setnumero_cuenta(politicascliente.getnumero_cuenta());	
		politicasclienteAsignar.setid_estado_politicas_cliente(politicascliente.getid_estado_politicas_cliente());
		politicasclienteAsignar.setestadopoliticascliente_descripcion(politicascliente.getestadopoliticascliente_descripcion());	
	}
	
	public static void inicializarPoliticasCliente(PoliticasCliente politicascliente) throws Exception {
		try {
				politicascliente.setId(-1L);	
					
				politicascliente.setid_empresa(-1L);	
				politicascliente.setlimite_credito(0.0);	
				politicascliente.setfecha_inicio(new Date());	
				politicascliente.setfecha_renovacion(new Date());	
				politicascliente.setfecha_fin(new Date());	
				politicascliente.setdias_neto_pago(0);	
				politicascliente.setdias_gracia(0);	
				politicascliente.setcupo(0.0);	
				politicascliente.setdescuento_general(0.0);	
				politicascliente.setdescuento_pronto_pago(0.0);	
				politicascliente.setid_tipo_precio(-1L);	
				politicascliente.setcon_lista_precio(false);	
				politicascliente.setcon_impuestos(false);	
				politicascliente.setactivar_monto_facturacion(false);	
				politicascliente.setvalor_sobregiro(0.0);	
				politicascliente.setfecha_venci_sobregiro(new Date());	
				politicascliente.setid_transporte(-1L);	
				politicascliente.setvalor_solicitado(0.0);	
				politicascliente.setvalor_aprobado(0.0);	
				politicascliente.setid_linea_negocio(-1L);	
				politicascliente.setfecha_solicitud(new Date());	
				politicascliente.setobsevacion("");	
				politicascliente.setweb("");	
				politicascliente.setcasilla_postal("");	
				politicascliente.setforma_envio("");	
				politicascliente.setid_banco(-1L);	
				politicascliente.setid_tipo_cuenta_banco_global(-1L);	
				politicascliente.setnumero_cuenta("");	
				politicascliente.setid_estado_politicas_cliente(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPoliticasCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_LIMITECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_FECHARENOVACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_DIASNETOPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_DIASGRACIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_CUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_DESCUENTOGENERAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_DESCUENTOPRONTOPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_CONLISTAPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_CONIMPUESTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_ACTIVARMONTOFACTURACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_VALORSOBREGIRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_FECHAVENCISOBREGIRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_IDTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_VALORSOLICITADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_VALORAPROBADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_IDLINEANEGOCIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_FECHASOLICITUD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_OBSEVACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_WEB);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_CASILLAPOSTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_FORMAENVIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PoliticasClienteConstantesFunciones.LABEL_IDESTADOPOLITICASCLIENTE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPoliticasCliente(String sTipo,Row row,Workbook workbook,PoliticasCliente politicascliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getlimite_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getfecha_renovacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getdias_neto_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getdias_gracia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getcupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getdescuento_general());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getdescuento_pronto_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(politicascliente.getcon_lista_precio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(politicascliente.getcon_impuestos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(politicascliente.getactivar_monto_facturacion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getvalor_sobregiro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getfecha_venci_sobregiro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.gettransporte_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getvalor_solicitado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getvalor_aprobado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getlineanegocio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getfecha_solicitud());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getobsevacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getweb());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getcasilla_postal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getforma_envio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.gettipocuentabancoglobal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(politicascliente.getestadopoliticascliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPoliticasCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPoliticasCliente() {
		return this.sFinalQueryPoliticasCliente;
	}
	
	public void setsFinalQueryPoliticasCliente(String sFinalQueryPoliticasCliente) {
		this.sFinalQueryPoliticasCliente= sFinalQueryPoliticasCliente;
	}
	
	public Border resaltarSeleccionarPoliticasCliente=null;
	
	public Border setResaltarSeleccionarPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPoliticasCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPoliticasCliente() {
		return this.resaltarSeleccionarPoliticasCliente;
	}
	
	public void setResaltarSeleccionarPoliticasCliente(Border borderResaltarSeleccionarPoliticasCliente) {
		this.resaltarSeleccionarPoliticasCliente= borderResaltarSeleccionarPoliticasCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltarid_clientePoliticasCliente=null;
	public Boolean mostrarid_clientePoliticasCliente=true;
	public Boolean activarid_clientePoliticasCliente=true;
	public Boolean cargarid_clientePoliticasCliente=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clientePoliticasCliente=false;//ConEventDepend=true

	public Border resaltarid_empresaPoliticasCliente=null;
	public Boolean mostrarid_empresaPoliticasCliente=true;
	public Boolean activarid_empresaPoliticasCliente=true;
	public Boolean cargarid_empresaPoliticasCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPoliticasCliente=false;//ConEventDepend=true

	public Border resaltarlimite_creditoPoliticasCliente=null;
	public Boolean mostrarlimite_creditoPoliticasCliente=true;
	public Boolean activarlimite_creditoPoliticasCliente=true;

	public Border resaltarfecha_inicioPoliticasCliente=null;
	public Boolean mostrarfecha_inicioPoliticasCliente=true;
	public Boolean activarfecha_inicioPoliticasCliente=false;

	public Border resaltarfecha_renovacionPoliticasCliente=null;
	public Boolean mostrarfecha_renovacionPoliticasCliente=true;
	public Boolean activarfecha_renovacionPoliticasCliente=false;

	public Border resaltarfecha_finPoliticasCliente=null;
	public Boolean mostrarfecha_finPoliticasCliente=true;
	public Boolean activarfecha_finPoliticasCliente=false;

	public Border resaltardias_neto_pagoPoliticasCliente=null;
	public Boolean mostrardias_neto_pagoPoliticasCliente=true;
	public Boolean activardias_neto_pagoPoliticasCliente=true;

	public Border resaltardias_graciaPoliticasCliente=null;
	public Boolean mostrardias_graciaPoliticasCliente=true;
	public Boolean activardias_graciaPoliticasCliente=true;

	public Border resaltarcupoPoliticasCliente=null;
	public Boolean mostrarcupoPoliticasCliente=true;
	public Boolean activarcupoPoliticasCliente=true;

	public Border resaltardescuento_generalPoliticasCliente=null;
	public Boolean mostrardescuento_generalPoliticasCliente=true;
	public Boolean activardescuento_generalPoliticasCliente=true;

	public Border resaltardescuento_pronto_pagoPoliticasCliente=null;
	public Boolean mostrardescuento_pronto_pagoPoliticasCliente=true;
	public Boolean activardescuento_pronto_pagoPoliticasCliente=true;

	public Border resaltarid_tipo_precioPoliticasCliente=null;
	public Boolean mostrarid_tipo_precioPoliticasCliente=true;
	public Boolean activarid_tipo_precioPoliticasCliente=true;
	public Boolean cargarid_tipo_precioPoliticasCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioPoliticasCliente=false;//ConEventDepend=true

	public Border resaltarcon_lista_precioPoliticasCliente=null;
	public Boolean mostrarcon_lista_precioPoliticasCliente=true;
	public Boolean activarcon_lista_precioPoliticasCliente=true;

	public Border resaltarcon_impuestosPoliticasCliente=null;
	public Boolean mostrarcon_impuestosPoliticasCliente=true;
	public Boolean activarcon_impuestosPoliticasCliente=true;

	public Border resaltaractivar_monto_facturacionPoliticasCliente=null;
	public Boolean mostraractivar_monto_facturacionPoliticasCliente=true;
	public Boolean activaractivar_monto_facturacionPoliticasCliente=true;

	public Border resaltarvalor_sobregiroPoliticasCliente=null;
	public Boolean mostrarvalor_sobregiroPoliticasCliente=true;
	public Boolean activarvalor_sobregiroPoliticasCliente=true;

	public Border resaltarfecha_venci_sobregiroPoliticasCliente=null;
	public Boolean mostrarfecha_venci_sobregiroPoliticasCliente=true;
	public Boolean activarfecha_venci_sobregiroPoliticasCliente=false;

	public Border resaltarid_transportePoliticasCliente=null;
	public Boolean mostrarid_transportePoliticasCliente=true;
	public Boolean activarid_transportePoliticasCliente=true;
	public Boolean cargarid_transportePoliticasCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportePoliticasCliente=false;//ConEventDepend=true

	public Border resaltarvalor_solicitadoPoliticasCliente=null;
	public Boolean mostrarvalor_solicitadoPoliticasCliente=true;
	public Boolean activarvalor_solicitadoPoliticasCliente=true;

	public Border resaltarvalor_aprobadoPoliticasCliente=null;
	public Boolean mostrarvalor_aprobadoPoliticasCliente=true;
	public Boolean activarvalor_aprobadoPoliticasCliente=true;

	public Border resaltarid_linea_negocioPoliticasCliente=null;
	public Boolean mostrarid_linea_negocioPoliticasCliente=true;
	public Boolean activarid_linea_negocioPoliticasCliente=true;
	public Boolean cargarid_linea_negocioPoliticasCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_negocioPoliticasCliente=false;//ConEventDepend=true

	public Border resaltarfecha_solicitudPoliticasCliente=null;
	public Boolean mostrarfecha_solicitudPoliticasCliente=true;
	public Boolean activarfecha_solicitudPoliticasCliente=false;

	public Border resaltarobsevacionPoliticasCliente=null;
	public Boolean mostrarobsevacionPoliticasCliente=true;
	public Boolean activarobsevacionPoliticasCliente=true;

	public Border resaltarwebPoliticasCliente=null;
	public Boolean mostrarwebPoliticasCliente=true;
	public Boolean activarwebPoliticasCliente=true;

	public Border resaltarcasilla_postalPoliticasCliente=null;
	public Boolean mostrarcasilla_postalPoliticasCliente=true;
	public Boolean activarcasilla_postalPoliticasCliente=true;

	public Border resaltarforma_envioPoliticasCliente=null;
	public Boolean mostrarforma_envioPoliticasCliente=true;
	public Boolean activarforma_envioPoliticasCliente=true;

	public Border resaltarid_bancoPoliticasCliente=null;
	public Boolean mostrarid_bancoPoliticasCliente=true;
	public Boolean activarid_bancoPoliticasCliente=true;
	public Boolean cargarid_bancoPoliticasCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoPoliticasCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_cuenta_banco_globalPoliticasCliente=null;
	public Boolean mostrarid_tipo_cuenta_banco_globalPoliticasCliente=true;
	public Boolean activarid_tipo_cuenta_banco_globalPoliticasCliente=true;
	public Boolean cargarid_tipo_cuenta_banco_globalPoliticasCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuenta_banco_globalPoliticasCliente=false;//ConEventDepend=true

	public Border resaltarnumero_cuentaPoliticasCliente=null;
	public Boolean mostrarnumero_cuentaPoliticasCliente=true;
	public Boolean activarnumero_cuentaPoliticasCliente=true;

	public Border resaltarid_estado_politicas_clientePoliticasCliente=null;
	public Boolean mostrarid_estado_politicas_clientePoliticasCliente=true;
	public Boolean activarid_estado_politicas_clientePoliticasCliente=true;
	public Boolean cargarid_estado_politicas_clientePoliticasCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_politicas_clientePoliticasCliente=false;//ConEventDepend=true

	
	

	public Border setResaltarid_clientePoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarid_clientePoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clientePoliticasCliente() {
		return this.resaltarid_clientePoliticasCliente;
	}

	public void setResaltarid_clientePoliticasCliente(Border borderResaltar) {
		this.resaltarid_clientePoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarid_clientePoliticasCliente() {
		return this.mostrarid_clientePoliticasCliente;
	}

	public void setMostrarid_clientePoliticasCliente(Boolean mostrarid_clientePoliticasCliente) {
		this.mostrarid_clientePoliticasCliente= mostrarid_clientePoliticasCliente;
	}

	public Boolean getActivarid_clientePoliticasCliente() {
		return this.activarid_clientePoliticasCliente;
	}

	public void setActivarid_clientePoliticasCliente(Boolean activarid_clientePoliticasCliente) {
		this.activarid_clientePoliticasCliente= activarid_clientePoliticasCliente;
	}

	public Boolean getCargarid_clientePoliticasCliente() {
		return this.cargarid_clientePoliticasCliente;
	}

	public void setCargarid_clientePoliticasCliente(Boolean cargarid_clientePoliticasCliente) {
		this.cargarid_clientePoliticasCliente= cargarid_clientePoliticasCliente;
	}

	public Border setResaltarid_empresaPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPoliticasCliente() {
		return this.resaltarid_empresaPoliticasCliente;
	}

	public void setResaltarid_empresaPoliticasCliente(Border borderResaltar) {
		this.resaltarid_empresaPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaPoliticasCliente() {
		return this.mostrarid_empresaPoliticasCliente;
	}

	public void setMostrarid_empresaPoliticasCliente(Boolean mostrarid_empresaPoliticasCliente) {
		this.mostrarid_empresaPoliticasCliente= mostrarid_empresaPoliticasCliente;
	}

	public Boolean getActivarid_empresaPoliticasCliente() {
		return this.activarid_empresaPoliticasCliente;
	}

	public void setActivarid_empresaPoliticasCliente(Boolean activarid_empresaPoliticasCliente) {
		this.activarid_empresaPoliticasCliente= activarid_empresaPoliticasCliente;
	}

	public Boolean getCargarid_empresaPoliticasCliente() {
		return this.cargarid_empresaPoliticasCliente;
	}

	public void setCargarid_empresaPoliticasCliente(Boolean cargarid_empresaPoliticasCliente) {
		this.cargarid_empresaPoliticasCliente= cargarid_empresaPoliticasCliente;
	}

	public Border setResaltarlimite_creditoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarlimite_creditoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlimite_creditoPoliticasCliente() {
		return this.resaltarlimite_creditoPoliticasCliente;
	}

	public void setResaltarlimite_creditoPoliticasCliente(Border borderResaltar) {
		this.resaltarlimite_creditoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarlimite_creditoPoliticasCliente() {
		return this.mostrarlimite_creditoPoliticasCliente;
	}

	public void setMostrarlimite_creditoPoliticasCliente(Boolean mostrarlimite_creditoPoliticasCliente) {
		this.mostrarlimite_creditoPoliticasCliente= mostrarlimite_creditoPoliticasCliente;
	}

	public Boolean getActivarlimite_creditoPoliticasCliente() {
		return this.activarlimite_creditoPoliticasCliente;
	}

	public void setActivarlimite_creditoPoliticasCliente(Boolean activarlimite_creditoPoliticasCliente) {
		this.activarlimite_creditoPoliticasCliente= activarlimite_creditoPoliticasCliente;
	}

	public Border setResaltarfecha_inicioPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioPoliticasCliente() {
		return this.resaltarfecha_inicioPoliticasCliente;
	}

	public void setResaltarfecha_inicioPoliticasCliente(Border borderResaltar) {
		this.resaltarfecha_inicioPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioPoliticasCliente() {
		return this.mostrarfecha_inicioPoliticasCliente;
	}

	public void setMostrarfecha_inicioPoliticasCliente(Boolean mostrarfecha_inicioPoliticasCliente) {
		this.mostrarfecha_inicioPoliticasCliente= mostrarfecha_inicioPoliticasCliente;
	}

	public Boolean getActivarfecha_inicioPoliticasCliente() {
		return this.activarfecha_inicioPoliticasCliente;
	}

	public void setActivarfecha_inicioPoliticasCliente(Boolean activarfecha_inicioPoliticasCliente) {
		this.activarfecha_inicioPoliticasCliente= activarfecha_inicioPoliticasCliente;
	}

	public Border setResaltarfecha_renovacionPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_renovacionPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_renovacionPoliticasCliente() {
		return this.resaltarfecha_renovacionPoliticasCliente;
	}

	public void setResaltarfecha_renovacionPoliticasCliente(Border borderResaltar) {
		this.resaltarfecha_renovacionPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_renovacionPoliticasCliente() {
		return this.mostrarfecha_renovacionPoliticasCliente;
	}

	public void setMostrarfecha_renovacionPoliticasCliente(Boolean mostrarfecha_renovacionPoliticasCliente) {
		this.mostrarfecha_renovacionPoliticasCliente= mostrarfecha_renovacionPoliticasCliente;
	}

	public Boolean getActivarfecha_renovacionPoliticasCliente() {
		return this.activarfecha_renovacionPoliticasCliente;
	}

	public void setActivarfecha_renovacionPoliticasCliente(Boolean activarfecha_renovacionPoliticasCliente) {
		this.activarfecha_renovacionPoliticasCliente= activarfecha_renovacionPoliticasCliente;
	}

	public Border setResaltarfecha_finPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_finPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finPoliticasCliente() {
		return this.resaltarfecha_finPoliticasCliente;
	}

	public void setResaltarfecha_finPoliticasCliente(Border borderResaltar) {
		this.resaltarfecha_finPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_finPoliticasCliente() {
		return this.mostrarfecha_finPoliticasCliente;
	}

	public void setMostrarfecha_finPoliticasCliente(Boolean mostrarfecha_finPoliticasCliente) {
		this.mostrarfecha_finPoliticasCliente= mostrarfecha_finPoliticasCliente;
	}

	public Boolean getActivarfecha_finPoliticasCliente() {
		return this.activarfecha_finPoliticasCliente;
	}

	public void setActivarfecha_finPoliticasCliente(Boolean activarfecha_finPoliticasCliente) {
		this.activarfecha_finPoliticasCliente= activarfecha_finPoliticasCliente;
	}

	public Border setResaltardias_neto_pagoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltardias_neto_pagoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_neto_pagoPoliticasCliente() {
		return this.resaltardias_neto_pagoPoliticasCliente;
	}

	public void setResaltardias_neto_pagoPoliticasCliente(Border borderResaltar) {
		this.resaltardias_neto_pagoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrardias_neto_pagoPoliticasCliente() {
		return this.mostrardias_neto_pagoPoliticasCliente;
	}

	public void setMostrardias_neto_pagoPoliticasCliente(Boolean mostrardias_neto_pagoPoliticasCliente) {
		this.mostrardias_neto_pagoPoliticasCliente= mostrardias_neto_pagoPoliticasCliente;
	}

	public Boolean getActivardias_neto_pagoPoliticasCliente() {
		return this.activardias_neto_pagoPoliticasCliente;
	}

	public void setActivardias_neto_pagoPoliticasCliente(Boolean activardias_neto_pagoPoliticasCliente) {
		this.activardias_neto_pagoPoliticasCliente= activardias_neto_pagoPoliticasCliente;
	}

	public Border setResaltardias_graciaPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltardias_graciaPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardias_graciaPoliticasCliente() {
		return this.resaltardias_graciaPoliticasCliente;
	}

	public void setResaltardias_graciaPoliticasCliente(Border borderResaltar) {
		this.resaltardias_graciaPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrardias_graciaPoliticasCliente() {
		return this.mostrardias_graciaPoliticasCliente;
	}

	public void setMostrardias_graciaPoliticasCliente(Boolean mostrardias_graciaPoliticasCliente) {
		this.mostrardias_graciaPoliticasCliente= mostrardias_graciaPoliticasCliente;
	}

	public Boolean getActivardias_graciaPoliticasCliente() {
		return this.activardias_graciaPoliticasCliente;
	}

	public void setActivardias_graciaPoliticasCliente(Boolean activardias_graciaPoliticasCliente) {
		this.activardias_graciaPoliticasCliente= activardias_graciaPoliticasCliente;
	}

	public Border setResaltarcupoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarcupoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcupoPoliticasCliente() {
		return this.resaltarcupoPoliticasCliente;
	}

	public void setResaltarcupoPoliticasCliente(Border borderResaltar) {
		this.resaltarcupoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarcupoPoliticasCliente() {
		return this.mostrarcupoPoliticasCliente;
	}

	public void setMostrarcupoPoliticasCliente(Boolean mostrarcupoPoliticasCliente) {
		this.mostrarcupoPoliticasCliente= mostrarcupoPoliticasCliente;
	}

	public Boolean getActivarcupoPoliticasCliente() {
		return this.activarcupoPoliticasCliente;
	}

	public void setActivarcupoPoliticasCliente(Boolean activarcupoPoliticasCliente) {
		this.activarcupoPoliticasCliente= activarcupoPoliticasCliente;
	}

	public Border setResaltardescuento_generalPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltardescuento_generalPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_generalPoliticasCliente() {
		return this.resaltardescuento_generalPoliticasCliente;
	}

	public void setResaltardescuento_generalPoliticasCliente(Border borderResaltar) {
		this.resaltardescuento_generalPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrardescuento_generalPoliticasCliente() {
		return this.mostrardescuento_generalPoliticasCliente;
	}

	public void setMostrardescuento_generalPoliticasCliente(Boolean mostrardescuento_generalPoliticasCliente) {
		this.mostrardescuento_generalPoliticasCliente= mostrardescuento_generalPoliticasCliente;
	}

	public Boolean getActivardescuento_generalPoliticasCliente() {
		return this.activardescuento_generalPoliticasCliente;
	}

	public void setActivardescuento_generalPoliticasCliente(Boolean activardescuento_generalPoliticasCliente) {
		this.activardescuento_generalPoliticasCliente= activardescuento_generalPoliticasCliente;
	}

	public Border setResaltardescuento_pronto_pagoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltardescuento_pronto_pagoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_pronto_pagoPoliticasCliente() {
		return this.resaltardescuento_pronto_pagoPoliticasCliente;
	}

	public void setResaltardescuento_pronto_pagoPoliticasCliente(Border borderResaltar) {
		this.resaltardescuento_pronto_pagoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrardescuento_pronto_pagoPoliticasCliente() {
		return this.mostrardescuento_pronto_pagoPoliticasCliente;
	}

	public void setMostrardescuento_pronto_pagoPoliticasCliente(Boolean mostrardescuento_pronto_pagoPoliticasCliente) {
		this.mostrardescuento_pronto_pagoPoliticasCliente= mostrardescuento_pronto_pagoPoliticasCliente;
	}

	public Boolean getActivardescuento_pronto_pagoPoliticasCliente() {
		return this.activardescuento_pronto_pagoPoliticasCliente;
	}

	public void setActivardescuento_pronto_pagoPoliticasCliente(Boolean activardescuento_pronto_pagoPoliticasCliente) {
		this.activardescuento_pronto_pagoPoliticasCliente= activardescuento_pronto_pagoPoliticasCliente;
	}

	public Border setResaltarid_tipo_precioPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioPoliticasCliente() {
		return this.resaltarid_tipo_precioPoliticasCliente;
	}

	public void setResaltarid_tipo_precioPoliticasCliente(Border borderResaltar) {
		this.resaltarid_tipo_precioPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioPoliticasCliente() {
		return this.mostrarid_tipo_precioPoliticasCliente;
	}

	public void setMostrarid_tipo_precioPoliticasCliente(Boolean mostrarid_tipo_precioPoliticasCliente) {
		this.mostrarid_tipo_precioPoliticasCliente= mostrarid_tipo_precioPoliticasCliente;
	}

	public Boolean getActivarid_tipo_precioPoliticasCliente() {
		return this.activarid_tipo_precioPoliticasCliente;
	}

	public void setActivarid_tipo_precioPoliticasCliente(Boolean activarid_tipo_precioPoliticasCliente) {
		this.activarid_tipo_precioPoliticasCliente= activarid_tipo_precioPoliticasCliente;
	}

	public Boolean getCargarid_tipo_precioPoliticasCliente() {
		return this.cargarid_tipo_precioPoliticasCliente;
	}

	public void setCargarid_tipo_precioPoliticasCliente(Boolean cargarid_tipo_precioPoliticasCliente) {
		this.cargarid_tipo_precioPoliticasCliente= cargarid_tipo_precioPoliticasCliente;
	}

	public Border setResaltarcon_lista_precioPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarcon_lista_precioPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_lista_precioPoliticasCliente() {
		return this.resaltarcon_lista_precioPoliticasCliente;
	}

	public void setResaltarcon_lista_precioPoliticasCliente(Border borderResaltar) {
		this.resaltarcon_lista_precioPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarcon_lista_precioPoliticasCliente() {
		return this.mostrarcon_lista_precioPoliticasCliente;
	}

	public void setMostrarcon_lista_precioPoliticasCliente(Boolean mostrarcon_lista_precioPoliticasCliente) {
		this.mostrarcon_lista_precioPoliticasCliente= mostrarcon_lista_precioPoliticasCliente;
	}

	public Boolean getActivarcon_lista_precioPoliticasCliente() {
		return this.activarcon_lista_precioPoliticasCliente;
	}

	public void setActivarcon_lista_precioPoliticasCliente(Boolean activarcon_lista_precioPoliticasCliente) {
		this.activarcon_lista_precioPoliticasCliente= activarcon_lista_precioPoliticasCliente;
	}

	public Border setResaltarcon_impuestosPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarcon_impuestosPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_impuestosPoliticasCliente() {
		return this.resaltarcon_impuestosPoliticasCliente;
	}

	public void setResaltarcon_impuestosPoliticasCliente(Border borderResaltar) {
		this.resaltarcon_impuestosPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarcon_impuestosPoliticasCliente() {
		return this.mostrarcon_impuestosPoliticasCliente;
	}

	public void setMostrarcon_impuestosPoliticasCliente(Boolean mostrarcon_impuestosPoliticasCliente) {
		this.mostrarcon_impuestosPoliticasCliente= mostrarcon_impuestosPoliticasCliente;
	}

	public Boolean getActivarcon_impuestosPoliticasCliente() {
		return this.activarcon_impuestosPoliticasCliente;
	}

	public void setActivarcon_impuestosPoliticasCliente(Boolean activarcon_impuestosPoliticasCliente) {
		this.activarcon_impuestosPoliticasCliente= activarcon_impuestosPoliticasCliente;
	}

	public Border setResaltaractivar_monto_facturacionPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltaractivar_monto_facturacionPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaractivar_monto_facturacionPoliticasCliente() {
		return this.resaltaractivar_monto_facturacionPoliticasCliente;
	}

	public void setResaltaractivar_monto_facturacionPoliticasCliente(Border borderResaltar) {
		this.resaltaractivar_monto_facturacionPoliticasCliente= borderResaltar;
	}

	public Boolean getMostraractivar_monto_facturacionPoliticasCliente() {
		return this.mostraractivar_monto_facturacionPoliticasCliente;
	}

	public void setMostraractivar_monto_facturacionPoliticasCliente(Boolean mostraractivar_monto_facturacionPoliticasCliente) {
		this.mostraractivar_monto_facturacionPoliticasCliente= mostraractivar_monto_facturacionPoliticasCliente;
	}

	public Boolean getActivaractivar_monto_facturacionPoliticasCliente() {
		return this.activaractivar_monto_facturacionPoliticasCliente;
	}

	public void setActivaractivar_monto_facturacionPoliticasCliente(Boolean activaractivar_monto_facturacionPoliticasCliente) {
		this.activaractivar_monto_facturacionPoliticasCliente= activaractivar_monto_facturacionPoliticasCliente;
	}

	public Border setResaltarvalor_sobregiroPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarvalor_sobregiroPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_sobregiroPoliticasCliente() {
		return this.resaltarvalor_sobregiroPoliticasCliente;
	}

	public void setResaltarvalor_sobregiroPoliticasCliente(Border borderResaltar) {
		this.resaltarvalor_sobregiroPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarvalor_sobregiroPoliticasCliente() {
		return this.mostrarvalor_sobregiroPoliticasCliente;
	}

	public void setMostrarvalor_sobregiroPoliticasCliente(Boolean mostrarvalor_sobregiroPoliticasCliente) {
		this.mostrarvalor_sobregiroPoliticasCliente= mostrarvalor_sobregiroPoliticasCliente;
	}

	public Boolean getActivarvalor_sobregiroPoliticasCliente() {
		return this.activarvalor_sobregiroPoliticasCliente;
	}

	public void setActivarvalor_sobregiroPoliticasCliente(Boolean activarvalor_sobregiroPoliticasCliente) {
		this.activarvalor_sobregiroPoliticasCliente= activarvalor_sobregiroPoliticasCliente;
	}

	public Border setResaltarfecha_venci_sobregiroPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_venci_sobregiroPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venci_sobregiroPoliticasCliente() {
		return this.resaltarfecha_venci_sobregiroPoliticasCliente;
	}

	public void setResaltarfecha_venci_sobregiroPoliticasCliente(Border borderResaltar) {
		this.resaltarfecha_venci_sobregiroPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_venci_sobregiroPoliticasCliente() {
		return this.mostrarfecha_venci_sobregiroPoliticasCliente;
	}

	public void setMostrarfecha_venci_sobregiroPoliticasCliente(Boolean mostrarfecha_venci_sobregiroPoliticasCliente) {
		this.mostrarfecha_venci_sobregiroPoliticasCliente= mostrarfecha_venci_sobregiroPoliticasCliente;
	}

	public Boolean getActivarfecha_venci_sobregiroPoliticasCliente() {
		return this.activarfecha_venci_sobregiroPoliticasCliente;
	}

	public void setActivarfecha_venci_sobregiroPoliticasCliente(Boolean activarfecha_venci_sobregiroPoliticasCliente) {
		this.activarfecha_venci_sobregiroPoliticasCliente= activarfecha_venci_sobregiroPoliticasCliente;
	}

	public Border setResaltarid_transportePoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarid_transportePoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportePoliticasCliente() {
		return this.resaltarid_transportePoliticasCliente;
	}

	public void setResaltarid_transportePoliticasCliente(Border borderResaltar) {
		this.resaltarid_transportePoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarid_transportePoliticasCliente() {
		return this.mostrarid_transportePoliticasCliente;
	}

	public void setMostrarid_transportePoliticasCliente(Boolean mostrarid_transportePoliticasCliente) {
		this.mostrarid_transportePoliticasCliente= mostrarid_transportePoliticasCliente;
	}

	public Boolean getActivarid_transportePoliticasCliente() {
		return this.activarid_transportePoliticasCliente;
	}

	public void setActivarid_transportePoliticasCliente(Boolean activarid_transportePoliticasCliente) {
		this.activarid_transportePoliticasCliente= activarid_transportePoliticasCliente;
	}

	public Boolean getCargarid_transportePoliticasCliente() {
		return this.cargarid_transportePoliticasCliente;
	}

	public void setCargarid_transportePoliticasCliente(Boolean cargarid_transportePoliticasCliente) {
		this.cargarid_transportePoliticasCliente= cargarid_transportePoliticasCliente;
	}

	public Border setResaltarvalor_solicitadoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarvalor_solicitadoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_solicitadoPoliticasCliente() {
		return this.resaltarvalor_solicitadoPoliticasCliente;
	}

	public void setResaltarvalor_solicitadoPoliticasCliente(Border borderResaltar) {
		this.resaltarvalor_solicitadoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarvalor_solicitadoPoliticasCliente() {
		return this.mostrarvalor_solicitadoPoliticasCliente;
	}

	public void setMostrarvalor_solicitadoPoliticasCliente(Boolean mostrarvalor_solicitadoPoliticasCliente) {
		this.mostrarvalor_solicitadoPoliticasCliente= mostrarvalor_solicitadoPoliticasCliente;
	}

	public Boolean getActivarvalor_solicitadoPoliticasCliente() {
		return this.activarvalor_solicitadoPoliticasCliente;
	}

	public void setActivarvalor_solicitadoPoliticasCliente(Boolean activarvalor_solicitadoPoliticasCliente) {
		this.activarvalor_solicitadoPoliticasCliente= activarvalor_solicitadoPoliticasCliente;
	}

	public Border setResaltarvalor_aprobadoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarvalor_aprobadoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_aprobadoPoliticasCliente() {
		return this.resaltarvalor_aprobadoPoliticasCliente;
	}

	public void setResaltarvalor_aprobadoPoliticasCliente(Border borderResaltar) {
		this.resaltarvalor_aprobadoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarvalor_aprobadoPoliticasCliente() {
		return this.mostrarvalor_aprobadoPoliticasCliente;
	}

	public void setMostrarvalor_aprobadoPoliticasCliente(Boolean mostrarvalor_aprobadoPoliticasCliente) {
		this.mostrarvalor_aprobadoPoliticasCliente= mostrarvalor_aprobadoPoliticasCliente;
	}

	public Boolean getActivarvalor_aprobadoPoliticasCliente() {
		return this.activarvalor_aprobadoPoliticasCliente;
	}

	public void setActivarvalor_aprobadoPoliticasCliente(Boolean activarvalor_aprobadoPoliticasCliente) {
		this.activarvalor_aprobadoPoliticasCliente= activarvalor_aprobadoPoliticasCliente;
	}

	public Border setResaltarid_linea_negocioPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarid_linea_negocioPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_negocioPoliticasCliente() {
		return this.resaltarid_linea_negocioPoliticasCliente;
	}

	public void setResaltarid_linea_negocioPoliticasCliente(Border borderResaltar) {
		this.resaltarid_linea_negocioPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarid_linea_negocioPoliticasCliente() {
		return this.mostrarid_linea_negocioPoliticasCliente;
	}

	public void setMostrarid_linea_negocioPoliticasCliente(Boolean mostrarid_linea_negocioPoliticasCliente) {
		this.mostrarid_linea_negocioPoliticasCliente= mostrarid_linea_negocioPoliticasCliente;
	}

	public Boolean getActivarid_linea_negocioPoliticasCliente() {
		return this.activarid_linea_negocioPoliticasCliente;
	}

	public void setActivarid_linea_negocioPoliticasCliente(Boolean activarid_linea_negocioPoliticasCliente) {
		this.activarid_linea_negocioPoliticasCliente= activarid_linea_negocioPoliticasCliente;
	}

	public Boolean getCargarid_linea_negocioPoliticasCliente() {
		return this.cargarid_linea_negocioPoliticasCliente;
	}

	public void setCargarid_linea_negocioPoliticasCliente(Boolean cargarid_linea_negocioPoliticasCliente) {
		this.cargarid_linea_negocioPoliticasCliente= cargarid_linea_negocioPoliticasCliente;
	}

	public Border setResaltarfecha_solicitudPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarfecha_solicitudPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_solicitudPoliticasCliente() {
		return this.resaltarfecha_solicitudPoliticasCliente;
	}

	public void setResaltarfecha_solicitudPoliticasCliente(Border borderResaltar) {
		this.resaltarfecha_solicitudPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarfecha_solicitudPoliticasCliente() {
		return this.mostrarfecha_solicitudPoliticasCliente;
	}

	public void setMostrarfecha_solicitudPoliticasCliente(Boolean mostrarfecha_solicitudPoliticasCliente) {
		this.mostrarfecha_solicitudPoliticasCliente= mostrarfecha_solicitudPoliticasCliente;
	}

	public Boolean getActivarfecha_solicitudPoliticasCliente() {
		return this.activarfecha_solicitudPoliticasCliente;
	}

	public void setActivarfecha_solicitudPoliticasCliente(Boolean activarfecha_solicitudPoliticasCliente) {
		this.activarfecha_solicitudPoliticasCliente= activarfecha_solicitudPoliticasCliente;
	}

	public Border setResaltarobsevacionPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarobsevacionPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobsevacionPoliticasCliente() {
		return this.resaltarobsevacionPoliticasCliente;
	}

	public void setResaltarobsevacionPoliticasCliente(Border borderResaltar) {
		this.resaltarobsevacionPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarobsevacionPoliticasCliente() {
		return this.mostrarobsevacionPoliticasCliente;
	}

	public void setMostrarobsevacionPoliticasCliente(Boolean mostrarobsevacionPoliticasCliente) {
		this.mostrarobsevacionPoliticasCliente= mostrarobsevacionPoliticasCliente;
	}

	public Boolean getActivarobsevacionPoliticasCliente() {
		return this.activarobsevacionPoliticasCliente;
	}

	public void setActivarobsevacionPoliticasCliente(Boolean activarobsevacionPoliticasCliente) {
		this.activarobsevacionPoliticasCliente= activarobsevacionPoliticasCliente;
	}

	public Border setResaltarwebPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarwebPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarwebPoliticasCliente() {
		return this.resaltarwebPoliticasCliente;
	}

	public void setResaltarwebPoliticasCliente(Border borderResaltar) {
		this.resaltarwebPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarwebPoliticasCliente() {
		return this.mostrarwebPoliticasCliente;
	}

	public void setMostrarwebPoliticasCliente(Boolean mostrarwebPoliticasCliente) {
		this.mostrarwebPoliticasCliente= mostrarwebPoliticasCliente;
	}

	public Boolean getActivarwebPoliticasCliente() {
		return this.activarwebPoliticasCliente;
	}

	public void setActivarwebPoliticasCliente(Boolean activarwebPoliticasCliente) {
		this.activarwebPoliticasCliente= activarwebPoliticasCliente;
	}

	public Border setResaltarcasilla_postalPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarcasilla_postalPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcasilla_postalPoliticasCliente() {
		return this.resaltarcasilla_postalPoliticasCliente;
	}

	public void setResaltarcasilla_postalPoliticasCliente(Border borderResaltar) {
		this.resaltarcasilla_postalPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarcasilla_postalPoliticasCliente() {
		return this.mostrarcasilla_postalPoliticasCliente;
	}

	public void setMostrarcasilla_postalPoliticasCliente(Boolean mostrarcasilla_postalPoliticasCliente) {
		this.mostrarcasilla_postalPoliticasCliente= mostrarcasilla_postalPoliticasCliente;
	}

	public Boolean getActivarcasilla_postalPoliticasCliente() {
		return this.activarcasilla_postalPoliticasCliente;
	}

	public void setActivarcasilla_postalPoliticasCliente(Boolean activarcasilla_postalPoliticasCliente) {
		this.activarcasilla_postalPoliticasCliente= activarcasilla_postalPoliticasCliente;
	}

	public Border setResaltarforma_envioPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarforma_envioPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarforma_envioPoliticasCliente() {
		return this.resaltarforma_envioPoliticasCliente;
	}

	public void setResaltarforma_envioPoliticasCliente(Border borderResaltar) {
		this.resaltarforma_envioPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarforma_envioPoliticasCliente() {
		return this.mostrarforma_envioPoliticasCliente;
	}

	public void setMostrarforma_envioPoliticasCliente(Boolean mostrarforma_envioPoliticasCliente) {
		this.mostrarforma_envioPoliticasCliente= mostrarforma_envioPoliticasCliente;
	}

	public Boolean getActivarforma_envioPoliticasCliente() {
		return this.activarforma_envioPoliticasCliente;
	}

	public void setActivarforma_envioPoliticasCliente(Boolean activarforma_envioPoliticasCliente) {
		this.activarforma_envioPoliticasCliente= activarforma_envioPoliticasCliente;
	}

	public Border setResaltarid_bancoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarid_bancoPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoPoliticasCliente() {
		return this.resaltarid_bancoPoliticasCliente;
	}

	public void setResaltarid_bancoPoliticasCliente(Border borderResaltar) {
		this.resaltarid_bancoPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarid_bancoPoliticasCliente() {
		return this.mostrarid_bancoPoliticasCliente;
	}

	public void setMostrarid_bancoPoliticasCliente(Boolean mostrarid_bancoPoliticasCliente) {
		this.mostrarid_bancoPoliticasCliente= mostrarid_bancoPoliticasCliente;
	}

	public Boolean getActivarid_bancoPoliticasCliente() {
		return this.activarid_bancoPoliticasCliente;
	}

	public void setActivarid_bancoPoliticasCliente(Boolean activarid_bancoPoliticasCliente) {
		this.activarid_bancoPoliticasCliente= activarid_bancoPoliticasCliente;
	}

	public Boolean getCargarid_bancoPoliticasCliente() {
		return this.cargarid_bancoPoliticasCliente;
	}

	public void setCargarid_bancoPoliticasCliente(Boolean cargarid_bancoPoliticasCliente) {
		this.cargarid_bancoPoliticasCliente= cargarid_bancoPoliticasCliente;
	}

	public Border setResaltarid_tipo_cuenta_banco_globalPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuenta_banco_globalPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuenta_banco_globalPoliticasCliente() {
		return this.resaltarid_tipo_cuenta_banco_globalPoliticasCliente;
	}

	public void setResaltarid_tipo_cuenta_banco_globalPoliticasCliente(Border borderResaltar) {
		this.resaltarid_tipo_cuenta_banco_globalPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuenta_banco_globalPoliticasCliente() {
		return this.mostrarid_tipo_cuenta_banco_globalPoliticasCliente;
	}

	public void setMostrarid_tipo_cuenta_banco_globalPoliticasCliente(Boolean mostrarid_tipo_cuenta_banco_globalPoliticasCliente) {
		this.mostrarid_tipo_cuenta_banco_globalPoliticasCliente= mostrarid_tipo_cuenta_banco_globalPoliticasCliente;
	}

	public Boolean getActivarid_tipo_cuenta_banco_globalPoliticasCliente() {
		return this.activarid_tipo_cuenta_banco_globalPoliticasCliente;
	}

	public void setActivarid_tipo_cuenta_banco_globalPoliticasCliente(Boolean activarid_tipo_cuenta_banco_globalPoliticasCliente) {
		this.activarid_tipo_cuenta_banco_globalPoliticasCliente= activarid_tipo_cuenta_banco_globalPoliticasCliente;
	}

	public Boolean getCargarid_tipo_cuenta_banco_globalPoliticasCliente() {
		return this.cargarid_tipo_cuenta_banco_globalPoliticasCliente;
	}

	public void setCargarid_tipo_cuenta_banco_globalPoliticasCliente(Boolean cargarid_tipo_cuenta_banco_globalPoliticasCliente) {
		this.cargarid_tipo_cuenta_banco_globalPoliticasCliente= cargarid_tipo_cuenta_banco_globalPoliticasCliente;
	}

	public Border setResaltarnumero_cuentaPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaPoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaPoliticasCliente() {
		return this.resaltarnumero_cuentaPoliticasCliente;
	}

	public void setResaltarnumero_cuentaPoliticasCliente(Border borderResaltar) {
		this.resaltarnumero_cuentaPoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaPoliticasCliente() {
		return this.mostrarnumero_cuentaPoliticasCliente;
	}

	public void setMostrarnumero_cuentaPoliticasCliente(Boolean mostrarnumero_cuentaPoliticasCliente) {
		this.mostrarnumero_cuentaPoliticasCliente= mostrarnumero_cuentaPoliticasCliente;
	}

	public Boolean getActivarnumero_cuentaPoliticasCliente() {
		return this.activarnumero_cuentaPoliticasCliente;
	}

	public void setActivarnumero_cuentaPoliticasCliente(Boolean activarnumero_cuentaPoliticasCliente) {
		this.activarnumero_cuentaPoliticasCliente= activarnumero_cuentaPoliticasCliente;
	}

	public Border setResaltarid_estado_politicas_clientePoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//politicasclienteBeanSwingJInternalFrame.jTtoolBarPoliticasCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_politicas_clientePoliticasCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_politicas_clientePoliticasCliente() {
		return this.resaltarid_estado_politicas_clientePoliticasCliente;
	}

	public void setResaltarid_estado_politicas_clientePoliticasCliente(Border borderResaltar) {
		this.resaltarid_estado_politicas_clientePoliticasCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_politicas_clientePoliticasCliente() {
		return this.mostrarid_estado_politicas_clientePoliticasCliente;
	}

	public void setMostrarid_estado_politicas_clientePoliticasCliente(Boolean mostrarid_estado_politicas_clientePoliticasCliente) {
		this.mostrarid_estado_politicas_clientePoliticasCliente= mostrarid_estado_politicas_clientePoliticasCliente;
	}

	public Boolean getActivarid_estado_politicas_clientePoliticasCliente() {
		return this.activarid_estado_politicas_clientePoliticasCliente;
	}

	public void setActivarid_estado_politicas_clientePoliticasCliente(Boolean activarid_estado_politicas_clientePoliticasCliente) {
		this.activarid_estado_politicas_clientePoliticasCliente= activarid_estado_politicas_clientePoliticasCliente;
	}

	public Boolean getCargarid_estado_politicas_clientePoliticasCliente() {
		return this.cargarid_estado_politicas_clientePoliticasCliente;
	}

	public void setCargarid_estado_politicas_clientePoliticasCliente(Boolean cargarid_estado_politicas_clientePoliticasCliente) {
		this.cargarid_estado_politicas_clientePoliticasCliente= cargarid_estado_politicas_clientePoliticasCliente;
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
		
		
		this.setMostrarid_clientePoliticasCliente(esInicial);
		this.setMostrarid_empresaPoliticasCliente(esInicial);
		this.setMostrarlimite_creditoPoliticasCliente(esInicial);
		this.setMostrarfecha_inicioPoliticasCliente(esInicial);
		this.setMostrarfecha_renovacionPoliticasCliente(esInicial);
		this.setMostrarfecha_finPoliticasCliente(esInicial);
		this.setMostrardias_neto_pagoPoliticasCliente(esInicial);
		this.setMostrardias_graciaPoliticasCliente(esInicial);
		this.setMostrarcupoPoliticasCliente(esInicial);
		this.setMostrardescuento_generalPoliticasCliente(esInicial);
		this.setMostrardescuento_pronto_pagoPoliticasCliente(esInicial);
		this.setMostrarid_tipo_precioPoliticasCliente(esInicial);
		this.setMostrarcon_lista_precioPoliticasCliente(esInicial);
		this.setMostrarcon_impuestosPoliticasCliente(esInicial);
		this.setMostraractivar_monto_facturacionPoliticasCliente(esInicial);
		this.setMostrarvalor_sobregiroPoliticasCliente(esInicial);
		this.setMostrarfecha_venci_sobregiroPoliticasCliente(esInicial);
		this.setMostrarid_transportePoliticasCliente(esInicial);
		this.setMostrarvalor_solicitadoPoliticasCliente(esInicial);
		this.setMostrarvalor_aprobadoPoliticasCliente(esInicial);
		this.setMostrarid_linea_negocioPoliticasCliente(esInicial);
		this.setMostrarfecha_solicitudPoliticasCliente(esInicial);
		this.setMostrarobsevacionPoliticasCliente(esInicial);
		this.setMostrarwebPoliticasCliente(esInicial);
		this.setMostrarcasilla_postalPoliticasCliente(esInicial);
		this.setMostrarforma_envioPoliticasCliente(esInicial);
		this.setMostrarid_bancoPoliticasCliente(esInicial);
		this.setMostrarid_tipo_cuenta_banco_globalPoliticasCliente(esInicial);
		this.setMostrarnumero_cuentaPoliticasCliente(esInicial);
		this.setMostrarid_estado_politicas_clientePoliticasCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.ID)) {
				this.setMostrarid_clientePoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.LIMITECREDITO)) {
				this.setMostrarlimite_creditoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHARENOVACION)) {
				this.setMostrarfecha_renovacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DIASNETOPAGO)) {
				this.setMostrardias_neto_pagoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DIASGRACIA)) {
				this.setMostrardias_graciaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CUPO)) {
				this.setMostrarcupoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DESCUENTOGENERAL)) {
				this.setMostrardescuento_generalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO)) {
				this.setMostrardescuento_pronto_pagoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CONLISTAPRECIO)) {
				this.setMostrarcon_lista_precioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CONIMPUESTOS)) {
				this.setMostrarcon_impuestosPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION)) {
				this.setMostraractivar_monto_facturacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORSOBREGIRO)) {
				this.setMostrarvalor_sobregiroPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO)) {
				this.setMostrarfecha_venci_sobregiroPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTRANSPORTE)) {
				this.setMostrarid_transportePoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORSOLICITADO)) {
				this.setMostrarvalor_solicitadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORAPROBADO)) {
				this.setMostrarvalor_aprobadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDLINEANEGOCIO)) {
				this.setMostrarid_linea_negocioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHASOLICITUD)) {
				this.setMostrarfecha_solicitudPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.OBSEVACION)) {
				this.setMostrarobsevacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.WEB)) {
				this.setMostrarwebPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CASILLAPOSTAL)) {
				this.setMostrarcasilla_postalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FORMAENVIO)) {
				this.setMostrarforma_envioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setMostrarid_tipo_cuenta_banco_globalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE)) {
				this.setMostrarid_estado_politicas_clientePoliticasCliente(esAsigna);
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
		
		
		this.setActivarid_clientePoliticasCliente(esInicial);
		this.setActivarid_empresaPoliticasCliente(esInicial);
		this.setActivarlimite_creditoPoliticasCliente(esInicial);
		this.setActivarfecha_inicioPoliticasCliente(esInicial);
		this.setActivarfecha_renovacionPoliticasCliente(esInicial);
		this.setActivarfecha_finPoliticasCliente(esInicial);
		this.setActivardias_neto_pagoPoliticasCliente(esInicial);
		this.setActivardias_graciaPoliticasCliente(esInicial);
		this.setActivarcupoPoliticasCliente(esInicial);
		this.setActivardescuento_generalPoliticasCliente(esInicial);
		this.setActivardescuento_pronto_pagoPoliticasCliente(esInicial);
		this.setActivarid_tipo_precioPoliticasCliente(esInicial);
		this.setActivarcon_lista_precioPoliticasCliente(esInicial);
		this.setActivarcon_impuestosPoliticasCliente(esInicial);
		this.setActivaractivar_monto_facturacionPoliticasCliente(esInicial);
		this.setActivarvalor_sobregiroPoliticasCliente(esInicial);
		this.setActivarfecha_venci_sobregiroPoliticasCliente(esInicial);
		this.setActivarid_transportePoliticasCliente(esInicial);
		this.setActivarvalor_solicitadoPoliticasCliente(esInicial);
		this.setActivarvalor_aprobadoPoliticasCliente(esInicial);
		this.setActivarid_linea_negocioPoliticasCliente(esInicial);
		this.setActivarfecha_solicitudPoliticasCliente(esInicial);
		this.setActivarobsevacionPoliticasCliente(esInicial);
		this.setActivarwebPoliticasCliente(esInicial);
		this.setActivarcasilla_postalPoliticasCliente(esInicial);
		this.setActivarforma_envioPoliticasCliente(esInicial);
		this.setActivarid_bancoPoliticasCliente(esInicial);
		this.setActivarid_tipo_cuenta_banco_globalPoliticasCliente(esInicial);
		this.setActivarnumero_cuentaPoliticasCliente(esInicial);
		this.setActivarid_estado_politicas_clientePoliticasCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.ID)) {
				this.setActivarid_clientePoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.LIMITECREDITO)) {
				this.setActivarlimite_creditoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHARENOVACION)) {
				this.setActivarfecha_renovacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DIASNETOPAGO)) {
				this.setActivardias_neto_pagoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DIASGRACIA)) {
				this.setActivardias_graciaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CUPO)) {
				this.setActivarcupoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DESCUENTOGENERAL)) {
				this.setActivardescuento_generalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO)) {
				this.setActivardescuento_pronto_pagoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CONLISTAPRECIO)) {
				this.setActivarcon_lista_precioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CONIMPUESTOS)) {
				this.setActivarcon_impuestosPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION)) {
				this.setActivaractivar_monto_facturacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORSOBREGIRO)) {
				this.setActivarvalor_sobregiroPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO)) {
				this.setActivarfecha_venci_sobregiroPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTRANSPORTE)) {
				this.setActivarid_transportePoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORSOLICITADO)) {
				this.setActivarvalor_solicitadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORAPROBADO)) {
				this.setActivarvalor_aprobadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDLINEANEGOCIO)) {
				this.setActivarid_linea_negocioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHASOLICITUD)) {
				this.setActivarfecha_solicitudPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.OBSEVACION)) {
				this.setActivarobsevacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.WEB)) {
				this.setActivarwebPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CASILLAPOSTAL)) {
				this.setActivarcasilla_postalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FORMAENVIO)) {
				this.setActivarforma_envioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setActivarid_tipo_cuenta_banco_globalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE)) {
				this.setActivarid_estado_politicas_clientePoliticasCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltarid_clientePoliticasCliente(esInicial);
		this.setResaltarid_empresaPoliticasCliente(esInicial);
		this.setResaltarlimite_creditoPoliticasCliente(esInicial);
		this.setResaltarfecha_inicioPoliticasCliente(esInicial);
		this.setResaltarfecha_renovacionPoliticasCliente(esInicial);
		this.setResaltarfecha_finPoliticasCliente(esInicial);
		this.setResaltardias_neto_pagoPoliticasCliente(esInicial);
		this.setResaltardias_graciaPoliticasCliente(esInicial);
		this.setResaltarcupoPoliticasCliente(esInicial);
		this.setResaltardescuento_generalPoliticasCliente(esInicial);
		this.setResaltardescuento_pronto_pagoPoliticasCliente(esInicial);
		this.setResaltarid_tipo_precioPoliticasCliente(esInicial);
		this.setResaltarcon_lista_precioPoliticasCliente(esInicial);
		this.setResaltarcon_impuestosPoliticasCliente(esInicial);
		this.setResaltaractivar_monto_facturacionPoliticasCliente(esInicial);
		this.setResaltarvalor_sobregiroPoliticasCliente(esInicial);
		this.setResaltarfecha_venci_sobregiroPoliticasCliente(esInicial);
		this.setResaltarid_transportePoliticasCliente(esInicial);
		this.setResaltarvalor_solicitadoPoliticasCliente(esInicial);
		this.setResaltarvalor_aprobadoPoliticasCliente(esInicial);
		this.setResaltarid_linea_negocioPoliticasCliente(esInicial);
		this.setResaltarfecha_solicitudPoliticasCliente(esInicial);
		this.setResaltarobsevacionPoliticasCliente(esInicial);
		this.setResaltarwebPoliticasCliente(esInicial);
		this.setResaltarcasilla_postalPoliticasCliente(esInicial);
		this.setResaltarforma_envioPoliticasCliente(esInicial);
		this.setResaltarid_bancoPoliticasCliente(esInicial);
		this.setResaltarid_tipo_cuenta_banco_globalPoliticasCliente(esInicial);
		this.setResaltarnumero_cuentaPoliticasCliente(esInicial);
		this.setResaltarid_estado_politicas_clientePoliticasCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.ID)) {
				this.setResaltarid_clientePoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.LIMITECREDITO)) {
				this.setResaltarlimite_creditoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHARENOVACION)) {
				this.setResaltarfecha_renovacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DIASNETOPAGO)) {
				this.setResaltardias_neto_pagoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DIASGRACIA)) {
				this.setResaltardias_graciaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CUPO)) {
				this.setResaltarcupoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DESCUENTOGENERAL)) {
				this.setResaltardescuento_generalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO)) {
				this.setResaltardescuento_pronto_pagoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CONLISTAPRECIO)) {
				this.setResaltarcon_lista_precioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CONIMPUESTOS)) {
				this.setResaltarcon_impuestosPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION)) {
				this.setResaltaractivar_monto_facturacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORSOBREGIRO)) {
				this.setResaltarvalor_sobregiroPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO)) {
				this.setResaltarfecha_venci_sobregiroPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTRANSPORTE)) {
				this.setResaltarid_transportePoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORSOLICITADO)) {
				this.setResaltarvalor_solicitadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.VALORAPROBADO)) {
				this.setResaltarvalor_aprobadoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDLINEANEGOCIO)) {
				this.setResaltarid_linea_negocioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FECHASOLICITUD)) {
				this.setResaltarfecha_solicitudPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.OBSEVACION)) {
				this.setResaltarobsevacionPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.WEB)) {
				this.setResaltarwebPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.CASILLAPOSTAL)) {
				this.setResaltarcasilla_postalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.FORMAENVIO)) {
				this.setResaltarforma_envioPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setResaltarid_tipo_cuenta_banco_globalPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaPoliticasCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE)) {
				this.setResaltarid_estado_politicas_clientePoliticasCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBancoPoliticasCliente=true;

	public Boolean getMostrarFK_IdBancoPoliticasCliente() {
		return this.mostrarFK_IdBancoPoliticasCliente;
	}

	public void setMostrarFK_IdBancoPoliticasCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoPoliticasCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClientePoliticasCliente=true;

	public Boolean getMostrarFK_IdClientePoliticasCliente() {
		return this.mostrarFK_IdClientePoliticasCliente;
	}

	public void setMostrarFK_IdClientePoliticasCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClientePoliticasCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPoliticasCliente=true;

	public Boolean getMostrarFK_IdEmpresaPoliticasCliente() {
		return this.mostrarFK_IdEmpresaPoliticasCliente;
	}

	public void setMostrarFK_IdEmpresaPoliticasCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPoliticasCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoPoliticasClientePoliticasCliente=true;

	public Boolean getMostrarFK_IdEstadoPoliticasClientePoliticasCliente() {
		return this.mostrarFK_IdEstadoPoliticasClientePoliticasCliente;
	}

	public void setMostrarFK_IdEstadoPoliticasClientePoliticasCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoPoliticasClientePoliticasCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdLineaNegocioPoliticasCliente=true;

	public Boolean getMostrarFK_IdLineaNegocioPoliticasCliente() {
		return this.mostrarFK_IdLineaNegocioPoliticasCliente;
	}

	public void setMostrarFK_IdLineaNegocioPoliticasCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdLineaNegocioPoliticasCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaBancoGlobalPoliticasCliente=true;

	public Boolean getMostrarFK_IdTipoCuentaBancoGlobalPoliticasCliente() {
		return this.mostrarFK_IdTipoCuentaBancoGlobalPoliticasCliente;
	}

	public void setMostrarFK_IdTipoCuentaBancoGlobalPoliticasCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaBancoGlobalPoliticasCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioPoliticasCliente=true;

	public Boolean getMostrarFK_IdTipoPrecioPoliticasCliente() {
		return this.mostrarFK_IdTipoPrecioPoliticasCliente;
	}

	public void setMostrarFK_IdTipoPrecioPoliticasCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioPoliticasCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransportePoliticasCliente=true;

	public Boolean getMostrarFK_IdTransportePoliticasCliente() {
		return this.mostrarFK_IdTransportePoliticasCliente;
	}

	public void setMostrarFK_IdTransportePoliticasCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransportePoliticasCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoPoliticasCliente=true;

	public Boolean getActivarFK_IdBancoPoliticasCliente() {
		return this.activarFK_IdBancoPoliticasCliente;
	}

	public void setActivarFK_IdBancoPoliticasCliente(Boolean habilitarResaltar) {
		this.activarFK_IdBancoPoliticasCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdClientePoliticasCliente=true;

	public Boolean getActivarFK_IdClientePoliticasCliente() {
		return this.activarFK_IdClientePoliticasCliente;
	}

	public void setActivarFK_IdClientePoliticasCliente(Boolean habilitarResaltar) {
		this.activarFK_IdClientePoliticasCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPoliticasCliente=true;

	public Boolean getActivarFK_IdEmpresaPoliticasCliente() {
		return this.activarFK_IdEmpresaPoliticasCliente;
	}

	public void setActivarFK_IdEmpresaPoliticasCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPoliticasCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoPoliticasClientePoliticasCliente=true;

	public Boolean getActivarFK_IdEstadoPoliticasClientePoliticasCliente() {
		return this.activarFK_IdEstadoPoliticasClientePoliticasCliente;
	}

	public void setActivarFK_IdEstadoPoliticasClientePoliticasCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoPoliticasClientePoliticasCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdLineaNegocioPoliticasCliente=true;

	public Boolean getActivarFK_IdLineaNegocioPoliticasCliente() {
		return this.activarFK_IdLineaNegocioPoliticasCliente;
	}

	public void setActivarFK_IdLineaNegocioPoliticasCliente(Boolean habilitarResaltar) {
		this.activarFK_IdLineaNegocioPoliticasCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaBancoGlobalPoliticasCliente=true;

	public Boolean getActivarFK_IdTipoCuentaBancoGlobalPoliticasCliente() {
		return this.activarFK_IdTipoCuentaBancoGlobalPoliticasCliente;
	}

	public void setActivarFK_IdTipoCuentaBancoGlobalPoliticasCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaBancoGlobalPoliticasCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioPoliticasCliente=true;

	public Boolean getActivarFK_IdTipoPrecioPoliticasCliente() {
		return this.activarFK_IdTipoPrecioPoliticasCliente;
	}

	public void setActivarFK_IdTipoPrecioPoliticasCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioPoliticasCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTransportePoliticasCliente=true;

	public Boolean getActivarFK_IdTransportePoliticasCliente() {
		return this.activarFK_IdTransportePoliticasCliente;
	}

	public void setActivarFK_IdTransportePoliticasCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTransportePoliticasCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoPoliticasCliente=null;

	public Border getResaltarFK_IdBancoPoliticasCliente() {
		return this.resaltarFK_IdBancoPoliticasCliente;
	}

	public void setResaltarFK_IdBancoPoliticasCliente(Border borderResaltar) {
		this.resaltarFK_IdBancoPoliticasCliente= borderResaltar;
	}

	public void setResaltarFK_IdBancoPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoPoliticasCliente= borderResaltar;
	}

	public Border resaltarFK_IdClientePoliticasCliente=null;

	public Border getResaltarFK_IdClientePoliticasCliente() {
		return this.resaltarFK_IdClientePoliticasCliente;
	}

	public void setResaltarFK_IdClientePoliticasCliente(Border borderResaltar) {
		this.resaltarFK_IdClientePoliticasCliente= borderResaltar;
	}

	public void setResaltarFK_IdClientePoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClientePoliticasCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPoliticasCliente=null;

	public Border getResaltarFK_IdEmpresaPoliticasCliente() {
		return this.resaltarFK_IdEmpresaPoliticasCliente;
	}

	public void setResaltarFK_IdEmpresaPoliticasCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPoliticasCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPoliticasCliente= borderResaltar;
	}

	public Border resaltarFK_IdEstadoPoliticasClientePoliticasCliente=null;

	public Border getResaltarFK_IdEstadoPoliticasClientePoliticasCliente() {
		return this.resaltarFK_IdEstadoPoliticasClientePoliticasCliente;
	}

	public void setResaltarFK_IdEstadoPoliticasClientePoliticasCliente(Border borderResaltar) {
		this.resaltarFK_IdEstadoPoliticasClientePoliticasCliente= borderResaltar;
	}

	public void setResaltarFK_IdEstadoPoliticasClientePoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoPoliticasClientePoliticasCliente= borderResaltar;
	}

	public Border resaltarFK_IdLineaNegocioPoliticasCliente=null;

	public Border getResaltarFK_IdLineaNegocioPoliticasCliente() {
		return this.resaltarFK_IdLineaNegocioPoliticasCliente;
	}

	public void setResaltarFK_IdLineaNegocioPoliticasCliente(Border borderResaltar) {
		this.resaltarFK_IdLineaNegocioPoliticasCliente= borderResaltar;
	}

	public void setResaltarFK_IdLineaNegocioPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdLineaNegocioPoliticasCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaBancoGlobalPoliticasCliente=null;

	public Border getResaltarFK_IdTipoCuentaBancoGlobalPoliticasCliente() {
		return this.resaltarFK_IdTipoCuentaBancoGlobalPoliticasCliente;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalPoliticasCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaBancoGlobalPoliticasCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaBancoGlobalPoliticasCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioPoliticasCliente=null;

	public Border getResaltarFK_IdTipoPrecioPoliticasCliente() {
		return this.resaltarFK_IdTipoPrecioPoliticasCliente;
	}

	public void setResaltarFK_IdTipoPrecioPoliticasCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioPoliticasCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioPoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioPoliticasCliente= borderResaltar;
	}

	public Border resaltarFK_IdTransportePoliticasCliente=null;

	public Border getResaltarFK_IdTransportePoliticasCliente() {
		return this.resaltarFK_IdTransportePoliticasCliente;
	}

	public void setResaltarFK_IdTransportePoliticasCliente(Border borderResaltar) {
		this.resaltarFK_IdTransportePoliticasCliente= borderResaltar;
	}

	public void setResaltarFK_IdTransportePoliticasCliente(ParametroGeneralUsuario parametroGeneralUsuario/*PoliticasClienteBeanSwingJInternalFrame politicasclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransportePoliticasCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}