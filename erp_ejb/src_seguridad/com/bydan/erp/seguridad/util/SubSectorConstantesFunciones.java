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


import com.bydan.erp.seguridad.util.SubSectorConstantesFunciones;
import com.bydan.erp.seguridad.util.SubSectorParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SubSectorParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SubSectorConstantesFunciones extends SubSectorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="SubSector";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SubSector"+SubSectorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SubSectorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SubSectorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SubSectorConstantesFunciones.SCHEMA+"_"+SubSectorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SubSectorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SubSectorConstantesFunciones.SCHEMA+"_"+SubSectorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SubSectorConstantesFunciones.SCHEMA+"_"+SubSectorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SubSectorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SubSectorConstantesFunciones.SCHEMA+"_"+SubSectorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubSectorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubSectorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubSectorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubSectorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubSectorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubSectorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SubSectorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SubSectorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SubSectorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SubSectorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sectores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sector";
	public static final String SCLASSWEBTITULO_LOWER="Sub Sector";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SubSector";
	public static final String OBJECTNAME="subsector";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="sub_sector";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select subsector from "+SubSectorConstantesFunciones.SPERSISTENCENAME+" subsector";
	public static String QUERYSELECTNATIVE="select "+SubSectorConstantesFunciones.SCHEMA+"."+SubSectorConstantesFunciones.TABLENAME+".id,"+SubSectorConstantesFunciones.SCHEMA+"."+SubSectorConstantesFunciones.TABLENAME+".version_row,"+SubSectorConstantesFunciones.SCHEMA+"."+SubSectorConstantesFunciones.TABLENAME+".id_empresa,"+SubSectorConstantesFunciones.SCHEMA+"."+SubSectorConstantesFunciones.TABLENAME+".id_sector,"+SubSectorConstantesFunciones.SCHEMA+"."+SubSectorConstantesFunciones.TABLENAME+".codigo,"+SubSectorConstantesFunciones.SCHEMA+"."+SubSectorConstantesFunciones.TABLENAME+".nombre,"+SubSectorConstantesFunciones.SCHEMA+"."+SubSectorConstantesFunciones.TABLENAME+".descripcion from "+SubSectorConstantesFunciones.SCHEMA+"."+SubSectorConstantesFunciones.TABLENAME;//+" as "+SubSectorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SubSectorConstantesFuncionesAdditional subsectorConstantesFuncionesAdditional=null;
	
	public SubSectorConstantesFuncionesAdditional getSubSectorConstantesFuncionesAdditional() {
		return this.subsectorConstantesFuncionesAdditional;
	}
	
	public void setSubSectorConstantesFuncionesAdditional(SubSectorConstantesFuncionesAdditional subsectorConstantesFuncionesAdditional) {
		try {
			this.subsectorConstantesFuncionesAdditional=subsectorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSECTOR= "id_sector";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSECTOR= "Sector";
		public static final String LABEL_IDSECTOR_LOWER= "Sector";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSubSectorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SubSectorConstantesFunciones.IDEMPRESA)) {sLabelColumna=SubSectorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SubSectorConstantesFunciones.IDSECTOR)) {sLabelColumna=SubSectorConstantesFunciones.LABEL_IDSECTOR;}
		if(sNombreColumna.equals(SubSectorConstantesFunciones.CODIGO)) {sLabelColumna=SubSectorConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(SubSectorConstantesFunciones.NOMBRE)) {sLabelColumna=SubSectorConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(SubSectorConstantesFunciones.DESCRIPCION)) {sLabelColumna=SubSectorConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getSubSectorDescripcion(SubSector subsector) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(subsector !=null/* && subsector.getId()!=0*/) {
			sDescripcion=subsector.getcodigo()+"-"+subsector.getnombre();//subsectorsubsector.getcodigo().trim()+"-"+subsector.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSubSectorDescripcionDetallado(SubSector subsector) {
		String sDescripcion="";
			
		sDescripcion+=SubSectorConstantesFunciones.ID+"=";
		sDescripcion+=subsector.getId().toString()+",";
		sDescripcion+=SubSectorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=subsector.getVersionRow().toString()+",";
		sDescripcion+=SubSectorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=subsector.getid_empresa().toString()+",";
		sDescripcion+=SubSectorConstantesFunciones.IDSECTOR+"=";
		sDescripcion+=subsector.getid_sector().toString()+",";
		sDescripcion+=SubSectorConstantesFunciones.CODIGO+"=";
		sDescripcion+=subsector.getcodigo()+",";
		sDescripcion+=SubSectorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=subsector.getnombre()+",";
		sDescripcion+=SubSectorConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=subsector.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setSubSectorDescripcion(SubSector subsector,String sValor) throws Exception {			
		if(subsector !=null) {
			subsector.setcodigo(sValor);
subsector.setnombre(sValor);;//subsectorsubsector.getcodigo().trim()+"-"+subsector.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSectorDescripcion(Sector sector) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sector!=null/*&&sector.getId()>0*/) {
			sDescripcion=SectorConstantesFunciones.getSectorDescripcion(sector);
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
		} else if(sNombreIndice.equals("FK_IdSector")) {
			sNombreIndice="Tipo=  Por Sector";
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

	public static String getDetalleIndiceFK_IdSector(Long id_sector) {
		String sDetalleIndice=" Parametros->";
		if(id_sector!=null) {sDetalleIndice+=" Codigo Unico De Sector="+id_sector.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSubSector(SubSector subsector,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		subsector.setcodigo(subsector.getcodigo().trim());
		subsector.setnombre(subsector.getnombre().trim());
		subsector.setdescripcion(subsector.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSubSectors(List<SubSector> subsectors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SubSector subsector: subsectors) {
			subsector.setcodigo(subsector.getcodigo().trim());
			subsector.setnombre(subsector.getnombre().trim());
			subsector.setdescripcion(subsector.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubSector(SubSector subsector,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && subsector.getConCambioAuxiliar()) {
			subsector.setIsDeleted(subsector.getIsDeletedAuxiliar());	
			subsector.setIsNew(subsector.getIsNewAuxiliar());	
			subsector.setIsChanged(subsector.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			subsector.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			subsector.setIsDeletedAuxiliar(false);	
			subsector.setIsNewAuxiliar(false);	
			subsector.setIsChangedAuxiliar(false);
			
			subsector.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubSectors(List<SubSector> subsectors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SubSector subsector : subsectors) {
			if(conAsignarBase && subsector.getConCambioAuxiliar()) {
				subsector.setIsDeleted(subsector.getIsDeletedAuxiliar());	
				subsector.setIsNew(subsector.getIsNewAuxiliar());	
				subsector.setIsChanged(subsector.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				subsector.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				subsector.setIsDeletedAuxiliar(false);	
				subsector.setIsNewAuxiliar(false);	
				subsector.setIsChangedAuxiliar(false);
				
				subsector.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSubSector(SubSector subsector,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSubSectors(List<SubSector> subsectors,Boolean conEnteros) throws Exception  {
		
		for(SubSector subsector: subsectors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSubSector(List<SubSector> subsectors,SubSector subsectorAux) throws Exception  {
		SubSectorConstantesFunciones.InicializarValoresSubSector(subsectorAux,true);
		
		for(SubSector subsector: subsectors) {
			if(subsector.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSubSector(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SubSectorConstantesFunciones.getArrayColumnasGlobalesSubSector(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSubSector(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubSectorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubSectorConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSubSector(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SubSector> subsectors,SubSector subsector,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SubSector subsectorAux: subsectors) {
			if(subsectorAux!=null && subsector!=null) {
				if((subsectorAux.getId()==null && subsector.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(subsectorAux.getId()!=null && subsector.getId()!=null){
					if(subsectorAux.getId().equals(subsector.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSubSector(List<SubSector> subsectors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(SubSector subsector: subsectors) {			
			if(subsector.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSubSector() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SubSectorConstantesFunciones.LABEL_ID, SubSectorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubSectorConstantesFunciones.LABEL_VERSIONROW, SubSectorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubSectorConstantesFunciones.LABEL_IDEMPRESA, SubSectorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubSectorConstantesFunciones.LABEL_IDSECTOR, SubSectorConstantesFunciones.IDSECTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubSectorConstantesFunciones.LABEL_CODIGO, SubSectorConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubSectorConstantesFunciones.LABEL_NOMBRE, SubSectorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubSectorConstantesFunciones.LABEL_DESCRIPCION, SubSectorConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSubSector() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SubSectorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubSectorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubSectorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubSectorConstantesFunciones.IDSECTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubSectorConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubSectorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubSectorConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubSector() throws Exception  {
		return SubSectorConstantesFunciones.getTiposSeleccionarSubSector(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubSector(Boolean conFk) throws Exception  {
		return SubSectorConstantesFunciones.getTiposSeleccionarSubSector(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubSector(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubSectorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SubSectorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubSectorConstantesFunciones.LABEL_IDSECTOR);
			reporte.setsDescripcion(SubSectorConstantesFunciones.LABEL_IDSECTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubSectorConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SubSectorConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubSectorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SubSectorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubSectorConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(SubSectorConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSubSector(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSubSector(SubSector subsectorAux) throws Exception {
		
			subsectorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subsectorAux.getEmpresa()));
			subsectorAux.setsector_descripcion(SectorConstantesFunciones.getSectorDescripcion(subsectorAux.getSector()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSubSector(List<SubSector> subsectorsTemp) throws Exception {
		for(SubSector subsectorAux:subsectorsTemp) {
			
			subsectorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subsectorAux.getEmpresa()));
			subsectorAux.setsector_descripcion(SectorConstantesFunciones.getSectorDescripcion(subsectorAux.getSector()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSubSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sector.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sector.class)) {
						classes.add(new Classe(Sector.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSubSector(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sector.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sector.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sector.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sector.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubSectorConstantesFunciones.getClassesRelationshipsOfSubSector(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubSector(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubSectorConstantesFunciones.getClassesRelationshipsFromStringsOfSubSector(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubSector(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(SubSector subsector,List<SubSector> subsectors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SubSector subsectorEncontrado=null;
			
			for(SubSector subsectorLocal:subsectors) {
				if(subsectorLocal.getId().equals(subsector.getId())) {
					subsectorEncontrado=subsectorLocal;
					
					subsectorLocal.setIsChanged(subsector.getIsChanged());
					subsectorLocal.setIsNew(subsector.getIsNew());
					subsectorLocal.setIsDeleted(subsector.getIsDeleted());
					
					subsectorLocal.setGeneralEntityOriginal(subsector.getGeneralEntityOriginal());
					
					subsectorLocal.setId(subsector.getId());	
					subsectorLocal.setVersionRow(subsector.getVersionRow());	
					subsectorLocal.setid_empresa(subsector.getid_empresa());	
					subsectorLocal.setid_sector(subsector.getid_sector());	
					subsectorLocal.setcodigo(subsector.getcodigo());	
					subsectorLocal.setnombre(subsector.getnombre());	
					subsectorLocal.setdescripcion(subsector.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!subsector.getIsDeleted()) {
				if(!existe) {
					subsectors.add(subsector);
				}
			} else {
				if(subsectorEncontrado!=null && permiteQuitar)  {
					subsectors.remove(subsectorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SubSector subsector,List<SubSector> subsectors) throws Exception {
		try	{			
			for(SubSector subsectorLocal:subsectors) {
				if(subsectorLocal.getId().equals(subsector.getId())) {
					subsectorLocal.setIsSelected(subsector.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSubSector(List<SubSector> subsectorsAux) throws Exception {
		//this.subsectorsAux=subsectorsAux;
		
		for(SubSector subsectorAux:subsectorsAux) {
			if(subsectorAux.getIsChanged()) {
				subsectorAux.setIsChanged(false);
			}		
			
			if(subsectorAux.getIsNew()) {
				subsectorAux.setIsNew(false);
			}	
			
			if(subsectorAux.getIsDeleted()) {
				subsectorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSubSector(SubSector subsectorAux) throws Exception {
		//this.subsectorAux=subsectorAux;
		
			if(subsectorAux.getIsChanged()) {
				subsectorAux.setIsChanged(false);
			}		
			
			if(subsectorAux.getIsNew()) {
				subsectorAux.setIsNew(false);
			}	
			
			if(subsectorAux.getIsDeleted()) {
				subsectorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SubSector subsectorAsignar,SubSector subsector) throws Exception {
		subsectorAsignar.setId(subsector.getId());	
		subsectorAsignar.setVersionRow(subsector.getVersionRow());	
		subsectorAsignar.setid_sector(subsector.getid_sector());
		subsectorAsignar.setsector_descripcion(subsector.getsector_descripcion());	
		subsectorAsignar.setcodigo(subsector.getcodigo());	
		subsectorAsignar.setnombre(subsector.getnombre());	
		subsectorAsignar.setdescripcion(subsector.getdescripcion());	
	}
	
	public static void inicializarSubSector(SubSector subsector) throws Exception {
		try {
				subsector.setId(0L);	
					
				subsector.setid_sector(-1L);	
				subsector.setcodigo("");	
				subsector.setnombre("");	
				subsector.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSubSector(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SubSectorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubSectorConstantesFunciones.LABEL_IDSECTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubSectorConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubSectorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubSectorConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSubSector(String sTipo,Row row,Workbook workbook,SubSector subsector,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(subsector.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subsector.getsector_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subsector.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subsector.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subsector.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySubSector=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySubSector() {
		return this.sFinalQuerySubSector;
	}
	
	public void setsFinalQuerySubSector(String sFinalQuerySubSector) {
		this.sFinalQuerySubSector= sFinalQuerySubSector;
	}
	
	public Border resaltarSeleccionarSubSector=null;
	
	public Border setResaltarSeleccionarSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//subsectorBeanSwingJInternalFrame.jTtoolBarSubSector.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSubSector= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSubSector() {
		return this.resaltarSeleccionarSubSector;
	}
	
	public void setResaltarSeleccionarSubSector(Border borderResaltarSeleccionarSubSector) {
		this.resaltarSeleccionarSubSector= borderResaltarSeleccionarSubSector;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSubSector=null;
	public Boolean mostraridSubSector=true;
	public Boolean activaridSubSector=true;

	public Border resaltarid_empresaSubSector=null;
	public Boolean mostrarid_empresaSubSector=true;
	public Boolean activarid_empresaSubSector=true;
	public Boolean cargarid_empresaSubSector=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSubSector=false;//ConEventDepend=true

	public Border resaltarid_sectorSubSector=null;
	public Boolean mostrarid_sectorSubSector=true;
	public Boolean activarid_sectorSubSector=true;
	public Boolean cargarid_sectorSubSector=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sectorSubSector=false;//ConEventDepend=true

	public Border resaltarcodigoSubSector=null;
	public Boolean mostrarcodigoSubSector=true;
	public Boolean activarcodigoSubSector=true;

	public Border resaltarnombreSubSector=null;
	public Boolean mostrarnombreSubSector=true;
	public Boolean activarnombreSubSector=true;

	public Border resaltardescripcionSubSector=null;
	public Boolean mostrardescripcionSubSector=true;
	public Boolean activardescripcionSubSector=true;

	
	

	public Border setResaltaridSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subsectorBeanSwingJInternalFrame.jTtoolBarSubSector.setBorder(borderResaltar);
		
		this.resaltaridSubSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSubSector() {
		return this.resaltaridSubSector;
	}

	public void setResaltaridSubSector(Border borderResaltar) {
		this.resaltaridSubSector= borderResaltar;
	}

	public Boolean getMostraridSubSector() {
		return this.mostraridSubSector;
	}

	public void setMostraridSubSector(Boolean mostraridSubSector) {
		this.mostraridSubSector= mostraridSubSector;
	}

	public Boolean getActivaridSubSector() {
		return this.activaridSubSector;
	}

	public void setActivaridSubSector(Boolean activaridSubSector) {
		this.activaridSubSector= activaridSubSector;
	}

	public Border setResaltarid_empresaSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subsectorBeanSwingJInternalFrame.jTtoolBarSubSector.setBorder(borderResaltar);
		
		this.resaltarid_empresaSubSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSubSector() {
		return this.resaltarid_empresaSubSector;
	}

	public void setResaltarid_empresaSubSector(Border borderResaltar) {
		this.resaltarid_empresaSubSector= borderResaltar;
	}

	public Boolean getMostrarid_empresaSubSector() {
		return this.mostrarid_empresaSubSector;
	}

	public void setMostrarid_empresaSubSector(Boolean mostrarid_empresaSubSector) {
		this.mostrarid_empresaSubSector= mostrarid_empresaSubSector;
	}

	public Boolean getActivarid_empresaSubSector() {
		return this.activarid_empresaSubSector;
	}

	public void setActivarid_empresaSubSector(Boolean activarid_empresaSubSector) {
		this.activarid_empresaSubSector= activarid_empresaSubSector;
	}

	public Boolean getCargarid_empresaSubSector() {
		return this.cargarid_empresaSubSector;
	}

	public void setCargarid_empresaSubSector(Boolean cargarid_empresaSubSector) {
		this.cargarid_empresaSubSector= cargarid_empresaSubSector;
	}

	public Border setResaltarid_sectorSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subsectorBeanSwingJInternalFrame.jTtoolBarSubSector.setBorder(borderResaltar);
		
		this.resaltarid_sectorSubSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sectorSubSector() {
		return this.resaltarid_sectorSubSector;
	}

	public void setResaltarid_sectorSubSector(Border borderResaltar) {
		this.resaltarid_sectorSubSector= borderResaltar;
	}

	public Boolean getMostrarid_sectorSubSector() {
		return this.mostrarid_sectorSubSector;
	}

	public void setMostrarid_sectorSubSector(Boolean mostrarid_sectorSubSector) {
		this.mostrarid_sectorSubSector= mostrarid_sectorSubSector;
	}

	public Boolean getActivarid_sectorSubSector() {
		return this.activarid_sectorSubSector;
	}

	public void setActivarid_sectorSubSector(Boolean activarid_sectorSubSector) {
		this.activarid_sectorSubSector= activarid_sectorSubSector;
	}

	public Boolean getCargarid_sectorSubSector() {
		return this.cargarid_sectorSubSector;
	}

	public void setCargarid_sectorSubSector(Boolean cargarid_sectorSubSector) {
		this.cargarid_sectorSubSector= cargarid_sectorSubSector;
	}

	public Border setResaltarcodigoSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subsectorBeanSwingJInternalFrame.jTtoolBarSubSector.setBorder(borderResaltar);
		
		this.resaltarcodigoSubSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSubSector() {
		return this.resaltarcodigoSubSector;
	}

	public void setResaltarcodigoSubSector(Border borderResaltar) {
		this.resaltarcodigoSubSector= borderResaltar;
	}

	public Boolean getMostrarcodigoSubSector() {
		return this.mostrarcodigoSubSector;
	}

	public void setMostrarcodigoSubSector(Boolean mostrarcodigoSubSector) {
		this.mostrarcodigoSubSector= mostrarcodigoSubSector;
	}

	public Boolean getActivarcodigoSubSector() {
		return this.activarcodigoSubSector;
	}

	public void setActivarcodigoSubSector(Boolean activarcodigoSubSector) {
		this.activarcodigoSubSector= activarcodigoSubSector;
	}

	public Border setResaltarnombreSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subsectorBeanSwingJInternalFrame.jTtoolBarSubSector.setBorder(borderResaltar);
		
		this.resaltarnombreSubSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSubSector() {
		return this.resaltarnombreSubSector;
	}

	public void setResaltarnombreSubSector(Border borderResaltar) {
		this.resaltarnombreSubSector= borderResaltar;
	}

	public Boolean getMostrarnombreSubSector() {
		return this.mostrarnombreSubSector;
	}

	public void setMostrarnombreSubSector(Boolean mostrarnombreSubSector) {
		this.mostrarnombreSubSector= mostrarnombreSubSector;
	}

	public Boolean getActivarnombreSubSector() {
		return this.activarnombreSubSector;
	}

	public void setActivarnombreSubSector(Boolean activarnombreSubSector) {
		this.activarnombreSubSector= activarnombreSubSector;
	}

	public Border setResaltardescripcionSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subsectorBeanSwingJInternalFrame.jTtoolBarSubSector.setBorder(borderResaltar);
		
		this.resaltardescripcionSubSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionSubSector() {
		return this.resaltardescripcionSubSector;
	}

	public void setResaltardescripcionSubSector(Border borderResaltar) {
		this.resaltardescripcionSubSector= borderResaltar;
	}

	public Boolean getMostrardescripcionSubSector() {
		return this.mostrardescripcionSubSector;
	}

	public void setMostrardescripcionSubSector(Boolean mostrardescripcionSubSector) {
		this.mostrardescripcionSubSector= mostrardescripcionSubSector;
	}

	public Boolean getActivardescripcionSubSector() {
		return this.activardescripcionSubSector;
	}

	public void setActivardescripcionSubSector(Boolean activardescripcionSubSector) {
		this.activardescripcionSubSector= activardescripcionSubSector;
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
		
		
		this.setMostraridSubSector(esInicial);
		this.setMostrarid_empresaSubSector(esInicial);
		this.setMostrarid_sectorSubSector(esInicial);
		this.setMostrarcodigoSubSector(esInicial);
		this.setMostrarnombreSubSector(esInicial);
		this.setMostrardescripcionSubSector(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubSectorConstantesFunciones.ID)) {
				this.setMostraridSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.IDSECTOR)) {
				this.setMostrarid_sectorSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionSubSector(esAsigna);
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
		
		
		this.setActivaridSubSector(esInicial);
		this.setActivarid_empresaSubSector(esInicial);
		this.setActivarid_sectorSubSector(esInicial);
		this.setActivarcodigoSubSector(esInicial);
		this.setActivarnombreSubSector(esInicial);
		this.setActivardescripcionSubSector(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubSectorConstantesFunciones.ID)) {
				this.setActivaridSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.IDSECTOR)) {
				this.setActivarid_sectorSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionSubSector(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSubSector(esInicial);
		this.setResaltarid_empresaSubSector(esInicial);
		this.setResaltarid_sectorSubSector(esInicial);
		this.setResaltarcodigoSubSector(esInicial);
		this.setResaltarnombreSubSector(esInicial);
		this.setResaltardescripcionSubSector(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubSectorConstantesFunciones.ID)) {
				this.setResaltaridSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.IDSECTOR)) {
				this.setResaltarid_sectorSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSubSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubSectorConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionSubSector(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaSubSector=true;

	public Boolean getMostrarFK_IdEmpresaSubSector() {
		return this.mostrarFK_IdEmpresaSubSector;
	}

	public void setMostrarFK_IdEmpresaSubSector(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSubSector= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSectorSubSector=true;

	public Boolean getMostrarFK_IdSectorSubSector() {
		return this.mostrarFK_IdSectorSubSector;
	}

	public void setMostrarFK_IdSectorSubSector(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSectorSubSector= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaSubSector=true;

	public Boolean getActivarFK_IdEmpresaSubSector() {
		return this.activarFK_IdEmpresaSubSector;
	}

	public void setActivarFK_IdEmpresaSubSector(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSubSector= habilitarResaltar;
	}

	public Boolean activarFK_IdSectorSubSector=true;

	public Boolean getActivarFK_IdSectorSubSector() {
		return this.activarFK_IdSectorSubSector;
	}

	public void setActivarFK_IdSectorSubSector(Boolean habilitarResaltar) {
		this.activarFK_IdSectorSubSector= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaSubSector=null;

	public Border getResaltarFK_IdEmpresaSubSector() {
		return this.resaltarFK_IdEmpresaSubSector;
	}

	public void setResaltarFK_IdEmpresaSubSector(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSubSector= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSubSector= borderResaltar;
	}

	public Border resaltarFK_IdSectorSubSector=null;

	public Border getResaltarFK_IdSectorSubSector() {
		return this.resaltarFK_IdSectorSubSector;
	}

	public void setResaltarFK_IdSectorSubSector(Border borderResaltar) {
		this.resaltarFK_IdSectorSubSector= borderResaltar;
	}

	public void setResaltarFK_IdSectorSubSector(ParametroGeneralUsuario parametroGeneralUsuario/*SubSectorBeanSwingJInternalFrame subsectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSectorSubSector= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}