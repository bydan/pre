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


import com.bydan.erp.seguridad.util.ProvinciaConstantesFunciones;
import com.bydan.erp.seguridad.util.ProvinciaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ProvinciaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ProvinciaConstantesFunciones extends ProvinciaConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=" order by nombre" ;	
	public static final String SNOMBREOPCION="Provincia";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Provincia"+ProvinciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ProvinciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ProvinciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ProvinciaConstantesFunciones.SCHEMA+"_"+ProvinciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ProvinciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ProvinciaConstantesFunciones.SCHEMA+"_"+ProvinciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ProvinciaConstantesFunciones.SCHEMA+"_"+ProvinciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ProvinciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ProvinciaConstantesFunciones.SCHEMA+"_"+ProvinciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProvinciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProvinciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProvinciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProvinciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ProvinciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ProvinciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ProvinciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ProvinciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ProvinciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ProvinciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Provinciaes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Provincia";
	public static final String SCLASSWEBTITULO_LOWER="Provincia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Provincia";
	public static final String OBJECTNAME="provincia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="provincia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select provincia from "+ProvinciaConstantesFunciones.SPERSISTENCENAME+" provincia";
	public static String QUERYSELECTNATIVE="select "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".id,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".version_row,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".id_pais,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".id_region,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".codigo,"+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME+".nombre from "+ProvinciaConstantesFunciones.SCHEMA+"."+ProvinciaConstantesFunciones.TABLENAME;//+" as "+ProvinciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ProvinciaConstantesFuncionesAdditional provinciaConstantesFuncionesAdditional=null;
	
	public ProvinciaConstantesFuncionesAdditional getProvinciaConstantesFuncionesAdditional() {
		return this.provinciaConstantesFuncionesAdditional;
	}
	
	public void setProvinciaConstantesFuncionesAdditional(ProvinciaConstantesFuncionesAdditional provinciaConstantesFuncionesAdditional) {
		try {
			this.provinciaConstantesFuncionesAdditional=provinciaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String IDREGION= "id_region";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDREGION= "Region";
		public static final String LABEL_IDREGION_LOWER= "Region";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getProvinciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ProvinciaConstantesFunciones.IDPAIS)) {sLabelColumna=ProvinciaConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(ProvinciaConstantesFunciones.IDREGION)) {sLabelColumna=ProvinciaConstantesFunciones.LABEL_IDREGION;}
		if(sNombreColumna.equals(ProvinciaConstantesFunciones.CODIGO)) {sLabelColumna=ProvinciaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(ProvinciaConstantesFunciones.NOMBRE)) {sLabelColumna=ProvinciaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(provincia !=null/* && provincia.getId()!=0*/) {
			sDescripcion=provincia.getnombre();//provinciaprovincia.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getProvinciaDescripcionDetallado(Provincia provincia) {
		String sDescripcion="";
			
		sDescripcion+=ProvinciaConstantesFunciones.ID+"=";
		sDescripcion+=provincia.getId().toString()+",";
		sDescripcion+=ProvinciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=provincia.getVersionRow().toString()+",";
		sDescripcion+=ProvinciaConstantesFunciones.IDPAIS+"=";
		sDescripcion+=provincia.getid_pais().toString()+",";
		sDescripcion+=ProvinciaConstantesFunciones.IDREGION+"=";
		sDescripcion+=provincia.getid_region().toString()+",";
		sDescripcion+=ProvinciaConstantesFunciones.CODIGO+"=";
		sDescripcion+=provincia.getcodigo()+",";
		sDescripcion+=ProvinciaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=provincia.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setProvinciaDescripcion(Provincia provincia,String sValor) throws Exception {			
		if(provincia !=null) {
			provincia.setnombre(sValor);;//provinciaprovincia.getnombre().trim();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getRegionDescripcion(Region region) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(region!=null/*&&region.getId()>0*/) {
			sDescripcion=RegionConstantesFunciones.getRegionDescripcion(region);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorIdPaisPorNombre")) {
			sNombreIndice="Tipo=  Por Pais Por Nombre";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdRegion")) {
			sNombreIndice="Tipo=  Por Region";
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

	public static String getDetalleIndiceBusquedaPorIdPaisPorNombre(Long id_pais,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdRegion(Long id_region) {
		String sDetalleIndice=" Parametros->";
		if(id_region!=null) {sDetalleIndice+=" Codigo Unico De Region="+id_region.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosProvincia(Provincia provincia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		provincia.setcodigo(provincia.getcodigo().trim());
		provincia.setnombre(provincia.getnombre().trim());
	}
	
	public static void quitarEspaciosProvincias(List<Provincia> provincias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Provincia provincia: provincias) {
			provincia.setcodigo(provincia.getcodigo().trim());
			provincia.setnombre(provincia.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProvincia(Provincia provincia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && provincia.getConCambioAuxiliar()) {
			provincia.setIsDeleted(provincia.getIsDeletedAuxiliar());	
			provincia.setIsNew(provincia.getIsNewAuxiliar());	
			provincia.setIsChanged(provincia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			provincia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			provincia.setIsDeletedAuxiliar(false);	
			provincia.setIsNewAuxiliar(false);	
			provincia.setIsChangedAuxiliar(false);
			
			provincia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresProvincias(List<Provincia> provincias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Provincia provincia : provincias) {
			if(conAsignarBase && provincia.getConCambioAuxiliar()) {
				provincia.setIsDeleted(provincia.getIsDeletedAuxiliar());	
				provincia.setIsNew(provincia.getIsNewAuxiliar());	
				provincia.setIsChanged(provincia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				provincia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				provincia.setIsDeletedAuxiliar(false);	
				provincia.setIsNewAuxiliar(false);	
				provincia.setIsChangedAuxiliar(false);
				
				provincia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresProvincia(Provincia provincia,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresProvincias(List<Provincia> provincias,Boolean conEnteros) throws Exception  {
		
		for(Provincia provincia: provincias) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaProvincia(List<Provincia> provincias,Provincia provinciaAux) throws Exception  {
		ProvinciaConstantesFunciones.InicializarValoresProvincia(provinciaAux,true);
		
		for(Provincia provincia: provincias) {
			if(provincia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesProvincia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ProvinciaConstantesFunciones.getArrayColumnasGlobalesProvincia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesProvincia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoProvincia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Provincia> provincias,Provincia provincia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Provincia provinciaAux: provincias) {
			if(provinciaAux!=null && provincia!=null) {
				if((provinciaAux.getId()==null && provincia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(provinciaAux.getId()!=null && provincia.getId()!=null){
					if(provinciaAux.getId().equals(provincia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaProvincia(List<Provincia> provincias) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Provincia provincia: provincias) {			
			if(provincia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaProvincia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ProvinciaConstantesFunciones.LABEL_ID, ProvinciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvinciaConstantesFunciones.LABEL_VERSIONROW, ProvinciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvinciaConstantesFunciones.LABEL_IDPAIS, ProvinciaConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvinciaConstantesFunciones.LABEL_IDREGION, ProvinciaConstantesFunciones.IDREGION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvinciaConstantesFunciones.LABEL_CODIGO, ProvinciaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ProvinciaConstantesFunciones.LABEL_NOMBRE, ProvinciaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasProvincia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ProvinciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvinciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvinciaConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvinciaConstantesFunciones.IDREGION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvinciaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ProvinciaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProvincia() throws Exception  {
		return ProvinciaConstantesFunciones.getTiposSeleccionarProvincia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProvincia(Boolean conFk) throws Exception  {
		return ProvinciaConstantesFunciones.getTiposSeleccionarProvincia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarProvincia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvinciaConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(ProvinciaConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvinciaConstantesFunciones.LABEL_IDREGION);
			reporte.setsDescripcion(ProvinciaConstantesFunciones.LABEL_IDREGION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvinciaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ProvinciaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ProvinciaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ProvinciaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesProvincia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesProvincia(Provincia provinciaAux) throws Exception {
		
			provinciaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(provinciaAux.getPais()));
			provinciaAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(provinciaAux.getRegion()));		
	}
	
	public static void refrescarForeignKeysDescripcionesProvincia(List<Provincia> provinciasTemp) throws Exception {
		for(Provincia provinciaAux:provinciasTemp) {
			
			provinciaAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(provinciaAux.getPais()));
			provinciaAux.setregion_descripcion(RegionConstantesFunciones.getRegionDescripcion(provinciaAux.getRegion()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfProvincia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Region.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Region.class)) {
						classes.add(new Classe(Region.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfProvincia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Region.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Region.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfProvincia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProvinciaConstantesFunciones.getClassesRelationshipsOfProvincia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProvincia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Barrio.class));
				classes.add(new Classe(Canton.class));
				classes.add(new Classe(NumeroPatronal.class));
				classes.add(new Classe(DatoGeneralEmpleado.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(DatoGeneralUsuario.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Barrio.class)) {
						classes.add(new Classe(Barrio.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Canton.class)) {
						classes.add(new Classe(Canton.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NumeroPatronal.class)) {
						classes.add(new Classe(NumeroPatronal.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralUsuario.class)) {
						classes.add(new Classe(DatoGeneralUsuario.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProvincia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ProvinciaConstantesFunciones.getClassesRelationshipsFromStringsOfProvincia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfProvincia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Barrio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Barrio.class)); continue;
					}

					if(Canton.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Canton.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(DatoGeneralUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralUsuario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Barrio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Barrio.class)); continue;
					}

					if(Canton.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Canton.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(DatoGeneralUsuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralUsuario.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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
	public static void actualizarLista(Provincia provincia,List<Provincia> provincias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Provincia provinciaEncontrado=null;
			
			for(Provincia provinciaLocal:provincias) {
				if(provinciaLocal.getId().equals(provincia.getId())) {
					provinciaEncontrado=provinciaLocal;
					
					provinciaLocal.setIsChanged(provincia.getIsChanged());
					provinciaLocal.setIsNew(provincia.getIsNew());
					provinciaLocal.setIsDeleted(provincia.getIsDeleted());
					
					provinciaLocal.setGeneralEntityOriginal(provincia.getGeneralEntityOriginal());
					
					provinciaLocal.setId(provincia.getId());	
					provinciaLocal.setVersionRow(provincia.getVersionRow());	
					provinciaLocal.setid_pais(provincia.getid_pais());	
					provinciaLocal.setid_region(provincia.getid_region());	
					provinciaLocal.setcodigo(provincia.getcodigo());	
					provinciaLocal.setnombre(provincia.getnombre());	
					
					
					provinciaLocal.setCiudads(provincia.getCiudads());
					provinciaLocal.setClientes(provincia.getClientes());
					provinciaLocal.setCantons(provincia.getCantons());
					provinciaLocal.setBarrios(provincia.getBarrios());
					provinciaLocal.setEmpleados(provincia.getEmpleados());
					provinciaLocal.setDatoGeneralEmpleados(provincia.getDatoGeneralEmpleados());
					provinciaLocal.setParametroCarteraDefectos(provincia.getParametroCarteraDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!provincia.getIsDeleted()) {
				if(!existe) {
					provincias.add(provincia);
				}
			} else {
				if(provinciaEncontrado!=null && permiteQuitar)  {
					provincias.remove(provinciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Provincia provincia,List<Provincia> provincias) throws Exception {
		try	{			
			for(Provincia provinciaLocal:provincias) {
				if(provinciaLocal.getId().equals(provincia.getId())) {
					provinciaLocal.setIsSelected(provincia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesProvincia(List<Provincia> provinciasAux) throws Exception {
		//this.provinciasAux=provinciasAux;
		
		for(Provincia provinciaAux:provinciasAux) {
			if(provinciaAux.getIsChanged()) {
				provinciaAux.setIsChanged(false);
			}		
			
			if(provinciaAux.getIsNew()) {
				provinciaAux.setIsNew(false);
			}	
			
			if(provinciaAux.getIsDeleted()) {
				provinciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesProvincia(Provincia provinciaAux) throws Exception {
		//this.provinciaAux=provinciaAux;
		
			if(provinciaAux.getIsChanged()) {
				provinciaAux.setIsChanged(false);
			}		
			
			if(provinciaAux.getIsNew()) {
				provinciaAux.setIsNew(false);
			}	
			
			if(provinciaAux.getIsDeleted()) {
				provinciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Provincia provinciaAsignar,Provincia provincia) throws Exception {
		provinciaAsignar.setId(provincia.getId());	
		provinciaAsignar.setVersionRow(provincia.getVersionRow());	
		provinciaAsignar.setid_pais(provincia.getid_pais());
		provinciaAsignar.setpais_descripcion(provincia.getpais_descripcion());	
		provinciaAsignar.setid_region(provincia.getid_region());
		provinciaAsignar.setregion_descripcion(provincia.getregion_descripcion());	
		provinciaAsignar.setcodigo(provincia.getcodigo());	
		provinciaAsignar.setnombre(provincia.getnombre());	
	}
	
	public static void inicializarProvincia(Provincia provincia) throws Exception {
		try {
				provincia.setId(0L);	
					
				provincia.setid_pais(-1L);	
				provincia.setid_region(-1L);	
				provincia.setcodigo("");	
				provincia.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderProvincia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvinciaConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvinciaConstantesFunciones.LABEL_IDREGION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvinciaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ProvinciaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataProvincia(String sTipo,Row row,Workbook workbook,Provincia provincia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(provincia.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provincia.getregion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provincia.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(provincia.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryProvincia=" order by nombre" ;
	
	public String getsFinalQueryProvincia() {
		return this.sFinalQueryProvincia;
	}
	
	public void setsFinalQueryProvincia(String sFinalQueryProvincia) {
		this.sFinalQueryProvincia= sFinalQueryProvincia;
	}
	
	public Border resaltarSeleccionarProvincia=null;
	
	public Border setResaltarSeleccionarProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarProvincia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarProvincia() {
		return this.resaltarSeleccionarProvincia;
	}
	
	public void setResaltarSeleccionarProvincia(Border borderResaltarSeleccionarProvincia) {
		this.resaltarSeleccionarProvincia= borderResaltarSeleccionarProvincia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridProvincia=null;
	public Boolean mostraridProvincia=true;
	public Boolean activaridProvincia=true;

	public Border resaltarid_paisProvincia=null;
	public Boolean mostrarid_paisProvincia=true;
	public Boolean activarid_paisProvincia=true;
	public Boolean cargarid_paisProvincia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisProvincia=false;//ConEventDepend=true

	public Border resaltarid_regionProvincia=null;
	public Boolean mostrarid_regionProvincia=true;
	public Boolean activarid_regionProvincia=true;
	public Boolean cargarid_regionProvincia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_regionProvincia=true;//ConEventDepend=true

	public Border resaltarcodigoProvincia=null;
	public Boolean mostrarcodigoProvincia=true;
	public Boolean activarcodigoProvincia=true;

	public Border resaltarnombreProvincia=null;
	public Boolean mostrarnombreProvincia=true;
	public Boolean activarnombreProvincia=true;

	
	

	public Border setResaltaridProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltar);
		
		this.resaltaridProvincia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridProvincia() {
		return this.resaltaridProvincia;
	}

	public void setResaltaridProvincia(Border borderResaltar) {
		this.resaltaridProvincia= borderResaltar;
	}

	public Boolean getMostraridProvincia() {
		return this.mostraridProvincia;
	}

	public void setMostraridProvincia(Boolean mostraridProvincia) {
		this.mostraridProvincia= mostraridProvincia;
	}

	public Boolean getActivaridProvincia() {
		return this.activaridProvincia;
	}

	public void setActivaridProvincia(Boolean activaridProvincia) {
		this.activaridProvincia= activaridProvincia;
	}

	public Border setResaltarid_paisProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltar);
		
		this.resaltarid_paisProvincia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisProvincia() {
		return this.resaltarid_paisProvincia;
	}

	public void setResaltarid_paisProvincia(Border borderResaltar) {
		this.resaltarid_paisProvincia= borderResaltar;
	}

	public Boolean getMostrarid_paisProvincia() {
		return this.mostrarid_paisProvincia;
	}

	public void setMostrarid_paisProvincia(Boolean mostrarid_paisProvincia) {
		this.mostrarid_paisProvincia= mostrarid_paisProvincia;
	}

	public Boolean getActivarid_paisProvincia() {
		return this.activarid_paisProvincia;
	}

	public void setActivarid_paisProvincia(Boolean activarid_paisProvincia) {
		this.activarid_paisProvincia= activarid_paisProvincia;
	}

	public Boolean getCargarid_paisProvincia() {
		return this.cargarid_paisProvincia;
	}

	public void setCargarid_paisProvincia(Boolean cargarid_paisProvincia) {
		this.cargarid_paisProvincia= cargarid_paisProvincia;
	}

	public Border setResaltarid_regionProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltar);
		
		this.resaltarid_regionProvincia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_regionProvincia() {
		return this.resaltarid_regionProvincia;
	}

	public void setResaltarid_regionProvincia(Border borderResaltar) {
		this.resaltarid_regionProvincia= borderResaltar;
	}

	public Boolean getMostrarid_regionProvincia() {
		return this.mostrarid_regionProvincia;
	}

	public void setMostrarid_regionProvincia(Boolean mostrarid_regionProvincia) {
		this.mostrarid_regionProvincia= mostrarid_regionProvincia;
	}

	public Boolean getActivarid_regionProvincia() {
		return this.activarid_regionProvincia;
	}

	public void setActivarid_regionProvincia(Boolean activarid_regionProvincia) {
		this.activarid_regionProvincia= activarid_regionProvincia;
	}

	public Boolean getCargarid_regionProvincia() {
		return this.cargarid_regionProvincia;
	}

	public void setCargarid_regionProvincia(Boolean cargarid_regionProvincia) {
		this.cargarid_regionProvincia= cargarid_regionProvincia;
	}

	public Border setResaltarcodigoProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltar);
		
		this.resaltarcodigoProvincia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoProvincia() {
		return this.resaltarcodigoProvincia;
	}

	public void setResaltarcodigoProvincia(Border borderResaltar) {
		this.resaltarcodigoProvincia= borderResaltar;
	}

	public Boolean getMostrarcodigoProvincia() {
		return this.mostrarcodigoProvincia;
	}

	public void setMostrarcodigoProvincia(Boolean mostrarcodigoProvincia) {
		this.mostrarcodigoProvincia= mostrarcodigoProvincia;
	}

	public Boolean getActivarcodigoProvincia() {
		return this.activarcodigoProvincia;
	}

	public void setActivarcodigoProvincia(Boolean activarcodigoProvincia) {
		this.activarcodigoProvincia= activarcodigoProvincia;
	}

	public Border setResaltarnombreProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltar);
		
		this.resaltarnombreProvincia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreProvincia() {
		return this.resaltarnombreProvincia;
	}

	public void setResaltarnombreProvincia(Border borderResaltar) {
		this.resaltarnombreProvincia= borderResaltar;
	}

	public Boolean getMostrarnombreProvincia() {
		return this.mostrarnombreProvincia;
	}

	public void setMostrarnombreProvincia(Boolean mostrarnombreProvincia) {
		this.mostrarnombreProvincia= mostrarnombreProvincia;
	}

	public Boolean getActivarnombreProvincia() {
		return this.activarnombreProvincia;
	}

	public void setActivarnombreProvincia(Boolean activarnombreProvincia) {
		this.activarnombreProvincia= activarnombreProvincia;
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
		
		
		this.setMostraridProvincia(esInicial);
		this.setMostrarid_paisProvincia(esInicial);
		this.setMostrarid_regionProvincia(esInicial);
		this.setMostrarcodigoProvincia(esInicial);
		this.setMostrarnombreProvincia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProvinciaConstantesFunciones.ID)) {
				this.setMostraridProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.IDREGION)) {
				this.setMostrarid_regionProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreProvincia(esAsigna);
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
		
		
		this.setActivaridProvincia(esInicial);
		this.setActivarid_paisProvincia(esInicial);
		this.setActivarid_regionProvincia(esInicial);
		this.setActivarcodigoProvincia(esInicial);
		this.setActivarnombreProvincia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProvinciaConstantesFunciones.ID)) {
				this.setActivaridProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.IDREGION)) {
				this.setActivarid_regionProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreProvincia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridProvincia(esInicial);
		this.setResaltarid_paisProvincia(esInicial);
		this.setResaltarid_regionProvincia(esInicial);
		this.setResaltarcodigoProvincia(esInicial);
		this.setResaltarnombreProvincia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ProvinciaConstantesFunciones.ID)) {
				this.setResaltaridProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.IDREGION)) {
				this.setResaltarid_regionProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoProvincia(esAsigna);
				continue;
			}

			if(campo.clase.equals(ProvinciaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreProvincia(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBarrioProvincia=null;

	public Border getResaltarBarrioProvincia() {
		return this.resaltarBarrioProvincia;
	}

	public void setResaltarBarrioProvincia(Border borderResaltarBarrio) {
		if(borderResaltarBarrio!=null) {
			this.resaltarBarrioProvincia= borderResaltarBarrio;
		}
	}

	public Border setResaltarBarrioProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltarBarrio=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltarBarrio);
			
		this.resaltarBarrioProvincia= borderResaltarBarrio;

		 return borderResaltarBarrio;
	}



	public Boolean mostrarBarrioProvincia=true;

	public Boolean getMostrarBarrioProvincia() {
		return this.mostrarBarrioProvincia;
	}

	public void setMostrarBarrioProvincia(Boolean visibilidadResaltarBarrio) {
		this.mostrarBarrioProvincia= visibilidadResaltarBarrio;
	}



	public Boolean activarBarrioProvincia=true;

	public Boolean gethabilitarResaltarBarrioProvincia() {
		return this.activarBarrioProvincia;
	}

	public void setActivarBarrioProvincia(Boolean habilitarResaltarBarrio) {
		this.activarBarrioProvincia= habilitarResaltarBarrio;
	}


	public Border resaltarCantonProvincia=null;

	public Border getResaltarCantonProvincia() {
		return this.resaltarCantonProvincia;
	}

	public void setResaltarCantonProvincia(Border borderResaltarCanton) {
		if(borderResaltarCanton!=null) {
			this.resaltarCantonProvincia= borderResaltarCanton;
		}
	}

	public Border setResaltarCantonProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltarCanton=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltarCanton);
			
		this.resaltarCantonProvincia= borderResaltarCanton;

		 return borderResaltarCanton;
	}



	public Boolean mostrarCantonProvincia=true;

	public Boolean getMostrarCantonProvincia() {
		return this.mostrarCantonProvincia;
	}

	public void setMostrarCantonProvincia(Boolean visibilidadResaltarCanton) {
		this.mostrarCantonProvincia= visibilidadResaltarCanton;
	}



	public Boolean activarCantonProvincia=true;

	public Boolean gethabilitarResaltarCantonProvincia() {
		return this.activarCantonProvincia;
	}

	public void setActivarCantonProvincia(Boolean habilitarResaltarCanton) {
		this.activarCantonProvincia= habilitarResaltarCanton;
	}


	public Border resaltarDatoGeneralEmpleadoProvincia=null;

	public Border getResaltarDatoGeneralEmpleadoProvincia() {
		return this.resaltarDatoGeneralEmpleadoProvincia;
	}

	public void setResaltarDatoGeneralEmpleadoProvincia(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoProvincia= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoProvincia= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoProvincia=true;

	public Boolean getMostrarDatoGeneralEmpleadoProvincia() {
		return this.mostrarDatoGeneralEmpleadoProvincia;
	}

	public void setMostrarDatoGeneralEmpleadoProvincia(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoProvincia= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoProvincia=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoProvincia() {
		return this.activarDatoGeneralEmpleadoProvincia;
	}

	public void setActivarDatoGeneralEmpleadoProvincia(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoProvincia= habilitarResaltarDatoGeneralEmpleado;
	}


	public Border resaltarEmpleadoProvincia=null;

	public Border getResaltarEmpleadoProvincia() {
		return this.resaltarEmpleadoProvincia;
	}

	public void setResaltarEmpleadoProvincia(Border borderResaltarEmpleado) {
		if(borderResaltarEmpleado!=null) {
			this.resaltarEmpleadoProvincia= borderResaltarEmpleado;
		}
	}

	public Border setResaltarEmpleadoProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltarEmpleado);
			
		this.resaltarEmpleadoProvincia= borderResaltarEmpleado;

		 return borderResaltarEmpleado;
	}



	public Boolean mostrarEmpleadoProvincia=true;

	public Boolean getMostrarEmpleadoProvincia() {
		return this.mostrarEmpleadoProvincia;
	}

	public void setMostrarEmpleadoProvincia(Boolean visibilidadResaltarEmpleado) {
		this.mostrarEmpleadoProvincia= visibilidadResaltarEmpleado;
	}



	public Boolean activarEmpleadoProvincia=true;

	public Boolean gethabilitarResaltarEmpleadoProvincia() {
		return this.activarEmpleadoProvincia;
	}

	public void setActivarEmpleadoProvincia(Boolean habilitarResaltarEmpleado) {
		this.activarEmpleadoProvincia= habilitarResaltarEmpleado;
	}


	public Border resaltarClienteProvincia=null;

	public Border getResaltarClienteProvincia() {
		return this.resaltarClienteProvincia;
	}

	public void setResaltarClienteProvincia(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteProvincia= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltarCliente);
			
		this.resaltarClienteProvincia= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteProvincia=true;

	public Boolean getMostrarClienteProvincia() {
		return this.mostrarClienteProvincia;
	}

	public void setMostrarClienteProvincia(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteProvincia= visibilidadResaltarCliente;
	}



	public Boolean activarClienteProvincia=true;

	public Boolean gethabilitarResaltarClienteProvincia() {
		return this.activarClienteProvincia;
	}

	public void setActivarClienteProvincia(Boolean habilitarResaltarCliente) {
		this.activarClienteProvincia= habilitarResaltarCliente;
	}


	public Border resaltarParametroCarteraDefectoProvincia=null;

	public Border getResaltarParametroCarteraDefectoProvincia() {
		return this.resaltarParametroCarteraDefectoProvincia;
	}

	public void setResaltarParametroCarteraDefectoProvincia(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoProvincia= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoProvincia= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoProvincia=true;

	public Boolean getMostrarParametroCarteraDefectoProvincia() {
		return this.mostrarParametroCarteraDefectoProvincia;
	}

	public void setMostrarParametroCarteraDefectoProvincia(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoProvincia= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoProvincia=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoProvincia() {
		return this.activarParametroCarteraDefectoProvincia;
	}

	public void setActivarParametroCarteraDefectoProvincia(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoProvincia= habilitarResaltarParametroCarteraDefecto;
	}


	public Border resaltarCiudadProvincia=null;

	public Border getResaltarCiudadProvincia() {
		return this.resaltarCiudadProvincia;
	}

	public void setResaltarCiudadProvincia(Border borderResaltarCiudad) {
		if(borderResaltarCiudad!=null) {
			this.resaltarCiudadProvincia= borderResaltarCiudad;
		}
	}

	public Border setResaltarCiudadProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltarCiudad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//provinciaBeanSwingJInternalFrame.jTtoolBarProvincia.setBorder(borderResaltarCiudad);
			
		this.resaltarCiudadProvincia= borderResaltarCiudad;

		 return borderResaltarCiudad;
	}



	public Boolean mostrarCiudadProvincia=true;

	public Boolean getMostrarCiudadProvincia() {
		return this.mostrarCiudadProvincia;
	}

	public void setMostrarCiudadProvincia(Boolean visibilidadResaltarCiudad) {
		this.mostrarCiudadProvincia= visibilidadResaltarCiudad;
	}



	public Boolean activarCiudadProvincia=true;

	public Boolean gethabilitarResaltarCiudadProvincia() {
		return this.activarCiudadProvincia;
	}

	public void setActivarCiudadProvincia(Boolean habilitarResaltarCiudad) {
		this.activarCiudadProvincia= habilitarResaltarCiudad;
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

		this.setMostrarBarrioProvincia(esInicial);
		this.setMostrarCantonProvincia(esInicial);
		this.setMostrarDatoGeneralEmpleadoProvincia(esInicial);
		this.setMostrarEmpleadoProvincia(esInicial);
		this.setMostrarClienteProvincia(esInicial);
		this.setMostrarParametroCarteraDefectoProvincia(esInicial);
		this.setMostrarCiudadProvincia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Barrio.class)) {
				this.setMostrarBarrioProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Canton.class)) {
				this.setMostrarCantonProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setMostrarEmpleadoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Ciudad.class)) {
				this.setMostrarCiudadProvincia(esAsigna);
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

		this.setActivarBarrioProvincia(esInicial);
		this.setActivarCantonProvincia(esInicial);
		this.setActivarDatoGeneralEmpleadoProvincia(esInicial);
		this.setActivarEmpleadoProvincia(esInicial);
		this.setActivarClienteProvincia(esInicial);
		this.setActivarParametroCarteraDefectoProvincia(esInicial);
		this.setActivarCiudadProvincia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Barrio.class)) {
				this.setActivarBarrioProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Canton.class)) {
				this.setActivarCantonProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setActivarEmpleadoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Ciudad.class)) {
				this.setActivarCiudadProvincia(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBarrioProvincia(esInicial);
		this.setResaltarCantonProvincia(esInicial);
		this.setResaltarDatoGeneralEmpleadoProvincia(esInicial);
		this.setResaltarEmpleadoProvincia(esInicial);
		this.setResaltarClienteProvincia(esInicial);
		this.setResaltarParametroCarteraDefectoProvincia(esInicial);
		this.setResaltarCiudadProvincia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Barrio.class)) {
				this.setResaltarBarrioProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Canton.class)) {
				this.setResaltarCantonProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Empleado.class)) {
				this.setResaltarEmpleadoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoProvincia(esAsigna);
				continue;
			}

			if(clase.clas.equals(Ciudad.class)) {
				this.setResaltarCiudadProvincia(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdPaisPorNombreProvincia=true;

	public Boolean getMostrarBusquedaPorIdPaisPorNombreProvincia() {
		return this.mostrarBusquedaPorIdPaisPorNombreProvincia;
	}

	public void setMostrarBusquedaPorIdPaisPorNombreProvincia(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdPaisPorNombreProvincia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisProvincia=true;

	public Boolean getMostrarFK_IdPaisProvincia() {
		return this.mostrarFK_IdPaisProvincia;
	}

	public void setMostrarFK_IdPaisProvincia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisProvincia= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdPaisPorNombreProvincia=true;

	public Boolean getActivarBusquedaPorIdPaisPorNombreProvincia() {
		return this.activarBusquedaPorIdPaisPorNombreProvincia;
	}

	public void setActivarBusquedaPorIdPaisPorNombreProvincia(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdPaisPorNombreProvincia= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisProvincia=true;

	public Boolean getActivarFK_IdPaisProvincia() {
		return this.activarFK_IdPaisProvincia;
	}

	public void setActivarFK_IdPaisProvincia(Boolean habilitarResaltar) {
		this.activarFK_IdPaisProvincia= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdPaisPorNombreProvincia=null;

	public Border getResaltarBusquedaPorIdPaisPorNombreProvincia() {
		return this.resaltarBusquedaPorIdPaisPorNombreProvincia;
	}

	public void setResaltarBusquedaPorIdPaisPorNombreProvincia(Border borderResaltar) {
		this.resaltarBusquedaPorIdPaisPorNombreProvincia= borderResaltar;
	}

	public void setResaltarBusquedaPorIdPaisPorNombreProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdPaisPorNombreProvincia= borderResaltar;
	}

	public Border resaltarFK_IdPaisProvincia=null;

	public Border getResaltarFK_IdPaisProvincia() {
		return this.resaltarFK_IdPaisProvincia;
	}

	public void setResaltarFK_IdPaisProvincia(Border borderResaltar) {
		this.resaltarFK_IdPaisProvincia= borderResaltar;
	}

	public void setResaltarFK_IdPaisProvincia(ParametroGeneralUsuario parametroGeneralUsuario/*ProvinciaBeanSwingJInternalFrame provinciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisProvincia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}