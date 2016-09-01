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


import com.bydan.erp.cartera.util.CuentaPorCobrarConstantesFunciones;
import com.bydan.erp.cartera.util.CuentaPorCobrarParameterReturnGeneral;
//import com.bydan.erp.cartera.util.CuentaPorCobrarParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CuentaPorCobrarConstantesFunciones extends CuentaPorCobrarConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaPorCobrar";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaPorCobrar"+CuentaPorCobrarConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaPorCobrarHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaPorCobrarHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaPorCobrarConstantesFunciones.SCHEMA+"_"+CuentaPorCobrarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaPorCobrarHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaPorCobrarConstantesFunciones.SCHEMA+"_"+CuentaPorCobrarConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaPorCobrarConstantesFunciones.SCHEMA+"_"+CuentaPorCobrarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaPorCobrarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaPorCobrarConstantesFunciones.SCHEMA+"_"+CuentaPorCobrarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaPorCobrarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaPorCobrarHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaPorCobrarConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaPorCobrarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaPorCobrarHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaPorCobrarConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaPorCobrarConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaPorCobrarConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaPorCobrarConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaPorCobrarConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Por Cobrares";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cuenta Por Cobrar";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Por Cobrar";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaPorCobrar";
	public static final String OBJECTNAME="cuentaporcobrar";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cuenta_por_cobrar";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentaporcobrar from "+CuentaPorCobrarConstantesFunciones.SPERSISTENCENAME+" cuentaporcobrar";
	public static String QUERYSELECTNATIVE="select "+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".version_row,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_empresa,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_sucursal,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_modulo,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_ejercicio,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_moneda,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_cliente,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_transaccion,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_asiento_contable,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".id_factura,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".fecha,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".monto,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".numero_comprobante,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".debito,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".credito,"+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME+".detalle from "+CuentaPorCobrarConstantesFunciones.SCHEMA+"."+CuentaPorCobrarConstantesFunciones.TABLENAME;//+" as "+CuentaPorCobrarConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaPorCobrarConstantesFuncionesAdditional cuentaporcobrarConstantesFuncionesAdditional=null;
	
	public CuentaPorCobrarConstantesFuncionesAdditional getCuentaPorCobrarConstantesFuncionesAdditional() {
		return this.cuentaporcobrarConstantesFuncionesAdditional;
	}
	
	public void setCuentaPorCobrarConstantesFuncionesAdditional(CuentaPorCobrarConstantesFuncionesAdditional cuentaporcobrarConstantesFuncionesAdditional) {
		try {
			this.cuentaporcobrarConstantesFuncionesAdditional=cuentaporcobrarConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDFACTURA= "id_factura";
    public static final String FECHA= "fecha";
    public static final String MONTO= "monto";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String DEBITO= "debito";
    public static final String CREDITO= "credito";
    public static final String DETALLE= "detalle";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_DEBITO= "Debito";
		public static final String LABEL_DEBITO_LOWER= "Debito";
    	public static final String LABEL_CREDITO= "Credito";
		public static final String LABEL_CREDITO_LOWER= "Credito";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCuentaPorCobrarLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDEMPRESA)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDMODULO)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDEJERCICIO)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDMONEDA)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDCLIENTE)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDTRANSACCION)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.IDFACTURA)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.FECHA)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.MONTO)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.DEBITO)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_DEBITO;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.CREDITO)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_CREDITO;}
		if(sNombreColumna.equals(CuentaPorCobrarConstantesFunciones.DETALLE)) {sLabelColumna=CuentaPorCobrarConstantesFunciones.LABEL_DETALLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCuentaPorCobrarDescripcion(CuentaPorCobrar cuentaporcobrar) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentaporcobrar !=null/* && cuentaporcobrar.getId()!=0*/) {
			if(cuentaporcobrar.getId()!=null) {
				sDescripcion=cuentaporcobrar.getId().toString();
			}//cuentaporcobrarcuentaporcobrar.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaPorCobrarDescripcionDetallado(CuentaPorCobrar cuentaporcobrar) {
		String sDescripcion="";
			
		sDescripcion+=CuentaPorCobrarConstantesFunciones.ID+"=";
		sDescripcion+=cuentaporcobrar.getId().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentaporcobrar.getVersionRow().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cuentaporcobrar.getid_empresa().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cuentaporcobrar.getid_sucursal().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDMODULO+"=";
		sDescripcion+=cuentaporcobrar.getid_modulo().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=cuentaporcobrar.getid_ejercicio().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=cuentaporcobrar.getid_moneda().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=cuentaporcobrar.getid_cliente().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=cuentaporcobrar.getid_transaccion().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=cuentaporcobrar.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=cuentaporcobrar.getid_asiento_contable().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=cuentaporcobrar.getid_factura().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.FECHA+"=";
		sDescripcion+=cuentaporcobrar.getfecha().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.MONTO+"=";
		sDescripcion+=cuentaporcobrar.getmonto().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=cuentaporcobrar.getnumero_comprobante()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.DEBITO+"=";
		sDescripcion+=cuentaporcobrar.getdebito().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.CREDITO+"=";
		sDescripcion+=cuentaporcobrar.getcredito().toString()+",";
		sDescripcion+=CuentaPorCobrarConstantesFunciones.DETALLE+"=";
		sDescripcion+=cuentaporcobrar.getdetalle()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaPorCobrarDescripcion(CuentaPorCobrar cuentaporcobrar,String sValor) throws Exception {			
		if(cuentaporcobrar !=null) {
			//cuentaporcobrarcuentaporcobrar.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
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

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaPorCobrar(CuentaPorCobrar cuentaporcobrar,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentaporcobrar.setnumero_comprobante(cuentaporcobrar.getnumero_comprobante().trim());
		cuentaporcobrar.setdetalle(cuentaporcobrar.getdetalle().trim());
	}
	
	public static void quitarEspaciosCuentaPorCobrars(List<CuentaPorCobrar> cuentaporcobrars,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaPorCobrar cuentaporcobrar: cuentaporcobrars) {
			cuentaporcobrar.setnumero_comprobante(cuentaporcobrar.getnumero_comprobante().trim());
			cuentaporcobrar.setdetalle(cuentaporcobrar.getdetalle().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaPorCobrar(CuentaPorCobrar cuentaporcobrar,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentaporcobrar.getConCambioAuxiliar()) {
			cuentaporcobrar.setIsDeleted(cuentaporcobrar.getIsDeletedAuxiliar());	
			cuentaporcobrar.setIsNew(cuentaporcobrar.getIsNewAuxiliar());	
			cuentaporcobrar.setIsChanged(cuentaporcobrar.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentaporcobrar.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentaporcobrar.setIsDeletedAuxiliar(false);	
			cuentaporcobrar.setIsNewAuxiliar(false);	
			cuentaporcobrar.setIsChangedAuxiliar(false);
			
			cuentaporcobrar.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaPorCobrars(List<CuentaPorCobrar> cuentaporcobrars,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaPorCobrar cuentaporcobrar : cuentaporcobrars) {
			if(conAsignarBase && cuentaporcobrar.getConCambioAuxiliar()) {
				cuentaporcobrar.setIsDeleted(cuentaporcobrar.getIsDeletedAuxiliar());	
				cuentaporcobrar.setIsNew(cuentaporcobrar.getIsNewAuxiliar());	
				cuentaporcobrar.setIsChanged(cuentaporcobrar.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentaporcobrar.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentaporcobrar.setIsDeletedAuxiliar(false);	
				cuentaporcobrar.setIsNewAuxiliar(false);	
				cuentaporcobrar.setIsChangedAuxiliar(false);
				
				cuentaporcobrar.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaPorCobrar(CuentaPorCobrar cuentaporcobrar,Boolean conEnteros) throws Exception  {
		cuentaporcobrar.setmonto(0.0);
		cuentaporcobrar.setdebito(0.0);
		cuentaporcobrar.setcredito(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCuentaPorCobrars(List<CuentaPorCobrar> cuentaporcobrars,Boolean conEnteros) throws Exception  {
		
		for(CuentaPorCobrar cuentaporcobrar: cuentaporcobrars) {
			cuentaporcobrar.setmonto(0.0);
			cuentaporcobrar.setdebito(0.0);
			cuentaporcobrar.setcredito(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaPorCobrar(List<CuentaPorCobrar> cuentaporcobrars,CuentaPorCobrar cuentaporcobrarAux) throws Exception  {
		CuentaPorCobrarConstantesFunciones.InicializarValoresCuentaPorCobrar(cuentaporcobrarAux,true);
		
		for(CuentaPorCobrar cuentaporcobrar: cuentaporcobrars) {
			if(cuentaporcobrar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cuentaporcobrarAux.setmonto(cuentaporcobrarAux.getmonto()+cuentaporcobrar.getmonto());			
			cuentaporcobrarAux.setdebito(cuentaporcobrarAux.getdebito()+cuentaporcobrar.getdebito());			
			cuentaporcobrarAux.setcredito(cuentaporcobrarAux.getcredito()+cuentaporcobrar.getcredito());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaPorCobrar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaPorCobrarConstantesFunciones.getArrayColumnasGlobalesCuentaPorCobrar(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaPorCobrar(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaPorCobrarConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaPorCobrarConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaPorCobrarConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaPorCobrarConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaPorCobrarConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaPorCobrarConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaPorCobrarConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaPorCobrarConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaPorCobrarConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaPorCobrarConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaPorCobrar(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaPorCobrar> cuentaporcobrars,CuentaPorCobrar cuentaporcobrar,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaPorCobrar cuentaporcobrarAux: cuentaporcobrars) {
			if(cuentaporcobrarAux!=null && cuentaporcobrar!=null) {
				if((cuentaporcobrarAux.getId()==null && cuentaporcobrar.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentaporcobrarAux.getId()!=null && cuentaporcobrar.getId()!=null){
					if(cuentaporcobrarAux.getId().equals(cuentaporcobrar.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaPorCobrar(List<CuentaPorCobrar> cuentaporcobrars) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double montoTotal=0.0;
		Double debitoTotal=0.0;
		Double creditoTotal=0.0;
	
		for(CuentaPorCobrar cuentaporcobrar: cuentaporcobrars) {			
			if(cuentaporcobrar.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			montoTotal+=cuentaporcobrar.getmonto();
			debitoTotal+=cuentaporcobrar.getdebito();
			creditoTotal+=cuentaporcobrar.getcredito();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuentaPorCobrarConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuentaPorCobrarConstantesFunciones.DEBITO);
		datoGeneral.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_DEBITO);
		datoGeneral.setdValorDouble(debitoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuentaPorCobrarConstantesFunciones.CREDITO);
		datoGeneral.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_CREDITO);
		datoGeneral.setdValorDouble(creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaPorCobrar() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_ID, CuentaPorCobrarConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_VERSIONROW, CuentaPorCobrarConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDEMPRESA, CuentaPorCobrarConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDSUCURSAL, CuentaPorCobrarConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDMODULO, CuentaPorCobrarConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDEJERCICIO, CuentaPorCobrarConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDMONEDA, CuentaPorCobrarConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDCLIENTE, CuentaPorCobrarConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDTRANSACCION, CuentaPorCobrarConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDASIENTOCONTABLE, CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_IDFACTURA, CuentaPorCobrarConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_FECHA, CuentaPorCobrarConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_MONTO, CuentaPorCobrarConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_NUMEROCOMPROBANTE, CuentaPorCobrarConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_DEBITO, CuentaPorCobrarConstantesFunciones.DEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_CREDITO, CuentaPorCobrarConstantesFunciones.CREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaPorCobrarConstantesFunciones.LABEL_DETALLE, CuentaPorCobrarConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaPorCobrar() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.DEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.CREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaPorCobrarConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaPorCobrar() throws Exception  {
		return CuentaPorCobrarConstantesFunciones.getTiposSeleccionarCuentaPorCobrar(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaPorCobrar(Boolean conFk) throws Exception  {
		return CuentaPorCobrarConstantesFunciones.getTiposSeleccionarCuentaPorCobrar(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaPorCobrar(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_DEBITO);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_DEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_CREDITO);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_CREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaPorCobrarConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(CuentaPorCobrarConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaPorCobrar(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaPorCobrar(CuentaPorCobrar cuentaporcobrarAux) throws Exception {
		
			cuentaporcobrarAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentaporcobrarAux.getEmpresa()));
			cuentaporcobrarAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cuentaporcobrarAux.getSucursal()));
			cuentaporcobrarAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(cuentaporcobrarAux.getModulo()));
			cuentaporcobrarAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(cuentaporcobrarAux.getEjercicio()));
			cuentaporcobrarAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(cuentaporcobrarAux.getMoneda()));
			cuentaporcobrarAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cuentaporcobrarAux.getCliente()));
			cuentaporcobrarAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(cuentaporcobrarAux.getTransaccion()));
			cuentaporcobrarAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(cuentaporcobrarAux.getTipoTransaccionModulo()));
			cuentaporcobrarAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(cuentaporcobrarAux.getAsientoContable()));
			cuentaporcobrarAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(cuentaporcobrarAux.getFactura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaPorCobrar(List<CuentaPorCobrar> cuentaporcobrarsTemp) throws Exception {
		for(CuentaPorCobrar cuentaporcobrarAux:cuentaporcobrarsTemp) {
			
			cuentaporcobrarAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentaporcobrarAux.getEmpresa()));
			cuentaporcobrarAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cuentaporcobrarAux.getSucursal()));
			cuentaporcobrarAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(cuentaporcobrarAux.getModulo()));
			cuentaporcobrarAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(cuentaporcobrarAux.getEjercicio()));
			cuentaporcobrarAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(cuentaporcobrarAux.getMoneda()));
			cuentaporcobrarAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cuentaporcobrarAux.getCliente()));
			cuentaporcobrarAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(cuentaporcobrarAux.getTransaccion()));
			cuentaporcobrarAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(cuentaporcobrarAux.getTipoTransaccionModulo()));
			cuentaporcobrarAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(cuentaporcobrarAux.getAsientoContable()));
			cuentaporcobrarAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(cuentaporcobrarAux.getFactura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaPorCobrar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Factura.class));
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaPorCobrar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaPorCobrar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaPorCobrarConstantesFunciones.getClassesRelationshipsOfCuentaPorCobrar(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaPorCobrar(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaPorCobrar(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaPorCobrarConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaPorCobrar(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaPorCobrar(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CuentaPorCobrar cuentaporcobrar,List<CuentaPorCobrar> cuentaporcobrars,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaPorCobrar cuentaporcobrarEncontrado=null;
			
			for(CuentaPorCobrar cuentaporcobrarLocal:cuentaporcobrars) {
				if(cuentaporcobrarLocal.getId().equals(cuentaporcobrar.getId())) {
					cuentaporcobrarEncontrado=cuentaporcobrarLocal;
					
					cuentaporcobrarLocal.setIsChanged(cuentaporcobrar.getIsChanged());
					cuentaporcobrarLocal.setIsNew(cuentaporcobrar.getIsNew());
					cuentaporcobrarLocal.setIsDeleted(cuentaporcobrar.getIsDeleted());
					
					cuentaporcobrarLocal.setGeneralEntityOriginal(cuentaporcobrar.getGeneralEntityOriginal());
					
					cuentaporcobrarLocal.setId(cuentaporcobrar.getId());	
					cuentaporcobrarLocal.setVersionRow(cuentaporcobrar.getVersionRow());	
					cuentaporcobrarLocal.setid_empresa(cuentaporcobrar.getid_empresa());	
					cuentaporcobrarLocal.setid_sucursal(cuentaporcobrar.getid_sucursal());	
					cuentaporcobrarLocal.setid_modulo(cuentaporcobrar.getid_modulo());	
					cuentaporcobrarLocal.setid_ejercicio(cuentaporcobrar.getid_ejercicio());	
					cuentaporcobrarLocal.setid_moneda(cuentaporcobrar.getid_moneda());	
					cuentaporcobrarLocal.setid_cliente(cuentaporcobrar.getid_cliente());	
					cuentaporcobrarLocal.setid_transaccion(cuentaporcobrar.getid_transaccion());	
					cuentaporcobrarLocal.setid_tipo_transaccion_modulo(cuentaporcobrar.getid_tipo_transaccion_modulo());	
					cuentaporcobrarLocal.setid_asiento_contable(cuentaporcobrar.getid_asiento_contable());	
					cuentaporcobrarLocal.setid_factura(cuentaporcobrar.getid_factura());	
					cuentaporcobrarLocal.setfecha(cuentaporcobrar.getfecha());	
					cuentaporcobrarLocal.setmonto(cuentaporcobrar.getmonto());	
					cuentaporcobrarLocal.setnumero_comprobante(cuentaporcobrar.getnumero_comprobante());	
					cuentaporcobrarLocal.setdebito(cuentaporcobrar.getdebito());	
					cuentaporcobrarLocal.setcredito(cuentaporcobrar.getcredito());	
					cuentaporcobrarLocal.setdetalle(cuentaporcobrar.getdetalle());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cuentaporcobrar.getIsDeleted()) {
				if(!existe) {
					cuentaporcobrars.add(cuentaporcobrar);
				}
			} else {
				if(cuentaporcobrarEncontrado!=null && permiteQuitar)  {
					cuentaporcobrars.remove(cuentaporcobrarEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaPorCobrar cuentaporcobrar,List<CuentaPorCobrar> cuentaporcobrars) throws Exception {
		try	{			
			for(CuentaPorCobrar cuentaporcobrarLocal:cuentaporcobrars) {
				if(cuentaporcobrarLocal.getId().equals(cuentaporcobrar.getId())) {
					cuentaporcobrarLocal.setIsSelected(cuentaporcobrar.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaPorCobrar(List<CuentaPorCobrar> cuentaporcobrarsAux) throws Exception {
		//this.cuentaporcobrarsAux=cuentaporcobrarsAux;
		
		for(CuentaPorCobrar cuentaporcobrarAux:cuentaporcobrarsAux) {
			if(cuentaporcobrarAux.getIsChanged()) {
				cuentaporcobrarAux.setIsChanged(false);
			}		
			
			if(cuentaporcobrarAux.getIsNew()) {
				cuentaporcobrarAux.setIsNew(false);
			}	
			
			if(cuentaporcobrarAux.getIsDeleted()) {
				cuentaporcobrarAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaPorCobrar(CuentaPorCobrar cuentaporcobrarAux) throws Exception {
		//this.cuentaporcobrarAux=cuentaporcobrarAux;
		
			if(cuentaporcobrarAux.getIsChanged()) {
				cuentaporcobrarAux.setIsChanged(false);
			}		
			
			if(cuentaporcobrarAux.getIsNew()) {
				cuentaporcobrarAux.setIsNew(false);
			}	
			
			if(cuentaporcobrarAux.getIsDeleted()) {
				cuentaporcobrarAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaPorCobrar cuentaporcobrarAsignar,CuentaPorCobrar cuentaporcobrar) throws Exception {
		cuentaporcobrarAsignar.setId(cuentaporcobrar.getId());	
		cuentaporcobrarAsignar.setVersionRow(cuentaporcobrar.getVersionRow());	
		cuentaporcobrarAsignar.setid_empresa(cuentaporcobrar.getid_empresa());
		cuentaporcobrarAsignar.setempresa_descripcion(cuentaporcobrar.getempresa_descripcion());	
		cuentaporcobrarAsignar.setid_sucursal(cuentaporcobrar.getid_sucursal());
		cuentaporcobrarAsignar.setsucursal_descripcion(cuentaporcobrar.getsucursal_descripcion());	
		cuentaporcobrarAsignar.setid_modulo(cuentaporcobrar.getid_modulo());
		cuentaporcobrarAsignar.setmodulo_descripcion(cuentaporcobrar.getmodulo_descripcion());	
		cuentaporcobrarAsignar.setid_ejercicio(cuentaporcobrar.getid_ejercicio());
		cuentaporcobrarAsignar.setejercicio_descripcion(cuentaporcobrar.getejercicio_descripcion());	
		cuentaporcobrarAsignar.setid_moneda(cuentaporcobrar.getid_moneda());
		cuentaporcobrarAsignar.setmoneda_descripcion(cuentaporcobrar.getmoneda_descripcion());	
		cuentaporcobrarAsignar.setid_cliente(cuentaporcobrar.getid_cliente());
		cuentaporcobrarAsignar.setcliente_descripcion(cuentaporcobrar.getcliente_descripcion());	
		cuentaporcobrarAsignar.setid_transaccion(cuentaporcobrar.getid_transaccion());
		cuentaporcobrarAsignar.settransaccion_descripcion(cuentaporcobrar.gettransaccion_descripcion());	
		cuentaporcobrarAsignar.setid_tipo_transaccion_modulo(cuentaporcobrar.getid_tipo_transaccion_modulo());
		cuentaporcobrarAsignar.settipotransaccionmodulo_descripcion(cuentaporcobrar.gettipotransaccionmodulo_descripcion());	
		cuentaporcobrarAsignar.setid_asiento_contable(cuentaporcobrar.getid_asiento_contable());
		cuentaporcobrarAsignar.setasientocontable_descripcion(cuentaporcobrar.getasientocontable_descripcion());	
		cuentaporcobrarAsignar.setid_factura(cuentaporcobrar.getid_factura());
		cuentaporcobrarAsignar.setfactura_descripcion(cuentaporcobrar.getfactura_descripcion());	
		cuentaporcobrarAsignar.setfecha(cuentaporcobrar.getfecha());	
		cuentaporcobrarAsignar.setmonto(cuentaporcobrar.getmonto());	
		cuentaporcobrarAsignar.setnumero_comprobante(cuentaporcobrar.getnumero_comprobante());	
		cuentaporcobrarAsignar.setdebito(cuentaporcobrar.getdebito());	
		cuentaporcobrarAsignar.setcredito(cuentaporcobrar.getcredito());	
		cuentaporcobrarAsignar.setdetalle(cuentaporcobrar.getdetalle());	
	}
	
	public static void inicializarCuentaPorCobrar(CuentaPorCobrar cuentaporcobrar) throws Exception {
		try {
				cuentaporcobrar.setId(0L);	
					
				cuentaporcobrar.setid_empresa(-1L);	
				cuentaporcobrar.setid_sucursal(-1L);	
				cuentaporcobrar.setid_modulo(-1L);	
				cuentaporcobrar.setid_ejercicio(-1L);	
				cuentaporcobrar.setid_moneda(-1L);	
				cuentaporcobrar.setid_cliente(-1L);	
				cuentaporcobrar.setid_transaccion(-1L);	
				cuentaporcobrar.setid_tipo_transaccion_modulo(null);	
				cuentaporcobrar.setid_asiento_contable(-1L);	
				cuentaporcobrar.setid_factura(-1L);	
				cuentaporcobrar.setfecha(new Date());	
				cuentaporcobrar.setmonto(0.0);	
				cuentaporcobrar.setnumero_comprobante("");	
				cuentaporcobrar.setdebito(0.0);	
				cuentaporcobrar.setcredito(0.0);	
				cuentaporcobrar.setdetalle("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaPorCobrar(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_DEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_CREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaPorCobrarConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaPorCobrar(String sTipo,Row row,Workbook workbook,CuentaPorCobrar cuentaporcobrar,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getdebito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getcredito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentaporcobrar.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaPorCobrar=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaPorCobrar() {
		return this.sFinalQueryCuentaPorCobrar;
	}
	
	public void setsFinalQueryCuentaPorCobrar(String sFinalQueryCuentaPorCobrar) {
		this.sFinalQueryCuentaPorCobrar= sFinalQueryCuentaPorCobrar;
	}
	
	public Border resaltarSeleccionarCuentaPorCobrar=null;
	
	public Border setResaltarSeleccionarCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaPorCobrar= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaPorCobrar() {
		return this.resaltarSeleccionarCuentaPorCobrar;
	}
	
	public void setResaltarSeleccionarCuentaPorCobrar(Border borderResaltarSeleccionarCuentaPorCobrar) {
		this.resaltarSeleccionarCuentaPorCobrar= borderResaltarSeleccionarCuentaPorCobrar;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaPorCobrar=null;
	public Boolean mostraridCuentaPorCobrar=true;
	public Boolean activaridCuentaPorCobrar=true;

	public Border resaltarid_empresaCuentaPorCobrar=null;
	public Boolean mostrarid_empresaCuentaPorCobrar=true;
	public Boolean activarid_empresaCuentaPorCobrar=true;
	public Boolean cargarid_empresaCuentaPorCobrar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_sucursalCuentaPorCobrar=null;
	public Boolean mostrarid_sucursalCuentaPorCobrar=true;
	public Boolean activarid_sucursalCuentaPorCobrar=true;
	public Boolean cargarid_sucursalCuentaPorCobrar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_moduloCuentaPorCobrar=null;
	public Boolean mostrarid_moduloCuentaPorCobrar=true;
	public Boolean activarid_moduloCuentaPorCobrar=true;
	public Boolean cargarid_moduloCuentaPorCobrar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_ejercicioCuentaPorCobrar=null;
	public Boolean mostrarid_ejercicioCuentaPorCobrar=true;
	public Boolean activarid_ejercicioCuentaPorCobrar=true;
	public Boolean cargarid_ejercicioCuentaPorCobrar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_monedaCuentaPorCobrar=null;
	public Boolean mostrarid_monedaCuentaPorCobrar=true;
	public Boolean activarid_monedaCuentaPorCobrar=true;
	public Boolean cargarid_monedaCuentaPorCobrar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_clienteCuentaPorCobrar=null;
	public Boolean mostrarid_clienteCuentaPorCobrar=true;
	public Boolean activarid_clienteCuentaPorCobrar=true;
	public Boolean cargarid_clienteCuentaPorCobrar=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_transaccionCuentaPorCobrar=null;
	public Boolean mostrarid_transaccionCuentaPorCobrar=true;
	public Boolean activarid_transaccionCuentaPorCobrar=true;
	public Boolean cargarid_transaccionCuentaPorCobrar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloCuentaPorCobrar=null;
	public Boolean mostrarid_tipo_transaccion_moduloCuentaPorCobrar=true;
	public Boolean activarid_tipo_transaccion_moduloCuentaPorCobrar=false;
	public Boolean cargarid_tipo_transaccion_moduloCuentaPorCobrar=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableCuentaPorCobrar=null;
	public Boolean mostrarid_asiento_contableCuentaPorCobrar=true;
	public Boolean activarid_asiento_contableCuentaPorCobrar=true;
	public Boolean cargarid_asiento_contableCuentaPorCobrar=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarid_facturaCuentaPorCobrar=null;
	public Boolean mostrarid_facturaCuentaPorCobrar=true;
	public Boolean activarid_facturaCuentaPorCobrar=true;
	public Boolean cargarid_facturaCuentaPorCobrar=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaCuentaPorCobrar=false;//ConEventDepend=true

	public Border resaltarfechaCuentaPorCobrar=null;
	public Boolean mostrarfechaCuentaPorCobrar=true;
	public Boolean activarfechaCuentaPorCobrar=false;

	public Border resaltarmontoCuentaPorCobrar=null;
	public Boolean mostrarmontoCuentaPorCobrar=true;
	public Boolean activarmontoCuentaPorCobrar=true;

	public Border resaltarnumero_comprobanteCuentaPorCobrar=null;
	public Boolean mostrarnumero_comprobanteCuentaPorCobrar=true;
	public Boolean activarnumero_comprobanteCuentaPorCobrar=true;

	public Border resaltardebitoCuentaPorCobrar=null;
	public Boolean mostrardebitoCuentaPorCobrar=true;
	public Boolean activardebitoCuentaPorCobrar=true;

	public Border resaltarcreditoCuentaPorCobrar=null;
	public Boolean mostrarcreditoCuentaPorCobrar=true;
	public Boolean activarcreditoCuentaPorCobrar=true;

	public Border resaltardetalleCuentaPorCobrar=null;
	public Boolean mostrardetalleCuentaPorCobrar=true;
	public Boolean activardetalleCuentaPorCobrar=true;

	
	

	public Border setResaltaridCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltaridCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaPorCobrar() {
		return this.resaltaridCuentaPorCobrar;
	}

	public void setResaltaridCuentaPorCobrar(Border borderResaltar) {
		this.resaltaridCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostraridCuentaPorCobrar() {
		return this.mostraridCuentaPorCobrar;
	}

	public void setMostraridCuentaPorCobrar(Boolean mostraridCuentaPorCobrar) {
		this.mostraridCuentaPorCobrar= mostraridCuentaPorCobrar;
	}

	public Boolean getActivaridCuentaPorCobrar() {
		return this.activaridCuentaPorCobrar;
	}

	public void setActivaridCuentaPorCobrar(Boolean activaridCuentaPorCobrar) {
		this.activaridCuentaPorCobrar= activaridCuentaPorCobrar;
	}

	public Border setResaltarid_empresaCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_empresaCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCuentaPorCobrar() {
		return this.resaltarid_empresaCuentaPorCobrar;
	}

	public void setResaltarid_empresaCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_empresaCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_empresaCuentaPorCobrar() {
		return this.mostrarid_empresaCuentaPorCobrar;
	}

	public void setMostrarid_empresaCuentaPorCobrar(Boolean mostrarid_empresaCuentaPorCobrar) {
		this.mostrarid_empresaCuentaPorCobrar= mostrarid_empresaCuentaPorCobrar;
	}

	public Boolean getActivarid_empresaCuentaPorCobrar() {
		return this.activarid_empresaCuentaPorCobrar;
	}

	public void setActivarid_empresaCuentaPorCobrar(Boolean activarid_empresaCuentaPorCobrar) {
		this.activarid_empresaCuentaPorCobrar= activarid_empresaCuentaPorCobrar;
	}

	public Boolean getCargarid_empresaCuentaPorCobrar() {
		return this.cargarid_empresaCuentaPorCobrar;
	}

	public void setCargarid_empresaCuentaPorCobrar(Boolean cargarid_empresaCuentaPorCobrar) {
		this.cargarid_empresaCuentaPorCobrar= cargarid_empresaCuentaPorCobrar;
	}

	public Border setResaltarid_sucursalCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCuentaPorCobrar() {
		return this.resaltarid_sucursalCuentaPorCobrar;
	}

	public void setResaltarid_sucursalCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_sucursalCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCuentaPorCobrar() {
		return this.mostrarid_sucursalCuentaPorCobrar;
	}

	public void setMostrarid_sucursalCuentaPorCobrar(Boolean mostrarid_sucursalCuentaPorCobrar) {
		this.mostrarid_sucursalCuentaPorCobrar= mostrarid_sucursalCuentaPorCobrar;
	}

	public Boolean getActivarid_sucursalCuentaPorCobrar() {
		return this.activarid_sucursalCuentaPorCobrar;
	}

	public void setActivarid_sucursalCuentaPorCobrar(Boolean activarid_sucursalCuentaPorCobrar) {
		this.activarid_sucursalCuentaPorCobrar= activarid_sucursalCuentaPorCobrar;
	}

	public Boolean getCargarid_sucursalCuentaPorCobrar() {
		return this.cargarid_sucursalCuentaPorCobrar;
	}

	public void setCargarid_sucursalCuentaPorCobrar(Boolean cargarid_sucursalCuentaPorCobrar) {
		this.cargarid_sucursalCuentaPorCobrar= cargarid_sucursalCuentaPorCobrar;
	}

	public Border setResaltarid_moduloCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_moduloCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloCuentaPorCobrar() {
		return this.resaltarid_moduloCuentaPorCobrar;
	}

	public void setResaltarid_moduloCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_moduloCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_moduloCuentaPorCobrar() {
		return this.mostrarid_moduloCuentaPorCobrar;
	}

	public void setMostrarid_moduloCuentaPorCobrar(Boolean mostrarid_moduloCuentaPorCobrar) {
		this.mostrarid_moduloCuentaPorCobrar= mostrarid_moduloCuentaPorCobrar;
	}

	public Boolean getActivarid_moduloCuentaPorCobrar() {
		return this.activarid_moduloCuentaPorCobrar;
	}

	public void setActivarid_moduloCuentaPorCobrar(Boolean activarid_moduloCuentaPorCobrar) {
		this.activarid_moduloCuentaPorCobrar= activarid_moduloCuentaPorCobrar;
	}

	public Boolean getCargarid_moduloCuentaPorCobrar() {
		return this.cargarid_moduloCuentaPorCobrar;
	}

	public void setCargarid_moduloCuentaPorCobrar(Boolean cargarid_moduloCuentaPorCobrar) {
		this.cargarid_moduloCuentaPorCobrar= cargarid_moduloCuentaPorCobrar;
	}

	public Border setResaltarid_ejercicioCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioCuentaPorCobrar() {
		return this.resaltarid_ejercicioCuentaPorCobrar;
	}

	public void setResaltarid_ejercicioCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_ejercicioCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioCuentaPorCobrar() {
		return this.mostrarid_ejercicioCuentaPorCobrar;
	}

	public void setMostrarid_ejercicioCuentaPorCobrar(Boolean mostrarid_ejercicioCuentaPorCobrar) {
		this.mostrarid_ejercicioCuentaPorCobrar= mostrarid_ejercicioCuentaPorCobrar;
	}

	public Boolean getActivarid_ejercicioCuentaPorCobrar() {
		return this.activarid_ejercicioCuentaPorCobrar;
	}

	public void setActivarid_ejercicioCuentaPorCobrar(Boolean activarid_ejercicioCuentaPorCobrar) {
		this.activarid_ejercicioCuentaPorCobrar= activarid_ejercicioCuentaPorCobrar;
	}

	public Boolean getCargarid_ejercicioCuentaPorCobrar() {
		return this.cargarid_ejercicioCuentaPorCobrar;
	}

	public void setCargarid_ejercicioCuentaPorCobrar(Boolean cargarid_ejercicioCuentaPorCobrar) {
		this.cargarid_ejercicioCuentaPorCobrar= cargarid_ejercicioCuentaPorCobrar;
	}

	public Border setResaltarid_monedaCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_monedaCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaCuentaPorCobrar() {
		return this.resaltarid_monedaCuentaPorCobrar;
	}

	public void setResaltarid_monedaCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_monedaCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_monedaCuentaPorCobrar() {
		return this.mostrarid_monedaCuentaPorCobrar;
	}

	public void setMostrarid_monedaCuentaPorCobrar(Boolean mostrarid_monedaCuentaPorCobrar) {
		this.mostrarid_monedaCuentaPorCobrar= mostrarid_monedaCuentaPorCobrar;
	}

	public Boolean getActivarid_monedaCuentaPorCobrar() {
		return this.activarid_monedaCuentaPorCobrar;
	}

	public void setActivarid_monedaCuentaPorCobrar(Boolean activarid_monedaCuentaPorCobrar) {
		this.activarid_monedaCuentaPorCobrar= activarid_monedaCuentaPorCobrar;
	}

	public Boolean getCargarid_monedaCuentaPorCobrar() {
		return this.cargarid_monedaCuentaPorCobrar;
	}

	public void setCargarid_monedaCuentaPorCobrar(Boolean cargarid_monedaCuentaPorCobrar) {
		this.cargarid_monedaCuentaPorCobrar= cargarid_monedaCuentaPorCobrar;
	}

	public Border setResaltarid_clienteCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_clienteCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteCuentaPorCobrar() {
		return this.resaltarid_clienteCuentaPorCobrar;
	}

	public void setResaltarid_clienteCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_clienteCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_clienteCuentaPorCobrar() {
		return this.mostrarid_clienteCuentaPorCobrar;
	}

	public void setMostrarid_clienteCuentaPorCobrar(Boolean mostrarid_clienteCuentaPorCobrar) {
		this.mostrarid_clienteCuentaPorCobrar= mostrarid_clienteCuentaPorCobrar;
	}

	public Boolean getActivarid_clienteCuentaPorCobrar() {
		return this.activarid_clienteCuentaPorCobrar;
	}

	public void setActivarid_clienteCuentaPorCobrar(Boolean activarid_clienteCuentaPorCobrar) {
		this.activarid_clienteCuentaPorCobrar= activarid_clienteCuentaPorCobrar;
	}

	public Boolean getCargarid_clienteCuentaPorCobrar() {
		return this.cargarid_clienteCuentaPorCobrar;
	}

	public void setCargarid_clienteCuentaPorCobrar(Boolean cargarid_clienteCuentaPorCobrar) {
		this.cargarid_clienteCuentaPorCobrar= cargarid_clienteCuentaPorCobrar;
	}

	public Border setResaltarid_transaccionCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_transaccionCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionCuentaPorCobrar() {
		return this.resaltarid_transaccionCuentaPorCobrar;
	}

	public void setResaltarid_transaccionCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_transaccionCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_transaccionCuentaPorCobrar() {
		return this.mostrarid_transaccionCuentaPorCobrar;
	}

	public void setMostrarid_transaccionCuentaPorCobrar(Boolean mostrarid_transaccionCuentaPorCobrar) {
		this.mostrarid_transaccionCuentaPorCobrar= mostrarid_transaccionCuentaPorCobrar;
	}

	public Boolean getActivarid_transaccionCuentaPorCobrar() {
		return this.activarid_transaccionCuentaPorCobrar;
	}

	public void setActivarid_transaccionCuentaPorCobrar(Boolean activarid_transaccionCuentaPorCobrar) {
		this.activarid_transaccionCuentaPorCobrar= activarid_transaccionCuentaPorCobrar;
	}

	public Boolean getCargarid_transaccionCuentaPorCobrar() {
		return this.cargarid_transaccionCuentaPorCobrar;
	}

	public void setCargarid_transaccionCuentaPorCobrar(Boolean cargarid_transaccionCuentaPorCobrar) {
		this.cargarid_transaccionCuentaPorCobrar= cargarid_transaccionCuentaPorCobrar;
	}

	public Border setResaltarid_tipo_transaccion_moduloCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloCuentaPorCobrar() {
		return this.resaltarid_tipo_transaccion_moduloCuentaPorCobrar;
	}

	public void setResaltarid_tipo_transaccion_moduloCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloCuentaPorCobrar() {
		return this.mostrarid_tipo_transaccion_moduloCuentaPorCobrar;
	}

	public void setMostrarid_tipo_transaccion_moduloCuentaPorCobrar(Boolean mostrarid_tipo_transaccion_moduloCuentaPorCobrar) {
		this.mostrarid_tipo_transaccion_moduloCuentaPorCobrar= mostrarid_tipo_transaccion_moduloCuentaPorCobrar;
	}

	public Boolean getActivarid_tipo_transaccion_moduloCuentaPorCobrar() {
		return this.activarid_tipo_transaccion_moduloCuentaPorCobrar;
	}

	public void setActivarid_tipo_transaccion_moduloCuentaPorCobrar(Boolean activarid_tipo_transaccion_moduloCuentaPorCobrar) {
		this.activarid_tipo_transaccion_moduloCuentaPorCobrar= activarid_tipo_transaccion_moduloCuentaPorCobrar;
	}

	public Boolean getCargarid_tipo_transaccion_moduloCuentaPorCobrar() {
		return this.cargarid_tipo_transaccion_moduloCuentaPorCobrar;
	}

	public void setCargarid_tipo_transaccion_moduloCuentaPorCobrar(Boolean cargarid_tipo_transaccion_moduloCuentaPorCobrar) {
		this.cargarid_tipo_transaccion_moduloCuentaPorCobrar= cargarid_tipo_transaccion_moduloCuentaPorCobrar;
	}

	public Border setResaltarid_asiento_contableCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableCuentaPorCobrar() {
		return this.resaltarid_asiento_contableCuentaPorCobrar;
	}

	public void setResaltarid_asiento_contableCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_asiento_contableCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableCuentaPorCobrar() {
		return this.mostrarid_asiento_contableCuentaPorCobrar;
	}

	public void setMostrarid_asiento_contableCuentaPorCobrar(Boolean mostrarid_asiento_contableCuentaPorCobrar) {
		this.mostrarid_asiento_contableCuentaPorCobrar= mostrarid_asiento_contableCuentaPorCobrar;
	}

	public Boolean getActivarid_asiento_contableCuentaPorCobrar() {
		return this.activarid_asiento_contableCuentaPorCobrar;
	}

	public void setActivarid_asiento_contableCuentaPorCobrar(Boolean activarid_asiento_contableCuentaPorCobrar) {
		this.activarid_asiento_contableCuentaPorCobrar= activarid_asiento_contableCuentaPorCobrar;
	}

	public Boolean getCargarid_asiento_contableCuentaPorCobrar() {
		return this.cargarid_asiento_contableCuentaPorCobrar;
	}

	public void setCargarid_asiento_contableCuentaPorCobrar(Boolean cargarid_asiento_contableCuentaPorCobrar) {
		this.cargarid_asiento_contableCuentaPorCobrar= cargarid_asiento_contableCuentaPorCobrar;
	}

	public Border setResaltarid_facturaCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarid_facturaCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaCuentaPorCobrar() {
		return this.resaltarid_facturaCuentaPorCobrar;
	}

	public void setResaltarid_facturaCuentaPorCobrar(Border borderResaltar) {
		this.resaltarid_facturaCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarid_facturaCuentaPorCobrar() {
		return this.mostrarid_facturaCuentaPorCobrar;
	}

	public void setMostrarid_facturaCuentaPorCobrar(Boolean mostrarid_facturaCuentaPorCobrar) {
		this.mostrarid_facturaCuentaPorCobrar= mostrarid_facturaCuentaPorCobrar;
	}

	public Boolean getActivarid_facturaCuentaPorCobrar() {
		return this.activarid_facturaCuentaPorCobrar;
	}

	public void setActivarid_facturaCuentaPorCobrar(Boolean activarid_facturaCuentaPorCobrar) {
		this.activarid_facturaCuentaPorCobrar= activarid_facturaCuentaPorCobrar;
	}

	public Boolean getCargarid_facturaCuentaPorCobrar() {
		return this.cargarid_facturaCuentaPorCobrar;
	}

	public void setCargarid_facturaCuentaPorCobrar(Boolean cargarid_facturaCuentaPorCobrar) {
		this.cargarid_facturaCuentaPorCobrar= cargarid_facturaCuentaPorCobrar;
	}

	public Border setResaltarfechaCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarfechaCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCuentaPorCobrar() {
		return this.resaltarfechaCuentaPorCobrar;
	}

	public void setResaltarfechaCuentaPorCobrar(Border borderResaltar) {
		this.resaltarfechaCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarfechaCuentaPorCobrar() {
		return this.mostrarfechaCuentaPorCobrar;
	}

	public void setMostrarfechaCuentaPorCobrar(Boolean mostrarfechaCuentaPorCobrar) {
		this.mostrarfechaCuentaPorCobrar= mostrarfechaCuentaPorCobrar;
	}

	public Boolean getActivarfechaCuentaPorCobrar() {
		return this.activarfechaCuentaPorCobrar;
	}

	public void setActivarfechaCuentaPorCobrar(Boolean activarfechaCuentaPorCobrar) {
		this.activarfechaCuentaPorCobrar= activarfechaCuentaPorCobrar;
	}

	public Border setResaltarmontoCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarmontoCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoCuentaPorCobrar() {
		return this.resaltarmontoCuentaPorCobrar;
	}

	public void setResaltarmontoCuentaPorCobrar(Border borderResaltar) {
		this.resaltarmontoCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarmontoCuentaPorCobrar() {
		return this.mostrarmontoCuentaPorCobrar;
	}

	public void setMostrarmontoCuentaPorCobrar(Boolean mostrarmontoCuentaPorCobrar) {
		this.mostrarmontoCuentaPorCobrar= mostrarmontoCuentaPorCobrar;
	}

	public Boolean getActivarmontoCuentaPorCobrar() {
		return this.activarmontoCuentaPorCobrar;
	}

	public void setActivarmontoCuentaPorCobrar(Boolean activarmontoCuentaPorCobrar) {
		this.activarmontoCuentaPorCobrar= activarmontoCuentaPorCobrar;
	}

	public Border setResaltarnumero_comprobanteCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteCuentaPorCobrar() {
		return this.resaltarnumero_comprobanteCuentaPorCobrar;
	}

	public void setResaltarnumero_comprobanteCuentaPorCobrar(Border borderResaltar) {
		this.resaltarnumero_comprobanteCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteCuentaPorCobrar() {
		return this.mostrarnumero_comprobanteCuentaPorCobrar;
	}

	public void setMostrarnumero_comprobanteCuentaPorCobrar(Boolean mostrarnumero_comprobanteCuentaPorCobrar) {
		this.mostrarnumero_comprobanteCuentaPorCobrar= mostrarnumero_comprobanteCuentaPorCobrar;
	}

	public Boolean getActivarnumero_comprobanteCuentaPorCobrar() {
		return this.activarnumero_comprobanteCuentaPorCobrar;
	}

	public void setActivarnumero_comprobanteCuentaPorCobrar(Boolean activarnumero_comprobanteCuentaPorCobrar) {
		this.activarnumero_comprobanteCuentaPorCobrar= activarnumero_comprobanteCuentaPorCobrar;
	}

	public Border setResaltardebitoCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltardebitoCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebitoCuentaPorCobrar() {
		return this.resaltardebitoCuentaPorCobrar;
	}

	public void setResaltardebitoCuentaPorCobrar(Border borderResaltar) {
		this.resaltardebitoCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrardebitoCuentaPorCobrar() {
		return this.mostrardebitoCuentaPorCobrar;
	}

	public void setMostrardebitoCuentaPorCobrar(Boolean mostrardebitoCuentaPorCobrar) {
		this.mostrardebitoCuentaPorCobrar= mostrardebitoCuentaPorCobrar;
	}

	public Boolean getActivardebitoCuentaPorCobrar() {
		return this.activardebitoCuentaPorCobrar;
	}

	public void setActivardebitoCuentaPorCobrar(Boolean activardebitoCuentaPorCobrar) {
		this.activardebitoCuentaPorCobrar= activardebitoCuentaPorCobrar;
	}

	public Border setResaltarcreditoCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltarcreditoCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcreditoCuentaPorCobrar() {
		return this.resaltarcreditoCuentaPorCobrar;
	}

	public void setResaltarcreditoCuentaPorCobrar(Border borderResaltar) {
		this.resaltarcreditoCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrarcreditoCuentaPorCobrar() {
		return this.mostrarcreditoCuentaPorCobrar;
	}

	public void setMostrarcreditoCuentaPorCobrar(Boolean mostrarcreditoCuentaPorCobrar) {
		this.mostrarcreditoCuentaPorCobrar= mostrarcreditoCuentaPorCobrar;
	}

	public Boolean getActivarcreditoCuentaPorCobrar() {
		return this.activarcreditoCuentaPorCobrar;
	}

	public void setActivarcreditoCuentaPorCobrar(Boolean activarcreditoCuentaPorCobrar) {
		this.activarcreditoCuentaPorCobrar= activarcreditoCuentaPorCobrar;
	}

	public Border setResaltardetalleCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentaporcobrarBeanSwingJInternalFrame.jTtoolBarCuentaPorCobrar.setBorder(borderResaltar);
		
		this.resaltardetalleCuentaPorCobrar= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleCuentaPorCobrar() {
		return this.resaltardetalleCuentaPorCobrar;
	}

	public void setResaltardetalleCuentaPorCobrar(Border borderResaltar) {
		this.resaltardetalleCuentaPorCobrar= borderResaltar;
	}

	public Boolean getMostrardetalleCuentaPorCobrar() {
		return this.mostrardetalleCuentaPorCobrar;
	}

	public void setMostrardetalleCuentaPorCobrar(Boolean mostrardetalleCuentaPorCobrar) {
		this.mostrardetalleCuentaPorCobrar= mostrardetalleCuentaPorCobrar;
	}

	public Boolean getActivardetalleCuentaPorCobrar() {
		return this.activardetalleCuentaPorCobrar;
	}

	public void setActivardetalleCuentaPorCobrar(Boolean activardetalleCuentaPorCobrar) {
		this.activardetalleCuentaPorCobrar= activardetalleCuentaPorCobrar;
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
		
		
		this.setMostraridCuentaPorCobrar(esInicial);
		this.setMostrarid_empresaCuentaPorCobrar(esInicial);
		this.setMostrarid_sucursalCuentaPorCobrar(esInicial);
		this.setMostrarid_moduloCuentaPorCobrar(esInicial);
		this.setMostrarid_ejercicioCuentaPorCobrar(esInicial);
		this.setMostrarid_monedaCuentaPorCobrar(esInicial);
		this.setMostrarid_clienteCuentaPorCobrar(esInicial);
		this.setMostrarid_transaccionCuentaPorCobrar(esInicial);
		this.setMostrarid_tipo_transaccion_moduloCuentaPorCobrar(esInicial);
		this.setMostrarid_asiento_contableCuentaPorCobrar(esInicial);
		this.setMostrarid_facturaCuentaPorCobrar(esInicial);
		this.setMostrarfechaCuentaPorCobrar(esInicial);
		this.setMostrarmontoCuentaPorCobrar(esInicial);
		this.setMostrarnumero_comprobanteCuentaPorCobrar(esInicial);
		this.setMostrardebitoCuentaPorCobrar(esInicial);
		this.setMostrarcreditoCuentaPorCobrar(esInicial);
		this.setMostrardetalleCuentaPorCobrar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.ID)) {
				this.setMostraridCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.FECHA)) {
				this.setMostrarfechaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.MONTO)) {
				this.setMostrarmontoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.DEBITO)) {
				this.setMostrardebitoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.CREDITO)) {
				this.setMostrarcreditoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.DETALLE)) {
				this.setMostrardetalleCuentaPorCobrar(esAsigna);
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
		
		
		this.setActivaridCuentaPorCobrar(esInicial);
		this.setActivarid_empresaCuentaPorCobrar(esInicial);
		this.setActivarid_sucursalCuentaPorCobrar(esInicial);
		this.setActivarid_moduloCuentaPorCobrar(esInicial);
		this.setActivarid_ejercicioCuentaPorCobrar(esInicial);
		this.setActivarid_monedaCuentaPorCobrar(esInicial);
		this.setActivarid_clienteCuentaPorCobrar(esInicial);
		this.setActivarid_transaccionCuentaPorCobrar(esInicial);
		this.setActivarid_tipo_transaccion_moduloCuentaPorCobrar(esInicial);
		this.setActivarid_asiento_contableCuentaPorCobrar(esInicial);
		this.setActivarid_facturaCuentaPorCobrar(esInicial);
		this.setActivarfechaCuentaPorCobrar(esInicial);
		this.setActivarmontoCuentaPorCobrar(esInicial);
		this.setActivarnumero_comprobanteCuentaPorCobrar(esInicial);
		this.setActivardebitoCuentaPorCobrar(esInicial);
		this.setActivarcreditoCuentaPorCobrar(esInicial);
		this.setActivardetalleCuentaPorCobrar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.ID)) {
				this.setActivaridCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.FECHA)) {
				this.setActivarfechaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.MONTO)) {
				this.setActivarmontoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.DEBITO)) {
				this.setActivardebitoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.CREDITO)) {
				this.setActivarcreditoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.DETALLE)) {
				this.setActivardetalleCuentaPorCobrar(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaPorCobrar(esInicial);
		this.setResaltarid_empresaCuentaPorCobrar(esInicial);
		this.setResaltarid_sucursalCuentaPorCobrar(esInicial);
		this.setResaltarid_moduloCuentaPorCobrar(esInicial);
		this.setResaltarid_ejercicioCuentaPorCobrar(esInicial);
		this.setResaltarid_monedaCuentaPorCobrar(esInicial);
		this.setResaltarid_clienteCuentaPorCobrar(esInicial);
		this.setResaltarid_transaccionCuentaPorCobrar(esInicial);
		this.setResaltarid_tipo_transaccion_moduloCuentaPorCobrar(esInicial);
		this.setResaltarid_asiento_contableCuentaPorCobrar(esInicial);
		this.setResaltarid_facturaCuentaPorCobrar(esInicial);
		this.setResaltarfechaCuentaPorCobrar(esInicial);
		this.setResaltarmontoCuentaPorCobrar(esInicial);
		this.setResaltarnumero_comprobanteCuentaPorCobrar(esInicial);
		this.setResaltardebitoCuentaPorCobrar(esInicial);
		this.setResaltarcreditoCuentaPorCobrar(esInicial);
		this.setResaltardetalleCuentaPorCobrar(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.ID)) {
				this.setResaltaridCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.FECHA)) {
				this.setResaltarfechaCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.MONTO)) {
				this.setResaltarmontoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.DEBITO)) {
				this.setResaltardebitoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.CREDITO)) {
				this.setResaltarcreditoCuentaPorCobrar(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaPorCobrarConstantesFunciones.DETALLE)) {
				this.setResaltardetalleCuentaPorCobrar(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdAsientoContableCuentaPorCobrar() {
		return this.mostrarFK_IdAsientoContableCuentaPorCobrar;
	}

	public void setMostrarFK_IdAsientoContableCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdClienteCuentaPorCobrar() {
		return this.mostrarFK_IdClienteCuentaPorCobrar;
	}

	public void setMostrarFK_IdClienteCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdEjercicioCuentaPorCobrar() {
		return this.mostrarFK_IdEjercicioCuentaPorCobrar;
	}

	public void setMostrarFK_IdEjercicioCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdEmpresaCuentaPorCobrar() {
		return this.mostrarFK_IdEmpresaCuentaPorCobrar;
	}

	public void setMostrarFK_IdEmpresaCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdFacturaCuentaPorCobrar() {
		return this.mostrarFK_IdFacturaCuentaPorCobrar;
	}

	public void setMostrarFK_IdFacturaCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdModuloCuentaPorCobrar() {
		return this.mostrarFK_IdModuloCuentaPorCobrar;
	}

	public void setMostrarFK_IdModuloCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdMonedaCuentaPorCobrar() {
		return this.mostrarFK_IdMonedaCuentaPorCobrar;
	}

	public void setMostrarFK_IdMonedaCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdSucursalCuentaPorCobrar() {
		return this.mostrarFK_IdSucursalCuentaPorCobrar;
	}

	public void setMostrarFK_IdSucursalCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloCuentaPorCobrar() {
		return this.mostrarFK_IdTipoTransaccionModuloCuentaPorCobrar;
	}

	public void setMostrarFK_IdTipoTransaccionModuloCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloCuentaPorCobrar= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionCuentaPorCobrar=true;

	public Boolean getMostrarFK_IdTransaccionCuentaPorCobrar() {
		return this.mostrarFK_IdTransaccionCuentaPorCobrar;
	}

	public void setMostrarFK_IdTransaccionCuentaPorCobrar(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionCuentaPorCobrar= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableCuentaPorCobrar=true;

	public Boolean getActivarFK_IdAsientoContableCuentaPorCobrar() {
		return this.activarFK_IdAsientoContableCuentaPorCobrar;
	}

	public void setActivarFK_IdAsientoContableCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteCuentaPorCobrar=true;

	public Boolean getActivarFK_IdClienteCuentaPorCobrar() {
		return this.activarFK_IdClienteCuentaPorCobrar;
	}

	public void setActivarFK_IdClienteCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdClienteCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioCuentaPorCobrar=true;

	public Boolean getActivarFK_IdEjercicioCuentaPorCobrar() {
		return this.activarFK_IdEjercicioCuentaPorCobrar;
	}

	public void setActivarFK_IdEjercicioCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCuentaPorCobrar=true;

	public Boolean getActivarFK_IdEmpresaCuentaPorCobrar() {
		return this.activarFK_IdEmpresaCuentaPorCobrar;
	}

	public void setActivarFK_IdEmpresaCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaCuentaPorCobrar=true;

	public Boolean getActivarFK_IdFacturaCuentaPorCobrar() {
		return this.activarFK_IdFacturaCuentaPorCobrar;
	}

	public void setActivarFK_IdFacturaCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloCuentaPorCobrar=true;

	public Boolean getActivarFK_IdModuloCuentaPorCobrar() {
		return this.activarFK_IdModuloCuentaPorCobrar;
	}

	public void setActivarFK_IdModuloCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdModuloCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaCuentaPorCobrar=true;

	public Boolean getActivarFK_IdMonedaCuentaPorCobrar() {
		return this.activarFK_IdMonedaCuentaPorCobrar;
	}

	public void setActivarFK_IdMonedaCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCuentaPorCobrar=true;

	public Boolean getActivarFK_IdSucursalCuentaPorCobrar() {
		return this.activarFK_IdSucursalCuentaPorCobrar;
	}

	public void setActivarFK_IdSucursalCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloCuentaPorCobrar=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloCuentaPorCobrar() {
		return this.activarFK_IdTipoTransaccionModuloCuentaPorCobrar;
	}

	public void setActivarFK_IdTipoTransaccionModuloCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloCuentaPorCobrar= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionCuentaPorCobrar=true;

	public Boolean getActivarFK_IdTransaccionCuentaPorCobrar() {
		return this.activarFK_IdTransaccionCuentaPorCobrar;
	}

	public void setActivarFK_IdTransaccionCuentaPorCobrar(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionCuentaPorCobrar= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableCuentaPorCobrar=null;

	public Border getResaltarFK_IdAsientoContableCuentaPorCobrar() {
		return this.resaltarFK_IdAsientoContableCuentaPorCobrar;
	}

	public void setResaltarFK_IdAsientoContableCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdClienteCuentaPorCobrar=null;

	public Border getResaltarFK_IdClienteCuentaPorCobrar() {
		return this.resaltarFK_IdClienteCuentaPorCobrar;
	}

	public void setResaltarFK_IdClienteCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdClienteCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdClienteCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioCuentaPorCobrar=null;

	public Border getResaltarFK_IdEjercicioCuentaPorCobrar() {
		return this.resaltarFK_IdEjercicioCuentaPorCobrar;
	}

	public void setResaltarFK_IdEjercicioCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdEjercicioCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCuentaPorCobrar=null;

	public Border getResaltarFK_IdEmpresaCuentaPorCobrar() {
		return this.resaltarFK_IdEmpresaCuentaPorCobrar;
	}

	public void setResaltarFK_IdEmpresaCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdFacturaCuentaPorCobrar=null;

	public Border getResaltarFK_IdFacturaCuentaPorCobrar() {
		return this.resaltarFK_IdFacturaCuentaPorCobrar;
	}

	public void setResaltarFK_IdFacturaCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdFacturaCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdFacturaCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdModuloCuentaPorCobrar=null;

	public Border getResaltarFK_IdModuloCuentaPorCobrar() {
		return this.resaltarFK_IdModuloCuentaPorCobrar;
	}

	public void setResaltarFK_IdModuloCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdModuloCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdModuloCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdMonedaCuentaPorCobrar=null;

	public Border getResaltarFK_IdMonedaCuentaPorCobrar() {
		return this.resaltarFK_IdMonedaCuentaPorCobrar;
	}

	public void setResaltarFK_IdMonedaCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdMonedaCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdMonedaCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCuentaPorCobrar=null;

	public Border getResaltarFK_IdSucursalCuentaPorCobrar() {
		return this.resaltarFK_IdSucursalCuentaPorCobrar;
	}

	public void setResaltarFK_IdSucursalCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdSucursalCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloCuentaPorCobrar=null;

	public Border getResaltarFK_IdTipoTransaccionModuloCuentaPorCobrar() {
		return this.resaltarFK_IdTipoTransaccionModuloCuentaPorCobrar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloCuentaPorCobrar= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionCuentaPorCobrar=null;

	public Border getResaltarFK_IdTransaccionCuentaPorCobrar() {
		return this.resaltarFK_IdTransaccionCuentaPorCobrar;
	}

	public void setResaltarFK_IdTransaccionCuentaPorCobrar(Border borderResaltar) {
		this.resaltarFK_IdTransaccionCuentaPorCobrar= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionCuentaPorCobrar(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaPorCobrarBeanSwingJInternalFrame cuentaporcobrarBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionCuentaPorCobrar= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}