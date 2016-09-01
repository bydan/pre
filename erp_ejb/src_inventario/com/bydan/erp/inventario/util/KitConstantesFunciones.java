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


import com.bydan.erp.inventario.util.KitConstantesFunciones;
import com.bydan.erp.inventario.util.KitParameterReturnGeneral;
//import com.bydan.erp.inventario.util.KitParameterGeneral;

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
final public class KitConstantesFunciones extends KitConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Kit";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Kit"+KitConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="KitHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="KitHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=KitConstantesFunciones.SCHEMA+"_"+KitConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/KitHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=KitConstantesFunciones.SCHEMA+"_"+KitConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=KitConstantesFunciones.SCHEMA+"_"+KitConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/KitHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=KitConstantesFunciones.SCHEMA+"_"+KitConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+KitConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/KitHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+KitConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+KitConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/KitHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+KitConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=KitConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+KitConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=KitConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+KitConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Kites";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Kit";
	public static final String SCLASSWEBTITULO_LOWER="Kit";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Kit";
	public static final String OBJECTNAME="kit";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="kit";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select kit from "+KitConstantesFunciones.SPERSISTENCENAME+" kit";
	public static String QUERYSELECTNATIVE="select "+KitConstantesFunciones.SCHEMA+"."+KitConstantesFunciones.TABLENAME+".id,"+KitConstantesFunciones.SCHEMA+"."+KitConstantesFunciones.TABLENAME+".version_row,"+KitConstantesFunciones.SCHEMA+"."+KitConstantesFunciones.TABLENAME+".id_empresa,"+KitConstantesFunciones.SCHEMA+"."+KitConstantesFunciones.TABLENAME+".id_sucursal,"+KitConstantesFunciones.SCHEMA+"."+KitConstantesFunciones.TABLENAME+".descripcion from "+KitConstantesFunciones.SCHEMA+"."+KitConstantesFunciones.TABLENAME;//+" as "+KitConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected KitConstantesFuncionesAdditional kitConstantesFuncionesAdditional=null;
	
	public KitConstantesFuncionesAdditional getKitConstantesFuncionesAdditional() {
		return this.kitConstantesFuncionesAdditional;
	}
	
	public void setKitConstantesFuncionesAdditional(KitConstantesFuncionesAdditional kitConstantesFuncionesAdditional) {
		try {
			this.kitConstantesFuncionesAdditional=kitConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getKitLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(KitConstantesFunciones.IDEMPRESA)) {sLabelColumna=KitConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(KitConstantesFunciones.IDSUCURSAL)) {sLabelColumna=KitConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(KitConstantesFunciones.DESCRIPCION)) {sLabelColumna=KitConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getKitDescripcion(Kit kit) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(kit !=null/* && kit.getId()!=0*/) {
			sDescripcion=kit.getdescripcion();//kitkit.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getKitDescripcionDetallado(Kit kit) {
		String sDescripcion="";
			
		sDescripcion+=KitConstantesFunciones.ID+"=";
		sDescripcion+=kit.getId().toString()+",";
		sDescripcion+=KitConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=kit.getVersionRow().toString()+",";
		sDescripcion+=KitConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=kit.getid_empresa().toString()+",";
		sDescripcion+=KitConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=kit.getid_sucursal().toString()+",";
		sDescripcion+=KitConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=kit.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setKitDescripcion(Kit kit,String sValor) throws Exception {			
		if(kit !=null) {
			kit.setdescripcion(sValor);//kitkit.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
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
	
	
	
	
	
	
	public static void quitarEspaciosKit(Kit kit,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		kit.setdescripcion(kit.getdescripcion().trim());
	}
	
	public static void quitarEspaciosKits(List<Kit> kits,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Kit kit: kits) {
			kit.setdescripcion(kit.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresKit(Kit kit,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && kit.getConCambioAuxiliar()) {
			kit.setIsDeleted(kit.getIsDeletedAuxiliar());	
			kit.setIsNew(kit.getIsNewAuxiliar());	
			kit.setIsChanged(kit.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			kit.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			kit.setIsDeletedAuxiliar(false);	
			kit.setIsNewAuxiliar(false);	
			kit.setIsChangedAuxiliar(false);
			
			kit.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresKits(List<Kit> kits,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Kit kit : kits) {
			if(conAsignarBase && kit.getConCambioAuxiliar()) {
				kit.setIsDeleted(kit.getIsDeletedAuxiliar());	
				kit.setIsNew(kit.getIsNewAuxiliar());	
				kit.setIsChanged(kit.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				kit.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				kit.setIsDeletedAuxiliar(false);	
				kit.setIsNewAuxiliar(false);	
				kit.setIsChangedAuxiliar(false);
				
				kit.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresKit(Kit kit,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresKits(List<Kit> kits,Boolean conEnteros) throws Exception  {
		
		for(Kit kit: kits) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaKit(List<Kit> kits,Kit kitAux) throws Exception  {
		KitConstantesFunciones.InicializarValoresKit(kitAux,true);
		
		for(Kit kit: kits) {
			if(kit.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesKit(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=KitConstantesFunciones.getArrayColumnasGlobalesKit(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesKit(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(KitConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(KitConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(KitConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(KitConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoKit(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Kit> kits,Kit kit,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Kit kitAux: kits) {
			if(kitAux!=null && kit!=null) {
				if((kitAux.getId()==null && kit.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(kitAux.getId()!=null && kit.getId()!=null){
					if(kitAux.getId().equals(kit.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaKit(List<Kit> kits) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Kit kit: kits) {			
			if(kit.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaKit() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,KitConstantesFunciones.LABEL_ID, KitConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,KitConstantesFunciones.LABEL_VERSIONROW, KitConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,KitConstantesFunciones.LABEL_IDEMPRESA, KitConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,KitConstantesFunciones.LABEL_IDSUCURSAL, KitConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,KitConstantesFunciones.LABEL_DESCRIPCION, KitConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasKit() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=KitConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=KitConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=KitConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=KitConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=KitConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarKit() throws Exception  {
		return KitConstantesFunciones.getTiposSeleccionarKit(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarKit(Boolean conFk) throws Exception  {
		return KitConstantesFunciones.getTiposSeleccionarKit(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarKit(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(KitConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(KitConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(KitConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(KitConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(KitConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(KitConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesKit(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesKit(Kit kitAux) throws Exception {
		
			kitAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(kitAux.getEmpresa()));
			kitAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(kitAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesKit(List<Kit> kitsTemp) throws Exception {
		for(Kit kitAux:kitsTemp) {
			
			kitAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(kitAux.getEmpresa()));
			kitAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(kitAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfKit(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfKit(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfKit(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return KitConstantesFunciones.getClassesRelationshipsOfKit(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfKit(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CompoKit.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CompoKit.class)) {
						classes.add(new Classe(CompoKit.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfKit(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return KitConstantesFunciones.getClassesRelationshipsFromStringsOfKit(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfKit(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CompoKit.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CompoKit.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CompoKit.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CompoKit.class)); continue;
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
	public static void actualizarLista(Kit kit,List<Kit> kits,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Kit kitEncontrado=null;
			
			for(Kit kitLocal:kits) {
				if(kitLocal.getId().equals(kit.getId())) {
					kitEncontrado=kitLocal;
					
					kitLocal.setIsChanged(kit.getIsChanged());
					kitLocal.setIsNew(kit.getIsNew());
					kitLocal.setIsDeleted(kit.getIsDeleted());
					
					kitLocal.setGeneralEntityOriginal(kit.getGeneralEntityOriginal());
					
					kitLocal.setId(kit.getId());	
					kitLocal.setVersionRow(kit.getVersionRow());	
					kitLocal.setid_empresa(kit.getid_empresa());	
					kitLocal.setid_sucursal(kit.getid_sucursal());	
					kitLocal.setdescripcion(kit.getdescripcion());	
					
					
					kitLocal.setCompoKits(kit.getCompoKits());
					
					existe=true;
					break;
				}
			}
			
			if(!kit.getIsDeleted()) {
				if(!existe) {
					kits.add(kit);
				}
			} else {
				if(kitEncontrado!=null && permiteQuitar)  {
					kits.remove(kitEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Kit kit,List<Kit> kits) throws Exception {
		try	{			
			for(Kit kitLocal:kits) {
				if(kitLocal.getId().equals(kit.getId())) {
					kitLocal.setIsSelected(kit.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesKit(List<Kit> kitsAux) throws Exception {
		//this.kitsAux=kitsAux;
		
		for(Kit kitAux:kitsAux) {
			if(kitAux.getIsChanged()) {
				kitAux.setIsChanged(false);
			}		
			
			if(kitAux.getIsNew()) {
				kitAux.setIsNew(false);
			}	
			
			if(kitAux.getIsDeleted()) {
				kitAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesKit(Kit kitAux) throws Exception {
		//this.kitAux=kitAux;
		
			if(kitAux.getIsChanged()) {
				kitAux.setIsChanged(false);
			}		
			
			if(kitAux.getIsNew()) {
				kitAux.setIsNew(false);
			}	
			
			if(kitAux.getIsDeleted()) {
				kitAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Kit kitAsignar,Kit kit) throws Exception {
		kitAsignar.setId(kit.getId());	
		kitAsignar.setVersionRow(kit.getVersionRow());	
		kitAsignar.setid_empresa(kit.getid_empresa());
		kitAsignar.setempresa_descripcion(kit.getempresa_descripcion());	
		kitAsignar.setid_sucursal(kit.getid_sucursal());
		kitAsignar.setsucursal_descripcion(kit.getsucursal_descripcion());	
		kitAsignar.setdescripcion(kit.getdescripcion());	
	}
	
	public static void inicializarKit(Kit kit) throws Exception {
		try {
				kit.setId(0L);	
					
				kit.setid_empresa(-1L);	
				kit.setid_sucursal(-1L);	
				kit.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderKit(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(KitConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(KitConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(KitConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataKit(String sTipo,Row row,Workbook workbook,Kit kit,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(kit.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(kit.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(kit.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryKit=Constantes.SFINALQUERY;
	
	public String getsFinalQueryKit() {
		return this.sFinalQueryKit;
	}
	
	public void setsFinalQueryKit(String sFinalQueryKit) {
		this.sFinalQueryKit= sFinalQueryKit;
	}
	
	public Border resaltarSeleccionarKit=null;
	
	public Border setResaltarSeleccionarKit(ParametroGeneralUsuario parametroGeneralUsuario/*KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//kitBeanSwingJInternalFrame.jTtoolBarKit.setBorder(borderResaltar);
		
		this.resaltarSeleccionarKit= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarKit() {
		return this.resaltarSeleccionarKit;
	}
	
	public void setResaltarSeleccionarKit(Border borderResaltarSeleccionarKit) {
		this.resaltarSeleccionarKit= borderResaltarSeleccionarKit;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridKit=null;
	public Boolean mostraridKit=true;
	public Boolean activaridKit=true;

	public Border resaltarid_empresaKit=null;
	public Boolean mostrarid_empresaKit=true;
	public Boolean activarid_empresaKit=true;
	public Boolean cargarid_empresaKit=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaKit=false;//ConEventDepend=true

	public Border resaltarid_sucursalKit=null;
	public Boolean mostrarid_sucursalKit=true;
	public Boolean activarid_sucursalKit=true;
	public Boolean cargarid_sucursalKit=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalKit=false;//ConEventDepend=true

	public Border resaltardescripcionKit=null;
	public Boolean mostrardescripcionKit=true;
	public Boolean activardescripcionKit=true;

	
	

	public Border setResaltaridKit(ParametroGeneralUsuario parametroGeneralUsuario/*KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//kitBeanSwingJInternalFrame.jTtoolBarKit.setBorder(borderResaltar);
		
		this.resaltaridKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridKit() {
		return this.resaltaridKit;
	}

	public void setResaltaridKit(Border borderResaltar) {
		this.resaltaridKit= borderResaltar;
	}

	public Boolean getMostraridKit() {
		return this.mostraridKit;
	}

	public void setMostraridKit(Boolean mostraridKit) {
		this.mostraridKit= mostraridKit;
	}

	public Boolean getActivaridKit() {
		return this.activaridKit;
	}

	public void setActivaridKit(Boolean activaridKit) {
		this.activaridKit= activaridKit;
	}

	public Border setResaltarid_empresaKit(ParametroGeneralUsuario parametroGeneralUsuario/*KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//kitBeanSwingJInternalFrame.jTtoolBarKit.setBorder(borderResaltar);
		
		this.resaltarid_empresaKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaKit() {
		return this.resaltarid_empresaKit;
	}

	public void setResaltarid_empresaKit(Border borderResaltar) {
		this.resaltarid_empresaKit= borderResaltar;
	}

	public Boolean getMostrarid_empresaKit() {
		return this.mostrarid_empresaKit;
	}

	public void setMostrarid_empresaKit(Boolean mostrarid_empresaKit) {
		this.mostrarid_empresaKit= mostrarid_empresaKit;
	}

	public Boolean getActivarid_empresaKit() {
		return this.activarid_empresaKit;
	}

	public void setActivarid_empresaKit(Boolean activarid_empresaKit) {
		this.activarid_empresaKit= activarid_empresaKit;
	}

	public Boolean getCargarid_empresaKit() {
		return this.cargarid_empresaKit;
	}

	public void setCargarid_empresaKit(Boolean cargarid_empresaKit) {
		this.cargarid_empresaKit= cargarid_empresaKit;
	}

	public Border setResaltarid_sucursalKit(ParametroGeneralUsuario parametroGeneralUsuario/*KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//kitBeanSwingJInternalFrame.jTtoolBarKit.setBorder(borderResaltar);
		
		this.resaltarid_sucursalKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalKit() {
		return this.resaltarid_sucursalKit;
	}

	public void setResaltarid_sucursalKit(Border borderResaltar) {
		this.resaltarid_sucursalKit= borderResaltar;
	}

	public Boolean getMostrarid_sucursalKit() {
		return this.mostrarid_sucursalKit;
	}

	public void setMostrarid_sucursalKit(Boolean mostrarid_sucursalKit) {
		this.mostrarid_sucursalKit= mostrarid_sucursalKit;
	}

	public Boolean getActivarid_sucursalKit() {
		return this.activarid_sucursalKit;
	}

	public void setActivarid_sucursalKit(Boolean activarid_sucursalKit) {
		this.activarid_sucursalKit= activarid_sucursalKit;
	}

	public Boolean getCargarid_sucursalKit() {
		return this.cargarid_sucursalKit;
	}

	public void setCargarid_sucursalKit(Boolean cargarid_sucursalKit) {
		this.cargarid_sucursalKit= cargarid_sucursalKit;
	}

	public Border setResaltardescripcionKit(ParametroGeneralUsuario parametroGeneralUsuario/*KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//kitBeanSwingJInternalFrame.jTtoolBarKit.setBorder(borderResaltar);
		
		this.resaltardescripcionKit= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionKit() {
		return this.resaltardescripcionKit;
	}

	public void setResaltardescripcionKit(Border borderResaltar) {
		this.resaltardescripcionKit= borderResaltar;
	}

	public Boolean getMostrardescripcionKit() {
		return this.mostrardescripcionKit;
	}

	public void setMostrardescripcionKit(Boolean mostrardescripcionKit) {
		this.mostrardescripcionKit= mostrardescripcionKit;
	}

	public Boolean getActivardescripcionKit() {
		return this.activardescripcionKit;
	}

	public void setActivardescripcionKit(Boolean activardescripcionKit) {
		this.activardescripcionKit= activardescripcionKit;
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
		
		
		this.setMostraridKit(esInicial);
		this.setMostrarid_empresaKit(esInicial);
		this.setMostrarid_sucursalKit(esInicial);
		this.setMostrardescripcionKit(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(KitConstantesFunciones.ID)) {
				this.setMostraridKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionKit(esAsigna);
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
		
		
		this.setActivaridKit(esInicial);
		this.setActivarid_empresaKit(esInicial);
		this.setActivarid_sucursalKit(esInicial);
		this.setActivardescripcionKit(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(KitConstantesFunciones.ID)) {
				this.setActivaridKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionKit(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridKit(esInicial);
		this.setResaltarid_empresaKit(esInicial);
		this.setResaltarid_sucursalKit(esInicial);
		this.setResaltardescripcionKit(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(KitConstantesFunciones.ID)) {
				this.setResaltaridKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalKit(esAsigna);
				continue;
			}

			if(campo.clase.equals(KitConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionKit(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCompoKitKit=null;

	public Border getResaltarCompoKitKit() {
		return this.resaltarCompoKitKit;
	}

	public void setResaltarCompoKitKit(Border borderResaltarCompoKit) {
		if(borderResaltarCompoKit!=null) {
			this.resaltarCompoKitKit= borderResaltarCompoKit;
		}
	}

	public Border setResaltarCompoKitKit(ParametroGeneralUsuario parametroGeneralUsuario/*KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/) {
		Border borderResaltarCompoKit=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//kitBeanSwingJInternalFrame.jTtoolBarKit.setBorder(borderResaltarCompoKit);
			
		this.resaltarCompoKitKit= borderResaltarCompoKit;

		 return borderResaltarCompoKit;
	}



	public Boolean mostrarCompoKitKit=true;

	public Boolean getMostrarCompoKitKit() {
		return this.mostrarCompoKitKit;
	}

	public void setMostrarCompoKitKit(Boolean visibilidadResaltarCompoKit) {
		this.mostrarCompoKitKit= visibilidadResaltarCompoKit;
	}



	public Boolean activarCompoKitKit=true;

	public Boolean gethabilitarResaltarCompoKitKit() {
		return this.activarCompoKitKit;
	}

	public void setActivarCompoKitKit(Boolean habilitarResaltarCompoKit) {
		this.activarCompoKitKit= habilitarResaltarCompoKit;
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

		this.setMostrarCompoKitKit(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CompoKit.class)) {
				this.setMostrarCompoKitKit(esAsigna);
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

		this.setActivarCompoKitKit(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CompoKit.class)) {
				this.setActivarCompoKitKit(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCompoKitKit(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CompoKit.class)) {
				this.setResaltarCompoKitKit(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaKit=true;

	public Boolean getMostrarFK_IdEmpresaKit() {
		return this.mostrarFK_IdEmpresaKit;
	}

	public void setMostrarFK_IdEmpresaKit(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaKit= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalKit=true;

	public Boolean getMostrarFK_IdSucursalKit() {
		return this.mostrarFK_IdSucursalKit;
	}

	public void setMostrarFK_IdSucursalKit(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalKit= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaKit=true;

	public Boolean getActivarFK_IdEmpresaKit() {
		return this.activarFK_IdEmpresaKit;
	}

	public void setActivarFK_IdEmpresaKit(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaKit= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalKit=true;

	public Boolean getActivarFK_IdSucursalKit() {
		return this.activarFK_IdSucursalKit;
	}

	public void setActivarFK_IdSucursalKit(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalKit= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaKit=null;

	public Border getResaltarFK_IdEmpresaKit() {
		return this.resaltarFK_IdEmpresaKit;
	}

	public void setResaltarFK_IdEmpresaKit(Border borderResaltar) {
		this.resaltarFK_IdEmpresaKit= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaKit(ParametroGeneralUsuario parametroGeneralUsuario/*KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaKit= borderResaltar;
	}

	public Border resaltarFK_IdSucursalKit=null;

	public Border getResaltarFK_IdSucursalKit() {
		return this.resaltarFK_IdSucursalKit;
	}

	public void setResaltarFK_IdSucursalKit(Border borderResaltar) {
		this.resaltarFK_IdSucursalKit= borderResaltar;
	}

	public void setResaltarFK_IdSucursalKit(ParametroGeneralUsuario parametroGeneralUsuario/*KitBeanSwingJInternalFrame kitBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalKit= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}