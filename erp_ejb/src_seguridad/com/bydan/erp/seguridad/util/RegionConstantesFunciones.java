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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.RegionConstantesFunciones;
import com.bydan.erp.seguridad.util.RegionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.RegionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RegionConstantesFunciones extends RegionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Region";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Region"+RegionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RegionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RegionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RegionConstantesFunciones.SCHEMA+"_"+RegionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RegionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RegionConstantesFunciones.SCHEMA+"_"+RegionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RegionConstantesFunciones.SCHEMA+"_"+RegionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RegionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RegionConstantesFunciones.SCHEMA+"_"+RegionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RegionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RegionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RegionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RegionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RegionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RegionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RegionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RegionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RegionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RegionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Regiones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Region";
	public static final String SCLASSWEBTITULO_LOWER="Region";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Region";
	public static final String OBJECTNAME="region";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="region";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select region from "+RegionConstantesFunciones.SPERSISTENCENAME+" region";
	public static String QUERYSELECTNATIVE="select "+RegionConstantesFunciones.SCHEMA+"."+RegionConstantesFunciones.TABLENAME+".id,"+RegionConstantesFunciones.SCHEMA+"."+RegionConstantesFunciones.TABLENAME+".version_row,"+RegionConstantesFunciones.SCHEMA+"."+RegionConstantesFunciones.TABLENAME+".id_pais,"+RegionConstantesFunciones.SCHEMA+"."+RegionConstantesFunciones.TABLENAME+".codigo,"+RegionConstantesFunciones.SCHEMA+"."+RegionConstantesFunciones.TABLENAME+".nombre from "+RegionConstantesFunciones.SCHEMA+"."+RegionConstantesFunciones.TABLENAME;//+" as "+RegionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RegionConstantesFuncionesAdditional regionConstantesFuncionesAdditional=null;
	
	public RegionConstantesFuncionesAdditional getRegionConstantesFuncionesAdditional() {
		return this.regionConstantesFuncionesAdditional;
	}
	
	public void setRegionConstantesFuncionesAdditional(RegionConstantesFuncionesAdditional regionConstantesFuncionesAdditional) {
		try {
			this.regionConstantesFuncionesAdditional=regionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getRegionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RegionConstantesFunciones.IDPAIS)) {sLabelColumna=RegionConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(RegionConstantesFunciones.CODIGO)) {sLabelColumna=RegionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(RegionConstantesFunciones.NOMBRE)) {sLabelColumna=RegionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getRegionDescripcion(Region region) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(region !=null/* && region.getId()!=0*/) {
			sDescripcion=region.getnombre();//regionregion.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getRegionDescripcionDetallado(Region region) {
		String sDescripcion="";
			
		sDescripcion+=RegionConstantesFunciones.ID+"=";
		sDescripcion+=region.getId().toString()+",";
		sDescripcion+=RegionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=region.getVersionRow().toString()+",";
		sDescripcion+=RegionConstantesFunciones.IDPAIS+"=";
		sDescripcion+=region.getid_pais().toString()+",";
		sDescripcion+=RegionConstantesFunciones.CODIGO+"=";
		sDescripcion+=region.getcodigo()+",";
		sDescripcion+=RegionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=region.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setRegionDescripcion(Region region,String sValor) throws Exception {			
		if(region !=null) {
			region.setnombre(sValor);;//regionregion.getnombre().trim();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("PorIdPaisPorNombre")) {
			sNombreIndice="Tipo=  Por Pais Por Nombre";
		} else if(sNombreIndice.equals("PorIdPorIdPais")) {
			sNombreIndice="Tipo=  Por Id Por Pais";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPaisPorNombre(Long id_pais,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorIdPais(Long id,Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRegion(Region region,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		region.setcodigo(region.getcodigo().trim());
		region.setnombre(region.getnombre().trim());
	}
	
	public static void quitarEspaciosRegions(List<Region> regions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Region region: regions) {
			region.setcodigo(region.getcodigo().trim());
			region.setnombre(region.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRegion(Region region,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && region.getConCambioAuxiliar()) {
			region.setIsDeleted(region.getIsDeletedAuxiliar());	
			region.setIsNew(region.getIsNewAuxiliar());	
			region.setIsChanged(region.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			region.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			region.setIsDeletedAuxiliar(false);	
			region.setIsNewAuxiliar(false);	
			region.setIsChangedAuxiliar(false);
			
			region.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRegions(List<Region> regions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Region region : regions) {
			if(conAsignarBase && region.getConCambioAuxiliar()) {
				region.setIsDeleted(region.getIsDeletedAuxiliar());	
				region.setIsNew(region.getIsNewAuxiliar());	
				region.setIsChanged(region.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				region.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				region.setIsDeletedAuxiliar(false);	
				region.setIsNewAuxiliar(false);	
				region.setIsChangedAuxiliar(false);
				
				region.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRegion(Region region,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRegions(List<Region> regions,Boolean conEnteros) throws Exception  {
		
		for(Region region: regions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRegion(List<Region> regions,Region regionAux) throws Exception  {
		RegionConstantesFunciones.InicializarValoresRegion(regionAux,true);
		
		for(Region region: regions) {
			if(region.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRegion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RegionConstantesFunciones.getArrayColumnasGlobalesRegion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRegion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRegion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Region> regions,Region region,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Region regionAux: regions) {
			if(regionAux!=null && region!=null) {
				if((regionAux.getId()==null && region.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(regionAux.getId()!=null && region.getId()!=null){
					if(regionAux.getId().equals(region.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRegion(List<Region> regions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Region region: regions) {			
			if(region.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRegion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RegionConstantesFunciones.LABEL_ID, RegionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegionConstantesFunciones.LABEL_VERSIONROW, RegionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegionConstantesFunciones.LABEL_IDPAIS, RegionConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegionConstantesFunciones.LABEL_CODIGO, RegionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegionConstantesFunciones.LABEL_NOMBRE, RegionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRegion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RegionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegionConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRegion() throws Exception  {
		return RegionConstantesFunciones.getTiposSeleccionarRegion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRegion(Boolean conFk) throws Exception  {
		return RegionConstantesFunciones.getTiposSeleccionarRegion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRegion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegionConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(RegionConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(RegionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(RegionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRegion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRegion(Region regionAux) throws Exception {
		
			regionAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(regionAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRegion(List<Region> regionsTemp) throws Exception {
		for(Region regionAux:regionsTemp) {
			
			regionAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(regionAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRegion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRegion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRegion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RegionConstantesFunciones.getClassesRelationshipsOfRegion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRegion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRegion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RegionConstantesFunciones.getClassesRelationshipsFromStringsOfRegion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRegion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
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
	public static void actualizarLista(Region region,List<Region> regions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Region regionEncontrado=null;
			
			for(Region regionLocal:regions) {
				if(regionLocal.getId().equals(region.getId())) {
					regionEncontrado=regionLocal;
					
					regionLocal.setIsChanged(region.getIsChanged());
					regionLocal.setIsNew(region.getIsNew());
					regionLocal.setIsDeleted(region.getIsDeleted());
					
					regionLocal.setGeneralEntityOriginal(region.getGeneralEntityOriginal());
					
					regionLocal.setId(region.getId());	
					regionLocal.setVersionRow(region.getVersionRow());	
					regionLocal.setid_pais(region.getid_pais());	
					regionLocal.setcodigo(region.getcodigo());	
					regionLocal.setnombre(region.getnombre());	
					
					
					regionLocal.setClientes(region.getClientes());
					regionLocal.setProvincias(region.getProvincias());
					regionLocal.setParametroCarteraDefectos(region.getParametroCarteraDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!region.getIsDeleted()) {
				if(!existe) {
					regions.add(region);
				}
			} else {
				if(regionEncontrado!=null && permiteQuitar)  {
					regions.remove(regionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Region region,List<Region> regions) throws Exception {
		try	{			
			for(Region regionLocal:regions) {
				if(regionLocal.getId().equals(region.getId())) {
					regionLocal.setIsSelected(region.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRegion(List<Region> regionsAux) throws Exception {
		//this.regionsAux=regionsAux;
		
		for(Region regionAux:regionsAux) {
			if(regionAux.getIsChanged()) {
				regionAux.setIsChanged(false);
			}		
			
			if(regionAux.getIsNew()) {
				regionAux.setIsNew(false);
			}	
			
			if(regionAux.getIsDeleted()) {
				regionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRegion(Region regionAux) throws Exception {
		//this.regionAux=regionAux;
		
			if(regionAux.getIsChanged()) {
				regionAux.setIsChanged(false);
			}		
			
			if(regionAux.getIsNew()) {
				regionAux.setIsNew(false);
			}	
			
			if(regionAux.getIsDeleted()) {
				regionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Region regionAsignar,Region region) throws Exception {
		regionAsignar.setId(region.getId());	
		regionAsignar.setVersionRow(region.getVersionRow());	
		regionAsignar.setid_pais(region.getid_pais());
		regionAsignar.setpais_descripcion(region.getpais_descripcion());	
		regionAsignar.setcodigo(region.getcodigo());	
		regionAsignar.setnombre(region.getnombre());	
	}
	
	public static void inicializarRegion(Region region) throws Exception {
		try {
				region.setId(0L);	
					
				region.setid_pais(-1L);	
				region.setcodigo("");	
				region.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRegion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RegionConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRegion(String sTipo,Row row,Workbook workbook,Region region,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(region.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(region.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(region.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRegion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRegion() {
		return this.sFinalQueryRegion;
	}
	
	public void setsFinalQueryRegion(String sFinalQueryRegion) {
		this.sFinalQueryRegion= sFinalQueryRegion;
	}
	
	public Border resaltarSeleccionarRegion=null;
	
	public Border setResaltarSeleccionarRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//regionBeanSwingJInternalFrame.jTtoolBarRegion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRegion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRegion() {
		return this.resaltarSeleccionarRegion;
	}
	
	public void setResaltarSeleccionarRegion(Border borderResaltarSeleccionarRegion) {
		this.resaltarSeleccionarRegion= borderResaltarSeleccionarRegion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRegion=null;
	public Boolean mostraridRegion=true;
	public Boolean activaridRegion=true;

	public Border resaltarid_paisRegion=null;
	public Boolean mostrarid_paisRegion=true;
	public Boolean activarid_paisRegion=true;
	public Boolean cargarid_paisRegion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisRegion=false;//ConEventDepend=true

	public Border resaltarcodigoRegion=null;
	public Boolean mostrarcodigoRegion=true;
	public Boolean activarcodigoRegion=true;

	public Border resaltarnombreRegion=null;
	public Boolean mostrarnombreRegion=true;
	public Boolean activarnombreRegion=true;

	
	

	public Border setResaltaridRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//regionBeanSwingJInternalFrame.jTtoolBarRegion.setBorder(borderResaltar);
		
		this.resaltaridRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRegion() {
		return this.resaltaridRegion;
	}

	public void setResaltaridRegion(Border borderResaltar) {
		this.resaltaridRegion= borderResaltar;
	}

	public Boolean getMostraridRegion() {
		return this.mostraridRegion;
	}

	public void setMostraridRegion(Boolean mostraridRegion) {
		this.mostraridRegion= mostraridRegion;
	}

	public Boolean getActivaridRegion() {
		return this.activaridRegion;
	}

	public void setActivaridRegion(Boolean activaridRegion) {
		this.activaridRegion= activaridRegion;
	}

	public Border setResaltarid_paisRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//regionBeanSwingJInternalFrame.jTtoolBarRegion.setBorder(borderResaltar);
		
		this.resaltarid_paisRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisRegion() {
		return this.resaltarid_paisRegion;
	}

	public void setResaltarid_paisRegion(Border borderResaltar) {
		this.resaltarid_paisRegion= borderResaltar;
	}

	public Boolean getMostrarid_paisRegion() {
		return this.mostrarid_paisRegion;
	}

	public void setMostrarid_paisRegion(Boolean mostrarid_paisRegion) {
		this.mostrarid_paisRegion= mostrarid_paisRegion;
	}

	public Boolean getActivarid_paisRegion() {
		return this.activarid_paisRegion;
	}

	public void setActivarid_paisRegion(Boolean activarid_paisRegion) {
		this.activarid_paisRegion= activarid_paisRegion;
	}

	public Boolean getCargarid_paisRegion() {
		return this.cargarid_paisRegion;
	}

	public void setCargarid_paisRegion(Boolean cargarid_paisRegion) {
		this.cargarid_paisRegion= cargarid_paisRegion;
	}

	public Border setResaltarcodigoRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//regionBeanSwingJInternalFrame.jTtoolBarRegion.setBorder(borderResaltar);
		
		this.resaltarcodigoRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoRegion() {
		return this.resaltarcodigoRegion;
	}

	public void setResaltarcodigoRegion(Border borderResaltar) {
		this.resaltarcodigoRegion= borderResaltar;
	}

	public Boolean getMostrarcodigoRegion() {
		return this.mostrarcodigoRegion;
	}

	public void setMostrarcodigoRegion(Boolean mostrarcodigoRegion) {
		this.mostrarcodigoRegion= mostrarcodigoRegion;
	}

	public Boolean getActivarcodigoRegion() {
		return this.activarcodigoRegion;
	}

	public void setActivarcodigoRegion(Boolean activarcodigoRegion) {
		this.activarcodigoRegion= activarcodigoRegion;
	}

	public Border setResaltarnombreRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//regionBeanSwingJInternalFrame.jTtoolBarRegion.setBorder(borderResaltar);
		
		this.resaltarnombreRegion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreRegion() {
		return this.resaltarnombreRegion;
	}

	public void setResaltarnombreRegion(Border borderResaltar) {
		this.resaltarnombreRegion= borderResaltar;
	}

	public Boolean getMostrarnombreRegion() {
		return this.mostrarnombreRegion;
	}

	public void setMostrarnombreRegion(Boolean mostrarnombreRegion) {
		this.mostrarnombreRegion= mostrarnombreRegion;
	}

	public Boolean getActivarnombreRegion() {
		return this.activarnombreRegion;
	}

	public void setActivarnombreRegion(Boolean activarnombreRegion) {
		this.activarnombreRegion= activarnombreRegion;
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
		
		
		this.setMostraridRegion(esInicial);
		this.setMostrarid_paisRegion(esInicial);
		this.setMostrarcodigoRegion(esInicial);
		this.setMostrarnombreRegion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RegionConstantesFunciones.ID)) {
				this.setMostraridRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreRegion(esAsigna);
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
		
		
		this.setActivaridRegion(esInicial);
		this.setActivarid_paisRegion(esInicial);
		this.setActivarcodigoRegion(esInicial);
		this.setActivarnombreRegion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RegionConstantesFunciones.ID)) {
				this.setActivaridRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreRegion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRegion(esInicial);
		this.setResaltarid_paisRegion(esInicial);
		this.setResaltarcodigoRegion(esInicial);
		this.setResaltarnombreRegion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RegionConstantesFunciones.ID)) {
				this.setResaltaridRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoRegion(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreRegion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteRegion=null;

	public Border getResaltarClienteRegion() {
		return this.resaltarClienteRegion;
	}

	public void setResaltarClienteRegion(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteRegion= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//regionBeanSwingJInternalFrame.jTtoolBarRegion.setBorder(borderResaltarCliente);
			
		this.resaltarClienteRegion= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteRegion=true;

	public Boolean getMostrarClienteRegion() {
		return this.mostrarClienteRegion;
	}

	public void setMostrarClienteRegion(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteRegion= visibilidadResaltarCliente;
	}



	public Boolean activarClienteRegion=true;

	public Boolean gethabilitarResaltarClienteRegion() {
		return this.activarClienteRegion;
	}

	public void setActivarClienteRegion(Boolean habilitarResaltarCliente) {
		this.activarClienteRegion= habilitarResaltarCliente;
	}


	public Border resaltarProvinciaRegion=null;

	public Border getResaltarProvinciaRegion() {
		return this.resaltarProvinciaRegion;
	}

	public void setResaltarProvinciaRegion(Border borderResaltarProvincia) {
		if(borderResaltarProvincia!=null) {
			this.resaltarProvinciaRegion= borderResaltarProvincia;
		}
	}

	public Border setResaltarProvinciaRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltarProvincia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//regionBeanSwingJInternalFrame.jTtoolBarRegion.setBorder(borderResaltarProvincia);
			
		this.resaltarProvinciaRegion= borderResaltarProvincia;

		 return borderResaltarProvincia;
	}



	public Boolean mostrarProvinciaRegion=true;

	public Boolean getMostrarProvinciaRegion() {
		return this.mostrarProvinciaRegion;
	}

	public void setMostrarProvinciaRegion(Boolean visibilidadResaltarProvincia) {
		this.mostrarProvinciaRegion= visibilidadResaltarProvincia;
	}



	public Boolean activarProvinciaRegion=true;

	public Boolean gethabilitarResaltarProvinciaRegion() {
		return this.activarProvinciaRegion;
	}

	public void setActivarProvinciaRegion(Boolean habilitarResaltarProvincia) {
		this.activarProvinciaRegion= habilitarResaltarProvincia;
	}


	public Border resaltarParametroCarteraDefectoRegion=null;

	public Border getResaltarParametroCarteraDefectoRegion() {
		return this.resaltarParametroCarteraDefectoRegion;
	}

	public void setResaltarParametroCarteraDefectoRegion(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoRegion= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//regionBeanSwingJInternalFrame.jTtoolBarRegion.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoRegion= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoRegion=true;

	public Boolean getMostrarParametroCarteraDefectoRegion() {
		return this.mostrarParametroCarteraDefectoRegion;
	}

	public void setMostrarParametroCarteraDefectoRegion(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoRegion= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoRegion=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoRegion() {
		return this.activarParametroCarteraDefectoRegion;
	}

	public void setActivarParametroCarteraDefectoRegion(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoRegion= habilitarResaltarParametroCarteraDefecto;
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

		this.setMostrarClienteRegion(esInicial);
		this.setMostrarProvinciaRegion(esInicial);
		this.setMostrarParametroCarteraDefectoRegion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteRegion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Provincia.class)) {
				this.setMostrarProvinciaRegion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoRegion(esAsigna);
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

		this.setActivarClienteRegion(esInicial);
		this.setActivarProvinciaRegion(esInicial);
		this.setActivarParametroCarteraDefectoRegion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteRegion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Provincia.class)) {
				this.setActivarProvinciaRegion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoRegion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteRegion(esInicial);
		this.setResaltarProvinciaRegion(esInicial);
		this.setResaltarParametroCarteraDefectoRegion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteRegion(esAsigna);
				continue;
			}

			if(clase.clas.equals(Provincia.class)) {
				this.setResaltarProvinciaRegion(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoRegion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdPaisRegion=true;

	public Boolean getMostrarFK_IdPaisRegion() {
		return this.mostrarFK_IdPaisRegion;
	}

	public void setMostrarFK_IdPaisRegion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisRegion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisRegion=true;

	public Boolean getActivarFK_IdPaisRegion() {
		return this.activarFK_IdPaisRegion;
	}

	public void setActivarFK_IdPaisRegion(Boolean habilitarResaltar) {
		this.activarFK_IdPaisRegion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisRegion=null;

	public Border getResaltarFK_IdPaisRegion() {
		return this.resaltarFK_IdPaisRegion;
	}

	public void setResaltarFK_IdPaisRegion(Border borderResaltar) {
		this.resaltarFK_IdPaisRegion= borderResaltar;
	}

	public void setResaltarFK_IdPaisRegion(ParametroGeneralUsuario parametroGeneralUsuario/*RegionBeanSwingJInternalFrame regionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisRegion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}