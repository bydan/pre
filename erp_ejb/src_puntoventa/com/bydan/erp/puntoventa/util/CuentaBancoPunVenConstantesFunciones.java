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


import com.bydan.erp.puntoventa.util.CuentaBancoPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.CuentaBancoPunVenParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CuentaBancoPunVenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CuentaBancoPunVenConstantesFunciones extends CuentaBancoPunVenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaBancoPunVen";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaBancoPunVen"+CuentaBancoPunVenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaBancoPunVenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaBancoPunVenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaBancoPunVenConstantesFunciones.SCHEMA+"_"+CuentaBancoPunVenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaBancoPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaBancoPunVenConstantesFunciones.SCHEMA+"_"+CuentaBancoPunVenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaBancoPunVenConstantesFunciones.SCHEMA+"_"+CuentaBancoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaBancoPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaBancoPunVenConstantesFunciones.SCHEMA+"_"+CuentaBancoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaBancoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaBancoPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaBancoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaBancoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaBancoPunVenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaBancoPunVenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaBancoPunVenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaBancoPunVenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaBancoPunVenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaBancoPunVenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Bancoes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cuenta Banco";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Banco Pun Ven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaBancoPunVen";
	public static final String OBJECTNAME="cuentabancopunven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="cuenta_banco_pun_ven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentabancopunven from "+CuentaBancoPunVenConstantesFunciones.SPERSISTENCENAME+" cuentabancopunven";
	public static String QUERYSELECTNATIVE="select "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".version_row,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_empresa,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_sucursal,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_banco,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_cliente,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".codigo,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".nombre from "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME;//+" as "+CuentaBancoPunVenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaBancoPunVenConstantesFuncionesAdditional cuentabancopunvenConstantesFuncionesAdditional=null;
	
	public CuentaBancoPunVenConstantesFuncionesAdditional getCuentaBancoPunVenConstantesFuncionesAdditional() {
		return this.cuentabancopunvenConstantesFuncionesAdditional;
	}
	
	public void setCuentaBancoPunVenConstantesFuncionesAdditional(CuentaBancoPunVenConstantesFuncionesAdditional cuentabancopunvenConstantesFuncionesAdditional) {
		try {
			this.cuentabancopunvenConstantesFuncionesAdditional=cuentabancopunvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBANCO= "id_banco";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCuentaBancoPunVenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaBancoPunVenConstantesFunciones.IDEMPRESA)) {sLabelColumna=CuentaBancoPunVenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CuentaBancoPunVenConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CuentaBancoPunVenConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CuentaBancoPunVenConstantesFunciones.IDBANCO)) {sLabelColumna=CuentaBancoPunVenConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(CuentaBancoPunVenConstantesFunciones.IDCLIENTE)) {sLabelColumna=CuentaBancoPunVenConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CuentaBancoPunVenConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CuentaBancoPunVenConstantesFunciones.CODIGO)) {sLabelColumna=CuentaBancoPunVenConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CuentaBancoPunVenConstantesFunciones.NOMBRE)) {sLabelColumna=CuentaBancoPunVenConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getCuentaBancoPunVenDescripcion(CuentaBancoPunVen cuentabancopunven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentabancopunven !=null/* && cuentabancopunven.getId()!=0*/) {
			sDescripcion=cuentabancopunven.getcodigo();//cuentabancopunvencuentabancopunven.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaBancoPunVenDescripcionDetallado(CuentaBancoPunVen cuentabancopunven) {
		String sDescripcion="";
			
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.ID+"=";
		sDescripcion+=cuentabancopunven.getId().toString()+",";
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentabancopunven.getVersionRow().toString()+",";
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cuentabancopunven.getid_empresa().toString()+",";
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cuentabancopunven.getid_sucursal().toString()+",";
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.IDBANCO+"=";
		sDescripcion+=cuentabancopunven.getid_banco().toString()+",";
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=cuentabancopunven.getid_cliente().toString()+",";
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cuentabancopunven.getid_cuenta_contable().toString()+",";
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.CODIGO+"=";
		sDescripcion+=cuentabancopunven.getcodigo()+",";
		sDescripcion+=CuentaBancoPunVenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cuentabancopunven.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaBancoPunVenDescripcion(CuentaBancoPunVen cuentabancopunven,String sValor) throws Exception {			
		if(cuentabancopunven !=null) {
			cuentabancopunven.setcodigo(sValor);;//cuentabancopunvencuentabancopunven.getcodigo().trim();
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentabancopunven.setcodigo(cuentabancopunven.getcodigo().trim());
		cuentabancopunven.setnombre(cuentabancopunven.getnombre().trim());
	}
	
	public static void quitarEspaciosCuentaBancoPunVens(List<CuentaBancoPunVen> cuentabancopunvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaBancoPunVen cuentabancopunven: cuentabancopunvens) {
			cuentabancopunven.setcodigo(cuentabancopunven.getcodigo().trim());
			cuentabancopunven.setnombre(cuentabancopunven.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentabancopunven.getConCambioAuxiliar()) {
			cuentabancopunven.setIsDeleted(cuentabancopunven.getIsDeletedAuxiliar());	
			cuentabancopunven.setIsNew(cuentabancopunven.getIsNewAuxiliar());	
			cuentabancopunven.setIsChanged(cuentabancopunven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentabancopunven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentabancopunven.setIsDeletedAuxiliar(false);	
			cuentabancopunven.setIsNewAuxiliar(false);	
			cuentabancopunven.setIsChangedAuxiliar(false);
			
			cuentabancopunven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaBancoPunVens(List<CuentaBancoPunVen> cuentabancopunvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaBancoPunVen cuentabancopunven : cuentabancopunvens) {
			if(conAsignarBase && cuentabancopunven.getConCambioAuxiliar()) {
				cuentabancopunven.setIsDeleted(cuentabancopunven.getIsDeletedAuxiliar());	
				cuentabancopunven.setIsNew(cuentabancopunven.getIsNewAuxiliar());	
				cuentabancopunven.setIsChanged(cuentabancopunven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentabancopunven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentabancopunven.setIsDeletedAuxiliar(false);	
				cuentabancopunven.setIsNewAuxiliar(false);	
				cuentabancopunven.setIsChangedAuxiliar(false);
				
				cuentabancopunven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCuentaBancoPunVens(List<CuentaBancoPunVen> cuentabancopunvens,Boolean conEnteros) throws Exception  {
		
		for(CuentaBancoPunVen cuentabancopunven: cuentabancopunvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaBancoPunVen(List<CuentaBancoPunVen> cuentabancopunvens,CuentaBancoPunVen cuentabancopunvenAux) throws Exception  {
		CuentaBancoPunVenConstantesFunciones.InicializarValoresCuentaBancoPunVen(cuentabancopunvenAux,true);
		
		for(CuentaBancoPunVen cuentabancopunven: cuentabancopunvens) {
			if(cuentabancopunven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaBancoPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaBancoPunVenConstantesFunciones.getArrayColumnasGlobalesCuentaBancoPunVen(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaBancoPunVen(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaBancoPunVenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaBancoPunVenConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaBancoPunVenConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaBancoPunVenConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaBancoPunVen(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaBancoPunVen> cuentabancopunvens,CuentaBancoPunVen cuentabancopunven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaBancoPunVen cuentabancopunvenAux: cuentabancopunvens) {
			if(cuentabancopunvenAux!=null && cuentabancopunven!=null) {
				if((cuentabancopunvenAux.getId()==null && cuentabancopunven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentabancopunvenAux.getId()!=null && cuentabancopunven.getId()!=null){
					if(cuentabancopunvenAux.getId().equals(cuentabancopunven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaBancoPunVen(List<CuentaBancoPunVen> cuentabancopunvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CuentaBancoPunVen cuentabancopunven: cuentabancopunvens) {			
			if(cuentabancopunven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaBancoPunVen() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_ID, CuentaBancoPunVenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_VERSIONROW, CuentaBancoPunVenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_IDEMPRESA, CuentaBancoPunVenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_IDSUCURSAL, CuentaBancoPunVenConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_IDBANCO, CuentaBancoPunVenConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_IDCLIENTE, CuentaBancoPunVenConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_IDCUENTACONTABLE, CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_CODIGO, CuentaBancoPunVenConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoPunVenConstantesFunciones.LABEL_NOMBRE, CuentaBancoPunVenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaBancoPunVen() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoPunVenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaBancoPunVen() throws Exception  {
		return CuentaBancoPunVenConstantesFunciones.getTiposSeleccionarCuentaBancoPunVen(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaBancoPunVen(Boolean conFk) throws Exception  {
		return CuentaBancoPunVenConstantesFunciones.getTiposSeleccionarCuentaBancoPunVen(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaBancoPunVen(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoPunVenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CuentaBancoPunVenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoPunVenConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CuentaBancoPunVenConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoPunVenConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(CuentaBancoPunVenConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoPunVenConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(CuentaBancoPunVenConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoPunVenConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CuentaBancoPunVenConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoPunVenConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CuentaBancoPunVenConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoPunVenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CuentaBancoPunVenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaBancoPunVen(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunvenAux) throws Exception {
		
			cuentabancopunvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentabancopunvenAux.getEmpresa()));
			cuentabancopunvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cuentabancopunvenAux.getSucursal()));
			cuentabancopunvenAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(cuentabancopunvenAux.getBanco()));
			cuentabancopunvenAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cuentabancopunvenAux.getCliente()));
			cuentabancopunvenAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentabancopunvenAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaBancoPunVen(List<CuentaBancoPunVen> cuentabancopunvensTemp) throws Exception {
		for(CuentaBancoPunVen cuentabancopunvenAux:cuentabancopunvensTemp) {
			
			cuentabancopunvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentabancopunvenAux.getEmpresa()));
			cuentabancopunvenAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cuentabancopunvenAux.getSucursal()));
			cuentabancopunvenAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(cuentabancopunvenAux.getBanco()));
			cuentabancopunvenAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(cuentabancopunvenAux.getCliente()));
			cuentabancopunvenAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentabancopunvenAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaBancoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(CuentaContable.class));
				
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaBancoPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaBancoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaBancoPunVenConstantesFunciones.getClassesRelationshipsOfCuentaBancoPunVen(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaBancoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(FormaPagoPuntoVenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaBancoPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaBancoPunVenConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaBancoPunVen(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaBancoPunVen(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(FormaPagoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormaPagoPuntoVenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

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
	public static void actualizarLista(CuentaBancoPunVen cuentabancopunven,List<CuentaBancoPunVen> cuentabancopunvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaBancoPunVen cuentabancopunvenEncontrado=null;
			
			for(CuentaBancoPunVen cuentabancopunvenLocal:cuentabancopunvens) {
				if(cuentabancopunvenLocal.getId().equals(cuentabancopunven.getId())) {
					cuentabancopunvenEncontrado=cuentabancopunvenLocal;
					
					cuentabancopunvenLocal.setIsChanged(cuentabancopunven.getIsChanged());
					cuentabancopunvenLocal.setIsNew(cuentabancopunven.getIsNew());
					cuentabancopunvenLocal.setIsDeleted(cuentabancopunven.getIsDeleted());
					
					cuentabancopunvenLocal.setGeneralEntityOriginal(cuentabancopunven.getGeneralEntityOriginal());
					
					cuentabancopunvenLocal.setId(cuentabancopunven.getId());	
					cuentabancopunvenLocal.setVersionRow(cuentabancopunven.getVersionRow());	
					cuentabancopunvenLocal.setid_empresa(cuentabancopunven.getid_empresa());	
					cuentabancopunvenLocal.setid_sucursal(cuentabancopunven.getid_sucursal());	
					cuentabancopunvenLocal.setid_banco(cuentabancopunven.getid_banco());	
					cuentabancopunvenLocal.setid_cliente(cuentabancopunven.getid_cliente());	
					cuentabancopunvenLocal.setid_cuenta_contable(cuentabancopunven.getid_cuenta_contable());	
					cuentabancopunvenLocal.setcodigo(cuentabancopunven.getcodigo());	
					cuentabancopunvenLocal.setnombre(cuentabancopunven.getnombre());	
					
					
					cuentabancopunvenLocal.setFormaPagoPuntoVentas(cuentabancopunven.getFormaPagoPuntoVentas());
					
					existe=true;
					break;
				}
			}
			
			if(!cuentabancopunven.getIsDeleted()) {
				if(!existe) {
					cuentabancopunvens.add(cuentabancopunven);
				}
			} else {
				if(cuentabancopunvenEncontrado!=null && permiteQuitar)  {
					cuentabancopunvens.remove(cuentabancopunvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaBancoPunVen cuentabancopunven,List<CuentaBancoPunVen> cuentabancopunvens) throws Exception {
		try	{			
			for(CuentaBancoPunVen cuentabancopunvenLocal:cuentabancopunvens) {
				if(cuentabancopunvenLocal.getId().equals(cuentabancopunven.getId())) {
					cuentabancopunvenLocal.setIsSelected(cuentabancopunven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaBancoPunVen(List<CuentaBancoPunVen> cuentabancopunvensAux) throws Exception {
		//this.cuentabancopunvensAux=cuentabancopunvensAux;
		
		for(CuentaBancoPunVen cuentabancopunvenAux:cuentabancopunvensAux) {
			if(cuentabancopunvenAux.getIsChanged()) {
				cuentabancopunvenAux.setIsChanged(false);
			}		
			
			if(cuentabancopunvenAux.getIsNew()) {
				cuentabancopunvenAux.setIsNew(false);
			}	
			
			if(cuentabancopunvenAux.getIsDeleted()) {
				cuentabancopunvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunvenAux) throws Exception {
		//this.cuentabancopunvenAux=cuentabancopunvenAux;
		
			if(cuentabancopunvenAux.getIsChanged()) {
				cuentabancopunvenAux.setIsChanged(false);
			}		
			
			if(cuentabancopunvenAux.getIsNew()) {
				cuentabancopunvenAux.setIsNew(false);
			}	
			
			if(cuentabancopunvenAux.getIsDeleted()) {
				cuentabancopunvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaBancoPunVen cuentabancopunvenAsignar,CuentaBancoPunVen cuentabancopunven) throws Exception {
		cuentabancopunvenAsignar.setId(cuentabancopunven.getId());	
		cuentabancopunvenAsignar.setVersionRow(cuentabancopunven.getVersionRow());	
		cuentabancopunvenAsignar.setid_empresa(cuentabancopunven.getid_empresa());
		cuentabancopunvenAsignar.setempresa_descripcion(cuentabancopunven.getempresa_descripcion());	
		cuentabancopunvenAsignar.setid_sucursal(cuentabancopunven.getid_sucursal());
		cuentabancopunvenAsignar.setsucursal_descripcion(cuentabancopunven.getsucursal_descripcion());	
		cuentabancopunvenAsignar.setid_banco(cuentabancopunven.getid_banco());
		cuentabancopunvenAsignar.setbanco_descripcion(cuentabancopunven.getbanco_descripcion());	
		cuentabancopunvenAsignar.setid_cliente(cuentabancopunven.getid_cliente());
		cuentabancopunvenAsignar.setcliente_descripcion(cuentabancopunven.getcliente_descripcion());	
		cuentabancopunvenAsignar.setid_cuenta_contable(cuentabancopunven.getid_cuenta_contable());
		cuentabancopunvenAsignar.setcuentacontable_descripcion(cuentabancopunven.getcuentacontable_descripcion());	
		cuentabancopunvenAsignar.setcodigo(cuentabancopunven.getcodigo());	
		cuentabancopunvenAsignar.setnombre(cuentabancopunven.getnombre());	
	}
	
	public static void inicializarCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunven) throws Exception {
		try {
				cuentabancopunven.setId(0L);	
					
				cuentabancopunven.setid_empresa(-1L);	
				cuentabancopunven.setid_sucursal(-1L);	
				cuentabancopunven.setid_banco(-1L);	
				cuentabancopunven.setid_cliente(-1L);	
				cuentabancopunven.setid_cuenta_contable(-1L);	
				cuentabancopunven.setcodigo("");	
				cuentabancopunven.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaBancoPunVen(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoPunVenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoPunVenConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoPunVenConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoPunVenConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoPunVenConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoPunVenConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoPunVenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaBancoPunVen(String sTipo,Row row,Workbook workbook,CuentaBancoPunVen cuentabancopunven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabancopunven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabancopunven.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabancopunven.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabancopunven.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabancopunven.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabancopunven.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabancopunven.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaBancoPunVen=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaBancoPunVen() {
		return this.sFinalQueryCuentaBancoPunVen;
	}
	
	public void setsFinalQueryCuentaBancoPunVen(String sFinalQueryCuentaBancoPunVen) {
		this.sFinalQueryCuentaBancoPunVen= sFinalQueryCuentaBancoPunVen;
	}
	
	public Border resaltarSeleccionarCuentaBancoPunVen=null;
	
	public Border setResaltarSeleccionarCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaBancoPunVen= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaBancoPunVen() {
		return this.resaltarSeleccionarCuentaBancoPunVen;
	}
	
	public void setResaltarSeleccionarCuentaBancoPunVen(Border borderResaltarSeleccionarCuentaBancoPunVen) {
		this.resaltarSeleccionarCuentaBancoPunVen= borderResaltarSeleccionarCuentaBancoPunVen;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaBancoPunVen=null;
	public Boolean mostraridCuentaBancoPunVen=true;
	public Boolean activaridCuentaBancoPunVen=true;

	public Border resaltarid_empresaCuentaBancoPunVen=null;
	public Boolean mostrarid_empresaCuentaBancoPunVen=true;
	public Boolean activarid_empresaCuentaBancoPunVen=true;
	public Boolean cargarid_empresaCuentaBancoPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCuentaBancoPunVen=false;//ConEventDepend=true

	public Border resaltarid_sucursalCuentaBancoPunVen=null;
	public Boolean mostrarid_sucursalCuentaBancoPunVen=true;
	public Boolean activarid_sucursalCuentaBancoPunVen=true;
	public Boolean cargarid_sucursalCuentaBancoPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCuentaBancoPunVen=false;//ConEventDepend=true

	public Border resaltarid_bancoCuentaBancoPunVen=null;
	public Boolean mostrarid_bancoCuentaBancoPunVen=true;
	public Boolean activarid_bancoCuentaBancoPunVen=true;
	public Boolean cargarid_bancoCuentaBancoPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoCuentaBancoPunVen=false;//ConEventDepend=true

	public Border resaltarid_clienteCuentaBancoPunVen=null;
	public Boolean mostrarid_clienteCuentaBancoPunVen=true;
	public Boolean activarid_clienteCuentaBancoPunVen=true;
	public Boolean cargarid_clienteCuentaBancoPunVen=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteCuentaBancoPunVen=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableCuentaBancoPunVen=null;
	public Boolean mostrarid_cuenta_contableCuentaBancoPunVen=true;
	public Boolean activarid_cuenta_contableCuentaBancoPunVen=true;
	public Boolean cargarid_cuenta_contableCuentaBancoPunVen=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCuentaBancoPunVen=false;//ConEventDepend=true

	public Border resaltarcodigoCuentaBancoPunVen=null;
	public Boolean mostrarcodigoCuentaBancoPunVen=true;
	public Boolean activarcodigoCuentaBancoPunVen=true;

	public Border resaltarnombreCuentaBancoPunVen=null;
	public Boolean mostrarnombreCuentaBancoPunVen=true;
	public Boolean activarnombreCuentaBancoPunVen=true;

	
	

	public Border setResaltaridCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltaridCuentaBancoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaBancoPunVen() {
		return this.resaltaridCuentaBancoPunVen;
	}

	public void setResaltaridCuentaBancoPunVen(Border borderResaltar) {
		this.resaltaridCuentaBancoPunVen= borderResaltar;
	}

	public Boolean getMostraridCuentaBancoPunVen() {
		return this.mostraridCuentaBancoPunVen;
	}

	public void setMostraridCuentaBancoPunVen(Boolean mostraridCuentaBancoPunVen) {
		this.mostraridCuentaBancoPunVen= mostraridCuentaBancoPunVen;
	}

	public Boolean getActivaridCuentaBancoPunVen() {
		return this.activaridCuentaBancoPunVen;
	}

	public void setActivaridCuentaBancoPunVen(Boolean activaridCuentaBancoPunVen) {
		this.activaridCuentaBancoPunVen= activaridCuentaBancoPunVen;
	}

	public Border setResaltarid_empresaCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltarid_empresaCuentaBancoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCuentaBancoPunVen() {
		return this.resaltarid_empresaCuentaBancoPunVen;
	}

	public void setResaltarid_empresaCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarid_empresaCuentaBancoPunVen= borderResaltar;
	}

	public Boolean getMostrarid_empresaCuentaBancoPunVen() {
		return this.mostrarid_empresaCuentaBancoPunVen;
	}

	public void setMostrarid_empresaCuentaBancoPunVen(Boolean mostrarid_empresaCuentaBancoPunVen) {
		this.mostrarid_empresaCuentaBancoPunVen= mostrarid_empresaCuentaBancoPunVen;
	}

	public Boolean getActivarid_empresaCuentaBancoPunVen() {
		return this.activarid_empresaCuentaBancoPunVen;
	}

	public void setActivarid_empresaCuentaBancoPunVen(Boolean activarid_empresaCuentaBancoPunVen) {
		this.activarid_empresaCuentaBancoPunVen= activarid_empresaCuentaBancoPunVen;
	}

	public Boolean getCargarid_empresaCuentaBancoPunVen() {
		return this.cargarid_empresaCuentaBancoPunVen;
	}

	public void setCargarid_empresaCuentaBancoPunVen(Boolean cargarid_empresaCuentaBancoPunVen) {
		this.cargarid_empresaCuentaBancoPunVen= cargarid_empresaCuentaBancoPunVen;
	}

	public Border setResaltarid_sucursalCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCuentaBancoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCuentaBancoPunVen() {
		return this.resaltarid_sucursalCuentaBancoPunVen;
	}

	public void setResaltarid_sucursalCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarid_sucursalCuentaBancoPunVen= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCuentaBancoPunVen() {
		return this.mostrarid_sucursalCuentaBancoPunVen;
	}

	public void setMostrarid_sucursalCuentaBancoPunVen(Boolean mostrarid_sucursalCuentaBancoPunVen) {
		this.mostrarid_sucursalCuentaBancoPunVen= mostrarid_sucursalCuentaBancoPunVen;
	}

	public Boolean getActivarid_sucursalCuentaBancoPunVen() {
		return this.activarid_sucursalCuentaBancoPunVen;
	}

	public void setActivarid_sucursalCuentaBancoPunVen(Boolean activarid_sucursalCuentaBancoPunVen) {
		this.activarid_sucursalCuentaBancoPunVen= activarid_sucursalCuentaBancoPunVen;
	}

	public Boolean getCargarid_sucursalCuentaBancoPunVen() {
		return this.cargarid_sucursalCuentaBancoPunVen;
	}

	public void setCargarid_sucursalCuentaBancoPunVen(Boolean cargarid_sucursalCuentaBancoPunVen) {
		this.cargarid_sucursalCuentaBancoPunVen= cargarid_sucursalCuentaBancoPunVen;
	}

	public Border setResaltarid_bancoCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltarid_bancoCuentaBancoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoCuentaBancoPunVen() {
		return this.resaltarid_bancoCuentaBancoPunVen;
	}

	public void setResaltarid_bancoCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarid_bancoCuentaBancoPunVen= borderResaltar;
	}

	public Boolean getMostrarid_bancoCuentaBancoPunVen() {
		return this.mostrarid_bancoCuentaBancoPunVen;
	}

	public void setMostrarid_bancoCuentaBancoPunVen(Boolean mostrarid_bancoCuentaBancoPunVen) {
		this.mostrarid_bancoCuentaBancoPunVen= mostrarid_bancoCuentaBancoPunVen;
	}

	public Boolean getActivarid_bancoCuentaBancoPunVen() {
		return this.activarid_bancoCuentaBancoPunVen;
	}

	public void setActivarid_bancoCuentaBancoPunVen(Boolean activarid_bancoCuentaBancoPunVen) {
		this.activarid_bancoCuentaBancoPunVen= activarid_bancoCuentaBancoPunVen;
	}

	public Boolean getCargarid_bancoCuentaBancoPunVen() {
		return this.cargarid_bancoCuentaBancoPunVen;
	}

	public void setCargarid_bancoCuentaBancoPunVen(Boolean cargarid_bancoCuentaBancoPunVen) {
		this.cargarid_bancoCuentaBancoPunVen= cargarid_bancoCuentaBancoPunVen;
	}

	public Border setResaltarid_clienteCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltarid_clienteCuentaBancoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteCuentaBancoPunVen() {
		return this.resaltarid_clienteCuentaBancoPunVen;
	}

	public void setResaltarid_clienteCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarid_clienteCuentaBancoPunVen= borderResaltar;
	}

	public Boolean getMostrarid_clienteCuentaBancoPunVen() {
		return this.mostrarid_clienteCuentaBancoPunVen;
	}

	public void setMostrarid_clienteCuentaBancoPunVen(Boolean mostrarid_clienteCuentaBancoPunVen) {
		this.mostrarid_clienteCuentaBancoPunVen= mostrarid_clienteCuentaBancoPunVen;
	}

	public Boolean getActivarid_clienteCuentaBancoPunVen() {
		return this.activarid_clienteCuentaBancoPunVen;
	}

	public void setActivarid_clienteCuentaBancoPunVen(Boolean activarid_clienteCuentaBancoPunVen) {
		this.activarid_clienteCuentaBancoPunVen= activarid_clienteCuentaBancoPunVen;
	}

	public Boolean getCargarid_clienteCuentaBancoPunVen() {
		return this.cargarid_clienteCuentaBancoPunVen;
	}

	public void setCargarid_clienteCuentaBancoPunVen(Boolean cargarid_clienteCuentaBancoPunVen) {
		this.cargarid_clienteCuentaBancoPunVen= cargarid_clienteCuentaBancoPunVen;
	}

	public Border setResaltarid_cuenta_contableCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCuentaBancoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCuentaBancoPunVen() {
		return this.resaltarid_cuenta_contableCuentaBancoPunVen;
	}

	public void setResaltarid_cuenta_contableCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarid_cuenta_contableCuentaBancoPunVen= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCuentaBancoPunVen() {
		return this.mostrarid_cuenta_contableCuentaBancoPunVen;
	}

	public void setMostrarid_cuenta_contableCuentaBancoPunVen(Boolean mostrarid_cuenta_contableCuentaBancoPunVen) {
		this.mostrarid_cuenta_contableCuentaBancoPunVen= mostrarid_cuenta_contableCuentaBancoPunVen;
	}

	public Boolean getActivarid_cuenta_contableCuentaBancoPunVen() {
		return this.activarid_cuenta_contableCuentaBancoPunVen;
	}

	public void setActivarid_cuenta_contableCuentaBancoPunVen(Boolean activarid_cuenta_contableCuentaBancoPunVen) {
		this.activarid_cuenta_contableCuentaBancoPunVen= activarid_cuenta_contableCuentaBancoPunVen;
	}

	public Boolean getCargarid_cuenta_contableCuentaBancoPunVen() {
		return this.cargarid_cuenta_contableCuentaBancoPunVen;
	}

	public void setCargarid_cuenta_contableCuentaBancoPunVen(Boolean cargarid_cuenta_contableCuentaBancoPunVen) {
		this.cargarid_cuenta_contableCuentaBancoPunVen= cargarid_cuenta_contableCuentaBancoPunVen;
	}

	public Border setResaltarcodigoCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltarcodigoCuentaBancoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCuentaBancoPunVen() {
		return this.resaltarcodigoCuentaBancoPunVen;
	}

	public void setResaltarcodigoCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarcodigoCuentaBancoPunVen= borderResaltar;
	}

	public Boolean getMostrarcodigoCuentaBancoPunVen() {
		return this.mostrarcodigoCuentaBancoPunVen;
	}

	public void setMostrarcodigoCuentaBancoPunVen(Boolean mostrarcodigoCuentaBancoPunVen) {
		this.mostrarcodigoCuentaBancoPunVen= mostrarcodigoCuentaBancoPunVen;
	}

	public Boolean getActivarcodigoCuentaBancoPunVen() {
		return this.activarcodigoCuentaBancoPunVen;
	}

	public void setActivarcodigoCuentaBancoPunVen(Boolean activarcodigoCuentaBancoPunVen) {
		this.activarcodigoCuentaBancoPunVen= activarcodigoCuentaBancoPunVen;
	}

	public Border setResaltarnombreCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltar);
		
		this.resaltarnombreCuentaBancoPunVen= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCuentaBancoPunVen() {
		return this.resaltarnombreCuentaBancoPunVen;
	}

	public void setResaltarnombreCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarnombreCuentaBancoPunVen= borderResaltar;
	}

	public Boolean getMostrarnombreCuentaBancoPunVen() {
		return this.mostrarnombreCuentaBancoPunVen;
	}

	public void setMostrarnombreCuentaBancoPunVen(Boolean mostrarnombreCuentaBancoPunVen) {
		this.mostrarnombreCuentaBancoPunVen= mostrarnombreCuentaBancoPunVen;
	}

	public Boolean getActivarnombreCuentaBancoPunVen() {
		return this.activarnombreCuentaBancoPunVen;
	}

	public void setActivarnombreCuentaBancoPunVen(Boolean activarnombreCuentaBancoPunVen) {
		this.activarnombreCuentaBancoPunVen= activarnombreCuentaBancoPunVen;
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
		
		
		this.setMostraridCuentaBancoPunVen(esInicial);
		this.setMostrarid_empresaCuentaBancoPunVen(esInicial);
		this.setMostrarid_sucursalCuentaBancoPunVen(esInicial);
		this.setMostrarid_bancoCuentaBancoPunVen(esInicial);
		this.setMostrarid_clienteCuentaBancoPunVen(esInicial);
		this.setMostrarid_cuenta_contableCuentaBancoPunVen(esInicial);
		this.setMostrarcodigoCuentaBancoPunVen(esInicial);
		this.setMostrarnombreCuentaBancoPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.ID)) {
				this.setMostraridCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCuentaBancoPunVen(esAsigna);
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
		
		
		this.setActivaridCuentaBancoPunVen(esInicial);
		this.setActivarid_empresaCuentaBancoPunVen(esInicial);
		this.setActivarid_sucursalCuentaBancoPunVen(esInicial);
		this.setActivarid_bancoCuentaBancoPunVen(esInicial);
		this.setActivarid_clienteCuentaBancoPunVen(esInicial);
		this.setActivarid_cuenta_contableCuentaBancoPunVen(esInicial);
		this.setActivarcodigoCuentaBancoPunVen(esInicial);
		this.setActivarnombreCuentaBancoPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.ID)) {
				this.setActivaridCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCuentaBancoPunVen(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaBancoPunVen(esInicial);
		this.setResaltarid_empresaCuentaBancoPunVen(esInicial);
		this.setResaltarid_sucursalCuentaBancoPunVen(esInicial);
		this.setResaltarid_bancoCuentaBancoPunVen(esInicial);
		this.setResaltarid_clienteCuentaBancoPunVen(esInicial);
		this.setResaltarid_cuenta_contableCuentaBancoPunVen(esInicial);
		this.setResaltarcodigoCuentaBancoPunVen(esInicial);
		this.setResaltarnombreCuentaBancoPunVen(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.ID)) {
				this.setResaltaridCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCuentaBancoPunVen(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoPunVenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCuentaBancoPunVen(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormaPagoPuntoVentaCuentaBancoPunVen=null;

	public Border getResaltarFormaPagoPuntoVentaCuentaBancoPunVen() {
		return this.resaltarFormaPagoPuntoVentaCuentaBancoPunVen;
	}

	public void setResaltarFormaPagoPuntoVentaCuentaBancoPunVen(Border borderResaltarFormaPagoPuntoVenta) {
		if(borderResaltarFormaPagoPuntoVenta!=null) {
			this.resaltarFormaPagoPuntoVentaCuentaBancoPunVen= borderResaltarFormaPagoPuntoVenta;
		}
	}

	public Border setResaltarFormaPagoPuntoVentaCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltarFormaPagoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cuentabancopunvenBeanSwingJInternalFrame.jTtoolBarCuentaBancoPunVen.setBorder(borderResaltarFormaPagoPuntoVenta);
			
		this.resaltarFormaPagoPuntoVentaCuentaBancoPunVen= borderResaltarFormaPagoPuntoVenta;

		 return borderResaltarFormaPagoPuntoVenta;
	}



	public Boolean mostrarFormaPagoPuntoVentaCuentaBancoPunVen=true;

	public Boolean getMostrarFormaPagoPuntoVentaCuentaBancoPunVen() {
		return this.mostrarFormaPagoPuntoVentaCuentaBancoPunVen;
	}

	public void setMostrarFormaPagoPuntoVentaCuentaBancoPunVen(Boolean visibilidadResaltarFormaPagoPuntoVenta) {
		this.mostrarFormaPagoPuntoVentaCuentaBancoPunVen= visibilidadResaltarFormaPagoPuntoVenta;
	}



	public Boolean activarFormaPagoPuntoVentaCuentaBancoPunVen=true;

	public Boolean gethabilitarResaltarFormaPagoPuntoVentaCuentaBancoPunVen() {
		return this.activarFormaPagoPuntoVentaCuentaBancoPunVen;
	}

	public void setActivarFormaPagoPuntoVentaCuentaBancoPunVen(Boolean habilitarResaltarFormaPagoPuntoVenta) {
		this.activarFormaPagoPuntoVentaCuentaBancoPunVen= habilitarResaltarFormaPagoPuntoVenta;
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

		this.setMostrarFormaPagoPuntoVentaCuentaBancoPunVen(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setMostrarFormaPagoPuntoVentaCuentaBancoPunVen(esAsigna);
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

		this.setActivarFormaPagoPuntoVentaCuentaBancoPunVen(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setActivarFormaPagoPuntoVentaCuentaBancoPunVen(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormaPagoPuntoVentaCuentaBancoPunVen(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(FormaPagoPuntoVenta.class)) {
				this.setResaltarFormaPagoPuntoVentaCuentaBancoPunVen(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdBancoCuentaBancoPunVen=true;

	public Boolean getMostrarFK_IdBancoCuentaBancoPunVen() {
		return this.mostrarFK_IdBancoCuentaBancoPunVen;
	}

	public void setMostrarFK_IdBancoCuentaBancoPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoCuentaBancoPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteCuentaBancoPunVen=true;

	public Boolean getMostrarFK_IdClienteCuentaBancoPunVen() {
		return this.mostrarFK_IdClienteCuentaBancoPunVen;
	}

	public void setMostrarFK_IdClienteCuentaBancoPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteCuentaBancoPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCuentaBancoPunVen=true;

	public Boolean getMostrarFK_IdCuentaContableCuentaBancoPunVen() {
		return this.mostrarFK_IdCuentaContableCuentaBancoPunVen;
	}

	public void setMostrarFK_IdCuentaContableCuentaBancoPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCuentaBancoPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCuentaBancoPunVen=true;

	public Boolean getMostrarFK_IdEmpresaCuentaBancoPunVen() {
		return this.mostrarFK_IdEmpresaCuentaBancoPunVen;
	}

	public void setMostrarFK_IdEmpresaCuentaBancoPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCuentaBancoPunVen= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCuentaBancoPunVen=true;

	public Boolean getMostrarFK_IdSucursalCuentaBancoPunVen() {
		return this.mostrarFK_IdSucursalCuentaBancoPunVen;
	}

	public void setMostrarFK_IdSucursalCuentaBancoPunVen(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCuentaBancoPunVen= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoCuentaBancoPunVen=true;

	public Boolean getActivarFK_IdBancoCuentaBancoPunVen() {
		return this.activarFK_IdBancoCuentaBancoPunVen;
	}

	public void setActivarFK_IdBancoCuentaBancoPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdBancoCuentaBancoPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteCuentaBancoPunVen=true;

	public Boolean getActivarFK_IdClienteCuentaBancoPunVen() {
		return this.activarFK_IdClienteCuentaBancoPunVen;
	}

	public void setActivarFK_IdClienteCuentaBancoPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdClienteCuentaBancoPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCuentaBancoPunVen=true;

	public Boolean getActivarFK_IdCuentaContableCuentaBancoPunVen() {
		return this.activarFK_IdCuentaContableCuentaBancoPunVen;
	}

	public void setActivarFK_IdCuentaContableCuentaBancoPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCuentaBancoPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCuentaBancoPunVen=true;

	public Boolean getActivarFK_IdEmpresaCuentaBancoPunVen() {
		return this.activarFK_IdEmpresaCuentaBancoPunVen;
	}

	public void setActivarFK_IdEmpresaCuentaBancoPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCuentaBancoPunVen= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCuentaBancoPunVen=true;

	public Boolean getActivarFK_IdSucursalCuentaBancoPunVen() {
		return this.activarFK_IdSucursalCuentaBancoPunVen;
	}

	public void setActivarFK_IdSucursalCuentaBancoPunVen(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCuentaBancoPunVen= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoCuentaBancoPunVen=null;

	public Border getResaltarFK_IdBancoCuentaBancoPunVen() {
		return this.resaltarFK_IdBancoCuentaBancoPunVen;
	}

	public void setResaltarFK_IdBancoCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarFK_IdBancoCuentaBancoPunVen= borderResaltar;
	}

	public void setResaltarFK_IdBancoCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoCuentaBancoPunVen= borderResaltar;
	}

	public Border resaltarFK_IdClienteCuentaBancoPunVen=null;

	public Border getResaltarFK_IdClienteCuentaBancoPunVen() {
		return this.resaltarFK_IdClienteCuentaBancoPunVen;
	}

	public void setResaltarFK_IdClienteCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarFK_IdClienteCuentaBancoPunVen= borderResaltar;
	}

	public void setResaltarFK_IdClienteCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteCuentaBancoPunVen= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCuentaBancoPunVen=null;

	public Border getResaltarFK_IdCuentaContableCuentaBancoPunVen() {
		return this.resaltarFK_IdCuentaContableCuentaBancoPunVen;
	}

	public void setResaltarFK_IdCuentaContableCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCuentaBancoPunVen= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCuentaBancoPunVen= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCuentaBancoPunVen=null;

	public Border getResaltarFK_IdEmpresaCuentaBancoPunVen() {
		return this.resaltarFK_IdEmpresaCuentaBancoPunVen;
	}

	public void setResaltarFK_IdEmpresaCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCuentaBancoPunVen= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCuentaBancoPunVen= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCuentaBancoPunVen=null;

	public Border getResaltarFK_IdSucursalCuentaBancoPunVen() {
		return this.resaltarFK_IdSucursalCuentaBancoPunVen;
	}

	public void setResaltarFK_IdSucursalCuentaBancoPunVen(Border borderResaltar) {
		this.resaltarFK_IdSucursalCuentaBancoPunVen= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCuentaBancoPunVen(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoPunVenBeanSwingJInternalFrame cuentabancopunvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCuentaBancoPunVen= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}