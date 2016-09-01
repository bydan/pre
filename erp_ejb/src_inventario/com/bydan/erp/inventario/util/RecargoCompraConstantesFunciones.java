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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.RecargoCompraConstantesFunciones;
import com.bydan.erp.inventario.util.RecargoCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RecargoCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RecargoCompraConstantesFunciones extends RecargoCompraConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RecargoCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RecargoCompra"+RecargoCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RecargoCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RecargoCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RecargoCompraConstantesFunciones.SCHEMA+"_"+RecargoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RecargoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RecargoCompraConstantesFunciones.SCHEMA+"_"+RecargoCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RecargoCompraConstantesFunciones.SCHEMA+"_"+RecargoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RecargoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RecargoCompraConstantesFunciones.SCHEMA+"_"+RecargoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RecargoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RecargoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RecargoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RecargoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RecargoCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RecargoCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RecargoCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RecargoCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RecargoCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RecargoCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Recargo Compraes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Recargo Compra";
	public static final String SCLASSWEBTITULO_LOWER="Recargo Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RecargoCompra";
	public static final String OBJECTNAME="recargocompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="recargo_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select recargocompra from "+RecargoCompraConstantesFunciones.SPERSISTENCENAME+" recargocompra";
	public static String QUERYSELECTNATIVE="select "+RecargoCompraConstantesFunciones.SCHEMA+"."+RecargoCompraConstantesFunciones.TABLENAME+".id,"+RecargoCompraConstantesFunciones.SCHEMA+"."+RecargoCompraConstantesFunciones.TABLENAME+".version_row,"+RecargoCompraConstantesFunciones.SCHEMA+"."+RecargoCompraConstantesFunciones.TABLENAME+".id_empresa,"+RecargoCompraConstantesFunciones.SCHEMA+"."+RecargoCompraConstantesFunciones.TABLENAME+".nombre,"+RecargoCompraConstantesFunciones.SCHEMA+"."+RecargoCompraConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+RecargoCompraConstantesFunciones.SCHEMA+"."+RecargoCompraConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+RecargoCompraConstantesFunciones.SCHEMA+"."+RecargoCompraConstantesFunciones.TABLENAME+".es_servicio from "+RecargoCompraConstantesFunciones.SCHEMA+"."+RecargoCompraConstantesFunciones.TABLENAME;//+" as "+RecargoCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RecargoCompraConstantesFuncionesAdditional recargocompraConstantesFuncionesAdditional=null;
	
	public RecargoCompraConstantesFuncionesAdditional getRecargoCompraConstantesFuncionesAdditional() {
		return this.recargocompraConstantesFuncionesAdditional;
	}
	
	public void setRecargoCompraConstantesFuncionesAdditional(RecargoCompraConstantesFuncionesAdditional recargocompraConstantesFuncionesAdditional) {
		try {
			this.recargocompraConstantesFuncionesAdditional=recargocompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String IDCUENTACONTABLEDEBITO= "id_cuenta_contable_debito";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String ESSERVICIO= "es_servicio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDCUENTACONTABLEDEBITO= "Cuenta C. Debito";
		public static final String LABEL_IDCUENTACONTABLEDEBITO_LOWER= "Cuenta Contable Debito";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta C. Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_ESSERVICIO= "Es Servicio";
		public static final String LABEL_ESSERVICIO_LOWER= "Es Servicio";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getRecargoCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RecargoCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=RecargoCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RecargoCompraConstantesFunciones.NOMBRE)) {sLabelColumna=RecargoCompraConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO)) {sLabelColumna=RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO;}
		if(sNombreColumna.equals(RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(RecargoCompraConstantesFunciones.ESSERVICIO)) {sLabelColumna=RecargoCompraConstantesFunciones.LABEL_ESSERVICIO;}
		
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
	
	
	
			
			
			
			
			
			
		
	public static String getes_servicioDescripcion(RecargoCompra recargocompra) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!recargocompra.getes_servicio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_servicioHtmlDescripcion(RecargoCompra recargocompra) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(recargocompra.getId(),recargocompra.getes_servicio());

		return sDescripcion;
	}	
	
	public static String getRecargoCompraDescripcion(RecargoCompra recargocompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(recargocompra !=null/* && recargocompra.getId()!=0*/) {
			sDescripcion=recargocompra.getnombre();//recargocomprarecargocompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRecargoCompraDescripcionDetallado(RecargoCompra recargocompra) {
		String sDescripcion="";
			
		sDescripcion+=RecargoCompraConstantesFunciones.ID+"=";
		sDescripcion+=recargocompra.getId().toString()+",";
		sDescripcion+=RecargoCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=recargocompra.getVersionRow().toString()+",";
		sDescripcion+=RecargoCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=recargocompra.getid_empresa().toString()+",";
		sDescripcion+=RecargoCompraConstantesFunciones.NOMBRE+"=";
		sDescripcion+=recargocompra.getnombre()+",";
		sDescripcion+=RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO+"=";
		sDescripcion+=recargocompra.getid_cuenta_contable_debito().toString()+",";
		sDescripcion+=RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=recargocompra.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=RecargoCompraConstantesFunciones.ESSERVICIO+"=";
		sDescripcion+=recargocompra.getes_servicio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRecargoCompraDescripcion(RecargoCompra recargocompra,String sValor) throws Exception {			
		if(recargocompra !=null) {
			recargocompra.setnombre(sValor);//recargocomprarecargocompra.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDebitoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Credito";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDebito")) {
			sNombreIndice="Tipo=  Por Cuenta C. Debito";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDebito(Long id_cuenta_contable_debito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_debito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Debito="+id_cuenta_contable_debito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRecargoCompra(RecargoCompra recargocompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		recargocompra.setnombre(recargocompra.getnombre().trim());
	}
	
	public static void quitarEspaciosRecargoCompras(List<RecargoCompra> recargocompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RecargoCompra recargocompra: recargocompras) {
			recargocompra.setnombre(recargocompra.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRecargoCompra(RecargoCompra recargocompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && recargocompra.getConCambioAuxiliar()) {
			recargocompra.setIsDeleted(recargocompra.getIsDeletedAuxiliar());	
			recargocompra.setIsNew(recargocompra.getIsNewAuxiliar());	
			recargocompra.setIsChanged(recargocompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			recargocompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			recargocompra.setIsDeletedAuxiliar(false);	
			recargocompra.setIsNewAuxiliar(false);	
			recargocompra.setIsChangedAuxiliar(false);
			
			recargocompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRecargoCompras(List<RecargoCompra> recargocompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RecargoCompra recargocompra : recargocompras) {
			if(conAsignarBase && recargocompra.getConCambioAuxiliar()) {
				recargocompra.setIsDeleted(recargocompra.getIsDeletedAuxiliar());	
				recargocompra.setIsNew(recargocompra.getIsNewAuxiliar());	
				recargocompra.setIsChanged(recargocompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				recargocompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				recargocompra.setIsDeletedAuxiliar(false);	
				recargocompra.setIsNewAuxiliar(false);	
				recargocompra.setIsChangedAuxiliar(false);
				
				recargocompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRecargoCompra(RecargoCompra recargocompra,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRecargoCompras(List<RecargoCompra> recargocompras,Boolean conEnteros) throws Exception  {
		
		for(RecargoCompra recargocompra: recargocompras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRecargoCompra(List<RecargoCompra> recargocompras,RecargoCompra recargocompraAux) throws Exception  {
		RecargoCompraConstantesFunciones.InicializarValoresRecargoCompra(recargocompraAux,true);
		
		for(RecargoCompra recargocompra: recargocompras) {
			if(recargocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRecargoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RecargoCompraConstantesFunciones.getArrayColumnasGlobalesRecargoCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRecargoCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RecargoCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RecargoCompraConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRecargoCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RecargoCompra> recargocompras,RecargoCompra recargocompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RecargoCompra recargocompraAux: recargocompras) {
			if(recargocompraAux!=null && recargocompra!=null) {
				if((recargocompraAux.getId()==null && recargocompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(recargocompraAux.getId()!=null && recargocompra.getId()!=null){
					if(recargocompraAux.getId().equals(recargocompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRecargoCompra(List<RecargoCompra> recargocompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(RecargoCompra recargocompra: recargocompras) {			
			if(recargocompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRecargoCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RecargoCompraConstantesFunciones.LABEL_ID, RecargoCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecargoCompraConstantesFunciones.LABEL_VERSIONROW, RecargoCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecargoCompraConstantesFunciones.LABEL_IDEMPRESA, RecargoCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecargoCompraConstantesFunciones.LABEL_NOMBRE, RecargoCompraConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO, RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RecargoCompraConstantesFunciones.LABEL_ESSERVICIO, RecargoCompraConstantesFunciones.ESSERVICIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRecargoCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RecargoCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecargoCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecargoCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecargoCompraConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RecargoCompraConstantesFunciones.ESSERVICIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRecargoCompra() throws Exception  {
		return RecargoCompraConstantesFunciones.getTiposSeleccionarRecargoCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRecargoCompra(Boolean conFk) throws Exception  {
		return RecargoCompraConstantesFunciones.getTiposSeleccionarRecargoCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRecargoCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RecargoCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RecargoCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecargoCompraConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(RecargoCompraConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
			reporte.setsDescripcion(RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RecargoCompraConstantesFunciones.LABEL_ESSERVICIO);
			reporte.setsDescripcion(RecargoCompraConstantesFunciones.LABEL_ESSERVICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRecargoCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRecargoCompra(RecargoCompra recargocompraAux) throws Exception {
		
			recargocompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(recargocompraAux.getEmpresa()));
			recargocompraAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(recargocompraAux.getCuentaContableDebito()));
			recargocompraAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(recargocompraAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRecargoCompra(List<RecargoCompra> recargocomprasTemp) throws Exception {
		for(RecargoCompra recargocompraAux:recargocomprasTemp) {
			
			recargocompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(recargocompraAux.getEmpresa()));
			recargocompraAux.setcuentacontabledebito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(recargocompraAux.getCuentaContableDebito()));
			recargocompraAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(recargocompraAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRecargoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRecargoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRecargoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RecargoCompraConstantesFunciones.getClassesRelationshipsOfRecargoCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRecargoCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRecargoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RecargoCompraConstantesFunciones.getClassesRelationshipsFromStringsOfRecargoCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRecargoCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RecargoCompra recargocompra,List<RecargoCompra> recargocompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RecargoCompra recargocompraEncontrado=null;
			
			for(RecargoCompra recargocompraLocal:recargocompras) {
				if(recargocompraLocal.getId().equals(recargocompra.getId())) {
					recargocompraEncontrado=recargocompraLocal;
					
					recargocompraLocal.setIsChanged(recargocompra.getIsChanged());
					recargocompraLocal.setIsNew(recargocompra.getIsNew());
					recargocompraLocal.setIsDeleted(recargocompra.getIsDeleted());
					
					recargocompraLocal.setGeneralEntityOriginal(recargocompra.getGeneralEntityOriginal());
					
					recargocompraLocal.setId(recargocompra.getId());	
					recargocompraLocal.setVersionRow(recargocompra.getVersionRow());	
					recargocompraLocal.setid_empresa(recargocompra.getid_empresa());	
					recargocompraLocal.setnombre(recargocompra.getnombre());	
					recargocompraLocal.setid_cuenta_contable_debito(recargocompra.getid_cuenta_contable_debito());	
					recargocompraLocal.setid_cuenta_contable_credito(recargocompra.getid_cuenta_contable_credito());	
					recargocompraLocal.setes_servicio(recargocompra.getes_servicio());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!recargocompra.getIsDeleted()) {
				if(!existe) {
					recargocompras.add(recargocompra);
				}
			} else {
				if(recargocompraEncontrado!=null && permiteQuitar)  {
					recargocompras.remove(recargocompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RecargoCompra recargocompra,List<RecargoCompra> recargocompras) throws Exception {
		try	{			
			for(RecargoCompra recargocompraLocal:recargocompras) {
				if(recargocompraLocal.getId().equals(recargocompra.getId())) {
					recargocompraLocal.setIsSelected(recargocompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRecargoCompra(List<RecargoCompra> recargocomprasAux) throws Exception {
		//this.recargocomprasAux=recargocomprasAux;
		
		for(RecargoCompra recargocompraAux:recargocomprasAux) {
			if(recargocompraAux.getIsChanged()) {
				recargocompraAux.setIsChanged(false);
			}		
			
			if(recargocompraAux.getIsNew()) {
				recargocompraAux.setIsNew(false);
			}	
			
			if(recargocompraAux.getIsDeleted()) {
				recargocompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRecargoCompra(RecargoCompra recargocompraAux) throws Exception {
		//this.recargocompraAux=recargocompraAux;
		
			if(recargocompraAux.getIsChanged()) {
				recargocompraAux.setIsChanged(false);
			}		
			
			if(recargocompraAux.getIsNew()) {
				recargocompraAux.setIsNew(false);
			}	
			
			if(recargocompraAux.getIsDeleted()) {
				recargocompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RecargoCompra recargocompraAsignar,RecargoCompra recargocompra) throws Exception {
		recargocompraAsignar.setId(recargocompra.getId());	
		recargocompraAsignar.setVersionRow(recargocompra.getVersionRow());	
		recargocompraAsignar.setid_empresa(recargocompra.getid_empresa());
		recargocompraAsignar.setempresa_descripcion(recargocompra.getempresa_descripcion());	
		recargocompraAsignar.setnombre(recargocompra.getnombre());	
		recargocompraAsignar.setid_cuenta_contable_debito(recargocompra.getid_cuenta_contable_debito());
		recargocompraAsignar.setcuentacontabledebito_descripcion(recargocompra.getcuentacontabledebito_descripcion());	
		recargocompraAsignar.setid_cuenta_contable_credito(recargocompra.getid_cuenta_contable_credito());
		recargocompraAsignar.setcuentacontablecredito_descripcion(recargocompra.getcuentacontablecredito_descripcion());	
		recargocompraAsignar.setes_servicio(recargocompra.getes_servicio());	
	}
	
	public static void inicializarRecargoCompra(RecargoCompra recargocompra) throws Exception {
		try {
				recargocompra.setId(0L);	
					
				recargocompra.setid_empresa(-1L);	
				recargocompra.setnombre("");	
				recargocompra.setid_cuenta_contable_debito(-1L);	
				recargocompra.setid_cuenta_contable_credito(-1L);	
				recargocompra.setes_servicio(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRecargoCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RecargoCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecargoCompraConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLEDEBITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecargoCompraConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RecargoCompraConstantesFunciones.LABEL_ESSERVICIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRecargoCompra(String sTipo,Row row,Workbook workbook,RecargoCompra recargocompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(recargocompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recargocompra.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recargocompra.getcuentacontabledebito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(recargocompra.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(recargocompra.getes_servicio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRecargoCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRecargoCompra() {
		return this.sFinalQueryRecargoCompra;
	}
	
	public void setsFinalQueryRecargoCompra(String sFinalQueryRecargoCompra) {
		this.sFinalQueryRecargoCompra= sFinalQueryRecargoCompra;
	}
	
	public Border resaltarSeleccionarRecargoCompra=null;
	
	public Border setResaltarSeleccionarRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//recargocompraBeanSwingJInternalFrame.jTtoolBarRecargoCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRecargoCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRecargoCompra() {
		return this.resaltarSeleccionarRecargoCompra;
	}
	
	public void setResaltarSeleccionarRecargoCompra(Border borderResaltarSeleccionarRecargoCompra) {
		this.resaltarSeleccionarRecargoCompra= borderResaltarSeleccionarRecargoCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRecargoCompra=null;
	public Boolean mostraridRecargoCompra=true;
	public Boolean activaridRecargoCompra=true;

	public Border resaltarid_empresaRecargoCompra=null;
	public Boolean mostrarid_empresaRecargoCompra=true;
	public Boolean activarid_empresaRecargoCompra=true;
	public Boolean cargarid_empresaRecargoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRecargoCompra=false;//ConEventDepend=true

	public Border resaltarnombreRecargoCompra=null;
	public Boolean mostrarnombreRecargoCompra=true;
	public Boolean activarnombreRecargoCompra=true;

	public Border resaltarid_cuenta_contable_debitoRecargoCompra=null;
	public Boolean mostrarid_cuenta_contable_debitoRecargoCompra=true;
	public Boolean activarid_cuenta_contable_debitoRecargoCompra=true;
	public Boolean cargarid_cuenta_contable_debitoRecargoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_debitoRecargoCompra=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoRecargoCompra=null;
	public Boolean mostrarid_cuenta_contable_creditoRecargoCompra=true;
	public Boolean activarid_cuenta_contable_creditoRecargoCompra=true;
	public Boolean cargarid_cuenta_contable_creditoRecargoCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoRecargoCompra=false;//ConEventDepend=true

	public Border resaltares_servicioRecargoCompra=null;
	public Boolean mostrares_servicioRecargoCompra=true;
	public Boolean activares_servicioRecargoCompra=true;

	
	

	public Border setResaltaridRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recargocompraBeanSwingJInternalFrame.jTtoolBarRecargoCompra.setBorder(borderResaltar);
		
		this.resaltaridRecargoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRecargoCompra() {
		return this.resaltaridRecargoCompra;
	}

	public void setResaltaridRecargoCompra(Border borderResaltar) {
		this.resaltaridRecargoCompra= borderResaltar;
	}

	public Boolean getMostraridRecargoCompra() {
		return this.mostraridRecargoCompra;
	}

	public void setMostraridRecargoCompra(Boolean mostraridRecargoCompra) {
		this.mostraridRecargoCompra= mostraridRecargoCompra;
	}

	public Boolean getActivaridRecargoCompra() {
		return this.activaridRecargoCompra;
	}

	public void setActivaridRecargoCompra(Boolean activaridRecargoCompra) {
		this.activaridRecargoCompra= activaridRecargoCompra;
	}

	public Border setResaltarid_empresaRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recargocompraBeanSwingJInternalFrame.jTtoolBarRecargoCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaRecargoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRecargoCompra() {
		return this.resaltarid_empresaRecargoCompra;
	}

	public void setResaltarid_empresaRecargoCompra(Border borderResaltar) {
		this.resaltarid_empresaRecargoCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaRecargoCompra() {
		return this.mostrarid_empresaRecargoCompra;
	}

	public void setMostrarid_empresaRecargoCompra(Boolean mostrarid_empresaRecargoCompra) {
		this.mostrarid_empresaRecargoCompra= mostrarid_empresaRecargoCompra;
	}

	public Boolean getActivarid_empresaRecargoCompra() {
		return this.activarid_empresaRecargoCompra;
	}

	public void setActivarid_empresaRecargoCompra(Boolean activarid_empresaRecargoCompra) {
		this.activarid_empresaRecargoCompra= activarid_empresaRecargoCompra;
	}

	public Boolean getCargarid_empresaRecargoCompra() {
		return this.cargarid_empresaRecargoCompra;
	}

	public void setCargarid_empresaRecargoCompra(Boolean cargarid_empresaRecargoCompra) {
		this.cargarid_empresaRecargoCompra= cargarid_empresaRecargoCompra;
	}

	public Border setResaltarnombreRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recargocompraBeanSwingJInternalFrame.jTtoolBarRecargoCompra.setBorder(borderResaltar);
		
		this.resaltarnombreRecargoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreRecargoCompra() {
		return this.resaltarnombreRecargoCompra;
	}

	public void setResaltarnombreRecargoCompra(Border borderResaltar) {
		this.resaltarnombreRecargoCompra= borderResaltar;
	}

	public Boolean getMostrarnombreRecargoCompra() {
		return this.mostrarnombreRecargoCompra;
	}

	public void setMostrarnombreRecargoCompra(Boolean mostrarnombreRecargoCompra) {
		this.mostrarnombreRecargoCompra= mostrarnombreRecargoCompra;
	}

	public Boolean getActivarnombreRecargoCompra() {
		return this.activarnombreRecargoCompra;
	}

	public void setActivarnombreRecargoCompra(Boolean activarnombreRecargoCompra) {
		this.activarnombreRecargoCompra= activarnombreRecargoCompra;
	}

	public Border setResaltarid_cuenta_contable_debitoRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recargocompraBeanSwingJInternalFrame.jTtoolBarRecargoCompra.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_debitoRecargoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_debitoRecargoCompra() {
		return this.resaltarid_cuenta_contable_debitoRecargoCompra;
	}

	public void setResaltarid_cuenta_contable_debitoRecargoCompra(Border borderResaltar) {
		this.resaltarid_cuenta_contable_debitoRecargoCompra= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_debitoRecargoCompra() {
		return this.mostrarid_cuenta_contable_debitoRecargoCompra;
	}

	public void setMostrarid_cuenta_contable_debitoRecargoCompra(Boolean mostrarid_cuenta_contable_debitoRecargoCompra) {
		this.mostrarid_cuenta_contable_debitoRecargoCompra= mostrarid_cuenta_contable_debitoRecargoCompra;
	}

	public Boolean getActivarid_cuenta_contable_debitoRecargoCompra() {
		return this.activarid_cuenta_contable_debitoRecargoCompra;
	}

	public void setActivarid_cuenta_contable_debitoRecargoCompra(Boolean activarid_cuenta_contable_debitoRecargoCompra) {
		this.activarid_cuenta_contable_debitoRecargoCompra= activarid_cuenta_contable_debitoRecargoCompra;
	}

	public Boolean getCargarid_cuenta_contable_debitoRecargoCompra() {
		return this.cargarid_cuenta_contable_debitoRecargoCompra;
	}

	public void setCargarid_cuenta_contable_debitoRecargoCompra(Boolean cargarid_cuenta_contable_debitoRecargoCompra) {
		this.cargarid_cuenta_contable_debitoRecargoCompra= cargarid_cuenta_contable_debitoRecargoCompra;
	}

	public Border setResaltarid_cuenta_contable_creditoRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recargocompraBeanSwingJInternalFrame.jTtoolBarRecargoCompra.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoRecargoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoRecargoCompra() {
		return this.resaltarid_cuenta_contable_creditoRecargoCompra;
	}

	public void setResaltarid_cuenta_contable_creditoRecargoCompra(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoRecargoCompra= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoRecargoCompra() {
		return this.mostrarid_cuenta_contable_creditoRecargoCompra;
	}

	public void setMostrarid_cuenta_contable_creditoRecargoCompra(Boolean mostrarid_cuenta_contable_creditoRecargoCompra) {
		this.mostrarid_cuenta_contable_creditoRecargoCompra= mostrarid_cuenta_contable_creditoRecargoCompra;
	}

	public Boolean getActivarid_cuenta_contable_creditoRecargoCompra() {
		return this.activarid_cuenta_contable_creditoRecargoCompra;
	}

	public void setActivarid_cuenta_contable_creditoRecargoCompra(Boolean activarid_cuenta_contable_creditoRecargoCompra) {
		this.activarid_cuenta_contable_creditoRecargoCompra= activarid_cuenta_contable_creditoRecargoCompra;
	}

	public Boolean getCargarid_cuenta_contable_creditoRecargoCompra() {
		return this.cargarid_cuenta_contable_creditoRecargoCompra;
	}

	public void setCargarid_cuenta_contable_creditoRecargoCompra(Boolean cargarid_cuenta_contable_creditoRecargoCompra) {
		this.cargarid_cuenta_contable_creditoRecargoCompra= cargarid_cuenta_contable_creditoRecargoCompra;
	}

	public Border setResaltares_servicioRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//recargocompraBeanSwingJInternalFrame.jTtoolBarRecargoCompra.setBorder(borderResaltar);
		
		this.resaltares_servicioRecargoCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_servicioRecargoCompra() {
		return this.resaltares_servicioRecargoCompra;
	}

	public void setResaltares_servicioRecargoCompra(Border borderResaltar) {
		this.resaltares_servicioRecargoCompra= borderResaltar;
	}

	public Boolean getMostrares_servicioRecargoCompra() {
		return this.mostrares_servicioRecargoCompra;
	}

	public void setMostrares_servicioRecargoCompra(Boolean mostrares_servicioRecargoCompra) {
		this.mostrares_servicioRecargoCompra= mostrares_servicioRecargoCompra;
	}

	public Boolean getActivares_servicioRecargoCompra() {
		return this.activares_servicioRecargoCompra;
	}

	public void setActivares_servicioRecargoCompra(Boolean activares_servicioRecargoCompra) {
		this.activares_servicioRecargoCompra= activares_servicioRecargoCompra;
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
		
		
		this.setMostraridRecargoCompra(esInicial);
		this.setMostrarid_empresaRecargoCompra(esInicial);
		this.setMostrarnombreRecargoCompra(esInicial);
		this.setMostrarid_cuenta_contable_debitoRecargoCompra(esInicial);
		this.setMostrarid_cuenta_contable_creditoRecargoCompra(esInicial);
		this.setMostrares_servicioRecargoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RecargoCompraConstantesFunciones.ID)) {
				this.setMostraridRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setMostrarid_cuenta_contable_debitoRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.ESSERVICIO)) {
				this.setMostrares_servicioRecargoCompra(esAsigna);
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
		
		
		this.setActivaridRecargoCompra(esInicial);
		this.setActivarid_empresaRecargoCompra(esInicial);
		this.setActivarnombreRecargoCompra(esInicial);
		this.setActivarid_cuenta_contable_debitoRecargoCompra(esInicial);
		this.setActivarid_cuenta_contable_creditoRecargoCompra(esInicial);
		this.setActivares_servicioRecargoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RecargoCompraConstantesFunciones.ID)) {
				this.setActivaridRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.NOMBRE)) {
				this.setActivarnombreRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setActivarid_cuenta_contable_debitoRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.ESSERVICIO)) {
				this.setActivares_servicioRecargoCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRecargoCompra(esInicial);
		this.setResaltarid_empresaRecargoCompra(esInicial);
		this.setResaltarnombreRecargoCompra(esInicial);
		this.setResaltarid_cuenta_contable_debitoRecargoCompra(esInicial);
		this.setResaltarid_cuenta_contable_creditoRecargoCompra(esInicial);
		this.setResaltares_servicioRecargoCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RecargoCompraConstantesFunciones.ID)) {
				this.setResaltaridRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDCUENTACONTABLEDEBITO)) {
				this.setResaltarid_cuenta_contable_debitoRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoRecargoCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RecargoCompraConstantesFunciones.ESSERVICIO)) {
				this.setResaltares_servicioRecargoCompra(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreRecargoCompra=true;

	public Boolean getMostrarBusquedaPorNombreRecargoCompra() {
		return this.mostrarBusquedaPorNombreRecargoCompra;
	}

	public void setMostrarBusquedaPorNombreRecargoCompra(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreRecargoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoRecargoCompra=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoRecargoCompra() {
		return this.mostrarFK_IdCuentaContableCreditoRecargoCompra;
	}

	public void setMostrarFK_IdCuentaContableCreditoRecargoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoRecargoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDebitoRecargoCompra=true;

	public Boolean getMostrarFK_IdCuentaContableDebitoRecargoCompra() {
		return this.mostrarFK_IdCuentaContableDebitoRecargoCompra;
	}

	public void setMostrarFK_IdCuentaContableDebitoRecargoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDebitoRecargoCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRecargoCompra=true;

	public Boolean getMostrarFK_IdEmpresaRecargoCompra() {
		return this.mostrarFK_IdEmpresaRecargoCompra;
	}

	public void setMostrarFK_IdEmpresaRecargoCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRecargoCompra= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreRecargoCompra=true;

	public Boolean getActivarBusquedaPorNombreRecargoCompra() {
		return this.activarBusquedaPorNombreRecargoCompra;
	}

	public void setActivarBusquedaPorNombreRecargoCompra(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreRecargoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoRecargoCompra=true;

	public Boolean getActivarFK_IdCuentaContableCreditoRecargoCompra() {
		return this.activarFK_IdCuentaContableCreditoRecargoCompra;
	}

	public void setActivarFK_IdCuentaContableCreditoRecargoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoRecargoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDebitoRecargoCompra=true;

	public Boolean getActivarFK_IdCuentaContableDebitoRecargoCompra() {
		return this.activarFK_IdCuentaContableDebitoRecargoCompra;
	}

	public void setActivarFK_IdCuentaContableDebitoRecargoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDebitoRecargoCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRecargoCompra=true;

	public Boolean getActivarFK_IdEmpresaRecargoCompra() {
		return this.activarFK_IdEmpresaRecargoCompra;
	}

	public void setActivarFK_IdEmpresaRecargoCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRecargoCompra= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreRecargoCompra=null;

	public Border getResaltarBusquedaPorNombreRecargoCompra() {
		return this.resaltarBusquedaPorNombreRecargoCompra;
	}

	public void setResaltarBusquedaPorNombreRecargoCompra(Border borderResaltar) {
		this.resaltarBusquedaPorNombreRecargoCompra= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreRecargoCompra= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoRecargoCompra=null;

	public Border getResaltarFK_IdCuentaContableCreditoRecargoCompra() {
		return this.resaltarFK_IdCuentaContableCreditoRecargoCompra;
	}

	public void setResaltarFK_IdCuentaContableCreditoRecargoCompra(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoRecargoCompra= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoRecargoCompra= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDebitoRecargoCompra=null;

	public Border getResaltarFK_IdCuentaContableDebitoRecargoCompra() {
		return this.resaltarFK_IdCuentaContableDebitoRecargoCompra;
	}

	public void setResaltarFK_IdCuentaContableDebitoRecargoCompra(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDebitoRecargoCompra= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDebitoRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDebitoRecargoCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRecargoCompra=null;

	public Border getResaltarFK_IdEmpresaRecargoCompra() {
		return this.resaltarFK_IdEmpresaRecargoCompra;
	}

	public void setResaltarFK_IdEmpresaRecargoCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRecargoCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRecargoCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RecargoCompraBeanSwingJInternalFrame recargocompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRecargoCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}