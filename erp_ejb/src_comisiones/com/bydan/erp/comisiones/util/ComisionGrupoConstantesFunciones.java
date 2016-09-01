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
package com.bydan.erp.comisiones.util;

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


import com.bydan.erp.comisiones.util.ComisionGrupoConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionGrupoParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionGrupoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.comisiones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.comisiones.business.dataaccess.*;
//import com.bydan.erp.comisiones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComisionGrupoConstantesFunciones extends ComisionGrupoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ComisionGrupo";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComisionGrupo"+ComisionGrupoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComisionGrupoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComisionGrupoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComisionGrupoConstantesFunciones.SCHEMA+"_"+ComisionGrupoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComisionGrupoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComisionGrupoConstantesFunciones.SCHEMA+"_"+ComisionGrupoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComisionGrupoConstantesFunciones.SCHEMA+"_"+ComisionGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComisionGrupoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComisionGrupoConstantesFunciones.SCHEMA+"_"+ComisionGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionGrupoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionGrupoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionGrupoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComisionGrupoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComisionGrupoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComisionGrupoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComisionGrupoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comision Grupos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comision Grupo";
	public static final String SCLASSWEBTITULO_LOWER="Comision Grupo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComisionGrupo";
	public static final String OBJECTNAME="comisiongrupo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="comision_grupo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comisiongrupo from "+ComisionGrupoConstantesFunciones.SPERSISTENCENAME+" comisiongrupo";
	public static String QUERYSELECTNATIVE="select "+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".id,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".version_row,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".id_empresa,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".id_comision_config,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".id_vendedor,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".id_linea,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".id_linea_grupo,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".id_estado_comision,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".porcentaje,"+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME+".descripcion from "+ComisionGrupoConstantesFunciones.SCHEMA+"."+ComisionGrupoConstantesFunciones.TABLENAME;//+" as "+ComisionGrupoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ComisionGrupoConstantesFuncionesAdditional comisiongrupoConstantesFuncionesAdditional=null;
	
	public ComisionGrupoConstantesFuncionesAdditional getComisionGrupoConstantesFuncionesAdditional() {
		return this.comisiongrupoConstantesFuncionesAdditional;
	}
	
	public void setComisionGrupoConstantesFuncionesAdditional(ComisionGrupoConstantesFuncionesAdditional comisiongrupoConstantesFuncionesAdditional) {
		try {
			this.comisiongrupoConstantesFuncionesAdditional=comisiongrupoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDCOMISIONCONFIG= "id_comision_config";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDESTADOCOMISION= "id_estado_comision";
    public static final String PORCENTAJE= "porcentaje";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDCOMISIONCONFIG= "Configuracion";
		public static final String LABEL_IDCOMISIONCONFIG_LOWER= "Comision Config";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDESTADOCOMISION= "Estado";
		public static final String LABEL_IDESTADOCOMISION_LOWER= "Estado Comision";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComisionGrupoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComisionGrupoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComisionGrupoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG)) {sLabelColumna=ComisionGrupoConstantesFunciones.LABEL_IDCOMISIONCONFIG;}
		if(sNombreColumna.equals(ComisionGrupoConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ComisionGrupoConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ComisionGrupoConstantesFunciones.IDLINEA)) {sLabelColumna=ComisionGrupoConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ComisionGrupoConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ComisionGrupoConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ComisionGrupoConstantesFunciones.IDESTADOCOMISION)) {sLabelColumna=ComisionGrupoConstantesFunciones.LABEL_IDESTADOCOMISION;}
		if(sNombreColumna.equals(ComisionGrupoConstantesFunciones.PORCENTAJE)) {sLabelColumna=ComisionGrupoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ComisionGrupoConstantesFunciones.DESCRIPCION)) {sLabelColumna=ComisionGrupoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getComisionGrupoDescripcion(ComisionGrupo comisiongrupo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comisiongrupo !=null/* && comisiongrupo.getId()!=0*/) {
			if(comisiongrupo.getId()!=null) {
				sDescripcion=comisiongrupo.getId().toString();
			}//comisiongrupocomisiongrupo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComisionGrupoDescripcionDetallado(ComisionGrupo comisiongrupo) {
		String sDescripcion="";
			
		sDescripcion+=ComisionGrupoConstantesFunciones.ID+"=";
		sDescripcion+=comisiongrupo.getId().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comisiongrupo.getVersionRow().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comisiongrupo.getid_empresa().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG+"=";
		sDescripcion+=comisiongrupo.getid_comision_config().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=comisiongrupo.getid_vendedor().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.IDLINEA+"=";
		sDescripcion+=comisiongrupo.getid_linea().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=comisiongrupo.getid_linea_grupo().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.IDESTADOCOMISION+"=";
		sDescripcion+=comisiongrupo.getid_estado_comision().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=comisiongrupo.getporcentaje().toString()+",";
		sDescripcion+=ComisionGrupoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=comisiongrupo.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setComisionGrupoDescripcion(ComisionGrupo comisiongrupo,String sValor) throws Exception {			
		if(comisiongrupo !=null) {
			//comisiongrupocomisiongrupo.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getComisionConfigDescripcion(ComisionConfig comisionconfig) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(comisionconfig!=null/*&&comisionconfig.getId()>0*/) {
			sDescripcion=ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisionconfig);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getEstadoComisionDescripcion(EstadoComision estadocomision) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocomision!=null/*&&estadocomision.getId()>0*/) {
			sDescripcion=EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(estadocomision);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdComisionConfig")) {
			sNombreIndice="Tipo=  Por Configuracion";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoComision")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdComisionConfig(Long id_comision_config) {
		String sDetalleIndice=" Parametros->";
		if(id_comision_config!=null) {sDetalleIndice+=" Codigo Unico De Configuracion="+id_comision_config.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoComision(Long id_estado_comision) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_comision!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_comision.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComisionGrupo(ComisionGrupo comisiongrupo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comisiongrupo.setdescripcion(comisiongrupo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosComisionGrupos(List<ComisionGrupo> comisiongrupos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComisionGrupo comisiongrupo: comisiongrupos) {
			comisiongrupo.setdescripcion(comisiongrupo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionGrupo(ComisionGrupo comisiongrupo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comisiongrupo.getConCambioAuxiliar()) {
			comisiongrupo.setIsDeleted(comisiongrupo.getIsDeletedAuxiliar());	
			comisiongrupo.setIsNew(comisiongrupo.getIsNewAuxiliar());	
			comisiongrupo.setIsChanged(comisiongrupo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comisiongrupo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comisiongrupo.setIsDeletedAuxiliar(false);	
			comisiongrupo.setIsNewAuxiliar(false);	
			comisiongrupo.setIsChangedAuxiliar(false);
			
			comisiongrupo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionGrupos(List<ComisionGrupo> comisiongrupos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComisionGrupo comisiongrupo : comisiongrupos) {
			if(conAsignarBase && comisiongrupo.getConCambioAuxiliar()) {
				comisiongrupo.setIsDeleted(comisiongrupo.getIsDeletedAuxiliar());	
				comisiongrupo.setIsNew(comisiongrupo.getIsNewAuxiliar());	
				comisiongrupo.setIsChanged(comisiongrupo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comisiongrupo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comisiongrupo.setIsDeletedAuxiliar(false);	
				comisiongrupo.setIsNewAuxiliar(false);	
				comisiongrupo.setIsChangedAuxiliar(false);
				
				comisiongrupo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComisionGrupo(ComisionGrupo comisiongrupo,Boolean conEnteros) throws Exception  {
		comisiongrupo.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComisionGrupos(List<ComisionGrupo> comisiongrupos,Boolean conEnteros) throws Exception  {
		
		for(ComisionGrupo comisiongrupo: comisiongrupos) {
			comisiongrupo.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComisionGrupo(List<ComisionGrupo> comisiongrupos,ComisionGrupo comisiongrupoAux) throws Exception  {
		ComisionGrupoConstantesFunciones.InicializarValoresComisionGrupo(comisiongrupoAux,true);
		
		for(ComisionGrupo comisiongrupo: comisiongrupos) {
			if(comisiongrupo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comisiongrupoAux.setporcentaje(comisiongrupoAux.getporcentaje()+comisiongrupo.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionGrupo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComisionGrupoConstantesFunciones.getArrayColumnasGlobalesComisionGrupo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionGrupo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionGrupoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionGrupoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComisionGrupo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComisionGrupo> comisiongrupos,ComisionGrupo comisiongrupo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComisionGrupo comisiongrupoAux: comisiongrupos) {
			if(comisiongrupoAux!=null && comisiongrupo!=null) {
				if((comisiongrupoAux.getId()==null && comisiongrupo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comisiongrupoAux.getId()!=null && comisiongrupo.getId()!=null){
					if(comisiongrupoAux.getId().equals(comisiongrupo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComisionGrupo(List<ComisionGrupo> comisiongrupos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(ComisionGrupo comisiongrupo: comisiongrupos) {			
			if(comisiongrupo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=comisiongrupo.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionGrupoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComisionGrupo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_ID, ComisionGrupoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_VERSIONROW, ComisionGrupoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_IDEMPRESA, ComisionGrupoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_IDCOMISIONCONFIG, ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_IDVENDEDOR, ComisionGrupoConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_IDLINEA, ComisionGrupoConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_IDLINEAGRUPO, ComisionGrupoConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_IDESTADOCOMISION, ComisionGrupoConstantesFunciones.IDESTADOCOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_PORCENTAJE, ComisionGrupoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionGrupoConstantesFunciones.LABEL_DESCRIPCION, ComisionGrupoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComisionGrupo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.IDESTADOCOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionGrupoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionGrupo() throws Exception  {
		return ComisionGrupoConstantesFunciones.getTiposSeleccionarComisionGrupo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionGrupo(Boolean conFk) throws Exception  {
		return ComisionGrupoConstantesFunciones.getTiposSeleccionarComisionGrupo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionGrupo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionGrupoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionGrupoConstantesFunciones.LABEL_IDCOMISIONCONFIG);
			reporte.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_IDCOMISIONCONFIG);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionGrupoConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionGrupoConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionGrupoConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionGrupoConstantesFunciones.LABEL_IDESTADOCOMISION);
			reporte.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_IDESTADOCOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionGrupoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionGrupoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ComisionGrupoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComisionGrupo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComisionGrupo(ComisionGrupo comisiongrupoAux) throws Exception {
		
			comisiongrupoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisiongrupoAux.getEmpresa()));
			comisiongrupoAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisiongrupoAux.getComisionConfig()));
			comisiongrupoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisiongrupoAux.getVendedor()));
			comisiongrupoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisiongrupoAux.getLinea()));
			comisiongrupoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisiongrupoAux.getLineaGrupo()));
			comisiongrupoAux.setestadocomision_descripcion(EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(comisiongrupoAux.getEstadoComision()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComisionGrupo(List<ComisionGrupo> comisiongruposTemp) throws Exception {
		for(ComisionGrupo comisiongrupoAux:comisiongruposTemp) {
			
			comisiongrupoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisiongrupoAux.getEmpresa()));
			comisiongrupoAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisiongrupoAux.getComisionConfig()));
			comisiongrupoAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisiongrupoAux.getVendedor()));
			comisiongrupoAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisiongrupoAux.getLinea()));
			comisiongrupoAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisiongrupoAux.getLineaGrupo()));
			comisiongrupoAux.setestadocomision_descripcion(EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(comisiongrupoAux.getEstadoComision()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComisionGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(ComisionConfig.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(EstadoComision.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ComisionConfig.class)) {
						classes.add(new Classe(ComisionConfig.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoComision.class)) {
						classes.add(new Classe(EstadoComision.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComisionGrupo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(EstadoComision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoComision.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(ComisionConfig.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ComisionConfig.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(EstadoComision.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoComision.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionGrupoConstantesFunciones.getClassesRelationshipsOfComisionGrupo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionGrupo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionGrupo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionGrupoConstantesFunciones.getClassesRelationshipsFromStringsOfComisionGrupo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionGrupo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComisionGrupo comisiongrupo,List<ComisionGrupo> comisiongrupos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ComisionGrupo comisiongrupoEncontrado=null;
			
			for(ComisionGrupo comisiongrupoLocal:comisiongrupos) {
				if(comisiongrupoLocal.getId().equals(comisiongrupo.getId())) {
					comisiongrupoEncontrado=comisiongrupoLocal;
					
					comisiongrupoLocal.setIsChanged(comisiongrupo.getIsChanged());
					comisiongrupoLocal.setIsNew(comisiongrupo.getIsNew());
					comisiongrupoLocal.setIsDeleted(comisiongrupo.getIsDeleted());
					
					comisiongrupoLocal.setGeneralEntityOriginal(comisiongrupo.getGeneralEntityOriginal());
					
					comisiongrupoLocal.setId(comisiongrupo.getId());	
					comisiongrupoLocal.setVersionRow(comisiongrupo.getVersionRow());	
					comisiongrupoLocal.setid_empresa(comisiongrupo.getid_empresa());	
					comisiongrupoLocal.setid_comision_config(comisiongrupo.getid_comision_config());	
					comisiongrupoLocal.setid_vendedor(comisiongrupo.getid_vendedor());	
					comisiongrupoLocal.setid_linea(comisiongrupo.getid_linea());	
					comisiongrupoLocal.setid_linea_grupo(comisiongrupo.getid_linea_grupo());	
					comisiongrupoLocal.setid_estado_comision(comisiongrupo.getid_estado_comision());	
					comisiongrupoLocal.setporcentaje(comisiongrupo.getporcentaje());	
					comisiongrupoLocal.setdescripcion(comisiongrupo.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!comisiongrupo.getIsDeleted()) {
				if(!existe) {
					comisiongrupos.add(comisiongrupo);
				}
			} else {
				if(comisiongrupoEncontrado!=null && permiteQuitar)  {
					comisiongrupos.remove(comisiongrupoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ComisionGrupo comisiongrupo,List<ComisionGrupo> comisiongrupos) throws Exception {
		try	{			
			for(ComisionGrupo comisiongrupoLocal:comisiongrupos) {
				if(comisiongrupoLocal.getId().equals(comisiongrupo.getId())) {
					comisiongrupoLocal.setIsSelected(comisiongrupo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComisionGrupo(List<ComisionGrupo> comisiongruposAux) throws Exception {
		//this.comisiongruposAux=comisiongruposAux;
		
		for(ComisionGrupo comisiongrupoAux:comisiongruposAux) {
			if(comisiongrupoAux.getIsChanged()) {
				comisiongrupoAux.setIsChanged(false);
			}		
			
			if(comisiongrupoAux.getIsNew()) {
				comisiongrupoAux.setIsNew(false);
			}	
			
			if(comisiongrupoAux.getIsDeleted()) {
				comisiongrupoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComisionGrupo(ComisionGrupo comisiongrupoAux) throws Exception {
		//this.comisiongrupoAux=comisiongrupoAux;
		
			if(comisiongrupoAux.getIsChanged()) {
				comisiongrupoAux.setIsChanged(false);
			}		
			
			if(comisiongrupoAux.getIsNew()) {
				comisiongrupoAux.setIsNew(false);
			}	
			
			if(comisiongrupoAux.getIsDeleted()) {
				comisiongrupoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComisionGrupo comisiongrupoAsignar,ComisionGrupo comisiongrupo) throws Exception {
		comisiongrupoAsignar.setId(comisiongrupo.getId());	
		comisiongrupoAsignar.setVersionRow(comisiongrupo.getVersionRow());	
		comisiongrupoAsignar.setid_empresa(comisiongrupo.getid_empresa());
		comisiongrupoAsignar.setempresa_descripcion(comisiongrupo.getempresa_descripcion());	
		comisiongrupoAsignar.setid_comision_config(comisiongrupo.getid_comision_config());
		comisiongrupoAsignar.setcomisionconfig_descripcion(comisiongrupo.getcomisionconfig_descripcion());	
		comisiongrupoAsignar.setid_vendedor(comisiongrupo.getid_vendedor());
		comisiongrupoAsignar.setvendedor_descripcion(comisiongrupo.getvendedor_descripcion());	
		comisiongrupoAsignar.setid_linea(comisiongrupo.getid_linea());
		comisiongrupoAsignar.setlinea_descripcion(comisiongrupo.getlinea_descripcion());	
		comisiongrupoAsignar.setid_linea_grupo(comisiongrupo.getid_linea_grupo());
		comisiongrupoAsignar.setlineagrupo_descripcion(comisiongrupo.getlineagrupo_descripcion());	
		comisiongrupoAsignar.setid_estado_comision(comisiongrupo.getid_estado_comision());
		comisiongrupoAsignar.setestadocomision_descripcion(comisiongrupo.getestadocomision_descripcion());	
		comisiongrupoAsignar.setporcentaje(comisiongrupo.getporcentaje());	
		comisiongrupoAsignar.setdescripcion(comisiongrupo.getdescripcion());	
	}
	
	public static void inicializarComisionGrupo(ComisionGrupo comisiongrupo) throws Exception {
		try {
				comisiongrupo.setId(0L);	
					
				comisiongrupo.setid_empresa(-1L);	
				comisiongrupo.setid_comision_config(-1L);	
				comisiongrupo.setid_vendedor(-1L);	
				comisiongrupo.setid_linea(-1L);	
				comisiongrupo.setid_linea_grupo(-1L);	
				comisiongrupo.setid_estado_comision(-1L);	
				comisiongrupo.setporcentaje(0.0);	
				comisiongrupo.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComisionGrupo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionGrupoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionGrupoConstantesFunciones.LABEL_IDCOMISIONCONFIG);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionGrupoConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionGrupoConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionGrupoConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionGrupoConstantesFunciones.LABEL_IDESTADOCOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionGrupoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionGrupoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComisionGrupo(String sTipo,Row row,Workbook workbook,ComisionGrupo comisiongrupo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiongrupo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiongrupo.getcomisionconfig_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiongrupo.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiongrupo.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiongrupo.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiongrupo.getestadocomision_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiongrupo.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisiongrupo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComisionGrupo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryComisionGrupo() {
		return this.sFinalQueryComisionGrupo;
	}
	
	public void setsFinalQueryComisionGrupo(String sFinalQueryComisionGrupo) {
		this.sFinalQueryComisionGrupo= sFinalQueryComisionGrupo;
	}
	
	public Border resaltarSeleccionarComisionGrupo=null;
	
	public Border setResaltarSeleccionarComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComisionGrupo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComisionGrupo() {
		return this.resaltarSeleccionarComisionGrupo;
	}
	
	public void setResaltarSeleccionarComisionGrupo(Border borderResaltarSeleccionarComisionGrupo) {
		this.resaltarSeleccionarComisionGrupo= borderResaltarSeleccionarComisionGrupo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComisionGrupo=null;
	public Boolean mostraridComisionGrupo=true;
	public Boolean activaridComisionGrupo=true;

	public Border resaltarid_empresaComisionGrupo=null;
	public Boolean mostrarid_empresaComisionGrupo=true;
	public Boolean activarid_empresaComisionGrupo=true;
	public Boolean cargarid_empresaComisionGrupo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComisionGrupo=false;//ConEventDepend=true

	public Border resaltarid_comision_configComisionGrupo=null;
	public Boolean mostrarid_comision_configComisionGrupo=true;
	public Boolean activarid_comision_configComisionGrupo=true;
	public Boolean cargarid_comision_configComisionGrupo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_comision_configComisionGrupo=false;//ConEventDepend=true

	public Border resaltarid_vendedorComisionGrupo=null;
	public Boolean mostrarid_vendedorComisionGrupo=true;
	public Boolean activarid_vendedorComisionGrupo=true;
	public Boolean cargarid_vendedorComisionGrupo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorComisionGrupo=false;//ConEventDepend=true

	public Border resaltarid_lineaComisionGrupo=null;
	public Boolean mostrarid_lineaComisionGrupo=true;
	public Boolean activarid_lineaComisionGrupo=true;
	public Boolean cargarid_lineaComisionGrupo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaComisionGrupo=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoComisionGrupo=null;
	public Boolean mostrarid_linea_grupoComisionGrupo=true;
	public Boolean activarid_linea_grupoComisionGrupo=true;
	public Boolean cargarid_linea_grupoComisionGrupo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoComisionGrupo=true;//ConEventDepend=true

	public Border resaltarid_estado_comisionComisionGrupo=null;
	public Boolean mostrarid_estado_comisionComisionGrupo=true;
	public Boolean activarid_estado_comisionComisionGrupo=true;
	public Boolean cargarid_estado_comisionComisionGrupo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_comisionComisionGrupo=false;//ConEventDepend=true

	public Border resaltarporcentajeComisionGrupo=null;
	public Boolean mostrarporcentajeComisionGrupo=true;
	public Boolean activarporcentajeComisionGrupo=true;

	public Border resaltardescripcionComisionGrupo=null;
	public Boolean mostrardescripcionComisionGrupo=true;
	public Boolean activardescripcionComisionGrupo=true;

	
	

	public Border setResaltaridComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltaridComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComisionGrupo() {
		return this.resaltaridComisionGrupo;
	}

	public void setResaltaridComisionGrupo(Border borderResaltar) {
		this.resaltaridComisionGrupo= borderResaltar;
	}

	public Boolean getMostraridComisionGrupo() {
		return this.mostraridComisionGrupo;
	}

	public void setMostraridComisionGrupo(Boolean mostraridComisionGrupo) {
		this.mostraridComisionGrupo= mostraridComisionGrupo;
	}

	public Boolean getActivaridComisionGrupo() {
		return this.activaridComisionGrupo;
	}

	public void setActivaridComisionGrupo(Boolean activaridComisionGrupo) {
		this.activaridComisionGrupo= activaridComisionGrupo;
	}

	public Border setResaltarid_empresaComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltarid_empresaComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComisionGrupo() {
		return this.resaltarid_empresaComisionGrupo;
	}

	public void setResaltarid_empresaComisionGrupo(Border borderResaltar) {
		this.resaltarid_empresaComisionGrupo= borderResaltar;
	}

	public Boolean getMostrarid_empresaComisionGrupo() {
		return this.mostrarid_empresaComisionGrupo;
	}

	public void setMostrarid_empresaComisionGrupo(Boolean mostrarid_empresaComisionGrupo) {
		this.mostrarid_empresaComisionGrupo= mostrarid_empresaComisionGrupo;
	}

	public Boolean getActivarid_empresaComisionGrupo() {
		return this.activarid_empresaComisionGrupo;
	}

	public void setActivarid_empresaComisionGrupo(Boolean activarid_empresaComisionGrupo) {
		this.activarid_empresaComisionGrupo= activarid_empresaComisionGrupo;
	}

	public Boolean getCargarid_empresaComisionGrupo() {
		return this.cargarid_empresaComisionGrupo;
	}

	public void setCargarid_empresaComisionGrupo(Boolean cargarid_empresaComisionGrupo) {
		this.cargarid_empresaComisionGrupo= cargarid_empresaComisionGrupo;
	}

	public Border setResaltarid_comision_configComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltarid_comision_configComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_comision_configComisionGrupo() {
		return this.resaltarid_comision_configComisionGrupo;
	}

	public void setResaltarid_comision_configComisionGrupo(Border borderResaltar) {
		this.resaltarid_comision_configComisionGrupo= borderResaltar;
	}

	public Boolean getMostrarid_comision_configComisionGrupo() {
		return this.mostrarid_comision_configComisionGrupo;
	}

	public void setMostrarid_comision_configComisionGrupo(Boolean mostrarid_comision_configComisionGrupo) {
		this.mostrarid_comision_configComisionGrupo= mostrarid_comision_configComisionGrupo;
	}

	public Boolean getActivarid_comision_configComisionGrupo() {
		return this.activarid_comision_configComisionGrupo;
	}

	public void setActivarid_comision_configComisionGrupo(Boolean activarid_comision_configComisionGrupo) {
		this.activarid_comision_configComisionGrupo= activarid_comision_configComisionGrupo;
	}

	public Boolean getCargarid_comision_configComisionGrupo() {
		return this.cargarid_comision_configComisionGrupo;
	}

	public void setCargarid_comision_configComisionGrupo(Boolean cargarid_comision_configComisionGrupo) {
		this.cargarid_comision_configComisionGrupo= cargarid_comision_configComisionGrupo;
	}

	public Border setResaltarid_vendedorComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltarid_vendedorComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorComisionGrupo() {
		return this.resaltarid_vendedorComisionGrupo;
	}

	public void setResaltarid_vendedorComisionGrupo(Border borderResaltar) {
		this.resaltarid_vendedorComisionGrupo= borderResaltar;
	}

	public Boolean getMostrarid_vendedorComisionGrupo() {
		return this.mostrarid_vendedorComisionGrupo;
	}

	public void setMostrarid_vendedorComisionGrupo(Boolean mostrarid_vendedorComisionGrupo) {
		this.mostrarid_vendedorComisionGrupo= mostrarid_vendedorComisionGrupo;
	}

	public Boolean getActivarid_vendedorComisionGrupo() {
		return this.activarid_vendedorComisionGrupo;
	}

	public void setActivarid_vendedorComisionGrupo(Boolean activarid_vendedorComisionGrupo) {
		this.activarid_vendedorComisionGrupo= activarid_vendedorComisionGrupo;
	}

	public Boolean getCargarid_vendedorComisionGrupo() {
		return this.cargarid_vendedorComisionGrupo;
	}

	public void setCargarid_vendedorComisionGrupo(Boolean cargarid_vendedorComisionGrupo) {
		this.cargarid_vendedorComisionGrupo= cargarid_vendedorComisionGrupo;
	}

	public Border setResaltarid_lineaComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltarid_lineaComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaComisionGrupo() {
		return this.resaltarid_lineaComisionGrupo;
	}

	public void setResaltarid_lineaComisionGrupo(Border borderResaltar) {
		this.resaltarid_lineaComisionGrupo= borderResaltar;
	}

	public Boolean getMostrarid_lineaComisionGrupo() {
		return this.mostrarid_lineaComisionGrupo;
	}

	public void setMostrarid_lineaComisionGrupo(Boolean mostrarid_lineaComisionGrupo) {
		this.mostrarid_lineaComisionGrupo= mostrarid_lineaComisionGrupo;
	}

	public Boolean getActivarid_lineaComisionGrupo() {
		return this.activarid_lineaComisionGrupo;
	}

	public void setActivarid_lineaComisionGrupo(Boolean activarid_lineaComisionGrupo) {
		this.activarid_lineaComisionGrupo= activarid_lineaComisionGrupo;
	}

	public Boolean getCargarid_lineaComisionGrupo() {
		return this.cargarid_lineaComisionGrupo;
	}

	public void setCargarid_lineaComisionGrupo(Boolean cargarid_lineaComisionGrupo) {
		this.cargarid_lineaComisionGrupo= cargarid_lineaComisionGrupo;
	}

	public Border setResaltarid_linea_grupoComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoComisionGrupo() {
		return this.resaltarid_linea_grupoComisionGrupo;
	}

	public void setResaltarid_linea_grupoComisionGrupo(Border borderResaltar) {
		this.resaltarid_linea_grupoComisionGrupo= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoComisionGrupo() {
		return this.mostrarid_linea_grupoComisionGrupo;
	}

	public void setMostrarid_linea_grupoComisionGrupo(Boolean mostrarid_linea_grupoComisionGrupo) {
		this.mostrarid_linea_grupoComisionGrupo= mostrarid_linea_grupoComisionGrupo;
	}

	public Boolean getActivarid_linea_grupoComisionGrupo() {
		return this.activarid_linea_grupoComisionGrupo;
	}

	public void setActivarid_linea_grupoComisionGrupo(Boolean activarid_linea_grupoComisionGrupo) {
		this.activarid_linea_grupoComisionGrupo= activarid_linea_grupoComisionGrupo;
	}

	public Boolean getCargarid_linea_grupoComisionGrupo() {
		return this.cargarid_linea_grupoComisionGrupo;
	}

	public void setCargarid_linea_grupoComisionGrupo(Boolean cargarid_linea_grupoComisionGrupo) {
		this.cargarid_linea_grupoComisionGrupo= cargarid_linea_grupoComisionGrupo;
	}

	public Border setResaltarid_estado_comisionComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltarid_estado_comisionComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_comisionComisionGrupo() {
		return this.resaltarid_estado_comisionComisionGrupo;
	}

	public void setResaltarid_estado_comisionComisionGrupo(Border borderResaltar) {
		this.resaltarid_estado_comisionComisionGrupo= borderResaltar;
	}

	public Boolean getMostrarid_estado_comisionComisionGrupo() {
		return this.mostrarid_estado_comisionComisionGrupo;
	}

	public void setMostrarid_estado_comisionComisionGrupo(Boolean mostrarid_estado_comisionComisionGrupo) {
		this.mostrarid_estado_comisionComisionGrupo= mostrarid_estado_comisionComisionGrupo;
	}

	public Boolean getActivarid_estado_comisionComisionGrupo() {
		return this.activarid_estado_comisionComisionGrupo;
	}

	public void setActivarid_estado_comisionComisionGrupo(Boolean activarid_estado_comisionComisionGrupo) {
		this.activarid_estado_comisionComisionGrupo= activarid_estado_comisionComisionGrupo;
	}

	public Boolean getCargarid_estado_comisionComisionGrupo() {
		return this.cargarid_estado_comisionComisionGrupo;
	}

	public void setCargarid_estado_comisionComisionGrupo(Boolean cargarid_estado_comisionComisionGrupo) {
		this.cargarid_estado_comisionComisionGrupo= cargarid_estado_comisionComisionGrupo;
	}

	public Border setResaltarporcentajeComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltarporcentajeComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeComisionGrupo() {
		return this.resaltarporcentajeComisionGrupo;
	}

	public void setResaltarporcentajeComisionGrupo(Border borderResaltar) {
		this.resaltarporcentajeComisionGrupo= borderResaltar;
	}

	public Boolean getMostrarporcentajeComisionGrupo() {
		return this.mostrarporcentajeComisionGrupo;
	}

	public void setMostrarporcentajeComisionGrupo(Boolean mostrarporcentajeComisionGrupo) {
		this.mostrarporcentajeComisionGrupo= mostrarporcentajeComisionGrupo;
	}

	public Boolean getActivarporcentajeComisionGrupo() {
		return this.activarporcentajeComisionGrupo;
	}

	public void setActivarporcentajeComisionGrupo(Boolean activarporcentajeComisionGrupo) {
		this.activarporcentajeComisionGrupo= activarporcentajeComisionGrupo;
	}

	public Border setResaltardescripcionComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisiongrupoBeanSwingJInternalFrame.jTtoolBarComisionGrupo.setBorder(borderResaltar);
		
		this.resaltardescripcionComisionGrupo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionComisionGrupo() {
		return this.resaltardescripcionComisionGrupo;
	}

	public void setResaltardescripcionComisionGrupo(Border borderResaltar) {
		this.resaltardescripcionComisionGrupo= borderResaltar;
	}

	public Boolean getMostrardescripcionComisionGrupo() {
		return this.mostrardescripcionComisionGrupo;
	}

	public void setMostrardescripcionComisionGrupo(Boolean mostrardescripcionComisionGrupo) {
		this.mostrardescripcionComisionGrupo= mostrardescripcionComisionGrupo;
	}

	public Boolean getActivardescripcionComisionGrupo() {
		return this.activardescripcionComisionGrupo;
	}

	public void setActivardescripcionComisionGrupo(Boolean activardescripcionComisionGrupo) {
		this.activardescripcionComisionGrupo= activardescripcionComisionGrupo;
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
		
		
		this.setMostraridComisionGrupo(esInicial);
		this.setMostrarid_empresaComisionGrupo(esInicial);
		this.setMostrarid_comision_configComisionGrupo(esInicial);
		this.setMostrarid_vendedorComisionGrupo(esInicial);
		this.setMostrarid_lineaComisionGrupo(esInicial);
		this.setMostrarid_linea_grupoComisionGrupo(esInicial);
		this.setMostrarid_estado_comisionComisionGrupo(esInicial);
		this.setMostrarporcentajeComisionGrupo(esInicial);
		this.setMostrardescripcionComisionGrupo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.ID)) {
				this.setMostraridComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setMostrarid_comision_configComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDESTADOCOMISION)) {
				this.setMostrarid_estado_comisionComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionComisionGrupo(esAsigna);
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
		
		
		this.setActivaridComisionGrupo(esInicial);
		this.setActivarid_empresaComisionGrupo(esInicial);
		this.setActivarid_comision_configComisionGrupo(esInicial);
		this.setActivarid_vendedorComisionGrupo(esInicial);
		this.setActivarid_lineaComisionGrupo(esInicial);
		this.setActivarid_linea_grupoComisionGrupo(esInicial);
		this.setActivarid_estado_comisionComisionGrupo(esInicial);
		this.setActivarporcentajeComisionGrupo(esInicial);
		this.setActivardescripcionComisionGrupo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.ID)) {
				this.setActivaridComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setActivarid_comision_configComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDESTADOCOMISION)) {
				this.setActivarid_estado_comisionComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionComisionGrupo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComisionGrupo(esInicial);
		this.setResaltarid_empresaComisionGrupo(esInicial);
		this.setResaltarid_comision_configComisionGrupo(esInicial);
		this.setResaltarid_vendedorComisionGrupo(esInicial);
		this.setResaltarid_lineaComisionGrupo(esInicial);
		this.setResaltarid_linea_grupoComisionGrupo(esInicial);
		this.setResaltarid_estado_comisionComisionGrupo(esInicial);
		this.setResaltarporcentajeComisionGrupo(esInicial);
		this.setResaltardescripcionComisionGrupo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.ID)) {
				this.setResaltaridComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setResaltarid_comision_configComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.IDESTADOCOMISION)) {
				this.setResaltarid_estado_comisionComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeComisionGrupo(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionGrupoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionComisionGrupo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdComisionConfigComisionGrupo=true;

	public Boolean getMostrarFK_IdComisionConfigComisionGrupo() {
		return this.mostrarFK_IdComisionConfigComisionGrupo;
	}

	public void setMostrarFK_IdComisionConfigComisionGrupo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdComisionConfigComisionGrupo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaComisionGrupo=true;

	public Boolean getMostrarFK_IdEmpresaComisionGrupo() {
		return this.mostrarFK_IdEmpresaComisionGrupo;
	}

	public void setMostrarFK_IdEmpresaComisionGrupo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaComisionGrupo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdComisionConfigComisionGrupo=true;

	public Boolean getActivarFK_IdComisionConfigComisionGrupo() {
		return this.activarFK_IdComisionConfigComisionGrupo;
	}

	public void setActivarFK_IdComisionConfigComisionGrupo(Boolean habilitarResaltar) {
		this.activarFK_IdComisionConfigComisionGrupo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaComisionGrupo=true;

	public Boolean getActivarFK_IdEmpresaComisionGrupo() {
		return this.activarFK_IdEmpresaComisionGrupo;
	}

	public void setActivarFK_IdEmpresaComisionGrupo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaComisionGrupo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdComisionConfigComisionGrupo=null;

	public Border getResaltarFK_IdComisionConfigComisionGrupo() {
		return this.resaltarFK_IdComisionConfigComisionGrupo;
	}

	public void setResaltarFK_IdComisionConfigComisionGrupo(Border borderResaltar) {
		this.resaltarFK_IdComisionConfigComisionGrupo= borderResaltar;
	}

	public void setResaltarFK_IdComisionConfigComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdComisionConfigComisionGrupo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaComisionGrupo=null;

	public Border getResaltarFK_IdEmpresaComisionGrupo() {
		return this.resaltarFK_IdEmpresaComisionGrupo;
	}

	public void setResaltarFK_IdEmpresaComisionGrupo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaComisionGrupo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaComisionGrupo(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionGrupoBeanSwingJInternalFrame comisiongrupoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaComisionGrupo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}