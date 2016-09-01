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


import com.bydan.erp.seguridad.util.CiudadConstantesFunciones;
import com.bydan.erp.seguridad.util.CiudadParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.CiudadParameterGeneral;

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
final public class CiudadConstantesFunciones extends CiudadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Ciudad";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Ciudad"+CiudadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CiudadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CiudadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CiudadConstantesFunciones.SCHEMA+"_"+CiudadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CiudadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CiudadConstantesFunciones.SCHEMA+"_"+CiudadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CiudadConstantesFunciones.SCHEMA+"_"+CiudadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CiudadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CiudadConstantesFunciones.SCHEMA+"_"+CiudadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CiudadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CiudadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CiudadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CiudadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CiudadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CiudadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CiudadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CiudadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CiudadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CiudadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ciudades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ciudad";
	public static final String SCLASSWEBTITULO_LOWER="Ciudad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Ciudad";
	public static final String OBJECTNAME="ciudad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="ciudad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ciudad from "+CiudadConstantesFunciones.SPERSISTENCENAME+" ciudad";
	public static String QUERYSELECTNATIVE="select "+CiudadConstantesFunciones.SCHEMA+"."+CiudadConstantesFunciones.TABLENAME+".id,"+CiudadConstantesFunciones.SCHEMA+"."+CiudadConstantesFunciones.TABLENAME+".version_row,"+CiudadConstantesFunciones.SCHEMA+"."+CiudadConstantesFunciones.TABLENAME+".id_pais,"+CiudadConstantesFunciones.SCHEMA+"."+CiudadConstantesFunciones.TABLENAME+".id_provincia,"+CiudadConstantesFunciones.SCHEMA+"."+CiudadConstantesFunciones.TABLENAME+".codigo,"+CiudadConstantesFunciones.SCHEMA+"."+CiudadConstantesFunciones.TABLENAME+".nombre from "+CiudadConstantesFunciones.SCHEMA+"."+CiudadConstantesFunciones.TABLENAME;//+" as "+CiudadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CiudadConstantesFuncionesAdditional ciudadConstantesFuncionesAdditional=null;
	
	public CiudadConstantesFuncionesAdditional getCiudadConstantesFuncionesAdditional() {
		return this.ciudadConstantesFuncionesAdditional;
	}
	
	public void setCiudadConstantesFuncionesAdditional(CiudadConstantesFuncionesAdditional ciudadConstantesFuncionesAdditional) {
		try {
			this.ciudadConstantesFuncionesAdditional=ciudadConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCiudadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CiudadConstantesFunciones.IDPAIS)) {sLabelColumna=CiudadConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(CiudadConstantesFunciones.IDPROVINCIA)) {sLabelColumna=CiudadConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(CiudadConstantesFunciones.CODIGO)) {sLabelColumna=CiudadConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CiudadConstantesFunciones.NOMBRE)) {sLabelColumna=CiudadConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ciudad !=null/* && ciudad.getId()!=0*/) {
			sDescripcion=ciudad.getnombre();//ciudadciudad.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCiudadDescripcionDetallado(Ciudad ciudad) {
		String sDescripcion="";
			
		sDescripcion+=CiudadConstantesFunciones.ID+"=";
		sDescripcion+=ciudad.getId().toString()+",";
		sDescripcion+=CiudadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ciudad.getVersionRow().toString()+",";
		sDescripcion+=CiudadConstantesFunciones.IDPAIS+"=";
		sDescripcion+=ciudad.getid_pais().toString()+",";
		sDescripcion+=CiudadConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=ciudad.getid_provincia().toString()+",";
		sDescripcion+=CiudadConstantesFunciones.CODIGO+"=";
		sDescripcion+=ciudad.getcodigo()+",";
		sDescripcion+=CiudadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=ciudad.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setCiudadDescripcion(Ciudad ciudad,String sValor) throws Exception {			
		if(ciudad !=null) {
			ciudad.setnombre(sValor);;//ciudadciudad.getnombre().trim();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
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
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		} else if(sNombreIndice.equals("PorIdPaisPorNombre")) {
			sNombreIndice="Tipo=  Por Pais Por Nombre";
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

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPaisPorNombre(Long id_pais,String nombre) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();}
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCiudad(Ciudad ciudad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ciudad.setcodigo(ciudad.getcodigo().trim());
		ciudad.setnombre(ciudad.getnombre().trim());
	}
	
	public static void quitarEspaciosCiudads(List<Ciudad> ciudads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Ciudad ciudad: ciudads) {
			ciudad.setcodigo(ciudad.getcodigo().trim());
			ciudad.setnombre(ciudad.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCiudad(Ciudad ciudad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ciudad.getConCambioAuxiliar()) {
			ciudad.setIsDeleted(ciudad.getIsDeletedAuxiliar());	
			ciudad.setIsNew(ciudad.getIsNewAuxiliar());	
			ciudad.setIsChanged(ciudad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ciudad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ciudad.setIsDeletedAuxiliar(false);	
			ciudad.setIsNewAuxiliar(false);	
			ciudad.setIsChangedAuxiliar(false);
			
			ciudad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCiudads(List<Ciudad> ciudads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Ciudad ciudad : ciudads) {
			if(conAsignarBase && ciudad.getConCambioAuxiliar()) {
				ciudad.setIsDeleted(ciudad.getIsDeletedAuxiliar());	
				ciudad.setIsNew(ciudad.getIsNewAuxiliar());	
				ciudad.setIsChanged(ciudad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ciudad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ciudad.setIsDeletedAuxiliar(false);	
				ciudad.setIsNewAuxiliar(false);	
				ciudad.setIsChangedAuxiliar(false);
				
				ciudad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCiudad(Ciudad ciudad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCiudads(List<Ciudad> ciudads,Boolean conEnteros) throws Exception  {
		
		for(Ciudad ciudad: ciudads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCiudad(List<Ciudad> ciudads,Ciudad ciudadAux) throws Exception  {
		CiudadConstantesFunciones.InicializarValoresCiudad(ciudadAux,true);
		
		for(Ciudad ciudad: ciudads) {
			if(ciudad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCiudad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CiudadConstantesFunciones.getArrayColumnasGlobalesCiudad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCiudad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCiudad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Ciudad> ciudads,Ciudad ciudad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Ciudad ciudadAux: ciudads) {
			if(ciudadAux!=null && ciudad!=null) {
				if((ciudadAux.getId()==null && ciudad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ciudadAux.getId()!=null && ciudad.getId()!=null){
					if(ciudadAux.getId().equals(ciudad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCiudad(List<Ciudad> ciudads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Ciudad ciudad: ciudads) {			
			if(ciudad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCiudad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CiudadConstantesFunciones.LABEL_ID, CiudadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CiudadConstantesFunciones.LABEL_VERSIONROW, CiudadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CiudadConstantesFunciones.LABEL_IDPAIS, CiudadConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CiudadConstantesFunciones.LABEL_IDPROVINCIA, CiudadConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CiudadConstantesFunciones.LABEL_CODIGO, CiudadConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CiudadConstantesFunciones.LABEL_NOMBRE, CiudadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCiudad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CiudadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CiudadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CiudadConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CiudadConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CiudadConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CiudadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCiudad() throws Exception  {
		return CiudadConstantesFunciones.getTiposSeleccionarCiudad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCiudad(Boolean conFk) throws Exception  {
		return CiudadConstantesFunciones.getTiposSeleccionarCiudad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCiudad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CiudadConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(CiudadConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CiudadConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(CiudadConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CiudadConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CiudadConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CiudadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CiudadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCiudad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCiudad(Ciudad ciudadAux) throws Exception {
		
			ciudadAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(ciudadAux.getPais()));
			ciudadAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(ciudadAux.getProvincia()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCiudad(List<Ciudad> ciudadsTemp) throws Exception {
		for(Ciudad ciudadAux:ciudadsTemp) {
			
			ciudadAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(ciudadAux.getPais()));
			ciudadAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(ciudadAux.getProvincia()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCiudad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Provincia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCiudad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCiudad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CiudadConstantesFunciones.getClassesRelationshipsOfCiudad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCiudad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCiudad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CiudadConstantesFunciones.getClassesRelationshipsFromStringsOfCiudad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCiudad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Ciudad ciudad,List<Ciudad> ciudads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Ciudad ciudadEncontrado=null;
			
			for(Ciudad ciudadLocal:ciudads) {
				if(ciudadLocal.getId().equals(ciudad.getId())) {
					ciudadEncontrado=ciudadLocal;
					
					ciudadLocal.setIsChanged(ciudad.getIsChanged());
					ciudadLocal.setIsNew(ciudad.getIsNew());
					ciudadLocal.setIsDeleted(ciudad.getIsDeleted());
					
					ciudadLocal.setGeneralEntityOriginal(ciudad.getGeneralEntityOriginal());
					
					ciudadLocal.setId(ciudad.getId());	
					ciudadLocal.setVersionRow(ciudad.getVersionRow());	
					ciudadLocal.setid_pais(ciudad.getid_pais());	
					ciudadLocal.setid_provincia(ciudad.getid_provincia());	
					ciudadLocal.setcodigo(ciudad.getcodigo());	
					ciudadLocal.setnombre(ciudad.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!ciudad.getIsDeleted()) {
				if(!existe) {
					ciudads.add(ciudad);
				}
			} else {
				if(ciudadEncontrado!=null && permiteQuitar)  {
					ciudads.remove(ciudadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Ciudad ciudad,List<Ciudad> ciudads) throws Exception {
		try	{			
			for(Ciudad ciudadLocal:ciudads) {
				if(ciudadLocal.getId().equals(ciudad.getId())) {
					ciudadLocal.setIsSelected(ciudad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCiudad(List<Ciudad> ciudadsAux) throws Exception {
		//this.ciudadsAux=ciudadsAux;
		
		for(Ciudad ciudadAux:ciudadsAux) {
			if(ciudadAux.getIsChanged()) {
				ciudadAux.setIsChanged(false);
			}		
			
			if(ciudadAux.getIsNew()) {
				ciudadAux.setIsNew(false);
			}	
			
			if(ciudadAux.getIsDeleted()) {
				ciudadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCiudad(Ciudad ciudadAux) throws Exception {
		//this.ciudadAux=ciudadAux;
		
			if(ciudadAux.getIsChanged()) {
				ciudadAux.setIsChanged(false);
			}		
			
			if(ciudadAux.getIsNew()) {
				ciudadAux.setIsNew(false);
			}	
			
			if(ciudadAux.getIsDeleted()) {
				ciudadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Ciudad ciudadAsignar,Ciudad ciudad) throws Exception {
		ciudadAsignar.setId(ciudad.getId());	
		ciudadAsignar.setVersionRow(ciudad.getVersionRow());	
		ciudadAsignar.setid_pais(ciudad.getid_pais());
		ciudadAsignar.setpais_descripcion(ciudad.getpais_descripcion());	
		ciudadAsignar.setid_provincia(ciudad.getid_provincia());
		ciudadAsignar.setprovincia_descripcion(ciudad.getprovincia_descripcion());	
		ciudadAsignar.setcodigo(ciudad.getcodigo());	
		ciudadAsignar.setnombre(ciudad.getnombre());	
	}
	
	public static void inicializarCiudad(Ciudad ciudad) throws Exception {
		try {
				ciudad.setId(0L);	
					
				ciudad.setid_pais(-1L);	
				ciudad.setid_provincia(null);	
				ciudad.setcodigo("");	
				ciudad.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCiudad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CiudadConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CiudadConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CiudadConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CiudadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCiudad(String sTipo,Row row,Workbook workbook,Ciudad ciudad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ciudad.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ciudad.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ciudad.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ciudad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCiudad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCiudad() {
		return this.sFinalQueryCiudad;
	}
	
	public void setsFinalQueryCiudad(String sFinalQueryCiudad) {
		this.sFinalQueryCiudad= sFinalQueryCiudad;
	}
	
	public Border resaltarSeleccionarCiudad=null;
	
	public Border setResaltarSeleccionarCiudad(ParametroGeneralUsuario parametroGeneralUsuario/*CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ciudadBeanSwingJInternalFrame.jTtoolBarCiudad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCiudad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCiudad() {
		return this.resaltarSeleccionarCiudad;
	}
	
	public void setResaltarSeleccionarCiudad(Border borderResaltarSeleccionarCiudad) {
		this.resaltarSeleccionarCiudad= borderResaltarSeleccionarCiudad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCiudad=null;
	public Boolean mostraridCiudad=true;
	public Boolean activaridCiudad=true;

	public Border resaltarid_paisCiudad=null;
	public Boolean mostrarid_paisCiudad=true;
	public Boolean activarid_paisCiudad=true;
	public Boolean cargarid_paisCiudad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisCiudad=false;//ConEventDepend=true

	public Border resaltarid_provinciaCiudad=null;
	public Boolean mostrarid_provinciaCiudad=true;
	public Boolean activarid_provinciaCiudad=true;
	public Boolean cargarid_provinciaCiudad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaCiudad=true;//ConEventDepend=true

	public Border resaltarcodigoCiudad=null;
	public Boolean mostrarcodigoCiudad=true;
	public Boolean activarcodigoCiudad=true;

	public Border resaltarnombreCiudad=null;
	public Boolean mostrarnombreCiudad=true;
	public Boolean activarnombreCiudad=true;

	
	

	public Border setResaltaridCiudad(ParametroGeneralUsuario parametroGeneralUsuario/*CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ciudadBeanSwingJInternalFrame.jTtoolBarCiudad.setBorder(borderResaltar);
		
		this.resaltaridCiudad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCiudad() {
		return this.resaltaridCiudad;
	}

	public void setResaltaridCiudad(Border borderResaltar) {
		this.resaltaridCiudad= borderResaltar;
	}

	public Boolean getMostraridCiudad() {
		return this.mostraridCiudad;
	}

	public void setMostraridCiudad(Boolean mostraridCiudad) {
		this.mostraridCiudad= mostraridCiudad;
	}

	public Boolean getActivaridCiudad() {
		return this.activaridCiudad;
	}

	public void setActivaridCiudad(Boolean activaridCiudad) {
		this.activaridCiudad= activaridCiudad;
	}

	public Border setResaltarid_paisCiudad(ParametroGeneralUsuario parametroGeneralUsuario/*CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ciudadBeanSwingJInternalFrame.jTtoolBarCiudad.setBorder(borderResaltar);
		
		this.resaltarid_paisCiudad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisCiudad() {
		return this.resaltarid_paisCiudad;
	}

	public void setResaltarid_paisCiudad(Border borderResaltar) {
		this.resaltarid_paisCiudad= borderResaltar;
	}

	public Boolean getMostrarid_paisCiudad() {
		return this.mostrarid_paisCiudad;
	}

	public void setMostrarid_paisCiudad(Boolean mostrarid_paisCiudad) {
		this.mostrarid_paisCiudad= mostrarid_paisCiudad;
	}

	public Boolean getActivarid_paisCiudad() {
		return this.activarid_paisCiudad;
	}

	public void setActivarid_paisCiudad(Boolean activarid_paisCiudad) {
		this.activarid_paisCiudad= activarid_paisCiudad;
	}

	public Boolean getCargarid_paisCiudad() {
		return this.cargarid_paisCiudad;
	}

	public void setCargarid_paisCiudad(Boolean cargarid_paisCiudad) {
		this.cargarid_paisCiudad= cargarid_paisCiudad;
	}

	public Border setResaltarid_provinciaCiudad(ParametroGeneralUsuario parametroGeneralUsuario/*CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ciudadBeanSwingJInternalFrame.jTtoolBarCiudad.setBorder(borderResaltar);
		
		this.resaltarid_provinciaCiudad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaCiudad() {
		return this.resaltarid_provinciaCiudad;
	}

	public void setResaltarid_provinciaCiudad(Border borderResaltar) {
		this.resaltarid_provinciaCiudad= borderResaltar;
	}

	public Boolean getMostrarid_provinciaCiudad() {
		return this.mostrarid_provinciaCiudad;
	}

	public void setMostrarid_provinciaCiudad(Boolean mostrarid_provinciaCiudad) {
		this.mostrarid_provinciaCiudad= mostrarid_provinciaCiudad;
	}

	public Boolean getActivarid_provinciaCiudad() {
		return this.activarid_provinciaCiudad;
	}

	public void setActivarid_provinciaCiudad(Boolean activarid_provinciaCiudad) {
		this.activarid_provinciaCiudad= activarid_provinciaCiudad;
	}

	public Boolean getCargarid_provinciaCiudad() {
		return this.cargarid_provinciaCiudad;
	}

	public void setCargarid_provinciaCiudad(Boolean cargarid_provinciaCiudad) {
		this.cargarid_provinciaCiudad= cargarid_provinciaCiudad;
	}

	public Border setResaltarcodigoCiudad(ParametroGeneralUsuario parametroGeneralUsuario/*CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ciudadBeanSwingJInternalFrame.jTtoolBarCiudad.setBorder(borderResaltar);
		
		this.resaltarcodigoCiudad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCiudad() {
		return this.resaltarcodigoCiudad;
	}

	public void setResaltarcodigoCiudad(Border borderResaltar) {
		this.resaltarcodigoCiudad= borderResaltar;
	}

	public Boolean getMostrarcodigoCiudad() {
		return this.mostrarcodigoCiudad;
	}

	public void setMostrarcodigoCiudad(Boolean mostrarcodigoCiudad) {
		this.mostrarcodigoCiudad= mostrarcodigoCiudad;
	}

	public Boolean getActivarcodigoCiudad() {
		return this.activarcodigoCiudad;
	}

	public void setActivarcodigoCiudad(Boolean activarcodigoCiudad) {
		this.activarcodigoCiudad= activarcodigoCiudad;
	}

	public Border setResaltarnombreCiudad(ParametroGeneralUsuario parametroGeneralUsuario/*CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ciudadBeanSwingJInternalFrame.jTtoolBarCiudad.setBorder(borderResaltar);
		
		this.resaltarnombreCiudad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCiudad() {
		return this.resaltarnombreCiudad;
	}

	public void setResaltarnombreCiudad(Border borderResaltar) {
		this.resaltarnombreCiudad= borderResaltar;
	}

	public Boolean getMostrarnombreCiudad() {
		return this.mostrarnombreCiudad;
	}

	public void setMostrarnombreCiudad(Boolean mostrarnombreCiudad) {
		this.mostrarnombreCiudad= mostrarnombreCiudad;
	}

	public Boolean getActivarnombreCiudad() {
		return this.activarnombreCiudad;
	}

	public void setActivarnombreCiudad(Boolean activarnombreCiudad) {
		this.activarnombreCiudad= activarnombreCiudad;
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
		
		
		this.setMostraridCiudad(esInicial);
		this.setMostrarid_paisCiudad(esInicial);
		this.setMostrarid_provinciaCiudad(esInicial);
		this.setMostrarcodigoCiudad(esInicial);
		this.setMostrarnombreCiudad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CiudadConstantesFunciones.ID)) {
				this.setMostraridCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCiudad(esAsigna);
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
		
		
		this.setActivaridCiudad(esInicial);
		this.setActivarid_paisCiudad(esInicial);
		this.setActivarid_provinciaCiudad(esInicial);
		this.setActivarcodigoCiudad(esInicial);
		this.setActivarnombreCiudad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CiudadConstantesFunciones.ID)) {
				this.setActivaridCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCiudad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCiudad(esInicial);
		this.setResaltarid_paisCiudad(esInicial);
		this.setResaltarid_provinciaCiudad(esInicial);
		this.setResaltarcodigoCiudad(esInicial);
		this.setResaltarnombreCiudad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CiudadConstantesFunciones.ID)) {
				this.setResaltaridCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCiudad(esAsigna);
				continue;
			}

			if(campo.clase.equals(CiudadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCiudad(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreCiudad=true;

	public Boolean getMostrarBusquedaPorNombreCiudad() {
		return this.mostrarBusquedaPorNombreCiudad;
	}

	public void setMostrarBusquedaPorNombreCiudad(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreCiudad= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisCiudad=true;

	public Boolean getMostrarFK_IdPaisCiudad() {
		return this.mostrarFK_IdPaisCiudad;
	}

	public void setMostrarFK_IdPaisCiudad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisCiudad= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreCiudad=true;

	public Boolean getActivarBusquedaPorNombreCiudad() {
		return this.activarBusquedaPorNombreCiudad;
	}

	public void setActivarBusquedaPorNombreCiudad(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreCiudad= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisCiudad=true;

	public Boolean getActivarFK_IdPaisCiudad() {
		return this.activarFK_IdPaisCiudad;
	}

	public void setActivarFK_IdPaisCiudad(Boolean habilitarResaltar) {
		this.activarFK_IdPaisCiudad= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreCiudad=null;

	public Border getResaltarBusquedaPorNombreCiudad() {
		return this.resaltarBusquedaPorNombreCiudad;
	}

	public void setResaltarBusquedaPorNombreCiudad(Border borderResaltar) {
		this.resaltarBusquedaPorNombreCiudad= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreCiudad(ParametroGeneralUsuario parametroGeneralUsuario/*CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreCiudad= borderResaltar;
	}

	public Border resaltarFK_IdPaisCiudad=null;

	public Border getResaltarFK_IdPaisCiudad() {
		return this.resaltarFK_IdPaisCiudad;
	}

	public void setResaltarFK_IdPaisCiudad(Border borderResaltar) {
		this.resaltarFK_IdPaisCiudad= borderResaltar;
	}

	public void setResaltarFK_IdPaisCiudad(ParametroGeneralUsuario parametroGeneralUsuario/*CiudadBeanSwingJInternalFrame ciudadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisCiudad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}