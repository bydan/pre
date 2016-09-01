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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoFormatoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoFormatoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoFormatoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoFormatoConstantesFunciones extends TipoFormatoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoFormato";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoFormato"+TipoFormatoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoFormatoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoFormatoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoFormatoConstantesFunciones.SCHEMA+"_"+TipoFormatoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoFormatoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoFormatoConstantesFunciones.SCHEMA+"_"+TipoFormatoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoFormatoConstantesFunciones.SCHEMA+"_"+TipoFormatoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoFormatoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoFormatoConstantesFunciones.SCHEMA+"_"+TipoFormatoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormatoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFormatoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormatoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormatoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoFormatoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoFormatoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoFormatoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoFormatoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoFormatoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoFormatoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Formato s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Formato ";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Formato";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoFormato";
	public static final String OBJECTNAME="tipoformato";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_formato";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoformato from "+TipoFormatoConstantesFunciones.SPERSISTENCENAME+" tipoformato";
	public static String QUERYSELECTNATIVE="select "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".id,"+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".version_row,"+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".id_empresa,"+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME+".nombre from "+TipoFormatoConstantesFunciones.SCHEMA+"."+TipoFormatoConstantesFunciones.TABLENAME;//+" as "+TipoFormatoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoFormatoConstantesFuncionesAdditional tipoformatoConstantesFuncionesAdditional=null;
	
	public TipoFormatoConstantesFuncionesAdditional getTipoFormatoConstantesFuncionesAdditional() {
		return this.tipoformatoConstantesFuncionesAdditional;
	}
	
	public void setTipoFormatoConstantesFuncionesAdditional(TipoFormatoConstantesFuncionesAdditional tipoformatoConstantesFuncionesAdditional) {
		try {
			this.tipoformatoConstantesFuncionesAdditional=tipoformatoConstantesFuncionesAdditional;
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
	
	public static String getTipoFormatoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoFormatoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoFormatoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoFormatoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoFormatoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoFormatoDescripcion(TipoFormato tipoformato) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoformato !=null/* && tipoformato.getId()!=0*/) {
			sDescripcion=tipoformato.getnombre();//tipoformatotipoformato.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoFormatoDescripcionDetallado(TipoFormato tipoformato) {
		String sDescripcion="";
			
		sDescripcion+=TipoFormatoConstantesFunciones.ID+"=";
		sDescripcion+=tipoformato.getId().toString()+",";
		sDescripcion+=TipoFormatoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoformato.getVersionRow().toString()+",";
		sDescripcion+=TipoFormatoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoformato.getid_empresa().toString()+",";
		sDescripcion+=TipoFormatoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoformato.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoFormatoDescripcion(TipoFormato tipoformato,String sValor) throws Exception {			
		if(tipoformato !=null) {
			tipoformato.setnombre(sValor);;//tipoformatotipoformato.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("PorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

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

	public static String getDetalleIndicePorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoFormato(TipoFormato tipoformato,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoformato.setnombre(tipoformato.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoFormatos(List<TipoFormato> tipoformatos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoFormato tipoformato: tipoformatos) {
			tipoformato.setnombre(tipoformato.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFormato(TipoFormato tipoformato,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoformato.getConCambioAuxiliar()) {
			tipoformato.setIsDeleted(tipoformato.getIsDeletedAuxiliar());	
			tipoformato.setIsNew(tipoformato.getIsNewAuxiliar());	
			tipoformato.setIsChanged(tipoformato.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoformato.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoformato.setIsDeletedAuxiliar(false);	
			tipoformato.setIsNewAuxiliar(false);	
			tipoformato.setIsChangedAuxiliar(false);
			
			tipoformato.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoFormatos(List<TipoFormato> tipoformatos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoFormato tipoformato : tipoformatos) {
			if(conAsignarBase && tipoformato.getConCambioAuxiliar()) {
				tipoformato.setIsDeleted(tipoformato.getIsDeletedAuxiliar());	
				tipoformato.setIsNew(tipoformato.getIsNewAuxiliar());	
				tipoformato.setIsChanged(tipoformato.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoformato.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoformato.setIsDeletedAuxiliar(false);	
				tipoformato.setIsNewAuxiliar(false);	
				tipoformato.setIsChangedAuxiliar(false);
				
				tipoformato.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoFormato(TipoFormato tipoformato,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoFormatos(List<TipoFormato> tipoformatos,Boolean conEnteros) throws Exception  {
		
		for(TipoFormato tipoformato: tipoformatos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoFormato(List<TipoFormato> tipoformatos,TipoFormato tipoformatoAux) throws Exception  {
		TipoFormatoConstantesFunciones.InicializarValoresTipoFormato(tipoformatoAux,true);
		
		for(TipoFormato tipoformato: tipoformatos) {
			if(tipoformato.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFormato(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoFormatoConstantesFunciones.getArrayColumnasGlobalesTipoFormato(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoFormato(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoFormatoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoFormatoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoFormato(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoFormato> tipoformatos,TipoFormato tipoformato,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoFormato tipoformatoAux: tipoformatos) {
			if(tipoformatoAux!=null && tipoformato!=null) {
				if((tipoformatoAux.getId()==null && tipoformato.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoformatoAux.getId()!=null && tipoformato.getId()!=null){
					if(tipoformatoAux.getId().equals(tipoformato.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoFormato(List<TipoFormato> tipoformatos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoFormato tipoformato: tipoformatos) {			
			if(tipoformato.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoFormato() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoFormatoConstantesFunciones.LABEL_ID, TipoFormatoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormatoConstantesFunciones.LABEL_VERSIONROW, TipoFormatoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormatoConstantesFunciones.LABEL_IDEMPRESA, TipoFormatoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoFormatoConstantesFunciones.LABEL_NOMBRE, TipoFormatoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoFormato() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoFormatoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormatoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormatoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoFormatoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormato() throws Exception  {
		return TipoFormatoConstantesFunciones.getTiposSeleccionarTipoFormato(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormato(Boolean conFk) throws Exception  {
		return TipoFormatoConstantesFunciones.getTiposSeleccionarTipoFormato(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoFormato(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormatoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoFormatoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoFormatoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoFormatoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoFormato(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFormato(TipoFormato tipoformatoAux) throws Exception {
		
			tipoformatoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoformatoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoFormato(List<TipoFormato> tipoformatosTemp) throws Exception {
		for(TipoFormato tipoformatoAux:tipoformatosTemp) {
			
			tipoformatoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoformatoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFormato(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoFormato(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormato(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFormatoConstantesFunciones.getClassesRelationshipsOfTipoFormato(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormato(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Formato.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFormato(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoFormatoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoFormato(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoFormato(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	public static void actualizarLista(TipoFormato tipoformato,List<TipoFormato> tipoformatos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoFormato tipoformatoEncontrado=null;
			
			for(TipoFormato tipoformatoLocal:tipoformatos) {
				if(tipoformatoLocal.getId().equals(tipoformato.getId())) {
					tipoformatoEncontrado=tipoformatoLocal;
					
					tipoformatoLocal.setIsChanged(tipoformato.getIsChanged());
					tipoformatoLocal.setIsNew(tipoformato.getIsNew());
					tipoformatoLocal.setIsDeleted(tipoformato.getIsDeleted());
					
					tipoformatoLocal.setGeneralEntityOriginal(tipoformato.getGeneralEntityOriginal());
					
					tipoformatoLocal.setId(tipoformato.getId());	
					tipoformatoLocal.setVersionRow(tipoformato.getVersionRow());	
					tipoformatoLocal.setid_empresa(tipoformato.getid_empresa());	
					tipoformatoLocal.setnombre(tipoformato.getnombre());	
					
					
					tipoformatoLocal.setFormatos(tipoformato.getFormatos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoformato.getIsDeleted()) {
				if(!existe) {
					tipoformatos.add(tipoformato);
				}
			} else {
				if(tipoformatoEncontrado!=null && permiteQuitar)  {
					tipoformatos.remove(tipoformatoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoFormato tipoformato,List<TipoFormato> tipoformatos) throws Exception {
		try	{			
			for(TipoFormato tipoformatoLocal:tipoformatos) {
				if(tipoformatoLocal.getId().equals(tipoformato.getId())) {
					tipoformatoLocal.setIsSelected(tipoformato.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoFormato(List<TipoFormato> tipoformatosAux) throws Exception {
		//this.tipoformatosAux=tipoformatosAux;
		
		for(TipoFormato tipoformatoAux:tipoformatosAux) {
			if(tipoformatoAux.getIsChanged()) {
				tipoformatoAux.setIsChanged(false);
			}		
			
			if(tipoformatoAux.getIsNew()) {
				tipoformatoAux.setIsNew(false);
			}	
			
			if(tipoformatoAux.getIsDeleted()) {
				tipoformatoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoFormato(TipoFormato tipoformatoAux) throws Exception {
		//this.tipoformatoAux=tipoformatoAux;
		
			if(tipoformatoAux.getIsChanged()) {
				tipoformatoAux.setIsChanged(false);
			}		
			
			if(tipoformatoAux.getIsNew()) {
				tipoformatoAux.setIsNew(false);
			}	
			
			if(tipoformatoAux.getIsDeleted()) {
				tipoformatoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoFormato tipoformatoAsignar,TipoFormato tipoformato) throws Exception {
		tipoformatoAsignar.setId(tipoformato.getId());	
		tipoformatoAsignar.setVersionRow(tipoformato.getVersionRow());	
		tipoformatoAsignar.setid_empresa(tipoformato.getid_empresa());
		tipoformatoAsignar.setempresa_descripcion(tipoformato.getempresa_descripcion());	
		tipoformatoAsignar.setnombre(tipoformato.getnombre());	
	}
	
	public static void inicializarTipoFormato(TipoFormato tipoformato) throws Exception {
		try {
				tipoformato.setId(0L);	
					
				tipoformato.setid_empresa(-1L);	
				tipoformato.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoFormato(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormatoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoFormatoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoFormato(String sTipo,Row row,Workbook workbook,TipoFormato tipoformato,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformato.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoformato.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoFormato=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoFormato() {
		return this.sFinalQueryTipoFormato;
	}
	
	public void setsFinalQueryTipoFormato(String sFinalQueryTipoFormato) {
		this.sFinalQueryTipoFormato= sFinalQueryTipoFormato;
	}
	
	public Border resaltarSeleccionarTipoFormato=null;
	
	public Border setResaltarSeleccionarTipoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoformatoBeanSwingJInternalFrame.jTtoolBarTipoFormato.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoFormato= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoFormato() {
		return this.resaltarSeleccionarTipoFormato;
	}
	
	public void setResaltarSeleccionarTipoFormato(Border borderResaltarSeleccionarTipoFormato) {
		this.resaltarSeleccionarTipoFormato= borderResaltarSeleccionarTipoFormato;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoFormato=null;
	public Boolean mostraridTipoFormato=true;
	public Boolean activaridTipoFormato=true;

	public Border resaltarid_empresaTipoFormato=null;
	public Boolean mostrarid_empresaTipoFormato=true;
	public Boolean activarid_empresaTipoFormato=true;
	public Boolean cargarid_empresaTipoFormato=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoFormato=false;//ConEventDepend=true

	public Border resaltarnombreTipoFormato=null;
	public Boolean mostrarnombreTipoFormato=true;
	public Boolean activarnombreTipoFormato=true;

	
	

	public Border setResaltaridTipoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformatoBeanSwingJInternalFrame.jTtoolBarTipoFormato.setBorder(borderResaltar);
		
		this.resaltaridTipoFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoFormato() {
		return this.resaltaridTipoFormato;
	}

	public void setResaltaridTipoFormato(Border borderResaltar) {
		this.resaltaridTipoFormato= borderResaltar;
	}

	public Boolean getMostraridTipoFormato() {
		return this.mostraridTipoFormato;
	}

	public void setMostraridTipoFormato(Boolean mostraridTipoFormato) {
		this.mostraridTipoFormato= mostraridTipoFormato;
	}

	public Boolean getActivaridTipoFormato() {
		return this.activaridTipoFormato;
	}

	public void setActivaridTipoFormato(Boolean activaridTipoFormato) {
		this.activaridTipoFormato= activaridTipoFormato;
	}

	public Border setResaltarid_empresaTipoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformatoBeanSwingJInternalFrame.jTtoolBarTipoFormato.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoFormato() {
		return this.resaltarid_empresaTipoFormato;
	}

	public void setResaltarid_empresaTipoFormato(Border borderResaltar) {
		this.resaltarid_empresaTipoFormato= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoFormato() {
		return this.mostrarid_empresaTipoFormato;
	}

	public void setMostrarid_empresaTipoFormato(Boolean mostrarid_empresaTipoFormato) {
		this.mostrarid_empresaTipoFormato= mostrarid_empresaTipoFormato;
	}

	public Boolean getActivarid_empresaTipoFormato() {
		return this.activarid_empresaTipoFormato;
	}

	public void setActivarid_empresaTipoFormato(Boolean activarid_empresaTipoFormato) {
		this.activarid_empresaTipoFormato= activarid_empresaTipoFormato;
	}

	public Boolean getCargarid_empresaTipoFormato() {
		return this.cargarid_empresaTipoFormato;
	}

	public void setCargarid_empresaTipoFormato(Boolean cargarid_empresaTipoFormato) {
		this.cargarid_empresaTipoFormato= cargarid_empresaTipoFormato;
	}

	public Border setResaltarnombreTipoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoformatoBeanSwingJInternalFrame.jTtoolBarTipoFormato.setBorder(borderResaltar);
		
		this.resaltarnombreTipoFormato= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoFormato() {
		return this.resaltarnombreTipoFormato;
	}

	public void setResaltarnombreTipoFormato(Border borderResaltar) {
		this.resaltarnombreTipoFormato= borderResaltar;
	}

	public Boolean getMostrarnombreTipoFormato() {
		return this.mostrarnombreTipoFormato;
	}

	public void setMostrarnombreTipoFormato(Boolean mostrarnombreTipoFormato) {
		this.mostrarnombreTipoFormato= mostrarnombreTipoFormato;
	}

	public Boolean getActivarnombreTipoFormato() {
		return this.activarnombreTipoFormato;
	}

	public void setActivarnombreTipoFormato(Boolean activarnombreTipoFormato) {
		this.activarnombreTipoFormato= activarnombreTipoFormato;
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
		
		
		this.setMostraridTipoFormato(esInicial);
		this.setMostrarid_empresaTipoFormato(esInicial);
		this.setMostrarnombreTipoFormato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormatoConstantesFunciones.ID)) {
				this.setMostraridTipoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormatoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormatoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoFormato(esAsigna);
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
		
		
		this.setActivaridTipoFormato(esInicial);
		this.setActivarid_empresaTipoFormato(esInicial);
		this.setActivarnombreTipoFormato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormatoConstantesFunciones.ID)) {
				this.setActivaridTipoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormatoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormatoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoFormato(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoFormato(esInicial);
		this.setResaltarid_empresaTipoFormato(esInicial);
		this.setResaltarnombreTipoFormato(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoFormatoConstantesFunciones.ID)) {
				this.setResaltaridTipoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormatoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoFormato(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoFormatoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoFormato(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarFormatoTipoFormato=null;

	public Border getResaltarFormatoTipoFormato() {
		return this.resaltarFormatoTipoFormato;
	}

	public void setResaltarFormatoTipoFormato(Border borderResaltarFormato) {
		if(borderResaltarFormato!=null) {
			this.resaltarFormatoTipoFormato= borderResaltarFormato;
		}
	}

	public Border setResaltarFormatoTipoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/) {
		Border borderResaltarFormato=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoformatoBeanSwingJInternalFrame.jTtoolBarTipoFormato.setBorder(borderResaltarFormato);
			
		this.resaltarFormatoTipoFormato= borderResaltarFormato;

		 return borderResaltarFormato;
	}



	public Boolean mostrarFormatoTipoFormato=true;

	public Boolean getMostrarFormatoTipoFormato() {
		return this.mostrarFormatoTipoFormato;
	}

	public void setMostrarFormatoTipoFormato(Boolean visibilidadResaltarFormato) {
		this.mostrarFormatoTipoFormato= visibilidadResaltarFormato;
	}



	public Boolean activarFormatoTipoFormato=true;

	public Boolean gethabilitarResaltarFormatoTipoFormato() {
		return this.activarFormatoTipoFormato;
	}

	public void setActivarFormatoTipoFormato(Boolean habilitarResaltarFormato) {
		this.activarFormatoTipoFormato= habilitarResaltarFormato;
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

		this.setMostrarFormatoTipoFormato(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Formato.class)) {
				this.setMostrarFormatoTipoFormato(esAsigna);
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

		this.setActivarFormatoTipoFormato(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Formato.class)) {
				this.setActivarFormatoTipoFormato(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarFormatoTipoFormato(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Formato.class)) {
				this.setResaltarFormatoTipoFormato(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdTipoFormato=true;

	public Boolean getMostrarBusquedaPorIdTipoFormato() {
		return this.mostrarBusquedaPorIdTipoFormato;
	}

	public void setMostrarBusquedaPorIdTipoFormato(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdTipoFormato= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreTipoFormato=true;

	public Boolean getMostrarBusquedaPorNombreTipoFormato() {
		return this.mostrarBusquedaPorNombreTipoFormato;
	}

	public void setMostrarBusquedaPorNombreTipoFormato(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTipoFormato= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTipoFormato=true;

	public Boolean getMostrarFK_IdEmpresaTipoFormato() {
		return this.mostrarFK_IdEmpresaTipoFormato;
	}

	public void setMostrarFK_IdEmpresaTipoFormato(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoFormato= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdTipoFormato=true;

	public Boolean getActivarBusquedaPorIdTipoFormato() {
		return this.activarBusquedaPorIdTipoFormato;
	}

	public void setActivarBusquedaPorIdTipoFormato(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdTipoFormato= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreTipoFormato=true;

	public Boolean getActivarBusquedaPorNombreTipoFormato() {
		return this.activarBusquedaPorNombreTipoFormato;
	}

	public void setActivarBusquedaPorNombreTipoFormato(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTipoFormato= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTipoFormato=true;

	public Boolean getActivarFK_IdEmpresaTipoFormato() {
		return this.activarFK_IdEmpresaTipoFormato;
	}

	public void setActivarFK_IdEmpresaTipoFormato(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoFormato= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdTipoFormato=null;

	public Border getResaltarBusquedaPorIdTipoFormato() {
		return this.resaltarBusquedaPorIdTipoFormato;
	}

	public void setResaltarBusquedaPorIdTipoFormato(Border borderResaltar) {
		this.resaltarBusquedaPorIdTipoFormato= borderResaltar;
	}

	public void setResaltarBusquedaPorIdTipoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdTipoFormato= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreTipoFormato=null;

	public Border getResaltarBusquedaPorNombreTipoFormato() {
		return this.resaltarBusquedaPorNombreTipoFormato;
	}

	public void setResaltarBusquedaPorNombreTipoFormato(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTipoFormato= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTipoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTipoFormato= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTipoFormato=null;

	public Border getResaltarFK_IdEmpresaTipoFormato() {
		return this.resaltarFK_IdEmpresaTipoFormato;
	}

	public void setResaltarFK_IdEmpresaTipoFormato(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoFormato= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoFormato(ParametroGeneralUsuario parametroGeneralUsuario/*TipoFormatoBeanSwingJInternalFrame tipoformatoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoFormato= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}