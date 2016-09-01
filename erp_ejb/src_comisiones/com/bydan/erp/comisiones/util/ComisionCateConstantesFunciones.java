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


import com.bydan.erp.comisiones.util.ComisionCateConstantesFunciones;
import com.bydan.erp.comisiones.util.ComisionCateParameterReturnGeneral;
//import com.bydan.erp.comisiones.util.ComisionCateParameterGeneral;

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
final public class ComisionCateConstantesFunciones extends ComisionCateConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ComisionCate";
	public static final String SPATHOPCION="Comisiones";	
	public static final String SPATHMODULO="comisiones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComisionCate"+ComisionCateConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComisionCateHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComisionCateHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComisionCateConstantesFunciones.SCHEMA+"_"+ComisionCateConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComisionCateHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComisionCateConstantesFunciones.SCHEMA+"_"+ComisionCateConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComisionCateConstantesFunciones.SCHEMA+"_"+ComisionCateConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComisionCateHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComisionCateConstantesFunciones.SCHEMA+"_"+ComisionCateConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionCateConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionCateHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionCateConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionCateConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComisionCateHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComisionCateConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComisionCateConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComisionCateConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComisionCateConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComisionCateConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comision Cates";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comision Cate";
	public static final String SCLASSWEBTITULO_LOWER="Comision Cate";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComisionCate";
	public static final String OBJECTNAME="comisioncate";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_COMISIONES;	
	public static final String TABLENAME="comision_cate";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comisioncate from "+ComisionCateConstantesFunciones.SPERSISTENCENAME+" comisioncate";
	public static String QUERYSELECTNATIVE="select "+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".id,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".version_row,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".id_empresa,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".id_comision_config,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".id_vendedor,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".id_linea,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".id_linea_grupo,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".id_linea_categoria,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".id_estado_comision,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".porcentaje,"+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME+".descripcion from "+ComisionCateConstantesFunciones.SCHEMA+"."+ComisionCateConstantesFunciones.TABLENAME;//+" as "+ComisionCateConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ComisionCateConstantesFuncionesAdditional comisioncateConstantesFuncionesAdditional=null;
	
	public ComisionCateConstantesFuncionesAdditional getComisionCateConstantesFuncionesAdditional() {
		return this.comisioncateConstantesFuncionesAdditional;
	}
	
	public void setComisionCateConstantesFuncionesAdditional(ComisionCateConstantesFuncionesAdditional comisioncateConstantesFuncionesAdditional) {
		try {
			this.comisioncateConstantesFuncionesAdditional=comisioncateConstantesFuncionesAdditional;
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
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
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
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDESTADOCOMISION= "Estado";
		public static final String LABEL_IDESTADOCOMISION_LOWER= "Estado Comision";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getComisionCateLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.IDCOMISIONCONFIG)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_IDCOMISIONCONFIG;}
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.IDLINEA)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.IDESTADOCOMISION)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_IDESTADOCOMISION;}
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.PORCENTAJE)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(ComisionCateConstantesFunciones.DESCRIPCION)) {sLabelColumna=ComisionCateConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComisionCateDescripcion(ComisionCate comisioncate) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comisioncate !=null/* && comisioncate.getId()!=0*/) {
			if(comisioncate.getId()!=null) {
				sDescripcion=comisioncate.getId().toString();
			}//comisioncatecomisioncate.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComisionCateDescripcionDetallado(ComisionCate comisioncate) {
		String sDescripcion="";
			
		sDescripcion+=ComisionCateConstantesFunciones.ID+"=";
		sDescripcion+=comisioncate.getId().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comisioncate.getVersionRow().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comisioncate.getid_empresa().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.IDCOMISIONCONFIG+"=";
		sDescripcion+=comisioncate.getid_comision_config().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=comisioncate.getid_vendedor().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.IDLINEA+"=";
		sDescripcion+=comisioncate.getid_linea().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=comisioncate.getid_linea_grupo().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=comisioncate.getid_linea_categoria().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.IDESTADOCOMISION+"=";
		sDescripcion+=comisioncate.getid_estado_comision().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=comisioncate.getporcentaje().toString()+",";
		sDescripcion+=ComisionCateConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=comisioncate.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setComisionCateDescripcion(ComisionCate comisioncate,String sValor) throws Exception {			
		if(comisioncate !=null) {
			//comisioncatecomisioncate.getId().toString();
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

	public static String getLineaCategoriaDescripcion(Linea linea) {
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
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
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

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosComisionCate(ComisionCate comisioncate,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comisioncate.setdescripcion(comisioncate.getdescripcion().trim());
	}
	
	public static void quitarEspaciosComisionCates(List<ComisionCate> comisioncates,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComisionCate comisioncate: comisioncates) {
			comisioncate.setdescripcion(comisioncate.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionCate(ComisionCate comisioncate,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comisioncate.getConCambioAuxiliar()) {
			comisioncate.setIsDeleted(comisioncate.getIsDeletedAuxiliar());	
			comisioncate.setIsNew(comisioncate.getIsNewAuxiliar());	
			comisioncate.setIsChanged(comisioncate.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comisioncate.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comisioncate.setIsDeletedAuxiliar(false);	
			comisioncate.setIsNewAuxiliar(false);	
			comisioncate.setIsChangedAuxiliar(false);
			
			comisioncate.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComisionCates(List<ComisionCate> comisioncates,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComisionCate comisioncate : comisioncates) {
			if(conAsignarBase && comisioncate.getConCambioAuxiliar()) {
				comisioncate.setIsDeleted(comisioncate.getIsDeletedAuxiliar());	
				comisioncate.setIsNew(comisioncate.getIsNewAuxiliar());	
				comisioncate.setIsChanged(comisioncate.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comisioncate.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comisioncate.setIsDeletedAuxiliar(false);	
				comisioncate.setIsNewAuxiliar(false);	
				comisioncate.setIsChangedAuxiliar(false);
				
				comisioncate.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComisionCate(ComisionCate comisioncate,Boolean conEnteros) throws Exception  {
		comisioncate.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresComisionCates(List<ComisionCate> comisioncates,Boolean conEnteros) throws Exception  {
		
		for(ComisionCate comisioncate: comisioncates) {
			comisioncate.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaComisionCate(List<ComisionCate> comisioncates,ComisionCate comisioncateAux) throws Exception  {
		ComisionCateConstantesFunciones.InicializarValoresComisionCate(comisioncateAux,true);
		
		for(ComisionCate comisioncate: comisioncates) {
			if(comisioncate.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comisioncateAux.setporcentaje(comisioncateAux.getporcentaje()+comisioncate.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionCate(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComisionCateConstantesFunciones.getArrayColumnasGlobalesComisionCate(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComisionCate(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComisionCateConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComisionCateConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComisionCate(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComisionCate> comisioncates,ComisionCate comisioncate,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComisionCate comisioncateAux: comisioncates) {
			if(comisioncateAux!=null && comisioncate!=null) {
				if((comisioncateAux.getId()==null && comisioncate.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comisioncateAux.getId()!=null && comisioncate.getId()!=null){
					if(comisioncateAux.getId().equals(comisioncate.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComisionCate(List<ComisionCate> comisioncates) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(ComisionCate comisioncate: comisioncates) {			
			if(comisioncate.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=comisioncate.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComisionCateConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(ComisionCateConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComisionCate() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_ID, ComisionCateConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_VERSIONROW, ComisionCateConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_IDEMPRESA, ComisionCateConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_IDCOMISIONCONFIG, ComisionCateConstantesFunciones.IDCOMISIONCONFIG,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_IDVENDEDOR, ComisionCateConstantesFunciones.IDVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_IDLINEA, ComisionCateConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_IDLINEAGRUPO, ComisionCateConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_IDLINEACATEGORIA, ComisionCateConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_IDESTADOCOMISION, ComisionCateConstantesFunciones.IDESTADOCOMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_PORCENTAJE, ComisionCateConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComisionCateConstantesFunciones.LABEL_DESCRIPCION, ComisionCateConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComisionCate() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.IDCOMISIONCONFIG;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.IDVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.IDESTADOCOMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComisionCateConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionCate() throws Exception  {
		return ComisionCateConstantesFunciones.getTiposSeleccionarComisionCate(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionCate(Boolean conFk) throws Exception  {
		return ComisionCateConstantesFunciones.getTiposSeleccionarComisionCate(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComisionCate(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_IDCOMISIONCONFIG);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_IDCOMISIONCONFIG);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_IDESTADOCOMISION);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_IDESTADOCOMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComisionCateConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(ComisionCateConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComisionCate(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComisionCate(ComisionCate comisioncateAux) throws Exception {
		
			comisioncateAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisioncateAux.getEmpresa()));
			comisioncateAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisioncateAux.getComisionConfig()));
			comisioncateAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisioncateAux.getVendedor()));
			comisioncateAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisioncateAux.getLinea()));
			comisioncateAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisioncateAux.getLineaGrupo()));
			comisioncateAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisioncateAux.getLineaCategoria()));
			comisioncateAux.setestadocomision_descripcion(EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(comisioncateAux.getEstadoComision()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComisionCate(List<ComisionCate> comisioncatesTemp) throws Exception {
		for(ComisionCate comisioncateAux:comisioncatesTemp) {
			
			comisioncateAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comisioncateAux.getEmpresa()));
			comisioncateAux.setcomisionconfig_descripcion(ComisionConfigConstantesFunciones.getComisionConfigDescripcion(comisioncateAux.getComisionConfig()));
			comisioncateAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comisioncateAux.getVendedor()));
			comisioncateAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisioncateAux.getLinea()));
			comisioncateAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisioncateAux.getLineaGrupo()));
			comisioncateAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(comisioncateAux.getLineaCategoria()));
			comisioncateAux.setestadocomision_descripcion(EstadoComisionConstantesFunciones.getEstadoComisionDescripcion(comisioncateAux.getEstadoComision()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComisionCate(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(ComisionConfig.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComisionCate(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionCate(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionCateConstantesFunciones.getClassesRelationshipsOfComisionCate(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComisionCate(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionCate(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComisionCateConstantesFunciones.getClassesRelationshipsFromStringsOfComisionCate(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComisionCate(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComisionCate comisioncate,List<ComisionCate> comisioncates,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ComisionCate comisioncateEncontrado=null;
			
			for(ComisionCate comisioncateLocal:comisioncates) {
				if(comisioncateLocal.getId().equals(comisioncate.getId())) {
					comisioncateEncontrado=comisioncateLocal;
					
					comisioncateLocal.setIsChanged(comisioncate.getIsChanged());
					comisioncateLocal.setIsNew(comisioncate.getIsNew());
					comisioncateLocal.setIsDeleted(comisioncate.getIsDeleted());
					
					comisioncateLocal.setGeneralEntityOriginal(comisioncate.getGeneralEntityOriginal());
					
					comisioncateLocal.setId(comisioncate.getId());	
					comisioncateLocal.setVersionRow(comisioncate.getVersionRow());	
					comisioncateLocal.setid_empresa(comisioncate.getid_empresa());	
					comisioncateLocal.setid_comision_config(comisioncate.getid_comision_config());	
					comisioncateLocal.setid_vendedor(comisioncate.getid_vendedor());	
					comisioncateLocal.setid_linea(comisioncate.getid_linea());	
					comisioncateLocal.setid_linea_grupo(comisioncate.getid_linea_grupo());	
					comisioncateLocal.setid_linea_categoria(comisioncate.getid_linea_categoria());	
					comisioncateLocal.setid_estado_comision(comisioncate.getid_estado_comision());	
					comisioncateLocal.setporcentaje(comisioncate.getporcentaje());	
					comisioncateLocal.setdescripcion(comisioncate.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!comisioncate.getIsDeleted()) {
				if(!existe) {
					comisioncates.add(comisioncate);
				}
			} else {
				if(comisioncateEncontrado!=null && permiteQuitar)  {
					comisioncates.remove(comisioncateEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ComisionCate comisioncate,List<ComisionCate> comisioncates) throws Exception {
		try	{			
			for(ComisionCate comisioncateLocal:comisioncates) {
				if(comisioncateLocal.getId().equals(comisioncate.getId())) {
					comisioncateLocal.setIsSelected(comisioncate.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComisionCate(List<ComisionCate> comisioncatesAux) throws Exception {
		//this.comisioncatesAux=comisioncatesAux;
		
		for(ComisionCate comisioncateAux:comisioncatesAux) {
			if(comisioncateAux.getIsChanged()) {
				comisioncateAux.setIsChanged(false);
			}		
			
			if(comisioncateAux.getIsNew()) {
				comisioncateAux.setIsNew(false);
			}	
			
			if(comisioncateAux.getIsDeleted()) {
				comisioncateAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComisionCate(ComisionCate comisioncateAux) throws Exception {
		//this.comisioncateAux=comisioncateAux;
		
			if(comisioncateAux.getIsChanged()) {
				comisioncateAux.setIsChanged(false);
			}		
			
			if(comisioncateAux.getIsNew()) {
				comisioncateAux.setIsNew(false);
			}	
			
			if(comisioncateAux.getIsDeleted()) {
				comisioncateAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComisionCate comisioncateAsignar,ComisionCate comisioncate) throws Exception {
		comisioncateAsignar.setId(comisioncate.getId());	
		comisioncateAsignar.setVersionRow(comisioncate.getVersionRow());	
		comisioncateAsignar.setid_empresa(comisioncate.getid_empresa());
		comisioncateAsignar.setempresa_descripcion(comisioncate.getempresa_descripcion());	
		comisioncateAsignar.setid_comision_config(comisioncate.getid_comision_config());
		comisioncateAsignar.setcomisionconfig_descripcion(comisioncate.getcomisionconfig_descripcion());	
		comisioncateAsignar.setid_vendedor(comisioncate.getid_vendedor());
		comisioncateAsignar.setvendedor_descripcion(comisioncate.getvendedor_descripcion());	
		comisioncateAsignar.setid_linea(comisioncate.getid_linea());
		comisioncateAsignar.setlinea_descripcion(comisioncate.getlinea_descripcion());	
		comisioncateAsignar.setid_linea_grupo(comisioncate.getid_linea_grupo());
		comisioncateAsignar.setlineagrupo_descripcion(comisioncate.getlineagrupo_descripcion());	
		comisioncateAsignar.setid_linea_categoria(comisioncate.getid_linea_categoria());
		comisioncateAsignar.setlineacategoria_descripcion(comisioncate.getlineacategoria_descripcion());	
		comisioncateAsignar.setid_estado_comision(comisioncate.getid_estado_comision());
		comisioncateAsignar.setestadocomision_descripcion(comisioncate.getestadocomision_descripcion());	
		comisioncateAsignar.setporcentaje(comisioncate.getporcentaje());	
		comisioncateAsignar.setdescripcion(comisioncate.getdescripcion());	
	}
	
	public static void inicializarComisionCate(ComisionCate comisioncate) throws Exception {
		try {
				comisioncate.setId(0L);	
					
				comisioncate.setid_empresa(-1L);	
				comisioncate.setid_comision_config(-1L);	
				comisioncate.setid_vendedor(-1L);	
				comisioncate.setid_linea(-1L);	
				comisioncate.setid_linea_grupo(-1L);	
				comisioncate.setid_linea_categoria(-1L);	
				comisioncate.setid_estado_comision(-1L);	
				comisioncate.setporcentaje(0.0);	
				comisioncate.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComisionCate(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_IDCOMISIONCONFIG);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_IDESTADOCOMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComisionCateConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComisionCate(String sTipo,Row row,Workbook workbook,ComisionCate comisioncate,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getcomisionconfig_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getestadocomision_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comisioncate.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComisionCate=Constantes.SFINALQUERY;
	
	public String getsFinalQueryComisionCate() {
		return this.sFinalQueryComisionCate;
	}
	
	public void setsFinalQueryComisionCate(String sFinalQueryComisionCate) {
		this.sFinalQueryComisionCate= sFinalQueryComisionCate;
	}
	
	public Border resaltarSeleccionarComisionCate=null;
	
	public Border setResaltarSeleccionarComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComisionCate= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComisionCate() {
		return this.resaltarSeleccionarComisionCate;
	}
	
	public void setResaltarSeleccionarComisionCate(Border borderResaltarSeleccionarComisionCate) {
		this.resaltarSeleccionarComisionCate= borderResaltarSeleccionarComisionCate;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComisionCate=null;
	public Boolean mostraridComisionCate=true;
	public Boolean activaridComisionCate=true;

	public Border resaltarid_empresaComisionCate=null;
	public Boolean mostrarid_empresaComisionCate=true;
	public Boolean activarid_empresaComisionCate=true;
	public Boolean cargarid_empresaComisionCate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComisionCate=false;//ConEventDepend=true

	public Border resaltarid_comision_configComisionCate=null;
	public Boolean mostrarid_comision_configComisionCate=true;
	public Boolean activarid_comision_configComisionCate=true;
	public Boolean cargarid_comision_configComisionCate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_comision_configComisionCate=false;//ConEventDepend=true

	public Border resaltarid_vendedorComisionCate=null;
	public Boolean mostrarid_vendedorComisionCate=true;
	public Boolean activarid_vendedorComisionCate=true;
	public Boolean cargarid_vendedorComisionCate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorComisionCate=false;//ConEventDepend=true

	public Border resaltarid_lineaComisionCate=null;
	public Boolean mostrarid_lineaComisionCate=true;
	public Boolean activarid_lineaComisionCate=true;
	public Boolean cargarid_lineaComisionCate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaComisionCate=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoComisionCate=null;
	public Boolean mostrarid_linea_grupoComisionCate=true;
	public Boolean activarid_linea_grupoComisionCate=true;
	public Boolean cargarid_linea_grupoComisionCate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoComisionCate=true;//ConEventDepend=true

	public Border resaltarid_linea_categoriaComisionCate=null;
	public Boolean mostrarid_linea_categoriaComisionCate=true;
	public Boolean activarid_linea_categoriaComisionCate=true;
	public Boolean cargarid_linea_categoriaComisionCate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaComisionCate=true;//ConEventDepend=true

	public Border resaltarid_estado_comisionComisionCate=null;
	public Boolean mostrarid_estado_comisionComisionCate=true;
	public Boolean activarid_estado_comisionComisionCate=true;
	public Boolean cargarid_estado_comisionComisionCate=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_comisionComisionCate=false;//ConEventDepend=true

	public Border resaltarporcentajeComisionCate=null;
	public Boolean mostrarporcentajeComisionCate=true;
	public Boolean activarporcentajeComisionCate=true;

	public Border resaltardescripcionComisionCate=null;
	public Boolean mostrardescripcionComisionCate=true;
	public Boolean activardescripcionComisionCate=true;

	
	

	public Border setResaltaridComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltaridComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComisionCate() {
		return this.resaltaridComisionCate;
	}

	public void setResaltaridComisionCate(Border borderResaltar) {
		this.resaltaridComisionCate= borderResaltar;
	}

	public Boolean getMostraridComisionCate() {
		return this.mostraridComisionCate;
	}

	public void setMostraridComisionCate(Boolean mostraridComisionCate) {
		this.mostraridComisionCate= mostraridComisionCate;
	}

	public Boolean getActivaridComisionCate() {
		return this.activaridComisionCate;
	}

	public void setActivaridComisionCate(Boolean activaridComisionCate) {
		this.activaridComisionCate= activaridComisionCate;
	}

	public Border setResaltarid_empresaComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarid_empresaComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComisionCate() {
		return this.resaltarid_empresaComisionCate;
	}

	public void setResaltarid_empresaComisionCate(Border borderResaltar) {
		this.resaltarid_empresaComisionCate= borderResaltar;
	}

	public Boolean getMostrarid_empresaComisionCate() {
		return this.mostrarid_empresaComisionCate;
	}

	public void setMostrarid_empresaComisionCate(Boolean mostrarid_empresaComisionCate) {
		this.mostrarid_empresaComisionCate= mostrarid_empresaComisionCate;
	}

	public Boolean getActivarid_empresaComisionCate() {
		return this.activarid_empresaComisionCate;
	}

	public void setActivarid_empresaComisionCate(Boolean activarid_empresaComisionCate) {
		this.activarid_empresaComisionCate= activarid_empresaComisionCate;
	}

	public Boolean getCargarid_empresaComisionCate() {
		return this.cargarid_empresaComisionCate;
	}

	public void setCargarid_empresaComisionCate(Boolean cargarid_empresaComisionCate) {
		this.cargarid_empresaComisionCate= cargarid_empresaComisionCate;
	}

	public Border setResaltarid_comision_configComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarid_comision_configComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_comision_configComisionCate() {
		return this.resaltarid_comision_configComisionCate;
	}

	public void setResaltarid_comision_configComisionCate(Border borderResaltar) {
		this.resaltarid_comision_configComisionCate= borderResaltar;
	}

	public Boolean getMostrarid_comision_configComisionCate() {
		return this.mostrarid_comision_configComisionCate;
	}

	public void setMostrarid_comision_configComisionCate(Boolean mostrarid_comision_configComisionCate) {
		this.mostrarid_comision_configComisionCate= mostrarid_comision_configComisionCate;
	}

	public Boolean getActivarid_comision_configComisionCate() {
		return this.activarid_comision_configComisionCate;
	}

	public void setActivarid_comision_configComisionCate(Boolean activarid_comision_configComisionCate) {
		this.activarid_comision_configComisionCate= activarid_comision_configComisionCate;
	}

	public Boolean getCargarid_comision_configComisionCate() {
		return this.cargarid_comision_configComisionCate;
	}

	public void setCargarid_comision_configComisionCate(Boolean cargarid_comision_configComisionCate) {
		this.cargarid_comision_configComisionCate= cargarid_comision_configComisionCate;
	}

	public Border setResaltarid_vendedorComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarid_vendedorComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorComisionCate() {
		return this.resaltarid_vendedorComisionCate;
	}

	public void setResaltarid_vendedorComisionCate(Border borderResaltar) {
		this.resaltarid_vendedorComisionCate= borderResaltar;
	}

	public Boolean getMostrarid_vendedorComisionCate() {
		return this.mostrarid_vendedorComisionCate;
	}

	public void setMostrarid_vendedorComisionCate(Boolean mostrarid_vendedorComisionCate) {
		this.mostrarid_vendedorComisionCate= mostrarid_vendedorComisionCate;
	}

	public Boolean getActivarid_vendedorComisionCate() {
		return this.activarid_vendedorComisionCate;
	}

	public void setActivarid_vendedorComisionCate(Boolean activarid_vendedorComisionCate) {
		this.activarid_vendedorComisionCate= activarid_vendedorComisionCate;
	}

	public Boolean getCargarid_vendedorComisionCate() {
		return this.cargarid_vendedorComisionCate;
	}

	public void setCargarid_vendedorComisionCate(Boolean cargarid_vendedorComisionCate) {
		this.cargarid_vendedorComisionCate= cargarid_vendedorComisionCate;
	}

	public Border setResaltarid_lineaComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarid_lineaComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaComisionCate() {
		return this.resaltarid_lineaComisionCate;
	}

	public void setResaltarid_lineaComisionCate(Border borderResaltar) {
		this.resaltarid_lineaComisionCate= borderResaltar;
	}

	public Boolean getMostrarid_lineaComisionCate() {
		return this.mostrarid_lineaComisionCate;
	}

	public void setMostrarid_lineaComisionCate(Boolean mostrarid_lineaComisionCate) {
		this.mostrarid_lineaComisionCate= mostrarid_lineaComisionCate;
	}

	public Boolean getActivarid_lineaComisionCate() {
		return this.activarid_lineaComisionCate;
	}

	public void setActivarid_lineaComisionCate(Boolean activarid_lineaComisionCate) {
		this.activarid_lineaComisionCate= activarid_lineaComisionCate;
	}

	public Boolean getCargarid_lineaComisionCate() {
		return this.cargarid_lineaComisionCate;
	}

	public void setCargarid_lineaComisionCate(Boolean cargarid_lineaComisionCate) {
		this.cargarid_lineaComisionCate= cargarid_lineaComisionCate;
	}

	public Border setResaltarid_linea_grupoComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoComisionCate() {
		return this.resaltarid_linea_grupoComisionCate;
	}

	public void setResaltarid_linea_grupoComisionCate(Border borderResaltar) {
		this.resaltarid_linea_grupoComisionCate= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoComisionCate() {
		return this.mostrarid_linea_grupoComisionCate;
	}

	public void setMostrarid_linea_grupoComisionCate(Boolean mostrarid_linea_grupoComisionCate) {
		this.mostrarid_linea_grupoComisionCate= mostrarid_linea_grupoComisionCate;
	}

	public Boolean getActivarid_linea_grupoComisionCate() {
		return this.activarid_linea_grupoComisionCate;
	}

	public void setActivarid_linea_grupoComisionCate(Boolean activarid_linea_grupoComisionCate) {
		this.activarid_linea_grupoComisionCate= activarid_linea_grupoComisionCate;
	}

	public Boolean getCargarid_linea_grupoComisionCate() {
		return this.cargarid_linea_grupoComisionCate;
	}

	public void setCargarid_linea_grupoComisionCate(Boolean cargarid_linea_grupoComisionCate) {
		this.cargarid_linea_grupoComisionCate= cargarid_linea_grupoComisionCate;
	}

	public Border setResaltarid_linea_categoriaComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaComisionCate() {
		return this.resaltarid_linea_categoriaComisionCate;
	}

	public void setResaltarid_linea_categoriaComisionCate(Border borderResaltar) {
		this.resaltarid_linea_categoriaComisionCate= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaComisionCate() {
		return this.mostrarid_linea_categoriaComisionCate;
	}

	public void setMostrarid_linea_categoriaComisionCate(Boolean mostrarid_linea_categoriaComisionCate) {
		this.mostrarid_linea_categoriaComisionCate= mostrarid_linea_categoriaComisionCate;
	}

	public Boolean getActivarid_linea_categoriaComisionCate() {
		return this.activarid_linea_categoriaComisionCate;
	}

	public void setActivarid_linea_categoriaComisionCate(Boolean activarid_linea_categoriaComisionCate) {
		this.activarid_linea_categoriaComisionCate= activarid_linea_categoriaComisionCate;
	}

	public Boolean getCargarid_linea_categoriaComisionCate() {
		return this.cargarid_linea_categoriaComisionCate;
	}

	public void setCargarid_linea_categoriaComisionCate(Boolean cargarid_linea_categoriaComisionCate) {
		this.cargarid_linea_categoriaComisionCate= cargarid_linea_categoriaComisionCate;
	}

	public Border setResaltarid_estado_comisionComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarid_estado_comisionComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_comisionComisionCate() {
		return this.resaltarid_estado_comisionComisionCate;
	}

	public void setResaltarid_estado_comisionComisionCate(Border borderResaltar) {
		this.resaltarid_estado_comisionComisionCate= borderResaltar;
	}

	public Boolean getMostrarid_estado_comisionComisionCate() {
		return this.mostrarid_estado_comisionComisionCate;
	}

	public void setMostrarid_estado_comisionComisionCate(Boolean mostrarid_estado_comisionComisionCate) {
		this.mostrarid_estado_comisionComisionCate= mostrarid_estado_comisionComisionCate;
	}

	public Boolean getActivarid_estado_comisionComisionCate() {
		return this.activarid_estado_comisionComisionCate;
	}

	public void setActivarid_estado_comisionComisionCate(Boolean activarid_estado_comisionComisionCate) {
		this.activarid_estado_comisionComisionCate= activarid_estado_comisionComisionCate;
	}

	public Boolean getCargarid_estado_comisionComisionCate() {
		return this.cargarid_estado_comisionComisionCate;
	}

	public void setCargarid_estado_comisionComisionCate(Boolean cargarid_estado_comisionComisionCate) {
		this.cargarid_estado_comisionComisionCate= cargarid_estado_comisionComisionCate;
	}

	public Border setResaltarporcentajeComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltarporcentajeComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeComisionCate() {
		return this.resaltarporcentajeComisionCate;
	}

	public void setResaltarporcentajeComisionCate(Border borderResaltar) {
		this.resaltarporcentajeComisionCate= borderResaltar;
	}

	public Boolean getMostrarporcentajeComisionCate() {
		return this.mostrarporcentajeComisionCate;
	}

	public void setMostrarporcentajeComisionCate(Boolean mostrarporcentajeComisionCate) {
		this.mostrarporcentajeComisionCate= mostrarporcentajeComisionCate;
	}

	public Boolean getActivarporcentajeComisionCate() {
		return this.activarporcentajeComisionCate;
	}

	public void setActivarporcentajeComisionCate(Boolean activarporcentajeComisionCate) {
		this.activarporcentajeComisionCate= activarporcentajeComisionCate;
	}

	public Border setResaltardescripcionComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comisioncateBeanSwingJInternalFrame.jTtoolBarComisionCate.setBorder(borderResaltar);
		
		this.resaltardescripcionComisionCate= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionComisionCate() {
		return this.resaltardescripcionComisionCate;
	}

	public void setResaltardescripcionComisionCate(Border borderResaltar) {
		this.resaltardescripcionComisionCate= borderResaltar;
	}

	public Boolean getMostrardescripcionComisionCate() {
		return this.mostrardescripcionComisionCate;
	}

	public void setMostrardescripcionComisionCate(Boolean mostrardescripcionComisionCate) {
		this.mostrardescripcionComisionCate= mostrardescripcionComisionCate;
	}

	public Boolean getActivardescripcionComisionCate() {
		return this.activardescripcionComisionCate;
	}

	public void setActivardescripcionComisionCate(Boolean activardescripcionComisionCate) {
		this.activardescripcionComisionCate= activardescripcionComisionCate;
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
		
		
		this.setMostraridComisionCate(esInicial);
		this.setMostrarid_empresaComisionCate(esInicial);
		this.setMostrarid_comision_configComisionCate(esInicial);
		this.setMostrarid_vendedorComisionCate(esInicial);
		this.setMostrarid_lineaComisionCate(esInicial);
		this.setMostrarid_linea_grupoComisionCate(esInicial);
		this.setMostrarid_linea_categoriaComisionCate(esInicial);
		this.setMostrarid_estado_comisionComisionCate(esInicial);
		this.setMostrarporcentajeComisionCate(esInicial);
		this.setMostrardescripcionComisionCate(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionCateConstantesFunciones.ID)) {
				this.setMostraridComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setMostrarid_comision_configComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDESTADOCOMISION)) {
				this.setMostrarid_estado_comisionComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionComisionCate(esAsigna);
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
		
		
		this.setActivaridComisionCate(esInicial);
		this.setActivarid_empresaComisionCate(esInicial);
		this.setActivarid_comision_configComisionCate(esInicial);
		this.setActivarid_vendedorComisionCate(esInicial);
		this.setActivarid_lineaComisionCate(esInicial);
		this.setActivarid_linea_grupoComisionCate(esInicial);
		this.setActivarid_linea_categoriaComisionCate(esInicial);
		this.setActivarid_estado_comisionComisionCate(esInicial);
		this.setActivarporcentajeComisionCate(esInicial);
		this.setActivardescripcionComisionCate(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionCateConstantesFunciones.ID)) {
				this.setActivaridComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setActivarid_comision_configComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDESTADOCOMISION)) {
				this.setActivarid_estado_comisionComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionComisionCate(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComisionCate(esInicial);
		this.setResaltarid_empresaComisionCate(esInicial);
		this.setResaltarid_comision_configComisionCate(esInicial);
		this.setResaltarid_vendedorComisionCate(esInicial);
		this.setResaltarid_lineaComisionCate(esInicial);
		this.setResaltarid_linea_grupoComisionCate(esInicial);
		this.setResaltarid_linea_categoriaComisionCate(esInicial);
		this.setResaltarid_estado_comisionComisionCate(esInicial);
		this.setResaltarporcentajeComisionCate(esInicial);
		this.setResaltardescripcionComisionCate(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComisionCateConstantesFunciones.ID)) {
				this.setResaltaridComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDCOMISIONCONFIG)) {
				this.setResaltarid_comision_configComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.IDESTADOCOMISION)) {
				this.setResaltarid_estado_comisionComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeComisionCate(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComisionCateConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionComisionCate(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdComisionConfigComisionCate=true;

	public Boolean getMostrarFK_IdComisionConfigComisionCate() {
		return this.mostrarFK_IdComisionConfigComisionCate;
	}

	public void setMostrarFK_IdComisionConfigComisionCate(Boolean visibilidadResaltar) {
		this.mostrarFK_IdComisionConfigComisionCate= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaComisionCate=true;

	public Boolean getMostrarFK_IdEmpresaComisionCate() {
		return this.mostrarFK_IdEmpresaComisionCate;
	}

	public void setMostrarFK_IdEmpresaComisionCate(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaComisionCate= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdComisionConfigComisionCate=true;

	public Boolean getActivarFK_IdComisionConfigComisionCate() {
		return this.activarFK_IdComisionConfigComisionCate;
	}

	public void setActivarFK_IdComisionConfigComisionCate(Boolean habilitarResaltar) {
		this.activarFK_IdComisionConfigComisionCate= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaComisionCate=true;

	public Boolean getActivarFK_IdEmpresaComisionCate() {
		return this.activarFK_IdEmpresaComisionCate;
	}

	public void setActivarFK_IdEmpresaComisionCate(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaComisionCate= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdComisionConfigComisionCate=null;

	public Border getResaltarFK_IdComisionConfigComisionCate() {
		return this.resaltarFK_IdComisionConfigComisionCate;
	}

	public void setResaltarFK_IdComisionConfigComisionCate(Border borderResaltar) {
		this.resaltarFK_IdComisionConfigComisionCate= borderResaltar;
	}

	public void setResaltarFK_IdComisionConfigComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdComisionConfigComisionCate= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaComisionCate=null;

	public Border getResaltarFK_IdEmpresaComisionCate() {
		return this.resaltarFK_IdEmpresaComisionCate;
	}

	public void setResaltarFK_IdEmpresaComisionCate(Border borderResaltar) {
		this.resaltarFK_IdEmpresaComisionCate= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaComisionCate(ParametroGeneralUsuario parametroGeneralUsuario/*ComisionCateBeanSwingJInternalFrame comisioncateBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaComisionCate= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}