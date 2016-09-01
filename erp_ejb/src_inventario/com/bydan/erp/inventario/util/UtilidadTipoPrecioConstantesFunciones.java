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


import com.bydan.erp.inventario.util.UtilidadTipoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.UtilidadTipoPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UtilidadTipoPrecioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class UtilidadTipoPrecioConstantesFunciones extends UtilidadTipoPrecioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="UtilidadTipoPrecio";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="UtilidadTipoPrecio"+UtilidadTipoPrecioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UtilidadTipoPrecioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UtilidadTipoPrecioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UtilidadTipoPrecioConstantesFunciones.SCHEMA+"_"+UtilidadTipoPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UtilidadTipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UtilidadTipoPrecioConstantesFunciones.SCHEMA+"_"+UtilidadTipoPrecioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UtilidadTipoPrecioConstantesFunciones.SCHEMA+"_"+UtilidadTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UtilidadTipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UtilidadTipoPrecioConstantesFunciones.SCHEMA+"_"+UtilidadTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UtilidadTipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UtilidadTipoPrecioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UtilidadTipoPrecioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UtilidadTipoPrecioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UtilidadTipoPrecioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UtilidadTipoPrecioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UtilidadTipoPrecioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Utilidad Tipo Precioes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Utilidad Tipo Precio";
	public static final String SCLASSWEBTITULO_LOWER="Utilidad Tipo Precio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="UtilidadTipoPrecio";
	public static final String OBJECTNAME="utilidadtipoprecio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="utilidad_tipo_precio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select utilidadtipoprecio from "+UtilidadTipoPrecioConstantesFunciones.SPERSISTENCENAME+" utilidadtipoprecio";
	public static String QUERYSELECTNATIVE="select "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".version_row,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id_empresa,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id_sucursal,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id_tipo_precio,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".porcentaje from "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME;//+" as "+UtilidadTipoPrecioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UtilidadTipoPrecioConstantesFuncionesAdditional utilidadtipoprecioConstantesFuncionesAdditional=null;
	
	public UtilidadTipoPrecioConstantesFuncionesAdditional getUtilidadTipoPrecioConstantesFuncionesAdditional() {
		return this.utilidadtipoprecioConstantesFuncionesAdditional;
	}
	
	public void setUtilidadTipoPrecioConstantesFuncionesAdditional(UtilidadTipoPrecioConstantesFuncionesAdditional utilidadtipoprecioConstantesFuncionesAdditional) {
		try {
			this.utilidadtipoprecioConstantesFuncionesAdditional=utilidadtipoprecioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOPRECIO= "id_tipo_precio";
    public static final String PORCENTAJE= "porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPOPRECIO= "Tipo Precio";
		public static final String LABEL_IDTIPOPRECIO_LOWER= "Tipo Precio";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
		
		
		
		
	
	public static String getUtilidadTipoPrecioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UtilidadTipoPrecioConstantesFunciones.IDEMPRESA)) {sLabelColumna=UtilidadTipoPrecioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL)) {sLabelColumna=UtilidadTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO)) {sLabelColumna=UtilidadTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO;}
		if(sNombreColumna.equals(UtilidadTipoPrecioConstantesFunciones.PORCENTAJE)) {sLabelColumna=UtilidadTipoPrecioConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getUtilidadTipoPrecioDescripcion(UtilidadTipoPrecio utilidadtipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(utilidadtipoprecio !=null/* && utilidadtipoprecio.getId()!=0*/) {
			if(utilidadtipoprecio.getId()!=null) {
				sDescripcion=utilidadtipoprecio.getId().toString();
			}//utilidadtipoprecioutilidadtipoprecio.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getUtilidadTipoPrecioDescripcionDetallado(UtilidadTipoPrecio utilidadtipoprecio) {
		String sDescripcion="";
			
		sDescripcion+=UtilidadTipoPrecioConstantesFunciones.ID+"=";
		sDescripcion+=utilidadtipoprecio.getId().toString()+",";
		sDescripcion+=UtilidadTipoPrecioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=utilidadtipoprecio.getVersionRow().toString()+",";
		sDescripcion+=UtilidadTipoPrecioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=utilidadtipoprecio.getid_empresa().toString()+",";
		sDescripcion+=UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=utilidadtipoprecio.getid_sucursal().toString()+",";
		sDescripcion+=UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO+"=";
		sDescripcion+=utilidadtipoprecio.getid_tipo_precio().toString()+",";
		sDescripcion+=UtilidadTipoPrecioConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=utilidadtipoprecio.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setUtilidadTipoPrecioDescripcion(UtilidadTipoPrecio utilidadtipoprecio,String sValor) throws Exception {			
		if(utilidadtipoprecio !=null) {
			//utilidadtipoprecioutilidadtipoprecio.getId().toString();
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

	public static String getTipoPrecioDescripcion(TipoPrecio tipoprecio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoprecio!=null/*&&tipoprecio.getId()>0*/) {
			sDescripcion=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(tipoprecio);
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
		} else if(sNombreIndice.equals("FK_IdTipoPrecio")) {
			sNombreIndice="Tipo=  Por Tipo Precio";
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

	public static String getDetalleIndiceFK_IdTipoPrecio(Long id_tipo_precio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_precio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Precio="+id_tipo_precio.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUtilidadTipoPrecio(UtilidadTipoPrecio utilidadtipoprecio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosUtilidadTipoPrecios(List<UtilidadTipoPrecio> utilidadtipoprecios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(UtilidadTipoPrecio utilidadtipoprecio: utilidadtipoprecios) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUtilidadTipoPrecio(UtilidadTipoPrecio utilidadtipoprecio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && utilidadtipoprecio.getConCambioAuxiliar()) {
			utilidadtipoprecio.setIsDeleted(utilidadtipoprecio.getIsDeletedAuxiliar());	
			utilidadtipoprecio.setIsNew(utilidadtipoprecio.getIsNewAuxiliar());	
			utilidadtipoprecio.setIsChanged(utilidadtipoprecio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			utilidadtipoprecio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			utilidadtipoprecio.setIsDeletedAuxiliar(false);	
			utilidadtipoprecio.setIsNewAuxiliar(false);	
			utilidadtipoprecio.setIsChangedAuxiliar(false);
			
			utilidadtipoprecio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUtilidadTipoPrecios(List<UtilidadTipoPrecio> utilidadtipoprecios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(UtilidadTipoPrecio utilidadtipoprecio : utilidadtipoprecios) {
			if(conAsignarBase && utilidadtipoprecio.getConCambioAuxiliar()) {
				utilidadtipoprecio.setIsDeleted(utilidadtipoprecio.getIsDeletedAuxiliar());	
				utilidadtipoprecio.setIsNew(utilidadtipoprecio.getIsNewAuxiliar());	
				utilidadtipoprecio.setIsChanged(utilidadtipoprecio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				utilidadtipoprecio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				utilidadtipoprecio.setIsDeletedAuxiliar(false);	
				utilidadtipoprecio.setIsNewAuxiliar(false);	
				utilidadtipoprecio.setIsChangedAuxiliar(false);
				
				utilidadtipoprecio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUtilidadTipoPrecio(UtilidadTipoPrecio utilidadtipoprecio,Boolean conEnteros) throws Exception  {
		utilidadtipoprecio.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresUtilidadTipoPrecios(List<UtilidadTipoPrecio> utilidadtipoprecios,Boolean conEnteros) throws Exception  {
		
		for(UtilidadTipoPrecio utilidadtipoprecio: utilidadtipoprecios) {
			utilidadtipoprecio.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaUtilidadTipoPrecio(List<UtilidadTipoPrecio> utilidadtipoprecios,UtilidadTipoPrecio utilidadtipoprecioAux) throws Exception  {
		UtilidadTipoPrecioConstantesFunciones.InicializarValoresUtilidadTipoPrecio(utilidadtipoprecioAux,true);
		
		for(UtilidadTipoPrecio utilidadtipoprecio: utilidadtipoprecios) {
			if(utilidadtipoprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			utilidadtipoprecioAux.setporcentaje(utilidadtipoprecioAux.getporcentaje()+utilidadtipoprecio.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UtilidadTipoPrecioConstantesFunciones.getArrayColumnasGlobalesUtilidadTipoPrecio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUtilidadTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UtilidadTipoPrecioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UtilidadTipoPrecioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUtilidadTipoPrecio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<UtilidadTipoPrecio> utilidadtipoprecios,UtilidadTipoPrecio utilidadtipoprecio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(UtilidadTipoPrecio utilidadtipoprecioAux: utilidadtipoprecios) {
			if(utilidadtipoprecioAux!=null && utilidadtipoprecio!=null) {
				if((utilidadtipoprecioAux.getId()==null && utilidadtipoprecio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(utilidadtipoprecioAux.getId()!=null && utilidadtipoprecio.getId()!=null){
					if(utilidadtipoprecioAux.getId().equals(utilidadtipoprecio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUtilidadTipoPrecio(List<UtilidadTipoPrecio> utilidadtipoprecios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(UtilidadTipoPrecio utilidadtipoprecio: utilidadtipoprecios) {			
			if(utilidadtipoprecio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=utilidadtipoprecio.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(UtilidadTipoPrecioConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(UtilidadTipoPrecioConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUtilidadTipoPrecio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UtilidadTipoPrecioConstantesFunciones.LABEL_ID, UtilidadTipoPrecioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadTipoPrecioConstantesFunciones.LABEL_VERSIONROW, UtilidadTipoPrecioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadTipoPrecioConstantesFunciones.LABEL_IDEMPRESA, UtilidadTipoPrecioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL, UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO, UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UtilidadTipoPrecioConstantesFunciones.LABEL_PORCENTAJE, UtilidadTipoPrecioConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUtilidadTipoPrecio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UtilidadTipoPrecioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadTipoPrecioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadTipoPrecioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UtilidadTipoPrecioConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadTipoPrecio() throws Exception  {
		return UtilidadTipoPrecioConstantesFunciones.getTiposSeleccionarUtilidadTipoPrecio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadTipoPrecio(Boolean conFk) throws Exception  {
		return UtilidadTipoPrecioConstantesFunciones.getTiposSeleccionarUtilidadTipoPrecio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUtilidadTipoPrecio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadTipoPrecioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(UtilidadTipoPrecioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(UtilidadTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO);
			reporte.setsDescripcion(UtilidadTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UtilidadTipoPrecioConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(UtilidadTipoPrecioConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUtilidadTipoPrecio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUtilidadTipoPrecio(UtilidadTipoPrecio utilidadtipoprecioAux) throws Exception {
		
			utilidadtipoprecioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(utilidadtipoprecioAux.getEmpresa()));
			utilidadtipoprecioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(utilidadtipoprecioAux.getSucursal()));
			utilidadtipoprecioAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(utilidadtipoprecioAux.getTipoPrecio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUtilidadTipoPrecio(List<UtilidadTipoPrecio> utilidadtipopreciosTemp) throws Exception {
		for(UtilidadTipoPrecio utilidadtipoprecioAux:utilidadtipopreciosTemp) {
			
			utilidadtipoprecioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(utilidadtipoprecioAux.getEmpresa()));
			utilidadtipoprecioAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(utilidadtipoprecioAux.getSucursal()));
			utilidadtipoprecioAux.settipoprecio_descripcion(TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(utilidadtipoprecioAux.getTipoPrecio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUtilidadTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoPrecio.class));
				
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
					if(clas.clas.equals(TipoPrecio.class)) {
						classes.add(new Classe(TipoPrecio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUtilidadTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
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

					if(TipoPrecio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoPrecio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UtilidadTipoPrecioConstantesFunciones.getClassesRelationshipsOfUtilidadTipoPrecio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUtilidadTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UtilidadTipoPrecioConstantesFunciones.getClassesRelationshipsFromStringsOfUtilidadTipoPrecio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUtilidadTipoPrecio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(UtilidadTipoPrecio utilidadtipoprecio,List<UtilidadTipoPrecio> utilidadtipoprecios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			UtilidadTipoPrecio utilidadtipoprecioEncontrado=null;
			
			for(UtilidadTipoPrecio utilidadtipoprecioLocal:utilidadtipoprecios) {
				if(utilidadtipoprecioLocal.getId().equals(utilidadtipoprecio.getId())) {
					utilidadtipoprecioEncontrado=utilidadtipoprecioLocal;
					
					utilidadtipoprecioLocal.setIsChanged(utilidadtipoprecio.getIsChanged());
					utilidadtipoprecioLocal.setIsNew(utilidadtipoprecio.getIsNew());
					utilidadtipoprecioLocal.setIsDeleted(utilidadtipoprecio.getIsDeleted());
					
					utilidadtipoprecioLocal.setGeneralEntityOriginal(utilidadtipoprecio.getGeneralEntityOriginal());
					
					utilidadtipoprecioLocal.setId(utilidadtipoprecio.getId());	
					utilidadtipoprecioLocal.setVersionRow(utilidadtipoprecio.getVersionRow());	
					utilidadtipoprecioLocal.setid_empresa(utilidadtipoprecio.getid_empresa());	
					utilidadtipoprecioLocal.setid_sucursal(utilidadtipoprecio.getid_sucursal());	
					utilidadtipoprecioLocal.setid_tipo_precio(utilidadtipoprecio.getid_tipo_precio());	
					utilidadtipoprecioLocal.setporcentaje(utilidadtipoprecio.getporcentaje());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!utilidadtipoprecio.getIsDeleted()) {
				if(!existe) {
					utilidadtipoprecios.add(utilidadtipoprecio);
				}
			} else {
				if(utilidadtipoprecioEncontrado!=null && permiteQuitar)  {
					utilidadtipoprecios.remove(utilidadtipoprecioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(UtilidadTipoPrecio utilidadtipoprecio,List<UtilidadTipoPrecio> utilidadtipoprecios) throws Exception {
		try	{			
			for(UtilidadTipoPrecio utilidadtipoprecioLocal:utilidadtipoprecios) {
				if(utilidadtipoprecioLocal.getId().equals(utilidadtipoprecio.getId())) {
					utilidadtipoprecioLocal.setIsSelected(utilidadtipoprecio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUtilidadTipoPrecio(List<UtilidadTipoPrecio> utilidadtipopreciosAux) throws Exception {
		//this.utilidadtipopreciosAux=utilidadtipopreciosAux;
		
		for(UtilidadTipoPrecio utilidadtipoprecioAux:utilidadtipopreciosAux) {
			if(utilidadtipoprecioAux.getIsChanged()) {
				utilidadtipoprecioAux.setIsChanged(false);
			}		
			
			if(utilidadtipoprecioAux.getIsNew()) {
				utilidadtipoprecioAux.setIsNew(false);
			}	
			
			if(utilidadtipoprecioAux.getIsDeleted()) {
				utilidadtipoprecioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUtilidadTipoPrecio(UtilidadTipoPrecio utilidadtipoprecioAux) throws Exception {
		//this.utilidadtipoprecioAux=utilidadtipoprecioAux;
		
			if(utilidadtipoprecioAux.getIsChanged()) {
				utilidadtipoprecioAux.setIsChanged(false);
			}		
			
			if(utilidadtipoprecioAux.getIsNew()) {
				utilidadtipoprecioAux.setIsNew(false);
			}	
			
			if(utilidadtipoprecioAux.getIsDeleted()) {
				utilidadtipoprecioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(UtilidadTipoPrecio utilidadtipoprecioAsignar,UtilidadTipoPrecio utilidadtipoprecio) throws Exception {
		utilidadtipoprecioAsignar.setId(utilidadtipoprecio.getId());	
		utilidadtipoprecioAsignar.setVersionRow(utilidadtipoprecio.getVersionRow());	
		utilidadtipoprecioAsignar.setid_empresa(utilidadtipoprecio.getid_empresa());
		utilidadtipoprecioAsignar.setempresa_descripcion(utilidadtipoprecio.getempresa_descripcion());	
		utilidadtipoprecioAsignar.setid_sucursal(utilidadtipoprecio.getid_sucursal());
		utilidadtipoprecioAsignar.setsucursal_descripcion(utilidadtipoprecio.getsucursal_descripcion());	
		utilidadtipoprecioAsignar.setid_tipo_precio(utilidadtipoprecio.getid_tipo_precio());
		utilidadtipoprecioAsignar.settipoprecio_descripcion(utilidadtipoprecio.gettipoprecio_descripcion());	
		utilidadtipoprecioAsignar.setporcentaje(utilidadtipoprecio.getporcentaje());	
	}
	
	public static void inicializarUtilidadTipoPrecio(UtilidadTipoPrecio utilidadtipoprecio) throws Exception {
		try {
				utilidadtipoprecio.setId(0L);	
					
				utilidadtipoprecio.setid_empresa(-1L);	
				utilidadtipoprecio.setid_sucursal(-1L);	
				utilidadtipoprecio.setid_tipo_precio(-1L);	
				utilidadtipoprecio.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUtilidadTipoPrecio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadTipoPrecioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadTipoPrecioConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadTipoPrecioConstantesFunciones.LABEL_IDTIPOPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UtilidadTipoPrecioConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUtilidadTipoPrecio(String sTipo,Row row,Workbook workbook,UtilidadTipoPrecio utilidadtipoprecio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadtipoprecio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadtipoprecio.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadtipoprecio.gettipoprecio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(utilidadtipoprecio.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUtilidadTipoPrecio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUtilidadTipoPrecio() {
		return this.sFinalQueryUtilidadTipoPrecio;
	}
	
	public void setsFinalQueryUtilidadTipoPrecio(String sFinalQueryUtilidadTipoPrecio) {
		this.sFinalQueryUtilidadTipoPrecio= sFinalQueryUtilidadTipoPrecio;
	}
	
	public Border resaltarSeleccionarUtilidadTipoPrecio=null;
	
	public Border setResaltarSeleccionarUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//utilidadtipoprecioBeanSwingJInternalFrame.jTtoolBarUtilidadTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUtilidadTipoPrecio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUtilidadTipoPrecio() {
		return this.resaltarSeleccionarUtilidadTipoPrecio;
	}
	
	public void setResaltarSeleccionarUtilidadTipoPrecio(Border borderResaltarSeleccionarUtilidadTipoPrecio) {
		this.resaltarSeleccionarUtilidadTipoPrecio= borderResaltarSeleccionarUtilidadTipoPrecio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUtilidadTipoPrecio=null;
	public Boolean mostraridUtilidadTipoPrecio=true;
	public Boolean activaridUtilidadTipoPrecio=true;

	public Border resaltarid_empresaUtilidadTipoPrecio=null;
	public Boolean mostrarid_empresaUtilidadTipoPrecio=true;
	public Boolean activarid_empresaUtilidadTipoPrecio=true;
	public Boolean cargarid_empresaUtilidadTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaUtilidadTipoPrecio=false;//ConEventDepend=true

	public Border resaltarid_sucursalUtilidadTipoPrecio=null;
	public Boolean mostrarid_sucursalUtilidadTipoPrecio=true;
	public Boolean activarid_sucursalUtilidadTipoPrecio=true;
	public Boolean cargarid_sucursalUtilidadTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalUtilidadTipoPrecio=false;//ConEventDepend=true

	public Border resaltarid_tipo_precioUtilidadTipoPrecio=null;
	public Boolean mostrarid_tipo_precioUtilidadTipoPrecio=true;
	public Boolean activarid_tipo_precioUtilidadTipoPrecio=true;
	public Boolean cargarid_tipo_precioUtilidadTipoPrecio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_precioUtilidadTipoPrecio=false;//ConEventDepend=true

	public Border resaltarporcentajeUtilidadTipoPrecio=null;
	public Boolean mostrarporcentajeUtilidadTipoPrecio=true;
	public Boolean activarporcentajeUtilidadTipoPrecio=true;

	
	

	public Border setResaltaridUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadtipoprecioBeanSwingJInternalFrame.jTtoolBarUtilidadTipoPrecio.setBorder(borderResaltar);
		
		this.resaltaridUtilidadTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUtilidadTipoPrecio() {
		return this.resaltaridUtilidadTipoPrecio;
	}

	public void setResaltaridUtilidadTipoPrecio(Border borderResaltar) {
		this.resaltaridUtilidadTipoPrecio= borderResaltar;
	}

	public Boolean getMostraridUtilidadTipoPrecio() {
		return this.mostraridUtilidadTipoPrecio;
	}

	public void setMostraridUtilidadTipoPrecio(Boolean mostraridUtilidadTipoPrecio) {
		this.mostraridUtilidadTipoPrecio= mostraridUtilidadTipoPrecio;
	}

	public Boolean getActivaridUtilidadTipoPrecio() {
		return this.activaridUtilidadTipoPrecio;
	}

	public void setActivaridUtilidadTipoPrecio(Boolean activaridUtilidadTipoPrecio) {
		this.activaridUtilidadTipoPrecio= activaridUtilidadTipoPrecio;
	}

	public Border setResaltarid_empresaUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadtipoprecioBeanSwingJInternalFrame.jTtoolBarUtilidadTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_empresaUtilidadTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaUtilidadTipoPrecio() {
		return this.resaltarid_empresaUtilidadTipoPrecio;
	}

	public void setResaltarid_empresaUtilidadTipoPrecio(Border borderResaltar) {
		this.resaltarid_empresaUtilidadTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_empresaUtilidadTipoPrecio() {
		return this.mostrarid_empresaUtilidadTipoPrecio;
	}

	public void setMostrarid_empresaUtilidadTipoPrecio(Boolean mostrarid_empresaUtilidadTipoPrecio) {
		this.mostrarid_empresaUtilidadTipoPrecio= mostrarid_empresaUtilidadTipoPrecio;
	}

	public Boolean getActivarid_empresaUtilidadTipoPrecio() {
		return this.activarid_empresaUtilidadTipoPrecio;
	}

	public void setActivarid_empresaUtilidadTipoPrecio(Boolean activarid_empresaUtilidadTipoPrecio) {
		this.activarid_empresaUtilidadTipoPrecio= activarid_empresaUtilidadTipoPrecio;
	}

	public Boolean getCargarid_empresaUtilidadTipoPrecio() {
		return this.cargarid_empresaUtilidadTipoPrecio;
	}

	public void setCargarid_empresaUtilidadTipoPrecio(Boolean cargarid_empresaUtilidadTipoPrecio) {
		this.cargarid_empresaUtilidadTipoPrecio= cargarid_empresaUtilidadTipoPrecio;
	}

	public Border setResaltarid_sucursalUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadtipoprecioBeanSwingJInternalFrame.jTtoolBarUtilidadTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_sucursalUtilidadTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalUtilidadTipoPrecio() {
		return this.resaltarid_sucursalUtilidadTipoPrecio;
	}

	public void setResaltarid_sucursalUtilidadTipoPrecio(Border borderResaltar) {
		this.resaltarid_sucursalUtilidadTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_sucursalUtilidadTipoPrecio() {
		return this.mostrarid_sucursalUtilidadTipoPrecio;
	}

	public void setMostrarid_sucursalUtilidadTipoPrecio(Boolean mostrarid_sucursalUtilidadTipoPrecio) {
		this.mostrarid_sucursalUtilidadTipoPrecio= mostrarid_sucursalUtilidadTipoPrecio;
	}

	public Boolean getActivarid_sucursalUtilidadTipoPrecio() {
		return this.activarid_sucursalUtilidadTipoPrecio;
	}

	public void setActivarid_sucursalUtilidadTipoPrecio(Boolean activarid_sucursalUtilidadTipoPrecio) {
		this.activarid_sucursalUtilidadTipoPrecio= activarid_sucursalUtilidadTipoPrecio;
	}

	public Boolean getCargarid_sucursalUtilidadTipoPrecio() {
		return this.cargarid_sucursalUtilidadTipoPrecio;
	}

	public void setCargarid_sucursalUtilidadTipoPrecio(Boolean cargarid_sucursalUtilidadTipoPrecio) {
		this.cargarid_sucursalUtilidadTipoPrecio= cargarid_sucursalUtilidadTipoPrecio;
	}

	public Border setResaltarid_tipo_precioUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadtipoprecioBeanSwingJInternalFrame.jTtoolBarUtilidadTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarid_tipo_precioUtilidadTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_precioUtilidadTipoPrecio() {
		return this.resaltarid_tipo_precioUtilidadTipoPrecio;
	}

	public void setResaltarid_tipo_precioUtilidadTipoPrecio(Border borderResaltar) {
		this.resaltarid_tipo_precioUtilidadTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarid_tipo_precioUtilidadTipoPrecio() {
		return this.mostrarid_tipo_precioUtilidadTipoPrecio;
	}

	public void setMostrarid_tipo_precioUtilidadTipoPrecio(Boolean mostrarid_tipo_precioUtilidadTipoPrecio) {
		this.mostrarid_tipo_precioUtilidadTipoPrecio= mostrarid_tipo_precioUtilidadTipoPrecio;
	}

	public Boolean getActivarid_tipo_precioUtilidadTipoPrecio() {
		return this.activarid_tipo_precioUtilidadTipoPrecio;
	}

	public void setActivarid_tipo_precioUtilidadTipoPrecio(Boolean activarid_tipo_precioUtilidadTipoPrecio) {
		this.activarid_tipo_precioUtilidadTipoPrecio= activarid_tipo_precioUtilidadTipoPrecio;
	}

	public Boolean getCargarid_tipo_precioUtilidadTipoPrecio() {
		return this.cargarid_tipo_precioUtilidadTipoPrecio;
	}

	public void setCargarid_tipo_precioUtilidadTipoPrecio(Boolean cargarid_tipo_precioUtilidadTipoPrecio) {
		this.cargarid_tipo_precioUtilidadTipoPrecio= cargarid_tipo_precioUtilidadTipoPrecio;
	}

	public Border setResaltarporcentajeUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//utilidadtipoprecioBeanSwingJInternalFrame.jTtoolBarUtilidadTipoPrecio.setBorder(borderResaltar);
		
		this.resaltarporcentajeUtilidadTipoPrecio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeUtilidadTipoPrecio() {
		return this.resaltarporcentajeUtilidadTipoPrecio;
	}

	public void setResaltarporcentajeUtilidadTipoPrecio(Border borderResaltar) {
		this.resaltarporcentajeUtilidadTipoPrecio= borderResaltar;
	}

	public Boolean getMostrarporcentajeUtilidadTipoPrecio() {
		return this.mostrarporcentajeUtilidadTipoPrecio;
	}

	public void setMostrarporcentajeUtilidadTipoPrecio(Boolean mostrarporcentajeUtilidadTipoPrecio) {
		this.mostrarporcentajeUtilidadTipoPrecio= mostrarporcentajeUtilidadTipoPrecio;
	}

	public Boolean getActivarporcentajeUtilidadTipoPrecio() {
		return this.activarporcentajeUtilidadTipoPrecio;
	}

	public void setActivarporcentajeUtilidadTipoPrecio(Boolean activarporcentajeUtilidadTipoPrecio) {
		this.activarporcentajeUtilidadTipoPrecio= activarporcentajeUtilidadTipoPrecio;
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
		
		
		this.setMostraridUtilidadTipoPrecio(esInicial);
		this.setMostrarid_empresaUtilidadTipoPrecio(esInicial);
		this.setMostrarid_sucursalUtilidadTipoPrecio(esInicial);
		this.setMostrarid_tipo_precioUtilidadTipoPrecio(esInicial);
		this.setMostrarporcentajeUtilidadTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.ID)) {
				this.setMostraridUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setMostrarid_tipo_precioUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeUtilidadTipoPrecio(esAsigna);
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
		
		
		this.setActivaridUtilidadTipoPrecio(esInicial);
		this.setActivarid_empresaUtilidadTipoPrecio(esInicial);
		this.setActivarid_sucursalUtilidadTipoPrecio(esInicial);
		this.setActivarid_tipo_precioUtilidadTipoPrecio(esInicial);
		this.setActivarporcentajeUtilidadTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.ID)) {
				this.setActivaridUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setActivarid_tipo_precioUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeUtilidadTipoPrecio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUtilidadTipoPrecio(esInicial);
		this.setResaltarid_empresaUtilidadTipoPrecio(esInicial);
		this.setResaltarid_sucursalUtilidadTipoPrecio(esInicial);
		this.setResaltarid_tipo_precioUtilidadTipoPrecio(esInicial);
		this.setResaltarporcentajeUtilidadTipoPrecio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.ID)) {
				this.setResaltaridUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO)) {
				this.setResaltarid_tipo_precioUtilidadTipoPrecio(esAsigna);
				continue;
			}

			if(campo.clase.equals(UtilidadTipoPrecioConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeUtilidadTipoPrecio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaUtilidadTipoPrecio=true;

	public Boolean getMostrarFK_IdEmpresaUtilidadTipoPrecio() {
		return this.mostrarFK_IdEmpresaUtilidadTipoPrecio;
	}

	public void setMostrarFK_IdEmpresaUtilidadTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaUtilidadTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalUtilidadTipoPrecio=true;

	public Boolean getMostrarFK_IdSucursalUtilidadTipoPrecio() {
		return this.mostrarFK_IdSucursalUtilidadTipoPrecio;
	}

	public void setMostrarFK_IdSucursalUtilidadTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalUtilidadTipoPrecio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoPrecioUtilidadTipoPrecio=true;

	public Boolean getMostrarFK_IdTipoPrecioUtilidadTipoPrecio() {
		return this.mostrarFK_IdTipoPrecioUtilidadTipoPrecio;
	}

	public void setMostrarFK_IdTipoPrecioUtilidadTipoPrecio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoPrecioUtilidadTipoPrecio= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaUtilidadTipoPrecio=true;

	public Boolean getActivarFK_IdEmpresaUtilidadTipoPrecio() {
		return this.activarFK_IdEmpresaUtilidadTipoPrecio;
	}

	public void setActivarFK_IdEmpresaUtilidadTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaUtilidadTipoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalUtilidadTipoPrecio=true;

	public Boolean getActivarFK_IdSucursalUtilidadTipoPrecio() {
		return this.activarFK_IdSucursalUtilidadTipoPrecio;
	}

	public void setActivarFK_IdSucursalUtilidadTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalUtilidadTipoPrecio= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoPrecioUtilidadTipoPrecio=true;

	public Boolean getActivarFK_IdTipoPrecioUtilidadTipoPrecio() {
		return this.activarFK_IdTipoPrecioUtilidadTipoPrecio;
	}

	public void setActivarFK_IdTipoPrecioUtilidadTipoPrecio(Boolean habilitarResaltar) {
		this.activarFK_IdTipoPrecioUtilidadTipoPrecio= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaUtilidadTipoPrecio=null;

	public Border getResaltarFK_IdEmpresaUtilidadTipoPrecio() {
		return this.resaltarFK_IdEmpresaUtilidadTipoPrecio;
	}

	public void setResaltarFK_IdEmpresaUtilidadTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaUtilidadTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaUtilidadTipoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdSucursalUtilidadTipoPrecio=null;

	public Border getResaltarFK_IdSucursalUtilidadTipoPrecio() {
		return this.resaltarFK_IdSucursalUtilidadTipoPrecio;
	}

	public void setResaltarFK_IdSucursalUtilidadTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdSucursalUtilidadTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdSucursalUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalUtilidadTipoPrecio= borderResaltar;
	}

	public Border resaltarFK_IdTipoPrecioUtilidadTipoPrecio=null;

	public Border getResaltarFK_IdTipoPrecioUtilidadTipoPrecio() {
		return this.resaltarFK_IdTipoPrecioUtilidadTipoPrecio;
	}

	public void setResaltarFK_IdTipoPrecioUtilidadTipoPrecio(Border borderResaltar) {
		this.resaltarFK_IdTipoPrecioUtilidadTipoPrecio= borderResaltar;
	}

	public void setResaltarFK_IdTipoPrecioUtilidadTipoPrecio(ParametroGeneralUsuario parametroGeneralUsuario/*UtilidadTipoPrecioBeanSwingJInternalFrame utilidadtipoprecioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoPrecioUtilidadTipoPrecio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}