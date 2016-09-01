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


import com.bydan.erp.puntoventa.util.CierreCajaConstantesFunciones;
import com.bydan.erp.puntoventa.util.CierreCajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CierreCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CierreCajaConstantesFunciones extends CierreCajaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CierreCaja";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CierreCaja"+CierreCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CierreCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CierreCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CierreCajaConstantesFunciones.SCHEMA+"_"+CierreCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CierreCajaConstantesFunciones.SCHEMA+"_"+CierreCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CierreCajaConstantesFunciones.SCHEMA+"_"+CierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CierreCajaConstantesFunciones.SCHEMA+"_"+CierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CierreCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CierreCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CierreCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CierreCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CierreCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CierreCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cierre Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cierre Caja";
	public static final String SCLASSWEBTITULO_LOWER="Cierre Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CierreCaja";
	public static final String OBJECTNAME="cierrecaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="cierre_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cierrecaja from "+CierreCajaConstantesFunciones.SPERSISTENCENAME+" cierrecaja";
	public static String QUERYSELECTNATIVE="select "+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".id,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".version_row,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".id_empresa,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".id_sucursal,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".id_usuario,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".fecha,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".total,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".total_diferencia,"+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME+".esta_activo from "+CierreCajaConstantesFunciones.SCHEMA+"."+CierreCajaConstantesFunciones.TABLENAME;//+" as "+CierreCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CierreCajaConstantesFuncionesAdditional cierrecajaConstantesFuncionesAdditional=null;
	
	public CierreCajaConstantesFuncionesAdditional getCierreCajaConstantesFuncionesAdditional() {
		return this.cierrecajaConstantesFuncionesAdditional;
	}
	
	public void setCierreCajaConstantesFuncionesAdditional(CierreCajaConstantesFuncionesAdditional cierrecajaConstantesFuncionesAdditional) {
		try {
			this.cierrecajaConstantesFuncionesAdditional=cierrecajaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String FECHA= "fecha";
    public static final String TOTAL= "total";
    public static final String TOTALDIFERENCIA= "total_diferencia";
    public static final String ESTAACTIVO= "esta_activo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_TOTALDIFERENCIA= "Total Diferencia";
		public static final String LABEL_TOTALDIFERENCIA_LOWER= "Total Diferencia";
    	public static final String LABEL_ESTAACTIVO= "Esta Activo";
		public static final String LABEL_ESTAACTIVO_LOWER= "Esta Activo";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getCierreCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CierreCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=CierreCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CierreCajaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CierreCajaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CierreCajaConstantesFunciones.IDUSUARIO)) {sLabelColumna=CierreCajaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(CierreCajaConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=CierreCajaConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(CierreCajaConstantesFunciones.FECHA)) {sLabelColumna=CierreCajaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(CierreCajaConstantesFunciones.TOTAL)) {sLabelColumna=CierreCajaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(CierreCajaConstantesFunciones.TOTALDIFERENCIA)) {sLabelColumna=CierreCajaConstantesFunciones.LABEL_TOTALDIFERENCIA;}
		if(sNombreColumna.equals(CierreCajaConstantesFunciones.ESTAACTIVO)) {sLabelColumna=CierreCajaConstantesFunciones.LABEL_ESTAACTIVO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
		
	public static String getesta_activoDescripcion(CierreCaja cierrecaja) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cierrecaja.getesta_activo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_activoHtmlDescripcion(CierreCaja cierrecaja) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cierrecaja.getId(),cierrecaja.getesta_activo());

		return sDescripcion;
	}	
	
	public static String getCierreCajaDescripcion(CierreCaja cierrecaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cierrecaja !=null/* && cierrecaja.getId()!=0*/) {
			if(cierrecaja.getId()!=null) {
				sDescripcion=cierrecaja.getId().toString();
			}//cierrecajacierrecaja.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCierreCajaDescripcionDetallado(CierreCaja cierrecaja) {
		String sDescripcion="";
			
		sDescripcion+=CierreCajaConstantesFunciones.ID+"=";
		sDescripcion+=cierrecaja.getId().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cierrecaja.getVersionRow().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cierrecaja.getid_empresa().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cierrecaja.getid_sucursal().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=cierrecaja.getid_usuario().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=cierrecaja.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.FECHA+"=";
		sDescripcion+=cierrecaja.getfecha().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.TOTAL+"=";
		sDescripcion+=cierrecaja.gettotal().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.TOTALDIFERENCIA+"=";
		sDescripcion+=cierrecaja.gettotal_diferencia().toString()+",";
		sDescripcion+=CierreCajaConstantesFunciones.ESTAACTIVO+"=";
		sDescripcion+=cierrecaja.getesta_activo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCierreCajaDescripcion(CierreCaja cierrecaja,String sValor) throws Exception {			
		if(cierrecaja !=null) {
			//cierrecajacierrecaja.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCierreCaja(CierreCaja cierrecaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosCierreCajas(List<CierreCaja> cierrecajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CierreCaja cierrecaja: cierrecajas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCierreCaja(CierreCaja cierrecaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cierrecaja.getConCambioAuxiliar()) {
			cierrecaja.setIsDeleted(cierrecaja.getIsDeletedAuxiliar());	
			cierrecaja.setIsNew(cierrecaja.getIsNewAuxiliar());	
			cierrecaja.setIsChanged(cierrecaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cierrecaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cierrecaja.setIsDeletedAuxiliar(false);	
			cierrecaja.setIsNewAuxiliar(false);	
			cierrecaja.setIsChangedAuxiliar(false);
			
			cierrecaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCierreCajas(List<CierreCaja> cierrecajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CierreCaja cierrecaja : cierrecajas) {
			if(conAsignarBase && cierrecaja.getConCambioAuxiliar()) {
				cierrecaja.setIsDeleted(cierrecaja.getIsDeletedAuxiliar());	
				cierrecaja.setIsNew(cierrecaja.getIsNewAuxiliar());	
				cierrecaja.setIsChanged(cierrecaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cierrecaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cierrecaja.setIsDeletedAuxiliar(false);	
				cierrecaja.setIsNewAuxiliar(false);	
				cierrecaja.setIsChangedAuxiliar(false);
				
				cierrecaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCierreCaja(CierreCaja cierrecaja,Boolean conEnteros) throws Exception  {
		cierrecaja.settotal(0.0);
		cierrecaja.settotal_diferencia(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCierreCajas(List<CierreCaja> cierrecajas,Boolean conEnteros) throws Exception  {
		
		for(CierreCaja cierrecaja: cierrecajas) {
			cierrecaja.settotal(0.0);
			cierrecaja.settotal_diferencia(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCierreCaja(List<CierreCaja> cierrecajas,CierreCaja cierrecajaAux) throws Exception  {
		CierreCajaConstantesFunciones.InicializarValoresCierreCaja(cierrecajaAux,true);
		
		for(CierreCaja cierrecaja: cierrecajas) {
			if(cierrecaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cierrecajaAux.settotal(cierrecajaAux.gettotal()+cierrecaja.gettotal());			
			cierrecajaAux.settotal_diferencia(cierrecajaAux.gettotal_diferencia()+cierrecaja.gettotal_diferencia());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CierreCajaConstantesFunciones.getArrayColumnasGlobalesCierreCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CierreCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CierreCajaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CierreCajaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CierreCajaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CierreCajaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CierreCajaConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCierreCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CierreCaja> cierrecajas,CierreCaja cierrecaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CierreCaja cierrecajaAux: cierrecajas) {
			if(cierrecajaAux!=null && cierrecaja!=null) {
				if((cierrecajaAux.getId()==null && cierrecaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cierrecajaAux.getId()!=null && cierrecaja.getId()!=null){
					if(cierrecajaAux.getId().equals(cierrecaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCierreCaja(List<CierreCaja> cierrecajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
		Double total_diferenciaTotal=0.0;
	
		for(CierreCaja cierrecaja: cierrecajas) {			
			if(cierrecaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=cierrecaja.gettotal();
			total_diferenciaTotal+=cierrecaja.gettotal_diferencia();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CierreCajaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(CierreCajaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CierreCajaConstantesFunciones.TOTALDIFERENCIA);
		datoGeneral.setsDescripcion(CierreCajaConstantesFunciones.LABEL_TOTALDIFERENCIA);
		datoGeneral.setdValorDouble(total_diferenciaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCierreCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_ID, CierreCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_VERSIONROW, CierreCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_IDEMPRESA, CierreCajaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_IDSUCURSAL, CierreCajaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_IDUSUARIO, CierreCajaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_IDTIPOFORMAPAGO, CierreCajaConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_FECHA, CierreCajaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_TOTAL, CierreCajaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_TOTALDIFERENCIA, CierreCajaConstantesFunciones.TOTALDIFERENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CierreCajaConstantesFunciones.LABEL_ESTAACTIVO, CierreCajaConstantesFunciones.ESTAACTIVO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCierreCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.TOTALDIFERENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CierreCajaConstantesFunciones.ESTAACTIVO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCierreCaja() throws Exception  {
		return CierreCajaConstantesFunciones.getTiposSeleccionarCierreCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCierreCaja(Boolean conFk) throws Exception  {
		return CierreCajaConstantesFunciones.getTiposSeleccionarCierreCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCierreCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CierreCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreCajaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CierreCajaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreCajaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(CierreCajaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreCajaConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(CierreCajaConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreCajaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CierreCajaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreCajaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(CierreCajaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreCajaConstantesFunciones.LABEL_TOTALDIFERENCIA);
			reporte.setsDescripcion(CierreCajaConstantesFunciones.LABEL_TOTALDIFERENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CierreCajaConstantesFunciones.LABEL_ESTAACTIVO);
			reporte.setsDescripcion(CierreCajaConstantesFunciones.LABEL_ESTAACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCierreCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCierreCaja(CierreCaja cierrecajaAux) throws Exception {
		
			cierrecajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cierrecajaAux.getEmpresa()));
			cierrecajaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cierrecajaAux.getSucursal()));
			cierrecajaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cierrecajaAux.getUsuario()));
			cierrecajaAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(cierrecajaAux.getTipoFormaPago()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCierreCaja(List<CierreCaja> cierrecajasTemp) throws Exception {
		for(CierreCaja cierrecajaAux:cierrecajasTemp) {
			
			cierrecajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cierrecajaAux.getEmpresa()));
			cierrecajaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cierrecajaAux.getSucursal()));
			cierrecajaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cierrecajaAux.getUsuario()));
			cierrecajaAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(cierrecajaAux.getTipoFormaPago()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(TipoFormaPago.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CierreCajaConstantesFunciones.getClassesRelationshipsOfCierreCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCierreCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CierreCajaConstantesFunciones.getClassesRelationshipsFromStringsOfCierreCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCierreCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CierreCaja cierrecaja,List<CierreCaja> cierrecajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CierreCaja cierrecajaEncontrado=null;
			
			for(CierreCaja cierrecajaLocal:cierrecajas) {
				if(cierrecajaLocal.getId().equals(cierrecaja.getId())) {
					cierrecajaEncontrado=cierrecajaLocal;
					
					cierrecajaLocal.setIsChanged(cierrecaja.getIsChanged());
					cierrecajaLocal.setIsNew(cierrecaja.getIsNew());
					cierrecajaLocal.setIsDeleted(cierrecaja.getIsDeleted());
					
					cierrecajaLocal.setGeneralEntityOriginal(cierrecaja.getGeneralEntityOriginal());
					
					cierrecajaLocal.setId(cierrecaja.getId());	
					cierrecajaLocal.setVersionRow(cierrecaja.getVersionRow());	
					cierrecajaLocal.setid_empresa(cierrecaja.getid_empresa());	
					cierrecajaLocal.setid_sucursal(cierrecaja.getid_sucursal());	
					cierrecajaLocal.setid_usuario(cierrecaja.getid_usuario());	
					cierrecajaLocal.setid_tipo_forma_pago(cierrecaja.getid_tipo_forma_pago());	
					cierrecajaLocal.setfecha(cierrecaja.getfecha());	
					cierrecajaLocal.settotal(cierrecaja.gettotal());	
					cierrecajaLocal.settotal_diferencia(cierrecaja.gettotal_diferencia());	
					cierrecajaLocal.setesta_activo(cierrecaja.getesta_activo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!cierrecaja.getIsDeleted()) {
				if(!existe) {
					cierrecajas.add(cierrecaja);
				}
			} else {
				if(cierrecajaEncontrado!=null && permiteQuitar)  {
					cierrecajas.remove(cierrecajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CierreCaja cierrecaja,List<CierreCaja> cierrecajas) throws Exception {
		try	{			
			for(CierreCaja cierrecajaLocal:cierrecajas) {
				if(cierrecajaLocal.getId().equals(cierrecaja.getId())) {
					cierrecajaLocal.setIsSelected(cierrecaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCierreCaja(List<CierreCaja> cierrecajasAux) throws Exception {
		//this.cierrecajasAux=cierrecajasAux;
		
		for(CierreCaja cierrecajaAux:cierrecajasAux) {
			if(cierrecajaAux.getIsChanged()) {
				cierrecajaAux.setIsChanged(false);
			}		
			
			if(cierrecajaAux.getIsNew()) {
				cierrecajaAux.setIsNew(false);
			}	
			
			if(cierrecajaAux.getIsDeleted()) {
				cierrecajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCierreCaja(CierreCaja cierrecajaAux) throws Exception {
		//this.cierrecajaAux=cierrecajaAux;
		
			if(cierrecajaAux.getIsChanged()) {
				cierrecajaAux.setIsChanged(false);
			}		
			
			if(cierrecajaAux.getIsNew()) {
				cierrecajaAux.setIsNew(false);
			}	
			
			if(cierrecajaAux.getIsDeleted()) {
				cierrecajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CierreCaja cierrecajaAsignar,CierreCaja cierrecaja) throws Exception {
		cierrecajaAsignar.setId(cierrecaja.getId());	
		cierrecajaAsignar.setVersionRow(cierrecaja.getVersionRow());	
		cierrecajaAsignar.setid_empresa(cierrecaja.getid_empresa());
		cierrecajaAsignar.setempresa_descripcion(cierrecaja.getempresa_descripcion());	
		cierrecajaAsignar.setid_sucursal(cierrecaja.getid_sucursal());
		cierrecajaAsignar.setsucursal_descripcion(cierrecaja.getsucursal_descripcion());	
		cierrecajaAsignar.setid_usuario(cierrecaja.getid_usuario());
		cierrecajaAsignar.setusuario_descripcion(cierrecaja.getusuario_descripcion());	
		cierrecajaAsignar.setid_tipo_forma_pago(cierrecaja.getid_tipo_forma_pago());
		cierrecajaAsignar.settipoformapago_descripcion(cierrecaja.gettipoformapago_descripcion());	
		cierrecajaAsignar.setfecha(cierrecaja.getfecha());	
		cierrecajaAsignar.settotal(cierrecaja.gettotal());	
		cierrecajaAsignar.settotal_diferencia(cierrecaja.gettotal_diferencia());	
		cierrecajaAsignar.setesta_activo(cierrecaja.getesta_activo());	
	}
	
	public static void inicializarCierreCaja(CierreCaja cierrecaja) throws Exception {
		try {
				cierrecaja.setId(0L);	
					
				cierrecaja.setid_empresa(-1L);	
				cierrecaja.setid_sucursal(-1L);	
				cierrecaja.setid_usuario(-1L);	
				cierrecaja.setid_tipo_forma_pago(-1L);	
				cierrecaja.setfecha(new Date());	
				cierrecaja.settotal(0.0);	
				cierrecaja.settotal_diferencia(0.0);	
				cierrecaja.setesta_activo(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCierreCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreCajaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreCajaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreCajaConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreCajaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreCajaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreCajaConstantesFunciones.LABEL_TOTALDIFERENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CierreCajaConstantesFunciones.LABEL_ESTAACTIVO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCierreCaja(String sTipo,Row row,Workbook workbook,CierreCaja cierrecaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrecaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrecaja.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrecaja.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrecaja.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrecaja.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrecaja.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cierrecaja.gettotal_diferencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cierrecaja.getesta_activo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCierreCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCierreCaja() {
		return this.sFinalQueryCierreCaja;
	}
	
	public void setsFinalQueryCierreCaja(String sFinalQueryCierreCaja) {
		this.sFinalQueryCierreCaja= sFinalQueryCierreCaja;
	}
	
	public Border resaltarSeleccionarCierreCaja=null;
	
	public Border setResaltarSeleccionarCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCierreCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCierreCaja() {
		return this.resaltarSeleccionarCierreCaja;
	}
	
	public void setResaltarSeleccionarCierreCaja(Border borderResaltarSeleccionarCierreCaja) {
		this.resaltarSeleccionarCierreCaja= borderResaltarSeleccionarCierreCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCierreCaja=null;
	public Boolean mostraridCierreCaja=true;
	public Boolean activaridCierreCaja=true;

	public Border resaltarid_empresaCierreCaja=null;
	public Boolean mostrarid_empresaCierreCaja=true;
	public Boolean activarid_empresaCierreCaja=true;
	public Boolean cargarid_empresaCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCierreCaja=false;//ConEventDepend=true

	public Border resaltarid_sucursalCierreCaja=null;
	public Boolean mostrarid_sucursalCierreCaja=true;
	public Boolean activarid_sucursalCierreCaja=true;
	public Boolean cargarid_sucursalCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCierreCaja=false;//ConEventDepend=true

	public Border resaltarid_usuarioCierreCaja=null;
	public Boolean mostrarid_usuarioCierreCaja=true;
	public Boolean activarid_usuarioCierreCaja=true;
	public Boolean cargarid_usuarioCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioCierreCaja=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoCierreCaja=null;
	public Boolean mostrarid_tipo_forma_pagoCierreCaja=true;
	public Boolean activarid_tipo_forma_pagoCierreCaja=true;
	public Boolean cargarid_tipo_forma_pagoCierreCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoCierreCaja=false;//ConEventDepend=true

	public Border resaltarfechaCierreCaja=null;
	public Boolean mostrarfechaCierreCaja=true;
	public Boolean activarfechaCierreCaja=true;

	public Border resaltartotalCierreCaja=null;
	public Boolean mostrartotalCierreCaja=true;
	public Boolean activartotalCierreCaja=true;

	public Border resaltartotal_diferenciaCierreCaja=null;
	public Boolean mostrartotal_diferenciaCierreCaja=true;
	public Boolean activartotal_diferenciaCierreCaja=true;

	public Border resaltaresta_activoCierreCaja=null;
	public Boolean mostraresta_activoCierreCaja=true;
	public Boolean activaresta_activoCierreCaja=true;

	
	

	public Border setResaltaridCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltaridCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCierreCaja() {
		return this.resaltaridCierreCaja;
	}

	public void setResaltaridCierreCaja(Border borderResaltar) {
		this.resaltaridCierreCaja= borderResaltar;
	}

	public Boolean getMostraridCierreCaja() {
		return this.mostraridCierreCaja;
	}

	public void setMostraridCierreCaja(Boolean mostraridCierreCaja) {
		this.mostraridCierreCaja= mostraridCierreCaja;
	}

	public Boolean getActivaridCierreCaja() {
		return this.activaridCierreCaja;
	}

	public void setActivaridCierreCaja(Boolean activaridCierreCaja) {
		this.activaridCierreCaja= activaridCierreCaja;
	}

	public Border setResaltarid_empresaCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCierreCaja() {
		return this.resaltarid_empresaCierreCaja;
	}

	public void setResaltarid_empresaCierreCaja(Border borderResaltar) {
		this.resaltarid_empresaCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaCierreCaja() {
		return this.mostrarid_empresaCierreCaja;
	}

	public void setMostrarid_empresaCierreCaja(Boolean mostrarid_empresaCierreCaja) {
		this.mostrarid_empresaCierreCaja= mostrarid_empresaCierreCaja;
	}

	public Boolean getActivarid_empresaCierreCaja() {
		return this.activarid_empresaCierreCaja;
	}

	public void setActivarid_empresaCierreCaja(Boolean activarid_empresaCierreCaja) {
		this.activarid_empresaCierreCaja= activarid_empresaCierreCaja;
	}

	public Boolean getCargarid_empresaCierreCaja() {
		return this.cargarid_empresaCierreCaja;
	}

	public void setCargarid_empresaCierreCaja(Boolean cargarid_empresaCierreCaja) {
		this.cargarid_empresaCierreCaja= cargarid_empresaCierreCaja;
	}

	public Border setResaltarid_sucursalCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCierreCaja() {
		return this.resaltarid_sucursalCierreCaja;
	}

	public void setResaltarid_sucursalCierreCaja(Border borderResaltar) {
		this.resaltarid_sucursalCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCierreCaja() {
		return this.mostrarid_sucursalCierreCaja;
	}

	public void setMostrarid_sucursalCierreCaja(Boolean mostrarid_sucursalCierreCaja) {
		this.mostrarid_sucursalCierreCaja= mostrarid_sucursalCierreCaja;
	}

	public Boolean getActivarid_sucursalCierreCaja() {
		return this.activarid_sucursalCierreCaja;
	}

	public void setActivarid_sucursalCierreCaja(Boolean activarid_sucursalCierreCaja) {
		this.activarid_sucursalCierreCaja= activarid_sucursalCierreCaja;
	}

	public Boolean getCargarid_sucursalCierreCaja() {
		return this.cargarid_sucursalCierreCaja;
	}

	public void setCargarid_sucursalCierreCaja(Boolean cargarid_sucursalCierreCaja) {
		this.cargarid_sucursalCierreCaja= cargarid_sucursalCierreCaja;
	}

	public Border setResaltarid_usuarioCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_usuarioCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioCierreCaja() {
		return this.resaltarid_usuarioCierreCaja;
	}

	public void setResaltarid_usuarioCierreCaja(Border borderResaltar) {
		this.resaltarid_usuarioCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_usuarioCierreCaja() {
		return this.mostrarid_usuarioCierreCaja;
	}

	public void setMostrarid_usuarioCierreCaja(Boolean mostrarid_usuarioCierreCaja) {
		this.mostrarid_usuarioCierreCaja= mostrarid_usuarioCierreCaja;
	}

	public Boolean getActivarid_usuarioCierreCaja() {
		return this.activarid_usuarioCierreCaja;
	}

	public void setActivarid_usuarioCierreCaja(Boolean activarid_usuarioCierreCaja) {
		this.activarid_usuarioCierreCaja= activarid_usuarioCierreCaja;
	}

	public Boolean getCargarid_usuarioCierreCaja() {
		return this.cargarid_usuarioCierreCaja;
	}

	public void setCargarid_usuarioCierreCaja(Boolean cargarid_usuarioCierreCaja) {
		this.cargarid_usuarioCierreCaja= cargarid_usuarioCierreCaja;
	}

	public Border setResaltarid_tipo_forma_pagoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoCierreCaja() {
		return this.resaltarid_tipo_forma_pagoCierreCaja;
	}

	public void setResaltarid_tipo_forma_pagoCierreCaja(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoCierreCaja= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoCierreCaja() {
		return this.mostrarid_tipo_forma_pagoCierreCaja;
	}

	public void setMostrarid_tipo_forma_pagoCierreCaja(Boolean mostrarid_tipo_forma_pagoCierreCaja) {
		this.mostrarid_tipo_forma_pagoCierreCaja= mostrarid_tipo_forma_pagoCierreCaja;
	}

	public Boolean getActivarid_tipo_forma_pagoCierreCaja() {
		return this.activarid_tipo_forma_pagoCierreCaja;
	}

	public void setActivarid_tipo_forma_pagoCierreCaja(Boolean activarid_tipo_forma_pagoCierreCaja) {
		this.activarid_tipo_forma_pagoCierreCaja= activarid_tipo_forma_pagoCierreCaja;
	}

	public Boolean getCargarid_tipo_forma_pagoCierreCaja() {
		return this.cargarid_tipo_forma_pagoCierreCaja;
	}

	public void setCargarid_tipo_forma_pagoCierreCaja(Boolean cargarid_tipo_forma_pagoCierreCaja) {
		this.cargarid_tipo_forma_pagoCierreCaja= cargarid_tipo_forma_pagoCierreCaja;
	}

	public Border setResaltarfechaCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltarfechaCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCierreCaja() {
		return this.resaltarfechaCierreCaja;
	}

	public void setResaltarfechaCierreCaja(Border borderResaltar) {
		this.resaltarfechaCierreCaja= borderResaltar;
	}

	public Boolean getMostrarfechaCierreCaja() {
		return this.mostrarfechaCierreCaja;
	}

	public void setMostrarfechaCierreCaja(Boolean mostrarfechaCierreCaja) {
		this.mostrarfechaCierreCaja= mostrarfechaCierreCaja;
	}

	public Boolean getActivarfechaCierreCaja() {
		return this.activarfechaCierreCaja;
	}

	public void setActivarfechaCierreCaja(Boolean activarfechaCierreCaja) {
		this.activarfechaCierreCaja= activarfechaCierreCaja;
	}

	public Border setResaltartotalCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltartotalCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalCierreCaja() {
		return this.resaltartotalCierreCaja;
	}

	public void setResaltartotalCierreCaja(Border borderResaltar) {
		this.resaltartotalCierreCaja= borderResaltar;
	}

	public Boolean getMostrartotalCierreCaja() {
		return this.mostrartotalCierreCaja;
	}

	public void setMostrartotalCierreCaja(Boolean mostrartotalCierreCaja) {
		this.mostrartotalCierreCaja= mostrartotalCierreCaja;
	}

	public Boolean getActivartotalCierreCaja() {
		return this.activartotalCierreCaja;
	}

	public void setActivartotalCierreCaja(Boolean activartotalCierreCaja) {
		this.activartotalCierreCaja= activartotalCierreCaja;
	}

	public Border setResaltartotal_diferenciaCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltartotal_diferenciaCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_diferenciaCierreCaja() {
		return this.resaltartotal_diferenciaCierreCaja;
	}

	public void setResaltartotal_diferenciaCierreCaja(Border borderResaltar) {
		this.resaltartotal_diferenciaCierreCaja= borderResaltar;
	}

	public Boolean getMostrartotal_diferenciaCierreCaja() {
		return this.mostrartotal_diferenciaCierreCaja;
	}

	public void setMostrartotal_diferenciaCierreCaja(Boolean mostrartotal_diferenciaCierreCaja) {
		this.mostrartotal_diferenciaCierreCaja= mostrartotal_diferenciaCierreCaja;
	}

	public Boolean getActivartotal_diferenciaCierreCaja() {
		return this.activartotal_diferenciaCierreCaja;
	}

	public void setActivartotal_diferenciaCierreCaja(Boolean activartotal_diferenciaCierreCaja) {
		this.activartotal_diferenciaCierreCaja= activartotal_diferenciaCierreCaja;
	}

	public Border setResaltaresta_activoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cierrecajaBeanSwingJInternalFrame.jTtoolBarCierreCaja.setBorder(borderResaltar);
		
		this.resaltaresta_activoCierreCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_activoCierreCaja() {
		return this.resaltaresta_activoCierreCaja;
	}

	public void setResaltaresta_activoCierreCaja(Border borderResaltar) {
		this.resaltaresta_activoCierreCaja= borderResaltar;
	}

	public Boolean getMostraresta_activoCierreCaja() {
		return this.mostraresta_activoCierreCaja;
	}

	public void setMostraresta_activoCierreCaja(Boolean mostraresta_activoCierreCaja) {
		this.mostraresta_activoCierreCaja= mostraresta_activoCierreCaja;
	}

	public Boolean getActivaresta_activoCierreCaja() {
		return this.activaresta_activoCierreCaja;
	}

	public void setActivaresta_activoCierreCaja(Boolean activaresta_activoCierreCaja) {
		this.activaresta_activoCierreCaja= activaresta_activoCierreCaja;
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
		
		
		this.setMostraridCierreCaja(esInicial);
		this.setMostrarid_empresaCierreCaja(esInicial);
		this.setMostrarid_sucursalCierreCaja(esInicial);
		this.setMostrarid_usuarioCierreCaja(esInicial);
		this.setMostrarid_tipo_forma_pagoCierreCaja(esInicial);
		this.setMostrarfechaCierreCaja(esInicial);
		this.setMostrartotalCierreCaja(esInicial);
		this.setMostrartotal_diferenciaCierreCaja(esInicial);
		this.setMostraresta_activoCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CierreCajaConstantesFunciones.ID)) {
				this.setMostraridCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.FECHA)) {
				this.setMostrarfechaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.TOTAL)) {
				this.setMostrartotalCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.TOTALDIFERENCIA)) {
				this.setMostrartotal_diferenciaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.ESTAACTIVO)) {
				this.setMostraresta_activoCierreCaja(esAsigna);
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
		
		
		this.setActivaridCierreCaja(esInicial);
		this.setActivarid_empresaCierreCaja(esInicial);
		this.setActivarid_sucursalCierreCaja(esInicial);
		this.setActivarid_usuarioCierreCaja(esInicial);
		this.setActivarid_tipo_forma_pagoCierreCaja(esInicial);
		this.setActivarfechaCierreCaja(esInicial);
		this.setActivartotalCierreCaja(esInicial);
		this.setActivartotal_diferenciaCierreCaja(esInicial);
		this.setActivaresta_activoCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CierreCajaConstantesFunciones.ID)) {
				this.setActivaridCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.FECHA)) {
				this.setActivarfechaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.TOTAL)) {
				this.setActivartotalCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.TOTALDIFERENCIA)) {
				this.setActivartotal_diferenciaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.ESTAACTIVO)) {
				this.setActivaresta_activoCierreCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCierreCaja(esInicial);
		this.setResaltarid_empresaCierreCaja(esInicial);
		this.setResaltarid_sucursalCierreCaja(esInicial);
		this.setResaltarid_usuarioCierreCaja(esInicial);
		this.setResaltarid_tipo_forma_pagoCierreCaja(esInicial);
		this.setResaltarfechaCierreCaja(esInicial);
		this.setResaltartotalCierreCaja(esInicial);
		this.setResaltartotal_diferenciaCierreCaja(esInicial);
		this.setResaltaresta_activoCierreCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CierreCajaConstantesFunciones.ID)) {
				this.setResaltaridCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.FECHA)) {
				this.setResaltarfechaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.TOTAL)) {
				this.setResaltartotalCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.TOTALDIFERENCIA)) {
				this.setResaltartotal_diferenciaCierreCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(CierreCajaConstantesFunciones.ESTAACTIVO)) {
				this.setResaltaresta_activoCierreCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaCierreCaja=true;

	public Boolean getMostrarFK_IdEmpresaCierreCaja() {
		return this.mostrarFK_IdEmpresaCierreCaja;
	}

	public void setMostrarFK_IdEmpresaCierreCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCierreCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCierreCaja=true;

	public Boolean getMostrarFK_IdSucursalCierreCaja() {
		return this.mostrarFK_IdSucursalCierreCaja;
	}

	public void setMostrarFK_IdSucursalCierreCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCierreCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoCierreCaja=true;

	public Boolean getMostrarFK_IdTipoFormaPagoCierreCaja() {
		return this.mostrarFK_IdTipoFormaPagoCierreCaja;
	}

	public void setMostrarFK_IdTipoFormaPagoCierreCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoCierreCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioCierreCaja=true;

	public Boolean getMostrarFK_IdUsuarioCierreCaja() {
		return this.mostrarFK_IdUsuarioCierreCaja;
	}

	public void setMostrarFK_IdUsuarioCierreCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioCierreCaja= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaCierreCaja=true;

	public Boolean getActivarFK_IdEmpresaCierreCaja() {
		return this.activarFK_IdEmpresaCierreCaja;
	}

	public void setActivarFK_IdEmpresaCierreCaja(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCierreCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCierreCaja=true;

	public Boolean getActivarFK_IdSucursalCierreCaja() {
		return this.activarFK_IdSucursalCierreCaja;
	}

	public void setActivarFK_IdSucursalCierreCaja(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCierreCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoCierreCaja=true;

	public Boolean getActivarFK_IdTipoFormaPagoCierreCaja() {
		return this.activarFK_IdTipoFormaPagoCierreCaja;
	}

	public void setActivarFK_IdTipoFormaPagoCierreCaja(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoCierreCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioCierreCaja=true;

	public Boolean getActivarFK_IdUsuarioCierreCaja() {
		return this.activarFK_IdUsuarioCierreCaja;
	}

	public void setActivarFK_IdUsuarioCierreCaja(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioCierreCaja= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaCierreCaja=null;

	public Border getResaltarFK_IdEmpresaCierreCaja() {
		return this.resaltarFK_IdEmpresaCierreCaja;
	}

	public void setResaltarFK_IdEmpresaCierreCaja(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCierreCaja= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCierreCaja= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCierreCaja=null;

	public Border getResaltarFK_IdSucursalCierreCaja() {
		return this.resaltarFK_IdSucursalCierreCaja;
	}

	public void setResaltarFK_IdSucursalCierreCaja(Border borderResaltar) {
		this.resaltarFK_IdSucursalCierreCaja= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCierreCaja= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoCierreCaja=null;

	public Border getResaltarFK_IdTipoFormaPagoCierreCaja() {
		return this.resaltarFK_IdTipoFormaPagoCierreCaja;
	}

	public void setResaltarFK_IdTipoFormaPagoCierreCaja(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoCierreCaja= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoCierreCaja= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioCierreCaja=null;

	public Border getResaltarFK_IdUsuarioCierreCaja() {
		return this.resaltarFK_IdUsuarioCierreCaja;
	}

	public void setResaltarFK_IdUsuarioCierreCaja(Border borderResaltar) {
		this.resaltarFK_IdUsuarioCierreCaja= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioCierreCaja(ParametroGeneralUsuario parametroGeneralUsuario/*CierreCajaBeanSwingJInternalFrame cierrecajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioCierreCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}