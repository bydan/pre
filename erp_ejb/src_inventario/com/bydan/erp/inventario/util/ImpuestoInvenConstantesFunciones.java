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


import com.bydan.erp.inventario.util.ImpuestoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.ImpuestoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.ImpuestoInvenParameterGeneral;

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
final public class ImpuestoInvenConstantesFunciones extends ImpuestoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ImpuestoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ImpuestoInven"+ImpuestoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ImpuestoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ImpuestoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ImpuestoInvenConstantesFunciones.SCHEMA+"_"+ImpuestoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ImpuestoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ImpuestoInvenConstantesFunciones.SCHEMA+"_"+ImpuestoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ImpuestoInvenConstantesFunciones.SCHEMA+"_"+ImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ImpuestoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ImpuestoInvenConstantesFunciones.SCHEMA+"_"+ImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ImpuestoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ImpuestoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ImpuestoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ImpuestoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ImpuestoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ImpuestoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ImpuestoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Impuesto Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Impuesto Inven";
	public static final String SCLASSWEBTITULO_LOWER="Impuesto Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ImpuestoInven";
	public static final String OBJECTNAME="impuestoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="impuesto_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select impuestoinven from "+ImpuestoInvenConstantesFunciones.SPERSISTENCENAME+" impuestoinven";
	public static String QUERYSELECTNATIVE="select "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".id,"+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".version_row,"+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".id_empresa,"+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME+".nombre from "+ImpuestoInvenConstantesFunciones.SCHEMA+"."+ImpuestoInvenConstantesFunciones.TABLENAME;//+" as "+ImpuestoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ImpuestoInvenConstantesFuncionesAdditional impuestoinvenConstantesFuncionesAdditional=null;
	
	public ImpuestoInvenConstantesFuncionesAdditional getImpuestoInvenConstantesFuncionesAdditional() {
		return this.impuestoinvenConstantesFuncionesAdditional;
	}
	
	public void setImpuestoInvenConstantesFuncionesAdditional(ImpuestoInvenConstantesFuncionesAdditional impuestoinvenConstantesFuncionesAdditional) {
		try {
			this.impuestoinvenConstantesFuncionesAdditional=impuestoinvenConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getImpuestoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ImpuestoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=ImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ImpuestoInvenConstantesFunciones.NOMBRE)) {sLabelColumna=ImpuestoInvenConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getImpuestoInvenDescripcion(ImpuestoInven impuestoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(impuestoinven !=null/* && impuestoinven.getId()!=0*/) {
			sDescripcion=impuestoinven.getnombre();//impuestoinvenimpuestoinven.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getImpuestoInvenDescripcionDetallado(ImpuestoInven impuestoinven) {
		String sDescripcion="";
			
		sDescripcion+=ImpuestoInvenConstantesFunciones.ID+"=";
		sDescripcion+=impuestoinven.getId().toString()+",";
		sDescripcion+=ImpuestoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=impuestoinven.getVersionRow().toString()+",";
		sDescripcion+=ImpuestoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=impuestoinven.getid_empresa().toString()+",";
		sDescripcion+=ImpuestoInvenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=impuestoinven.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setImpuestoInvenDescripcion(ImpuestoInven impuestoinven,String sValor) throws Exception {			
		if(impuestoinven !=null) {
			impuestoinven.setnombre(sValor);;//impuestoinvenimpuestoinven.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorIdEmpresaPorNombre")) {
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

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdEmpresaPorNombre(Long id_empresa,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosImpuestoInven(ImpuestoInven impuestoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		impuestoinven.setnombre(impuestoinven.getnombre().trim());
	}
	
	public static void quitarEspaciosImpuestoInvens(List<ImpuestoInven> impuestoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ImpuestoInven impuestoinven: impuestoinvens) {
			impuestoinven.setnombre(impuestoinven.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresImpuestoInven(ImpuestoInven impuestoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && impuestoinven.getConCambioAuxiliar()) {
			impuestoinven.setIsDeleted(impuestoinven.getIsDeletedAuxiliar());	
			impuestoinven.setIsNew(impuestoinven.getIsNewAuxiliar());	
			impuestoinven.setIsChanged(impuestoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			impuestoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			impuestoinven.setIsDeletedAuxiliar(false);	
			impuestoinven.setIsNewAuxiliar(false);	
			impuestoinven.setIsChangedAuxiliar(false);
			
			impuestoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresImpuestoInvens(List<ImpuestoInven> impuestoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ImpuestoInven impuestoinven : impuestoinvens) {
			if(conAsignarBase && impuestoinven.getConCambioAuxiliar()) {
				impuestoinven.setIsDeleted(impuestoinven.getIsDeletedAuxiliar());	
				impuestoinven.setIsNew(impuestoinven.getIsNewAuxiliar());	
				impuestoinven.setIsChanged(impuestoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				impuestoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				impuestoinven.setIsDeletedAuxiliar(false);	
				impuestoinven.setIsNewAuxiliar(false);	
				impuestoinven.setIsChangedAuxiliar(false);
				
				impuestoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresImpuestoInven(ImpuestoInven impuestoinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresImpuestoInvens(List<ImpuestoInven> impuestoinvens,Boolean conEnteros) throws Exception  {
		
		for(ImpuestoInven impuestoinven: impuestoinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaImpuestoInven(List<ImpuestoInven> impuestoinvens,ImpuestoInven impuestoinvenAux) throws Exception  {
		ImpuestoInvenConstantesFunciones.InicializarValoresImpuestoInven(impuestoinvenAux,true);
		
		for(ImpuestoInven impuestoinven: impuestoinvens) {
			if(impuestoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesImpuestoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ImpuestoInvenConstantesFunciones.getArrayColumnasGlobalesImpuestoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesImpuestoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ImpuestoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ImpuestoInvenConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoImpuestoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ImpuestoInven> impuestoinvens,ImpuestoInven impuestoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ImpuestoInven impuestoinvenAux: impuestoinvens) {
			if(impuestoinvenAux!=null && impuestoinven!=null) {
				if((impuestoinvenAux.getId()==null && impuestoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(impuestoinvenAux.getId()!=null && impuestoinven.getId()!=null){
					if(impuestoinvenAux.getId().equals(impuestoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaImpuestoInven(List<ImpuestoInven> impuestoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ImpuestoInven impuestoinven: impuestoinvens) {			
			if(impuestoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaImpuestoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ImpuestoInvenConstantesFunciones.LABEL_ID, ImpuestoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoInvenConstantesFunciones.LABEL_VERSIONROW, ImpuestoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA, ImpuestoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ImpuestoInvenConstantesFunciones.LABEL_NOMBRE, ImpuestoInvenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasImpuestoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ImpuestoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ImpuestoInvenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImpuestoInven() throws Exception  {
		return ImpuestoInvenConstantesFunciones.getTiposSeleccionarImpuestoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImpuestoInven(Boolean conFk) throws Exception  {
		return ImpuestoInvenConstantesFunciones.getTiposSeleccionarImpuestoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarImpuestoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ImpuestoInvenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(ImpuestoInvenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesImpuestoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesImpuestoInven(ImpuestoInven impuestoinvenAux) throws Exception {
		
			impuestoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(impuestoinvenAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesImpuestoInven(List<ImpuestoInven> impuestoinvensTemp) throws Exception {
		for(ImpuestoInven impuestoinvenAux:impuestoinvensTemp) {
			
			impuestoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(impuestoinvenAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfImpuestoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ImpuestoInvenConstantesFunciones.getClassesRelationshipsOfImpuestoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfImpuestoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ProductoImpuesto.class));
				classes.add(new Classe(DetalleImpuestoInven.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ProductoImpuesto.class)) {
						classes.add(new Classe(ProductoImpuesto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleImpuestoInven.class)) {
						classes.add(new Classe(DetalleImpuestoInven.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfImpuestoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ImpuestoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfImpuestoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfImpuestoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoImpuesto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoImpuesto.class)); continue;
					}

					if(DetalleImpuestoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleImpuestoInven.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ProductoImpuesto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ProductoImpuesto.class)); continue;
					}

					if(DetalleImpuestoInven.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleImpuestoInven.class)); continue;
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
	public static void actualizarLista(ImpuestoInven impuestoinven,List<ImpuestoInven> impuestoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ImpuestoInven impuestoinvenEncontrado=null;
			
			for(ImpuestoInven impuestoinvenLocal:impuestoinvens) {
				if(impuestoinvenLocal.getId().equals(impuestoinven.getId())) {
					impuestoinvenEncontrado=impuestoinvenLocal;
					
					impuestoinvenLocal.setIsChanged(impuestoinven.getIsChanged());
					impuestoinvenLocal.setIsNew(impuestoinven.getIsNew());
					impuestoinvenLocal.setIsDeleted(impuestoinven.getIsDeleted());
					
					impuestoinvenLocal.setGeneralEntityOriginal(impuestoinven.getGeneralEntityOriginal());
					
					impuestoinvenLocal.setId(impuestoinven.getId());	
					impuestoinvenLocal.setVersionRow(impuestoinven.getVersionRow());	
					impuestoinvenLocal.setid_empresa(impuestoinven.getid_empresa());	
					impuestoinvenLocal.setnombre(impuestoinven.getnombre());	
					
					
					impuestoinvenLocal.setProductoImpuestos(impuestoinven.getProductoImpuestos());
					impuestoinvenLocal.setDetalleImpuestoInvens(impuestoinven.getDetalleImpuestoInvens());
					
					existe=true;
					break;
				}
			}
			
			if(!impuestoinven.getIsDeleted()) {
				if(!existe) {
					impuestoinvens.add(impuestoinven);
				}
			} else {
				if(impuestoinvenEncontrado!=null && permiteQuitar)  {
					impuestoinvens.remove(impuestoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ImpuestoInven impuestoinven,List<ImpuestoInven> impuestoinvens) throws Exception {
		try	{			
			for(ImpuestoInven impuestoinvenLocal:impuestoinvens) {
				if(impuestoinvenLocal.getId().equals(impuestoinven.getId())) {
					impuestoinvenLocal.setIsSelected(impuestoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesImpuestoInven(List<ImpuestoInven> impuestoinvensAux) throws Exception {
		//this.impuestoinvensAux=impuestoinvensAux;
		
		for(ImpuestoInven impuestoinvenAux:impuestoinvensAux) {
			if(impuestoinvenAux.getIsChanged()) {
				impuestoinvenAux.setIsChanged(false);
			}		
			
			if(impuestoinvenAux.getIsNew()) {
				impuestoinvenAux.setIsNew(false);
			}	
			
			if(impuestoinvenAux.getIsDeleted()) {
				impuestoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesImpuestoInven(ImpuestoInven impuestoinvenAux) throws Exception {
		//this.impuestoinvenAux=impuestoinvenAux;
		
			if(impuestoinvenAux.getIsChanged()) {
				impuestoinvenAux.setIsChanged(false);
			}		
			
			if(impuestoinvenAux.getIsNew()) {
				impuestoinvenAux.setIsNew(false);
			}	
			
			if(impuestoinvenAux.getIsDeleted()) {
				impuestoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ImpuestoInven impuestoinvenAsignar,ImpuestoInven impuestoinven) throws Exception {
		impuestoinvenAsignar.setId(impuestoinven.getId());	
		impuestoinvenAsignar.setVersionRow(impuestoinven.getVersionRow());	
		impuestoinvenAsignar.setid_empresa(impuestoinven.getid_empresa());
		impuestoinvenAsignar.setempresa_descripcion(impuestoinven.getempresa_descripcion());	
		impuestoinvenAsignar.setnombre(impuestoinven.getnombre());	
	}
	
	public static void inicializarImpuestoInven(ImpuestoInven impuestoinven) throws Exception {
		try {
				impuestoinven.setId(0L);	
					
				impuestoinven.setid_empresa(-1L);	
				impuestoinven.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderImpuestoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ImpuestoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ImpuestoInvenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataImpuestoInven(String sTipo,Row row,Workbook workbook,ImpuestoInven impuestoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(impuestoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(impuestoinven.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryImpuestoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryImpuestoInven() {
		return this.sFinalQueryImpuestoInven;
	}
	
	public void setsFinalQueryImpuestoInven(String sFinalQueryImpuestoInven) {
		this.sFinalQueryImpuestoInven= sFinalQueryImpuestoInven;
	}
	
	public Border resaltarSeleccionarImpuestoInven=null;
	
	public Border setResaltarSeleccionarImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//impuestoinvenBeanSwingJInternalFrame.jTtoolBarImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarImpuestoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarImpuestoInven() {
		return this.resaltarSeleccionarImpuestoInven;
	}
	
	public void setResaltarSeleccionarImpuestoInven(Border borderResaltarSeleccionarImpuestoInven) {
		this.resaltarSeleccionarImpuestoInven= borderResaltarSeleccionarImpuestoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridImpuestoInven=null;
	public Boolean mostraridImpuestoInven=true;
	public Boolean activaridImpuestoInven=true;

	public Border resaltarid_empresaImpuestoInven=null;
	public Boolean mostrarid_empresaImpuestoInven=true;
	public Boolean activarid_empresaImpuestoInven=true;
	public Boolean cargarid_empresaImpuestoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaImpuestoInven=false;//ConEventDepend=true

	public Border resaltarnombreImpuestoInven=null;
	public Boolean mostrarnombreImpuestoInven=true;
	public Boolean activarnombreImpuestoInven=true;

	
	

	public Border setResaltaridImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestoinvenBeanSwingJInternalFrame.jTtoolBarImpuestoInven.setBorder(borderResaltar);
		
		this.resaltaridImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridImpuestoInven() {
		return this.resaltaridImpuestoInven;
	}

	public void setResaltaridImpuestoInven(Border borderResaltar) {
		this.resaltaridImpuestoInven= borderResaltar;
	}

	public Boolean getMostraridImpuestoInven() {
		return this.mostraridImpuestoInven;
	}

	public void setMostraridImpuestoInven(Boolean mostraridImpuestoInven) {
		this.mostraridImpuestoInven= mostraridImpuestoInven;
	}

	public Boolean getActivaridImpuestoInven() {
		return this.activaridImpuestoInven;
	}

	public void setActivaridImpuestoInven(Boolean activaridImpuestoInven) {
		this.activaridImpuestoInven= activaridImpuestoInven;
	}

	public Border setResaltarid_empresaImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestoinvenBeanSwingJInternalFrame.jTtoolBarImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaImpuestoInven() {
		return this.resaltarid_empresaImpuestoInven;
	}

	public void setResaltarid_empresaImpuestoInven(Border borderResaltar) {
		this.resaltarid_empresaImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaImpuestoInven() {
		return this.mostrarid_empresaImpuestoInven;
	}

	public void setMostrarid_empresaImpuestoInven(Boolean mostrarid_empresaImpuestoInven) {
		this.mostrarid_empresaImpuestoInven= mostrarid_empresaImpuestoInven;
	}

	public Boolean getActivarid_empresaImpuestoInven() {
		return this.activarid_empresaImpuestoInven;
	}

	public void setActivarid_empresaImpuestoInven(Boolean activarid_empresaImpuestoInven) {
		this.activarid_empresaImpuestoInven= activarid_empresaImpuestoInven;
	}

	public Boolean getCargarid_empresaImpuestoInven() {
		return this.cargarid_empresaImpuestoInven;
	}

	public void setCargarid_empresaImpuestoInven(Boolean cargarid_empresaImpuestoInven) {
		this.cargarid_empresaImpuestoInven= cargarid_empresaImpuestoInven;
	}

	public Border setResaltarnombreImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//impuestoinvenBeanSwingJInternalFrame.jTtoolBarImpuestoInven.setBorder(borderResaltar);
		
		this.resaltarnombreImpuestoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreImpuestoInven() {
		return this.resaltarnombreImpuestoInven;
	}

	public void setResaltarnombreImpuestoInven(Border borderResaltar) {
		this.resaltarnombreImpuestoInven= borderResaltar;
	}

	public Boolean getMostrarnombreImpuestoInven() {
		return this.mostrarnombreImpuestoInven;
	}

	public void setMostrarnombreImpuestoInven(Boolean mostrarnombreImpuestoInven) {
		this.mostrarnombreImpuestoInven= mostrarnombreImpuestoInven;
	}

	public Boolean getActivarnombreImpuestoInven() {
		return this.activarnombreImpuestoInven;
	}

	public void setActivarnombreImpuestoInven(Boolean activarnombreImpuestoInven) {
		this.activarnombreImpuestoInven= activarnombreImpuestoInven;
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
		
		
		this.setMostraridImpuestoInven(esInicial);
		this.setMostrarid_empresaImpuestoInven(esInicial);
		this.setMostrarnombreImpuestoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.ID)) {
				this.setMostraridImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreImpuestoInven(esAsigna);
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
		
		
		this.setActivaridImpuestoInven(esInicial);
		this.setActivarid_empresaImpuestoInven(esInicial);
		this.setActivarnombreImpuestoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.ID)) {
				this.setActivaridImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreImpuestoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridImpuestoInven(esInicial);
		this.setResaltarid_empresaImpuestoInven(esInicial);
		this.setResaltarnombreImpuestoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.ID)) {
				this.setResaltaridImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaImpuestoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(ImpuestoInvenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreImpuestoInven(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarProductoImpuestoImpuestoInven=null;

	public Border getResaltarProductoImpuestoImpuestoInven() {
		return this.resaltarProductoImpuestoImpuestoInven;
	}

	public void setResaltarProductoImpuestoImpuestoInven(Border borderResaltarProductoImpuesto) {
		if(borderResaltarProductoImpuesto!=null) {
			this.resaltarProductoImpuestoImpuestoInven= borderResaltarProductoImpuesto;
		}
	}

	public Border setResaltarProductoImpuestoImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltarProductoImpuesto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//impuestoinvenBeanSwingJInternalFrame.jTtoolBarImpuestoInven.setBorder(borderResaltarProductoImpuesto);
			
		this.resaltarProductoImpuestoImpuestoInven= borderResaltarProductoImpuesto;

		 return borderResaltarProductoImpuesto;
	}



	public Boolean mostrarProductoImpuestoImpuestoInven=true;

	public Boolean getMostrarProductoImpuestoImpuestoInven() {
		return this.mostrarProductoImpuestoImpuestoInven;
	}

	public void setMostrarProductoImpuestoImpuestoInven(Boolean visibilidadResaltarProductoImpuesto) {
		this.mostrarProductoImpuestoImpuestoInven= visibilidadResaltarProductoImpuesto;
	}



	public Boolean activarProductoImpuestoImpuestoInven=true;

	public Boolean gethabilitarResaltarProductoImpuestoImpuestoInven() {
		return this.activarProductoImpuestoImpuestoInven;
	}

	public void setActivarProductoImpuestoImpuestoInven(Boolean habilitarResaltarProductoImpuesto) {
		this.activarProductoImpuestoImpuestoInven= habilitarResaltarProductoImpuesto;
	}


	public Border resaltarDetalleImpuestoInvenImpuestoInven=null;

	public Border getResaltarDetalleImpuestoInvenImpuestoInven() {
		return this.resaltarDetalleImpuestoInvenImpuestoInven;
	}

	public void setResaltarDetalleImpuestoInvenImpuestoInven(Border borderResaltarDetalleImpuestoInven) {
		if(borderResaltarDetalleImpuestoInven!=null) {
			this.resaltarDetalleImpuestoInvenImpuestoInven= borderResaltarDetalleImpuestoInven;
		}
	}

	public Border setResaltarDetalleImpuestoInvenImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleImpuestoInven=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//impuestoinvenBeanSwingJInternalFrame.jTtoolBarImpuestoInven.setBorder(borderResaltarDetalleImpuestoInven);
			
		this.resaltarDetalleImpuestoInvenImpuestoInven= borderResaltarDetalleImpuestoInven;

		 return borderResaltarDetalleImpuestoInven;
	}



	public Boolean mostrarDetalleImpuestoInvenImpuestoInven=true;

	public Boolean getMostrarDetalleImpuestoInvenImpuestoInven() {
		return this.mostrarDetalleImpuestoInvenImpuestoInven;
	}

	public void setMostrarDetalleImpuestoInvenImpuestoInven(Boolean visibilidadResaltarDetalleImpuestoInven) {
		this.mostrarDetalleImpuestoInvenImpuestoInven= visibilidadResaltarDetalleImpuestoInven;
	}



	public Boolean activarDetalleImpuestoInvenImpuestoInven=true;

	public Boolean gethabilitarResaltarDetalleImpuestoInvenImpuestoInven() {
		return this.activarDetalleImpuestoInvenImpuestoInven;
	}

	public void setActivarDetalleImpuestoInvenImpuestoInven(Boolean habilitarResaltarDetalleImpuestoInven) {
		this.activarDetalleImpuestoInvenImpuestoInven= habilitarResaltarDetalleImpuestoInven;
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

		this.setMostrarProductoImpuestoImpuestoInven(esInicial);
		this.setMostrarDetalleImpuestoInvenImpuestoInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoImpuesto.class)) {
				this.setMostrarProductoImpuestoImpuestoInven(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleImpuestoInven.class)) {
				this.setMostrarDetalleImpuestoInvenImpuestoInven(esAsigna);
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

		this.setActivarProductoImpuestoImpuestoInven(esInicial);
		this.setActivarDetalleImpuestoInvenImpuestoInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoImpuesto.class)) {
				this.setActivarProductoImpuestoImpuestoInven(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleImpuestoInven.class)) {
				this.setActivarDetalleImpuestoInvenImpuestoInven(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarProductoImpuestoImpuestoInven(esInicial);
		this.setResaltarDetalleImpuestoInvenImpuestoInven(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ProductoImpuesto.class)) {
				this.setResaltarProductoImpuestoImpuestoInven(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleImpuestoInven.class)) {
				this.setResaltarDetalleImpuestoInvenImpuestoInven(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorNombreImpuestoInven=true;

	public Boolean getMostrarBusquedaPorNombreImpuestoInven() {
		return this.mostrarBusquedaPorNombreImpuestoInven;
	}

	public void setMostrarBusquedaPorNombreImpuestoInven(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreImpuestoInven= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaImpuestoInven=true;

	public Boolean getMostrarFK_IdEmpresaImpuestoInven() {
		return this.mostrarFK_IdEmpresaImpuestoInven;
	}

	public void setMostrarFK_IdEmpresaImpuestoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaImpuestoInven= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreImpuestoInven=true;

	public Boolean getActivarBusquedaPorNombreImpuestoInven() {
		return this.activarBusquedaPorNombreImpuestoInven;
	}

	public void setActivarBusquedaPorNombreImpuestoInven(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreImpuestoInven= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaImpuestoInven=true;

	public Boolean getActivarFK_IdEmpresaImpuestoInven() {
		return this.activarFK_IdEmpresaImpuestoInven;
	}

	public void setActivarFK_IdEmpresaImpuestoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaImpuestoInven= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreImpuestoInven=null;

	public Border getResaltarBusquedaPorNombreImpuestoInven() {
		return this.resaltarBusquedaPorNombreImpuestoInven;
	}

	public void setResaltarBusquedaPorNombreImpuestoInven(Border borderResaltar) {
		this.resaltarBusquedaPorNombreImpuestoInven= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreImpuestoInven= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaImpuestoInven=null;

	public Border getResaltarFK_IdEmpresaImpuestoInven() {
		return this.resaltarFK_IdEmpresaImpuestoInven;
	}

	public void setResaltarFK_IdEmpresaImpuestoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaImpuestoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaImpuestoInven(ParametroGeneralUsuario parametroGeneralUsuario/*ImpuestoInvenBeanSwingJInternalFrame impuestoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaImpuestoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}