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


import com.bydan.erp.facturacion.util.FacturaImpresionConstantesFunciones;
import com.bydan.erp.facturacion.util.FacturaImpresionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.FacturaImpresionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturaImpresionConstantesFunciones extends FacturaImpresionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="FacturaImpresion";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturaImpresion"+FacturaImpresionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturaImpresionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturaImpresionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturaImpresionConstantesFunciones.SCHEMA+"_"+FacturaImpresionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturaImpresionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturaImpresionConstantesFunciones.SCHEMA+"_"+FacturaImpresionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturaImpresionConstantesFunciones.SCHEMA+"_"+FacturaImpresionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturaImpresionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturaImpresionConstantesFunciones.SCHEMA+"_"+FacturaImpresionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaImpresionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaImpresionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaImpresionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaImpresionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturaImpresionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturaImpresionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturaImpresionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturaImpresionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturaImpresionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturaImpresionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Factura Impresiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Factura Impresion";
	public static final String SCLASSWEBTITULO_LOWER="Factura Impresion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturaImpresion";
	public static final String OBJECTNAME="facturaimpresion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="factura_impresion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturaimpresion from "+FacturaImpresionConstantesFunciones.SPERSISTENCENAME+" facturaimpresion";
	public static String QUERYSELECTNATIVE="select "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".version_row,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id_empresa,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id_sucursal,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id_factura,"+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME+".id_estado_factu_impre from "+FacturaImpresionConstantesFunciones.SCHEMA+"."+FacturaImpresionConstantesFunciones.TABLENAME;//+" as "+FacturaImpresionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected FacturaImpresionConstantesFuncionesAdditional facturaimpresionConstantesFuncionesAdditional=null;
	
	public FacturaImpresionConstantesFuncionesAdditional getFacturaImpresionConstantesFuncionesAdditional() {
		return this.facturaimpresionConstantesFuncionesAdditional;
	}
	
	public void setFacturaImpresionConstantesFuncionesAdditional(FacturaImpresionConstantesFuncionesAdditional facturaimpresionConstantesFuncionesAdditional) {
		try {
			this.facturaimpresionConstantesFuncionesAdditional=facturaimpresionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDFACTURA= "id_factura";
    public static final String IDESTADOFACTUIMPRE= "id_estado_factu_impre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_IDESTADOFACTUIMPRE= "Estado Factu Impre";
		public static final String LABEL_IDESTADOFACTUIMPRE_LOWER= "Estado Factu Impre";
	
		
		
		
		
		
		
	
	public static String getFacturaImpresionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturaImpresionConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturaImpresionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturaImpresionConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FacturaImpresionConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FacturaImpresionConstantesFunciones.IDFACTURA)) {sLabelColumna=FacturaImpresionConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE)) {sLabelColumna=FacturaImpresionConstantesFunciones.LABEL_IDESTADOFACTUIMPRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getFacturaImpresionDescripcion(FacturaImpresion facturaimpresion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturaimpresion !=null/* && facturaimpresion.getId()!=0*/) {
			if(facturaimpresion.getId()!=null) {
				sDescripcion=facturaimpresion.getId().toString();
			}//facturaimpresionfacturaimpresion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturaImpresionDescripcionDetallado(FacturaImpresion facturaimpresion) {
		String sDescripcion="";
			
		sDescripcion+=FacturaImpresionConstantesFunciones.ID+"=";
		sDescripcion+=facturaimpresion.getId().toString()+",";
		sDescripcion+=FacturaImpresionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturaimpresion.getVersionRow().toString()+",";
		sDescripcion+=FacturaImpresionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturaimpresion.getid_empresa().toString()+",";
		sDescripcion+=FacturaImpresionConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=facturaimpresion.getid_sucursal().toString()+",";
		sDescripcion+=FacturaImpresionConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=facturaimpresion.getid_factura().toString()+",";
		sDescripcion+=FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE+"=";
		sDescripcion+=facturaimpresion.getid_estado_factu_impre().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturaImpresionDescripcion(FacturaImpresion facturaimpresion,String sValor) throws Exception {			
		if(facturaimpresion !=null) {
			//facturaimpresionfacturaimpresion.getId().toString();
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

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
		}

		return sDescripcion;
	}

	public static String getEstadoFactuImpreDescripcion(EstadoFactuImpre estadofactuimpre) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadofactuimpre!=null/*&&estadofactuimpre.getId()>0*/) {
			sDescripcion=EstadoFactuImpreConstantesFunciones.getEstadoFactuImpreDescripcion(estadofactuimpre);
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
		} else if(sNombreIndice.equals("FK_IdEstadoFactuImpre")) {
			sNombreIndice="Tipo=  Por Estado Factu Impre";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdEstadoFactuImpre(Long id_estado_factu_impre) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_factu_impre!=null) {sDetalleIndice+=" Codigo Unico De Estado Factu Impre="+id_estado_factu_impre.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturaImpresion(FacturaImpresion facturaimpresion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosFacturaImpresions(List<FacturaImpresion> facturaimpresions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturaImpresion facturaimpresion: facturaimpresions) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaImpresion(FacturaImpresion facturaimpresion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturaimpresion.getConCambioAuxiliar()) {
			facturaimpresion.setIsDeleted(facturaimpresion.getIsDeletedAuxiliar());	
			facturaimpresion.setIsNew(facturaimpresion.getIsNewAuxiliar());	
			facturaimpresion.setIsChanged(facturaimpresion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturaimpresion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturaimpresion.setIsDeletedAuxiliar(false);	
			facturaimpresion.setIsNewAuxiliar(false);	
			facturaimpresion.setIsChangedAuxiliar(false);
			
			facturaimpresion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturaImpresions(List<FacturaImpresion> facturaimpresions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturaImpresion facturaimpresion : facturaimpresions) {
			if(conAsignarBase && facturaimpresion.getConCambioAuxiliar()) {
				facturaimpresion.setIsDeleted(facturaimpresion.getIsDeletedAuxiliar());	
				facturaimpresion.setIsNew(facturaimpresion.getIsNewAuxiliar());	
				facturaimpresion.setIsChanged(facturaimpresion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturaimpresion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturaimpresion.setIsDeletedAuxiliar(false);	
				facturaimpresion.setIsNewAuxiliar(false);	
				facturaimpresion.setIsChangedAuxiliar(false);
				
				facturaimpresion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturaImpresion(FacturaImpresion facturaimpresion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturaImpresions(List<FacturaImpresion> facturaimpresions,Boolean conEnteros) throws Exception  {
		
		for(FacturaImpresion facturaimpresion: facturaimpresions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturaImpresion(List<FacturaImpresion> facturaimpresions,FacturaImpresion facturaimpresionAux) throws Exception  {
		FacturaImpresionConstantesFunciones.InicializarValoresFacturaImpresion(facturaimpresionAux,true);
		
		for(FacturaImpresion facturaimpresion: facturaimpresions) {
			if(facturaimpresion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaImpresion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturaImpresionConstantesFunciones.getArrayColumnasGlobalesFacturaImpresion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturaImpresion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaImpresionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaImpresionConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturaImpresionConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturaImpresionConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturaImpresion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturaImpresion> facturaimpresions,FacturaImpresion facturaimpresion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturaImpresion facturaimpresionAux: facturaimpresions) {
			if(facturaimpresionAux!=null && facturaimpresion!=null) {
				if((facturaimpresionAux.getId()==null && facturaimpresion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturaimpresionAux.getId()!=null && facturaimpresion.getId()!=null){
					if(facturaimpresionAux.getId().equals(facturaimpresion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturaImpresion(List<FacturaImpresion> facturaimpresions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(FacturaImpresion facturaimpresion: facturaimpresions) {			
			if(facturaimpresion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturaImpresion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturaImpresionConstantesFunciones.LABEL_ID, FacturaImpresionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaImpresionConstantesFunciones.LABEL_VERSIONROW, FacturaImpresionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaImpresionConstantesFunciones.LABEL_IDEMPRESA, FacturaImpresionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaImpresionConstantesFunciones.LABEL_IDSUCURSAL, FacturaImpresionConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaImpresionConstantesFunciones.LABEL_IDFACTURA, FacturaImpresionConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturaImpresionConstantesFunciones.LABEL_IDESTADOFACTUIMPRE, FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturaImpresion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturaImpresionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaImpresionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaImpresionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaImpresionConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaImpresionConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaImpresion() throws Exception  {
		return FacturaImpresionConstantesFunciones.getTiposSeleccionarFacturaImpresion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaImpresion(Boolean conFk) throws Exception  {
		return FacturaImpresionConstantesFunciones.getTiposSeleccionarFacturaImpresion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturaImpresion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaImpresionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturaImpresionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaImpresionConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FacturaImpresionConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaImpresionConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(FacturaImpresionConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturaImpresionConstantesFunciones.LABEL_IDESTADOFACTUIMPRE);
			reporte.setsDescripcion(FacturaImpresionConstantesFunciones.LABEL_IDESTADOFACTUIMPRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturaImpresion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaImpresion(FacturaImpresion facturaimpresionAux) throws Exception {
		
			facturaimpresionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaimpresionAux.getEmpresa()));
			facturaimpresionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturaimpresionAux.getSucursal()));
			facturaimpresionAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(facturaimpresionAux.getFactura()));
			facturaimpresionAux.setestadofactuimpre_descripcion(EstadoFactuImpreConstantesFunciones.getEstadoFactuImpreDescripcion(facturaimpresionAux.getEstadoFactuImpre()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturaImpresion(List<FacturaImpresion> facturaimpresionsTemp) throws Exception {
		for(FacturaImpresion facturaimpresionAux:facturaimpresionsTemp) {
			
			facturaimpresionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturaimpresionAux.getEmpresa()));
			facturaimpresionAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturaimpresionAux.getSucursal()));
			facturaimpresionAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(facturaimpresionAux.getFactura()));
			facturaimpresionAux.setestadofactuimpre_descripcion(EstadoFactuImpreConstantesFunciones.getEstadoFactuImpreDescripcion(facturaimpresionAux.getEstadoFactuImpre()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaImpresion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(EstadoFactuImpre.class));
				
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
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoFactuImpre.class)) {
						classes.add(new Classe(EstadoFactuImpre.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturaImpresion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(EstadoFactuImpre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoFactuImpre.class)); continue;
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

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(EstadoFactuImpre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoFactuImpre.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaImpresion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaImpresionConstantesFunciones.getClassesRelationshipsOfFacturaImpresion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaImpresion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaImpresion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturaImpresionConstantesFunciones.getClassesRelationshipsFromStringsOfFacturaImpresion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturaImpresion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FacturaImpresion facturaimpresion,List<FacturaImpresion> facturaimpresions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			FacturaImpresion facturaimpresionEncontrado=null;
			
			for(FacturaImpresion facturaimpresionLocal:facturaimpresions) {
				if(facturaimpresionLocal.getId().equals(facturaimpresion.getId())) {
					facturaimpresionEncontrado=facturaimpresionLocal;
					
					facturaimpresionLocal.setIsChanged(facturaimpresion.getIsChanged());
					facturaimpresionLocal.setIsNew(facturaimpresion.getIsNew());
					facturaimpresionLocal.setIsDeleted(facturaimpresion.getIsDeleted());
					
					facturaimpresionLocal.setGeneralEntityOriginal(facturaimpresion.getGeneralEntityOriginal());
					
					facturaimpresionLocal.setId(facturaimpresion.getId());	
					facturaimpresionLocal.setVersionRow(facturaimpresion.getVersionRow());	
					facturaimpresionLocal.setid_empresa(facturaimpresion.getid_empresa());	
					facturaimpresionLocal.setid_sucursal(facturaimpresion.getid_sucursal());	
					facturaimpresionLocal.setid_factura(facturaimpresion.getid_factura());	
					facturaimpresionLocal.setid_estado_factu_impre(facturaimpresion.getid_estado_factu_impre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!facturaimpresion.getIsDeleted()) {
				if(!existe) {
					facturaimpresions.add(facturaimpresion);
				}
			} else {
				if(facturaimpresionEncontrado!=null && permiteQuitar)  {
					facturaimpresions.remove(facturaimpresionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(FacturaImpresion facturaimpresion,List<FacturaImpresion> facturaimpresions) throws Exception {
		try	{			
			for(FacturaImpresion facturaimpresionLocal:facturaimpresions) {
				if(facturaimpresionLocal.getId().equals(facturaimpresion.getId())) {
					facturaimpresionLocal.setIsSelected(facturaimpresion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturaImpresion(List<FacturaImpresion> facturaimpresionsAux) throws Exception {
		//this.facturaimpresionsAux=facturaimpresionsAux;
		
		for(FacturaImpresion facturaimpresionAux:facturaimpresionsAux) {
			if(facturaimpresionAux.getIsChanged()) {
				facturaimpresionAux.setIsChanged(false);
			}		
			
			if(facturaimpresionAux.getIsNew()) {
				facturaimpresionAux.setIsNew(false);
			}	
			
			if(facturaimpresionAux.getIsDeleted()) {
				facturaimpresionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturaImpresion(FacturaImpresion facturaimpresionAux) throws Exception {
		//this.facturaimpresionAux=facturaimpresionAux;
		
			if(facturaimpresionAux.getIsChanged()) {
				facturaimpresionAux.setIsChanged(false);
			}		
			
			if(facturaimpresionAux.getIsNew()) {
				facturaimpresionAux.setIsNew(false);
			}	
			
			if(facturaimpresionAux.getIsDeleted()) {
				facturaimpresionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturaImpresion facturaimpresionAsignar,FacturaImpresion facturaimpresion) throws Exception {
		facturaimpresionAsignar.setId(facturaimpresion.getId());	
		facturaimpresionAsignar.setVersionRow(facturaimpresion.getVersionRow());	
		facturaimpresionAsignar.setid_empresa(facturaimpresion.getid_empresa());
		facturaimpresionAsignar.setempresa_descripcion(facturaimpresion.getempresa_descripcion());	
		facturaimpresionAsignar.setid_sucursal(facturaimpresion.getid_sucursal());
		facturaimpresionAsignar.setsucursal_descripcion(facturaimpresion.getsucursal_descripcion());	
		facturaimpresionAsignar.setid_factura(facturaimpresion.getid_factura());
		facturaimpresionAsignar.setfactura_descripcion(facturaimpresion.getfactura_descripcion());	
		facturaimpresionAsignar.setid_estado_factu_impre(facturaimpresion.getid_estado_factu_impre());
		facturaimpresionAsignar.setestadofactuimpre_descripcion(facturaimpresion.getestadofactuimpre_descripcion());	
	}
	
	public static void inicializarFacturaImpresion(FacturaImpresion facturaimpresion) throws Exception {
		try {
				facturaimpresion.setId(0L);	
					
				facturaimpresion.setid_empresa(-1L);	
				facturaimpresion.setid_sucursal(-1L);	
				facturaimpresion.setid_factura(-1L);	
				facturaimpresion.setid_estado_factu_impre(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturaImpresion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaImpresionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaImpresionConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaImpresionConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturaImpresionConstantesFunciones.LABEL_IDESTADOFACTUIMPRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturaImpresion(String sTipo,Row row,Workbook workbook,FacturaImpresion facturaimpresion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaimpresion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaimpresion.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaimpresion.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturaimpresion.getestadofactuimpre_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturaImpresion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryFacturaImpresion() {
		return this.sFinalQueryFacturaImpresion;
	}
	
	public void setsFinalQueryFacturaImpresion(String sFinalQueryFacturaImpresion) {
		this.sFinalQueryFacturaImpresion= sFinalQueryFacturaImpresion;
	}
	
	public Border resaltarSeleccionarFacturaImpresion=null;
	
	public Border setResaltarSeleccionarFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturaimpresionBeanSwingJInternalFrame.jTtoolBarFacturaImpresion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturaImpresion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturaImpresion() {
		return this.resaltarSeleccionarFacturaImpresion;
	}
	
	public void setResaltarSeleccionarFacturaImpresion(Border borderResaltarSeleccionarFacturaImpresion) {
		this.resaltarSeleccionarFacturaImpresion= borderResaltarSeleccionarFacturaImpresion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturaImpresion=null;
	public Boolean mostraridFacturaImpresion=true;
	public Boolean activaridFacturaImpresion=true;

	public Border resaltarid_empresaFacturaImpresion=null;
	public Boolean mostrarid_empresaFacturaImpresion=true;
	public Boolean activarid_empresaFacturaImpresion=true;
	public Boolean cargarid_empresaFacturaImpresion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturaImpresion=false;//ConEventDepend=true

	public Border resaltarid_sucursalFacturaImpresion=null;
	public Boolean mostrarid_sucursalFacturaImpresion=true;
	public Boolean activarid_sucursalFacturaImpresion=true;
	public Boolean cargarid_sucursalFacturaImpresion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFacturaImpresion=false;//ConEventDepend=true

	public Border resaltarid_facturaFacturaImpresion=null;
	public Boolean mostrarid_facturaFacturaImpresion=true;
	public Boolean activarid_facturaFacturaImpresion=true;
	public Boolean cargarid_facturaFacturaImpresion=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaFacturaImpresion=false;//ConEventDepend=true

	public Border resaltarid_estado_factu_impreFacturaImpresion=null;
	public Boolean mostrarid_estado_factu_impreFacturaImpresion=true;
	public Boolean activarid_estado_factu_impreFacturaImpresion=true;
	public Boolean cargarid_estado_factu_impreFacturaImpresion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_factu_impreFacturaImpresion=false;//ConEventDepend=true

	
	

	public Border setResaltaridFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaimpresionBeanSwingJInternalFrame.jTtoolBarFacturaImpresion.setBorder(borderResaltar);
		
		this.resaltaridFacturaImpresion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturaImpresion() {
		return this.resaltaridFacturaImpresion;
	}

	public void setResaltaridFacturaImpresion(Border borderResaltar) {
		this.resaltaridFacturaImpresion= borderResaltar;
	}

	public Boolean getMostraridFacturaImpresion() {
		return this.mostraridFacturaImpresion;
	}

	public void setMostraridFacturaImpresion(Boolean mostraridFacturaImpresion) {
		this.mostraridFacturaImpresion= mostraridFacturaImpresion;
	}

	public Boolean getActivaridFacturaImpresion() {
		return this.activaridFacturaImpresion;
	}

	public void setActivaridFacturaImpresion(Boolean activaridFacturaImpresion) {
		this.activaridFacturaImpresion= activaridFacturaImpresion;
	}

	public Border setResaltarid_empresaFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaimpresionBeanSwingJInternalFrame.jTtoolBarFacturaImpresion.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturaImpresion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturaImpresion() {
		return this.resaltarid_empresaFacturaImpresion;
	}

	public void setResaltarid_empresaFacturaImpresion(Border borderResaltar) {
		this.resaltarid_empresaFacturaImpresion= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturaImpresion() {
		return this.mostrarid_empresaFacturaImpresion;
	}

	public void setMostrarid_empresaFacturaImpresion(Boolean mostrarid_empresaFacturaImpresion) {
		this.mostrarid_empresaFacturaImpresion= mostrarid_empresaFacturaImpresion;
	}

	public Boolean getActivarid_empresaFacturaImpresion() {
		return this.activarid_empresaFacturaImpresion;
	}

	public void setActivarid_empresaFacturaImpresion(Boolean activarid_empresaFacturaImpresion) {
		this.activarid_empresaFacturaImpresion= activarid_empresaFacturaImpresion;
	}

	public Boolean getCargarid_empresaFacturaImpresion() {
		return this.cargarid_empresaFacturaImpresion;
	}

	public void setCargarid_empresaFacturaImpresion(Boolean cargarid_empresaFacturaImpresion) {
		this.cargarid_empresaFacturaImpresion= cargarid_empresaFacturaImpresion;
	}

	public Border setResaltarid_sucursalFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaimpresionBeanSwingJInternalFrame.jTtoolBarFacturaImpresion.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFacturaImpresion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFacturaImpresion() {
		return this.resaltarid_sucursalFacturaImpresion;
	}

	public void setResaltarid_sucursalFacturaImpresion(Border borderResaltar) {
		this.resaltarid_sucursalFacturaImpresion= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFacturaImpresion() {
		return this.mostrarid_sucursalFacturaImpresion;
	}

	public void setMostrarid_sucursalFacturaImpresion(Boolean mostrarid_sucursalFacturaImpresion) {
		this.mostrarid_sucursalFacturaImpresion= mostrarid_sucursalFacturaImpresion;
	}

	public Boolean getActivarid_sucursalFacturaImpresion() {
		return this.activarid_sucursalFacturaImpresion;
	}

	public void setActivarid_sucursalFacturaImpresion(Boolean activarid_sucursalFacturaImpresion) {
		this.activarid_sucursalFacturaImpresion= activarid_sucursalFacturaImpresion;
	}

	public Boolean getCargarid_sucursalFacturaImpresion() {
		return this.cargarid_sucursalFacturaImpresion;
	}

	public void setCargarid_sucursalFacturaImpresion(Boolean cargarid_sucursalFacturaImpresion) {
		this.cargarid_sucursalFacturaImpresion= cargarid_sucursalFacturaImpresion;
	}

	public Border setResaltarid_facturaFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaimpresionBeanSwingJInternalFrame.jTtoolBarFacturaImpresion.setBorder(borderResaltar);
		
		this.resaltarid_facturaFacturaImpresion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaFacturaImpresion() {
		return this.resaltarid_facturaFacturaImpresion;
	}

	public void setResaltarid_facturaFacturaImpresion(Border borderResaltar) {
		this.resaltarid_facturaFacturaImpresion= borderResaltar;
	}

	public Boolean getMostrarid_facturaFacturaImpresion() {
		return this.mostrarid_facturaFacturaImpresion;
	}

	public void setMostrarid_facturaFacturaImpresion(Boolean mostrarid_facturaFacturaImpresion) {
		this.mostrarid_facturaFacturaImpresion= mostrarid_facturaFacturaImpresion;
	}

	public Boolean getActivarid_facturaFacturaImpresion() {
		return this.activarid_facturaFacturaImpresion;
	}

	public void setActivarid_facturaFacturaImpresion(Boolean activarid_facturaFacturaImpresion) {
		this.activarid_facturaFacturaImpresion= activarid_facturaFacturaImpresion;
	}

	public Boolean getCargarid_facturaFacturaImpresion() {
		return this.cargarid_facturaFacturaImpresion;
	}

	public void setCargarid_facturaFacturaImpresion(Boolean cargarid_facturaFacturaImpresion) {
		this.cargarid_facturaFacturaImpresion= cargarid_facturaFacturaImpresion;
	}

	public Border setResaltarid_estado_factu_impreFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturaimpresionBeanSwingJInternalFrame.jTtoolBarFacturaImpresion.setBorder(borderResaltar);
		
		this.resaltarid_estado_factu_impreFacturaImpresion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_factu_impreFacturaImpresion() {
		return this.resaltarid_estado_factu_impreFacturaImpresion;
	}

	public void setResaltarid_estado_factu_impreFacturaImpresion(Border borderResaltar) {
		this.resaltarid_estado_factu_impreFacturaImpresion= borderResaltar;
	}

	public Boolean getMostrarid_estado_factu_impreFacturaImpresion() {
		return this.mostrarid_estado_factu_impreFacturaImpresion;
	}

	public void setMostrarid_estado_factu_impreFacturaImpresion(Boolean mostrarid_estado_factu_impreFacturaImpresion) {
		this.mostrarid_estado_factu_impreFacturaImpresion= mostrarid_estado_factu_impreFacturaImpresion;
	}

	public Boolean getActivarid_estado_factu_impreFacturaImpresion() {
		return this.activarid_estado_factu_impreFacturaImpresion;
	}

	public void setActivarid_estado_factu_impreFacturaImpresion(Boolean activarid_estado_factu_impreFacturaImpresion) {
		this.activarid_estado_factu_impreFacturaImpresion= activarid_estado_factu_impreFacturaImpresion;
	}

	public Boolean getCargarid_estado_factu_impreFacturaImpresion() {
		return this.cargarid_estado_factu_impreFacturaImpresion;
	}

	public void setCargarid_estado_factu_impreFacturaImpresion(Boolean cargarid_estado_factu_impreFacturaImpresion) {
		this.cargarid_estado_factu_impreFacturaImpresion= cargarid_estado_factu_impreFacturaImpresion;
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
		
		
		this.setMostraridFacturaImpresion(esInicial);
		this.setMostrarid_empresaFacturaImpresion(esInicial);
		this.setMostrarid_sucursalFacturaImpresion(esInicial);
		this.setMostrarid_facturaFacturaImpresion(esInicial);
		this.setMostrarid_estado_factu_impreFacturaImpresion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.ID)) {
				this.setMostraridFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE)) {
				this.setMostrarid_estado_factu_impreFacturaImpresion(esAsigna);
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
		
		
		this.setActivaridFacturaImpresion(esInicial);
		this.setActivarid_empresaFacturaImpresion(esInicial);
		this.setActivarid_sucursalFacturaImpresion(esInicial);
		this.setActivarid_facturaFacturaImpresion(esInicial);
		this.setActivarid_estado_factu_impreFacturaImpresion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.ID)) {
				this.setActivaridFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE)) {
				this.setActivarid_estado_factu_impreFacturaImpresion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturaImpresion(esInicial);
		this.setResaltarid_empresaFacturaImpresion(esInicial);
		this.setResaltarid_sucursalFacturaImpresion(esInicial);
		this.setResaltarid_facturaFacturaImpresion(esInicial);
		this.setResaltarid_estado_factu_impreFacturaImpresion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.ID)) {
				this.setResaltaridFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaFacturaImpresion(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturaImpresionConstantesFunciones.IDESTADOFACTUIMPRE)) {
				this.setResaltarid_estado_factu_impreFacturaImpresion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaFacturaImpresion=true;

	public Boolean getMostrarFK_IdEmpresaFacturaImpresion() {
		return this.mostrarFK_IdEmpresaFacturaImpresion;
	}

	public void setMostrarFK_IdEmpresaFacturaImpresion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaFacturaImpresion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoFactuImpreFacturaImpresion=true;

	public Boolean getMostrarFK_IdEstadoFactuImpreFacturaImpresion() {
		return this.mostrarFK_IdEstadoFactuImpreFacturaImpresion;
	}

	public void setMostrarFK_IdEstadoFactuImpreFacturaImpresion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoFactuImpreFacturaImpresion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaFacturaImpresion=true;

	public Boolean getMostrarFK_IdFacturaFacturaImpresion() {
		return this.mostrarFK_IdFacturaFacturaImpresion;
	}

	public void setMostrarFK_IdFacturaFacturaImpresion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaFacturaImpresion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalFacturaImpresion=true;

	public Boolean getMostrarFK_IdSucursalFacturaImpresion() {
		return this.mostrarFK_IdSucursalFacturaImpresion;
	}

	public void setMostrarFK_IdSucursalFacturaImpresion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalFacturaImpresion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaFacturaImpresion=true;

	public Boolean getActivarFK_IdEmpresaFacturaImpresion() {
		return this.activarFK_IdEmpresaFacturaImpresion;
	}

	public void setActivarFK_IdEmpresaFacturaImpresion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaFacturaImpresion= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoFactuImpreFacturaImpresion=true;

	public Boolean getActivarFK_IdEstadoFactuImpreFacturaImpresion() {
		return this.activarFK_IdEstadoFactuImpreFacturaImpresion;
	}

	public void setActivarFK_IdEstadoFactuImpreFacturaImpresion(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoFactuImpreFacturaImpresion= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaFacturaImpresion=true;

	public Boolean getActivarFK_IdFacturaFacturaImpresion() {
		return this.activarFK_IdFacturaFacturaImpresion;
	}

	public void setActivarFK_IdFacturaFacturaImpresion(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaFacturaImpresion= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalFacturaImpresion=true;

	public Boolean getActivarFK_IdSucursalFacturaImpresion() {
		return this.activarFK_IdSucursalFacturaImpresion;
	}

	public void setActivarFK_IdSucursalFacturaImpresion(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalFacturaImpresion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaFacturaImpresion=null;

	public Border getResaltarFK_IdEmpresaFacturaImpresion() {
		return this.resaltarFK_IdEmpresaFacturaImpresion;
	}

	public void setResaltarFK_IdEmpresaFacturaImpresion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaFacturaImpresion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaFacturaImpresion= borderResaltar;
	}

	public Border resaltarFK_IdEstadoFactuImpreFacturaImpresion=null;

	public Border getResaltarFK_IdEstadoFactuImpreFacturaImpresion() {
		return this.resaltarFK_IdEstadoFactuImpreFacturaImpresion;
	}

	public void setResaltarFK_IdEstadoFactuImpreFacturaImpresion(Border borderResaltar) {
		this.resaltarFK_IdEstadoFactuImpreFacturaImpresion= borderResaltar;
	}

	public void setResaltarFK_IdEstadoFactuImpreFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoFactuImpreFacturaImpresion= borderResaltar;
	}

	public Border resaltarFK_IdFacturaFacturaImpresion=null;

	public Border getResaltarFK_IdFacturaFacturaImpresion() {
		return this.resaltarFK_IdFacturaFacturaImpresion;
	}

	public void setResaltarFK_IdFacturaFacturaImpresion(Border borderResaltar) {
		this.resaltarFK_IdFacturaFacturaImpresion= borderResaltar;
	}

	public void setResaltarFK_IdFacturaFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaFacturaImpresion= borderResaltar;
	}

	public Border resaltarFK_IdSucursalFacturaImpresion=null;

	public Border getResaltarFK_IdSucursalFacturaImpresion() {
		return this.resaltarFK_IdSucursalFacturaImpresion;
	}

	public void setResaltarFK_IdSucursalFacturaImpresion(Border borderResaltar) {
		this.resaltarFK_IdSucursalFacturaImpresion= borderResaltar;
	}

	public void setResaltarFK_IdSucursalFacturaImpresion(ParametroGeneralUsuario parametroGeneralUsuario/*FacturaImpresionBeanSwingJInternalFrame facturaimpresionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalFacturaImpresion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}