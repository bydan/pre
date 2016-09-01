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


import com.bydan.erp.inventario.util.UnidadConstantesFunciones;
import com.bydan.erp.inventario.util.UnidadParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UnidadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class UnidadConstantesFunciones extends UnidadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Unidad";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Unidad"+UnidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="UnidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="UnidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=UnidadConstantesFunciones.SCHEMA+"_"+UnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/UnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=UnidadConstantesFunciones.SCHEMA+"_"+UnidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=UnidadConstantesFunciones.SCHEMA+"_"+UnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/UnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=UnidadConstantesFunciones.SCHEMA+"_"+UnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UnidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UnidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/UnidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+UnidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=UnidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+UnidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=UnidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+UnidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Unidades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Unidad";
	public static final String SCLASSWEBTITULO_LOWER="Unidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Unidad";
	public static final String OBJECTNAME="unidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="unidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select unidad from "+UnidadConstantesFunciones.SPERSISTENCENAME+" unidad";
	public static String QUERYSELECTNATIVE="select "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".id,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".version_row,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".id_empresa,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".id_tipo_unidad,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".nombre,"+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME+".siglas from "+UnidadConstantesFunciones.SCHEMA+"."+UnidadConstantesFunciones.TABLENAME;//+" as "+UnidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected UnidadConstantesFuncionesAdditional unidadConstantesFuncionesAdditional=null;
	
	public UnidadConstantesFuncionesAdditional getUnidadConstantesFuncionesAdditional() {
		return this.unidadConstantesFuncionesAdditional;
	}
	
	public void setUnidadConstantesFuncionesAdditional(UnidadConstantesFuncionesAdditional unidadConstantesFuncionesAdditional) {
		try {
			this.unidadConstantesFuncionesAdditional=unidadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOUNIDAD= "id_tipo_unidad";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOUNIDAD= "Tipo Unidad";
		public static final String LABEL_IDTIPOUNIDAD_LOWER= "Tipo Unidad";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getUnidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(UnidadConstantesFunciones.IDEMPRESA)) {sLabelColumna=UnidadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(UnidadConstantesFunciones.IDTIPOUNIDAD)) {sLabelColumna=UnidadConstantesFunciones.LABEL_IDTIPOUNIDAD;}
		if(sNombreColumna.equals(UnidadConstantesFunciones.NOMBRE)) {sLabelColumna=UnidadConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(UnidadConstantesFunciones.SIGLAS)) {sLabelColumna=UnidadConstantesFunciones.LABEL_SIGLAS;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(unidad !=null/* && unidad.getId()!=0*/) {
			sDescripcion=unidad.getnombre();//unidadunidad.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getUnidadDescripcionDetallado(Unidad unidad) {
		String sDescripcion="";
			
		sDescripcion+=UnidadConstantesFunciones.ID+"=";
		sDescripcion+=unidad.getId().toString()+",";
		sDescripcion+=UnidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=unidad.getVersionRow().toString()+",";
		sDescripcion+=UnidadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=unidad.getid_empresa().toString()+",";
		sDescripcion+=UnidadConstantesFunciones.IDTIPOUNIDAD+"=";
		sDescripcion+=unidad.getid_tipo_unidad().toString()+",";
		sDescripcion+=UnidadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=unidad.getnombre()+",";
		sDescripcion+=UnidadConstantesFunciones.SIGLAS+"=";
		sDescripcion+=unidad.getsiglas()+",";
			
		return sDescripcion;
	}
	
	public static void setUnidadDescripcion(Unidad unidad,String sValor) throws Exception {			
		if(unidad !=null) {
			unidad.setnombre(sValor);;//unidadunidad.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoUnidadDescripcion(TipoUnidad tipounidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipounidad!=null/*&&tipounidad.getId()>0*/) {
			sDescripcion=TipoUnidadConstantesFunciones.getTipoUnidadDescripcion(tipounidad);
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
		} else if(sNombreIndice.equals("BusquedaPorSiglas")) {
			sNombreIndice="Tipo=  Por Siglas";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoUnidad")) {
			sNombreIndice="Tipo=  Por Tipo Unidad";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Empresa Por Nombre";
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

	public static String getDetalleIndiceBusquedaPorSiglas(String siglas) {
		String sDetalleIndice=" Parametros->";
		if(siglas!=null) {sDetalleIndice+=" Siglas="+siglas;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoUnidad(Long id_tipo_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_unidad!=null) {sDetalleIndice+=" Codigo Unico De Tipo Unidad="+id_tipo_unidad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorNombre(Long id_empresa,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosUnidad(Unidad unidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		unidad.setnombre(unidad.getnombre().trim());
		unidad.setsiglas(unidad.getsiglas().trim());
	}
	
	public static void quitarEspaciosUnidads(List<Unidad> unidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Unidad unidad: unidads) {
			unidad.setnombre(unidad.getnombre().trim());
			unidad.setsiglas(unidad.getsiglas().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUnidad(Unidad unidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && unidad.getConCambioAuxiliar()) {
			unidad.setIsDeleted(unidad.getIsDeletedAuxiliar());	
			unidad.setIsNew(unidad.getIsNewAuxiliar());	
			unidad.setIsChanged(unidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			unidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			unidad.setIsDeletedAuxiliar(false);	
			unidad.setIsNewAuxiliar(false);	
			unidad.setIsChangedAuxiliar(false);
			
			unidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresUnidads(List<Unidad> unidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Unidad unidad : unidads) {
			if(conAsignarBase && unidad.getConCambioAuxiliar()) {
				unidad.setIsDeleted(unidad.getIsDeletedAuxiliar());	
				unidad.setIsNew(unidad.getIsNewAuxiliar());	
				unidad.setIsChanged(unidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				unidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				unidad.setIsDeletedAuxiliar(false);	
				unidad.setIsNewAuxiliar(false);	
				unidad.setIsChangedAuxiliar(false);
				
				unidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresUnidad(Unidad unidad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresUnidads(List<Unidad> unidads,Boolean conEnteros) throws Exception  {
		
		for(Unidad unidad: unidads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaUnidad(List<Unidad> unidads,Unidad unidadAux) throws Exception  {
		UnidadConstantesFunciones.InicializarValoresUnidad(unidadAux,true);
		
		for(Unidad unidad: unidads) {
			if(unidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=UnidadConstantesFunciones.getArrayColumnasGlobalesUnidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesUnidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(UnidadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(UnidadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoUnidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Unidad> unidads,Unidad unidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Unidad unidadAux: unidads) {
			if(unidadAux!=null && unidad!=null) {
				if((unidadAux.getId()==null && unidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(unidadAux.getId()!=null && unidad.getId()!=null){
					if(unidadAux.getId().equals(unidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaUnidad(List<Unidad> unidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Unidad unidad: unidads) {			
			if(unidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaUnidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,UnidadConstantesFunciones.LABEL_ID, UnidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UnidadConstantesFunciones.LABEL_VERSIONROW, UnidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UnidadConstantesFunciones.LABEL_IDEMPRESA, UnidadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UnidadConstantesFunciones.LABEL_IDTIPOUNIDAD, UnidadConstantesFunciones.IDTIPOUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UnidadConstantesFunciones.LABEL_NOMBRE, UnidadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,UnidadConstantesFunciones.LABEL_SIGLAS, UnidadConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasUnidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=UnidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UnidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UnidadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UnidadConstantesFunciones.IDTIPOUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UnidadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=UnidadConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUnidad() throws Exception  {
		return UnidadConstantesFunciones.getTiposSeleccionarUnidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUnidad(Boolean conFk) throws Exception  {
		return UnidadConstantesFunciones.getTiposSeleccionarUnidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarUnidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UnidadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(UnidadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(UnidadConstantesFunciones.LABEL_IDTIPOUNIDAD);
			reporte.setsDescripcion(UnidadConstantesFunciones.LABEL_IDTIPOUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UnidadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(UnidadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(UnidadConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(UnidadConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesUnidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesUnidad(Unidad unidadAux) throws Exception {
		
			unidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(unidadAux.getEmpresa()));
			unidadAux.settipounidad_descripcion(TipoUnidadConstantesFunciones.getTipoUnidadDescripcion(unidadAux.getTipoUnidad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesUnidad(List<Unidad> unidadsTemp) throws Exception {
		for(Unidad unidadAux:unidadsTemp) {
			
			unidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(unidadAux.getEmpresa()));
			unidadAux.settipounidad_descripcion(TipoUnidadConstantesFunciones.getTipoUnidadDescripcion(unidadAux.getTipoUnidad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoUnidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoUnidad.class)) {
						classes.add(new Classe(TipoUnidad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoUnidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoUnidad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoUnidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoUnidad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return UnidadConstantesFunciones.getClassesRelationshipsOfUnidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUnidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(ConversionInven.class));
				classes.add(new Classe(RangoUnidadVenta.class));
				classes.add(new Classe(ValorPorUnidad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ConversionInven.class)) {
						classes.add(new Classe(ConversionInven.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(RangoUnidadVenta.class)) {
						classes.add(new Classe(RangoUnidadVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ValorPorUnidad.class)) {
						classes.add(new Classe(ValorPorUnidad.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return UnidadConstantesFunciones.getClassesRelationshipsFromStringsOfUnidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfUnidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ConversionInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ConversionInven.class)); continue;
					}

					if(RangoUnidadVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RangoUnidadVenta.class)); continue;
					}

					if(ValorPorUnidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ValorPorUnidad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(ConversionInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ConversionInven.class)); continue;
					}

					if(RangoUnidadVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(RangoUnidadVenta.class)); continue;
					}

					if(ValorPorUnidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ValorPorUnidad.class)); continue;
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
	public static void actualizarLista(Unidad unidad,List<Unidad> unidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Unidad unidadEncontrado=null;
			
			for(Unidad unidadLocal:unidads) {
				if(unidadLocal.getId().equals(unidad.getId())) {
					unidadEncontrado=unidadLocal;
					
					unidadLocal.setIsChanged(unidad.getIsChanged());
					unidadLocal.setIsNew(unidad.getIsNew());
					unidadLocal.setIsDeleted(unidad.getIsDeleted());
					
					unidadLocal.setGeneralEntityOriginal(unidad.getGeneralEntityOriginal());
					
					unidadLocal.setId(unidad.getId());	
					unidadLocal.setVersionRow(unidad.getVersionRow());	
					unidadLocal.setid_empresa(unidad.getid_empresa());	
					unidadLocal.setid_tipo_unidad(unidad.getid_tipo_unidad());	
					unidadLocal.setnombre(unidad.getnombre());	
					unidadLocal.setsiglas(unidad.getsiglas());	
					
					
					unidadLocal.setProductos(unidad.getProductos());
					unidadLocal.setConversionInvenConversions(unidad.getConversionInvenConversions());
					unidadLocal.setRangoUnidadVentas(unidad.getRangoUnidadVentas());
					unidadLocal.setValorPorUnidads(unidad.getValorPorUnidads());
					
					existe=true;
					break;
				}
			}
			
			if(!unidad.getIsDeleted()) {
				if(!existe) {
					unidads.add(unidad);
				}
			} else {
				if(unidadEncontrado!=null && permiteQuitar)  {
					unidads.remove(unidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Unidad unidad,List<Unidad> unidads) throws Exception {
		try	{			
			for(Unidad unidadLocal:unidads) {
				if(unidadLocal.getId().equals(unidad.getId())) {
					unidadLocal.setIsSelected(unidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesUnidad(List<Unidad> unidadsAux) throws Exception {
		//this.unidadsAux=unidadsAux;
		
		for(Unidad unidadAux:unidadsAux) {
			if(unidadAux.getIsChanged()) {
				unidadAux.setIsChanged(false);
			}		
			
			if(unidadAux.getIsNew()) {
				unidadAux.setIsNew(false);
			}	
			
			if(unidadAux.getIsDeleted()) {
				unidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesUnidad(Unidad unidadAux) throws Exception {
		//this.unidadAux=unidadAux;
		
			if(unidadAux.getIsChanged()) {
				unidadAux.setIsChanged(false);
			}		
			
			if(unidadAux.getIsNew()) {
				unidadAux.setIsNew(false);
			}	
			
			if(unidadAux.getIsDeleted()) {
				unidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Unidad unidadAsignar,Unidad unidad) throws Exception {
		unidadAsignar.setId(unidad.getId());	
		unidadAsignar.setVersionRow(unidad.getVersionRow());	
		unidadAsignar.setid_empresa(unidad.getid_empresa());
		unidadAsignar.setempresa_descripcion(unidad.getempresa_descripcion());	
		unidadAsignar.setid_tipo_unidad(unidad.getid_tipo_unidad());
		unidadAsignar.settipounidad_descripcion(unidad.gettipounidad_descripcion());	
		unidadAsignar.setnombre(unidad.getnombre());	
		unidadAsignar.setsiglas(unidad.getsiglas());	
	}
	
	public static void inicializarUnidad(Unidad unidad) throws Exception {
		try {
				unidad.setId(0L);	
					
				unidad.setid_empresa(-1L);	
				unidad.setid_tipo_unidad(-1L);	
				unidad.setnombre("");	
				unidad.setsiglas("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderUnidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(UnidadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UnidadConstantesFunciones.LABEL_IDTIPOUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UnidadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(UnidadConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataUnidad(String sTipo,Row row,Workbook workbook,Unidad unidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(unidad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(unidad.gettipounidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(unidad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(unidad.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryUnidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryUnidad() {
		return this.sFinalQueryUnidad;
	}
	
	public void setsFinalQueryUnidad(String sFinalQueryUnidad) {
		this.sFinalQueryUnidad= sFinalQueryUnidad;
	}
	
	public Border resaltarSeleccionarUnidad=null;
	
	public Border setResaltarSeleccionarUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarUnidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarUnidad() {
		return this.resaltarSeleccionarUnidad;
	}
	
	public void setResaltarSeleccionarUnidad(Border borderResaltarSeleccionarUnidad) {
		this.resaltarSeleccionarUnidad= borderResaltarSeleccionarUnidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridUnidad=null;
	public Boolean mostraridUnidad=true;
	public Boolean activaridUnidad=true;

	public Border resaltarid_empresaUnidad=null;
	public Boolean mostrarid_empresaUnidad=true;
	public Boolean activarid_empresaUnidad=true;
	public Boolean cargarid_empresaUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaUnidad=false;//ConEventDepend=true

	public Border resaltarid_tipo_unidadUnidad=null;
	public Boolean mostrarid_tipo_unidadUnidad=true;
	public Boolean activarid_tipo_unidadUnidad=true;
	public Boolean cargarid_tipo_unidadUnidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_unidadUnidad=false;//ConEventDepend=true

	public Border resaltarnombreUnidad=null;
	public Boolean mostrarnombreUnidad=true;
	public Boolean activarnombreUnidad=true;

	public Border resaltarsiglasUnidad=null;
	public Boolean mostrarsiglasUnidad=true;
	public Boolean activarsiglasUnidad=true;

	
	

	public Border setResaltaridUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltar);
		
		this.resaltaridUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridUnidad() {
		return this.resaltaridUnidad;
	}

	public void setResaltaridUnidad(Border borderResaltar) {
		this.resaltaridUnidad= borderResaltar;
	}

	public Boolean getMostraridUnidad() {
		return this.mostraridUnidad;
	}

	public void setMostraridUnidad(Boolean mostraridUnidad) {
		this.mostraridUnidad= mostraridUnidad;
	}

	public Boolean getActivaridUnidad() {
		return this.activaridUnidad;
	}

	public void setActivaridUnidad(Boolean activaridUnidad) {
		this.activaridUnidad= activaridUnidad;
	}

	public Border setResaltarid_empresaUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltar);
		
		this.resaltarid_empresaUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaUnidad() {
		return this.resaltarid_empresaUnidad;
	}

	public void setResaltarid_empresaUnidad(Border borderResaltar) {
		this.resaltarid_empresaUnidad= borderResaltar;
	}

	public Boolean getMostrarid_empresaUnidad() {
		return this.mostrarid_empresaUnidad;
	}

	public void setMostrarid_empresaUnidad(Boolean mostrarid_empresaUnidad) {
		this.mostrarid_empresaUnidad= mostrarid_empresaUnidad;
	}

	public Boolean getActivarid_empresaUnidad() {
		return this.activarid_empresaUnidad;
	}

	public void setActivarid_empresaUnidad(Boolean activarid_empresaUnidad) {
		this.activarid_empresaUnidad= activarid_empresaUnidad;
	}

	public Boolean getCargarid_empresaUnidad() {
		return this.cargarid_empresaUnidad;
	}

	public void setCargarid_empresaUnidad(Boolean cargarid_empresaUnidad) {
		this.cargarid_empresaUnidad= cargarid_empresaUnidad;
	}

	public Border setResaltarid_tipo_unidadUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltar);
		
		this.resaltarid_tipo_unidadUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_unidadUnidad() {
		return this.resaltarid_tipo_unidadUnidad;
	}

	public void setResaltarid_tipo_unidadUnidad(Border borderResaltar) {
		this.resaltarid_tipo_unidadUnidad= borderResaltar;
	}

	public Boolean getMostrarid_tipo_unidadUnidad() {
		return this.mostrarid_tipo_unidadUnidad;
	}

	public void setMostrarid_tipo_unidadUnidad(Boolean mostrarid_tipo_unidadUnidad) {
		this.mostrarid_tipo_unidadUnidad= mostrarid_tipo_unidadUnidad;
	}

	public Boolean getActivarid_tipo_unidadUnidad() {
		return this.activarid_tipo_unidadUnidad;
	}

	public void setActivarid_tipo_unidadUnidad(Boolean activarid_tipo_unidadUnidad) {
		this.activarid_tipo_unidadUnidad= activarid_tipo_unidadUnidad;
	}

	public Boolean getCargarid_tipo_unidadUnidad() {
		return this.cargarid_tipo_unidadUnidad;
	}

	public void setCargarid_tipo_unidadUnidad(Boolean cargarid_tipo_unidadUnidad) {
		this.cargarid_tipo_unidadUnidad= cargarid_tipo_unidadUnidad;
	}

	public Border setResaltarnombreUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltar);
		
		this.resaltarnombreUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreUnidad() {
		return this.resaltarnombreUnidad;
	}

	public void setResaltarnombreUnidad(Border borderResaltar) {
		this.resaltarnombreUnidad= borderResaltar;
	}

	public Boolean getMostrarnombreUnidad() {
		return this.mostrarnombreUnidad;
	}

	public void setMostrarnombreUnidad(Boolean mostrarnombreUnidad) {
		this.mostrarnombreUnidad= mostrarnombreUnidad;
	}

	public Boolean getActivarnombreUnidad() {
		return this.activarnombreUnidad;
	}

	public void setActivarnombreUnidad(Boolean activarnombreUnidad) {
		this.activarnombreUnidad= activarnombreUnidad;
	}

	public Border setResaltarsiglasUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltar);
		
		this.resaltarsiglasUnidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasUnidad() {
		return this.resaltarsiglasUnidad;
	}

	public void setResaltarsiglasUnidad(Border borderResaltar) {
		this.resaltarsiglasUnidad= borderResaltar;
	}

	public Boolean getMostrarsiglasUnidad() {
		return this.mostrarsiglasUnidad;
	}

	public void setMostrarsiglasUnidad(Boolean mostrarsiglasUnidad) {
		this.mostrarsiglasUnidad= mostrarsiglasUnidad;
	}

	public Boolean getActivarsiglasUnidad() {
		return this.activarsiglasUnidad;
	}

	public void setActivarsiglasUnidad(Boolean activarsiglasUnidad) {
		this.activarsiglasUnidad= activarsiglasUnidad;
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
		
		
		this.setMostraridUnidad(esInicial);
		this.setMostrarid_empresaUnidad(esInicial);
		this.setMostrarid_tipo_unidadUnidad(esInicial);
		this.setMostrarnombreUnidad(esInicial);
		this.setMostrarsiglasUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UnidadConstantesFunciones.ID)) {
				this.setMostraridUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.IDTIPOUNIDAD)) {
				this.setMostrarid_tipo_unidadUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasUnidad(esAsigna);
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
		
		
		this.setActivaridUnidad(esInicial);
		this.setActivarid_empresaUnidad(esInicial);
		this.setActivarid_tipo_unidadUnidad(esInicial);
		this.setActivarnombreUnidad(esInicial);
		this.setActivarsiglasUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UnidadConstantesFunciones.ID)) {
				this.setActivaridUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.IDTIPOUNIDAD)) {
				this.setActivarid_tipo_unidadUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasUnidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridUnidad(esInicial);
		this.setResaltarid_empresaUnidad(esInicial);
		this.setResaltarid_tipo_unidadUnidad(esInicial);
		this.setResaltarnombreUnidad(esInicial);
		this.setResaltarsiglasUnidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(UnidadConstantesFunciones.ID)) {
				this.setResaltaridUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.IDTIPOUNIDAD)) {
				this.setResaltarid_tipo_unidadUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreUnidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(UnidadConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasUnidad(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoUnidad=null;

	public Border getResaltarProductoUnidad() {
		return this.resaltarProductoUnidad;
	}

	public void setResaltarProductoUnidad(Border borderResaltarProducto) {
		if(borderResaltarProducto!=null) {
			this.resaltarProductoUnidad= borderResaltarProducto;
		}
	}

	public Border setResaltarProductoUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltarProducto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltarProducto);
			
		this.resaltarProductoUnidad= borderResaltarProducto;

		 return borderResaltarProducto;
	}



	public Boolean mostrarProductoUnidad=true;

	public Boolean getMostrarProductoUnidad() {
		return this.mostrarProductoUnidad;
	}

	public void setMostrarProductoUnidad(Boolean visibilidadResaltarProducto) {
		this.mostrarProductoUnidad= visibilidadResaltarProducto;
	}



	public Boolean activarProductoUnidad=true;

	public Boolean gethabilitarResaltarProductoUnidad() {
		return this.activarProductoUnidad;
	}

	public void setActivarProductoUnidad(Boolean habilitarResaltarProducto) {
		this.activarProductoUnidad= habilitarResaltarProducto;
	}


	public Border resaltarConversionInvenUnidad=null;

	public Border getResaltarConversionInvenUnidad() {
		return this.resaltarConversionInvenUnidad;
	}

	public void setResaltarConversionInvenUnidad(Border borderResaltarConversionInven) {
		if(borderResaltarConversionInven!=null) {
			this.resaltarConversionInvenUnidad= borderResaltarConversionInven;
		}
	}

	public Border setResaltarConversionInvenUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltarConversionInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltarConversionInven);
			
		this.resaltarConversionInvenUnidad= borderResaltarConversionInven;

		 return borderResaltarConversionInven;
	}



	public Boolean mostrarConversionInvenUnidad=true;

	public Boolean getMostrarConversionInvenUnidad() {
		return this.mostrarConversionInvenUnidad;
	}

	public void setMostrarConversionInvenUnidad(Boolean visibilidadResaltarConversionInven) {
		this.mostrarConversionInvenUnidad= visibilidadResaltarConversionInven;
	}



	public Boolean activarConversionInvenUnidad=true;

	public Boolean gethabilitarResaltarConversionInvenUnidad() {
		return this.activarConversionInvenUnidad;
	}

	public void setActivarConversionInvenUnidad(Boolean habilitarResaltarConversionInven) {
		this.activarConversionInvenUnidad= habilitarResaltarConversionInven;
	}


	public Border resaltarRangoUnidadVentaUnidad=null;

	public Border getResaltarRangoUnidadVentaUnidad() {
		return this.resaltarRangoUnidadVentaUnidad;
	}

	public void setResaltarRangoUnidadVentaUnidad(Border borderResaltarRangoUnidadVenta) {
		if(borderResaltarRangoUnidadVenta!=null) {
			this.resaltarRangoUnidadVentaUnidad= borderResaltarRangoUnidadVenta;
		}
	}

	public Border setResaltarRangoUnidadVentaUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltarRangoUnidadVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltarRangoUnidadVenta);
			
		this.resaltarRangoUnidadVentaUnidad= borderResaltarRangoUnidadVenta;

		 return borderResaltarRangoUnidadVenta;
	}



	public Boolean mostrarRangoUnidadVentaUnidad=true;

	public Boolean getMostrarRangoUnidadVentaUnidad() {
		return this.mostrarRangoUnidadVentaUnidad;
	}

	public void setMostrarRangoUnidadVentaUnidad(Boolean visibilidadResaltarRangoUnidadVenta) {
		this.mostrarRangoUnidadVentaUnidad= visibilidadResaltarRangoUnidadVenta;
	}



	public Boolean activarRangoUnidadVentaUnidad=true;

	public Boolean gethabilitarResaltarRangoUnidadVentaUnidad() {
		return this.activarRangoUnidadVentaUnidad;
	}

	public void setActivarRangoUnidadVentaUnidad(Boolean habilitarResaltarRangoUnidadVenta) {
		this.activarRangoUnidadVentaUnidad= habilitarResaltarRangoUnidadVenta;
	}


	public Border resaltarValorPorUnidadUnidad=null;

	public Border getResaltarValorPorUnidadUnidad() {
		return this.resaltarValorPorUnidadUnidad;
	}

	public void setResaltarValorPorUnidadUnidad(Border borderResaltarValorPorUnidad) {
		if(borderResaltarValorPorUnidad!=null) {
			this.resaltarValorPorUnidadUnidad= borderResaltarValorPorUnidad;
		}
	}

	public Border setResaltarValorPorUnidadUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltarValorPorUnidad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//unidadBeanSwingJInternalFrame.jTtoolBarUnidad.setBorder(borderResaltarValorPorUnidad);
			
		this.resaltarValorPorUnidadUnidad= borderResaltarValorPorUnidad;

		 return borderResaltarValorPorUnidad;
	}



	public Boolean mostrarValorPorUnidadUnidad=true;

	public Boolean getMostrarValorPorUnidadUnidad() {
		return this.mostrarValorPorUnidadUnidad;
	}

	public void setMostrarValorPorUnidadUnidad(Boolean visibilidadResaltarValorPorUnidad) {
		this.mostrarValorPorUnidadUnidad= visibilidadResaltarValorPorUnidad;
	}



	public Boolean activarValorPorUnidadUnidad=true;

	public Boolean gethabilitarResaltarValorPorUnidadUnidad() {
		return this.activarValorPorUnidadUnidad;
	}

	public void setActivarValorPorUnidadUnidad(Boolean habilitarResaltarValorPorUnidad) {
		this.activarValorPorUnidadUnidad= habilitarResaltarValorPorUnidad;
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

		this.setMostrarProductoUnidad(esInicial);
		this.setMostrarConversionInvenUnidad(esInicial);
		this.setMostrarRangoUnidadVentaUnidad(esInicial);
		this.setMostrarValorPorUnidadUnidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setMostrarProductoUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(ConversionInven.class)) {
				this.setMostrarConversionInvenUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(RangoUnidadVenta.class)) {
				this.setMostrarRangoUnidadVentaUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(ValorPorUnidad.class)) {
				this.setMostrarValorPorUnidadUnidad(esAsigna);
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

		this.setActivarProductoUnidad(esInicial);
		this.setActivarConversionInvenUnidad(esInicial);
		this.setActivarRangoUnidadVentaUnidad(esInicial);
		this.setActivarValorPorUnidadUnidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setActivarProductoUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(ConversionInven.class)) {
				this.setActivarConversionInvenUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(RangoUnidadVenta.class)) {
				this.setActivarRangoUnidadVentaUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(ValorPorUnidad.class)) {
				this.setActivarValorPorUnidadUnidad(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoUnidad(esInicial);
		this.setResaltarConversionInvenUnidad(esInicial);
		this.setResaltarRangoUnidadVentaUnidad(esInicial);
		this.setResaltarValorPorUnidadUnidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Producto.class)) {
				this.setResaltarProductoUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(ConversionInven.class)) {
				this.setResaltarConversionInvenUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(RangoUnidadVenta.class)) {
				this.setResaltarRangoUnidadVentaUnidad(esAsigna);
				continue;
			}

			if(clase.clas.equals(ValorPorUnidad.class)) {
				this.setResaltarValorPorUnidadUnidad(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreUnidad=true;

	public Boolean getMostrarBusquedaPorNombreUnidad() {
		return this.mostrarBusquedaPorNombreUnidad;
	}

	public void setMostrarBusquedaPorNombreUnidad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreUnidad= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorSiglasUnidad=true;

	public Boolean getMostrarBusquedaPorSiglasUnidad() {
		return this.mostrarBusquedaPorSiglasUnidad;
	}

	public void setMostrarBusquedaPorSiglasUnidad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorSiglasUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaUnidad=true;

	public Boolean getMostrarFK_IdEmpresaUnidad() {
		return this.mostrarFK_IdEmpresaUnidad;
	}

	public void setMostrarFK_IdEmpresaUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaUnidad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoUnidadUnidad=true;

	public Boolean getMostrarFK_IdTipoUnidadUnidad() {
		return this.mostrarFK_IdTipoUnidadUnidad;
	}

	public void setMostrarFK_IdTipoUnidadUnidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoUnidadUnidad= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreUnidad=true;

	public Boolean getActivarBusquedaPorNombreUnidad() {
		return this.activarBusquedaPorNombreUnidad;
	}

	public void setActivarBusquedaPorNombreUnidad(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreUnidad= habilitarResaltar;
	}

	public Boolean activarBusquedaPorSiglasUnidad=true;

	public Boolean getActivarBusquedaPorSiglasUnidad() {
		return this.activarBusquedaPorSiglasUnidad;
	}

	public void setActivarBusquedaPorSiglasUnidad(Boolean habilitarResaltar) {
		this.activarBusquedaPorSiglasUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaUnidad=true;

	public Boolean getActivarFK_IdEmpresaUnidad() {
		return this.activarFK_IdEmpresaUnidad;
	}

	public void setActivarFK_IdEmpresaUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaUnidad= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoUnidadUnidad=true;

	public Boolean getActivarFK_IdTipoUnidadUnidad() {
		return this.activarFK_IdTipoUnidadUnidad;
	}

	public void setActivarFK_IdTipoUnidadUnidad(Boolean habilitarResaltar) {
		this.activarFK_IdTipoUnidadUnidad= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreUnidad=null;

	public Border getResaltarBusquedaPorNombreUnidad() {
		return this.resaltarBusquedaPorNombreUnidad;
	}

	public void setResaltarBusquedaPorNombreUnidad(Border borderResaltar) {
		this.resaltarBusquedaPorNombreUnidad= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreUnidad= borderResaltar;
	}

	public Border resaltarBusquedaPorSiglasUnidad=null;

	public Border getResaltarBusquedaPorSiglasUnidad() {
		return this.resaltarBusquedaPorSiglasUnidad;
	}

	public void setResaltarBusquedaPorSiglasUnidad(Border borderResaltar) {
		this.resaltarBusquedaPorSiglasUnidad= borderResaltar;
	}

	public void setResaltarBusquedaPorSiglasUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorSiglasUnidad= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaUnidad=null;

	public Border getResaltarFK_IdEmpresaUnidad() {
		return this.resaltarFK_IdEmpresaUnidad;
	}

	public void setResaltarFK_IdEmpresaUnidad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaUnidad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaUnidad= borderResaltar;
	}

	public Border resaltarFK_IdTipoUnidadUnidad=null;

	public Border getResaltarFK_IdTipoUnidadUnidad() {
		return this.resaltarFK_IdTipoUnidadUnidad;
	}

	public void setResaltarFK_IdTipoUnidadUnidad(Border borderResaltar) {
		this.resaltarFK_IdTipoUnidadUnidad= borderResaltar;
	}

	public void setResaltarFK_IdTipoUnidadUnidad(ParametroGeneralUsuario parametroGeneralUsuario/*UnidadBeanSwingJInternalFrame unidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoUnidadUnidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}