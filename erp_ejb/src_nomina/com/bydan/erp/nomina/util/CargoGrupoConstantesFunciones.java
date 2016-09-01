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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.CargoGrupoConstantesFunciones;
import com.bydan.erp.nomina.util.CargoGrupoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CargoGrupoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CargoGrupoConstantesFunciones extends CargoGrupoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CargoGrupo";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CargoGrupo"+CargoGrupoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CargoGrupoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CargoGrupoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CargoGrupoConstantesFunciones.SCHEMA+"_"+CargoGrupoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CargoGrupoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CargoGrupoConstantesFunciones.SCHEMA+"_"+CargoGrupoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CargoGrupoConstantesFunciones.SCHEMA+"_"+CargoGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CargoGrupoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CargoGrupoConstantesFunciones.SCHEMA+"_"+CargoGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargoGrupoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CargoGrupoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CargoGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CargoGrupoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CargoGrupoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CargoGrupoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CargoGrupoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cargo Grupos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cargo Grupo";
	public static final String SCLASSWEBTITULO_LOWER="Cargo Grupo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CargoGrupo";
	public static final String OBJECTNAME="cargogrupo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="cargo_grupo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cargogrupo from "+CargoGrupoConstantesFunciones.SPERSISTENCENAME+" cargogrupo";
	public static String QUERYSELECTNATIVE="select "+CargoGrupoConstantesFunciones.SCHEMA+"."+CargoGrupoConstantesFunciones.TABLENAME+".id,"+CargoGrupoConstantesFunciones.SCHEMA+"."+CargoGrupoConstantesFunciones.TABLENAME+".version_row,"+CargoGrupoConstantesFunciones.SCHEMA+"."+CargoGrupoConstantesFunciones.TABLENAME+".id_empresa,"+CargoGrupoConstantesFunciones.SCHEMA+"."+CargoGrupoConstantesFunciones.TABLENAME+".codigo,"+CargoGrupoConstantesFunciones.SCHEMA+"."+CargoGrupoConstantesFunciones.TABLENAME+".nombre from "+CargoGrupoConstantesFunciones.SCHEMA+"."+CargoGrupoConstantesFunciones.TABLENAME;//+" as "+CargoGrupoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CargoGrupoConstantesFuncionesAdditional cargogrupoConstantesFuncionesAdditional=null;
	
	public CargoGrupoConstantesFuncionesAdditional getCargoGrupoConstantesFuncionesAdditional() {
		return this.cargogrupoConstantesFuncionesAdditional;
	}
	
	public void setCargoGrupoConstantesFuncionesAdditional(CargoGrupoConstantesFuncionesAdditional cargogrupoConstantesFuncionesAdditional) {
		try {
			this.cargogrupoConstantesFuncionesAdditional=cargogrupoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCargoGrupoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CargoGrupoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CargoGrupoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CargoGrupoConstantesFunciones.CODIGO)) {sLabelColumna=CargoGrupoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CargoGrupoConstantesFunciones.NOMBRE)) {sLabelColumna=CargoGrupoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getCargoGrupoDescripcion(CargoGrupo cargogrupo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cargogrupo !=null/* && cargogrupo.getId()!=0*/) {
			sDescripcion=cargogrupo.getcodigo();//cargogrupocargogrupo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCargoGrupoDescripcionDetallado(CargoGrupo cargogrupo) {
		String sDescripcion="";
			
		sDescripcion+=CargoGrupoConstantesFunciones.ID+"=";
		sDescripcion+=cargogrupo.getId().toString()+",";
		sDescripcion+=CargoGrupoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cargogrupo.getVersionRow().toString()+",";
		sDescripcion+=CargoGrupoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cargogrupo.getid_empresa().toString()+",";
		sDescripcion+=CargoGrupoConstantesFunciones.CODIGO+"=";
		sDescripcion+=cargogrupo.getcodigo()+",";
		sDescripcion+=CargoGrupoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cargogrupo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setCargoGrupoDescripcion(CargoGrupo cargogrupo,String sValor) throws Exception {			
		if(cargogrupo !=null) {
			cargogrupo.setcodigo(sValor);;//cargogrupocargogrupo.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	
	
	public static void quitarEspaciosCargoGrupo(CargoGrupo cargogrupo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cargogrupo.setcodigo(cargogrupo.getcodigo().trim());
		cargogrupo.setnombre(cargogrupo.getnombre().trim());
	}
	
	public static void quitarEspaciosCargoGrupos(List<CargoGrupo> cargogrupos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CargoGrupo cargogrupo: cargogrupos) {
			cargogrupo.setcodigo(cargogrupo.getcodigo().trim());
			cargogrupo.setnombre(cargogrupo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargoGrupo(CargoGrupo cargogrupo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cargogrupo.getConCambioAuxiliar()) {
			cargogrupo.setIsDeleted(cargogrupo.getIsDeletedAuxiliar());	
			cargogrupo.setIsNew(cargogrupo.getIsNewAuxiliar());	
			cargogrupo.setIsChanged(cargogrupo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cargogrupo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cargogrupo.setIsDeletedAuxiliar(false);	
			cargogrupo.setIsNewAuxiliar(false);	
			cargogrupo.setIsChangedAuxiliar(false);
			
			cargogrupo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCargoGrupos(List<CargoGrupo> cargogrupos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CargoGrupo cargogrupo : cargogrupos) {
			if(conAsignarBase && cargogrupo.getConCambioAuxiliar()) {
				cargogrupo.setIsDeleted(cargogrupo.getIsDeletedAuxiliar());	
				cargogrupo.setIsNew(cargogrupo.getIsNewAuxiliar());	
				cargogrupo.setIsChanged(cargogrupo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cargogrupo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cargogrupo.setIsDeletedAuxiliar(false);	
				cargogrupo.setIsNewAuxiliar(false);	
				cargogrupo.setIsChangedAuxiliar(false);
				
				cargogrupo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCargoGrupo(CargoGrupo cargogrupo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCargoGrupos(List<CargoGrupo> cargogrupos,Boolean conEnteros) throws Exception  {
		
		for(CargoGrupo cargogrupo: cargogrupos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCargoGrupo(List<CargoGrupo> cargogrupos,CargoGrupo cargogrupoAux) throws Exception  {
		CargoGrupoConstantesFunciones.InicializarValoresCargoGrupo(cargogrupoAux,true);
		
		for(CargoGrupo cargogrupo: cargogrupos) {
			if(cargogrupo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCargoGrupo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CargoGrupoConstantesFunciones.getArrayColumnasGlobalesCargoGrupo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCargoGrupo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CargoGrupoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CargoGrupoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCargoGrupo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CargoGrupo> cargogrupos,CargoGrupo cargogrupo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CargoGrupo cargogrupoAux: cargogrupos) {
			if(cargogrupoAux!=null && cargogrupo!=null) {
				if((cargogrupoAux.getId()==null && cargogrupo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cargogrupoAux.getId()!=null && cargogrupo.getId()!=null){
					if(cargogrupoAux.getId().equals(cargogrupo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCargoGrupo(List<CargoGrupo> cargogrupos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CargoGrupo cargogrupo: cargogrupos) {			
			if(cargogrupo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCargoGrupo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CargoGrupoConstantesFunciones.LABEL_ID, CargoGrupoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoGrupoConstantesFunciones.LABEL_VERSIONROW, CargoGrupoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoGrupoConstantesFunciones.LABEL_IDEMPRESA, CargoGrupoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoGrupoConstantesFunciones.LABEL_CODIGO, CargoGrupoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CargoGrupoConstantesFunciones.LABEL_NOMBRE, CargoGrupoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCargoGrupo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CargoGrupoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoGrupoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoGrupoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoGrupoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CargoGrupoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargoGrupo() throws Exception  {
		return CargoGrupoConstantesFunciones.getTiposSeleccionarCargoGrupo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargoGrupo(Boolean conFk) throws Exception  {
		return CargoGrupoConstantesFunciones.getTiposSeleccionarCargoGrupo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCargoGrupo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoGrupoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CargoGrupoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoGrupoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CargoGrupoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CargoGrupoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CargoGrupoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCargoGrupo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCargoGrupo(CargoGrupo cargogrupoAux) throws Exception {
		
			cargogrupoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargogrupoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCargoGrupo(List<CargoGrupo> cargogruposTemp) throws Exception {
		for(CargoGrupo cargogrupoAux:cargogruposTemp) {
			
			cargogrupoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cargogrupoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCargoGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCargoGrupo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargoGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargoGrupoConstantesFunciones.getClassesRelationshipsOfCargoGrupo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargoGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cargo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cargo.class)) {
						classes.add(new Classe(Cargo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargoGrupo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CargoGrupoConstantesFunciones.getClassesRelationshipsFromStringsOfCargoGrupo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCargoGrupo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
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
	public static void actualizarLista(CargoGrupo cargogrupo,List<CargoGrupo> cargogrupos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CargoGrupo cargogrupoEncontrado=null;
			
			for(CargoGrupo cargogrupoLocal:cargogrupos) {
				if(cargogrupoLocal.getId().equals(cargogrupo.getId())) {
					cargogrupoEncontrado=cargogrupoLocal;
					
					cargogrupoLocal.setIsChanged(cargogrupo.getIsChanged());
					cargogrupoLocal.setIsNew(cargogrupo.getIsNew());
					cargogrupoLocal.setIsDeleted(cargogrupo.getIsDeleted());
					
					cargogrupoLocal.setGeneralEntityOriginal(cargogrupo.getGeneralEntityOriginal());
					
					cargogrupoLocal.setId(cargogrupo.getId());	
					cargogrupoLocal.setVersionRow(cargogrupo.getVersionRow());	
					cargogrupoLocal.setid_empresa(cargogrupo.getid_empresa());	
					cargogrupoLocal.setcodigo(cargogrupo.getcodigo());	
					cargogrupoLocal.setnombre(cargogrupo.getnombre());	
					
					
					cargogrupoLocal.setCargos(cargogrupo.getCargos());
					
					existe=true;
					break;
				}
			}
			
			if(!cargogrupo.getIsDeleted()) {
				if(!existe) {
					cargogrupos.add(cargogrupo);
				}
			} else {
				if(cargogrupoEncontrado!=null && permiteQuitar)  {
					cargogrupos.remove(cargogrupoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CargoGrupo cargogrupo,List<CargoGrupo> cargogrupos) throws Exception {
		try	{			
			for(CargoGrupo cargogrupoLocal:cargogrupos) {
				if(cargogrupoLocal.getId().equals(cargogrupo.getId())) {
					cargogrupoLocal.setIsSelected(cargogrupo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCargoGrupo(List<CargoGrupo> cargogruposAux) throws Exception {
		//this.cargogruposAux=cargogruposAux;
		
		for(CargoGrupo cargogrupoAux:cargogruposAux) {
			if(cargogrupoAux.getIsChanged()) {
				cargogrupoAux.setIsChanged(false);
			}		
			
			if(cargogrupoAux.getIsNew()) {
				cargogrupoAux.setIsNew(false);
			}	
			
			if(cargogrupoAux.getIsDeleted()) {
				cargogrupoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCargoGrupo(CargoGrupo cargogrupoAux) throws Exception {
		//this.cargogrupoAux=cargogrupoAux;
		
			if(cargogrupoAux.getIsChanged()) {
				cargogrupoAux.setIsChanged(false);
			}		
			
			if(cargogrupoAux.getIsNew()) {
				cargogrupoAux.setIsNew(false);
			}	
			
			if(cargogrupoAux.getIsDeleted()) {
				cargogrupoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CargoGrupo cargogrupoAsignar,CargoGrupo cargogrupo) throws Exception {
		cargogrupoAsignar.setId(cargogrupo.getId());	
		cargogrupoAsignar.setVersionRow(cargogrupo.getVersionRow());	
		cargogrupoAsignar.setid_empresa(cargogrupo.getid_empresa());
		cargogrupoAsignar.setempresa_descripcion(cargogrupo.getempresa_descripcion());	
		cargogrupoAsignar.setcodigo(cargogrupo.getcodigo());	
		cargogrupoAsignar.setnombre(cargogrupo.getnombre());	
	}
	
	public static void inicializarCargoGrupo(CargoGrupo cargogrupo) throws Exception {
		try {
				cargogrupo.setId(0L);	
					
				cargogrupo.setid_empresa(-1L);	
				cargogrupo.setcodigo("");	
				cargogrupo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCargoGrupo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoGrupoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoGrupoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CargoGrupoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCargoGrupo(String sTipo,Row row,Workbook workbook,CargoGrupo cargogrupo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cargogrupo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargogrupo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cargogrupo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCargoGrupo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCargoGrupo() {
		return this.sFinalQueryCargoGrupo;
	}
	
	public void setsFinalQueryCargoGrupo(String sFinalQueryCargoGrupo) {
		this.sFinalQueryCargoGrupo= sFinalQueryCargoGrupo;
	}
	
	public Border resaltarSeleccionarCargoGrupo=null;
	
	public Border setResaltarSeleccionarCargoGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cargogrupoBeanSwingJInternalFrame.jTtoolBarCargoGrupo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCargoGrupo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCargoGrupo() {
		return this.resaltarSeleccionarCargoGrupo;
	}
	
	public void setResaltarSeleccionarCargoGrupo(Border borderResaltarSeleccionarCargoGrupo) {
		this.resaltarSeleccionarCargoGrupo= borderResaltarSeleccionarCargoGrupo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCargoGrupo=null;
	public Boolean mostraridCargoGrupo=true;
	public Boolean activaridCargoGrupo=true;

	public Border resaltarid_empresaCargoGrupo=null;
	public Boolean mostrarid_empresaCargoGrupo=true;
	public Boolean activarid_empresaCargoGrupo=true;
	public Boolean cargarid_empresaCargoGrupo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCargoGrupo=false;//ConEventDepend=true

	public Border resaltarcodigoCargoGrupo=null;
	public Boolean mostrarcodigoCargoGrupo=true;
	public Boolean activarcodigoCargoGrupo=true;

	public Border resaltarnombreCargoGrupo=null;
	public Boolean mostrarnombreCargoGrupo=true;
	public Boolean activarnombreCargoGrupo=true;

	
	

	public Border setResaltaridCargoGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargogrupoBeanSwingJInternalFrame.jTtoolBarCargoGrupo.setBorder(borderResaltar);
		
		this.resaltaridCargoGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCargoGrupo() {
		return this.resaltaridCargoGrupo;
	}

	public void setResaltaridCargoGrupo(Border borderResaltar) {
		this.resaltaridCargoGrupo= borderResaltar;
	}

	public Boolean getMostraridCargoGrupo() {
		return this.mostraridCargoGrupo;
	}

	public void setMostraridCargoGrupo(Boolean mostraridCargoGrupo) {
		this.mostraridCargoGrupo= mostraridCargoGrupo;
	}

	public Boolean getActivaridCargoGrupo() {
		return this.activaridCargoGrupo;
	}

	public void setActivaridCargoGrupo(Boolean activaridCargoGrupo) {
		this.activaridCargoGrupo= activaridCargoGrupo;
	}

	public Border setResaltarid_empresaCargoGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargogrupoBeanSwingJInternalFrame.jTtoolBarCargoGrupo.setBorder(borderResaltar);
		
		this.resaltarid_empresaCargoGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCargoGrupo() {
		return this.resaltarid_empresaCargoGrupo;
	}

	public void setResaltarid_empresaCargoGrupo(Border borderResaltar) {
		this.resaltarid_empresaCargoGrupo= borderResaltar;
	}

	public Boolean getMostrarid_empresaCargoGrupo() {
		return this.mostrarid_empresaCargoGrupo;
	}

	public void setMostrarid_empresaCargoGrupo(Boolean mostrarid_empresaCargoGrupo) {
		this.mostrarid_empresaCargoGrupo= mostrarid_empresaCargoGrupo;
	}

	public Boolean getActivarid_empresaCargoGrupo() {
		return this.activarid_empresaCargoGrupo;
	}

	public void setActivarid_empresaCargoGrupo(Boolean activarid_empresaCargoGrupo) {
		this.activarid_empresaCargoGrupo= activarid_empresaCargoGrupo;
	}

	public Boolean getCargarid_empresaCargoGrupo() {
		return this.cargarid_empresaCargoGrupo;
	}

	public void setCargarid_empresaCargoGrupo(Boolean cargarid_empresaCargoGrupo) {
		this.cargarid_empresaCargoGrupo= cargarid_empresaCargoGrupo;
	}

	public Border setResaltarcodigoCargoGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargogrupoBeanSwingJInternalFrame.jTtoolBarCargoGrupo.setBorder(borderResaltar);
		
		this.resaltarcodigoCargoGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCargoGrupo() {
		return this.resaltarcodigoCargoGrupo;
	}

	public void setResaltarcodigoCargoGrupo(Border borderResaltar) {
		this.resaltarcodigoCargoGrupo= borderResaltar;
	}

	public Boolean getMostrarcodigoCargoGrupo() {
		return this.mostrarcodigoCargoGrupo;
	}

	public void setMostrarcodigoCargoGrupo(Boolean mostrarcodigoCargoGrupo) {
		this.mostrarcodigoCargoGrupo= mostrarcodigoCargoGrupo;
	}

	public Boolean getActivarcodigoCargoGrupo() {
		return this.activarcodigoCargoGrupo;
	}

	public void setActivarcodigoCargoGrupo(Boolean activarcodigoCargoGrupo) {
		this.activarcodigoCargoGrupo= activarcodigoCargoGrupo;
	}

	public Border setResaltarnombreCargoGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cargogrupoBeanSwingJInternalFrame.jTtoolBarCargoGrupo.setBorder(borderResaltar);
		
		this.resaltarnombreCargoGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCargoGrupo() {
		return this.resaltarnombreCargoGrupo;
	}

	public void setResaltarnombreCargoGrupo(Border borderResaltar) {
		this.resaltarnombreCargoGrupo= borderResaltar;
	}

	public Boolean getMostrarnombreCargoGrupo() {
		return this.mostrarnombreCargoGrupo;
	}

	public void setMostrarnombreCargoGrupo(Boolean mostrarnombreCargoGrupo) {
		this.mostrarnombreCargoGrupo= mostrarnombreCargoGrupo;
	}

	public Boolean getActivarnombreCargoGrupo() {
		return this.activarnombreCargoGrupo;
	}

	public void setActivarnombreCargoGrupo(Boolean activarnombreCargoGrupo) {
		this.activarnombreCargoGrupo= activarnombreCargoGrupo;
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
		
		
		this.setMostraridCargoGrupo(esInicial);
		this.setMostrarid_empresaCargoGrupo(esInicial);
		this.setMostrarcodigoCargoGrupo(esInicial);
		this.setMostrarnombreCargoGrupo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoGrupoConstantesFunciones.ID)) {
				this.setMostraridCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCargoGrupo(esAsigna);
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
		
		
		this.setActivaridCargoGrupo(esInicial);
		this.setActivarid_empresaCargoGrupo(esInicial);
		this.setActivarcodigoCargoGrupo(esInicial);
		this.setActivarnombreCargoGrupo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoGrupoConstantesFunciones.ID)) {
				this.setActivaridCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCargoGrupo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCargoGrupo(esInicial);
		this.setResaltarid_empresaCargoGrupo(esInicial);
		this.setResaltarcodigoCargoGrupo(esInicial);
		this.setResaltarnombreCargoGrupo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CargoGrupoConstantesFunciones.ID)) {
				this.setResaltaridCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCargoGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(CargoGrupoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCargoGrupo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCargoCargoGrupo=null;

	public Border getResaltarCargoCargoGrupo() {
		return this.resaltarCargoCargoGrupo;
	}

	public void setResaltarCargoCargoGrupo(Border borderResaltarCargo) {
		if(borderResaltarCargo!=null) {
			this.resaltarCargoCargoGrupo= borderResaltarCargo;
		}
	}

	public Border setResaltarCargoCargoGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/) {
		Border borderResaltarCargo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cargogrupoBeanSwingJInternalFrame.jTtoolBarCargoGrupo.setBorder(borderResaltarCargo);
			
		this.resaltarCargoCargoGrupo= borderResaltarCargo;

		 return borderResaltarCargo;
	}



	public Boolean mostrarCargoCargoGrupo=true;

	public Boolean getMostrarCargoCargoGrupo() {
		return this.mostrarCargoCargoGrupo;
	}

	public void setMostrarCargoCargoGrupo(Boolean visibilidadResaltarCargo) {
		this.mostrarCargoCargoGrupo= visibilidadResaltarCargo;
	}



	public Boolean activarCargoCargoGrupo=true;

	public Boolean gethabilitarResaltarCargoCargoGrupo() {
		return this.activarCargoCargoGrupo;
	}

	public void setActivarCargoCargoGrupo(Boolean habilitarResaltarCargo) {
		this.activarCargoCargoGrupo= habilitarResaltarCargo;
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

		this.setMostrarCargoCargoGrupo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cargo.class)) {
				this.setMostrarCargoCargoGrupo(esAsigna);
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

		this.setActivarCargoCargoGrupo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cargo.class)) {
				this.setActivarCargoCargoGrupo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCargoCargoGrupo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cargo.class)) {
				this.setResaltarCargoCargoGrupo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaCargoGrupo=true;

	public Boolean getMostrarFK_IdEmpresaCargoGrupo() {
		return this.mostrarFK_IdEmpresaCargoGrupo;
	}

	public void setMostrarFK_IdEmpresaCargoGrupo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCargoGrupo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaCargoGrupo=true;

	public Boolean getActivarFK_IdEmpresaCargoGrupo() {
		return this.activarFK_IdEmpresaCargoGrupo;
	}

	public void setActivarFK_IdEmpresaCargoGrupo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCargoGrupo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaCargoGrupo=null;

	public Border getResaltarFK_IdEmpresaCargoGrupo() {
		return this.resaltarFK_IdEmpresaCargoGrupo;
	}

	public void setResaltarFK_IdEmpresaCargoGrupo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCargoGrupo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCargoGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*CargoGrupoBeanSwingJInternalFrame cargogrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCargoGrupo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}