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


import com.bydan.erp.inventario.util.GrupoColorConstantesFunciones;
import com.bydan.erp.inventario.util.GrupoColorParameterReturnGeneral;
//import com.bydan.erp.inventario.util.GrupoColorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GrupoColorConstantesFunciones extends GrupoColorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GrupoColor";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GrupoColor"+GrupoColorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GrupoColorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GrupoColorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GrupoColorConstantesFunciones.SCHEMA+"_"+GrupoColorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GrupoColorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GrupoColorConstantesFunciones.SCHEMA+"_"+GrupoColorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GrupoColorConstantesFunciones.SCHEMA+"_"+GrupoColorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GrupoColorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GrupoColorConstantesFunciones.SCHEMA+"_"+GrupoColorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoColorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoColorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoColorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoColorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoColorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoColorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GrupoColorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GrupoColorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GrupoColorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GrupoColorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Grupo Colores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Grupo Color";
	public static final String SCLASSWEBTITULO_LOWER="Grupo Color";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GrupoColor";
	public static final String OBJECTNAME="grupocolor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="grupo_color";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select grupocolor from "+GrupoColorConstantesFunciones.SPERSISTENCENAME+" grupocolor";
	public static String QUERYSELECTNATIVE="select "+GrupoColorConstantesFunciones.SCHEMA+"."+GrupoColorConstantesFunciones.TABLENAME+".id,"+GrupoColorConstantesFunciones.SCHEMA+"."+GrupoColorConstantesFunciones.TABLENAME+".version_row,"+GrupoColorConstantesFunciones.SCHEMA+"."+GrupoColorConstantesFunciones.TABLENAME+".id_empresa,"+GrupoColorConstantesFunciones.SCHEMA+"."+GrupoColorConstantesFunciones.TABLENAME+".id_sucursal,"+GrupoColorConstantesFunciones.SCHEMA+"."+GrupoColorConstantesFunciones.TABLENAME+".codigo,"+GrupoColorConstantesFunciones.SCHEMA+"."+GrupoColorConstantesFunciones.TABLENAME+".nombre from "+GrupoColorConstantesFunciones.SCHEMA+"."+GrupoColorConstantesFunciones.TABLENAME;//+" as "+GrupoColorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GrupoColorConstantesFuncionesAdditional grupocolorConstantesFuncionesAdditional=null;
	
	public GrupoColorConstantesFuncionesAdditional getGrupoColorConstantesFuncionesAdditional() {
		return this.grupocolorConstantesFuncionesAdditional;
	}
	
	public void setGrupoColorConstantesFuncionesAdditional(GrupoColorConstantesFuncionesAdditional grupocolorConstantesFuncionesAdditional) {
		try {
			this.grupocolorConstantesFuncionesAdditional=grupocolorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getGrupoColorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GrupoColorConstantesFunciones.IDEMPRESA)) {sLabelColumna=GrupoColorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GrupoColorConstantesFunciones.IDSUCURSAL)) {sLabelColumna=GrupoColorConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(GrupoColorConstantesFunciones.CODIGO)) {sLabelColumna=GrupoColorConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(GrupoColorConstantesFunciones.NOMBRE)) {sLabelColumna=GrupoColorConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getGrupoColorDescripcion(GrupoColor grupocolor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(grupocolor !=null/* && grupocolor.getId()!=0*/) {
			sDescripcion=grupocolor.getcodigo();//grupocolorgrupocolor.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getGrupoColorDescripcionDetallado(GrupoColor grupocolor) {
		String sDescripcion="";
			
		sDescripcion+=GrupoColorConstantesFunciones.ID+"=";
		sDescripcion+=grupocolor.getId().toString()+",";
		sDescripcion+=GrupoColorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=grupocolor.getVersionRow().toString()+",";
		sDescripcion+=GrupoColorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=grupocolor.getid_empresa().toString()+",";
		sDescripcion+=GrupoColorConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=grupocolor.getid_sucursal().toString()+",";
		sDescripcion+=GrupoColorConstantesFunciones.CODIGO+"=";
		sDescripcion+=grupocolor.getcodigo()+",";
		sDescripcion+=GrupoColorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=grupocolor.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setGrupoColorDescripcion(GrupoColor grupocolor,String sValor) throws Exception {			
		if(grupocolor !=null) {
			grupocolor.setcodigo(sValor);;//grupocolorgrupocolor.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
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

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

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
	
	
	
	
	
	
	public static void quitarEspaciosGrupoColor(GrupoColor grupocolor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		grupocolor.setcodigo(grupocolor.getcodigo().trim());
		grupocolor.setnombre(grupocolor.getnombre().trim());
	}
	
	public static void quitarEspaciosGrupoColors(List<GrupoColor> grupocolors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GrupoColor grupocolor: grupocolors) {
			grupocolor.setcodigo(grupocolor.getcodigo().trim());
			grupocolor.setnombre(grupocolor.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoColor(GrupoColor grupocolor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && grupocolor.getConCambioAuxiliar()) {
			grupocolor.setIsDeleted(grupocolor.getIsDeletedAuxiliar());	
			grupocolor.setIsNew(grupocolor.getIsNewAuxiliar());	
			grupocolor.setIsChanged(grupocolor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			grupocolor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			grupocolor.setIsDeletedAuxiliar(false);	
			grupocolor.setIsNewAuxiliar(false);	
			grupocolor.setIsChangedAuxiliar(false);
			
			grupocolor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoColors(List<GrupoColor> grupocolors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GrupoColor grupocolor : grupocolors) {
			if(conAsignarBase && grupocolor.getConCambioAuxiliar()) {
				grupocolor.setIsDeleted(grupocolor.getIsDeletedAuxiliar());	
				grupocolor.setIsNew(grupocolor.getIsNewAuxiliar());	
				grupocolor.setIsChanged(grupocolor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				grupocolor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				grupocolor.setIsDeletedAuxiliar(false);	
				grupocolor.setIsNewAuxiliar(false);	
				grupocolor.setIsChangedAuxiliar(false);
				
				grupocolor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGrupoColor(GrupoColor grupocolor,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGrupoColors(List<GrupoColor> grupocolors,Boolean conEnteros) throws Exception  {
		
		for(GrupoColor grupocolor: grupocolors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGrupoColor(List<GrupoColor> grupocolors,GrupoColor grupocolorAux) throws Exception  {
		GrupoColorConstantesFunciones.InicializarValoresGrupoColor(grupocolorAux,true);
		
		for(GrupoColor grupocolor: grupocolors) {
			if(grupocolor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoColor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GrupoColorConstantesFunciones.getArrayColumnasGlobalesGrupoColor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoColor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GrupoColorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GrupoColorConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GrupoColorConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GrupoColorConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGrupoColor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GrupoColor> grupocolors,GrupoColor grupocolor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GrupoColor grupocolorAux: grupocolors) {
			if(grupocolorAux!=null && grupocolor!=null) {
				if((grupocolorAux.getId()==null && grupocolor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(grupocolorAux.getId()!=null && grupocolor.getId()!=null){
					if(grupocolorAux.getId().equals(grupocolor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGrupoColor(List<GrupoColor> grupocolors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(GrupoColor grupocolor: grupocolors) {			
			if(grupocolor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGrupoColor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GrupoColorConstantesFunciones.LABEL_ID, GrupoColorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoColorConstantesFunciones.LABEL_VERSIONROW, GrupoColorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoColorConstantesFunciones.LABEL_IDEMPRESA, GrupoColorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoColorConstantesFunciones.LABEL_IDSUCURSAL, GrupoColorConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoColorConstantesFunciones.LABEL_CODIGO, GrupoColorConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoColorConstantesFunciones.LABEL_NOMBRE, GrupoColorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGrupoColor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GrupoColorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoColorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoColorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoColorConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoColorConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoColorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoColor() throws Exception  {
		return GrupoColorConstantesFunciones.getTiposSeleccionarGrupoColor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoColor(Boolean conFk) throws Exception  {
		return GrupoColorConstantesFunciones.getTiposSeleccionarGrupoColor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoColor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoColorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GrupoColorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoColorConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(GrupoColorConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoColorConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(GrupoColorConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoColorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(GrupoColorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGrupoColor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoColor(GrupoColor grupocolorAux) throws Exception {
		
			grupocolorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupocolorAux.getEmpresa()));
			grupocolorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(grupocolorAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoColor(List<GrupoColor> grupocolorsTemp) throws Exception {
		for(GrupoColor grupocolorAux:grupocolorsTemp) {
			
			grupocolorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupocolorAux.getEmpresa()));
			grupocolorAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(grupocolorAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoColor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGrupoColor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoColor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoColorConstantesFunciones.getClassesRelationshipsOfGrupoColor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoColor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ColorProducto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ColorProducto.class)) {
						classes.add(new Classe(ColorProducto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoColor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoColorConstantesFunciones.getClassesRelationshipsFromStringsOfGrupoColor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoColor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ColorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorProducto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ColorProducto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ColorProducto.class)); continue;
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
	public static void actualizarLista(GrupoColor grupocolor,List<GrupoColor> grupocolors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GrupoColor grupocolorEncontrado=null;
			
			for(GrupoColor grupocolorLocal:grupocolors) {
				if(grupocolorLocal.getId().equals(grupocolor.getId())) {
					grupocolorEncontrado=grupocolorLocal;
					
					grupocolorLocal.setIsChanged(grupocolor.getIsChanged());
					grupocolorLocal.setIsNew(grupocolor.getIsNew());
					grupocolorLocal.setIsDeleted(grupocolor.getIsDeleted());
					
					grupocolorLocal.setGeneralEntityOriginal(grupocolor.getGeneralEntityOriginal());
					
					grupocolorLocal.setId(grupocolor.getId());	
					grupocolorLocal.setVersionRow(grupocolor.getVersionRow());	
					grupocolorLocal.setid_empresa(grupocolor.getid_empresa());	
					grupocolorLocal.setid_sucursal(grupocolor.getid_sucursal());	
					grupocolorLocal.setcodigo(grupocolor.getcodigo());	
					grupocolorLocal.setnombre(grupocolor.getnombre());	
					
					
					grupocolorLocal.setColorProductos(grupocolor.getColorProductos());
					
					existe=true;
					break;
				}
			}
			
			if(!grupocolor.getIsDeleted()) {
				if(!existe) {
					grupocolors.add(grupocolor);
				}
			} else {
				if(grupocolorEncontrado!=null && permiteQuitar)  {
					grupocolors.remove(grupocolorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GrupoColor grupocolor,List<GrupoColor> grupocolors) throws Exception {
		try	{			
			for(GrupoColor grupocolorLocal:grupocolors) {
				if(grupocolorLocal.getId().equals(grupocolor.getId())) {
					grupocolorLocal.setIsSelected(grupocolor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGrupoColor(List<GrupoColor> grupocolorsAux) throws Exception {
		//this.grupocolorsAux=grupocolorsAux;
		
		for(GrupoColor grupocolorAux:grupocolorsAux) {
			if(grupocolorAux.getIsChanged()) {
				grupocolorAux.setIsChanged(false);
			}		
			
			if(grupocolorAux.getIsNew()) {
				grupocolorAux.setIsNew(false);
			}	
			
			if(grupocolorAux.getIsDeleted()) {
				grupocolorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGrupoColor(GrupoColor grupocolorAux) throws Exception {
		//this.grupocolorAux=grupocolorAux;
		
			if(grupocolorAux.getIsChanged()) {
				grupocolorAux.setIsChanged(false);
			}		
			
			if(grupocolorAux.getIsNew()) {
				grupocolorAux.setIsNew(false);
			}	
			
			if(grupocolorAux.getIsDeleted()) {
				grupocolorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GrupoColor grupocolorAsignar,GrupoColor grupocolor) throws Exception {
		grupocolorAsignar.setId(grupocolor.getId());	
		grupocolorAsignar.setVersionRow(grupocolor.getVersionRow());	
		grupocolorAsignar.setid_empresa(grupocolor.getid_empresa());
		grupocolorAsignar.setempresa_descripcion(grupocolor.getempresa_descripcion());	
		grupocolorAsignar.setid_sucursal(grupocolor.getid_sucursal());
		grupocolorAsignar.setsucursal_descripcion(grupocolor.getsucursal_descripcion());	
		grupocolorAsignar.setcodigo(grupocolor.getcodigo());	
		grupocolorAsignar.setnombre(grupocolor.getnombre());	
	}
	
	public static void inicializarGrupoColor(GrupoColor grupocolor) throws Exception {
		try {
				grupocolor.setId(0L);	
					
				grupocolor.setid_empresa(-1L);	
				grupocolor.setid_sucursal(-1L);	
				grupocolor.setcodigo("");	
				grupocolor.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGrupoColor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoColorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoColorConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoColorConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoColorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGrupoColor(String sTipo,Row row,Workbook workbook,GrupoColor grupocolor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocolor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocolor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocolor.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupocolor.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGrupoColor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGrupoColor() {
		return this.sFinalQueryGrupoColor;
	}
	
	public void setsFinalQueryGrupoColor(String sFinalQueryGrupoColor) {
		this.sFinalQueryGrupoColor= sFinalQueryGrupoColor;
	}
	
	public Border resaltarSeleccionarGrupoColor=null;
	
	public Border setResaltarSeleccionarGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//grupocolorBeanSwingJInternalFrame.jTtoolBarGrupoColor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGrupoColor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGrupoColor() {
		return this.resaltarSeleccionarGrupoColor;
	}
	
	public void setResaltarSeleccionarGrupoColor(Border borderResaltarSeleccionarGrupoColor) {
		this.resaltarSeleccionarGrupoColor= borderResaltarSeleccionarGrupoColor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGrupoColor=null;
	public Boolean mostraridGrupoColor=true;
	public Boolean activaridGrupoColor=true;

	public Border resaltarid_empresaGrupoColor=null;
	public Boolean mostrarid_empresaGrupoColor=true;
	public Boolean activarid_empresaGrupoColor=true;
	public Boolean cargarid_empresaGrupoColor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGrupoColor=false;//ConEventDepend=true

	public Border resaltarid_sucursalGrupoColor=null;
	public Boolean mostrarid_sucursalGrupoColor=true;
	public Boolean activarid_sucursalGrupoColor=true;
	public Boolean cargarid_sucursalGrupoColor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalGrupoColor=false;//ConEventDepend=true

	public Border resaltarcodigoGrupoColor=null;
	public Boolean mostrarcodigoGrupoColor=true;
	public Boolean activarcodigoGrupoColor=true;

	public Border resaltarnombreGrupoColor=null;
	public Boolean mostrarnombreGrupoColor=true;
	public Boolean activarnombreGrupoColor=true;

	
	

	public Border setResaltaridGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupocolorBeanSwingJInternalFrame.jTtoolBarGrupoColor.setBorder(borderResaltar);
		
		this.resaltaridGrupoColor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGrupoColor() {
		return this.resaltaridGrupoColor;
	}

	public void setResaltaridGrupoColor(Border borderResaltar) {
		this.resaltaridGrupoColor= borderResaltar;
	}

	public Boolean getMostraridGrupoColor() {
		return this.mostraridGrupoColor;
	}

	public void setMostraridGrupoColor(Boolean mostraridGrupoColor) {
		this.mostraridGrupoColor= mostraridGrupoColor;
	}

	public Boolean getActivaridGrupoColor() {
		return this.activaridGrupoColor;
	}

	public void setActivaridGrupoColor(Boolean activaridGrupoColor) {
		this.activaridGrupoColor= activaridGrupoColor;
	}

	public Border setResaltarid_empresaGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupocolorBeanSwingJInternalFrame.jTtoolBarGrupoColor.setBorder(borderResaltar);
		
		this.resaltarid_empresaGrupoColor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGrupoColor() {
		return this.resaltarid_empresaGrupoColor;
	}

	public void setResaltarid_empresaGrupoColor(Border borderResaltar) {
		this.resaltarid_empresaGrupoColor= borderResaltar;
	}

	public Boolean getMostrarid_empresaGrupoColor() {
		return this.mostrarid_empresaGrupoColor;
	}

	public void setMostrarid_empresaGrupoColor(Boolean mostrarid_empresaGrupoColor) {
		this.mostrarid_empresaGrupoColor= mostrarid_empresaGrupoColor;
	}

	public Boolean getActivarid_empresaGrupoColor() {
		return this.activarid_empresaGrupoColor;
	}

	public void setActivarid_empresaGrupoColor(Boolean activarid_empresaGrupoColor) {
		this.activarid_empresaGrupoColor= activarid_empresaGrupoColor;
	}

	public Boolean getCargarid_empresaGrupoColor() {
		return this.cargarid_empresaGrupoColor;
	}

	public void setCargarid_empresaGrupoColor(Boolean cargarid_empresaGrupoColor) {
		this.cargarid_empresaGrupoColor= cargarid_empresaGrupoColor;
	}

	public Border setResaltarid_sucursalGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupocolorBeanSwingJInternalFrame.jTtoolBarGrupoColor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalGrupoColor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalGrupoColor() {
		return this.resaltarid_sucursalGrupoColor;
	}

	public void setResaltarid_sucursalGrupoColor(Border borderResaltar) {
		this.resaltarid_sucursalGrupoColor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalGrupoColor() {
		return this.mostrarid_sucursalGrupoColor;
	}

	public void setMostrarid_sucursalGrupoColor(Boolean mostrarid_sucursalGrupoColor) {
		this.mostrarid_sucursalGrupoColor= mostrarid_sucursalGrupoColor;
	}

	public Boolean getActivarid_sucursalGrupoColor() {
		return this.activarid_sucursalGrupoColor;
	}

	public void setActivarid_sucursalGrupoColor(Boolean activarid_sucursalGrupoColor) {
		this.activarid_sucursalGrupoColor= activarid_sucursalGrupoColor;
	}

	public Boolean getCargarid_sucursalGrupoColor() {
		return this.cargarid_sucursalGrupoColor;
	}

	public void setCargarid_sucursalGrupoColor(Boolean cargarid_sucursalGrupoColor) {
		this.cargarid_sucursalGrupoColor= cargarid_sucursalGrupoColor;
	}

	public Border setResaltarcodigoGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupocolorBeanSwingJInternalFrame.jTtoolBarGrupoColor.setBorder(borderResaltar);
		
		this.resaltarcodigoGrupoColor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoGrupoColor() {
		return this.resaltarcodigoGrupoColor;
	}

	public void setResaltarcodigoGrupoColor(Border borderResaltar) {
		this.resaltarcodigoGrupoColor= borderResaltar;
	}

	public Boolean getMostrarcodigoGrupoColor() {
		return this.mostrarcodigoGrupoColor;
	}

	public void setMostrarcodigoGrupoColor(Boolean mostrarcodigoGrupoColor) {
		this.mostrarcodigoGrupoColor= mostrarcodigoGrupoColor;
	}

	public Boolean getActivarcodigoGrupoColor() {
		return this.activarcodigoGrupoColor;
	}

	public void setActivarcodigoGrupoColor(Boolean activarcodigoGrupoColor) {
		this.activarcodigoGrupoColor= activarcodigoGrupoColor;
	}

	public Border setResaltarnombreGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupocolorBeanSwingJInternalFrame.jTtoolBarGrupoColor.setBorder(borderResaltar);
		
		this.resaltarnombreGrupoColor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreGrupoColor() {
		return this.resaltarnombreGrupoColor;
	}

	public void setResaltarnombreGrupoColor(Border borderResaltar) {
		this.resaltarnombreGrupoColor= borderResaltar;
	}

	public Boolean getMostrarnombreGrupoColor() {
		return this.mostrarnombreGrupoColor;
	}

	public void setMostrarnombreGrupoColor(Boolean mostrarnombreGrupoColor) {
		this.mostrarnombreGrupoColor= mostrarnombreGrupoColor;
	}

	public Boolean getActivarnombreGrupoColor() {
		return this.activarnombreGrupoColor;
	}

	public void setActivarnombreGrupoColor(Boolean activarnombreGrupoColor) {
		this.activarnombreGrupoColor= activarnombreGrupoColor;
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
		
		
		this.setMostraridGrupoColor(esInicial);
		this.setMostrarid_empresaGrupoColor(esInicial);
		this.setMostrarid_sucursalGrupoColor(esInicial);
		this.setMostrarcodigoGrupoColor(esInicial);
		this.setMostrarnombreGrupoColor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoColorConstantesFunciones.ID)) {
				this.setMostraridGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreGrupoColor(esAsigna);
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
		
		
		this.setActivaridGrupoColor(esInicial);
		this.setActivarid_empresaGrupoColor(esInicial);
		this.setActivarid_sucursalGrupoColor(esInicial);
		this.setActivarcodigoGrupoColor(esInicial);
		this.setActivarnombreGrupoColor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoColorConstantesFunciones.ID)) {
				this.setActivaridGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.CODIGO)) {
				this.setActivarcodigoGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreGrupoColor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGrupoColor(esInicial);
		this.setResaltarid_empresaGrupoColor(esInicial);
		this.setResaltarid_sucursalGrupoColor(esInicial);
		this.setResaltarcodigoGrupoColor(esInicial);
		this.setResaltarnombreGrupoColor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoColorConstantesFunciones.ID)) {
				this.setResaltaridGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoGrupoColor(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoColorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreGrupoColor(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarColorProductoGrupoColor=null;

	public Border getResaltarColorProductoGrupoColor() {
		return this.resaltarColorProductoGrupoColor;
	}

	public void setResaltarColorProductoGrupoColor(Border borderResaltarColorProducto) {
		if(borderResaltarColorProducto!=null) {
			this.resaltarColorProductoGrupoColor= borderResaltarColorProducto;
		}
	}

	public Border setResaltarColorProductoGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltarColorProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupocolorBeanSwingJInternalFrame.jTtoolBarGrupoColor.setBorder(borderResaltarColorProducto);
			
		this.resaltarColorProductoGrupoColor= borderResaltarColorProducto;

		 return borderResaltarColorProducto;
	}



	public Boolean mostrarColorProductoGrupoColor=true;

	public Boolean getMostrarColorProductoGrupoColor() {
		return this.mostrarColorProductoGrupoColor;
	}

	public void setMostrarColorProductoGrupoColor(Boolean visibilidadResaltarColorProducto) {
		this.mostrarColorProductoGrupoColor= visibilidadResaltarColorProducto;
	}



	public Boolean activarColorProductoGrupoColor=true;

	public Boolean gethabilitarResaltarColorProductoGrupoColor() {
		return this.activarColorProductoGrupoColor;
	}

	public void setActivarColorProductoGrupoColor(Boolean habilitarResaltarColorProducto) {
		this.activarColorProductoGrupoColor= habilitarResaltarColorProducto;
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

		this.setMostrarColorProductoGrupoColor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ColorProducto.class)) {
				this.setMostrarColorProductoGrupoColor(esAsigna);
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

		this.setActivarColorProductoGrupoColor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ColorProducto.class)) {
				this.setActivarColorProductoGrupoColor(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarColorProductoGrupoColor(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ColorProducto.class)) {
				this.setResaltarColorProductoGrupoColor(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoGrupoColor=true;

	public Boolean getMostrarBusquedaPorCodigoGrupoColor() {
		return this.mostrarBusquedaPorCodigoGrupoColor;
	}

	public void setMostrarBusquedaPorCodigoGrupoColor(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoGrupoColor= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreGrupoColor=true;

	public Boolean getMostrarBusquedaPorNombreGrupoColor() {
		return this.mostrarBusquedaPorNombreGrupoColor;
	}

	public void setMostrarBusquedaPorNombreGrupoColor(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreGrupoColor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaGrupoColor=true;

	public Boolean getMostrarFK_IdEmpresaGrupoColor() {
		return this.mostrarFK_IdEmpresaGrupoColor;
	}

	public void setMostrarFK_IdEmpresaGrupoColor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGrupoColor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalGrupoColor=true;

	public Boolean getMostrarFK_IdSucursalGrupoColor() {
		return this.mostrarFK_IdSucursalGrupoColor;
	}

	public void setMostrarFK_IdSucursalGrupoColor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalGrupoColor= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoGrupoColor=true;

	public Boolean getActivarBusquedaPorCodigoGrupoColor() {
		return this.activarBusquedaPorCodigoGrupoColor;
	}

	public void setActivarBusquedaPorCodigoGrupoColor(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoGrupoColor= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreGrupoColor=true;

	public Boolean getActivarBusquedaPorNombreGrupoColor() {
		return this.activarBusquedaPorNombreGrupoColor;
	}

	public void setActivarBusquedaPorNombreGrupoColor(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreGrupoColor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaGrupoColor=true;

	public Boolean getActivarFK_IdEmpresaGrupoColor() {
		return this.activarFK_IdEmpresaGrupoColor;
	}

	public void setActivarFK_IdEmpresaGrupoColor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGrupoColor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalGrupoColor=true;

	public Boolean getActivarFK_IdSucursalGrupoColor() {
		return this.activarFK_IdSucursalGrupoColor;
	}

	public void setActivarFK_IdSucursalGrupoColor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalGrupoColor= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoGrupoColor=null;

	public Border getResaltarBusquedaPorCodigoGrupoColor() {
		return this.resaltarBusquedaPorCodigoGrupoColor;
	}

	public void setResaltarBusquedaPorCodigoGrupoColor(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoGrupoColor= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoGrupoColor= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreGrupoColor=null;

	public Border getResaltarBusquedaPorNombreGrupoColor() {
		return this.resaltarBusquedaPorNombreGrupoColor;
	}

	public void setResaltarBusquedaPorNombreGrupoColor(Border borderResaltar) {
		this.resaltarBusquedaPorNombreGrupoColor= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreGrupoColor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaGrupoColor=null;

	public Border getResaltarFK_IdEmpresaGrupoColor() {
		return this.resaltarFK_IdEmpresaGrupoColor;
	}

	public void setResaltarFK_IdEmpresaGrupoColor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGrupoColor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGrupoColor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalGrupoColor=null;

	public Border getResaltarFK_IdSucursalGrupoColor() {
		return this.resaltarFK_IdSucursalGrupoColor;
	}

	public void setResaltarFK_IdSucursalGrupoColor(Border borderResaltar) {
		this.resaltarFK_IdSucursalGrupoColor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalGrupoColor(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoColorBeanSwingJInternalFrame grupocolorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalGrupoColor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}