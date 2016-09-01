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


import com.bydan.erp.tesoreria.util.BancoFormaPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.BancoFormaPagoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.BancoFormaPagoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BancoFormaPagoConstantesFunciones extends BancoFormaPagoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="BancoFormaPago";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BancoFormaPago"+BancoFormaPagoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BancoFormaPagoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BancoFormaPagoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BancoFormaPagoConstantesFunciones.SCHEMA+"_"+BancoFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BancoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BancoFormaPagoConstantesFunciones.SCHEMA+"_"+BancoFormaPagoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BancoFormaPagoConstantesFunciones.SCHEMA+"_"+BancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BancoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BancoFormaPagoConstantesFunciones.SCHEMA+"_"+BancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BancoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BancoFormaPagoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BancoFormaPagoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BancoFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BancoFormaPagoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BancoFormaPagoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BancoFormaPagoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Banco Forma Pagos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Banco Forma Pago";
	public static final String SCLASSWEBTITULO_LOWER="Banco Forma Pago";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BancoFormaPago";
	public static final String OBJECTNAME="bancoformapago";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="banco_forma_pago";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select bancoformapago from "+BancoFormaPagoConstantesFunciones.SPERSISTENCENAME+" bancoformapago";
	public static String QUERYSELECTNATIVE="select "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_ejercicio,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_periodo,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_factura,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_deta_forma_pago,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_tipo_banco_forma_pago,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".nombre_banco,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".nombre_girador,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".fecha_vence,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".numero_cuenta_banco,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".numero_cheque,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".valor_monto,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_anio,"+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME+".id_mes from "+BancoFormaPagoConstantesFunciones.SCHEMA+"."+BancoFormaPagoConstantesFunciones.TABLENAME;//+" as "+BancoFormaPagoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected BancoFormaPagoConstantesFuncionesAdditional bancoformapagoConstantesFuncionesAdditional=null;
	
	public BancoFormaPagoConstantesFuncionesAdditional getBancoFormaPagoConstantesFuncionesAdditional() {
		return this.bancoformapagoConstantesFuncionesAdditional;
	}
	
	public void setBancoFormaPagoConstantesFuncionesAdditional(BancoFormaPagoConstantesFuncionesAdditional bancoformapagoConstantesFuncionesAdditional) {
		try {
			this.bancoformapagoConstantesFuncionesAdditional=bancoformapagoConstantesFuncionesAdditional;
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
    public static final String IDDETAFORMAPAGO= "id_deta_forma_pago";
    public static final String IDTIPOBANCOFORMAPAGO= "id_tipo_banco_forma_pago";
    public static final String NOMBREBANCO= "nombre_banco";
    public static final String NOMBREGIRADOR= "nombre_girador";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String NUMEROCUENTABANCO= "numero_cuenta_banco";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String VALORMONTO= "valor_monto";
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
    	public static final String LABEL_IDDETAFORMAPAGO= "Deta Forma Pago";
		public static final String LABEL_IDDETAFORMAPAGO_LOWER= "Deta Forma Pago";
    	public static final String LABEL_IDTIPOBANCOFORMAPAGO= "Tipo Banco Forma Pago";
		public static final String LABEL_IDTIPOBANCOFORMAPAGO_LOWER= "Tipo Banco Forma Pago";
    	public static final String LABEL_NOMBREBANCO= "Nombre Banco";
		public static final String LABEL_NOMBREBANCO_LOWER= "Nombre Banco";
    	public static final String LABEL_NOMBREGIRADOR= "Nombre Girador";
		public static final String LABEL_NOMBREGIRADOR_LOWER= "Nombre Girador";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_NUMEROCUENTABANCO= "Numero Cuenta Banco";
		public static final String LABEL_NUMEROCUENTABANCO_LOWER= "Numero Cuenta Banco";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_VALORMONTO= "Valor Monto";
		public static final String LABEL_VALORMONTO_LOWER= "Valor Monto";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GIRADOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GIRADOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_CUENTA_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getBancoFormaPagoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDEMPRESA)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDPERIODO)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDFACTURA)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGO;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDTIPOBANCOFORMAPAGO;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.NOMBREBANCO)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_NOMBREBANCO;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.NOMBREGIRADOR)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_NOMBREGIRADOR;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.FECHAVENCE)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_NUMEROCUENTABANCO;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.VALORMONTO)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_VALORMONTO;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDANIO)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(BancoFormaPagoConstantesFunciones.IDMES)) {sLabelColumna=BancoFormaPagoConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getBancoFormaPagoDescripcion(BancoFormaPago bancoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(bancoformapago !=null/* && bancoformapago.getId()!=0*/) {
			if(bancoformapago.getId()!=null) {
				sDescripcion=bancoformapago.getId().toString();
			}//bancoformapagobancoformapago.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBancoFormaPagoDescripcionDetallado(BancoFormaPago bancoformapago) {
		String sDescripcion="";
			
		sDescripcion+=BancoFormaPagoConstantesFunciones.ID+"=";
		sDescripcion+=bancoformapago.getId().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=bancoformapago.getVersionRow().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=bancoformapago.getid_empresa().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=bancoformapago.getid_sucursal().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=bancoformapago.getid_ejercicio().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=bancoformapago.getid_periodo().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=bancoformapago.getid_factura().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO+"=";
		sDescripcion+=bancoformapago.getid_deta_forma_pago().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO+"=";
		sDescripcion+=bancoformapago.getid_tipo_banco_forma_pago().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.NOMBREBANCO+"=";
		sDescripcion+=bancoformapago.getnombre_banco()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.NOMBREGIRADOR+"=";
		sDescripcion+=bancoformapago.getnombre_girador()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=bancoformapago.getfecha_vence().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO+"=";
		sDescripcion+=bancoformapago.getnumero_cuenta_banco()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=bancoformapago.getnumero_cheque()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.VALORMONTO+"=";
		sDescripcion+=bancoformapago.getvalor_monto().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDANIO+"=";
		sDescripcion+=bancoformapago.getid_anio().toString()+",";
		sDescripcion+=BancoFormaPagoConstantesFunciones.IDMES+"=";
		sDescripcion+=bancoformapago.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setBancoFormaPagoDescripcion(BancoFormaPago bancoformapago,String sValor) throws Exception {			
		if(bancoformapago !=null) {
			//bancoformapagobancoformapago.getId().toString();
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

	public static String getDetaFormaPagoDescripcion(DetaFormaPago detaformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detaformapago!=null/*&&detaformapago.getId()>0*/) {
			sDescripcion=DetaFormaPagoConstantesFunciones.getDetaFormaPagoDescripcion(detaformapago);
		}

		return sDescripcion;
	}

	public static String getTipoBancoFormaPagoDescripcion(TipoBancoFormaPago tipobancoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipobancoformapago!=null/*&&tipobancoformapago.getId()>0*/) {
			sDescripcion=TipoBancoFormaPagoConstantesFunciones.getTipoBancoFormaPagoDescripcion(tipobancoformapago);
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
		} else if(sNombreIndice.equals("FK_IdBancoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Banco Forma Pago";
		} else if(sNombreIndice.equals("FK_IdDetaFormaPago")) {
			sNombreIndice="Tipo=  Por Deta Forma Pago";
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

	public static String getDetalleIndiceFK_IdBancoFormaPago(Long id_tipo_banco_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_banco_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Banco Forma Pago="+id_tipo_banco_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetaFormaPago(Long id_deta_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_deta_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Deta Forma Pago="+id_deta_forma_pago.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosBancoFormaPago(BancoFormaPago bancoformapago,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		bancoformapago.setnombre_banco(bancoformapago.getnombre_banco().trim());
		bancoformapago.setnombre_girador(bancoformapago.getnombre_girador().trim());
		bancoformapago.setnumero_cuenta_banco(bancoformapago.getnumero_cuenta_banco().trim());
		bancoformapago.setnumero_cheque(bancoformapago.getnumero_cheque().trim());
	}
	
	public static void quitarEspaciosBancoFormaPagos(List<BancoFormaPago> bancoformapagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BancoFormaPago bancoformapago: bancoformapagos) {
			bancoformapago.setnombre_banco(bancoformapago.getnombre_banco().trim());
			bancoformapago.setnombre_girador(bancoformapago.getnombre_girador().trim());
			bancoformapago.setnumero_cuenta_banco(bancoformapago.getnumero_cuenta_banco().trim());
			bancoformapago.setnumero_cheque(bancoformapago.getnumero_cheque().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBancoFormaPago(BancoFormaPago bancoformapago,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && bancoformapago.getConCambioAuxiliar()) {
			bancoformapago.setIsDeleted(bancoformapago.getIsDeletedAuxiliar());	
			bancoformapago.setIsNew(bancoformapago.getIsNewAuxiliar());	
			bancoformapago.setIsChanged(bancoformapago.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			bancoformapago.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			bancoformapago.setIsDeletedAuxiliar(false);	
			bancoformapago.setIsNewAuxiliar(false);	
			bancoformapago.setIsChangedAuxiliar(false);
			
			bancoformapago.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBancoFormaPagos(List<BancoFormaPago> bancoformapagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BancoFormaPago bancoformapago : bancoformapagos) {
			if(conAsignarBase && bancoformapago.getConCambioAuxiliar()) {
				bancoformapago.setIsDeleted(bancoformapago.getIsDeletedAuxiliar());	
				bancoformapago.setIsNew(bancoformapago.getIsNewAuxiliar());	
				bancoformapago.setIsChanged(bancoformapago.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				bancoformapago.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				bancoformapago.setIsDeletedAuxiliar(false);	
				bancoformapago.setIsNewAuxiliar(false);	
				bancoformapago.setIsChangedAuxiliar(false);
				
				bancoformapago.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBancoFormaPago(BancoFormaPago bancoformapago,Boolean conEnteros) throws Exception  {
		bancoformapago.setvalor_monto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBancoFormaPagos(List<BancoFormaPago> bancoformapagos,Boolean conEnteros) throws Exception  {
		
		for(BancoFormaPago bancoformapago: bancoformapagos) {
			bancoformapago.setvalor_monto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBancoFormaPago(List<BancoFormaPago> bancoformapagos,BancoFormaPago bancoformapagoAux) throws Exception  {
		BancoFormaPagoConstantesFunciones.InicializarValoresBancoFormaPago(bancoformapagoAux,true);
		
		for(BancoFormaPago bancoformapago: bancoformapagos) {
			if(bancoformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			bancoformapagoAux.setvalor_monto(bancoformapagoAux.getvalor_monto()+bancoformapago.getvalor_monto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBancoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BancoFormaPagoConstantesFunciones.getArrayColumnasGlobalesBancoFormaPago(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBancoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BancoFormaPagoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BancoFormaPagoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BancoFormaPagoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BancoFormaPagoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BancoFormaPagoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BancoFormaPagoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BancoFormaPagoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BancoFormaPagoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBancoFormaPago(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BancoFormaPago> bancoformapagos,BancoFormaPago bancoformapago,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BancoFormaPago bancoformapagoAux: bancoformapagos) {
			if(bancoformapagoAux!=null && bancoformapago!=null) {
				if((bancoformapagoAux.getId()==null && bancoformapago.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(bancoformapagoAux.getId()!=null && bancoformapago.getId()!=null){
					if(bancoformapagoAux.getId().equals(bancoformapago.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBancoFormaPago(List<BancoFormaPago> bancoformapagos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_montoTotal=0.0;
	
		for(BancoFormaPago bancoformapago: bancoformapagos) {			
			if(bancoformapago.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_montoTotal+=bancoformapago.getvalor_monto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BancoFormaPagoConstantesFunciones.VALORMONTO);
		datoGeneral.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_VALORMONTO);
		datoGeneral.setdValorDouble(valor_montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBancoFormaPago() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_ID, BancoFormaPagoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_VERSIONROW, BancoFormaPagoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA, BancoFormaPagoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL, BancoFormaPagoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDEJERCICIO, BancoFormaPagoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDPERIODO, BancoFormaPagoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDFACTURA, BancoFormaPagoConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGO, BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDTIPOBANCOFORMAPAGO, BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_NOMBREBANCO, BancoFormaPagoConstantesFunciones.NOMBREBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_NOMBREGIRADOR, BancoFormaPagoConstantesFunciones.NOMBREGIRADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_FECHAVENCE, BancoFormaPagoConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_NUMEROCUENTABANCO, BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE, BancoFormaPagoConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_VALORMONTO, BancoFormaPagoConstantesFunciones.VALORMONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDANIO, BancoFormaPagoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BancoFormaPagoConstantesFunciones.LABEL_IDMES, BancoFormaPagoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBancoFormaPago() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.NOMBREBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.NOMBREGIRADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.VALORMONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BancoFormaPagoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBancoFormaPago() throws Exception  {
		return BancoFormaPagoConstantesFunciones.getTiposSeleccionarBancoFormaPago(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBancoFormaPago(Boolean conFk) throws Exception  {
		return BancoFormaPagoConstantesFunciones.getTiposSeleccionarBancoFormaPago(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBancoFormaPago(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGO);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDTIPOBANCOFORMAPAGO);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDTIPOBANCOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_NOMBREBANCO);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_NOMBREBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_NOMBREGIRADOR);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_NOMBREGIRADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_NUMEROCUENTABANCO);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_NUMEROCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_VALORMONTO);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_VALORMONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BancoFormaPagoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(BancoFormaPagoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBancoFormaPago(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBancoFormaPago(BancoFormaPago bancoformapagoAux) throws Exception {
		
			bancoformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bancoformapagoAux.getEmpresa()));
			bancoformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(bancoformapagoAux.getSucursal()));
			bancoformapagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(bancoformapagoAux.getEjercicio()));
			bancoformapagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(bancoformapagoAux.getPeriodo()));
			bancoformapagoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(bancoformapagoAux.getFactura()));
			bancoformapagoAux.setdetaformapago_descripcion(DetaFormaPagoConstantesFunciones.getDetaFormaPagoDescripcion(bancoformapagoAux.getDetaFormaPago()));
			bancoformapagoAux.settipobancoformapago_descripcion(TipoBancoFormaPagoConstantesFunciones.getTipoBancoFormaPagoDescripcion(bancoformapagoAux.getTipoBancoFormaPago()));
			bancoformapagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(bancoformapagoAux.getAnio()));
			bancoformapagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(bancoformapagoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBancoFormaPago(List<BancoFormaPago> bancoformapagosTemp) throws Exception {
		for(BancoFormaPago bancoformapagoAux:bancoformapagosTemp) {
			
			bancoformapagoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(bancoformapagoAux.getEmpresa()));
			bancoformapagoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(bancoformapagoAux.getSucursal()));
			bancoformapagoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(bancoformapagoAux.getEjercicio()));
			bancoformapagoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(bancoformapagoAux.getPeriodo()));
			bancoformapagoAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(bancoformapagoAux.getFactura()));
			bancoformapagoAux.setdetaformapago_descripcion(DetaFormaPagoConstantesFunciones.getDetaFormaPagoDescripcion(bancoformapagoAux.getDetaFormaPago()));
			bancoformapagoAux.settipobancoformapago_descripcion(TipoBancoFormaPagoConstantesFunciones.getTipoBancoFormaPagoDescripcion(bancoformapagoAux.getTipoBancoFormaPago()));
			bancoformapagoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(bancoformapagoAux.getAnio()));
			bancoformapagoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(bancoformapagoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(DetaFormaPago.class));
				classes.add(new Classe(TipoBancoFormaPago.class));
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
					if(clas.clas.equals(DetaFormaPago.class)) {
						classes.add(new Classe(DetaFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoBancoFormaPago.class)) {
						classes.add(new Classe(TipoBancoFormaPago.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBancoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
					}

					if(TipoBancoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBancoFormaPago.class)); continue;
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

					if(DetaFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaFormaPago.class)); continue;
					}

					if(TipoBancoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoBancoFormaPago.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BancoFormaPagoConstantesFunciones.getClassesRelationshipsOfBancoFormaPago(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBancoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BancoFormaPagoConstantesFunciones.getClassesRelationshipsFromStringsOfBancoFormaPago(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBancoFormaPago(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(BancoFormaPago bancoformapago,List<BancoFormaPago> bancoformapagos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			BancoFormaPago bancoformapagoEncontrado=null;
			
			for(BancoFormaPago bancoformapagoLocal:bancoformapagos) {
				if(bancoformapagoLocal.getId().equals(bancoformapago.getId())) {
					bancoformapagoEncontrado=bancoformapagoLocal;
					
					bancoformapagoLocal.setIsChanged(bancoformapago.getIsChanged());
					bancoformapagoLocal.setIsNew(bancoformapago.getIsNew());
					bancoformapagoLocal.setIsDeleted(bancoformapago.getIsDeleted());
					
					bancoformapagoLocal.setGeneralEntityOriginal(bancoformapago.getGeneralEntityOriginal());
					
					bancoformapagoLocal.setId(bancoformapago.getId());	
					bancoformapagoLocal.setVersionRow(bancoformapago.getVersionRow());	
					bancoformapagoLocal.setid_empresa(bancoformapago.getid_empresa());	
					bancoformapagoLocal.setid_sucursal(bancoformapago.getid_sucursal());	
					bancoformapagoLocal.setid_ejercicio(bancoformapago.getid_ejercicio());	
					bancoformapagoLocal.setid_periodo(bancoformapago.getid_periodo());	
					bancoformapagoLocal.setid_factura(bancoformapago.getid_factura());	
					bancoformapagoLocal.setid_deta_forma_pago(bancoformapago.getid_deta_forma_pago());	
					bancoformapagoLocal.setid_tipo_banco_forma_pago(bancoformapago.getid_tipo_banco_forma_pago());	
					bancoformapagoLocal.setnombre_banco(bancoformapago.getnombre_banco());	
					bancoformapagoLocal.setnombre_girador(bancoformapago.getnombre_girador());	
					bancoformapagoLocal.setfecha_vence(bancoformapago.getfecha_vence());	
					bancoformapagoLocal.setnumero_cuenta_banco(bancoformapago.getnumero_cuenta_banco());	
					bancoformapagoLocal.setnumero_cheque(bancoformapago.getnumero_cheque());	
					bancoformapagoLocal.setvalor_monto(bancoformapago.getvalor_monto());	
					bancoformapagoLocal.setid_anio(bancoformapago.getid_anio());	
					bancoformapagoLocal.setid_mes(bancoformapago.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!bancoformapago.getIsDeleted()) {
				if(!existe) {
					bancoformapagos.add(bancoformapago);
				}
			} else {
				if(bancoformapagoEncontrado!=null && permiteQuitar)  {
					bancoformapagos.remove(bancoformapagoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(BancoFormaPago bancoformapago,List<BancoFormaPago> bancoformapagos) throws Exception {
		try	{			
			for(BancoFormaPago bancoformapagoLocal:bancoformapagos) {
				if(bancoformapagoLocal.getId().equals(bancoformapago.getId())) {
					bancoformapagoLocal.setIsSelected(bancoformapago.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBancoFormaPago(List<BancoFormaPago> bancoformapagosAux) throws Exception {
		//this.bancoformapagosAux=bancoformapagosAux;
		
		for(BancoFormaPago bancoformapagoAux:bancoformapagosAux) {
			if(bancoformapagoAux.getIsChanged()) {
				bancoformapagoAux.setIsChanged(false);
			}		
			
			if(bancoformapagoAux.getIsNew()) {
				bancoformapagoAux.setIsNew(false);
			}	
			
			if(bancoformapagoAux.getIsDeleted()) {
				bancoformapagoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBancoFormaPago(BancoFormaPago bancoformapagoAux) throws Exception {
		//this.bancoformapagoAux=bancoformapagoAux;
		
			if(bancoformapagoAux.getIsChanged()) {
				bancoformapagoAux.setIsChanged(false);
			}		
			
			if(bancoformapagoAux.getIsNew()) {
				bancoformapagoAux.setIsNew(false);
			}	
			
			if(bancoformapagoAux.getIsDeleted()) {
				bancoformapagoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BancoFormaPago bancoformapagoAsignar,BancoFormaPago bancoformapago) throws Exception {
		bancoformapagoAsignar.setId(bancoformapago.getId());	
		bancoformapagoAsignar.setVersionRow(bancoformapago.getVersionRow());	
		bancoformapagoAsignar.setid_empresa(bancoformapago.getid_empresa());
		bancoformapagoAsignar.setempresa_descripcion(bancoformapago.getempresa_descripcion());	
		bancoformapagoAsignar.setid_sucursal(bancoformapago.getid_sucursal());
		bancoformapagoAsignar.setsucursal_descripcion(bancoformapago.getsucursal_descripcion());	
		bancoformapagoAsignar.setid_ejercicio(bancoformapago.getid_ejercicio());
		bancoformapagoAsignar.setejercicio_descripcion(bancoformapago.getejercicio_descripcion());	
		bancoformapagoAsignar.setid_periodo(bancoformapago.getid_periodo());
		bancoformapagoAsignar.setperiodo_descripcion(bancoformapago.getperiodo_descripcion());	
		bancoformapagoAsignar.setid_factura(bancoformapago.getid_factura());
		bancoformapagoAsignar.setfactura_descripcion(bancoformapago.getfactura_descripcion());	
		bancoformapagoAsignar.setid_deta_forma_pago(bancoformapago.getid_deta_forma_pago());
		bancoformapagoAsignar.setdetaformapago_descripcion(bancoformapago.getdetaformapago_descripcion());	
		bancoformapagoAsignar.setid_tipo_banco_forma_pago(bancoformapago.getid_tipo_banco_forma_pago());
		bancoformapagoAsignar.settipobancoformapago_descripcion(bancoformapago.gettipobancoformapago_descripcion());	
		bancoformapagoAsignar.setnombre_banco(bancoformapago.getnombre_banco());	
		bancoformapagoAsignar.setnombre_girador(bancoformapago.getnombre_girador());	
		bancoformapagoAsignar.setfecha_vence(bancoformapago.getfecha_vence());	
		bancoformapagoAsignar.setnumero_cuenta_banco(bancoformapago.getnumero_cuenta_banco());	
		bancoformapagoAsignar.setnumero_cheque(bancoformapago.getnumero_cheque());	
		bancoformapagoAsignar.setvalor_monto(bancoformapago.getvalor_monto());	
		bancoformapagoAsignar.setid_anio(bancoformapago.getid_anio());
		bancoformapagoAsignar.setanio_descripcion(bancoformapago.getanio_descripcion());	
		bancoformapagoAsignar.setid_mes(bancoformapago.getid_mes());
		bancoformapagoAsignar.setmes_descripcion(bancoformapago.getmes_descripcion());	
	}
	
	public static void inicializarBancoFormaPago(BancoFormaPago bancoformapago) throws Exception {
		try {
				bancoformapago.setId(0L);	
					
				bancoformapago.setid_empresa(-1L);	
				bancoformapago.setid_sucursal(-1L);	
				bancoformapago.setid_ejercicio(-1L);	
				bancoformapago.setid_periodo(-1L);	
				bancoformapago.setid_factura(-1L);	
				bancoformapago.setid_deta_forma_pago(-1L);	
				bancoformapago.setid_tipo_banco_forma_pago(-1L);	
				bancoformapago.setnombre_banco("");	
				bancoformapago.setnombre_girador("");	
				bancoformapago.setfecha_vence(new Date());	
				bancoformapago.setnumero_cuenta_banco("");	
				bancoformapago.setnumero_cheque("");	
				bancoformapago.setvalor_monto(0.0);	
				bancoformapago.setid_anio(null);	
				bancoformapago.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBancoFormaPago(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDDETAFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDTIPOBANCOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_NOMBREBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_NOMBREGIRADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_NUMEROCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_VALORMONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BancoFormaPagoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBancoFormaPago(String sTipo,Row row,Workbook workbook,BancoFormaPago bancoformapago,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getdetaformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.gettipobancoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getnombre_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getnombre_girador());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getnumero_cuenta_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getvalor_monto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(bancoformapago.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBancoFormaPago=Constantes.SFINALQUERY;
	
	public String getsFinalQueryBancoFormaPago() {
		return this.sFinalQueryBancoFormaPago;
	}
	
	public void setsFinalQueryBancoFormaPago(String sFinalQueryBancoFormaPago) {
		this.sFinalQueryBancoFormaPago= sFinalQueryBancoFormaPago;
	}
	
	public Border resaltarSeleccionarBancoFormaPago=null;
	
	public Border setResaltarSeleccionarBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBancoFormaPago= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBancoFormaPago() {
		return this.resaltarSeleccionarBancoFormaPago;
	}
	
	public void setResaltarSeleccionarBancoFormaPago(Border borderResaltarSeleccionarBancoFormaPago) {
		this.resaltarSeleccionarBancoFormaPago= borderResaltarSeleccionarBancoFormaPago;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBancoFormaPago=null;
	public Boolean mostraridBancoFormaPago=true;
	public Boolean activaridBancoFormaPago=true;

	public Border resaltarid_empresaBancoFormaPago=null;
	public Boolean mostrarid_empresaBancoFormaPago=true;
	public Boolean activarid_empresaBancoFormaPago=true;
	public Boolean cargarid_empresaBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_sucursalBancoFormaPago=null;
	public Boolean mostrarid_sucursalBancoFormaPago=true;
	public Boolean activarid_sucursalBancoFormaPago=true;
	public Boolean cargarid_sucursalBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_ejercicioBancoFormaPago=null;
	public Boolean mostrarid_ejercicioBancoFormaPago=true;
	public Boolean activarid_ejercicioBancoFormaPago=true;
	public Boolean cargarid_ejercicioBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_periodoBancoFormaPago=null;
	public Boolean mostrarid_periodoBancoFormaPago=true;
	public Boolean activarid_periodoBancoFormaPago=true;
	public Boolean cargarid_periodoBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_facturaBancoFormaPago=null;
	public Boolean mostrarid_facturaBancoFormaPago=true;
	public Boolean activarid_facturaBancoFormaPago=true;
	public Boolean cargarid_facturaBancoFormaPago=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_deta_forma_pagoBancoFormaPago=null;
	public Boolean mostrarid_deta_forma_pagoBancoFormaPago=true;
	public Boolean activarid_deta_forma_pagoBancoFormaPago=true;
	public Boolean cargarid_deta_forma_pagoBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_deta_forma_pagoBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_tipo_banco_forma_pagoBancoFormaPago=null;
	public Boolean mostrarid_tipo_banco_forma_pagoBancoFormaPago=true;
	public Boolean activarid_tipo_banco_forma_pagoBancoFormaPago=true;
	public Boolean cargarid_tipo_banco_forma_pagoBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_banco_forma_pagoBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarnombre_bancoBancoFormaPago=null;
	public Boolean mostrarnombre_bancoBancoFormaPago=true;
	public Boolean activarnombre_bancoBancoFormaPago=true;

	public Border resaltarnombre_giradorBancoFormaPago=null;
	public Boolean mostrarnombre_giradorBancoFormaPago=true;
	public Boolean activarnombre_giradorBancoFormaPago=true;

	public Border resaltarfecha_venceBancoFormaPago=null;
	public Boolean mostrarfecha_venceBancoFormaPago=true;
	public Boolean activarfecha_venceBancoFormaPago=false;

	public Border resaltarnumero_cuenta_bancoBancoFormaPago=null;
	public Boolean mostrarnumero_cuenta_bancoBancoFormaPago=true;
	public Boolean activarnumero_cuenta_bancoBancoFormaPago=true;

	public Border resaltarnumero_chequeBancoFormaPago=null;
	public Boolean mostrarnumero_chequeBancoFormaPago=true;
	public Boolean activarnumero_chequeBancoFormaPago=true;

	public Border resaltarvalor_montoBancoFormaPago=null;
	public Boolean mostrarvalor_montoBancoFormaPago=true;
	public Boolean activarvalor_montoBancoFormaPago=true;

	public Border resaltarid_anioBancoFormaPago=null;
	public Boolean mostrarid_anioBancoFormaPago=true;
	public Boolean activarid_anioBancoFormaPago=false;
	public Boolean cargarid_anioBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioBancoFormaPago=false;//ConEventDepend=true

	public Border resaltarid_mesBancoFormaPago=null;
	public Boolean mostrarid_mesBancoFormaPago=true;
	public Boolean activarid_mesBancoFormaPago=false;
	public Boolean cargarid_mesBancoFormaPago=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesBancoFormaPago=false;//ConEventDepend=true

	
	

	public Border setResaltaridBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltaridBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBancoFormaPago() {
		return this.resaltaridBancoFormaPago;
	}

	public void setResaltaridBancoFormaPago(Border borderResaltar) {
		this.resaltaridBancoFormaPago= borderResaltar;
	}

	public Boolean getMostraridBancoFormaPago() {
		return this.mostraridBancoFormaPago;
	}

	public void setMostraridBancoFormaPago(Boolean mostraridBancoFormaPago) {
		this.mostraridBancoFormaPago= mostraridBancoFormaPago;
	}

	public Boolean getActivaridBancoFormaPago() {
		return this.activaridBancoFormaPago;
	}

	public void setActivaridBancoFormaPago(Boolean activaridBancoFormaPago) {
		this.activaridBancoFormaPago= activaridBancoFormaPago;
	}

	public Border setResaltarid_empresaBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_empresaBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBancoFormaPago() {
		return this.resaltarid_empresaBancoFormaPago;
	}

	public void setResaltarid_empresaBancoFormaPago(Border borderResaltar) {
		this.resaltarid_empresaBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_empresaBancoFormaPago() {
		return this.mostrarid_empresaBancoFormaPago;
	}

	public void setMostrarid_empresaBancoFormaPago(Boolean mostrarid_empresaBancoFormaPago) {
		this.mostrarid_empresaBancoFormaPago= mostrarid_empresaBancoFormaPago;
	}

	public Boolean getActivarid_empresaBancoFormaPago() {
		return this.activarid_empresaBancoFormaPago;
	}

	public void setActivarid_empresaBancoFormaPago(Boolean activarid_empresaBancoFormaPago) {
		this.activarid_empresaBancoFormaPago= activarid_empresaBancoFormaPago;
	}

	public Boolean getCargarid_empresaBancoFormaPago() {
		return this.cargarid_empresaBancoFormaPago;
	}

	public void setCargarid_empresaBancoFormaPago(Boolean cargarid_empresaBancoFormaPago) {
		this.cargarid_empresaBancoFormaPago= cargarid_empresaBancoFormaPago;
	}

	public Border setResaltarid_sucursalBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_sucursalBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalBancoFormaPago() {
		return this.resaltarid_sucursalBancoFormaPago;
	}

	public void setResaltarid_sucursalBancoFormaPago(Border borderResaltar) {
		this.resaltarid_sucursalBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_sucursalBancoFormaPago() {
		return this.mostrarid_sucursalBancoFormaPago;
	}

	public void setMostrarid_sucursalBancoFormaPago(Boolean mostrarid_sucursalBancoFormaPago) {
		this.mostrarid_sucursalBancoFormaPago= mostrarid_sucursalBancoFormaPago;
	}

	public Boolean getActivarid_sucursalBancoFormaPago() {
		return this.activarid_sucursalBancoFormaPago;
	}

	public void setActivarid_sucursalBancoFormaPago(Boolean activarid_sucursalBancoFormaPago) {
		this.activarid_sucursalBancoFormaPago= activarid_sucursalBancoFormaPago;
	}

	public Boolean getCargarid_sucursalBancoFormaPago() {
		return this.cargarid_sucursalBancoFormaPago;
	}

	public void setCargarid_sucursalBancoFormaPago(Boolean cargarid_sucursalBancoFormaPago) {
		this.cargarid_sucursalBancoFormaPago= cargarid_sucursalBancoFormaPago;
	}

	public Border setResaltarid_ejercicioBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioBancoFormaPago() {
		return this.resaltarid_ejercicioBancoFormaPago;
	}

	public void setResaltarid_ejercicioBancoFormaPago(Border borderResaltar) {
		this.resaltarid_ejercicioBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioBancoFormaPago() {
		return this.mostrarid_ejercicioBancoFormaPago;
	}

	public void setMostrarid_ejercicioBancoFormaPago(Boolean mostrarid_ejercicioBancoFormaPago) {
		this.mostrarid_ejercicioBancoFormaPago= mostrarid_ejercicioBancoFormaPago;
	}

	public Boolean getActivarid_ejercicioBancoFormaPago() {
		return this.activarid_ejercicioBancoFormaPago;
	}

	public void setActivarid_ejercicioBancoFormaPago(Boolean activarid_ejercicioBancoFormaPago) {
		this.activarid_ejercicioBancoFormaPago= activarid_ejercicioBancoFormaPago;
	}

	public Boolean getCargarid_ejercicioBancoFormaPago() {
		return this.cargarid_ejercicioBancoFormaPago;
	}

	public void setCargarid_ejercicioBancoFormaPago(Boolean cargarid_ejercicioBancoFormaPago) {
		this.cargarid_ejercicioBancoFormaPago= cargarid_ejercicioBancoFormaPago;
	}

	public Border setResaltarid_periodoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_periodoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoBancoFormaPago() {
		return this.resaltarid_periodoBancoFormaPago;
	}

	public void setResaltarid_periodoBancoFormaPago(Border borderResaltar) {
		this.resaltarid_periodoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_periodoBancoFormaPago() {
		return this.mostrarid_periodoBancoFormaPago;
	}

	public void setMostrarid_periodoBancoFormaPago(Boolean mostrarid_periodoBancoFormaPago) {
		this.mostrarid_periodoBancoFormaPago= mostrarid_periodoBancoFormaPago;
	}

	public Boolean getActivarid_periodoBancoFormaPago() {
		return this.activarid_periodoBancoFormaPago;
	}

	public void setActivarid_periodoBancoFormaPago(Boolean activarid_periodoBancoFormaPago) {
		this.activarid_periodoBancoFormaPago= activarid_periodoBancoFormaPago;
	}

	public Boolean getCargarid_periodoBancoFormaPago() {
		return this.cargarid_periodoBancoFormaPago;
	}

	public void setCargarid_periodoBancoFormaPago(Boolean cargarid_periodoBancoFormaPago) {
		this.cargarid_periodoBancoFormaPago= cargarid_periodoBancoFormaPago;
	}

	public Border setResaltarid_facturaBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_facturaBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaBancoFormaPago() {
		return this.resaltarid_facturaBancoFormaPago;
	}

	public void setResaltarid_facturaBancoFormaPago(Border borderResaltar) {
		this.resaltarid_facturaBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_facturaBancoFormaPago() {
		return this.mostrarid_facturaBancoFormaPago;
	}

	public void setMostrarid_facturaBancoFormaPago(Boolean mostrarid_facturaBancoFormaPago) {
		this.mostrarid_facturaBancoFormaPago= mostrarid_facturaBancoFormaPago;
	}

	public Boolean getActivarid_facturaBancoFormaPago() {
		return this.activarid_facturaBancoFormaPago;
	}

	public void setActivarid_facturaBancoFormaPago(Boolean activarid_facturaBancoFormaPago) {
		this.activarid_facturaBancoFormaPago= activarid_facturaBancoFormaPago;
	}

	public Boolean getCargarid_facturaBancoFormaPago() {
		return this.cargarid_facturaBancoFormaPago;
	}

	public void setCargarid_facturaBancoFormaPago(Boolean cargarid_facturaBancoFormaPago) {
		this.cargarid_facturaBancoFormaPago= cargarid_facturaBancoFormaPago;
	}

	public Border setResaltarid_deta_forma_pagoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_deta_forma_pagoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_deta_forma_pagoBancoFormaPago() {
		return this.resaltarid_deta_forma_pagoBancoFormaPago;
	}

	public void setResaltarid_deta_forma_pagoBancoFormaPago(Border borderResaltar) {
		this.resaltarid_deta_forma_pagoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_deta_forma_pagoBancoFormaPago() {
		return this.mostrarid_deta_forma_pagoBancoFormaPago;
	}

	public void setMostrarid_deta_forma_pagoBancoFormaPago(Boolean mostrarid_deta_forma_pagoBancoFormaPago) {
		this.mostrarid_deta_forma_pagoBancoFormaPago= mostrarid_deta_forma_pagoBancoFormaPago;
	}

	public Boolean getActivarid_deta_forma_pagoBancoFormaPago() {
		return this.activarid_deta_forma_pagoBancoFormaPago;
	}

	public void setActivarid_deta_forma_pagoBancoFormaPago(Boolean activarid_deta_forma_pagoBancoFormaPago) {
		this.activarid_deta_forma_pagoBancoFormaPago= activarid_deta_forma_pagoBancoFormaPago;
	}

	public Boolean getCargarid_deta_forma_pagoBancoFormaPago() {
		return this.cargarid_deta_forma_pagoBancoFormaPago;
	}

	public void setCargarid_deta_forma_pagoBancoFormaPago(Boolean cargarid_deta_forma_pagoBancoFormaPago) {
		this.cargarid_deta_forma_pagoBancoFormaPago= cargarid_deta_forma_pagoBancoFormaPago;
	}

	public Border setResaltarid_tipo_banco_forma_pagoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_tipo_banco_forma_pagoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_banco_forma_pagoBancoFormaPago() {
		return this.resaltarid_tipo_banco_forma_pagoBancoFormaPago;
	}

	public void setResaltarid_tipo_banco_forma_pagoBancoFormaPago(Border borderResaltar) {
		this.resaltarid_tipo_banco_forma_pagoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_tipo_banco_forma_pagoBancoFormaPago() {
		return this.mostrarid_tipo_banco_forma_pagoBancoFormaPago;
	}

	public void setMostrarid_tipo_banco_forma_pagoBancoFormaPago(Boolean mostrarid_tipo_banco_forma_pagoBancoFormaPago) {
		this.mostrarid_tipo_banco_forma_pagoBancoFormaPago= mostrarid_tipo_banco_forma_pagoBancoFormaPago;
	}

	public Boolean getActivarid_tipo_banco_forma_pagoBancoFormaPago() {
		return this.activarid_tipo_banco_forma_pagoBancoFormaPago;
	}

	public void setActivarid_tipo_banco_forma_pagoBancoFormaPago(Boolean activarid_tipo_banco_forma_pagoBancoFormaPago) {
		this.activarid_tipo_banco_forma_pagoBancoFormaPago= activarid_tipo_banco_forma_pagoBancoFormaPago;
	}

	public Boolean getCargarid_tipo_banco_forma_pagoBancoFormaPago() {
		return this.cargarid_tipo_banco_forma_pagoBancoFormaPago;
	}

	public void setCargarid_tipo_banco_forma_pagoBancoFormaPago(Boolean cargarid_tipo_banco_forma_pagoBancoFormaPago) {
		this.cargarid_tipo_banco_forma_pagoBancoFormaPago= cargarid_tipo_banco_forma_pagoBancoFormaPago;
	}

	public Border setResaltarnombre_bancoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombre_bancoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bancoBancoFormaPago() {
		return this.resaltarnombre_bancoBancoFormaPago;
	}

	public void setResaltarnombre_bancoBancoFormaPago(Border borderResaltar) {
		this.resaltarnombre_bancoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombre_bancoBancoFormaPago() {
		return this.mostrarnombre_bancoBancoFormaPago;
	}

	public void setMostrarnombre_bancoBancoFormaPago(Boolean mostrarnombre_bancoBancoFormaPago) {
		this.mostrarnombre_bancoBancoFormaPago= mostrarnombre_bancoBancoFormaPago;
	}

	public Boolean getActivarnombre_bancoBancoFormaPago() {
		return this.activarnombre_bancoBancoFormaPago;
	}

	public void setActivarnombre_bancoBancoFormaPago(Boolean activarnombre_bancoBancoFormaPago) {
		this.activarnombre_bancoBancoFormaPago= activarnombre_bancoBancoFormaPago;
	}

	public Border setResaltarnombre_giradorBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarnombre_giradorBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_giradorBancoFormaPago() {
		return this.resaltarnombre_giradorBancoFormaPago;
	}

	public void setResaltarnombre_giradorBancoFormaPago(Border borderResaltar) {
		this.resaltarnombre_giradorBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarnombre_giradorBancoFormaPago() {
		return this.mostrarnombre_giradorBancoFormaPago;
	}

	public void setMostrarnombre_giradorBancoFormaPago(Boolean mostrarnombre_giradorBancoFormaPago) {
		this.mostrarnombre_giradorBancoFormaPago= mostrarnombre_giradorBancoFormaPago;
	}

	public Boolean getActivarnombre_giradorBancoFormaPago() {
		return this.activarnombre_giradorBancoFormaPago;
	}

	public void setActivarnombre_giradorBancoFormaPago(Boolean activarnombre_giradorBancoFormaPago) {
		this.activarnombre_giradorBancoFormaPago= activarnombre_giradorBancoFormaPago;
	}

	public Border setResaltarfecha_venceBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarfecha_venceBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceBancoFormaPago() {
		return this.resaltarfecha_venceBancoFormaPago;
	}

	public void setResaltarfecha_venceBancoFormaPago(Border borderResaltar) {
		this.resaltarfecha_venceBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarfecha_venceBancoFormaPago() {
		return this.mostrarfecha_venceBancoFormaPago;
	}

	public void setMostrarfecha_venceBancoFormaPago(Boolean mostrarfecha_venceBancoFormaPago) {
		this.mostrarfecha_venceBancoFormaPago= mostrarfecha_venceBancoFormaPago;
	}

	public Boolean getActivarfecha_venceBancoFormaPago() {
		return this.activarfecha_venceBancoFormaPago;
	}

	public void setActivarfecha_venceBancoFormaPago(Boolean activarfecha_venceBancoFormaPago) {
		this.activarfecha_venceBancoFormaPago= activarfecha_venceBancoFormaPago;
	}

	public Border setResaltarnumero_cuenta_bancoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_cuenta_bancoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuenta_bancoBancoFormaPago() {
		return this.resaltarnumero_cuenta_bancoBancoFormaPago;
	}

	public void setResaltarnumero_cuenta_bancoBancoFormaPago(Border borderResaltar) {
		this.resaltarnumero_cuenta_bancoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_cuenta_bancoBancoFormaPago() {
		return this.mostrarnumero_cuenta_bancoBancoFormaPago;
	}

	public void setMostrarnumero_cuenta_bancoBancoFormaPago(Boolean mostrarnumero_cuenta_bancoBancoFormaPago) {
		this.mostrarnumero_cuenta_bancoBancoFormaPago= mostrarnumero_cuenta_bancoBancoFormaPago;
	}

	public Boolean getActivarnumero_cuenta_bancoBancoFormaPago() {
		return this.activarnumero_cuenta_bancoBancoFormaPago;
	}

	public void setActivarnumero_cuenta_bancoBancoFormaPago(Boolean activarnumero_cuenta_bancoBancoFormaPago) {
		this.activarnumero_cuenta_bancoBancoFormaPago= activarnumero_cuenta_bancoBancoFormaPago;
	}

	public Border setResaltarnumero_chequeBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeBancoFormaPago() {
		return this.resaltarnumero_chequeBancoFormaPago;
	}

	public void setResaltarnumero_chequeBancoFormaPago(Border borderResaltar) {
		this.resaltarnumero_chequeBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeBancoFormaPago() {
		return this.mostrarnumero_chequeBancoFormaPago;
	}

	public void setMostrarnumero_chequeBancoFormaPago(Boolean mostrarnumero_chequeBancoFormaPago) {
		this.mostrarnumero_chequeBancoFormaPago= mostrarnumero_chequeBancoFormaPago;
	}

	public Boolean getActivarnumero_chequeBancoFormaPago() {
		return this.activarnumero_chequeBancoFormaPago;
	}

	public void setActivarnumero_chequeBancoFormaPago(Boolean activarnumero_chequeBancoFormaPago) {
		this.activarnumero_chequeBancoFormaPago= activarnumero_chequeBancoFormaPago;
	}

	public Border setResaltarvalor_montoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarvalor_montoBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_montoBancoFormaPago() {
		return this.resaltarvalor_montoBancoFormaPago;
	}

	public void setResaltarvalor_montoBancoFormaPago(Border borderResaltar) {
		this.resaltarvalor_montoBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarvalor_montoBancoFormaPago() {
		return this.mostrarvalor_montoBancoFormaPago;
	}

	public void setMostrarvalor_montoBancoFormaPago(Boolean mostrarvalor_montoBancoFormaPago) {
		this.mostrarvalor_montoBancoFormaPago= mostrarvalor_montoBancoFormaPago;
	}

	public Boolean getActivarvalor_montoBancoFormaPago() {
		return this.activarvalor_montoBancoFormaPago;
	}

	public void setActivarvalor_montoBancoFormaPago(Boolean activarvalor_montoBancoFormaPago) {
		this.activarvalor_montoBancoFormaPago= activarvalor_montoBancoFormaPago;
	}

	public Border setResaltarid_anioBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_anioBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioBancoFormaPago() {
		return this.resaltarid_anioBancoFormaPago;
	}

	public void setResaltarid_anioBancoFormaPago(Border borderResaltar) {
		this.resaltarid_anioBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_anioBancoFormaPago() {
		return this.mostrarid_anioBancoFormaPago;
	}

	public void setMostrarid_anioBancoFormaPago(Boolean mostrarid_anioBancoFormaPago) {
		this.mostrarid_anioBancoFormaPago= mostrarid_anioBancoFormaPago;
	}

	public Boolean getActivarid_anioBancoFormaPago() {
		return this.activarid_anioBancoFormaPago;
	}

	public void setActivarid_anioBancoFormaPago(Boolean activarid_anioBancoFormaPago) {
		this.activarid_anioBancoFormaPago= activarid_anioBancoFormaPago;
	}

	public Boolean getCargarid_anioBancoFormaPago() {
		return this.cargarid_anioBancoFormaPago;
	}

	public void setCargarid_anioBancoFormaPago(Boolean cargarid_anioBancoFormaPago) {
		this.cargarid_anioBancoFormaPago= cargarid_anioBancoFormaPago;
	}

	public Border setResaltarid_mesBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//bancoformapagoBeanSwingJInternalFrame.jTtoolBarBancoFormaPago.setBorder(borderResaltar);
		
		this.resaltarid_mesBancoFormaPago= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesBancoFormaPago() {
		return this.resaltarid_mesBancoFormaPago;
	}

	public void setResaltarid_mesBancoFormaPago(Border borderResaltar) {
		this.resaltarid_mesBancoFormaPago= borderResaltar;
	}

	public Boolean getMostrarid_mesBancoFormaPago() {
		return this.mostrarid_mesBancoFormaPago;
	}

	public void setMostrarid_mesBancoFormaPago(Boolean mostrarid_mesBancoFormaPago) {
		this.mostrarid_mesBancoFormaPago= mostrarid_mesBancoFormaPago;
	}

	public Boolean getActivarid_mesBancoFormaPago() {
		return this.activarid_mesBancoFormaPago;
	}

	public void setActivarid_mesBancoFormaPago(Boolean activarid_mesBancoFormaPago) {
		this.activarid_mesBancoFormaPago= activarid_mesBancoFormaPago;
	}

	public Boolean getCargarid_mesBancoFormaPago() {
		return this.cargarid_mesBancoFormaPago;
	}

	public void setCargarid_mesBancoFormaPago(Boolean cargarid_mesBancoFormaPago) {
		this.cargarid_mesBancoFormaPago= cargarid_mesBancoFormaPago;
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
		
		
		this.setMostraridBancoFormaPago(esInicial);
		this.setMostrarid_empresaBancoFormaPago(esInicial);
		this.setMostrarid_sucursalBancoFormaPago(esInicial);
		this.setMostrarid_ejercicioBancoFormaPago(esInicial);
		this.setMostrarid_periodoBancoFormaPago(esInicial);
		this.setMostrarid_facturaBancoFormaPago(esInicial);
		this.setMostrarid_deta_forma_pagoBancoFormaPago(esInicial);
		this.setMostrarid_tipo_banco_forma_pagoBancoFormaPago(esInicial);
		this.setMostrarnombre_bancoBancoFormaPago(esInicial);
		this.setMostrarnombre_giradorBancoFormaPago(esInicial);
		this.setMostrarfecha_venceBancoFormaPago(esInicial);
		this.setMostrarnumero_cuenta_bancoBancoFormaPago(esInicial);
		this.setMostrarnumero_chequeBancoFormaPago(esInicial);
		this.setMostrarvalor_montoBancoFormaPago(esInicial);
		this.setMostrarid_anioBancoFormaPago(esInicial);
		this.setMostrarid_mesBancoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.ID)) {
				this.setMostraridBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO)) {
				this.setMostrarid_deta_forma_pagoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO)) {
				this.setMostrarid_tipo_banco_forma_pagoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NOMBREBANCO)) {
				this.setMostrarnombre_bancoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NOMBREGIRADOR)) {
				this.setMostrarnombre_giradorBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO)) {
				this.setMostrarnumero_cuenta_bancoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.VALORMONTO)) {
				this.setMostrarvalor_montoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesBancoFormaPago(esAsigna);
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
		
		
		this.setActivaridBancoFormaPago(esInicial);
		this.setActivarid_empresaBancoFormaPago(esInicial);
		this.setActivarid_sucursalBancoFormaPago(esInicial);
		this.setActivarid_ejercicioBancoFormaPago(esInicial);
		this.setActivarid_periodoBancoFormaPago(esInicial);
		this.setActivarid_facturaBancoFormaPago(esInicial);
		this.setActivarid_deta_forma_pagoBancoFormaPago(esInicial);
		this.setActivarid_tipo_banco_forma_pagoBancoFormaPago(esInicial);
		this.setActivarnombre_bancoBancoFormaPago(esInicial);
		this.setActivarnombre_giradorBancoFormaPago(esInicial);
		this.setActivarfecha_venceBancoFormaPago(esInicial);
		this.setActivarnumero_cuenta_bancoBancoFormaPago(esInicial);
		this.setActivarnumero_chequeBancoFormaPago(esInicial);
		this.setActivarvalor_montoBancoFormaPago(esInicial);
		this.setActivarid_anioBancoFormaPago(esInicial);
		this.setActivarid_mesBancoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.ID)) {
				this.setActivaridBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO)) {
				this.setActivarid_deta_forma_pagoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO)) {
				this.setActivarid_tipo_banco_forma_pagoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NOMBREBANCO)) {
				this.setActivarnombre_bancoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NOMBREGIRADOR)) {
				this.setActivarnombre_giradorBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO)) {
				this.setActivarnumero_cuenta_bancoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.VALORMONTO)) {
				this.setActivarvalor_montoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDMES)) {
				this.setActivarid_mesBancoFormaPago(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBancoFormaPago(esInicial);
		this.setResaltarid_empresaBancoFormaPago(esInicial);
		this.setResaltarid_sucursalBancoFormaPago(esInicial);
		this.setResaltarid_ejercicioBancoFormaPago(esInicial);
		this.setResaltarid_periodoBancoFormaPago(esInicial);
		this.setResaltarid_facturaBancoFormaPago(esInicial);
		this.setResaltarid_deta_forma_pagoBancoFormaPago(esInicial);
		this.setResaltarid_tipo_banco_forma_pagoBancoFormaPago(esInicial);
		this.setResaltarnombre_bancoBancoFormaPago(esInicial);
		this.setResaltarnombre_giradorBancoFormaPago(esInicial);
		this.setResaltarfecha_venceBancoFormaPago(esInicial);
		this.setResaltarnumero_cuenta_bancoBancoFormaPago(esInicial);
		this.setResaltarnumero_chequeBancoFormaPago(esInicial);
		this.setResaltarvalor_montoBancoFormaPago(esInicial);
		this.setResaltarid_anioBancoFormaPago(esInicial);
		this.setResaltarid_mesBancoFormaPago(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.ID)) {
				this.setResaltaridBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDDETAFORMAPAGO)) {
				this.setResaltarid_deta_forma_pagoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDTIPOBANCOFORMAPAGO)) {
				this.setResaltarid_tipo_banco_forma_pagoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NOMBREBANCO)) {
				this.setResaltarnombre_bancoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NOMBREGIRADOR)) {
				this.setResaltarnombre_giradorBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NUMEROCUENTABANCO)) {
				this.setResaltarnumero_cuenta_bancoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.VALORMONTO)) {
				this.setResaltarvalor_montoBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioBancoFormaPago(esAsigna);
				continue;
			}

			if(campo.clase.equals(BancoFormaPagoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesBancoFormaPago(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBancoFormaPagoBancoFormaPago=true;

	public Boolean getMostrarFK_IdBancoFormaPagoBancoFormaPago() {
		return this.mostrarFK_IdBancoFormaPagoBancoFormaPago;
	}

	public void setMostrarFK_IdBancoFormaPagoBancoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoFormaPagoBancoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetaFormaPagoBancoFormaPago=true;

	public Boolean getMostrarFK_IdDetaFormaPagoBancoFormaPago() {
		return this.mostrarFK_IdDetaFormaPagoBancoFormaPago;
	}

	public void setMostrarFK_IdDetaFormaPagoBancoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetaFormaPagoBancoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioBancoFormaPago=true;

	public Boolean getMostrarFK_IdEjercicioBancoFormaPago() {
		return this.mostrarFK_IdEjercicioBancoFormaPago;
	}

	public void setMostrarFK_IdEjercicioBancoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioBancoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaBancoFormaPago=true;

	public Boolean getMostrarFK_IdEmpresaBancoFormaPago() {
		return this.mostrarFK_IdEmpresaBancoFormaPago;
	}

	public void setMostrarFK_IdEmpresaBancoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaBancoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaBancoFormaPago=true;

	public Boolean getMostrarFK_IdFacturaBancoFormaPago() {
		return this.mostrarFK_IdFacturaBancoFormaPago;
	}

	public void setMostrarFK_IdFacturaBancoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaBancoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoBancoFormaPago=true;

	public Boolean getMostrarFK_IdPeriodoBancoFormaPago() {
		return this.mostrarFK_IdPeriodoBancoFormaPago;
	}

	public void setMostrarFK_IdPeriodoBancoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoBancoFormaPago= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalBancoFormaPago=true;

	public Boolean getMostrarFK_IdSucursalBancoFormaPago() {
		return this.mostrarFK_IdSucursalBancoFormaPago;
	}

	public void setMostrarFK_IdSucursalBancoFormaPago(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalBancoFormaPago= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoFormaPagoBancoFormaPago=true;

	public Boolean getActivarFK_IdBancoFormaPagoBancoFormaPago() {
		return this.activarFK_IdBancoFormaPagoBancoFormaPago;
	}

	public void setActivarFK_IdBancoFormaPagoBancoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdBancoFormaPagoBancoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdDetaFormaPagoBancoFormaPago=true;

	public Boolean getActivarFK_IdDetaFormaPagoBancoFormaPago() {
		return this.activarFK_IdDetaFormaPagoBancoFormaPago;
	}

	public void setActivarFK_IdDetaFormaPagoBancoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdDetaFormaPagoBancoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioBancoFormaPago=true;

	public Boolean getActivarFK_IdEjercicioBancoFormaPago() {
		return this.activarFK_IdEjercicioBancoFormaPago;
	}

	public void setActivarFK_IdEjercicioBancoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioBancoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaBancoFormaPago=true;

	public Boolean getActivarFK_IdEmpresaBancoFormaPago() {
		return this.activarFK_IdEmpresaBancoFormaPago;
	}

	public void setActivarFK_IdEmpresaBancoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaBancoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaBancoFormaPago=true;

	public Boolean getActivarFK_IdFacturaBancoFormaPago() {
		return this.activarFK_IdFacturaBancoFormaPago;
	}

	public void setActivarFK_IdFacturaBancoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaBancoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoBancoFormaPago=true;

	public Boolean getActivarFK_IdPeriodoBancoFormaPago() {
		return this.activarFK_IdPeriodoBancoFormaPago;
	}

	public void setActivarFK_IdPeriodoBancoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoBancoFormaPago= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalBancoFormaPago=true;

	public Boolean getActivarFK_IdSucursalBancoFormaPago() {
		return this.activarFK_IdSucursalBancoFormaPago;
	}

	public void setActivarFK_IdSucursalBancoFormaPago(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalBancoFormaPago= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoFormaPagoBancoFormaPago=null;

	public Border getResaltarFK_IdBancoFormaPagoBancoFormaPago() {
		return this.resaltarFK_IdBancoFormaPagoBancoFormaPago;
	}

	public void setResaltarFK_IdBancoFormaPagoBancoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdBancoFormaPagoBancoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdBancoFormaPagoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoFormaPagoBancoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdDetaFormaPagoBancoFormaPago=null;

	public Border getResaltarFK_IdDetaFormaPagoBancoFormaPago() {
		return this.resaltarFK_IdDetaFormaPagoBancoFormaPago;
	}

	public void setResaltarFK_IdDetaFormaPagoBancoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdDetaFormaPagoBancoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdDetaFormaPagoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetaFormaPagoBancoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioBancoFormaPago=null;

	public Border getResaltarFK_IdEjercicioBancoFormaPago() {
		return this.resaltarFK_IdEjercicioBancoFormaPago;
	}

	public void setResaltarFK_IdEjercicioBancoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEjercicioBancoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioBancoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaBancoFormaPago=null;

	public Border getResaltarFK_IdEmpresaBancoFormaPago() {
		return this.resaltarFK_IdEmpresaBancoFormaPago;
	}

	public void setResaltarFK_IdEmpresaBancoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdEmpresaBancoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaBancoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdFacturaBancoFormaPago=null;

	public Border getResaltarFK_IdFacturaBancoFormaPago() {
		return this.resaltarFK_IdFacturaBancoFormaPago;
	}

	public void setResaltarFK_IdFacturaBancoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdFacturaBancoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdFacturaBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaBancoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoBancoFormaPago=null;

	public Border getResaltarFK_IdPeriodoBancoFormaPago() {
		return this.resaltarFK_IdPeriodoBancoFormaPago;
	}

	public void setResaltarFK_IdPeriodoBancoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdPeriodoBancoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoBancoFormaPago= borderResaltar;
	}

	public Border resaltarFK_IdSucursalBancoFormaPago=null;

	public Border getResaltarFK_IdSucursalBancoFormaPago() {
		return this.resaltarFK_IdSucursalBancoFormaPago;
	}

	public void setResaltarFK_IdSucursalBancoFormaPago(Border borderResaltar) {
		this.resaltarFK_IdSucursalBancoFormaPago= borderResaltar;
	}

	public void setResaltarFK_IdSucursalBancoFormaPago(ParametroGeneralUsuario parametroGeneralUsuario/*BancoFormaPagoBeanSwingJInternalFrame bancoformapagoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalBancoFormaPago= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}