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


import com.bydan.erp.seguridad.util.SectorConstantesFunciones;
import com.bydan.erp.seguridad.util.SectorParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SectorParameterGeneral;

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
final public class SectorConstantesFunciones extends SectorConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Sector";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Sector"+SectorConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SectorHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SectorHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SectorConstantesFunciones.SCHEMA+"_"+SectorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SectorHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SectorConstantesFunciones.SCHEMA+"_"+SectorConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SectorConstantesFunciones.SCHEMA+"_"+SectorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SectorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SectorConstantesFunciones.SCHEMA+"_"+SectorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SectorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SectorHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SectorConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SectorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SectorHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SectorConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SectorConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SectorConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SectorConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SectorConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sectores";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sector";
	public static final String SCLASSWEBTITULO_LOWER="Sector";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Sector";
	public static final String OBJECTNAME="sector";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="sector";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sector from "+SectorConstantesFunciones.SPERSISTENCENAME+" sector";
	public static String QUERYSELECTNATIVE="select "+SectorConstantesFunciones.SCHEMA+"."+SectorConstantesFunciones.TABLENAME+".id,"+SectorConstantesFunciones.SCHEMA+"."+SectorConstantesFunciones.TABLENAME+".version_row,"+SectorConstantesFunciones.SCHEMA+"."+SectorConstantesFunciones.TABLENAME+".id_empresa,"+SectorConstantesFunciones.SCHEMA+"."+SectorConstantesFunciones.TABLENAME+".id_ciudad,"+SectorConstantesFunciones.SCHEMA+"."+SectorConstantesFunciones.TABLENAME+".nombre,"+SectorConstantesFunciones.SCHEMA+"."+SectorConstantesFunciones.TABLENAME+".descripcion from "+SectorConstantesFunciones.SCHEMA+"."+SectorConstantesFunciones.TABLENAME;//+" as "+SectorConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SectorConstantesFuncionesAdditional sectorConstantesFuncionesAdditional=null;
	
	public SectorConstantesFuncionesAdditional getSectorConstantesFuncionesAdditional() {
		return this.sectorConstantesFuncionesAdditional;
	}
	
	public void setSectorConstantesFuncionesAdditional(SectorConstantesFuncionesAdditional sectorConstantesFuncionesAdditional) {
		try {
			this.sectorConstantesFuncionesAdditional=sectorConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSectorLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SectorConstantesFunciones.IDEMPRESA)) {sLabelColumna=SectorConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SectorConstantesFunciones.IDCIUDAD)) {sLabelColumna=SectorConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(SectorConstantesFunciones.NOMBRE)) {sLabelColumna=SectorConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(SectorConstantesFunciones.DESCRIPCION)) {sLabelColumna=SectorConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getSectorDescripcion(Sector sector) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sector !=null/* && sector.getId()!=0*/) {
			sDescripcion=sector.getnombre();//sectorsector.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSectorDescripcionDetallado(Sector sector) {
		String sDescripcion="";
			
		sDescripcion+=SectorConstantesFunciones.ID+"=";
		sDescripcion+=sector.getId().toString()+",";
		sDescripcion+=SectorConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sector.getVersionRow().toString()+",";
		sDescripcion+=SectorConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=sector.getid_empresa().toString()+",";
		sDescripcion+=SectorConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=sector.getid_ciudad().toString()+",";
		sDescripcion+=SectorConstantesFunciones.NOMBRE+"=";
		sDescripcion+=sector.getnombre()+",";
		sDescripcion+=SectorConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=sector.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setSectorDescripcion(Sector sector,String sValor) throws Exception {			
		if(sector !=null) {
			sector.setnombre(sValor);;//sectorsector.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSector(Sector sector,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sector.setnombre(sector.getnombre().trim());
		sector.setdescripcion(sector.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSectors(List<Sector> sectors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Sector sector: sectors) {
			sector.setnombre(sector.getnombre().trim());
			sector.setdescripcion(sector.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSector(Sector sector,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sector.getConCambioAuxiliar()) {
			sector.setIsDeleted(sector.getIsDeletedAuxiliar());	
			sector.setIsNew(sector.getIsNewAuxiliar());	
			sector.setIsChanged(sector.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sector.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sector.setIsDeletedAuxiliar(false);	
			sector.setIsNewAuxiliar(false);	
			sector.setIsChangedAuxiliar(false);
			
			sector.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSectors(List<Sector> sectors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Sector sector : sectors) {
			if(conAsignarBase && sector.getConCambioAuxiliar()) {
				sector.setIsDeleted(sector.getIsDeletedAuxiliar());	
				sector.setIsNew(sector.getIsNewAuxiliar());	
				sector.setIsChanged(sector.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sector.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sector.setIsDeletedAuxiliar(false);	
				sector.setIsNewAuxiliar(false);	
				sector.setIsChangedAuxiliar(false);
				
				sector.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSector(Sector sector,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSectors(List<Sector> sectors,Boolean conEnteros) throws Exception  {
		
		for(Sector sector: sectors) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSector(List<Sector> sectors,Sector sectorAux) throws Exception  {
		SectorConstantesFunciones.InicializarValoresSector(sectorAux,true);
		
		for(Sector sector: sectors) {
			if(sector.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSector(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SectorConstantesFunciones.getArrayColumnasGlobalesSector(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSector(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SectorConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SectorConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSector(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Sector> sectors,Sector sector,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Sector sectorAux: sectors) {
			if(sectorAux!=null && sector!=null) {
				if((sectorAux.getId()==null && sector.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(sectorAux.getId()!=null && sector.getId()!=null){
					if(sectorAux.getId().equals(sector.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSector(List<Sector> sectors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Sector sector: sectors) {			
			if(sector.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSector() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SectorConstantesFunciones.LABEL_ID, SectorConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SectorConstantesFunciones.LABEL_VERSIONROW, SectorConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SectorConstantesFunciones.LABEL_IDEMPRESA, SectorConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SectorConstantesFunciones.LABEL_IDCIUDAD, SectorConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SectorConstantesFunciones.LABEL_NOMBRE, SectorConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SectorConstantesFunciones.LABEL_DESCRIPCION, SectorConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSector() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SectorConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SectorConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SectorConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SectorConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SectorConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SectorConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSector() throws Exception  {
		return SectorConstantesFunciones.getTiposSeleccionarSector(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSector(Boolean conFk) throws Exception  {
		return SectorConstantesFunciones.getTiposSeleccionarSector(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSector(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SectorConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SectorConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SectorConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(SectorConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SectorConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SectorConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SectorConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(SectorConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSector(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSector(Sector sectorAux) throws Exception {
		
			sectorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(sectorAux.getEmpresa()));
			sectorAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(sectorAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSector(List<Sector> sectorsTemp) throws Exception {
		for(Sector sectorAux:sectorsTemp) {
			
			sectorAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(sectorAux.getEmpresa()));
			sectorAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(sectorAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSector(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SectorConstantesFunciones.getClassesRelationshipsOfSector(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSector(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Ruta.class));
				classes.add(new Classe(SubSector.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Ruta.class)) {
						classes.add(new Classe(Ruta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubSector.class)) {
						classes.add(new Classe(SubSector.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSector(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SectorConstantesFunciones.getClassesRelationshipsFromStringsOfSector(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSector(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Ruta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ruta.class)); continue;
					}

					if(SubSector.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubSector.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Ruta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ruta.class)); continue;
					}

					if(SubSector.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubSector.class)); continue;
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
	public static void actualizarLista(Sector sector,List<Sector> sectors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Sector sectorEncontrado=null;
			
			for(Sector sectorLocal:sectors) {
				if(sectorLocal.getId().equals(sector.getId())) {
					sectorEncontrado=sectorLocal;
					
					sectorLocal.setIsChanged(sector.getIsChanged());
					sectorLocal.setIsNew(sector.getIsNew());
					sectorLocal.setIsDeleted(sector.getIsDeleted());
					
					sectorLocal.setGeneralEntityOriginal(sector.getGeneralEntityOriginal());
					
					sectorLocal.setId(sector.getId());	
					sectorLocal.setVersionRow(sector.getVersionRow());	
					sectorLocal.setid_empresa(sector.getid_empresa());	
					sectorLocal.setid_ciudad(sector.getid_ciudad());	
					sectorLocal.setnombre(sector.getnombre());	
					sectorLocal.setdescripcion(sector.getdescripcion());	
					
					
					sectorLocal.setRutaOrigens(sector.getRutaOrigens());
					sectorLocal.setSubSectors(sector.getSubSectors());
					
					existe=true;
					break;
				}
			}
			
			if(!sector.getIsDeleted()) {
				if(!existe) {
					sectors.add(sector);
				}
			} else {
				if(sectorEncontrado!=null && permiteQuitar)  {
					sectors.remove(sectorEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Sector sector,List<Sector> sectors) throws Exception {
		try	{			
			for(Sector sectorLocal:sectors) {
				if(sectorLocal.getId().equals(sector.getId())) {
					sectorLocal.setIsSelected(sector.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSector(List<Sector> sectorsAux) throws Exception {
		//this.sectorsAux=sectorsAux;
		
		for(Sector sectorAux:sectorsAux) {
			if(sectorAux.getIsChanged()) {
				sectorAux.setIsChanged(false);
			}		
			
			if(sectorAux.getIsNew()) {
				sectorAux.setIsNew(false);
			}	
			
			if(sectorAux.getIsDeleted()) {
				sectorAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSector(Sector sectorAux) throws Exception {
		//this.sectorAux=sectorAux;
		
			if(sectorAux.getIsChanged()) {
				sectorAux.setIsChanged(false);
			}		
			
			if(sectorAux.getIsNew()) {
				sectorAux.setIsNew(false);
			}	
			
			if(sectorAux.getIsDeleted()) {
				sectorAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Sector sectorAsignar,Sector sector) throws Exception {
		sectorAsignar.setId(sector.getId());	
		sectorAsignar.setVersionRow(sector.getVersionRow());	
		sectorAsignar.setid_ciudad(sector.getid_ciudad());
		sectorAsignar.setciudad_descripcion(sector.getciudad_descripcion());	
		sectorAsignar.setnombre(sector.getnombre());	
		sectorAsignar.setdescripcion(sector.getdescripcion());	
	}
	
	public static void inicializarSector(Sector sector) throws Exception {
		try {
				sector.setId(0L);	
					
				sector.setid_ciudad(-1L);	
				sector.setnombre("");	
				sector.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSector(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SectorConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SectorConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SectorConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SectorConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSector(String sTipo,Row row,Workbook workbook,Sector sector,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sector.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sector.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sector.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sector.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySector=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySector() {
		return this.sFinalQuerySector;
	}
	
	public void setsFinalQuerySector(String sFinalQuerySector) {
		this.sFinalQuerySector= sFinalQuerySector;
	}
	
	public Border resaltarSeleccionarSector=null;
	
	public Border setResaltarSeleccionarSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//sectorBeanSwingJInternalFrame.jTtoolBarSector.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSector= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSector() {
		return this.resaltarSeleccionarSector;
	}
	
	public void setResaltarSeleccionarSector(Border borderResaltarSeleccionarSector) {
		this.resaltarSeleccionarSector= borderResaltarSeleccionarSector;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSector=null;
	public Boolean mostraridSector=true;
	public Boolean activaridSector=true;

	public Border resaltarid_empresaSector=null;
	public Boolean mostrarid_empresaSector=true;
	public Boolean activarid_empresaSector=true;
	public Boolean cargarid_empresaSector=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSector=false;//ConEventDepend=true

	public Border resaltarid_ciudadSector=null;
	public Boolean mostrarid_ciudadSector=true;
	public Boolean activarid_ciudadSector=true;
	public Boolean cargarid_ciudadSector=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadSector=false;//ConEventDepend=true

	public Border resaltarnombreSector=null;
	public Boolean mostrarnombreSector=true;
	public Boolean activarnombreSector=true;

	public Border resaltardescripcionSector=null;
	public Boolean mostrardescripcionSector=true;
	public Boolean activardescripcionSector=true;

	
	

	public Border setResaltaridSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sectorBeanSwingJInternalFrame.jTtoolBarSector.setBorder(borderResaltar);
		
		this.resaltaridSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSector() {
		return this.resaltaridSector;
	}

	public void setResaltaridSector(Border borderResaltar) {
		this.resaltaridSector= borderResaltar;
	}

	public Boolean getMostraridSector() {
		return this.mostraridSector;
	}

	public void setMostraridSector(Boolean mostraridSector) {
		this.mostraridSector= mostraridSector;
	}

	public Boolean getActivaridSector() {
		return this.activaridSector;
	}

	public void setActivaridSector(Boolean activaridSector) {
		this.activaridSector= activaridSector;
	}

	public Border setResaltarid_empresaSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sectorBeanSwingJInternalFrame.jTtoolBarSector.setBorder(borderResaltar);
		
		this.resaltarid_empresaSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSector() {
		return this.resaltarid_empresaSector;
	}

	public void setResaltarid_empresaSector(Border borderResaltar) {
		this.resaltarid_empresaSector= borderResaltar;
	}

	public Boolean getMostrarid_empresaSector() {
		return this.mostrarid_empresaSector;
	}

	public void setMostrarid_empresaSector(Boolean mostrarid_empresaSector) {
		this.mostrarid_empresaSector= mostrarid_empresaSector;
	}

	public Boolean getActivarid_empresaSector() {
		return this.activarid_empresaSector;
	}

	public void setActivarid_empresaSector(Boolean activarid_empresaSector) {
		this.activarid_empresaSector= activarid_empresaSector;
	}

	public Boolean getCargarid_empresaSector() {
		return this.cargarid_empresaSector;
	}

	public void setCargarid_empresaSector(Boolean cargarid_empresaSector) {
		this.cargarid_empresaSector= cargarid_empresaSector;
	}

	public Border setResaltarid_ciudadSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sectorBeanSwingJInternalFrame.jTtoolBarSector.setBorder(borderResaltar);
		
		this.resaltarid_ciudadSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadSector() {
		return this.resaltarid_ciudadSector;
	}

	public void setResaltarid_ciudadSector(Border borderResaltar) {
		this.resaltarid_ciudadSector= borderResaltar;
	}

	public Boolean getMostrarid_ciudadSector() {
		return this.mostrarid_ciudadSector;
	}

	public void setMostrarid_ciudadSector(Boolean mostrarid_ciudadSector) {
		this.mostrarid_ciudadSector= mostrarid_ciudadSector;
	}

	public Boolean getActivarid_ciudadSector() {
		return this.activarid_ciudadSector;
	}

	public void setActivarid_ciudadSector(Boolean activarid_ciudadSector) {
		this.activarid_ciudadSector= activarid_ciudadSector;
	}

	public Boolean getCargarid_ciudadSector() {
		return this.cargarid_ciudadSector;
	}

	public void setCargarid_ciudadSector(Boolean cargarid_ciudadSector) {
		this.cargarid_ciudadSector= cargarid_ciudadSector;
	}

	public Border setResaltarnombreSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sectorBeanSwingJInternalFrame.jTtoolBarSector.setBorder(borderResaltar);
		
		this.resaltarnombreSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSector() {
		return this.resaltarnombreSector;
	}

	public void setResaltarnombreSector(Border borderResaltar) {
		this.resaltarnombreSector= borderResaltar;
	}

	public Boolean getMostrarnombreSector() {
		return this.mostrarnombreSector;
	}

	public void setMostrarnombreSector(Boolean mostrarnombreSector) {
		this.mostrarnombreSector= mostrarnombreSector;
	}

	public Boolean getActivarnombreSector() {
		return this.activarnombreSector;
	}

	public void setActivarnombreSector(Boolean activarnombreSector) {
		this.activarnombreSector= activarnombreSector;
	}

	public Border setResaltardescripcionSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sectorBeanSwingJInternalFrame.jTtoolBarSector.setBorder(borderResaltar);
		
		this.resaltardescripcionSector= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionSector() {
		return this.resaltardescripcionSector;
	}

	public void setResaltardescripcionSector(Border borderResaltar) {
		this.resaltardescripcionSector= borderResaltar;
	}

	public Boolean getMostrardescripcionSector() {
		return this.mostrardescripcionSector;
	}

	public void setMostrardescripcionSector(Boolean mostrardescripcionSector) {
		this.mostrardescripcionSector= mostrardescripcionSector;
	}

	public Boolean getActivardescripcionSector() {
		return this.activardescripcionSector;
	}

	public void setActivardescripcionSector(Boolean activardescripcionSector) {
		this.activardescripcionSector= activardescripcionSector;
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
		
		
		this.setMostraridSector(esInicial);
		this.setMostrarid_empresaSector(esInicial);
		this.setMostrarid_ciudadSector(esInicial);
		this.setMostrarnombreSector(esInicial);
		this.setMostrardescripcionSector(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SectorConstantesFunciones.ID)) {
				this.setMostraridSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionSector(esAsigna);
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
		
		
		this.setActivaridSector(esInicial);
		this.setActivarid_empresaSector(esInicial);
		this.setActivarid_ciudadSector(esInicial);
		this.setActivarnombreSector(esInicial);
		this.setActivardescripcionSector(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SectorConstantesFunciones.ID)) {
				this.setActivaridSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionSector(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSector(esInicial);
		this.setResaltarid_empresaSector(esInicial);
		this.setResaltarid_ciudadSector(esInicial);
		this.setResaltarnombreSector(esInicial);
		this.setResaltardescripcionSector(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SectorConstantesFunciones.ID)) {
				this.setResaltaridSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSector(esAsigna);
				continue;
			}

			if(campo.clase.equals(SectorConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionSector(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarRutaSector=null;

	public Border getResaltarRutaSector() {
		return this.resaltarRutaSector;
	}

	public void setResaltarRutaSector(Border borderResaltarRuta) {
		if(borderResaltarRuta!=null) {
			this.resaltarRutaSector= borderResaltarRuta;
		}
	}

	public Border setResaltarRutaSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltarRuta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//sectorBeanSwingJInternalFrame.jTtoolBarSector.setBorder(borderResaltarRuta);
			
		this.resaltarRutaSector= borderResaltarRuta;

		 return borderResaltarRuta;
	}



	public Boolean mostrarRutaSector=true;

	public Boolean getMostrarRutaSector() {
		return this.mostrarRutaSector;
	}

	public void setMostrarRutaSector(Boolean visibilidadResaltarRuta) {
		this.mostrarRutaSector= visibilidadResaltarRuta;
	}



	public Boolean activarRutaSector=true;

	public Boolean gethabilitarResaltarRutaSector() {
		return this.activarRutaSector;
	}

	public void setActivarRutaSector(Boolean habilitarResaltarRuta) {
		this.activarRutaSector= habilitarResaltarRuta;
	}


	public Border resaltarSubSectorSector=null;

	public Border getResaltarSubSectorSector() {
		return this.resaltarSubSectorSector;
	}

	public void setResaltarSubSectorSector(Border borderResaltarSubSector) {
		if(borderResaltarSubSector!=null) {
			this.resaltarSubSectorSector= borderResaltarSubSector;
		}
	}

	public Border setResaltarSubSectorSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltarSubSector=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//sectorBeanSwingJInternalFrame.jTtoolBarSector.setBorder(borderResaltarSubSector);
			
		this.resaltarSubSectorSector= borderResaltarSubSector;

		 return borderResaltarSubSector;
	}



	public Boolean mostrarSubSectorSector=true;

	public Boolean getMostrarSubSectorSector() {
		return this.mostrarSubSectorSector;
	}

	public void setMostrarSubSectorSector(Boolean visibilidadResaltarSubSector) {
		this.mostrarSubSectorSector= visibilidadResaltarSubSector;
	}



	public Boolean activarSubSectorSector=true;

	public Boolean gethabilitarResaltarSubSectorSector() {
		return this.activarSubSectorSector;
	}

	public void setActivarSubSectorSector(Boolean habilitarResaltarSubSector) {
		this.activarSubSectorSector= habilitarResaltarSubSector;
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

		this.setMostrarRutaSector(esInicial);
		this.setMostrarSubSectorSector(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Ruta.class)) {
				this.setMostrarRutaSector(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubSector.class)) {
				this.setMostrarSubSectorSector(esAsigna);
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

		this.setActivarRutaSector(esInicial);
		this.setActivarSubSectorSector(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Ruta.class)) {
				this.setActivarRutaSector(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubSector.class)) {
				this.setActivarSubSectorSector(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarRutaSector(esInicial);
		this.setResaltarSubSectorSector(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Ruta.class)) {
				this.setResaltarRutaSector(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubSector.class)) {
				this.setResaltarSubSectorSector(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCiudadSector=true;

	public Boolean getMostrarFK_IdCiudadSector() {
		return this.mostrarFK_IdCiudadSector;
	}

	public void setMostrarFK_IdCiudadSector(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCiudadSector= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSector=true;

	public Boolean getMostrarFK_IdEmpresaSector() {
		return this.mostrarFK_IdEmpresaSector;
	}

	public void setMostrarFK_IdEmpresaSector(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSector= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCiudadSector=true;

	public Boolean getActivarFK_IdCiudadSector() {
		return this.activarFK_IdCiudadSector;
	}

	public void setActivarFK_IdCiudadSector(Boolean habilitarResaltar) {
		this.activarFK_IdCiudadSector= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSector=true;

	public Boolean getActivarFK_IdEmpresaSector() {
		return this.activarFK_IdEmpresaSector;
	}

	public void setActivarFK_IdEmpresaSector(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSector= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCiudadSector=null;

	public Border getResaltarFK_IdCiudadSector() {
		return this.resaltarFK_IdCiudadSector;
	}

	public void setResaltarFK_IdCiudadSector(Border borderResaltar) {
		this.resaltarFK_IdCiudadSector= borderResaltar;
	}

	public void setResaltarFK_IdCiudadSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCiudadSector= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSector=null;

	public Border getResaltarFK_IdEmpresaSector() {
		return this.resaltarFK_IdEmpresaSector;
	}

	public void setResaltarFK_IdEmpresaSector(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSector= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSector(ParametroGeneralUsuario parametroGeneralUsuario/*SectorBeanSwingJInternalFrame sectorBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSector= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}